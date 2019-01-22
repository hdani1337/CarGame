package com.mygdx.game.MyBaseClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {

    public static AssetManager manager;

    public static final AssetDescriptor<Texture> CAR_TEXTURE = new AssetDescriptor<Texture>("car.png", Texture.class);
    public static final AssetDescriptor<Texture> ENEMY_TEXTURE = new AssetDescriptor<Texture>("enemyCar.png", Texture.class);
    public static void prepare() {
        manager = new AssetManager();
        Texture.setAssetManager(manager);
    }

    public static void load() {
        manager.load(CAR_TEXTURE);
        manager.load(ENEMY_TEXTURE);
    }

    public static void unload() {
        manager.dispose();
    }
}