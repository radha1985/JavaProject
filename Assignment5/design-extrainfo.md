# **Design Document --  Radha Venkataraman**

###1.0 Introduction

  The objective is to create a Software Design document for Ezshop,an easy shopping app for a supermarket.

###2.0 Classes and Methods Used

* EZShop - Initializecart(), AddItemtoCart(),  RemoveItemfromCart(),      AddCouponstoCart(),    GeneratePayment()    
* QRCodeScanner - DecodeQRCode()
* Customer
* Product
* Coupons
* AlcoholicBeverages - calculateStateTax()
* Cart - calculateTotalPrice()
* Payment - EncodeQRCode()
* Cashier - ScanQRCode()
* External System - processingQRCode, processingPayment(), SendEmail() 


###3.0 General Flow of the UML Class Diagram

* Ezshop Application itself is considered as a class. It has the main() method and drives the application.

* The **decodeQRCode()** method in QRCodeScanner class, performs Method Overloading as the same method is called, to decode **CustomerQRCode**, **ProductQRCode** and **CouponQRCode**.	

* Customer class calls QRCodeScanner class,and **decodeQRCode()** method decodes FirstName, LastName,Email and Zipcode initializes an empty cart with empty lists of items and coupons. 

* Product and Coupons classes go through **decodeQRCode()** method, to decode their QRCodes. ITEMID, price and the appropriate discount amt gets added to cart. 

* Cart is made of one or more Products and Coupons of a Customer. There is an Aggregation relationship between Products and Coupons to cart.Association between Customer and Cart.

* Removing items from the cart also go through the same flow, in which **decodeQRCode()**, is called and the ProductQRCode is decoded, and the corresponding itemID and price is removed from the cart. 

* AlcoholicBeverages class is called by **calculateTotalPrice()**. **calculateStateTax()**method checks if the ITEMID is prefixed with "AB", then a special tax gets added to the cart.

* There is a dependency relationship between payment and cart class.**EncodeQRCode()** in Payment class encodes the information in the cart to a QRCode.

* Cashier scans the encoded QRCode from the Payment Class in an external system and the external system is responsible for **processingQRCode()**, **processingpayment()** and **sendingEmail()**.
 

