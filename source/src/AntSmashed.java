/*
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class AntSmashed extends JPanel implements ActionListener, MouseInputListener, MouseListener, MouseMotionListener, KeyListener
{
    private final int B_WIDTH = 600;
    private final int B_HEIGHT = 600;
    private final int DELAY = 50;
    private ArrayList<Ant> ants;
    private Random random;
    private Timer timer;
    private int mouseX;
    private int mouseY;
    private int score = 0;

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }
    }
    public AntSmashed()
    {
        initBoard();
    }

    private void initBoard()
    {
        addMouseListener( this );
        addMouseMotionListener( this );
        addKeyListener(new TAdapter());
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setFocusable(true);

        InitializeAssets();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void InitializeAssets()
    {
        ants = new ArrayList<>();
        random = new Random();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // randomly create ants at the bottom of the panel
        if (random.nextInt(20) == 0) {
            ants.add(new Ant(random.nextInt(getWidth()), getHeight()));
        }

        // move each ant upwards in a straight line until it reaches the top of the panel
        for (int i = ants.size() - 1; i >= 0; i--) {
            Ant ant = ants.get(i);
            ant.moveUp();

            */
/**
             * removes the escapees
             *//*

            if (ant.getY() < 0) {
                ants.remove(i);
            }
        }

        for (Ant a : ants) {
            a.draw(g, a.getX(), a.getY());
        }

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 100, 30);

        g.setColor(Color.WHITE);
        Font font = new Font("Monospaced", Font.PLAIN, 17);
        g.setFont(font);
        g.drawString("Score: " + score, 5, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Toolkit.getDefaultToolkit().sync();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();

        for (Ant a : ants)
        {
            a.onClick(mouseX, mouseY);
            if (a.clickedFirstTime)// check if the ant is clicked and isclick is true
            {
                score++; // increment the score by 1
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
*/
