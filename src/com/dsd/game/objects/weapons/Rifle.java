package com.dsd.game.objects.weapons;

import com.dsd.game.Game;
import com.dsd.game.objects.BulletGameObject;
import com.dsd.game.objects.Player;
import com.dsd.game.util.Utilities;
import com.revivedstandards.controller.StandardAnimatorController;
import com.revivedstandards.handlers.StandardCollisionHandler;
import com.revivedstandards.model.StandardAnimation;

/**
 * This class is a subclass of Gun; it's an automatic rifle.
 *
 * @author Joshua
 */
public class Rifle extends Gun {
    
    private static final int walkingFPS = 10;
    private static final int shootGunFPS = 20;

    private final int delay = 100;

    public Rifle (Game _game, Player _player, StandardCollisionHandler _sch) {
        super("rifle", 31, _game, _player, _sch);

        //  Instantiates the animation controllers
        StandardAnimatorController walkingAnimation = new StandardAnimatorController(
                new StandardAnimation(_player, Utilities.loadFrames("src/res/img/player/player_walk_rifle/", 6), walkingFPS));

        StandardAnimatorController shootingAnimation = new StandardAnimatorController(
                new StandardAnimation(_player, Utilities.loadFrames("src/res/img/player/player_shoot_rifle/", 4), shootGunFPS));

        super.setWalkFrames(walkingAnimation);
        super.setAttackFrames(shootingAnimation);
        super.setDelay(delay);

    }

    @Override
    public void shoot () {
        this.addBullet();
        super.deductAmmo();
    }

    /**
     * Adds a bullet to the global handler.
     */
    private void addBullet () {
        super.getHandler().addEntity(new BulletGameObject(
                (int) super.getPlayer().getX() + super.getPlayer().getWidth() / 2,
                (int) super.getPlayer().getY() + super.getPlayer().getHeight() / 2,
                super.getPlayer().getAngle(), super.getGame(), super.getHandler(),
                super.getPlayer().getCamera(), super.getPlayer()));
    }
}