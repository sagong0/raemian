package main;

import lombok.Data;

@Data
public class MemberDto {
	int midx;
	String mname,mid,mpw,mtel,memail;
	String mzipcode;
	String mstreetaddr,mdetailaddr;
	String ckemail,cktel,ckaddr,cksms;
	String mindate;
}
