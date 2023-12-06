import React from 'react';
import { Link } from 'react-router-dom';

const Confirmation = () => {
    return (
        <div>
            <h1>Thank You for Your Booking!</h1>
            <p>Your booking has been confirmed. We look forward to welcoming you on board.</p>
            <Link to="/login">Back to Login</Link>
        </div>
    );
};

export default Confirmation;
