package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.wages.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "OutStaffRequest", description = "")
public class OutStaffRequest {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "monomerName", notes = "单体名")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "areaName", notes = "区域名")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "leaderName", notes = "组长名")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "productType", notes = "类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @NotNull(message = "类型不能为空")
   private Integer productType;

   public static OutStaffRequest.OutStaffRequestBuilder builder() {
      return new OutStaffRequest.OutStaffRequestBuilder();
   }

   public OutStaffRequest(
      final Long projectId,
      final Long factoryId,
      final String monomerName,
      final String areaName,
      final String leaderName,
      final String serialNumber,
      final Long processId,
      final Integer productType
   ) {
      this.projectId = projectId;
      this.factoryId = factoryId;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.leaderName = leaderName;
      this.serialNumber = serialNumber;
      this.processId = processId;
      this.productType = productType;
   }

   public OutStaffRequest() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   @JsonProperty("projectId")
   public OutStaffRequest setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("factoryId")
   public OutStaffRequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("monomerName")
   public OutStaffRequest setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("areaName")
   public OutStaffRequest setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("leaderName")
   public OutStaffRequest setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("serialNumber")
   public OutStaffRequest setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("processId")
   public OutStaffRequest setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("productType")
   public OutStaffRequest setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @Override
   public String toString() {
      return "OutStaffRequest(projectId="
         + this.getProjectId()
         + ", factoryId="
         + this.getFactoryId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", leaderName="
         + this.getLeaderName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", processId="
         + this.getProcessId()
         + ", productType="
         + this.getProductType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutStaffRequest)) {
         return false;
      }

      OutStaffRequest other = (OutStaffRequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$monomerName = this.getMonomerName();
                  Object other$monomerName = other.getMonomerName();
                  if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                     Object this$areaName = this.getAreaName();
                     Object other$areaName = other.getAreaName();
                     if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                        Object this$leaderName = this.getLeaderName();
                        Object other$leaderName = other.getLeaderName();
                        if (this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof OutStaffRequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $leaderName = this.getLeaderName();
      result = result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   public static class OutStaffRequestBuilder {
      private Long projectId;
      private Long factoryId;
      private String monomerName;
      private String areaName;
      private String leaderName;
      private String serialNumber;
      private Long processId;
      private Integer productType;

      OutStaffRequestBuilder() {
      }

      @JsonProperty("projectId")
      public OutStaffRequest.OutStaffRequestBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("factoryId")
      public OutStaffRequest.OutStaffRequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("monomerName")
      public OutStaffRequest.OutStaffRequestBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("areaName")
      public OutStaffRequest.OutStaffRequestBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("leaderName")
      public OutStaffRequest.OutStaffRequestBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("serialNumber")
      public OutStaffRequest.OutStaffRequestBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("processId")
      public OutStaffRequest.OutStaffRequestBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("productType")
      public OutStaffRequest.OutStaffRequestBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public OutStaffRequest build() {
         return new OutStaffRequest(
            this.projectId, this.factoryId, this.monomerName, this.areaName, this.leaderName, this.serialNumber, this.processId, this.productType
         );
      }

      @Override
      public String toString() {
         return "OutStaffRequest.OutStaffRequestBuilder(projectId="
            + this.projectId
            + ", factoryId="
            + this.factoryId
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", leaderName="
            + this.leaderName
            + ", serialNumber="
            + this.serialNumber
            + ", processId="
            + this.processId
            + ", productType="
            + this.productType
            + ")";
      }
   }
}
