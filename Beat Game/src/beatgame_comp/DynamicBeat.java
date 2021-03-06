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
	private int nowSelected = 0;	//????????? ????????? ??????
	Music introMusic = new Music("intromusic.mp3", true);
	
	public static Game game;	//????????? ????????? ????????? ??????????????? static
	
	public DynamicBeat() {
		
		//?????? ????????? ?????? ???????????? ??????
		trackList.add(new Track("KDA_name.png","KDA.png","KDA_main.jpg",
				"KDA  POPSTARS-League of Legends-cut.mp3","KDA  POPSTARS-League of Legends.mp3","KDA  POPSTARS-League of Legends") );
		trackList.add(new Track("RISE_name.png","RISE.png","RISE_main.jpg",
				"RISE-League of Legends-cut.mp3","RISE-League of Legends.mp3","RISE-League of Legends"));
		trackList.add(new Track("Warriors_name.png","Warriors.png","Warriors_main.jpg",
				"Warriors-League of Legends-cut.mp3","Warriors-League of Legends.mp3","Warriors-League of Legends"));
				
		setUndecorated(true);
		setTitle("Dynamic Beat Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // ?????? ??????
		setResizable(false); // ???????????? ???????????? ????????? ???????????????
		setLocationRelativeTo(null); // ????????? ??? ????????? ??? ?????????
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ?????? ????????? ????????? ????????? ??????(??????)
		setVisible(true); // ?????? ???????????????
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
			public void mouseEntered(MouseEvent e) {	//???????????? ???????????? ???
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//????????? ???????????? ??????
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//?????? ?????????
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
			public void mouseEntered(MouseEvent e) {	//???????????? ???????????? ???
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//????????? ???????????? ??????
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//?????? ?????????
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//?????? ?????? ?????????
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
			public void mouseEntered(MouseEvent e) {	//???????????? ???????????? ???
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//????????? ???????????? ??????
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//?????? ?????????
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
			public void mouseEntered(MouseEvent e) {	//???????????? ???????????? ???
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//????????? ???????????? ??????
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//?????? ?????????
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//?????? ?????? ?????????
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
			public void mouseEntered(MouseEvent e) {	//???????????? ???????????? ???
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//????????? ???????????? ??????
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//?????? ?????????
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//????????? ?????? ?????????
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
			public void mouseEntered(MouseEvent e) {	//???????????? ???????????? ???
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//????????? ???????????? ??????
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//?????? ?????????
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//easy?????? ?????????
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
			public void mouseEntered(MouseEvent e) {	//???????????? ???????????? ???
				normalButton.setIcon(normalButtonEnteredImage);
				normalButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//????????? ???????????? ??????
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				normalButton.setIcon(normalButtonBasicImage);
				normalButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//?????? ?????????
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//normal?????? ?????????
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
			public void mouseEntered(MouseEvent e) {	//???????????? ???????????? ???
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//????????? ???????????? ??????
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//?????? ?????????
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//?????????????????? ?????? ?????? ?????????
				backmain();
			}
		});
		add(backButton);
		
		

		menuBar.setBounds(0, 0, 1280, 30);
		//?????? ????????? ????????? ??????????????? ?????????
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

	public void paint(Graphics g) { // ????????? ???????????? ??????
		screenimage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 1280,720????????? ???????????? screenImage??? ?????????
		screenGraphic = screenimage.getGraphics(); // screenimage??? ???????????? ????????? screenGraphic??? ?????????
		screenDraw((Graphics2D)screenGraphic);// ????????? ????????????
		g.drawImage(screenimage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null); // 0, 0????????? introbackgroud???????????? ?????????
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 110, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		if(isGameScreen) {
			game.screenDraw(g);
		}
		paintComponents(g); // ?????? ???????????? ?????????(menuBar)??? ????????? ???????????? ????????? add()????????? ??????
		try {
			Thread.sleep(5);
		} catch (Exception e) {
			
		}
		
		this.repaint(); // ?????? paint????????? ????????????(??? ???????????? ??????????????? ?????????)
	
	}
	
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();	//????????? ????????????????????? ??????
		titleImage = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getTitleimage())).getImage();		//????????? ?????? ????????????????????? ?????????
		selectedImage = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getStartimage())).getImage();		//????????? ?????? ??????????????? ?????????
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(),true);	//????????? ??? ????????????(true)
		selectedMusic.start();
	}
	
	
	public void selectLeft() {
		if(nowSelected==0)
			nowSelected = trackList.size()-1;	//?????? ????????? ?????? ????????? ?????? ????????? ??? ?????? ????????? ????????? ??????
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
	
	public void gameStart(int nowSelected, String difficulty) {	//??????????????? ?????? ??????
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
		requestFocus();	//????????????
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
		selectTrack(0);	//????????? ??? ??????
	}
	
	
	
}
