package com.mygdx.game.MyBaseClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Assets {

    public static AssetManager manager;


    public static final AssetDescriptor<Texture> CAR_TEXTURE = new AssetDescriptor<Texture>("car.png", Texture.class);
    public static final AssetDescriptor<Texture> ENEMY_TEXTURE = new AssetDescriptor<Texture>("enemyCar.png", Texture.class);
    public static final AssetDescriptor<Texture> CAR_TEXTURE_CRASHED = new AssetDescriptor<Texture>("carCrash.png", Texture.class);
    public static final AssetDescriptor<Texture> ENEMY_TEXTURE_CRASHED = new AssetDescriptor<Texture>("enemyCarCrash.png", Texture.class);
    public static final AssetDescriptor<Texture> HATTER_TEXTURE = new AssetDescriptor<Texture>("bg.png", Texture.class);
    public static final AssetDescriptor<Texture> HATTER_TEXTURE_LOST = new AssetDescriptor<Texture>("bgLost.png", Texture.class);
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
    }

    public static void unload() {
        manager.dispose();
    }
}