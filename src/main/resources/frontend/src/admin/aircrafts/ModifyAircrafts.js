import React from 'react';
import { useNavigate } from 'react-router-dom';

const ModifyAircrafts = () => {
    const navigate = useNavigate();

    return (
        <section>
            <h2>What's Next?</h2>
            <button className="back-wagwan" onClick={() => navigate("/admin/")}>Back</button>
            <button className="log" onClick={() => navigate("/login")}>Logout</button>
            <form className="admin">
                <div>
                    <button className="admin-button" onClick={() => navigate("/admin/modifyaircrafts/addaircraft")}>Add Aircraft</button>
                </div>
                <div>
                    <button className="admin-button" onClick={() => navigate("/admin/modifyaircrafts/removeaircraft")}>Remove Aircraft</button>
                </div>
                <div>
                    <button className="admin-button" onClick={() => navigate("/admin/modifyaircrafts/aircraftlist")}>Get List of Aircrafts</button>
                </div>
            </form>
        </section>
    );
};

export default ModifyAircrafts;