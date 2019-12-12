package com.sample;


import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
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
	
	private JLabel finalLabel;

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
		frame.setBounds(100, 100, 1061, 711);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		questionLabel = new JLabel("Loading . . .");
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		questionLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		
		JButton btnSendAnswer = new JButton("Send answer");
		btnSendAnswer.setBackground(SystemColor.info);
		btnSendAnswer.setFont(new Font("Dialog", Font.BOLD, 28));
		btnSendAnswer.setEnabled(false);
		btnSendAnswer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnSendAnswer.isEnabled()) {
					String answer = answerList.getSelectedValue();
					currentExchange.setAnswer(answer);
					btnSendAnswer.setEnabled(false);
				}
			}
		});
		
		DefaultListModel<String> model = new DefaultListModel<>();
		answerList = new JList<>(model);
		answerList.setFont(new Font("Dialog", Font.BOLD, 26));
		answerList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (answerList.getSelectedValue() != null) {
					btnSendAnswer.setEnabled(true);
				}
			}
		});
		answerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		finalLabel = new JLabel("");
		finalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		finalLabel.setFont(new Font("Dialog", Font.BOLD, 39));
		finalLabel.setForeground(Color.red);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
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
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(finalLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(answerList, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(btnSendAnswer, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
					.addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
							.addComponent(answerList, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
							.addGap(27))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(163)
							.addComponent(btnSendAnswer, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())));
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
	
	public void finishChoosing(String wineType) {
		answerList.setEnabled(false);
		if (wineType != null)
			finalLabel.setText(wineType);
	}
	
	public String waitForAnswer() throws InterruptedException {
		while(currentExchange.getAnswer().equals("")) {
			Thread.sleep(100);
		}
		return currentExchange.getAnswer();
	}
}
