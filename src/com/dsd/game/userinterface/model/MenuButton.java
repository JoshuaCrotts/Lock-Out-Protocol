package com.dsd.game.userinterface.model;

import com.dsd.game.Game;
import com.dsd.game.userinterface.MenuScreen;
import com.dsd.game.userinterface.MouseEventInterface;
import com.revivedstandards.util.StdOps;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Joshua
 */
public abstract class MenuButton extends StandardButton implements MouseEventInterface {

    private final Game game;
    private final MenuScreen menuScreen;

    protected final Font font;
    protected BufferedImage onHoverButtonImg;
    protected BufferedImage buttonImg;
    protected BufferedImage activeImage;

    public MenuButton (int _x, int _y, int _width, int _height, String _text, Game _game, MenuScreen _menuScreen) {
        this.game = _game;
        this.menuScreen = _menuScreen;
        this.font = StdOps.initFont("src/resources/fonts/chargen.ttf", 24f);
        this.setX(_x);
        this.setY(_y);
        this.setWidth(_width);
        this.setHeight(_height);
        this.setText(_text);

        this.initializeButtonImages();
    }

    @Override
    public void render (Graphics2D _g2) {
        _g2.drawImage(activeImage, (int) (this.getX()),
                (int) (this.getY()), this.getWidth(), this.getHeight(), game);
    }

    private void initializeButtonImages () {
        buttonImg = StdOps.loadImage("src/resources/img/ui/buttonStock1.png");
        onHoverButtonImg = StdOps.loadImage("src/resources/img/ui/buttonStock1h.png");
    }

    public Game getGame () {
        return this.game;
    }

    public MenuScreen getMenuScreen () {
        return this.menuScreen;
    }
}