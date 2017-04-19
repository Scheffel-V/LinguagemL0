package userInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import linguagemzero.BigStep;
import linguagemzero.NoRuleAppliesException;
import linguagemzero.Step;
import linguagemzero.Term;
import linguagemzero.TmFalse;
import linguagemzero.TmIf;
import linguagemzero.TmIsZero;
import linguagemzero.TmPred;
import linguagemzero.TmSucc;
import linguagemzero.TmTrue;
import linguagemzero.TmZero;
import sistemadetipos.SistemaDeTipos;
import ssm.CodeStackTuple;
import ssm.Instructions;
import ssm.Jump;
import ssm.JumpIfZero;
import ssm.Push;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import compilacao.Compilacao;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfaceL0 {
	private JFrame framePrincipal;
	private JPanel panelPrincipal;
	private JTextField textField;
	private JTextField textField_1;
	private Term term;
	private JTextArea textArea;
	private ArrayList<JLabel> labelListCode;
	private ArrayList<JLabel> labelListStack;
	private JButton btnSmallStep;
	private JButton btnBigStep;
	private JButton btnCompilar;
	private JScrollPane scrollPane;
	private JCheckBox chckbxSistemaDeTipos;
	
	public InterfaceL0() {
		framePrincipal = new JFrame();
		framePrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceL0.class.getResource("/images/L0.png")));
		framePrincipal.setResizable(false);
		framePrincipal.setTitle("Linguagem L0");
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.setBounds(50, 50, 862, 507);
		panelPrincipal = new JPanel();
		framePrincipal.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 50, 572, 20);
		panelPrincipal.add(textField);
		textField.setColumns(10);
		
		JLabel lblTermoInicial = new JLabel("Termo Inicial");
		lblTermoInicial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTermoInicial.setBounds(10, 25, 121, 20);
		panelPrincipal.add(lblTermoInicial);
		
		JButton btnValidrTermo = new JButton("Validar Termo");
		btnValidrTermo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnValidrTermo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					term = (validarTermo(textField.getText()));
					if(chckbxSistemaDeTipos.isSelected()){
						if(SistemaDeTipos.verificarTermo(term)){
							if(term != null){
								textField_1.setText(term.printTerm());
								textArea.setText("");
								btnSmallStep.setEnabled(true);
								btnBigStep.setEnabled(true);
								btnCompilar.setEnabled(true);
							}
						}
					}else{
						if(term != null){
							textField_1.setText(term.printTerm());
							textArea.setText("");
							btnSmallStep.setEnabled(true);
							btnBigStep.setEnabled(true);
							btnCompilar.setEnabled(true);
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}				
			}
		});
		btnValidrTermo.setBounds(10, 99, 121, 23);
		panelPrincipal.add(btnValidrTermo);
		
		JButton btnSintaxeAceita = new JButton("Sintaxe Padr\u00E3o");
		btnSintaxeAceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSintaxePadrao();
			}
		});
		btnSintaxeAceita.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSintaxeAceita.setBounds(10, 76, 121, 23);
		panelPrincipal.add(btnSintaxeAceita);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 141, 572, 20);
		panelPrincipal.add(textField_1);
		
		btnSmallStep = new JButton("Small Step");
		btnSmallStep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSmallStep.setEnabled(false);
		btnSmallStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					term = (new Step(term)).getT2();
					textField_1.setText(term.printTerm());
					textArea.append(term.printTerm()+"\n");
				} catch (NoRuleAppliesException e) {
					JOptionPane.showMessageDialog(null, "Termo já é valor.");
				}
			}
		});
		btnSmallStep.setBounds(10, 172, 121, 23);
		panelPrincipal.add(btnSmallStep);
		
		btnBigStep = new JButton("Big Step");
		btnBigStep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBigStep.setEnabled(false);
		btnBigStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				term = (new BigStep(term)).getFinalTerm();
				textField_1.setText(term.printTerm());
				textArea.append(term.printTerm()+"\n");
			}
		});
		btnBigStep.setBounds(221, 172, 121, 23);
		panelPrincipal.add(btnBigStep);
		
		btnCompilar = new JButton("Compilar");
		btnCompilar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCompilar.setEnabled(false);
		btnCompilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				compilar();
			}
		});
		btnCompilar.setBounds(461, 172, 121, 23);
		panelPrincipal.add(btnCompilar);
		
		JLabel lblHistrico = new JLabel("Hist\u00F3rico");
		lblHistrico.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHistrico.setBounds(10, 223, 73, 14);
		panelPrincipal.add(lblHistrico);
				
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 239, 572, 218);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 239, 572, 218);
		panelPrincipal.add(scrollPane);
		
		labelListCode = new ArrayList<JLabel>();
		labelListStack = new ArrayList<JLabel>();
		
		JLabel lblPilhaDoCode = new JLabel("Pilha do Code");
		lblPilhaDoCode.setFont(new Font("Arial", Font.BOLD, 15));
		lblPilhaDoCode.setBounds(596, 443, 117, 14);
		panelPrincipal.add(lblPilhaDoCode);
		
		JLabel lblPilhaDoStack = new JLabel("Pilha do Stack");
		lblPilhaDoStack.setFont(new Font("Arial", Font.BOLD, 15));
		lblPilhaDoStack.setBounds(719, 443, 117, 14);
		panelPrincipal.add(lblPilhaDoStack);
		
		chckbxSistemaDeTipos = new JCheckBox("Sistema De Tipos");
		chckbxSistemaDeTipos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxSistemaDeTipos.setBounds(152, 99, 170, 23);
		panelPrincipal.add(chckbxSistemaDeTipos);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				label.setIcon(new ImageIcon(InterfaceL0.class.getResource("/images/icon(3).png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setIcon(new ImageIcon(InterfaceL0.class.getResource("/images/icon(2).png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Desenvolvido por Vinícius Scheffel\nvbscheffel@inf.ufrgs.br\nAbril, 2017");
			}
		});
		label.setIcon(new ImageIcon(InterfaceL0.class.getResource("/images/icon(2).png")));
		label.setBounds(822, 11, 24, 24);
		panelPrincipal.add(label);
	}
	
	public void showUI(){
		this.framePrincipal.setVisible(true);
	}
	
	private void compilar(){
		InterfaceL0 interfaceL0 = this;
		SwingWorker<Void, Void>worker = new SwingWorker<Void, Void>(){
			@Override
			protected Void doInBackground() throws Exception {
				CodeStackTuple codeStack = new CodeStackTuple(interfaceL0);
				new Compilacao(term, codeStack.getCode());
				codeStack.executeAll(interfaceL0);
				return null;
			}
			
			@Override
			protected void done() {
				super.done();
			}
		};
		worker.execute();
	}
	
	private Term validarTermo(String entrada) throws Exception{
		if(entrada.equals("true")){
			return new TmTrue();
		}else if(entrada.equals("false")){
			return new TmFalse();
		}else if(entrada.equals("0")){
			return new TmZero();
		}else{
			int contador = 0;
			if(entrada.charAt(0) == 'i' && entrada.charAt(1) == 'f' && entrada.charAt(2) == '('){
				boolean flag = true;
				int i = 3;
				int pilha = 0;
				String t1 = "";
				String t2 = "";
				String t3 = "";
				while(flag){
					if(entrada.charAt(i) == ')' && contador == 2 && pilha == 0){
						flag = false;
					}else if(entrada.charAt(i) == ',' && contador < 2 && pilha == 0){
						contador++;
					}else{
						switch(contador){
							case 0:
								if(entrada.charAt(i) == '(')
									pilha++;
								if(entrada.charAt(i) == ')')
									pilha--;
								t1 = t1 + entrada.charAt(i);
								break;
							case 1:
								if(entrada.charAt(i) == '(')
									pilha++;
								if(entrada.charAt(i) == ')')
									pilha--;
								t2 = t2 + entrada.charAt(i);
								break;
							case 2:
								if(entrada.charAt(i) == '(')
									pilha++;
								if(entrada.charAt(i) == ')')
									pilha--;
								t3 = t3 + entrada.charAt(i);
								break;
						}	
					}
					i++;
				}
				return new TmIf(validarTermo(t1), validarTermo(t2), validarTermo(t3));
			}else if(entrada.charAt(0) == 's' && entrada.charAt(1) == 'u' && entrada.charAt(2) == 'c' && entrada.charAt(3) == 'c' && entrada.charAt(4) == '('){
				boolean flag = true;
				String t1 = "";
				int i = 5;
				int pilha=0;
				while(flag){
					if(entrada.charAt(i) == ')' && pilha == 0){
						flag = false;
					}else{
						if(entrada.charAt(i) == '(')
							pilha++;
						if(entrada.charAt(i) == ')')
							pilha--;
						t1 = t1 + entrada.charAt(i);
					}	
					i++;
				}
				return new TmSucc(validarTermo(t1));
			}else if(entrada.charAt(0) == 'p' && entrada.charAt(1) == 'r' && entrada.charAt(2) == 'e' && entrada.charAt(3) == 'd' && entrada.charAt(4) == '('){
				boolean flag = true;
				String t1 = "";
				int i = 5;
				int pilha = 0;
				while(flag){
					if(entrada.charAt(i) == ')' && pilha == 0){
						flag = false;
					}else{
						if(entrada.charAt(i) == '(')
							pilha++;
						if(entrada.charAt(i) == ')')
							pilha--;
						t1 = t1 + entrada.charAt(i);
					}	
					i++;
				}
				return new TmPred(validarTermo(t1.toString()));
			}else if(entrada.charAt(0) == 'i' && entrada.charAt(1) == 's' && entrada.charAt(2) == 'z' && entrada.charAt(3) == 'e' && entrada.charAt(4) == 'r' &&
					entrada.charAt(5) == 'o' && entrada.charAt(6) == '('){
				boolean flag = true;
				String t1 = "";
				int i = 7;
				int pilha = 0;
				while(flag){
					if(entrada.charAt(i) == ')' && pilha == 0){
						flag = false;
					}else{
						if(entrada.charAt(i) == '(')
							pilha++;
						if(entrada.charAt(i) == ')')
							pilha--;
						t1 = t1 + entrada.charAt(i);
					}	
					i++;
				}
				return new TmIsZero(validarTermo(t1.toString()));
			}else{
				throw new Exception();
			}
		}
	}
	
	public void updateUI(ArrayList<Instructions> codeList, ArrayList<Integer> stackList){
		updateCode(codeList);
		updateStack(stackList);
		panelPrincipal.repaint();
		for(JLabel label : labelListCode){
			label.setVisible(true);
		}
		for(JLabel label : labelListStack)
		{
			label.setVisible(true);
		}
	}
	
	private void updateCode(ArrayList<Instructions> codeList){
		for(JLabel label : labelListCode){
			panelPrincipal.remove(label);
		}
		labelListCode.clear();
		panelPrincipal.repaint();
		
		int i = 0;
		JLabel label;
		for(Instructions inst : codeList){
			switch(inst.getClass().toString()){
				case "class ssm.Push":
					label = new JLabel("PUSH " + ((Push)inst).getZ());
					if(i == 0)
						label.setForeground(Color.RED);
					label.setBounds(596, 427-(16*i), 130, 14);
					panelPrincipal.add(label);
					labelListCode.add(label);
					i++;
					break;
				case "class ssm.JumpIfZero":
					label = new JLabel("JUMPIFZERO " + ((JumpIfZero)inst).getN());
					if(i == 0)
						label.setForeground(Color.RED);
					label.setBounds(596, 427-(16*i), 130, 14);
					panelPrincipal.add(label);
					labelListCode.add(label);
					i++;
					break;
				case "class ssm.Jump":
					label = new JLabel("JUMP " + ((Jump)inst).getN());
					if(i == 0)
						label.setForeground(Color.RED);
					label.setBounds(596, 427-(16*i), 130, 14);
					panelPrincipal.add(label);
					labelListCode.add(label);
					i++;
					break;
				case "class ssm.Inc":
					label = new JLabel("INC");
					label.setBounds(596, 427-(16*i), 130, 14);
					if(i == 0)
						label.setForeground(Color.RED);
					panelPrincipal.add(label);
					labelListCode.add(label);
					i++;
					break;
				case "class ssm.Dec":
					label = new JLabel("DEC");
					label.setBounds(596, 427-(16*i), 130, 14);
					if(i == 0)
						label.setForeground(Color.RED);
					panelPrincipal.add(label);
					labelListCode.add(label);
					i++;
					break;
				case "class ssm.Pop":
					label = new JLabel("POP");
					label.setBounds(596, 427-(16*i), 130, 14);
					if(i == 0)
						label.setForeground(Color.RED);
					panelPrincipal.add(label);
					labelListCode.add(label);
					i++;
					break;
				case "class ssm.Copy":
					label = new JLabel("COPY");
					label.setBounds(596, 427-(16*i), 130, 14);
					if(i == 0)
						label.setForeground(Color.RED);
					panelPrincipal.add(label);
					labelListCode.add(label);
					i++;
					break;
				default:
					label = new JLabel("ERROR");
					label.setBounds(596, 427-(16*i), 130, 14);
					panelPrincipal.add(label);
					labelListCode.add(label);
					i++;
					break;
			}
		}
		panelPrincipal.repaint();
	}
	
	private void updateStack(ArrayList<Integer> stackList){
		for(JLabel label : labelListStack){
			panelPrincipal.remove(label);
		}
		labelListStack.clear();
		
		int i = 0;
		for(Integer value : stackList){
			JLabel label = new JLabel(String.valueOf(value));
			label.setBounds(719, 427-(16*i), 130, 14);
			panelPrincipal.add(label);
			labelListStack.add(label);
			i++;
		}
	}
	
	private void showSintaxePadrao(){
		InterfaceSintaxe ui = new InterfaceSintaxe();
		ui.showUI();
	}
}
