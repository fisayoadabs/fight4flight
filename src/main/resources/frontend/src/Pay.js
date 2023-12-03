import React, { useEffect, useState } from "react";

function Pay() {
    const [user, setUser] = useState('');
    const [card, setCard] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('http://localhost:8080/card/getAll');

                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }

                const data = await response.json();
                setCard(data);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };
        fetchData();
    }, []);

    console.log(card);

    const handleSubmit = async (e) => {
        e.preventDefault();

        // Assuming card validation and transaction logic is handled in the backend
        const payload = {
            cardNumber: user,
            // ... other necessary data like amount, user details, etc.
        };

        try {
            const response = await fetch('http://localhost:8080/payment/process', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(payload),
            });

            const result = await response.json();

            if (response.ok) {
                window.alert("Transaction Successful! An email will be sent to you with your ticket");
                // You can also navigate the user to a success page or similar here
            } else {
                window.alert(result.message || "Payment failed. Please try again.");
            }
        } catch (error) {
            console.error('Error during transaction:', error);
            window.alert("An error occurred. Please try again.");
        }
    };


    //Hypothetical Balance:
    const payment = 900.00;

    // const handleSubmit = async (e) => {
    //     e.preventDefault();
    //     for (let i = 0; i < card.length; i++) {
    //         console.log(card[i].cardnumber);
    //         console.log(user);
    //         //Match the cardnumber with user
    //         if (parseInt(card[i].cardnumber, 10) === parseInt(user, 10)) {
    //             console.log("card is equal to user");
    //             if (parseFloat(card[i].balance) < payment) {
    //                 window.alert("Insufficient funds!");
    //             } else {
    //                 window.alert("Transaction Successful! An email will be sent to you with your ticket");
    //             }
    //         }
    //     }
    // };

    return (
        <section>
            <h1>Pay with Card</h1>
            <form onSubmit={handleSubmit}>
                <label htmlFor="firstname">
                    Card Number:
                </label>
                <input
                    type="text"
                    id="firstname"
                    autoComplete="off"
                    onChange={(e) => setUser(e.target.value)}
                    required
                />

                <label htmlFor="lastname">
                    First Name:
                </label>
                <input
                    type="text"
                    id="lastname"
                    autoComplete="off"
                />

                <label htmlFor="address">
                    Last Name:
                </label>
                <input
                    type="text"
                    id="address"
                    autoComplete="off"
                />

                <label htmlFor="email">
                    Expiration Date:
                </label>
                <input
                    type="text"
                    id="email"
                    autoComplete="off"
                    placeholder={"MMYYYY"}
                />

                <label htmlFor="username">
                    CVV:
                </label>
                <input
                    type="text"
                    id="username"
                    autoComplete="off"
                    required
                />

                <button>Pay Now!</button>
            </form>
        </section>
    );
};

export default Pay;