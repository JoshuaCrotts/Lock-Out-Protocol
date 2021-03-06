package com.dsd.game.userinterface.model.buttons;

import com.dsd.game.core.Game;
import com.dsd.game.objects.ResolutionEnum;
import com.dsd.game.commands.DecreaseResolutionCommand;
import com.dsd.game.commands.IncreaseResolutionCommand;
import com.dsd.game.controller.LanguageController;
import com.dsd.game.userinterface.MenuScreen;
import com.dsd.game.userinterface.MouseEventInterface;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 * This class can be used in a multitude of ways; for now, it will be used for
 * verifying changes in the sub-options menu.
 *
 * [Group Name: Data Structure Deadheads]
 *
 * @author Joshua, Ronald, Rinty
 *
 * @updated 11/19/19
 */
public class SaveResolutionChangesButton extends MenuButton implements MouseEventInterface {

    //  Miscellaneous reference variables.
    private final MenuScreen menuScreen;
    private final IncreaseResolutionCommand incResCommand;
    private final DecreaseResolutionCommand decResCommand;

    //  Positioning offsets for the button and the text.
    private static final int BUTTON_X_OFFSET = 0;
    private static final int BUTTON_Y_OFFSET = 120;
    private static final int TEXT_X_OFFSET = 60;
    private static final int TEXT_Y_OFFSET = 45;

    public SaveResolutionChangesButton(Game _game, MenuScreen _menuScreen) {
        super(BUTTON_X_OFFSET, _game.getGameHeight() - BUTTON_Y_OFFSET,
                LanguageController.translate("SAVE CHANGES"), _game, _menuScreen);
        this.menuScreen = _menuScreen;
        this.incResCommand = new IncreaseResolutionCommand(this.getGame());
        this.decResCommand = new DecreaseResolutionCommand(this.getGame());
    }

    @Override
    public void tick() {
        this.setX(BUTTON_X_OFFSET);
        this.setY(this.getGame().getGameHeight() - BUTTON_Y_OFFSET);
    }

    @Override
    public void render(Graphics2D _g2) {
        if (!this.getGame().isMenu() || !(this.getMenuScreen().isOnResolution())) {
            return;
        }
        super.render(_g2);
        _g2.setFont(this.font);
        _g2.setColor(Color.WHITE);
        _g2.drawString(this.getText(), this.getX() + TEXT_X_OFFSET, this.getY() + TEXT_Y_OFFSET);
    }

    @Override
    public void onMouseClick() {
        if (!this.getGame().isMenu() || !(this.getMenuScreen().isOnResolution())) {
            return;
        }
        super.onMouseClick();
        //  Once the user presses the save changes button, it will update the game's resolution.
        Dimension changedDimension = ResolutionEnum.getDimension();
        this.getGame().changeResolution((int) changedDimension.getWidth(), (int) changedDimension.getHeight());
        this.getGame().saveToSettings();
    }

    @Override
    public void onMouseEnterHover() {
        if (!this.getGame().isMenu() || !(this.getMenuScreen().isOnResolution())) {
            return;
        }
        this.activeImage = this.onHoverButtonImg;
    }

    @Override
    public void onMouseExitHover() {
        if (!this.getGame().isMenu() || !(this.getMenuScreen().isOnResolution())) {
            return;
        }
        this.activeImage = this.buttonImg;
    }

}
