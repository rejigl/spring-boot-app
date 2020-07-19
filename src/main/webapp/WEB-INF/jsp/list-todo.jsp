<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
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
<%@ include file="common/footer.jspf" %>