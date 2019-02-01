package hu.hdani1337.cargame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class PauseScreen extends MyScreen {

    OneSpriteStaticActor bg;
    OneSpriteStaticActor folyt;
    MyStage pauseStage;

    Music bgMusic = Assets.manager.get(Assets.GAME_ZENE);

    public PauseScreen(CarGame game) {
        super(game);

        pauseStage = new MyStage(new ExtendViewport(1280,720), spriteBatch, game) {
            @Override
            public void init() {

                folyt = new OneSpriteStaticActor(Assets.manager.get(Assets.CONTINUE_TEXTURE));
                folyt.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                    }

                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        game.setScreen(new GameScreen(game));
                        bgMusic.play();
                        return super.touchDown(event, x, y, pointer, button);
                    }
                });

                bg = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE));

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

