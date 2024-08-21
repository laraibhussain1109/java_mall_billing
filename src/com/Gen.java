package com;

public class Gen{
	private static String billStr="a";
	private static int billNum;
	
	public static String getBillNo() {
		billNum=billNum+1;
		String billNo=getNumberingFormat(billStr, billNum);
		
		return billNo;
	}
	
	public synchronized static String getNumberingFormat(String alpha, int number) {
		String alphanum = null;
		if(number>0&&number<=9) {
			alphanum=alpha+"00"+number;
		}else if(number>10 && number<=99) {
			alphanum=alpha+"0"+number;
		}else {
			alphanum=alpha+number;
		}
		
		return alphanum;
	}
	
}