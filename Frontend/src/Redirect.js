import React from 'react';
import { BrowserRouter as Router, Route, Switch,Link, Redirecr} from 'react-router-dom'; 
import loginForm from"./LoginForm"

class Redirect extends Component
{
    render()
    {
        return
        (
            <Router>
                <Switch>
                    <Route exact path = "/loginForm" component={loginForm}></Route>
                </Switch>
            </Router>
        )
    }
}