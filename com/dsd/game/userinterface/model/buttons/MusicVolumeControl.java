package com.dsd.game.userinterface.model.buttons;

import com.dsd.game.core.Game;
import com.dsd.game.userinterface.MenuScreen;
import com.dsd.game.userinterface.Screen;
import com.dsd.game.userinterface.model.Interactor;
import com.dsd.game.userinterface.model.labels.MusicLabel;
import com.revivedstandards.controller.StandardAudioController;
import com.revivedstandards.model.StandardAudioType;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * This class is the music volume control for the... as you guessed, music audio
 * tracks.
 *
 * [Group Name: Data Structure Deadheads]
 *
 * @author Joshua, Ronald, Rinty
 *
 * @updated 11/19/19
 */
public class MusicVolumeControl extends Interactor {

    //  Miscellaneous reference variables.
    private final Game game;
    private final MenuScreen menuScreen;
    private Rectangle[] volumeBars;

    //  Buttons to increase/decrease the sfx volume.
    private final IncreaseVolumeButton incVolumeButton;
    private final DecreaseVolumeButton decVolumeButton;
    private final MusicLabel volumeControlLabel;

    //  Music Button position offsets.
    private static final int BUTTON_X_OFFSET = 200;
    private static final int BUTTON_Y_OFFSET = -200;

    //  Default volume.
    private static float volume = 1.0f;

    public MusicVolumeControl(Game _game, MenuScreen _menuScreen) {
        super(0, 0, 0, 0);
        this.game = _game;
        this.menuScreen = _menuScreen;
        this.incVolumeButton = new IncreaseVolumeButton(_game, _menuScreen, this,
                MusicVolumeControl.BUTTON_X_OFFSET, MusicVolumeControl.BUTTON_Y_OFFSET);
        this.decVolumeButton = new DecreaseVolumeButton(_game, _menuScreen, this,
                MusicVolumeControl.BUTTON_X_OFFSET, MusicVolumeControl.BUTTON_Y_OFFSET);
        this.volumeControlLabel = new MusicLabel(this, this.menuScreen);
        this.menuScreen.addInteractor(this.incVolumeButton);
        this.menuScreen.addInteractor(this.decVolumeButton);
        this.menuScreen.addInteractor(this.volumeControlLabel);
        this.initializeVolumeBars();
    }

    @Override
    public void tick() {
        if (!this.game.isMenu() || !this.menuScreen.isOnVolume()) {
            return;
        }
        this.initializeVolumeBars();
    }

    @Override
    public void render(Graphics2D _g2) {
        if (!this.game.isMenu() || !this.menuScreen.isOnVolume()) {
            return;
        }
        this.renderVolumeBars(_g2);
    }

    @Override
    public void onMouseClick() {
        //  No mouse logic.

    }

    @Override
    public void onMouseEnterHover() {
        //  No mouse logic.

    }

    @Override
    public void onMouseExitHover() {
        //  No mouse logic.

    }

    /**
     * Increments the volume of the music by a factor of 10%. If we are already
     * at the max volume, we just quit.
     */
    public void incrementVolume() {
        if (MusicVolumeControl.volume == IncreaseVolumeButton.MAX_VOLUME) {
            return;
        }
        MusicVolumeControl.volume += 0.1;
        StandardAudioController.setVolumeOfTracks(MusicVolumeControl.volume, StandardAudioType.MUSIC);
    }

    /**
     * Decrements the volume of the music by a factor of 10%. If we are already
     * at the max volume, we just quit.
     */
    public void decrementVolume() {
        if (MusicVolumeControl.volume < 0.1) {
            StandardAudioController.setVolumeOfTracks(0, StandardAudioType.MUSIC);
        } else {
            MusicVolumeControl.volume -= 0.1;
            StandardAudioController.setVolumeOfTracks(MusicVolumeControl.volume, StandardAudioType.MUSIC);
        }
    }

    /**
     * Instantiates the ten bars of music volume.
     */
    private void initializeVolumeBars() {
        this.volumeBars = new Rectangle[10];
        for (int i = 0, xOffset = -120; i < this.volumeBars.length; i++, xOffset += 30) {
            this.volumeBars[i] = new Rectangle(Screen.gameHalfWidth + xOffset, Screen.gameHalfHeight - 200, 20, 60);
        }
    }

    /**
     * Colors in the bars of music that are "filled". Each filled bar represents
     * 0.1 of "volume" so to speak.
     *
     * @param _g2
     */
    private void renderVolumeBars(Graphics2D _g2) {
        _g2.setColor(Color.RED);
        for (int i = 0; i < this.volumeBars.length; i++) {
            if (((i + 1)) <= Math.round(volume * 10)) {
                _g2.fill(this.volumeBars[i]);
            } else {
                _g2.draw(this.volumeBars[i]);
            }
        }
    }

//============================== GETTERS =====================================//
    public int getLeftButtonX() {
        return this.decVolumeButton.getX();
    }

    public int getLeftButtonY() {
        return this.decVolumeButton.getY();
    }

}
