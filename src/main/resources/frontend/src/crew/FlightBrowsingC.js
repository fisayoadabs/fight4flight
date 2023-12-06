import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlane } from '@fortawesome/free-solid-svg-icons';

const FlightBrowsingC = () => {
    const [flights, setFlights] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('http://localhost:8080/flight-management/getAllFlights');

                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }

                const data = await response.json();
                setFlights(data);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };
        fetchData();
    }, []); // Run once on component mount
    console.log(flights);
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
    const [start, setStart] = useState(true);


    // Access departure dates for all
    const departureDates = flights.map((flight) => flight.departureTime.substring(0, 10));
    // Access all departure portCodes
    const departureArray = flights.map((flight) => flight.departure.portCode);
    // Access all destination portCodes
    const destinationArray = flights.map((flight) => flight.destination.portCode);
    const[flightid, setFlightid] = useState(0);

    const checkFlights = () => {
        const matchingDep = [];
        const matchingDest = [];
        const matchingDate = [];

        //iterate through departure airport list and check to see if there's a match
        //add to matchingDep list to reference index
        for (let i = 0; i < departureArray.length; i++) {
            console.log(i);
            console.log(departureArray[i]);
            console.log(formData.departure.substring(formData.departure.length - 3));
            if (formData.departure.substring(formData.departure.length - 3) === departureArray[i]) {
                matchingDep.push(i);
                console.log("departure match!");
            } else {
                console.log("departure does not match :/");
            }
        }
        console.log(matchingDep);

        for (let i = 0; i < destinationArray.length; i++) {
            console.log(destinationArray[i]);
            console.log(formData.destination.substring(formData.destination.length - 3));
            if (formData.destination.substring(formData.destination.length - 3) === destinationArray[i]) {
                matchingDest.push(i);
                console.log("destination match!");
            } else {
                console.log("destination does not match :/");
            }
        }
        console.log(matchingDest);

        for (let i = 0; i < departureDates.length; i++) {
            console.log(departureDates[i]);
            console.log(formData.departureDate);
            if (formData.departureDate === departureDates[i]) {
                matchingDate.push(i);
                console.log("date match!");
            } else {
                console.log("date does not match :/");
            }
        }
        console.log(matchingDate);

        //check if there is a number in all arrays
        //this will return the first match or none
        for(let i = 0; i < flights.length; i++){
            if(matchingDep.includes(i) && matchingDest.includes(i) && matchingDate.includes(i)){
                setShowFlightSummary(true);
                setStart(false);
                console.log("flight does exist");
                const sum = i + 1;
                setFlightid(sum);
                console.log(flightid);
                break;
            } else {
                setShowFlightSummary(false);
                setStart(false);
                console.log("flight does not exist");
            }
        }
    }

    useEffect(() => {
        // Fetch airport data from API and update state
        const fetchAirports = async () => {
            try {
                const response = await fetch('http://localhost:8080/flight-management/airport/getAll');
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
    };
    return (
        <section>
            <h1>Search Flights</h1>
            <button className="back" onClick={() => navigate("/crew")}>Back</button>
            <button className="log" onClick={() => navigate("/login")}>Logout</button>
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

                <button onClick={checkFlights}>
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

                    <button onClick={(() => { navigate(`/guest/seat/${flightid}`) })}>Proceed to Seat Selection</button>
                </div>

            )}
            {!showFlightSummary && !start &&(
                <div className="results">
                    <p>Flight Is Not Available at the Moment</p>
                </div>
            )}
        </section>
    );
};
export default FlightBrowsingC;