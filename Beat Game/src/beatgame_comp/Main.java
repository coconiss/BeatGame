package beatgame_comp;

public class Main {
	//상수
	public static final int SCREEN_WIDTH = 1280;	//static 모든 프로젝트 공유하는 변수
	public static final int SCREEN_HEIGHT = 720;	//final 한번 선언되면 절대 변하지 않는 변수
	public static final int NOTE_SPEED = 3;			//note 떨어지는 속도
	public static final int SLEEP_TIME = 10;		//note 시간 간격
	public static final int REACH_TIME = 2;			//판정바 도달하기까지 시간
	
	public static void main(String[] args) {
		
		new DynamicBeat();

	}

}
