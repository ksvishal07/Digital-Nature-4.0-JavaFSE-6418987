import React from 'react';

const IndianPlayers = () => {
  const oddTeam = ['Player1', 'Player3', 'Player5', 'Player7', 'Player9'];
  const evenTeam = ['Player2', 'Player4', 'Player6', 'Player8', 'Player10'];

  const [p1, p2, p3, ...others] = [...oddTeam, ...evenTeam];

  const T20players = ['Virat', 'Rohit', 'Gill'];
  const RanjiPlayers = ['Pujara', 'Rahane', 'Saha'];

  const allPlayers = [...T20players, ...RanjiPlayers];

  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>
        {oddTeam.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
      <h2>Even Team Players</h2>
      <ul>
        {evenTeam.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

      <h2>Merged Players (T20 + Ranji)</h2>
      <ul>
        {allPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
