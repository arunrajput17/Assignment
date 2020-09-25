package assignment.one.test;

import java.text.DecimalFormat;

public class two {
	
	static float calST,calOT,calDT;
	
	
	
	static DecimalFormat df = new DecimalFormat("##0.00");
	
	
	
	public static void calSTOTDTMTWT(float dayHr) {
	if(dayHr<8) {
		calST=calST+dayHr;
		System.out.println("ST Total is "+calST);
		
	}else 
		if(dayHr>8 && dayHr<10) {
			calST=calST+8.00f;
			calOT=calOT+dayHr-8.00f;
			System.out.println("ST total is "+df.format(calST)+" , "+"OT Total is "+df.format(calOT)+" & "+"DT total is "+df.format(calDT));
		}else
//		if (dayHr==10) {
//			calST = calST+dayHr;
//			System.out.println("ST Total is "+calST);
//		}
//		else
			if (dayHr>=10 && dayHr<=12) {
				calST=calST+10.00f;
				calOT = calOT+dayHr-10.00f;
				calDT=0.00f;
				System.out.println("ST total is "+df.format(calST)+" , "+"OT Total is "+df.format(calOT)+" & "+"DT total is "+df.format(calDT));
			}
			else
				if(dayHr>12) {
					calST=calST+10.00f;
					calOT=calOT+2.00f;
					calDT=calDT+dayHr-12.00f;
					System.out.println("ST total is "+df.format(calST)+" , "+"OT Total is "+df.format(calOT)+" & "+"DT total is "+df.format(calDT));
				}
		
	}
	
	public static void calSTOTDTFSS(float dayHr) {
		if (dayHr<=8) {
			calOT = calOT+dayHr;
			System.out.println("OT Total is "+calOT);
		}
		else
			if(dayHr>8) {
				calOT=calOT+8.00f;
				calDT=calDT+dayHr-8.00f;
				System.out.println("OT Total is "+df.format(calOT)+" & "+"DT total is "+df.format(calDT));
			}
		
	}

	public static void main(String[] args) {
		System.out.println("Start");
		
		float valMon=10.00f,valTue=9.99f,valWed=9.99f,valThu=10.01f,valFri=8.00f,valSat=8.02f,valSun=8.00f;
		
		calSTOTDTMTWT(valMon);
		calSTOTDTMTWT(valTue);
		calSTOTDTMTWT(valWed);
		calSTOTDTMTWT(valThu);
		calSTOTDTFSS(valFri);
		calSTOTDTFSS(valSat);
		calSTOTDTFSS(valSun);
		System.out.println("ST total is "+df.format(calST)+" , "+"OT Total is "+df.format(calOT)+" & "+"DT total is "+df.format(calDT));
		
//		System.out.println(valMon);
		

	}

}
