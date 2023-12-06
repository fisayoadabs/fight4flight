import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from 'react-router-dom';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material'
import {type} from "@testing-library/user-event/dist/type";

function Pay() {
    const navigate = useNavigate();
    const [cardnumber, setCardNumber] = useState("");
    const [cardname, setCardName] = useState("");
    const [expiryyear, setExpiryYear] = useState("");
    const [expirymonth, setExpiryMonth] = useState("");
    const [ccv, setCcv] = useState("");
    const { flightid, email, seatid, price } = useParams();
    const [body, setBody] = useState("");


    const handleSubmit = async (e) => {
        e.preventDefault();
        setBody(`Thank you for booking a ticket.\nYour flight identification is ${parseInt(flightid)}.\nYour seat Id is ${parseInt(seatid)}.\nYour cost is $${parseInt(price)}. Please pay before your flight time.\nThank you for using Fight4Flight`);
        console.log(parseInt(flightid), parseInt(seatid), parseInt(price));
        const paymentRequestBody = {
            cardnumber: parseInt(cardnumber),
            cardname,
            expiryyear: parseInt(expiryyear),
            expirymonth: parseInt(expirymonth),
            ccv: parseInt(ccv),
            email,
            body: `Thank you for booking a ticket.\nYour flight identification is ${parseInt(flightid)}.\nYour seat Id is ${parseInt(seatid)}.\nYour cost is $${parseInt(price)}. Please pay before your flight time.\nThank you for using Fight4Flight`
        };

        const requestBody={
            flightId: parseInt(flightid),
            seatId: parseInt(seatid),
            userEmail: email
        }
        console.log(JSON.stringify(paymentRequestBody));
        // Make API call to validate payment
        const paymentValidationResponse = await fetch("http://localhost:8080/user/makeCard", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(paymentRequestBody),
        });

        if (!paymentValidationResponse.ok) {
            throw new Error(`Payment validation failed. Status: ${paymentValidationResponse.status}`);
        }

        // Make API call to occupy the seat
        const seatOccupationResponse = await fetch(`http://localhost:8080/flight-management/seat/occupy`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(requestBody),
        });

        if (!seatOccupationResponse.ok) {
            throw new Error(`Seat occupation failed. Status: ${seatOccupationResponse.status}`);
        }

        // Continue with your logic after successfully occupying the seat

        // Optional: Redirect to a confirmation page
        navigate(`/confirmation`);


    };


    return (
        <Container>
            <Paper elevation={3} style={{ padding: "20px" }}>
                <h1 style={{ color: "blue" }}>Pay Now</h1>
                <form>
                    <TextField
                        label="Card Number"
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        value={cardnumber}
                        onChange={(e) => setCardNumber(e.target.value)}
                    />
                    <TextField
                        label="Card Name"
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        value={cardname}
                        onChange={(e) => setCardName(e.target.value)}
                    />
                    <TextField
                        label="Expiry Year"
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        value={expiryyear}
                        onChange={(e) => setExpiryYear(e.target.value)}
                    />
                    <TextField
                        label="Expiry Month"
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        value={expirymonth}
                        onChange={(e) => setExpiryMonth(e.target.value)}
                    />
                    <TextField
                        label="CCV"
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        value={ccv}
                        onChange={(e) => setCcv(e.target.value)}
                    />
                    <Button variant="contained" color="secondary" onClick={handleSubmit}>
                        Submit
                    </Button>
                </form>
            </Paper>
        </Container>
    );
};

export default Pay;
