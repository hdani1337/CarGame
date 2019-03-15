package hu.hdani1337.cargame.Stage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.hdani1337.cargame.Actor.Background;
import hu.hdani1337.cargame.Button.Back;
import hu.hdani1337.cargame.Button.CarChoose;
import hu.hdani1337.cargame.Button.ControlFlip;
import hu.hdani1337.cargame.Button.ControlTouch;
import hu.hdani1337.cargame.Button.Mute;
import hu.hdani1337.cargame.Button.Unmute;
import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.Screen.ChoosingScreen;
import hu.hdani1337.cargame.Screen.HomeScreen;

public class OptionsStage extends MyStage {
    Background background;
    ControlFlip controlFlip;
    ControlTouch controlTouch;
    CarChoose carChoose;
    Mute mute;
    Unmute unmute;
    Back back;

    public static byte controlType;
    public static byte ifMuted;

    public OptionsStage(Viewport viewport, Batch batch, final CarGame game) {
        super(viewport, batch, game);

        ifMuted = 0;

        background = new Background(false);
        back = new Back();
        controlFlip = new ControlFlip();
        controlTouch = new ControlTouch();
        carChoose = new CarChoose();
        mute = new Mute();
        unmute = new Unmute();

        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new HomeScreen(game));
            }
        });

        controlFlip.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                controlType = 0;
            }
        });

        controlTouch.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                controlType = 1;
            }
        });

        carChoose.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new ChoosingScreen(game));
            }
        });

        back.setPosition(865, 100);
        controlFlip.setPosition(225,370);
        controlTouch.setPosition(430,370);
        carChoose.setPosition(640,370);
        unmute.setPosition(430,150);
        mute.setPosition(225,150);

        addActor(background);
        addActor(back);
        addActor(controlFlip);
        addActor(controlTouch);
        addActor(carChoose);
        addActor(mute);
        addActor(unmute);
    }

    @Override
    public void init() {

    }
}
