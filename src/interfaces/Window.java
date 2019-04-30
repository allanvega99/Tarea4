package interfaces;

import domain.JumpingCharacter;
import domain.MovingCharacter1;
import domain.RunningCharacter;
import domain.StandingCharacter;
import utility.Variables;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.BufferOverflowException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Window extends Application implements Runnable{

    
    private Thread thread; //hilos
    private Scene scene;
    private Pane pane;
    private Canvas canvas; 
    private Image image; 
    private WritableImage writable; //convierte pixeles en una imagen
    //clases
    private StandingCharacter sc;
    private RunningCharacter rc;
    private JumpingCharacter jc;
    private MovingCharacter1 mc;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Graphics and Threads");
        initComponents(primaryStage);
        primaryStage.setOnCloseRequest(exit);
        primaryStage.show();
    }

    @Override
    public void run() {
        
        long start; //comienzo
        long elapsed; //transcurrido
        long wait; //esperar
        int fps = 30;
        long time = 1000/fps; //tiempo

        while(true){
            try {
                start=System.nanoTime();
                elapsed=System.nanoTime()-start;                    
                wait = time-elapsed/1000000;
                //System.out.println("Time:"+time+"  Start:"+start+"  Elapsed:"+elapsed+"  WAIT: "+wait);
                Thread.sleep(wait); //33
                GraphicsContext gc = this.canvas.getGraphicsContext2D();
                draw(gc);
            } 
            catch (InterruptedException ex) {}
        }
    }//RUN

    private void initComponents(Stage primaryStage) { //iniciar componentes
        try {
            this.pane = new Pane();
            this.scene = new Scene(this.pane, Variables.WIDTH, Variables.HEIGHT);// pane >> scene
            this.canvas = new Canvas(Variables.WIDTH, Variables.HEIGHT);
            this.image = new Image(new FileInputStream("src/Assets/background.png"));
            //                                         //dirección de la imagen
            this.pane.getChildren().add(this.canvas); // canvas >> pane

            primaryStage.setScene(this.scene); // canvas >> pane >> scene ->  primaryStage
            
            //INICIALIZAMOS cada hilo (personaje) y lo iniciamos
            this.sc = new StandingCharacter(600, 50, 0);
            this.sc.start();
            
            this.rc = new RunningCharacter(-50, 500, 0);
            this.rc.start();
            
            this.jc = new JumpingCharacter(450, 370, 2);
            this.jc.start();
            this.mc = new MovingCharacter1(-50, 500, 0);
            this.mc.start();
            
            this.thread = new Thread(this);
            this.thread.start();
        } 
        catch (FileNotFoundException ex){}
        catch (BufferOverflowException ex){}
    }

    private void draw(GraphicsContext gc){
        gc.clearRect(0, 0, Variables.WIDTH, Variables.HEIGHT);
        gc.drawImage(this.image, 0, 0);
        gc.drawImage(this.sc.getImage(), this.sc.getX(), this.sc.getY());
        gc.drawImage(this.rc.getImage(), this.rc.getX(), this.rc.getY());
        gc.drawImage(this.jc.getImage(), this.jc.getX(), this.jc.getY());
        gc.drawImage(this.mc.getImage(), this.mc.getX(), this.mc.getY());
    }
    
    EventHandler<WindowEvent> exit = new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            System.exit(0); //Termina la Java Virtual Machine actualmente en ejecución.
        }
    };
}
