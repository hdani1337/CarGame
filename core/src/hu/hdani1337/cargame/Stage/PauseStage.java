package hu.hdani1337.cargame.Stage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.hdani1337.cargame.Actor.Background;
import hu.hdani1337.cargame.Button.Easy;
import hu.hdani1337.cargame.Button.Exit;
import hu.hdani1337.cargame.Button.Play;
import hu.hdani1337.cargame.Button.Settings;
import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;

public class PauseStage extends MyStage {
    Background background;
    Play play;
    Exit exit;
    Settings settings;

    public static byte inGame, unpause;

    public PauseStage(Viewport viewport, Batch batch, CarGame game) {
        super(viewport, batch, game);
        background = new Background(false);
        play = new Play();
        exit = new Exit();
        settings = new Settings();
    }

    @Override
    public void init() {

    }
}
