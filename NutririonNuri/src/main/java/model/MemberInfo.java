package model;

public class MemberInfo {
    private int MemId;
    private float Height;
    private float Weight;
    private char Smoke;
    private char Alchol;
    private char Pregnant;
    private String Medicine;
    private String Supplement;
    private String PrefIngredient;
    
    public MemberInfo() {};
    
    public MemberInfo(float height, float weight, char smoke, char alchol, char pregnant, String medicine,
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

    public MemberInfo(int memId, float height, float weight, char smoke, char alchol, 
            char pregnant, String medicine, String supplement, String prefIngredient) {
        super();
        MemId = memId;
        Height = height;
        Weight = weight;
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
    
    public char getSmoke() {
        return Smoke;
    }
    
    public void setSmoke(char smoke) {
        Smoke = smoke;
    }
    
    public char getAlchol() {
        return Alchol;
    }

    public void setAlchol(char alchol) {
        Alchol = alchol;
    }

    public char getPregnant() {
        return Pregnant;
    }

    public void setPregnant(char pregnant) {
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