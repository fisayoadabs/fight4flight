# Fight4Flight Web Application

## Overview
The **Fight4Flight Web Application** is a comprehensive platform designed to streamline the booking, management, and administration of flights for a single airline company. The system caters to multiple user roles such as tourists, airline agents, flight attendants, and system administrators, providing each with tailored functionalities and an intuitive user interface for a seamless experience.

---

## Key Features
- **User-Friendly Interface**: Designed for ease of use with graphical seat maps and interactive elements.
- **Multi-User Access**: Different user roles (tourists, airline agents, administrators) each have access to functionalities specific to their responsibilities.
- **Flight Booking**: Users can browse available flights, select destinations, choose seat types (regular, comfort, or business class), and opt for ticket cancellation insurance.
- **Secure Payment Processing**: Integration with a secure payment gateway for credit card transactions, ensuring confidentiality and integrity.
- **Email Notifications**: Users receive electronic tickets and payment receipts via email. Registered users benefit from monthly promotions and discounted companion tickets.
- **Flight Management**: Airline agents and administrators have tools to manage flights, crews, aircraft, and destinations, including adding/removing entities and modifying flight details.
- **Membership Benefits**: Registered users can apply for an airline credit card and enjoy perks such as monthly promotions, discounted lounge access, and an annual free companion ticket.
- **Dynamic Pricing**: The system dynamically calculates flight prices based on seat type and additional services.

---

## System Architecture
### Web Side
- **Responsibility**: Provides the user interface, ensuring an intuitive and visually appealing experience.
- **Technologies**: Built using **JavaScript** and **React**.
- **Functionality**: Displays seat maps and interactive features for booking.

### Client Side
- **Responsibility**: Acts as an intermediary between the user and system functionalities.
- **Technologies**: Implements design patterns like inheritance, realization, aggregation, and composition for modularity and scalability.
- **Functionality**: Facilitates flight browsing, destination selection, seat choice, and booking management.

### Database Side
- **Responsibility**: Manages the storage and retrieval of user and system data.
- **Technologies**: Uses **MySQL** to ensure data integrity, security, and efficient access.
- **Functionality**: Stores flight details, user profiles, transaction data, and system configurations.

---

## Architectural Principles
- **Modular and Scalable**: The system follows a modular structure, facilitating easy maintenance and future enhancements.
- **Design Patterns**: Strategic use of design patterns like inheritance, realization, aggregation, and composition ensures reusability and adaptability to future changes.

---

## Use Case Scenarios
### Receive Perks
A registered user automatically receives monthly promotions and a companion ticket annually via email.

### Flight Booking
Users can easily browse flights, select seats, and proceed with secure payments. They can opt for add-ons such as insurance packages and lounge access.

### Flight Cancellation
Guests or registered users can cancel flights, and the system will automatically process and email refunds, along with removing personal data from the system.

---

## Authors
- **Feranmi Falade** (Student ID: 30145480)
- **Oluwafisayo Adabs** (Student ID: 30141541)
- **Tomas Kmet** (Student ID: 30150088)
- **David Rodriguez Barrios** (Student ID: 30145288)

---

## Development Technologies
- **Frontend**: JavaScript/React for a responsive and dynamic user interface.
- **Backend**: MySQL for secure and efficient data management.

---
