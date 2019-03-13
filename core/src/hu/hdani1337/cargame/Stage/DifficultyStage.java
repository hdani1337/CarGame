package hu.hdani1337.cargame.Stage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.hdani1337.cargame.Actor.Background;
import hu.hdani1337.cargame.Button.Easy;
import hu.hdani1337.cargame.Button.Hard;
import hu.hdani1337.cargame.Button.Medium;
import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.Screen.GameScreen;

public class DifficultyStage extends MyStage {
    public static int speed;
    public static byte speedPlus;

    Easy easy;
    Medium medium;
    Hard hard;
    Background background;

    public DifficultyStage(Viewport viewport, Batch batch, final CarGame game) {
        super(viewport, batch, game);
        background = new Background(false);
        easy = new Easy();
        medium = new Medium();
        hard = new Hard();

        easy.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                speed = 350;
                speedPlus = 12;
                game.setScreen(new GameScreen(game));
            }
        });

        medium.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                speed = 400;
                speedPlus = 15;
                game.setScreen(new GameScreen(game));
            }
        });

        hard.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                speed = 500;
                speedPlus = 18;
                game.setScreen(new GameScreen(game));
            }
        });

        easy.setPosition(350,275);
        medium.setPosition(550,275);
        hard.setPosition(750,275);

        addActor(background);
        addActor(easy);
        addActor(medium);
        addActor(hard);
    }

    @Override
    public void init() {

    }
}
