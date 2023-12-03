import React, { useState, useEffect, useContext } from 'react';
import { useNavigate } from 'react-router-dom'; // Import useNavigate for redirection
import Video from './runway.mp4';

// Create a context to manage authentication state
const AuthContext = React.createContext();

// Create a custom hook to access the AuthContext
export const useAuth = () => useContext(AuthContext);

const Login = () => {
    const [username, setUser] = useState('');
    const [password, setPassword] = useState('');
    const [errMessage, setErrMessage] = useState('');
    const [userType, setUserType] = useState('');
    const [adminKey, setAdminKey] = useState('');
    const [crewKey, setCrewKey] = useState('');
    const navigate = useNavigate(); // Initialize useNavigate

    useEffect(() => {
        setErrMessage('');
    }, [username, password])

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            // Replace with the correct API URL
            const response = await fetch('http://localhost:8080/registered/getAll');
            const users = await response.json();

            // Find the user with the matching username
            const user = users.find(user => user.username === username);

            if (user) {
                // Check if the password matches
                if (user.password === password) {
                    // Redirect to flight browsing page if credentials match
                    navigate('/registered/flightbrowsing');
                } else {
                    // Set error message if the password does not match
                    setErrMessage('Invalid password.');
                }
            } else {
                // Set error message if username does not exist
                setErrMessage('Invalid username. You must register.');
            }
        } catch (error) {
            console.error('Error fetching users:', error);
            setErrMessage('An error occurred. Please try again later.');
        }
    }

    const handleLogout = async (e) => {
        navigate('/login');
    }

    return (
        <AuthContext.Provider value={{ handleLogout }}>
            <div className="mainbg">
                <video src={Video} autoPlay loop muted />
                <div className="overlay"></div>
                <section>
                    <p className={errMessage ? "errmsg" : "offscreen"} aria-live="assertive">{errMessage}</p>
                    <h1>Login</h1>
                    <form onSubmit={handleSubmit}>
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
                        {userType === "Crew" ? <div>
                            <label htmlFor="crewkey">Crew Key:</label>
                            <input
                                type="text"
                                id="crewkey"
                                autoComplete="off"
                                onChange={(e) => setCrewKey(e.target.value)}
                                value={username}
                                required
                            />
                        </div> : null}
                        {userType === "Admin" ? <div>
                            <label htmlFor="adminkey">Admin Key:</label>
                            <input
                                type="text"
                                id="adminkey"
                                autoComplete="off"
                                onChange={(e) => setAdminKey(e.target.value)}
                                value={username}
                                required
                            />
                        </div> : null}
                        <button>Log In</button>
                    </form>
                    <p>
                        <a href="/guest/flightbrowsing">Continue as Guest</a>
                    </p>
                    <div className="options">
                        <h3>Log in as: </h3>
                        <ul>
                            <input
                                type="radio"
                                name="userType"
                                value="User"
                                className="radio"
                                onChange={(e) => setUserType(e.target.value)}
                            />{" "}
                            User
                            <input
                                type="radio"
                                name="userType"
                                value="Crew"
                                className="radio"
                                onChange={(e) => setUserType(e.target.value)}
                            />{" "}
                            Crew
                            <input
                                type="radio"
                                name="userType"
                                value="Admin"
                                className="radio"
                                onChange={(e) => setUserType(e.target.value)}
                            />
                            Admin
                        </ul>
                    </div>
                    <div>
                        <p>
                            Don't have an account?
                            {/* Option 1: Link for registration */}
                            <a href="/register"> Register Here</a>
                            {/* Option 2: Button for registration (uncomment to use) */}
                            {/* <button onClick={handleRegisterNavigation}>Register</button> */}
                        </p>
                    </div>
                </section>
            </div>
        </AuthContext.Provider>
    )
}

export default Login;