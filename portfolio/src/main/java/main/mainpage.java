package main;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import portfolio.ConfigDTO;
import portfolio.ConfigModel;
import portfolio.FaQdto;
import portfolio.NoticeDto;
import portfolio.NoticeModule;
import portfolio.faqModule;

@Controller
public class mainpage {

	HttpSession session;
	
	@Resource(name = "ad_config")
	private ConfigModel confModel;
	
	@Resource(name = "loginM")
	private LoginModel loginModel;
	
	@Resource(name = "reserveM")
	private reserveModel rsmodel;
	
	@Resource(name = "notice")
	private NoticeModule noticemodel;
	
	@Resource(name="faqM")
	private faqModule faqmodel;
	
	/* Main 페이지 (index) */
	@RequestMapping("main/mainPage.do")
	public String mainPage(Model m) {
		List<ConfigDTO> lists = this.confModel.getTypeList();
		m.addAttribute("lists",lists);
		
		return "main/index";
	}
	
	/*회원가입 PART*/
	@RequestMapping("main/join_member.do")
	public String join_member() {
		
		return null;
	}

	/*회원가입 완료시*/
	@PostMapping("main/joinok.do")
	public String login_ck(@ModelAttribute MemberDto lgdto,HttpServletResponse res) throws Exception {
		
		
		
		this.loginModel.join_member(lgdto,res);
		return null;
	}
	
	/*아이디 중복체크 AJAX*/
	@PostMapping("main/idck.do")
	public void idchcek(Model m,String id) {
		System.out.println("con id : "+id);
		MemberDto ldto = this.loginModel.id_check(id);
		if(ldto == null) {
			m.addAttribute("idck","canuse");
		}
		else {
			m.addAttribute("idck","nouse");
		}
	}
	
	
	/* 로그인 페이지 */
	@RequestMapping("main/login.do")
	public String login_page() {
		return null;
	}
	
	@PostMapping("main/loginok.do")
	public String loginok(@ModelAttribute MemberDto lgdto,HttpServletResponse res,HttpServletRequest req) {
		
		
		try {
			// 세션 저장
			MemberDto loggedInMdto = this.loginModel.userCheck(lgdto, res);
			this.session = req.getSession();
			System.out.println("check");
			this.session.setAttribute("mdto", loggedInMdto);
		}
		catch (Exception e) {
			System.out.println("로그인 파트 쿼리 에러");
			e.printStackTrace();
		}
		return null;
	}
	
	/*로그아웃 PART	 */
	@RequestMapping("main/userlogOut.do")
	public String userLogOut(HttpServletRequest req) {
		this.loginModel.userLogOut(req);
		
		return "redirect:/main/mainPage.do";
	}
	
	/* 예약 Page */
	@RequestMapping("main/reservation_in.do")
	public String reserve_in(HttpServletRequest req,HttpServletResponse res, Model m) throws Exception {
		
		MemberDto mdto = this.loginModel.getReserve(req,res);
		if(mdto != null) {
			System.out.println("여기로 넘어왓음");
			m.addAttribute("mdto",mdto);
		}
		
		return "/main/reservation_in";
	}
	
	/* 예약완료시 */
	@PostMapping("main/reserve_ok.do")
	public String reserOk(
			@ModelAttribute ReserveDto rdto,HttpServletResponse res) {
		try {
			this.rsmodel.insert_reserve(rdto,res);
		} 
		catch (Exception e) {
			System.out.println("예약 insert Querry ERR");
			e.printStackTrace();
		}
		return null;
	}
	
	/* 예약 확인 */
	@RequestMapping("main/reservation_ck.do")
	public String reserve_ck(Model m,HttpServletRequest req,HttpServletResponse res) throws Exception {
		ReserveDto rdto = this.rsmodel.ckReserve(req,res);
		
		m.addAttribute("rdto",rdto);
		return "main/reservation_ck";
	}
	
	
	/*예약 수정 PART*/
	@PostMapping("main/reserve_modify.do")
	public void reserve_modify(HttpServletResponse res,@ModelAttribute ReserveDto rdto) {
		
		try {
			this.rsmodel.modify_reserve(rdto,res);
		}
		catch (Exception e) {
			System.out.println("수정 쿼리 PART 실패");
			e.printStackTrace();
		}
	}
	
	/*예약 취소 처음 로드 PART*/
	@RequestMapping("main/reservation_cancel.do")
	public String reserve_cancel(Model m,HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 세션값 기반 예약 여부 확인.
		ReserveDto rdto = this.rsmodel.ckReserve(req, res);
		
		ReserveDto prdto = this.rsmodel.cancel_ck(rdto,res);
		m.addAttribute("rdto",prdto);
		
		return "main/reservation_cancel";
	}
	
	/*예약 취소시*/
	@PostMapping("main/del_reserve.do")
	@ResponseBody
	public String del_reserve(String ridx) throws Exception {
		String sign = this.rsmodel.del_reserve(ridx);
		
		return sign;
	}
	
	
	/* 메인 공지사항 PART */
	@RequestMapping("main/notice.do")
	public String notice_page(
			Model m,
			@RequestParam(required = false) String searchVal,
			@RequestParam(defaultValue = "0") int no) {
		
		List<NoticeDto> ndtos = this.noticemodel.getNoticeToMain(searchVal, no);
		int ea = this.noticemodel.notice_ea(searchVal);
		m.addAttribute("ndtos",ndtos);
		m.addAttribute("ea",ea);
		return "main/notice";
	}
	
	/* Main Faq Part */
	@RequestMapping("main/faq.do")
	public String main_faq(Model m) {
		
		List<FaQdto> fdtos = this.faqmodel.getAllFaqs();
		m.addAttribute("fdtos",fdtos);
		
		return "main/faq";
	}
	
	
	/* 인증번호 AJAX 통신 PART */
	@PostMapping("main/sms_verifycation.do")
	@ResponseBody
	public String smsVerify(
			HttpServletResponse response,
			@RequestParam(required = false) String smsNo, @RequestParam(required = false) String usertel) throws Exception {
		
		this.loginModel.smsApiService(smsNo, usertel,response);
		
		return null;
	}
}




