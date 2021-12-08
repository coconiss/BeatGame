package beatgame_comp;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image screenimage;
	private Graphics screenGraphic;
	
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introbackground.jpg")).getImage();;
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon normalButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/normalButtonEntered.png"));
	private ImageIcon normalButtonBasicImage = new ImageIcon(Main.class.getResource("../images/normalButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton normalButton = new JButton(normalButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private int nowSelected = 0;	//선택된 트랙의 번호
	Music introMusic = new Music("intromusic.mp3", true);
	
	public static Game game;	//한번에 하나의 게임만 가능하도록 static
	
	public DynamicBeat() {
		
		//곡의 정보를 트랙 리스트에 추가
		trackList.add(new Track("KDA_name.png","KDA.png","KDA_main.jpg",
				"KDA  POPSTARS-League of Legends-cut.mp3","KDA  POPSTARS-League of Legends.mp3","KDA  POPSTARS-League of Legends") );
		trackList.add(new Track("RISE_name.png","RISE.png","RISE_main.jpg",
				"RISE-League of Legends-cut.mp3","RISE-League of Legends.mp3","RISE-League of Legends"));
		trackList.add(new Track("Warriors_name.png","Warriors.png","Warriors_main.jpg",
				"Warriors-League of Legends-cut.mp3","Warriors-League of Legends.mp3","Warriors-League of Legends"));
				
		setUndecorated(true);
		setTitle("Dynamic Beat Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 창의 크기
		setResizable(false); // 사용자가 임의대로 사이즈 변경불가능
		setLocationRelativeTo(null); // 화면의 정 가운데 창 띄우기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창이 꺼지면 게임도 꺼지는 기능(필수)
		setVisible(true); // 창을 보여주는것
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		addKeyListener(new KeyListner());
		
		introMusic.start();
		
		exitButton.setBounds(1250, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	//마우스가 올라갔을 때
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//손가락 모양으로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//모양 돌아옴
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(500);
				}catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		
		startButton.setBounds(30, 420, 400,100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	//마우스가 올라갔을 때
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//손가락 모양으로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//모양 돌아옴
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//게임 시작 이벤트
				enterMain();
			}
		});
		add(startButton);
		
		
		
		quitButton.setBounds(30, 550, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	//마우스가 올라갔을 때
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//손가락 모양으로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//모양 돌아옴
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(500);
				}catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	//마우스가 올라갔을 때
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//손가락 모양으로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//모양 돌아옴
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//왼쪽 버튼 이벤트
				selectLeft();
				
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	//마우스가 올라갔을 때
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//손가락 모양으로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//모양 돌아옴
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//오른쪽 버튼 이벤트
				selectRight();
			}
		});
		add(rightButton);
		
		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 250, 67);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	//마우스가 올라갔을 때
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//손가락 모양으로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//모양 돌아옴
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//easy버튼 이벤트
				gameStart(nowSelected, "Easy");
			}
		});
		add(easyButton);
		
		normalButton.setVisible(false);
		normalButton.setBounds(655, 580, 250, 67);
		normalButton.setBorderPainted(false);
		normalButton.setContentAreaFilled(false);
		normalButton.setFocusPainted(false);
		normalButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	//마우스가 올라갔을 때
				normalButton.setIcon(normalButtonEnteredImage);
				normalButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//손가락 모양으로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				normalButton.setIcon(normalButtonBasicImage);
				normalButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//모양 돌아옴
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//normal버튼 이벤트
				gameStart(nowSelected, "Normal");
			}
		});
		add(normalButton);
		
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	//마우스가 올라갔을 때
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//손가락 모양으로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//모양 돌아옴
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//메인화면으로 가는 버튼 이벤트
				backmain();
			}
		});
		add(backButton);
		
		

		menuBar.setBounds(0, 0, 1280, 30);
		//창을 마우스 드래그 위치에따라 옮겨줌
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

		
	}

	public void paint(Graphics g) { // 화면을 그려주는 함수
		screenimage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 1280,720만큼의 이미지를 screenImage에 넣는다
		screenGraphic = screenimage.getGraphics(); // screenimage의 그래픽을 가져와 screenGraphic에 넣는다
		screenDraw((Graphics2D)screenGraphic);// 그림을 그려준다
		g.drawImage(screenimage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null); // 0, 0위치에 introbackgroud이미지를 그려줌
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 110, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		if(isGameScreen) {
			game.screenDraw(g);
		}
		paintComponents(g); // 항상 보여주는 이미지(menuBar)가 아니라 이것으로 그려줌 add()부분을 말함
		try {
			Thread.sleep(5);
		} catch (Exception e) {
			
		}
		
		this.repaint(); // 다시 paint함수를 불러온다(매 순간마다 반복적으로 그려줌)
	
	}
	
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();	//다른곡 실행되어있으면 종료
		titleImage = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getTitleimage())).getImage();		//선택된 곡의 타이틀이미지를 가져옴
		selectedImage = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getStartimage())).getImage();		//선택된 곡의 곡이미지를 가져옴
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(),true);	//선택된 곡 무한재생(true)
		selectedMusic.start();
	}
	
	
	public void selectLeft() {
		if(nowSelected==0)
			nowSelected = trackList.size()-1;	//가장 왼쪽에 있는 곡에서 왼쪽 눌렀을 때 가장 오른쪽 곡으로 이동
		else
			nowSelected--;
		selectTrack(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected==trackList.size()-1)
			nowSelected = 0;

		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {	//게임시작을 했을 경우
		if(selectedMusic != null)
		selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		normalButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getGameimage())).getImage();;
		backButton.setVisible(true);
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
		requestFocus();	//오류수정
		game.start();
		setFocusable(true);
	}
	
	public void backmain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		normalButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
		game.close();
	}
	
	public void enterMain() {
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();;
		isMainScreen = true;
		startButton.setVisible(false);
		quitButton.setVisible(false);
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		normalButton.setVisible(true);
		introMusic.close();
		selectTrack(0);	//첫번째 곡 실행
	}
	
	
	
}
