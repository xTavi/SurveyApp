import React from 'react';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';
import loginForm from "./LoginForm"

function Header() {

  return (
    <Router>
      <Link  className="login-btn" to="/loginForm">Login</Link>
      <Switch>
        <Route exact path="/loginForm" component={loginForm}></Route>
      </Switch>
    </Router>

  );
}

export default Header