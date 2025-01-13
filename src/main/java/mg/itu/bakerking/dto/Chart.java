package mg.itu.bakerking.dto;

import lombok.Data;
import lombok.Getter;
import mg.itu.bakerking.dto.transaction.ChiffreAffaireProduit;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Chart {
    List<String> labels;
    List<Datasets> datasets=new ArrayList<Datasets>();
    int borderWidth;
    boolean fill;

    public Chart(List<Double> data, List<String> labels, String label){
        this.borderWidth=1;
        this.fill=false;
        this.labels=labels;
        this.datasets.add(new Datasets(data,label));
    }

    public static Chart getChiffreAffaireProduitChar(List<ChiffreAffaireProduit> chiffreAffaireProduits){
        List<Double> data=new ArrayList<Double>();
        List<String> labels=new ArrayList<String>();
        for (ChiffreAffaireProduit chiffreAffaireProduit:chiffreAffaireProduits) {
            data.add(chiffreAffaireProduit.getChiffreAffaire());
            labels.add(chiffreAffaireProduit.getProduit());
        }
        return new Chart(data,labels,"Chiffre d'affaire");
    }
    @Getter
    public class Datasets{
        String label;
        List<Double> data;
        List<String> backgroundColor = new ArrayList<String>();
        List<String> borderColor = new ArrayList<String>();

        protected Datasets(List<Double> data,String label){
            this.label=label;
            this.data=data;
            this.setColor();
        }

        public static List<String> getBackColor(){
            List<String> response = new ArrayList<String>();
            response.add("rgba(255, 99, 132, 0.2)");
            response.add("rgba(54, 162, 235, 0.2)");
            response.add("rgba(255, 206, 86, 0.2)");
            response.add("rgba(75, 192, 192, 0.2)");
            response.add("rgba(153, 102, 255, 0.2)");
            response.add("rgba(255, 159, 64, 0.2)");
            return response;
        }

        protected void setColor(){
            List<String> backColor=getBackColor();
            for(int i=0;i<this.data.size();i++){
                this.backgroundColor.add(backColor.get(i % backColor.size()));
                this.borderColor.add(backColor.get(i % backColor.size()));
            }
        }
    }
}