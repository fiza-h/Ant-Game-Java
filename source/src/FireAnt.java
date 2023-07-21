import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FireAnt extends Ant
{

    public FireAnt(int x, int y, String antType) {
        super(x, y, antType);

        for (int i = 0; i < 10; i++) {
            ImageIcon a = new ImageIcon("C:\\Users\\Amanlab02\\Downloads\\FizaHussain_26749_Lab09\\Lab 09\\src\\fireant\\fireant\\tile00" + i + ".png");
            super.images.add(a);
        }
        for (int i = 10; i < 23; i++) {
            ImageIcon a = new ImageIcon("C:\\Users\\Amanlab02\\Downloads\\FizaHussain_26749_Lab09\\Lab 09\\src\\fireant\\fireant\\tile0" + i + ".png");
            super.images.add(a);
        }

        super.dead = new ImageIcon("C:\\Users\\Amanlab02\\Downloads\\FizaHussain_26749_Lab09\\Lab 09\\src\\fireant\\fireant\\tile023.png");
    }

    public FireAnt() {
    }
}
