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

public class DifficultyScreen extends MyScreen {
    int nehezseg;

    Music bgMusic = Assets.manager.get(Assets.HOME_ZENE);

    OneSpriteStaticActor background;
    OneSpriteStaticActor easy;
    OneSpriteStaticActor med;
    OneSpriteStaticActor hard;

    public DifficultyScreen(CarGame game) {
        super(game);
    }

    MyStage difficulty = new MyStage(new ExtendViewport(1280,720),spriteBatch,game) {
        @Override
        public void init() {
            background = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE)){
                @Override
                public void act(float delta) {
                    super.act(delta);
                }
            };

            easy = new OneSpriteStaticActor(Assets.manager.get(Assets.EASY_TEXTURE));
            med = new OneSpriteStaticActor(Assets.manager.get(Assets.MED_TEXTURE));
            hard = new OneSpriteStaticActor(Assets.manager.get(Assets.HARD_TEXTURE));

                easy.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                    }

                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        bgMusic.stop();
                        GameScreen.nehezseg = 250;
                        GameScreen.nehezsegNov = 12;
                        game.setScreen(new GameScreen(game));
                        return super.touchDown(event, x, y, pointer, button);
                    }
                });

                med.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                    }

                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        bgMusic.stop();
                        GameScreen.nehezseg = 300;
                        GameScreen.nehezsegNov = 15;
                        game.setScreen(new GameScreen(game));
                        return super.touchDown(event, x, y, pointer, button);
                    }
                });

                hard.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                    }

                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        bgMusic.stop();
                        GameScreen.nehezseg = 400;
                        GameScreen.nehezsegNov = 18;
                        game.setScreen(new GameScreen(game));
                        return super.touchDown(event, x, y, pointer, button);
                    }
                });

            background.setSize(1280,720);
            background.setPosition(0,0);

            easy.setPosition(350,275);
            easy.setSize(180,180);

            med.setPosition(550,275);
            med.setSize(180,180);

            hard.setPosition(750,275);
            hard.setSize(180,180);

            addActor(background);
            addActor(easy);
            addActor(med);
            addActor(hard);
        }
    };

    @Override
    public void init() {

    }

    public void render(float delta){
        super.render(delta);
        difficulty.draw();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(difficulty);
    }
}
