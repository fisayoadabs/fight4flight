import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import ButtonArray from "./ButtonArray"; // Import the ButtonArray component

function Seat() {
    const navigate = useNavigate();
    const LOCAL_STORAGE_KEY = "notesApp.notes";

    const [notes, setNotes] = useState(() => {
        const stored = JSON.parse(localStorage.getItem(LOCAL_STORAGE_KEY));
        return stored || [];
    });

    const [seatData, setSeatData] = useState([]); // State for storing seat data from API

    const [showBusinessArray, setShowBusinessArray] = useState(false);
    const [showComfortArray, setShowComfortArray] = useState(false);
    const [showOrdinaryArray, setShowOrdinaryArray] = useState(false);
    const [showFirstArray, setShowFirstArray] = useState(true);
    const [seatNumber, setSeatNumber] = useState(""); // State to hold the seat number
    const [selectedSeat, setSelectedSeat] = useState("");

    const toggleArray = (arrayType) => {
        setShowBusinessArray(arrayType === "business");
        setShowComfortArray(arrayType === "comfort");
        setShowOrdinaryArray(arrayType === "ordinary");
        setShowFirstArray(arrayType === "first"); // Add this line
    };


    const logButtonClick = (seatName) => {
        setSeatNumber(seatName);
        setSelectedSeat(seatName);
    };


    const clearSeatNumber = () => {
        setSeatNumber("");
    };

    useEffect(() => {
        localStorage.setItem(LOCAL_STORAGE_KEY, JSON.stringify(notes));
    }, [notes]);

    useEffect(() => {
        // Fetch seat data from the API
        fetch("http://localhost:8080/seat/getAll") // Replace with your API URL
            .then(response => response.json())
            .then(data => setSeatData(data))
            .catch(error => console.error("Error fetching seat data:", error));
    }, []);

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
                    <button className="nav-menu-items" onClick={() => toggleArray("business")}>
                        <h2>Business</h2>
                    </button>
                    <button className="nav-menu-items" onClick={() => toggleArray("comfort")}>
                        <h2>Comfort</h2>
                    </button>
                    <button className="nav-menu-items" onClick={() => toggleArray("ordinary")}>
                        <h2>Ordinary</h2>
                    </button>
                    <br />
                    <div id="head">
                        <h2>Seat: {seatNumber}</h2>
                        <button onClick={clearSeatNumber} className="remove">
                            <b>Remove</b>
                        </button>
                    </div>
                    <button className="continue" onClick={() => navigate("/add")}>
                        <h2>Continue</h2>
                    </button>
                </div>
                <div className="right-content">
                    {showFirstArray && (
                        <ButtonArray
                            seatData={seatData.filter(seat => seat.seattype === "First")}
                            onButtonClick={logButtonClick}
                            selectedSeat={selectedSeat}
                        />
                    )}
                </div>
            </div>
        </>
    );
}

export default Seat;
