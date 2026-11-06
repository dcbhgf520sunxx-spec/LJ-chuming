package com.hzchum.scim.common.core.api.pojo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.dto.MonomerTreeDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ProjectInfo {
   @ApiModelProperty("项目id")
   private Long id;
   @ApiModelProperty("项目名称")
   private String name;
   @ApiModelProperty("项目简称")
   private String shortName;
   @ApiModelProperty("项目编号")
   private String serialNumber;
   @ApiModelProperty("项目经理ID")
   @JsonInclude(Include.NON_NULL)
   private Long projectManagerId;
   @ApiModelProperty("项目经理")
   @JsonInclude(Include.NON_NULL)
   private String projectManagerName;
   @ApiModelProperty("签订日期")
   @JsonInclude(Include.NON_NULL)
   private LocalDate signDate;
   @ApiModelProperty("签订日期")
   @JsonInclude(Include.NON_NULL)
   private LocalDate signingDate;
   @ApiModelProperty(name = "project_type", notes = "项目类型   1建筑钢结构 2桥梁钢结构  4立体停车库")
   @JsonInclude(Include.NON_NULL)
   private Integer projectType;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "end_date", notes = "约定完工时期")
   private LocalDate endDate;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "businessType", value = "业务类型 1加工承揽 2项目承包")
   private Integer businessType;
   @ApiModelProperty(name = "project_attribute", notes = "项目类型")
   @JsonInclude(Include.NON_NULL)
   private Integer projectAttribute;
   @ApiModelProperty(name = "contract_sign_body_id", notes = "合同签订主体id")
   @JsonInclude(Include.NON_NULL)
   private Long contractSignBodyId;
   @ApiModelProperty("等级")
   private Integer level;
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime createTime;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "monomerList", value = "单体列表")
   private List<MonomerTreeDTO> children;

   public static ProjectInfo.ProjectInfoBuilder builder() {
      return new ProjectInfo.ProjectInfoBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public LocalDate getSignDate() {
      return this.signDate;
   }

   public LocalDate getSigningDate() {
      return this.signingDate;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public Integer getLevel() {
      return this.level;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public List<MonomerTreeDTO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setSignDate(final LocalDate signDate) {
      this.signDate = signDate;
   }

   public void setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setChildren(final List<MonomerTreeDTO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInfo)) {
         return false;
      }

      ProjectInfo other = (ProjectInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectManagerId = this.getProjectManagerId();
         Object other$projectManagerId = other.getProjectManagerId();
         if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
            Object this$projectType = this.getProjectType();
            Object other$projectType = other.getProjectType();
            if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
               Object this$businessType = this.getBusinessType();
               Object other$businessType = other.getBusinessType();
               if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
                  Object this$projectAttribute = this.getProjectAttribute();
                  Object other$projectAttribute = other.getProjectAttribute();
                  if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                     Object this$contractSignBodyId = this.getContractSignBodyId();
                     Object other$contractSignBodyId = other.getContractSignBodyId();
                     if (this$contractSignBodyId == null ? other$contractSignBodyId == null : this$contractSignBodyId.equals(other$contractSignBodyId)) {
                        Object this$level = this.getLevel();
                        Object other$level = other.getLevel();
                        if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$shortName = this.getShortName();
                              Object other$shortName = other.getShortName();
                              if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$projectManagerName = this.getProjectManagerName();
                                    Object other$projectManagerName = other.getProjectManagerName();
                                    if (this$projectManagerName == null
                                       ? other$projectManagerName == null
                                       : this$projectManagerName.equals(other$projectManagerName)) {
                                       Object this$signDate = this.getSignDate();
                                       Object other$signDate = other.getSignDate();
                                       if (this$signDate == null ? other$signDate == null : this$signDate.equals(other$signDate)) {
                                          Object this$signingDate = this.getSigningDate();
                                          Object other$signingDate = other.getSigningDate();
                                          if (this$signingDate == null ? other$signingDate == null : this$signingDate.equals(other$signingDate)) {
                                             Object this$endDate = this.getEndDate();
                                             Object other$endDate = other.getEndDate();
                                             if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                                Object this$createTime = this.getCreateTime();
                                                Object other$createTime = other.getCreateTime();
                                                if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                   Object this$children = this.getChildren();
                                                   Object other$children = other.getChildren();
                                                   return this$children == null ? other$children == null : this$children.equals(other$children);
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
      return other instanceof ProjectInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $signDate = this.getSignDate();
      result = result * 59 + ($signDate == null ? 43 : $signDate.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInfo(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", signDate="
         + this.getSignDate()
         + ", signingDate="
         + this.getSigningDate()
         + ", projectType="
         + this.getProjectType()
         + ", endDate="
         + this.getEndDate()
         + ", businessType="
         + this.getBusinessType()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", level="
         + this.getLevel()
         + ", createTime="
         + this.getCreateTime()
         + ", children="
         + this.getChildren()
         + ")";
   }

   public ProjectInfo() {
   }

   public ProjectInfo(
      final Long id,
      final String name,
      final String shortName,
      final String serialNumber,
      final Long projectManagerId,
      final String projectManagerName,
      final LocalDate signDate,
      final LocalDate signingDate,
      final Integer projectType,
      final LocalDate endDate,
      final Integer businessType,
      final Integer projectAttribute,
      final Long contractSignBodyId,
      final Integer level,
      final LocalDateTime createTime,
      final List<MonomerTreeDTO> children
   ) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.serialNumber = serialNumber;
      this.projectManagerId = projectManagerId;
      this.projectManagerName = projectManagerName;
      this.signDate = signDate;
      this.signingDate = signingDate;
      this.projectType = projectType;
      this.endDate = endDate;
      this.businessType = businessType;
      this.projectAttribute = projectAttribute;
      this.contractSignBodyId = contractSignBodyId;
      this.level = level;
      this.createTime = createTime;
      this.children = children;
   }

   public static class ProjectInfoBuilder {
      private Long id;
      private String name;
      private String shortName;
      private String serialNumber;
      private Long projectManagerId;
      private String projectManagerName;
      private LocalDate signDate;
      private LocalDate signingDate;
      private Integer projectType;
      private LocalDate endDate;
      private Integer businessType;
      private Integer projectAttribute;
      private Long contractSignBodyId;
      private Integer level;
      private LocalDateTime createTime;
      private List<MonomerTreeDTO> children;

      ProjectInfoBuilder() {
      }

      public ProjectInfo.ProjectInfoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectInfo.ProjectInfoBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectInfo.ProjectInfoBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public ProjectInfo.ProjectInfoBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectInfo.ProjectInfoBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ProjectInfo.ProjectInfoBuilder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public ProjectInfo.ProjectInfoBuilder signDate(final LocalDate signDate) {
         this.signDate = signDate;
         return this;
      }

      public ProjectInfo.ProjectInfoBuilder signingDate(final LocalDate signingDate) {
         this.signingDate = signingDate;
         return this;
      }

      public ProjectInfo.ProjectInfoBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public ProjectInfo.ProjectInfoBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public ProjectInfo.ProjectInfoBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      public ProjectInfo.ProjectInfoBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public ProjectInfo.ProjectInfoBuilder contractSignBodyId(final Long contractSignBodyId) {
         this.contractSignBodyId = contractSignBodyId;
         return this;
      }

      public ProjectInfo.ProjectInfoBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public ProjectInfo.ProjectInfoBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectInfo.ProjectInfoBuilder children(final List<MonomerTreeDTO> children) {
         this.children = children;
         return this;
      }

      public ProjectInfo build() {
         return new ProjectInfo(
            this.id,
            this.name,
            this.shortName,
            this.serialNumber,
            this.projectManagerId,
            this.projectManagerName,
            this.signDate,
            this.signingDate,
            this.projectType,
            this.endDate,
            this.businessType,
            this.projectAttribute,
            this.contractSignBodyId,
            this.level,
            this.createTime,
            this.children
         );
      }

      @Override
      public String toString() {
         return "ProjectInfo.ProjectInfoBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", serialNumber="
            + this.serialNumber
            + ", projectManagerId="
            + this.projectManagerId
            + ", projectManagerName="
            + this.projectManagerName
            + ", signDate="
            + this.signDate
            + ", signingDate="
            + this.signingDate
            + ", projectType="
            + this.projectType
            + ", endDate="
            + this.endDate
            + ", businessType="
            + this.businessType
            + ", projectAttribute="
            + this.projectAttribute
            + ", contractSignBodyId="
            + this.contractSignBodyId
            + ", level="
            + this.level
            + ", createTime="
            + this.createTime
            + ", children="
            + this.children
            + ")";
      }
   }
}
