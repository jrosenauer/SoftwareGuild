/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
loadLocations();
        $('#create-location').click(function (event) {

event.preventDefault();
        $('#validationErrors').empty();
        $.ajax({
        type: 'POST',
                url: 'location',
                data: JSON.stringify({
                locatioName: $('add-location-name').val(),
                        locationDescription: $('add-location-description').val(),
                        locationAddress: $('add-location-address').val(),
                        locationLongitude: $('add-location-longitude').val(),
                        locationLatitude: $('add-location-latitude').val(),
                }),
                headers: {
                'Accept': 'application/json',
                        'Content-Type': 'application/json'
                },
                'dataType': 'json'
        }).success(function (data, status) {
$('add-location-name').val(''),
        $('add-location-description').val(''),
        $('add-location-address').val(''),
        $('add-location-longitude').val(''),
        $('add-location-latitude').val('')

        loadLocations();
        });
        $('#edit-location-button').click(function(event) {
event.preventDefault();
        $.ajax({
        type: 'PUT',
                url: 'location/' + $('#edit-location-id').val(),
                data: JSON.stringify({
                locationID: $('#edit-location-id').val(),
                        locationName: $('edit-location-name').val(),
                        locationDescription: $('edit-location-description').val(),
                        locationAddress: $('edit-location-address').val(),
                        locationLongitude: $('edit-location-longitude').val(),
                        locationLatitude: $('edit-location-latitude').val()
                }),
                headers: {
                'Accept': 'application/json',
                        'Content-Type': 'application/json'
                },
                'dataType': 'json'
        });
        });
});

function loadLocations() {
    $.ajax({
        url: "locations"
    }).success (function (data, status) {
        fileLocationTable(data, status);
    });
}

function clearLocationTable() {
    $('#location-rows').empty();
}

function deleteLocation(id) {
    var answer = confirm("Do you wish to delete?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'location/' + id
        }).success(function () {
            loadLocations();
        });
    }
}
