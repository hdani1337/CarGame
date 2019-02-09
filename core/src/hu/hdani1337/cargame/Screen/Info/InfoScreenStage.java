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
import hu.hdani1337.cargame.MyBaseClasses.UI.MyLabel;
import hu.hdani1337.cargame.Screen.Home.HomeScreenStage;

public class InfoScreenStage extends MyScreen {

    MyStage info;
    OneSpriteStaticActor bg;
    OneSpriteStaticActor back;
    OneSpriteStaticActor bgtext;
    MyLabel text;

    public InfoScreenStage(CarGame game) {
        super(game);
    }

    @Override
    public void init() {
        info = new MyStage(new ExtendViewport(1280,720),spriteBatch,game) {
            @Override
            public void init() {
                text = new MyLabel(CarGame.getLabelStyle(),"A játék lényege az, hogy kikerüld a veled\nszembe hajtó autókat. Minden egyes\nkikerült autó után egy pont jár. Sok sikert\na játékhoz!\n\nKészítette: Horváth Dániel\nTanár: Tüske Balázs                              2019");

                bgtext = new OneSpriteStaticActor(Assets.manager.get(Assets.SZOVEG_HATTER)){
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
                bgtext.setSize(640,270);
                bgtext.setPosition(340,320);
                text.setPosition(360,335);

                addActor(bg);
                addActor(back);
                addActor(bgtext);
                addActor(text);
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
