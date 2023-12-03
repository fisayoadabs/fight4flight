import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const AircraftList = () => {
  const [bookings, setBookings] = useState([]);
  const [users, setUsers] = useState(null);
  const [guestEmail, setGuestEmail] = useState(null);

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch('http://localhost:8080/flight-management/aircraft/getAll');
      const data = await response.json();
      setBookings(data);
    } catch (error) {
      console.error('Error fetching aircrafts:', error);
      // Handle errors appropriately
    }
  };

  //   const handleTestButtonClick = () => {
  //     // Test data
  //     const testData = [{
  //       "aircraftId": 2,
  //       "aircraftName": "Wrap",
  //       "model": "itsa"
  //     },
  // { 
  //     "aircraftId": 4,
  //     "aircraftName": "Test3",
  //     "model": "boeing"
  // }];

  //     // Set the state with test data
  //     setBookings(testData);
  //   };

  useEffect(() => {
    // Fetch bookings based on user or guest email
    if (users) {
      // Fetch bookings for logged-in user (you need to implement the API endpoint)
      fetchBookingsForUser(users.username);
    } else if (guestEmail) {
      // Fetch bookings for guest using the provided email (you need to implement the API endpoint)
      fetchBookingsForGuest(guestEmail);
    }
  }, [users, guestEmail]);

  const fetchBookingsForUser = async (username) => {
    try {
      // Replace with the correct API URL for fetching user bookings
      const response = await fetch(`http://localhost:8080/bookings/user/${username}`);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      setBookings(data);
    } catch (error) {
      console.error('Error fetching user bookings:', error);
      // Handle errors appropriately
    }
  };

  const fetchBookingsForGuest = async (email) => {
    try {
      // Replace with the correct API URL for fetching guest bookings
      const response = await fetch(`http://localhost:8080/bookings/guest/${email}`);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      setBookings(data);
    } catch (error) {
      console.error('Error fetching guest bookings:', error);
      // Handle errors appropriately
    }
  };

  return (
    <div>
      <h1>All Aircrafts</h1>
      <button onClick={handleSubmit}>Load Aircrafts</button>
      {/* <button onClick={handleTestButtonClick}>Test with Sample Data</button> */}
      {bookings.length === 0 ? (
        <p>No aircrafts found.</p>
      ) : (
        <ul>
          {bookings.map((aircraft) => (
            <li key={aircraft.aircraftId}>
              <p>Aircraft ID: {aircraft.aircraftId}</p>
              <p>Aircraft Name: {aircraft.aircraftName}</p>
              <p>Model: {aircraft.model}</p>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default AircraftList;