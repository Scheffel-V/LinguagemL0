package userInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class InterfaceSintaxe {
	
	private JFrame framePrincipal;
	private JPanel panelPrincipal;
	
	public InterfaceSintaxe() {
		framePrincipal = new JFrame();
		framePrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceSintaxe.class.getResource("/images/L0.png")));
		framePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framePrincipal.setResizable(false);
		framePrincipal.setBounds(50,50,193,219);
		panelPrincipal = new JPanel();
		framePrincipal.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel label = new JLabel("0");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(10, 73, 46, 14);
		panelPrincipal.add(label);
		
		JLabel lblTrue = new JLabel("true");
		lblTrue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrue.setBounds(10, 103, 46, 14);
		panelPrincipal.add(lblTrue);
		
		JLabel lblFalse = new JLabel("false");
		lblFalse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFalse.setBounds(10, 133, 46, 14);
		panelPrincipal.add(lblFalse);
		
		JLabel lblIszerot = new JLabel("iszero(t)");
		lblIszerot.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIszerot.setBounds(10, 163, 62, 14);
		panelPrincipal.add(lblIszerot);
		
		JLabel lblSucct = new JLabel("succ(t)");
		lblSucct.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSucct.setBounds(85, 73, 46, 14);
		panelPrincipal.add(lblSucct);
		
		JLabel lblPredt = new JLabel("pred(t)");
		lblPredt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPredt.setBounds(85, 103, 46, 14);
		panelPrincipal.add(lblPredt);
		
		JLabel lblIfttt = new JLabel("if(t1,t2,t3)");
		lblIfttt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIfttt.setBounds(85, 133, 73, 14);
		panelPrincipal.add(lblIfttt);
		
		JLabel lblTtt = new JLabel("t,t1,t2...");
		lblTtt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTtt.setBounds(10, 11, 81, 14);
		panelPrincipal.add(lblTtt);
		
		JLabel lblTerms = new JLabel("Terms");
		lblTerms.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTerms.setBounds(85, 11, 81, 14);
		panelPrincipal.add(lblTerms);
		
		JLabel lblT = new JLabel("t   ::=");
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblT.setBounds(10, 36, 46, 14);
		panelPrincipal.add(lblT);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(InterfaceSintaxe.class.getResource("/images/pertence.JPG")));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(66, 12, 11, 14);
		panelPrincipal.add(label_1);
		
	}
	
	public void showUI(){
		this.framePrincipal.setVisible(true);
	}
}
