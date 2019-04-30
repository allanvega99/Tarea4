package domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class StandingCharacter extends Character {

    public StandingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for(int i = 0; i <= 4; i++){//Le asigno un número a cada imagen, con el cual se manejará en el sig metodo
                                    //Le asigno el número con el "i" y a la vez a la imagen
            //sprite.add(new Image(new FileInputStream("src/Assets/Standing"+i+".png")));
            sprite.add(i, new Image(new FileInputStream("src/Assets/Standing"+i+".png")) );
        }//for
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        int speed = 150;//velocidad
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0)); //Aquí es donde utiliza el número de la imagen
        while (true) {
            try {
                Thread.sleep(speed+700); //850
                for(int i = 0; i <= 4; i++){
                    super.setImage(sprite.get(i));//Aquí es donde utiliza el número de la imagen
                    Thread.sleep(speed);            //la pone según avance el for
                }//for
                
            }//try
            catch (InterruptedException ex) { }
        }//while
    }//run
    
}//
