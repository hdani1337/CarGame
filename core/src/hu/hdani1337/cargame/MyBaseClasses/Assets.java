package hu.hdani1337.cargame.MyBaseClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Assets {

    public static AssetManager manager;


    public static final AssetDescriptor<Texture> CAR_TEXTURE = new AssetDescriptor<Texture>("actors/car.png", Texture.class);
    public static final AssetDescriptor<Texture> ENEMY_TEXTURE = new AssetDescriptor<Texture>("actors/enemyCar.png", Texture.class);
    public static final AssetDescriptor<Texture> CAR_TEXTURE_CRASHED = new AssetDescriptor<Texture>("actors/carCrash.png", Texture.class);
    public static final AssetDescriptor<Texture> ENEMY_TEXTURE_CRASHED = new AssetDescriptor<Texture>("actors/enemyCarCrash.png", Texture.class);
    public static final AssetDescriptor<Texture> HATTER_TEXTURE = new AssetDescriptor<Texture>("bgs/bg.png", Texture.class);
    public static final AssetDescriptor<Texture> HATTER_TEXTURE_LOST = new AssetDescriptor<Texture>("bgs/bgLost.png", Texture.class);
    public static final AssetDescriptor<Texture> START_BUTTON = new AssetDescriptor<Texture>("actors/startButton.png", Texture.class);
    public static final AssetDescriptor<Music> HOME_ZENE = new AssetDescriptor<Music>("snd/ballblazer.mp3", Music.class);
    public static final AssetDescriptor<Music> GAME_ZENE = new AssetDescriptor<Music>("snd/kirby.mp3", Music.class);
    public static final AssetDescriptor<Sound> CRASH_SOUND = new AssetDescriptor<Sound>("snd/crash.wav", Sound.class);
    public static final AssetDescriptor<Texture> EASY_TEXTURE = new AssetDescriptor<Texture>("actors/diff/easy.png", Texture.class);
    public static final AssetDescriptor<Texture> MED_TEXTURE = new AssetDescriptor<Texture>("actors/diff/medium.png", Texture.class);
    public static final AssetDescriptor<Texture> HARD_TEXTURE = new AssetDescriptor<Texture>("actors/diff/hard.png", Texture.class);
    public static final AssetDescriptor<Texture> PAUSE_TEXTURE = new AssetDescriptor<Texture>("actors/pause.png", Texture.class);
    public static final AssetDescriptor<Texture> CONTINUE_TEXTURE = new AssetDescriptor<Texture>("actors/continue.png", Texture.class);
    public static void prepare() {
        manager = new AssetManager();
        Texture.setAssetManager(manager);
    }

    public static void load() {
        manager.load(CAR_TEXTURE);
        manager.load(ENEMY_TEXTURE);
        manager.load(HATTER_TEXTURE);
        manager.load(CAR_TEXTURE_CRASHED);
        manager.load(ENEMY_TEXTURE_CRASHED);
        manager.load(HATTER_TEXTURE_LOST);
        manager.load(START_BUTTON);
        manager.load(HOME_ZENE);
        manager.load(GAME_ZENE);
        manager.load(CRASH_SOUND);
        manager.load(EASY_TEXTURE);
        manager.load(MED_TEXTURE);
        manager.load(HARD_TEXTURE);
        manager.load(PAUSE_TEXTURE);
        manager.load(CONTINUE_TEXTURE);
    }

    public static void unload() {
        manager.dispose();
    }
}