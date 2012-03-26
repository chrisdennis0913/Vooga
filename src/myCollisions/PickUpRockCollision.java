package myCollisions;

import com.golden.gamedev.object.*;
import com.golden.gamedev.object.collision.*;


public class PickUpRockCollision extends CollisionGroup
{

    public void collided (Sprite s1, Sprite s2)
    {
        // s1 = Hero sprite
        // s2 = Rock sprite
        s1.setHorizontalSpeed(0);
        s2.setX(s1.getX());
        s2.setY(s1.getY()-40);
        setProperXRock(s2);
        setProperY(s2);
        // 4 8 2 1
    }
    private void setProperXRock (Sprite s2)
    {
        int currentX= (int) s2.getX();
        if (currentX%32<16)
            s2.setX(currentX-currentX%32);
        else 
            s2.setX(currentX-currentX%32+32);
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
