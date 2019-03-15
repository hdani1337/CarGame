package hu.hdani1337.cargame.Button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.hdani1337.cargame.Stage.HomeStage;
import hu.hdani1337.cargame.Stage.OptionsStage;

public class Mute extends OneSpriteStaticActor {
    public Mute() {
        super(Assets.manager.get(Assets.MUTE_TEXTURE));
        setDebug(false);
        setSize(200,200);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                OptionsStage.ifMuted = 1;
                HomeStage.bgMusic.stop();
            }
        });
    }
}
