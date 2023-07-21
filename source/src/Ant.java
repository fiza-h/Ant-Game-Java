import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Ant implements PortionListener, Ants, Serializable
{
    protected ArrayList<ImageIcon> images;
    private int currentImageIndex;
    private int x;
    private int y;
    protected boolean clicked;
    ImageIcon dead = new ImageIcon();

    public int getCurrentImageIndex() {
        return currentImageIndex;
    }

    public void setCurrentImageIndex(int currentImageIndex) {
        this.currentImageIndex = currentImageIndex;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public ImageIcon getDead() {
        return dead;
    }

    public void setDead(ImageIcon dead) {
        this.dead = dead;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public boolean isClickedFirstTime() {
        return clickedFirstTime;
    }

    public void setClickedFirstTime(boolean clickedFirstTime) {
        this.clickedFirstTime = clickedFirstTime;
    }

    public int getWavelength() {
        return wavelength;
    }

    public void setWavelength(int wavelength) {
        this.wavelength = wavelength;
    }

    public String getAntType() {
        return antType;
    }

    public void setAntType(String antType) {
        this.antType = antType;
    }

    public ArrayList<ImageIcon> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImageIcon> images) {
        this.images = images;
    }

    private Random random;
    protected boolean clickedFirstTime;
    private int wavelength = (int)(Math.random()*10)+1;
    private String antType;
    private static final long serialVersionUID = 1L;

    public Ant(int x, int y, String antType)
    {
        this.x=x;
        this.y=y;
        this.antType=antType;

        this.images = new ArrayList<>();

        currentImageIndex = 0;
    }

    public Ant() {
    }

    public void draw(Graphics g, int x, int y)
    {
        if (images!=null) {
            if (clicked) {
                g.drawImage(dead.getImage(), x, y, null);
            } else {
                g.drawImage(images.get(currentImageIndex).getImage(), x, y, null);
            }
        }
    }

    public void moveUp() {

        if (!clicked) {
            y -= 5; // adjust the speed of the ant by changing the value here
            nextImage();
        }
    }

    public void moveUpSinusoidal()
    {
        if (!clicked) {
            int verticalSpeed = 5;
            double period = 10;

            x += wavelength * Math.sin(period*y);
            y -= verticalSpeed;

            nextImage();
        }
    }
    public void nextImage()
    {
        if (this.images!=null) {
            currentImageIndex++;
            if (currentImageIndex >= images.size()) {
                currentImageIndex = 0;
            }
        }
    }

    public void move(int mouseX, int mouseY) {
        double distance = Math.sqrt(Math.pow(mouseX - x, 2) + Math.pow(mouseY - y, 2));
        if (distance < 100) {
            double angle = Math.atan2(mouseY - y, mouseX - x);
            x -= 20 * Math.cos(angle);
            y -= 20 * Math.sin(angle);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void onClick(int x, int y)
    {
        if (clickedFirstTime)
        {
            clickedFirstTime=false;
        }
        if(x>=this.x && x<=this.x+images.get(currentImageIndex).getImage().getWidth(null) && y>=this.y && y<=this.y+images.get(currentImageIndex).getImage().getHeight(null)){
            clicked=true;
            clickedFirstTime=true;
        }
    }

    @Override
    public void onMove(int x, int y) {

    }

    @Override
    public void onPress(int x, int y) {

    }

    @Override
    public void onRelease(int x, int y) {

    }
}
