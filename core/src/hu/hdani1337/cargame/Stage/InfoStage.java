package hu.hdani1337.cargame.Stage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.hdani1337.cargame.Actor.Background;
import hu.hdani1337.cargame.Button.Back;
import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.MyBaseClasses.UI.MyLabel;
import hu.hdani1337.cargame.MyBaseClasses.UI.TextBackground;
import hu.hdani1337.cargame.Screen.HomeScreen;

public class InfoStage extends MyStage {
    Background background;
    TextBackground textBackground;
    Back back;
    MyLabel text;

    public InfoStage(Viewport viewport, Batch batch, final CarGame game) {
        super(viewport, batch, game);
        background = new Background(false);
        back = new Back();
        textBackground = new TextBackground(560,270);
        text = new MyLabel(CarGame.getLabelStyle(),"A játék lényege az, hogy kikerüld a veled\nszembe hajtó autókat. Minden egyes\nkikerült autó után egy pont jár. Sok sikert\na játékhoz!\n\nKészítette: Horváth Dániel\nTanár: Tüske Balázs                               2019");

        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new HomeScreen(game));
            }
        });

        textBackground.setPosition(360,320);
        text.setPosition(375,325);
        back.setPosition(225,100);

        addActor(background);
        addActor(back);
        addActor(textBackground);
        addActor(text);
    }

    @Override
    public void init() {

    }
}
