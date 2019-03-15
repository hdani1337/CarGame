package hu.hdani1337.cargame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.FitViewport;

import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.cargame.Stage.ChoosingStage;

public class ChoosingScreen extends MyScreen {
    ChoosingStage choosingStage;

    public ChoosingScreen(CarGame game) {
        super(game);
        choosingStage = new ChoosingStage(new FitViewport(1280,720),spriteBatch,game);
        Gdx.input.setInputProcessor(choosingStage);
    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        choosingStage.act(delta);
        if(delta >= 0){
            choosingStage.draw();
        }
    }
}
