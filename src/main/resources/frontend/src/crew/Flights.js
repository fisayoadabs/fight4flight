import { React, useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlane } from '@fortawesome/free-solid-svg-icons';
import Pay from '../Pay';

const Flights = () => {
    const navigate = useNavigate();
    const [airports, setAirports] = useState([]); // State for storing airport data
    const [filteredDepartureAirports, setFilteredDepartureAirports] = useState([]); // Filtered list for departure
    const [filteredDestinationAirports, setFilteredDestinationAirports] = useState([]); // Filtered list for destination


    // State to manage form data
    const [formData, setFormData] = useState({
        departure: '',
        destination: '',
        departureDate: '',
    });

    // State to manage visibility of flight summary
    const [showFlightSummary, setShowFlightSummary] = useState(false);

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

    const handleViewBookings = () => {
        // Implement logic to fetch and display user's bookings
        alert('View My Bookings functionality will be implemented here.');
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        setShowFlightSummary(true);
    };
    
    return (
        <section>
            <h1>Available Flights</h1>
            <button className="back" onClick={() => navigate("/crew/flightbrowsing")}>Back</button>
            <button className="log" onClick={() => navigate("/login")}>Logout</button>
            <form onSubmit={handleSubmit}>
                {showFlightSummary && (
                    <div className="flight-summary">
                        <h2>Flight Summary</h2>
                        <p>Departure: {formData.departure}</p>
                        <p>Destination: {formData.destination}</p>
                        <p>Departure Date: {formData.departureDate}</p>
                        <button onClick={handleViewBookings}>View My Bookings</button>
                        <button onClick={(() => { navigate("/guest/seat") })}>Proceed to Seat Selection</button>
                    </div>
                )}
            </form>
        </section>
    );
};

export default Flights;