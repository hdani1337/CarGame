package hu.hdani1337.cargame.Stage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;

public class ChoosingStage extends MyStage {
    public static byte carID;

    public ChoosingStage(Viewport viewport, Batch batch, CarGame game) {
        super(viewport, batch, game);
    }

    @Override
    public void init() {

    }
}
