package beatgame_comp;

public class Track {
	
	private String titleimage;	//제목 이미지
	private String startimage;	//선택창 표지
	private String gameimage;	//해당 곡을 실행했을 때 이미지
	private String startMusic; 	//게임 선택창 음악
	private String gameMusic;	//해당 곡을 실행
	private String titleName;	//곡 제목
	
	
	
	public String getTitleimage() {
		return titleimage;
	}
	public void setTitleimage(String titleimage) {
		this.titleimage = titleimage;
	}
	public String getStartimage() {
		return startimage;
	}
	public void setStartimage(String startimage) {
		this.startimage = startimage;
	}
	public String getGameimage() {
		return gameimage;
	}
	public void setGameimage(String gameimage) {
		this.gameimage = gameimage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	//생성자
	public Track(String titleimage, String startimage, String gameimage, String startMusic, String gameMusic, String titleName) {
		super();
		this.titleimage = titleimage;
		this.startimage = startimage;
		this.gameimage = gameimage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.titleName = titleName;
	}
	
	

}
