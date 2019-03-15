package hu.hdani1337.cargame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.FitViewport;

import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.cargame.Stage.GameStage;

public class GameScreen extends MyScreen {
    GameStage gameStage;

    public GameScreen(CarGame game, final float myCarX, final float myCarY, final float enemyCarX, final float enemyCarY, final float korlatx, final float korlaty, final int speed, final boolean fromPause) {
        super(game);
        gameStage = new GameStage(new FitViewport(1280,720),spriteBatch,game,myCarX,myCarY,enemyCarX,enemyCarY,korlatx,korlaty,speed,fromPause);
        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        gameStage.act(delta);
        if(delta >= 0){
            gameStage.draw();
        }
    }
}
