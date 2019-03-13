package hu.hdani1337.cargame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.FitViewport;

import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.cargame.Stage.CrashStage;

public class CrashScreen extends MyScreen {
    CrashStage crashStage;

    public CrashScreen(CarGame game, float myXT, float eXT, float eYT, final boolean car) {
        super(game);
        crashStage = new CrashStage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()),spriteBatch,game, myXT, eXT, eYT, car);
        Gdx.input.setInputProcessor(crashStage);
    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        crashStage.act(delta);
        if(delta >= 0){
            crashStage.draw();
        }
    }
}
