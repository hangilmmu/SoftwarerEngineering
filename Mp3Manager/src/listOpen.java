import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

class listOpen implements ActionListener{
	MainFrame MF;
	ListFrame LF;
	public listOpen(MainFrame MF,ListFrame LF){
		this.MF = MF;
		this.LF = LF;
	}
	public void actionPerformed(ActionEvent e){
		JButton list = (JButton)e.getSource();
		
		if(list.getText().equals("List")){
			LF.show(MF);
			list.setText("Close");
		} else {
			LF.setVisible(false);
			list.setText("List");
		}
	}	
}