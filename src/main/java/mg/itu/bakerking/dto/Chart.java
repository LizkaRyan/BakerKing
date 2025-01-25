package mg.itu.bakerking.dto;

import lombok.Getter;
import mg.itu.bakerking.dto.transaction.ChiffreAffaireProduit;
import mg.itu.bakerking.dto.transaction.CommissionGenre;

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
        this.fill=true;
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

    public static Chart getCommissionChart(List<CommissionGenre> commissionGenres){
        List<Double> data=new ArrayList<Double>();
        List<String> labels=new ArrayList<String>();
        for (CommissionGenre commissionGenre: commissionGenres) {
            data.add(commissionGenre.getMontant());
            labels.add(commissionGenre.getGenre());
        }
        return new Chart(data,labels,"Commission par genre");
    }

    @Getter
    public class Datasets{
        protected static List<String> backColor;
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
            if(backColor==null){
                List<String> response = new ArrayList<String>();
                response.add("rgba(255, 99, 132, 0.2)");
                response.add("rgba(54, 162, 235, 0.2)");
                response.add("rgba(255, 206, 86, 0.2)");
                response.add("rgba(75, 192, 192, 0.2)");
                response.add("rgba(153, 102, 255, 0.2)");
                response.add("rgba(255, 159, 64, 0.2)");
                backColor=response;
            }
            return backColor;
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