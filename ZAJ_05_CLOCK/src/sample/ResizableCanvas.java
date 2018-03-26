package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.Calendar;

public class ResizableCanvas extends Canvas {

    private GraphicsContext gc;
    private double height;
    private double width;
    private double padding = 0;
    private double numeralSpacing = 20;
    private double radius = 0;
    private  int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12};


    public ResizableCanvas() {
        widthProperty().addListener(evt -> onDraw());
        heightProperty().addListener(evt -> onDraw());
    }

    public  void initClock(){
        height = getHeight() - 20;
        width = getWidth();
        padding = numeralSpacing+30;
        double min = Math.min(height,width);
        radius = min/2-padding;

        gc = getGraphicsContext2D();
        gc.clearRect(0, 0, width, height);
    }

    public void onDraw()
    {
        initClock();
        drawCircle();
        drawNumeral();
        drawHands();

    }

    private void drawCircle() {
       gc.setStroke(Color.rgb(2,136,209));
        gc.setLineWidth(10);
        gc.setFill(Color.rgb(33,199,255,0.6));
        gc.fillOval(20, 20, height - 38, height - 38);
        gc.strokeOval(20,20,height - 38,height - 38);
    }
    private void drawNumeral() {
        for(int number : numbers){
            String tmp = String.valueOf(number);
            double angle = Math.PI / 6 * (number-3);
            int x = (int) (height/2+Math.cos(angle)*radius-height/50);
            int y = (int) (height/2+Math.sin(angle)*radius+height/40);
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(1);
            gc.setFont(new Font("default", height/15));
            gc.setFill(Color.rgb(210,239,255));
            gc.fillText(tmp, x, y);

        }
    }
    private void drawHand(double time, double len){
        double angle = Math.PI * time / 30 - Math.PI / 2;
        double handRadius = radius - len * height / 50;
        gc.strokeLine(height/2,height/2,height/2+Math.cos(angle)*handRadius,height/2+Math.sin(angle)*handRadius);
    }
    private void drawHands() {
        gc.setStroke(Color.rgb(255,255 ,255));
        gc.setLineWidth(8);
        Calendar c = Calendar.getInstance();
        float hour = c.get(Calendar.HOUR_OF_DAY);
        hour = hour > 12 ? hour - 12 : hour;
        drawHand((hour+c.get(Calendar.MINUTE) / 60) * 5.0,8);
        gc.setLineWidth(4);
        drawHand(c.get(Calendar.MINUTE), 5);
        gc.setLineWidth(3);
        drawHand(c.get(Calendar.SECOND), 3);
    }

    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double prefWidth(double height) {
        return getHeight();
    }

    @Override
    public double prefHeight(double width) {
        return getHeight();
    }
}