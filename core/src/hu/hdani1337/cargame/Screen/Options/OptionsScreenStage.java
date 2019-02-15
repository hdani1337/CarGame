package hu.hdani1337.cargame.Screen.Options;

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
import hu.hdani1337.cargame.Screen.Choosing.ChoosingScreenStage;
import hu.hdani1337.cargame.Screen.Game.GameScreenStage;
import hu.hdani1337.cargame.Screen.Home.HomeScreenStage;
import hu.hdani1337.cargame.Screen.Pause.PauseScreenStage;

public class OptionsScreenStage extends MyScreen {

    public static byte controlType;//az irányírás típusa (döntés vagy érintés)
    public static byte ifMuted;//le van e némítva, de nem értem mi a rákért nem boolean
    public static OneSpriteStaticActor back;//visszagomb, hogy tudjak rá hivatkozni

    OneSpriteStaticActor bg;//háttér
    OneSpriteStaticActor controlF;//ikon, döntő irányítás
    OneSpriteStaticActor controlT;//ikon, tapintós irányítás
    OneSpriteStaticActor carChoose;//ikon, autóválasztás
    OneSpriteStaticActor mute;//ikon, némítás
    OneSpriteStaticActor unmute;//ikon, némítás feloldása
    MyStage options;

    Music bgMusic = Assets.manager.get(Assets.HOME_ZENE);//háttérzene, hogy kilehessen kapcsolni. lehet majd staticre kéne rakni, mert lusta vagyok mindig meghívni :)

    public OptionsScreenStage(CarGame game) {
        super(game);

        options = new MyStage(new ExtendViewport(1280,720),spriteBatch,game) {
            @Override
            public void init() {
                bg = new OneSpriteStaticActor(Assets.manager.get(Assets.HATTER_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }
                };

                back = new OneSpriteStaticActor(Assets.manager.get(Assets.BACK_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }
                };
                back.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        if(PauseScreenStage.inGame == 0) {
                            game.setScreen(new HomeScreenStage(game));
                        }
                        if(PauseScreenStage.inGame == 1) {
                            game.setScreen(new PauseScreenStage(game,GameScreenStage.pause_mycarx,GameScreenStage.pause_mycary,GameScreenStage.pause_enemycarx,GameScreenStage.pause_enemycary,GameScreenStage.pause_korlatx,GameScreenStage.pause_korlaty,GameScreenStage.pause_speed));
                        }
                    }
                });

                mute = new OneSpriteStaticActor(Assets.manager.get(Assets.MUTE_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }
                };
                mute.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        ifMuted = 1;//levan némítva
                        bgMusic.stop();
                    }
                });

                unmute = new OneSpriteStaticActor(Assets.manager.get(Assets.UNMUTE_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }
                };
                unmute.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        ifMuted = 0;//nincs lenémítva
                    }
                });

                controlF = new OneSpriteStaticActor(Assets.manager.get(Assets.CONTROLF_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }
                };
                controlF.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        controlType = 0;//döntős irányítás
                    }
                });

                controlT = new OneSpriteStaticActor(Assets.manager.get(Assets.CONTROLT_TEXTURE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }
                };
                controlT.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        controlType = 1;//tapogatós irányítás, de ez sem boolean édes istenem XD
                    }
                });

                carChoose = new OneSpriteStaticActor(Assets.manager.get(Assets.CAR_CHOOSE)){
                    @Override
                    public void setDebug(boolean enabled) {
                        super.setDebug(false);
                    }
                };

                carChoose.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new ChoosingScreenStage(game));
                    }
                });

                back.setPosition(865, 100);
                back.setSize(200,200);

                mute.setSize(200,200);
                mute.setPosition(225,150);

                unmute.setSize(200,200);
                unmute.setPosition(430,150);

                controlF.setSize(200,200);
                controlF.setPosition(225,370);

                controlT.setSize(200,200);
                controlT.setPosition(430,370);

                carChoose.setSize(200,200);
                carChoose.setPosition(640,370);

                addActor(bg);
                addActor(back);
                addActor(mute);
                addActor(unmute);
                addActor(controlF);
                addActor(controlT);
                addActor(carChoose);
            }
        };
    }

    @Override
    public void init() {

    }

    public void render(float delta){
        super.render(delta);
        options.draw();
    }

    public void show(){
        Gdx.input.setInputProcessor(options);
    }
}
