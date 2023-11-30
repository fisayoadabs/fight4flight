package io.group02.fight4flight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    public static void main(String[] args) {
        // Example search code
        String searchCode = "";

        // Perform the search and measure the time
        long startTime = System.nanoTime();
        Tuple result = searchAirportDatabase(searchCode);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convert to milliseconds

        // Display the result
        if (result != null) {
            System.out.println("Airport with code " + searchCode + " found: " + result);
        } else {
            System.out.println("Airport with code " + searchCode + " not found.");
        }

        System.out.println("Search time: " + duration + " milliseconds");
    }
    // private static Tuple getflights(String FlightID){
    //     String url = "jdbc:mysql://localhost/fight4flight";
    //     String username = "dev";
    //     String password = "developer";


    //     try (Connection connection = DriverManager.getConnection(url,username,password)){
    //         String sqlQuery = "SELECT * FROM FLIGHTS WHERE FLIGHTS GET NUMBER  = {FlightID}  JOINED BY TICKETS WHICH HAVE THE FLIGHTID JOINED BY TICKETS.CUSTOMERID= REGISTERED.id AND TICKETS.CUSTOMERID = UNREGEISTERED.id";
    //     }

    // }

    private static Tuple getEmptySeatsFromFlight(String FlightID){
        String url = "jdbc:mysql://localhost/fight4flightdb";
        String username = "dev";
        String password = "developer";

        try (Connection connection = DriverManager.getConnection(url,username,password)){
            String sqlQuery = "SELECT * FROM FLIGHTS WHERE FLIGHTS GET NUMBER  = {FlightID}  JOINED BY TICKETS WHICH HAVE THE FLIGHTID JOINED BY TICKETS.CUSTOMERID= REGISTERED.id AND TICKETS.CUSTOMERID = UNREGEISTERED.id";
        }
    }
    // Function to search for a tuple by airport code in the database
    private static Tuple searchAirportDatabase(String searchCode) {
        String url = "jdbc:mysql://localhost/fight4flightdb";
        String username = "dev";
        String password = "developer";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM UNREGISTERED"; //WHERE portcode = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                //statement.setString(1, searchCode);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while(resultSet.next() == true) {
                        System.out.println(resultSet.getInt("id"));
                        System.out.println(resultSet.getString("fname"));
                        System.out.println(resultSet.getString("lname"));
                        System.out.println(resultSet.getString("email"));
                    }
                    if (resultSet.next()) {
                        String city = "davide";//resultSet.getString("citystate");
                        String country = "Tomas";//resultSet.getString("country");
                        return new Tuple(city, country, searchCode);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Tuple class to represent each airport entry
    private static class Tuple {
        private String city;
        private String country;
        private String code;

        public Tuple(String city, String country, String code) {
            this.city = city;
            this.country = country;
            this.code = code;
        }

        @Override
        public String toString() {
            return "(" + city + ", " + country + ", " + code + ")";
        }
    }
}