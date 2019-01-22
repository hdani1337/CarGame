package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MyBaseClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyScreen;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteActor;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class GameScreen extends MyScreen {




	MyStage stage = new MyStage(new ExtendViewport(128,128), spriteBatch, game ) {
		OneSpriteStaticActor myCar;
		OneSpriteStaticActor enemyCar;


		@Override
		public void init() {
			myCar = new OneSpriteStaticActor(Assets.manager.get(Assets.CAR_TEXTURE)){
				@Override
				public void act(float delta){
					super.act(delta);
					setX(getX() +  Gdx.input.getAccelerometerY() * (float)0.5);
				}
			};

			enemyCar = new OneSpriteStaticActor(Assets.manager.get(Assets.ENEMY_TEXTURE)){
				@Override
				public void act(float delta) {
					super.act(delta);
					setY(getY() - delta * 30);
				}
			};


			if(enemyCar.getY() < 0){
				enemyCar.setPosition(40,getHeight());
			}

			myCar.setSize(10,24);
			myCar.addBaseCollisionCircleShape();
			enemyCar.addBaseCollisionRectangleShape();
			enemyCar.setSize(10,19);
			enemyCar.setPosition(40,getHeight());
			addActor(myCar);
			addActor(enemyCar);
		}

	};


	public GameScreen(MyGdxGame game) {
		super(game);
	}

	@Override
	public void init() {

	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

	}
}