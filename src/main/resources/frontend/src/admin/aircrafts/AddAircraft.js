import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faInfoCircle } from '@fortawesome/free-solid-svg-icons';

const AddAircraft = () => {
    const navigate = useNavigate();
    const [airports, setAirports] = useState([]); // State for storing airport data
    const [filteredDepartureAirports, setFilteredDepartureAirports] = useState([]); // Filtered list for departure
    const [filteredDestinationAirports, setFilteredDestinationAirports] = useState([]); // Filtered list for destination

    // State to manage form data
    const [formData, setFormData] = useState({
        departure: '',
        destination: '',
        departureTime: '',
        arrivalTime: '',
    });

    // State to manage visibility of flight summary
    const [showFlightSummary, setShowFlightSummary] = useState(false);

    const handleViewBookings = () => {
        // Implement logic to fetch and display user's bookings
        alert('View My Bookings functionality will be implemented here.');
    };

    useEffect(() => {
        // Fetch airport data from API and update state
        const fetchAirports = async () => {
            try {
                const response = await fetch('http://localhost:8080/airport/getAll');
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                const data = await response.json();
                setAirports(data);
            } catch (error) {
                console.error('Error fetching airport data:', error);
                // Handle errors appropriately
            }
        };

        fetchAirports();
    }, []);

    const filterAirports = (input, type) => {
        if (!input) return [];
        return airports.filter(airport =>
            airport.cityState.toLowerCase().startsWith(input.toLowerCase()) ||
            airport.country.toLowerCase().startsWith(input.toLowerCase()) ||
            airport.portCode.toLowerCase().startsWith(input.toLowerCase())
        );
    };

    const handleInputChange = (e) => {
        const { id, value } = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [id]: value,
        }));

        if (id === 'departure' || id === 'destination') {
            const filteredAirports = filterAirports(value, id);
            if (id === 'departure') {
                setFilteredDepartureAirports(filteredAirports);
            } else {
                setFilteredDestinationAirports(filteredAirports);
            }
        }
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        setShowFlightSummary(true);
    };

    return (
        <section>
            <h1>Add an Aircraft</h1>
            <button className="back" onClick={() => navigate("/admin/modifyaircrafts")}>Back</button>
            <button className="log" onClick={() => navigate("/login")}>Logout</button>
            <form onSubmit={handleSubmit}>
                <label htmlFor="departure">
                    Departure ID:
                    <input
                        type="text"
                        id="departure"
                        autoComplete="off"
                        placeholder="Enter departure airport"
                        required
                        value={formData.departure}
                        onChange={handleInputChange}
                    />
                </label>

                <label htmlFor="destination">
                    Destination ID:
                    <input
                        type="text"
                        id="destination"
                        autoComplete="off"
                        placeholder="Enter destination airport"
                        required
                        value={formData.destination}
                        onChange={handleInputChange}
                    />
                </label>

                <label htmlFor="aircraft">
                    Aircraft ID:
                    <input
                        type="text"
                        id="aircraft"
                        autoComplete="off"
                        placeholder="Enter aircraft ID"
                        required
                        value={formData.aircraft}
                        onChange={handleInputChange}
                    />
                </label>

                {/* Autocomplete suggestions for departure */}
                {filteredDepartureAirports.length > 0 && (
                    <div className="autocomplete-suggestions">
                        {filteredDepartureAirports.map(airport => (
                            <div
                                key={airport.portCode}
                                className="autocomplete-suggestion"
                                onClick={() => {
                                    setFormData({ ...formData, departure: `${airport.cityState} (${airport.country}) - ${airport.portCode}` });
                                    setFilteredDepartureAirports([]);
                                }}
                            >
                                <span style={{ float: 'left' }}>{airport.cityState} ({airport.country})</span>
                                <span style={{ float: 'right' }}>{airport.portCode}</span>
                                <div style={{ clear: 'both' }}></div>
                            </div>
                        ))}
                    </div>
                )}

                {/* Autocomplete suggestions for destination */}
                {filteredDestinationAirports.length > 0 && (
                    <div className="autocomplete-suggestions">
                        {filteredDestinationAirports.map(airport => (
                            <div
                                key={airport.portCode}
                                className="autocomplete-suggestion"
                                onClick={() => {
                                    setFormData({ ...formData, destination: `${airport.cityState} (${airport.country}) - ${airport.portCode}` });
                                    setFilteredDestinationAirports([]);
                                }}
                            >
                                <span style={{ float: 'left' }}>{airport.cityState} ({airport.country})</span>
                                <span style={{ float: 'right' }}>{airport.portCode}</span>
                                <div style={{ clear: 'both' }}></div>
                            </div>
                        ))}
                    </div>
                )}

                <label htmlFor="departureTime">
                    Departure Time:
                    <input
                        type="text"
                        id="departureTime"
                        autoComplete="off"
                        required
                        value={formData.departureDate}
                        onChange={handleInputChange}
                    />
                </label>
                <p id="departureTime" className={formData.departureTime ? "offscreen" : "instructions"}>
                    <FontAwesomeIcon icon={faInfoCircle} />
                    Put in the format "YYYY-MM-DD_T_HH:MM:SS" but ignore underscores<br />
                    Eg. 2023-12-01T22:21:20.<br />
                </p>

                <label htmlFor="arrivalTime">
                    Arrival Time:
                    <input
                        type="time"
                        id="arrivalTime"
                        autoComplete="off"
                        required
                        value={formData.returnDate}
                        onChange={handleInputChange}
                    />
                </label>
                <p id="arrivalTime" className={formData.arrivalTime ? "offscreen" : "instructions"}>
                    <FontAwesomeIcon icon={faInfoCircle} />
                    Time displayed is local time.<br />
                </p>
                

                <button>
                    <div className="icon-container">
                        +
                    </div>
                </button>
            </form>

            {showFlightSummary && (
                <div className="flight-summary">
                    <h2>Flight Summary</h2>
                    <p>Departure: {formData.departure}</p>
                    <p>Destination: {formData.destination}</p>
                    <p>Departure Date: {formData.departureDate}</p>
                    <p>Return Date: {formData.returnDate}</p>
                    <button onClick={handleViewBookings}>View My Bookings</button>
                    <button onClick={(() => { navigate("/guest/seat") })}>Proceed to Seat Selection</button>
                </div>
            )}

        </section>
    );
};

export default AddAircraft;