package com.dsd.game.objects.weapons;

import com.dsd.game.core.Game;
import com.dsd.game.objects.Player;
import com.dsd.game.objects.weapons.enums.WeaponType;
import com.dsd.game.objects.weapons.projectiles.BulletGameObject;
import com.dsd.game.util.Utilities;
import com.revivedstandards.controller.StandardAnimatorController;
import com.revivedstandards.handlers.StandardCollisionHandler;
import com.revivedstandards.model.StandardAnimation;

/**
 * This class is a subclass of Gun; it acts as a standard pistol.
 *
 * [Group Name: Data Structure Deadheads]
 *
 * @author Joshua, Ronald, Rinty
 *
 * @updated 12/7/19
 */
public class Pistol extends Gun {

    //  Information regarding the FPS of the pistol animations for the player.
    private static final int WALKING_FPS = 10;
    private static final int SHOOT_GUN_FPS = 20;

    //  How many of each animation we have for this gun.
    private static final int WALKING_FRAMES = 6;
    private static final int SHOOTING_FRAMES = 4;

    //  Delay between shots.
    private static final int DELAY = 750;

    //  Delay between reloading and firing the first bullet afterwards.
    private static final long RELOAD_DELAY = 2000;

    //  Damage from the pistol.
    private static final int BULLET_DAMAGE = 40;

    //  Amount of casing image frames for this gun.
    private static final int CASING_IMAGES = 14;
    private static final int INITIAL_AMMO = 16;

    public Pistol(Game _game, Player _player, StandardCollisionHandler _sch) {
        super(WeaponType.PISTOL, INITIAL_AMMO, _game, _player, _sch, "src/resources/audio/sfx/pistol_reload.wav", RELOAD_DELAY);
        //  Instantiates the animation controllers
        this.loadAssets(_player);
        super.setDelay(Pistol.DELAY);
        super.loadCasingImages(Pistol.CASING_IMAGES);
    }

    @Override
    public void shoot() {
        this.addBullet();
        super.deductAmmo();
    }

    /**
     * Adds a bullet to the global handler.
     */
    private void addBullet() {
        super.getHandler().addEntity(new BulletGameObject(
                (int) super.getPlayer().getX() + super.getPlayer().getWidth() / 2,
                (int) super.getPlayer().getY() + super.getPlayer().getHeight() / 2,
                super.getPlayer().getAngle(), BULLET_DAMAGE * this.getDamageFactor(),
                super.getGame(), super.getHandler(), super.getPlayer()));
    }

    @Override
    public void loadAssets(Player _player) {
        //  Instantiates the animation controllers.
        StandardAnimatorController walkingAnimation = new StandardAnimatorController(
                new StandardAnimation(_player, Utilities.loadFrames("src/resources/img/player/player_"
                        + _player.getPlayerSex() + "/player_walk_gun/", WALKING_FRAMES), WALKING_FPS));

        StandardAnimatorController shootingAnimation = new StandardAnimatorController(
                new StandardAnimation(_player, Utilities.loadFrames("src/resources/img/player/player_"
                        + _player.getPlayerSex() + "/player_shoot_gun/", SHOOTING_FRAMES), SHOOT_GUN_FPS));
        super.setWalkFrames(walkingAnimation);
        super.setAttackFrames(shootingAnimation);
    }
}
