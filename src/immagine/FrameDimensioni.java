package immagine;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class FrameDimensioni extends JFrame implements ActionListener {
    public FrameDimensioni() {
        super("Errore dimensioni immagine");
        setSize(600, 100);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setLayout(new GridLayout(2, 1));

        Font m = new Font("Calibri", Font.PLAIN, 20);
        JLabel messaggio = new JLabel();
        messaggio.setText("Hai inserito un'immagine con dimensioni diverse da quella originale");
        messaggio.setHorizontalAlignment(JLabel.CENTER);
        messaggio.setSize(600, 50);
        messaggio.setFont(m);

        JPanel p = new JPanel();
        p.setSize(600, 20);
        p.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JButton ok = new JButton("<html><div align='center'>OK</a></html>");
        ok.setSize(50, 20);
        ok.addActionListener(this);
        p.add(ok);

        add(messaggio);
        add(p);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        this.dispatchEvent(close);
    }
}