<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet">        
    </head>
    <body>

        <div class="container">
            <h1>Vending Machine</h1>
            <hr/>
            <div id="leftColumn" class="col-md-9">
                <ul class="list-group" id="errorMessages"></ul>

                <div class="row">
                    <!All of the items in a row for 3 rows in 3 squares to make 9>
                    <div id="leftSquares" class="col-md-9"> <!-- Squares-->
                        <c:forEach var="product" items="${productList}">
                            <div class="products col-sm-6 col-md-4">
                                <form action="addProduct" method="POST">
                                    <input type="hidden" id="hidden-product-field" name="product" value="${product.id}"/>
                                    <button name="item-selection" type="submit" class="btn btn-default product-btn">
                                        <p class="product-id"><c:out value="${product.id}"/></p>
                                        <p class="product-name"><c:out value="${product.name}"/></p>
                                        <p class="product-price"><c:out value="${product.price}"/></p>
                                        <p class="product-quantity">Quantity Left: <c:out value="${product.quantity}"/></p>
                                    </button>
                                </form>
                            </div>
                        </c:forEach>
                    </div>

                    <!--Right side of VM below>-->
                    <div id="rightColumn" class="col-md-3">

                        <div id="TotalMoneyIn"></div>
                        <div class="col-md-12">
                            <h3>Total $ In</h3>
                            <input type="text" class="form" id="money-input" name="money" value="${amount}"/>
                        </div>

                        <div class="add-money-div col-md-12">
                            <div class="col-sm-6">
                                <form action="addMoney" method="POST">
                                    <input type="submit" id="dollar-button" class="btn btn-default add-money" name="money" value="Add Dollar"/>
                                    <input type="hidden" id="hidden-dollar-field" name="hidden-value" value="1.00"/>                               
                                </form>
                            </div>

                            <div class="col-sm-6">
                                <form action="addMoney" method="POST">
                                    <input type="submit" id="quarter-button" class="btn btn-default add-money" name="money" value="Add Quarter"/>
                                    <input type="hidden" id="hidden-quarter-field" name="hidden-value" value="0.25"/>
                                </form>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="col-sm-6">
                                <form action="addMoney" method="POST">
                                    <input type="submit" id="dime-button" class="btn btn-default add-money" name="money" value="Add Dime"/>
                                    <input type="hidden" id="hidden-dime-field" name="hidden-value" value="0.10"/>
                                </form>
                            </div>
                            <div class="col-sm-6">
                                <form action="addMoney" method="POST">
                                    <input type="submit" id="nickel-button" class="btn btn-default add-money" name="money" value="Add Nickel"/>
                                    <input type="hidden" id="hidden-nickel-field" name="hidden-value" value="0.05"/>
                                </form>
                            </div>
                        </div>
                        <hr>
                        <div id="Message"></div>
                        <div class="col-md-12">
                            <h3>Messages</h3>
                            <div class="center">
                                <!--Message Box-->
                                <input type="text" class="form" id="money-message" name="message" value="${message}"/>
                            </div>
                            <!--Item Box-->
                            <div class="center">
                                Item: <input type="text" class="form" id="item-output" name="message" value="${productId}"/>
                            </div>                   
                            <!--Purchase Button-->
                            <div class="center">
                                <form action="makePurchase" method="POST">
                                    <input type="submit" id="purchase-button" value="Make Purchase" class="btn btn-default" name="purchase-button"/>
                                    <input type="hidden" id="hidden-purchase-button" name="hidden-value" value="purchasebutton"/>
                                </form>
                            </div>
                        </div>
                        <hr>

                        <div id="Change"></div>
                        <div class="col-md-12">                    
                            <h3>Change</h3>

                            <!--Displays change-->
                            <div class="center">
                                <input value="${coins}" type="text" class="form" id="change-return" name="message"/>
                            </div>

                            <!--Return Change Button-->
                            <div class="center">
                                <form action="returnChange" method="POST">
                                    <input type="submit" id="change-button" value="Return Change" class="btn btn-default" name="return-change"/>                   
                                    <input type="hidden" id="hidden-purchase-button" name="hidden-value" value="returnchange"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>