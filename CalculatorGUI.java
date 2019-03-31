import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame {
	
	private JButton zerobtn, onebtn, twobtn, threebtn, fourbtn,
	                fivebtn,sixbtn,sevenbtn,eightbtn,ninebtn;
	private JButton addbtn,subbtn,mulbtn,dividebtn,quitbtn, testbtn;
	private JTextField tf1, tf2;
	private JPanel pane, pane1, pane2,pane3;
	private Font font = new Font("SansSerif", Font.PLAIN, 20);
	private Mode presentmode;
	private double present=0;
	private enum Mode{PLUS,MINUS,TIMES,DIVIDED;};
	public CalculatorGUI() {
		myUI();
	}

	public void myUI() {
		
		quitbtn = new JButton("Quit");
		quitbtn.setToolTipText("Want to quit?");
		quitbtn.addActionListener((event) -> System.exit(0));
		
		testbtn = new JButton("test");
		testbtn.setToolTipText("Press me");
		testbtn.addActionListener((event) ->  displayTest(Double.parseDouble(tf1.getText())));
			
		addbtn = new JButton("+");
		addbtn.setToolTipText("+");
		addbtn.setActionCommand("+");
		addbtn.addActionListener((event) -> addition(Double.parseDouble(tf1.getText())));
			
		subbtn = new JButton("-");
		subbtn.setToolTipText("-");
		subbtn.addActionListener((event) -> substraction(Double.parseDouble(tf1.getText())));
		
		mulbtn = new JButton("*");
		mulbtn.setToolTipText("*");
		mulbtn.addActionListener((event) -> multiplication(Double.parseDouble(tf1.getText())));
		
		dividebtn = new JButton("/");
		dividebtn.setToolTipText("/");
		dividebtn.addActionListener((event) -> division(Double.parseDouble(tf1.getText())));
		 
		zerobtn = new JButton("0");
		zerobtn.setToolTipText("0");
		zerobtn.addActionListener((event) -> tf1.setText(tf1.getText()+"0"));
		 
		onebtn = new JButton("1");
		onebtn.setToolTipText("1");
		onebtn.addActionListener((event) -> press("1"));
		 
		twobtn = new JButton("2");
		twobtn.setToolTipText("2");
		twobtn.addActionListener((event) -> press("2"));
		 
		threebtn = new JButton("3");
		threebtn.setToolTipText("3");
		threebtn.addActionListener((event) -> press("3"));
		 
		fourbtn = new JButton("4");
		fourbtn.setToolTipText("4");
		fourbtn.addActionListener((event) -> press("4"));
		 
		fivebtn = new JButton("5");
		fivebtn.setToolTipText("5");
		fivebtn.addActionListener((event) -> press("5"));
		 
		sixbtn = new JButton("6");
		sixbtn.setToolTipText("6");
		sixbtn.addActionListener((event) -> press("6"));
		 
		sevenbtn = new JButton("7");
		sevenbtn.setToolTipText("7");
		sevenbtn.addActionListener((event) -> press("7"));
		 
		eightbtn = new JButton("8");
		eightbtn.setToolTipText("8");
		eightbtn.addActionListener((event) -> press("8"));
		 
		ninebtn = new JButton("9");
		ninebtn.setToolTipText("9");
		ninebtn.addActionListener((event) -> press("9"));
		 
		tf1= new JTextField();
	    tf1.setFont(font);
	    tf1.setText("         ");
	     
	    tf2 = new JTextField();
	    tf2.setFont(font);
	    tf2.setText("        ");

	    setTitle("calculator");
	    createFlowLayout();
	       //Position in screen center
	    setLocationRelativeTo(null);
	        //Close Application when window is closed
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

//	private void onSubmit() {
//		// TODO Auto-generated method stub
//		 tf2.setText("You entered: " + tf1.getText());
//	}
	
	public void  press (String name) {
		tf1.setText(tf1.getText()+name);
	}
	
	private double getResult(double val) {
		tf1.setText("");
		switch(presentmode) {
		  case PLUS:
			  return present + val;
		  case MINUS:
			  return  present- val;
		  case TIMES:
			  return present * val;
		  case DIVIDED:
			  return present /val;
		   default:
			   return -1;
		}
	}
	
	private void displayTest(double val) {
		tf2.setText(String.valueOf(getResult(val)));
	}
	
	private void createFlowLayout() {
		// TODO Auto-generated method stub
		pane = (JPanel) getContentPane();
        pane.add(tf1);
        pane.add(testbtn);
        pane.add(tf2);
        pane.add(quitbtn);
        pane.setLayout(new FlowLayout());
        pane.setSize(300, 300);
        
        pane1 =(JPanel) getContentPane();
        pane1.add(addbtn);
        pane1.add(dividebtn);
        pane1.add(mulbtn);
        pane1.add(subbtn);
        pane1.setSize(300, 300);
        
        pane2 =(JPanel) getContentPane();
        pane2.add(ninebtn);
        pane2.add(eightbtn);
        pane2.add(sevenbtn);
        pane2.add(sixbtn);
        pane2.add(fivebtn);
        pane2.setSize(300, 300);
        
        pane3 =(JPanel) getContentPane();
        pane3.add(fourbtn);
        pane3.add(threebtn);
        pane3.add(twobtn);
        pane3.add(onebtn);
        pane3.add(zerobtn);
        pane3.setSize(300, 300);
        
        pack();
	}
	
	private void addition(double present) {
		this.present= present;
		this.presentmode = Mode.PLUS;
		tf1.setText("");
	}
	
	private void substraction(double present) {
		this.present= present;
		this.presentmode = Mode.MINUS;
		tf1.setText("");
	}
	
	private void multiplication(double present) {
		this.present= present;
		this.presentmode = Mode.TIMES;
		tf1.setText("");
	}
	
	private void division(double present) {
		this.present= present;
		this.presentmode = Mode.DIVIDED;
		tf1.setText("");
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() ->{
			CalculatorGUI c = new CalculatorGUI();
			c.setVisible(true);
		});
	}
}
