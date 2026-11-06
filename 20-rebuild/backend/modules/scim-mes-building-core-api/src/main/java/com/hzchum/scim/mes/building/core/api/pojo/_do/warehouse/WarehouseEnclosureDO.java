package com.hzchum.scim.mes.building.core.api.pojo._do.warehouse;

import com.hzchum.scim.common.core.api.pojo.common.EnclosureBaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("出入库围护信息")
public class WarehouseEnclosureDO extends EnclosureBaseInfo {
   @ApiModelProperty("入库数量")
   private Integer inboundQuantity;
   @ApiModelProperty("入库量")
   private BigDecimal inboundMete;
   @ApiModelProperty("出库数量")
   private Integer outboundQuantity;
   @ApiModelProperty("出库量")
   private BigDecimal outboundMete;
   @ApiModelProperty("任务数量")
   private Integer taskQuantity;
   @ApiModelProperty("任务量")
   private BigDecimal taskMete;
   @ApiModelProperty("库存数量")
   private Integer stockQuantity;
   @ApiModelProperty("库存量")
   private BigDecimal stockMete;

   public Integer getInboundQuantity() {
      return this.inboundQuantity;
   }

   public BigDecimal getInboundMete() {
      return this.inboundMete;
   }

   public Integer getOutboundQuantity() {
      return this.outboundQuantity;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTaskMete() {
      return this.taskMete;
   }

   public Integer getStockQuantity() {
      return this.stockQuantity;
   }

   public BigDecimal getStockMete() {
      return this.stockMete;
   }

   public void setInboundQuantity(final Integer inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
   }

   public void setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
   }

   public void setOutboundQuantity(final Integer outboundQuantity) {
      this.outboundQuantity = outboundQuantity;
   }

   public void setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
   }

   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   public void setTaskMete(final BigDecimal taskMete) {
      this.taskMete = taskMete;
   }

   public void setStockQuantity(final Integer stockQuantity) {
      this.stockQuantity = stockQuantity;
   }

   public void setStockMete(final BigDecimal stockMete) {
      this.stockMete = stockMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseEnclosureDO)) {
         return false;
      }

      WarehouseEnclosureDO other = (WarehouseEnclosureDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inboundQuantity = this.getInboundQuantity();
      Object other$inboundQuantity = other.getInboundQuantity();
      if (this$inboundQuantity == null ? other$inboundQuantity == null : this$inboundQuantity.equals(other$inboundQuantity)) {
         Object this$outboundQuantity = this.getOutboundQuantity();
         Object other$outboundQuantity = other.getOutboundQuantity();
         if (this$outboundQuantity == null ? other$outboundQuantity == null : this$outboundQuantity.equals(other$outboundQuantity)) {
            Object this$taskQuantity = this.getTaskQuantity();
            Object other$taskQuantity = other.getTaskQuantity();
            if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
               Object this$stockQuantity = this.getStockQuantity();
               Object other$stockQuantity = other.getStockQuantity();
               if (this$stockQuantity == null ? other$stockQuantity == null : this$stockQuantity.equals(other$stockQuantity)) {
                  Object this$inboundMete = this.getInboundMete();
                  Object other$inboundMete = other.getInboundMete();
                  if (this$inboundMete == null ? other$inboundMete == null : this$inboundMete.equals(other$inboundMete)) {
                     Object this$outboundMete = this.getOutboundMete();
                     Object other$outboundMete = other.getOutboundMete();
                     if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)) {
                        Object this$taskMete = this.getTaskMete();
                        Object other$taskMete = other.getTaskMete();
                        if (this$taskMete == null ? other$taskMete == null : this$taskMete.equals(other$taskMete)) {
                           Object this$stockMete = this.getStockMete();
                           Object other$stockMete = other.getStockMete();
                           return this$stockMete == null ? other$stockMete == null : this$stockMete.equals(other$stockMete);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WarehouseEnclosureDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $outboundQuantity = this.getOutboundQuantity();
      result = result * 59 + ($outboundQuantity == null ? 43 : $outboundQuantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $stockQuantity = this.getStockQuantity();
      result = result * 59 + ($stockQuantity == null ? 43 : $stockQuantity.hashCode());
      Object $inboundMete = this.getInboundMete();
      result = result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $taskMete = this.getTaskMete();
      result = result * 59 + ($taskMete == null ? 43 : $taskMete.hashCode());
      Object $stockMete = this.getStockMete();
      return result * 59 + ($stockMete == null ? 43 : $stockMete.hashCode());
   }

   @Override
   public String toString() {
      return "WarehouseEnclosureDO(inboundQuantity="
         + this.getInboundQuantity()
         + ", inboundMete="
         + this.getInboundMete()
         + ", outboundQuantity="
         + this.getOutboundQuantity()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskMete="
         + this.getTaskMete()
         + ", stockQuantity="
         + this.getStockQuantity()
         + ", stockMete="
         + this.getStockMete()
         + ")";
   }
}
