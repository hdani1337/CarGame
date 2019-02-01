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

public class HomeScreen extends MyScreen {

    OneSpriteStaticActor startBTN;
    OneSpriteStaticActor background;
    Music bgMusic = Assets.manager.get(Assets.HOME_ZENE);

    public static int pontszam;

    MyStage home = new MyStage(new ExtendViewport(1280,720),spriteBatch,game) {
        @Override
        public void init() {
            startBTN = new OneSpriteStaticActor(Assets.manager.get(Assets.START_BUTTON));
            startBTN.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                }

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    pontszam = 0;
                    game.setScreen(new DifficultyScreen(game));
                    return super.touchDown(event, x, y, pointer, button);
                }
            });


            background = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE)){
                @Override
                public void act(float delta) {
                    super.act(delta);
                    bgMusic.setLooping(true);
                    bgMusic.setVolume(0.4f);
                    bgMusic.play();
                }
            };

            background.setSize(1280,720);
            background.setPosition(0,0);

            startBTN.setPosition(485,75);

            addActor(background);
            addActor(startBTN);
        }
    };

    @Override
    public void init() {

    }

    public HomeScreen(CarGame game) {
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
}
