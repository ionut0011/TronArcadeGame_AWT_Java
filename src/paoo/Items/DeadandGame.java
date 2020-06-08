package paoo.Items;

public class DeadandGame extends Item {
    public DeadandGame(int x, int y, int img) {
        super(x, y);
        if (img == 0) {
            loadImage("images/press2continue.png");
            getImageDimensions();
        } else if (img == 1) {
            loadImage("images/gameinprogress.png");
            getImageDimensions();
        } else if (img == 2){
            loadImage("images/reddead.png");
            getImageDimensions();
        } else if (img == 3){
            loadImage("images/reddead1.png");
            getImageDimensions();
        }else if (img == 4){
            loadImage("images/reddead2.png");
            getImageDimensions();
        } else if (img == 5){
            loadImage("images/reddead3.png");
            getImageDimensions();
        }else if (img == 6){
            loadImage("images/reddead4.png");
            getImageDimensions();
        } else if (img == 7){
            loadImage("images/bluedead.png");
            getImageDimensions();
        }else if (img == 8){
            loadImage("images/bluedead1.png");
            getImageDimensions();
        } else if (img == 9){
            loadImage("images/bluedead2.png");
            getImageDimensions();
        }else if (img == 10){
            loadImage("images/bluedead3.png");
            getImageDimensions();
        } else if (img == 11){
            loadImage("images/bluedead4.png");
            getImageDimensions();
        }
    }
}


