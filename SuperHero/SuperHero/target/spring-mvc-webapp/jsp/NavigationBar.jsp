<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="container">
        <div class="row col-md-12">
            <div class="col-md-7">
                <h1 class="Name" role="presentation"><a href="${pageContext.request.contextPath}/">The Hero Education Relationship Organization</a></h1>
                <hr/>
            </div>

            <div class="col-md-5">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Sighting</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Superhero</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Location</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Organization</a></li>
                </ul>
            </div>
        </div>
    </div>
</html>

