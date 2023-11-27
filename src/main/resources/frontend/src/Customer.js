import React, { useState } from 'react';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material'

function Customer() {
    const [FName, setFName] = useState('')
    const [LName, setLName] = useState('')
    const [Email, setEmail] = useState('')

    const handleClick = (e) => {
        e.preventDefault()
        const customer = { FName, LName, Email }
        console.log(customer)
        fetch('http://localhost:8080/customer/add', {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body:JSON.stringify(customer)
        }
        ).then(() => {
            console.log("Customer was added")
        })
    }
    
    return (
        <Container>
            <Paper elevation={3}>
                <h1 style={{color: "blue"}}>Add Customer</h1>
                <form>
                    <TextField label="First Name" variant="outlined" margin="normal" required fullWidth
                        value={FName}
                        onChange={(e)=>setFName(e.target.value)}
                    />
                    <TextField label="Last Name" variant="outlined" margin="normal" required fullWidth
                        value={LName}
                        onChange={(e) => setLName(e.target.value)}
                    />
                    <TextField label="Email Address" variant="outlined" margin="normal" required type="email" fullWidth
                        value={Email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <Button variant="contained" color="secondary" onClick={handleClick}>
                        Submit
                    </Button>
                </form>
            </Paper>
        </Container>
    );
}

export default Customer;
