package hu.hdani1337.cargame.Screen.Info;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.hdani1337.cargame.Screen.Home.HomeScreenStage;

public class InfoScreenStage extends MyScreen {

    MyStage info;
    OneSpriteStaticActor bg;
    OneSpriteStaticActor back;

    public InfoScreenStage(CarGame game) {
        super(game);
    }

    @Override
    public void init() {
        info = new MyStage(new ExtendViewport(1280,720),spriteBatch,game) {
            @Override
            public void init() {
                bg = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }
                };

                back = new OneSpriteStaticActor(Assets.manager.get(Assets.BACK_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }
                };
                back.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new HomeScreenStage(game));
                    }
                });

                back.setPosition(225, 100);
                back.setSize(200,200);

                addActor(bg);
                addActor(back);
            }
        };
    }

    public void render(float delta){
        info.draw();
    }

    public void show(){
        Gdx.input.setInputProcessor(info);
    }
}
