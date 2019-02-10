package hu.hdani1337.cargame.Screen.Crash;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.hdani1337.cargame.MyBaseClasses.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.UI.MyLabel;
import hu.hdani1337.cargame.Screen.Game.GameScreenStage;

public class CrashScreenStage extends MyScreen {

    long ido = System.currentTimeMillis();

    float myX;
    float eX;
    float eY;

    OneSpriteStaticActor backgroundLost;
    OneSpriteStaticActor mycar;
    OneSpriteStaticActor enemy;
    MyStage crash;
    MyLabel pontLabel;

    public CrashScreenStage(CarGame game, float myXT, float eXT, float eYT, final boolean car) {
        super(game);
        myX = myXT;
        eX = eXT;
        eY = eYT;

        pontLabel = new MyLabel(CarGame.getLabelStyle(),""+GameScreenStage.pontszam+" pontot értél el.");

        crash = new MyStage(new ExtendViewport(1280, 720, new OrthographicCamera(1280, 720)), spriteBatch, game) {
            @Override
            public void init() {
                backgroundLost = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE_LOST)) {
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }

                    @Override
                    public void act(float delta) {
                        super.act(delta);
                    }
                };

                mycar = new OneSpriteStaticActor(Assets.manager.get(Assets.CAR_TEXTURE_CRASHED)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }

                };

                if(car) {
                    enemy = new OneSpriteStaticActor(Assets.manager.get(Assets.ENEMY_TEXTURE_CRASHED)) {
                        @Override
                        public void setDebug(boolean enabled) {
                            super.setDebug(false);
                        }

                    };
                }

                if(!car){
                    enemy = new OneSpriteStaticActor(Assets.manager.get(Assets.BLOCK_CRASH_TEXTURE)) {
                        @Override
                        public void setDebug(boolean enabled) {
                            super.setDebug(false);
                        }

                    };
                    enemy.setSize(150,150);
                }

                backgroundLost.setSize(1280, 720);
                backgroundLost.setPosition(0, 0);

                mycar.setPosition(myX, 5);
                mycar.setRotation(GameScreenStage.myCarDegree);
                enemy.setPosition(eX, eY);

                pontLabel.setPosition((getViewport().getWorldWidth()/2) - (pontLabel.getWidth()/2),282.5f);

                addActor(backgroundLost);
                addActor(enemy);
                addActor(mycar);
                addActor(pontLabel);

                if(myX<=169 || myX>=1070){
                    enemy.remove();
                }

            }
        };
    }

    @Override
    public void init () {

    }

    public void render(float delta){
        super.render(delta);

        if (System.currentTimeMillis() - ido > 3000) {
            GameScreenStage.pontszam = 0;
            game.setScreen(new GameScreenStage(game));
        }
        crash.draw();
    }
}



