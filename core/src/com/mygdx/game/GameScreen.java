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
import com.mygdx.game.Screen.CrashScreen;

import java.awt.event.KeyEvent;

import static com.badlogic.gdx.scenes.scene2d.InputEvent.Type.keyDown;

public class GameScreen extends MyScreen {

	OneSpriteStaticActor myCar;
	OneSpriteStaticActor enemyCar;
	OneSpriteStaticActor background;

	int pontszam;



	MyStage stage = new MyStage(new ExtendViewport(1280,720), spriteBatch, game ) {

		int sav;
		int nehezseg;

		@Override
		public void init() {
			pontszam = 0;
			nehezseg = 250;

			myCar = new OneSpriteStaticActor(Assets.manager.get(Assets.CAR_TEXTURE)){
				@Override
				public void act(float delta){
					super.act(delta);
					setX(getX() +  Gdx.input.getAccelerometerY() * 3);
					if(myCar.getX()<=169 || myCar.getX()>=1070){
						game.setScreen(new CrashScreen(game));
					}
				}
			};

			enemyCar = new OneSpriteStaticActor(Assets.manager.get(Assets.ENEMY_TEXTURE)){
				@Override
				public void act(float delta) {
					super.act(delta);
					setY(getY() - delta * nehezseg);
					if(enemyCar.getY() + enemyCar.getHeight() < 0){
						sav = (int)(Math.random() * 4 + 1);
						if(sav == 1){
							enemyCar.setX(300);
						}

						if(sav == 2){
							enemyCar.setX(500);
						}

						if(sav == 3){
							enemyCar.setX(735);
						}

						if(sav == 4){
							enemyCar.setX(940);
						}
						setY(stage.getHeight());
						pontszam++;
						nehezseg += 12;
					}

					if(overlaps(myCar,enemyCar) == true){
						game.setScreen(new CrashScreen(game));
					}
				}
			};

			background = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE)){
				@Override
				public void act(float delta) {
					super.act(delta);
				}
			};

			myCar.setSize(50,120);
			myCar.addBaseCollisionRectangleShape();
			myCar.setPosition(615,5);
			enemyCar.addBaseCollisionRectangleShape();
			enemyCar.setSize(50,95);
			enemyCar.setPosition(500,getHeight());
			background.setSize(1280,720);
			background.setPosition(0,0);
			addActor(background);
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
			myCar.setX(myCar.getX() - 6);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			myCar.setX(myCar.getX() + 6);
		}
		System.out.println("Pontszám: " + pontszam);
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