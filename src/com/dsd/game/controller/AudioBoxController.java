package com.dsd.game.controller;

import com.revivedstandards.controller.StandardAudioController;
import com.revivedstandards.model.StandardAudioType;

/**
 * This class loads all necessary sfx for the game.
 *
 * [Group Name: Data Structure Deadheads]
 *
 * @author Joshua, Ronald, Rinty
 *
 * @updated 11/12/19
 */
public abstract class AudioBoxController {

    /**
     * Instantiates the amount of buffers that the controller should hold, along
     * with the tracks that are used in the game.
     *
     * @param _buffers
     */
    public static void initialize(int _buffers) {
        StandardAudioController.init(_buffers);
        StandardAudioController.load("src/resources/audio/music/menu.mp3", 1, StandardAudioType.MUSIC);
        StandardAudioController.load("src/resources/audio/music/level0.mp3", 1, StandardAudioType.MUSIC);
        StandardAudioController.load("src/resources/audio/sfx/pistol.wav", 16, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/splat1.wav", 2, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/splat2.wav", 2, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/empty.wav", 1, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/reload.wav", 1, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/knife.wav", 3, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/shotgun.wav", 4, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/grenade_launcher.wav", 2, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/grenade_explosion.wav", 4, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/minigun.wav", 64, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/rifle.wav", 32, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/fast_rifle.wav", 32, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/coin0.wav", 12, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/round_change.wav", 1, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/restore_health.wav", 4, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/berserk.wav", 2, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/menuselect.wav", 5, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/thunder0.wav", 2, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/thunder1.wav", 2, StandardAudioType.SFX);
        StandardAudioController.load("src/resources/audio/sfx/thunder2.wav", 2, StandardAudioType.SFX);
        AudioBoxController.initBasicMonsterSFX(5);
        AudioBoxController.initGreenMonsterSFX(5);
    }

    /**
     * Initializes the basic monster sfx (these monsters have their own
     * dedicated sfx).
     *
     * @param _sfxCount
     */
    private static void initBasicMonsterSFX(int _sfxCount) {
        for (int i = 1; i < _sfxCount; i++) {
            StandardAudioController.load("src/resources/audio/sfx/basic_monster/zombie-" + i + ".wav", 4, StandardAudioType.SFX);
        }
    }

    /**
     * Initializes the green monster sfx (these monsters have their own
     * dedicated sfx).
     *
     * @param _sfxCount
     */
    private static void initGreenMonsterSFX(int _sfxCount) {
        for (int i = 1; i < _sfxCount; i++) {
            StandardAudioController.load("src/resources/audio/sfx/green_monster/pain" + i + ".wav", 4, StandardAudioType.SFX);
        }
    }
}
