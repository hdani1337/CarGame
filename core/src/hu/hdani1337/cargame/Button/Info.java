package hu.hdani1337.cargame.Button;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Info extends OneSpriteStaticActor {
    public Info() {
        super(Assets.manager.get(Assets.INFO_TEXTURE));
        setDebug(false);
        setSize(200,200);
    }
}
