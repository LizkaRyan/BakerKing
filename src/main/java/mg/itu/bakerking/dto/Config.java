package mg.itu.bakerking.dto;

import lombok.Getter;

@Getter
public class Config {
    double commissiontaux;
    double commissionMin;

    public Config(double commissiontaux,double commissionMin){
        this.commissiontaux=commissiontaux;
        this.commissionMin=commissionMin;
    }
}
