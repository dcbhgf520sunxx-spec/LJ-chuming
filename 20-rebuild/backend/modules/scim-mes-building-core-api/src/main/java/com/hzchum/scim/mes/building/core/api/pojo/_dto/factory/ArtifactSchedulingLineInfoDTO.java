package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ArtifactSchedulingLineInfoDTO", description = "构件排产产线信息DTO")
public class ArtifactSchedulingLineInfoDTO {
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", notes = "车间名称")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "productionLineId", notes = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineName", notes = "产线名称")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   @JsonProperty("workshopId")
   public ArtifactSchedulingLineInfoDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("workshopName")
   public ArtifactSchedulingLineInfoDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("productionLineId")
   public ArtifactSchedulingLineInfoDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineName")
   public ArtifactSchedulingLineInfoDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactSchedulingLineInfoDTO(workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactSchedulingLineInfoDTO)) {
         return false;
      }

      ArtifactSchedulingLineInfoDTO other = (ArtifactSchedulingLineInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$workshopName = this.getWorkshopName();
            Object other$workshopName = other.getWorkshopName();
            if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
               Object this$productionLineName = this.getProductionLineName();
               Object other$productionLineName = other.getProductionLineName();
               return this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName);
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
      return other instanceof ArtifactSchedulingLineInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      return result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
   }
}
