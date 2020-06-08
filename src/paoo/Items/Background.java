package paoo.Items;

public class Background extends Item{
    public Background(int x, int y) {
        super(x, y);
        loadImage("images/background.png");
        getImageDimensions();
    }
}
