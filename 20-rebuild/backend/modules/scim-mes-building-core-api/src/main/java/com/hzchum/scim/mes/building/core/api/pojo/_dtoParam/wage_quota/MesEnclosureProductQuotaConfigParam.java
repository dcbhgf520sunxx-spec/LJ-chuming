package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("围护产品定额配置新增修改Param")
public class MesEnclosureProductQuotaConfigParam {
   @ApiModelProperty("主键ID")
   @NotNull(groups = Update.class, message = "ID不能为空")
   private Long id;
   @ApiModelProperty("车间IdList")
   @NotEmpty(groups = {Add.class, Update.class}, message = "车间ID不能为空")
   private List<Long> workshopIdList;
   @ApiModelProperty("产品类型")
   @NotNull(groups = {Add.class, Update.class}, message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty("是否需要规格分类(true: 需分类, false: 无需分类)")
   @NotNull(groups = {Add.class, Update.class}, message = "规格分类不能为空")
   private Boolean boolSpecificationClass;
   @ApiModelProperty("规格分类")
   private Integer specificationClassEnum;
   @ApiModelProperty("单价(元/米)")
   private BigDecimal price;
   @ApiModelProperty("详情List")
   @Valid
   private List<MesEnclosureProductQuotaConfigDetailParam> detailParamList;

   public Long getId() {
      return this.id;
   }

   public List<Long> getWorkshopIdList() {
      return this.workshopIdList;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Boolean getBoolSpecificationClass() {
      return this.boolSpecificationClass;
   }

   public Integer getSpecificationClassEnum() {
      return this.specificationClassEnum;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public List<MesEnclosureProductQuotaConfigDetailParam> getDetailParamList() {
      return this.detailParamList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWorkshopIdList(final List<Long> workshopIdList) {
      this.workshopIdList = workshopIdList;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setBoolSpecificationClass(final Boolean boolSpecificationClass) {
      this.boolSpecificationClass = boolSpecificationClass;
   }

   public void setSpecificationClassEnum(final Integer specificationClassEnum) {
      this.specificationClassEnum = specificationClassEnum;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setDetailParamList(final List<MesEnclosureProductQuotaConfigDetailParam> detailParamList) {
      this.detailParamList = detailParamList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProductQuotaConfigParam)) {
         return false;
      }

      MesEnclosureProductQuotaConfigParam other = (MesEnclosureProductQuotaConfigParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$boolSpecificationClass = this.getBoolSpecificationClass();
            Object other$boolSpecificationClass = other.getBoolSpecificationClass();
            if (this$boolSpecificationClass == null ? other$boolSpecificationClass == null : this$boolSpecificationClass.equals(other$boolSpecificationClass)) {
               Object this$specificationClassEnum = this.getSpecificationClassEnum();
               Object other$specificationClassEnum = other.getSpecificationClassEnum();
               if (this$specificationClassEnum == null
                  ? other$specificationClassEnum == null
                  : this$specificationClassEnum.equals(other$specificationClassEnum)) {
                  Object this$workshopIdList = this.getWorkshopIdList();
                  Object other$workshopIdList = other.getWorkshopIdList();
                  if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
                     Object this$price = this.getPrice();
                     Object other$price = other.getPrice();
                     if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                        Object this$detailParamList = this.getDetailParamList();
                        Object other$detailParamList = other.getDetailParamList();
                        return this$detailParamList == null ? other$detailParamList == null : this$detailParamList.equals(other$detailParamList);
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
      return other instanceof MesEnclosureProductQuotaConfigParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $boolSpecificationClass = this.getBoolSpecificationClass();
      result = result * 59 + ($boolSpecificationClass == null ? 43 : $boolSpecificationClass.hashCode());
      Object $specificationClassEnum = this.getSpecificationClassEnum();
      result = result * 59 + ($specificationClassEnum == null ? 43 : $specificationClassEnum.hashCode());
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $detailParamList = this.getDetailParamList();
      return result * 59 + ($detailParamList == null ? 43 : $detailParamList.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureProductQuotaConfigParam(id="
         + this.getId()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", productType="
         + this.getProductType()
         + ", boolSpecificationClass="
         + this.getBoolSpecificationClass()
         + ", specificationClassEnum="
         + this.getSpecificationClassEnum()
         + ", price="
         + this.getPrice()
         + ", detailParamList="
         + this.getDetailParamList()
         + ")";
   }
}
