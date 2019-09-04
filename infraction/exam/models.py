from django.db import models

# Create your models here.

class infraction(models.Model):
    street = models.CharField(max_length = 100)
    speed_limit = models.CharField(max_length = 3)
    infractions_speed = models.CharField(max_length = 100)
    def __unicode__(self):
        return self.street


