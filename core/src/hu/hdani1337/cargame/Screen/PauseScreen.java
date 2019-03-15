package hu.hdani1337.cargame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.FitViewport;

import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.cargame.Stage.PauseStage;

public class PauseScreen extends MyScreen {
    PauseStage pauseStage;
    public PauseScreen(CarGame game, final float myCarX, final float myCarY, final float enemyCarX, final float enemyCarY, final float korlatx, final float korlaty, final int speed) {
        super(game);
        pauseStage = new PauseStage(new FitViewport(1280,720),spriteBatch,game,myCarX,myCarY,enemyCarX,enemyCarY,korlatx,korlaty,speed);
        Gdx.input.setInputProcessor(pauseStage);
    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        pauseStage.act(delta);
        if(delta >= 0){
            pauseStage.draw();
        }
    }
}
