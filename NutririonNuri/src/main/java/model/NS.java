package model;

public class NS {
    private int supId;
    private String name;
    private String effect;
    private String ingredient;
    private String manufacturer;
    private String precaution;
    private float rate;

    
    public NS(int supId, String name, String effect, String ingredient, String manufacturer, String precaution,
            float rate) {
        super();
        this.supId = supId;
        this.name = name;
        this.effect = effect;
        this.ingredient = ingredient;
        this.manufacturer = manufacturer;
        this.precaution = precaution;
        this.rate = rate;
    }

    public int getSupId() {
        return supId;
    }
    public void setSupId(int supId) {
        this.supId = supId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEffect() {
        return effect;
    }
    public void setEffect(String effect) {
        this.effect = effect;
    }
    public String getIngredient() {
        return ingredient;
    }
    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
    public String getmanufacturer() {
        return manufacturer;
    }
    public void setmanufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getPrecaution() {
        return precaution;
    }
    public void setPrecaution(String precaution) {
        this.precaution = precaution;
    }
    public float getRate() {
        return rate;
    }
    public void setRate(float rate) {
        this.rate = rate;
    }
}