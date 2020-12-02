package br.com.rth220.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class TelaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setResizable(false);
		setTitle("Telefunken RTH220 HF Transceiver Control");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelButtons.setBounds(6, 6, 688, 45);
		contentPane.add(panelButtons);
		panelButtons.setLayout(null);
		
		JButton btnConnect = new JButton("Connect to Radio");
		btnConnect.setBounds(6, 6, 152, 29);
		panelButtons.add(btnConnect);
		
		JButton btnUpdateHostIP = new JButton("Update Host IP");
		btnUpdateHostIP.setBounds(170, 6, 117, 29);
		panelButtons.add(btnUpdateHostIP);
		
		JPanel panelStatus = new JPanel();
		panelStatus.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelStatus.setBounds(6, 392, 688, 24);
		contentPane.add(panelStatus);
		
		JLabel lblDial = new JLabel("FREQUENCY");
		lblDial.setHorizontalAlignment(SwingConstants.CENTER);
		lblDial.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblDial.setBounds(285, 63, 129, 24);
		contentPane.add(lblDial);
		
		JLabel lblBands = new JLabel("HAM Bands");
		lblBands.setHorizontalAlignment(SwingConstants.CENTER);
		lblBands.setBounds(23, 191, 95, 16);
		contentPane.add(lblBands);
		
		JRadioButton rdbtn80m = new JRadioButton("80 m");
		rdbtn80m.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn80m.setBounds(23, 218, 95, 23);
		contentPane.add(rdbtn80m);
		
		JRadioButton rdbtn40m = new JRadioButton("40 m");
		rdbtn40m.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn40m.setBounds(23, 259, 95, 23);
		contentPane.add(rdbtn40m);
		
		JRadioButton rdbtn20m = new JRadioButton("20 m");
		rdbtn20m.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn20m.setBounds(23, 300, 95, 23);
		contentPane.add(rdbtn20m);
		
		JRadioButton rdbtn15m = new JRadioButton("15 m");
		rdbtn15m.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn15m.setBounds(23, 341, 95, 23);
		contentPane.add(rdbtn15m);
		
		JLabel lblBands_1 = new JLabel("HAM Bands");
		lblBands_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBands_1.setBounds(580, 191, 95, 16);
		contentPane.add(lblBands_1);
		
		JRadioButton rdbtn80m_1 = new JRadioButton("80 m");
		rdbtn80m_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn80m_1.setBounds(580, 218, 95, 23);
		contentPane.add(rdbtn80m_1);
		
		JRadioButton rdbtn40m_1 = new JRadioButton("40 m");
		rdbtn40m_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn40m_1.setBounds(580, 259, 95, 23);
		contentPane.add(rdbtn40m_1);
		
		JRadioButton rdbtn20m_1 = new JRadioButton("20 m");
		rdbtn20m_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn20m_1.setBounds(580, 300, 95, 23);
		contentPane.add(rdbtn20m_1);
		
		JRadioButton rdbtn15m_1 = new JRadioButton("15 m");
		rdbtn15m_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn15m_1.setBounds(580, 341, 95, 23);
		contentPane.add(rdbtn15m_1);
	}
}
