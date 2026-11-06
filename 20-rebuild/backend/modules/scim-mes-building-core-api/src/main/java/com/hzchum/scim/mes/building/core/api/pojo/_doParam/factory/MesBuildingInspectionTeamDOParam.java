package com.hzchum.scim.mes.building.core.api.pojo._doParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingInspectionTeamDOParam对象", description = "")
public class MesBuildingInspectionTeamDOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "userId", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;

   public static MesBuildingInspectionTeamDOParam.MesBuildingInspectionTeamDOParamBuilder builder() {
      return new MesBuildingInspectionTeamDOParam.MesBuildingInspectionTeamDOParamBuilder();
   }

   public MesBuildingInspectionTeamDOParam() {
   }

   public MesBuildingInspectionTeamDOParam(
      final Long id, final Long factoryId, final Long workshopId, final Long productionLineId, final Long processId, final Long userId
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.processId = processId;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public MesBuildingInspectionTeamDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingInspectionTeamDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingInspectionTeamDOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingInspectionTeamDOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingInspectionTeamDOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingInspectionTeamDOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingInspectionTeamDOParam(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", processId="
         + this.getProcessId()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingInspectionTeamDOParam)) {
         return false;
      }

      MesBuildingInspectionTeamDOParam other = (MesBuildingInspectionTeamDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     return this$userId == null ? other$userId == null : this$userId.equals(other$userId);
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
      return other instanceof MesBuildingInspectionTeamDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   public static class MesBuildingInspectionTeamDOParamBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long processId;
      private Long userId;

      MesBuildingInspectionTeamDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingInspectionTeamDOParam.MesBuildingInspectionTeamDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingInspectionTeamDOParam.MesBuildingInspectionTeamDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingInspectionTeamDOParam.MesBuildingInspectionTeamDOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingInspectionTeamDOParam.MesBuildingInspectionTeamDOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingInspectionTeamDOParam.MesBuildingInspectionTeamDOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingInspectionTeamDOParam.MesBuildingInspectionTeamDOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingInspectionTeamDOParam build() {
         return new MesBuildingInspectionTeamDOParam(this.id, this.factoryId, this.workshopId, this.productionLineId, this.processId, this.userId);
      }

      @Override
      public String toString() {
         return "MesBuildingInspectionTeamDOParam.MesBuildingInspectionTeamDOParamBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", processId="
            + this.processId
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
