import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import './App.css'; // Import a CSS file for styling (create SeatSelection.css)

const Seat = () => {
    const navigate = useNavigate();
    const [seats, setSeats] = useState([]);
    const [filteredSeats, setFilteredSeats] = useState([]);
    const [seatid, setSelectedSeat] = useState(null);
    const [seatname, setSeatName] = useState(null);
    const [price, setPrice] = useState(null);
    const [selectedType, setSelectedType] = useState('All');
    const { flightid, email } = useParams();

    useEffect(() => {
        // Simulating API call or use your actual fetch code
        fetch(`http://localhost:8080/flight-management/seat/getByFlight/${flightid}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Failed to fetch seats. Status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                setSeats(data);
                setFilteredSeats(data);
            })
            .catch(error => {
                console.error(error);
                // Handle the error as needed
            });
    }, [flightid]);

    const calculateSeatsPerRow = (totalSeats) => {
        // Assuming you want 3 seats per row, you can modify this as needed
        const seatsPerRow = 3;
        const numberOfRows = Math.ceil(totalSeats / seatsPerRow);
        return Math.ceil(totalSeats / numberOfRows);
    };


    const handleSeatSelection = (seat) => {
        // Toggle seat selection
        if (seatid === seat.seatId) {
            setSelectedSeat(null);
            setPrice(null);
        } else if (seat.vacancy) {
            setSelectedSeat(seat.seatId);
            setPrice(seat.price);
            setSeatName(seat.seatName);
        }
    };

    const handleTypeChange = (event) => {
        const selectedType = event.target.value;
        setSelectedType(selectedType);
        if (selectedType === 'All') {
            setFilteredSeats(seats);
        } else {
            const filteredSeats = seats.filter(seat => seat.seatType === selectedType);
            setFilteredSeats(filteredSeats);
        }
    };

    return (
        <div className="seat-selection-container">
            <h2>Seat Selection</h2>
            <div className="filter-container">
                <label htmlFor="seatType">Filter by Seat Type:</label>
                <select
                    id="seatType"
                    name="seatType"
                    value={selectedType}
                    onChange={handleTypeChange}
                >
                    <option value="All">All</option>
                    <option value="Business">Business</option>
                    <option value="Comfort">Comfort</option>
                    <option value="Ordinary">Ordinary</option>
                </select>
            </div>
            <div className="seat-grid">
                {filteredSeats.map((seat, index) => (
                    <button
                        key={seat.seatId}
                        onClick={() => handleSeatSelection(seat)}
                        disabled={!seat.vacancy}
                        className={`seat-button ${seatid === seat.seatId ? 'selected' : ''}`}
                        style={{ marginRight: (index + 1) % calculateSeatsPerRow(seats.length) !== 0 ? '10px' : 0 }}
                    >
                        {seat.seatName}
                    </button>
                ))}
            </div>
            {seatid && (
                <div className="selected-seat-info">
                    <p>Selected Seat: {seatname}</p>
                    <p>Selected Seat Price: ${price}</p>
                    <button
                        onClick={() => navigate(`/pay/${flightid}/${email}/${seatid}/${price}`)}
                    >
                        Move to Next Page
                    </button>
                </div>
            )}
        </div>
    );
};

export default Seat;
