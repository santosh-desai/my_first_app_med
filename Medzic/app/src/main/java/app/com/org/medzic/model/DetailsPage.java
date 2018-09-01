package app.com.org.medzic.model;

import java.util.List;

public class DetailsPage {

    private MedicineDetails medicineDetails;
    private List<RetailerDetails> retailerDetails;
    private List<MedicineDetails> alternateMedicines;

    public MedicineDetails getMedicineDetails() {
        return medicineDetails;
    }

    public void setMedicineDetails(MedicineDetails medicineDetails) {
        this.medicineDetails = medicineDetails;
    }

    public List<RetailerDetails> getRetailerDetails() {
        return retailerDetails;
    }

    public void setRetailerDetails(List<RetailerDetails> retailerDetails) {
        this.retailerDetails = retailerDetails;
    }

    public List<MedicineDetails> getAlternateMedicines() {
        return alternateMedicines;
    }

    public void setAlternateMedicines(List<MedicineDetails> alternateMedicines) {
        this.alternateMedicines = alternateMedicines;
    }
}
