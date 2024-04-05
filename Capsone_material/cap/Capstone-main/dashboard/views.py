from django.views.generic import TemplateView
# from django.views.generic.list import ListView

# Create your views here.

class IndexView(TemplateView):
    template_name = 'index.html'

class CalendarListView(TemplateView):
    template_name = 'calendar.html'

class TodoView(TemplateView):
    template_name = 'notifications.html'