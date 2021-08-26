package com.Nowek.Mazurczak.Ozga.Klient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.GrupaDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.KlientLogin;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.NauczycielDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.OcenaDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.PosDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.PrzedmiotDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.StudentDane;
import com.Nowek.Mazurczak.Ozga.ServerConnector.ServerConnector;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JProgressBar;
import javax.swing.JEditorPane;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea; 


public class Okno {
	private static final Logger logger=Logger.getLogger(Okno.class);
	private OcenaDane ocena=new OcenaDane();
	private StudentDane loggedStudent;
	private PosDane pos= new PosDane();
	private NauczycielDane loggedNauczyciel;
	private JFrame frmElektroniczySystemOceniania;
	private JTextField loglog;
	private JPasswordField logpas;
	private JTable table;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_8;
	private JTextField textField_9;
	private JPasswordField passwordField_3;
	private JPasswordField passwordField_4;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTextField textField;
	/**
	 * @wbp.nonvisual location=142,559
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table_6;
	private JTable table_7;
	private JTable table_8;
	private JTable table_1;
	private JTable table_9;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_10;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Okno window = new Okno();
					window.frmElektroniczySystemOceniania.setVisible(true);
				} catch (Exception e) {
					logger.error("ERROR",e);
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Okno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	private void initialize() {
		
		try {
			ServerConnector.initialize();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			logger.error("ERROR",e1);
		}
		frmElektroniczySystemOceniania = new JFrame();
		frmElektroniczySystemOceniania.setTitle("Elektroniczny system oceniania");
		frmElektroniczySystemOceniania.setBounds(100, 100, 1300, 800);
		frmElektroniczySystemOceniania.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        	logger.error("ERROR",e);
        }
		
	
		CardLayout layout = new CardLayout();
		JPanel panel = new JPanel();
		frmElektroniczySystemOceniania.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(layout);
		
		JPanel logowanie = new JPanel();
		logowanie.setBackground(Color.WHITE);
		panel.add(logowanie, "logowanie");
		logowanie.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Logowanie do systemu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(500, 20, 253, 142);
		logowanie.add(lblNewLabel);
		
		loglog = new JTextField();
		loglog.setFont(new Font("Tahoma", Font.PLAIN, 25));
		loglog.setBounds(730, 173, 175, 75);
		logowanie.add(loglog);
		loglog.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(420, 178, 69, 75);
		logowanie.add(lblNewLabel_1);
		
		logpas = new JPasswordField();
		logpas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		logpas.setBounds(730, 337, 175, 75);
		logowanie.add(logpas);
		
		JRadioButton AdminButton = new JRadioButton("Admin");
		AdminButton.setBounds(380, 451, 109, 23);
		logowanie.add(AdminButton);
		
		JRadioButton StudentButton = new JRadioButton("Student");
		StudentButton.setBounds(576, 451, 109, 23);
		logowanie.add(StudentButton);
		
		JRadioButton NauczycielButton = new JRadioButton("Nauczyciel");
		NauczycielButton.setBounds(758, 451, 109, 23);
		logowanie.add(NauczycielButton);
		
		JLabel lblNewLabel_2 = new JLabel("Haslo:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(420, 337, 81, 75);
		logowanie.add(lblNewLabel_2);
		
		JPanel student = new JPanel();
		panel.add(student, "student");
		student.setLayout(null);
		
		JLabel simie = new JLabel("New label");
		simie.setBounds(189, 46, 123, 14);
		student.add(simie);
		
		JLabel snazwisko = new JLabel("New label");
		snazwisko.setBounds(189, 128, 123, 14);
		student.add(snazwisko);
		
		JLabel sgrupa = new JLabel("New label");
		sgrupa.setBounds(189, 210, 46, 14);
		student.add(sgrupa);
		
		JLabel sindeks = new JLabel("New label");
		sindeks.setBounds(189, 278, 46, 14);
		student.add(sindeks);
		
		JButton btnNewButton = new JButton("Zaloguj");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String log=loglog.getText();
				String pass=String.valueOf(logpas.getPassword());
				
				if(AdminButton.isSelected())
				{
					if(log.equals("admin") && pass.equals("admin"))
					{
						layout.show(panel, "admin1");
					}	
					else
					{
						JOptionPane.showMessageDialog(panel, "Bledne dane logowania");
					}
				}
				else if(StudentButton.isSelected())
				{
					KlientLogin klt=new KlientLogin(log,pass);
					klt.setStudent(true);
					loggedStudent=ServerConnector.getStudentLog(klt);
					if(loggedStudent!=null)
					{
						JOptionPane.showMessageDialog(panel, "Pomyslnie zalogowano");
						simie.setText(loggedStudent.getImie());
						snazwisko.setText(loggedStudent.getNazwisko());
						sgrupa.setText(String.valueOf(loggedStudent.getIdGrupa()));
						sindeks.setText(String.valueOf(loggedStudent.getIdStudent()));
						
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						for(int j=table.getRowCount()-1; j>=0; j--)
							model.removeRow(j);
						
						StudentDane stud=new StudentDane();
						stud.setIdStudent(loggedStudent.getIdStudent());
						stud.setOperacja(4);
						
						List<OcenaDane> list=ServerConnector.getOcenaStudentList(stud);
						int i=0;
						for(OcenaDane a:list)
						{
							model.insertRow(i++,new Object[] {a.getIdOcena(),a.getOcena(),a.getWaga(),a.getNazwisko(),a.getImie(),a.getNazwa(),a.getTyp()});
						}
						
						
						layout.show(panel, "student");
						
					}
					else
					{
						JOptionPane.showMessageDialog(panel, "Nie ma studenta o podanych danych logowania");
					}
				}
				else if(NauczycielButton.isSelected())
				{
					KlientLogin klt=new KlientLogin(log,pass);
					klt.setStudent(false);
					loggedNauczyciel=ServerConnector.getNauczycielLog(klt);
					if(loggedNauczyciel!=null)
					{
						JOptionPane.showMessageDialog(panel, "Pomyslnie zalogowano");
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						for(int j=table_1.getRowCount()-1; j>=0; j--)
							model.removeRow(j);
						StudentDane naucz=new StudentDane();
						naucz.setOperacja(3);
						List<StudentDane> list=ServerConnector.getStudentList(naucz);
						int i=0;
						for(StudentDane a:list)
						{
							model.insertRow(i++,new Object[] {a.getIdStudent(),a.getImie(),a.getNazwisko(),a.getIdGrupa()});
						}
						
						PosDane pos1=new PosDane();
						model = (DefaultTableModel) table_9.getModel();
						for(int j=table_9.getRowCount()-1; j>=0; j--)
							model.removeRow(j);
						pos1.setOperacja(4);
						pos1.setIdNauczyciel(loggedNauczyciel.getIdNauczyciel());
						List<PosDane> lista=ServerConnector.getPosList(pos1);
						i=0;
						for(PosDane a:lista)
						{
							model.insertRow(i++,new Object[] {a.getIdPos(),a.getNazwa(),a.getTyp()});
						}
					
						
						layout.show(panel, "nauczyciel");
					}
					else
					{
						JOptionPane.showMessageDialog(panel, "Nie ma nauczyciela o podanych danych logowania");
					}
				}

				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(547, 506, 250, 75);
		logowanie.add(btnNewButton);
		
		
		JPanel admin1 = new JPanel();
		panel.add(admin1, "admin1");
		admin1.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1284, 761);
		admin1.add(tabbedPane);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setToolTipText("");
		tabbedPane.addTab("Podstawowe dodawanie i usuwanie", null, layeredPane_1, null);
		
		JButton btnNewButton_1 = new JButton("Dodaj Nauczyciela");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "dodnaucz");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBounds(221, 100, 260, 75);
		layeredPane_1.add(btnNewButton_1);
		
		JPanel usnaucz = new JPanel();
		panel.add(usnaucz, "usnaucz");
		usnaucz.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(28, 32, 452, 402);
		usnaucz.add(scrollPane_2);
		
		JButton btnNewButton_22 = new JButton("Usun");
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table_2.getSelectedRow()!=-1)
				{
					NauczycielDane naucz=new NauczycielDane();
					naucz.setIdNauczyciel((Integer)table_2.getValueAt(table_2.getSelectedRow(), 0));
					naucz.setOperacja(2);
					if(ServerConnector.sendNauczyciel(naucz))
					{
						JOptionPane.showMessageDialog(panel, "Pomyslnie usunieto nauczyciela");
						DefaultTableModel model = (DefaultTableModel) table_2.getModel();
						for(int j=table_2.getRowCount()-1; j>=0; j--)
							model.removeRow(j);
						naucz=new NauczycielDane();
						naucz.setOperacja(3);
						List<NauczycielDane> list=ServerConnector.getNauczycielList(naucz);
						int i=0;
						for(NauczycielDane a:list)
						{
							model.insertRow(i++,new Object[] {a.getIdNauczyciel(),a.getImie(),a.getNazwisko(),a.getStopien(),a.getLogin(),a.getHaslo()});
						}
					}
					else
					{
						JOptionPane.showMessageDialog(panel, "Nie udalo sie usunac");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(panel, "Nalezy zaznaczyc wiersz w tabeli");
				}
				
			}
		});
		btnNewButton_22.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_22.setBounds(616, 261, 200, 75);
		usnaucz.add(btnNewButton_22);
		
		JButton btnNewButton_23 = new JButton("Wroc");
		btnNewButton_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "admin1");
			}
		});
		btnNewButton_23.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_23.setBounds(1081, 663, 170, 75);
		usnaucz.add(btnNewButton_23);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IDnauczyciel", "Imie", "Nazwisko", "Stopien", "Login", "Haslo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_2.setViewportView(table_2);
		
		
		JButton btnNewButton_2 = new JButton("Usun Nauczyciela");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_2.getModel();
				for(int j=table_2.getRowCount()-1; j>=0; j--)
					model.removeRow(j);
				NauczycielDane naucz=new NauczycielDane();
				naucz.setOperacja(3);
				List<NauczycielDane> list=ServerConnector.getNauczycielList(naucz);
				int i=0;
				for(NauczycielDane a:list)
				{
					model.insertRow(i++,new Object[] {a.getIdNauczyciel(),a.getImie(),a.getNazwisko(),a.getStopien(),a.getLogin(),a.getHaslo()});
				}
				layout.show(panel, "usnaucz");
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_2.setBounds(754, 100, 255, 75);
		layeredPane_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Wyloguj");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "logowanie");
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_3.setBounds(1036, 629, 198, 75);
		layeredPane_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Dodaj studenta");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "dodstud");
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_4.setBounds(221, 217, 260, 75);
		layeredPane_1.add(btnNewButton_4);
		
		JPanel usstud = new JPanel();
		panel.add(usstud, "usstud");
		usstud.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(21, 24, 452, 402);
		usstud.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idStudent", "Imie", "Nazwisko", "PESEL", "idGrupa", "Login", "Haslo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_3.setViewportView(table_3);
		
		JButton btnNewButton_5 = new JButton("Usun studenta");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_3.getModel();
				for(int j=table_3.getRowCount()-1; j>=0; j--)
					model.removeRow(j);
				StudentDane naucz=new StudentDane();
				naucz.setOperacja(3);
				List<StudentDane> list=ServerConnector.getStudentList(naucz);
				int i=0;
				for(StudentDane a:list)
				{
					model.insertRow(i++,new Object[] {a.getIdStudent(),a.getImie(),a.getNazwisko(),a.getPesel(),a.getIdGrupa(),a.getLogin(),a.getHaslo()});
				}
				layout.show(panel, "usstud");
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_5.setBounds(754, 217, 260, 75);
		layeredPane_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Dodaj przedmiot");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "dodprzed");
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_6.setBounds(221, 335, 260, 75);
		layeredPane_1.add(btnNewButton_6);
		
		JPanel usprzed = new JPanel();
		panel.add(usprzed, "usprzed");
		usprzed.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(22, 22, 452, 402);
		usprzed.add(scrollPane_5);
		
		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idPrzedmiot", "Nazwa", "Typ"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_5.setViewportView(table_5);
		
		JButton btnNewButton_7 = new JButton("Usun przedmiot");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_5.getModel();
				for(int j=table_5.getRowCount()-1; j>=0; j--)
					model.removeRow(j);
				PrzedmiotDane przed=new PrzedmiotDane();
				przed.setOperacja(3);
				List<PrzedmiotDane> list=ServerConnector.getPrzedmiotList(przed);
				int i=0;
				for(PrzedmiotDane a:list)
				{
					model.insertRow(i++,new Object[] {a.getIdPrzedmiot(),a.getNazwa(),a.getTyp()});
				}
				
				
				layout.show(panel, "usprzed");
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_7.setBounds(754, 335, 260, 75);
		layeredPane_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Dodaj grupe");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "dodgrup");
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_8.setBounds(221, 448, 260, 75);
		layeredPane_1.add(btnNewButton_8);
		
		JPanel usgrup = new JPanel();
		panel.add(usgrup, "usgrup");
		usgrup.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(20, 24, 452, 402);
		usgrup.add(scrollPane_4);
		
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idGrupa", "Nazwa_grupy"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_4.setViewportView(table_4);
		
		JButton btnNewButton_9 = new JButton("Usun grupe");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_4.getModel();
				for(int j=table_4.getRowCount()-1; j>=0; j--)
					model.removeRow(j);
				GrupaDane grup=new GrupaDane();
				grup.setOperacja(3);
				List<GrupaDane> list=ServerConnector.getGrupaList(grup);
				int i=0;
				for(GrupaDane a:list)
				{
					model.insertRow(i++,new Object[] {a.getIdGrupa(),a.getNazwa_grupy()});
				}
				layout.show(panel, "usgrup");
			}
		});
		btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_9.setBounds(754, 455, 260, 75);
		layeredPane_1.add(btnNewButton_9);
		
		JLabel lblNewLabel_3 = new JLabel("Panel Dodawania i Usuwania");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(450, 11, 338, 75);
		layeredPane_1.add(lblNewLabel_3);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Zaawansowane ustawienia", null, layeredPane, null);
		
		JButton btnNewButton_34 = new JButton("Dodaj");
		btnNewButton_34.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//wstawianie nauczyciela
				DefaultTableModel model = (DefaultTableModel) table_7.getModel();
				for(int j=table_7.getRowCount()-1; j>=0; j--)
					model.removeRow(j);
				NauczycielDane naucz=new NauczycielDane();
				naucz.setOperacja(3);
				List<NauczycielDane> list=ServerConnector.getNauczycielList(naucz);
				int i=0;
				for(NauczycielDane a:list)
				{
					model.insertRow(i++,new Object[] {a.getIdNauczyciel(),a.getImie(),a.getNazwisko(),a.getStopien(),a.getLogin(),a.getHaslo()});
				}
				//wstawianie przedmiotu
				model = (DefaultTableModel) table_6.getModel();
				for(int j=table_6.getRowCount()-1; j>=0; j--)
					model.removeRow(j);
				PrzedmiotDane przed=new PrzedmiotDane();
				przed.setOperacja(3);
				List<PrzedmiotDane> lista=ServerConnector.getPrzedmiotList(przed);
				i=0;
				for(PrzedmiotDane a:lista)
				{
					model.insertRow(i++,new Object[] {a.getIdPrzedmiot(),a.getNazwa(),a.getTyp()});
				}
				layout.show(panel,"dodpos");
			}
		});
		btnNewButton_34.setBounds(254, 315, 159, 77);
		layeredPane.add(btnNewButton_34);
		
		JButton btnNewButton_35 = new JButton("Usun");
		btnNewButton_35.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_8.getModel();
				for(int j=table_8.getRowCount()-1; j>=0; j--)
					model.removeRow(j);
				PosDane poss=new PosDane();
				poss.setOperacja(3);
				List<PosDane> list=ServerConnector.getPosList(poss);
				int i=0;
				for(PosDane a:list)
				{
					model.insertRow(i++,new Object[] {a.getIdPos(),a.getIdNauczyciel(),a.getIdPrzedmiot(),a.getImie(),a.getNazwisko(),a.getNazwa(),a.getTyp()});
				}
			
				layout.show(panel, "uspos");
			}
		});
		btnNewButton_35.setBounds(890, 311, 159, 84);
		layeredPane.add(btnNewButton_35);
		
		JLabel lblNewLabel_31 = new JLabel("Polacz nauczyciela z przedmiotem");
		lblNewLabel_31.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_31.setBounds(414, 41, 383, 52);
		layeredPane.add(lblNewLabel_31);
		
		
		
		JLabel lblNewLabel_14 = new JLabel("Imie:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_14.setBounds(28, 29, 76, 37);
		student.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Nazwisko:");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_15.setBounds(28, 105, 112, 48);
		student.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Grupa:");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_16.setBounds(25, 182, 79, 59);
		student.add(lblNewLabel_16);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(432, 87, 795, 569);
		student.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idOcena", "Ocena", "Waga", "Nazwisko", "Imie", "Nazwa", "Typ"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Float.class, Integer.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JLabel lblNewLabel_20 = new JLabel("Oceny:");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_20.setBounds(432, 17, 133, 49);
		student.add(lblNewLabel_20);
		
		JLabel lblNewLabel_39 = new JLabel("");
		lblNewLabel_39.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_39.setBounds(189, 372, 79, 37);
		student.add(lblNewLabel_39);
		
		JButton btnNewButton_12 = new JButton("Wyloguj");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_39.setText("");
				layout.show(panel, "logowanie");
			}
		});
		btnNewButton_12.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_12.setBounds(96, 628, 149, 70);
		student.add(btnNewButton_12);
		
		JLabel lblNewLabel_44 = new JLabel("Indeks:");
		lblNewLabel_44.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_44.setBounds(28, 264, 94, 31);
		student.add(lblNewLabel_44);
		
		
		JButton btnNewButton_41 = new JButton("Policz");
		btnNewButton_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			StudentDane stud=new StudentDane();
			stud.setIdStudent(loggedStudent.getIdStudent());
			stud.setOperacja(4);
			List<OcenaDane> list=ServerConnector.getOcenaStudentList(stud);
			
			float suma=0, wagi=0;
			
			for(OcenaDane a:list)
			{
				suma+=(a.getOcena()*a.getWaga());
				wagi+=a.getWaga();				
			}
			if(wagi!=0)
			{
				lblNewLabel_39.setText(Float.toString(suma/wagi));
			}
			else
			{
				lblNewLabel_39.setText("0");
			}
			
			}
		});
		btnNewButton_41.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_41.setBounds(96, 513, 149, 70);
		student.add(btnNewButton_41);
		
		JLabel lblNewLabel_38 = new JLabel("Srednia:");
		lblNewLabel_38.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_38.setBounds(28, 372, 94, 31);
		student.add(lblNewLabel_38);
		
		JPanel naucz = new JPanel();
		panel.add(naucz, "nauczyciel");
		naucz.setLayout(null);
		
		JButton btnNewButton_11 = new JButton("Wyloguj");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_5.setText("");
				textField_4.setText("");
				layout.show(panel, "logowanie");
			}
		});
		btnNewButton_11.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_11.setBounds(970, 618, 151, 69);
		naucz.add(btnNewButton_11);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(92, 55, 468, 361);
		naucz.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idStudent", "Imie", "Nazwisko", "Grupa"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(673, 53, 483, 361);
		naucz.add(scrollPane_9);
		
		table_9 = new JTable();
		table_9.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Nazwa", "Typ"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_9.setViewportView(table_9);
		
		JLabel lblNewLabel_42 = new JLabel("Wczytaj dane");
		lblNewLabel_42.setBounds(209, 439, 111, 14);
		naucz.add(lblNewLabel_42);
		
		JLabel lblNewLabel_43 = new JLabel("Wczytaj dane");
		lblNewLabel_43.setBounds(209, 498, 111, 14);
		naucz.add(lblNewLabel_43);
		
		
		JButton btnNewButton_13 = new JButton("Wczytaj");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_1.getSelectedRow()!=-1 && table_9.getSelectedRow()!=-1)
				{
					lblNewLabel_42.setText(Integer.toString((Integer)table_1.getValueAt(table_1.getSelectedRow(), 0)));
					ocena.setIdStudent((Integer)table_1.getValueAt(table_1.getSelectedRow(), 0));
					
					
					lblNewLabel_43.setText((String)table_9.getValueAt(table_9.getSelectedRow(), 1));
					ocena.setIdPos((Integer)table_9.getValueAt(table_9.getSelectedRow(), 0));
					
				}
				else
				{
					JOptionPane.showMessageDialog(panel, "Musisz zaznaczyæ wiersze w obu tabelach");
				}
			}
		});
		btnNewButton_13.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_13.setBounds(543, 450, 161, 62);
		naucz.add(btnNewButton_13);
		
		
		JLabel lblNewLabel_24 = new JLabel("Waga:");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_24.setBounds(37, 548, 104, 50);
		naucz.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("Ocena:");
		lblNewLabel_25.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_25.setBounds(37, 632, 111, 40);
		naucz.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("Id studenta:");
		lblNewLabel_26.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_26.setBounds(33, 427, 135, 40);
		naucz.add(lblNewLabel_26);
		
		JLabel lblNewLabel_37 = new JLabel("Przedmiot");
		lblNewLabel_37.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_37.setBounds(37, 478, 111, 51);
		naucz.add(lblNewLabel_37);
		
		textField_4 = new JTextField();
		textField_4.setBounds(197, 632, 86, 50);
		naucz.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(197, 548, 86, 50);
		naucz.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_39 = new JButton("Dodaj");
		btnNewButton_39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isCorrect=true;
				ocena.setOperacja(1);
				
				if(textField_5.getText().equals(""))
				{
					isCorrect=false;
					
				}
				else {
					ocena.setWaga(Integer.parseInt(String.valueOf(textField_5.getText())));
				}
				if(textField_4.getText().equals(""))
				{
					isCorrect=false;
					
				}
				else {
					ocena.setOcena(Float.parseFloat(String.valueOf(textField_4.getText())));
				}
				if(isCorrect) {
					if(ServerConnector.sendOcena(ocena))
					{
						JOptionPane.showMessageDialog(panel, "Udalo sie dodac ocene");
					}
					else
					{
						JOptionPane.showMessageDialog(panel, "Nie udalo sie dodac oceny");
					}
				}
				else {
					JOptionPane.showMessageDialog(panel, "Nalezy uzupelnic oba pola ");
				}
				ocena=new OcenaDane();
				textField_5.setText("");
				textField_4.setText("");
			}
		});
		btnNewButton_39.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_39.setBounds(543, 615, 161, 69);
		naucz.add(btnNewButton_39);
		
		JButton btnNewButton_36 = new JButton("Wyswietl Oceny");
		btnNewButton_36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_10.getModel();
				for(int j=table_10.getRowCount()-1; j>=0; j--)
					model.removeRow(j);
				NauczycielDane nauczz=new NauczycielDane();
				nauczz.setOperacja(4);
				nauczz.setIdNauczyciel(loggedNauczyciel.getIdNauczyciel());
				
				List<OcenaDane> list=ServerConnector.getOcenaNauczycielList(nauczz);
				int i=0;
				for(OcenaDane a:list)
				{
					model.insertRow(i++,new Object[] {a.getIdOcena(),a.getOcena(),a.getWaga(),a.getNazwisko(),a.getImie(),a.getNazwa(),a.getTyp()});
				}
				
				layout.show(panel, "nauczyciel2");
			}
		});
		btnNewButton_36.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_36.setBounds(936, 450, 284, 62);
		naucz.add(btnNewButton_36);
		
		JPanel dodnaucz = new JPanel();
		panel.add(dodnaucz, "dodnaucz");
		dodnaucz.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Dodaj nauczyciela");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(550, 50, 199, 75);
		dodnaucz.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Login:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(275, 150, 69, 75);
		dodnaucz.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Haslo:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(275, 236, 79, 75);
		dodnaucz.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Powtorz haslo:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(275, 322, 164, 75);
		dodnaucz.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Imie:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(275, 408, 58, 75);
		dodnaucz.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Nazwisko:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_9.setBounds(275, 494, 112, 75);
		dodnaucz.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Stopien:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_10.setBounds(275, 580, 92, 75);
		dodnaucz.add(lblNewLabel_10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setBounds(697, 156, 300, 75);
		dodnaucz.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField_1.setBounds(697, 236, 300, 75);
		dodnaucz.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField_2.setBounds(697, 322, 300, 75);
		dodnaucz.add(passwordField_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_2.setBounds(697, 408, 300, 75);
		dodnaucz.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_3.setBounds(697, 494, 300, 75);
		dodnaucz.add(textField_3);
		textField_3.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_8.setBounds(697, 580, 300, 75);
		dodnaucz.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton_14 = new JButton("Wroc");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "admin1");
			}
		});
		btnNewButton_14.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_14.setBounds(275, 666, 170, 75);
		dodnaucz.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Dodaj");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(String.valueOf(passwordField_1.getPassword()).equals(String.valueOf(passwordField_2.getPassword())))
				{
					NauczycielDane dan=new NauczycielDane();
					dan.setLogin(textField_1.getText());
					dan.setHaslo(String.valueOf(passwordField_1.getPassword()));
					dan.setImie(textField_2.getText());
					dan.setNazwisko(textField_3.getText());
					dan.setStopien(textField_8.getText());
					dan.setOperacja(1);
					if(ServerConnector.sendNauczyciel(dan))
					{
						JOptionPane.showMessageDialog(panel, "Pomyslnie dodano nauczyciela");
					}
					else
					{
						JOptionPane.showMessageDialog(panel, "Cos poszlo nie tak");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(panel, "Hasla sie nie zgadzaja");
				}
				
			}
		});
		btnNewButton_15.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_15.setBounds(769, 675, 170, 75);
		dodnaucz.add(btnNewButton_15);
		
		JPanel dodstud = new JPanel();
		panel.add(dodstud, "dodstud");
		dodstud.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Dodaj studenta");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_11.setBounds(550, 30, 168, 75);
		dodstud.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Login:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_12.setBounds(275, 100, 69, 75);
		dodstud.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Haslo:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_13.setBounds(275, 186, 80, 75);
		dodstud.add(lblNewLabel_13);
		
		JLabel lblNewLabel_27 = new JLabel("Powtorz haslo:");
		lblNewLabel_27.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_27.setBounds(273, 272, 164, 75);
		dodstud.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("Imie:");
		lblNewLabel_28.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_28.setBounds(275, 358, 74, 75);
		dodstud.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("Nazwisko:");
		lblNewLabel_29.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_29.setBounds(275, 444, 112, 75);
		dodstud.add(lblNewLabel_29);
		
		JLabel lblNewLabel_30 = new JLabel("Pesel:");
		lblNewLabel_30.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_30.setBounds(274, 530, 81, 75);
		dodstud.add(lblNewLabel_30);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_9.setBounds(700, 109, 300, 57);
		dodstud.add(textField_9);
		textField_9.setColumns(10);
		
		passwordField_3 = new JPasswordField();
		passwordField_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField_3.setBounds(700, 195, 300, 57);
		dodstud.add(passwordField_3);
		
		passwordField_4 = new JPasswordField();
		passwordField_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField_4.setBounds(700, 281, 300, 57);
		dodstud.add(passwordField_4);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_10.setBounds(700, 364, 300, 57);
		dodstud.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_11.setBounds(700, 453, 300, 57);
		dodstud.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_12.setBounds(700, 539, 300, 57);
		dodstud.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnNewButton_16 = new JButton("Dodaj");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(String.valueOf(passwordField_3.getPassword()).equals(String.valueOf(passwordField_4.getPassword())))
				{
					StudentDane stud=new StudentDane();
					stud.setLogin(textField_9.getText());
					stud.setHaslo(String.valueOf(passwordField_3.getPassword()));
					stud.setImie(textField_10.getText());
					stud.setNazwisko(textField_11.getText());
					stud.setPesel(textField_12.getText());
					if(textField.getText().equals(new String(""))==true){
					
						stud.setIdGrupa(0);
					}
					else
					{
						stud.setIdGrupa(Integer.parseInt(textField.getText()));
					}
					stud.setOperacja(1);
					if(ServerConnector.sendStudent(stud))
					{
						JOptionPane.showMessageDialog(panel, "Pomyslnie dodano Studenta");
					}
					else
					{
						JOptionPane.showMessageDialog(panel, "Cos poszlo nie tak");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(panel, "Hasla sie nie zgadzaja");
				}
			}
		});
		btnNewButton_16.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_16.setBounds(775, 686, 170, 70);
		dodstud.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("Wroc");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "admin1");
			}
		});
		btnNewButton_17.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_17.setBounds(275, 686, 170, 70);
		dodstud.add(btnNewButton_17);
		
		JLabel lblNewLabel_21 = new JLabel("Grupa:");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_21.setBounds(275, 630, 126, 36);
		dodstud.add(lblNewLabel_21);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(700, 618, 300, 57);
		dodstud.add(textField);
		textField.setColumns(10);
		
		JPanel dodprzed = new JPanel();
		panel.add(dodprzed, "dodprzed");
		dodprzed.setLayout(null);
		
		JLabel lblNewLabel_32 = new JLabel("Dodaj przedmiot");
		lblNewLabel_32.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_32.setBounds(550, 30, 188, 75);
		dodprzed.add(lblNewLabel_32);
		
		JLabel lblNewLabel_33 = new JLabel("Nazwa:");
		lblNewLabel_33.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_33.setBounds(275, 156, 93, 75);
		dodprzed.add(lblNewLabel_33);
		
		JLabel lblNewLabel_34 = new JLabel("Typ:");
		lblNewLabel_34.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_34.setBounds(275, 268, 59, 75);
		dodprzed.add(lblNewLabel_34);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_13.setBounds(700, 156, 300, 75);
		dodprzed.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_14.setBounds(700, 274, 300, 75);
		dodprzed.add(textField_14);
		textField_14.setColumns(10);
		
		JButton btnNewButton_18 = new JButton("Dodaj");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrzedmiotDane przed=new PrzedmiotDane();
				przed.setNazwa(textField_13.getText());
				przed.setTyp(textField_14.getText());
				przed.setOperacja(1);
				if(ServerConnector.sendPrzedmiot(przed))
				{
					JOptionPane.showMessageDialog(panel, "Pomyslnie dodano przedmiot");
				}
				else
				{
					JOptionPane.showMessageDialog(panel, "Cos poszlo nie tak");
				}
			}
		});
		btnNewButton_18.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_18.setBounds(1081, 675, 170, 75);
		dodprzed.add(btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("Wroc");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "admin1");
			}
		});
		btnNewButton_19.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_19.setBounds(275, 675, 170, 75);
		dodprzed.add(btnNewButton_19);
		
		JPanel dodgrup = new JPanel();
		panel.add(dodgrup, "dodgrup");
		dodgrup.setLayout(null);
		
		JLabel lblNewLabel_35 = new JLabel("Dodaj grupe");
		lblNewLabel_35.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_35.setBounds(550, 30, 144, 75);
		dodgrup.add(lblNewLabel_35);
		
		JLabel lblNewLabel_36 = new JLabel("Nazwa grupy:");
		lblNewLabel_36.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_36.setBounds(275, 216, 163, 75);
		dodgrup.add(lblNewLabel_36);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_15.setBounds(700, 216, 300, 75);
		dodgrup.add(textField_15);
		textField_15.setColumns(10);
		
		JButton btnNewButton_20 = new JButton("Dodaj");
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GrupaDane grup=new GrupaDane();
				grup.setNazwa_grupy(textField_15.getText());
				grup.setOperacja(1);
				if(ServerConnector.sendGrupa(grup))
				{
					JOptionPane.showMessageDialog(panel, "Pomyslnie dodano grupe");
				}
				else
				{
					JOptionPane.showMessageDialog(panel, "Cos poszlo nie tak");
				}
				
			}
		});
		btnNewButton_20.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_20.setBounds(1088, 675, 170, 75);
		dodgrup.add(btnNewButton_20);
		
		JButton btnNewButton_21 = new JButton("Wroc");
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "admin1");
			}
		});
		btnNewButton_21.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_21.setBounds(275, 675, 170, 75);
		dodgrup.add(btnNewButton_21);
		
		JButton btnNewButton_24 = new JButton("Usun");
		btnNewButton_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table_3.getSelectedRow()!=-1)
				{
					StudentDane stud=new StudentDane();
					stud.setIdStudent((Integer)table_3.getValueAt(table_3.getSelectedRow(), 0));
					stud.setOperacja(2);
					if(ServerConnector.sendStudent(stud))
					{
						JOptionPane.showMessageDialog(panel, "Pomyslnie usunieto studenta");
						DefaultTableModel model = (DefaultTableModel) table_3.getModel();
						for(int j=table_3.getRowCount()-1; j>=0; j--)
							model.removeRow(j);
						stud=new StudentDane();
						stud.setOperacja(3);
						List<StudentDane> list=ServerConnector.getStudentList(stud);
						int i=0;
						for(StudentDane a:list)
						{
							model.insertRow(i++,new Object[] {a.getIdStudent(),a.getImie(),a.getNazwisko(),a.getPesel(),a.getIdGrupa(),a.getLogin(),a.getHaslo()});
						}
					}
					else
					{
						JOptionPane.showMessageDialog(panel, "Cos poszlo nie tak");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(panel, "Nale¿y zaznaczyc wiersz w tabeli");
				}
				
			}
		});
		btnNewButton_24.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_24.setBounds(596, 231, 200, 75);
		usstud.add(btnNewButton_24);
		
		JButton btnNewButton_25 = new JButton("Wroc");
		btnNewButton_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "admin1");
			}
		});
		btnNewButton_25.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_25.setBounds(1092, 660, 170, 75);
		usstud.add(btnNewButton_25);
		
		JButton btnNewButton_26 = new JButton("Usun");
		btnNewButton_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_4.getSelectedRow()!=-1)
				{
					GrupaDane grup=new GrupaDane();
					grup.setIdGrupa((Integer)table_4.getValueAt(table_4.getSelectedRow(), 0));
					grup.setOperacja(2);
					if(ServerConnector.sendGrupa(grup))
					{
						JOptionPane.showMessageDialog(panel, "Pomyslnie usunieto grupe");
						DefaultTableModel model = (DefaultTableModel) table_4.getModel();
						for(int j=table_4.getRowCount()-1; j>=0; j--)
							model.removeRow(j);
						grup=new GrupaDane();
						grup.setOperacja(3);
						List<GrupaDane> list=ServerConnector.getGrupaList(grup);
						int i=0;
						for(GrupaDane a:list)
						{
							model.insertRow(i++,new Object[] {a.getIdGrupa(),a.getNazwa_grupy()});
						}
						layout.show(panel, "usgrup");
					}
					else
					{
						JOptionPane.showMessageDialog(panel, "Cos poszlo nie tak");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(panel, "Musisz zaznaczyc wiersz w tabeli");
				}
				
				
			}
		});
		btnNewButton_26.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_26.setBounds(609, 231, 200, 75);
		usgrup.add(btnNewButton_26);
		
		JButton btnNewButton_27 = new JButton("Wroc");
		btnNewButton_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "admin1");
			}
		});
		btnNewButton_27.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_27.setBounds(1084, 662, 170, 75);
		usgrup.add(btnNewButton_27);
		
		JButton btnNewButton_28 = new JButton("Usun");
		btnNewButton_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_5.getSelectedRow()!=-1)
				{
					PrzedmiotDane przed=new PrzedmiotDane();
					przed.setIdPrzedmiot((Integer)table_5.getValueAt(table_5.getSelectedRow(), 0));
					przed.setOperacja(2);
					if(ServerConnector.sendPrzedmiot(przed))
					{
						JOptionPane.showMessageDialog(panel, "Pomyslnie usunieto przedmiot");
						DefaultTableModel model = (DefaultTableModel) table_5.getModel();
						for(int j=table_5.getRowCount()-1; j>=0; j--)
							model.removeRow(j);
						przed=new PrzedmiotDane();
						przed.setOperacja(3);
						List<PrzedmiotDane> list=ServerConnector.getPrzedmiotList(przed);
						int i=0;
						for(PrzedmiotDane a:list)
						{
							model.insertRow(i++,new Object[] {a.getIdPrzedmiot(),a.getNazwa(),a.getTyp()});
						}
					}
					else
					{
						JOptionPane.showMessageDialog(panel, "Cos poszlo nie tak");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(panel, "Nalezy zaznaczyc wiersz w tabeli");
				}
				
			}
		});
		btnNewButton_28.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_28.setBounds(614, 233, 200, 75);
		usprzed.add(btnNewButton_28);
		
		JButton btnNewButton_29 = new JButton("Wroc");
		btnNewButton_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "admin1");
			}
		});
		btnNewButton_29.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_29.setBounds(1089, 660, 170, 75);
		usprzed.add(btnNewButton_29);
		
		buttonGroup.add(AdminButton);
		buttonGroup.add(StudentButton);
		buttonGroup.add(NauczycielButton);
		
		JPanel dodpos = new JPanel();
		panel.add(dodpos, "dodpos");
		dodpos.setLayout(null);
		
		JLabel lblNewLabel_17 = new JLabel("Polacz nauczyciela z przedmiotem");
		lblNewLabel_17.setBounds(454, 5, 375, 31);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dodpos.add(lblNewLabel_17);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(56, 74, 490, 369);
		dodpos.add(scrollPane_6);
		
		table_6 = new JTable();
		table_6.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idPrzedmiot", "Nazwa", "Typ"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_6.setViewportView(table_6);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(725, 70, 470, 370);
		dodpos.add(scrollPane_7);
		
		table_7 = new JTable();
		table_7.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idNauczyciel", "Imie", "Nazwisko", "Stopien", "Login", "Haslo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_7.setViewportView(table_7);
		
		JLabel lblNewLabel_18 = new JLabel("Wybierz dane z lewej tabeli:");
		lblNewLabel_18.setBounds(205, 515, 135, 14);
		dodpos.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Wybierz dane z prawej tabeli:");
		lblNewLabel_19.setBounds(900, 515, 151, 14);
		dodpos.add(lblNewLabel_19);
		
		JButton btnNewButton_30 = new JButton("Wybierz przedmiot");
		btnNewButton_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_6.getSelectedRow()!=-1)
				{
					lblNewLabel_18.setText(Integer.toString((Integer)table_6.getValueAt(table_6.getSelectedRow(), 0)));
					pos.setIdPrzedmiot((Integer)table_6.getValueAt(table_6.getSelectedRow(), 0));
				}
				else if(table_6.getSelectedRow()==-1)
					JOptionPane.showMessageDialog(panel, "Musisz wybrac wiersz z lewej tabeli");
				
				
			}
		});
		btnNewButton_30.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_30.setBounds(111, 585, 321, 82);
		dodpos.add(btnNewButton_30);
		
		
		
		JButton btnNewButton_31 = new JButton("Wybierz nauczyciela");
		btnNewButton_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_7.getSelectedRow()!=-1)
				{
					lblNewLabel_19.setText(Integer.toString((Integer)table_7.getValueAt(table_7.getSelectedRow(), 0)));
					pos.setIdNauczyciel((Integer)table_7.getValueAt(table_7.getSelectedRow(), 0));
				}
				else if(table_7.getSelectedRow()==-1)
					JOptionPane.showMessageDialog(panel, "Musisz wybrac wiersz z prawej tabeli");
			}
		});
		btnNewButton_31.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_31.setBounds(804, 585, 335, 82);
		dodpos.add(btnNewButton_31);
		
		JButton btnNewButton_32 = new JButton("Dodaj");
		btnNewButton_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pos.setOperacja(1);
				if(ServerConnector.sendPos(pos))
				{
					JOptionPane.showMessageDialog(panel, "Pomyslnie dodano polaczenie!");
				}
				else
					JOptionPane.showMessageDialog(panel, "Nie udalo sie dodac polaczenia");
				pos=new PosDane();
			}
		});
		btnNewButton_32.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_32.setBounds(559, 668, 151, 53);
		dodpos.add(btnNewButton_32);
		
		JButton btnNewButton_33 = new JButton("Wroc");
		btnNewButton_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "admin1");
			}
		});
		btnNewButton_33.setBounds(1122, 708, 89, 23);
		dodpos.add(btnNewButton_33);
		
		JPanel uspos = new JPanel();
		panel.add(uspos, "uspos");
		uspos.setLayout(null);
		
		JLabel lblNewLabel_22 = new JLabel("Usun polaczenie");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_22.setBounds(476, 11, 219, 44);
		uspos.add(lblNewLabel_22);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(284, 124, 577, 341);
		uspos.add(scrollPane_8);
		
		table_8 = new JTable();
		table_8.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idPos", "idNauczyciel", "idPrzedmiot", "Imie", "Nazwisko", "Przedmiot", "Typ"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_8.setViewportView(table_8);
		
		
		JButton btnNewButton_37 = new JButton("Usun");
		btnNewButton_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table_8.getSelectedRow()!=-1)
				{
					pos.setIdPos((Integer)table_8.getValueAt(table_8.getSelectedRow(), 0));
					
				}
				else if(table_8.getSelectedRow()==-1)
				{
					JOptionPane.showMessageDialog(panel, "Nalezy zaznaczyc wiesz tabeli");
				}
				pos.setOperacja(2);
				if(ServerConnector.sendPos(pos))
				{
					JOptionPane.showMessageDialog(panel, "Pomyslnie usunieto polaczenie");
					DefaultTableModel model = (DefaultTableModel) table_8.getModel();
					for(int j=table_8.getRowCount()-1; j>=0; j--)
						model.removeRow(j);
					pos=new PosDane();
					pos.setOperacja(3);
					List<PosDane> list=ServerConnector.getPosList(pos);
					int i=0;
					for(PosDane a:list)
					{
						model.insertRow(i++,new Object[] {a.getIdPos(),a.getIdNauczyciel(),a.getIdPrzedmiot(),a.getImie(),a.getNazwisko(),a.getNazwa(),a.getTyp()});
					}
				
					
				}
				else
					JOptionPane.showMessageDialog(panel, "Nie udalo sie usunac polaczenia");
				pos=new PosDane();
					
				
			}
		});
		btnNewButton_37.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_37.setBounds(476, 643, 219, 78);
		uspos.add(btnNewButton_37);
		
		JButton btnNewButton_38 = new JButton("Wroc");
		btnNewButton_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "admin1");
			}
		});
		btnNewButton_38.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_38.setBounds(1109, 675, 145, 58);
		uspos.add(btnNewButton_38);
		
		JPanel nauczyciel2 = new JPanel();
		panel.add(nauczyciel2, "nauczyciel2");
		nauczyciel2.setLayout(null);
		
		JLabel lblNewLabel_23 = new JLabel("Wszystkie Oceny:");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_23.setBounds(40, 23, 201, 103);
		nauczyciel2.add(lblNewLabel_23);
		
		JButton btnNewButton_40 = new JButton("Wroc");
		btnNewButton_40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(panel, "nauczyciel");
			}
		});
		btnNewButton_40.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_40.setBounds(54, 661, 160, 57);
		nauczyciel2.add(btnNewButton_40);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(420, 66, 744, 561);
		nauczyciel2.add(scrollPane_10);
		
		table_10 = new JTable();
		scrollPane_10.setViewportView(table_10);
		table_10.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idOcena", "Ocena", "Waga", "Nazwisko", "Imie", "Nazwa", "Typ"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Float.class, Integer.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JButton btnNewButton_10 = new JButton("Usun");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_10.getSelectedRow()!=-1)
				{
					OcenaDane ocena = new OcenaDane();
					ocena.setOperacja(2);
					ocena.setIdOcena((Integer)table_10.getValueAt(table_10.getSelectedRow(), 0));
					if(ServerConnector.sendOcena(ocena))
					{
						JOptionPane.showMessageDialog(panel, "Udalo sie usunac ocene");
						
							DefaultTableModel model = (DefaultTableModel) table_10.getModel();
							for(int j=table_10.getRowCount()-1; j>=0; j--)
								model.removeRow(j);
							NauczycielDane nauczz=new NauczycielDane();
							nauczz.setOperacja(4);
							nauczz.setIdNauczyciel(loggedNauczyciel.getIdNauczyciel());
							
							List<OcenaDane> list=ServerConnector.getOcenaNauczycielList(nauczz);
							int i=0;
							for(OcenaDane a:list)
							{
								model.insertRow(i++,new Object[] {a.getIdOcena(),a.getOcena(),a.getWaga(),a.getNazwisko(),a.getImie(),a.getNazwa(),a.getTyp()});
							}
						
					}
					else
						JOptionPane.showMessageDialog(panel, "Nie udalo sie usunac oceny");
							
				}
				else
				{
					JOptionPane.showMessageDialog(panel, "Nalezy zaznaczyc wiersz w tabeli");
				}
			}
		});
		btnNewButton_10.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_10.setBounds(827, 661, 173, 73);
		nauczyciel2.add(btnNewButton_10);
	}
}
