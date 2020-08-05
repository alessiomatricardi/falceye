package immagine;
public class RGB {
    int red;
    int green;
    int blue;
    public RGB(int r,int g, int b){
        red=r;
        green=g;
        blue=b;
    }
    public RGB(){
        red=0;
        green=0;
        blue=0;
    }
    public int getRed(){return red;}
    public int getGreen(){return green;}
    public int getBlue(){return blue;}
    public void setRed(int x){red=x;}
    public void setGreen(int x){green=x;}
    public void setBlue(int x){blue=x;}
}
