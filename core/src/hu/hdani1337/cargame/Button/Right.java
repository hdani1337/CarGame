package hu.hdani1337.cargame.Button;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Right extends OneSpriteStaticActor {
    public Right() {
        super(Assets.manager.get(Assets.RIGHT_ARROW));
        setDebug(false);
        setSize(200,200);
    }
}
