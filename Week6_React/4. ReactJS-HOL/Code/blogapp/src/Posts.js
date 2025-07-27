// src/Posts.js
import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
    };
  }

  componentDidMount() {
    this.loadPosts();
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((res) => res.json())
      .then((data) => {
        const postsList = data.map(
          (item) => new Post(item.userId, item.id, item.title, item.body)
        );
        this.setState({ posts: postsList });
      })
      .catch((error) => {
        this.setState({ hasError: true });
        alert('Error loading posts: ' + error.message);
      });
  }

  componentDidCatch(error, info) {
    this.setState({ hasError: true });
    alert('A rendering error occurred: ' + error);
  }

  render() {
    if (this.state.hasError) {
      return <h2>Something went wrong.</h2>;
    }

    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.map((post) => (
          <div key={post.id}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
            <hr />
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
