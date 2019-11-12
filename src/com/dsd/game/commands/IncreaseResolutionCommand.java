package com.dsd.game.commands;

import com.dsd.game.core.Game;
import com.dsd.game.objects.ResolutionEnum;
import com.revivedstandards.commands.Command;
import java.awt.event.KeyEvent;

/**
 * Command representing when the user presses the left arrow to increase the
 * game's screen resolution.
 *
 * [Group Name: Data Structure Deadheads]
 *
 * @author Joshua, Ronald, Rinty
 */
public class IncreaseResolutionCommand extends Command {

    private final Game game;

    public IncreaseResolutionCommand (Game _game) {
        this.game = _game;
        this.bind(this.game.getKeyboard(), KeyEvent.VK_RIGHT);
    }

    @Override
    public void pressed (float _dt) {
        if (!this.game.isMenu() || !this.game.getMenuScreen().isOnResolution()) {
            return;
        }
        ResolutionEnum.increaseResolution();
    }
}
