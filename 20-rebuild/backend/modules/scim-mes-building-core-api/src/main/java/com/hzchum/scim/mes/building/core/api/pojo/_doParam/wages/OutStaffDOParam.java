package com.hzchum.scim.mes.building.core.api.pojo._doParam.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OutStaffDOParam", description = "")
public class OutStaffDOParam {
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
   private Integer productType;

   public static OutStaffDOParam.OutStaffDOParamBuilder builder() {
      return new OutStaffDOParam.OutStaffDOParamBuilder();
   }

   public OutStaffDOParam(
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

   public OutStaffDOParam() {
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
   public OutStaffDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("factoryId")
   public OutStaffDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("monomerName")
   public OutStaffDOParam setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("areaName")
   public OutStaffDOParam setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("leaderName")
   public OutStaffDOParam setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("serialNumber")
   public OutStaffDOParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("processId")
   public OutStaffDOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("productType")
   public OutStaffDOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @Override
   public String toString() {
      return "OutStaffDOParam(projectId="
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

      if (!(o instanceof OutStaffDOParam)) {
         return false;
      }

      OutStaffDOParam other = (OutStaffDOParam)o;
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
      return other instanceof OutStaffDOParam;
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

   public static class OutStaffDOParamBuilder {
      private Long projectId;
      private Long factoryId;
      private String monomerName;
      private String areaName;
      private String leaderName;
      private String serialNumber;
      private Long processId;
      private Integer productType;

      OutStaffDOParamBuilder() {
      }

      @JsonProperty("projectId")
      public OutStaffDOParam.OutStaffDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("factoryId")
      public OutStaffDOParam.OutStaffDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("monomerName")
      public OutStaffDOParam.OutStaffDOParamBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("areaName")
      public OutStaffDOParam.OutStaffDOParamBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("leaderName")
      public OutStaffDOParam.OutStaffDOParamBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("serialNumber")
      public OutStaffDOParam.OutStaffDOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("processId")
      public OutStaffDOParam.OutStaffDOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("productType")
      public OutStaffDOParam.OutStaffDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public OutStaffDOParam build() {
         return new OutStaffDOParam(
            this.projectId, this.factoryId, this.monomerName, this.areaName, this.leaderName, this.serialNumber, this.processId, this.productType
         );
      }

      @Override
      public String toString() {
         return "OutStaffDOParam.OutStaffDOParamBuilder(projectId="
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
