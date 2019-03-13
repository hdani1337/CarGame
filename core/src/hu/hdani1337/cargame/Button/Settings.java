package hu.hdani1337.cargame.Button;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Settings extends OneSpriteStaticActor {
    public Settings() {
        super(Assets.manager.get(Assets.SETTINGS_TEXTURE));
        setDebug(false);
        setSize(200,200);
    }
}
