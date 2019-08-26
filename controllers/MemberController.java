package com.bitcamp.controllers;

import javax.swing.JOptionPane;

import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;

public class MemberController {

	public static void main(String[] args) {

		MemberService service = new MemberService();
		MemberBean member =null;
		String [] arr = null;

		while (true) {

			switch (JOptionPane.showInputDialog(
					"0.종료"
							+ "\n-------사용자 기능 ---------\n"
							+ "01.회원가입 \n "
							+ "02. 마이페이지 \n  "
							+ "03. 비번수정 \n  "
							+ "04. 회원탈퇴 \n "
							+ "05.아이디체크  \n"
							+ "06.로그인  \n"
							+ "-------관리자기능 ---------\n "
							+ "11.회원목록  \n "
							+ "12. 아이디검색\n"
							+ "13. 이름검색\n"
							+ "14. 전체 회원수 \n")) {
							case "0":
								JOptionPane.showMessageDialog(null, "종료");
								return;

							case "01": 
								JOptionPane.showMessageDialog(null, "01.회원가입"); 
								arr = (JOptionPane.showInputDialog("이름, 아이디, 비번, 주민번호, 혈액형, 키, 몸무게")).split(",");
								member = new MemberBean();
								member.setUserName(arr[0]);
								member.setUserId(arr[1]);
								member.setUserPW(arr[2]); 
								member.setUserBD(arr[3]);
								member.setUserBT(arr[4]);
								member.setHeight(Double.parseDouble(arr[5]));
								member.setWeight(Double.parseDouble(arr[6]));
	
								JOptionPane.showMessageDialog(null, service.join(member));
	
								break;

							case "02": 
								JOptionPane.showMessageDialog(null, "02. 마이페이지");
								JOptionPane.showMessageDialog(null,service.getMypage(JOptionPane.showInputDialog("회원번호를 입력하세요")));
	
								break; 

							case "03": 
								JOptionPane.showMessageDialog(null, "03. 비번수정");
								arr = (JOptionPane.showInputDialog(" 아이디, 기존 비번 , 변경할 비번을 입력하세요")).split(",");
								MemberBean[] memberBeans = new MemberBean[2]; 
								MemberBean newMember = new MemberBean(); 
								member = new MemberBean();
								member.setUserId(arr[0]); 
								member.setUserPW(arr[1]);
								newMember.setUserPW(arr[2]);
	
								memberBeans[0] = member; 
								memberBeans[1] = newMember;
	
								JOptionPane.showMessageDialog(null, service.update(memberBeans));
	
								break; 

							case "04": 
								JOptionPane.showMessageDialog(null, "04. 회원탈퇴"); 
								arr = (JOptionPane.showInputDialog(" 아이디, 비번을 입력하세요")).split(",");
								member = new MemberBean(); 
								member.setUserId(arr[0]); 
								member.setUserPW(arr[1]);

								JOptionPane.showMessageDialog(null, service.withdrawal(member));

								break; 
							case "05": 
								JOptionPane.showMessageDialog(null, "05.아이디체크");
								JOptionPane.showMessageDialog(null, service.existId(JOptionPane.showInputDialog("아이디를 입력하세요")));

								break; 
							
							case "06": 
								JOptionPane.showMessageDialog(null, "06.로그인"); 
								arr = (JOptionPane.showInputDialog(" 아이디, 비번을 입력하세요")).split(","); 
								member = new MemberBean(); 
								member.setUserId(arr[0]); 
								member.setUserPW(arr[1]);

								JOptionPane.showMessageDialog(null, service.login(member));

							break;

							case "11":
								JOptionPane.showMessageDialog(null, "11.회원목록");
								JOptionPane.showMessageDialog(null, service.list());

								break;
							case "12":
								JOptionPane.showMessageDialog(null, "12. 아이디검색");
								JOptionPane.showMessageDialog(null, service.findById(JOptionPane.showInputDialog("아이디를 입력하세요")));
								break;
							case "13":
								JOptionPane.showMessageDialog(null, "13. 이름검색");
								MemberBean[] memberarr = service.findByName(JOptionPane.showInputDialog("이름을 입력하세요"));
								JOptionPane.showMessageDialog(null, memberarr);
								break;
							case "14":
								JOptionPane.showMessageDialog(null, "14. 전체 회원수");

								JOptionPane.showMessageDialog(null, service.countAll());
								break;

			}//switch
		}//while
	}

}
