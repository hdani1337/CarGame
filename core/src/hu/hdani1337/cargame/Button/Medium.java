package hu.hdani1337.cargame.Button;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Medium extends OneSpriteStaticActor {
    public Medium() {
        super(Assets.manager.get(Assets.MED_TEXTURE));
        setDebug(false);
        setSize(180,180);
    }
}
