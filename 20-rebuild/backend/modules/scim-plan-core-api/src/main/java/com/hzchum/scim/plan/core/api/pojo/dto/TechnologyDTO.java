package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;

@ApiModel("部门任务信息类")
public class TechnologyDTO {
   @ApiModelProperty(name = "id", value = "项目id")
   private Long id;
   @ApiModelProperty(name = "signingDate", notes = "立项日期")
   private LocalDate signingDate;
   @ApiModelProperty(name = "shortName", value = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "serialNumber", value = "项目编号")
   private String serialNumber;
   @ApiModelProperty(name = "planCreateDate", value = "计划编排日期")
   private LocalDate planCreateDate;
   @ApiModelProperty(name = "projectAttribute", notes = "项目属性: 1.自营 2.合营 3.包干制 枚举:ProjectAttributeEnum")
   private Integer projectAttribute;
   @ApiModelProperty(name = "businessType", value = "业务类型 1加工承揽 2项目承包")
   private Integer businessType;
   @ApiModelProperty("结构类型 参考枚举 structureStatusEnum：1.厂房 2.框架类 4.空间结构 8.梁式 16.拱式 32.钢架")
   private Integer structureStatus;
   @ApiModelProperty(name = "projectManagerName", notes = "项目经理名字")
   private String projectManagerName;
   @ApiModelProperty(name = "isCreateDeepArchivist", notes = "是否创建深化负责人 1.单体已全部创建深化负责人 0.有单体未创建深化负责人")
   private Boolean isCreateDeepArchivist;
   @ApiModelProperty(name = "monomerList", notes = "单体集合")
   private List<PlanMonomerDTO> monomerList;
   @ApiModelProperty(name = "lumpSumSystemType", notes = "包干制项目管理选项 参考枚举：LumpSumSystemEnum 1 其他 2.无管控，需加工 4.无管控，无加工 8.需加工，需管控 16.需加工，无需管控")
   private Integer lumpSumSystemType;

   public Long getId() {
      return this.id;
   }

   public LocalDate getSigningDate() {
      return this.signingDate;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public LocalDate getPlanCreateDate() {
      return this.planCreateDate;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getStructureStatus() {
      return this.structureStatus;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public Boolean getIsCreateDeepArchivist() {
      return this.isCreateDeepArchivist;
   }

   public List<PlanMonomerDTO> getMonomerList() {
      return this.monomerList;
   }

   public Integer getLumpSumSystemType() {
      return this.lumpSumSystemType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPlanCreateDate(final LocalDate planCreateDate) {
      this.planCreateDate = planCreateDate;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setStructureStatus(final Integer structureStatus) {
      this.structureStatus = structureStatus;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setIsCreateDeepArchivist(final Boolean isCreateDeepArchivist) {
      this.isCreateDeepArchivist = isCreateDeepArchivist;
   }

   public void setMonomerList(final List<PlanMonomerDTO> monomerList) {
      this.monomerList = monomerList;
   }

   public void setLumpSumSystemType(final Integer lumpSumSystemType) {
      this.lumpSumSystemType = lumpSumSystemType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechnologyDTO)) {
         return false;
      }

      TechnologyDTO other = (TechnologyDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectAttribute = this.getProjectAttribute();
         Object other$projectAttribute = other.getProjectAttribute();
         if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
            Object this$businessType = this.getBusinessType();
            Object other$businessType = other.getBusinessType();
            if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
               Object this$structureStatus = this.getStructureStatus();
               Object other$structureStatus = other.getStructureStatus();
               if (this$structureStatus == null ? other$structureStatus == null : this$structureStatus.equals(other$structureStatus)) {
                  Object this$isCreateDeepArchivist = this.getIsCreateDeepArchivist();
                  Object other$isCreateDeepArchivist = other.getIsCreateDeepArchivist();
                  if (this$isCreateDeepArchivist == null ? other$isCreateDeepArchivist == null : this$isCreateDeepArchivist.equals(other$isCreateDeepArchivist)
                     )
                   {
                     Object this$lumpSumSystemType = this.getLumpSumSystemType();
                     Object other$lumpSumSystemType = other.getLumpSumSystemType();
                     if (this$lumpSumSystemType == null ? other$lumpSumSystemType == null : this$lumpSumSystemType.equals(other$lumpSumSystemType)) {
                        Object this$signingDate = this.getSigningDate();
                        Object other$signingDate = other.getSigningDate();
                        if (this$signingDate == null ? other$signingDate == null : this$signingDate.equals(other$signingDate)) {
                           Object this$shortName = this.getShortName();
                           Object other$shortName = other.getShortName();
                           if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$planCreateDate = this.getPlanCreateDate();
                                 Object other$planCreateDate = other.getPlanCreateDate();
                                 if (this$planCreateDate == null ? other$planCreateDate == null : this$planCreateDate.equals(other$planCreateDate)) {
                                    Object this$projectManagerName = this.getProjectManagerName();
                                    Object other$projectManagerName = other.getProjectManagerName();
                                    if (this$projectManagerName == null
                                       ? other$projectManagerName == null
                                       : this$projectManagerName.equals(other$projectManagerName)) {
                                       Object this$monomerList = this.getMonomerList();
                                       Object other$monomerList = other.getMonomerList();
                                       return this$monomerList == null ? other$monomerList == null : this$monomerList.equals(other$monomerList);
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
      return other instanceof TechnologyDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $isCreateDeepArchivist = this.getIsCreateDeepArchivist();
      result = result * 59 + ($isCreateDeepArchivist == null ? 43 : $isCreateDeepArchivist.hashCode());
      Object $lumpSumSystemType = this.getLumpSumSystemType();
      result = result * 59 + ($lumpSumSystemType == null ? 43 : $lumpSumSystemType.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $planCreateDate = this.getPlanCreateDate();
      result = result * 59 + ($planCreateDate == null ? 43 : $planCreateDate.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $monomerList = this.getMonomerList();
      return result * 59 + ($monomerList == null ? 43 : $monomerList.hashCode());
   }

   @Override
   public String toString() {
      return "TechnologyDTO(id="
         + this.getId()
         + ", signingDate="
         + this.getSigningDate()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", planCreateDate="
         + this.getPlanCreateDate()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", businessType="
         + this.getBusinessType()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", isCreateDeepArchivist="
         + this.getIsCreateDeepArchivist()
         + ", monomerList="
         + this.getMonomerList()
         + ", lumpSumSystemType="
         + this.getLumpSumSystemType()
         + ")";
   }
}
