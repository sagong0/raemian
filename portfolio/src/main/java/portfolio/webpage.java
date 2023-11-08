package portfolio;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import main.LoginModel;
import main.MemberDto;
import main.ReserveDto;
import main.reserveModel;

@Controller
public class webpage {
	
	PrintWriter pw = null;
	HttpSession httpSession = null;
	
	@Resource(name = "admin_membership")
	private ad_membershipModule am;

	@Resource(name = "notice")
	private NoticeModule noticeModule;
	
	@Resource(name="faqM")
	private faqModule faqModule;
	
	@Resource(name = "ad_config")
	private ConfigModel confModel;
	
	@Resource(name="loginM")
	private LoginModel loginModel;
	
	@Resource(name="reserveM")
	private reserveModel rsModel;
	
	/* 관리자 로그인 PART */
	@RequestMapping("admin/view/ad_loginok.do")
	public String admin_login(
			HttpServletRequest request,
			HttpServletResponse res,
			@RequestParam String login_id,
			@RequestParam String login_pass) throws Exception {
		res.setContentType("text/html; charset=utf-8;");
		
		/*
		String[] allowIp = {"183.111.199.179","211.171.32.170","119.192.19.122","119.192.19.112","192.168.110.214","192.168.56.1","59.5.218.81"};
		
		
		InetAddress address = InetAddress.getLocalHost();
		String myIp = address.getHostAddress();
		boolean allowed = false;

		int w = 0;
		while(w<allowIp.length) {
			//허용된 아이피일때
			if(myIp.intern() == allowIp[w]) {
				allowed = true;
				break;
			}
			else {
				allowed = false;
			}			
			w++;
		}
		if(allowed==true) {
		}
		else {
			//System.out.println("차단된 아이피");
		}
		*/
		this.httpSession = request.getSession();
		this.httpSession.setAttribute("name", login_id);
		this.am.isUser(login_id, login_pass,res,request);
		return null;
	}
	
	/* 로그아웃 PART */
	@RequestMapping("admin/view/logout.do")
	public String loggedOut(HttpServletRequest req,HttpServletResponse res) {
		this.httpSession = req.getSession();
		this.httpSession.invalidate();
		
		return "redirect:/admin/view/index.jsp";
	}
	
	
	
		
	/* 회원가입 신청하기 버튼 PART*/
	@PostMapping("admin/view/admin_join.do")
	public String admin_join(
			HttpServletResponse res,
			@ModelAttribute admin_dto adto) throws Exception {
		res.setContentType("text/html; charset=utf-8;");
		
		this.am.admin_join(adto,res);
		
		return null;
	}
	
	

	
	/* 관리자 ID 중복체크 */
	@PostMapping("admin/view/idck.do")
	public String idck(String id, Model m) {
		admin_dto adto = this.am.idcheck(id);
		if(adto==null) {
			m.addAttribute("idck","ok");
		}
		else {
			m.addAttribute("idck","no");
		}
		
		return "admin/view/idck";
	}
	
	
	
	/*관리자 로그인 후 메인*/
	@RequestMapping("admin/view/admin_main")
	public String ad_main(Model m) {
		/*당일 가입 유저 출력*/
		List<MemberDto> todayUsers = this.loginModel.getTodayUsers();
		
		/*당일 예약 건 출력*/
		List<ReserveDto> todayReserves = this.rsModel.getTodayReserves();

		m.addAttribute("todayUsers",todayUsers);
		m.addAttribute("todayReserves",todayReserves);
		System.out.println("2222");
		System.out.println(todayReserves);
		return "admin/view/admin_main";
	}
	
	
	/* 관리자 현황 PART */
	@RequestMapping("admin/view/config_main.do")
	public List<admin_dto> ad_config(Model m,
			@ModelAttribute SearchDTO searchDTO,
			@RequestParam(required = false) String aarea,
			@RequestParam(defaultValue = "1") int no) {
				
		if(no < 2) {
			no = 0;
		}
		else {
			no = (no-1)*10;
		}
		
		List<admin_dto> lists = null;
		Map<String, Object> searchdata =null;
		int ct = 0;
		// 검색어 없고
		if(searchDTO.search_type == null || searchDTO.search_val == null) {
			// 소속 전체일때
			if(aarea == null || aarea.equals("all") || aarea=="") {
				lists = this.am.getAllAdmin(no);
				ct = this.am.countAdmin();
			}
			// 소속 change event
			else {
				//System.out.println("area :"+aarea);
				lists = this.am.getAdminByArea(aarea);
				ct = this.am.countAdminByArea(aarea);
			}
		}
		// 검색어 있을 때
		else {
			searchdata = this.am.getAdminBySearch(searchDTO);
			lists = (List<admin_dto>)searchdata.get("lists");
			ct = this.am.countAdminBySearch(searchDTO);
			m.addAttribute("searchType",searchdata.get("searchType"));
		}
		
		m.addAttribute("lists",lists);
		m.addAttribute("ct",ct);
		
		return null;
	}
	
	/*소속 AJAX PART*/
	@RequestMapping("admin/view/getListByArea.do")
	public @ResponseBody List<admin_dto> getListByArea(@RequestParam(required = false) String area) throws Exception {
		int ct = 0;
		List<admin_dto> lists = this.am.getAdminByArea(area);
		ct = this.am.countAdminByArea(area);
		System.out.println(ct);
		return lists;
	}
	
	
	/* 근무중 / 퇴직중 AJAX */
	@PostMapping("admin/view/modifyStatus.do")
	@ResponseBody
	public int updateStatus (@ModelAttribute StatusDto statusdto) {
		int result =this.am.updateStatus(statusdto);
		return result;
	}
	
	
	
	
	
	
	
	/* ****************** NOTICE **************** */
	
	/* 공지사항 메인 PART*/
	@RequestMapping("admin/view/notice_main.do")
	public void notice(Model m, String searchVal,@RequestParam(defaultValue = "1") int no)  {
		
		if(no < 2) {
			no = 0;
		}
		else {
			no = (no-1) * 10;
		}
		
		List<NoticeDto> notices = null;
		int ea = 0;
		if(searchVal == null || searchVal=="") {
			notices= this.noticeModule.getNotice(no);
		}
		else {
			notices = this.noticeModule.getNoticeBySearch(searchVal);
		}
		ea = this.noticeModule.notice_ea(searchVal);
		m.addAttribute("notices",notices);
		m.addAttribute("ea",ea);
	}
	
	
	/* 공지사항 글쓰기 PART*/
	@RequestMapping("admin/view/notice_write.do")
	public String notice_write(Model m) {
		
		return "admin/view/notice_write";
	}
	
	/*공지사항 글쓰기 완료시 PART*/
	@RequestMapping("admin/view/notice_writeok.do")
	public void notice(
			@ModelAttribute NoticeDto noticeDto,
			@RequestParam(required = false) String idx,
			MultipartFile mfile,
			HttpServletResponse res) throws Exception {
		
		if(idx == null || idx=="") {
			this.noticeModule.saveNotice(noticeDto,mfile,res);					
		}
		else {
			String dbFileNm = this.noticeModule.getDbFile(idx);
			//System.out.println(dbFileNm);
			this.noticeModule.downFile(dbFileNm,res);
		}
		
	}
	/* 공지사항 삭제 */
	@GetMapping("admin/view/notice_del.do")
	public void notice_delete(String idx,HttpServletResponse res) {
		try {
			this.noticeModule.delNotice(idx,res);
		} 
		catch (Exception e) {
			System.out.println("삭제 Module 부분 Error");
			e.printStackTrace();
		}
	}
	
	/* 공지사항 디테일 (title 클릭)*/
	@RequestMapping("admin/view/notice_view.do")
	public String notice_view(@RequestParam(required = false) String idx, Model m) {
		
		// 조회수 증가 여기서
		//this.noticeModule.notice_countUp(idx);
		NoticeDto n_dto = this.noticeModule.notice_detail(idx);
		m.addAttribute("ndto",n_dto);
		return null;
	}
	
	/* 조회수 증가 AJAX */
	@GetMapping("admin/view/nCountUp.do")
	@ResponseBody
	public ResponseEntity<String> notice_countUp (@RequestParam(required = false) String idx) {
		this.noticeModule.notice_countUp(idx);
		return ResponseEntity.ok("success");
	}
	
	
	/* FAQ PART */
	@RequestMapping("admin/view/faq_main.do")
	public String faq_main(
			Model m,
			@RequestParam(required = false) String searchVal,
			@RequestParam(defaultValue="1") int fidx) {
		if(fidx < 2) {
			fidx = 0;
		}
		else {
			fidx = (fidx-1)*10;
		}		
		List<FaQdto> fdto = null;
		int ea = 0;
		
		fdto = this.faqModule.getFaqList(searchVal,fidx);
		ea = this.faqModule.countFaq(searchVal);
		m.addAttribute("fdto",fdto);
		m.addAttribute("total",ea);
		return null;
	}
	
	/*FAQ 삭제 PART*/
	@RequestMapping("admin/view/del_faq.do")
	@ResponseBody
	public void del_faq(String fidx,HttpServletResponse res) throws Exception {
		//System.out.println(fidx);
		this.faqModule.delFaq(fidx,res);
	}


	/* FAQ 글 등록 페이지 */
	@RequestMapping("admin/view/faq_write.do")
	public String write_faq() {
		return null;
	}
	
	/* FAQ 글 등록 완료시  */
	@RequestMapping("admin/view/faq_writeok.do")
	public String writeok_faq(@ModelAttribute FaQdto faqdto,HttpServletResponse res) {
		this.faqModule.insertFaq(faqdto,res);
		return null;
	}
	
	
	
	/* 환경설정 Main PART */
	@RequestMapping("admin/view/info_main.do")
	public String infoMain(Model m,@RequestParam(required = false) String searchVal)  {
		
		List<ConfigDTO> infos = null;
		int ea = 0;
		
		infos = this.confModel.select_info(searchVal);
		ea = this.confModel.count_infos(searchVal);
		
		m.addAttribute("infos",infos);
		m.addAttribute("ea",ea);
		return null;
	}
	
	/*환경설정 글쓰기 페이지 이동*/
	@RequestMapping("admin/view/info_write.do")
	public String writeInfo() {
		return null;
	}
	
	
	
	/*주거타입 등록 PART*/
	@RequestMapping("admin/view/info_writeok.do")
	public String saveInfo(@ModelAttribute ConfigDTO cdto, HttpServletResponse res) {
		try {
			System.out.println(cdto.getAuse());
			this.confModel.insert_info(cdto,res);
		} 
		catch (Exception e) {
			System.out.println("주거타입 등록  PART 에러");
			e.printStackTrace();
		}
		return null;
	}
	
	/*회원 관리 PART*/
	@RequestMapping("admin/view/member_main.do")
	public String member_main(Model m,@ModelAttribute SearchDTO searchdto,
			@RequestParam(defaultValue = "1") int pageNo) {
		if(pageNo < 2) {
			pageNo = 0;
		}
		else {
			pageNo = 20 * (pageNo-1);
		}
		
		
		List<MemberDto> mdtos = this.loginModel.getUsers(searchdto, pageNo);						
		int ea = this.loginModel.countUsers(searchdto);
		
		m.addAttribute("users",mdtos);
		m.addAttribute("ea",ea);
		m.addAttribute("sdto",searchdto);
		return null;
	}


	/* 유저 삭제 버튼 PART */
	@GetMapping("admin/view/delete_user.do")
	public void delete_user(int idx, HttpServletResponse res) {
		this.loginModel.deleteUser(idx,res);
	}
	
	/* 관리자 예약 현황 */
	@RequestMapping("admin/view/reserve_main.do")
	public String ad_reserve(Model m, @ModelAttribute SearchDTO sdto) {
		System.out.println(sdto);
		List<ReserveDto> rdtos = null;	
		rdtos = this.rsModel.getReserves(sdto);
		
		m.addAttribute("rdtos",rdtos);
		m.addAttribute("sdto",sdto);
		return "admin/view/reserve_main";
	}	
	
	
	
}







