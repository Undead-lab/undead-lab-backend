from google.cloud import firestore
import base64

def push_to_firestore(request):
    request_json = request.get_json()
    if request_json and 'name' in request_json and 'html64' in request_json :
        db = firestore.Client()
        html = base64.b64decode(request_json['html64'])
        data = {
            u'content': html
        }

        db.collection(u'htmlContent').document(request_json['name']).set(data)
    else:
        raise ValueError("Bad request value")