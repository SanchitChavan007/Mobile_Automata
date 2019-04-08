package edu.neu.csye6200.ma;

import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.xml.sax.HandlerBase;

public class MAUI extends MAApp {

	private static Logger log = Logger.getLogger(MAUI.class.getName());

	protected JPanel northPanel = null;
	protected JButton startBtn = null;
	protected JButton stopBtn = null;
	protected JComboBox<List> ruleComboBox = null;
	protected JButton setTime = null;
	protected JButton setActiveNumber = null;
	protected JButton resetBtn;
	protected JTextField timeInputField;
	protected JTextField activeCellsField;
	protected JLabel stepLabel;
	protected JLabel activeCells;
	private static MACanvas maPanel = null;
	private static String selectedRule = "RuleA";
	private int simulationSteps;
	private int activeNumber;
	private Timer timer;

	public MAUI() {
		frame.setSize(1000, 600);
		frame.setTitle("MA Simulation App");
		showUI(); // Cause the Swing Dispatch thread to display the JFrame
		timer = new Timer(100, this);
		timer.setRepeats(true);
	}

	// User Interaction Action Handler method
	@Override
	public void actionPerformed(ActionEvent ae) {
		timer.start();
		maPanel.start(simulationSteps);
		// Pressing Start Button
		if (ae.getActionCommand() == "Start") {
			if (timeInputField.getText().equals("") || activeCellsField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please Activate cells and provide Step Size");
			}
			else {
				HashSet<Integer> set = new HashSet<>();
				int offset = 0;
				while (activeNumber > 0) {

					set.add(maPanel.maxCols / 10 + offset);
					offset = maPanel.maxCols / 10 + offset;
					activeNumber--;
				}
				maPanel.addActiveCells(set);
			simulationSteps = Integer.parseInt(timeInputField.getText());
			activeNumber = Integer.parseInt(activeCellsField.getText());
			if (activeNumber > 0 && simulationSteps > 0) {
				log.info("We received an ActionEvent " + ae);
				System.out.println("Start pressed");
				simulationSteps = Integer.parseInt(timeInputField.getText());
			} else {
				JOptionPane.showMessageDialog(null, "Please enter active cell number and Step Size");
			}
		}
		}
		// Stopping Simulation
		else if (ae.getActionCommand() == "Stop") {
			log.info("We received an ActionEvent " + ae);
			System.out.println("Stop pressed");
			simulationSteps = 0;
			timer.stop();
		}
		// Selecting Rule from ComboBox
		else if ((ae.getActionCommand() == "comboBoxChanged")) {
			log.info("We received an ActionEvent " + ae);
			JComboBox cb = (JComboBox) ae.getSource();
			selectedRule = (String) cb.getSelectedItem();
			maPanel.currRule = selectedRule;
		}

		// Saving the number of steps
		else if (ae.getActionCommand() == "Set Steps") {
			if (timeInputField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter step size");

			} else {
				log.info("We received an ActionEvent " + ae);
				simulationSteps = Integer.parseInt(timeInputField.getText());
			}
		}

		// Saving active cells number to initiate simulation
		else if (ae.getActionCommand() == "Activate Cells") {
			log.info("We received an ActionEvent " + ae);
			if (activeCellsField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter active cell number");

			} else {
				timeInputField.setEnabled(true);
				activeNumber = Integer.parseInt(activeCellsField.getText());
				HashSet<Integer> set = new HashSet<>();
				int offset = 0;
				while (activeNumber > 0) {

					set.add(maPanel.maxCols / 10 + offset);
					offset = maPanel.maxCols / 10 + offset;
					activeNumber--;
				}
				maPanel.addActiveCells(set);
			}
		}
		
		else if (ae.getActionCommand() == "Reset") {
			simulationSteps = 0;
			activeNumber = 0;
			timeInputField.setText("");
			activeCellsField.setText("");
			timeInputField.setEnabled(false);
			maPanel.resetFrame();
	}
	}

	public String getSelectedRule() {
		return selectedRule;
	}

	public void setSelectedRule(String selectedRule) {
		this.selectedRule = selectedRule;
	}

	// Create Main Panel
	@Override
	public JPanel getMainPanel() {
		maPanel = new MACanvas(activeNumber);
		return maPanel;

	}

	public static void main(String[] args) {
		new MAUI();
	}

	// Create NorthPanel
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
		
		resetBtn = new JButton("Reset");
		resetBtn.addActionListener(this);
		northPanel.add(stopBtn);
		ruleComboBox = new JComboBox(rules);
		ruleComboBox.setSelectedIndex(0);
		ruleComboBox.addActionListener(this);
//		setTime = new JButton("Set Steps");
//		setTime.addActionListener(this);
		setActiveNumber = new JButton("Activate Cells");
		setActiveNumber.addActionListener(this);
		stepLabel = new JLabel("Step Size:");
		activeCells = new JLabel("Activate Cells");
		timeInputField = new JTextField(10);
		timeInputField.setEnabled(false);
		activeCellsField = new JTextField(10);
		northPanel.add(ruleComboBox);
		northPanel.add(resetBtn);
//		northPanel.add(setTime);
		northPanel.add(stepLabel);
		northPanel.add(timeInputField);
		northPanel.add(setActiveNumber);
//		northPanel.add(activeCells);
		northPanel.add(activeCellsField);
		

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
