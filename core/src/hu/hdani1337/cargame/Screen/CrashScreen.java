package hu.hdani1337.cargame.Screen;

import com.badlogic.gdx.utils.viewport.ExtendViewport;
import hu.hdani1337.cargame.MyBaseClasses.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.MyStage;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.hdani1337.cargame.CarGame;

public class CrashScreen extends MyScreen {

    long ido = System.currentTimeMillis();

    static float myX;
    static float eX;
    static float eY;

    OneSpriteStaticActor backgroundLost;
    OneSpriteStaticActor mycar;
    OneSpriteStaticActor enemy;

    public CrashScreen(CarGame game, float myXT, float eXT, float eYT) {
        super(game);
        myX = myXT;
        eX = eXT;
        eY = eYT;
    }


    MyStage crash = new MyStage(new ExtendViewport(1280,720),spriteBatch,game) {
        @Override
        public void init() {
            backgroundLost = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE_LOST)){
                @Override
                public void act(float delta) {
                    super.act(delta);
                }
            };
            mycar = new OneSpriteStaticActor(Assets.manager.get(Assets.CAR_TEXTURE_CRASHED));
            enemy = new OneSpriteStaticActor(Assets.manager.get(Assets.ENEMY_TEXTURE_CRASHED));

            backgroundLost.setSize(1280,720);
            backgroundLost.setPosition(0,0);

            mycar.setPosition(myX, 5);
            enemy.setPosition(eX,eY);

            System.out.println("MyCar X: " + myX + " Enemy X és Y: " + eX + ", " + eY);

            addActor(backgroundLost);
            addActor(enemy);
            addActor(mycar);
        }
    };

    @Override
    public void init() {

    }

    public void render(float delta){
        super.render(delta);
        if(System.currentTimeMillis()-ido>3000){
            game.setScreen(new GameScreen(game));
        }
        crash.draw();
    }
}
