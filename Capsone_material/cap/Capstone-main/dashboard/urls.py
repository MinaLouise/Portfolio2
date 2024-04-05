from django.urls import path

from . views import IndexView, CalendarListView, TodoView

urlpatterns = [
    path(
        '',
        IndexView.as_view(),
        name='index',
    ),
    path(
        'calendar',
        CalendarListView.as_view(),
        name='calendar',
    ),
    path(
        'Notifications',
        TodoView.as_view(),
        name='alerts',
    ),
]