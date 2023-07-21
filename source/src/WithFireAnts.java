import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class WithFireAnts extends JPanel implements ActionListener, MouseInputListener, MouseListener, MouseMotionListener, KeyListener
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
    private AntFactory antFactory;

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            int keyCode = e.getKeyCode();

            //for serialization
            if (keyCode == KeyEvent.VK_UP) {
                try {
                    // Serialize the object to a file
                    FileOutputStream fileOut = new FileOutputStream("savedStatus.txt");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(ants);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in savedStatus.txt");

                } catch (IOException a) {
                    a.printStackTrace();
                }
            }

            //for deserialization
            if (keyCode == KeyEvent.VK_DOWN)
            {
                try {
                    // Deserialize the object from the file
                    FileInputStream fileIn = new FileInputStream("savedStatus.txt");
                    ObjectInputStream in = new ObjectInputStream(fileIn);

                    ants = (ArrayList) in.readObject();
//                    ants.add((Ant) in.readObject());
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data:");

                } catch (IOException a) {
                    a.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }

            //xml encoding
            if (keyCode == KeyEvent.VK_LEFT)
            {
                XMLEncoder encoder = null;
                try {
                    encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("savedStatus.xml")));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                encoder.writeObject(ants);
                encoder.close();
                System.out.println("xml file saved");
            }

            if (keyCode == KeyEvent.VK_RIGHT)
            {
                XMLDecoder decoder = null;
                try {
                    decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("savedStatus.xml")));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                ArrayList<Ant> temp = (ArrayList<Ant>) decoder.readObject();

                ants.clear();
                ants.addAll(temp);

                System.out.println("xml file decoded");
                decoder.close();

            }
        }
    }

    public void serialize() throws IOException
    {
        // Serialize the object to a file
        FileOutputStream fileOut = new FileOutputStream("savedStatus.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(ants);
        out.close();
        fileOut.close();
        System.out.println("Serialized data is saved in savedStatus.txt");

    }

    public void deserialize() throws IOException, ClassNotFoundException
    {
        // Deserialize the object from the file
        FileInputStream fileIn = new FileInputStream("person.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ants.add((Ant) in.readObject());
        in.close();
        fileIn.close();
    }
    public WithFireAnts()
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
        antFactory = new AntFactory();
    }

    NormalAnt ant = new NormalAnt();

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // move each ant upwards in a straight line until it reaches the top of the panel
        for (int i = ants.size() - 1; i >= 0; i--) {
            Ant ant = ants.get(i);
            ant.moveUp();

            /**
             * removes the escapees
             */
//            if (ant.getY() < 0) {
//                ants.remove(i);
//            }
        }

        for (Ant a : ants) {
            a.draw(g, a.getX(), a.getY());
        }

        g.drawImage(ant.dead.getImage(), 30, 30, this);

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

        // randomly create ants at the bottom of the panel
        if (random.nextInt(20) == 0) {
            double antChoice = Math.random();
            Ant ant;
            if (antChoice >= 0.5) {
                ant = antFactory.getAnt("normal ant");
//                ant.setX(random.nextInt(getWidth()));
//                ant.setY(getHeight());
//                ants.add(new NormalAnt(random.nextInt(getWidth()), getHeight(), "normal ant"));
            } else {
                ant = antFactory.getAnt("fire ant");
//                ants.add(new FireAnt(random.nextInt(getWidth()), getHeight(), "fire ant"));
            }

            ants.add(ant);
        }

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
