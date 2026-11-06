package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingWIPStatisticsDetailDTO", description = "在制品统计详情DTO")
public class MesBuildingWIPStatisticsDetailDTO {
   @ApiModelProperty(name = "projectId", value = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "workShopId", value = "车间ID")
   @JsonProperty("workShopId")
   @JSONField(name = "workShopId")
   private Long workShopId;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "processId", value = "工序ID")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", value = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "serialNumber", value = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "productId", value = "产品ID")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "productName", value = "产品名称")
   @JsonProperty("productName")
   @JSONField(name = "productName")
   private String productName;
   @ApiModelProperty(name = "specification", value = "产品规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单重量")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalWeight", value = "总重量")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   private BigDecimal totalWeight;

   public static MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder builder() {
      return new MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder();
   }

   public MesBuildingWIPStatisticsDetailDTO() {
   }

   public MesBuildingWIPStatisticsDetailDTO(
      final Long projectId,
      final Long workShopId,
      final String projectName,
      final Long processId,
      final String processName,
      final String serialNumber,
      final Long productId,
      final String productName,
      final String specification,
      final Integer taskTypeEnum,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalWeight
   ) {
      this.projectId = projectId;
      this.workShopId = workShopId;
      this.projectName = projectName;
      this.processId = processId;
      this.processName = processName;
      this.serialNumber = serialNumber;
      this.productId = productId;
      this.productName = productName;
      this.specification = specification;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalWeight = totalWeight;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getProductName() {
      return this.productName;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   @JsonProperty("projectId")
   public MesBuildingWIPStatisticsDetailDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("workShopId")
   public MesBuildingWIPStatisticsDetailDTO setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   @JsonProperty("projectName")
   public MesBuildingWIPStatisticsDetailDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingWIPStatisticsDetailDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public MesBuildingWIPStatisticsDetailDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingWIPStatisticsDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingWIPStatisticsDetailDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productName")
   public MesBuildingWIPStatisticsDetailDTO setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingWIPStatisticsDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingWIPStatisticsDetailDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingWIPStatisticsDetailDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingWIPStatisticsDetailDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalWeight")
   public MesBuildingWIPStatisticsDetailDTO setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWIPStatisticsDetailDTO)) {
         return false;
      }

      MesBuildingWIPStatisticsDetailDTO other = (MesBuildingWIPStatisticsDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$workShopId = this.getWorkShopId();
         Object other$workShopId = other.getWorkShopId();
         if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$taskTypeEnum = this.getTaskTypeEnum();
                  Object other$taskTypeEnum = other.getTaskTypeEnum();
                  if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$projectName = this.getProjectName();
                        Object other$projectName = other.getProjectName();
                        if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                           Object this$processName = this.getProcessName();
                           Object other$processName = other.getProcessName();
                           if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$productName = this.getProductName();
                                 Object other$productName = other.getProductName();
                                 if (this$productName == null ? other$productName == null : this$productName.equals(other$productName)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$netWeight = this.getNetWeight();
                                       Object other$netWeight = other.getNetWeight();
                                       if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                          Object this$totalWeight = this.getTotalWeight();
                                          Object other$totalWeight = other.getTotalWeight();
                                          return this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight);
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
      return other instanceof MesBuildingWIPStatisticsDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      return result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingWIPStatisticsDetailDTO(projectId="
         + this.getProjectId()
         + ", workShopId="
         + this.getWorkShopId()
         + ", projectName="
         + this.getProjectName()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", productId="
         + this.getProductId()
         + ", productName="
         + this.getProductName()
         + ", specification="
         + this.getSpecification()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ")";
   }

   public static class MesBuildingWIPStatisticsDetailDTOBuilder {
      private Long projectId;
      private Long workShopId;
      private String projectName;
      private Long processId;
      private String processName;
      private String serialNumber;
      private Long productId;
      private String productName;
      private String specification;
      private Integer taskTypeEnum;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalWeight;

      MesBuildingWIPStatisticsDetailDTOBuilder() {
      }

      @JsonProperty("projectId")
      public MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("workShopId")
      public MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      @JsonProperty("projectName")
      public MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productName")
      public MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalWeight")
      public MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public MesBuildingWIPStatisticsDetailDTO build() {
         return new MesBuildingWIPStatisticsDetailDTO(
            this.projectId,
            this.workShopId,
            this.projectName,
            this.processId,
            this.processName,
            this.serialNumber,
            this.productId,
            this.productName,
            this.specification,
            this.taskTypeEnum,
            this.quantity,
            this.netWeight,
            this.totalWeight
         );
      }

      @Override
      public String toString() {
         return "MesBuildingWIPStatisticsDetailDTO.MesBuildingWIPStatisticsDetailDTOBuilder(projectId="
            + this.projectId
            + ", workShopId="
            + this.workShopId
            + ", projectName="
            + this.projectName
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", serialNumber="
            + this.serialNumber
            + ", productId="
            + this.productId
            + ", productName="
            + this.productName
            + ", specification="
            + this.specification
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", totalWeight="
            + this.totalWeight
            + ")";
      }
   }
}
