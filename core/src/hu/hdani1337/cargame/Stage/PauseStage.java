package hu.hdani1337.cargame.Stage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.hdani1337.cargame.Actor.Background;
import hu.hdani1337.cargame.Button.Easy;
import hu.hdani1337.cargame.Button.Exit;
import hu.hdani1337.cargame.Button.Play;
import hu.hdani1337.cargame.Button.Settings;
import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.Screen.GameScreen;
import hu.hdani1337.cargame.Screen.HomeScreen;

public class PauseStage extends MyStage {
    Background background;
    Play play;
    Exit exit;

    public static byte unpause;

    public PauseStage(Viewport viewport, Batch batch, final CarGame game, final float myCarX, final float myCarY, final float enemyCarX, final float enemyCarY, final float korlatx, final float korlaty, final int speed) {
        super(viewport, batch, game);
        background = new Background(false);
        play = new Play();
        exit = new Exit();

        if(OptionsStage.ifMuted == 0){
            GameStage.gameMusic.pause();
        }

        play.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new GameScreen(game,myCarX,myCarY,enemyCarX,enemyCarY,korlatx,korlaty,speed,true));
            }
        });

        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new HomeScreen(game));
            }
        });

        play.setPosition(435,260);
        exit.setPosition(650, 260);

        addActor(background);
        addActor(play);
        addActor(exit);
    }

    @Override
    public void init() {

    }
}
