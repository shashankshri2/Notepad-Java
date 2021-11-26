
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
public class GUI implements ActionListener {

	JFrame window;
	
	//Text Area
	JTextArea textarea;
	JScrollPane scrollpane;
	boolean wordwrapon= false;
	
	
	//Top Menu Bar
	JMenuBar menubar;
	JMenu menufile,menuedit,menuformat,menucolor;
	
	//File Menu
	JMenuItem inew,iopen,isave,isaveas,iexit;
	
	//Format Menu
	JMenuItem iwrap,ifontarial,ifontcms,ifonttnr,ifs8,ifs12,ifs16,ifs20,ifs24,ifs28;
	JMenu menufont,menufontsize;
	
	//Color Menu
	JMenuItem ic1,ic2,ic3;
	
	//Edit Menu
	JMenuItem iundo,iredo;
	
	
	Function_File file =new Function_File(this);
	Function_Format format=new Function_Format(this);
	Function_Color color=new Function_Color(this);
	Function_Edit edit=new Function_Edit(this);
	
	
	
	UndoManager um= new UndoManager();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new GUI();

	}
	public GUI() {
		
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createEditMenu();
		createFormatMenu();
		createColorMenu();
		
		window.setVisible(true);
		
		format.selectedfont= "Arial";
		format.createfont(16);
		format.wordwrap();
		color.changecolor("White");
	}
	
	public void createWindow() {
		
		window= new JFrame("Notepad");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void createTextArea() {
		textarea=new JTextArea();
		textarea.setFont(format.arial);
		
	
		
		textarea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				});
		
		scrollpane=new JScrollPane(textarea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollpane);
		
		window.add(textarea);
	}
	
	public void createMenuBar() {
		menubar= new JMenuBar();
		window.setJMenuBar(menubar);
		
		menufile= new JMenu("File");
		menubar.add(menufile);
		
		menuedit= new JMenu("Edit");
		menubar.add(menuedit);
		
		menuformat= new JMenu("Format");
		menubar.add(menuformat);
		
		menucolor= new JMenu("Color");
		menubar.add(menucolor);
	}
	
	public void createFileMenu() {
		
		inew= new JMenuItem("New");
		menufile.add(inew);
		inew.addActionListener(this);
		inew.setActionCommand("New");
		inew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		iopen= new JMenuItem("Open");
		menufile.add(iopen);
		iopen.addActionListener(this);
		iopen.setActionCommand("Open");
		iopen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		
		
		
		
		isave= new JMenuItem("Save");
		menufile.add(isave);
		isave.addActionListener(this);
		isave.setActionCommand("Save");
		isave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		
		
		isaveas= new JMenuItem("Save as");
		menufile.add(isaveas);
		isaveas.addActionListener(this);
		isaveas.setActionCommand("Save as");
		
		

		iexit= new JMenuItem("Exit");
		menufile.add(iexit);
		iexit.addActionListener(this);
		iexit.setActionCommand("Exit");
		iexit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	}
	
	public void createEditMenu() {
		
		iundo=new JMenuItem("Undo");
		iundo.addActionListener(this);
		iundo.setActionCommand("Undo");
		menuedit.add(iundo);
		
		iredo=new JMenuItem("Redo");
		iredo.addActionListener(this);
		iredo.setActionCommand("Redo");
		menuedit.add(iredo);
	}
	public void createFormatMenu() {
		
		iwrap= new JMenuItem("Word Wrap:Off");
		iwrap.addActionListener(this);
		iwrap.setActionCommand("Word Wrap");
		menuformat.add(iwrap);
		
		menufont= new JMenu("Font");
		menuformat.add(menufont);
		
		
		ifontarial=new JMenuItem("Arial");
		ifontarial.addActionListener(this);
		ifontarial.setActionCommand("Arial");
		menufont.add(ifontarial);
		
		ifontcms=new JMenuItem("Comic Sans MS");
		ifontcms.addActionListener(this);
		ifontcms.setActionCommand("Comic Sans MS");
		menufont.add(ifontcms);
		
		ifonttnr=new JMenuItem("Times New Roman");
		ifonttnr.addActionListener(this);
		ifonttnr.setActionCommand("Times New Roman");
		menufont.add(ifonttnr);
		
		menufontsize= new JMenu("Font Size");
		menuformat.add(menufontsize);
		
		ifs8= new JMenuItem("8");
		ifs8.addActionListener(this);
		ifs8.setActionCommand("8");
		menufontsize.add(ifs8);
		
		
		ifs12= new JMenuItem("12");
		ifs12.addActionListener(this);
		ifs12.setActionCommand("12");
		menufontsize.add(ifs12);
		
		
		ifs16= new JMenuItem("16");
		ifs16.addActionListener(this);
		ifs16.setActionCommand("16");
		menufontsize.add(ifs16);
		
		
		ifs20= new JMenuItem("20");
		ifs20.addActionListener(this);
		ifs20.setActionCommand("20");
		menufontsize.add(ifs20);
		
		
		ifs24= new JMenuItem("24");
		ifs24.addActionListener(this);
		ifs24.setActionCommand("24");
		menufontsize.add(ifs24);
		
		
		ifs28= new JMenuItem("28");
		ifs28.addActionListener(this);
		ifs28.setActionCommand("28");
		menufontsize.add(ifs28);
		
		
	}
	
	public void createColorMenu() {
		ic1= new JMenuItem("White");
		ic1.addActionListener(this);
		ic1.setActionCommand("While");
		menucolor.add(ic1);
		ic1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		
		ic2= new JMenuItem("Black");
		ic2.addActionListener(this);
		ic2.setActionCommand("Black");
		menucolor.add(ic2);
		ic2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		
		ic3= new JMenuItem("Blue");
		ic3.addActionListener(this);
		ic3.setActionCommand("Blue");
		menucolor.add(ic3);
		ic3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String command=e.getActionCommand();
		
		switch(command) {
		case "New": file.newFile();
		break;
		
		case "Open": file.open();
		break;
		
		case "Save as": file.saveas();
		break;
		
		case "Save": file.save();
		break;
		
		case "Exit": file.exit();
		break;
		
		case "Undo": edit.undo();
		break;
		
		case "Redo": edit.undo();
		break;
		
		case "Word Wrap": format.wordwrap();
		break;
		
		case "Arial": format.setfont(command); break;
		case "Comic Sans MS": format.setfont(command); break; 
		case "Times New Roman": format.setfont(command); break;
		
		case "8": format.createfont(8);
		break;
		
		case "12": format.createfont(12);
		break;
		
		case "16": format.createfont(16);
		break;
		
		case "24": format.createfont(24);
		break;
		
		case "28": format.createfont(28);
		break;
		
		case "White":  color.changecolor(command);
		break;
		
		case "Black":  color.changecolor(command);
		break;
	
		case "Blue":  color.changecolor(command);
		break;
	

	
		
	}

}
}
