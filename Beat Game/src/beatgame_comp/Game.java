package beatgame_comp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Game extends Thread{
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image goldFlareImage;
	private Image judgeImage;
	
	private Image keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	private int scoreSum = 0;
	Image buffImage;
	Graphics2D buffg;
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}
	
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		
		for(int i=0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}else {
				note.screenDraw(g);
			}
		}
		
		
		
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );	//텍스트 깨짐 현상 수정
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1150,  702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 586, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		
		g.setColor(Color.red);
		g.drawString("SCORE : "+scoreSum, 590, 702);
		
		g.drawImage(goldFlareImage, 110, 150, null);
		g.drawImage(judgeImage,460, 420, null);
		
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);
		
		
		
	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	}
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	}
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	}
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	}
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	}
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	
	public void dropNotes(String titleName) {
		Beat[] beats= null;
		if(titleName.equals("KDA  POPSTARS-League of Legends") && difficulty.equals("Easy")) {
			int startTime = 6000 - Main.REACH_TIME * 1000;
			/*int gap = 300;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 2, "F"),	//600
					new Beat(startTime + gap * 5, "L"),	//1500
					new Beat(startTime + gap * 7, "J"),	//2100
					new Beat(startTime + gap * 9, "D"),	//2700
					new Beat(startTime + gap * 12, "S"),
					new Beat(startTime + gap * 13, "Space"),
					new Beat(startTime + gap * 18, "J"),
					new Beat(startTime + gap * 18, "Space"),
					new Beat(startTime + gap * 18, "F"),
					new Beat(startTime + gap * 19, "K"),
					new Beat(startTime + gap * 21, "F"),
					new Beat(startTime + gap * 26, "F"),
					new Beat(startTime + gap * 31, "L"),
					new Beat(startTime + gap * 33, "K"),
					new Beat(startTime + gap * 35, "Space"),
					new Beat(startTime + gap * 40, "S"),
					new Beat(startTime + gap * 45, "D"),
					new Beat(startTime + gap * 49, "F"),
					new Beat(startTime + gap * 54, "S"),
					new Beat(startTime + gap * 58, "S"),
					new Beat(startTime + gap * 64, "D"),
					new Beat(startTime + gap * 68, "D"),
					new Beat(startTime + gap * 73, "F"),
					new Beat(startTime + gap * 78, "F"),
					new Beat(startTime + gap * 82, "J"),
					new Beat(startTime + gap * 87, "J"), 
					new Beat(startTime + gap * 90, "K"),
					new Beat(startTime + gap * 91, "S"),
					new Beat(startTime + gap * 92, "K"),
					new Beat(startTime + gap * 93, "S"),	//완성
					
					new Beat(startTime + gap * 98, "J"), 
					new Beat(startTime + gap * 100, "K"),
					new Beat(startTime + gap * 103, "S"),
					new Beat(startTime + gap * 106, "K"),
					new Beat(startTime + gap * 110, "S"),
					*/
			int gap = 100;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 6, "F"),	
					new Beat(startTime + gap * 15, "L"),	
					new Beat(startTime + gap * 21, "J"),	
					new Beat(startTime + gap * 27, "D"),	
					new Beat(startTime + gap * 36, "S"),
					new Beat(startTime + gap * 39, "Space"),
					new Beat(startTime + gap * 43, "S"),
					new Beat(startTime + gap * 46, "D"),
					new Beat(startTime + gap * 50, "F"),
					new Beat(startTime + gap * 54, "J"),
					new Beat(startTime + gap * 54, "Space"),
					new Beat(startTime + gap * 54, "F"),
					new Beat(startTime + gap * 57, "K"),
					new Beat(startTime + gap * 63, "F"),
					new Beat(startTime + gap * 77, "F"),
					new Beat(startTime + gap * 92, "L"),
					new Beat(startTime + gap * 95, "K"),
					new Beat(startTime + gap * 100, "S"),
					new Beat(startTime + gap * 103, "L"),
					new Beat(startTime + gap * 106, "D"),
					new Beat(startTime + gap * 109, "K"),
					new Beat(startTime + gap * 120, "S"),
					new Beat(startTime + gap * 134, "D"),
					new Beat(startTime + gap * 147, "F"),
					new Beat(startTime + gap * 150, "Space"),
					new Beat(startTime + gap * 155, "J"),
					new Beat(startTime + gap * 158, "D"),
					new Beat(startTime + gap * 161, "K"),
					new Beat(startTime + gap * 164, "S"),	
					new Beat(startTime + gap * 176, "S"),
					new Beat(startTime + gap * 190, "D"),
					new Beat(startTime + gap * 204, "D"),
					new Beat(startTime + gap * 218, "F"),
					new Beat(startTime + gap * 233, "F"),
					new Beat(startTime + gap * 247, "J"),
					new Beat(startTime + gap * 261, "J"), 
					new Beat(startTime + gap * 269, "K"),
					new Beat(startTime + gap * 272, "S"),
					new Beat(startTime + gap * 275, "K"),
					new Beat(startTime + gap * 278, "S"),	
					new Beat(startTime + gap * 294, "J"), 
					new Beat(startTime + gap * 300, "K"),
					new Beat(startTime + gap * 307, "S"),
					new Beat(startTime + gap * 321, "K"),
					new Beat(startTime + gap * 330, "S"),	//완성
			
			};
		}
		else if(titleName.equals("RISE-League of Legends") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("Warriors-League of Legends") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		int i = 0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void judge(String input) {
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				scoreEvent(note.score());
				break;
			}
		}
	}
	
	public void scoreEvent(int score) {
		if(score == 100) {
			scoreSum = scoreSum+100;
			System.out.println("현재 점수 : "+scoreSum);
			
		}
		else if(score == 200) {
			scoreSum = scoreSum+200;
			System.out.println("현재 점수 : "+scoreSum);
		}
		else if(score == 300) {
			scoreSum = scoreSum+300;
			System.out.println("현재 점수 : "+scoreSum);
		}
		else if(score == 400) {
			scoreSum = scoreSum+400;
			System.out.println("현재 점수 : "+scoreSum);
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			goldFlareImage = new ImageIcon(Main.class.getResource("../images/goldFlare.png")).getImage();
		}
		if(judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
		}
		else if(judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
		}
		else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
		}
		else if(judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
		}
		else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
		}
		else if(judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
		}
	}
	
	
	

}
