// ButtonArray.js
import React, { useEffect, useState } from "react";

const ButtonArray = ({ onButtonClick, rows, cols, offset, airplane }) => {
    const [seats, setSeats] = useState([]);
    console.log(airplane);
    console.log(rows);
    console.log(cols);

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
    console.log(seats);


    const [selectedButton, setSelectedButton] = useState(null);


    const handleButtonClick = (row, col) => {
        // Convert the column index to alphabet using String.fromCharCode
        //const colName = String.fromCharCode("A".charCodeAt(0) + col);
        const buttons = document.querySelectorAll(".seat-button");
        buttons.forEach(button => button.classList.remove("clicked"));

        const buttonId = `${String.fromCharCode("A".charCodeAt(0) + col)}${row + 1 + offset}`;
        const button = document.getElementById(buttonId);
        console.log(button);
        console.log(buttonId);
        if (button) {
            console.log("entered clicked");
            button.classList.add("clicked");
            setSelectedButton(buttonId);
        }

        onButtonClick(`${String.fromCharCode("A".charCodeAt(0) + col)}${row + 1 + offset}`);
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
                                className={`seat-button`}
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