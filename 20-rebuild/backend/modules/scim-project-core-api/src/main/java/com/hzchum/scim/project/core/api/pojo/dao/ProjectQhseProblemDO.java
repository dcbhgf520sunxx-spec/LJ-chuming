package com.hzchum.scim.project.core.api.pojo.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel(value = "ProjectQhseProblem对象DTO", description = "质安问题表 ")
public class ProjectQhseProblemDO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "number", value = "流水号", notes = "流水号")
   private String number;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @ApiModelProperty(name = "supplierId", value = "分包单位ID", notes = "分包单位ID")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "分包单位", notes = "分包单位")
   private String supplierName;
   @ApiModelProperty(name = "subcontractClassId", value = "分包类别id", notes = "分包类别id")
   private Long subcontractClassId;
   @ApiModelProperty(name = "subcontractClassName", value = "分包类别", notes = "分包类别")
   private String subcontractClassName;
   @ApiModelProperty(name = "problemDate", value = "日期", notes = "日期")
   private LocalDate problemDate;
   @ApiModelProperty(name = "promoterId", value = "发起人id", notes = "发起人id")
   private Long promoterId;
   @ApiModelProperty(name = "promoterName", value = "发起人", notes = "发起人")
   private String promoterName;
   @ApiModelProperty(name = "problemTypeId", value = "问题类型ID", notes = "问题类型ID")
   private Long problemTypeId;
   @ApiModelProperty(name = "problemTypeName", value = "问题类型", notes = "问题类型")
   private String problemTypeName;
   @ApiModelProperty(name = "beforeChangeImgs", value = "整改前图片", notes = "整改前图片")
   private String beforeChangeImgs;
   @ApiModelProperty(name = "afterChangeImgs", value = "整改后图片", notes = "整改后图片")
   private String afterChangeImgs;
   @ApiModelProperty(name = "boolChangeStatus", value = "整改状态 0未整改1已整改", notes = "整改状态 0未整改 1已整改")
   private Boolean boolChangeStatus;
   @ApiModelProperty(name = "penalty", value = "违约金", notes = "违约金")
   private BigDecimal penalty;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty("是否回复 true回复 false不回复")
   private Boolean boolReply;

   public static ProjectQhseProblemDO.ProjectQhseProblemDOBuilder builder() {
      return new ProjectQhseProblemDO.ProjectQhseProblemDOBuilder();
   }

   public ProjectQhseProblemDO() {
   }

   public ProjectQhseProblemDO(
      final Long id,
      final String number,
      final Long projectId,
      final ProjectInfo project,
      final Long monomerId,
      final Long supplierId,
      final String supplierName,
      final Long subcontractClassId,
      final String subcontractClassName,
      final LocalDate problemDate,
      final Long promoterId,
      final String promoterName,
      final Long problemTypeId,
      final String problemTypeName,
      final String beforeChangeImgs,
      final String afterChangeImgs,
      final Boolean boolChangeStatus,
      final BigDecimal penalty,
      final String remark,
      final Boolean boolReply
   ) {
      this.id = id;
      this.number = number;
      this.projectId = projectId;
      this.project = project;
      this.monomerId = monomerId;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.subcontractClassId = subcontractClassId;
      this.subcontractClassName = subcontractClassName;
      this.problemDate = problemDate;
      this.promoterId = promoterId;
      this.promoterName = promoterName;
      this.problemTypeId = problemTypeId;
      this.problemTypeName = problemTypeName;
      this.beforeChangeImgs = beforeChangeImgs;
      this.afterChangeImgs = afterChangeImgs;
      this.boolChangeStatus = boolChangeStatus;
      this.penalty = penalty;
      this.remark = remark;
      this.boolReply = boolReply;
   }

   public Long getId() {
      return this.id;
   }

   public String getNumber() {
      return this.number;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getSubcontractClassId() {
      return this.subcontractClassId;
   }

   public String getSubcontractClassName() {
      return this.subcontractClassName;
   }

   public LocalDate getProblemDate() {
      return this.problemDate;
   }

   public Long getPromoterId() {
      return this.promoterId;
   }

   public String getPromoterName() {
      return this.promoterName;
   }

   public Long getProblemTypeId() {
      return this.problemTypeId;
   }

   public String getProblemTypeName() {
      return this.problemTypeName;
   }

   public String getBeforeChangeImgs() {
      return this.beforeChangeImgs;
   }

   public String getAfterChangeImgs() {
      return this.afterChangeImgs;
   }

   public Boolean getBoolChangeStatus() {
      return this.boolChangeStatus;
   }

   public BigDecimal getPenalty() {
      return this.penalty;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolReply() {
      return this.boolReply;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setNumber(final String number) {
      this.number = number;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setSubcontractClassId(final Long subcontractClassId) {
      this.subcontractClassId = subcontractClassId;
   }

   public void setSubcontractClassName(final String subcontractClassName) {
      this.subcontractClassName = subcontractClassName;
   }

   public void setProblemDate(final LocalDate problemDate) {
      this.problemDate = problemDate;
   }

   public void setPromoterId(final Long promoterId) {
      this.promoterId = promoterId;
   }

   public void setPromoterName(final String promoterName) {
      this.promoterName = promoterName;
   }

   public void setProblemTypeId(final Long problemTypeId) {
      this.problemTypeId = problemTypeId;
   }

   public void setProblemTypeName(final String problemTypeName) {
      this.problemTypeName = problemTypeName;
   }

   public void setBeforeChangeImgs(final String beforeChangeImgs) {
      this.beforeChangeImgs = beforeChangeImgs;
   }

   public void setAfterChangeImgs(final String afterChangeImgs) {
      this.afterChangeImgs = afterChangeImgs;
   }

   public void setBoolChangeStatus(final Boolean boolChangeStatus) {
      this.boolChangeStatus = boolChangeStatus;
   }

   public void setPenalty(final BigDecimal penalty) {
      this.penalty = penalty;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBoolReply(final Boolean boolReply) {
      this.boolReply = boolReply;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectQhseProblemDO)) {
         return false;
      }

      ProjectQhseProblemDO other = (ProjectQhseProblemDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$supplierId = this.getSupplierId();
               Object other$supplierId = other.getSupplierId();
               if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                  Object this$subcontractClassId = this.getSubcontractClassId();
                  Object other$subcontractClassId = other.getSubcontractClassId();
                  if (this$subcontractClassId == null ? other$subcontractClassId == null : this$subcontractClassId.equals(other$subcontractClassId)) {
                     Object this$promoterId = this.getPromoterId();
                     Object other$promoterId = other.getPromoterId();
                     if (this$promoterId == null ? other$promoterId == null : this$promoterId.equals(other$promoterId)) {
                        Object this$problemTypeId = this.getProblemTypeId();
                        Object other$problemTypeId = other.getProblemTypeId();
                        if (this$problemTypeId == null ? other$problemTypeId == null : this$problemTypeId.equals(other$problemTypeId)) {
                           Object this$boolChangeStatus = this.getBoolChangeStatus();
                           Object other$boolChangeStatus = other.getBoolChangeStatus();
                           if (this$boolChangeStatus == null ? other$boolChangeStatus == null : this$boolChangeStatus.equals(other$boolChangeStatus)) {
                              Object this$boolReply = this.getBoolReply();
                              Object other$boolReply = other.getBoolReply();
                              if (this$boolReply == null ? other$boolReply == null : this$boolReply.equals(other$boolReply)) {
                                 Object this$number = this.getNumber();
                                 Object other$number = other.getNumber();
                                 if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                    Object this$project = this.getProject();
                                    Object other$project = other.getProject();
                                    if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                       Object this$supplierName = this.getSupplierName();
                                       Object other$supplierName = other.getSupplierName();
                                       if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                          Object this$subcontractClassName = this.getSubcontractClassName();
                                          Object other$subcontractClassName = other.getSubcontractClassName();
                                          if (this$subcontractClassName == null
                                             ? other$subcontractClassName == null
                                             : this$subcontractClassName.equals(other$subcontractClassName)) {
                                             Object this$problemDate = this.getProblemDate();
                                             Object other$problemDate = other.getProblemDate();
                                             if (this$problemDate == null ? other$problemDate == null : this$problemDate.equals(other$problemDate)) {
                                                Object this$promoterName = this.getPromoterName();
                                                Object other$promoterName = other.getPromoterName();
                                                if (this$promoterName == null ? other$promoterName == null : this$promoterName.equals(other$promoterName)) {
                                                   Object this$problemTypeName = this.getProblemTypeName();
                                                   Object other$problemTypeName = other.getProblemTypeName();
                                                   if (this$problemTypeName == null
                                                      ? other$problemTypeName == null
                                                      : this$problemTypeName.equals(other$problemTypeName)) {
                                                      Object this$beforeChangeImgs = this.getBeforeChangeImgs();
                                                      Object other$beforeChangeImgs = other.getBeforeChangeImgs();
                                                      if (this$beforeChangeImgs == null
                                                         ? other$beforeChangeImgs == null
                                                         : this$beforeChangeImgs.equals(other$beforeChangeImgs)) {
                                                         Object this$afterChangeImgs = this.getAfterChangeImgs();
                                                         Object other$afterChangeImgs = other.getAfterChangeImgs();
                                                         if (this$afterChangeImgs == null
                                                            ? other$afterChangeImgs == null
                                                            : this$afterChangeImgs.equals(other$afterChangeImgs)) {
                                                            Object this$penalty = this.getPenalty();
                                                            Object other$penalty = other.getPenalty();
                                                            if (this$penalty == null ? other$penalty == null : this$penalty.equals(other$penalty)) {
                                                               Object this$remark = this.getRemark();
                                                               Object other$remark = other.getRemark();
                                                               return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof ProjectQhseProblemDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $promoterId = this.getPromoterId();
      result = result * 59 + ($promoterId == null ? 43 : $promoterId.hashCode());
      Object $problemTypeId = this.getProblemTypeId();
      result = result * 59 + ($problemTypeId == null ? 43 : $problemTypeId.hashCode());
      Object $boolChangeStatus = this.getBoolChangeStatus();
      result = result * 59 + ($boolChangeStatus == null ? 43 : $boolChangeStatus.hashCode());
      Object $boolReply = this.getBoolReply();
      result = result * 59 + ($boolReply == null ? 43 : $boolReply.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $subcontractClassName = this.getSubcontractClassName();
      result = result * 59 + ($subcontractClassName == null ? 43 : $subcontractClassName.hashCode());
      Object $problemDate = this.getProblemDate();
      result = result * 59 + ($problemDate == null ? 43 : $problemDate.hashCode());
      Object $promoterName = this.getPromoterName();
      result = result * 59 + ($promoterName == null ? 43 : $promoterName.hashCode());
      Object $problemTypeName = this.getProblemTypeName();
      result = result * 59 + ($problemTypeName == null ? 43 : $problemTypeName.hashCode());
      Object $beforeChangeImgs = this.getBeforeChangeImgs();
      result = result * 59 + ($beforeChangeImgs == null ? 43 : $beforeChangeImgs.hashCode());
      Object $afterChangeImgs = this.getAfterChangeImgs();
      result = result * 59 + ($afterChangeImgs == null ? 43 : $afterChangeImgs.hashCode());
      Object $penalty = this.getPenalty();
      result = result * 59 + ($penalty == null ? 43 : $penalty.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectQhseProblemDO(id="
         + this.getId()
         + ", number="
         + this.getNumber()
         + ", projectId="
         + this.getProjectId()
         + ", project="
         + this.getProject()
         + ", monomerId="
         + this.getMonomerId()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", subcontractClassId="
         + this.getSubcontractClassId()
         + ", subcontractClassName="
         + this.getSubcontractClassName()
         + ", problemDate="
         + this.getProblemDate()
         + ", promoterId="
         + this.getPromoterId()
         + ", promoterName="
         + this.getPromoterName()
         + ", problemTypeId="
         + this.getProblemTypeId()
         + ", problemTypeName="
         + this.getProblemTypeName()
         + ", beforeChangeImgs="
         + this.getBeforeChangeImgs()
         + ", afterChangeImgs="
         + this.getAfterChangeImgs()
         + ", boolChangeStatus="
         + this.getBoolChangeStatus()
         + ", penalty="
         + this.getPenalty()
         + ", remark="
         + this.getRemark()
         + ", boolReply="
         + this.getBoolReply()
         + ")";
   }

   public static class ProjectQhseProblemDOBuilder {
      private Long id;
      private String number;
      private Long projectId;
      private ProjectInfo project;
      private Long monomerId;
      private Long supplierId;
      private String supplierName;
      private Long subcontractClassId;
      private String subcontractClassName;
      private LocalDate problemDate;
      private Long promoterId;
      private String promoterName;
      private Long problemTypeId;
      private String problemTypeName;
      private String beforeChangeImgs;
      private String afterChangeImgs;
      private Boolean boolChangeStatus;
      private BigDecimal penalty;
      private String remark;
      private Boolean boolReply;

      ProjectQhseProblemDOBuilder() {
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder number(final String number) {
         this.number = number;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder subcontractClassName(final String subcontractClassName) {
         this.subcontractClassName = subcontractClassName;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder problemDate(final LocalDate problemDate) {
         this.problemDate = problemDate;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder promoterId(final Long promoterId) {
         this.promoterId = promoterId;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder promoterName(final String promoterName) {
         this.promoterName = promoterName;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder problemTypeId(final Long problemTypeId) {
         this.problemTypeId = problemTypeId;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder problemTypeName(final String problemTypeName) {
         this.problemTypeName = problemTypeName;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder beforeChangeImgs(final String beforeChangeImgs) {
         this.beforeChangeImgs = beforeChangeImgs;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder afterChangeImgs(final String afterChangeImgs) {
         this.afterChangeImgs = afterChangeImgs;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder boolChangeStatus(final Boolean boolChangeStatus) {
         this.boolChangeStatus = boolChangeStatus;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder penalty(final BigDecimal penalty) {
         this.penalty = penalty;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectQhseProblemDO.ProjectQhseProblemDOBuilder boolReply(final Boolean boolReply) {
         this.boolReply = boolReply;
         return this;
      }

      public ProjectQhseProblemDO build() {
         return new ProjectQhseProblemDO(
            this.id,
            this.number,
            this.projectId,
            this.project,
            this.monomerId,
            this.supplierId,
            this.supplierName,
            this.subcontractClassId,
            this.subcontractClassName,
            this.problemDate,
            this.promoterId,
            this.promoterName,
            this.problemTypeId,
            this.problemTypeName,
            this.beforeChangeImgs,
            this.afterChangeImgs,
            this.boolChangeStatus,
            this.penalty,
            this.remark,
            this.boolReply
         );
      }

      @Override
      public String toString() {
         return "ProjectQhseProblemDO.ProjectQhseProblemDOBuilder(id="
            + this.id
            + ", number="
            + this.number
            + ", projectId="
            + this.projectId
            + ", project="
            + this.project
            + ", monomerId="
            + this.monomerId
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", subcontractClassId="
            + this.subcontractClassId
            + ", subcontractClassName="
            + this.subcontractClassName
            + ", problemDate="
            + this.problemDate
            + ", promoterId="
            + this.promoterId
            + ", promoterName="
            + this.promoterName
            + ", problemTypeId="
            + this.problemTypeId
            + ", problemTypeName="
            + this.problemTypeName
            + ", beforeChangeImgs="
            + this.beforeChangeImgs
            + ", afterChangeImgs="
            + this.afterChangeImgs
            + ", boolChangeStatus="
            + this.boolChangeStatus
            + ", penalty="
            + this.penalty
            + ", remark="
            + this.remark
            + ", boolReply="
            + this.boolReply
            + ")";
      }
   }
}
