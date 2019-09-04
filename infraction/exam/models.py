from django.db import models

# Create your models here.

class infraction(models.Model):
    street = models.CharField(max_length = 100)
