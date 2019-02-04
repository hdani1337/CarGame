package hu.hdani1337.cargame.Screen.Pause;

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
import hu.hdani1337.cargame.Screen.Game.GameScreenStage;
import hu.hdani1337.cargame.Screen.Home.HomeScreenStage;
import hu.hdani1337.cargame.Screen.Options.OptionsScreenStage;

public class PauseScreenStage extends MyScreen {

    OneSpriteStaticActor bg;
    OneSpriteStaticActor folyt;
    OneSpriteStaticActor kilep;
    OneSpriteStaticActor settingsBTN;
    MyStage pauseStage;

    Music bgMusic = Assets.manager.get(Assets.GAME_ZENE);

    public static byte inGame;

    public PauseScreenStage(CarGame game) {
        super(game);

        pauseStage = new MyStage(new ExtendViewport(1280,720, new OrthographicCamera(1280, 720)), spriteBatch, game) {
            @Override
            public void init() {
                inGame = 0;

                folyt = new OneSpriteStaticActor(Assets.manager.get(Assets.CONTINUE_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }

                };
                folyt.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                    }

                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        game.setScreen(new GameScreenStage(game));
                        bgMusic.play();
                        return super.touchDown(event, x, y, pointer, button);
                    }
                });

                kilep = new OneSpriteStaticActor(Assets.manager.get(Assets.EXIT_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }

                };
                kilep.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Gdx.app.exit();
                    }
                });

                settingsBTN = new OneSpriteStaticActor(Assets.manager.get(Assets.SETTINGS_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }};
                settingsBTN.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        inGame = 1;
                        game.setScreen(new OptionsScreenStage(game));
                    }
                });

                bg = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }

                };

                folyt.setPosition(435,260);
                folyt.setSize(200,200);

                kilep.setPosition(650, 260);
                kilep.setSize(200,200);

                settingsBTN.setPosition((float)542.5,50);
                settingsBTN.setSize(200,200);

                addActor(bg);
                addActor(folyt);
                addActor(kilep);
                addActor(settingsBTN);
            }
        };
    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        pauseStage.draw();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(pauseStage);
    }
}

