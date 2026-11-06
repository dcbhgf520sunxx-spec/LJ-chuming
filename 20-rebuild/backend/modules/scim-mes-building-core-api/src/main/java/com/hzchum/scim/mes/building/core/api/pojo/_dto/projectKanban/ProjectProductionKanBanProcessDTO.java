package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProjectProductionKanBanProcessDTO {
   @ApiModelProperty(name = "artifactTaskId", notes = "构件任务Id")
   @JsonProperty("artifactTaskId")
   @JSONField(name = "artifactTaskId")
   private Long artifactTaskId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "processId", notes = "工序Id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "totalTaskQuantity", notes = "任务数")
   @JsonProperty("totalTaskQuantity")
   @JSONField(name = "totalTaskQuantity")
   private Integer totalTaskQuantity;
   @ApiModelProperty(name = "totalNeedQuantity", value = "本工序需要生产的数量", notes = "本工序需要生产的数量")
   @JsonProperty("totalNeedQuantity")
   @JSONField(name = "totalNeedQuantity")
   private Integer totalNeedQuantity;
   @ApiModelProperty(name = "totalReportQuantity", notes = "生产上报数")
   @JsonProperty("totalReportQuantity")
   @JSONField(name = "totalReportQuantity")
   private Integer totalReportQuantity;
   @ApiModelProperty(name = "totalInspectionQuantity", notes = "质检数")
   @JsonProperty("totalInspectionQuantity")
   @JSONField(name = "totalInspectionQuantity")
   private Integer totalInspectionQuantity;
   @ApiModelProperty(name = "netWeight", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "productKanBanCompanyStatusEnum", notes = "生产状态")
   @JsonProperty("productKanBanCompanyStatusEnum")
   @JSONField(name = "productKanBanCompanyStatusEnum")
   private Integer productKanBanCompanyStatusEnum;
   @ApiModelProperty(name = "productId", notes = "产品Id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "processType", notes = "工序类型")
   @JsonProperty("processType")
   @JSONField(name = "processType")
   private Integer processType;
   @ApiModelProperty(name = "processName", notes = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "inspectionUserName", notes = "质检人,多个以逗号分隔")
   @JsonProperty("inspectionUserName")
   @JSONField(name = "inspectionUserName")
   private String inspectionUserName;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;

   public static ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder builder() {
      return new ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder();
   }

   public Long getArtifactTaskId() {
      return this.artifactTaskId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getTotalTaskQuantity() {
      return this.totalTaskQuantity;
   }

   public Integer getTotalNeedQuantity() {
      return this.totalNeedQuantity;
   }

   public Integer getTotalReportQuantity() {
      return this.totalReportQuantity;
   }

   public Integer getTotalInspectionQuantity() {
      return this.totalInspectionQuantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Integer getProductKanBanCompanyStatusEnum() {
      return this.productKanBanCompanyStatusEnum;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProcessType() {
      return this.processType;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getInspectionUserName() {
      return this.inspectionUserName;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   @JsonProperty("artifactTaskId")
   public void setArtifactTaskId(final Long artifactTaskId) {
      this.artifactTaskId = artifactTaskId;
   }

   @JsonProperty("productType")
   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @JsonProperty("processId")
   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   @JsonProperty("totalTaskQuantity")
   public void setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
   }

   @JsonProperty("totalNeedQuantity")
   public void setTotalNeedQuantity(final Integer totalNeedQuantity) {
      this.totalNeedQuantity = totalNeedQuantity;
   }

   @JsonProperty("totalReportQuantity")
   public void setTotalReportQuantity(final Integer totalReportQuantity) {
      this.totalReportQuantity = totalReportQuantity;
   }

   @JsonProperty("totalInspectionQuantity")
   public void setTotalInspectionQuantity(final Integer totalInspectionQuantity) {
      this.totalInspectionQuantity = totalInspectionQuantity;
   }

   @JsonProperty("netWeight")
   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   @JsonProperty("productKanBanCompanyStatusEnum")
   public void setProductKanBanCompanyStatusEnum(final Integer productKanBanCompanyStatusEnum) {
      this.productKanBanCompanyStatusEnum = productKanBanCompanyStatusEnum;
   }

   @JsonProperty("productId")
   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   @JsonProperty("processType")
   public void setProcessType(final Integer processType) {
      this.processType = processType;
   }

   @JsonProperty("processName")
   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @JsonProperty("inspectionUserName")
   public void setInspectionUserName(final String inspectionUserName) {
      this.inspectionUserName = inspectionUserName;
   }

   @JsonProperty("orderNumber")
   public void setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductionKanBanProcessDTO)) {
         return false;
      }

      ProjectProductionKanBanProcessDTO other = (ProjectProductionKanBanProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactTaskId = this.getArtifactTaskId();
      Object other$artifactTaskId = other.getArtifactTaskId();
      if (this$artifactTaskId == null ? other$artifactTaskId == null : this$artifactTaskId.equals(other$artifactTaskId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$totalTaskQuantity = this.getTotalTaskQuantity();
               Object other$totalTaskQuantity = other.getTotalTaskQuantity();
               if (this$totalTaskQuantity == null ? other$totalTaskQuantity == null : this$totalTaskQuantity.equals(other$totalTaskQuantity)) {
                  Object this$totalNeedQuantity = this.getTotalNeedQuantity();
                  Object other$totalNeedQuantity = other.getTotalNeedQuantity();
                  if (this$totalNeedQuantity == null ? other$totalNeedQuantity == null : this$totalNeedQuantity.equals(other$totalNeedQuantity)) {
                     Object this$totalReportQuantity = this.getTotalReportQuantity();
                     Object other$totalReportQuantity = other.getTotalReportQuantity();
                     if (this$totalReportQuantity == null ? other$totalReportQuantity == null : this$totalReportQuantity.equals(other$totalReportQuantity)) {
                        Object this$totalInspectionQuantity = this.getTotalInspectionQuantity();
                        Object other$totalInspectionQuantity = other.getTotalInspectionQuantity();
                        if (this$totalInspectionQuantity == null
                           ? other$totalInspectionQuantity == null
                           : this$totalInspectionQuantity.equals(other$totalInspectionQuantity)) {
                           Object this$productKanBanCompanyStatusEnum = this.getProductKanBanCompanyStatusEnum();
                           Object other$productKanBanCompanyStatusEnum = other.getProductKanBanCompanyStatusEnum();
                           if (this$productKanBanCompanyStatusEnum == null
                              ? other$productKanBanCompanyStatusEnum == null
                              : this$productKanBanCompanyStatusEnum.equals(other$productKanBanCompanyStatusEnum)) {
                              Object this$productId = this.getProductId();
                              Object other$productId = other.getProductId();
                              if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                 Object this$processType = this.getProcessType();
                                 Object other$processType = other.getProcessType();
                                 if (this$processType == null ? other$processType == null : this$processType.equals(other$processType)) {
                                    Object this$netWeight = this.getNetWeight();
                                    Object other$netWeight = other.getNetWeight();
                                    if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                       Object this$processName = this.getProcessName();
                                       Object other$processName = other.getProcessName();
                                       if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                          Object this$inspectionUserName = this.getInspectionUserName();
                                          Object other$inspectionUserName = other.getInspectionUserName();
                                          if (this$inspectionUserName == null
                                             ? other$inspectionUserName == null
                                             : this$inspectionUserName.equals(other$inspectionUserName)) {
                                             Object this$orderNumber = this.getOrderNumber();
                                             Object other$orderNumber = other.getOrderNumber();
                                             return this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber);
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
      return other instanceof ProjectProductionKanBanProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactTaskId = this.getArtifactTaskId();
      result = result * 59 + ($artifactTaskId == null ? 43 : $artifactTaskId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $totalTaskQuantity = this.getTotalTaskQuantity();
      result = result * 59 + ($totalTaskQuantity == null ? 43 : $totalTaskQuantity.hashCode());
      Object $totalNeedQuantity = this.getTotalNeedQuantity();
      result = result * 59 + ($totalNeedQuantity == null ? 43 : $totalNeedQuantity.hashCode());
      Object $totalReportQuantity = this.getTotalReportQuantity();
      result = result * 59 + ($totalReportQuantity == null ? 43 : $totalReportQuantity.hashCode());
      Object $totalInspectionQuantity = this.getTotalInspectionQuantity();
      result = result * 59 + ($totalInspectionQuantity == null ? 43 : $totalInspectionQuantity.hashCode());
      Object $productKanBanCompanyStatusEnum = this.getProductKanBanCompanyStatusEnum();
      result = result * 59 + ($productKanBanCompanyStatusEnum == null ? 43 : $productKanBanCompanyStatusEnum.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $inspectionUserName = this.getInspectionUserName();
      result = result * 59 + ($inspectionUserName == null ? 43 : $inspectionUserName.hashCode());
      Object $orderNumber = this.getOrderNumber();
      return result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductionKanBanProcessDTO(artifactTaskId="
         + this.getArtifactTaskId()
         + ", productType="
         + this.getProductType()
         + ", processId="
         + this.getProcessId()
         + ", totalTaskQuantity="
         + this.getTotalTaskQuantity()
         + ", totalNeedQuantity="
         + this.getTotalNeedQuantity()
         + ", totalReportQuantity="
         + this.getTotalReportQuantity()
         + ", totalInspectionQuantity="
         + this.getTotalInspectionQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", productKanBanCompanyStatusEnum="
         + this.getProductKanBanCompanyStatusEnum()
         + ", productId="
         + this.getProductId()
         + ", processType="
         + this.getProcessType()
         + ", processName="
         + this.getProcessName()
         + ", inspectionUserName="
         + this.getInspectionUserName()
         + ", orderNumber="
         + this.getOrderNumber()
         + ")";
   }

   public ProjectProductionKanBanProcessDTO(
      final Long artifactTaskId,
      final Integer productType,
      final Long processId,
      final Integer totalTaskQuantity,
      final Integer totalNeedQuantity,
      final Integer totalReportQuantity,
      final Integer totalInspectionQuantity,
      final BigDecimal netWeight,
      final Integer productKanBanCompanyStatusEnum,
      final Long productId,
      final Integer processType,
      final String processName,
      final String inspectionUserName,
      final String orderNumber
   ) {
      this.artifactTaskId = artifactTaskId;
      this.productType = productType;
      this.processId = processId;
      this.totalTaskQuantity = totalTaskQuantity;
      this.totalNeedQuantity = totalNeedQuantity;
      this.totalReportQuantity = totalReportQuantity;
      this.totalInspectionQuantity = totalInspectionQuantity;
      this.netWeight = netWeight;
      this.productKanBanCompanyStatusEnum = productKanBanCompanyStatusEnum;
      this.productId = productId;
      this.processType = processType;
      this.processName = processName;
      this.inspectionUserName = inspectionUserName;
      this.orderNumber = orderNumber;
   }

   public ProjectProductionKanBanProcessDTO() {
   }

   public static class ProjectProductionKanBanProcessDTOBuilder {
      private Long artifactTaskId;
      private Integer productType;
      private Long processId;
      private Integer totalTaskQuantity;
      private Integer totalNeedQuantity;
      private Integer totalReportQuantity;
      private Integer totalInspectionQuantity;
      private BigDecimal netWeight;
      private Integer productKanBanCompanyStatusEnum;
      private Long productId;
      private Integer processType;
      private String processName;
      private String inspectionUserName;
      private String orderNumber;

      ProjectProductionKanBanProcessDTOBuilder() {
      }

      @JsonProperty("artifactTaskId")
      public ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder artifactTaskId(final Long artifactTaskId) {
         this.artifactTaskId = artifactTaskId;
         return this;
      }

      @JsonProperty("productType")
      public ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("processId")
      public ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("totalTaskQuantity")
      public ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder totalTaskQuantity(final Integer totalTaskQuantity) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      @JsonProperty("totalNeedQuantity")
      public ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder totalNeedQuantity(final Integer totalNeedQuantity) {
         this.totalNeedQuantity = totalNeedQuantity;
         return this;
      }

      @JsonProperty("totalReportQuantity")
      public ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder totalReportQuantity(final Integer totalReportQuantity) {
         this.totalReportQuantity = totalReportQuantity;
         return this;
      }

      @JsonProperty("totalInspectionQuantity")
      public ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder totalInspectionQuantity(final Integer totalInspectionQuantity) {
         this.totalInspectionQuantity = totalInspectionQuantity;
         return this;
      }

      @JsonProperty("netWeight")
      public ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("productKanBanCompanyStatusEnum")
      public ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder productKanBanCompanyStatusEnum(
         final Integer productKanBanCompanyStatusEnum
      ) {
         this.productKanBanCompanyStatusEnum = productKanBanCompanyStatusEnum;
         return this;
      }

      @JsonProperty("productId")
      public ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("processType")
      public ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      @JsonProperty("processName")
      public ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("inspectionUserName")
      public ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder inspectionUserName(final String inspectionUserName) {
         this.inspectionUserName = inspectionUserName;
         return this;
      }

      @JsonProperty("orderNumber")
      public ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public ProjectProductionKanBanProcessDTO build() {
         return new ProjectProductionKanBanProcessDTO(
            this.artifactTaskId,
            this.productType,
            this.processId,
            this.totalTaskQuantity,
            this.totalNeedQuantity,
            this.totalReportQuantity,
            this.totalInspectionQuantity,
            this.netWeight,
            this.productKanBanCompanyStatusEnum,
            this.productId,
            this.processType,
            this.processName,
            this.inspectionUserName,
            this.orderNumber
         );
      }

      @Override
      public String toString() {
         return "ProjectProductionKanBanProcessDTO.ProjectProductionKanBanProcessDTOBuilder(artifactTaskId="
            + this.artifactTaskId
            + ", productType="
            + this.productType
            + ", processId="
            + this.processId
            + ", totalTaskQuantity="
            + this.totalTaskQuantity
            + ", totalNeedQuantity="
            + this.totalNeedQuantity
            + ", totalReportQuantity="
            + this.totalReportQuantity
            + ", totalInspectionQuantity="
            + this.totalInspectionQuantity
            + ", netWeight="
            + this.netWeight
            + ", productKanBanCompanyStatusEnum="
            + this.productKanBanCompanyStatusEnum
            + ", productId="
            + this.productId
            + ", processType="
            + this.processType
            + ", processName="
            + this.processName
            + ", inspectionUserName="
            + this.inspectionUserName
            + ", orderNumber="
            + this.orderNumber
            + ")";
      }
   }
}
