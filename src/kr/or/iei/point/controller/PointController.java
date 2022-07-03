package kr.or.iei.point.controller;

import java.util.Scanner;

import kr.or.iei.point.vo.Gold;
import kr.or.iei.point.vo.Sliver;
import kr.or.iei.point.vo.Vip;
import kr.or.iei.point.vo.Vvip;

public class PointController {
	private Sliver[] sMembers;
	private int sIndex;
	private Gold[] gMembers;
	private int gIndex;
	private Vip[] vMembers;
	private int vIndex;
	private Vvip[] vvMembers;
	private int vvIndex;
	
	private Scanner sc;
	private int flag;
	
	public PointController() {
		sMembers = new Sliver[10];
		gMembers = new Gold[10];
		vMembers = new Vip[10];
		vvMembers = new Vvip[10];
		sc = new Scanner(System.in);
	}
	
	public void main() {
		while(true) {
			System.out.println("===== 포인트 관리 프로그램 =====");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 전체 회원 조회");
			System.out.println("3. 회원 1명 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			int sel = sc.nextInt();
			switch(sel) {
			case 1 :
				insertMembers();
				break;
			case 2 :
				printAllMembers();
				break;
			case 3 :
				printOneMembers();
				break;
			case 4 :
				updateMembers();
				break;
			case 5 :
				deleteMember();
				break;
			case 6 :
				break;
			default : 
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}
	
	
	public void insertMembers() {
		System.out.println("===== 회원 정보 등록 =====");
		System.out.print("회원 등급 입력 : ");
		String grade = sc.next();
		System.out.print("회원 이름 입력 : ");
		String name = sc.next();
		System.out.print("회원 포인트 입력 : ");
		int point = sc.nextInt();
		
		switch(grade) {
		case "sliver" :
			Sliver s = new Sliver(grade, name, point);
			sMembers[sIndex] = s; 
			sIndex++;
			System.out.println("회원 등록 완료!");
			break;
		case "gold" :
			Gold g = new Gold(grade, name, point);
			gMembers[gIndex] = g;
			gIndex++;
			System.out.println("회원 등록 완료!");
			break;
		case "vip" :
			Vip v = new Vip(grade, name, point);
			vMembers[vIndex] = v;
			vIndex++;
			System.out.println("회원 등록 완료!");
			break;
		case "vvip" :
			Vvip vv = new Vvip(grade, name, point);
			vvMembers[vvIndex] = vv;
			vvIndex++;
			System.out.println("회원 등록 완료!");
			break;
		}
	}
	
	public void printAllMembers() {
		System.out.println("===== 전체 회원 출력 =====");
		System.out.println("등급\t이름\t포인트\t보너스");
		System.out.println("----------------------");
		for(int i = 0; i< sIndex; i++) {
			Sliver s = sMembers[i];
			System.out.println(s.getGrade()+"\t"+s.getName()+"\t"+ s.getPoint()+"\t"+ s.getBonus());
		}
		for(int i = 0; i<gIndex; i++) {
			Gold g = gMembers[i];
			System.out.println(g.getGrade() + "\t" + g.getName() + "\t" + g.getPoint() + "\t" + g.getBonus());
		}
		for(int i = 0; i<vIndex; i++) {
			Vip v = vMembers[i];
			System.out.println(v.getGrade() + "\t" + v.getName() + "\t" + v.getPoint() + "\t" + v.getBonus());
		}
		for(int i = 0; i<vvIndex; i++) {
			Vvip vv = vvMembers[i];
			System.out.println(vv.getGrade() + "\t" + vv.getName() + "\t" + vv.getPoint() + "\t" + vv.getBonus());
		}
	}
	
	
	
	public int[] searchMembers(String name) {
		int result[] = new int[2]; 
		for(int i = 0; i< sIndex; i++) {
			if(name.equals(sMembers[i].getName())) {
				result[0] = 1;
				result[1] = i;
				return result;
			}
		}
		for(int i = 0; i< gIndex; i++) {
			Gold g = gMembers[i];
			if(name.equals(g.getName())) {
				result[0] = 2;
				result[1] = i;
				return result;
			}
		}
		for(int i = 0; i< vIndex; i++) {
			Vip v = vMembers[i];
			if(name.equals(v.getName())) {
				result[0] = 3;
				result[1] = i;
				return result;
			}
		}
		for(int i = 0; i< vvIndex; i++) {
			Vvip vv = vvMembers[i];
			if(name.equals(vv.getName())) {
				result[0] = 4;
				result[1] = i;
				return result;
			}
		}
		return result;
	}
	
	
	
	public void printOneMembers() {
		System.out.println("===== 회원 정보 출력 =====");
		System.out.print("조회할 회원 이름 입력 : ");
		String name = sc.next();
		int[] result = searchMembers(name);
		if(result[0]== 0) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else if(result[0]==1){
			Sliver s = sMembers[result[1]];
			System.out.println("등급 : " + s.getGrade());
			System.out.println("이름 : " + s.getName());
			System.out.println("포인트 : " + s.getPoint());
			System.out.println("보너스 : " + s.getBonus());
		}else if(result[0]==2) {
			Gold g = gMembers[result[1]];
			System.out.println("등급 : " + g.getGrade());
			System.out.println("이름 : " + g.getName());
			System.out.println("포인트 : " + g.getPoint());
			System.out.println("보너스 : " + g.getBonus());
		}else if(result[0]==3) {
			Vip v = vMembers[result[1]];
			System.out.println("등급 : " + v.getGrade());
			System.out.println("이름 : " + v.getName());
			System.out.println("포인트 : " + v.getPoint());
			System.out.println("보너스 : " + v.getBonus());
		}else if(result[0]==4) {
			Vvip vv = vvMembers[result[1]];
			System.out.println("등급 : " + vv.getGrade());
			System.out.println("이름 : " + vv.getName());
			System.out.println("포인트 : " + vv.getPoint());
			System.out.println("보너스 : " + vv.getBonus());
		}
	}
	
	
	
	public void updateMembers() {
		System.out.println("===== 회원 정보 수정 =====");
		System.out.print("수정할 회원의 이름을 입력하세요 : ");
		String name = sc.next();
		int[] result = searchMembers(name);
		if(result[0]==0) {
			System.out.println("회원 정보를 찾을수 없습니다");
		}else {
			if(result[0]==1) {
				for(int i =result[1]; i<sIndex-1; i++) {
					sMembers[i] = sMembers[i+1];
				}
				sIndex--;
			}else if(result[0]==2) {
				for(int i=result[1]; i<gIndex-1; i++) {
					gMembers[i] = gMembers[i+1];
				}
				gIndex--;
			}else if(result[0]==3) {
				for(int i=result[1]; i<vIndex-1; i++) {
					vMembers[i] = vMembers[i+1];
				}
				vIndex--;
			}else if(result[0]==4) {
				for(int i=result[1]; i<vvIndex-1; i++) {
					vvMembers[i] = vvMembers[i+1];
				}
				vvIndex--;
			}
		
		System.out.print("수정할 회원 등급 입력 : ");
		String grade = sc.next();
		System.out.print("수정할 회원 이름 입력 : ");
		String updateName = sc.next();
		System.out.print("수정할 회원 포인트 입력 : ");
		int point = sc.nextInt();
		switch(grade) {
		case "sliver" :
			sMembers[sIndex++] = new Sliver(grade, updateName, point);;
			break;
		case "gold" :
			gMembers[gIndex++] = new Gold(grade, updateName, point);
			break;
		case "vip" :
			vMembers[vIndex++] = new Vip(grade, updateName, point);
			break;
		case "vvip" :
			vvMembers[vvIndex++] = new Vvip(grade, updateName, point);
			break;
		}
		System.out.println("회원 수정완료 ");
	}
}
	
	public void deleteMember() {
		System.out.println("===== 회원 정보 삭제 =====");
		System.out.print("삭제할 회원의 이름을 입력하세요 : ");
		String name = sc.next();
		int result[] = searchMembers(name);
		if(result[0]==0) {
			System.out.println("회원의 정보를 찾을 수 없습니다.");
		}else {
			if(result[0]==1) {
				for(int i =result[1]; i<sIndex; i++) {
					sMembers[i] = sMembers[i+1];
				}
				sIndex--;
			}else if(result[0]==2){
				for(int i =result[1]; i<gIndex; i++) {
					gMembers[i] = gMembers[i+1];
				}
				gIndex--;
			}else if(result[0]==3) {
				for(int i =result[1]; i<vIndex; i++) {
					vMembers[i] = vMembers[i+1];
				}
				vIndex--;
			}else if(result[0]==4) {
				for(int i = result[1]; i<vvIndex; i++) {
					vvMembers[i] = vvMembers[i+1];
				}
				vvIndex--;
			}
		}System.out.println("삭제완료 !");
	}
}
