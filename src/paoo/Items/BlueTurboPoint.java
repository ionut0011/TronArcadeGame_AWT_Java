package paoo.Items;

public class BlueTurboPoint extends Item{
    public BlueTurboPoint(int x, int y,int color) {
        super(x, y);
        if (color == 5) {
            loadImage("images/blueturbo.png");
            getImageDimensions();
        }if (color == 6) {
            loadImage("images/blueturbo1.png");
            getImageDimensions();
        }if (color == 7) {
            loadImage("images/blueturbo2.png");
            getImageDimensions();
        }if (color == 8) {
            loadImage("images/blueturbo3.png");
            getImageDimensions();
        }if (color == 9) {
            loadImage("images/blueturbo4.png");
            getImageDimensions();
        }
        if(color==0) {
            loadImage("images/bluetline.png");
        }
        else if(color==1)
        {
            loadImage("images/bluetline1.png");
        }
        else if(color==2)
        {
            loadImage("images/bluetline2.png");
        }
        else if(color==3)
        {
            loadImage("images/bluetline3.png");
        }
        else if(color==4)
        {
            loadImage("images/bluetline4.png");
        }
    }

}
