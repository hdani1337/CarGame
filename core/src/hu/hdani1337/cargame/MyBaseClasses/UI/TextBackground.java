package hu.hdani1337.cargame.MyBaseClasses.UI;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class TextBackground extends OneSpriteStaticActor {
    public TextBackground(float width, float height) {
        super(Assets.manager.get(Assets.SZOVEG_HATTER));
        setDebug(false);
        setWidth(width);
        setHeight(height);
    }
}
