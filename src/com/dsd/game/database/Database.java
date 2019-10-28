package com.dsd.game.database;

/**
 *
 * This class acts as the barebones template of any persistent database this
 * program uses.
 *
 * @author Joshua
 */
public interface Database {

    public boolean save ();

    public boolean load ();
}