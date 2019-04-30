package domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;
                     //******EXTENDS******
//hereda todo el contenido de una clase dentro de la clase a la que se le aplica extends 
// ("bueno realmente todo no dependera de otros factores private, protect)
public class JumpingCharacter extends Character {
    
     //Constructor
    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i <= 2; i++) {
            switch(i){ //Le asigno un número a cada imagen, con el cual se manejará en el sig metodo
                case 0:                    
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Jumping2.png")) );
                    break;
                case 1:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Jumping0.png")) );
                    break;
                case 2:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Jumping1.png")) );
                    break;
            }//switch
        }
        //sprite.add(new Image(new FileInputStream("src/Assets/Jumping0.png"))); //añade imagen
    }//setSprite

    
    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0)); //Aquí es donde utiliza el número de la imagen  
        //                  x    y
        //JumpingCharacter(450, 370, 2);
        while (true) {                           
            try {
                this.setY(370);
                super.setImage(sprite.get(0)); //imagen de pie
                Thread.sleep(800);//Hace que el subproceso que se está ejecutando en ese momento esté en suspensión 

                for (int i = 370; i > 270; i=i-5) {
                    super.setImage(sprite.get(1));//imagen saltando
                    this.setY(i); //arriba
                    Thread.sleep(20);
                }
                
                for (int i = 270; i < 370; i=i+5) {
                    super.setImage(sprite.get(2));//imagen bajando
                    this.setY(i);//abajo 370
                    Thread.sleep(30);
                }//for
            }//try 
            catch (InterruptedException ex) {} 
        }//while
    }//RUN
    
}//JumpingCharacter
