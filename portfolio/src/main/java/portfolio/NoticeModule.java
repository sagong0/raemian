package portfolio;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository("notice")
public class NoticeModule {
	
	PrintWriter pw = null;
	String msg = "";
	
	String host= "iup.cdn1.cafe24.com";
	String user = "sagong0";
	String password = "wjd461352";
	int port = 21;
	
	@Resource(name = "sqlsession")
	private SqlSessionTemplate sessionTemplate;
	
	/*공지사항 insert 저장*/
	public void saveNotice(NoticeDto noticeDto,MultipartFile mfile,HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8;");
		this.pw = res.getWriter();

		int sign = 0;
		
		if(mfile.isEmpty()) {
			System.out.println("mfile null임 원래");
			//그냥 디비저장   /*디비 저장*/
			sign = this.sessionTemplate.insert("DB.saveNotice", noticeDto);
			if(sign >= 1) {
				this.msg = "<script>"
						+ "alert('공지사항이 등록되었습니다.');"
						+ "location.href='./notice_main.do';"
						+ "</script>";
			}
			else {
				this.msg = "<script>"
						+ "alert('등록에 실패하였습니다.');"
						+ "history.go(-1);"
						+ "</script>";
			}
		}
		else {
			// 디비 저장 + cdn업로드
			cdnUpload cdnUpload = new cdnUpload(this.host, this.user, this.password, this.port);
			String finalUrl = cdnUpload.uploadFile(mfile);
			noticeDto.setNfile(finalUrl);
			sign = this.sessionTemplate.insert("DB.saveNotice", noticeDto);
			if(sign >= 1) {
				this.msg = "<script>"
						+ "alert('공지사항이 등록되었습니다.');"
						+ "location.href='./notice_main.do';"
						+ "</script>";
			}
			else {
				this.msg = "<script>"
						+ "alert('등록에 실패하였습니다.');"
						+ "history.go(-1);"
						+ "</script>";
			}
		}
		this.pw.write(this.msg);
		this.pw.close();
	}
	/* 첨부파일 명 출력 */
	public String getDbFile(String idx) {
		String fnm = this.sessionTemplate.selectOne("DB.getDbFileNm", idx);
		return fnm;
	}
	
	
	/* 파일 다운로드 */
	public String downFile(String dbFileNm,HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8;");
		
		String host = "iup.cdn1.cafe24.com";
		int port = 21;
		String userId = "sagong0";
		String userPw = "wjd461352";
		

		FTPClient ftp = new FTPClient();
		ftp.setControlEncoding("utf-8");
		FTPClientConfig config = new FTPClientConfig();
		ftp.configure(config);
		
		ftp.connect(host,port);
		
		if(ftp.login(userId, userPw)) {
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
		}
		int replycode = ftp.getReplyCode();
		//System.out.println(replycode);
		
		String[] urlSplited = dbFileNm.split("/");
		String originalFileNm = urlSplited[urlSplited.length-1];
		String filePath = "/www/files/"+originalFileNm;
		this.pw = res.getWriter();
		OutputStream os = new FileOutputStream("D:\\"+originalFileNm);

		boolean isdownload = ftp.retrieveFile(filePath, os);
		if(isdownload) {
			System.out.println("다운 성공");
			this.msg = "<script>"
					+ "alert('첨부파일을 다운로드하였습니다.');"
					+ "history.go(-1);"
					+ "</script>";
		}
		else {
			this.msg = "<script>"
					+ "alert('첨부파일 다운로드에 실패하였습니다.');"
					+ "history.go(-1);"
					+ "</script>";
		}
		this.pw.write(this.msg);
		this.pw.close();

		return null;
	}
	
	
	
	/*저장된 거 출력 (SELECT) */
	public List<NoticeDto> getNotice(int no) {
		List<NoticeDto> notices = null;
		notices = this.sessionTemplate.selectList("DB.getNotice",no);
		return notices;
	}

	/* 검색어가 있을때 게시글 출력 */
	public List<NoticeDto> getNoticeBySearch(String searchVal){
		List<NoticeDto> notices = null;
		notices = this.sessionTemplate.selectList("DB.getNoticeBySearch",searchVal);

		return notices;
	} 
	
	/* 해당 게시글 삭제 */
	public void delNotice(String idx,HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8;");
		this.pw = res.getWriter();
		int result = this.sessionTemplate.delete("DB.delNotice",idx);
		if(result > 0) {
			System.out.println("삭제 완료");
			this.msg = "<script>"
					+ "alert('성공적으로 삭제 되었습니다.');"
					+ "location.href='./notice_main.do';"
					+ "</script>";
		}
		else {
			System.out.println("삭제 실패");
			this.msg = "<script>"
					+ "alert('삭제에 실패하였습니다.');"
					+ "history.go(-1);"
					+ "</script>";
		}
		this.pw.write(this.msg);
		this.pw.close();
	}

	/* 해당 게시글 디테일 */
	public NoticeDto notice_detail(String idx) {
		NoticeDto notice = this.sessionTemplate.selectOne("DB.getNoticeByIdx",idx);
		
		return notice;
	}
	
	/* 조회수 카운트 업 */
	public void notice_countUp(String idx) {
		int response = this.sessionTemplate.update("DB.countUp",idx);
	}
	
	/* 게시물 총 갯수 */
	public int notice_ea(String searchVal) {
		Map<String, Object> searchMap = new HashMap<String, Object>();
		
		int ea = 0;
		
		if(searchVal==null || searchVal == "") {
			searchMap = null;
		}
		else {
			searchMap.put("part", "yesSearch");
			searchMap.put("searchVal", searchVal);
		}
		ea = this.sessionTemplate.selectOne("DB.noticeEa",searchMap);
		
		return ea;
	}
	
	/* 공지사항 메인으로 출력 */
	public List<NoticeDto> getNoticeToMain(String searchVal, int pageNo){
		
		if(pageNo < 2) {
			pageNo = 0;
		}
		else {
			pageNo = 10 * (pageNo-1);
		}
		
		List<NoticeDto> ndtos = null;
		String psearch = (searchVal != null) ? searchVal.trim() : null;
		
		Map<String, Object> smaps = new HashMap<String, Object>();
		
		
		if(searchVal == null || searchVal == "") {
			smaps.put("part", "");
		}
		else {
			smaps.put("part", "oksearch");
			smaps.put("searchVal", psearch);
		}
		smaps.put("pNo", pageNo);
		ndtos = this.sessionTemplate.selectList("DB.getNoticeToMain",smaps);
		return ndtos;
	}
}


class cdnUpload{
	private String host;
    private String user;
    private String password;
    private int port;
    
    public cdnUpload(String host, String user, String password, int port) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.port = port;
    }
    public String uploadFile(MultipartFile mfile) {
    	String pFileName = null;
    	String fileName = mfile.getOriginalFilename();
    	String type =null;
    	
    	String url = "https://sagong0.cdn1.cafe24.com/files/";
    	String ftpPath = "/www/files/"+pFileName;
    	
    	Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
    	
		int lastIndex = fileName.lastIndexOf(".");
		if(lastIndex != -1) {
			type = fileName.substring(fileName.lastIndexOf("."));			
		}
		
		pFileName = sf.format(date) + "_" + type;
		String purl = url+pFileName;
		
		FTPClient ftp = new FTPClient();
		ftp.setControlEncoding("utf-8");
		FTPClientConfig cf = new FTPClientConfig();
		
		ftp.configure(cf);
		try {
			ftp.connect(this.host,this.port); 
			
			if(ftp.login(this.user, this.password)) {
				ftp.setFileType(FTP.BINARY_FILE_TYPE);
				
				/*
				OutputStream os = new FileOutputStream("D:\\filetest\\"+purl);
				boolean res = ftp.retrieveFile(ftpPath, os);
				
				System.out.println(res);
				*/
				/* FTP 파일 업로드 PART */
				boolean result = ftp.storeFile("/www/files/"+pFileName, mfile.getInputStream());
				if(result) {
					System.out.println("업로드 성공");
					return purl;
				}
				else {
					System.out.println("업로드 실패");
				}
			}
			else {
				System.out.println("ftp 정보가 올바르지 않습니다.");
			}
			ftp.logout();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } 
                catch (Exception e) {
                	System.out.println("최종 ftp 연결 해제도 실패");
                    e.printStackTrace();
                }
            }
        }
		
    	return null;
    }
}
