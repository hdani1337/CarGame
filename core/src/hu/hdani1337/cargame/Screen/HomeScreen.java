package hu.hdani1337.cargame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.FitViewport;

import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.cargame.Stage.HomeStage;

public class HomeScreen extends MyScreen {
    HomeStage homeStage;

    public HomeScreen(CarGame game) {
        super(game);
        homeStage = new HomeStage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()),spriteBatch,game);
        Gdx.input.setInputProcessor(homeStage);
    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        homeStage.act(delta);
        if(delta >= 0){
            homeStage.draw();
        }
    }
}
