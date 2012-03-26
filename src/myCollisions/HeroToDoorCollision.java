package myCollisions;

import com.golden.gamedev.object.*;
import com.golden.gamedev.object.collision.*;


public class HeroToDoorCollision extends CollisionGroup
{

    public void collided (Sprite s1, Sprite s2)
    {
        // s1 = Hero sprite
        // s2 = Door sprite
        System.out.println("We is Done");
        s2.setActive(false);
        
        // 4 8 2 1
    }

}
