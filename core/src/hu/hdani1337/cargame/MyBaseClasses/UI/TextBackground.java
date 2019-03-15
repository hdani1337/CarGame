package hu.hdani1337.cargame.MyBaseClasses.UI;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class TextBackground extends OneSpriteStaticActor {
    private static float valami1;
    private static float valami2;

    public TextBackground(float width, float height) {
        super(Assets.manager.get(Assets.SZOVEG_HATTER));
        setDebug(false);
        valami1 = width;
        valami2 = height;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setWidth(valami1);
        setHeight(valami2);
    }
}
