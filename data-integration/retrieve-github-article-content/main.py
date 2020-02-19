import requests

def retrieve_github_content(request):
    request_json = request.get_json()
    if request_json and 'articlePath' in request_json:
        resp = requests.get('https://api.github.com/repos/wootlab/wootlab-io-posts/contents/' + request_json['articlePath'])
        if resp and resp.status_code == 200:
            json = resp.json();
            return json['content']
        else:
            raise ValueError("Not found")
    else:
        raise ValueError("Bad request value")
