package hu.hdani1337.cargame.Actor;

import com.badlogic.gdx.Gdx;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Background extends OneSpriteStaticActor {
    public Background(boolean mozog) {
        super(Assets.manager.get(Assets.HATTER_TEXTURE));
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setDebug(false);
        setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }
}
