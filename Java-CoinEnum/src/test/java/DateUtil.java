import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String getString(Object obj) {
		String result="";
		if (obj != null&&obj.toString().trim().length()!=0) {
			result = obj.toString().trim();
		}
		return result;
	}

	/**
	  * 获取现在时间
	  *
	  * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
	  */
	 public static String getStringDate() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(currentTime);
	  return dateString;
	 }

	/**
	 * 获取现在时间
	 *
	 * @return返回字符串格式 yyyyMMddHHmmss
	 */
	public static String getSimpleDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取现在时间
	 *
	 * @return返回字符串格式 yyyyMMddHHmmssSSS
	 */
	public static String getFileDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取现在时间
	 *
	 * @return返回字符串格式 yyyyMMdd
	 */
	public static String getDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	/**
	 * 获取现在时间
	 *
	 * @return返回字符串格式 yyyy-MM-dd
	 */
	public static String getDate2() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取现在时间
	 *
	 * @return返回字符串格式 yy
	 */
	public static String getyear2() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yy");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	/**
	 * 获取现在时间
	 *
	 * @return返回字符串格式 yyyy年MM月dd日
	 */
	public static String getDateZH() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static Date now() {
		return new Date();
	}

	public static String getCurrentDateAlter(int day) {
		Calendar calendar = Calendar.getInstance();//此时打印它获取的是系统当前时间
        calendar.add(Calendar.DATE, day);    //得到前一天
        String yestedayDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
		return yestedayDate;
	}

	public static Date parseDatetime(String datetime) throws ParseException {
		SimpleDateFormat datetimeFormat = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss");
		return datetimeFormat.parse(datetime);
	}

	/**
	 * 判断某个日期是否在某个日期范围
	 *
	 * @param beginDate
	 *            日期范围开始
	 * @param endDate
	 *            日期范围结束
	 * @param src
	 *            需要判断的日期
	 * @return
	 */
	public static boolean between(Date beginDate, Date endDate, Date src) {
		return beginDate.before(src) && endDate.after(src);
	}

	public static String getbanci(){
		Date now = DateUtil.now();
		String today = DateUtil.getDate2();
		String tom = DateUtil.getCurrentDateAlter(1);
		String banci=null;
		try {
			Date ztm = DateUtil.parseDatetime(today+" 08:10:00");
			Date mtm = DateUtil.parseDatetime(today+" 16:10:00");
			Date wtm = DateUtil.parseDatetime(today+" 23:10:00");
			Date ltm = DateUtil.parseDatetime(today+" 00:00:00");
			Date zctm = DateUtil.parseDatetime(tom+" 00:00:00");

			if(DateUtil.between(ztm, mtm, now)){
				banci = "早班";
			}
			if(DateUtil.between(mtm, wtm, now)){
				banci = "中班";
			}
			if(DateUtil.between(wtm, zctm, now)){
				banci = "晚班";
			}
			if(DateUtil.between(ltm, ztm, now)){
				banci = "晚班";
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return banci;
	}

	public static void main(String[] args){
		System.out.println(getbanci());
	}
}
