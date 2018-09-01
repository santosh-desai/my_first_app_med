package app.com.org.medzic.model;

public class MedicineDetails {

    //Api = https://medzic.net/search/getDesiredMediPackDetails?drppckID=1410

    private int mediPackId;
    private int DrugId;
    private String drugType;
    private String mrp;
    private String packing;
    private String atcCode;
    private String manfacturer;
    private String drugName;
    private String cimsClass;
    private String drugContent;
    private String treatmentType;
    private String dosage;
    private int uniqueDrgId;
    private int atcCodeId;

    public int getMediPackId() {
        return mediPackId;
    }

    public void setMediPackId(int mediPackId) {
        this.mediPackId = mediPackId;
    }

    public int getDrugId() {
        return DrugId;
    }

    public void setDrugId(int drugId) {
        DrugId = drugId;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getAtcCode() {
        return atcCode;
    }

    public void setAtcCode(String atcCode) {
        this.atcCode = atcCode;
    }

    public String getManfacturer() {
        return manfacturer;
    }

    public void setManfacturer(String manfacturer) {
        this.manfacturer = manfacturer;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getCimsClass() {
        return cimsClass;
    }

    public void setCimsClass(String cimsClass) {
        this.cimsClass = cimsClass;
    }

    public String getDrugContent() {
        return drugContent;
    }

    public void setDrugContent(String drugContent) {
        this.drugContent = drugContent;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public int getUniqueDrgId() {
        return uniqueDrgId;
    }

    public void setUniqueDrgId(int uniqueDrgId) {
        this.uniqueDrgId = uniqueDrgId;
    }

    public int getAtcCodeId() {
        return atcCodeId;
    }

    public void setAtcCodeId(int atcCodeId) {
        this.atcCodeId = atcCodeId;
    }
}
