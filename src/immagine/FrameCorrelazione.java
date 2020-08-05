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

public class FrameCorrelazione extends JFrame implements ActionListener{
    public FrameCorrelazione(double r){
        super("Risultato Correlazione");
        setSize(350,150);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setLayout(new GridLayout(3,1));
        
        Font m=new Font("Calibri",Font.BOLD,30);
        JLabel messaggio=new JLabel();
        if(r<(-0.05) || r>(0.05)){
            messaggio.setText("CONFORME");
            messaggio.setForeground(Color.green);
        }else{
            messaggio.setText("NON CONFORME");
            messaggio.setForeground(Color.red);
        }  
        messaggio.setHorizontalAlignment(JLabel.CENTER);
        messaggio.setSize(350,50);
        messaggio.setFont(m);
        
        double x = Math.floor(r * 10000.0) / 10000.0;
        
        Font f=new Font("Calibri",Font.PLAIN,20);
        JLabel risultato=new JLabel("RISULTATO CORRELAZIONE = "+x);
        risultato.setHorizontalAlignment(JLabel.CENTER);
        risultato.setSize(350,50);
        risultato.setFont(f);
        
        JPanel p=new JPanel();
        p.setSize(350,20);
        p.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        JButton ok=new JButton("<html><div align='center'>OK</div></html>");
        ok.setSize(50, 20);
        ok.addActionListener(this);
        p.add(ok);
        
        add(messaggio);
        add(risultato);
        add(p);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        this.dispatchEvent(close);
    }
}
