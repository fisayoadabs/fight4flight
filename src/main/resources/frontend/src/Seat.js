import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import ButtonArray from "./ButtonArray"; // Make sure this component is implemented correctly

function Seat() {
    const [seats, setSeats] = useState([]);
    const { flightid } = useParams();
    const navigate = useNavigate();

    const [seatNumber, setSeatNumber] = useState("");
    const [selectedButton, setSelectedButton] = useState(null);

    // Fetch seat data on component mount
    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(`http://localhost:8080/flight-management/seat/getByAircraft/${flightid}`);
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                const data = await response.json();
                setSeats(data);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };
        fetchData();
    }, [flightid]);

    // Function to occupy a seat
    const occupySeat = async (seatId) => {
        try {
            const response = await fetch(`http://localhost:8080/flight-management/seat/occupy`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ seatId: seatId, userEmail: 'user@example.com' }) // Replace with actual user email
            });

            if (!response.ok) {
                throw new Error('Failed to occupy the seat');
            }

            console.log("Seat occupied successfully");
        } catch (error) {
            console.error('Error occupying seat:', error);
        }
    };

    // Function to deoccupy a seat
    const deoccupySeat = async (seatId) => {
        try {
            const response = await fetch(`http://localhost:8080/flight-management/seat/deoccupy`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ seatId: seatId })
            });

            if (!response.ok) {
                throw new Error('Failed to deoccupy the seat');
            }

            console.log("Seat deoccupied successfully");
        } catch (error) {
            console.error('Error deoccupying seat:', error);
        }
    };

    const logButtonClick = (seatId, row, col) => {
        const newSeatNumber = `${String.fromCharCode("A".charCodeAt(0) + col)}${row}`;
        setSeatNumber(newSeatNumber);
        occupySeat(seatId);
    };

    const clearSeatNumber = () => {
        const seatToClear = seats.find(seat => seat.seatNumber === seatNumber);
        if (seatToClear) {
            deoccupySeat(seatToClear.seatId);
        }
        setSeatNumber("");
    };

    return (
        <>
            <div id="title">
                <h1>Seat Selection</h1>
            </div>
            <div className="container">
                <div className="left-menu">
                    <div id="head">
                        <h2>Seat Type</h2>
                    </div>
                    <button
                        className={`nav-menu-items ${selectedButton === "business" ? "selected" : ""}`}
                        onClick={() => setSelectedButton("business")}>
                        <h2>Business</h2>
                    </button>
                    <button
                        className={`nav-menu-items ${selectedButton === "comfort" ? "selected" : ""}`}
                        onClick={() => setSelectedButton("comfort")}>
                        <h2>Comfort</h2>
                    </button>
                    <button
                        className={`nav-menu-items ${selectedButton === "ordinary" ? "selected" : ""}`}
                        onClick={() => setSelectedButton("ordinary")}>
                        <h2>Ordinary</h2>
                    </button>
                    <br></br>
                    <div id="head">
                        <h2>Seat: {seatNumber}</h2>
                        <button onClick={clearSeatNumber} className="remove">
                            <b>Remove</b>
                        </button>
                    </div>
                    <button className="continue"
                        onClick={() => {
                            if (seatNumber) {
                                navigate("/pay");
                            } else {
                                alert("Please select a seat before continuing.");
                            }
                        }}>
                        <h2>Continue</h2>
                    </button>
                </div>
                <div className="right-content">
                    {/* ButtonArray components for different seat types */}
                    {/* You will need to pass the appropriate props based on the seat type */}
                </div>
            </div>
        </>
    );
}

export default Seat;
