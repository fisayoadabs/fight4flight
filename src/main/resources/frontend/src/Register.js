import { useState, useEffect } from "react";
import { faCheck, faTimes, faInfoCircle } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

const USERNAME = /^[a-zA-Z][a-zA-Z0-9-_]{3,23}$/; // must start with lower/uppercase character, then can follow with any upper/lowercase characters, digits, -, or _. 4-24 character usernamename
const PASSWORD = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/; // requires 1 lowercase letter, 1 uppercase letter, 1 digit, and 1 special character (shift 12345). 8-24 characters

const Register = () => {
    const [fname, setFName] = useState('')
    const [lname, setLName] = useState('')
    const [email, setEmail] = useState('')
    const [address, setAddress] = useState('')

    const [username, setUsername] = useState('');
    const [validName, setValidName] = useState(false); // boolean, tied to whether name validates or not
    const [usernameFocus, setUsernameFocus] = useState(false); // boolean, tied to whether  we have focus on input field or nah

    const [password, setPassword] = useState('');
    const [validPassword, setValidPassword] = useState(false);
    const [passwordFocus, setPasswordFocus] = useState(false);

    const [matchPassword, setMatchPassword] = useState('');
    const [validMatch, setValidMatch] = useState(false);
    const [matchFocus, setMatchFocus] = useState(false);

    const [errMessage, setErrMessage] = useState('');
    const [success, setSuccess] = useState(false);

    // validating usernamename
    useEffect(() => {
        const result = USERNAME.test(username);
        console.log(result);
        console.log(username);
        setValidName(result);
    }, [username])

    // validating password
    useEffect(() => {
        const result = PASSWORD.test(password);
        console.log(result);
        console.log(password);
        setValidPassword(result);
        const match = password === matchPassword;
        setValidMatch(match);
    }, [password, matchPassword])

    // for error message
    useEffect(() => {
        setErrMessage('');
    }, [username, password, matchPassword])


    // const handleSubmit = async (e) => {
    //     e.preventDefault();
    //     fetch('http://localhost:8080/registered/getAll', {
    //     })
    //     if (validName && validPassword && validMatch) {
    //         const registee = {fname, lname, address, email, username, password}
    //         fetch('http://localhost:8080/registered/register', {
    //             method: 'POST',
    //             headers: {
    //                 'Content-Type': 'application/json'
    //             },
    //             body: JSON.stringify(registee) // add other parameters
    //         }).then(() => {
    //             console.log("Registee was added")
    //         })
    //         // console.log(data);
    //         // if (data.status === 'success') {
    //         //     setSuccess(true);
    //         //     setErrMessage('Successfully registered!');
    //         // } else {
    //         //     setErrMessage('Usernamename already exists. Please try again.');
    //         // }
    //     } else {
    //         setErrMessage('Please fill out all fields correctly.');
    //     }
    //     const v1 = USERNAME.test(username);
    //     const v2 = PASSWORD.test(password);
    //     if (!v1 || !v2) {
    //         setErrMessage('Please fill out all fields correctly.');
    //         return;
    //     }
    //     // try {
    //     //     const response = await axios.post(REGISTER_URL, JSON.stringify({ username, password }),
    //     //     {
    //     //         headers: { 'Content-Type': 'application/json'},
    //     //         withCredentials: true
    //     //     }
    //     //     );
    //     //     console.log(response.data);
    //     //     setSuccess(true);
    //     // } catch (err) {
    //     //     if (!err?.response) {
    //     //         setErrMessage('No Server Response');
    //     //     } else if (err.response?.status === 409) {
    //     //         setErrMessage('Usernamename already exists. Please try again.');
    //     //     } else {
    //     //         setErrMessage('Something went wrong. Please try again.');
    //     //     }
    //     //     errRef.current.focus
    //     // }
    // }
    
    const handleSubmit = async (e) => {
        e.preventDefault();

        // Step 1: Fetch existing user data
        const response = await fetch('http://localhost:8080/registered/getAll');
        const users = await response.json();

        // Step 2: Check if the username already exists
        const usernameExists = users.some(user => user.username === username);

        if (usernameExists) {
            // Step 3: Set error message if username exists
            setErrMessage('Username already exists. Please try a different one.');
            return;
        } else {
            // Step 4: Proceed with registration if username does not exist
            if (validName && validPassword && validMatch) {
                const registee = { fname, lname, address, email, username, password };
                fetch('http://localhost:8080/registered/register', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(registee)
                }).then(() => {
                    console.log("Registee was added");
                    // Set success message or redirect to login
                    setSuccess(true);
                }).catch(err => {
                    console.error("Error adding registee", err);
                    setErrMessage('An error occurred during registration. Please try again.');
                });
            } else {
                setErrMessage('Please fill out all fields correctly.');
            }
        }
    }


    return (
        <>
            {success ? (
                <section>
                    <h1>Success!</h1>
                    <p>You have successfully registered!
                        <a href="#">Log In Now!</a
                        ></p>
                </section>
            ) : (
                <section>
                    <p className={errMessage ? "errmessage" : "offscreen"} aria-live="assertive">{errMessage}</p>
                    <h1>Register</h1>
                    <form onSubmit={handleSubmit}>
                        {/* for first name */}
                        <label htmlFor="firstname">
                            First Name:
                            <span className={validName ? "valid" : "hide"}>
                                <FontAwesomeIcon icon={faCheck} />
                            </span>
                            <span className={validName || !username ? "hide" : "invalid"}>
                                <FontAwesomeIcon icon={faTimes} />
                            </span>
                        </label>
                        <input
                            type="text"
                            id="firstname"
                            autoComplete="off"
                            onChange={(e) => setFName(e.target.value)}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                            onFocus={() => setUsernameFocus(true)}
                            onBlur={() => setUsernameFocus(false)}
                        />

                        {/* for last name */}
                        <label htmlFor="lastname">
                            Last Name:
                            <span className={validName ? "valid" : "hide"}>
                                <FontAwesomeIcon icon={faCheck} />
                            </span>
                            <span className={validName || !username ? "hide" : "invalid"}>
                                <FontAwesomeIcon icon={faTimes} />
                            </span>
                        </label>
                        <input
                            type="text"
                            id="lastname"
                            autoComplete="off"
                            onChange={(e) => setLName(e.target.value)}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                            onFocus={() => setUsernameFocus(true)}
                            onBlur={() => setUsernameFocus(false)}
                        />

                        {/* for address */}
                        <label htmlFor="address">
                            Address:
                            <span className={validName ? "valid" : "hide"}>
                                <FontAwesomeIcon icon={faCheck} />
                            </span>
                            <span className={validName || !username ? "hide" : "invalid"}>
                                <FontAwesomeIcon icon={faTimes} />
                            </span>
                        </label>
                        <input
                            type="text"
                            id="address"
                            autoComplete="off"
                            onChange={(e) => setAddress(e.target.value)}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                            onFocus={() => setUsernameFocus(true)}
                            onBlur={() => setUsernameFocus(false)}
                        />

                        {/* for email */}
                        <label htmlFor="email">
                            Email:
                            <span className={validName ? "valid" : "hide"}>
                                <FontAwesomeIcon icon={faCheck} />
                            </span>
                            <span className={validName || !username ? "hide" : "invalid"}>
                                <FontAwesomeIcon icon={faTimes} />
                            </span>
                        </label>
                        <input
                            type="email"
                            id="email"
                            autoComplete="off"
                            onChange={(e) => setEmail(e.target.value)}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                            onFocus={() => setUsernameFocus(true)}
                            onBlur={() => setUsernameFocus(false)}
                        />

                        {/* for usernamename */}
                        <label htmlFor="usernamename">
                            Usernamename:
                            <span className={validName ? "valid" : "hide"}>
                                <FontAwesomeIcon icon={faCheck} />
                            </span>
                            <span className={validName || !username ? "hide" : "invalid"}>
                                <FontAwesomeIcon icon={faTimes} />
                            </span>
                        </label>
                        <input
                            type="text"
                            id="usernamename"
                            autoComplete="off"
                            onChange={(e) => setUsername(e.target.value)}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                            onFocus={() => setUsernameFocus(true)}
                            onBlur={() => setUsernameFocus(false)}
                        />
                        <p id="uidnote" className={usernameFocus && username && !validName ? "instructions" : "offscreen"}>
                            <FontAwesomeIcon icon={faInfoCircle} />
                            Usernamename must be 4-24 characters and start with a letter.<br />
                            Letters, numbers, underscores, and hyphens allowed. <br />
                        </p>

                        {/* for password */}
                        <label htmlFor="password">
                            Password:
                            <span className={validPassword ? "valid" : "hide"}>
                                <FontAwesomeIcon icon={faCheck} />
                            </span>
                            <span className={validPassword || !password ? "hide" : "invalid"}>
                                <FontAwesomeIcon icon={faTimes} />
                            </span>
                        </label>
                        <input
                            type="password"
                            id="password"
                            autoComplete="off"
                            onChange={(e) => setPassword(e.target.value)}
                            required
                            aria-invalid={validPassword ? "false" : "true"}
                            aria-describedby="pwdnote"
                            onFocus={() => setPasswordFocus(true)}
                            onBlur={() => setPasswordFocus(false)}
                        />
                        <p id="pwdnote" className={passwordFocus && !validPassword ? "instructions" : "offscreen"}>
                            <FontAwesomeIcon icon={faInfoCircle} />
                            Password must be 4-24 characters.<br />
                            Must include uppercase and lowercase letters, a number, and a special character.<br />
                            Allowed special characters:
                            <span aria-label="exclamation mark">!</span>
                            <span aria-label="at sign">@</span>
                            <span aria-label="hashtag">#</span>
                            <span aria-label="dollar sign">$</span>
                            <span aria-label="percent">%</span>
                        </p>

                        {/* for matching password (confirmation) */}
                        <label htmlFor="confirm_password">
                            Confirm Password:
                            <span className={validMatch && matchPassword ? "valid" : "hide"}>
                                <FontAwesomeIcon icon={faCheck} />
                            </span>
                            <span className={validMatch || !matchPassword ? "hide" : "invalid"}>
                                <FontAwesomeIcon icon={faTimes} />
                            </span>
                        </label>
                        <input
                            type="password"
                            id="confirm_password"
                            onChange={(e) => setMatchPassword(e.target.value)}
                            required
                            aria-invalid={validMatch ? "false" : "true"}
                            aria-describedby="confirmnote"
                            onFocus={() => setMatchFocus(true)}
                            onBlur={() => setMatchFocus(false)}
                        />
                        <p id="confirmnote" className={matchFocus && !validMatch ? "instructions" : "offscreen"}>
                            <FontAwesomeIcon icon={faInfoCircle} />
                            Make sure your password here matches the first password input field.<br />
                        </p>

                        <button disabled={!validName || !validPassword || !validMatch ? true : false}>Sign Up!</button>
                    </form>

                    {/* at the end of sign up form */}
                    <p>
                        Already registered?<br />
                        <span className="line">
                            {/* # is a placeholder for now, will replace with router link to login page */}
                            <a href="login">Log In Here</a>
                        </span>
                    </p>
                </section>
            )}
        </>
    )
}

export default Register;