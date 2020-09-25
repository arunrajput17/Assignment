package assignment.dto;


public class AssignmentDTO {
	private String valMon;
	private String valTue;
	private String valWed;
	private String valThu;
	private String valFri;
	private String valSat;
	private String valSun;
	
	public AssignmentDTO(){
		
	}
	public AssignmentDTO(String valMon, String valTue, String valWed,
			String valThu, String valFri, String valSat, String valSun){
		this.valMon = valMon;
		this.valTue = valTue;
		this.valWed = valWed;
		this.valThu = valThu;
		this.valFri = valFri;
		this.valSat = valSat;
		this.valSun = valSun;
		
	}
	public String getvalMon() {
		return valMon;
	}
	public void setvalMon(String valMon) {
		this.valMon = valMon;
//		System.out.println(valMon);
	}
	public String getvalTue() {
		return valTue;
	}
	public void setvalTue(String valTue) {
		this.valTue = valTue;
	}
	public String getvalWed() {
		return valWed;
	}
	public void setvalWed(String valWed) {
		this.valWed = valWed;
	}
	public String getvalThu() {
		return valThu;
	}
	public void setvalThu(String valThu) {
		this.valThu = valThu;
	}
	public String getvalFri() {
		return valFri;
	}
	public void setvalFri(String valFri) {
		this.valFri = valFri;
	}
	public String getvalSat() {
		return valSat;
	}
	public void setvalSat(String valSat) {
		this.valSat = valSat;
	}
	public String getvalSun() {
		return valSun;
	}
	public void setvalSun(String valSun) {
		this.valSun = valSun;
	}
	@Override
	public String toString() {
		return "CommandDTO [Mon=" + valMon + ", Tue=" + valTue + ", Wed=" + valWed + ", Thu=" + valThu +", Fri=" + valFri +", Sat=" + valSat +", Thu=" + valSun +"]\n";
	}
	
	

	
}
