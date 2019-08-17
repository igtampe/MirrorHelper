package mirrorHelperMain;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Object;
public class CopyWindow {

	//private static final long serialVersionUID = 1L;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopyWindow window = new CopyWindow(args);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CopyWindow(String[] args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize(String[] args) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] doot= { "Value 1", "Value 2", "Value 3", "Value 4", "Value 5" };
		Object[] data=  args;
		//Object[] data=  doot;
		JList list = new JList(data);
		list.setLocation(10, 11);
		list.setSize(424, 420);
		frame.getContentPane().add(list);
		
		JButton btnOk = new JButton("OK");
		btnOk.setMnemonic('O');
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			}
		});
		btnOk.setBounds(345, 442, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JButton btnNextCommand = new JButton("Next Command");
		btnNextCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int TheOneWeGot = list.getSelectedIndex();
				if (TheOneWeGot==list.getLastVisibleIndex()) {
					TheOneWeGot=-1;
				}
				TheOneWeGot++;
				list.setSelectedIndex(TheOneWeGot);
				String CommandtoCopy = list.getSelectedValue().toString();
				System.out.println(CommandtoCopy);
				StringSelection selection = new StringSelection(CommandtoCopy);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(selection, selection);
			
			}
		});
		btnNextCommand.setMnemonic('N');
		btnNextCommand.setBounds(10, 442, 325, 23);
		frame.getContentPane().add(btnNextCommand);
		
		
	}
}
