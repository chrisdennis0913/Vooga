package platformPuzzle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import myCollisions.HeroToDoorCollision;
import myCollisions.HeroToGroundCollision;
import myCollisions.HeroToRockCollision;
import myCollisions.PickUpRockCollision;
import myCollisions.PowerUpCollision;
import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.background.ImageBackground;
import com.golden.gamedev.object.sprite.AdvanceSprite;

public class BlockAndRoll extends Game {
    private AdvanceSprite myHero;
    private SpriteGroup myHeroGroup;
    private Background myBackdrop;
    private boolean carryingRock;
    private final int xConst = 32;
    private final int yConst = 40;
    private int currentLevel = 1;
    private int numPowerUps;
    private Sprite flowers;
    private Sprite teddy;
    private Sprite candy;
    private Sprite boulder1;
    private Sprite boulder2;
    private Sprite boulder3;
    private Sprite boulder4;
    private Sprite boulder5;
    private Sprite boulder6;
    private Sprite boulder7;
    private Sprite boulder8;
    private Sprite boulder9;
    private Sprite boulder10;
    private int numBoulders = 5;
    private ArrayList<Sprite> carriedRock;
    private Sprite Congrats;
    private Sprite door1;
    private Sprite door2;
    private Sprite ground1;
    private Sprite ground2;
    private Sprite ground3;
    private Sprite ground4;
    private Sprite ground5;
    private Sprite ground6;
    private Sprite ground7;
    private Sprite ground8;
    private Sprite ground9;
    private Sprite ground10;
    private Sprite ground11;
    private Sprite ground12;
    private Sprite ground13;
    private Sprite ground14;
    private Sprite ground15;
    private Sprite ground16;
    private Sprite ground17;
    private Sprite ground18;
    private Sprite ground19;
    private Sprite ground20;
    private Sprite ground21;
    private Sprite ground22;
    private Sprite ground23;
    private Sprite ground24;
    private Sprite ground25;
    private Sprite ground26;
    private Sprite ground27;
    private Sprite ground28;
    private Sprite ground29;
    private Sprite ground30;
    private Sprite ground31;
    private Sprite ground32;
    private Sprite ground33;
    private Sprite ground34;
    private Sprite ground35;
    private Sprite ground36;
    private Sprite ground37;
    private Sprite ground38;
    private Sprite ground39;
    private Sprite ground40;
    private Sprite help;
    private Sprite toggleHelp;
    private CollisionManager hitGround;
    private CollisionManager hitRock;
    private CollisionManager powerUp;
    private CollisionManager pickUp;
    private CollisionManager toDoor;
    private SpriteGroup helpGroup;
    private SpriteGroup groundGroup;
    private SpriteGroup rockGroup;
    private SpriteGroup powerUpsGroup;
    private SpriteGroup doorGroup;
    private Timer moveRate;

    @Override
    public void initResources () {
        myBackdrop = new ImageBackground(getImage("resources/forester.png"));
        myBackdrop.setClip(0, 0, 800, 600);

        BufferedImage[] spriteWalkingImages =
            getImages("resources/rpgSpriteWalk.png", 8, 4);
        myHero = new MyHeroSprite(spriteWalkingImages);
        myHero.setAnimationFrame(24, 31);
        myHero.setAnimationTimer(new Timer(200));
        myHero.setLocation(18 * xConst, 8 * yConst);
        myHero.setAnimate(true);
        myHero.setLoopAnim(true);
        setMaskColor(Color.white);
        myHero.setBackground(myBackdrop);
        myHeroGroup = new SpriteGroup("Hero Group");
        myHeroGroup.add(myHero);
        moveRate = new Timer(0);
        boulder1 =
            new Sprite(getImage("resources/boulder.png"),
                       21 * xConst,
                       8 * yConst);
        boulder1.setBackground(myBackdrop);
        boulder2 =
            new Sprite(getImage("resources/boulder.png"),
                       20 * xConst,
                       8 * yConst);
        boulder2.setBackground(myBackdrop);
        boulder3 =
            new Sprite(getImage("resources/boulder.png"),
                       21 * xConst,
                       7 * yConst);
        boulder3.setBackground(myBackdrop);
        boulder4 =
            new Sprite(getImage("resources/boulder.png"),
                       15 * xConst,
                       8 * yConst);
        boulder4.setBackground(myBackdrop);
        boulder5 =
            new Sprite(getImage("resources/boulder.png"),
                       9 * xConst,
                       10 * yConst);
        boulder5.setBackground(myBackdrop);

        carryingRock = false;

        help = new Sprite(getImage("resources/help.png"), 32, 50);
        help.setActive(false);
        helpGroup = new SpriteGroup("Help Group");
        helpGroup.setBackground(myBackdrop);
        toggleHelp = new Sprite(getImage("resources/toggleHelp.png"), 300, 550);
        toggleHelp.setBackground(myBackdrop);

        helpGroup.add(toggleHelp);

        door1 = new Sprite(getImage("resources/door1.png"), 16, 5 * yConst);
        door1.setBackground(myBackdrop);
        ground1 = new Sprite(getImage("resources/dirt.jpg"), 0, 6 * yConst);
        ground2 = new Sprite(getImage("resources/dirt.jpg"), 32, 360);
        ground3 = new Sprite(getImage("resources/dirt.jpg"), 64, 360);
        ground4 = new Sprite(getImage("resources/dirt.jpg"), 0, 7 * yConst);
        ground5 = new Sprite(getImage("resources/dirt.jpg"), 96, 360);
        ground6 = new Sprite(getImage("resources/dirt.jpg"), 128, 360);
        ground7 = new Sprite(getImage("resources/dirt.jpg"), 160, 360);
        ground8 = new Sprite(getImage("resources/dirt.jpg"), 192, 360);
        ground9 =
            new Sprite(getImage("resources/dirt.jpg"), 7 * xConst, 11 * yConst);
        ground10 =
            new Sprite(getImage("resources/dirt.jpg"), 8 * xConst, 11 * yConst);
        ground11 =
            new Sprite(getImage("resources/dirt.jpg"), 9 * xConst, 11 * yConst);
        ground12 =
            new Sprite(getImage("resources/dirt.jpg"), 10 * xConst, 9 * yConst);
        ground13 = new Sprite(getImage("resources/dirt.jpg"), 352, 360);
        ground14 = new Sprite(getImage("resources/dirt.jpg"), 384, 360);
        ground15 = new Sprite(getImage("resources/dirt.jpg"), 416, 360);
        ground16 =
            new Sprite(getImage("resources/dirt.jpg"), 14 * xConst, 7 * yConst);
        ground17 = new Sprite(getImage("resources/dirt.jpg"), 480, 360);
        ground18 = new Sprite(getImage("resources/dirt.jpg"), 512, 360);
        ground19 = new Sprite(getImage("resources/dirt.jpg"), 544, 360);
        ground20 = new Sprite(getImage("resources/dirt.jpg"), 576, 360);
        ground21 = new Sprite(getImage("resources/dirt.jpg"), 608, 360);
        ground22 =
            new Sprite(getImage("resources/dirt.jpg"), 20 * xConst, 9 * yConst);
        ground23 = new Sprite(getImage("resources/dirt.jpg"), 672, 360);
        ground24 = new Sprite(getImage("resources/dirt.jpg"), 704, 360);
        ground25 = new Sprite(getImage("resources/dirt.jpg"), 736, 360);
        ground26 = new Sprite(getImage("resources/dirt.jpg"), 24 * xConst, 360);
        ground27 =
            new Sprite(getImage("resources/dirt.jpg"), 14 * xConst, 8 * yConst);
        ground28 =
            new Sprite(getImage("resources/dirt.jpg"), 6 * xConst, 10 * yConst);
        ground29 =
            new Sprite(getImage("resources/dirt.jpg"), 10 * xConst, 10 * yConst);
        ground30 =
            new Sprite(getImage("resources/dirt.jpg"), 1 * xConst, 8 * yConst);
        ground31 =
            new Sprite(getImage("resources/dirt.jpg"), 1 * xConst, 7 * yConst);
        ground32 =
            new Sprite(getImage("resources/dirt.jpg"), 1 * xConst, 6 * yConst);

        groundGroup = new SpriteGroup("Ground Group");
        groundGroup.add(ground1);
        groundGroup.add(ground2);
        groundGroup.add(ground3);
        groundGroup.add(ground4);
        groundGroup.add(ground5);
        groundGroup.add(ground6);
        groundGroup.add(ground7);
        groundGroup.add(ground8);
        groundGroup.add(ground9);
        groundGroup.add(ground10);
        groundGroup.add(ground11);
        groundGroup.add(ground12);
        groundGroup.add(ground13);
        groundGroup.add(ground14);
        groundGroup.add(ground15);
        groundGroup.add(ground16);
        groundGroup.add(ground17);
        groundGroup.add(ground18);
        groundGroup.add(ground19);
        groundGroup.add(ground20);
        groundGroup.add(ground21);
        groundGroup.add(ground22);
        groundGroup.add(ground23);
        groundGroup.add(ground24);
        groundGroup.add(ground25);
        groundGroup.add(ground26);
        groundGroup.add(ground27);
        groundGroup.add(ground28);
        groundGroup.add(ground29);
        groundGroup.add(ground30);
        groundGroup.add(ground31);
        groundGroup.add(ground32);
        groundGroup.setBackground(myBackdrop);
        rockGroup = new SpriteGroup("Rock Group");
        rockGroup.add(boulder1);
        rockGroup.add(boulder2);
        rockGroup.add(boulder3);
        rockGroup.add(boulder4);
        rockGroup.add(boulder5);
        rockGroup.setBackground(myBackdrop);
        carriedRock = new ArrayList<Sprite>();

        hitGround = new HeroToGroundCollision();
        hitGround.setCollisionGroup(myHeroGroup, groundGroup);
        hitRock = new HeroToRockCollision();
        hitRock.setCollisionGroup(myHeroGroup, rockGroup);
        flowers =
            new Sprite(getImage("resources/roseBouquet.png"),
                       14 * xConst,
                       6 * yConst);
        teddy =
            new Sprite(getImage("resources/teddyBear.png"),
                       22 * xConst,
                       7 * yConst);
        candy =
            new Sprite(getImage("resources/CandyBox.png"),
                       8 * xConst,
                       9 * yConst);
        powerUpsGroup = new SpriteGroup("PowerUps Group");
        powerUpsGroup.add(teddy);
        powerUpsGroup.add(flowers);
        powerUpsGroup.add(candy);
        powerUpsGroup.setBackground(myBackdrop);
        powerUp = new PowerUpCollision();
        powerUp.setCollisionGroup(myHeroGroup, powerUpsGroup);
        pickUp = new PickUpRockCollision();
        pickUp.setCollisionGroup(myHeroGroup, rockGroup);
        myHeroGroup.add(boulder1);
        myHeroGroup.add(boulder2);
        myHeroGroup.add(boulder3);
        myHeroGroup.add(boulder4);
        myHeroGroup.add(boulder5);
        doorGroup = new SpriteGroup("Door Group");
        doorGroup.add(door1);
        toDoor = new HeroToDoorCollision();
        toDoor.setCollisionGroup(myHeroGroup, doorGroup);
    }

    @Override
    public void render (Graphics2D pen) { // used to actually show graphics
                                          // clear last frame
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getWidth(), getHeight());
        // render sprites based on their current state
        myBackdrop.render(pen);
        myHeroGroup.render(pen);
        rockGroup.render(pen);
        doorGroup.render(pen);
        groundGroup.render(pen);
        powerUpsGroup.render(pen);
        helpGroup.render(pen);
    }

    @Override
    public void update (long elapsedTime) {
        helpGroup.update(elapsedTime);
        if (currentLevel == 1) updateLevel1(elapsedTime);
        if (currentLevel == 2) updateLevel2(elapsedTime);
        if (currentLevel == 3) updateDone(elapsedTime);
    }

    private void updateDone (long elapsedTime) {
        Congrats.update(elapsedTime);
        if (keyPressed(java.awt.event.KeyEvent.VK_Q)) {//Quit game       
            notifyExit();
        }

    }

    private void updateLevel1 (long elapsedTime) {
        // update sprites based on their current state
        myHero.update(elapsedTime);
        myHeroGroup.update(elapsedTime);
        groundGroup.update(elapsedTime);
        powerUpsGroup.update(elapsedTime);

        powerUp.checkCollision();
        powerUpsGroup.removeInactiveSprites();
        numPowerUps = powerUpsGroup.getSize();
        if (keyPressed(java.awt.event.KeyEvent.VK_UP)) {
            jump();
        }
        if (keyPressed(java.awt.event.KeyEvent.VK_DOWN)) {//down
            if (!carryingRock & notMoving()) {
                move("facing");
                pickUp.checkCollision();
                carryRock();
            }
            else if (carryingRock & notMoving()) {
                Sprite carry = carriedRock.get(0);
                carryingRock = false;
                carry.setLocation(carry.getX() + 32 * myHero.getDirection(),
                                  carry.getY());
                checkForDropRock(carry);
                carriedRock.clear();
            }
        }
        if (keyPressed(java.awt.event.KeyEvent.VK_RIGHT)) {//right
            if (notMoving()) {
                move("right");
            }
        }

        if (keyPressed(java.awt.event.KeyEvent.VK_LEFT)) {
            if (notMoving()) {
                move("left");
            }
        }

        if (moveRate.action(elapsedTime)) {
            myHero.setHorizontalSpeed(0);
            setProperXHero();
            checkForDropHero();
        }

        if (keyPressed(java.awt.event.KeyEvent.VK_R)) {//Reset Level        
            resetLevel1();
        }
        if (keyPressed(java.awt.event.KeyEvent.VK_Q)) {//Quit game       
            notifyExit();
        }
        if (keyPressed(java.awt.event.KeyEvent.VK_H) & !help.isActive()) {
            help.setActive(true);
            helpGroup.add(help);
        }
        else if (keyPressed(java.awt.event.KeyEvent.VK_H) & help.isActive()) {
            help.setActive(false);
        }

        if (carryingRock) {
            Sprite carried = carriedRock.get(0);
            carried.setX(myHero.getX());
            carried.setY(myHero.getY() - 43);
            setProperXRock(carried);
            setProperY(carried);
        }
        if (finishedLevel1()) {
            currentLevel++;
            prepareLevel2();
        }
        toDoor.checkCollision();
        hitGround.checkCollision();
        hitRock.checkCollision();
        myBackdrop.update(elapsedTime);
        rockGroup.update(elapsedTime);
        doorGroup.update(elapsedTime);
    }

    private void updateLevel2 (long elapsedTime) {
        // update sprites based on their current state
        myHero.update(elapsedTime);
        myHeroGroup.update(elapsedTime);
        groundGroup.update(elapsedTime);
        powerUpsGroup.update(elapsedTime);

        powerUp.checkCollision();
        powerUpsGroup.removeInactiveSprites();
        numPowerUps = powerUpsGroup.getSize();
        if (keyPressed(java.awt.event.KeyEvent.VK_UP)) {
            jump();
        }
        if (keyPressed(java.awt.event.KeyEvent.VK_DOWN)) {//down
            if (!carryingRock & notMoving()) {
                move("facing");
                pickUp.checkCollision();
                carryRock();
            }
            else if (carryingRock & notMoving()) {
                Sprite carry = carriedRock.get(0);
                carryingRock = false;
                carry.setLocation(carry.getX() + 32 * myHero.getDirection(),
                                  carry.getY());
                checkForDropRock(carry);
                carriedRock.clear();
            }
        }
        if (keyPressed(java.awt.event.KeyEvent.VK_RIGHT)) {//right
            if (notMoving()) {
                move("right");
            }
        }

        if (keyPressed(java.awt.event.KeyEvent.VK_LEFT)) {
            if (notMoving()) {
                move("left");
            }
        }

        if (moveRate.action(elapsedTime)) {
            myHero.setHorizontalSpeed(0);
            setProperXHero();
            checkForDropHero();
        }

        if (keyPressed(java.awt.event.KeyEvent.VK_R)) {//Reset Level        
            resetLevel2();
        }
        if (keyPressed(java.awt.event.KeyEvent.VK_Q)) {//Quit game       
            notifyExit();
        }
        if (keyPressed(java.awt.event.KeyEvent.VK_H) & !help.isActive()) {
            help.setActive(true);
            helpGroup.add(help);
        }
        else if (keyPressed(java.awt.event.KeyEvent.VK_H) & help.isActive()) {
            help.setActive(false);
        }

        if (carryingRock) {
            Sprite carried = carriedRock.get(0);
            carried.setX(myHero.getX());
            carried.setY(myHero.getY() - 43);
            setProperXRock(carried);
            setProperY(carried);
        }
        if (finishedLevel2()) {
            currentLevel++;
            Congrats = new Sprite(getImage("resources/Congrats.png"), 300, 250);
            helpGroup.add(Congrats);
        }
        toDoor.checkCollision();
        hitGround.checkCollision();
        hitRock.checkCollision();
        myBackdrop.update(elapsedTime);
        rockGroup.update(elapsedTime);
        doorGroup.update(elapsedTime);
    }

    private void jump () {
        if (myHero.getY() >= 40 & notMoving()) {
            myHero.setLocation(myHero.getX(), myHero.getY() - 44);
        }
        move("facing");
    }

    private void resetLevel1 () {
        myHero.setLocation(18 * xConst, 8 * yConst);
        flowers.setActive(true);
        teddy.setActive(true);
        candy.setActive(true);
        powerUpsGroup.add(teddy);
        powerUpsGroup.add(flowers);
        powerUpsGroup.add(candy);
        carryingRock = false;
        carriedRock.clear();
        boulder1.setLocation(21 * xConst, 8 * yConst);
        boulder2.setLocation(20 * xConst, 8 * yConst);
        boulder3.setLocation(21 * xConst, 7 * yConst);
        boulder4.setLocation(15 * xConst, 8 * yConst);
        boulder5.setLocation(9 * xConst, 10 * yConst);
    }

    private void resetLevel2 () {
        myHero.setLocation(12 * xConst, 7 * yConst);
        flowers.setActive(true);
        teddy.setActive(true);
        candy.setActive(true);
        powerUpsGroup.add(teddy);
        powerUpsGroup.add(flowers);
        powerUpsGroup.add(candy);
        carryingRock = false;
        carriedRock.clear();
        boulder1.setLocation(8 * xConst, 7 * yConst);
        boulder2.setLocation(9 * xConst, 7 * yConst);
        boulder3.setLocation(10 * xConst, 7 * yConst);
        boulder4.setLocation(11 * xConst, 7 * yConst);
        boulder5.setLocation(19 * xConst, 11 * yConst);
        boulder6.setLocation(20 * xConst, 11 * yConst);
        boulder7.setLocation(20 * xConst, 10 * yConst);
        boulder8.setLocation(21 * xConst, 11 * yConst);
        boulder9.setLocation(21 * xConst, 10 * yConst);
        boulder10.setLocation(21 * xConst, 9 * yConst);
    }

    private void prepareLevel2 () {
        myHero.setLocation(12 * xConst, 7 * yConst);
        flowers.setActive(true);
        teddy.setActive(true);
        candy.setActive(true);
        flowers.setLocation(16 * xConst, 8 * yConst);
        teddy.setLocation(20 * xConst, 8 * yConst);
        candy.setLocation(7 * xConst, 4 * yConst);
        powerUpsGroup.add(teddy);
        powerUpsGroup.add(flowers);
        powerUpsGroup.add(candy);
        carryingRock = false;
        carriedRock.clear();
        door2 =
            new Sprite(getImage("resources/door1.png"),
                       1 * xConst + 16,
                       8 * yConst);
        door2.setBackground(myBackdrop);
        doorGroup.add(door2);
        boulder1.setLocation(8 * xConst, 7 * yConst);
        boulder2.setLocation(9 * xConst, 7 * yConst);
        boulder3.setLocation(10 * xConst, 7 * yConst);
        boulder4.setLocation(11 * xConst, 7 * yConst);
        boulder5.setLocation(19 * xConst, 11 * yConst);
        boulder6 =
            new Sprite(getImage("resources/boulder.png"),
                       20 * xConst,
                       11 * yConst);
        boulder6.setBackground(myBackdrop);
        boulder7 =
            new Sprite(getImage("resources/boulder.png"),
                       20 * xConst,
                       10 * yConst);
        boulder7.setBackground(myBackdrop);
        boulder8 =
            new Sprite(getImage("resources/boulder.png"),
                       21 * xConst,
                       11 * yConst);
        boulder8.setBackground(myBackdrop);
        boulder9 =
            new Sprite(getImage("resources/boulder.png"),
                       21 * xConst,
                       10 * yConst);
        boulder9.setBackground(myBackdrop);
        boulder10 =
            new Sprite(getImage("resources/boulder.png"),
                       21 * xConst,
                       9 * yConst);
        boulder10.setBackground(myBackdrop);
        numBoulders = 10;
        rockGroup.add(boulder6);
        rockGroup.add(boulder7);
        rockGroup.add(boulder8);
        rockGroup.add(boulder9);
        rockGroup.add(boulder10);
        myHeroGroup.add(boulder6);
        myHeroGroup.add(boulder7);
        myHeroGroup.add(boulder8);
        myHeroGroup.add(boulder9);
        myHeroGroup.add(boulder10);

        ground1.setLocation(0 * xConst, 7 * yConst);
        ground2.setLocation(0 * xConst, 8 * yConst);
        ground3.setLocation(2 * xConst, 9 * yConst);
        ground4.setLocation(2 * xConst, 10 * yConst);
        ground5.setLocation(2 * xConst, 11 * yConst);
        ground6.setLocation(1 * xConst, 9 * yConst);
        ground7.setLocation(3 * xConst, 12 * yConst);
        ground8.setLocation(4 * xConst, 9 * yConst);
        ground9.setLocation(4 * xConst, 10 * yConst);
        ground10.setLocation(4 * xConst, 11 * yConst);
        ground11.setLocation(5 * xConst, 9 * yConst);
        ground12.setLocation(6 * xConst, 8 * yConst);
        ground13.setLocation(7 * xConst, 5 * yConst);
        ground14.setLocation(7 * xConst, 6 * yConst);
        ground15.setLocation(7 * xConst, 7 * yConst);
        ground16.setLocation(8 * xConst, 8 * yConst);
        ground17.setLocation(9 * xConst, 8 * yConst);
        ground18.setLocation(10 * xConst, 8 * yConst);
        ground19.setLocation(11 * xConst, 8 * yConst);
        ground20.setLocation(12 * xConst, 8 * yConst);
        ground21.setLocation(13 * xConst, 9 * yConst);
        ground22.setLocation(13 * xConst, 10 * yConst);
        ground23.setLocation(13 * xConst, 11 * yConst);
        ground24.setLocation(13 * xConst, 12 * yConst);
        ground25.setLocation(14 * xConst, 13 * yConst);
        ground26.setLocation(15 * xConst, 9 * yConst);
        ground27.setLocation(15 * xConst, 10 * yConst);
        ground28.setLocation(15 * xConst, 11 * yConst);
        ground29.setLocation(15 * xConst, 12 * yConst);
        ground30.setLocation(16 * xConst, 10 * yConst);
        ground31.setLocation(16 * xConst, 11 * yConst);
        ground32.setLocation(17 * xConst, 12 * yConst);
        ground33 =
            new Sprite(getImage("resources/dirt.jpg"), 18 * xConst, 12 * yConst);
        ground34 =
            new Sprite(getImage("resources/dirt.jpg"), 19 * xConst, 12 * yConst);
        ground35 =
            new Sprite(getImage("resources/dirt.jpg"), 20 * xConst, 12 * yConst);
        ground36 =
            new Sprite(getImage("resources/dirt.jpg"), 21 * xConst, 12 * yConst);
        ground37 =
            new Sprite(getImage("resources/dirt.jpg"), 22 * xConst, 11 * yConst);
        ground38 =
            new Sprite(getImage("resources/dirt.jpg"), 22 * xConst, 10 * yConst);
        ground39 =
            new Sprite(getImage("resources/dirt.jpg"), 22 * xConst, 9 * yConst);
        ground40 =
            new Sprite(getImage("resources/dirt.jpg"), 23 * xConst, 8 * yConst);
        groundGroup.add(ground33);
        groundGroup.add(ground34);
        groundGroup.add(ground35);
        groundGroup.add(ground36);
        groundGroup.add(ground37);
        groundGroup.add(ground38);
        groundGroup.add(ground39);
        groundGroup.add(ground40);
    }

    private boolean finishedLevel1 () {
        if (!door1.isActive() & numPowerUps == 0) return true;
        return false;
    }

    private boolean finishedLevel2 () {
        if (!door2.isActive() & numPowerUps == 0) return true;
        return false;
    }

    private void carryRock () {
        Sprite[] rockArray = rockGroup.getSprites();
        for (int i = 0; i < numBoulders; i++) {
            Sprite s = rockArray[i];
            if ((s.getX() - 8) < (myHero.getX()) &
                (s.getX() + 8 > myHero.getX()) &
                (s.getY() - 12 < myHero.getY() - 40) &
                (s.getY() + 12 > myHero.getY() - 40)) {
                carriedRock.add(s);
                carryingRock = true;
                return;
            }
        }
    }

    private void checkForDropHero () {
        myHero.setVerticalSpeed(.1);
        hitGround.checkCollision();
        hitRock.checkCollision();
        powerUp.checkCollision();
    }

    private void checkForDropRock (Sprite rock) {
        rock.setVerticalSpeed(.1);
        hitGround.checkCollision();
        hitRock.checkCollision();
    }

    private void move (String direction) {
        int dir = 1;
        if (direction.equals("left")) dir = -1;
        else if (direction.equals("facing")) {
            dir = myHero.getDirection();
            myHero.setX(myHero.getX() + 5 * dir);
        }

        if (sidesOkay(myHero.getX() + 32 * dir)) {
            myHero.setHorizontalSpeed(dir * .170);
            moveRate = new Timer((int) (120));
        }
        myHero.setDirection(dir);
    }

    public boolean sidesOkay () {
        // check sprites edges against boundaries of the frame:
        //   0 .. width
        if (myHero.getX() < 0 || myHero.getX() + myHero.getWidth() > getWidth()) {
            return false;
        }
        return true;
    }

    public boolean sidesOkay (double x) {
        // check sprites edges against boundaries of the frame:
        //   0 .. width
        if (x < 0 || x + myHero.getWidth() >= getWidth()) {
            return false;
        }
        return true;
    }

    private void setProperXHero () {
        int currentX = (int) myHero.getX();
        if (currentX % 32 < 16) myHero.setX(currentX - currentX % 32);
        else myHero.setX(currentX - currentX % 32 + 32);
    }

    private void setProperXRock (Sprite s2) {
        int currentX = (int) s2.getX();
        if (currentX % 32 < 16) s2.setX(currentX - currentX % 32);
        else s2.setX(currentX - currentX % 32 + 32);
    }

    private void setProperY (Sprite s1) {
        int currentY = (int) s1.getY();
        if (currentY % 40 < 20) s1.setY(currentY - currentY % 40);
        else s1.setY(currentY - currentY % 40 + 40);
    }

    private boolean notMoving () {
        return (myHero.getVerticalSpeed() == 0) &
               (myHero.getHorizontalSpeed() == 0);

    }

    public static void main (String[] args) {
        GameLoader gLoader = new GameLoader();
        gLoader.setup(new BlockAndRoll(), new Dimension(800, 600), false);
        gLoader.start();
    }
}
