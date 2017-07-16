<%-- 
    Document   : location
    Created on : Jul 14, 2017, 2:46:59 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Location</title>
        <link src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js">
        <link src="${pageContext.request.contextPath}/js/bootstrap.min.js">
    </head>
    <body>
        <div class="container">
            <jsp:include page="NavigationBar.jsp"/>
            <hr/>

            <div class="row">
                <div class="col-md-6">
                    <h2>Locations</h2>
                    <table id="locationTable" class="table">
                        <tr>
                            <th width="30%">Name</th>
                            <th width="50%">Description</th>
                            <th width="10%"></th>
                            <th width="10%"></th>
                        </tr>
                        <tbody id="location-rows"></tbody>
                    </table>
                </div>

                <!--new location form-->

                <h2>Add New Contact</h2>
                <form class="form-horizontal" role="form">


                    <div class="form-group">
                        <label for="add-lcation-name" class="col-md-4 control-label">Name:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationName" placeholder="Enter Name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-location-description" class="col-md-4 control-label">Description</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationDescription" id="add-location-description" placeholder="Enter Description"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-location-address" class="col-md-4 control-label">Address:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationAddress" id="add-location-address" placeholder="Enter Address"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-location-longitude" class="col-md-4 control-label">Longitude</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationLongitude" id="add-location-longitude" placeholder="Enter Longitude"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-location-latitude" class="col-md-4 control-label">Latitude</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationLatitude" id="add-location-latitude" placeholder="Enter Latitude"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" class="btn btn-default" id="create-location">Add Location</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <jsp:include page="locationEdit.jsp"/>
        <script src="${pageContent.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContent.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContent.request.contextPath}/js/locationList"></script>
    </body>
</html>