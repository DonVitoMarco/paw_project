package pl.thewalkingcode.model.dto;

import java.math.BigDecimal;

public class UserBuyItemDto {

    private String code;
    private String fullname;
    private Integer unit;
    private BigDecimal price;

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

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "UserBuyItemDto{" +
                "code='" + code + '\'' +
                ", fullname='" + fullname + '\'' +
                ", unit=" + unit +
                ", price=" + price +
                '}';
    }

}
