package domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class MovingCharacter1 extends Character {

    private PixelReader pixel;
    private WritableImage writable;

    public MovingCharacter1(int x, int y, int imgNum) throws FileNotFoundException {
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

//        while (true) {
        try {
            int x = 0; //0 para que inicie en la pura orilla
            //int count =0; //va a llevar la cuenta 
            int count = 0;
//                System.out.println("X: "+x);
            for (int i = 0; i <= 23; i++) { //7
                //System.out.println("X: "+x);
                if (i == 8 || i == 16 || i == 24 || i == 32 || i == 40) //||i ==16 ||i==24
                {
                    count++;
                }
                super.setImage(sprite.get(i - (8 * count))); //i-(8*i)              
                super.setX(x);
                Thread.sleep(100);//velocidad
                x = x + 10; // x+100 --El aumento para que avance a la derecha
//                    System.out.println("X: "+x);
            }//for

            this.setY(500);
            super.setImage(sprite.get(0)); //imagen de pie
            Thread.sleep(200);//Hace que el subproceso que se está ejecutando en ese momento esté en suspensión 

            //Primer Salto
            int j = 240;//x
            int i = 500;//y
            while (i >= 330) {
                for (int k = 0; k < 2; k++) {

                    super.setImage(sprite.get(1)); //i-(8*i)              
                    super.setX(j);
                    j = j + 2;

                    super.setImage(sprite.get(1));//imagen saltando
                    this.setY(i); //arriba
                    i = i - 5;
                    Thread.sleep(60);
                }
            }

            //Baja del primer salto
            int d = 312;//x
            int s = 320;//y
            while (s <= 370) {
                for (int k = 0; k <= 2; k++) {
                    super.setImage(sprite.get(2)); //i-(8*i)              
                    super.setX(d);
//                    Thread.sleep(80);//velocidad
                    d = d + 5;
//                }
//                for (int k = 0; k <= 1; k++) {
                    super.setImage(sprite.get(2));//imagen saltando
                    this.setY(s); //arriba
                    Thread.sleep(60);
                    s = s + 3;
                }
            }
            //FIN PRIMER SALTO

            //SEGUNDA CAMINATA
            x = 402; //0 para que inicie en la pura orilla
            this.setY(370);
            //int count =0; //va a llevar la cuenta 
            count = 0;
//                System.out.println("X: "+x);
            for (int o = 0; o <= 7; o++) { //7
                //System.out.println("X: "+x);
                if (o == 8 || o == 16 || o == 24 || o == 32 || o == 40) //||i ==16 ||i==24
                {
                    count++;
                }
                super.setImage(sprite.get(o - (8 * count))); //i-(8*i)              
                super.setX(x);
                Thread.sleep(100);//velocidad
                x = x + 10; // x+100 --El aumento para que avance a la derecha
//                    System.out.println("X: "+x);
            }//for
            //FIN SEGUNDA CAMINATA

            super.setImage(sprite.get(0)); //imagen de pie
            Thread.sleep(200);//Hace que el subproceso que se está ejecutando en ese momento esté en suspensión 
            System.out.println("el X para el segundo salto " + x);

            //SEGUNDO SALTO
            //Primer Salto
            j = 482;//x
            i = 370;//y
            while (i >= 200) {
                for (int k = 0; k < 2; k++) {

                    super.setImage(sprite.get(1)); //i-(8*i)              
                    super.setX(j);
                    j = j + 1;

                    super.setImage(sprite.get(1));//imagen saltando
                    this.setY(i); //arriba
                    i = i - 5;
                    Thread.sleep(60);
                }
            }

            System.out.println("j: " + j + " i: " + i);

            //Baja del segundo salto
            d = 518;//x
            s = 190;//y
            while (s <= 235) {
                for (int k = 0; k <= 2; k++) {
                    super.setImage(sprite.get(2)); //i-(8*i)              
                    super.setX(d);
//                    Thread.sleep(80);//velocidad
                    d = d + 5;
//                }
//                for (int k = 0; k <= 1; k++) {
                    super.setImage(sprite.get(2));//imagen saltando
                    this.setY(s); //arriba
                    Thread.sleep(60);
                    s = s + 3;
                }
            }
            //FIN SEGUNDO SALTO
            System.out.println("d: " + d + " s: " + s);

            //Tercera CAMINATA
            x = 608; //0 para que inicie en la pura orilla
            this.setY(235);
            //int count =0; //va a llevar la cuenta 
            count = 0;
//                System.out.println("X: "+x);
            for (int o = 0; o <= 12; o++) { //7
                //System.out.println("X: "+x);
                if (o == 8 || o == 16 || o == 24 || o == 32 || o == 40) //||i ==16 ||i==24
                {
                    count++;
                }
                super.setImage(sprite.get(o - (8 * count))); //i-(8*i)              
                super.setX(x);
                Thread.sleep(100);//velocidad
                x = x + 10; // x+100 --El aumento para que avance a la derecha
//                    System.out.println("X: "+x);
            }//for

            count = 8;
//                System.out.println("X: "+x);
            for (int c = 0; c <= 13; c++) { //7
                // System.out.println("X: "+x);
                if (c == 8 || c == 16 || c == 24 || c == 32 || c == 40) //||i ==16 ||i==24
                {
                    count = 8;
                }
                super.setImage(sprite.get(count)); //i-(8*count)) 
                x = x - 10; //Disminuye para que avance a la izquierda
                super.setX(x);
                Thread.sleep(100);//velocidad
                //x = x-20; // x+100
                count++;
            }//for
            //FIN TERCERA CAMINATA

            Image imagen = new Image(new FileInputStream("src/Assets/Running4.1.png"));
            this.pixel = imagen.getPixelReader();
            int count1 = 0;
            for (int l = 0; l < 34; l++) {
                this.writable = new WritableImage(this.pixel, 20+count1, 0, 34-count1, 54); //Lee los pixeles (imagen, xInicio, yInicio, xFin, yFin)
                super.setImage(this.writable);
                super.setX(598); //drawIagen tambien puede recibir un writableImage
                super.setY(235);
                Thread.sleep(100);
                count1+=5;
            }

        } catch (InterruptedException ex) {
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MovingCharacter1.class.getName()).log(Level.SEVERE, null, ex);
        }
//        }
    }

}//RunningCharacter
