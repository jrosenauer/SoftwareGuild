$(document).ready(function () {

    loadProducts();

    // Add Button onclick handler
    $('#dollar-button').click(function () {
        moneyInserted += 1.00;
        updatedMoney();
    });
    
    $('#quarter-button').click(function () {
        moneyInserted += 0.25;
        updatedMoney();
    });
    
    $('#dime-button').click(function () {
        moneyInserted += 0.10;
        updatedMoney();
    });
    
    $('#nickel-button').click(function () {
        moneyInserted += 0.05;
        updatedMoney();
    });
    $('#purchase-button').click(function () {
        makePurchase();
    });
    
    $('#change-button').click(function () {
        moneyInserted = 0;
        updatedMoney();
        loadProducts();
        emptyMessageBox();
        emptyMoneyBox();
        emptyItemBox();
        emptyChangeBox();
    });

});

var moneyInserted = 0;
//Total $ In Section
function updatedMoney() {
    $('#money-input').val(moneyInserted.toFixed(2));
}

function emptyMoneyBox() {
    $('#money-output').val('');
}

//Messages Section
function updatedMessageBox(message) {
    $('#message-output').val(message);
}

function emptyMessageBox() {
    $('#message-output').val('');
}

function emptyItemBox() {
    $('#item-output').val('');
}

//Change Section
function updatedChangeBox(message) {
    $('#change-return').val(message);
}

function emptyChangeBox() {
    $('#change-return').val('');
}


function loadProducts() {

    var productRows = $('#productRows');
    productRows.empty();
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/items',
        success: function (data) {
            $.each(data, function (index, item) {
                console.log(index)
                var id = item.id;
                var name = item.name;
                var price = item.price;
                var quantity = item.quantity;
                var row = '<div class = "col-sm-6 col-md-4">';
                row += '<button type = "button" class = "btn btn-default productBox-btn" id = "item' + id + '">';
                row += '<p class = "item-id">' + item.id + '</p>';
                row += '<p class = "item-name">' + item.name + '</p>';
                row += '<p class = "item-price"> $' + item.price.toFixed(2) + '</p>';
                row += '<p class = "item-quantity"> <span>Quantity Left: </span> <span id = item-' + item.id + '-quantity">' + quantity + '</span> </p>';
                row += '</button>';
                row += '</div>';
                productRows.append(row);
                
                $('#item' + id).click(function (){
                    emptyMessageBox();
                    emptyItemBox();
                    $('#item-output').val(item.id);
                });
            });
        },
        error: function() {
            $('#errorMessages').text('Error calling web service.  Please try again later.');
        }
    });
};

function makePurchase() {
    var itemBoxValue = $('#item-output').val();
    
    if ($('#item-output').val() != ' ') {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/money/' + moneyInserted + '/item/' + itemBoxValue,
            
            success: function (data, status) {
                console.log(' ',data, ' ', status)
                if (status == 422) {
                    updatedMessageBox(data.message);
                } else {
                    updatedMessageBox('Thank You!');
                    var coins = '';
                    coins += "Quarters: " + data.quarters + ' | ';
                    coins += "Dimes: " + data.dimes + ' | ';
                    coins += "Nickels: " + data.nickels + ' | ';
                    coins += "Pennies: " + data.pennies;
                    updatedChangeBox(coins);
                }
            },
            error: function(err) {
                console.log(' ', err, ' ')
                updatedMessageBox(err.responseJSON.message);
            //$('#errorMessages').text('Error calling web service.  Please try again later.');
            }
        });
    }
}
