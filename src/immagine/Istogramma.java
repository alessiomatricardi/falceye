package immagine;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Istogramma extends JPanel {
    float[] red;
    float[] green;
    float[] blue;
    float max;
    String colore;
    boolean visRed;
    boolean visGreen;
    boolean visBlue;

    public Istogramma(float[] r, float[] g, float[] b) {
        red = r;
        green = g;
        blue = b;
        max = 0;
        for (int i = 0; i < 256; i++) {
            if (red[i] > max)
                max = red[i];
            if (green[i] > max)
                max = green[i];
            if (blue[i] > max)
                max = blue[i];
        }
        setVisibilitaRGB();
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < 256; i++) {
            g.setColor(Color.red);
            if (visRed && (red[i] / max * 600) != 0)
                g.drawLine(i * 3 + 10, 650, i * 3 + 10, (int) (650 - (red[i] / max * 600)));
            g.setColor(Color.green);
            if (visGreen && (green[i] / max * 600) != 0)
                g.drawLine(i * 3 + 11, 650, i * 3 + 11, (int) (650 - (green[i] / max * 600)));
            g.setColor(Color.blue);
            if (visBlue && (blue[i] / max * 600) != 0)
                g.drawLine(i * 3 + 12, 650, i * 3 + 12, (int) (650 - (blue[i] / max * 600)));
        }
    }

    public void setVisibilitaRGB() {
        visRed = true;
        visGreen = true;
        visBlue = true;
    }

    public void setVisibilitaRed(boolean visRed) {
        this.visRed = visRed;
    }

    public void setVisibilitaGreen(boolean visGreen) {
        this.visGreen = visGreen;
    }

    public void setVisibilitaBlue(boolean visBlue) {
        this.visBlue = visBlue;
    }
}
