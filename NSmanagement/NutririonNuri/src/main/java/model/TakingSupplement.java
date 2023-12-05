package model;

import java.util.Date;

public class TakingSupplement {
    private int intakeInform;
    private Date intakeTime;
    private int intakeAmount;
    private float rate;
    private int supId;
    private int memId;
    
    public TakingSupplement(int intakeInform, Date intakeTime, int intakeAmount, float rate, int supId, int memId) {
        super();
        this.intakeInform = intakeInform;
        this.intakeTime = intakeTime;
        this.intakeAmount = intakeAmount;
        this.rate = rate;
        this.supId = supId;
        this.memId = memId;
    }
    
    public int getIntakeInform() {
        return intakeInform;
    }
    public void setIntakeInform(int intakeInform) {
        this.intakeInform = intakeInform;
    }
    public Date getIntakeTime() {
        return intakeTime;
    }
    public void setIntakeTime(Date intakeTime) {
        this.intakeTime = intakeTime;
    }
    public int getIntakeAmount() {
        return intakeAmount;
    }
    public void setIntakeAmount(int intakeAmount) {
        this.intakeAmount = intakeAmount;
    }
    public float getRate() {
        return rate;
    }
    public void setRate(float rate) {
        this.rate = rate;
    }
    public int getSupId() {
        return supId;
    }
    public void setSupId(int supId) {
        this.supId = supId;
    }
    public int getMemId() {
        return memId;
    }
    public void setMemId(int memId) {
        this.memId = memId;
    }
}