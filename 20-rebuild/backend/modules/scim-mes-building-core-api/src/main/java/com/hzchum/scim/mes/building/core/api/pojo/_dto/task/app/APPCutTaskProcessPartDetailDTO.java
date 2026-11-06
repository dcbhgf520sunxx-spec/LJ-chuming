package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "APPQuantityAndMeteDTO", description = "半自动切割任务详情")
public class APPCutTaskProcessPartDetailDTO {
   private Long id;
   private Integer quantity;
   private String orderNumber;
   private String serialNumber;
   private String partType;
   private String thickness;
   private String material;
   private String specification;
   private BigDecimal totalLength;
   private BigDecimal totalProcessedLength = BigDecimal.ZERO;
   private BigDecimal totalUnprocessedLength = BigDecimal.ZERO;
   private BigDecimal totalNetWeight;

   public static APPCutTaskProcessPartDetailDTO.APPCutTaskProcessPartDetailDTOBuilder builder() {
      return new APPCutTaskProcessPartDetailDTO.APPCutTaskProcessPartDetailDTOBuilder();
   }

   public APPCutTaskProcessPartDetailDTO() {
   }

   public APPCutTaskProcessPartDetailDTO(
      final Long id,
      final Integer quantity,
      final String orderNumber,
      final String serialNumber,
      final String partType,
      final String thickness,
      final String material,
      final String specification,
      final BigDecimal totalLength,
      final BigDecimal totalProcessedLength,
      final BigDecimal totalUnprocessedLength,
      final BigDecimal totalNetWeight
   ) {
      this.id = id;
      this.quantity = quantity;
      this.orderNumber = orderNumber;
      this.serialNumber = serialNumber;
      this.partType = partType;
      this.thickness = thickness;
      this.material = material;
      this.specification = specification;
      this.totalLength = totalLength;
      this.totalProcessedLength = totalProcessedLength;
      this.totalUnprocessedLength = totalUnprocessedLength;
      this.totalNetWeight = totalNetWeight;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPartType() {
      return this.partType;
   }

   public String getThickness() {
      return this.thickness;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalProcessedLength() {
      return this.totalProcessedLength;
   }

   public BigDecimal getTotalUnprocessedLength() {
      return this.totalUnprocessedLength;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public APPCutTaskProcessPartDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public APPCutTaskProcessPartDetailDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public APPCutTaskProcessPartDetailDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   public APPCutTaskProcessPartDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public APPCutTaskProcessPartDetailDTO setPartType(final String partType) {
      this.partType = partType;
      return this;
   }

   public APPCutTaskProcessPartDetailDTO setThickness(final String thickness) {
      this.thickness = thickness;
      return this;
   }

   public APPCutTaskProcessPartDetailDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public APPCutTaskProcessPartDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public APPCutTaskProcessPartDetailDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   public APPCutTaskProcessPartDetailDTO setTotalProcessedLength(final BigDecimal totalProcessedLength) {
      this.totalProcessedLength = totalProcessedLength;
      return this;
   }

   public APPCutTaskProcessPartDetailDTO setTotalUnprocessedLength(final BigDecimal totalUnprocessedLength) {
      this.totalUnprocessedLength = totalUnprocessedLength;
      return this;
   }

   public APPCutTaskProcessPartDetailDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @Override
   public String toString() {
      return "APPCutTaskProcessPartDetailDTO(id="
         + this.getId()
         + ", quantity="
         + this.getQuantity()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", partType="
         + this.getPartType()
         + ", thickness="
         + this.getThickness()
         + ", material="
         + this.getMaterial()
         + ", specification="
         + this.getSpecification()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalProcessedLength="
         + this.getTotalProcessedLength()
         + ", totalUnprocessedLength="
         + this.getTotalUnprocessedLength()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof APPCutTaskProcessPartDetailDTO)) {
         return false;
      }

      APPCutTaskProcessPartDetailDTO other = (APPCutTaskProcessPartDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$orderNumber = this.getOrderNumber();
            Object other$orderNumber = other.getOrderNumber();
            if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$partType = this.getPartType();
                  Object other$partType = other.getPartType();
                  if (this$partType == null ? other$partType == null : this$partType.equals(other$partType)) {
                     Object this$thickness = this.getThickness();
                     Object other$thickness = other.getThickness();
                     if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                        Object this$material = this.getMaterial();
                        Object other$material = other.getMaterial();
                        if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$totalLength = this.getTotalLength();
                              Object other$totalLength = other.getTotalLength();
                              if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                 Object this$totalProcessedLength = this.getTotalProcessedLength();
                                 Object other$totalProcessedLength = other.getTotalProcessedLength();
                                 if (this$totalProcessedLength == null
                                    ? other$totalProcessedLength == null
                                    : this$totalProcessedLength.equals(other$totalProcessedLength)) {
                                    Object this$totalUnprocessedLength = this.getTotalUnprocessedLength();
                                    Object other$totalUnprocessedLength = other.getTotalUnprocessedLength();
                                    if (this$totalUnprocessedLength == null
                                       ? other$totalUnprocessedLength == null
                                       : this$totalUnprocessedLength.equals(other$totalUnprocessedLength)) {
                                       Object this$totalNetWeight = this.getTotalNetWeight();
                                       Object other$totalNetWeight = other.getTotalNetWeight();
                                       return this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight);
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
      return other instanceof APPCutTaskProcessPartDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $partType = this.getPartType();
      result = result * 59 + ($partType == null ? 43 : $partType.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalProcessedLength = this.getTotalProcessedLength();
      result = result * 59 + ($totalProcessedLength == null ? 43 : $totalProcessedLength.hashCode());
      Object $totalUnprocessedLength = this.getTotalUnprocessedLength();
      result = result * 59 + ($totalUnprocessedLength == null ? 43 : $totalUnprocessedLength.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      return result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
   }

   public static class APPCutTaskProcessPartDetailDTOBuilder {
      private Long id;
      private Integer quantity;
      private String orderNumber;
      private String serialNumber;
      private String partType;
      private String thickness;
      private String material;
      private String specification;
      private BigDecimal totalLength;
      private BigDecimal totalProcessedLength;
      private BigDecimal totalUnprocessedLength;
      private BigDecimal totalNetWeight;

      APPCutTaskProcessPartDetailDTOBuilder() {
      }

      public APPCutTaskProcessPartDetailDTO.APPCutTaskProcessPartDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public APPCutTaskProcessPartDetailDTO.APPCutTaskProcessPartDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public APPCutTaskProcessPartDetailDTO.APPCutTaskProcessPartDetailDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public APPCutTaskProcessPartDetailDTO.APPCutTaskProcessPartDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public APPCutTaskProcessPartDetailDTO.APPCutTaskProcessPartDetailDTOBuilder partType(final String partType) {
         this.partType = partType;
         return this;
      }

      public APPCutTaskProcessPartDetailDTO.APPCutTaskProcessPartDetailDTOBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      public APPCutTaskProcessPartDetailDTO.APPCutTaskProcessPartDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public APPCutTaskProcessPartDetailDTO.APPCutTaskProcessPartDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public APPCutTaskProcessPartDetailDTO.APPCutTaskProcessPartDetailDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public APPCutTaskProcessPartDetailDTO.APPCutTaskProcessPartDetailDTOBuilder totalProcessedLength(final BigDecimal totalProcessedLength) {
         this.totalProcessedLength = totalProcessedLength;
         return this;
      }

      public APPCutTaskProcessPartDetailDTO.APPCutTaskProcessPartDetailDTOBuilder totalUnprocessedLength(final BigDecimal totalUnprocessedLength) {
         this.totalUnprocessedLength = totalUnprocessedLength;
         return this;
      }

      public APPCutTaskProcessPartDetailDTO.APPCutTaskProcessPartDetailDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public APPCutTaskProcessPartDetailDTO build() {
         return new APPCutTaskProcessPartDetailDTO(
            this.id,
            this.quantity,
            this.orderNumber,
            this.serialNumber,
            this.partType,
            this.thickness,
            this.material,
            this.specification,
            this.totalLength,
            this.totalProcessedLength,
            this.totalUnprocessedLength,
            this.totalNetWeight
         );
      }

      @Override
      public String toString() {
         return "APPCutTaskProcessPartDetailDTO.APPCutTaskProcessPartDetailDTOBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", orderNumber="
            + this.orderNumber
            + ", serialNumber="
            + this.serialNumber
            + ", partType="
            + this.partType
            + ", thickness="
            + this.thickness
            + ", material="
            + this.material
            + ", specification="
            + this.specification
            + ", totalLength="
            + this.totalLength
            + ", totalProcessedLength="
            + this.totalProcessedLength
            + ", totalUnprocessedLength="
            + this.totalUnprocessedLength
            + ", totalNetWeight="
            + this.totalNetWeight
            + ")";
      }
   }
}
