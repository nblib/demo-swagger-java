package demo.nblib.swagger.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "carInfo", description = "车相关的信息")
public class CarInfo {
    @ApiModelProperty("汽车的id")
    private String infoId;
    @ApiModelProperty("汽车的品牌")
    private String specName;

    @ApiModelProperty(value = "汽车价格", allowableValues = "range[0,9999999]")
    private Float price;

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
