package com.hzchum.scim.contract.core.api.pojo.dtoParam.project;

import io.swagger.annotations.ApiModelProperty;

public class ContractProjectFilesParam {
   @ApiModelProperty(name = "year", notes = "年份 例如:2022")
   private Integer year;
   @ApiModelProperty(name = "isArchive", notes = "是否归档 1.归档 0.未归档")
   private Integer isArchive;
   @ApiModelProperty(name = "projectAttribute", notes = "项目属性: 1.自营 2.合营 3.包干制 参考枚举：ProjectAttributeEnum")
   private Integer projectAttribute;
   @ApiModelProperty(name = "projectType", notes = "项目类型   1建筑钢结构 2桥梁钢结构  4立体停车库 参考枚举 ProjectTypeEnum")
   private Integer projectType;
   @ApiModelProperty(name = "businessType", value = "项目订单类型 1.加工业务 2.项目承包 ")
   private Integer businessType;
   @ApiModelProperty(name = "structureStatus", value = "结构类型")
   private Integer structureStatus;
   @ApiModelProperty(name = "contractSignBodyId", notes = "合同签订主体id(公司,单位...)")
   private Long contractSignBodyId;
   @ApiModelProperty(name = "isBuilding", value = "装配式建筑 1.是  0.否")
   private Integer isBuilding;
   @ApiModelProperty(name = "name", value = "项目名称或者编号搜索")
   private String name;

   public Integer getYear() {
      return this.year;
   }

   public Integer getIsArchive() {
      return this.isArchive;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getStructureStatus() {
      return this.structureStatus;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public Integer getIsBuilding() {
      return this.isBuilding;
   }

   public String getName() {
      return this.name;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setIsArchive(final Integer isArchive) {
      this.isArchive = isArchive;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setStructureStatus(final Integer structureStatus) {
      this.structureStatus = structureStatus;
   }

   public void setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
   }

   public void setIsBuilding(final Integer isBuilding) {
      this.isBuilding = isBuilding;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectFilesParam)) {
         return false;
      }

      ContractProjectFilesParam other = (ContractProjectFilesParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$year = this.getYear();
      Object other$year = other.getYear();
      if (this$year == null ? other$year == null : this$year.equals(other$year)) {
         Object this$isArchive = this.getIsArchive();
         Object other$isArchive = other.getIsArchive();
         if (this$isArchive == null ? other$isArchive == null : this$isArchive.equals(other$isArchive)) {
            Object this$projectAttribute = this.getProjectAttribute();
            Object other$projectAttribute = other.getProjectAttribute();
            if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
               Object this$projectType = this.getProjectType();
               Object other$projectType = other.getProjectType();
               if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                  Object this$businessType = this.getBusinessType();
                  Object other$businessType = other.getBusinessType();
                  if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
                     Object this$structureStatus = this.getStructureStatus();
                     Object other$structureStatus = other.getStructureStatus();
                     if (this$structureStatus == null ? other$structureStatus == null : this$structureStatus.equals(other$structureStatus)) {
                        Object this$contractSignBodyId = this.getContractSignBodyId();
                        Object other$contractSignBodyId = other.getContractSignBodyId();
                        if (this$contractSignBodyId == null ? other$contractSignBodyId == null : this$contractSignBodyId.equals(other$contractSignBodyId)) {
                           Object this$isBuilding = this.getIsBuilding();
                           Object other$isBuilding = other.getIsBuilding();
                           if (this$isBuilding == null ? other$isBuilding == null : this$isBuilding.equals(other$isBuilding)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof ContractProjectFilesParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $isArchive = this.getIsArchive();
      result = result * 59 + ($isArchive == null ? 43 : $isArchive.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $isBuilding = this.getIsBuilding();
      result = result * 59 + ($isBuilding == null ? 43 : $isBuilding.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectFilesParam(year="
         + this.getYear()
         + ", isArchive="
         + this.getIsArchive()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", projectType="
         + this.getProjectType()
         + ", businessType="
         + this.getBusinessType()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", isBuilding="
         + this.getIsBuilding()
         + ", name="
         + this.getName()
         + ")";
   }
}
