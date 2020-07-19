<html>
    <head>
        <title>First Web Application</title>
        <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
                            rel="stylesheet">
    </head>
    <body>
        <div  class="col-md-6 col-sm-12">
            <h2>Login </h2>
            <div class="login-form">
                <form method="post" class="form-group">
                    <fieldset>
                        <label>Name </label> <input type="text" class="form-control" name = "name" /><br>
                    </fieldset>
                    <fieldset>
                        <label>Password</label> <input type="password" class="form-control" name="password"/><br>
                    </fieldset>
                    <input type = "submit" value = "Login"/>
                    <font color="red">${message}</font>
                </form>
            </div>
       </div>

        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </body>
</html>