package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("型材套料清单信息")
public class AssembleNestingConfigDTO {
   @ApiModelProperty(name = "quantity", value = "总数量")
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "typesettingAssembleTypeEnum", value = "材料属性 [1 焊接型材, 2 成品型材]")
   private Integer typesettingAssembleTypeEnum;
   @ApiModelProperty(name = "nestingDTOS", value = "型材套料清单")
   private List<AssembleNestingDTO> nestingDTOS;

   public static AssembleNestingConfigDTO.AssembleNestingConfigDTOBuilder builder() {
      return new AssembleNestingConfigDTO.AssembleNestingConfigDTOBuilder();
   }

   public AssembleNestingConfigDTO() {
   }

   public AssembleNestingConfigDTO(
      final Integer totalQuantity, final BigDecimal totalNetWeight, final Integer typesettingAssembleTypeEnum, final List<AssembleNestingDTO> nestingDTOS
   ) {
      this.totalQuantity = totalQuantity;
      this.totalNetWeight = totalNetWeight;
      this.typesettingAssembleTypeEnum = typesettingAssembleTypeEnum;
      this.nestingDTOS = nestingDTOS;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Integer getTypesettingAssembleTypeEnum() {
      return this.typesettingAssembleTypeEnum;
   }

   public List<AssembleNestingDTO> getNestingDTOS() {
      return this.nestingDTOS;
   }

   public void setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setTypesettingAssembleTypeEnum(final Integer typesettingAssembleTypeEnum) {
      this.typesettingAssembleTypeEnum = typesettingAssembleTypeEnum;
   }

   public void setNestingDTOS(final List<AssembleNestingDTO> nestingDTOS) {
      this.nestingDTOS = nestingDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleNestingConfigDTO)) {
         return false;
      }

      AssembleNestingConfigDTO other = (AssembleNestingConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalQuantity = this.getTotalQuantity();
      Object other$totalQuantity = other.getTotalQuantity();
      if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
         Object this$typesettingAssembleTypeEnum = this.getTypesettingAssembleTypeEnum();
         Object other$typesettingAssembleTypeEnum = other.getTypesettingAssembleTypeEnum();
         if (this$typesettingAssembleTypeEnum == null
            ? other$typesettingAssembleTypeEnum == null
            : this$typesettingAssembleTypeEnum.equals(other$typesettingAssembleTypeEnum)) {
            Object this$totalNetWeight = this.getTotalNetWeight();
            Object other$totalNetWeight = other.getTotalNetWeight();
            if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
               Object this$nestingDTOS = this.getNestingDTOS();
               Object other$nestingDTOS = other.getNestingDTOS();
               return this$nestingDTOS == null ? other$nestingDTOS == null : this$nestingDTOS.equals(other$nestingDTOS);
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
      return other instanceof AssembleNestingConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $typesettingAssembleTypeEnum = this.getTypesettingAssembleTypeEnum();
      result = result * 59 + ($typesettingAssembleTypeEnum == null ? 43 : $typesettingAssembleTypeEnum.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $nestingDTOS = this.getNestingDTOS();
      return result * 59 + ($nestingDTOS == null ? 43 : $nestingDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleNestingConfigDTO(totalQuantity="
         + this.getTotalQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", typesettingAssembleTypeEnum="
         + this.getTypesettingAssembleTypeEnum()
         + ", nestingDTOS="
         + this.getNestingDTOS()
         + ")";
   }

   public static class AssembleNestingConfigDTOBuilder {
      private Integer totalQuantity;
      private BigDecimal totalNetWeight;
      private Integer typesettingAssembleTypeEnum;
      private List<AssembleNestingDTO> nestingDTOS;

      AssembleNestingConfigDTOBuilder() {
      }

      public AssembleNestingConfigDTO.AssembleNestingConfigDTOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public AssembleNestingConfigDTO.AssembleNestingConfigDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public AssembleNestingConfigDTO.AssembleNestingConfigDTOBuilder typesettingAssembleTypeEnum(final Integer typesettingAssembleTypeEnum) {
         this.typesettingAssembleTypeEnum = typesettingAssembleTypeEnum;
         return this;
      }

      public AssembleNestingConfigDTO.AssembleNestingConfigDTOBuilder nestingDTOS(final List<AssembleNestingDTO> nestingDTOS) {
         this.nestingDTOS = nestingDTOS;
         return this;
      }

      public AssembleNestingConfigDTO build() {
         return new AssembleNestingConfigDTO(this.totalQuantity, this.totalNetWeight, this.typesettingAssembleTypeEnum, this.nestingDTOS);
      }

      @Override
      public String toString() {
         return "AssembleNestingConfigDTO.AssembleNestingConfigDTOBuilder(totalQuantity="
            + this.totalQuantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", typesettingAssembleTypeEnum="
            + this.typesettingAssembleTypeEnum
            + ", nestingDTOS="
            + this.nestingDTOS
            + ")";
      }
   }
}
