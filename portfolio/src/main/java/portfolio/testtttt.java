package portfolio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class testtttt {

	public static void main(String[] args) throws Exception {
		/*
		 * String[] data =
		 * {"리포멘","사라리클린","안키토산","리메트리","사포멘시토리","카이토산","테파플로이드","리케페트로이드"};
		 * 
		 * int w =0;
		 * 
		 * System.out.println(Arrays.asList(data));
		 */
		Date dt = new Date();
		DateFormat df = new SimpleDateFormat("MM-");
		String dates = df.format(dt);
		System.out.println(dates);
	}
}
