package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingAssembleCompleteUseDTO", description = "部件完成数使用数")
public class MesBuildingAssembleCompleteUseDTO {
   @ApiModelProperty(name = "projectId", notes = "projectId")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "workShopId", notes = "workShopId")
   @JsonProperty("workShopId")
   @JSONField(name = "workShopId")
   private Long workShopId;
   @ApiModelProperty(name = "productId", notes = "构件产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "assembleId", notes = "部件产品id")
   @JsonProperty("assembleId")
   @JSONField(name = "assembleId")
   private Long assembleId;
   @ApiModelProperty(name = "serialNumber", value = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "产品规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "taskTypeEnum", notes = "taskTypeEnum")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "completeQuantity", value = "生产数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "useQuantity", value = "使用数量")
   @JsonProperty("useQuantity")
   @JSONField(name = "useQuantity")
   private Integer useQuantity;
   @ApiModelProperty(name = "netWeight", value = "单重量")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;

   public static MesBuildingAssembleCompleteUseDTO.MesBuildingAssembleCompleteUseDTOBuilder builder() {
      return new MesBuildingAssembleCompleteUseDTO.MesBuildingAssembleCompleteUseDTOBuilder();
   }

   public MesBuildingAssembleCompleteUseDTO() {
   }

   public MesBuildingAssembleCompleteUseDTO(
      final Long projectId,
      final Long workShopId,
      final Long productId,
      final Long assembleId,
      final String serialNumber,
      final String specification,
      final Integer taskTypeEnum,
      final Integer completeQuantity,
      final Integer useQuantity,
      final BigDecimal netWeight
   ) {
      this.projectId = projectId;
      this.workShopId = workShopId;
      this.productId = productId;
      this.assembleId = assembleId;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.taskTypeEnum = taskTypeEnum;
      this.completeQuantity = completeQuantity;
      this.useQuantity = useQuantity;
      this.netWeight = netWeight;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getAssembleId() {
      return this.assembleId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getUseQuantity() {
      return this.useQuantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   @JsonProperty("projectId")
   public MesBuildingAssembleCompleteUseDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("workShopId")
   public MesBuildingAssembleCompleteUseDTO setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingAssembleCompleteUseDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("assembleId")
   public MesBuildingAssembleCompleteUseDTO setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingAssembleCompleteUseDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingAssembleCompleteUseDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingAssembleCompleteUseDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesBuildingAssembleCompleteUseDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("useQuantity")
   public MesBuildingAssembleCompleteUseDTO setUseQuantity(final Integer useQuantity) {
      this.useQuantity = useQuantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingAssembleCompleteUseDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleCompleteUseDTO(projectId="
         + this.getProjectId()
         + ", workShopId="
         + this.getWorkShopId()
         + ", productId="
         + this.getProductId()
         + ", assembleId="
         + this.getAssembleId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", useQuantity="
         + this.getUseQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssembleCompleteUseDTO)) {
         return false;
      }

      MesBuildingAssembleCompleteUseDTO other = (MesBuildingAssembleCompleteUseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$workShopId = this.getWorkShopId();
         Object other$workShopId = other.getWorkShopId();
         if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$assembleId = this.getAssembleId();
               Object other$assembleId = other.getAssembleId();
               if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
                  Object this$taskTypeEnum = this.getTaskTypeEnum();
                  Object other$taskTypeEnum = other.getTaskTypeEnum();
                  if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                     Object this$completeQuantity = this.getCompleteQuantity();
                     Object other$completeQuantity = other.getCompleteQuantity();
                     if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                        Object this$useQuantity = this.getUseQuantity();
                        Object other$useQuantity = other.getUseQuantity();
                        if (this$useQuantity == null ? other$useQuantity == null : this$useQuantity.equals(other$useQuantity)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$netWeight = this.getNetWeight();
                                 Object other$netWeight = other.getNetWeight();
                                 return this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight);
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
      return other instanceof MesBuildingAssembleCompleteUseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $useQuantity = this.getUseQuantity();
      result = result * 59 + ($useQuantity == null ? 43 : $useQuantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }

   public static class MesBuildingAssembleCompleteUseDTOBuilder {
      private Long projectId;
      private Long workShopId;
      private Long productId;
      private Long assembleId;
      private String serialNumber;
      private String specification;
      private Integer taskTypeEnum;
      private Integer completeQuantity;
      private Integer useQuantity;
      private BigDecimal netWeight;

      MesBuildingAssembleCompleteUseDTOBuilder() {
      }

      @JsonProperty("projectId")
      public MesBuildingAssembleCompleteUseDTO.MesBuildingAssembleCompleteUseDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("workShopId")
      public MesBuildingAssembleCompleteUseDTO.MesBuildingAssembleCompleteUseDTOBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingAssembleCompleteUseDTO.MesBuildingAssembleCompleteUseDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("assembleId")
      public MesBuildingAssembleCompleteUseDTO.MesBuildingAssembleCompleteUseDTOBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingAssembleCompleteUseDTO.MesBuildingAssembleCompleteUseDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingAssembleCompleteUseDTO.MesBuildingAssembleCompleteUseDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingAssembleCompleteUseDTO.MesBuildingAssembleCompleteUseDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesBuildingAssembleCompleteUseDTO.MesBuildingAssembleCompleteUseDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("useQuantity")
      public MesBuildingAssembleCompleteUseDTO.MesBuildingAssembleCompleteUseDTOBuilder useQuantity(final Integer useQuantity) {
         this.useQuantity = useQuantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingAssembleCompleteUseDTO.MesBuildingAssembleCompleteUseDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public MesBuildingAssembleCompleteUseDTO build() {
         return new MesBuildingAssembleCompleteUseDTO(
            this.projectId,
            this.workShopId,
            this.productId,
            this.assembleId,
            this.serialNumber,
            this.specification,
            this.taskTypeEnum,
            this.completeQuantity,
            this.useQuantity,
            this.netWeight
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleCompleteUseDTO.MesBuildingAssembleCompleteUseDTOBuilder(projectId="
            + this.projectId
            + ", workShopId="
            + this.workShopId
            + ", productId="
            + this.productId
            + ", assembleId="
            + this.assembleId
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", completeQuantity="
            + this.completeQuantity
            + ", useQuantity="
            + this.useQuantity
            + ", netWeight="
            + this.netWeight
            + ")";
      }
   }
}
