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
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroupBands = new ButtonGroup();
	private final ButtonGroup buttonGroupModes = new ButtonGroup();
	private JTextField txtDial;
	private JButton btnConnect;
	private JButton btnUpdateHostIP;
	private JButton btnPlus10000;
	private JButton btnPlus1000;
	private JButton btnPlus100;
	private JButton btnMinus100;
	private JButton btnMinus1000;
	private JButton btnMinus10000;
	private JRadioButton rdbtn80m;
	private JRadioButton rdbtn40m;
	private JRadioButton rdbtn20m;
	private JRadioButton rdbtn15m;
	private JRadioButton rdbtnUSB;
	private JRadioButton rdbtnLSB;
	private JRadioButton rdbtnFT8;

	private final String BANDA_15M = "15m";
	private final String BANDA_20M = "20m";
	private final String BANDA_40M = "40m";
	private final String BANDA_80M = "80m";

	private String bandaSelecionada = BANDA_40M;
	private String modo = "USB";
	private int freq = 7000000;
	private boolean connected = false;

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

		JLabel lblHz = new JLabel("Hz");
		lblHz.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHz.setBounds(453, 120, 48, 24);
		contentPane.add(lblHz);

		txtDial = new JTextField();
		txtDial.setHorizontalAlignment(SwingConstants.CENTER);
		txtDial.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtDial.setText("7.000.000");
		txtDial.setEditable(false);
		txtDial.setBounds(193, 98, 308, 58);
		contentPane.add(txtDial);
		txtDial.setColumns(10);

		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelButtons.setBounds(6, 6, 678, 45);
		contentPane.add(panelButtons);
		panelButtons.setLayout(null);

		btnConnect = new JButton("Connect to Radio");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonConnectHandler();
			}
		});
		btnConnect.setBounds(6, 6, 203, 29);
		panelButtons.add(btnConnect);

		btnUpdateHostIP = new JButton("Update Host IP");
		btnUpdateHostIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdateHostIP.setBounds(219, 6, 145, 29);
		panelButtons.add(btnUpdateHostIP);

		JPanel panelStatus = new JPanel();
		panelStatus.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelStatus.setBounds(6, 386, 678, 24);
		contentPane.add(panelStatus);

		JLabel lblDial = new JLabel("FREQUENCY");
		lblDial.setHorizontalAlignment(SwingConstants.CENTER);
		lblDial.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblDial.setBounds(282, 63, 129, 24);
		contentPane.add(lblDial);

		JLabel lblBands = new JLabel("HAM Bands");
		lblBands.setHorizontalAlignment(SwingConstants.CENTER);
		lblBands.setBounds(30, 191, 95, 16);
		contentPane.add(lblBands);

		rdbtn80m = new JRadioButton("80 m");
		rdbtn80m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroupBands.add(rdbtn80m);
		rdbtn80m.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn80m.setBounds(30, 218, 95, 23);
		contentPane.add(rdbtn80m);

		rdbtn40m = new JRadioButton("40 m");
		rdbtn40m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroupBands.add(rdbtn40m);
		rdbtn40m.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn40m.setBounds(30, 259, 95, 23);
		contentPane.add(rdbtn40m);

		rdbtn20m = new JRadioButton("20 m");
		rdbtn20m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroupBands.add(rdbtn20m);
		rdbtn20m.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn20m.setBounds(30, 300, 95, 23);
		contentPane.add(rdbtn20m);

		rdbtn15m = new JRadioButton("15 m");
		rdbtn15m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroupBands.add(rdbtn15m);
		rdbtn15m.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn15m.setBounds(30, 341, 95, 23);
		contentPane.add(rdbtn15m);

		JLabel lblModes = new JLabel("Modes");
		lblModes.setHorizontalAlignment(SwingConstants.CENTER);
		lblModes.setBounds(571, 191, 95, 16);
		contentPane.add(lblModes);

		rdbtnUSB = new JRadioButton("USB");
		rdbtnUSB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroupModes.add(rdbtnUSB);
		rdbtnUSB.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnUSB.setBounds(571, 218, 95, 23);
		contentPane.add(rdbtnUSB);

		rdbtnLSB = new JRadioButton("LSB");
		rdbtnLSB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroupModes.add(rdbtnLSB);
		rdbtnLSB.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnLSB.setBounds(571, 278, 95, 23);
		contentPane.add(rdbtnLSB);

		rdbtnFT8 = new JRadioButton("FT8");
		rdbtnFT8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroupModes.add(rdbtnFT8);
		rdbtnFT8.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnFT8.setBounds(571, 341, 95, 23);
		contentPane.add(rdbtnFT8);

		btnPlus100 = new JButton("+");
		btnPlus100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlus100.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPlus100.setBounds(295, 248, 48, 39);
		contentPane.add(btnPlus100);

		btnMinus100 = new JButton("-");
		btnMinus100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMinus100.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMinus100.setBounds(353, 248, 48, 39);
		contentPane.add(btnMinus100);

		btnPlus1000 = new JButton("+");
		btnPlus1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlus1000.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPlus1000.setBounds(232, 241, 53, 52);
		contentPane.add(btnPlus1000);

		btnMinus1000 = new JButton("-");
		btnMinus1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMinus1000.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus1000.setBounds(411, 241, 53, 52);
		contentPane.add(btnMinus1000);

		btnPlus10000 = new JButton("+");
		btnPlus10000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlus10000.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPlus10000.setBounds(155, 234, 67, 67);
		contentPane.add(btnPlus10000);

		btnMinus10000 = new JButton("+");
		btnMinus10000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMinus10000.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMinus10000.setBounds(474, 234, 67, 67);
		contentPane.add(btnMinus10000);
	}

	//Métodos funcionais da classe
	//***************************************************************************
	
	/**
	 * Método que lida com o botão de conexão ao rádio.
	 */
	private void buttonConnectHandler() {
		if (connected) {
			btnConnect.setText("Connect to Radio");
			connected = false;
		} else {
			btnConnect.setText("Disconnect from Radio");
			connected = true;
		}
		;
	}

	/**
	 * Método que atualiza a informação exibida do DIAL com a frequência ativa no
	 * momento.
	 */
	private void atualizaDisplay() {
		String temp = "" + freq;
		int i = temp.length();
		if (i == 7) {
			String bloco1 = temp.substring(0, 1);
			String bloco2 = temp.substring(1, 4);
			String bloco3 = temp.substring(4);
			String frequencia = bloco1 + "." + bloco2 + "." + bloco3;
			txtDial.setText(frequencia);
		} else {
			String bloco1 = temp.substring(0, 2);
			String bloco2 = temp.substring(2, 5);
			String bloco3 = temp.substring(5);
			String frequencia = bloco1 + "." + bloco2 + "." + bloco3;
			txtDial.setText(frequencia);
		}
	}

	/**
	 * Método que calcula se a frequência pretendida está dentro dos limites
	 * definidos para a banda selecionada. Retorna verdadeiro quando está dentro dos
	 * limites e falso quando está fora dos limites.
	 * 
	 * @return boolean
	 */
	private boolean calculaLimitesDaBanda() {
		if (bandaSelecionada.equals(BANDA_15M)) {
			if (freq >= 21000000 && freq <= 21450000) {
				return true;
			} else {
				return false;
			}
		} else if (bandaSelecionada.equals(BANDA_20M)) {
			if (freq >= 14000000 && freq <= 14350000) {
				return true;
			} else {
				return false;
			}
		} else if (bandaSelecionada.equals(BANDA_40M)) {
			if (freq >= 7000000 && freq <= 7300000) {
				return true;
			} else {
				return false;
			}
		} else if (bandaSelecionada.equals(BANDA_80M)) {
			if (freq >= 3500000 && freq <= 4000000) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
