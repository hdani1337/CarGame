package hu.hdani1337.cargame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import hu.hdani1337.cargame.MyBaseClasses.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Game.MyGame;

import hu.hdani1337.cargame.Screen.Home.HomeScreenStage;

public class CarGame extends MyGame {
    @Override
    public void create () {
        Assets.prepare();
        Assets.load();
        System.out.println("Loading");
        while (!Assets.manager.update()){
            System.out.print(".");
        }
        setScreen(new HomeScreenStage(this));//miután betöltött, meghívom a kezdőképernyőt
    }

    public static Label.LabelStyle getLabelStyle() {//label stílusa, nagynehezen sikerült
        Label.LabelStyle style;
        style = new Label.LabelStyle();
        style.font = Assets.manager.get(Assets.ARIAL);
        style.fontColor = Color.WHITE;
        Pixmap p = new Pixmap(2, 2, Pixmap.Format.RGB888);
        p.setColor(0.4f, 0.2f, 0.8f, 0.5f);
        p.fill();
        return style;
    }

}