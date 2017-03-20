package models;

import java.util.ArrayList;

public class CalculateModel {

    private int amount;
    private int rates_count;
    private float percent;
    private String rates_type;
    private ArrayList<CalculateRowModel> table_data = new ArrayList<>();

    public void setData(int amount, int rates_count, float percent, String rates_type){

        this.amount = amount*100; // na grosze
        this.rates_count = rates_count;
        this.percent = percent/100;
        this.rates_type = rates_type;

    }

    private void calculateEqualRates(){
        double q = 1 + (percent / 12);
        int month_rate = (int)Math.round( (amount * Math.pow(q, rates_count) * (q - 1)) / (Math.pow(q, rates_count) - 1) );
        int rate_left = amount;

        for(int i = 1; i<=rates_count; i++){
            CalculateRowModel rate = new CalculateRowModel();
            rate.setRate_number(i);
            rate.setRate_interest((int) Math.round(rate_left * (percent / 12)));
            rate.setRate_amount((int) Math.round(month_rate - rate.getRate_interest()));
            rate.setRate_sum(rate.getRate_amount()+rate.getRate_interest());
            rate_left -= rate.getRate_amount();
            table_data.add(rate);
        }
    }

    private void calculateDecreasingRates(){
        int rate_left = amount;
        for(int i = 1; i<=rates_count; i++){
            CalculateRowModel rate = new CalculateRowModel();
            rate.setRate_number(i);
            rate.setRate_amount((int) Math.round(amount / rates_count));
            rate.setRate_interest((int) Math.round(rate_left * (percent / 12)));
            rate.setRate_sum(rate.getRate_amount()+rate.getRate_interest());
            rate_left -= rate.getRate_amount();
            table_data.add(rate);
        }
    }

    public ArrayList<CalculateRowModel> getData(){
        if(rates_type.equals("equal")){
            calculateEqualRates();
        }
        if(rates_type.equals("decrease")){
            calculateDecreasingRates();
        }
        return table_data;
    }

}
