package portfolio;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("faqM")
public class faqModule {
	
	PrintWriter pw = null;
	String msg = "";
	@Resource(name="sqlsession")
	private SqlSessionTemplate sessionTemplate;
	
	/* FAQ 데이터 가져오기 */
	public List<FaQdto> getFaqList(String searchVal, int fidx) {
		List<FaQdto> fdto = null;
		
		Map<String, Object> smap = new HashMap<String, Object>();
		
		if(searchVal == null || searchVal =="") {
			smap.put("fidx", fidx);
		}
		// 검색어 있을 경우
		else {
			smap.put("search", searchVal);
			smap.put("part", "yes");
			smap.put("fidx", fidx);
		}
		fdto = this.sessionTemplate.selectList("DB.getFaqList",smap);
		
		return fdto;
	}
	
	/* faq 카운트 */
	public int countFaq(String searchVal) {
		Map<String, Object> eaMap = new HashMap<String, Object>();
		
		int ea = 0;
		if(searchVal == null || searchVal == "") {
			eaMap = null;
		}
		else {
			eaMap.put("part", "yes");
			eaMap.put("search", searchVal);
		}
		ea = this.sessionTemplate.selectOne("DB.countFAQ",eaMap);
		return ea;
	}
	
	/* FAQ 삭제*/
	public void delFaq(String idx,HttpServletResponse res) throws Exception {
		res.setContentType("text/html;charset=utf-8;");
		this.pw = res.getWriter();
		
		int result = this.sessionTemplate.delete("DB.del_faq",idx);
		if(result > 0) {
			this.msg = "success";
			
		}
		else {
			this.msg = "fail";
		}
		this.pw.write(this.msg);
		this.pw.close();
	}

	/* faq 등록 */
	public String insertFaq(FaQdto faqdto,HttpServletResponse res) {
		res.setContentType("text/html; charset=utf-8;");
		
		try {
			this.pw = res.getWriter();
			int response = this.sessionTemplate.insert("DB.write_faq",faqdto);
			if(response > 0) {
				this.msg = "<script>"
						+ "alert('성공적으로 등록 되었습니다.');"
						+ "location.href='./faq_main.do';"
						+ "</script>";
			}
			else {
				this.msg = "<script>"
						+ "alert('네트워크 오류로 인하여 등록에 실패하였습니다.');"
						+ "history.go(-1);"
						+ "</script>";
			}
			this.pw.write(this.msg);
			this.pw.close();
		} 
		catch (Exception e) {
			System.out.println("faq insert 쿼리 모듈 에러");
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*faq 메인에 전체 출력*/
	public List<FaQdto> getAllFaqs(){
		
		List<FaQdto> fdtos = this.sessionTemplate.selectList("DB.getAllFaqs");
		
		return fdtos;
	}
	
}







