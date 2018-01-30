import java.util.List;

public class PollutionInfo{
  private SiteReport SiteReport;
  public List<PollutionItem> getList(){
    return SiteReport.getList();
  }
}

class SiteReport{
  private List<PollutionItem> ReportItem;
  public List<PollutionItem> getList(){
    return ReportItem;
  }
}

class PollutionItem{

  private String SpeciesCode;
  private String ReportItem;
  private String ReportItemName;
  private String Month1;
  private String Month2;
  private String Month3;
  private String Month4;
  private String Month5;
  private String Month6;
  private String Month7;
  private String Month8;
  private String Month9;
  private String Month10;
  private String Month11;
  private String Month12;
  private String Annual;

	/**
	* Returns value of SpeciesCode
	* @return
	*/
	public String getSpeciesCode() {
		return SpeciesCode;
	}

	/**
	* Sets new value of SpeciesCode
	* @param
	*/
	public void setSpeciesCode(String SpeciesCode) {
		this.SpeciesCode = SpeciesCode;
	}

	/**
	* Returns value of ReportItem
	* @return
	*/
	public String getReportItem() {
		return ReportItem;
	}

	/**
	* Sets new value of ReportItem
	* @param
	*/
	public void setReportItem(String ReportItem) {
		this.ReportItem = ReportItem;
	}

	/**
	* Returns value of ReportItemName
	* @return
	*/
	public String getReportItemName() {
		return ReportItemName;
	}

	/**
	* Sets new value of ReportItemName
	* @param
	*/
	public void setReportItemName(String ReportItemName) {
		this.ReportItemName = ReportItemName;
	}

	/**
	* Returns value of Month1
	* @return
	*/
	public String getMonth1() {
		return Month1;
	}

	/**
	* Sets new value of Month1
	* @param
	*/
	public void setMonth1(String Month1) {
		this.Month1 = Month1;
	}

	/**
	* Returns value of Month2
	* @return
	*/
	public String getMonth2() {
		return Month2;
	}

	/**
	* Sets new value of Month2
	* @param
	*/
	public void setMonth2(String Month2) {
		this.Month2 = Month2;
	}

	/**
	* Returns value of Month3
	* @return
	*/
	public String getMonth3() {
		return Month3;
	}

	/**
	* Sets new value of Month3
	* @param
	*/
	public void setMonth3(String Month3) {
		this.Month3 = Month3;
	}

	/**
	* Returns value of Month4
	* @return
	*/
	public String getMonth4() {
		return Month4;
	}

	/**
	* Sets new value of Month4
	* @param
	*/
	public void setMonth4(String Month4) {
		this.Month4 = Month4;
	}

	/**
	* Returns value of Month5
	* @return
	*/
	public String getMonth5() {
		return Month5;
	}

	/**
	* Sets new value of Month5
	* @param
	*/
	public void setMonth5(String Month5) {
		this.Month5 = Month5;
	}

	/**
	* Returns value of Month6
	* @return
	*/
	public String getMonth6() {
		return Month6;
	}

	/**
	* Sets new value of Month6
	* @param
	*/
	public void setMonth6(String Month6) {
		this.Month6 = Month6;
	}

	/**
	* Returns value of Month7
	* @return
	*/
	public String getMonth7() {
		return Month7;
	}

	/**
	* Sets new value of Month7
	* @param
	*/
	public void setMonth7(String Month7) {
		this.Month7 = Month7;
	}

	/**
	* Returns value of Month8
	* @return
	*/
	public String getMonth8() {
		return Month8;
	}

	/**
	* Sets new value of Month8
	* @param
	*/
	public void setMonth8(String Month8) {
		this.Month8 = Month8;
	}

	/**
	* Returns value of Month9
	* @return
	*/
	public String getMonth9() {
		return Month9;
	}

	/**
	* Sets new value of Month9
	* @param
	*/
	public void setMonth9(String Month9) {
		this.Month9 = Month9;
	}

	/**
	* Returns value of Month10
	* @return
	*/
	public String getMonth10() {
		return Month10;
	}

	/**
	* Sets new value of Month10
	* @param
	*/
	public void setMonth10(String Month10) {
		this.Month10 = Month10;
	}

	/**
	* Returns value of Month11
	* @return
	*/
	public String getMonth11() {
		return Month11;
	}

	/**
	* Sets new value of Month11
	* @param
	*/
	public void setMonth11(String Month11) {
		this.Month11 = Month11;
	}

	/**
	* Returns value of Month12
	* @return
	*/
	public String getMonth12() {
		return Month12;
	}

	/**
	* Sets new value of Month12
	* @param
	*/
	public void setMonth12(String Month12) {
		this.Month12 = Month12;
	}

	/**
	* Returns value of Annual
	* @return
	*/
	public String getAnnual() {
		return Annual;
	}

	/**
	* Sets new value of Annual
	* @param
	*/
	public void setAnnual(String Annual) {
		this.Annual = Annual;
	}
}
