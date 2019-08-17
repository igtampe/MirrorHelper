package mirrorHelperMain;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class MirrorHelperMain {

	private JFrame frmMirrorhelper;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MirrorHelperMain window = new MirrorHelperMain();
					window.frmMirrorhelper.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MirrorHelperMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMirrorhelper = new JFrame();
		frmMirrorhelper.setResizable(false);
		
		frmMirrorhelper.setIconImage(Toolkit.getDefaultToolkit().getImage(MirrorHelperMain.class.getResource("/MirrorHelperM.png")));
		
		frmMirrorhelper.setTitle("MirrorHelper");
		
		
		frmMirrorhelper.setBounds(100, 100, 319, 568);
		frmMirrorhelper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMirrorhelper.getContentPane().setLayout(null);
		
		JLabel MirrorHelperLabel = new JLabel("");
		MirrorHelperLabel.setIcon(new ImageIcon(MirrorHelperMain.class.getResource("/MirrorHelperSmol.png")));
		MirrorHelperLabel.setBounds(0, 0, 313, 97);
		MirrorHelperLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MirrorHelperLabel.setFont(new Font("Arial", Font.BOLD, 30));
		frmMirrorhelper.getContentPane().add(MirrorHelperLabel);
		
		JLabel lblCoordinate = new JLabel("Coord. 2");
		lblCoordinate.setBounds(10, 137, 62, 14);
		frmMirrorhelper.getContentPane().add(lblCoordinate);
		
		JLabel lblCoord = new JLabel("Coord. 1");
		lblCoord.setBounds(10, 108, 62, 14);
		frmMirrorhelper.getContentPane().add(lblCoord);
		
		JLabel lblPasteCoordinate = new JLabel("Paste Coord.");
		lblPasteCoordinate.setBounds(10, 162, 83, 14);
		frmMirrorhelper.getContentPane().add(lblPasteCoordinate);
		
		JTextPane Coord1TXB = new JTextPane();
		Coord1TXB.setText("X,Y,Z");
		Coord1TXB.setBounds(103, 108, 200, 20);
		frmMirrorhelper.getContentPane().add(Coord1TXB);
		
		JTextPane Coord2TXB = new JTextPane();
		Coord2TXB.setText("X,Y,Z");
		Coord2TXB.setBounds(103, 133, 200, 20);
		frmMirrorhelper.getContentPane().add(Coord2TXB);
		
		JTextPane PasteCoordTXB = new JTextPane();
		PasteCoordTXB.setToolTipText("REMEMBER: LOWEST NORTH WESTERN POINT");
		PasteCoordTXB.setText("X,Y,Z");
		PasteCoordTXB.setBounds(103, 156, 200, 20);
		frmMirrorhelper.getContentPane().add(PasteCoordTXB);
		
		JLabel lblOBJ = new JLabel("");
		lblOBJ.setIcon(new ImageIcon(MirrorHelperMain.class.getResource("/XMirror.png")));
		lblOBJ.setHorizontalAlignment(SwingConstants.LEFT);
		lblOBJ.setBounds(22, 370, 160, 80);
		frmMirrorhelper.getContentPane().add(lblOBJ);
		
		JRadioButton XMirrorRButton = new JRadioButton("");
		XMirrorRButton.setBounds(88, 457, 24, 23);
		JRadioButton ZMirrorRButton = new JRadioButton("");
		ZMirrorRButton.setBounds(228, 501, 24, 23);
		
		//before we add them to the form, lets make sure they're in the same group:
		ButtonGroup Doot = new ButtonGroup();
		Doot.add(ZMirrorRButton);
		Doot.add(XMirrorRButton);
				
		frmMirrorhelper.getContentPane().add(ZMirrorRButton);
		frmMirrorhelper.getContentPane().add(XMirrorRButton);
		
		JComboBox FirstOption = new JComboBox();
		FirstOption.setBounds(103, 286, 79, 20);
		FirstOption.addItem("replace");
		FirstOption.addItem("masked");
		FirstOption.setToolTipText("<html>"
				+ "<b>Replace:</b> Replace all blocks in the way <br>"
				+ "<b>Masked:</b> Only mirror non-air blocks<br>"
				+ "</html>");
		frmMirrorhelper.getContentPane().add(FirstOption);
		
		JComboBox SecondOption = new JComboBox();
		SecondOption.setBounds(200, 286, 79, 20);
		SecondOption.addItem("normal");
		SecondOption.addItem("move");
		SecondOption.addItem("force");
		SecondOption.setToolTipText("<html>"
				+ "<b>Normal:</b> A normal clone <br>"
				+ "<b>Move:</b> Move all blocks to the mirrored copy<br>"
				+ "<b>Force:</b> Force the mirror, even if the areas overlap. <b> BE VERY CAUTIOUS WHEN USING THIS OPTION </b><br>"
				+ "</html>");
		frmMirrorhelper.getContentPane().add(SecondOption);
		
		JButton btnNewButton = new JButton("Mirror!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//oh so this happens when the action is performed mmm que lindo
				
				echo("It's Big Brain Time");
				
				//ok now we've got to parse the coordinates into three sets
				String[] Coord1;
				String[] Coord2;
				String[] PasteCoord;
				int Coord1X;
				int Coord1Y;
				int Coord1Z;
				int Coord2X;
				int Coord2Y;
				int Coord2Z;
				int PasteCoordX;
				int PasteCoordY;
				int PasteCoordZ;
				
				try {					
					Coord1 = Coord1TXB.getText().split(",");
					Coord2 = Coord2TXB.getText().split(",");
					PasteCoord = PasteCoordTXB.getText().split(",");
				} catch (Exception e) {
					ErrorWindow.Generate(0, "An Error Happened", "I couldn't split the coordinates.", true, e.toString());
					echo("Coordinates could not be split. \n \n ");
					e.printStackTrace();
					return;
					
				}
				
				
				try {
					Coord1X = Integer.parseInt(Coord1[0]);
					Coord1Y = Integer.parseInt(Coord1[1]);
					Coord1Z = Integer.parseInt(Coord1[2]);
					Coord2X = Integer.parseInt(Coord2[0]);;
					Coord2Y = Integer.parseInt(Coord2[1]);;
					Coord2Z = Integer.parseInt(Coord2[2]);;
					PasteCoordX = Integer.parseInt(PasteCoord[0]);;
					PasteCoordY = Integer.parseInt(PasteCoord[1]);;
					PasteCoordZ = Integer.parseInt(PasteCoord[2]);;
					
				} catch (Exception e) {
					ErrorWindow.Generate(0, "An Error Happened", "I couldn't parse the coordinates", true, e.toString());
					echo("Coordinates could not be converted to Integers. \n \n ");
					e.printStackTrace();
					return;
				}
				
				echo("OK I should have the coords now");
				
				//then we've got to check which way we're mirroring
				String Mode;
				Mode="none";
				if (XMirrorRButton.isSelected()) Mode="X";
				if (ZMirrorRButton.isSelected()) Mode="Z";

				
				String[] Commands;
				String CommandsTemp;
				
				
				//if it's X, the highest X on the original goes to the lowest X on the copy
				//then second highest goes to second lowest and so on and so forth
				//the same with Z
				switch (Mode) {
				case "X":
					echo("Mirroring on X");
					
					int CurrentOriginalX;
					int MinOriginalX;
					int CurrentCopyX;
					
					if (Coord1X>Coord2X) {
						CurrentOriginalX=Coord1X;
						MinOriginalX=Coord2X;
					}
					else {
						CurrentOriginalX=Coord2X;
						MinOriginalX=Coord1X;
					}
					
					CurrentCopyX=PasteCoordX;
					CommandsTemp="";
					
					while(CurrentOriginalX>=MinOriginalX) {
						CommandsTemp=CommandsTemp + "/clone " + CurrentOriginalX + " " + Coord1Y + " " + Coord1Z + " " + CurrentOriginalX + " " + Coord2Y + " " + Coord2Z + " " + CurrentCopyX + " " + PasteCoordY + " " + PasteCoordZ + " " + FirstOption.getSelectedItem().toString() + " " + SecondOption.getSelectedItem().toString()+"~";
						CurrentOriginalX--;
						CurrentCopyX++;
					}
					
					
					
					//"/clone <Dynamic1> coord1Y coord1Z"
					
					break;
				case "Z":
					echo("Mirroring on Z");
					
					
					int CurrentOriginalZ;
					int MinOriginalZ;
					int CurrentCopyZ;
					
					if (Coord1Z>Coord2Z) {
						CurrentOriginalZ=Coord1Z;
						MinOriginalZ=Coord2Z;
					}
					else {
						CurrentOriginalZ=Coord2Z;
						MinOriginalZ=Coord1Z;
					}
					
					CurrentCopyZ=PasteCoordZ;
					CommandsTemp="";
					
					while(CurrentOriginalZ>=MinOriginalZ) {
						CommandsTemp=CommandsTemp + "/clone " + Coord1X + " " + Coord1Y + " " + CurrentOriginalZ + " " + Coord2X + " " + Coord2Y + " " + CurrentOriginalZ + " " + PasteCoordX + " " + PasteCoordY + " " + CurrentCopyZ + " " + FirstOption.getSelectedItem().toString() + " " + SecondOption.getSelectedItem().toString()+"~";
						CurrentOriginalZ--;
						CurrentCopyZ++;
					}
					
					
					break;
				default:
					ErrorWindow.Generate(1, "b o b o", "You didn't select a mode", false, null);
					echo("User did not select a mode, and thus he is a bobo.");
					return;
					
				}
				
				
				Commands=CommandsTemp.split("~");
				CopyWindow.main(Commands);
				
				//Then we have to output it somehow. For now lets use console, then we can deal with commandos
								
				System.out.println("haha you has pressed the button");
			}
		});
		btnNewButton.setBounds(22, 501, 160, 23);
		frmMirrorhelper.getContentPane().add(btnNewButton);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MirrorHelperMain.class.getResource("/ZMirror.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(200, 327, 83, 167);
		frmMirrorhelper.getContentPane().add(label_1);
		
		JLabel lblOR = new JLabel("OR");
		lblOR.setHorizontalAlignment(SwingConstants.CENTER);
		lblOR.setBounds(136, 187, 46, 14);
		frmMirrorhelper.getContentPane().add(lblOR);
		
		JTextPane CloneCommandTXB = new JTextPane();
		CloneCommandTXB.setText("/clone X1 Y1 Z1 X2 Y2 Z2 PX PY PZ");
		CloneCommandTXB.setBounds(10, 212, 293, 20);
		frmMirrorhelper.getContentPane().add(CloneCommandTXB);
		
		JButton btnParseCloneCommand = new JButton("Parse Clone Command");
		btnParseCloneCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String[] CloneCommand=CloneCommandTXB.getText().split(" ");
			Coord1TXB.setText(CloneCommand[1] + "," + CloneCommand[2] + "," + CloneCommand[3]);
			Coord2TXB.setText(CloneCommand[4] + "," + CloneCommand[5] + "," + CloneCommand[6]);
			PasteCoordTXB.setText(CloneCommand[7] + "," + CloneCommand[8] + "," + CloneCommand[9]);
			}
		});
		btnParseCloneCommand.setBounds(68, 243, 195, 23);
		frmMirrorhelper.getContentPane().add(btnParseCloneCommand);
		
		JLabel lblCloneOptions = new JLabel("Clone Options:");
		lblCloneOptions.setBounds(10, 286, 83, 20);
		frmMirrorhelper.getContentPane().add(lblCloneOptions);
		
		
		
		
		
		
	}
	
	
	
	public void echo(String Doot) {
		System.out.println(Doot);
	}
}
