package kr.or.iei.point.vo;

public class Vip extends Sliver{

	public Vip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vip(String grade, String name, int point) {
		super(grade, name, point);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double getBonus() {
		return 0.07*getPoint();
	}

}
