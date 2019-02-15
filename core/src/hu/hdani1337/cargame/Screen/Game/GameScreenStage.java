package hu.hdani1337.cargame.Screen.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.hdani1337.cargame.CarGame;
import hu.hdani1337.cargame.MyBaseClasses.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.hdani1337.cargame.MyBaseClasses.UI.MyLabel;
import hu.hdani1337.cargame.Screen.Choosing.ChoosingScreenStage;
import hu.hdani1337.cargame.Screen.Crash.CrashScreenStage;
import hu.hdani1337.cargame.Screen.Options.OptionsScreenStage;
import hu.hdani1337.cargame.Screen.Pause.PauseScreenStage;

import static hu.hdani1337.cargame.Screen.Pause.PauseScreenStage.unpause;

public class GameScreenStage extends MyScreen {

	OneSpriteStaticActor myCar;
	OneSpriteStaticActor enemyCar;
	OneSpriteStaticActor block;
	OneSpriteStaticActor background;
	OneSpriteStaticActor background2;
	OneSpriteStaticActor textbg;
	OneSpriteStaticActor pause;
	OneSpriteStaticActor rightArrow;
	OneSpriteStaticActor leftArrow;

	long ido = 0;
	boolean cheat = false;
	//minek vannak ezek is itt xdxdxdxdxd

	public static int nehezseg;
	public static int nehezsegNov;
	public static int pontszam;//magyarázzam?..
	public static float myCarDegree;//az autóm szöge, mikor ütközik

	public static float pause_mycarx, pause_mycary, pause_enemycarx, pause_enemycary, pause_korlatx, pause_korlaty; //temp változók, a megállítás után lényegesek
	public static int pause_speed;//ez is


	MyLabel pontLabel;

	Music bgMusic = Assets.manager.get(Assets.GAME_ZENE);
	Sound crash = Assets.manager.get(Assets.CRASH_SOUND);

	MyStage stage = new MyStage(new ExtendViewport(1280,720, new OrthographicCamera(1280, 720)), spriteBatch, game ) {

		int sav;
		int speed;
		float palyaFele;
		Texture car_texture;

		@Override
		public void init() {
			palyaFele = getViewport().getWorldWidth()/2;
			speed = nehezseg;

			pontLabel = new MyLabel(CarGame.getLabelStyle(),""+pontszam);//pontszámláló

			textbg = new OneSpriteStaticActor(Assets.manager.get(Assets.SZOVEG_HATTER)){//pontszámláló háttere
				@Override
				public void setDebug(boolean enabled) {
					super.setDebug(false);
				}
			};

			pause = new OneSpriteStaticActor(Assets.manager.get(Assets.PAUSE_TEXTURE)){
				@Override
					public void setDebug(boolean enabled) {
					super.setDebug(false);
				}
			};
			pause.addListener(new ClickListener(){

				public void clicked(InputEvent event, float x, float y) {
					super.clicked(event, x, y);
				}

				@Override
				public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
					bgMusic.pause();
					pause_mycarx = myCar.getX();
					pause_mycary = myCar.getY();
					pause_enemycarx = enemyCar.getX();
					pause_enemycary = enemyCar.getY();
					pause_speed = speed;
					pause_korlatx = block.getX();
					pause_korlaty = block.getY();
					game.setScreen(new PauseScreenStage(game,myCar.getX(),myCar.getY(),enemyCar.getX(),enemyCar.getY(),block.getX(),block.getY(),speed));
					return super.touchDown(event, x, y, pointer, button);
				}
			});

			if(ChoosingScreenStage.carID == 0){
				car_texture = Assets.manager.get(Assets.CAR1_TEXTURE);
			}

			if(ChoosingScreenStage.carID == 1){
				car_texture = Assets.manager.get(Assets.CAR3_TEXTURE);
			}

			if(ChoosingScreenStage.carID == -1){
				car_texture = Assets.manager.get(Assets.CAR2_TEXTURE);
			}

			myCar = new OneSpriteStaticActor(car_texture){
				@Override
				public void setDebug(boolean enabled) {
					super.setDebug(false);
				}

				@Override
				public void act(float delta){
					super.act(delta);

					//AUTÓ IRÁNYÍTÁS
					if(OptionsScreenStage.controlType == 0){
					setX(getX() +  Gdx.input.getAccelerometerY() * 3);
					setRotation(Gdx.input.getAccelerometerY() * 6);
					}

					if(OptionsScreenStage.controlType == 1){
						leftArrow.addListener(new ClickListener(){
							@Override
							public void clicked(InputEvent event, float x, float y) {
								super.clicked(event, x, y);
								myCar.setX(myCar.getX() - 0.099f);
								myCar.setRotation(-4);
							}
						});

						rightArrow.addListener(new ClickListener(){
							@Override
							public void clicked(InputEvent event, float x, float y) {
								super.clicked(event, x, y);
								myCar.setX(myCar.getX() + 0.099f);
								myCar.setRotation(4);
							}
						});
					}

					if(myCar.getX()<=169 || myCar.getX()>=1070){//Korlátnak ütközés
						bgMusic.stop();
						crash.play();
						myCarDegree = myCar.getRotation();
						game.setScreen(new CrashScreenStage(game, myCar.getX(),enemyCar.getX(),enemyCar.getY(),false));
					}
				}
			};//AZ ÉN AUTÓM

			enemyCar = new OneSpriteStaticActor(Assets.manager.get(Assets.ENEMY_TEXTURE)){
				@Override
				public void setDebug(boolean enabled) {
					super.setDebug(false);
				}

				@Override
				public void act(float delta) {
					super.act(delta);
					setY(getY() - delta * speed);
					if(enemyCar.getY() + enemyCar.getHeight() < 0){//Sávválasztás
						sav = (int)(Math.random() * 4 + 1);
						if(sav == 1){
							enemyCar.setX(295);
						}

						if(sav == 2){
							enemyCar.setX(500);
						}

						if(sav == 3){
							enemyCar.setX(730);
						}

						if(sav == 4){
							enemyCar.setX(935);
						}
						setY(stage.getHeight());
						pontszam++;
						pontLabel.setText(""+pontszam);
						if(pontszam == 10){
							pontLabel.setX(pontLabel.getX() - 7.5f);
						}
						speed += nehezsegNov;//Sebességnövelés
					}

					if(overlaps(myCar,enemyCar) == true){//Ütközés az ellenféllel
						bgMusic.stop();
						crash.play();
						myCarDegree = myCar.getRotation();
						game.setScreen(new CrashScreenStage(game, myCar.getX(), enemyCar.getX(),enemyCar.getY(),true));
					}
				}
			};//ELLENSÉGES AUTÓ

			background = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE)){
				@Override
				public void setDebug(boolean enabled) {
					super.setDebug(false);
				}

				@Override
				public void act(float delta) {
					super.act(delta);
					background.setY(getY() - 5);

					if(OptionsScreenStage.ifMuted == 0){
						bgMusic.setLooping(true);
						bgMusic.setVolume(0.4f);
						bgMusic.play();
					}

					if(OptionsScreenStage.ifMuted == 1){
						bgMusic.stop();
					}

					if(background.getY() + 720 <= 0){
						background.setY(720);
					}
				}
			};//HÁTTÉR

			background2 = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE)){
				@Override
				public void setDebug(boolean enabled) {
					super.setDebug(false);
				}

				@Override
				public void act(float delta) {
					super.act(delta);
					background2.setY(getY() - 5);

					if(background2.getY() + 720 <= 0){
						background2.setY(720);
					}
				}
			};//HÁTTÉR

			block = new OneSpriteStaticActor(Assets.manager.get(Assets.BLOCK_TEXTURE)){
				@Override
				public void setDebug(boolean enabled) {
				super.setDebug(false);
				}

				@Override
				public void act(float delta) {
					super.act(delta);

					if (block.getY() + block.getHeight() < 0) {
						block.setY(2000);
					}

					//na ezen igazodj el xdxd
					//amúgy azt figyeli, hogy melyik helyen van az autó, ahol lehetne csalni, és akkor oda rakja az akadályt

					if (myCar.getX() > 560 && myCar.getX() < 670) {//középen
						block.setY(block.getY() - (float)0.0001);
						if(block.getY() > 600) {
							block.setX(palyaFele - (block.getWidth()) / 2);
						}
						if (block.getY() <= myCar.getY() + myCar.getHeight()) {
							if(myCar.getX() > block.getX() && (myCar.getX() + myCar.getWidth() < (block.getX() + block.getWidth()))) {
								bgMusic.stop();
								crash.play();
								game.setScreen(new CrashScreenStage(game, myCar.getX(), block.getX(), block.getY(), false));
							}
						}
					}

					if (myCar.getX() > 360 && myCar.getX() < 440) {//1-2 sáv között
						block.setY(block.getY() - (float)0.0001);
						if(block.getY() > 600) {
							block.setX((425 - (block.getWidth() / 2)));
						}
						if (block.getY() <= myCar.getY() + myCar.getHeight()) {
							if(myCar.getX() > block.getX() && (myCar.getX() + myCar.getWidth() < (block.getX() + block.getWidth()))) {
								bgMusic.stop();
								crash.play();
								game.setScreen(new CrashScreenStage(game, myCar.getX(), block.getX(), block.getY(), false));
							}
						}
					}

					if (myCar.getX() > 800 && myCar.getX() < 870) {//3-4 sáv között
						block.setY(block.getY() - (float)0.0001);
						if(block.getY() > 600) {//ha már kisebb az Y 600-nál, akkor már ne váltson sávot, mert akkor játszhatatlan lenne
							block.setX((863 - (block.getWidth() / 2)));
						}
						if (block.getY() <= myCar.getY() + myCar.getHeight()) {//ütközés, mert valamiért az overlaps nem működik itt, de megoldjuk okosba'
							if(myCar.getX() > block.getX() && (myCar.getX() + myCar.getWidth() < (block.getX() + block.getWidth()))){
								bgMusic.stop();
								crash.play();
								game.setScreen(new CrashScreenStage(game, myCar.getX(), block.getX(), block.getY(), false));
							}
						}
					}

					if (block.getY() != 2000) {
						block.setY(block.getY() - 5);
					}
				}
			};//AKADÁLY

			leftArrow = new OneSpriteStaticActor(Assets.manager.get(Assets.LEFT_ARROW)){
				@Override
				public void setDebug(boolean enabled) {
					super.setDebug(false);
				}
			};//BALRA GOMB
			rightArrow = new OneSpriteStaticActor(Assets.manager.get(Assets.RIGHT_ARROW)){
				@Override
				public void setDebug(boolean enabled) {
					super.setDebug(false);
				}
			};//JOBBRA GOMB

			myCar.addBaseCollisionRectangleShape();
			myCar.setPosition(615,5);

			enemyCar.addBaseCollisionRectangleShape();
			enemyCar.setSize(65,135);
			enemyCar.setPosition(500,getHeight());

			background.setSize(1280,720);
			background.setPosition(0,0);

			background2.setSize(1280,720);
			background2.setPosition(0,720);

			pause.setPosition(1205,645);
			pause.setSize(72,72);

			block.setSize(150,150);
			block.setY(2000);

			pontLabel.setPosition(palyaFele - (pontLabel.getWidth()/2),720 - (pontLabel.getHeight()));
			textbg.setPosition(palyaFele - (textbg.getWidth()/2),720 - (pontLabel.getHeight()));
			textbg.setSize(50,35);

			addActor(background);
			addActor(background2);
			addActor(myCar);
			addActor(enemyCar);
			addActor(block);
			addActor(pause);
			addActor(textbg);
			addActor(pontLabel);

			//ha tapintós irányítás, gombok
			if(OptionsScreenStage.controlType == 1){
				leftArrow.setSize(75,75);
				rightArrow.setSize(75,75);

				leftArrow.setPosition(950,50);
				rightArrow.setPosition(1050,50);
				addActor(leftArrow);
				addActor(rightArrow);
			}

			//na ez fontos!
			//ha megállítás után jövök vissza a játékba, akkor maradjanak a pozíciók és a nehézség
			if(unpause == 1){
				speed = pause_speed;
				myCar.setX(pause_mycarx);
				myCar.setY(pause_mycary);
				enemyCar.setX(pause_enemycarx);
				enemyCar.setY(pause_enemycary);
				block.setX(pause_korlatx);
				block.setY(pause_korlaty);
			}
		}

	};

	public GameScreenStage(CarGame game) {
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
			myCar.setRotation(-5);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			myCar.setX(myCar.getX() + 6);
			myCar.setRotation(5);
		}
		//gépen irányítás

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