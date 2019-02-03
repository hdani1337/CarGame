package hu.hdani1337.cargame.Screen.Home;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.hdani1337.cargame.Screen.Difficulty.DifficultyScreenStage;

public class HomeScreenStage extends MyScreen {

    OneSpriteStaticActor demoCar;
    OneSpriteStaticActor demoCar2;
    OneSpriteStaticActor startBTN;
    OneSpriteStaticActor background;
    Music bgMusic = Assets.manager.get(Assets.HOME_ZENE);

    public static int pontszam;

    MyStage home = new MyStage(new ExtendViewport(1280,720, new OrthographicCamera(1280, 720)),spriteBatch,game) {
        @Override
        public void init() {
            startBTN = new OneSpriteStaticActor(Assets.manager.get(Assets.START_BUTTON)){
                @Override
                public void setDebug(boolean enabled) {
                    super.setDebug(false);
                }

            };
            startBTN.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                }

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    pontszam = 0;
                    game.setScreen(new DifficultyScreenStage(game));
                    return super.touchDown(event, x, y, pointer, button);
                }
            });


            background = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE)){
                @Override
                public void setDebug(boolean enabled) {
                    super.setDebug(false);
                }

                @Override
                public void act(float delta) {
                    super.act(delta);
                    bgMusic.setLooping(true);
                    bgMusic.setVolume(0.4f);
                    bgMusic.play();
                }
            };



            demoCar = new OneSpriteStaticActor(Assets.manager.get(Assets.CAR_TEXTURE)) {
                @Override
                public void setDebug(boolean enabled) {
                    super.setDebug(false);
                }

                byte sav;

                @Override
                public void act(float delta) {
                    super.act(delta);
                    setY(getY() + delta * 360);
                    if (demoCar.getY() > getViewport().getWorldHeight()) {//Sávválasztás
                        sav = (byte) (Math.random() * 4 + 1);
                        if (sav == 1) {
                            demoCar.setX(300);
                        }

                        if (sav == 2) {
                            demoCar.setX(500);
                        }

                        if (sav == 3) {
                            demoCar.setX(735);
                        }

                        if (sav == 4) {
                            demoCar.setX(940);
                        }
                        setY(-1250);
                    }
                }
            };

            demoCar2 = new OneSpriteStaticActor(Assets.manager.get(Assets.ENEMY_TEXTURE)) {
                @Override
                public void setDebug(boolean enabled) {
                    super.setDebug(false);
                }

                byte sav;

                @Override
                public void act(float delta) {
                    super.act(delta);
                    setY(getY() - delta * 420);
                    if (demoCar2.getY() + demoCar2.getHeight() < 0) {
                        sav = (byte) (Math.random() * 4 + 1);
                        if (sav == 1) {
                            demoCar2.setX(300);
                        }

                        if (sav == 2) {
                            demoCar2.setX(500);
                        }

                        if (sav == 3) {
                            demoCar2.setX(735);
                        }

                        if (sav == 4) {
                            demoCar2.setX(940);
                        }
                        setY(1500);
                    }
                }
            };

            background.setSize(1280,720);
            background.setPosition(0,0);

            demoCar.setPosition(300,-1250);
            demoCar2.setPosition(735,1500);

            startBTN.setPosition(485,75);

            addActor(background);
            addActor(demoCar);
            addActor(demoCar2);
            addActor(startBTN);
        }
    };

    @Override
    public void init() {

    }

    public HomeScreenStage(CarGame game) {
        super(game);
    }

    public void render(float delta){
        super.render(delta);
        home.act(delta);
        home.draw();
        bgMusic.setVolume(0.4f);
        bgMusic.setLooping(true);
        bgMusic.play();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(home);
    }
};
