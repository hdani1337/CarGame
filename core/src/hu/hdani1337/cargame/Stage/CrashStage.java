package hu.hdani1337.cargame.Stage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.hdani1337.cargame.Actor.Background;
import hu.hdani1337.cargame.Actor.Block;
import hu.hdani1337.cargame.Actor.Car;
import hu.hdani1337.cargame.Actor.EnemyCar;
import hu.hdani1337.cargame.Button.Back;
import hu.hdani1337.cargame.Button.Play;
import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.MyBaseClasses.UI.MyLabel;
import hu.hdani1337.cargame.MyBaseClasses.UI.TextBackground;
import hu.hdani1337.cargame.Screen.GameScreen;

public class CrashStage extends MyStage {
    Background background;
    Car car;
    EnemyCar enemyCar;
    Block block;
    MyLabel pontszam;
    TextBackground textBackground;
    Play play;

    public CrashStage(Viewport viewport, Batch batch, final CarGame game, float myXT, float myDegree ,float eXT, float eYT, final boolean crashType) {
        super(viewport, batch, game);
        pontszam = new MyLabel(CarGame.getLabelStyle(),GameStage.pontszam+" pontot értél el");
        background = new Background(false);
        play = new Play();
        play.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                GameStage.pontszam = 0;
                game.setScreen(new GameScreen(game,0,0,0,0,0,0,0,false));
            }
        });
        switch (ChoosingStage.carID){
            case 0: car = new Car(Assets.manager.get(Assets.CAR1_TEXTURE_CRASHED),false);
            case 1: car = new Car(Assets.manager.get(Assets.CAR3_TEXTURE_CRASHED),false);
            case -1: car = new Car(Assets.manager.get(Assets.CAR2_TEXTURE_CRASHED),false);
        }

        play.setPosition(viewport.getWorldWidth()/2-play.getWidth()/2,viewport.getWorldHeight()/2-play.getWidth()/2+35);
        pontszam.setPosition((viewport.getWorldWidth()/2) - (pontszam.getWidth()/2),play.getY()+play.getHeight()+15);
        textBackground = new TextBackground(pontszam.getWidth()+10,pontszam.getHeight()+4);
        textBackground.setPosition(pontszam.getX() - 5,pontszam.getY()-2);
        car.setPosition(myXT,5);
        car.setRotation(myDegree);

        addActor(background);
        addActor(textBackground);
        addActor(pontszam);
        addActor(car);
        addActor(play);

        if(crashType){
            enemyCar = new EnemyCar(Assets.manager.get(Assets.ENEMY_TEXTURE_CRASHED));
            enemyCar.setPosition(eXT,eYT);
            addActor(enemyCar);
        }
        else{
            block = new Block(Assets.manager.get(Assets.BLOCK_CRASH_TEXTURE),false);
            block.setPosition(eXT,eYT);
            addActor(block);
        }

    }

    @Override
    public void init() {

    }
}
