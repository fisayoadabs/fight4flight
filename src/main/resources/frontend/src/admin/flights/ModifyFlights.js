import React from 'react';
import { useNavigate } from 'react-router-dom';

const ModifyFlights = () => {
    const navigate = useNavigate();

    return (
        <section>
            <h2>What's Next?</h2>
            <button className="back-wagwan" onClick={() => navigate("/admin/")}>Back</button>
            <button className="log" onClick={() => navigate("/login")}>Logout</button>
            <form className="admin">
                <div>
                    <button className="admin-button" onClick={() => navigate("/admin/modifyflights/addflights")}>Add Flight</button>
                </div>
                <div>
                    <button className="admin-button" onClick={() => navigate("/admin/modifyflights/editflights")}>Edit Flight</button>
                </div>
                <div>
                    <button className="admin-button" onClick={() => navigate("/admin/modifyflights/removeflights")}>Remove Flight</button>
                </div>
                <div>
                    <button className="admin-button" onClick={() => navigate("/admin/modifyflights/getall")}>Get All Flights</button>
                </div>
            </form>
        </section>
    );
};

export default ModifyFlights;