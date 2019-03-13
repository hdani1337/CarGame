package hu.hdani1337.cargame.Actor;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class DemoCar extends OneSpriteStaticActor {
    public DemoCar() {
        super(Assets.manager.get(Assets.CAR1_TEXTURE));
    }
}
