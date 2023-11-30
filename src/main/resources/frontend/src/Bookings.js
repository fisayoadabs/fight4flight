import React, { useState, useEffect } from 'react';

const Bookings = ({ user, guestEmail }) => {
  const [bookings, setBookings] = useState([]);

  useEffect(() => {
    // Fetch bookings based on user or guest email
    if (user) {
      // Fetch bookings for logged-in user (you need to implement the API endpoint)
      fetchBookingsForUser(user.username);
    } else if (guestEmail) {
      // Fetch bookings for guest using the provided email (you need to implement the API endpoint)
      fetchBookingsForGuest(guestEmail);
    }
  }, [user, guestEmail]);

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
      <h1>My Bookings</h1>
      {bookings.length === 0 ? (
        <p>No bookings found.</p>
      ) : (
        <ul>
          {bookings.map((booking) => (
            <li key={booking.id}>
              {/* Display booking details based on your data structure */}
              <p>Flight: {booking.flightDetails}</p>
              <p>Date: {booking.date}</p>
              {/* Add more details as needed */}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default Bookings;