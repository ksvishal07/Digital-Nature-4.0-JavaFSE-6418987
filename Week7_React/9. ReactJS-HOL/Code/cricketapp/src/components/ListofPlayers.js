import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Virat', score: 90 },
    { name: 'Rohit', score: 85 },
    { name: 'Rahul', score: 65 },
    { name: 'Gill', score: 75 },
    { name: 'Pant', score: 68 },
    { name: 'Jadeja', score: 95 },
    { name: 'Ashwin', score: 70 },
    { name: 'Bumrah', score: 60 },
    { name: 'Shami', score: 80 },
    { name: 'Surya', score: 88 },
    { name: 'Iyer', score: 45 },
  ];

  const filteredPlayers = players.filter(player => player.score >= 70);

  return (
    <div>
      <h2>List of Players with Score ≥ 70</h2>
      <ul>
        {filteredPlayers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
