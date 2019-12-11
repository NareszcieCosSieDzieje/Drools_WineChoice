package com.sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class WineChooserGUI {
	
	private JLabel questionLabel;
	
	private JFrame frame;
	
	private JList<String> answerList;
	
	private WineChooser.Exchange currentExchange;
<<<<<<< HEAD
	
	private JLabel finalLabel;
=======
>>>>>>> 5639d56a8da57300bbbc800bdf05556c1e37979f

	/**
	 * Create the application.
	 */
	public WineChooserGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
<<<<<<< HEAD
		frame.setBounds(100, 100, 1061, 711);
=======
		frame.setBounds(100, 100, 797, 586);
>>>>>>> 5639d56a8da57300bbbc800bdf05556c1e37979f
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		questionLabel = new JLabel("Loading . . .");
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		questionLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		
		JButton btnSendAnswer = new JButton("Send answer");
		btnSendAnswer.setBackground(SystemColor.info);
<<<<<<< HEAD
		btnSendAnswer.setFont(new Font("Dialog", Font.BOLD, 28));
=======
		btnSendAnswer.setFont(new Font("Dialog", Font.BOLD, 24));
>>>>>>> 5639d56a8da57300bbbc800bdf05556c1e37979f
		btnSendAnswer.setEnabled(false);
		btnSendAnswer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnSendAnswer.isEnabled()) {
					String answer = answerList.getSelectedValue();
					currentExchange.setAnswer(answer);
<<<<<<< HEAD
					btnSendAnswer.setEnabled(false);
=======
>>>>>>> 5639d56a8da57300bbbc800bdf05556c1e37979f
				}
			}
		});
		
		DefaultListModel<String> model = new DefaultListModel<>();
		answerList = new JList<>(model);
<<<<<<< HEAD
		answerList.setFont(new Font("Dialog", Font.BOLD, 26));
=======
		answerList.setFont(new Font("Dialog", Font.BOLD, 20));
>>>>>>> 5639d56a8da57300bbbc800bdf05556c1e37979f
		answerList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (answerList.getSelectedValue() != null) {
					btnSendAnswer.setEnabled(true);
				}
			}
		});
		answerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
<<<<<<< HEAD
		finalLabel = new JLabel("");
		finalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		finalLabel.setFont(new Font("Dialog", Font.BOLD, 39));
		
=======
>>>>>>> 5639d56a8da57300bbbc800bdf05556c1e37979f
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
<<<<<<< HEAD
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(395)
							.addComponent(btnSendAnswer))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(answerList, GroupLayout.PREFERRED_SIZE, 979, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(questionLabel, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE))
						.addComponent(finalLabel, GroupLayout.PREFERRED_SIZE, 1037, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
=======
					.addContainerGap()
					.addComponent(questionLabel, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(answerList, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addComponent(btnSendAnswer)
					.addGap(50))
>>>>>>> 5639d56a8da57300bbbc800bdf05556c1e37979f
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
<<<<<<< HEAD
					.addContainerGap()
					.addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(finalLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(answerList, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(btnSendAnswer, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
=======
					.addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
							.addComponent(answerList, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
							.addGap(27))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(163)
							.addComponent(btnSendAnswer, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
>>>>>>> 5639d56a8da57300bbbc800bdf05556c1e37979f
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public void setQuestion(String question) {
		this.questionLabel.setText(question);
	}
	
	public void setAnswers(ArrayList<String> answers) {
		((DefaultListModel<String>)this.answerList.getModel()).removeAllElements();
		for (String answer : answers) {
			((DefaultListModel<String>)this.answerList.getModel()).addElement(answer);;
		}
	}
	
	public void setCurrentExchange(WineChooser.Exchange e) {
		this.currentExchange = e;
		this.setQuestion(e.getQuestion());
	}
	
<<<<<<< HEAD
	public void finishChoosing(String wineType) {
		answerList.setEnabled(false);
		if (wineType != null)
			finalLabel.setText();
=======
	public void finishChoosing() {
		answerList.setEnabled(false);
>>>>>>> 5639d56a8da57300bbbc800bdf05556c1e37979f
	}
	
	public String waitForAnswer() throws InterruptedException {
		while(currentExchange.getAnswer().equals("")) {
			Thread.sleep(100);
		}
		return currentExchange.getAnswer();
	}
}
