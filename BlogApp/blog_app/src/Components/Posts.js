import React, { Component } from "react";
import Post from "./Post";
class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
    };
  }

  loadPosts() {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((res) => res.json())
      .then((data) => {
        const postsList = data.map((p) => new Post(p.id, p.title, p.body));
        this.setState({ posts: postsList });
      })
      .catch((err) => {
        alert("Error fetching posts:", err.message);
      });
  }

  componentDidMount(){
    this.loadPosts();
  }
  
  render(){
    return (
      <div>
        <h2>Blog Posts</h2>
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

  componentDidCatch(error, info) {
    alert("An error occurred: " + error.toString());
  }
}

export default Posts;
