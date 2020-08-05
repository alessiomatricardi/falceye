package immagine;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener {
    Immagine campione;
    Immagine confronto;
    MyJButton sceltaCampione;
    MyJButton visualizzaIMGCampione;
    MyJButton visualizzaIstogrammaCampione;
    MyJButton visualizzaIMGNormCampione;
    MyJButton visualizzaIstogrammaNormCampione;
    MyJButton salvaImmagineNormCampione;
    MyJButton visualizzaEdgeCampione;
    MyJButton sceltaConfronto;
    MyJButton visualizzaIMGConfronto;
    MyJButton visualizzaIstogrammaConfronto;
    MyJButton visualizzaIMGNormConfronto;
    MyJButton visualizzaIstogrammaNormConfronto;
    MyJButton salvaImmagineNormConfronto;
    MyJButton visualizzaEdgeConfronto;
    JTextField testo; 
    MyJButton calcolaBordi;
    MyJButton correlazione;
    MyJButton esci;
    public MainFrame(){
        super("Lynx");
        setSize(1600,600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,1)); 
        
        sceltaCampione=new MyJButton("Scegli file...");
        visualizzaIMGCampione=new MyJButton("<html><div align='center'>Visualizza<br>immagine</div></html>");
        visualizzaIstogrammaCampione=new MyJButton("<html><div align='center'>Istogramma<br>dei livelli RGB</div></html>");
        visualizzaIMGNormCampione=new MyJButton("<html><div align='center'>Visualizza<br>immagine<br>normalizzata</div></html>");
        visualizzaIstogrammaNormCampione=new MyJButton("<html><div align='center'>Istogramma<br>dei livelli RGB<br>normalizzato</div></html>");
        salvaImmagineNormCampione=new MyJButton("<html><div align='center'>Salva immagine<br>normalizzata</div></html>");
        visualizzaEdgeCampione=new MyJButton("<html><div align='center'>Visualizza<br>edge</div></html>");
        sceltaConfronto=new MyJButton("Scegli file...");
        visualizzaIMGConfronto=new MyJButton("<html><div align='center'>Visualizza<br>immagine</div></html>");
        visualizzaIstogrammaConfronto=new MyJButton("<html><div align='center'>Istogramma<br>dei livelli RGB</div></html>");
        visualizzaIMGNormConfronto=new MyJButton("<html><div align='center'>Visualizza<br>immagine<br>normalizzata</div></html>");
        visualizzaIstogrammaNormConfronto=new MyJButton("<html><div align='center'>Istogramma<br>dei livelli RGB<br>normalizzato</div></html>");
        salvaImmagineNormConfronto=new MyJButton("<html><div align='center'>Salva immagine<br>normalizzata</div></html>");
        visualizzaEdgeConfronto=new MyJButton("<html><div align='center'>Visualizza<br>edge</div></html>");
        testo=new JTextField(3);
        testo.setFont(new Font("Calibri", Font.BOLD, 50));
        calcolaBordi=new MyJButton("Edge detection");
        correlazione=new MyJButton("<html><div align='center'>Calcola<br>correlazione</div></html>");
        esci=new MyJButton("Esci");
        
        sceltaCampione.addActionListener(this);
        visualizzaIMGCampione.addActionListener(this);
        visualizzaIstogrammaCampione.addActionListener(this);
        visualizzaIMGNormCampione.addActionListener(this);
        visualizzaIstogrammaNormCampione.addActionListener(this);
        salvaImmagineNormCampione.addActionListener(this);
        visualizzaEdgeCampione.addActionListener(this);
        sceltaConfronto.addActionListener(this);
        visualizzaIMGConfronto.addActionListener(this);
        visualizzaIstogrammaConfronto.addActionListener(this);
        visualizzaIMGNormConfronto.addActionListener(this);
        visualizzaIstogrammaNormConfronto.addActionListener(this);
        salvaImmagineNormConfronto.addActionListener(this);
        visualizzaEdgeConfronto.addActionListener(this);
        calcolaBordi.addActionListener(this);
        correlazione.addActionListener(this);
        esci.addActionListener(this);
        
        visualizzaIMGCampione.setEnabled(false);
        visualizzaIstogrammaCampione.setEnabled(false);
        visualizzaIMGNormCampione.setEnabled(false);
        visualizzaIstogrammaNormCampione.setEnabled(false);
        salvaImmagineNormCampione.setEnabled(false);
        visualizzaEdgeCampione.setEnabled(false);
        sceltaConfronto.setEnabled(false);
        visualizzaIMGConfronto.setEnabled(false);
        visualizzaIstogrammaConfronto.setEnabled(false);
        visualizzaIMGNormConfronto.setEnabled(false);
        visualizzaIstogrammaNormConfronto.setEnabled(false);
        salvaImmagineNormConfronto.setEnabled(false);
        visualizzaEdgeConfronto.setEnabled(false);
        correlazione.setEnabled(false);
        calcolaBordi.setEnabled(false);
        
        
        JPanel panelCampione=new JPanel();
        panelCampione.setLayout(new GridLayout(1,7,10,10)); 
        panelCampione.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); 
        panelCampione.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        JPanel panelConfronto=new JPanel();
        panelConfronto.setLayout(new GridLayout(1,7,10,10)); 
        panelConfronto.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); 
        panelConfronto.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        JPanel panelOperazioni=new JPanel();
        panelOperazioni.setLayout(new GridLayout(1,7,10,10)); 
        panelOperazioni.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); 
        panelOperazioni.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        JPanel edgePanel=new JPanel();
        edgePanel.setLayout(new GridLayout(2,1,5,5)); 
        edgePanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        edgePanel.add(testo);
        edgePanel.add(calcolaBordi);
        
        panelCampione.add(sceltaCampione);
        panelCampione.add(visualizzaIMGCampione);
        panelCampione.add(visualizzaIstogrammaCampione);
        panelCampione.add(visualizzaIMGNormCampione);
        panelCampione.add(visualizzaIstogrammaNormCampione);
        panelCampione.add(salvaImmagineNormCampione);
        panelCampione.add(visualizzaEdgeCampione);
        panelConfronto.add(sceltaConfronto);
        panelConfronto.add(visualizzaIMGConfronto);
        panelConfronto.add(visualizzaIstogrammaConfronto);
        panelConfronto.add(visualizzaIMGNormConfronto);
        panelConfronto.add(visualizzaIstogrammaNormConfronto);
        panelConfronto.add(salvaImmagineNormConfronto);
        panelConfronto.add(visualizzaEdgeConfronto);
        panelOperazioni.add(edgePanel);
        panelOperazioni.add(correlazione);
        panelOperazioni.add(esci);
        
        add(panelCampione);
        add(panelConfronto);
        add(panelOperazioni);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==sceltaCampione){
            try{
                campione=new Immagine();
                visualizzaIMGCampione.setEnabled(true);
                visualizzaIstogrammaCampione.setEnabled(true);
                visualizzaIMGNormCampione.setEnabled(true);
                visualizzaIstogrammaNormCampione.setEnabled(true);
                salvaImmagineNormCampione.setEnabled(true);
                visualizzaEdgeCampione.setEnabled(false);
                sceltaConfronto.setEnabled(true);
            }catch(CaricamentoErrato ex){}
        }
        if(e.getSource()==visualizzaIMGCampione){
            campione.visualizzaImmagine();
        }
        if(e.getSource()==visualizzaIstogrammaCampione){
            campione.visualizzaIstogramma();
        }
        if(e.getSource()==visualizzaIMGNormCampione){
            campione.visualizzaImmagineNormalizzata();
        }
        if(e.getSource()==visualizzaIstogrammaNormCampione){
            campione.visualizzaIstogrammaNormalizzato();
        }
        if(e.getSource()==salvaImmagineNormCampione){
            try {
                campione.salvaImmagineNormalizzata();
            } catch (IOException ex) {}
        }
        if(e.getSource()==visualizzaEdgeCampione){
            campione.visualizzaEdgeImage();
        }
        if(e.getSource()==sceltaConfronto){
            try{
                confronto=new Immagine(campione.getHeight(),campione.getWidth());
                visualizzaIMGConfronto.setEnabled(true);
                visualizzaIstogrammaConfronto.setEnabled(true);
                visualizzaIMGNormConfronto.setEnabled(true);
                visualizzaIstogrammaNormConfronto.setEnabled(true);
                salvaImmagineNormConfronto.setEnabled(true);
                visualizzaEdgeConfronto.setEnabled(false);
                calcolaBordi.setEnabled(true);
            }catch(CaricamentoErrato ex){}
            catch(DimensioniErrate ex){
                FrameDimensioni f = new FrameDimensioni();
            }
        }
        if(e.getSource()==visualizzaIMGConfronto){
            confronto.visualizzaImmagine();
        }
        if(e.getSource()==visualizzaIstogrammaConfronto){
            confronto.visualizzaIstogramma();
        }
        if(e.getSource()==visualizzaIMGNormConfronto){
            confronto.visualizzaImmagineNormalizzata();
        }
        if(e.getSource()==visualizzaIstogrammaNormConfronto){
            confronto.visualizzaIstogrammaNormalizzato();
        }
        if(e.getSource()==salvaImmagineNormConfronto){
            try {
                confronto.salvaImmagineNormalizzata();
            } catch (IOException ex) {}
        }
        if(e.getSource()==visualizzaEdgeConfronto){
            confronto.visualizzaEdgeImage();
        }
        if(e.getSource()==calcolaBordi){
            try{
                int valore=Integer.parseInt(testo.getText());
                campione.edgeDetection(valore);
                confronto.edgeDetection(valore);
                visualizzaEdgeCampione.setEnabled(true);
                visualizzaEdgeConfronto.setEnabled(true);
                correlazione.setEnabled(true);
            }catch(NumberFormatException ex){}
        }
        if(e.getSource()==correlazione){
            double risultato = campione.correlazione(confronto.getEdge());
            FrameCorrelazione f=new FrameCorrelazione(risultato);
        }
        if(e.getSource()==esci){
            WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
            this.dispatchEvent(close);
        }
    }
}
