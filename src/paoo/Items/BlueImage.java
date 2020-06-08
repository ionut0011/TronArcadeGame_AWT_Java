package paoo.Items;

public class BlueImage extends Item{
    public BlueImage(int x, int y,int color) {
        super(x, y);
        if(color==0) {
            loadImage("images/blue.png");
        }
        else if(color==1)
        {
            loadImage("images/blue1.png");
        }
        else if(color==2)
        {
            loadImage("images/blue2.png");
        }
        else if(color==3)
        {
            loadImage("images/blue3.png");
        }
        else if(color==4)
        {
            loadImage("images/blue4.png");
        }
        getImageDimensions();
    }
}
