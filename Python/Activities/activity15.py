def message():
    try:
        message = "Hi Ravi"
        return kumar
    except NameError:
        return "NameError occurred. Some variable isn't defined."

print(message())