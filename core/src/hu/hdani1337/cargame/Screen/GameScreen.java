package hu.hdani1337.cargame.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import hu.hdani1337.cargame.MyBaseClasses.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.hdani1337.cargame.CarGame;

public class GameScreen extends MyScreen {

	OneSpriteStaticActor myCar;
	OneSpriteStaticActor enemyCar;
	OneSpriteStaticActor background;

	public static int nehezseg;
	public static int nehezsegNov;
	int pontszam;

	Music bgMusic = Assets.manager.get(Assets.GAME_ZENE);
	Sound crash = Assets.manager.get(Assets.CRASH_SOUND);

	MyStage stage = new MyStage(new ExtendViewport(1280,720), spriteBatch, game ) {

		int sav;
		int speed;

		@Override
		public void init() {
			pontszam = 0;
			speed = nehezseg;

			myCar = new OneSpriteStaticActor(Assets.manager.get(Assets.CAR_TEXTURE)){
				@Override
				public void act(float delta){
					super.act(delta);
					setX(getX() +  Gdx.input.getAccelerometerY() * 3);
					if(myCar.getX()<=169 || myCar.getX()>=1070){
						game.setScreen(new CrashScreen(game, myCar.getX(),enemyCar.getX(),enemyCar.getY()));
					}
				}
			};

			enemyCar = new OneSpriteStaticActor(Assets.manager.get(Assets.ENEMY_TEXTURE)){
				@Override
				public void act(float delta) {
					super.act(delta);
					setY(getY() - delta * speed);
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
						speed += nehezsegNov;
					}

					if(overlaps(myCar,enemyCar) == true){
						bgMusic.stop();
						crash.play();
						game.setScreen(new CrashScreen(game, myCar.getX(), enemyCar.getX(),enemyCar.getY()));
					}
				}
			};

			background = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE)){
				@Override
				public void act(float delta) {
					super.act(delta);
					bgMusic.setLooping(true);
					bgMusic.setVolume(0.4f);
					bgMusic.play();
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

	public GameScreen(CarGame game) {
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