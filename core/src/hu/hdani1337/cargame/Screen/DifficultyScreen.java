package hu.hdani1337.cargame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.FitViewport;

import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.cargame.Stage.DifficultyStage;

public class DifficultyScreen extends MyScreen {
    DifficultyStage difficultyStage;

    public DifficultyScreen(CarGame game) {
        super(game);
        difficultyStage = new DifficultyStage(new FitViewport(1280,720),spriteBatch,game);
        Gdx.input.setInputProcessor(difficultyStage);
    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        difficultyStage.act(delta);
        if(delta >= 0){
            difficultyStage.draw();
        }
    }
}
