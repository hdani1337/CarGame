package hu.hdani1337.cargame.Screen.Choosing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.hdani1337.cargame.Screen.Options.OptionsScreenStage;

public class ChoosingScreenStage extends MyScreen {
    MyStage choosing;
    OneSpriteStaticActor left;
    OneSpriteStaticActor right;
    OneSpriteStaticActor car;
    OneSpriteStaticActor back;
    OneSpriteStaticActor bg;
    public static byte carID;

    public ChoosingScreenStage(CarGame game) {
        super(game);

        choosing = new MyStage(new ExtendViewport(1280,720),spriteBatch,game) {
            @Override
            public void init() {
                carID = 0;

                left = new OneSpriteStaticActor(Assets.manager.get(Assets.LEFT_ARROW)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }
                };

                left.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        if(carID > -1) {
                            carID--;
                        }
                    }
                });

                right = new OneSpriteStaticActor(Assets.manager.get(Assets.RIGHT_ARROW)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }
                };

                right.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        if(carID < 1) {
                            carID++;
                        }
                    }
                });

                back = new OneSpriteStaticActor(Assets.manager.get(Assets.BACK_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }
                };

                back.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new OptionsScreenStage(game));
                    }
                });

                car = new OneSpriteStaticActor(Assets.manager.get(Assets.CAR1_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }
                };

                bg = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }

                    @Override
                    public void act(float delta) {
                        super.act(delta);
                        if (carID == 0){
                            car.remove();
                            car = new OneSpriteStaticActor(Assets.manager.get(Assets.CAR1_TEXTURE)){
                                @Override
                                public void setDebug(boolean enabled) {
                                    super.setDebug(false);
                                }
                            };

                            car.setPosition(612,370);
                            addActor(car);
                        }

                        if (carID == 1){
                            car.remove();
                            car = new OneSpriteStaticActor(Assets.manager.get(Assets.CAR3_TEXTURE)){
                                @Override
                                public void setDebug(boolean enabled) {
                                    super.setDebug(false);
                                }
                            };


                            car.setPosition(608,370);
                            addActor(car);
                        }

                        if (carID == -1){
                            car.remove();
                            car = new OneSpriteStaticActor(Assets.manager.get(Assets.CAR2_TEXTURE)){
                                @Override
                                public void setDebug(boolean enabled) {
                                    super.setDebug(false);
                                }
                            };

                            car.setPosition(606,370);
                            addActor(car);
                        }
                    }
                };

                left.setSize(120,120);
                left.setPosition(430,370);

                right.setSize(120,120);
                right.setPosition(740,370);

                back.setSize(200,200);
                back.setPosition((getViewport().getWorldWidth()/2)-(back.getWidth()/2),150);

                car.setPosition(615,370);

                addActor(bg);
                addActor(left);
                addActor(right);
                addActor(car);
                addActor(back);
            }
        };
    }

    @Override
    public void init() {

    }

    public void render(float delta){
        super.render(delta);
        choosing.act(delta);
        choosing.draw();
    }

    public void show(){
        Gdx.input.setInputProcessor(choosing);
    }
}
