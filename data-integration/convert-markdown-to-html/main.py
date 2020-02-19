import markdown2
import base64

def convert_to_markdown(request):
    request_json = request.get_json()
    if request_json and 'markdown64' in request_json:
        markdown =  base64.b64decode(request_json['markdown64'])
        html = markdown2.markdown(markdown)
        html_bytes = html.encode('ascii')
        html64_bytes = base64.b64encode(html_bytes)
        html64_message = html64_bytes.decode('ascii')
        return html64_message