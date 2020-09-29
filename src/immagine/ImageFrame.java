package immagine;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageFrame extends JFrame {
    ImageIcon icon;
    JLabel sfondo;

    public ImageFrame(String nomeFrame, Image immagine) {
        super(nomeFrame);
        icon = new ImageIcon(immagine);
        sfondo = new JLabel(icon);
        setSize(icon.getIconWidth(), icon.getIconHeight());
        setVisible(true);
        setLocationRelativeTo(null);
        add(sfondo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
