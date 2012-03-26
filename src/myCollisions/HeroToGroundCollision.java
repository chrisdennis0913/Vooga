package myCollisions;

import com.golden.gamedev.object.*;
import com.golden.gamedev.object.collision.*;


public class HeroToGroundCollision extends CollisionGroup
{

    public void collided (Sprite s1, Sprite s2)
    {
        // s1 = Hero sprite
        // s2 = Ground sprite
        s1.setHorizontalSpeed(0);
        if(getCollisionSide()==4||getCollisionSide()==8){
            s1.setVerticalSpeed(0);
            setProperY(s1);
            
        }
        // 4 8 2 1
    }

    private void setProperY (Sprite s1)
    {
        int currentY= (int) s1.getY();
        if (currentY%40<20)
            s1.setY(currentY-currentY%40);
        else 
            s1.setY(currentY-currentY%40+40);
    }
}
