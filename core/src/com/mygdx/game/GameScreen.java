package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MyBaseClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyScreen;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteActor;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

import java.awt.event.KeyEvent;

import static com.badlogic.gdx.scenes.scene2d.InputEvent.Type.keyDown;

public class GameScreen extends MyScreen {

	OneSpriteStaticActor myCar;
	OneSpriteStaticActor enemyCar;


	MyStage stage = new MyStage(new ExtendViewport(160,160), spriteBatch, game ) {

		int sav;


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
					setY(getY() - delta * 75);
					if(enemyCar.getY() + enemyCar.getHeight() < 0){
						sav = (int)(Math.random() * 4 + 1);
						if(sav == 1){
							enemyCar.setX(30);
						}

						if(sav == 2){
							enemyCar.setX(60);
						}

						if(sav == 3){
							enemyCar.setX(90);
						}

						if(sav == 4){
							enemyCar.setX(120);
						}
						setY(stage.getHeight());
					}

					if(overlaps(myCar,enemyCar) == true){
						setCameraZoomSpeed(1);
						setCameraZoomXY(myCar.getX(),myCar.getY(),(float)0.7);
					}
				}
			};

			myCar.setSize(10,24);
			myCar.addBaseCollisionRectangleShape();
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
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			myCar.setX(myCar.getX() - (float)1.8);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			myCar.setX(myCar.getX() + (float)1.8);
		}
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