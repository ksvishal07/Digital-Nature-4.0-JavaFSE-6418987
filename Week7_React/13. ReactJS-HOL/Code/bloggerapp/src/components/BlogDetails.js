import React from 'react';

const BlogDetails = () => {
  const blogs = [
    { id: 1, title: 'React Basics', date: '2023-01-01' },
    { id: 2, title: 'State vs Props', date: '2023-02-15' },
    { id: 3, title: 'JSX Tricks', date: '2023-03-20' }
  ];

  return (
    <div style={styles.container}>
      <h2>📝 Blog Details</h2>
      <ul>
        {blogs.map(blog => (
          <li key={blog.id}>
            {blog.title} — <em>{blog.date}</em>
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

export default BlogDetails;
