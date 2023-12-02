import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import ButtonArray from "./ButtonArray"; // Import the ButtonArray component

function Seat() {
    const [seats, setSeats] = useState([]);
    const { flightid } = useParams();
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

    console.log(flightid);
    const businessSeats = [];
    const ordinarySeats = [];
    const comfortSeats = [];

    // Organize seats into arrays
    seats.forEach(seat => {
        switch (seat.seatType) {
            case 'Business':
                businessSeats.push(seat);
                break;
            case 'Comfort':
                comfortSeats.push(seat);
                break;
            case 'Ordinary':
                ordinarySeats.push(seat);
                break;
            // Handle other seat types if needed
            default:
                break;
        }
    });
    console.log(businessSeats.length);
    console.log(ordinarySeats.length);
    console.log(comfortSeats.length);
    console.log(seats);

    const [businessRows, setBusinessRows] = useState(0);
    const [businessCols, setBusinessCols] = useState(0);
    const [comfortRows, setComfortRows] = useState(0);
    const [comfortCols, setComfortCols] = useState(0);
    const [ordinaryRows, setOrdinaryRows] = useState(0);
    const [ordinaryCols, setOrdinaryCols] = useState(0);
    const [offset, setOffset] = useState(0);

    useEffect(() => {
        const calculateSeatConfig = (seatLength) => {
            switch (seatLength) {
                case 9:
                    setBusinessRows(1);
                    setBusinessCols(3);
                    setComfortRows(1);
                    setComfortCols(3);
                    setOrdinaryRows(1);
                    setOrdinaryCols(3);
                    break;
                case 12:
                    setBusinessRows(2);
                    setBusinessCols(2);
                    setComfortRows(2);
                    setComfortCols(2);
                    setOrdinaryRows(2);
                    setOrdinaryCols(2);
                    break;
                default:
            }
        };

        calculateSeatConfig(seats.length);
    }, [seats.length]);


    const navigate = useNavigate();

    const [showBusinessArray, setShowBusinessArray] = useState(false);
    const [showComfortArray, setShowComfortArray] = useState(false);
    const [showOrdinaryArray, setShowOrdinaryArray] = useState(false);

    const [seatNumber, setSeatNumber] = useState("");
    const [selectedButton, setSelectedButton] = useState(null);

    const toggleArray = (arrayType) => {
        setSelectedButton(arrayType);

        switch (arrayType) {
            case "business":
                setShowBusinessArray(true);
                setShowComfortArray(false);
                setShowOrdinaryArray(false);
                break;
            case "comfort":
                setShowComfortArray(true);
                setShowBusinessArray(false);
                setShowOrdinaryArray(false);
                break;
            case "ordinary":
                setShowOrdinaryArray(true);
                setShowBusinessArray(false);
                setShowComfortArray(false);
                break;
            default:
                break;
        }
    };

    const logButtonClick = (label, row, col) => {
        const newSeatNumber = `${String.fromCharCode("A".charCodeAt(0) + col)}${row}`;
        setSeatNumber(newSeatNumber);
    };

    const clearSeatNumber = () => {
        // Remove "clicked" class from all buttons
        const buttons = document.querySelectorAll(".seat-button");
        buttons.forEach((button) => button.classList.remove("clicked"));
        setSeatNumber("");
    };

    return (
        <>
            <div id="title">
                <h1>Seat Selection</h1>
            </div>
            <div class="container">
                <div class="left-menu">
                    <div id="head">
                        <h2>Seat Type</h2>
                    </div>
                    <button
                        className={`nav-menu-items ${selectedButton === "business" ? "selected" : ""}`}
                        onClick={() => toggleArray("business")}>
                        <h2>Business</h2>
                    </button>
                    <button
                        className={`nav-menu-items ${selectedButton === "comfort" ? "selected" : ""}`}
                        onClick={() => toggleArray("comfort")}>
                        <h2>Comfort</h2>
                    </button>
                    <button
                        className={`nav-menu-items ${selectedButton === "ordinary" ? "selected" : ""}`}
                        onClick={() => toggleArray("ordinary")}>
                        <h2>Ordinary</h2>
                    </button>
                    <br>
                    </br>
                    <br></br>
                    <div id="head">
                        <h2>Seat: {seatNumber}</h2>
                        <button onClick={clearSeatNumber} class="remove">
                            <b>Remove</b>
                        </button>
                    </div>
                    <button class="continue"
                            onClick={() => {
                                if (seatNumber) {
                                    navigate("/guest/insurance");
                                } else {
                                    alert("Please select a seat before continuing.");
                                }
                            }}>
                        <h2>Continue</h2>
                    </button>
                </div>
                <div class="right-content">
                    {showBusinessArray && (
                        <ButtonArray
                            onButtonClick={(row, col) => logButtonClick('', row, col)}
                            rows={businessRows}
                            cols={businessCols}
                            offset={0}
                            airplane={flightid}
                        />
                    )}

                    {showComfortArray && (
                        <ButtonArray
                            onButtonClick={(row, col) => logButtonClick('', row, col)}
                            rows={comfortRows}
                            cols={comfortCols}
                            offset={2}
                            airplane={flightid}
                        />
                    )}

                    {showOrdinaryArray && (
                        <ButtonArray
                            onButtonClick={(row, col) => logButtonClick('', row, col)}
                            rows={ordinaryRows}
                            cols={ordinaryCols}
                            offset={4}
                            airplane={flightid}
                        />
                    )}
                </div>
            </div>
        </>
    );
}

export default Seat;