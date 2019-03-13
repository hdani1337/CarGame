package hu.hdani1337.cargame.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.hdani1337.cargame.Actor.Background;
import hu.hdani1337.cargame.Button.Exit;
import hu.hdani1337.cargame.Button.Info;
import hu.hdani1337.cargame.Button.Play;
import hu.hdani1337.cargame.Button.Settings;
import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.Screen.DifficultyScreen;
import hu.hdani1337.cargame.Screen.InfoScreen;
import hu.hdani1337.cargame.Screen.OptionsScreen;

public class HomeStage extends MyStage {
    Music bgMusic = Assets.manager.get(Assets.HOME_ZENE);
    Play play;
    Exit exit;
    Info info;
    Settings settings;
    Background background;

    public HomeStage(Viewport viewport, Batch batch, final CarGame game) {
        super(viewport, batch, game);
        background = new Background(false);
        play = new Play();
        exit = new Exit();
        info = new Info();
        settings = new Settings();

        play.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new DifficultyScreen(game));
            }
        });

        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });

        info.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new InfoScreen(game));
            }
        });

        settings.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new OptionsScreen(game));
            }
        });

        info.setPosition(225,100);
        play.setPosition(430,100);
        exit.setPosition(650,100);
        settings.setPosition(865,100);

        addActor(background);
        addActor(play);
        addActor(settings);
        addActor(info);
        addActor(exit);
    }

    @Override
    public void init() {

    }
}
