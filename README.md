# Hospital JDBC Project

This project demonstrates how to manage patient data using Java, JDBC, and MySQL. The application allows you to add, update, delete, and retrieve patient details from a MySQL database.

## Project Overview

The Hospital JDBC Project includes:
- A **Patient** management system where you can perform CRUD (Create, Read, Update, Delete) operations on patient data.
- A **MySQL Database** with tables for storing patient information.
- JDBC (Java Database Connectivity) to interact with the MySQL database.

## Technologies Used
- **Java** (JDK 8+)
- **MySQL** (Database)
- **JDBC** (Java Database Connectivity)
- **Eclipse** (IDE)

## Requirements
- **MySQL Server** installed and running
- **JDBC Driver** (MySQL Connector/J) for Java
- **Eclipse IDE** or any Java IDE for development

## Setting Up the Project

### 1. Download MySQL Connector/J
Download the MySQL JDBC driver from the official site:  
[MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)

### 2. Create the MySQL Database
Open MySQL Workbench or any MySQL client and execute the following SQL commands to create the database and table:

```sql
CREATE DATABASE hospital_db1;

USE hospital_db1;

CREATE TABLE Patients (
    patient_id INT PRIMARY KEY,
    name VARCHAR(100),
    gender VARCHAR(10),
    dob DATE,
    phone VARCHAR(15),
    address VARCHAR(255)
);
