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

class App extends React.Component {

    render() {
        return (
            <Router>
                <div>  
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

export default App
