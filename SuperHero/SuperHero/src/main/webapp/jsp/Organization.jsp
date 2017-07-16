<%-- 
    Document   : Organization
    Created on : Jul 16, 2017, 5:11:43 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Organization</title>
        <link src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js">
        <link src="${pageContext.request.contextPath}/js/bootstrap.min.js">
    </head>
    <body>
        <div class="container">
            <jsp:include page="NavigationBar.jsp"/>
            <hr/>

            <div class="row">
                <div class="col-md-6">
                    <h2>Organizations</h2>
                    <table id="organizationTable" class="table">
                        <tr>
                            <th width="30%">Name</th>
                            <th width="50%">Description</th>
                            <th width="10%"></th>
                            <th width="10%"></th>
                        </tr>
                        <tbody id="organization-rows"></tbody>
                    </table>
                </div>

                <!--new Organization form-->

                <h2>Add New Organization</h2>
                <form class="form-horizontal" role="form">

                    <div class="form-group">
                        <label for="add-organization-name" class="col-md-4 control-label">Name:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="organizationName" placeholder="Enter Organization"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-organization-description" class="col-md-4 control-label">Description</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="organizationDescription" id="add-organization-descriptuon" placeholder="Enter Description"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-organization-phone" class="col-md-4 control-label">Phone:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="organizationPhone" id="add-organization-phone" placeholder="Enter Phone"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-organization-email" class="col-md-4 control-label">Email:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="organizationEmail" id="add-organization-email" placeholder="Enter Email"/>
                        </div>
                    </div>      
                </form>
            </div>
        </div>
        <jsp:include page="organizationEdit.jsp"/>
        <script src="${pageContent.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContent.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContent.request.contextPath}/js/organizationList"></script>
    </body>
</html>
