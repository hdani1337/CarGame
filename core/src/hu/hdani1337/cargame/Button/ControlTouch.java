package hu.hdani1337.cargame.Button;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class ControlTouch extends OneSpriteStaticActor {
    public ControlTouch() {
        super(Assets.manager.get(Assets.CONTROLT_TEXTURE));
        setDebug(false);
        setSize(200,200);
    }
}
