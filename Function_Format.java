import java.awt.Font;

public class Function_Format {
	
	GUI gui;
	Font arial, comicsansems, timesnewroman;
	String selectedfont;
	
	public Function_Format(GUI gui) {
		
		this.gui=gui;
		
	}
	
	public void wordwrap() {
		
		if(gui.wordwrapon==false) {
			gui.wordwrapon=true;
			gui.textarea.setLineWrap(true);
			gui.textarea.setWrapStyleWord(true);
			gui.iwrap.setText("Word Wrap: On");
			
		}
		else if(gui.wordwrapon==true) {
			gui.wordwrapon=false;
			gui.textarea.setLineWrap(false);
			gui.textarea.setWrapStyleWord(false);
			gui.iwrap.setText("Word Wrap: Off");
			
		}
	}
	
	public  void createfont(int fontsize) {
		
		arial=  new Font("Arial", Font.PLAIN, fontsize);
		 comicsansems=  new Font(" Comic Sanse MS", Font.PLAIN, fontsize);
		 timesnewroman=  new Font("Times New Roman", Font.PLAIN, fontsize);
		 
		 setfont(selectedfont);
	}
	
	public void setfont(String font) {
		selectedfont= font;
		
		switch(selectedfont) {
		case "Arial":
			gui.textarea.setFont(arial);
			break;
			
		case "Comic Sans MS":
			gui.textarea.setFont(comicsansems);
			break;
			
		case "Times New Roman":
			gui.textarea.setFont(timesnewroman);
			break;

		}
	}
	

}
