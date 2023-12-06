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
import Admin from './admin/Admin.js';
import ModifyAircrafts from './admin/aircrafts/ModifyAircrafts.js';
import AddAircrafts from './admin/aircrafts/AddAircraft.js';
import RemoveAircrafts from './admin/aircrafts/RemoveAircraft.js';
import AircraftList from './admin/aircrafts/AircraftList.js';

import AddFlights from './admin/flights/AddFlights.js';
import ModifyFlights from './admin/flights/ModifyFlights.js';
import EditFlights from './admin/flights/EditFlights.js';
import RemoveFlights from './admin/flights/RemoveFlights.js';
import GetAll from './admin/flights/GetAll.js';

import Crew from './crew/Crew.js';
import PassengerList from './crew/PassengerList.js';
import FlightBrowsingC from './crew/FlightBrowsingC.js';
import ModifyCrew from './admin/crew/ModifyCrew.js';
import EditCrew from './admin/crew/EditCrew.js';
import RemoveCrew from './admin/crew/RemoveCrew.js';
import AddCrew from './admin/crew/AddCrew.js';
import Confirmation from "./Confirmation";
import Cancel from "./Cancel";


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/cancel" element={<Cancel />} />

        <Route path="/registered/flightbrowsing" element={<FlightBrowsingR />} />
        <Route path="/registered/seat/:flightid" element={<SeatR />} />
        <Route path="/registered/insurance" element={<InsuranceR />} />

        <Route path="/agent/flightbrowsing" element={<FlightBrowsing />} />

        <Route path="/guest/flightbrowsing" element={<FlightBrowsing />} />
        <Route path="/guest/customer/:flightid" element ={<Customer/>} />
        <Route path="guest/seat/:flightid/:email" element={<Seat />} />
        <Route path="guest/insurance" element={<Insurance />} />

        <Route path="/pay/:flightid/:email/:seatid/:price" element={<Pay />} />
        <Route path="/confirmation" element={<Confirmation />} />
        <Route path="/summary" element={<Summary />} />

        <Route path="/crew/" element={<Crew />} />
        {/*<Route path="/crew/passengerlist" element={<PassengerList />} />*/}
        <Route path="/crew/flightbrowsing" element={<FlightBrowsingC />} />

        <Route path="/admin/" element={<Admin />} />
        <Route path="/admin/modifyaircrafts" element={<ModifyAircrafts />} />
        <Route path="/admin/modifyflights" element={<ModifyFlights />} />
        <Route path="/admin/modifycrew" element={<ModifyCrew />} />

        <Route path="/admin/modifyaircrafts/addaircraft" element={<AddAircrafts />} />
        <Route path="/admin/modifyaircrafts/removeaircraft" element={<RemoveAircrafts />} />
        <Route path="/admin/modifyaircrafts/aircraftlist" element={<AircraftList />} />

        <Route path="/admin/modifyflights/addflights" element={<AddFlights />} />
        <Route path="/admin/modifyflights/editflights" element={<EditFlights />} />
        <Route path="/admin/modifyflights/removeflights" element={<RemoveFlights />} />

        <Route path="/admin/modifycrew/addcrew" element={<AddCrew />} />
        <Route path="/admin/modifycrew/editcrew" element={<EditCrew />} />
        <Route path="/admin/modifycrew/removecrew" element={<RemoveCrew />} />
        <Route path="/admin/modifycrew/getall" element={<GetAll />} />

      </Routes>
    </Router>
  );
}

export default App;

