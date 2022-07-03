package kr.or.iei.point.vo;

public class Vvip extends Sliver{

	public Vvip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vvip(String grade, String name, int point) {
		super(grade, name, point);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double getBonus(){
		return 0.10*getPoint();
	}
}
