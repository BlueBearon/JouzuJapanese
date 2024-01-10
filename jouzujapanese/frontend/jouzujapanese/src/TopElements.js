import React from "react";


function TopElements(props)
{
    var percent = props.questions === 0 ? 0 : props.correct/props.questions;

    return (
        <div id = "topElements" className = "topElements">

            <div id = "topButtons" className = "topButtons">
                <button id = "optionsButton" className = "topButton" onClick = {() => props.openOptions()}>Options</button>
            </div>

            <div id = "score" className = "score">
                <div id = "outOf" className = "outOf">{props.correct}/{props.questions}</div>
                <div id = "percentage" className = "percentage">{Math.round(percent * 100)}%</div>
            </div>
        </div>
        
    );
}

export default TopElements;