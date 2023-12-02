package model;

public class NS {
    private int supId;
    private String name;
    private String effect;
    private String ingredient;
    private String manufacture;
    private String precaution;
    private float rate;
    private int searchVolume;
    
    public NS(int supId, String name, String effect, String ingredient, String manufacture, String precaution,
            float rate, int searchVolume) {
        super();
        this.supId = supId;
        this.name = name;
        this.effect = effect;
        this.ingredient = ingredient;
        this.manufacture = manufacture;
        this.precaution = precaution;
        this.rate = rate;
        this.searchVolume = 0;
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
    public String getManufacture() {
        return manufacture;
    }
    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
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
    public int getSearchVolume() {
        return searchVolume;
    }
    public void setSearchVolume(int searchVolume) {
        this.searchVolume = searchVolume;
    }
    
    
}
