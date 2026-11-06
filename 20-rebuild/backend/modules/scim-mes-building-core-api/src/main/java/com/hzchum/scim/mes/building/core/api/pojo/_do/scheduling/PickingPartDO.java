package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "PickingPartDO", description = "零件领料信息 ")
public class PickingPartDO {
   private Long projectId;
   private String partType;
   private Long workshopId;
   private String taskOrderNumber;
   private Long taskOrderId;
   private BigDecimal netWeight;
   private Integer quantity;
   private String specification;
   private String material;
   private String thick;
   private BigDecimal length;
   private BigDecimal surfaceArea;

   public static PickingPartDO.PickingPartDOBuilder builder() {
      return new PickingPartDO.PickingPartDOBuilder();
   }

   public PickingPartDO() {
   }

   public PickingPartDO(
      final Long projectId,
      final String partType,
      final Long workshopId,
      final String taskOrderNumber,
      final Long taskOrderId,
      final BigDecimal netWeight,
      final Integer quantity,
      final String specification,
      final String material,
      final String thick,
      final BigDecimal length,
      final BigDecimal surfaceArea
   ) {
      this.projectId = projectId;
      this.partType = partType;
      this.workshopId = workshopId;
      this.taskOrderNumber = taskOrderNumber;
      this.taskOrderId = taskOrderId;
      this.netWeight = netWeight;
      this.quantity = quantity;
      this.specification = specification;
      this.material = material;
      this.thick = thick;
      this.length = length;
      this.surfaceArea = surfaceArea;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getPartType() {
      return this.partType;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getThick() {
      return this.thick;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public PickingPartDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public PickingPartDO setPartType(final String partType) {
      this.partType = partType;
      return this;
   }

   public PickingPartDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public PickingPartDO setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
      return this;
   }

   public PickingPartDO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   public PickingPartDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public PickingPartDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public PickingPartDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public PickingPartDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public PickingPartDO setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   public PickingPartDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public PickingPartDO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PickingPartDO)) {
         return false;
      }

      PickingPartDO other = (PickingPartDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$taskOrderId = this.getTaskOrderId();
            Object other$taskOrderId = other.getTaskOrderId();
            if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$partType = this.getPartType();
                  Object other$partType = other.getPartType();
                  if (this$partType == null ? other$partType == null : this$partType.equals(other$partType)) {
                     Object this$taskOrderNumber = this.getTaskOrderNumber();
                     Object other$taskOrderNumber = other.getTaskOrderNumber();
                     if (this$taskOrderNumber == null ? other$taskOrderNumber == null : this$taskOrderNumber.equals(other$taskOrderNumber)) {
                        Object this$netWeight = this.getNetWeight();
                        Object other$netWeight = other.getNetWeight();
                        if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$material = this.getMaterial();
                              Object other$material = other.getMaterial();
                              if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                 Object this$thick = this.getThick();
                                 Object other$thick = other.getThick();
                                 if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                    Object this$length = this.getLength();
                                    Object other$length = other.getLength();
                                    if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                       Object this$surfaceArea = this.getSurfaceArea();
                                       Object other$surfaceArea = other.getSurfaceArea();
                                       return this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea);
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
      return other instanceof PickingPartDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $partType = this.getPartType();
      result = result * 59 + ($partType == null ? 43 : $partType.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      return result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
   }

   @Override
   public String toString() {
      return "PickingPartDO(projectId="
         + this.getProjectId()
         + ", partType="
         + this.getPartType()
         + ", workshopId="
         + this.getWorkshopId()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", netWeight="
         + this.getNetWeight()
         + ", quantity="
         + this.getQuantity()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", thick="
         + this.getThick()
         + ", length="
         + this.getLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ")";
   }

   public static class PickingPartDOBuilder {
      private Long projectId;
      private String partType;
      private Long workshopId;
      private String taskOrderNumber;
      private Long taskOrderId;
      private BigDecimal netWeight;
      private Integer quantity;
      private String specification;
      private String material;
      private String thick;
      private BigDecimal length;
      private BigDecimal surfaceArea;

      PickingPartDOBuilder() {
      }

      public PickingPartDO.PickingPartDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public PickingPartDO.PickingPartDOBuilder partType(final String partType) {
         this.partType = partType;
         return this;
      }

      public PickingPartDO.PickingPartDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public PickingPartDO.PickingPartDOBuilder taskOrderNumber(final String taskOrderNumber) {
         this.taskOrderNumber = taskOrderNumber;
         return this;
      }

      public PickingPartDO.PickingPartDOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public PickingPartDO.PickingPartDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public PickingPartDO.PickingPartDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public PickingPartDO.PickingPartDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public PickingPartDO.PickingPartDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public PickingPartDO.PickingPartDOBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      public PickingPartDO.PickingPartDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public PickingPartDO.PickingPartDOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public PickingPartDO build() {
         return new PickingPartDO(
            this.projectId,
            this.partType,
            this.workshopId,
            this.taskOrderNumber,
            this.taskOrderId,
            this.netWeight,
            this.quantity,
            this.specification,
            this.material,
            this.thick,
            this.length,
            this.surfaceArea
         );
      }

      @Override
      public String toString() {
         return "PickingPartDO.PickingPartDOBuilder(projectId="
            + this.projectId
            + ", partType="
            + this.partType
            + ", workshopId="
            + this.workshopId
            + ", taskOrderNumber="
            + this.taskOrderNumber
            + ", taskOrderId="
            + this.taskOrderId
            + ", netWeight="
            + this.netWeight
            + ", quantity="
            + this.quantity
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", thick="
            + this.thick
            + ", length="
            + this.length
            + ", surfaceArea="
            + this.surfaceArea
            + ")";
      }
   }
}
