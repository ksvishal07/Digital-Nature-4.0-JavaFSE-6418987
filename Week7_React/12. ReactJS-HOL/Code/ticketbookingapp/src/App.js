import React, { useState } from 'react';
import GuestPage from './components/GuestPage';
import UserPage from './components/UserPage';

const App = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>✈️ Ticket Booking App</h1>
      <div style={{ marginBottom: '10px' }}>
        {isLoggedIn ? (
          <button onClick={handleLogout}>Logout</button>
        ) : (
          <button onClick={handleLogin}>Login</button>
        )}
      </div>

      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
};

export default App;
