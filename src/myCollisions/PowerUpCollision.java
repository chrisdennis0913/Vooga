package myCollisions;

import com.golden.gamedev.object.*;
import com.golden.gamedev.object.collision.*;


public class PowerUpCollision extends CollisionGroup
{

    public void collided (Sprite s1, Sprite s2)
    {
        // s1 = Hero sprite
        // s2 = Powerup sprite
        s2.setActive(false);
        
        // 4 8 2 1
    }

}
