package com.dsd.game.userinterface;

import com.dsd.game.core.Game;
import com.dsd.game.userinterface.model.buttons.HelpBackButton;
import com.dsd.game.userinterface.model.labels.ControlsLabel;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * This class defines the screen for the Help elements.
 *
 * [Group Name: Data Structure Deadheads]
 * 
 * @author Joshua
 * 
 * @updated 12/10/19
 */
public class HelpScreen extends Screen {

    private final Color transparentBlack = new Color(0f, 0f, 0f, 0.5f);

    public HelpScreen(Game _game) {
        super(_game);
        this.createUIElements();
    }

    @Override
    public void tick() {
        if (!this.getGame().isHelp()) {
            return;
        }
        super.tick();
    }

    @Override
    public void render(Graphics2D _g2) {
        if (!this.getGame().isHelp()) {
            return;
        }
        this.drawTransparentScreen(_g2);
        super.render(_g2);
    }

    /**
     * Draws the black transparent screen as an overlay.
     *
     * @param _g2
     */
    private void drawTransparentScreen(Graphics2D _g2) {
        Color oldColor = _g2.getColor();
        _g2.setColor(this.transparentBlack);
        _g2.fillRect((int) (this.getGame().getCamera().getX() - Screen.gameHalfWidth),
                (int) (this.getGame().getCamera().getY() - Screen.gameHalfHeight),
                (int) (this.getGame().getCamera().getX() + Screen.gameDoubleWidth),
                (int) (this.getGame().getCamera().getY() + Screen.gameDoubleHeight));
        _g2.setColor(oldColor);
    }

    private void createUIElements() {
        super.addInteractor(new ControlsLabel(this.getGame()));
        super.addInteractor(new HelpBackButton(this.getGame(), null));
    }

}
