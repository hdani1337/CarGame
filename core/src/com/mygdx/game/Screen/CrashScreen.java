package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.GameScreen;
import com.mygdx.game.MyBaseClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyScreen;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;

public class CrashScreen extends MyScreen {

    long ido = System.currentTimeMillis();

    OneSpriteStaticActor backgroundLost;

    MyStage crash = new MyStage(new ExtendViewport(1280,720),spriteBatch,game) {
        @Override
        public void init() {
            backgroundLost = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE_LOST)){
                @Override
                public void act(float delta) {
                    super.act(delta);
                }
            };
            backgroundLost.setSize(1280,720);
            backgroundLost.setPosition(0,0);
            addActor(backgroundLost);
        }
    };

    @Override
    public void init() {

    }

    public CrashScreen(MyGdxGame game) {
        super(game);
    }

    public void render(float delta){
        super.render(delta);
        if(System.currentTimeMillis()-ido>3000){
            game.setScreen(new GameScreen(game));
        }
        crash.draw();
    }
}
