package com.hzchum.scim.mes.building.core.api.pojo._do.warehouse;

import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("任务构件打印响应类")
public class WareSubscribeArtifactPrintDO extends ArtifactBaseInfo {
   @ApiModelProperty("产品id")
   private Long id;
   @ApiModelProperty("入库Id")
   private Long whId;
   @ApiModelProperty("入库数量")
   private Integer warehouseQuantity;
   @ApiModelProperty("打印数量")
   private Integer printQuantity;
   @ApiModelProperty("打印时间")
   private LocalDateTime printTime;
   @ApiModelProperty("是否一物一码")
   private Boolean boolOneCode;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否构件全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;

   public Long getId() {
      return this.id;
   }

   public Long getWhId() {
      return this.whId;
   }

   public Integer getWarehouseQuantity() {
      return this.warehouseQuantity;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public LocalDateTime getPrintTime() {
      return this.printTime;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   @Override
   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWhId(final Long whId) {
      this.whId = whId;
   }

   public void setWarehouseQuantity(final Integer warehouseQuantity) {
      this.warehouseQuantity = warehouseQuantity;
   }

   public void setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
   }

   public void setPrintTime(final LocalDateTime printTime) {
      this.printTime = printTime;
   }

   public void setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
   }

   @Override
   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WareSubscribeArtifactPrintDO)) {
         return false;
      }

      WareSubscribeArtifactPrintDO other = (WareSubscribeArtifactPrintDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$whId = this.getWhId();
         Object other$whId = other.getWhId();
         if (this$whId == null ? other$whId == null : this$whId.equals(other$whId)) {
            Object this$warehouseQuantity = this.getWarehouseQuantity();
            Object other$warehouseQuantity = other.getWarehouseQuantity();
            if (this$warehouseQuantity == null ? other$warehouseQuantity == null : this$warehouseQuantity.equals(other$warehouseQuantity)) {
               Object this$printQuantity = this.getPrintQuantity();
               Object other$printQuantity = other.getPrintQuantity();
               if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                  Object this$boolOneCode = this.getBoolOneCode();
                  Object other$boolOneCode = other.getBoolOneCode();
                  if (this$boolOneCode == null ? other$boolOneCode == null : this$boolOneCode.equals(other$boolOneCode)) {
                     Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                     Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                     if (this$boolAllPartSendDirectly == null
                        ? other$boolAllPartSendDirectly == null
                        : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                        Object this$printTime = this.getPrintTime();
                        Object other$printTime = other.getPrintTime();
                        return this$printTime == null ? other$printTime == null : this$printTime.equals(other$printTime);
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
      return other instanceof WareSubscribeArtifactPrintDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $whId = this.getWhId();
      result = result * 59 + ($whId == null ? 43 : $whId.hashCode());
      Object $warehouseQuantity = this.getWarehouseQuantity();
      result = result * 59 + ($warehouseQuantity == null ? 43 : $warehouseQuantity.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $printTime = this.getPrintTime();
      return result * 59 + ($printTime == null ? 43 : $printTime.hashCode());
   }

   @Override
   public String toString() {
      return "WareSubscribeArtifactPrintDO(id="
         + this.getId()
         + ", whId="
         + this.getWhId()
         + ", warehouseQuantity="
         + this.getWarehouseQuantity()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", printTime="
         + this.getPrintTime()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ")";
   }
}
