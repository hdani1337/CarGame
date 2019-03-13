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
import hu.hdani1337.cargame.Screen.GameScreen;

public class CrashStage extends MyStage {
    Background background;
    Car car;
    EnemyCar enemyCar;
    Block block;
    MyLabel pontszam;
    Play play;

    public CrashStage(Viewport viewport, Batch batch, final CarGame game, float myXT, float eXT, float eYT, final boolean crashType) {
        super(viewport, batch, game);
        pontszam = new MyLabel(CarGame.getLabelStyle(),"x pontot értél el");
        background = new Background(false);
        play = new Play();
        play.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new GameScreen(game));
            }
        });
        switch (ChoosingStage.carID){
            case 0: car = new Car(Assets.manager.get(Assets.CAR1_TEXTURE_CRASHED));
            case 1: car = new Car(Assets.manager.get(Assets.CAR3_TEXTURE_CRASHED));
            case -1: car = new Car(Assets.manager.get(Assets.CAR2_TEXTURE_CRASHED));
        }

        pontszam.setPosition((viewport.getWorldWidth()/2) - (pontszam.getWidth()/2),282.5f);
        play.setPosition(viewport.getWorldWidth()/2-play.getWidth()/2,100);
        car.setPosition(myXT,5);

        addActor(background);
        addActor(pontszam);
        addActor(car);
        addActor(play);

        if(crashType){
            enemyCar = new EnemyCar(Assets.manager.get(Assets.ENEMY_TEXTURE_CRASHED));
            enemyCar.setPosition(eXT,eYT);
            addActor(enemyCar);
        }
        else{
            block = new Block(Assets.manager.get(Assets.BLOCK_CRASH_TEXTURE));
            block.setPosition(eXT,eYT);
            addActor(block);
        }

    }

    @Override
    public void init() {

    }
}
