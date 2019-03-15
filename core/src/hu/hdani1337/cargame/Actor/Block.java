package hu.hdani1337.cargame.Actor;

import com.badlogic.gdx.graphics.Texture;

import hu.hdani1337.cargame.Global.Assets;
import hu.hdani1337.cargame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Block extends OneSpriteStaticActor {
    private static boolean valami;

    public Block(Texture texture, boolean act) {
        super(texture);
        setDebug(false);
        addBaseCollisionRectangleShape();
        setSize(150,150);
        valami = act;
    }

    @Override
    public void act(float delta) {
        if(valami) {

            if (getY() + getHeight() < 0) {
                setY(2000);
            }

            if(getY()<=2000){
                setY(getY() - 5);
            }

            if (Car.sav == 1){
                if(getY() > 600) {
                    setX((425 - (getWidth() / 2)));
                }
            }

            if (Car.sav == 2){
                if(getY() > 600) {
                    setX((640 - (getWidth() / 2)));
                }
            }

            if (Car.sav == 3){
                if(getY() > 600) {
                    setX((863 - (getWidth() / 2)));
                }
            }
        }
    }
}
