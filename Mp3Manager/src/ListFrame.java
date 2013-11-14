import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class ListFrame extends JFrame {
	DBConnecter DBC;
	ArrayList<Mp3Header> Mp3List;
	
	public ListFrame(DBConnecter DBC) {
		this.DBC = DBC;
		setTitle("Mp3 List");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		setLayout(null);
		
		JButton add = new JButton("ADD");
		Mp3Collecter mpc = new Mp3Collecter(DBC, Mp3List);
		add.addActionListener(mpc);
		add.setLocation(10, 10);
		add.setSize(70, 30);
		add(add);
		
		this.setSize(300, 600);
		this.setVisible(false);		
	}
	
	public void show(MainFrame MF){
		this.setLocation(MF.getX() + MF.getWidth(), MF.getY());
		this.setVisible(true);
	}
}
