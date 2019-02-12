package hu.hdani1337.cargame.MyBaseClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

public class Assets {

    public static AssetManager manager;

    //szöveghez kell - begin
    public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";

    static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();

    static {
        fontParameter.fontFileName = "font0.ttf";
        fontParameter.fontParameters.size = 30;
        fontParameter.fontParameters.characters = CHARS;
        fontParameter.fontParameters.color = Color.WHITE;
    }
    //szöveghez kell - end

    public static final AssetDescriptor<Texture> CAR_TEXTURE = new AssetDescriptor<Texture>("actors/car.png", Texture.class); //én autóm
    public static final AssetDescriptor<Texture> ENEMY_TEXTURE = new AssetDescriptor<Texture>("actors/enemyCar.png", Texture.class); //ellenfél autó
    public static final AssetDescriptor<Texture> CAR_TEXTURE_CRASHED = new AssetDescriptor<Texture>("actors/carCrash.png", Texture.class); //én autóm ütközve
    public static final AssetDescriptor<Texture> ENEMY_TEXTURE_CRASHED = new AssetDescriptor<Texture>("actors/enemyCarCrash.png", Texture.class); //ellenfél autó ütközve
    public static final AssetDescriptor<Texture> HATTER_TEXTURE = new AssetDescriptor<Texture>("bgs/bg.png", Texture.class); //háttér
    public static final AssetDescriptor<Texture> HATTER_TEXTURE_LOST = new AssetDescriptor<Texture>("bgs/bgLost.png", Texture.class); //háttér vesztés esetén
    public static final AssetDescriptor<Texture> SZOVEG_HATTER = new AssetDescriptor<Texture>("bgs/bgText.png", Texture.class); //szöveg háttere (kicsi fekete kocka)
    public static final AssetDescriptor<Music> HOME_ZENE = new AssetDescriptor<Music>("snd/ballblazer.mp3", Music.class); //kezdőképernyő zene, Ballblazer zenéje
    public static final AssetDescriptor<Music> GAME_ZENE = new AssetDescriptor<Music>("snd/kirby.mp3", Music.class); //játék zenéje, Kirby zenéje
    public static final AssetDescriptor<Sound> CRASH_SOUND = new AssetDescriptor<Sound>("snd/crash.wav", Sound.class); //ütközés hang
    public static final AssetDescriptor<Texture> EASY_TEXTURE = new AssetDescriptor<Texture>("actors/diff/easy.png", Texture.class); //könnyű fokozat gomb
    public static final AssetDescriptor<Texture> MED_TEXTURE = new AssetDescriptor<Texture>("actors/diff/medium.png", Texture.class); //közepes fokozat gomb
    public static final AssetDescriptor<Texture> HARD_TEXTURE = new AssetDescriptor<Texture>("actors/diff/hard.png", Texture.class); //nehéz fokozat gomb
    public static final AssetDescriptor<Texture> PAUSE_TEXTURE = new AssetDescriptor<Texture>("actors/btns/pause.png", Texture.class); //megállítás gomb
    public static final AssetDescriptor<Texture> CONTINUE_TEXTURE = new AssetDescriptor<Texture>("actors/btns/continue.png", Texture.class); //folytatás gomb
    public static final AssetDescriptor<Texture> EXIT_TEXTURE = new AssetDescriptor<Texture>("actors/btns/exit.png", Texture.class); //kilépés gomb
    public static final AssetDescriptor<Texture> BLOCK_TEXTURE = new AssetDescriptor<Texture>("actors/block.png", Texture.class); //akadály
    public static final AssetDescriptor<Texture> BLOCK_CRASH_TEXTURE = new AssetDescriptor<Texture>("actors/blockCrash.png", Texture.class); //akadály ütközve
    public static final AssetDescriptor<Texture> SETTINGS_TEXTURE = new AssetDescriptor<Texture>("actors/btns/settings.png", Texture.class); //beállítások gomb
    public static final AssetDescriptor<Texture> BACK_TEXTURE = new AssetDescriptor<Texture>("actors/btns/back.png", Texture.class); //visszalépés gomb
    public static final AssetDescriptor<Texture> INFO_TEXTURE = new AssetDescriptor<Texture>("actors/btns/info.png", Texture.class); //információ gomb
    public static final AssetDescriptor<Texture> CONTROLF_TEXTURE = new AssetDescriptor<Texture>("actors/btns/control_flip.png", Texture.class); //döntés irányító gomb
    public static final AssetDescriptor<Texture> CONTROLT_TEXTURE = new AssetDescriptor<Texture>("actors/btns/control_touch.png", Texture.class); //tapintás irányító gomb
    public static final AssetDescriptor<Texture> MUTE_TEXTURE = new AssetDescriptor<Texture>("actors/btns/mute.png", Texture.class); //némító gomb
    public static final AssetDescriptor<Texture> UNMUTE_TEXTURE = new AssetDescriptor<Texture>("actors/btns/unmute.png", Texture.class); //némítás feloldó gomb
    public static final AssetDescriptor<Texture> LEFT_ARROW = new AssetDescriptor<Texture>("actors/btns/left.png", Texture.class); //balra nyíl tapintásnál
    public static final AssetDescriptor<Texture> RIGHT_ARROW = new AssetDescriptor<Texture>("actors/btns/right.png", Texture.class); //jobbra nyíl irányításnál
    public static final AssetDescriptor<BitmapFont> ARIAL = new AssetDescriptor<BitmapFont>(fontParameter.fontFileName, BitmapFont.class, fontParameter); //betütípus, még véletlenül sem arial, csak lusta vagyok átírni
    public static void prepare() {
        manager = new AssetManager();
        Texture.setAssetManager(manager);
    }

    public static void load() {
        FileHandleResolver resolver = new InternalFileHandleResolver();
        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
        manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));

        //textúrák meghívása
        manager.load(CAR_TEXTURE);
        manager.load(ENEMY_TEXTURE);
        manager.load(HATTER_TEXTURE);
        manager.load(CAR_TEXTURE_CRASHED);
        manager.load(ENEMY_TEXTURE_CRASHED);
        manager.load(HATTER_TEXTURE_LOST);
        manager.load(SZOVEG_HATTER);
        manager.load(HOME_ZENE);
        manager.load(GAME_ZENE);
        manager.load(CRASH_SOUND);
        manager.load(EASY_TEXTURE);
        manager.load(MED_TEXTURE);
        manager.load(HARD_TEXTURE);
        manager.load(PAUSE_TEXTURE);
        manager.load(CONTINUE_TEXTURE);
        manager.load(EXIT_TEXTURE);
        manager.load(BLOCK_TEXTURE);
        manager.load(BLOCK_CRASH_TEXTURE);
        manager.load(SETTINGS_TEXTURE);
        manager.load(BACK_TEXTURE);
        manager.load(INFO_TEXTURE);
        manager.load(CONTROLT_TEXTURE);
        manager.load(CONTROLF_TEXTURE);
        manager.load(MUTE_TEXTURE);
        manager.load(UNMUTE_TEXTURE);
        manager.load(LEFT_ARROW);
        manager.load(RIGHT_ARROW);
        manager.load(ARIAL);
    }

    public static void unload() {
        manager.dispose();
    }
}