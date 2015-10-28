import static java.lang.Math.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Calculator extends JFrame {
	
	    JTextField aInput, bInput, cInput;
	    JButton calculateButton;
	    JLabel answerLabel;
	    DecimalFormat fmt = new DecimalFormat("0.##");

	    
	    public Calculator()
	    {
	    	Font font = new Font("Arial", Font.PLAIN, 30);
	    	
	        setLayout(null);
	        
	        aInput = new JTextField();
	        add(aInput);
	        aInput.setBounds(0,0,200,100);
	        aInput.setFont(font);
	        aInput.setHorizontalAlignment(JTextField.CENTER);
	        
	        bInput = new JTextField();
	        add(bInput);
	        bInput.setBounds(200,0,200,100);
	        bInput.setFont(font);
	        bInput.setHorizontalAlignment(JTextField.CENTER);
	        
	        cInput = new JTextField();
	        add(cInput);
	        cInput.setBounds(400,0,200,100);
	        cInput.setFont(font);
	        cInput.setHorizontalAlignment(JTextField.CENTER);
	        
	        calculateButton = new JButton("Calculate");
	        add(calculateButton);
	        calculateButton.setBounds(0,100,200,100);
	        
	        answerLabel = new JLabel();
	        add(answerLabel);
	        answerLabel.setBounds(200,100,400,100);
	        answerLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        answerLabel.setVerticalAlignment(SwingConstants.CENTER);

	        event e = new event();
	        calculateButton.addActionListener(e);      
	        
	    } 
	    
	    public class event implements ActionListener
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	            Double a , b , c , delta;
	            String answer= "";
	            if(aInput.getText().equals("") || bInput.getText().equals("") || cInput.getText().equals(""))
	            {
	                
	            }else
	            {
	                a = Double.parseDouble(aInput.getText());
	                b = Double.parseDouble(bInput.getText());
	                c = Double.parseDouble(cInput.getText());
	            
	                delta= b*b - 4*a*c;
	                
	                if(delta >= 0)
	                {
	                    answer = ("<html>Delta = " + delta + "<br>" );
	                    
	                    Double x1 ,x2, numerator1, denominator, numerator2;
	                    denominator = 2 * a;
	                    numerator1 = (-b - sqrt(delta));
	                    numerator2 = (-b + sqrt(delta));
	                    x1 = ( -b - sqrt(delta) ) / (2*a);
	                    x2 = ( -b + sqrt(delta) ) / (2*a);
	                    answer = answer.concat(("X1 = " + "(-" + b + " - \u221A" + delta + ") / " + 2 * a + "   =   " + fmt.format(numerator1) + " / " + fmt.format(denominator) + " = " + fmt.format(x1) + "<br>"));
	                                            
	                    answer = answer.concat(("X2 = " + "(-" + b + " + \u221A" + delta + ") / " + 2 * a + "   =   " + fmt.format(numerator2) + " / " + fmt.format(denominator) + " = " + fmt.format(x2) + "</html>"));
	                }else
	                {
	                    answer = ("Delta = " + fmt.format(delta) + " is less that zero");
	                }
	            }
	            answerLabel.setText(answer);
	            
	        }
	    }
	    
	    public static void main (String[] args)
	    {
	        Calculator gui = new Calculator();
	        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        gui.setVisible(true);
	        gui.setSize(604,227);
	        gui.setTitle("Quadratic Equation Calculator");
	        gui.setLocation(350,200);
	        gui.setResizable(false);
	    }
	
}
