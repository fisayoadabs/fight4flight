import React from 'react';

const ButtonArray = ({ seatData, onButtonClick, selectedSeat }) => {
    return (
        <div className="button-array">
            {seatData.map(seat => (
                <button
                    key={seat.seatid}
                    className={`seat-button ${selectedSeat === seat.seatname ? 'selected' : ''}`}
                    onClick={() => onButtonClick(seat.seatname)} // Pass the seatname when the button is clicked
                >
                    {seat.seatname}
                </button>
            ))}
        </div>
    );
};

export default ButtonArray;
