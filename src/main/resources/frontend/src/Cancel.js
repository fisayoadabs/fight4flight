import React, { useState } from 'react';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { useNavigate } from 'react-router-dom';

function Cancel() {
    const [flightId, setFlightId] = useState("");
    const [seatId, setSeatId] = useState("");
    const [email, setEmail] = useState("");
    const navigate = useNavigate();

    const cancelBooking = () => {
        const cancelEndpoint = "http://localhost:8080/user/seat/cancel";

        const requestBody = {
            flightId: parseInt(flightId),
            seatId: parseInt(seatId),
            userEmail: email,
        };

        fetch(cancelEndpoint, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(requestBody),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Cancel request failed. Status: ${response.status}`);
                }
                // Handle success, e.g., show a confirmation message
                console.log("Booking canceled successfully");
                navigate("/login");
            })
            .catch(error => {
                // Handle errors, e.g., show an error message to the user
                console.error("Cancel request error:", error);
            });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // Call the cancelBooking function when the form is submitted
        cancelBooking();
    };

    return (
        <form onSubmit={handleSubmit}>
            <TextField
                label="Flight ID"
                variant="outlined"
                margin="normal"
                required
                fullWidth
                value={flightId}
                onChange={(e) => setFlightId(e.target.value)}
            />
            <TextField
                label="Seat ID"
                variant="outlined"
                margin="normal"
                required
                fullWidth
                value={seatId}
                onChange={(e) => setSeatId(e.target.value)}
            />
            <TextField
                label="Email"
                variant="outlined"
                margin="normal"
                required
                fullWidth
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />
            <Button variant="contained" color="primary" type="submit">
                Cancel Booking
            </Button>
        </form>
    );
}

export default Cancel;
