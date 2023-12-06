import React from 'react';
import { useNavigate } from 'react-router-dom';

const Admin = () => {
    const navigate = useNavigate();

    return (
        <section>
            <h1>Welcome Admin!</h1>
            <p>What would you like to do?</p>
            <button className="log" onClick={() => navigate("/login")}>Logout</button>
            <form className="admin">
                <div>
                    <button className="admin-button" onClick={() => navigate("/admin/modifyaircrafts")}>Modify an Aircraft</button>
                </div>
                <div>
                    <button className="admin-button" onClick={() => navigate("/admin/modifyflights")}>Modify a Flight</button>
                </div>
                <div>
                    <button className="admin-button" onClick={() => navigate("/admin/modifycrew")}>Modify Crew</button>
                </div>
            </form>
        </section>
    );
};

export default Admin;