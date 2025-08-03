import React, { useState } from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

const App = () => {
  const [selected, setSelected] = useState('book');

  const renderComponent = () => {
    switch (selected) {
      case 'book':
        return <BookDetails />;
      case 'blog':
        return <BlogDetails />;
      case 'course':
        return <CourseDetails />;
      default:
        return <p>Select a section</p>;
    }
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>📚 Blogger App</h1>

      <div style={{ marginBottom: '15px' }}>
        {/* Way 1: Using inline arrow function in onClick */}
        <button onClick={() => setSelected('book')}>Book</button>{' '}
        <button onClick={() => setSelected('blog')}>Blog</button>{' '}
        <button onClick={() => setSelected('course')}>Course</button>
      </div>

      {/* Way 2: Ternary operator */}
      {selected === 'book' ? (
        <BookDetails />
      ) : selected === 'blog' ? (
        <BlogDetails />
      ) : selected === 'course' ? (
        <CourseDetails />
      ) : (
        <p>Please select a section</p>
      )}

      {/* Way 4: Function returning component */}
      {/* Uncomment to try another way */}
      {/* {renderComponent()} */}
    </div>
  );
};

export default App;
