import java.awt.EventQueue;
import javax.swing.JFrame;

public class GamePlayer extends JFrame {

    public GamePlayer()
    {
        initUI();
    }

    private void initUI()
    {
        /**
         * Problem Set 1
         */
//        add(new AntAvoidance());

        /**
         * Problem Set 2 & 3
         */
//        add(new AntSmashed());

//        /**
//         * Problem Set 4
//         */
//        add(new AntSinusoidal());

        add(new WithFireAnts());

        setResizable(false);
        pack();

        setTitle("Squishy Squashy");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            GamePlayer ex = new GamePlayer();
            ex.setVisible(true);
        });
    }
}