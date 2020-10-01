import React from "react"
import Header from "./Header"
import Main from "./Main"
import LoginForm from "./LoginForm"
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";

// import Footer from "./Footer"
class App extends React.Component {
    // constructor() {
    //     super()

    // }

    render() {
        return (
            <Router>
                <div>  
                  <nav>
                      <ul>
                        
                              <Link to="/" className="login-btn"> Home </Link>
                          

                        
                              <Link to="/login" className="login-btn"> Login </Link>
                          
                      </ul>
                  </nav>

                    <Switch>
                        <Route path="/login">
                            <LoginForm/>
                        </Route>

                        <Route path="/">
                            <Header/>
                            <Main/>
                        </Route>
                    </Switch>
                </div>
            </Router>


        )
    }
}

function Login() {
    return <h2>Ceva</h2>
}
export default App
