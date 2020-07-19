<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
        <div class="container">
            Hi <b>${name}</b>, Add a new todo <br>

           <form:form method="POST" modelAttribute="todo">
                <form:hidden path="id" />
                <fieldset>
                    <form:label path="username">User</form:label>
                    ${name}
                </fieldset>
                <fieldset class="form-group">
                    <form:label path="title">Title</form:label>
                    <form:input path="title" type="text" name="title" class="form-control" required="required"/>
                    <form:errors path="title" cssClass="text-warning"/>
                </fieldset>
                <fieldset class="form-group">
                    <form:label path="description">Description</form:label>
                    <form:input path="description" type="text" name="description" class="form-control"/>
                    <form:errors path="targetDate" cssClass="text-warning"/>
                </fieldset>
                <fieldset class="form-group">
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input path="targetDate" type="text" name="targetDate" class="form-control" required="optional"/>
                    <form:errors path="targetDate" cssClass="text-warning"/>
                </fieldset>
                <button type="submit" class="btn btn-success">Add Todo</button>
            </form:form>
        </div>
<%@ include file="common/footer.jspf" %>