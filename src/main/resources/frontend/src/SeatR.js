import React, { useEffect, useState } from "react";
import { Outlet, useNavigate, useParams } from "react-router-dom";
import ButtonArray from "./ButtonArray";

function SeatR() {
    const navigate = useNavigate();
    const LOCAL_STORAGE_KEY = "notesApp.notes";
    const params = useParams();
    const [notes, setNotes] = useState(() => {
        const store = JSON.parse(localStorage.getItem(LOCAL_STORAGE_KEY));
        if (store === null) {
            return [];
        } else {
            return store;
        }
    });

    const [showBusinessArray, setShowBusinessArray] = useState(false);
    const [showComfortArray, setShowComfortArray] = useState(false);
    const [showOrdinaryArray, setShowOrdinaryArray] = useState(false);

    const [seatNumber, setSeatNumber] = useState(""); // State to hold the seat number
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

    useEffect(() => {
        localStorage.setItem(LOCAL_STORAGE_KEY, JSON.stringify(notes));
    }, [notes]);

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
                                navigate("/registered/insurance");
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
                            rows={5}
                            cols={6}
                            offset={0}
                        />
                    )}

                    {showComfortArray && (
                        <ButtonArray
                            onButtonClick={(row, col) => logButtonClick('', row, col)}
                            rows={6}
                            cols={6}
                            offset={5}
                        />
                    )}

                    {showOrdinaryArray && (
                        <ButtonArray
                            onButtonClick={(row, col) => logButtonClick('', row, col)}
                            rows={9}
                            cols={6}
                            offset={11}
                        />
                    )}

                    <Outlet context={[notes, setNotes]} />
                </div>
            </div>
        </>
    );
}

export default SeatR;