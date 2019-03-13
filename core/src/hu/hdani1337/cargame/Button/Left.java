package hu.hdani1337.cargame.Button;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Left extends OneSpriteStaticActor {
    public Left() {
        super(Assets.manager.get(Assets.LEFT_ARROW));
        setDebug(false);
        setSize(200,200);
    }
}
