package immagine;

import static immagine.Grafica.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Immagine {
    public static void main(String[] args) throws IOException {
        int altezza;
        int larghezza;
        Color colore;
        String link="mare.jpg";
        int min;
        int max;
        float p;
        int[][] m;
        Istogramma ig;
        // vettore frequenze del canale R
        float[] canaleR=new float[256];
        for(int i=0;i<canaleR.length;i++)
            canaleR[i]=0;
        // istanza immagine campione (input)
        BufferedImage imgIN=ImageIO.read(new File(link));
        // acquisizione altezza e larghezza immagine
        altezza=imgIN.getHeight();
        larghezza=imgIN.getWidth();
        // metodo per visualizzare l'immagine
        visualizzaImmagine("Immagine campione",link,larghezza,altezza);
        System.out.println("Dimensioni dell'immagine= "+larghezza+" x "+altezza);
        m=new int[altezza][larghezza];
        for(int i=0;i<altezza;i++){
            for(int j=0;j<larghezza;j++){
                colore = new Color(imgIN.getRGB(j,i));
                m[i][j]=colore.getRed();
                canaleR[(m[i][j])]++;
            }
        }
        // istanza dell'oggetto Istogramma
        ig=new Istogramma(canaleR);
        // metodo per visualizzare l'istogramma delle frequenze del canale R
        visualizzaIstogramma(ig);
        // trova valore minimo e massimo
        min=m[0][0]; max=m[0][0];
        for(int i=0;i<altezza;i++)
            for(int j=0;j<larghezza;j++){
                if(m[i][j]<min)
                    min=m[i][j];
                if(m[i][j]>max)
                    max=m[i][j];
            }
        // ripartizione della matrice da 0 a max-min
        for(int i=0;i<altezza;i++)
            for(int j=0;j<larghezza;j++)
                m[i][j]=m[i][j]-min;
        System.out.println("Valore MAX canale RED= "+max);
        System.out.println("Valore MIN canale RED= "+min);
        System.out.println("MAX-MIN= "+(max-min));
        // fattore di normalizzazione
        p=((float)255)/(max-min);
        System.out.println("FATTORE DI NORMALIZZAZIONE= "+p);
        // normalizzazione
        for(int i=0;i<altezza;i++)
            for(int j=0;j<larghezza;j++){
                float temp=m[i][j]*p;
                m[i][j]=(int)temp;
                if(temp-((int)temp)>0.5)
                    m[i][j]++;
            }
    }
}   

