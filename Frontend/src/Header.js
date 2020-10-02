import React from 'react';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';
import loginForm from "./LoginForm"

function Header() {

  return (
    <header>
      <nav>
          <Link className="nav-op" to="/login">Home</Link>
          <Link className="nav-op" to="/login">About Us</Link>
          <Link className="nav-op" to="/login">Contact Us</Link>
          <Link className="nav-op btn" to="/login" >Login </Link>
          <span className="nav-op btn" >|</span>
          <Link className="nav-op btn" to="/login" >Sign Up </Link>          
      </nav>
      <h1 id="Title">Survey App</h1>
    </header>
  );
}
export default Header
