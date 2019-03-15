package hu.hdani1337.cargame.Stage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.hdani1337.cargame.Actor.Background;
import hu.hdani1337.cargame.Actor.Car;
import hu.hdani1337.cargame.Button.Back;
import hu.hdani1337.cargame.Button.Left;
import hu.hdani1337.cargame.Button.Right;
import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.Screen.OptionsScreen;

public class ChoosingStage extends MyStage {
    public static byte carID;
    Left left;
    Right right;
    Car car;
    Back back;
    Background background;

    public ChoosingStage(Viewport viewport, Batch batch, final CarGame game) {
        super(viewport, batch, game);
        carID = 0;
        left = new Left();
        right = new Right();
        back = new Back();
        background = new Background(false);

        car = new Car(Assets.manager.get(Assets.CAR1_TEXTURE),false);

        left.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(carID > -1) {
                    carID--;
                    carChange(carID);
                }
            }
        });

        right.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(carID < 1) {
                    carID++;
                    carChange(carID);
                }
            }
        });

        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new OptionsScreen(game));
            }
        });

        left.setPosition(430,370);
        left.setSize(120,120);

        right.setPosition(740,370);
        right.setSize(120,120);

        car.setPosition(615,370);
        back.setPosition((getViewport().getWorldWidth()/2)-(back.getWidth()/2),150);

        addActor(background);
        addActor(back);
        addActor(car);
        addActor(left);
        addActor(right);
    }

    @Override
    public void init() {

    }

    public void carChange(byte carID){
        if(carID == 0)
        {
            car.remove();
            car = new Car(Assets.manager.get(Assets.CAR1_TEXTURE),false);
            car.setPosition(615,370);
            addActor(car);
        }

        if(carID == 1)
        {
            car.remove();
            car = new Car(Assets.manager.get(Assets.CAR3_TEXTURE),false);
            car.setPosition(615,370);
            addActor(car);
        }

        if(carID == -1) {
            car.remove();
            car = new Car(Assets.manager.get(Assets.CAR2_TEXTURE), false);
            car.setPosition(615,370);
            addActor(car);
        }
    }
}
