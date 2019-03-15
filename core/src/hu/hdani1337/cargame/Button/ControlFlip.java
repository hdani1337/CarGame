package hu.hdani1337.cargame.Button;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class ControlFlip extends OneSpriteStaticActor {
    public ControlFlip() {
        super(Assets.manager.get(Assets.CONTROLF_TEXTURE));
        setDebug(false);
        setSize(200,200);
    }
}
