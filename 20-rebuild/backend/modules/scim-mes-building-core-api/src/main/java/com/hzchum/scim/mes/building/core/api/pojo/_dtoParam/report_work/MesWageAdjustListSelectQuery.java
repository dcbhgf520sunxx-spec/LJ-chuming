package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work;

import io.swagger.annotations.ApiModelProperty;

public class MesWageAdjustListSelectQuery {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("产品类型")
   private Integer TypeEnum;
   @ApiModelProperty("种类id")
   private Long classId;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("材质")
   private String material;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getTypeEnum() {
      return this.TypeEnum;
   }

   public Long getClassId() {
      return this.classId;
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

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setTypeEnum(final Integer TypeEnum) {
      this.TypeEnum = TypeEnum;
   }

   public void setClassId(final Long classId) {
      this.classId = classId;
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

      if (!(o instanceof MesWageAdjustListSelectQuery)) {
         return false;
      }

      MesWageAdjustListSelectQuery other = (MesWageAdjustListSelectQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$TypeEnum = this.getTypeEnum();
            Object other$TypeEnum = other.getTypeEnum();
            if (this$TypeEnum == null ? other$TypeEnum == null : this$TypeEnum.equals(other$TypeEnum)) {
               Object this$classId = this.getClassId();
               Object other$classId = other.getClassId();
               if (this$classId == null ? other$classId == null : this$classId.equals(other$classId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesWageAdjustListSelectQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $TypeEnum = this.getTypeEnum();
      result = result * 59 + ($TypeEnum == null ? 43 : $TypeEnum.hashCode());
      Object $classId = this.getClassId();
      result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "MesWageAdjustListSelectQuery(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", TypeEnum="
         + this.getTypeEnum()
         + ", classId="
         + this.getClassId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ")";
   }
}
