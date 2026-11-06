package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

public class ProjectReturnProductChildQueryDTOParam {
   private Long projectId;
   private Integer type;
   private Integer relationType;
   private Long warehouseId;
   private String name;
   private String serialNumber;
   private String specification;
   private String material;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
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

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReturnProductChildQueryDTOParam)) {
         return false;
      }

      ProjectReturnProductChildQueryDTOParam other = (ProjectReturnProductChildQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$relationType = this.getRelationType();
            Object other$relationType = other.getRelationType();
            if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
               Object this$warehouseId = this.getWarehouseId();
               Object other$warehouseId = other.getWarehouseId();
               if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectReturnProductChildQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
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
      return "ProjectReturnProductChildQueryDTOParam(projectId="
         + this.getProjectId()
         + ", type="
         + this.getType()
         + ", relationType="
         + this.getRelationType()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ")";
   }
}
