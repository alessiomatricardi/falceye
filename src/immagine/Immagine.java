package immagine;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Immagine {
    BufferedImage imgIN;
    BufferedImage imgOUT;
    BufferedImage imgEdge;
    Istogramma igIN;
    Istogramma igOUT;
    public Immagine() throws CaricamentoErrato{
        try{
            boolean s=this.caricamento();
            if(s==false) throw new CaricamentoErrato();
        }catch(IOException e){
            throw new CaricamentoErrato();
        }
    }
    public Immagine(int altezza, int larghezza) throws CaricamentoErrato,DimensioniErrate{
        try{
            boolean s = this.caricamento();
            if(s == false) throw new CaricamentoErrato();
            if(this.getHeight() != altezza || this.getWidth() != larghezza) throw new DimensioniErrate();
        }catch(IOException e){
            throw new CaricamentoErrato();
        }
    }
    public boolean caricamento() throws IOException{
        OpenFile op=new OpenFile();
        int stato=op.showOpenDialog(op);
        File imgfile;
        if(stato == OpenFile.APPROVE_OPTION){
            imgfile = op.getSelectedFile();
            imgIN=ImageIO.read(imgfile);
            // caricamento
            int altezza=imgIN.getHeight();
            int larghezza=imgIN.getWidth();
            RGB[][] m=new RGB[altezza][larghezza];
            Color colore;
            float[] canaleR=new float[256];
            float[] canaleG=new float[256];
            float[] canaleB=new float[256];
            for(int i=0;i<canaleR.length;i++){
                canaleR[i]=0;
                canaleG[i]=0;
                canaleB[i]=0;
            }
            for(int i=0;i<altezza;i++)
                for(int j=0;j<larghezza;j++){
                    colore = new Color(imgIN.getRGB(j,i));
                    m[i][j]=new RGB(colore.getRed(),colore.getGreen(),colore.getBlue());
                    canaleR[(m[i][j]).getRed()]++;
                    canaleG[(m[i][j]).getGreen()]++;
                    canaleB[(m[i][j]).getBlue()]++;
                }
            // istanza dell'oggetto Istogramma
            igIN=new Istogramma(canaleR,canaleG,canaleB);
            float[] canaleR2=new float[256];
            float[] canaleG2=new float[256];
            float[] canaleB2=new float[256];
            for(int i=0;i<canaleR2.length;i++){
                canaleR2[i]=0;
                canaleG2[i]=0;
                canaleB2[i]=0;
            }
            // normalizzazione canale R
            // trova valore minimo e massimo
            int min=m[0][0].getRed(); int max=m[0][0].getRed();
            float p;
            for(int i=0;i<altezza;i++)
                for(int j=0;j<larghezza;j++){
                    if(m[i][j].getRed()<min)
                        min=m[i][j].getRed();
                    if(m[i][j].getRed()>max)
                        max=m[i][j].getRed();
                }
            // ripartizione della matrice da 0 a max-min
            for(int i=0;i<altezza;i++)
                for(int j=0;j<larghezza;j++)
                    m[i][j].setRed(m[i][j].getRed()-min);
            // fattore di normalizzazione
            p=((float)255)/(max-min);
            // normalizzazione
            float[] n=new float[256];
            for(int i=0;i<256;i++)
                n[i]=i*p;
            for(int i=0;i<altezza;i++)
                for(int j=0;j<larghezza;j++){
                    m[i][j].setRed(Math.round(n[(m[i][j].getRed())]));
                    canaleR2[(m[i][j]).getRed()]++;
                }
            // normalizzazione canale G
            // trova valore minimo e massimo
            min=m[0][0].getGreen(); max=m[0][0].getGreen();
            for(int i=0;i<altezza;i++)
                for(int j=0;j<larghezza;j++){
                    if(m[i][j].getGreen()<min)
                        min=m[i][j].getGreen();
                    if(m[i][j].getGreen()>max)
                        max=m[i][j].getGreen();
                }
            // ripartizione della matrice da 0 a max-min
            for(int i=0;i<altezza;i++)
                for(int j=0;j<larghezza;j++)
                    m[i][j].setGreen(m[i][j].getGreen()-min);
            // fattore di normalizzazione
            p=((float)255)/(max-min);
            // normalizzazione
            for(int i=0;i<256;i++)
                n[i]=i*p;
            for(int i=0;i<altezza;i++)
                for(int j=0;j<larghezza;j++){
                    m[i][j].setGreen(Math.round(n[(m[i][j].getGreen())]));
                    canaleG2[(m[i][j]).getGreen()]++;
                }
            // normalizzazione canale B
            // trova valore minimo e massimo
            min=m[0][0].getBlue(); max=m[0][0].getBlue();
            for(int i=0;i<altezza;i++)
                for(int j=0;j<larghezza;j++){
                    if(m[i][j].getBlue()<min)
                        min=m[i][j].getBlue();
                    if(m[i][j].getBlue()>max)
                        max=m[i][j].getBlue();
                }
            // ripartizione della matrice da 0 a max-min
            for(int i=0;i<altezza;i++)
                for(int j=0;j<larghezza;j++)
                    m[i][j].setBlue(m[i][j].getBlue()-min);
            // fattore di normalizzazione
            p=((float)255)/(max-min);
            // normalizzazione
            for(int i=0;i<256;i++)
                n[i]=i*p;
            for(int i=0;i<altezza;i++)
                for(int j=0;j<larghezza;j++){
                    m[i][j].setBlue(Math.round(n[(m[i][j].getBlue())]));
                    canaleB2[(m[i][j]).getBlue()]++;
                }
            igOUT=new Istogramma(canaleR2,canaleG2,canaleB2);
            imgOUT=new BufferedImage(larghezza, altezza, BufferedImage.TYPE_INT_RGB);
            for(int i=0;i<altezza;i++)
                for(int j=0;j<larghezza;j++){
                    int rgb = (m[i][j].getRed() << 16) | (m[i][j].getGreen() << 8) | m[i][j].getBlue();
                    imgOUT.setRGB(j, i, rgb);
                }
            return true;
        }
        return false;
    }
    public void visualizzaImmagine(){
        Image in=(Image) imgIN;
        ImageFrame imgfIN=new ImageFrame("Immagine campione",in);
    }
    public void visualizzaIstogramma(){
        FrameIstogramma fIN=new FrameIstogramma(igIN,"");
    }
    public void visualizzaImmagineNormalizzata(){
        Image out=(Image) imgOUT;
        ImageFrame imgfOUT=new ImageFrame("Immagine normalizzata",out);
    }
    public void visualizzaIstogrammaNormalizzato(){
        FrameIstogramma fOUT=new FrameIstogramma(igOUT," - NORMALIZZATO");
    }
    public void salvaImmagineNormalizzata() throws IOException{
        OpenFile op=new OpenFile();
        int stato=op.showSaveDialog(op);
        String path;
        if(stato == OpenFile.APPROVE_OPTION){
            path = op.getSelectedFile().getAbsolutePath();
            if(!path.endsWith(".png")) path+=".png";
            ImageIO.write(imgOUT, "png", new File(path));
        }
    }
    public void edgeDetection(int d){
        int altezza=imgOUT.getHeight();
        int larghezza=imgOUT.getWidth();
        Color colore1;
        Color colore2;
        BufferedImage greyScale=new BufferedImage(larghezza, altezza, BufferedImage.TYPE_BYTE_GRAY);
        greyScale.getGraphics().drawImage(imgOUT, 0, 0, null);
        imgEdge=new BufferedImage(larghezza, altezza, BufferedImage.TYPE_BYTE_GRAY);
        for(int i=0;i<altezza;i++)
            for(int j=0;j<larghezza;j++){
                int rgb = (255 << 16) | (255 << 8) | 255;
                imgEdge.setRGB(j, i, rgb);
            }
        for(int i=0;i<altezza;i++)
            for(int j=0;j<larghezza-1;j++){
                colore1 = new Color(greyScale.getRGB(j,i));
                colore2 = new Color(greyScale.getRGB(j+1,i));
                if(Math.abs(colore1.getRed()-colore2.getRed())>d)
                    imgEdge.setRGB(j+1, i, 0);
            }
        for(int j=0;j<larghezza;j++)
            for(int i=0;i<altezza-1;i++){
                colore1 = new Color(greyScale.getRGB(j,i));
                colore2 = new Color(greyScale.getRGB(j,i+1));
                if(Math.abs(colore1.getRed()-colore2.getRed())>d)
                    imgEdge.setRGB(j, i+1, 0);
            }
    }
    public void visualizzaEdgeImage(){
        Image edge=(Image) imgEdge;
        ImageFrame imgEdgef=new ImageFrame("Edge Detection",edge);
    }
    public BufferedImage getEdge(){ return imgEdge; }
    public static double covarianza(BufferedImage campione,BufferedImage confronto){
        int altezza=campione.getHeight();
        int larghezza=campione.getWidth();
        
        int sommax=0;
        for(int i=0;i<altezza;i++)
            for(int j=0;j<larghezza;j++){
                Color colore=new Color(campione.getRGB(j, i));
                sommax+=colore.getRed();
            }
            
        double mediax=(double)sommax/(altezza*larghezza);
        
        int sommay=0;
        for(int i=0;i<altezza;i++)
            for(int j=0;j<larghezza;j++){
                Color colore=new Color(confronto.getRGB(j, i));
                sommay+=colore.getRed();
            }
        
        double mediay=(double)sommay/(altezza*larghezza);
        
        double sommatot=0;
        for(int i=0;i<altezza;i++)
            for(int j=0;j<larghezza;j++){
                Color colore1=new Color(campione.getRGB(j, i));
                Color colore2=new Color(confronto.getRGB(j, i));
                sommatot+=(colore1.getRed()-mediax)*(colore2.getRed()-mediay);
            }
        double cov=sommatot/(altezza*larghezza);
        
        return cov;
    }
    public static double deviazioneStandard(BufferedImage img){
        int altezza=img.getHeight();
        int larghezza=img.getWidth();
        
        int somma=0;
        for(int i=0;i<altezza;i++)
            for(int j=0;j<larghezza;j++){
                Color colore=new Color(img.getRGB(j, i));
                somma+=colore.getRed();
            }
            
        double media=(double)somma/(altezza*larghezza);
        
        double sx=0;
        for(int i=0;i<altezza;i++)
            for(int j=0;j<larghezza;j++){
                Color colore=new Color(img.getRGB(j, i));
                sx+=Math.pow((colore.getRed()-media),2);
            }
        
        double ds=Math.sqrt(sx/(altezza*larghezza));
        
        return ds;
    }
    public double correlazione(BufferedImage confronto){
        double r=covarianza(imgEdge,confronto)/(deviazioneStandard(imgEdge)*deviazioneStandard(confronto));
        return r;
    }
    public int getHeight(){
        return imgIN.getHeight();
    }
    public int getWidth(){
        return imgIN.getWidth();
    }
}   

