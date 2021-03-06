package com.dsd.game.commands;

import com.dsd.game.core.Game;
import com.dsd.game.userinterface.model.TextFieldModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class will be used for user input when asking for their username and
 * password. We wrote a custom text input field instead of using the lousy Java
 * Swing ones.
 *
 * [Group Name: Data Structure Deadheads]
 *
 * @author Joshua, Ronald, Rinty Last Updated: 12/10/2019
 */
public class LetterInputListener implements KeyListener {

    // Miscellaneous reference variables.
    private final Game game;
    private final TextFieldModel textElement;

    // Last inputted char by the user.
    private char character;

    public LetterInputListener(Game _game, TextFieldModel _textElement) {
        this.game = _game;
        this.game.addKeyListener(this);
        this.textElement = _textElement;
    }

    @Override
    public void keyTyped(KeyEvent _e) {
        if (!this.textElement.isActive() || !this.game.isMenu()) {
            return;
        }
        //  Retrieve the char last typed.
        this.character = _e.getKeyChar();
        if (this.isValidTypedChar(this.character)) {
            //  If it's the backspace key, delete the last inserted character into
            //  the stringbuilder. Otherwise, just append it.
            switch (this.character) {
                case KeyEvent.VK_BACK_SPACE:
                    if (!this.textElement.isEmpty()) {
                        textElement.removeLastChar();
                    }
                    break;
                default:
                    textElement.appendToString(this.character);
                    break;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent _e) {
    }

    @Override
    public void keyReleased(KeyEvent _e) {
    }

    /**
     * If a character matches the specified criteria, it returns true. False
     * otherwise.
     *
     * @param _char
     * @return true or false
     */
    private boolean isValidTypedChar(char _char) {
        return _char != KeyEvent.VK_TAB && _char != KeyEvent.VK_ENTER;
    }

//============================== GETTERS =====================================
    public char getLastKeyTyped() {
        // Returns last characters.
        return this.character;
    }

    public String getTextElement() {
        return this.textElement.toString();
    }

}
