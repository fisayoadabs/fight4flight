import './App.css'
import Customer from './Customer.js'
import Register from './Register';
// App.js or your main entry point
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Seat from './Seat';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/seat" element={<Seat />} />
        {/* Other routes */}
      </Routes>
    </Router>
  );
}

export default App;

