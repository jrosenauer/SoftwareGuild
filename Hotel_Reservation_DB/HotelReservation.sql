DROP DATABASE HotelReservation;

CREATE DATABASE HotelReservation;

use HotelReservation;

CREATE TABLE HotelReservation.PrimaryGuest (
PrimaryGuestID INT NOT NULL AUTO_INCREMENT,
Name VARCHAR(50) NOT NULL,
PhoneNumber CHAR(10) NOT NULL,
Email VARCHAR(30) NOT NULL,
ZipCode CHAR(5) NOT NULL,
CreditCardNumber VARCHAR(16) NOT NULL,
CVV VARCHAR(4) NOT NULL,
PRIMARY KEY (PrimaryGuestID));

CREATE TABLE HotelReservation.RoomRate (
RoomRateID INT NOT NULL AUTO_INCREMENT,
RoomTypeID INT NOT NULL,
Date DATETIME NOT NULL,
PRIMARY KEY (RoomRateID));

CREATE TABLE HotelReservation.AddOnInRoomType(
RoomTypeID VARCHAR(10) NOT NULL,
AddOnID VARCHAR(15) NOT NULL,
PRIMARY KEY(RoomTypeID, AddOnID));

CREATE TABLE HotelReservation.AddOnTotalCostForReservation (
AddOnID INT NOT NULL AUTO_INCREMENT,
Date DATETIME NOT NULL,
TotalCost DECIMAL(2) NOT NULL,
ReservationID INT NOT NULL,
PRIMARY KEY (AddOnID));

CREATE TABLE HotelReservation.AddOn (
AddOnID INT NOT NULL AUTO_INCREMENT,
AddOnName VARCHAR(20) NOT NULL,
AddOnPrice DECIMAL(2) NOT NULL,
PRIMARY KEY(AddOnID));

CREATE TABLE HotelReservation.Promotion (
EventID INT NOT NULL AUTO_INCREMENT,
EventType VARCHAR(40) NOT NULL,
Discount VARCHAR(40) NOT NULL,
Date DATETIME NOT NULL,
Primary KEY (EventID));

CREATE TABLE HotelReservation.RoomDetails (
RoomTypeID INT NOT NULL AUTO_INCREMENT,
RoomType VARCHAR(40) NOT NULL,
RoomRateID INT NOT NULL,
AmenityID INT NOT NULL,
RoomOccupancyLimit INT NOT NULL,
PRIMARY KEY (RoomTypeID));

CREATE TABLE HotelReservation.Amenity (
AmenityID INT NOT NULL AUTO_INCREMENT,
AmenityType VARCHAR(40) NOT NULL,
RoomTypeID INT NOT NULL,
PRIMARY KEY (AmenityID));

CREATE TABLE HotelReservation.AddOnCost (
AddOnCostID INT NOT NULL AUTO_INCREMENT,
AddOnID INT NOT NULL,
Date DATETIME NOT NULL,
Cost DECIMAL(2) NOT NULL,
PRIMARY KEY(AddOnCostID));

CREATE TABLE HotelReservation.Room (
RoomNumber INT NOT NULL,
RoomTypeID INT NOT NULL,
PRIMARY KEY (RoomNumber));

CREATE TABLE HotelReservation.Reservation (
ReservationID INT NOT NULL AUTO_INCREMENT,
PrimaryGuestID INT NOT NULL,
RoomTypeID INT NOT NULL,
Date DATETIME NOT NULL,
Tax DECIMAL(2) NOT NULL,
PRIMARY KEY(ReservationID));

CREATE TABLE HotelReservation.OtherGuests (
PrimaryGuestID INT NOT NULL AUTO_INCREMENT,
ReservationID INT NOT NULL,
Name VARCHAR(30) NULL,
Age VARCHAR(3) NULL,
PRIMARY KEY (PrimaryGuestID));

CREATE TABLE HotelReservation.ReservationRoom (
RoomNumber INT,
ReservationID INT NOT NULL,
PRIMARY KEY(RoomNumber, ReservationID));

CREATE TABLE HotelReservation.Receipt (
ReceiptNumber INT NOT NULL AUTO_INCREMENT,
ReservationID INT NOT NULL,
EventID INT NULL,
PRIMARY KEY(ReceiptNumber));

CREATE TABLE HotelReservation.AddOnReceipt (
AddOnID INT NOT NULL,
ReservationID INT NOT NULL,
OrderDate DATETIME NOT NULL,
PRIMARY KEY(AddOnID, ReservationID, OrderDate));

ALTER TABLE RoomDetails
ADD constraint fk_RoomDetails_RoomRate
FOREIGN KEY (RoomRateID)
references HotelReservation.RoomRate (RoomRateID)
on delete no action on update no action,

ADD constraint fk_RoomDetails_Amenity
FOREIGN KEY (AmenityID)
references HotelReservation.Amenity (AmenityID)
on delete no action on update no action;

ALTER TABLE Amenity
ADD constraint fk_Amenity_RoomType
FOREIGN KEY (RoomTypeID)
references HotelReservation.RoomDetails (RoomTypeID)
on delete no action on update no action;

ALTER TABLE AddOnCost
ADD constraint fk_AddOnCost_AddOn
FOREIGN KEY (AddOnID)
references HotelReservation.AddOn(AddOnID)
on delete no action on update no action;

ALTER TABLE Room
ADD constraint fk_Room_RoomDetails
FOREIGN KEY (RoomTypeID)
references HotelReservation.RoomDetails(RoomTypeID)
on delete no action on update no action;

ALTER TABLE Reservation
ADD constraint fk_Reservation_PrimaryGuest
FOREIGN KEY (PrimaryGuestID)
references HotelReservation.PrimaryGuest(PrimaryGuestID)
on delete no action on update no action;

ALTER TABLE OtherGuests
ADD constraint fk_OtherGuests_ReservationID
FOREIGN KEY (ReservationID)
references HotelReservation.Reservation (ReservationID)
on delete no action on update no action;

ALTER TABLE Receipt
ADD constraint fk_Receipt_Reservation
FOREIGN KEY (ReservationID)
references HotelReservation.Reservation (ReservationID);

ALTER TABLE Receipt
ADD constraint fk_Receipt_Promotion
FOREIGN KEY (EventID)
references HotelReservation.Promotion (EventID);

ALTER TABLE AddOnReceipt
ADD constraint fk_AddOnReceipt_AddOn
FOREIGN KEY (AddOnID)
references HotelReservation.AddOn (AddOnID)
on delete no action on update no action;

ALTER TABLE AddOnReceipt
ADD constraint fk_AddOnReceipt_Reservation
FOREIGN KEY (ReservationID)
references HotelReservation.Reservation (ReservationID)
on delete no action on update no action;

ALTER TABLE ReservationRoom
ADD constraint fk_ReservationRoom_Room
FOREIGN KEY (RoomNumber)
references HotelReservation.Room (RoomNumber)
on delete no action on update no action;

ALTER TABLE ReservationRoom
ADD constraint fk_ReservationRoom_Reservation
FOREIGN KEY (ReservationID)
references HotelReservation.Reservation (ReservationID)
on delete no action on update no action;