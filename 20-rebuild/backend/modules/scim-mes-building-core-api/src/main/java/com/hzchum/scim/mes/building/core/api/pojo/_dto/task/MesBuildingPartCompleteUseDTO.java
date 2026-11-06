package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingCompleteAssPartDTO", description = "零件完成数使用数")
public class MesBuildingPartCompleteUseDTO {
   @ApiModelProperty(name = "projectId", notes = "projectId")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "workShopId", notes = "workShopId")
   @JsonProperty("workShopId")
   @JSONField(name = "workShopId")
   private Long workShopId;
   @ApiModelProperty(name = "productId", notes = "构部件产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "partId", notes = "零件产品id")
   @JsonProperty("partId")
   @JSONField(name = "partId")
   private Long partId;
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
   @ApiModelProperty(name = "weight", value = "总重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;

   public static MesBuildingPartCompleteUseDTO.MesBuildingPartCompleteUseDTOBuilder builder() {
      return new MesBuildingPartCompleteUseDTO.MesBuildingPartCompleteUseDTOBuilder();
   }

   public MesBuildingPartCompleteUseDTO() {
   }

   public MesBuildingPartCompleteUseDTO(
      final Long projectId,
      final Long workShopId,
      final Long productId,
      final Long partId,
      final String serialNumber,
      final String specification,
      final Integer taskTypeEnum,
      final Integer completeQuantity,
      final Integer useQuantity,
      final BigDecimal netWeight,
      final BigDecimal weight
   ) {
      this.projectId = projectId;
      this.workShopId = workShopId;
      this.productId = productId;
      this.partId = partId;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.taskTypeEnum = taskTypeEnum;
      this.completeQuantity = completeQuantity;
      this.useQuantity = useQuantity;
      this.netWeight = netWeight;
      this.weight = weight;
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

   public Long getPartId() {
      return this.partId;
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

   public BigDecimal getWeight() {
      return this.weight;
   }

   @JsonProperty("projectId")
   public MesBuildingPartCompleteUseDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("workShopId")
   public MesBuildingPartCompleteUseDTO setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingPartCompleteUseDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("partId")
   public MesBuildingPartCompleteUseDTO setPartId(final Long partId) {
      this.partId = partId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingPartCompleteUseDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingPartCompleteUseDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingPartCompleteUseDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesBuildingPartCompleteUseDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("useQuantity")
   public MesBuildingPartCompleteUseDTO setUseQuantity(final Integer useQuantity) {
      this.useQuantity = useQuantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingPartCompleteUseDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("weight")
   public MesBuildingPartCompleteUseDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPartCompleteUseDTO(projectId="
         + this.getProjectId()
         + ", workShopId="
         + this.getWorkShopId()
         + ", productId="
         + this.getProductId()
         + ", partId="
         + this.getPartId()
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
         + ", weight="
         + this.getWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPartCompleteUseDTO)) {
         return false;
      }

      MesBuildingPartCompleteUseDTO other = (MesBuildingPartCompleteUseDTO)o;
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
               Object this$partId = this.getPartId();
               Object other$partId = other.getPartId();
               if (this$partId == null ? other$partId == null : this$partId.equals(other$partId)) {
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
                                 if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                    Object this$weight = this.getWeight();
                                    Object other$weight = other.getWeight();
                                    return this$weight == null ? other$weight == null : this$weight.equals(other$weight);
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
      return other instanceof MesBuildingPartCompleteUseDTO;
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
      Object $partId = this.getPartId();
      result = result * 59 + ($partId == null ? 43 : $partId.hashCode());
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
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $weight = this.getWeight();
      return result * 59 + ($weight == null ? 43 : $weight.hashCode());
   }

   public static class MesBuildingPartCompleteUseDTOBuilder {
      private Long projectId;
      private Long workShopId;
      private Long productId;
      private Long partId;
      private String serialNumber;
      private String specification;
      private Integer taskTypeEnum;
      private Integer completeQuantity;
      private Integer useQuantity;
      private BigDecimal netWeight;
      private BigDecimal weight;

      MesBuildingPartCompleteUseDTOBuilder() {
      }

      @JsonProperty("projectId")
      public MesBuildingPartCompleteUseDTO.MesBuildingPartCompleteUseDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("workShopId")
      public MesBuildingPartCompleteUseDTO.MesBuildingPartCompleteUseDTOBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingPartCompleteUseDTO.MesBuildingPartCompleteUseDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("partId")
      public MesBuildingPartCompleteUseDTO.MesBuildingPartCompleteUseDTOBuilder partId(final Long partId) {
         this.partId = partId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingPartCompleteUseDTO.MesBuildingPartCompleteUseDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingPartCompleteUseDTO.MesBuildingPartCompleteUseDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingPartCompleteUseDTO.MesBuildingPartCompleteUseDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesBuildingPartCompleteUseDTO.MesBuildingPartCompleteUseDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("useQuantity")
      public MesBuildingPartCompleteUseDTO.MesBuildingPartCompleteUseDTOBuilder useQuantity(final Integer useQuantity) {
         this.useQuantity = useQuantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingPartCompleteUseDTO.MesBuildingPartCompleteUseDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("weight")
      public MesBuildingPartCompleteUseDTO.MesBuildingPartCompleteUseDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public MesBuildingPartCompleteUseDTO build() {
         return new MesBuildingPartCompleteUseDTO(
            this.projectId,
            this.workShopId,
            this.productId,
            this.partId,
            this.serialNumber,
            this.specification,
            this.taskTypeEnum,
            this.completeQuantity,
            this.useQuantity,
            this.netWeight,
            this.weight
         );
      }

      @Override
      public String toString() {
         return "MesBuildingPartCompleteUseDTO.MesBuildingPartCompleteUseDTOBuilder(projectId="
            + this.projectId
            + ", workShopId="
            + this.workShopId
            + ", productId="
            + this.productId
            + ", partId="
            + this.partId
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
            + ", weight="
            + this.weight
            + ")";
      }
   }
}
