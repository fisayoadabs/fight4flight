import React from 'react';
import { useNavigate } from 'react-router-dom';

const Crew = () => {
    const navigate = useNavigate();

    return (
        <section>
            <h1>Welcome Crew!</h1>
            <p>What would you like to do?</p>
            <button className="log" onClick={() => navigate("/login")}>Logout</button>
            <form className="crew">
                <div>
                    <button className="admin-button" onClick={() => navigate("/crew/passengerlist")}>Browse Passenger List</button>
                </div>
                <div>
                    <button className="admin-button" onClick={() => navigate("/crew/flightbrowsing")}>Browse Flights</button>
                </div>
            </form>
        </section>
    );
};

export default Crew;