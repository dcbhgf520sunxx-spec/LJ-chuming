package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "LineSchedulingInfoDTOParam", description = "产线排产请求")
public class LineSchedulingInfoDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "产线id", notes = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private String productionLineId;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "typeId", value = "类型id", notes = "类型id")
   @JsonProperty("typeId")
   @JSONField(name = "typeId")
   private Integer typeId;
   @ApiModelProperty("mes分类 1建钢 2桥梁4围护")
   private Integer mesProductEnum;

   public static LineSchedulingInfoDTOParam.LineSchedulingInfoDTOParamBuilder builder() {
      return new LineSchedulingInfoDTOParam.LineSchedulingInfoDTOParamBuilder();
   }

   public LineSchedulingInfoDTOParam() {
   }

   public LineSchedulingInfoDTOParam(
      final Long projectId,
      final Long workshopId,
      final String productionLineId,
      final Long teamId,
      final Integer productType,
      final Integer typeId,
      final Integer mesProductEnum
   ) {
      this.projectId = projectId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.teamId = teamId;
      this.productType = productType;
      this.typeId = typeId;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getProductionLineId() {
      return this.productionLineId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getTypeId() {
      return this.typeId;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   @JsonProperty("projectId")
   public LineSchedulingInfoDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("workshopId")
   public LineSchedulingInfoDTOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public LineSchedulingInfoDTOParam setProductionLineId(final String productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("teamId")
   public LineSchedulingInfoDTOParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("productType")
   public LineSchedulingInfoDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("typeId")
   public LineSchedulingInfoDTOParam setTypeId(final Integer typeId) {
      this.typeId = typeId;
      return this;
   }

   public LineSchedulingInfoDTOParam setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "LineSchedulingInfoDTOParam(projectId="
         + this.getProjectId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", teamId="
         + this.getTeamId()
         + ", productType="
         + this.getProductType()
         + ", typeId="
         + this.getTypeId()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LineSchedulingInfoDTOParam)) {
         return false;
      }

      LineSchedulingInfoDTOParam other = (LineSchedulingInfoDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$typeId = this.getTypeId();
                  Object other$typeId = other.getTypeId();
                  if (this$typeId == null ? other$typeId == null : this$typeId.equals(other$typeId)) {
                     Object this$mesProductEnum = this.getMesProductEnum();
                     Object other$mesProductEnum = other.getMesProductEnum();
                     if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                        Object this$productionLineId = this.getProductionLineId();
                        Object other$productionLineId = other.getProductionLineId();
                        return this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId);
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
      return other instanceof LineSchedulingInfoDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $typeId = this.getTypeId();
      result = result * 59 + ($typeId == null ? 43 : $typeId.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $productionLineId = this.getProductionLineId();
      return result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
   }

   public static class LineSchedulingInfoDTOParamBuilder {
      private Long projectId;
      private Long workshopId;
      private String productionLineId;
      private Long teamId;
      private Integer productType;
      private Integer typeId;
      private Integer mesProductEnum;

      LineSchedulingInfoDTOParamBuilder() {
      }

      @JsonProperty("projectId")
      public LineSchedulingInfoDTOParam.LineSchedulingInfoDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("workshopId")
      public LineSchedulingInfoDTOParam.LineSchedulingInfoDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public LineSchedulingInfoDTOParam.LineSchedulingInfoDTOParamBuilder productionLineId(final String productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("teamId")
      public LineSchedulingInfoDTOParam.LineSchedulingInfoDTOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("productType")
      public LineSchedulingInfoDTOParam.LineSchedulingInfoDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("typeId")
      public LineSchedulingInfoDTOParam.LineSchedulingInfoDTOParamBuilder typeId(final Integer typeId) {
         this.typeId = typeId;
         return this;
      }

      public LineSchedulingInfoDTOParam.LineSchedulingInfoDTOParamBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public LineSchedulingInfoDTOParam build() {
         return new LineSchedulingInfoDTOParam(
            this.projectId, this.workshopId, this.productionLineId, this.teamId, this.productType, this.typeId, this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "LineSchedulingInfoDTOParam.LineSchedulingInfoDTOParamBuilder(projectId="
            + this.projectId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", teamId="
            + this.teamId
            + ", productType="
            + this.productType
            + ", typeId="
            + this.typeId
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
