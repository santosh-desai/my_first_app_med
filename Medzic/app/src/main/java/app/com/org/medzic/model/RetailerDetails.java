package app.com.org.medzic.model;

public class RetailerDetails {

    private int DrugID;
    private String DrugName;
    private String DrugContents;
    private String ATCCode;
    private int CIMSClassID;
    private int ManufacturerID;
    private String DrugStatus;
    private String LastUpdated;
    private int uniquedrugId;
    private String created_by;
    private String DrugType;
    private String MRP;
    private int MediPackDetailsID;
    private String DrugForm;
    private int Rating;

    public int getDrugID() {
        return DrugID;
    }

    public void setDrugID(int drugID) {
        DrugID = drugID;
    }

    public String getDrugName() {
        return DrugName;
    }

    public void setDrugName(String drugName) {
        DrugName = drugName;
    }

    public String getDrugContents() {
        return DrugContents;
    }

    public void setDrugContents(String drugContents) {
        DrugContents = drugContents;
    }

    public String getATCCode() {
        return ATCCode;
    }

    public void setATCCode(String ATCCode) {
        this.ATCCode = ATCCode;
    }

    public int getCIMSClassID() {
        return CIMSClassID;
    }

    public void setCIMSClassID(int CIMSClassID) {
        this.CIMSClassID = CIMSClassID;
    }

    public int getManufacturerID() {
        return ManufacturerID;
    }

    public void setManufacturerID(int manufacturerID) {
        ManufacturerID = manufacturerID;
    }

    public String getDrugStatus() {
        return DrugStatus;
    }

    public void setDrugStatus(String drugStatus) {
        DrugStatus = drugStatus;
    }

    public String getLastUpdated() {
        return LastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        LastUpdated = lastUpdated;
    }

    public int getUniquedrugId() {
        return uniquedrugId;
    }

    public void setUniquedrugId(int uniquedrugId) {
        this.uniquedrugId = uniquedrugId;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getDrugType() {
        return DrugType;
    }

    public void setDrugType(String drugType) {
        DrugType = drugType;
    }

    public String getMRP() {
        return MRP;
    }

    public void setMRP(String MRP) {
        this.MRP = MRP;
    }

    public int getMediPackDetailsID() {
        return MediPackDetailsID;
    }

    public void setMediPackDetailsID(int mediPackDetailsID) {
        MediPackDetailsID = mediPackDetailsID;
    }

    public String getDrugForm() {
        return DrugForm;
    }

    public void setDrugForm(String drugForm) {
        DrugForm = drugForm;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }
}
