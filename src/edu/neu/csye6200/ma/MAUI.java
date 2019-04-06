package edu.neu.csye6200.ma;

import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MAUI extends MAApp {
	
	private static Logger log = Logger.getLogger(MAUI.class.getName());

	protected JPanel northPanel = null;
	protected JButton startBtn = null;
	protected JButton stopBtn = null;
	protected JComboBox<List> ruleComboBox = null;
	protected JButton setTime = null;
	protected JTextField timeInputField;
    private static MACanvas maPanel = null;
    private static String selectedRule = "RuleA";
    private double simulationTime = 1;

	public MAUI() {
		// TODO Auto-generated constructor stub
		frame.setSize(500, 400);
		frame.setTitle("MA Simulation App");	
    	showUI(); // Cause the Swing Dispatch thread to display the JFrame
	}
	
   
	@Override
	public void actionPerformed(ActionEvent ae) {
		log.info("We received an ActionEvent " + ae);
		if (ae.getActionCommand() == "Start") {
			System.out.println("Start pressed");
			maPanel.start();
			
		}
		else if (ae.getActionCommand() == "Stop") {
			System.out.println("Stop pressed");
		   timeInputField.setEnabled(true);


		}
		//Selecting Rule from ComboBox
		else if((ae.getActionCommand() == "comboBoxChanged")) {
		JComboBox cb = (JComboBox)ae.getSource();
		selectedRule = (String)cb.getSelectedItem();
		System.out.println(selectedRule);
		}		
		
		else if(ae.getActionCommand() == "Set Time") {
			simulationTime = Double.parseDouble(timeInputField.getText());
			   timeInputField.setEnabled(false);

			System.out.println(simulationTime);
		}
	}
	
	

	public String getSelectedRule() {
		return selectedRule;
	}


	public void setSelectedRule(String selectedRule) {
		this.selectedRule = selectedRule;
	}


	@Override
	public JPanel getMainPanel() {
		// TODO Auto-generated method stub
		maPanel = new MACanvas();
		return maPanel;

	}
	public static void main(String[] args) {
		MAUI maui = new MAUI();
		log.info("MAApp started");
	}


	@Override
	protected JPanel getNorthPanel() {
		
				String[] rules = { "RuleA", "RuleB", "RuleC" };
		
		    	northPanel = new JPanel();
		    	northPanel.setLayout(new FlowLayout());
		    	
		    	startBtn = new JButton("Start");
		    	startBtn.addActionListener(this); // Start-Button push initiated
		    	northPanel.add(startBtn);
		    	
		    	stopBtn = new JButton("Stop"); // Stop-Button push initiated
		    	stopBtn.addActionListener(this);
		    	northPanel.add(stopBtn);
		    	ruleComboBox = new JComboBox(rules);
		    	ruleComboBox.setSelectedIndex(0);
		    	ruleComboBox.addActionListener(this);
		    	setTime = new JButton("Set Time");
		    	setTime.addActionListener(this);
		    	timeInputField = new JTextField("Input Time");
		    	timeInputField.addActionListener(this);
		    	northPanel.add(ruleComboBox);
		    	northPanel.add(setTime);
		    	northPanel.add(timeInputField);


		    	return northPanel;
		    }


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


}
