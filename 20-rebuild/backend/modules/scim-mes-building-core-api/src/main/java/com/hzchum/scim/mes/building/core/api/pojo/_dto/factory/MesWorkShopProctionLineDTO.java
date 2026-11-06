package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesWorkShopProctionLineDTO", description = "车间-产线DTO")
public class MesWorkShopProctionLineDTO {
   @ApiModelProperty(name = "shopId", notes = "车间id")
   @JsonProperty("shopId")
   @JSONField(name = "shopId")
   private Long shopId;
   @ApiModelProperty(name = "shopName", notes = "车间名")
   @JsonProperty("shopName")
   @JSONField(name = "shopName")
   private String shopName;
   @ApiModelProperty(name = "lineId", notes = "产线id")
   @JsonProperty("lineId")
   @JSONField(name = "lineId")
   private Long lineId;
   @ApiModelProperty(name = "lineName", notes = "产线名称")
   @JsonProperty("lineName")
   @JSONField(name = "lineName")
   private String lineName;

   public Long getShopId() {
      return this.shopId;
   }

   public String getShopName() {
      return this.shopName;
   }

   public Long getLineId() {
      return this.lineId;
   }

   public String getLineName() {
      return this.lineName;
   }

   @JsonProperty("shopId")
   public MesWorkShopProctionLineDTO setShopId(final Long shopId) {
      this.shopId = shopId;
      return this;
   }

   @JsonProperty("shopName")
   public MesWorkShopProctionLineDTO setShopName(final String shopName) {
      this.shopName = shopName;
      return this;
   }

   @JsonProperty("lineId")
   public MesWorkShopProctionLineDTO setLineId(final Long lineId) {
      this.lineId = lineId;
      return this;
   }

   @JsonProperty("lineName")
   public MesWorkShopProctionLineDTO setLineName(final String lineName) {
      this.lineName = lineName;
      return this;
   }

   @Override
   public String toString() {
      return "MesWorkShopProctionLineDTO(shopId="
         + this.getShopId()
         + ", shopName="
         + this.getShopName()
         + ", lineId="
         + this.getLineId()
         + ", lineName="
         + this.getLineName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWorkShopProctionLineDTO)) {
         return false;
      }

      MesWorkShopProctionLineDTO other = (MesWorkShopProctionLineDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$shopId = this.getShopId();
      Object other$shopId = other.getShopId();
      if (this$shopId == null ? other$shopId == null : this$shopId.equals(other$shopId)) {
         Object this$lineId = this.getLineId();
         Object other$lineId = other.getLineId();
         if (this$lineId == null ? other$lineId == null : this$lineId.equals(other$lineId)) {
            Object this$shopName = this.getShopName();
            Object other$shopName = other.getShopName();
            if (this$shopName == null ? other$shopName == null : this$shopName.equals(other$shopName)) {
               Object this$lineName = this.getLineName();
               Object other$lineName = other.getLineName();
               return this$lineName == null ? other$lineName == null : this$lineName.equals(other$lineName);
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
      return other instanceof MesWorkShopProctionLineDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $shopId = this.getShopId();
      result = result * 59 + ($shopId == null ? 43 : $shopId.hashCode());
      Object $lineId = this.getLineId();
      result = result * 59 + ($lineId == null ? 43 : $lineId.hashCode());
      Object $shopName = this.getShopName();
      result = result * 59 + ($shopName == null ? 43 : $shopName.hashCode());
      Object $lineName = this.getLineName();
      return result * 59 + ($lineName == null ? 43 : $lineName.hashCode());
   }
}
