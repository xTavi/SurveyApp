import React from "react"
import  ReactDOM from "react-dom"


function Form()
{ 
    return(
        <div className="login" >
            <h1  id ="loginTitle">SurveyApp</h1>
            <input type="text" placeholder="EMAIL" className="Input"></input>
            <br></br> <br></br>
            <input type="text" placeholder="PASSWORD" className="Input"></input> <br></br> <br></br>
            <button id="loginButton" >LOGIN</button> <br></br> <br></br>
            
            <a href="#" id="forgetPsw">Forgot password?</a>
    

     
        </div>


    )
}
export default Form