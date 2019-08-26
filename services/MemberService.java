package com.bitcamp.services;

import com.bitcamp.domains.MemberBean;
/*
1. 회원가입
2. 마이페이지
3. 비번수정
4. 회원탈퇴
5.아이디 존재체크
6.로그인

<관리자기능>
1.회원목록
2. 아이디검색
3. 이름검색
4. 천체 회원수
 */

public class MemberService {

	private MemberBean[] members;
	private int count;

	public MemberService() {
		members = new MemberBean[10];
		count =0;
	}

	/*****************************************************************
		사용자기능
	 ******************************************************************/

	/*
	01. 회원가입
	 */
	public String join(MemberBean member) {
		String msg="회원가입에 성공하였습니다. ";
		members[count] = member;
		count++;
		return msg;
	}

	/*
	02. 마이페이지
	 */
	public String getMypage(String number) {
		int num = Integer.parseInt(number);
		String msg=String.format("회원정보 \n"
				+ "=====================\n"
				+ "이름 : %s \n"
				+ "아이디 : %s \n"
				+ "비번 : %s \n"
				+ "주민번호 : %s \n"
				+ "혈액형 : %s \n"
				+ "키 : %.2f \n"
				+ "몸무게 : %.2f \n", members[num].getUserName(), members[num].getUserId() ,
				members[num].getUserPW() , members[num].getUserBD() , 
				members[num].getUserBT(), members[num].getHeight() , members[num].getWeight() );

		return msg;
	}
	/*
	03. 비번 변경 옛날 비번, 신규 비번을 입력받아서 , 옛날 비번을 체크 후 일치하면 신규 비번으로 변경
		비번 변경 후 로그인을 진행해서 새로 바뀐 비번이 로그인 성공, 옛날 비번은 로그인 실패. 
	 */
	public String  update(MemberBean[] memberBeans) {
		String result = "비밀번호 변경에 실패하였습니다. " ;

		String userId = memberBeans[0].getUserId();
		String oldPW = memberBeans[0].getUserPW();
		String newPW = memberBeans[1].getUserPW();

		for (int i = 0; i < count; i++) {
			if(userId.equals(members[i].getUserId()) && oldPW.equals(members[i].getUserPW()) ) {
				System.out.println(newPW);

				members[i].setUserPW(newPW); 
				System.out.println(members[i].getUserPW());

				result = "비밀번호 변경에 성공하였습니다. " ;
				break;
			}
		}

		return result;
	}

	/*
	04. 회원 탈퇴 
	 */
	public String withdrawal(MemberBean member) {
		String result="회원탈퇴실패";
		String userId = member.getUserId();
		String userPw = member.getUserPW();


		for (int i = 0; i < count; i++) {
			if(userId.equals(members[i].getUserId())){
				if(userPw.equals(members[i].getUserPW())) {
					//회원 탈퇴 프로세스 진행 	
					members[i] = null;
					for (int j = i; j < count; j++) {
						members[j] = members[j+1];
					}
					members[members.length-1] = null;
					count-- ;

					result = "회원탈퇴 성공";
					break;
				}
				result = "비밀번호가 틀립니다.";
				break;
			}
			result = "없는 아이디 입니다.";
		}
		return result;

	}

	/*
		05. 아이디 체크
	 */

	public String existId(String id) {
		String result="사용 가능한 아이디 입니다.";

		for (int i = 0; i < count; i++) {
			if(id.equals(members[i].getUserId())) {
				result = "이미 존재하는 아이디 입니다.";

				break;
			}
		}
		return result;
	}

	/*	
		06. 로그인 (파라미터로 ID, PW만 입력받은 상태)
	 */	

	public String login(MemberBean param) {
		String result="로그인실패";
		String userId = param.getUserId();
		String userPw = param.getUserPW();


		for (int i = 0; i < count; i++) {
			if(userId.equals(members[i].getUserId())){
				if(userPw.equals(members[i].getUserPW())) {
					result = "로그인성공";

					break;
				}
				result = "비밀번호가 틀립니다.";
				break;
			}
			result = "없는 아이디 입니다.";
		}
		return result;
	}

	/*****************************************************************
			관리자기능
	 ******************************************************************/
	/*
	11. 회원목록
	 */
	public String list() {
		String msg="";
		for (int i = 0; i < count; i++) {
			msg += members[i].toString()+"\n\n\n ";
		}

		return msg;
	}

	/*
	12. 아이디 검색
	 */
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();

		for (int i = 0; i < count; i++) {
			if(id.equals(members[i].getUserId())) {
				member = members[i];
			}
		}

		return member;
	}
	/*
	13. 이름 검색
	 */

	public MemberBean[] findByName(String name) {

		int cnt=0;

		for (int i = 0; i < count ; i++) {
			if(name.equals(members[i].getUserName())) {
				cnt++;
			}
		}

		MemberBean[] memberArr = new MemberBean[cnt];
		cnt =0;
		for (int i = 0; i < count; i++) {
			if(name.equals(members[i].getUserName())) {
				memberArr[cnt] = members[i];
				if(memberArr.length == cnt) {
					break;
				}
				cnt++;
			}
		}
		return memberArr;
	}
	/*
	14. 총 회원수
	 */

	public String countAll() {
		return "총 회원수 : "+count;
	}


}
