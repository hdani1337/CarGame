package hu.hdani1337.cargame.Actor;

import com.badlogic.gdx.graphics.Texture;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Block extends OneSpriteStaticActor {
    public Block(Texture texture) {
        super(texture);
        setDebug(false);
        addBaseCollisionRectangleShape();
        setSize(150,150);
    }

    @Override
    public void act(float delta) {
        if (getY() + getHeight() < 0) {
            setY(2000);
        }

    }
}
