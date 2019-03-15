package hu.hdani1337.cargame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.FitViewport;

import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.cargame.Stage.InfoStage;

public class InfoScreen extends MyScreen {
    InfoStage infoStage;

    public InfoScreen(CarGame game) {
        super(game);
        infoStage = new InfoStage(new FitViewport(1280,720),spriteBatch,game);
        Gdx.input.setInputProcessor(infoStage);
    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        infoStage.act(delta);
        if(delta >= 0){
            infoStage.draw();
        }
    }
}
