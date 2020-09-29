package immagine;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JFileChooser;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.swing.FilePane;

public class OpenFile extends JFileChooser{
    public OpenFile(){
        super();
        setAcceptAllFileFilterUsed(false);
        String[] estensioni=new String[2];
        estensioni[0]="jpg";
        estensioni[1]="png";
        addChoosableFileFilter(new FileNameExtensionFilter("File JPG/PNG", estensioni));
    }
    public void updateUI(){
        LookAndFeel old = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Throwable ex) {
            old = null;
        } 

        super.updateUI();

        if(old != null){
            FilePane filePane = findFilePane(this);

            Color background = UIManager.getColor("Label.background");
            setBackground(background);
            setOpaque(true);

            try {
               UIManager.setLookAndFeel(old);
            } 
            catch (UnsupportedLookAndFeelException ignored) {} // shouldn't get here
        }
     }

    private static FilePane findFilePane(Container parent){
        for(Component comp: parent.getComponents()){
            if(FilePane.class.isInstance(comp)){
                return (FilePane)comp;
            }
            if(comp instanceof Container){
                Container cont = (Container)comp;
                if(cont.getComponentCount() > 0){
                    FilePane found = findFilePane(cont);
                    if (found != null) {
                        return found;
                    }
                }
            }
        }

        return null;
    }
}