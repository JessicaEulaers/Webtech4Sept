from django.shortcuts import render


# Create your views here.
def examen(request):

    data.objects.order_by('infractions_speed')


    return render (request,'exam/list.html')


def data(request):
    url = 'http:localhost:/8000/infractions/20'
    return requests.get(url).json()