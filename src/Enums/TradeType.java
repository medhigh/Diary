package Enums;

/**
 * Created by med_high on 03.02.2015.
 */
public enum TradeType {
    B("Buy"), S("Sell"), SS("Short");
    private String declaration;
    TradeType(String s){declaration= s;}
    public String getDeclaration(){return declaration;}
}
