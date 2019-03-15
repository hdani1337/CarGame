package hu.hdani1337.cargame.Stage;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.hdani1337.cargame.Actor.Background;
import hu.hdani1337.cargame.Actor.Block;
import hu.hdani1337.cargame.Actor.Car;
import hu.hdani1337.cargame.Actor.EnemyCar;
import hu.hdani1337.cargame.Actor.Pontszamlalo;
import hu.hdani1337.cargame.Button.Left;
import hu.hdani1337.cargame.Button.Pause;
import hu.hdani1337.cargame.Button.Right;
import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.MyBaseClasses.UI.MyLabel;
import hu.hdani1337.cargame.MyBaseClasses.UI.TextBackground;
import hu.hdani1337.cargame.Screen.CrashScreen;
import hu.hdani1337.cargame.Screen.PauseScreen;

import static hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyActor.overlaps;

public class GameStage extends MyStage {
    public static Music gameMusic = Assets.manager.get(Assets.GAME_ZENE);
    public static Sound crash = Assets.manager.get(Assets.CRASH_SOUND);

    public static int pontszam = 0;
    public static byte textBackgroundWidth = 16;

    Car car;
    EnemyCar enemyCar;
    Block block;
    Background background;
    Background background2;
    TextBackground textBackground;
    Pause pause;
    Left left;
    Right right;
    Pontszamlalo pontszamlalo;

    public GameStage(Viewport viewport, Batch batch, final CarGame game, final float myCarX, final float myCarY, final float enemyCarX, final float enemyCarY, final float korlatx, final float korlaty, final int speed, final boolean fromPause) {
        super(viewport, batch, game);
        if(OptionsStage.ifMuted == 0){
            gameMusic.play();
        }

        background = new Background(true);
        background2 = new Background(true);
        background.setY(0);
        background2.setY(viewport.getWorldHeight());
        addActor(background);
        addActor(background2);

        pontszamlalo = new Pontszamlalo();
        textBackground = new TextBackground(pontszamlalo.getWidth() + textBackgroundWidth,pontszamlalo.getHeight() + 2);
        textBackground.setPosition(pontszamlalo.getX() - textBackgroundWidth/2, pontszamlalo.getY() - 1);

        pause = new Pause();
        pause.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new PauseScreen(game,car.getX(),car.getY(),enemyCar.getX(),enemyCar.getY(),block.getX(),block.getY(),DifficultyStage.speed));
            }
        });
        pause.setPosition(1205,645);
        pause.setSize(72,72);

        block = new Block(Assets.manager.get(Assets.BLOCK_TEXTURE),true);
        block.setY(2000);

        if(ChoosingStage.carID == 1){
            car = new Car(Assets.manager.get(Assets.CAR3_TEXTURE),true);
        }

        else if(ChoosingStage.carID == -1){
            car = new Car(Assets.manager.get(Assets.CAR2_TEXTURE),true);
        }

        else{
            car = new Car(Assets.manager.get(Assets.CAR1_TEXTURE),true);
        }

        if(OptionsStage.controlType == 1){
            left = new Left();
            right = new Right();

            left.addListener(new ClickListener(){
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    car.setX(car.getX() - 5);
                    return super.touchDown(event, x, y, pointer, button);
                }
            });

            right.addListener(new ClickListener(){
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    car.setX(car.getX() - 5);
                    return super.touchDown(event, x, y, pointer, button);
                }
            });

            addActor(left);
            addActor(right);
        }

        enemyCar = new EnemyCar(Assets.manager.get(Assets.ENEMY_TEXTURE));
        enemyCar.setPosition(500,1500);

        car.setPosition(615,5);

        addActor(enemyCar);
        addActor(textBackground);
        addActor(pontszamlalo);
        addActor(pause);
        addActor(car);
        addActor(block);

        if(fromPause){
            car.setX(myCarX);
            car.setY(myCarY);
            enemyCar.setX(enemyCarX);
            enemyCar.setY(enemyCarY);
            block.setX(korlatx);
            block.setY(korlaty);
            DifficultyStage.speed = speed;
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        textBackground = new TextBackground(pontszamlalo.getWidth() + textBackgroundWidth,pontszamlalo.getHeight() + 2);
        textBackground.setPosition(pontszamlalo.getX() - textBackgroundWidth/2, pontszamlalo.getY() - 1);
        if(overlaps(car,block)) game.setScreen(new CrashScreen(game, car.getX(), car.getRotation(), block.getX(), block.getY(), false));
        if(Car.korlatCrash) game.setScreen(new CrashScreen(game, car.getX(),car.getRotation(),enemyCar.getX(),enemyCar.getY(),false));
    }
}
