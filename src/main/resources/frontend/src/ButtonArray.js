// ButtonArray.js
import React, { useEffect, useState } from "react";

const ButtonArray = ({ onButtonClick, rows, cols, offset, airplane }) => {
    const [seats, setSeats] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(`http://localhost:8080/flight-management/seat/getByAircraft/${airplane}`);

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
    }, [airplane]);

    const handleButtonClick = (row, col) => {
        const selectedSeat = seats.find(
            seat => seat.seatName === `${String.fromCharCode("A".charCodeAt(0) + col)}${row + 1 + offset}`
        );

        // Check if the seat is vacant before handling the button click
        if (selectedSeat && selectedSeat.vacancy) {
            onButtonClick(selectedSeat.seatName);
        }
    };

    return (
        <div>
            {Array.from({ length: rows }).map((_, row) => (
                <div key={row}>
                    {Array.from({ length: cols }).map((_, col) => {
                        const buttonId = `${String.fromCharCode("A".charCodeAt(0) + col)}${row + 1 + offset}`;
                        const selectedSeat = seats.find(seat => seat.seatName === buttonId);

                        return (
                            <button
                                key={col}
                                onClick={() => handleButtonClick(row, col)}
                                className={`seat-button ${selectedSeat && !selectedSeat.vacancy ? "occupied" : ""}`}
                                disabled={selectedSeat && !selectedSeat.vacancy}
                            >
                                {String.fromCharCode("A".charCodeAt(0) + col)}{row + 1 + offset}
                            </button>
                        );
                    })}
                </div>
            ))}
        </div>
    );
};

export default ButtonArray;
