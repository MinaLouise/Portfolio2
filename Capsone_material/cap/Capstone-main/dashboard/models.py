from django.db import models

# Create your models here.

class AdminModel(models.Model):
    adminName = models.CharField(max_length = 200)
    aboutMe = models.CharField(max_length = 500)
    certifications = models.CharField(max_length = 1000)