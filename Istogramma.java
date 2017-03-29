package immagine;

import java.awt.*;

public class Istogramma extends Canvas {
    float[] frequenze;
    float max;
    public Istogramma(float[] f){
        frequenze=f;
        max=0;
        for(int i=0;i<frequenze.length;i++)
            if(frequenze[i]>max)
                max=frequenze[i];
    }
    public void paint(Graphics g){
        for(int i=0;i<frequenze.length;i++){
            g.setColor(Color.red);
            g.drawLine(i*5+10,700,i*5+10,(int)(700-(frequenze[i]/max*600)));
        }
    }
}
