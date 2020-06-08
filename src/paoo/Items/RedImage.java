package paoo.Items;

public class RedImage extends Item{
    public RedImage(int x, int y,int color) {
        super(x, y);
        if(color==0) {
            loadImage("images/red.png");
        }
        else if(color==1)
        {
            loadImage("images/red1.png");
        }
        else if(color==2)
        {
            loadImage("images/red2.png");
        }
        else if(color==3)
        {
            loadImage("images/red3.png");
        }
        else if(color==4)
        {
            loadImage("images/red4.png");
        }
        getImageDimensions();
    }
}
