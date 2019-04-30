package domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i <= 15; i++) {//Le asigno un número a cada imagen, con el cual se manejará en el sig metodo
            //sprite.add(new Image(new FileInputStream("src/Assets/Running0.png")));
            switch (i) {
                case 0:
//                    Image imagen =  new Image(new FileInputStream("src/Assets/Running0png")) ;                    
//                    sprite.add(i, imagen);
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running0.png")));
                    break;
                case 1:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running1.png")));
                    break;
                case 2:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running2.png")));
                    break;
                case 3:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running3.png")));
                    break;
                case 4:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running4.png")));
                    break;
                case 5:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running5.png")));
                    break;
                case 6:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running6.png")));
                    break;
                case 7:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running7.png")));
                    break;
                //Imágenes el contrario
                case 8:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running0.1.png")));
                    break;
                case 9:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running1.1.png")));
                    break;
                case 10:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running2.1.png")));
                    break;
                case 11:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running3.1.png")));
                    break;
                case 12:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running4.1.png")));
                    break;
                case 13:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running5.1.png")));
                    break;
                case 14:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running6.1.png")));
                    break;
                case 15:
                    sprite.add(i, new Image(new FileInputStream("src/Assets/Running7.1.png")));
                    break;

            }//switch

        }
        super.setSprite(sprite); //establece la imagen 
    }

    @Override
    public void run() {          //obtiene la imagen
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0)); //Aquí es donde utiliza el número de la imagen  

        while (true) {
            int x = 0; //0 para que inicie en la pura orilla
            //int count =0; //va a llevar la cuenta 
            try {
                int count = 0;
//                System.out.println("X: "+x);
                for (int i = 0; i <= 38; i++) { //7
                    //System.out.println("X: "+x);
                    if (i == 8 || i == 16 || i == 24 || i == 32 || i == 40) //||i ==16 ||i==24
                    {
                        count++;
                    }
                    super.setImage(sprite.get(i - (8 * count))); //i-(8*i)              
                    super.setX(x);
                    Thread.sleep(500);//velocidad
                    x = x + 20; // x+100 --El aumento para que avance a la derecha
//                    System.out.println("X: "+x);
                }//for

                count = 8;
//                System.out.println("X: "+x);
                for (int i = 0; i <= 38; i++) { //7
                    // System.out.println("X: "+x);
                    if (i == 8 || i == 16 || i == 24 || i == 32 || i == 40) //||i ==16 ||i==24
                    {
                        count = 8;
                    }
                    super.setImage(sprite.get(count)); //i-(8*count)) 
                    x = x - 20; //Disminuye para que avance a la izquierda
                    super.setX(x);
                    Thread.sleep(500);//velocidad
                    //x = x-20; // x+100
                    count++;
//                    System.out.println("X: "+x);
                }//for

                //Esto es lo que estaba
//                super.setX(100); //izquierda
//                Thread.sleep(800);
//                //super.setImage(sprite.get(0) );
//                super.setX(700); //derecha
//                Thread.sleep(800);
            } catch (InterruptedException ex) {
            }
        }
    }

}//RunningCharacter
