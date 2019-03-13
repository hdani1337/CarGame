package hu.hdani1337.cargame.Button;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Play extends OneSpriteStaticActor {
    public Play() {
        super(Assets.manager.get(Assets.CONTINUE_TEXTURE));
        setDebug(false);
        setSize(200,200);
    }
}
