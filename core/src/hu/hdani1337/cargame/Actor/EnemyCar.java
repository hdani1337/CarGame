package hu.hdani1337.cargame.Actor;

import com.badlogic.gdx.graphics.Texture;

import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.hdani1337.cargame.Stage.GameStage;

import static hu.hdani1337.cargame.Stage.DifficultyStage.speed;
import static hu.hdani1337.cargame.Stage.DifficultyStage.speedPlus;
import static hu.hdani1337.cargame.Stage.GameStage.pontszam;

public class EnemyCar extends OneSpriteStaticActor {
    int sav;

    public EnemyCar(Texture texture) {
        super(texture);
        setDebug(false);
        addBaseCollisionRectangleShape();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setY(getY() - delta * speed);
        if(getY() + getHeight() < 0){//Sávválasztás
            sav = (int)(Math.random() * 4 + 1);
            if(sav == 1){
                setX(295);
            }

            if(sav == 2){
                setX(500);
            }

            if(sav == 3){
                setX(730);
            }

            if(sav == 4){
                setX(935);
            }
            setY(getStage().getHeight());
            pontszam++;
            speed += speedPlus;//Sebességnövelés
        }

    }
}
