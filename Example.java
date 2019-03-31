import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class Example extends JFrame {


    public Example(){
        initUI();
    }

    private JButton quitButton;
    private JButton testButton;
    private JPanel pane;
    private GroupLayout gl;
    private JTextField tf1;
    private JTextField tf2;
    private Font font = new Font("SansSerif", Font.PLAIN, 20);

    private void initUI(){

        //new Button
        quitButton = new JButton("Quit");
        //set tool tip text
        quitButton.setToolTipText("Want to quit?");

        //ActionListener (Quit on Button Press)
        quitButton.addActionListener((event) -> System.exit(0));

        testButton = new JButton("test");
        testButton.setToolTipText("Press me");
        testButton.addActionListener((event) -> onSubmit());

        tf1= new JTextField();
        tf1.setFont(font);
        tf1.setText("Hello World!");

        tf2 = new JTextField();
        tf2.setFont(font);
        tf2.setText("Output goes here");

        setTitle("Simple example");

        createFlowLayout();

        //Position in screen center
        setLocationRelativeTo(null);
        //Close Application when window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createFlowLayout(){
        //mind the order of the components!
        pane = (JPanel) getContentPane();
        pane.add(tf1);
        pane.add(testButton);
        pane.add(tf2);
        pane.add(quitButton);
        pane.setLayout(new FlowLayout());
        pane.setSize(300, 300);
        pack();
    }

    private void onSubmit(){
        tf2.setText("You entered: " + tf1.getText());
    }

    public static void main(String[] args){
        //places the application on the Swing Event Queue such that all UI updates are concurrency-safe
        EventQueue.invokeLater(() ->{
            Example ex = new Example();
            ex.setVisible(true);
        });
    }

}
