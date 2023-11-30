import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlane } from '@fortawesome/free-solid-svg-icons';
import { useAuth } from './Login';

const FlightBrowsing = () => {
    const navigate = useNavigate();
    const [airports, setAirports] = useState([]); // State for storing airport data
    const [filteredDepartureAirports, setFilteredDepartureAirports] = useState([]); // Filtered list for departure
    const [filteredDestinationAirports, setFilteredDestinationAirports] = useState([]); // Filtered list for destination
    const { handleLogout } = useAuth(); // Use the useAuth hook

    // State to manage form data
    const [formData, setFormData] = useState({
        departure: '',
        destination: '',
        departureDate: '',
        returnDate: '',
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
        // Add validation logic here if needed

        // Show the flight summary
        setShowFlightSummary(true);
    };
    return (
        <section>
            <h1>Flight Browsing</h1>
            <button className="logout" onClick={handleLogout}>Logout</button>
            <form onSubmit={handleSubmit}>
                <label htmlFor="departure">
                    Departure Airport:
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
                    Destination Airport:
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


                <label htmlFor="departureDate">
                    Departure Date:
                    <input
                        type="date"
                        id="departureDate"
                        autoComplete="off"
                        required
                        value={formData.departureDate}
                        onChange={handleInputChange}
                    />
                </label>

                <label htmlFor="returnDate">
                    Return Date:
                    <input
                        type="date"
                        id="returnDate"
                        autoComplete="off"
                        required
                        value={formData.returnDate}
                        onChange={handleInputChange}
                    />
                </label>

                <button>
                    <div className="icon-container">
                        <FontAwesomeIcon icon={faPlane} className="plane-icon" />
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

export default FlightBrowsing;