package com.dsd.game.objects;

import com.dsd.game.core.Game;
import com.revivedstandards.handlers.StandardCollisionHandler;
import com.revivedstandards.model.StandardGameObject;
import com.revivedstandards.model.StandardID;

/**
 * Abstract class representing an entity that belongs to a standard collision
 * handler, and has health.
 *
 * [Group Name: Data Structure Deadheads]
 *
 * @author Joshua, Ronald, Rinty
 *
 * @updated 11/12/19
 */
public abstract class Entity extends StandardGameObject {

    //  Miscellaneous reference variables.
    private final Game game;
    private StandardCollisionHandler parentContainer;
    /**
     * For entities that follow another entity, this is the factor that should
     * be applied when detecting the angle to turn towards.
     */
    public static final int APPROACH_FACTOR = 8;
    //  Health of entity.
    private double health = 0;

    public Entity(int _x, int _y, int _health, StandardID _id, Game _game, StandardCollisionHandler _parentContainer) {
        super(_x, _y, _id);
        this.game = _game;
        this.parentContainer = _parentContainer;
        this.health = _health;
    }

//=================================== GETTERS =================================
    public Game getGame() {
        return this.game;
    }

    public StandardCollisionHandler getHandler() {
        return this.parentContainer;
    }

    public double getHealth() {
        return this.health;
    }

    public boolean isMoving() {
        return this.getVelX() != 0 && this.getVelY() != 0;
    }

//================================ SETTERS =============================
    public void setHealth(double _health) {
        this.health = _health;
    }

    public void setHandler(StandardCollisionHandler _sch) {
        this.parentContainer = _sch;
    }
    
}
