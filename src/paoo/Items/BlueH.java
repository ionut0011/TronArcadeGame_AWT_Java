package paoo.Items;

public class BlueH extends Item{
    public BlueH(int x, int y,int color) {
        super(x, y);
        if(color==0) {
            loadImage("images/bluehead.png");
        }
        else if(color==1)
        {
            loadImage("images/bluehead1.png");
        }
        else if(color==2)
        {
            loadImage("images/bluehead2.png");
        }
        else if(color==3)
        {
            loadImage("images/bluehead3.png");
        }
        else if(color==4)
        {
            loadImage("images/bluehead4.png");
        }
        getImageDimensions();
    }
}
