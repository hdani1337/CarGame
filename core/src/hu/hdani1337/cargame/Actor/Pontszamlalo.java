package hu.hdani1337.cargame.Actor;

import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.UI.MyLabel;
import hu.hdani1337.cargame.Stage.CrashStage;
import hu.hdani1337.cargame.Stage.GameStage;

import static hu.hdani1337.cargame.Stage.GameStage.pontszam;

public class Pontszamlalo extends MyLabel {
    public Pontszamlalo() {
        super(CarGame.getLabelStyle(), GameStage.pontszam + "");
        setPosition(640 - (getWidth()/2),720 - (getHeight()));
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setText(GameStage.pontszam+"");
        if(pontszam == 10){
            setX(640 - (getWidth()/2) - 7.5f);
            GameStage.textBackgroundWidth = 24;
        }
    }
}
