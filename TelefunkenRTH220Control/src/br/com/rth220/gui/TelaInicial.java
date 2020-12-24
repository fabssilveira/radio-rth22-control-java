package br.com.rth220.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import org.json.JSONObject;

import br.com.rth220.util.HttpUtils;
import java.awt.Color;

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
	private JRadioButton rdbtnUSB;
	private JRadioButton rdbtnLSB;

	private final String BANDA_20M = "20m";
	private final String BANDA_40M = "40m";
	private final String BANDA_80M = "80m";

	private String bandaSelecionada = BANDA_40M;
	private String modo = "LSB";
	private int freq = 7000000;
	private boolean connected = false;
	private JLabel lblHz;

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

		lblHz = new JLabel("Hz");
		lblHz.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHz.setBounds(513, 120, 48, 24);
		contentPane.add(lblHz);

		txtDial = new JTextField();
		txtDial.setForeground(Color.gray);
		txtDial.setHorizontalAlignment(SwingConstants.CENTER);
		txtDial.setFont(new Font("Tahoma", Font.PLAIN, 35));
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
				TelaConfig config = new TelaConfig();
				config.setVisible(true);
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
				try {
					bandaSelecionada = BANDA_80M;
					freq = 3500000;	
					JSONObject response = new JSONObject(HttpUtils.defineFrequencia(freq, bandaSelecionada));
					freq = response.getInt("frequencia");
					modo = response.getString("modo");
					atualizaDisplay();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro de conexão, tente novamente...");
				}
			}
		});
		buttonGroupBands.add(rdbtn80m);
		rdbtn80m.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn80m.setBounds(30, 240, 95, 23);
		contentPane.add(rdbtn80m);

		rdbtn40m = new JRadioButton("40 m");
		rdbtn40m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bandaSelecionada = BANDA_40M;
					freq = 7000000;
					JSONObject response = new JSONObject(HttpUtils.defineFrequencia(freq, bandaSelecionada));
					freq = response.getInt("frequencia");
					modo = response.getString("modo");
					atualizaDisplay();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro de conexão, tente novamente...");
				}
			}
		});
		buttonGroupBands.add(rdbtn40m);
		rdbtn40m.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn40m.setBounds(30, 281, 95, 23);
		contentPane.add(rdbtn40m);

		rdbtn20m = new JRadioButton("20 m");
		rdbtn20m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					bandaSelecionada = BANDA_20M;
					freq = 14000000;
					JSONObject response = new JSONObject(HttpUtils.defineFrequencia(freq, bandaSelecionada));
					freq = response.getInt("frequencia");
					modo = response.getString("modo");
					atualizaDisplay();
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro de conexão, tente novamente...");
				}
			}
		});
		buttonGroupBands.add(rdbtn20m);
		rdbtn20m.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn20m.setBounds(30, 322, 95, 23);
		contentPane.add(rdbtn20m);		

		JLabel lblModes = new JLabel("Modes");
		lblModes.setHorizontalAlignment(SwingConstants.CENTER);
		lblModes.setBounds(571, 191, 95, 16);
		contentPane.add(lblModes);

		rdbtnUSB = new JRadioButton("USB");
		rdbtnUSB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					modo = "USB";
					JSONObject response = new JSONObject(HttpUtils.defineModo(modo));	
					freq = response.getInt("frequencia");
					modo = response.getString("modo");
					atualizaDisplay();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro de conexão, tente novamente...");
				}					
			}
		});
		buttonGroupModes.add(rdbtnUSB);
		rdbtnUSB.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnUSB.setBounds(571, 250, 95, 23);
		contentPane.add(rdbtnUSB);

		rdbtnLSB = new JRadioButton("LSB");
		rdbtnLSB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modo = "LSB";
					JSONObject response = new JSONObject(HttpUtils.defineModo(modo));	
					freq = response.getInt("frequencia");
					modo = response.getString("modo");
					atualizaDisplay();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro de conexão, tente novamente...");
				}			}
		});
		buttonGroupModes.add(rdbtnLSB);
		rdbtnLSB.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnLSB.setBounds(571, 310, 95, 23);
		contentPane.add(rdbtnLSB);		

		btnPlus100 = new JButton("+");
		btnPlus100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					freq = freq + 100;
					if (calculaLimitesDaBanda()) {
						JSONObject response = new JSONObject(HttpUtils.aumentaFrequencia(100));
						freq = response.getInt("frequencia");
						atualizaDisplay();
					} else {
						freq = freq - 100;
					}					
				} catch (Exception e1 ) {
					JOptionPane.showMessageDialog(null, "Erro de conexão, tente novamente...");
				}								
			}
		});
		btnPlus100.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPlus100.setBounds(353, 248, 48, 39);
		contentPane.add(btnPlus100);

		btnMinus100 = new JButton("-");
		btnMinus100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					freq = freq - 100;
					if (calculaLimitesDaBanda()) {
						JSONObject response = new JSONObject(HttpUtils.diminuiFrequencia(100));
						freq = response.getInt("frequencia");
						atualizaDisplay();
					} else {
						freq = freq + 100;
					}					
				} catch (Exception e1 ) {
					JOptionPane.showMessageDialog(null, "Erro de conexão, tente novamente...");
				}	
			}
		});
		btnMinus100.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMinus100.setBounds(295, 248, 48, 39);
		contentPane.add(btnMinus100);

		btnPlus1000 = new JButton("+");
		btnPlus1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					freq = freq + 1000;
					if (calculaLimitesDaBanda()) {
						JSONObject response = new JSONObject(HttpUtils.aumentaFrequencia(1000));
						freq = response.getInt("frequencia");
						atualizaDisplay();
					} else {
						freq = freq - 1000;
					}					
				} catch (Exception e1 ) {
					JOptionPane.showMessageDialog(null, "Erro de conexão, tente novamente...");
				}	
			}
		});
		btnPlus1000.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPlus1000.setBounds(411, 242, 53, 52);
		contentPane.add(btnPlus1000);

		btnMinus1000 = new JButton("-");
		btnMinus1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					freq = freq - 1000;
					if (calculaLimitesDaBanda()) {
						JSONObject response = new JSONObject(HttpUtils.diminuiFrequencia(1000));
						freq = response.getInt("frequencia");
						atualizaDisplay();
					} else {
						freq = freq + 1000;
					}					
				} catch (Exception e1 ) {
					JOptionPane.showMessageDialog(null, "Erro de conexão, tente novamente...");
				}	
			}
		});
		btnMinus1000.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus1000.setBounds(232, 242, 53, 52);
		contentPane.add(btnMinus1000);

		btnPlus10000 = new JButton("+");
		btnPlus10000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					freq = freq + 10000;
					if (calculaLimitesDaBanda()) {
						JSONObject response = new JSONObject(HttpUtils.aumentaFrequencia(10000));
						freq = response.getInt("frequencia");
						atualizaDisplay();
					} else {
						freq = freq - 10000;
					}					
				} catch (Exception e1 ) {
					JOptionPane.showMessageDialog(null, "Erro de conexão, tente novamente...");
				}	
			}
		});
		btnPlus10000.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPlus10000.setBounds(474, 234, 67, 67);
		contentPane.add(btnPlus10000);

		btnMinus10000 = new JButton("-");
		btnMinus10000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					freq = freq - 10000;
					if (calculaLimitesDaBanda()) {
						JSONObject response = new JSONObject(HttpUtils.diminuiFrequencia(10000));
						freq = response.getInt("frequencia");
						atualizaDisplay();
					} else {
						freq = freq + 10000;
					}					
				} catch (Exception e1 ) {
					JOptionPane.showMessageDialog(null, "Erro de conexão, tente novamente...");
				}	
			}
		});
		btnMinus10000.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMinus10000.setBounds(155, 234, 67, 67);
		contentPane.add(btnMinus10000);
		
		initScreem();
	}

	//Métodos funcionais da classe
	//***************************************************************************
	
	private void initScreem() {		
		atualizaDisplay();
		disableButtons();
	};
	
	private void enableButtons() {
		btnMinus100.setEnabled(true);
		btnMinus1000.setEnabled(true);
		btnMinus10000.setEnabled(true);
		btnPlus100.setEnabled(true);
		btnPlus1000.setEnabled(true);
		btnPlus10000.setEnabled(true);
		rdbtn20m.setEnabled(true);
		rdbtn40m.setEnabled(true);
		rdbtn80m.setEnabled(true);
		rdbtnLSB.setEnabled(true);
		rdbtnUSB.setEnabled(true);
	};
	
	private void disableButtons() {
		btnMinus100.setEnabled(false);
		btnMinus1000.setEnabled(false);
		btnMinus10000.setEnabled(false);
		btnPlus100.setEnabled(false);
		btnPlus1000.setEnabled(false);
		btnPlus10000.setEnabled(false);
		rdbtn20m.setEnabled(false);
		rdbtn40m.setEnabled(false);
		rdbtn80m.setEnabled(false);
		rdbtnLSB.setEnabled(false);
		rdbtnUSB.setEnabled(false);
	};
	
	/**
	 * Método que lida com o botão de conexão ao rádio.
	 */
	private void buttonConnectHandler() {
		if (connected) {
			btnConnect.setText("Connect to Radio");
			connected = false;
			txtDial.setForeground(Color.gray);
			disableButtons();
		} else {
			btnConnect.setText("Disconnect from Radio");
			connected = true;
			txtDial.setForeground(Color.black);
			enableButtons();
			try {
				JSONObject response = new JSONObject(HttpUtils.identificaBanda());
				bandaSelecionada = response.getString("banda");
				if (bandaSelecionada.equals(BANDA_20M)) {
					rdbtn20m.doClick();
				}
				if (bandaSelecionada.equals(BANDA_40M)) {
					rdbtn40m.doClick();
				}
				if (bandaSelecionada.equals(BANDA_80M)) {
					rdbtn80m.doClick();
				}
				atualizaDisplay();
			} catch (Exception e1) {					
				JOptionPane.showMessageDialog(null, "Erro de conexão, tente novamente...");
			}
		}		
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
		if (bandaSelecionada.equals(BANDA_20M)) {
			rdbtn20m.setSelected(true);
		}
		if (bandaSelecionada.equals(BANDA_40M)) {
			rdbtn40m.setSelected(true);
		}
		if (bandaSelecionada.equals(BANDA_80M)) {
			rdbtn80m.setSelected(true);
		}
		if (modo.equals("USB")) {			
			rdbtnUSB.setSelected(true);
		}
		if (modo.equals("LSB")){			
			rdbtnLSB.setSelected(true);
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
		if (bandaSelecionada.equals(BANDA_20M)) {
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
