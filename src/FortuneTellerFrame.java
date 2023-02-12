import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import  java.util.Random;

public class FortuneTellerFrame extends JFrame {
    int lastChosen = -1;
    Random rnd = new Random();

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
        Toolkit kit = Toolkit.getDefaultToolkit();
        frame = new JFrame();
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        topPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);

        middlePanel();
        mainPnl.add(midPnl, BorderLayout.CENTER);

        bottomPanel();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        frame.add(mainPnl);

        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        frame.setSize(screenWidth / 2, screenHeight / 2);
        frame.setLocation(screenWidth / 4, screenHeight / 4);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void topPanel() {
        topPnl = new JPanel();

        image = new ImageIcon("src/fortuneOrb.jpg");
        Image conversion = image.getImage();
        Image scaling = conversion.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(scaling);

        title = new JLabel("Fortune Teller", image, JLabel.CENTER);
        title.setFont(new Font("Calibri", Font.PLAIN, 48));
        title.setVerticalTextPosition(JLabel.BOTTOM);
        title.setHorizontalTextPosition(JLabel.CENTER);


        topPnl.add(title);
    }

    public void middlePanel() {
        midPnl = new JPanel();

        text = new JTextArea(5,50);

        /* In the case it is necessary to resize the frame (and for screenshot)
        text = new JTextArea(15, 50);
         */

        text.setEditable(false);
        scroll = new JScrollPane(text);
        text.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        midPnl.add(scroll);
    }

    private void bottomPanel() {

        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1,2));

        fortune = new JButton("Read My Fortune!");
        fortune.addActionListener((ActionEvent ae) -> getFortune(text));
        fortune.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        quit = new JButton("Quit!");
        quit.addActionListener((ActionEvent ae) -> System.exit(0));
        quit.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        bottomPnl.add(quit);
        bottomPnl.add(fortune);
    }

    private JTextArea getFortune(JTextArea fortune) {
        //int randMax = 11, randMin = 0;

        ArrayList<String> fortunes = new ArrayList<>();
        fortunes.add("We don't know about today.");
        fortunes.add("You might see a duck.");
        fortunes.add("Oranges. Lots of oranges.");
        fortunes.add("You will have the worst luck today.");
        fortunes.add("I would just go to bed.");
        fortunes.add("You will actually have a good day today.");
        fortunes.add("Nothing.");
        fortunes.add("Why are you asking me?");
        fortunes.add("Maybe something interesting will happen.");
        fortunes.add("We'll find out together.");
        fortunes.add("Your next paycheck will disappear.");
        fortunes.add("You will soon find a useful item.");


        int randomFortune = rnd.nextInt(11); //(int)(Math.random() * (randMax - randMin + 1) + randMin);


        while (true) {
            if (lastChosen == randomFortune) {
                randomFortune = rnd.nextInt(11);
            } else {
                break;
            }
        }

        String chosenFortune = fortunes.get(randomFortune);
        lastChosen = randomFortune;

        fortune.append(chosenFortune + "\n\n");

        return fortune;
    }
}
