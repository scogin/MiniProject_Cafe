﻿package _0522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * 1차메뉴 (매장,메뉴,고객,직원관리)와 2차 메뉴(매장관리>매장정보, 매출정보, 재고관리) 는 인터페이스로 관리
 * 3차메뉴 (매장정보>기본정보, 수정, 수입확인, 지출확인)는 scripts 클래스 내의 메소드로 관리합니다
 * 
 */

// 유저에게 보여줄 메뉴 인터페이스(1차, 2차 메뉴)
interface MainMenu {
	int STORE = 1, MENU = 2, CUSTOMER = 3, STAFF = 4;
}

interface StoreMenu {

}

interface menuMenu {

}

interface customerMenu {

}

interface staffMenu {

}

public class Scripts {
	Socket socket;
	BufferedReader br;
	PrintWriter pw;
	Pos_controller posControl;
	Scripts(Socket socket){
		this.socket = socket;
		try {
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.posControl = Pos_controller.getPosInstance();
	}
	
	// 유저에게 메세지 보내는 용도의 pw 메서드
	public void send(String msg) {
		pw.println(msg);
		pw.flush();
	}
	// 유저에게서 선택 받아오는 용도의 br 메서드
	// Scanner 대신 쓰세요!
	public String receive() {
		String line = null;
		try {
			if((line=br.readLine())!=null)
				return line;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("유저의 입력을 받아오지 못했습니다");
		}
		return null;
	}
	
	
	// 최초 프로그램 실행시 로그인 기능
	// 메서드 완성할 떄의 예시로 봐주세요
	public void logIn() {
		//유저에게 메세지를 전달하고 유저의 입력을 받는다
		send("카페관리 프로그램을 시작합니다");
		send("아이디를 입력하세요");
		String id = receive();
		send("아이디를 입력하세요");
		String password = receive();
		//유저의 입력을 controller 소속의 적절한 메소드로 넘긴다
		posControl.checkLogin(id, password);
		
		
	}
	
	public void logInSuccess() {
		send("로그인에 성공하였습니다");
		// 원래라면 controller의 메서드를 호출해야하나
		// 편의를 위해 view 메서드 -> view 메서드 의 이동은 scripts 클래스내에서
		// 직접적으로 이루어지도록 하겠습니다
		mainMenu();
		
		
	}
	public void logInFailTypeId() {
		send("id가 없습니다");
		// 실패시 첫화면으로 돌아간다
		
	}
	public void logInFailTypePassword() {
		send("password가 일치하지 않습니다");
		// 실패시 첫화면으로 돌아간다
	}
	
	
	// 유저에게서 메인메뉴를 보여주고 선택받는다
	public void mainMenu() {

	}

	// 유저에게서 매장관리 메뉴를 보여주고 선택받는다
	public void storeMenu() {

	}

	// 유저에게서 메뉴관리 메뉴를 보여주고 선택받는다
	public void menuMenu() {

	}

	// 유저에게서 고객관리 메뉴를 보여주고 선택받는다
	public void customerMenu() {

	}

	// 유저에게서 직원관리 메뉴를 보여주고 선택받는다
	public void staffMenu() {

	}

	// -----------------------------
	// -----------------------------여기부터 3차메뉴 관리
	// 매장관리>매장정보 내부 메뉴
	public void storeInfoDefault() {

	}

	public void storeInfoMotify() {

	}

	public void checkIncome() {

	}

	public void checkOutcome() {

	}

	// 매장관리>매출정보 내부 메뉴
	public void salesInfoDefault() {

	}

	public void salesSearchTimes() {

	}

	public void salesSearchMenus() {

	}

	// 매장관리>재고관리 내부 메뉴
	public void stockNow() {

	}

	public void stockManage() {

	}

	// 메뉴관리>메뉴정보 내부 메뉴
	public void menuInfoDefault() {

	}
	public void menuModify() {
		
	}
	public void menuDelete() {
		
	}
	public void menuOnOff() {
		
	}

	// 메뉴검색>메뉴검색 내부 메뉴
	public void searchMenuName() {

	}
	public void searchMenuCategory() {

	}
	// 고객관리>회원정보 내부 메뉴
	public void showMembers() {
		
	}
	public void searchMember() {
		
	}
	public void showMemberDetail() {
		
	}
	// 고객관리>회원정보>정보보기 내부 메뉴
	public void showMemberDetailModify() {
		
	}
	public void showMemberDetailDelete() {
		
	}
	// 고객관리>고객구매이력 내부 메뉴
	public void lastBuyingRecord() {
		
	}
	public void MostBuyingRecord() {
		
	}
	// 직원관리>직원정보 내부 메뉴
	public void staffInfoDefault() {
		
	}
	public void staffInfoModify() {
		
	}
	public void staffInfoDelete() {
		
	}
	// 직원관리>급여관리 내부 메뉴
	public void staffSalaryManage() {
		
	}



}