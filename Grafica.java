package immagine;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Grafica {
    public static void visualizzaImmagine (String nomeFrame, String percorso, int larghezza, int altezza){
        ImageIcon immagine=new ImageIcon(percorso);
        JLabel sfondo=new JLabel(immagine);
        JFrame f = new JFrame(nomeFrame);
        f.setSize(larghezza,altezza);
        f.setVisible(true);
        f.setLocation(100,50);
        f.add(sfondo);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public static void visualizzaIstogramma(Istogramma i){
        JFrame f=new JFrame("Istogramma canale R");
        f.setSize(1340,800);
        f.add(i);
        f.setVisible(true);
        f.setLocation(300,100);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
//ciaooo
