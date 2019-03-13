package hu.hdani1337.cargame.Button;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Hard extends OneSpriteStaticActor {
    public Hard() {
        super(Assets.manager.get(Assets.HARD_TEXTURE));
        setDebug(false);
        setSize(180,180);
    }
}
