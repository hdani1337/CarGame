package hu.hdani1337.cargame.Button;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Exit extends OneSpriteStaticActor {
    public Exit() {
        super(Assets.manager.get(Assets.EXIT_TEXTURE));
        setDebug(false);
        setSize(200,200);
    }
}
