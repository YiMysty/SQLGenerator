package entity;

public class dimTerm {
	Integer TermID;
	String POSType;
	String Name;
	public int getTermID() {
		return TermID;
	}
	public void setTermID(int termID) {
		TermID = termID;
	}
	public String getPOSType() {
		return POSType;
	}
	public void setPOSType(String pOSType) {
		POSType = pOSType;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public dimTerm(){
		this.TermID = null;
		this.POSType = null;
		this.Name = null;
	}
}
