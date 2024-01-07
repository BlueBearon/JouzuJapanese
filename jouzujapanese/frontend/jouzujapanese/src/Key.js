import React, { useState } from 'react';

function Key(props) {

    const [pressed, setPressed] = React.useState(false);

    var css = "kanaButton" + (pressed ? " pressed" : "");

    function keyboardPress() {
        // Toggle the pressed state of the button

        if(!pressed)
        {
            var valid = props.updateUserInput(props.kana);
            if(valid)
            {
                setPressed(true);
            }
        }

    }

    return(
       <div className={props.roma}><button className={css} onClick={() => keyboardPress()}>{props.kana}</button></div>
    );

}

export default Key;