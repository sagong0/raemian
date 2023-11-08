package portfolio;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("admin_membership")
public class ad_membershipModule {
	
	@Resource(name = "sqlsession")
	private SqlSessionTemplate sessionTemplate;
	
	PrintWriter pw = null;
	String msg = "";
	
	/*관리자 회원가입 정보 저장*/
	public void admin_join(admin_dto adto,HttpServletResponse res) throws Exception {
		this.pw = res.getWriter();
		
		int result = this.sessionTemplate.insert("DB.admin_insert",adto);
		
		if(result == 1) {
			msg = "<script>"
					+ "alert('관리자 등록이 완료되었습니다.');"
					+ "location.href='./index.jsp';"
					+ "</script>";
		}
		else {
			msg = "<script>"
					+ "alert('관리자 등록에 실패 하였습니다.');"
					+ "history.go(-1);"
					+ "</script>";
		}
		this.pw.write(msg);
		this.pw.close();
	}
	
	
	/* 아이디 중복체크 */
	public admin_dto idcheck(String id) {
		admin_dto adto = this.sessionTemplate.selectOne("DB.ad_idck",id);
		
		return adto;
	}
	
	/* 아이디 존재 유/무 확인 */
	public void isUser(String aid, String apw,HttpServletResponse res,HttpServletRequest request) throws Exception {
		HttpSession httpSession = null;
		
		this.pw = res.getWriter();
		String msg = "";
		String canuse = "";
		
		admin_dto adto = this.sessionTemplate.selectOne("DB.ad_idck",aid);
		if(adto == null) {
			// 아이디부터 틀리면 여기로.
			msg = "<script>"
					+ "alert('해당 정보를 확인할 수 없습니다.');"
					+ "history.go(-1);"
					+ "</script>";
		}
		// 일단 아이디맞고
		else {
			/* 비밀번호 체크
			 * aid랑 password(apw) 두개 where 조건. => 해당 
			 * */
			Map<String, Object> maps = new HashMap<String, Object>();
			maps.put("id", aid);
			maps.put("pw", apw);
			admin_dto adto2 = this.sessionTemplate.selectOne("DB.ad_pwck",maps);
			
			
			//trycount update 전용 map
			Map<String, Object> tryMap = new HashMap<String, Object>();
			// 비밀번호가 틀렸을 때
			if(adto2 == null) {
				String id = adto.getAid();
				tryMap.put("part", "upTryCount");
				tryMap.put("id", id);
				
				this.sessionTemplate.update("DB.upTryCount",tryMap);
				
				msg = "<script>"
						+ "alert('비밀번호가 틀렸습니다..');"
						+ "history.go(-1);"
						+ "</script>";
								
				int count = adto.getTry_count();
				if(count>=4) {
					this.sessionTemplate.update("DB.setUse",id);
				};
			}
			else {
				/* 여기서 ause 가 N이면 차단됬다는 메세지*/
				canuse = adto.getAuse();
				if(canuse.intern() =="N") {
					msg = "<script>"
							+ "alert('해당 아이디는 차단되었습니다. 관리자에게 문의하십시오.');"
							+ "history.go(-1);"
							+ "</script>";
				}
				else {
					// login 완료시 try count 0으로 set해줘야
					tryMap.put("part", "setZeroTry");
					tryMap.put("id", adto2.getAid());
					this.sessionTemplate.update("DB.upTryCount",tryMap);
					
					msg = "<script>"
							+ "alert('로그인 되셨습니다.');"
							+ "location.href='./admin_main.do';"
							+ "</script>";
					httpSession = request.getSession();
					httpSession.setAttribute("name", adto2.getAname());
				}
				
			}
		}
		this.pw.write(msg);
		this.pw.close();
	}

	/* 관리자 전체 리스트 출력 */
	public List<admin_dto> getAllAdmin(int no){
		List<admin_dto> lists = null;
		
		lists = this.sessionTemplate.selectList("DB.getAdminAll",no);
		
		return lists;
	}
	
	
	/* 지역 관리자 리스트 출력. (AJAX 통신) */
	public List<admin_dto> getAdminByArea(String area){
		List<admin_dto> lists = null;
		
		lists = this.sessionTemplate.selectList("DB.getAdminByArea",area);
		
		return lists;
	}

	/* 근무중/퇴직중 업데이트  */
	public int updateStatus(StatusDto statusDto) {
		int result = 0;
		if(statusDto.getStatus().intern()=="근무중") {
			result = this.sessionTemplate.update("DB.updateStatusY",statusDto.getAidx());
		}
		else if(statusDto.getStatus().intern()=="퇴직중") {
			result = this.sessionTemplate.update("DB.updateStatusN",statusDto.getAidx());
		}
		System.out.println("result : "+result);
		return result;
	}

	/* 검색어 통한 관리자 리스트 출력 */
	public Map<String, Object> getAdminBySearch(SearchDTO searchdto){
		List<admin_dto> lists = null;
		
		if(searchdto.search_type.intern() =="아이디") {
			lists = this.sessionTemplate.selectList("DB.getAdminByID", searchdto.search_val);
		}
		else if(searchdto.search_type.intern() =="연락처") {
			lists = this.sessionTemplate.selectList("DB.getAdminByTell", searchdto.search_val);
		}
		else if(searchdto.search_type.intern() =="이름") {
			lists = this.sessionTemplate.selectList("DB.getAdminByName", searchdto.search_val);
		}
		
		Map<String, Object> searchdata = new HashMap<String, Object>();
		searchdata.put("searchType", searchdto.search_type);
		searchdata.put("lists", lists);
		return searchdata;
	}

	/*관리자 전체 COUNT*/
	public int countAdmin() {
		int ct = this.sessionTemplate.selectOne("DB.countAllAdmin");
		return ct;
	}
	
	/* 관리자 소속 count */
	public int countAdminByArea(String aarea) {
		int ct = this.sessionTemplate.selectOne("DB.countAdminByArea",aarea);
		return ct;
	}
	/*검색필터링된 관리자 COUNT*/
	public int countAdminBySearch(SearchDTO sdto) {
		Map<String, Object> mapList = new HashMap<String, Object>();
		
		if(sdto.getSearch_type().intern() =="이름") {
			mapList.put("part", "name");
		}
		else if(sdto.getSearch_type().intern() =="연락처") {
			mapList.put("part", "tell");
		}
		else if(sdto.getSearch_type().intern() =="아이디") {
			mapList.put("part", "id");
		}
		mapList.put("data", sdto.getSearch_val());
		int ct = this.sessionTemplate.selectOne("DB.countAdminBySearch",mapList);
		return ct;
	}
	
	/*전체 버튼 클릭시 */
}








