package com.hzchum.scim.project.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApiModel(value = "ProjectQhseProblem对象DTO", description = "质安问题表 ")
public class ProjectQhseProblemDTO {
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
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "subcontractOrderId", value = "分包订单ID", notes = "分包订单ID")
   private Long subcontractOrderId;
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
   @ApiModelProperty(name = "beforeChangeImgs", value = "整改前图片列表", notes = "整改前图片列表")
   private List<AttachmentDTO> beforeChangeImgs;
   @ApiModelProperty(name = "afterChangeImgs", value = "整改后图片", notes = "整改后图片")
   private List<AttachmentDTO> afterChangeImgs;
   @ApiModelProperty(name = "boolChangeStatus", value = "整改状态 false未整改 true已整改", notes = "整改状态 false未整改 true已整改")
   private Boolean boolChangeStatus;
   @ApiModelProperty(name = "penalty", value = "违约金", notes = "违约金")
   private BigDecimal penalty;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "problemDesc", value = "问题描述", notes = "问题描述")
   private String problemDesc;
   @ApiModelProperty("是否回复 true回复 false不回复")
   private Boolean boolReply;
   @ApiModelProperty("整改报告")
   private ProjectQhseChangeDTO qhseChange;

   public static ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder builder() {
      return new ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder();
   }

   public ProjectQhseProblemDTO() {
   }

   public ProjectQhseProblemDTO(
      final Long id,
      final String number,
      final Long projectId,
      final ProjectInfo project,
      final Long monomerId,
      final NameInfo monomer,
      final Long subcontractOrderId,
      final Long supplierId,
      final String supplierName,
      final Long subcontractClassId,
      final String subcontractClassName,
      final LocalDate problemDate,
      final Long promoterId,
      final String promoterName,
      final Long problemTypeId,
      final String problemTypeName,
      final List<AttachmentDTO> beforeChangeImgs,
      final List<AttachmentDTO> afterChangeImgs,
      final Boolean boolChangeStatus,
      final BigDecimal penalty,
      final String remark,
      final String problemDesc,
      final Boolean boolReply,
      final ProjectQhseChangeDTO qhseChange
   ) {
      this.id = id;
      this.number = number;
      this.projectId = projectId;
      this.project = project;
      this.monomerId = monomerId;
      this.monomer = monomer;
      this.subcontractOrderId = subcontractOrderId;
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
      this.problemDesc = problemDesc;
      this.boolReply = boolReply;
      this.qhseChange = qhseChange;
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

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public Long getSubcontractOrderId() {
      return this.subcontractOrderId;
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

   public List<AttachmentDTO> getBeforeChangeImgs() {
      return this.beforeChangeImgs;
   }

   public List<AttachmentDTO> getAfterChangeImgs() {
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

   public String getProblemDesc() {
      return this.problemDesc;
   }

   public Boolean getBoolReply() {
      return this.boolReply;
   }

   public ProjectQhseChangeDTO getQhseChange() {
      return this.qhseChange;
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

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setSubcontractOrderId(final Long subcontractOrderId) {
      this.subcontractOrderId = subcontractOrderId;
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

   public void setBeforeChangeImgs(final List<AttachmentDTO> beforeChangeImgs) {
      this.beforeChangeImgs = beforeChangeImgs;
   }

   public void setAfterChangeImgs(final List<AttachmentDTO> afterChangeImgs) {
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

   public void setProblemDesc(final String problemDesc) {
      this.problemDesc = problemDesc;
   }

   public void setBoolReply(final Boolean boolReply) {
      this.boolReply = boolReply;
   }

   public void setQhseChange(final ProjectQhseChangeDTO qhseChange) {
      this.qhseChange = qhseChange;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectQhseProblemDTO)) {
         return false;
      }

      ProjectQhseProblemDTO other = (ProjectQhseProblemDTO)o;
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
               Object this$subcontractOrderId = this.getSubcontractOrderId();
               Object other$subcontractOrderId = other.getSubcontractOrderId();
               if (this$subcontractOrderId == null ? other$subcontractOrderId == null : this$subcontractOrderId.equals(other$subcontractOrderId)) {
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
                                          Object this$monomer = this.getMonomer();
                                          Object other$monomer = other.getMonomer();
                                          if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
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
                                                      if (this$promoterName == null ? other$promoterName == null : this$promoterName.equals(other$promoterName)
                                                         )
                                                       {
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
                                                                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                        Object this$problemDesc = this.getProblemDesc();
                                                                        Object other$problemDesc = other.getProblemDesc();
                                                                        if (this$problemDesc == null
                                                                           ? other$problemDesc == null
                                                                           : this$problemDesc.equals(other$problemDesc)) {
                                                                           Object this$qhseChange = this.getQhseChange();
                                                                           Object other$qhseChange = other.getQhseChange();
                                                                           return this$qhseChange == null
                                                                              ? other$qhseChange == null
                                                                              : this$qhseChange.equals(other$qhseChange);
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
      return other instanceof ProjectQhseProblemDTO;
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
      Object $subcontractOrderId = this.getSubcontractOrderId();
      result = result * 59 + ($subcontractOrderId == null ? 43 : $subcontractOrderId.hashCode());
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
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
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
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $problemDesc = this.getProblemDesc();
      result = result * 59 + ($problemDesc == null ? 43 : $problemDesc.hashCode());
      Object $qhseChange = this.getQhseChange();
      return result * 59 + ($qhseChange == null ? 43 : $qhseChange.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectQhseProblemDTO(id="
         + this.getId()
         + ", number="
         + this.getNumber()
         + ", projectId="
         + this.getProjectId()
         + ", project="
         + this.getProject()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomer="
         + this.getMonomer()
         + ", subcontractOrderId="
         + this.getSubcontractOrderId()
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
         + ", problemDesc="
         + this.getProblemDesc()
         + ", boolReply="
         + this.getBoolReply()
         + ", qhseChange="
         + this.getQhseChange()
         + ")";
   }

   public static class ProjectQhseProblemDTOBuilder {
      private Long id;
      private String number;
      private Long projectId;
      private ProjectInfo project;
      private Long monomerId;
      private NameInfo monomer;
      private Long subcontractOrderId;
      private Long supplierId;
      private String supplierName;
      private Long subcontractClassId;
      private String subcontractClassName;
      private LocalDate problemDate;
      private Long promoterId;
      private String promoterName;
      private Long problemTypeId;
      private String problemTypeName;
      private List<AttachmentDTO> beforeChangeImgs;
      private List<AttachmentDTO> afterChangeImgs;
      private Boolean boolChangeStatus;
      private BigDecimal penalty;
      private String remark;
      private String problemDesc;
      private Boolean boolReply;
      private ProjectQhseChangeDTO qhseChange;

      ProjectQhseProblemDTOBuilder() {
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder number(final String number) {
         this.number = number;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder subcontractOrderId(final Long subcontractOrderId) {
         this.subcontractOrderId = subcontractOrderId;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder subcontractClassName(final String subcontractClassName) {
         this.subcontractClassName = subcontractClassName;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder problemDate(final LocalDate problemDate) {
         this.problemDate = problemDate;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder promoterId(final Long promoterId) {
         this.promoterId = promoterId;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder promoterName(final String promoterName) {
         this.promoterName = promoterName;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder problemTypeId(final Long problemTypeId) {
         this.problemTypeId = problemTypeId;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder problemTypeName(final String problemTypeName) {
         this.problemTypeName = problemTypeName;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder beforeChangeImgs(final List<AttachmentDTO> beforeChangeImgs) {
         this.beforeChangeImgs = beforeChangeImgs;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder afterChangeImgs(final List<AttachmentDTO> afterChangeImgs) {
         this.afterChangeImgs = afterChangeImgs;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder boolChangeStatus(final Boolean boolChangeStatus) {
         this.boolChangeStatus = boolChangeStatus;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder penalty(final BigDecimal penalty) {
         this.penalty = penalty;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder problemDesc(final String problemDesc) {
         this.problemDesc = problemDesc;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder boolReply(final Boolean boolReply) {
         this.boolReply = boolReply;
         return this;
      }

      public ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder qhseChange(final ProjectQhseChangeDTO qhseChange) {
         this.qhseChange = qhseChange;
         return this;
      }

      public ProjectQhseProblemDTO build() {
         return new ProjectQhseProblemDTO(
            this.id,
            this.number,
            this.projectId,
            this.project,
            this.monomerId,
            this.monomer,
            this.subcontractOrderId,
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
            this.problemDesc,
            this.boolReply,
            this.qhseChange
         );
      }

      @Override
      public String toString() {
         return "ProjectQhseProblemDTO.ProjectQhseProblemDTOBuilder(id="
            + this.id
            + ", number="
            + this.number
            + ", projectId="
            + this.projectId
            + ", project="
            + this.project
            + ", monomerId="
            + this.monomerId
            + ", monomer="
            + this.monomer
            + ", subcontractOrderId="
            + this.subcontractOrderId
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
            + ", problemDesc="
            + this.problemDesc
            + ", boolReply="
            + this.boolReply
            + ", qhseChange="
            + this.qhseChange
            + ")";
      }
   }
}
