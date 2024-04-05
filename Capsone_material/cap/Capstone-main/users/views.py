from django.shortcuts import render, redirect
from django.contrib.auth.forms import UserCreationForm
from django.contrib import messages
from django.contrib.auth import logout


# Create your views here.
def register(request):
    form = UserCreationForm()

    if request.POST:
        form = UserCreationForm(request.POST)
        if form.is_valid():
            form.save()
            username = form.cleaned_data.get("username")
            messages.success(request, f"Successfully created user for {username}!")
            return redirect("login")

    return render(request, "users/register.html", {"form": form})


def log_out(request):
    logout(request)
    return render(request, "users/logout.html")
