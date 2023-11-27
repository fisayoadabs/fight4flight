
  import React, { useState } from 'react';
  import axios from 'axios';

  function App() {
    const [customer, setCustomer] = useState({FName: '', LName: '', Email: '' });

    const handleChange = (e) => {
      setCustomer({ ...customer, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
      e.preventDefault();
      try {
        console.log(customer);
        await axios.post('http://localhost:8080/customers', customer);
        alert('Customer added!');
      } catch (error) {
        console.error('There was an error!', error);
      }
    };

    return (
      <div>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            name="FName"
            value={customer.FName}
            onChange={handleChange}
            placeholder="First Name"
          />
          <input
            type="text"
            name="LName"
            value={customer.LName}
            onChange={handleChange}
            placeholder="Last Name"
          />
          <input
            type="email"
            name="Email"
            value={customer.Email}
            onChange={handleChange}
            placeholder="Email"
          />
          <button type="submit">Add Customer</button>
        </form>
      </div>
    );
  }

export default App;
