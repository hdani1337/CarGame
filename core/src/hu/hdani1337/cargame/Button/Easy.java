package hu.hdani1337.cargame.Button;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Easy extends OneSpriteStaticActor {
    public Easy() {
        super(Assets.manager.get(Assets.EASY_TEXTURE));
        setDebug(false);
        setSize(180,180);
    }
}
