import './App.css'
import Customer from './Customer.js'
import Register from './Register';
// App.js or your main entry point
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Seat from './Seat';
import Login from './Login';
import FlightBrowsing from './FlightBrowsing';
import Pay from './Pay';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />}/>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/flightbrowsing" element={<FlightBrowsing />} />
        <Route path="/pay" element={<Pay />} />
      </Routes>
    </Router>
  );
}

export default App;

