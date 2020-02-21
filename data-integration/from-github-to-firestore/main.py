import requests
import markdown2
from google.cloud import firestore
import base64

def from_github_to_firestore(event, context):
    path = base64.b64decode(event['data']).decode("utf-8")
    md64 = retrieve_github_content(path)
    if md64:
        html = convert_to_html(md64)
        return push_to_firestore(path,html)
    return False

def retrieve_github_content(path):
    resp = requests.get('https://api.github.com/repos/wootlab/wootlab-io-posts/contents/' + path)
    if resp and resp.status_code == 200:
        json = resp.json()
        return json['content']

def convert_to_html(md64):
    markdown =  base64.b64decode(md64)
    html = markdown2.markdown(markdown)
    return html

def push_to_firestore(name, html):
    db = firestore.Client()
    data = {
        u'content': html
    }
    db.collection(u'htmlContent').document(name).set(data)
    return True