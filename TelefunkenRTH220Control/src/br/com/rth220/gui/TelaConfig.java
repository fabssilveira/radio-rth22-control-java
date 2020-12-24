package br.com.rth220.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.com.rth220.util.HttpUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaConfig extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();	
	private JTextField txtIp;
	private String ip;
	

	/**
	 * Create the dialog.
	 */
	public TelaConfig() {
		setTitle("Config");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 265, 196);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 229, 102);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblIp = new JLabel("Endere\u00E7o IP");
		lblIp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIp.setBounds(10, 11, 124, 24);
		panel.add(lblIp);
		
		txtIp = new JTextField();
		txtIp.setHorizontalAlignment(SwingConstants.CENTER);
		txtIp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIp.setBounds(10, 46, 209, 31);
		panel.add(txtIp);
		txtIp.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						saveIp(txtIp.getText());
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");				
				buttonPane.add(cancelButton);
			}
		}
		
		initScreem();
	}
	
	private void initScreem() {
		ip = HttpUtils.getEndpoint();
		txtIp.setText(ip);
	}
	
	private void saveIp(String ip) {
		HttpUtils.setEndpoint(ip);
	}
}
