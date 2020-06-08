package paoo.Items;

public class RedH extends Item{
    public RedH(int x, int y, int color) {
        super(x, y);
        if(color==0) {
            loadImage("images/redhead.png");
        }
        else if(color==1)
        {
            loadImage("images/redhead1.png");
        }
        else if(color==2)
        {
            loadImage("images/redhead2.png");
        }
        else if(color==3)
        {
            loadImage("images/redhead3.png");
        }
        else if(color==4)
        {
            loadImage("images/redhead4.png");
        }
        getImageDimensions();
    }
}
