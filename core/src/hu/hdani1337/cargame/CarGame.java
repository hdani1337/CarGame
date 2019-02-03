package hu.hdani1337.cargame;

import hu.hdani1337.cargame.MyBaseClasses.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Game.MyGame;

import hu.hdani1337.cargame.Screen.Home.HomeScreenStage;

public class CarGame extends MyGame {
    @Override
    public void create () {
        Assets.prepare();
        Assets.load();
        System.out.println("Loading");
        while (!Assets.manager.update()){
            System.out.print(".");
        }
        setScreen(new HomeScreenStage(this));
    }

}