import requests
import os

def integrate_modified_article(request):
    request_json = request.get_json()
    if request_json and 'articlePath' in request_json:
        article_path = request_json['articlePath']
        markdown64 = retrieve_github_article(article_path)
        html64 = convert_markdown(markdown64)
        push_to_firestore(article_path, html64)
    else:
        raise ValueError("Bad request value")


def retrieve_github_article(article_path):
    retrieve_github_function_uri = os.environ.get('RETRIEVE_GITHUB_ARTICLE_URI',
                                                  'Specified environment variable is not set.')
    request = {'articlePath': article_path}
    resp = requests.post(retrieve_github_function_uri,data = request)
    if resp and resp.text:
        return resp.text
    raise OSError("article not found")


def convert_markdown(markdown64):
    convert_markdown_function_uri = os.environ.get('CONVERT_MARKDOWN_ARTICLE_URI',
                                                   'Specified environment variable is not set.')
    request = {'markdown64': markdown64}
    resp = requests.post(convert_markdown_function_uri, data = request)
    if resp and resp.text:
        return resp.text
    raise OSError("article not found")


def push_to_firestore(name, html64):
    push_to_firestore_function_uri = os.environ.get('PUSH_TO_FIRESTORE_URI', 'Specified environment variable is not set.')
    request = {'name': name, 'html64': html64, }
    requests.post(push_to_firestore_function_uri, data = request)
