import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const Login = () => {
    const [username, setUser] = useState('');
    const [password, setPassword] = useState('');
    const [errMessage, setErrMessage] = useState('');
    const [userType, setUserType] = useState('User'); // Default to 'User'
    const [adminid, setAdminid] = useState('');
    const [crewid, setCrewid] = useState('');
    const navigate = useNavigate();

    useEffect(() => {
        setErrMessage('');
    }, [username, password])

    const getApiEndpoint = () => {
        if (userType === 'Admin') {
            return 'http://localhost:8080/user/adminLogin'; // Replace with actual admin login API
        } else if (userType === 'Crew') {
            return 'http://localhost:8080/flight-management/workers/getCrewMem'; // Replace with actual crew login API
        }
        return 'http://http://localhost:8080/user/getAllAdmins'; // Default API for regular users
    }

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const endpoint = getApiEndpoint();
            const response = await fetch(endpoint, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ username, password, adminid, crewid })
            });

            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }

            const user = await response.json();

            if (user) {
                // Redirect to appropriate page based on user type
                if (userType === 'Admin') {
                    navigate('/admin/dashboard');
                } else if (userType === 'Crew') {
                    navigate('/crew/dashboard');
                } else {
                    navigate('/registered/flightbrowsing');
                }
            } else {
                setErrMessage('Invalid login credentials.');
            }
        } catch (error) {
            console.error('Error during login:', error);
            setErrMessage('An error occurred. Please try again later.');
        }
    }

    return (
        <section>
            {/* Error Message Display */}
            <p className={errMessage ? "errmsg" : "offscreen"} aria-live="assertive">{errMessage}</p>

            <h1>Login</h1>
            <form onSubmit={handleSubmit}>
                {/* Form Inputs */}
                <label htmlFor="username">Username:</label>
                <input
                    type="text"
                    id="username"
                    autoComplete="off"
                    onChange={(e) => setUser(e.target.value)}
                    value={username}
                    required
                />
                <label htmlFor="password">Password:</label>
                <input
                    type="password"
                    id="password"
                    onChange={(e) => setPassword(e.target.value)}
                    value={password}
                    required
                />

                {/* Additional Fields for Crew and Admin */}
                {userType === "Crew" && (
                    <div>
                        <label htmlFor="crewid">Crew Key:</label>
                        <input
                            type="text"
                            id="crew"
                            autoComplete="off"
                            onChange={(e) => setCrewid(e.target.value)}
                            value={crewid}
                            required
                        />
                    </div>
                )}
                {userType === "Admin" && (
                    <div>
                        <label htmlFor="adminid">Admin Key:</label>
                        <input
                            type="text"
                            id="admin"
                            autoComplete="off"
                            onChange={(e) => setAdminid(e.target.value)}
                            value={adminid}
                            required
                        />
                    </div>
                )}

                <button>Log In</button>
            </form>

            {/* Continue as Guest and Registration Links */}
            <p>
                <a href="/guest/flightbrowsing">Continue as Guest</a>
            </p>
            <div className="options">
                <h3>Log in as: </h3>
                <ul>
                    <li>
                        <label>
                            <input
                                type="radio"
                                name="userType"
                                value="User"
                                className="radio"
                                onChange={(e) => setUserType(e.target.value)}
                                checked={userType === "User"}
                            />
                            User
                        </label>
                    </li>
                    <li>
                        <label>
                            <input
                                type="radio"
                                name="userType"
                                value="Crew"
                                className="radio"
                                onChange={(e) => setUserType(e.target.value)}
                                checked={userType === "Crew"}
                            />
                            Crew
                        </label>
                    </li>
                    <li>
                        <label>
                            <input
                                type="radio"
                                name="userType"
                                value="Admin"
                                className="radio"
                                onChange={(e) => setUserType(e.target.value)}
                                checked={userType === "Admin"}
                            />
                            Admin
                        </label>
                    </li>
                </ul>
            </div>
            <div>
                <p>
                    Don't have an account? <a href="/register">Register Here</a>
                </p>
            </div>
            <p>
                Cancel ticket? <a href="/cancel">Cancel Ticket</a>
            </p>
        </section>
    )
}

export default Login;
