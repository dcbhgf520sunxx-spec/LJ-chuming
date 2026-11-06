package com.hzchum.scim.mes.building.core.api.pojo._do.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("每月完成量")
public class AppCompleteSumDO {
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "completeQuantity", notes = "完成量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeMete", notes = "完成量")
   @JsonProperty("completeMete")
   @JSONField(name = "completeMete")
   private BigDecimal completeMete;
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

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteMete() {
      return this.completeMete;
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

   @JsonProperty("completeQuantity")
   public void setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   @JsonProperty("completeMete")
   public void setCompleteMete(final BigDecimal completeMete) {
      this.completeMete = completeMete;
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

      if (!(o instanceof AppCompleteSumDO)) {
         return false;
      }

      AppCompleteSumDO other = (AppCompleteSumDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$completeQuantity = this.getCompleteQuantity();
      Object other$completeQuantity = other.getCompleteQuantity();
      if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$area = this.getArea();
            Object other$area = other.getArea();
            if (this$area == null ? other$area == null : this$area.equals(other$area)) {
               Object this$completeMete = this.getCompleteMete();
               Object other$completeMete = other.getCompleteMete();
               if (this$completeMete == null ? other$completeMete == null : this$completeMete.equals(other$completeMete)) {
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
      return other instanceof AppCompleteSumDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $completeMete = this.getCompleteMete();
      result = result * 59 + ($completeMete == null ? 43 : $completeMete.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "AppCompleteSumDO(area="
         + this.getArea()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeMete="
         + this.getCompleteMete()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ")";
   }
}
