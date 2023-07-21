//import javax.swing.*;
//import javax.swing.event.MouseInputListener;
//import java.awt.*;
//import java.awt.event.*;
//
//public class AntAvoidance extends JPanel implements ActionListener, MouseInputListener, MouseListener, MouseMotionListener, KeyListener
//{
//    private final int B_WIDTH = 600;
//    private final int B_HEIGHT = 600;
//    private final int DELAY = 100;
//    private Ant ant;
//    private Timer timer;
//    private int mouseX;
//    private int mouseY;
//
//    private class TAdapter extends KeyAdapter {
//
//        @Override
//        public void keyReleased(KeyEvent e) {
//
//        }
//
//        @Override
//        public void keyPressed(KeyEvent e) {
//
//        }
//    }
//    public AntAvoidance()
//    {
//        initBoard();
//    }
//
//    private void initBoard()
//    {
//        addMouseListener( this );
//        addMouseMotionListener( this );
//        addKeyListener(new TAdapter());
//        setBackground(Color.WHITE);
//        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
//        setFocusable(true);
//
//        InitializeAssets();
//
//        timer = new Timer(DELAY, this);
//        timer.start();
//    }
//
//    private void InitializeAssets()
//    {
//        ant = new Ant(300, 300);
//    }
//
//    @Override
//    public void paintComponent(Graphics g)
//    {
//        super.paintComponent(g);
//        ant.draw(g, ant.getX(), ant.getY());
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e)
//    {
//        Toolkit.getDefaultToolkit().sync();
//        ant.nextImage();
//        ant.move(mouseX, mouseY);
//        repaint();
//    }
//
//    @Override
//    public void mouseMoved(MouseEvent e)
//    {
//        mouseX = e.getX();
//        mouseY = e.getY();
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseDragged(MouseEvent e) {
//
//    }
//}
