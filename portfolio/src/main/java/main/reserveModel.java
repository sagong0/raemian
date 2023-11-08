package main;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import portfolio.SearchDTO;

@Repository("reserveM")
public class reserveModel {

	@Resource(name = "sqlsession2")
	private SqlSessionTemplate sessionTemplate;
	
	PrintWriter pw = null;
	HttpSession httpSession;
	
	String msg = "";
	
	public void insert_reserve(ReserveDto rdto,HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8;");
		
		this.pw = res.getWriter();
		if(rdto == null) {			
			this.msg="<script>"
					+ "alert('예약 정보를 확인해주세요.');"
					+ "history.go(-1);"
					+ "</script>";
		}
		else {
			//System.out.println(rdto);
			int oksign = this.sessionTemplate.insert("mainPageDB.insertReserve",rdto);
			if(oksign > 0) {
				this.msg = "<script>"
						+ "alert('성공적으로 예약 되었습니다.');"
						+ "location.href='./mainPage.do';"
						+ "</script>";
			}
			else {
				this.msg = "<script>"
						+ "alert('네트워크 오류로 인하여 예약에 실패하였습니다.');"
						+ "history.go(-1);"
						+ "</script>";
			}
		}
		this.pw.write(this.msg);
		this.pw.close();
	}


	/* 로그인 유저 기반 예약 확인 */
	public ReserveDto ckReserve(HttpServletRequest req,HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8;");
		
		this.httpSession = req.getSession();
		String userId = "";
		
		MemberDto mdto = (MemberDto) this.httpSession.getAttribute("mdto");
		
		this.pw = res.getWriter();
		// 로그인한 세션이 만료되거나 null일때
		if(mdto == null) {
			this.pw.write("<script>"
					+ "alert('세션이 만료되었습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		else {
			userId = mdto.getMid();
			ReserveDto rdtos = this.sessionTemplate.selectOne("mainPageDB.ckReserve",userId);
			
			// 해당하는 예약 정보 출력.
			// 로그인 유저의 예약 정보 없을 경우.
			if(rdtos == null) {
				this.pw.write("<script>"
						+ "alert('예약된 내용이 없습니다.');"
						+ "location.href='./reservation_in.do';"
						+ "</script>");
			}
			else {
				return rdtos;
			}
		}		
		this.pw.close();
		return null;
	}
	
	/* 예약 수정 */
	public void modify_reserve(ReserveDto rdto,HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8;");
		this.pw = res.getWriter();
		
		System.out.println("chk dardsafasdfdsa");
		System.out.println(rdto);
		
		// 예약 정보 업데이트.
		int result = this.sessionTemplate.update("mainPageDB.update_reserve",rdto);
		
		if(result > 0) {
			// 횟수 차감
			int sign = this.sessionTemplate.update("mainPageDB.set_chance",rdto.getRidx());

			// 횟수까지 차감 완료시
			if(sign > 0) {
				this.msg = "<script>"
						+ "alert('정상적으로 수정 되었습니다.');"
						+ "location.href='./reservation_ck.do';"
						+ "</script>";				
			}
			else {
				this.msg = "<script>"
						+ "alert('네트워크 오류로 인하여 수정에 실패하였습니다.');"
						+ "history.go(-1);"
						+ "</script>";
			}
		}
		else {
			this.msg = "<script>"
					+ "alert('네트워크 오류로 인하여 수정에 실패하였습니다.');"
					+ "history.go(-1);"
					+ "</script>";
		}
		this.pw.write(this.msg);
		this.pw.close();
	}
	
	/*예약 취소 page 처음 로드 */
	public ReserveDto cancel_ck(ReserveDto rdto,HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8;");
		
		this.pw = res.getWriter();
		if(rdto == null) {
			this.pw.write("<script>"
					+ "alert('예약 후 사용 가능한 기능입니다.');"
					+ "location.href='./login.do';"
					+ "</script>");
		}
		else {
			return rdto;
		}
		this.pw.close();
		
		return null;
	}
	
	/* 예약 삭제 ajax return값*/
	public String del_reserve(String ridx) throws Exception {
		
		// ridx는 null 값 아님 무조건 (앞에서 조건 필터링함)
		int result = this.sessionTemplate.delete("mainPageDB.del_reserve",ridx);
		
		//this.pw = res.getWriter();
		
		if(result > 0) {
			return "success";
		}
		else {
			return "fail";
		}
	}
	
	/* 관리자page 예약현황 */
	public List<ReserveDto> getReserves(SearchDTO sdto) {
		
		List<ReserveDto> rdtos = null;
		Map<String, Object> maps = new HashMap<String, Object>();
		
		if(sdto.getSearch_type() == null || sdto.getSearch_val() == null) {
			maps = null;
		}
		else {
			if(sdto.getSearch_type().intern() == "아이디") {
				maps.put("part", "byId");				
			}
			else if(sdto.getSearch_type().intern() == "이름") {
				maps.put("part", "byName");				
			}
			else if(sdto.getSearch_type().intern() == "연락처") {
				maps.put("part", "byTel");				
			}
			maps.put("searchVal", sdto.getSearch_val());
		}
		rdtos = this.sessionTemplate.selectList("mainPageDB.getReserves", maps);			
		
		return rdtos;
	}
	
	
	/* 오늘 예약건 출력 */
	public List<ReserveDto> getTodayReserves(){
		
		Date dt = new Date();
		DateFormat df = new SimpleDateFormat("MM-");
		String dates = df.format(dt);
		
		Map<String,Object> dtMap = new HashMap<String, Object>();
		dtMap.put("part", "getToday");
		dtMap.put("dates", dates.trim());
		
		List<ReserveDto> rdtos = this.sessionTemplate.selectList("mainPageDB.getReserves",dtMap);
		
		return rdtos;
	}
	
	
	
	
	
}










