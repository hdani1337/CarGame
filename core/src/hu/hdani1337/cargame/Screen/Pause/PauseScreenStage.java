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

public class PauseScreenStage extends MyScreen {

    OneSpriteStaticActor bg;
    OneSpriteStaticActor folyt;
    MyStage pauseStage;

    Music bgMusic = Assets.manager.get(Assets.GAME_ZENE);

    public PauseScreenStage(CarGame game) {
        super(game);

        pauseStage = new MyStage(new ExtendViewport(1280,720, new OrthographicCamera(1280, 720)), spriteBatch, game) {
            @Override
            public void init() {

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

                bg = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }

                };

                folyt.setPosition(515,235);

                addActor(bg);
                addActor(folyt);
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

