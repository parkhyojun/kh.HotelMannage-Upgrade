package kr.or.iei.point.vo;

public class Gold extends Sliver{

	public Gold() {
		super();
	}

	public Gold(String grade, String name, int point) {
		super(grade, name, point);
	}
	
	@Override 
	public double getBonus() {
		return 0.05 * getPoint();
		//private인 포인트는 직접접근이 불가능 -> get을써서 가져온다
	}
}
