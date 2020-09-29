package immagine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameIstogramma extends JFrame implements ActionListener {
    private JPanel pcb;
    private JCheckBox r;
    private JCheckBox g;
    private JCheckBox b;
    private Istogramma istogramma;

    public FrameIstogramma(Istogramma i, String n) {
        super("Istogramma" + n);
        this.pcb = new JPanel();
        this.r = new JCheckBox("R", true);
        this.g = new JCheckBox("G", true);
        this.b = new JCheckBox("B", true);
        this.pcb.add(this.r);
        this.pcb.add(this.g);
        this.pcb.add(this.b);
        this.istogramma = i;
        istogramma.setVisibilitaRGB();
        this.istogramma.setSize(800, 650);
        add(istogramma);
        add(pcb);
        setSize(800, 700);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        r.addActionListener(this);
        g.addActionListener(this);
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == r) istogramma.setVisibilitaRed(r.isSelected());
        if (e.getSource() == g) istogramma.setVisibilitaGreen(g.isSelected());
        if (e.getSource() == b) istogramma.setVisibilitaBlue(b.isSelected());
        repaint();
    }
}
