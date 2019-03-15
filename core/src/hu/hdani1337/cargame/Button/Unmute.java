package hu.hdani1337.cargame.Button;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.hdani1337.cargame.Stage.OptionsStage;

public class Unmute extends OneSpriteStaticActor {
    public Unmute() {
        super(Assets.manager.get(Assets.UNMUTE_TEXTURE));
        setDebug(false);
        setSize(200,200);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                OptionsStage.ifMuted = 0;
            }
        });
    }
}
