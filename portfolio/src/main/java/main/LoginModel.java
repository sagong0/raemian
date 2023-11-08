package main;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import portfolio.SearchDTO;

@Repository("loginM")
public class LoginModel {
	
	PrintWriter pw = null;	
	String msg = "";
	HttpSession session = null;
	
	@Resource(name="sqlsession2")
	private SqlSessionTemplate sessionTemplate;
	
	/* 아이디 중복체크 AJAX */
	public MemberDto id_check(String id) {
		
		MemberDto ldto = this.sessionTemplate.selectOne("mainPageDB.getIdck",id);
		return ldto;
	}
	
	/*회원가입 저장*/
	public void join_member(MemberDto mdto,HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8;");
		
		if(mdto.getCkemail() == null) {
			mdto.setCkemail("N");
		}
		if(mdto.getCktel() == null) {
			mdto.setCktel("N");
		}
		if(mdto.getCkaddr() == null) {
			mdto.setCkaddr("N");
		}
		if(mdto.getCksms() == null) {
			mdto.setCksms("N");
		}
		System.out.println("check hre");
		System.out.println(mdto);
		int result = this.sessionTemplate.insert("mainPageDB.insertMember",mdto);
		this.pw = res.getWriter();
		if(result > 0) {
			this.msg = "<script>"
					+ "alert('정상적으로 회원가입이 완료되었습니다.');"
					+ "location.href='./login.do';"
					+ "</script>";
		}
		else {
			this.msg = "<script>"
					+ "alert('회원가입에 오류가 발생하였습니다.');"
					+ "history.go(-1);"
					+ "</script>";
		}
		this.pw.write(this.msg);
		this.pw.close();
	}

	/* 유저(Login) 확인 */
	public MemberDto userCheck(MemberDto mdto, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8;");
		
		this.pw = res.getWriter();
		
		Map<String, Object> userMap = new HashMap<String, Object>();
		
		MemberDto mlist2 = null;
		
		if(mdto.getMid().isEmpty() || mdto.getMid() == null || mdto.getMpw().isEmpty() || mdto.getMpw() == null) {
			this.msg = "<script>"
					+ "alert('정상적인 접근 방법이 아닙니다.');"
					+ "history.go(-1);"
					+ "</script>";
		}
		else {
			userMap.put("part", "idck");
			userMap.put("userid", mdto.getMid());
			//일단 아이디 맞는지 체크
			MemberDto mlist = this.sessionTemplate.selectOne("mainPageDB.checkUser",userMap);
			// 아이디 부터 틀리면
			if(mlist == null) {
				this.msg = "<script>"
						+ "alert('해당 사용자 정보를 확인 할 수 없습니다.');"
						+ "history.go(-1);"
						+ "</script>"; 
			}
			// 일단 아이디 맞음.
			else {
				// 이제 비밀번호 체크
				userMap.put("part", "idpwck");
				userMap.put("id", mdto.getMid());
				userMap.put("pass", mdto.getMpw());
				mlist2 =this.sessionTemplate.selectOne("mainPageDB.checkUser", userMap);
				
				// 비번틀리면
				if(mlist2 == null) {
					this.msg = "<script>"
							+ "alert('올바른 정보를 확인해주시길 바랍니다.');"
							+ "history.go(-1);"
							+ "</script>";
				}
				// 비번까지 맞음
				else {
					this.msg = "<script>"
							+ "alert('로그인 되셨습니다.');"
							+ "location.href='./mainPage.do';"
							+ "</script>";
				}
			}
		}
		System.out.println("여기는안옴?");
		this.pw.write(this.msg);
		this.pw.close();
		
		return mlist2;
	}
	
	/* 유저 로그아웃 */ 
	public String userLogOut(HttpServletRequest req) {
		this.session = req.getSession();
		this.session.invalidate();
		
		return "redirect:/main/mainPage.do";
	}

	
	
	/*회원 리스트 관리자 페이지에 출력*/
	public List<MemberDto> getUsers(SearchDTO sdto, int page){
		List<MemberDto> users = null;
		
		Map<String, Object> smap = new HashMap<String, Object>();
		
		
		if(sdto.getSearch_type() == null || sdto.getSearch_val() == null) {			
			smap.put("page", page);
		}
		else if(sdto.getSearch_type().intern() == "아이디") {
			smap.put("part", "id");
			smap.put("searchVal", sdto.getSearch_val());
			smap.put("page", page);
		}
		else if(sdto.getSearch_type().intern() == "이름") {
			smap.put("part", "name");
			smap.put("searchVal", sdto.getSearch_val());
			smap.put("page", page);
		}
		else if(sdto.getSearch_type().intern() == "연락처") {
			smap.put("part", "tel");
			smap.put("searchVal", sdto.getSearch_val());
			smap.put("page", page);
		}		
		users = this.sessionTemplate.selectList("mainPageDB.getUsers", smap);
		return users;
	}
	
	/* 회원 리스트 카운트 */
	public int countUsers(SearchDTO sdto) {
		
		int ea = 0;
		Map<String, Object> cmap = new HashMap<String, Object>();
		
		if(sdto.getSearch_type() == null || sdto.getSearch_val() == null) {
			cmap = null;
		}
		else if(sdto.getSearch_type().intern() == "아이디") {
			cmap.put("part", "id");
			cmap.put("searchVal", sdto.getSearch_val());
		}
		else if(sdto.getSearch_type().intern() == "이름") {
			System.out.println("이름 검색 됨");
			cmap.put("part","name");
			cmap.put("searchVal", sdto.getSearch_val());
		}
		else if(sdto.getSearch_type().intern() == "연락처") {
			cmap.put("part", "tel");
			cmap.put("searchVal", sdto.getSearch_val());
		}
		
		ea = this.sessionTemplate.selectOne("mainPageDB.countUsers",cmap);
		return ea;
	}
	
	
	/* 삭제 버튼 PART */
	public int deleteUser(int idx,HttpServletResponse res) {
		res.setContentType("text/html; charset=utf-8;");
		int result = 0;
		try {
			this.pw = res.getWriter();
			result = this.sessionTemplate.delete("mainPageDB.delUser",idx);
			
			if(result > 0) {
				this.msg = "<script>"
						+ "alert('정상적으로 삭제 되었습니다.')"
						+ ";location.href='./member_main.do';"
						+ "</script>";
			}
			else {
				this.msg = "<script>"
						+ "alert('네트워크 오류로 인하여 삭제에 실패하였습니다.');"
						+ "history.go(-1);"
						+ "</script>";
			}
			this.pw.write(this.msg);
			this.pw.close();
		} 
		catch (Exception e) {
			System.out.println("유저 삭제 쿼리 PART ERR");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/*관리자 메인 일반 회원 (당일기준) 출력 PART*/
	public List<MemberDto> getTodayUsers(){
		
		Date dt = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dates = df.format(dt);
		
		Map<String, Object> dateMap = new HashMap<String, Object>();
		dateMap.put("part", "getdates");
		dateMap.put("dates", dates);
		
		List<MemberDto> mdto = this.sessionTemplate.selectList("mainPageDB.getTodayUsers",dateMap);
		return mdto;
	}
	
	public MemberDto getReserve(HttpServletRequest req,HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8;");
		
		this.session = req.getSession();
		this.pw = res.getWriter();
		
		MemberDto mdto = (MemberDto) this.session.getAttribute("mdto");
		
		if(mdto != null) {
			ReserveDto rdto = (ReserveDto) this.sessionTemplate.selectOne("mainPageDB.ckReserve",mdto.getMid());
			if(rdto != null) {
				this.pw.write("<script>"
						+ "alert('해당 계정은 이미 예약 내역이 존재합니다.');"
						+ "history.go(-1);"
						+ "</script>"); 
			}
			else {
				return mdto;
			}
			this.pw.close();
		}
		return null;
	}
	
	
	String service_id = "ncp:sms:kr:318002747651:raemian";
	String access_key = "ocUNXmdgtCs589Vk9WDq";
	String security_key ="QtGAhRfAJLLSfHVXn4bgrEwDjppobjnMwTGuW9JF";
	String service = "SMS";	// SMS,LMS,MMS
	String url = "https://sens.apigw.ntruss.com/sms/v2/services/"+service_id+"/messages";
	String url2 = "/sms/v2/services/"+service_id+"/messages";	//SHA 암호화에서 사용.
	// 오늘 날짜
	String timestamp = Long.toString(System.currentTimeMillis()); //발송시간 1625245221 2023-00-00
	
	
	/* SMS API */
	public void smsApiService(String securityNo, String usertel,HttpServletResponse response) throws Exception {
		
		JSONObject code1 = new JSONObject();
		JSONObject code2 = new JSONObject();
		JSONArray code3 = new JSONArray();
		
		code1.put("type", "SMS");
		code1.put("countryCode","82");
		code1.put("from", "01047542394");
		code1.put("contentType" ,"COMM");
		code1.put("content","이벤트 내용발송");	// 관리자가 확인하는 메세지 내용
		code2.put("content", securityNo);	//클라이언트가 받을 메세지 내용.
		code2.put("to", usertel);
		
		code3.add(code2);
		code1.put("messages",code3);
		
		String data = code1.toString();	//해당 배열을 문자화로 변경.
		//System.out.println(data);
		OkHttpClient client = new OkHttpClient();
		this.pw = response.getWriter();
		Request req = new Request.Builder()
				.addHeader("x-ncp-apigw-timestamp", timestamp)
				.addHeader("x-ncp-iam-access-key", access_key)
				.addHeader("x-ncp-apigw-signature-v2", makese())	// SHA로 변환된 값을 적용.
				.url(url)
				.post(RequestBody.create(MediaType.parse("application/json"),data))	//POST로 전송.
				.build();	// curl 요청사항 제작.
		Response res = client.newCall(req).execute();	//Naver API로 전송 실행 및 return 내용을 받음.
		String result = res.body().string();	//문자열로 확인.
		System.out.println(result);
		
		
		if(result.indexOf("202") > 0) {
			this.pw.write("ok"+securityNo);
		}
		else {
			this.pw.write("cancel"+securityNo);
		}
		this.pw.close();
	}
	
	// 암호화 코드 변경 class -> Base64
	public String makese() {
		String sp = " ";
		String line = "\n";
		
		String msg = new StringBuilder()
				.append("POST")
				.append(sp)
				.append(url2)
				.append(line)
				.append(timestamp)
				.append(line)
				.append(access_key)
				.toString();
		SecretKeySpec key;
		String base64 = "";
		try {
			key = new SecretKeySpec(security_key.getBytes("UTF-8"), "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(key);
			
			byte[] rawHmac = mac.doFinal(msg.getBytes("UTF-8"));
			base64 = Base64.getEncoder().encodeToString(rawHmac);
		}
		catch(Exception e) {
			System.out.println("암호화 오류발생 !!");
			base64 = null;
			e.printStackTrace();
		}
		return base64;
	}
}








