import './App.css'
import Customer from './Customer.js'
import Register from './Register';
// App.js or your main entry point
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Seat from './Seat';
import Login from './Login';
import FlightBrowsing from './FlightBrowsing';
import Pay from './Pay';
import FlightBrowsingR from './FlightBrowsingR';
import SeatR from './SeatR';
import Summary from './Summary';
import Insurance from './Insurance';
import InsuranceR from './InsuranceR';
import AircraftList from './AircraftList';
import AddFlights from './AddFlights';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />

        <Route path="/registered/flightbrowsing" element={<FlightBrowsingR />} />
        <Route path="/registered/seat" element={<SeatR />} />
        <Route path="/registered/insurance" element={<InsuranceR />} />

        <Route path="/agent/flightbrowsing" element={<FlightBrowsing />} />

        <Route path="/guest/flightbrowsing" element={<FlightBrowsing />} />
        <Route path="guest/seat" element={<Seat />} />
        <Route path="guest/insurance" element={<Insurance />} />

        <Route path="/pay" element={<Pay />} />
        <Route path="/summary" element={<Summary />} />
        <Route path="/admin/modifyaircrafts/aircraftlist" element={<AircraftList />} />

        {/* <Route path="/admin/modifyaircrafts/removeaircraft" element={<RemoveAircrafts />} />
        <Route path="/admin/modifyaircrafts/aircraftlist" element={<AircraftList />} /> */}

        <Route path="/admin/modifyflights/addflights" element={<AddFlights />} />

      </Routes>
    </Router>
  );
}

export default App;

