package hu.hdani1337.cargame.Button;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class CarChoose extends OneSpriteStaticActor {
    public CarChoose() {
        super(Assets.manager.get(Assets.CAR_CHOOSE));
        setDebug(false);
        setSize(200,200);
    }
}
