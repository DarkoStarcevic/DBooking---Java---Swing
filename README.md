# DBooking - Java - Swing

 Desktop application that simulates booking.com
 
 
This is my first Java project and i tried to simulate booking.com website.
Application is intended for users who want to easily view, select and reserve a potential place for their vacation or business trip, as well as for those users who want to offer their accommodation.

DBooking is built with core Java and MySQL and contains three level projects (Client - Common - Server).

Also, the application consists of three levels of access:

• Super Admin - has access to financial reports (in this application it is the Super admin form that shows the profit of "DBooking", ie the administrator of the application who earns a percentage of earnings from reservations and has direct access to the database).

• Admin - the owner of the facility (hotel, hostel, apartment, camp, resort, etc.), who enters his facility, rooms, photos and sets prices in the application, check reservations, reviews, earnings...

• User - can make a reservation, check the booked accommodation, change personal data and leave a review after leaving the facility.

The user part of the application contains of the main - Main form, which allows the Admin and the User, to register and log in to the application, if they have already registered.
The so-called "Admin form" is a part of the application through which the owner of the facility enters all the necessary data about his facility, while the so-called "User form" is a part of the application intended for the User to select an object and reserve accommodation in it.

In order to activate application on your computer follow these steps: 

1) Import booking.sql to your MySQL database management system

2) Open project in your editor   

3) In Client and Server projects - right click on project - properties -Java Buid Path - Libraries (edit jars with bad path with jars from lib folder OR remove jars with bad path,then click Add External JARs and add correct jar file from lib folder)

4) In Common - Constants - change Port and IPAdress if needed

5) In Server - Server - baseName.properties enter email and email pass in order to pass recovery can work

6) In Server - Connection - change FileInputStream path ("/Users/darko/eclipse-workspace/BookingSerever/baseName.properties");

7) To login you can register (like user or owner) or you can check for username and password in booking.sql database 'user'. In column 'status' you can se superAdmin and who is OWNER or USER 

