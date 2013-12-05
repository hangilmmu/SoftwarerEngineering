import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {
	ListFrame LF;
	DBConnecter DBC;
	
	public MainFrame() {
		setTitle("Mp3 manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		DBC = new DBConnecter();
		LF = new ListFrame(DBC);
		
		JButton back = new JButton("이전");
		back.setLocation(20, 120);
		back.setSize(70, 30);
		add(back);
		
		JButton play = new JButton("재생");
		play.setLocation(90, 120);
		play.setSize(70, 30);
		add(play);
		
		JButton next = new JButton("다음");
		next.setLocation(160, 120);
		next.setSize(70, 30);
		add(next);
		
		JButton list = new JButton("List");
		listOpen lstOp = new listOpen(this, LF);
		list.addActionListener(lstOp);
		list.setLocation(210, 10);
		list.setSize(70, 30);
		add(list);
		
		setSize(300,200);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new MainFrame();
	}
}