from django.conf.urls import url
from . import views

app_name = 'exam'

urlpatterns = [
    url(r'urlparts', views.examen, name='examen')
]
