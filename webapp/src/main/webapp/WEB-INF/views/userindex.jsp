<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/userindex.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title>User Index</title>
</head>
<body class="text-center">
    <div class="panel">
        <img class="mb-4" src="https://d28htnjz2elwuj.cloudfront.net/wp-content/uploads/2013/11/Northeastern_University_Logo.jpg" alt="" width="72" height="72">
        <h1 class="h4 mb-3 font-weight-normal">Hello ${user}</h1>
        <h6 class="h6 mb-3 font-weight-normal">${currentTime}</h6>
        <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="window.location.href='/user/logout'">logout</button>
        <p class="mt-5 mb-3 text-muted">&copy;CSYE6225</p>
    </div>
</body>
</html>w