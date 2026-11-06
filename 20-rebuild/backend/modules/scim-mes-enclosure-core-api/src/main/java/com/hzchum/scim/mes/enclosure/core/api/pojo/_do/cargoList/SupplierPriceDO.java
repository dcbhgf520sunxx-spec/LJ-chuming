package com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "物流管理列表")
public class SupplierPriceDO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   private Long id;
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("供应商信息")
   private NameInfo supplier;
   @ApiModelProperty("计价方式 [1重量, 2 车次]")
   private Integer priceType;
   @ApiModelProperty("计价方式 [1重量, 2 车次]")
   private Integer invoiceTypeEnum;
   @ApiModelProperty("价格")
   private BigDecimal price;
   @ApiModelProperty("是否含税 [0 包含 1 不包含]")
   private Boolean boolContainTaxEnum;
   @ApiModelProperty("税率")
   private BigDecimal tax;
   @ApiModelProperty("填写人id")
   private Long userId;
   @ApiModelProperty("填写人名称")
   private String userName;
   @ApiModelProperty("是否使用")
   private Boolean boolUseEnum;
   @ApiModelProperty("填写人名称")
   private String createTime;
   @ApiModelProperty(name = "carModel", value = "车型", notes = "车型")
   @JsonProperty("carModel")
   @JSONField(name = "carModel")
   private String carModel;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   @JsonProperty("licensePlate")
   @JSONField(name = "licensePlate")
   private String licensePlate;
   @ApiModelProperty(name = "boolPersonalEnum", value = "是否个人  ", notes = "是否个人 ")
   @JsonProperty("boolPersonalEnum")
   @JSONField(name = "boolPersonalEnum")
   private Boolean boolPersonalEnum;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getSupplier() {
      return this.supplier;
   }

   public Integer getPriceType() {
      return this.priceType;
   }

   public Integer getInvoiceTypeEnum() {
      return this.invoiceTypeEnum;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Boolean getBoolContainTaxEnum() {
      return this.boolContainTaxEnum;
   }

   public BigDecimal getTax() {
      return this.tax;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Boolean getBoolUseEnum() {
      return this.boolUseEnum;
   }

   public String getCreateTime() {
      return this.createTime;
   }

   public String getCarModel() {
      return this.carModel;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public Boolean getBoolPersonalEnum() {
      return this.boolPersonalEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setSupplier(final NameInfo supplier) {
      this.supplier = supplier;
   }

   public void setPriceType(final Integer priceType) {
      this.priceType = priceType;
   }

   public void setInvoiceTypeEnum(final Integer invoiceTypeEnum) {
      this.invoiceTypeEnum = invoiceTypeEnum;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setBoolContainTaxEnum(final Boolean boolContainTaxEnum) {
      this.boolContainTaxEnum = boolContainTaxEnum;
   }

   public void setTax(final BigDecimal tax) {
      this.tax = tax;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setBoolUseEnum(final Boolean boolUseEnum) {
      this.boolUseEnum = boolUseEnum;
   }

   public void setCreateTime(final String createTime) {
      this.createTime = createTime;
   }

   @JsonProperty("carModel")
   public void setCarModel(final String carModel) {
      this.carModel = carModel;
   }

   @JsonProperty("licensePlate")
   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   @JsonProperty("boolPersonalEnum")
   public void setBoolPersonalEnum(final Boolean boolPersonalEnum) {
      this.boolPersonalEnum = boolPersonalEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPriceDO)) {
         return false;
      }

      SupplierPriceDO other = (SupplierPriceDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$priceType = this.getPriceType();
         Object other$priceType = other.getPriceType();
         if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
            Object this$invoiceTypeEnum = this.getInvoiceTypeEnum();
            Object other$invoiceTypeEnum = other.getInvoiceTypeEnum();
            if (this$invoiceTypeEnum == null ? other$invoiceTypeEnum == null : this$invoiceTypeEnum.equals(other$invoiceTypeEnum)) {
               Object this$boolContainTaxEnum = this.getBoolContainTaxEnum();
               Object other$boolContainTaxEnum = other.getBoolContainTaxEnum();
               if (this$boolContainTaxEnum == null ? other$boolContainTaxEnum == null : this$boolContainTaxEnum.equals(other$boolContainTaxEnum)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$boolUseEnum = this.getBoolUseEnum();
                     Object other$boolUseEnum = other.getBoolUseEnum();
                     if (this$boolUseEnum == null ? other$boolUseEnum == null : this$boolUseEnum.equals(other$boolUseEnum)) {
                        Object this$boolPersonalEnum = this.getBoolPersonalEnum();
                        Object other$boolPersonalEnum = other.getBoolPersonalEnum();
                        if (this$boolPersonalEnum == null ? other$boolPersonalEnum == null : this$boolPersonalEnum.equals(other$boolPersonalEnum)) {
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                              Object this$supplier = this.getSupplier();
                              Object other$supplier = other.getSupplier();
                              if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                                 Object this$price = this.getPrice();
                                 Object other$price = other.getPrice();
                                 if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                    Object this$tax = this.getTax();
                                    Object other$tax = other.getTax();
                                    if (this$tax == null ? other$tax == null : this$tax.equals(other$tax)) {
                                       Object this$userName = this.getUserName();
                                       Object other$userName = other.getUserName();
                                       if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                          Object this$createTime = this.getCreateTime();
                                          Object other$createTime = other.getCreateTime();
                                          if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                             Object this$carModel = this.getCarModel();
                                             Object other$carModel = other.getCarModel();
                                             if (this$carModel == null ? other$carModel == null : this$carModel.equals(other$carModel)) {
                                                Object this$licensePlate = this.getLicensePlate();
                                                Object other$licensePlate = other.getLicensePlate();
                                                return this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate);
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SupplierPriceDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $invoiceTypeEnum = this.getInvoiceTypeEnum();
      result = result * 59 + ($invoiceTypeEnum == null ? 43 : $invoiceTypeEnum.hashCode());
      Object $boolContainTaxEnum = this.getBoolContainTaxEnum();
      result = result * 59 + ($boolContainTaxEnum == null ? 43 : $boolContainTaxEnum.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolUseEnum = this.getBoolUseEnum();
      result = result * 59 + ($boolUseEnum == null ? 43 : $boolUseEnum.hashCode());
      Object $boolPersonalEnum = this.getBoolPersonalEnum();
      result = result * 59 + ($boolPersonalEnum == null ? 43 : $boolPersonalEnum.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $tax = this.getTax();
      result = result * 59 + ($tax == null ? 43 : $tax.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $carModel = this.getCarModel();
      result = result * 59 + ($carModel == null ? 43 : $carModel.hashCode());
      Object $licensePlate = this.getLicensePlate();
      return result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierPriceDO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", supplier="
         + this.getSupplier()
         + ", priceType="
         + this.getPriceType()
         + ", invoiceTypeEnum="
         + this.getInvoiceTypeEnum()
         + ", price="
         + this.getPrice()
         + ", boolContainTaxEnum="
         + this.getBoolContainTaxEnum()
         + ", tax="
         + this.getTax()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", boolUseEnum="
         + this.getBoolUseEnum()
         + ", createTime="
         + this.getCreateTime()
         + ", carModel="
         + this.getCarModel()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", boolPersonalEnum="
         + this.getBoolPersonalEnum()
         + ")";
   }
}
