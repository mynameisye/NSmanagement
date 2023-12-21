package model;

public class MemberInfo {
    private int MemId;
    private float Height;
    private float Weight;
    private String Disease;
    private int Smoke;
    private int Alchol;
    private int Pregnant;
    private String Medicine;
    private String Supplement;
    private String PrefIngredient;
    
    public MemberInfo() {};
    
    public MemberInfo(float height, float weight, int smoke, int alchol, int pregnant, String medicine,
            String supplement, String prefIngredient) {
        super();
        Height = height;
        Weight = weight;
        Smoke = smoke;
        Alchol = alchol;
        Pregnant = pregnant;
        Medicine = medicine;
        Supplement = supplement;
        PrefIngredient = prefIngredient;
    }

    public MemberInfo(int memId, float height, float weight, String disease, int smoke, int alchol, 
            int pregnant, String medicine, String supplement, String prefIngredient) {
        super();
        MemId = memId;
        Height = height;
        Weight = weight;
        Disease = disease;
        Smoke = smoke;
        Alchol = alchol;
        Pregnant = pregnant;
        Medicine = medicine;
        Supplement = supplement;
        PrefIngredient = prefIngredient;
    }
    
    public int getMemId() {
        return MemId;
    }
    public void setMemId(int memId) {
        MemId = memId;
    }
    public float getHeight() {
        return Height;
    }
    public void setHeight(float height) {
        Height = height;
    }
    public float getWeight() {
        return Weight;
    }
    public void setWeight(float weight) {
        Weight = weight;
    }
    public String getDisease() {
        return Disease;
    }
    public void setDisease(String disease) {
        Disease = disease;
    }
    public int getSmoke() {
        return Smoke;
    }
    public void setSmoke(int smoke) {
        Smoke = smoke;
    }
    public int getAlchol() {
        return Alchol;
    }
    public void setSupId(int alchol) {
        Alchol = alchol;
    }
    public int getPregnant() {
        return Pregnant;
    }
    public void setPregnant(int pregnant ) {
        Pregnant = pregnant;
    }
    public String getMedicine() {
        return Medicine;
    }
    public void setMedicine(String medicine) {
        Medicine = medicine;
    }
    public String getSupplement() {
        return Supplement;
    }
    public void setSupplement(String supplement) {
        Supplement = supplement;
    }
    public String getPrefIngredient() {
        return PrefIngredient;
    }
    public void setPrefIngredient(String prefIngredient) {
        PrefIngredient = prefIngredient;
    }
}