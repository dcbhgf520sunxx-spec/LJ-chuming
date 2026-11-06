package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@ApiModel("其他分摊新增类")
public class MesOtherApportionmentSaveDTOParam {
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @NotBlank(groups = {Add.class, Update.class}, message = "类型不能为空")
   @Size(max = 20, groups = {Add.class, Update.class}, message = "类型名称过长")
   @ApiModelProperty(name = "type", value = "类型", notes = "类型")
   private String type;
   @ApiModelProperty(name = "unit", value = "计量单位（统一为吨）", notes = "计量单位")
   private String unit;
   @NotNull(groups = {Add.class, Update.class}, message = "单价不能为空")
   @DecimalMin(groups = {Add.class, Update.class}, value = "0.01", message = "单价不能小于0.01")
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   private BigDecimal price;
   @NotNull(groups = Update.class, message = "状态不能为空")
   @ApiModelProperty(name = "status", value = "状态", notes = "状态")
   private Boolean status;
   @NotNull(groups = {Add.class, Update.class}, message = "车间ID不能为空")
   @ApiModelProperty(name = "factoryId", value = "车间ID", notes = "车间ID")
   private Long workshopId;
   @NotNull(groups = {Add.class, Update.class}, message = "入库量不能为空")
   @Positive(groups = {Add.class, Update.class}, message = "入库量要大于0")
   @ApiModelProperty(name = "inventoryQuantity", value = "入库量(吨)", notes = "入库量(吨)")
   private BigDecimal inventoryQuantity;

   public static MesOtherApportionmentSaveDTOParam.MesOtherApportionmentSaveDTOParamBuilder builder() {
      return new MesOtherApportionmentSaveDTOParam.MesOtherApportionmentSaveDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getType() {
      return this.type;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public BigDecimal getInventoryQuantity() {
      return this.inventoryQuantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setInventoryQuantity(final BigDecimal inventoryQuantity) {
      this.inventoryQuantity = inventoryQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesOtherApportionmentSaveDTOParam)) {
         return false;
      }

      MesOtherApportionmentSaveDTOParam other = (MesOtherApportionmentSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$unit = this.getUnit();
                  Object other$unit = other.getUnit();
                  if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                     Object this$price = this.getPrice();
                     Object other$price = other.getPrice();
                     if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                        Object this$inventoryQuantity = this.getInventoryQuantity();
                        Object other$inventoryQuantity = other.getInventoryQuantity();
                        return this$inventoryQuantity == null ? other$inventoryQuantity == null : this$inventoryQuantity.equals(other$inventoryQuantity);
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
      return other instanceof MesOtherApportionmentSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $inventoryQuantity = this.getInventoryQuantity();
      return result * 59 + ($inventoryQuantity == null ? 43 : $inventoryQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "MesOtherApportionmentSaveDTOParam(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", unit="
         + this.getUnit()
         + ", price="
         + this.getPrice()
         + ", status="
         + this.getStatus()
         + ", workshopId="
         + this.getWorkshopId()
         + ", inventoryQuantity="
         + this.getInventoryQuantity()
         + ")";
   }

   public MesOtherApportionmentSaveDTOParam(
      final Long id,
      final String type,
      final String unit,
      final BigDecimal price,
      final Boolean status,
      final Long workshopId,
      final BigDecimal inventoryQuantity
   ) {
      this.id = id;
      this.type = type;
      this.unit = unit;
      this.price = price;
      this.status = status;
      this.workshopId = workshopId;
      this.inventoryQuantity = inventoryQuantity;
   }

   public MesOtherApportionmentSaveDTOParam() {
   }

   public static class MesOtherApportionmentSaveDTOParamBuilder {
      private Long id;
      private String type;
      private String unit;
      private BigDecimal price;
      private Boolean status;
      private Long workshopId;
      private BigDecimal inventoryQuantity;

      MesOtherApportionmentSaveDTOParamBuilder() {
      }

      public MesOtherApportionmentSaveDTOParam.MesOtherApportionmentSaveDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesOtherApportionmentSaveDTOParam.MesOtherApportionmentSaveDTOParamBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public MesOtherApportionmentSaveDTOParam.MesOtherApportionmentSaveDTOParamBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesOtherApportionmentSaveDTOParam.MesOtherApportionmentSaveDTOParamBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesOtherApportionmentSaveDTOParam.MesOtherApportionmentSaveDTOParamBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesOtherApportionmentSaveDTOParam.MesOtherApportionmentSaveDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesOtherApportionmentSaveDTOParam.MesOtherApportionmentSaveDTOParamBuilder inventoryQuantity(final BigDecimal inventoryQuantity) {
         this.inventoryQuantity = inventoryQuantity;
         return this;
      }

      public MesOtherApportionmentSaveDTOParam build() {
         return new MesOtherApportionmentSaveDTOParam(this.id, this.type, this.unit, this.price, this.status, this.workshopId, this.inventoryQuantity);
      }

      @Override
      public String toString() {
         return "MesOtherApportionmentSaveDTOParam.MesOtherApportionmentSaveDTOParamBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", unit="
            + this.unit
            + ", price="
            + this.price
            + ", status="
            + this.status
            + ", workshopId="
            + this.workshopId
            + ", inventoryQuantity="
            + this.inventoryQuantity
            + ")";
      }
   }
}
