import React from 'react';

const BookDetails = () => {
  const books = [
    { id: 1, title: 'You Can Win', author: 'Shiv Khera' },
    { id: 2, title: 'Atomic Habits', author: 'James Clear' },
    { id: 3, title: 'Wings of Fire', author: 'A.P.J Abdul Kalam' }
  ];

  return (
    <div style={styles.container}>
      <h2>📘 Book Details</h2>
      <ul>
        {books.map(book => (
          <li key={book.id}>
            <strong>{book.title}</strong> by {book.author}
          </li>
        ))}
      </ul>
    </div>
  );
};

const styles = {
  container: {
    border: '1px solid #ccc',
    padding: '15px',
    backgroundColor: '#f9f9f9',
    borderRadius: '8px'
  }
};

export default BookDetails;
