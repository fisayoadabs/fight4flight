import React, { useEffect, useState } from "react";
import { Outlet, useNavigate, useParams } from "react-router-dom";

function Summary() {
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
            <div class="packageContainer">
                <div id="headpackage">
                    <h2>Summary</h2>
                </div>
                <br></br>
                <li class="list">Ordinary Seat<div id="include">600.00 CAD</div></li>
                <li class="list">Golden Insurance<div id="include">129.99 CAD</div></li>
                <li class="list">Lounge<div id="include">120.99 CAD</div></li>
                <li class="list">+ GST<div id="include">40.00 CAD</div></li>
                <li class="list">Total<div id="include">99.99 CAD</div></li>
                <br></br>
                <button
                    className="selectbutton"
                    onClick={() => {
                        navigate("/pay");
                    }}>Pay</button>
                <br></br>
            </div>
            <Outlet context={[notes, setNotes]} />
        </>
    );
}

export default Summary;