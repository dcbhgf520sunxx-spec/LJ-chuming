package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "AssembleMatchingDTO", description = "总装匹配零件信息")
public class AssembleMatchingDTO {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "boolStatusEnum")
   @JsonProperty("boolStatusEnum")
   @JSONField(name = "boolStatusEnum")
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "planId")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
   @ApiModelProperty(name = "grossWeight")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "length")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "monomerId")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "netWeight")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "projectId")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "quantity")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "remark")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "serialNumber")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "totalGrossWeight")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "totalNetWeight")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "type")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Long type;
   @ApiModelProperty(name = "usedQuantity", value = "已使用")
   @JsonProperty("usedQuantity")
   @JSONField(name = "usedQuantity")
   private Integer usedQuantity;
   @ApiModelProperty(name = "producedQuantity", value = "已生产量")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "needQuantity", value = "已生产量")
   @JsonProperty("needQuantity")
   @JSONField(name = "needQuantity")
   private Integer needQuantity;
   @ApiModelProperty(name = "usableQuantity", value = "可用数量")
   @JsonProperty("usableQuantity")
   @JSONField(name = "usableQuantity")
   private Integer usableQuantity;

   public static AssembleMatchingDTO.AssembleMatchingDTOBuilder builder() {
      return new AssembleMatchingDTO.AssembleMatchingDTOBuilder();
   }

   public AssembleMatchingDTO() {
   }

   public AssembleMatchingDTO(
      final Long id,
      final Boolean boolStatusEnum,
      final Long planId,
      final BigDecimal grossWeight,
      final BigDecimal length,
      final String material,
      final Long monomerId,
      final BigDecimal netWeight,
      final Long projectId,
      final Integer quantity,
      final String remark,
      final String serialNumber,
      final String specification,
      final BigDecimal totalGrossWeight,
      final BigDecimal totalNetWeight,
      final Long type,
      final Integer usedQuantity,
      final Integer producedQuantity,
      final Integer needQuantity,
      final Integer usableQuantity
   ) {
      this.id = id;
      this.boolStatusEnum = boolStatusEnum;
      this.planId = planId;
      this.grossWeight = grossWeight;
      this.length = length;
      this.material = material;
      this.monomerId = monomerId;
      this.netWeight = netWeight;
      this.projectId = projectId;
      this.quantity = quantity;
      this.remark = remark;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.totalGrossWeight = totalGrossWeight;
      this.totalNetWeight = totalNetWeight;
      this.type = type;
      this.usedQuantity = usedQuantity;
      this.producedQuantity = producedQuantity;
      this.needQuantity = needQuantity;
      this.usableQuantity = usableQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Long getType() {
      return this.type;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getNeedQuantity() {
      return this.needQuantity;
   }

   public Integer getUsableQuantity() {
      return this.usableQuantity;
   }

   @JsonProperty("id")
   public AssembleMatchingDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("boolStatusEnum")
   public AssembleMatchingDTO setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   @JsonProperty("planId")
   public AssembleMatchingDTO setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("grossWeight")
   public AssembleMatchingDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
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

   @JsonProperty("monomerId")
   public AssembleMatchingDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("netWeight")
   public AssembleMatchingDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("projectId")
   public AssembleMatchingDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("quantity")
   public AssembleMatchingDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("remark")
   public AssembleMatchingDTO setRemark(final String remark) {
      this.remark = remark;
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

   @JsonProperty("totalGrossWeight")
   public AssembleMatchingDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public AssembleMatchingDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("type")
   public AssembleMatchingDTO setType(final Long type) {
      this.type = type;
      return this;
   }

   @JsonProperty("usedQuantity")
   public AssembleMatchingDTO setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
      return this;
   }

   @JsonProperty("producedQuantity")
   public AssembleMatchingDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("needQuantity")
   public AssembleMatchingDTO setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
      return this;
   }

   @JsonProperty("usableQuantity")
   public AssembleMatchingDTO setUsableQuantity(final Integer usableQuantity) {
      this.usableQuantity = usableQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "AssembleMatchingDTO(id="
         + this.getId()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", planId="
         + this.getPlanId()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", monomerId="
         + this.getMonomerId()
         + ", netWeight="
         + this.getNetWeight()
         + ", projectId="
         + this.getProjectId()
         + ", quantity="
         + this.getQuantity()
         + ", remark="
         + this.getRemark()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", type="
         + this.getType()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", needQuantity="
         + this.getNeedQuantity()
         + ", usableQuantity="
         + this.getUsableQuantity()
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
         Object this$boolStatusEnum = this.getBoolStatusEnum();
         Object other$boolStatusEnum = other.getBoolStatusEnum();
         if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
            Object this$planId = this.getPlanId();
            Object other$planId = other.getPlanId();
            if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$type = this.getType();
                        Object other$type = other.getType();
                        if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                           Object this$usedQuantity = this.getUsedQuantity();
                           Object other$usedQuantity = other.getUsedQuantity();
                           if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                              Object this$producedQuantity = this.getProducedQuantity();
                              Object other$producedQuantity = other.getProducedQuantity();
                              if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                                 Object this$needQuantity = this.getNeedQuantity();
                                 Object other$needQuantity = other.getNeedQuantity();
                                 if (this$needQuantity == null ? other$needQuantity == null : this$needQuantity.equals(other$needQuantity)) {
                                    Object this$usableQuantity = this.getUsableQuantity();
                                    Object other$usableQuantity = other.getUsableQuantity();
                                    if (this$usableQuantity == null ? other$usableQuantity == null : this$usableQuantity.equals(other$usableQuantity)) {
                                       Object this$grossWeight = this.getGrossWeight();
                                       Object other$grossWeight = other.getGrossWeight();
                                       if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                             Object this$material = this.getMaterial();
                                             Object other$material = other.getMaterial();
                                             if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                Object this$netWeight = this.getNetWeight();
                                                Object other$netWeight = other.getNetWeight();
                                                if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                   Object this$remark = this.getRemark();
                                                   Object other$remark = other.getRemark();
                                                   if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                      Object this$serialNumber = this.getSerialNumber();
                                                      Object other$serialNumber = other.getSerialNumber();
                                                      if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)
                                                         )
                                                       {
                                                         Object this$specification = this.getSpecification();
                                                         Object other$specification = other.getSpecification();
                                                         if (this$specification == null
                                                            ? other$specification == null
                                                            : this$specification.equals(other$specification)) {
                                                            Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                            Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                            if (this$totalGrossWeight == null
                                                               ? other$totalGrossWeight == null
                                                               : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                               Object this$totalNetWeight = this.getTotalNetWeight();
                                                               Object other$totalNetWeight = other.getTotalNetWeight();
                                                               return this$totalNetWeight == null
                                                                  ? other$totalNetWeight == null
                                                                  : this$totalNetWeight.equals(other$totalNetWeight);
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
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $needQuantity = this.getNeedQuantity();
      result = result * 59 + ($needQuantity == null ? 43 : $needQuantity.hashCode());
      Object $usableQuantity = this.getUsableQuantity();
      result = result * 59 + ($usableQuantity == null ? 43 : $usableQuantity.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      return result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
   }

   public static class AssembleMatchingDTOBuilder {
      private Long id;
      private Boolean boolStatusEnum;
      private Long planId;
      private BigDecimal grossWeight;
      private BigDecimal length;
      private String material;
      private Long monomerId;
      private BigDecimal netWeight;
      private Long projectId;
      private Integer quantity;
      private String remark;
      private String serialNumber;
      private String specification;
      private BigDecimal totalGrossWeight;
      private BigDecimal totalNetWeight;
      private Long type;
      private Integer usedQuantity;
      private Integer producedQuantity;
      private Integer needQuantity;
      private Integer usableQuantity;

      AssembleMatchingDTOBuilder() {
      }

      @JsonProperty("id")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("boolStatusEnum")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      @JsonProperty("planId")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("grossWeight")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
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

      @JsonProperty("monomerId")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("netWeight")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("projectId")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("quantity")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("remark")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder remark(final String remark) {
         this.remark = remark;
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

      @JsonProperty("totalGrossWeight")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("type")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder type(final Long type) {
         this.type = type;
         return this;
      }

      @JsonProperty("usedQuantity")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder usedQuantity(final Integer usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      @JsonProperty("producedQuantity")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("needQuantity")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder needQuantity(final Integer needQuantity) {
         this.needQuantity = needQuantity;
         return this;
      }

      @JsonProperty("usableQuantity")
      public AssembleMatchingDTO.AssembleMatchingDTOBuilder usableQuantity(final Integer usableQuantity) {
         this.usableQuantity = usableQuantity;
         return this;
      }

      public AssembleMatchingDTO build() {
         return new AssembleMatchingDTO(
            this.id,
            this.boolStatusEnum,
            this.planId,
            this.grossWeight,
            this.length,
            this.material,
            this.monomerId,
            this.netWeight,
            this.projectId,
            this.quantity,
            this.remark,
            this.serialNumber,
            this.specification,
            this.totalGrossWeight,
            this.totalNetWeight,
            this.type,
            this.usedQuantity,
            this.producedQuantity,
            this.needQuantity,
            this.usableQuantity
         );
      }

      @Override
      public String toString() {
         return "AssembleMatchingDTO.AssembleMatchingDTOBuilder(id="
            + this.id
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", planId="
            + this.planId
            + ", grossWeight="
            + this.grossWeight
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", monomerId="
            + this.monomerId
            + ", netWeight="
            + this.netWeight
            + ", projectId="
            + this.projectId
            + ", quantity="
            + this.quantity
            + ", remark="
            + this.remark
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", type="
            + this.type
            + ", usedQuantity="
            + this.usedQuantity
            + ", producedQuantity="
            + this.producedQuantity
            + ", needQuantity="
            + this.needQuantity
            + ", usableQuantity="
            + this.usableQuantity
            + ")";
      }
   }
}
