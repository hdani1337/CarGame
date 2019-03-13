package hu.hdani1337.cargame.Button;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Pause extends OneSpriteStaticActor {
    public Pause() {
        super(Assets.manager.get(Assets.PAUSE_TEXTURE));
        setDebug(false);
        setSize(200,200);
    }
}
