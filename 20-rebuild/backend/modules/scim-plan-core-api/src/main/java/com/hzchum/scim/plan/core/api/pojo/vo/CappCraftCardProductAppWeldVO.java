package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP app焊接工艺焊缝 响应参数")
public class CappCraftCardProductAppWeldVO {
   private Long id;
   @ApiModelProperty(name = "weldingSerialNumber", value = "焊缝编号", notes = "焊缝编号")
   private String weldingSerialNumber;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号", notes = "产品编号")
   private String productSerialNumber;
   @ApiModelProperty(name = "weldingBaseJointType", value = "接头形式", notes = "接头形式")
   private String weldingBaseJointType;
   @ApiModelProperty(name = "techCappCraftCardStorehouseId", value = "焊接工艺id", notes = "焊接工艺id")
   private Long techCappCraftCardStorehouseId;
   @ApiModelProperty(name = "echCappCraftCardStorehouseSerialNumber", value = "工艺编号", notes = "工艺编号")
   private String techCappCraftCardStorehouseSerialNumber;
   @ApiModelProperty(name = "weldingBaseWeldingMethod", value = "焊接方法", notes = "焊接方法")
   private String weldingBaseWeldingMethod;
   @ApiModelProperty(
      name = "techCappProductTaskWorkType",
      value = "capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum",
      notes = "capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum"
   )
   private Integer techCappProductTaskWorkType;

   public Long getId() {
      return this.id;
   }

   public String getWeldingSerialNumber() {
      return this.weldingSerialNumber;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public String getWeldingBaseJointType() {
      return this.weldingBaseJointType;
   }

   public Long getTechCappCraftCardStorehouseId() {
      return this.techCappCraftCardStorehouseId;
   }

   public String getTechCappCraftCardStorehouseSerialNumber() {
      return this.techCappCraftCardStorehouseSerialNumber;
   }

   public String getWeldingBaseWeldingMethod() {
      return this.weldingBaseWeldingMethod;
   }

   public Integer getTechCappProductTaskWorkType() {
      return this.techCappProductTaskWorkType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWeldingSerialNumber(final String weldingSerialNumber) {
      this.weldingSerialNumber = weldingSerialNumber;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setWeldingBaseJointType(final String weldingBaseJointType) {
      this.weldingBaseJointType = weldingBaseJointType;
   }

   public void setTechCappCraftCardStorehouseId(final Long techCappCraftCardStorehouseId) {
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
   }

   public void setTechCappCraftCardStorehouseSerialNumber(final String techCappCraftCardStorehouseSerialNumber) {
      this.techCappCraftCardStorehouseSerialNumber = techCappCraftCardStorehouseSerialNumber;
   }

   public void setWeldingBaseWeldingMethod(final String weldingBaseWeldingMethod) {
      this.weldingBaseWeldingMethod = weldingBaseWeldingMethod;
   }

   public void setTechCappProductTaskWorkType(final Integer techCappProductTaskWorkType) {
      this.techCappProductTaskWorkType = techCappProductTaskWorkType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardProductAppWeldVO)) {
         return false;
      }

      CappCraftCardProductAppWeldVO other = (CappCraftCardProductAppWeldVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
         Object other$techCappCraftCardStorehouseId = other.getTechCappCraftCardStorehouseId();
         if (this$techCappCraftCardStorehouseId == null
            ? other$techCappCraftCardStorehouseId == null
            : this$techCappCraftCardStorehouseId.equals(other$techCappCraftCardStorehouseId)) {
            Object this$techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
            Object other$techCappProductTaskWorkType = other.getTechCappProductTaskWorkType();
            if (this$techCappProductTaskWorkType == null
               ? other$techCappProductTaskWorkType == null
               : this$techCappProductTaskWorkType.equals(other$techCappProductTaskWorkType)) {
               Object this$weldingSerialNumber = this.getWeldingSerialNumber();
               Object other$weldingSerialNumber = other.getWeldingSerialNumber();
               if (this$weldingSerialNumber == null ? other$weldingSerialNumber == null : this$weldingSerialNumber.equals(other$weldingSerialNumber)) {
                  Object this$productSerialNumber = this.getProductSerialNumber();
                  Object other$productSerialNumber = other.getProductSerialNumber();
                  if (this$productSerialNumber == null ? other$productSerialNumber == null : this$productSerialNumber.equals(other$productSerialNumber)) {
                     Object this$weldingBaseJointType = this.getWeldingBaseJointType();
                     Object other$weldingBaseJointType = other.getWeldingBaseJointType();
                     if (this$weldingBaseJointType == null ? other$weldingBaseJointType == null : this$weldingBaseJointType.equals(other$weldingBaseJointType)) {
                        Object this$techCappCraftCardStorehouseSerialNumber = this.getTechCappCraftCardStorehouseSerialNumber();
                        Object other$techCappCraftCardStorehouseSerialNumber = other.getTechCappCraftCardStorehouseSerialNumber();
                        if (this$techCappCraftCardStorehouseSerialNumber == null
                           ? other$techCappCraftCardStorehouseSerialNumber == null
                           : this$techCappCraftCardStorehouseSerialNumber.equals(other$techCappCraftCardStorehouseSerialNumber)) {
                           Object this$weldingBaseWeldingMethod = this.getWeldingBaseWeldingMethod();
                           Object other$weldingBaseWeldingMethod = other.getWeldingBaseWeldingMethod();
                           return this$weldingBaseWeldingMethod == null
                              ? other$weldingBaseWeldingMethod == null
                              : this$weldingBaseWeldingMethod.equals(other$weldingBaseWeldingMethod);
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
      return other instanceof CappCraftCardProductAppWeldVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
      result = result * 59 + ($techCappCraftCardStorehouseId == null ? 43 : $techCappCraftCardStorehouseId.hashCode());
      Object $techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
      result = result * 59 + ($techCappProductTaskWorkType == null ? 43 : $techCappProductTaskWorkType.hashCode());
      Object $weldingSerialNumber = this.getWeldingSerialNumber();
      result = result * 59 + ($weldingSerialNumber == null ? 43 : $weldingSerialNumber.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $weldingBaseJointType = this.getWeldingBaseJointType();
      result = result * 59 + ($weldingBaseJointType == null ? 43 : $weldingBaseJointType.hashCode());
      Object $techCappCraftCardStorehouseSerialNumber = this.getTechCappCraftCardStorehouseSerialNumber();
      result = result * 59 + ($techCappCraftCardStorehouseSerialNumber == null ? 43 : $techCappCraftCardStorehouseSerialNumber.hashCode());
      Object $weldingBaseWeldingMethod = this.getWeldingBaseWeldingMethod();
      return result * 59 + ($weldingBaseWeldingMethod == null ? 43 : $weldingBaseWeldingMethod.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductAppWeldVO(id="
         + this.getId()
         + ", weldingSerialNumber="
         + this.getWeldingSerialNumber()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", weldingBaseJointType="
         + this.getWeldingBaseJointType()
         + ", techCappCraftCardStorehouseId="
         + this.getTechCappCraftCardStorehouseId()
         + ", techCappCraftCardStorehouseSerialNumber="
         + this.getTechCappCraftCardStorehouseSerialNumber()
         + ", weldingBaseWeldingMethod="
         + this.getWeldingBaseWeldingMethod()
         + ", techCappProductTaskWorkType="
         + this.getTechCappProductTaskWorkType()
         + ")";
   }
}
