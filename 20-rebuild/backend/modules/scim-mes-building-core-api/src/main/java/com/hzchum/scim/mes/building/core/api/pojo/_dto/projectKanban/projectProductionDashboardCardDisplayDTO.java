package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import io.swagger.annotations.ApiModelProperty;

public class projectProductionDashboardCardDisplayDTO {
   @ApiModelProperty(name = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "producedQuantity", value = "已生产量")
   private Integer producedQuantity;
   @ApiModelProperty(name = "producedQuantity", value = "生产状态")
   private Integer status;
   @ApiModelProperty(name = "outsourcingQuantity", value = "外协数量")
   private Integer outsourcingQuantity;

   public static projectProductionDashboardCardDisplayDTO.projectProductionDashboardCardDisplayDTOBuilder builder() {
      return new projectProductionDashboardCardDisplayDTO.projectProductionDashboardCardDisplayDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getOutsourcingQuantity() {
      return this.outsourcingQuantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setOutsourcingQuantity(final Integer outsourcingQuantity) {
      this.outsourcingQuantity = outsourcingQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof projectProductionDashboardCardDisplayDTO)) {
         return false;
      }

      projectProductionDashboardCardDisplayDTO other = (projectProductionDashboardCardDisplayDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$producedQuantity = this.getProducedQuantity();
            Object other$producedQuantity = other.getProducedQuantity();
            if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$outsourcingQuantity = this.getOutsourcingQuantity();
                  Object other$outsourcingQuantity = other.getOutsourcingQuantity();
                  if (this$outsourcingQuantity == null ? other$outsourcingQuantity == null : this$outsourcingQuantity.equals(other$outsourcingQuantity)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$material = this.getMaterial();
                              Object other$material = other.getMaterial();
                              return this$material == null ? other$material == null : this$material.equals(other$material);
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
      return other instanceof projectProductionDashboardCardDisplayDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $outsourcingQuantity = this.getOutsourcingQuantity();
      result = result * 59 + ($outsourcingQuantity == null ? 43 : $outsourcingQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "projectProductionDashboardCardDisplayDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", status="
         + this.getStatus()
         + ", outsourcingQuantity="
         + this.getOutsourcingQuantity()
         + ")";
   }

   public projectProductionDashboardCardDisplayDTO(
      final Long id,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final Integer quantity,
      final Integer producedQuantity,
      final Integer status,
      final Integer outsourcingQuantity
   ) {
      this.id = id;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.quantity = quantity;
      this.producedQuantity = producedQuantity;
      this.status = status;
      this.outsourcingQuantity = outsourcingQuantity;
   }

   public projectProductionDashboardCardDisplayDTO() {
   }

   public static class projectProductionDashboardCardDisplayDTOBuilder {
      private Long id;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private Integer quantity;
      private Integer producedQuantity;
      private Integer status;
      private Integer outsourcingQuantity;

      projectProductionDashboardCardDisplayDTOBuilder() {
      }

      public projectProductionDashboardCardDisplayDTO.projectProductionDashboardCardDisplayDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public projectProductionDashboardCardDisplayDTO.projectProductionDashboardCardDisplayDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public projectProductionDashboardCardDisplayDTO.projectProductionDashboardCardDisplayDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public projectProductionDashboardCardDisplayDTO.projectProductionDashboardCardDisplayDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public projectProductionDashboardCardDisplayDTO.projectProductionDashboardCardDisplayDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public projectProductionDashboardCardDisplayDTO.projectProductionDashboardCardDisplayDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public projectProductionDashboardCardDisplayDTO.projectProductionDashboardCardDisplayDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      public projectProductionDashboardCardDisplayDTO.projectProductionDashboardCardDisplayDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public projectProductionDashboardCardDisplayDTO.projectProductionDashboardCardDisplayDTOBuilder outsourcingQuantity(final Integer outsourcingQuantity) {
         this.outsourcingQuantity = outsourcingQuantity;
         return this;
      }

      public projectProductionDashboardCardDisplayDTO build() {
         return new projectProductionDashboardCardDisplayDTO(
            this.id,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.quantity,
            this.producedQuantity,
            this.status,
            this.outsourcingQuantity
         );
      }

      @Override
      public String toString() {
         return "projectProductionDashboardCardDisplayDTO.projectProductionDashboardCardDisplayDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", producedQuantity="
            + this.producedQuantity
            + ", status="
            + this.status
            + ", outsourcingQuantity="
            + this.outsourcingQuantity
            + ")";
      }
   }
}
