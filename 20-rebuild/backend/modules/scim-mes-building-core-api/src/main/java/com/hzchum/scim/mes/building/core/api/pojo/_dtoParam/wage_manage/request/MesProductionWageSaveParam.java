package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request;

import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("生产工资保存参数类")
public class MesProductionWageSaveParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   private Long id;
   @ApiModelProperty(name = "measurementQuantity", value = "计量量", notes = "计量量")
   @NotNull(groups = Update.class, message = "计量量不能为空")
   @Min(groups = Update.class, value = 0L, message = "计量量不能小于0")
   private BigDecimal measurementQuantity;
   @ApiModelProperty(name = "wage", value = "工价(元)", notes = "工价(元)")
   @NotNull(groups = Update.class, message = "定额单价不能为空")
   @Min(groups = Update.class, value = 0L, message = "定额单价不能小于0")
   private BigDecimal wage;

   public Long getId() {
      return this.id;
   }

   public BigDecimal getMeasurementQuantity() {
      return this.measurementQuantity;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMeasurementQuantity(final BigDecimal measurementQuantity) {
      this.measurementQuantity = measurementQuantity;
   }

   public void setWage(final BigDecimal wage) {
      this.wage = wage;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionWageSaveParam)) {
         return false;
      }

      MesProductionWageSaveParam other = (MesProductionWageSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$measurementQuantity = this.getMeasurementQuantity();
         Object other$measurementQuantity = other.getMeasurementQuantity();
         if (this$measurementQuantity == null ? other$measurementQuantity == null : this$measurementQuantity.equals(other$measurementQuantity)) {
            Object this$wage = this.getWage();
            Object other$wage = other.getWage();
            return this$wage == null ? other$wage == null : this$wage.equals(other$wage);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesProductionWageSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $measurementQuantity = this.getMeasurementQuantity();
      result = result * 59 + ($measurementQuantity == null ? 43 : $measurementQuantity.hashCode());
      Object $wage = this.getWage();
      return result * 59 + ($wage == null ? 43 : $wage.hashCode());
   }

   @Override
   public String toString() {
      return "MesProductionWageSaveParam(id=" + this.getId() + ", measurementQuantity=" + this.getMeasurementQuantity() + ", wage=" + this.getWage() + ")";
   }
}
