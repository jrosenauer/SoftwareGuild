<%-- 
    Document   : organizationEdit
    Created on : Jul 16, 2017, 4:47:41 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal-info">
    <div class="modal-content">
        <div class="modal-header"
             <button type="button" class="close">
                <span class="edit-only">Close</span>
            </button>
            <h4 class="modal-title" id="modalDetails">Organization Details</h4>
        </div>
        <div class="modal-body">
            <h3 id="organizationID"></h3>
            <table class="table-bordered">
                <tr>
                    <th>Name</th>
                    <td id="organization-name"></td>
                </tr>
                <tr>
                    <th>Description</th>
                    <td id="organization-description"></td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td id="organization-address"></td>
                </tr>
                <tr>
                    <th>Phone</th>
                    <td id="organization-phone"></td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td id="organization-email"></td>
                </tr>
            </table>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
    </div>
</div>

<div class="modal-fade" id="edit-organization">
    <div class="modal-info">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"></button>
                <h4 class="modal-title" id="organizationEdit">Edit Organization></h4>
            </div>
            <div class="modal-body">
                <h3 id="organization-id"></h3>
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="edit-organization-name" class="col-md-4">Name</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-organization-name" path="organizationName" placeholder="Enter Name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-organization-description" class="col-md-4">Description</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-organization-description" path="organizationAddress" placeholder="Enter Description"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-organization-address" class="col-md-4">Address</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-organization-address" path="organizationAddress" placeholder="Enter Address"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-organization-phone" class="col-md-4">Phone</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-organization-phone" path="organizationPhone" placeholder="Enter Phone"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-organization-email" class="col-md-4">Email</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-organization-email" path="organizationEmail" placeholder="Enter Email"/>
                            <hidden type="organizationID"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="button" id ="edit organization-button" class="btn btn-default" data-dismiss="modal">Edit Organization</button>
                            <button type="button" class="btn btn-default" data-dismiss="organization">Cancel</button>
                            <input type="hidden" id="edit-organization-id">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>