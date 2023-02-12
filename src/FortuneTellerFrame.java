import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FortuneTellerFrame extends JFrame {
    JFrame frame;

    JPanel mainPnl;

    JPanel topPnl;
    JLabel title;
    ImageIcon image;

    JPanel midPnl;
    JTextArea text;
    JScrollPane scroll;

    JPanel bottomPnl;
    JButton quit;
    JButton fortune;

    //Change the name of this when copying
    public FortuneTellerFrame() {
        //frame = new JFrame();
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        topPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);

        middlePanel();
        mainPnl.add(midPnl, BorderLayout.CENTER);

        bottomPanel();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void topPanel() {
        topPnl = new JPanel();

        image = new ImageIcon("src/fortuneOrb.jpg");
        Image conversion = image.getImage();
        Image scaling = conversion.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(scaling);

        title = new JLabel("Fortune Teller", image, JLabel.CENTER);
        title.setFont(new Font("Calibri", Font.PLAIN, 48));
        title.setVerticalTextPosition(JLabel.BOTTOM);
        title.setHorizontalTextPosition(JLabel.CENTER);


        topPnl.add(title);
    }

    public void middlePanel() {
        midPnl = new JPanel();

        text = new JTextArea(10,50);
        scroll = new JScrollPane(text);
        text.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        midPnl.add(scroll);
    }

    private void bottomPanel() {

        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1,2));

        fortune = new JButton("Read My Fortune!");
        fortune.addActionListener((ActionEvent ae) -> {getFortune(text);});
        fortune.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        quit = new JButton("Quit!");
        quit.addActionListener((ActionEvent ae) -> System.exit(0));
        quit.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        bottomPnl.add(quit);
        bottomPnl.add(fortune);
    }

    private JTextArea getFortune(JTextArea fortune) {
        int randMax = 11, randMin = 0;

        ArrayList<String> fortunes = new ArrayList<>();
        fortunes.add("fortune 1");
        fortunes.add("fortune 2");
        fortunes.add("fortune 3");
        fortunes.add("fortune 4");
        fortunes.add("fortune 5");
        fortunes.add("fortune 6");
        fortunes.add("fortune 7");
        fortunes.add("fortune 8");
        fortunes.add("fortune 9");
        fortunes.add("fortune 10");
        fortunes.add("fortune 11");
        fortunes.add("fortune 12");

        int randomFortune = (int)(Math.random() * (randMax - randMin + 1) + randMin);

        fortune.insert(fortunes.get(randomFortune) + "\n\n", 0);

        return fortune;
    }
}
