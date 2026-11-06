package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("每月完成量")
public class AppDispatchSumDO {
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "dispatchQuantity", notes = "出库数量")
   @JsonProperty("dispatchQuantity")
   @JSONField(name = "dispatchQuantity")
   private Integer dispatchQuantity;
   @ApiModelProperty(name = "dispatchMete", notes = "出库量")
   @JsonProperty("dispatchMete")
   @JSONField(name = "dispatchMete")
   private BigDecimal dispatchMete;
   @ApiModelProperty(name = "quantity", notes = "清单数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "mete", notes = "总清单量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;

   public AreaDetailDO getArea() {
      return this.area;
   }

   public Integer getDispatchQuantity() {
      return this.dispatchQuantity;
   }

   public BigDecimal getDispatchMete() {
      return this.dispatchMete;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   @JsonProperty("area")
   public void setArea(final AreaDetailDO area) {
      this.area = area;
   }

   @JsonProperty("dispatchQuantity")
   public void setDispatchQuantity(final Integer dispatchQuantity) {
      this.dispatchQuantity = dispatchQuantity;
   }

   @JsonProperty("dispatchMete")
   public void setDispatchMete(final BigDecimal dispatchMete) {
      this.dispatchMete = dispatchMete;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppDispatchSumDO)) {
         return false;
      }

      AppDispatchSumDO other = (AppDispatchSumDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$dispatchQuantity = this.getDispatchQuantity();
      Object other$dispatchQuantity = other.getDispatchQuantity();
      if (this$dispatchQuantity == null ? other$dispatchQuantity == null : this$dispatchQuantity.equals(other$dispatchQuantity)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$area = this.getArea();
            Object other$area = other.getArea();
            if (this$area == null ? other$area == null : this$area.equals(other$area)) {
               Object this$dispatchMete = this.getDispatchMete();
               Object other$dispatchMete = other.getDispatchMete();
               if (this$dispatchMete == null ? other$dispatchMete == null : this$dispatchMete.equals(other$dispatchMete)) {
                  Object this$mete = this.getMete();
                  Object other$mete = other.getMete();
                  return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
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
      return other instanceof AppDispatchSumDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dispatchQuantity = this.getDispatchQuantity();
      result = result * 59 + ($dispatchQuantity == null ? 43 : $dispatchQuantity.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $dispatchMete = this.getDispatchMete();
      result = result * 59 + ($dispatchMete == null ? 43 : $dispatchMete.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "AppDispatchSumDO(area="
         + this.getArea()
         + ", dispatchQuantity="
         + this.getDispatchQuantity()
         + ", dispatchMete="
         + this.getDispatchMete()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ")";
   }
}
