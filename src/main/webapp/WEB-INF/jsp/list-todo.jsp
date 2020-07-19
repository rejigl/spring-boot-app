<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>First Web Application</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
    <body>
        <div class="container">
            <table class="table table-striped">
                <caption>ToDo List</caption>
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Due Date</th>
                        <th>Completed</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <ui:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.title}</td>
                            <td>${todo.description}</td>
                            <td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
                            <td>${todo.done}</td>
                            <td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Update</a></td>
                            <td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</a></td>
                        </tr>
                    </ui:forEach>
                </tbody>
            </table>
            <div>
                <a class = "button" href="/upsert-todo">Add a new Todo </a>
            </div>
        </div>

        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    </body>
</html>