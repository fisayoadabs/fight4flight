import { useState, useEffect } from "react";

const CARDNUMBER = /^\d{16}$/;
const PASSWORD = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/; // requires 1 lowercase letter, 1 uppercase letter, 1 digit, and 1 special character (shift 12345). 8-24 characters

const Pay = () => {
    const [user, setUser] = useState('');
    const [validName, setValidName] = useState(false); // boolean, tied to whether name validates or not
    const [userFocus, setUserFocus] = useState(false); // boolean, tied to whether  we have focus on input field or nah

    const [password, setPassword] = useState('');
    const [validPassword, setValidPassword] = useState(false);
    const [passwordFocus, setPasswordFocus] = useState(false);

    const [matchPassword, setMatchPassword] = useState('');
    const [validMatch, setValidMatch] = useState(false);
    const [matchFocus, setMatchFocus] = useState(false);

    const [errMessage, setErrMessage] = useState('');
    const [success, setSuccess] = useState(false);


    useEffect(() => {
        const result = CARDNUMBER.test(user);
        console.log(result);
        console.log(user);
        setValidName(result);
    }, [user])

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
    }, [user, password, matchPassword])

    const handleSubmit = async (e) => {
        e.preventDefault();

        const v1 = CARDNUMBER.test(user);
        const v2 = PASSWORD.test(password);
        if (!v1 || !v2) {
            setErrMessage('Please fill out all fields correctly.');
            return;
        }

    }

    const handleChange = (e) => {
        const value = e.target.value;
    };


    return (
        <>
                <section>
                    <p className={errMessage ? "errmessage" : "offscreen"} aria-live="assertive">{errMessage}</p>
                    <h1>Pay with Card</h1>
                    <form onSubmit={handleSubmit}>
                        {/* for first name */}
                        <label htmlFor="firstname">
                            Card Number:
                        </label>
                        <input
                            type="text"
                            id="firstname"
                            autoComplete="off"
                            onChange={(e) => setUser(e.target.value)}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                            onFocus={() => setUserFocus(true)}
                            onBlur={() => setUserFocus(false)}
                        />

                        {/* for last name */}
                        <label htmlFor="lastname">
                            First Name:
                        </label>
                        <input
                            type="text"
                            id="lastname"
                            autoComplete="off"
                            onChange={(e) => setUser(e.target.value)}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                            onFocus={() => setUserFocus(true)}
                            onBlur={() => setUserFocus(false)}
                        />

                        {/* for address */}
                        <label htmlFor="address">
                            Last Name:
                        </label>
                        <input
                            type="text"
                            id="address"
                            autoComplete="off"
                            onChange={(e) => setUser(e.target.value)}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                            onFocus={() => setUserFocus(true)}
                            onBlur={() => setUserFocus(false)}
                        />

                        {/* for email */}
                        <label htmlFor="email">
                            Expiration Date:
                        </label>
                        <input
                            type="email"
                            id="email"
                            autoComplete="off"
                            onChange={handleChange}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                            onFocus={() => setUserFocus(true)}
                            onBlur={() => setUserFocus(false)}
                            placeholder={"MMYYYY"}
                        />
                        <label htmlFor="username">
                            CVV:
                        </label>
                        <input
                            type="text"
                            id="username"
                            autoComplete="off"
                            onChange={(e) => setUser(e.target.value)}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                            onFocus={() => setUserFocus(true)}
                            onBlur={() => setUserFocus(false)}
                        />

                        <button disabled={!validName || !validPassword || !validMatch ? true : false}>Pay Now!</button>
                    </form>
                </section>
        </>
    )
}

export default Pay;