package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "AssembleMatchingDTO", description = "构件匹配零件部件信息")
public class AssembleMatchingDTO {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "产品规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "netWeight", notes = "单重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "companyQuantity", value = "完成数量")
   @JsonProperty("companyQuantity")
   @JSONField(name = "companyQuantity")
   private Integer companyQuantity;
   @ApiModelProperty(name = "workShopLineName", value = "车间产线信息")
   @JsonProperty("workShopLineName")
   @JSONField(name = "workShopLineName")
   private String workShopLineName;

   public static AssembleMatchingDTO.AssembleMatchingDTOBuilder builder() {
      return new AssembleMatchingDTO.AssembleMatchingDTOBuilder();
   }

   public AssembleMatchingDTO() {
   }

   public AssembleMatchingDTO(
      final Long id,
      final Integer productType,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final Integer taskQuantity,
      final Integer companyQuantity,
      final String workShopLineName
   ) {
      this.id = id;
      this.productType = productType;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.taskQuantity = taskQuantity;
      this.companyQuantity = companyQuantity;
      this.workShopLineName = workShopLineName;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompanyQuantity() {
      return this.companyQuantity;
   }

   public String getWorkShopLineName() {
      return this.workShopLineName;
   }

   @JsonProperty("id")
   public AssembleMatchingDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productType")
   public AssembleMatchingDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("serialNumber")
   public AssembleMatchingDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public AssembleMatchingDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public AssembleMatchingDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public AssembleMatchingDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("netWeight")
   public AssembleMatchingDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public AssembleMatchingDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("taskQuantity")
   public AssembleMatchingDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("companyQuantity")
   public AssembleMatchingDTO setCompanyQuantity(final Integer companyQuantity) {
      this.companyQuantity = companyQuantity;
      return this;
   }

   @JsonProperty("workShopLineName")
   public AssembleMatchingDTO setWorkShopLineName(final String workShopLineName) {
      this.workShopLineName = workShopLineName;
      return this;
   }

   @Override
   public String toString() {
      return "AssembleMatchingDTO(id="
         + this.getId()
         + ", productType="
         + this.getProductType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", companyQuantity="
         + this.getCompanyQuantity()
         + ", workShopLineName="
         + this.getWorkShopLineName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleMatchingDTO)) {
         return false;
      }

      AssembleMatchingDTO other = (AssembleMatchingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$taskQuantity = this.getTaskQuantity();
            Object other$taskQuantity = other.getTaskQuantity();
            if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
               Object this$companyQuantity = this.getCompanyQuantity();
               Object other$companyQuantity = other.getCompanyQuantity();
               if (this$companyQuantity == null ? other$companyQuantity == null : this$companyQuantity.equals(other$companyQuantity)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$length = this.getLength();
                        Object other$length = other.getLength();
                        if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                           Object this$material = this.getMaterial();
                           Object other$material = other.getMaterial();
                           if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                              Object this$netWeight = this.getNetWeight();
                              Object other$netWeight = other.getNetWeight();
                              if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                 Object this$grossWeight = this.getGrossWeight();
                                 Object other$grossWeight = other.getGrossWeight();
                                 if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                    Object this$workShopLineName = this.getWorkShopLineName();
                                    Object other$workShopLineName = other.getWorkShopLineName();
                                    return this$workShopLineName == null
                                       ? other$workShopLineName == null
                                       : this$workShopLineName.equals(other$workShopLineName);
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
      return other instanceof AssembleMatchingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $companyQuantity = this.getCompanyQuantity();
      result = result * 59 + ($companyQuantity == null ? 43 : $companyQuantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $workShopLineName = this.getWorkShopLineName();
      return result * 59 + ($workShopLineName == null ? 43 : $workShopLineName.hashCode());
   }

   public static class AssembleMatchingDTOBuilder {
      private Long id;
      private Integer productType;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private Integer taskQuantity;
      private Integer companyQuantity;
      private String workShopLineName;

      AssembleMatchingDTOBuilder() {
      }

      @JsonProperty("id")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productType")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("serialNumber")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("netWeight")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("taskQuantity")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("companyQuantity")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder companyQuantity(final Integer companyQuantity) {
         this.companyQuantity = companyQuantity;
         return this;
      }

      @JsonProperty("workShopLineName")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder workShopLineName(final String workShopLineName) {
         this.workShopLineName = workShopLineName;
         return this;
      }

      public AssembleMatchingDTO build() {
         return new AssembleMatchingDTO(
            this.id,
            this.productType,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.netWeight,
            this.grossWeight,
            this.taskQuantity,
            this.companyQuantity,
            this.workShopLineName
         );
      }

      @Override
      public String toString() {
         return "AssembleMatchingDTO.AssembleMatchingDTOBuilder(id="
            + this.id
            + ", productType="
            + this.productType
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", taskQuantity="
            + this.taskQuantity
            + ", companyQuantity="
            + this.companyQuantity
            + ", workShopLineName="
            + this.workShopLineName
            + ")";
      }
   }
}
