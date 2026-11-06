package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.abnormal.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProduceSurplusRequest", description = "多余产品请求类")
public class ProduceSurplusRequest {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "leaderName", value = "组长名", notes = "组长名")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "processName", value = "工序名", notes = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty(name = "handleStatus", value = "处理状态", notes = "处理状态")
   @JsonProperty("handleStatus")
   @JSONField(name = "handleStatus")
   private Integer handleStatus;

   public static ProduceSurplusRequest.ProduceSurplusRequestBuilder builder() {
      return new ProduceSurplusRequest.ProduceSurplusRequestBuilder();
   }

   public ProduceSurplusRequest(
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final String leaderName,
      final String processName,
      final Integer productType,
      final Integer handleStatus
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.leaderName = leaderName;
      this.processName = processName;
      this.productType = productType;
      this.handleStatus = handleStatus;
   }

   public ProduceSurplusRequest() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
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

   public String getLeaderName() {
      return this.leaderName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getHandleStatus() {
      return this.handleStatus;
   }

   @JsonProperty("projectId")
   public ProduceSurplusRequest setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ProduceSurplusRequest setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ProduceSurplusRequest setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("factoryId")
   public ProduceSurplusRequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public ProduceSurplusRequest setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public ProduceSurplusRequest setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("leaderName")
   public ProduceSurplusRequest setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("processName")
   public ProduceSurplusRequest setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("productType")
   public ProduceSurplusRequest setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("handleStatus")
   public ProduceSurplusRequest setHandleStatus(final Integer handleStatus) {
      this.handleStatus = handleStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ProduceSurplusRequest(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", leaderName="
         + this.getLeaderName()
         + ", processName="
         + this.getProcessName()
         + ", productType="
         + this.getProductType()
         + ", handleStatus="
         + this.getHandleStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProduceSurplusRequest)) {
         return false;
      }

      ProduceSurplusRequest other = (ProduceSurplusRequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$factoryId = this.getFactoryId();
               Object other$factoryId = other.getFactoryId();
               if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$productionLineId = this.getProductionLineId();
                     Object other$productionLineId = other.getProductionLineId();
                     if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$handleStatus = this.getHandleStatus();
                           Object other$handleStatus = other.getHandleStatus();
                           if (this$handleStatus == null ? other$handleStatus == null : this$handleStatus.equals(other$handleStatus)) {
                              Object this$leaderName = this.getLeaderName();
                              Object other$leaderName = other.getLeaderName();
                              if (this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName)) {
                                 Object this$processName = this.getProcessName();
                                 Object other$processName = other.getProcessName();
                                 return this$processName == null ? other$processName == null : this$processName.equals(other$processName);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProduceSurplusRequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $handleStatus = this.getHandleStatus();
      result = result * 59 + ($handleStatus == null ? 43 : $handleStatus.hashCode());
      Object $leaderName = this.getLeaderName();
      result = result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
      Object $processName = this.getProcessName();
      return result * 59 + ($processName == null ? 43 : $processName.hashCode());
   }

   public static class ProduceSurplusRequestBuilder {
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private String leaderName;
      private String processName;
      private Integer productType;
      private Integer handleStatus;

      ProduceSurplusRequestBuilder() {
      }

      @JsonProperty("projectId")
      public ProduceSurplusRequest.ProduceSurplusRequestBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ProduceSurplusRequest.ProduceSurplusRequestBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ProduceSurplusRequest.ProduceSurplusRequestBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("factoryId")
      public ProduceSurplusRequest.ProduceSurplusRequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public ProduceSurplusRequest.ProduceSurplusRequestBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public ProduceSurplusRequest.ProduceSurplusRequestBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("leaderName")
      public ProduceSurplusRequest.ProduceSurplusRequestBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("processName")
      public ProduceSurplusRequest.ProduceSurplusRequestBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("productType")
      public ProduceSurplusRequest.ProduceSurplusRequestBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("handleStatus")
      public ProduceSurplusRequest.ProduceSurplusRequestBuilder handleStatus(final Integer handleStatus) {
         this.handleStatus = handleStatus;
         return this;
      }

      public ProduceSurplusRequest build() {
         return new ProduceSurplusRequest(
            this.projectId,
            this.monomerId,
            this.areaId,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.leaderName,
            this.processName,
            this.productType,
            this.handleStatus
         );
      }

      @Override
      public String toString() {
         return "ProduceSurplusRequest.ProduceSurplusRequestBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", leaderName="
            + this.leaderName
            + ", processName="
            + this.processName
            + ", productType="
            + this.productType
            + ", handleStatus="
            + this.handleStatus
            + ")";
      }
   }
}
