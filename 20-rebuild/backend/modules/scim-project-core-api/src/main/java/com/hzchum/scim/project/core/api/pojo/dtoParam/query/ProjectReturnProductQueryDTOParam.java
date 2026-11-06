package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("退货产品查询类")
public class ProjectReturnProductQueryDTOParam {
   @NotNull(message = "产品类型不能为空!")
   @ApiModelProperty("产品类型")
   private Integer type;
   @ApiModelProperty("配套件关联类型 2关联构件 4关联围护")
   private Integer relationType;
   @NotNull(message = "项目不能为空!")
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("区域id")
   private Long areaId;
   @ApiModelProperty("围护计划id")
   private Long planId;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty("退货产品状态 1已发运 2已入库 4未入库(已排产未入库)")
   private Integer status = 1;

   public static ProjectReturnProductQueryDTOParam.ProjectReturnProductQueryDTOParamBuilder builder() {
      return new ProjectReturnProductQueryDTOParam.ProjectReturnProductQueryDTOParamBuilder();
   }

   public ProjectReturnProductQueryDTOParam(
      final Integer type,
      final Integer relationType,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long planId,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final Integer status
   ) {
      this.type = type;
      this.relationType = relationType;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.planId = planId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.status = status;
   }

   public ProjectReturnProductQueryDTOParam() {
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getPlanId() {
      return this.planId;
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

   public Integer getStatus() {
      return this.status;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setPlanId(final Long planId) {
      this.planId = planId;
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

   public void setStatus(final Integer status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReturnProductQueryDTOParam)) {
         return false;
      }

      ProjectReturnProductQueryDTOParam other = (ProjectReturnProductQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$relationType = this.getRelationType();
         Object other$relationType = other.getRelationType();
         if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$planId = this.getPlanId();
                     Object other$planId = other.getPlanId();
                     if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectReturnProductQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
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
      return "ProjectReturnProductQueryDTOParam(type="
         + this.getType()
         + ", relationType="
         + this.getRelationType()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", planId="
         + this.getPlanId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class ProjectReturnProductQueryDTOParamBuilder {
      private Integer type;
      private Integer relationType;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long planId;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private Integer status;

      ProjectReturnProductQueryDTOParamBuilder() {
      }

      public ProjectReturnProductQueryDTOParam.ProjectReturnProductQueryDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ProjectReturnProductQueryDTOParam.ProjectReturnProductQueryDTOParamBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public ProjectReturnProductQueryDTOParam.ProjectReturnProductQueryDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectReturnProductQueryDTOParam.ProjectReturnProductQueryDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectReturnProductQueryDTOParam.ProjectReturnProductQueryDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectReturnProductQueryDTOParam.ProjectReturnProductQueryDTOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      public ProjectReturnProductQueryDTOParam.ProjectReturnProductQueryDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectReturnProductQueryDTOParam.ProjectReturnProductQueryDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectReturnProductQueryDTOParam.ProjectReturnProductQueryDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectReturnProductQueryDTOParam.ProjectReturnProductQueryDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ProjectReturnProductQueryDTOParam.ProjectReturnProductQueryDTOParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ProjectReturnProductQueryDTOParam build() {
         return new ProjectReturnProductQueryDTOParam(
            this.type,
            this.relationType,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.planId,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.status
         );
      }

      @Override
      public String toString() {
         return "ProjectReturnProductQueryDTOParam.ProjectReturnProductQueryDTOParamBuilder(type="
            + this.type
            + ", relationType="
            + this.relationType
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", planId="
            + this.planId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", status="
            + this.status
            + ")";
      }
   }
}
