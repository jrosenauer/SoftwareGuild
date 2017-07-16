<%-- 
    Document   : locationEdit
    Created on : Jul 14, 2017, 4:46:53 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal-info">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close">
                <span class="edit-only">Close</span>
            </button>
            <h4 class="modal-title" id="modalDetails">Location Details</h4>
        </div>
        <div class="modal-body">
            <h3 id="locationID"></h3>
            <table class="table-bordered">
                <tr>
                    <th>Name</th>
                    <td id="location-name"</td>
                </tr>
                <tr>
                    <th>Description</th>
                    <td id="location-description"</td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td id="location-address"</td>
                </tr>
                <tr>
                    <th>Longitude</th>
                    <td id="location-latitude"</td>
                </tr>
                <tr>
                    <th>Latitude</th>
                    <td id="location-latitude"</td>
                </tr>
            </table>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
    </div>
</div>

<div class="modal-fade" id="edit-location">
    <div class="modal-info">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"></button>
                <h4 class="modal-title" id="locationEdit">Edit Location></h4>
            </div>
            <div class="modal-body">
                <h3 id="location-id"></h3>
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="edit-location-name" class="col-md-4">Name</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-location-name" path="locationName" placeholder="Enter Name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-location-description" class="col-md-4">Description"></label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-location-description" path="locationDescription" placeholder="Enter Description"/>
                        </div>
                    </div>                          
                    <div class="form-group">
                        <label for="edit-location-address" class="col-md-4">Description"></label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-location-address" path="locationAddress" placeholder="Enter Address"/>
                        </div>
                    </div>                          
                    <div class="form-group">
                        <label for="edit-location-longitude" class="col-md-4">Longitude"></label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-location-longitude" path="locationLongitude" placeholder="Enter Longitude"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-location-latitude" class="col-md-4">Longitude"></label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-location-latitude" path="locationLatitude" placeholder="Enter Latitude"/>
                            <hidden path="locationID"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="button" id ="edit location-button" class="btn btn-default" data-dismiss="modal">Edit Location</button>
                            <button type="button" class="btn btn-default" data-dismiss="location">Cancel</button>
                            <input type="hidden" id="edit-location-id">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>