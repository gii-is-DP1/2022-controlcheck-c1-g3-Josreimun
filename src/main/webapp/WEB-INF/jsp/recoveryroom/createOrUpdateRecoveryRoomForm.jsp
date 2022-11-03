<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="recoveryRooms">
    <jsp:body>
        <c:if test="messages != null">
            <div class="messages">
                <c:forEach items="${messages}" var="message">
                    <div class="message">
                        <c:out value="${message}"/>
                    </div>
                </c:forEach>
            </div>
        </c:if>
        <form:form modelAttribute="recoveryRoom"
                   class="form-horizontal">
            <petclinic:inputField label="Name" name="name"/>
            <petclinic:selectField name="roomType" label="Room type" names="${roomTypes}" size="5"/>
            <petclinic:inputField label="Size" name="size"/>
            <petclinic:inputField label="Secure" name="secure"/>
            <button class="btn btn-default" type="submit">Add Room</button>
        </form:form>
    </jsp:body>
</petclinic:layout>
