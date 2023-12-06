import React from 'react';
import { useNavigate } from 'react-router-dom';

const ModifyCrew = () => {
    const navigate = useNavigate();

    return (
        <section>
            <h2>What's Next?</h2>
            <button className="back-wagwan" onClick={() => navigate("/admin/")}>Back</button>
            <button className="log" onClick={() => navigate("/login")}>Logout</button>
            <form className="admin">
                <div>
                    <button className="admin-button" onClick={() => navigate("/admin/modifycrew/addcrew")}>Add Crew Member</button>
                </div>
                <div>
                    <button className="admin-button" onClick={() => navigate("/admin/modifycrew/editcrew")}>Edit Crew Member</button>
                </div>
                <div>
                    <button className="admin-button" onClick={() => navigate("/admin/modifycrew/removecrew")}>Remove Crew Member</button>
                </div>
                <div>
                    <button className="admin-button" onClick={() => navigate("/admin/modifycrew/getall")}>Get All Crew Members</button>
                </div>
            </form>
        </section>
    );
};

export default ModifyCrew;