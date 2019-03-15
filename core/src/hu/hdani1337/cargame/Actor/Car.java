package hu.hdani1337.cargame.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.hdani1337.cargame.Stage.OptionsStage;

import static hu.hdani1337.cargame.Stage.GameStage.crash;
import static hu.hdani1337.cargame.Stage.GameStage.gameMusic;

public class Car extends OneSpriteStaticActor {
    private static boolean valami;
    public static boolean korlatCrash = false;
    public static int sav = 2;

    public Car(Texture texture, boolean act) {
        super(texture);
        setDebug(false);
        addBaseCollisionRectangleShape();
        valami = act;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(valami){
            if(OptionsStage.controlType == 0){
                setX(getX() +  Gdx.input.getAccelerometerY() * 3);
                setRotation(Gdx.input.getAccelerometerY() * 6);
            }

            if(getX()<=169 || getX()>=1070){//Korlátnak ütközés
                gameMusic.stop();
                crash.play();
                korlatCrash = true;
            }

            if (getX() > 560 && getX() < 670) sav = 2;
            if (getX() > 360 && getX() < 440) sav = 1;
            if (getX() > 800 && getX() < 870) sav = 3;
        }
    }
}
