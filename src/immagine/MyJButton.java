package immagine;

import java.awt.Font;
import javax.swing.JButton;

public class MyJButton extends JButton {
    public MyJButton(String text){
        super(text);
        setFont(new Font("Calibri",Font.PLAIN,30));
        setBorder(null);
    }
}
