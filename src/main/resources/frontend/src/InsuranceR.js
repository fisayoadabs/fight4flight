import React, { useEffect, useState } from "react";
import { Outlet, useNavigate, useParams } from "react-router-dom";

function InsuranceR() {
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


    const [showGoldenPackage, setshowGoldenPackage] = useState(false);
    const [showSilverPackage, setshowSilverPackage] = useState(false);
    const [showLoungePackage, setshowLoungePackage] = useState(false);
    const [selectedButton, setSelectedButton] = useState(null);
    const [isAddButtonClicked, setIsAddButtonClicked] = useState(false);
    const [isSelectLoungeClicked, setIsSelectLoungeClicked] = useState(false);
    const [isSelectGoldClicked, setIsSelectGoldClicked] = useState(false);
    const [isSelectSilverClicked, setIsSelectSilverClicked] = useState(false);

    const [seatNumber, setSeatNumber] = useState(""); // State to hold the seat number

    const toggleOptions = (arrayType) => {
        setSelectedButton(arrayType);

        switch (arrayType) {
            case "golden":
                setshowGoldenPackage(true);
                setshowSilverPackage(false);
                setIsSelectSilverClicked(false);
                break;
            case "silver":
                setshowSilverPackage(true);
                setshowGoldenPackage(false);
                setIsSelectGoldClicked(false);
                break;
            case "none":
                setshowGoldenPackage(false);
                setshowSilverPackage(false);
                setIsSelectGoldClicked(false);
                setIsSelectSilverClicked(false);
                break;
            default:
                break;
        }
    };

    useEffect(() => {
        localStorage.setItem(LOCAL_STORAGE_KEY, JSON.stringify(notes));
    }, [notes]);

    return (
        <>
            <div id="title">
                <h1>Flight Add-On Selection</h1>
            </div>
            <div class="container">
                <div class="left-menu">
                    <div id="head">
                        <h2>Insurance Type</h2>
                    </div>
                    <button
                        className={`nav-menu-items ${selectedButton === "golden" ? "selected" : ""}`}
                        onClick={() => toggleOptions("golden")}>
                        <h2>Gold</h2>
                    </button>
                    <button
                        className={`nav-menu-items ${selectedButton === "silver" ? "selected" : ""}`}
                        onClick={() => toggleOptions("silver")}>
                        <h2>Silver</h2>
                    </button>
                    <button
                        className={`nav-menu-items ${selectedButton === "none" ? "selected" : ""}`}
                        onClick={() => toggleOptions("none")}>
                        <h2>None</h2>
                    </button>
                    <br>
                    </br>
                    <br></br>
                    <div id="head">
                        <h2>Airport Lounge</h2>
                        <button
                            className={`add ${isAddButtonClicked ? "clicked" : ""}`}
                            onClick={() => {
                                setshowLoungePackage(!showLoungePackage);
                                setIsAddButtonClicked(!isAddButtonClicked);
                            }}>
                            <b>Add</b>
                        </button>
                    </div>
                    <button class="continue" onClick={(() => { navigate("/summary") })}>
                        <h2>Checkout</h2>
                    </button>
                </div>
                <div class="right-content">
                    {showLoungePackage && (
                        <div class="packageContainer">
                            <div id="headpackage">
                                <h2>Airport Lounge Package</h2>
                            </div>
                            <br></br>
                            <li class="list-lounge">Airport Lounge<div id="include">included</div></li>
                            <li class="list"><div id="price">129.99 CAD</div></li>
                            <br></br>
                            <button
                                className={`selectbutton ${isSelectLoungeClicked ? "clicked" : ""}`}
                                onClick={() => {
                                    setIsSelectLoungeClicked(!isSelectLoungeClicked);
                                }}>Select</button>
                            <br></br>
                        </div>
                    )}

                    {showGoldenPackage && (
                        <div class="packageContainer">
                            <div id="headpackage">
                                <h2>Gold Package</h2>
                            </div>
                            <br></br>
                            <li class="list">Cancellation, Interruption or Delay<div id="include">included</div></li>
                            <li class="list">Emergency Medical<div id="include">included</div></li>
                            <li class="list">Baggage Loss & Delay<div id="include">included</div></li>
                            <li class="list">Flight/Travel Accident<div id="include">included</div></li>
                            <li class="list"><div id="price">149.99 CAD</div></li>
                            <br></br>
                            <button
                                className={`selectbutton ${isSelectGoldClicked ? "clicked" : ""}`}
                                onClick={() => {
                                    setIsSelectGoldClicked(!isSelectGoldClicked);
                                }}>Select</button>
                            <br></br>
                        </div>
                    )}

                    {showSilverPackage && (
                        <div class="packageContainer">
                            <div id="headpackage">
                                <h2>Silver Package</h2>
                            </div>
                            <br></br>
                            <li class="list">Cancellation, Interruption or Delay<div id="include">included</div></li>
                            <li class="list">Emergency Medical<div id="include">not included</div></li>
                            <li class="list">Baggage Loss & Delay<div id="include">not included</div></li>
                            <li class="list">Flight/Travel Accident<div id="include">not included</div></li>
                            <li class="list"><div id="price">99.99 CAD</div></li>
                            <br></br>
                            <button
                                className={`selectbutton ${isSelectSilverClicked ? "clicked" : ""}`}
                                onClick={() => {
                                    setIsSelectSilverClicked(!isSelectSilverClicked);
                                }}>Select</button>
                            <br></br>
                        </div>
                    )}
                    <Outlet context={[notes, setNotes]} />
                </div>
            </div>
        </>
    );
}

export default InsuranceR;