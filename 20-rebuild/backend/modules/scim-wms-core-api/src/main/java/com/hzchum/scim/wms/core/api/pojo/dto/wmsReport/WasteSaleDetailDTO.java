package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "WasteSaleDetail对象", description = "废料出售明细表 ")
public class WasteSaleDetailDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "WasteSaleId", value = "废料销售表id", notes = "废料销售表id")
   private Long WasteSaleId;
   @ApiModelProperty(name = "wasteClassificationId", value = "废料种类表id", notes = "废料种类表id")
   private Long wasteClassificationId;
   @ApiModelProperty(name = "wasteClassificationName", value = "废料种类名称", notes = "废料种类名称")
   private String wasteClassificationName;
   @ApiModelProperty(name = "measureUnit", value = "单位", notes = "单位")
   private String measureUnit;
   @ApiModelProperty(name = "saleMete", value = "销量", notes = "销量")
   private BigDecimal saleMete;
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   private BigDecimal price;
   @ApiModelProperty(name = "amount", value = "金额 = 销量*单价", notes = "金额 = 销量*单价")
   private BigDecimal amount;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "auditStatusEnum", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   private Integer auditStatusEnum;

   public static WasteSaleDetailDTO.WasteSaleDetailDTOBuilder builder() {
      return new WasteSaleDetailDTO.WasteSaleDetailDTOBuilder();
   }

   public WasteSaleDetailDTO() {
   }

   public WasteSaleDetailDTO(
      final Long id,
      final Long WasteSaleId,
      final Long wasteClassificationId,
      final String wasteClassificationName,
      final String measureUnit,
      final BigDecimal saleMete,
      final BigDecimal price,
      final BigDecimal amount,
      final String remark,
      final Integer auditStatusEnum
   ) {
      this.id = id;
      this.WasteSaleId = WasteSaleId;
      this.wasteClassificationId = wasteClassificationId;
      this.wasteClassificationName = wasteClassificationName;
      this.measureUnit = measureUnit;
      this.saleMete = saleMete;
      this.price = price;
      this.amount = amount;
      this.remark = remark;
      this.auditStatusEnum = auditStatusEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWasteSaleId() {
      return this.WasteSaleId;
   }

   public Long getWasteClassificationId() {
      return this.wasteClassificationId;
   }

   public String getWasteClassificationName() {
      return this.wasteClassificationName;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getSaleMete() {
      return this.saleMete;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWasteSaleId(final Long WasteSaleId) {
      this.WasteSaleId = WasteSaleId;
   }

   public void setWasteClassificationId(final Long wasteClassificationId) {
      this.wasteClassificationId = wasteClassificationId;
   }

   public void setWasteClassificationName(final String wasteClassificationName) {
      this.wasteClassificationName = wasteClassificationName;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setSaleMete(final BigDecimal saleMete) {
      this.saleMete = saleMete;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WasteSaleDetailDTO)) {
         return false;
      }

      WasteSaleDetailDTO other = (WasteSaleDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$WasteSaleId = this.getWasteSaleId();
         Object other$WasteSaleId = other.getWasteSaleId();
         if (this$WasteSaleId == null ? other$WasteSaleId == null : this$WasteSaleId.equals(other$WasteSaleId)) {
            Object this$wasteClassificationId = this.getWasteClassificationId();
            Object other$wasteClassificationId = other.getWasteClassificationId();
            if (this$wasteClassificationId == null ? other$wasteClassificationId == null : this$wasteClassificationId.equals(other$wasteClassificationId)) {
               Object this$auditStatusEnum = this.getAuditStatusEnum();
               Object other$auditStatusEnum = other.getAuditStatusEnum();
               if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                  Object this$wasteClassificationName = this.getWasteClassificationName();
                  Object other$wasteClassificationName = other.getWasteClassificationName();
                  if (this$wasteClassificationName == null
                     ? other$wasteClassificationName == null
                     : this$wasteClassificationName.equals(other$wasteClassificationName)) {
                     Object this$measureUnit = this.getMeasureUnit();
                     Object other$measureUnit = other.getMeasureUnit();
                     if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                        Object this$saleMete = this.getSaleMete();
                        Object other$saleMete = other.getSaleMete();
                        if (this$saleMete == null ? other$saleMete == null : this$saleMete.equals(other$saleMete)) {
                           Object this$price = this.getPrice();
                           Object other$price = other.getPrice();
                           if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                              Object this$amount = this.getAmount();
                              Object other$amount = other.getAmount();
                              if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof WasteSaleDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $WasteSaleId = this.getWasteSaleId();
      result = result * 59 + ($WasteSaleId == null ? 43 : $WasteSaleId.hashCode());
      Object $wasteClassificationId = this.getWasteClassificationId();
      result = result * 59 + ($wasteClassificationId == null ? 43 : $wasteClassificationId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $wasteClassificationName = this.getWasteClassificationName();
      result = result * 59 + ($wasteClassificationName == null ? 43 : $wasteClassificationName.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $saleMete = this.getSaleMete();
      result = result * 59 + ($saleMete == null ? 43 : $saleMete.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "WasteSaleDetailDTO(id="
         + this.getId()
         + ", WasteSaleId="
         + this.getWasteSaleId()
         + ", wasteClassificationId="
         + this.getWasteClassificationId()
         + ", wasteClassificationName="
         + this.getWasteClassificationName()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", saleMete="
         + this.getSaleMete()
         + ", price="
         + this.getPrice()
         + ", amount="
         + this.getAmount()
         + ", remark="
         + this.getRemark()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ")";
   }

   public static class WasteSaleDetailDTOBuilder {
      private Long id;
      private Long WasteSaleId;
      private Long wasteClassificationId;
      private String wasteClassificationName;
      private String measureUnit;
      private BigDecimal saleMete;
      private BigDecimal price;
      private BigDecimal amount;
      private String remark;
      private Integer auditStatusEnum;

      WasteSaleDetailDTOBuilder() {
      }

      public WasteSaleDetailDTO.WasteSaleDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WasteSaleDetailDTO.WasteSaleDetailDTOBuilder WasteSaleId(final Long WasteSaleId) {
         this.WasteSaleId = WasteSaleId;
         return this;
      }

      public WasteSaleDetailDTO.WasteSaleDetailDTOBuilder wasteClassificationId(final Long wasteClassificationId) {
         this.wasteClassificationId = wasteClassificationId;
         return this;
      }

      public WasteSaleDetailDTO.WasteSaleDetailDTOBuilder wasteClassificationName(final String wasteClassificationName) {
         this.wasteClassificationName = wasteClassificationName;
         return this;
      }

      public WasteSaleDetailDTO.WasteSaleDetailDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public WasteSaleDetailDTO.WasteSaleDetailDTOBuilder saleMete(final BigDecimal saleMete) {
         this.saleMete = saleMete;
         return this;
      }

      public WasteSaleDetailDTO.WasteSaleDetailDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public WasteSaleDetailDTO.WasteSaleDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public WasteSaleDetailDTO.WasteSaleDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public WasteSaleDetailDTO.WasteSaleDetailDTOBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public WasteSaleDetailDTO build() {
         return new WasteSaleDetailDTO(
            this.id,
            this.WasteSaleId,
            this.wasteClassificationId,
            this.wasteClassificationName,
            this.measureUnit,
            this.saleMete,
            this.price,
            this.amount,
            this.remark,
            this.auditStatusEnum
         );
      }

      @Override
      public String toString() {
         return "WasteSaleDetailDTO.WasteSaleDetailDTOBuilder(id="
            + this.id
            + ", WasteSaleId="
            + this.WasteSaleId
            + ", wasteClassificationId="
            + this.wasteClassificationId
            + ", wasteClassificationName="
            + this.wasteClassificationName
            + ", measureUnit="
            + this.measureUnit
            + ", saleMete="
            + this.saleMete
            + ", price="
            + this.price
            + ", amount="
            + this.amount
            + ", remark="
            + this.remark
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ")";
      }
   }
}
