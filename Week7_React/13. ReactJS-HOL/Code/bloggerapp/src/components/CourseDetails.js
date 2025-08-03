import React from 'react';

const CourseDetails = () => {
  const courses = [
    { id: 1, name: 'React for Beginners', duration: '4 weeks' },
    { id: 2, name: 'JavaScript Mastery', duration: '6 weeks' },
    { id: 3, name: 'Node.js Fundamentals', duration: '5 weeks' }
  ];

  return (
    <div style={styles.container}>
      <h2>🎓 Course Details</h2>
      <ul>
        {courses.map(course => (
          <li key={course.id}>
            {course.name} — {course.duration}
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

export default CourseDetails;
