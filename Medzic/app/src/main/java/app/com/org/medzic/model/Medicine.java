package app.com.org.medzic.model;

import java.io.Serializable;

public class Medicine implements Serializable {

    private int id;
    private int cmsId;
    private String name;
    private String content;
    private String desc;
    private String dosage;
    private String treatment;
    private String drugType;
    private String atcCode;

    public String getAtcCode() {
        return atcCode;
    }

    public void setAtcCode(String atcCode) {
        this.atcCode = atcCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCmsId() {
        return cmsId;
    }

    public void setCmsId(int cmsId) {
        this.cmsId = cmsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    @Override
    public String toString() {
        return getName();
    }
}
