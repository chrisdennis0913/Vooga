package platformPuzzle;


import java.awt.image.BufferedImage;
import com.golden.gamedev.object.sprite.AdvanceSprite;

public class MyHeroSprite extends AdvanceSprite
{
    public MyHeroSprite(BufferedImage[] image){
        super(image);
        this.setDirection(1);
    }
    protected void animationChanged(int oldStat,
                     int oldDir,
                     int status,
                     int direction){
        if (direction>0){
            setAnimationFrame(24,31);
        }
        else{
            setAnimationFrame(16,23);
        }
        
    }
}
