import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Mp3Collecter implements ActionListener{
	ArrayList<Mp3Header> findList;
	ArrayList<Mp3Header> Mp3List;
	DBConnecter DBC;
	
	public Mp3Collecter(DBConnecter DBC, ArrayList<Mp3Header> Mp3List){
		this.DBC = DBC;
		this.Mp3List = Mp3List;
	}

	public void actionPerformed(ActionEvent e) {
		JButton add = (JButton)e.getSource();
		String path = JOptionPane.showInputDialog(null, "파일 경로", "경로 탐색", JOptionPane.PLAIN_MESSAGE);
		findList = new ArrayList<Mp3Header>();
		try {
			readMp3(path);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(findList.size() != 0){
			Mp3List = DBC.insertMp3List(findList);
		}//리스트 갱신
	}//버튼 리스너
	
	private void readMp3(String path) throws Exception{
		File pathDir = new File(path);
		if(pathDir.exists()){
			File []fileList = pathDir.listFiles();
			for(int i=0; i<fileList.length; i++){
				if(fileList[i].getName().endsWith(".mp3")){
					@SuppressWarnings("resource")
					FileInputStream fis = new FileInputStream(fileList[i]);
					OutputStream bis = new ByteArrayOutputStream();
					
					int ch = 0;
					byte [] b = new byte[128];
					
					fis.skip(fileList[i].length() - 128);
					while((ch = fis.read(b, 0, b.length)) != -1) {
						bis.write(b, 0, ch);
					}
					
					Mp3Header mp3h = new Mp3Header();
					mp3h.FName = fileList[i].getName();
					mp3h.Name = parseParam(b, 3, 30);
					mp3h.Artist = parseParam(b, 33, 30);
					mp3h.Album = parseParam(b, 63, 30);
					mp3h.Year = parseParam(b, 93, 4);
					mp3h.Comment  = parseParam(b, 97, 30);
					findList.add(mp3h);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Not Find Path", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}//디렉토리 탐색
	
	public String parseParam(byte [] src, int start, int offset) {
		String paramValue = "";
		int end = start + offset;
		for( int i = start ; i < end ; i++ ) {
			paramValue += (char)src[i];
		}
		return paramValue;
	}//Mp3 파일 헤더 파싱
}
