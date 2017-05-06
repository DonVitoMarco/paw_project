package pl.thewalkingcode.model.dto;

import java.math.BigDecimal;

public class SellTransactionDto {

    private int idUserTranscation;
    private String code;
    private String fullname;
    private BigDecimal price;
    private BigDecimal amount;
    private int unit;

    public int getIdUserTranscation() {
        return idUserTranscation;
    }

    public void setIdUserTranscation(int idUserTranscation) {
        this.idUserTranscation = idUserTranscation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "SellTransactionDto{" +
                "idUserTranscation=" + idUserTranscation +
                ", code='" + code + '\'' +
                ", fullname='" + fullname + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", unit=" + unit +
                '}';
    }

}