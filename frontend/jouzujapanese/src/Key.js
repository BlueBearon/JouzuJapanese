/**
 * @fileoverview This file defines the Key component. This component is a single key on the keyboard. When pressed, the button will call the parent's updateUserInput function
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */

import React, { useState } from 'react';

/**
 * A single key on the keyboard. When pressed, the button will call the parent's updateUserInput function
 * @param {*} props: roma: the className of the button on the keyboard, updateUserInput: the function called when the button is pressed, kana: the kana displayed on the button
 * @returns A single key on the keyboard
 */
function Key(props) {

    const [pressed, setPressed] = React.useState(false);//Manages whether the button is pressed or not, false: not pressed, true: pressed

    var css = "kanaButton" + (pressed ? " pressed" : "");//Determines the css class of the button, if pressed, the button will be highlighted

    /**
     * Called when the button is pressed
     */
    function keyboardPress() {
        // Toggle the pressed state of the button

        if(!pressed)//If the button is not pressed, call the parent's updateUserInput function
        {
            var valid = props.updateUserInput(props.kana);//check if the button press was valid, if it was, set the button to pressed
            if(valid)
            {
                setPressed(true);
            }
        }

    }

    return(//Props.roma determines location in grid layout, css var determines if button is pressed, keyboardPress() is the function called when the button is pressed, props.kana is the kana displayed on the button
       <div className={props.roma}><button className={css} onClick={() => keyboardPress()}>{props.kana}</button></div>
    );

}

export default Key;