package paoo.Items;

public class RedTurboPoint extends Item{
    public RedTurboPoint(int x, int y,int color) {
        super(x, y);
        if (color == 5) {
            loadImage("images/redturbo.png");
            getImageDimensions();
        }if (color == 6) {
            loadImage("images/redturbo1.png");
            getImageDimensions();
        }if (color == 7) {
            loadImage("images/redturbo2.png");
            getImageDimensions();
        }if (color == 8) {
            loadImage("images/redturbo3.png");
            getImageDimensions();
        }if (color == 9) {
            loadImage("images/redturbo4.png");
            getImageDimensions();
        }
        if(color==0) {
            loadImage("images/redtline.png");
        }
        else if(color==1)
        {
            loadImage("images/redtline1.png");
        }
        else if(color==2)
        {
            loadImage("images/redtline2.png");
        }
        else if(color==3)
        {
            loadImage("images/redtline3.png");
        }
        else if(color==4)
        {
            loadImage("images/redtline4.png");
        }
    }
}
