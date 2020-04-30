import requests
from google.cloud import firestore
import base64
import json
import os

def from_github_to_firestore(event, context):
    path = base64.b64decode(event['data']).decode("utf-8")
    json64 = retrieve_github_content(path)
    if json64:
        html = convert_to_json(json64)
        return push_to_firestore(path, html)
    return False


def retrieve_github_content(path):
    resp = requests.get(
        'https://api.github.com/repos/wootlab/wootlab-io-posts/contents/' + path + '?ref=' + os.environ.get(
            'GITHUB_POSTS_BRANCH', 'Not found'))
    if resp and resp.status_code == 200:
        json = resp.json()
        return json['content']

def convert_to_json(json64):
    decoded_content = base64.b64decode(json64)
    return json.loads(decoded_content.decode("utf-8"))


def push_to_firestore(name, meta):
    db = firestore.Client()
    path = name.replace("/", "-").replace("-meta.json", "")

    next = ""
    if 'next' in meta:
        next = meta['next']

    previous = ""
    if 'previous' in meta:
        previous = meta['previous']

    data = {
        u'title': meta['title'],
        u'description': meta['description'],
        u'url': meta['url'],
        u'images': meta['images'],
        u'tag': meta['tag'],
        u'date': meta['date'],
        u'author': meta['author'],
        u'published': meta['published'],
        u'path': path,
        u'next': next,
        u'previous': previous
    }
    db.collection(u'article').document(path).set(data)
    return True
