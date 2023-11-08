package portfolio;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("ad_config")
public class ConfigModel {
	
	PrintWriter pw = null;
	
	@Resource(name="sqlsession")
	private SqlSessionTemplate sessionTemplate;
	
	int sign = 0;
	String msg = "";
	
	/* 환경 세대정보 리스트 출력 */
	public List<ConfigDTO>  select_info(String searchVal) {
		
		Map<String,Object> infoMap = new HashMap<String, Object>();

		List<ConfigDTO> cdto = null;
		
		if(searchVal == null || searchVal.isEmpty()) {
			infoMap = null;
		}
		else {
			infoMap.put("part", "yesSearch");
			infoMap.put("searchVal", searchVal);
		}
		
		cdto = this.sessionTemplate.selectList("DB.getInfos",infoMap);
		System.out.println(cdto);
		return cdto;
	}
	
	/* 정보 카운팅 */
	public int count_infos(String searchVal) {
		
		Map<String, Object> countMap = new HashMap<String, Object>();
		int ea = 0;
		if(searchVal == null || searchVal.isEmpty()) {
			// 전체 카운팅
			countMap = null;
		}
		else {
			// 검색어 필터링 한것 만 카운팅.
			countMap.put("part", "ea");
			countMap.put("search", searchVal);
		}
		ea = this.sessionTemplate.selectOne("DB.countInfos",countMap);
		System.out.println("ea : "+ ea);
		return ea;
	} 
	
	
	/* 환경설정 INSERT (저장) */
	public void insert_info(ConfigDTO cdto,HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8;");
		
		this.sign = this.sessionTemplate.insert("DB.insert_info",cdto);
		this.pw = res.getWriter();
		
		if(this.sign > 0) {
			this.msg = "<script>"
					+ "alert('정상적으로 등록 되었습니다.');"
					+ "location.href='./info_main.do';"
					+ "</script>";
		}
		else {
			this.msg = "<script>"
					+ "alert('네트워크 오류로 인하여 등록에 실패 하였습니다.');"
					+ "history.go(-1);"
					+ "</script>";
		}
		this.pw.write(this.msg);
		this.pw.close();
	}

	/* Main Index Type Info 출력 */
	public List<ConfigDTO> getTypeList() {
		
		List<ConfigDTO> lists = null;
		lists = this.sessionTemplate.selectList("DB.getTypeInfos");		
		
		return lists;
	}
}





