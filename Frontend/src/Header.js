import React from 'react';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';
import loginForm from "./LoginForm"

function Header() {

  return (

      <Link  className="login-btn" to="/login">Login</Link>

  );
}

export default Header
