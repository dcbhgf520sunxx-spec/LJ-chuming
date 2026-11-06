package com.hzchum.scim.project.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesSafetyClassConfigDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;

@ApiModel(value = "ProjectQhseProblemDTOV2", description = "质安问题表")
public class ProjectQhseProblemDTOV2 {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "number", value = "流水号", notes = "流水号")
   private String number;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("项目")
   private ProjectInfo project;
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
   @ApiModelProperty(name = "promoterId", value = "责任人", notes = "责任人")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "责任人", notes = "责任人")
   private String userName;
   @ApiModelProperty(name = "parentClassDTO", value = "上级类别", notes = "上级类别")
   private MesSafetyClassConfigDTO parentClassDTO;
   @ApiModelProperty(name = "problemDTO", value = "问题详情", notes = "问题详情")
   private MesSafetyClassConfigDTO problemDTO;
   @ApiModelProperty(name = "beforeChangeImgs", value = "整改前图片列表", notes = "整改前图片列表")
   private List<AttachmentDTO> beforeChangeImgs;
   @ApiModelProperty(name = "afterChangeImgs", value = "整改后图片", notes = "整改后图片")
   private List<AttachmentDTO> afterChangeImgs;
   @ApiModelProperty(name = "boolChangeStatusV2", value = "整改状态", notes = "整改状态")
   private Integer boolChangeStatusV2;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "problemDesc", value = "问题描述", notes = "问题描述")
   private String problemDesc;
   @ApiModelProperty("是否回复 true回复 false不回复")
   private Boolean boolReply;
   @ApiModelProperty("整改报告")
   private ProjectQhseChangeDTO qhseChange;
   @ApiModelProperty(name = "powerType", value = "权限 [1 查看 2 整改 4 审核]")
   @JsonInclude(Include.NON_NULL)
   private Integer powerType;
   @ApiModelProperty("问题类型")
   private Integer type;
   @ApiModelProperty("对内对外")
   private Boolean isInternal;
   @JsonInclude
   private String typeName;
   @JsonInclude
   private String penalty;
   @JsonInclude
   private String isInternalName;

   public static ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder builder() {
      return new ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder();
   }

   public ProjectQhseProblemDTOV2() {
   }

   public ProjectQhseProblemDTOV2(
      final Long id,
      final String number,
      final Long projectId,
      final ProjectInfo project,
      final Long subcontractOrderId,
      final Long supplierId,
      final String supplierName,
      final Long subcontractClassId,
      final String subcontractClassName,
      final LocalDate problemDate,
      final Long promoterId,
      final String promoterName,
      final Long userId,
      final String userName,
      final MesSafetyClassConfigDTO parentClassDTO,
      final MesSafetyClassConfigDTO problemDTO,
      final List<AttachmentDTO> beforeChangeImgs,
      final List<AttachmentDTO> afterChangeImgs,
      final Integer boolChangeStatusV2,
      final String remark,
      final String problemDesc,
      final Boolean boolReply,
      final ProjectQhseChangeDTO qhseChange,
      final Integer powerType,
      final Integer type,
      final Boolean isInternal,
      final String typeName,
      final String penalty,
      final String isInternalName
   ) {
      this.id = id;
      this.number = number;
      this.projectId = projectId;
      this.project = project;
      this.subcontractOrderId = subcontractOrderId;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.subcontractClassId = subcontractClassId;
      this.subcontractClassName = subcontractClassName;
      this.problemDate = problemDate;
      this.promoterId = promoterId;
      this.promoterName = promoterName;
      this.userId = userId;
      this.userName = userName;
      this.parentClassDTO = parentClassDTO;
      this.problemDTO = problemDTO;
      this.beforeChangeImgs = beforeChangeImgs;
      this.afterChangeImgs = afterChangeImgs;
      this.boolChangeStatusV2 = boolChangeStatusV2;
      this.remark = remark;
      this.problemDesc = problemDesc;
      this.boolReply = boolReply;
      this.qhseChange = qhseChange;
      this.powerType = powerType;
      this.type = type;
      this.isInternal = isInternal;
      this.typeName = typeName;
      this.penalty = penalty;
      this.isInternalName = isInternalName;
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

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public MesSafetyClassConfigDTO getParentClassDTO() {
      return this.parentClassDTO;
   }

   public MesSafetyClassConfigDTO getProblemDTO() {
      return this.problemDTO;
   }

   public List<AttachmentDTO> getBeforeChangeImgs() {
      return this.beforeChangeImgs;
   }

   public List<AttachmentDTO> getAfterChangeImgs() {
      return this.afterChangeImgs;
   }

   public Integer getBoolChangeStatusV2() {
      return this.boolChangeStatusV2;
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

   public Integer getPowerType() {
      return this.powerType;
   }

   public Integer getType() {
      return this.type;
   }

   public Boolean getIsInternal() {
      return this.isInternal;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public String getPenalty() {
      return this.penalty;
   }

   public String getIsInternalName() {
      return this.isInternalName;
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

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setParentClassDTO(final MesSafetyClassConfigDTO parentClassDTO) {
      this.parentClassDTO = parentClassDTO;
   }

   public void setProblemDTO(final MesSafetyClassConfigDTO problemDTO) {
      this.problemDTO = problemDTO;
   }

   public void setBeforeChangeImgs(final List<AttachmentDTO> beforeChangeImgs) {
      this.beforeChangeImgs = beforeChangeImgs;
   }

   public void setAfterChangeImgs(final List<AttachmentDTO> afterChangeImgs) {
      this.afterChangeImgs = afterChangeImgs;
   }

   public void setBoolChangeStatusV2(final Integer boolChangeStatusV2) {
      this.boolChangeStatusV2 = boolChangeStatusV2;
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

   public void setPowerType(final Integer powerType) {
      this.powerType = powerType;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setIsInternal(final Boolean isInternal) {
      this.isInternal = isInternal;
   }

   public void setTypeName(final String typeName) {
      this.typeName = typeName;
   }

   public void setPenalty(final String penalty) {
      this.penalty = penalty;
   }

   public void setIsInternalName(final String isInternalName) {
      this.isInternalName = isInternalName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectQhseProblemDTOV2)) {
         return false;
      }

      ProjectQhseProblemDTOV2 other = (ProjectQhseProblemDTOV2)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
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
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$boolChangeStatusV2 = this.getBoolChangeStatusV2();
                           Object other$boolChangeStatusV2 = other.getBoolChangeStatusV2();
                           if (this$boolChangeStatusV2 == null ? other$boolChangeStatusV2 == null : this$boolChangeStatusV2.equals(other$boolChangeStatusV2)) {
                              Object this$boolReply = this.getBoolReply();
                              Object other$boolReply = other.getBoolReply();
                              if (this$boolReply == null ? other$boolReply == null : this$boolReply.equals(other$boolReply)) {
                                 Object this$powerType = this.getPowerType();
                                 Object other$powerType = other.getPowerType();
                                 if (this$powerType == null ? other$powerType == null : this$powerType.equals(other$powerType)) {
                                    Object this$type = this.getType();
                                    Object other$type = other.getType();
                                    if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                       Object this$isInternal = this.getIsInternal();
                                       Object other$isInternal = other.getIsInternal();
                                       if (this$isInternal == null ? other$isInternal == null : this$isInternal.equals(other$isInternal)) {
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
                                                         if (this$promoterName == null
                                                            ? other$promoterName == null
                                                            : this$promoterName.equals(other$promoterName)) {
                                                            Object this$userName = this.getUserName();
                                                            Object other$userName = other.getUserName();
                                                            if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                               Object this$parentClassDTO = this.getParentClassDTO();
                                                               Object other$parentClassDTO = other.getParentClassDTO();
                                                               if (this$parentClassDTO == null
                                                                  ? other$parentClassDTO == null
                                                                  : this$parentClassDTO.equals(other$parentClassDTO)) {
                                                                  Object this$problemDTO = this.getProblemDTO();
                                                                  Object other$problemDTO = other.getProblemDTO();
                                                                  if (this$problemDTO == null
                                                                     ? other$problemDTO == null
                                                                     : this$problemDTO.equals(other$problemDTO)) {
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
                                                                                 if (this$qhseChange == null
                                                                                    ? other$qhseChange == null
                                                                                    : this$qhseChange.equals(other$qhseChange)) {
                                                                                    Object this$typeName = this.getTypeName();
                                                                                    Object other$typeName = other.getTypeName();
                                                                                    if (this$typeName == null
                                                                                       ? other$typeName == null
                                                                                       : this$typeName.equals(other$typeName)) {
                                                                                       Object this$penalty = this.getPenalty();
                                                                                       Object other$penalty = other.getPenalty();
                                                                                       if (this$penalty == null
                                                                                          ? other$penalty == null
                                                                                          : this$penalty.equals(other$penalty)) {
                                                                                          Object this$isInternalName = this.getIsInternalName();
                                                                                          Object other$isInternalName = other.getIsInternalName();
                                                                                          return this$isInternalName == null
                                                                                             ? other$isInternalName == null
                                                                                             : this$isInternalName.equals(other$isInternalName);
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
      return other instanceof ProjectQhseProblemDTOV2;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $subcontractOrderId = this.getSubcontractOrderId();
      result = result * 59 + ($subcontractOrderId == null ? 43 : $subcontractOrderId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $promoterId = this.getPromoterId();
      result = result * 59 + ($promoterId == null ? 43 : $promoterId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolChangeStatusV2 = this.getBoolChangeStatusV2();
      result = result * 59 + ($boolChangeStatusV2 == null ? 43 : $boolChangeStatusV2.hashCode());
      Object $boolReply = this.getBoolReply();
      result = result * 59 + ($boolReply == null ? 43 : $boolReply.hashCode());
      Object $powerType = this.getPowerType();
      result = result * 59 + ($powerType == null ? 43 : $powerType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $isInternal = this.getIsInternal();
      result = result * 59 + ($isInternal == null ? 43 : $isInternal.hashCode());
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
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $parentClassDTO = this.getParentClassDTO();
      result = result * 59 + ($parentClassDTO == null ? 43 : $parentClassDTO.hashCode());
      Object $problemDTO = this.getProblemDTO();
      result = result * 59 + ($problemDTO == null ? 43 : $problemDTO.hashCode());
      Object $beforeChangeImgs = this.getBeforeChangeImgs();
      result = result * 59 + ($beforeChangeImgs == null ? 43 : $beforeChangeImgs.hashCode());
      Object $afterChangeImgs = this.getAfterChangeImgs();
      result = result * 59 + ($afterChangeImgs == null ? 43 : $afterChangeImgs.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $problemDesc = this.getProblemDesc();
      result = result * 59 + ($problemDesc == null ? 43 : $problemDesc.hashCode());
      Object $qhseChange = this.getQhseChange();
      result = result * 59 + ($qhseChange == null ? 43 : $qhseChange.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $penalty = this.getPenalty();
      result = result * 59 + ($penalty == null ? 43 : $penalty.hashCode());
      Object $isInternalName = this.getIsInternalName();
      return result * 59 + ($isInternalName == null ? 43 : $isInternalName.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectQhseProblemDTOV2(id="
         + this.getId()
         + ", number="
         + this.getNumber()
         + ", projectId="
         + this.getProjectId()
         + ", project="
         + this.getProject()
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
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", parentClassDTO="
         + this.getParentClassDTO()
         + ", problemDTO="
         + this.getProblemDTO()
         + ", beforeChangeImgs="
         + this.getBeforeChangeImgs()
         + ", afterChangeImgs="
         + this.getAfterChangeImgs()
         + ", boolChangeStatusV2="
         + this.getBoolChangeStatusV2()
         + ", remark="
         + this.getRemark()
         + ", problemDesc="
         + this.getProblemDesc()
         + ", boolReply="
         + this.getBoolReply()
         + ", qhseChange="
         + this.getQhseChange()
         + ", powerType="
         + this.getPowerType()
         + ", type="
         + this.getType()
         + ", isInternal="
         + this.getIsInternal()
         + ", typeName="
         + this.getTypeName()
         + ", penalty="
         + this.getPenalty()
         + ", isInternalName="
         + this.getIsInternalName()
         + ")";
   }

   public static class ProjectQhseProblemDTOV2Builder {
      private Long id;
      private String number;
      private Long projectId;
      private ProjectInfo project;
      private Long subcontractOrderId;
      private Long supplierId;
      private String supplierName;
      private Long subcontractClassId;
      private String subcontractClassName;
      private LocalDate problemDate;
      private Long promoterId;
      private String promoterName;
      private Long userId;
      private String userName;
      private MesSafetyClassConfigDTO parentClassDTO;
      private MesSafetyClassConfigDTO problemDTO;
      private List<AttachmentDTO> beforeChangeImgs;
      private List<AttachmentDTO> afterChangeImgs;
      private Integer boolChangeStatusV2;
      private String remark;
      private String problemDesc;
      private Boolean boolReply;
      private ProjectQhseChangeDTO qhseChange;
      private Integer powerType;
      private Integer type;
      private Boolean isInternal;
      private String typeName;
      private String penalty;
      private String isInternalName;

      ProjectQhseProblemDTOV2Builder() {
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder number(final String number) {
         this.number = number;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder subcontractOrderId(final Long subcontractOrderId) {
         this.subcontractOrderId = subcontractOrderId;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder subcontractClassName(final String subcontractClassName) {
         this.subcontractClassName = subcontractClassName;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder problemDate(final LocalDate problemDate) {
         this.problemDate = problemDate;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder promoterId(final Long promoterId) {
         this.promoterId = promoterId;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder promoterName(final String promoterName) {
         this.promoterName = promoterName;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder parentClassDTO(final MesSafetyClassConfigDTO parentClassDTO) {
         this.parentClassDTO = parentClassDTO;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder problemDTO(final MesSafetyClassConfigDTO problemDTO) {
         this.problemDTO = problemDTO;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder beforeChangeImgs(final List<AttachmentDTO> beforeChangeImgs) {
         this.beforeChangeImgs = beforeChangeImgs;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder afterChangeImgs(final List<AttachmentDTO> afterChangeImgs) {
         this.afterChangeImgs = afterChangeImgs;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder boolChangeStatusV2(final Integer boolChangeStatusV2) {
         this.boolChangeStatusV2 = boolChangeStatusV2;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder problemDesc(final String problemDesc) {
         this.problemDesc = problemDesc;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder boolReply(final Boolean boolReply) {
         this.boolReply = boolReply;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder qhseChange(final ProjectQhseChangeDTO qhseChange) {
         this.qhseChange = qhseChange;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder powerType(final Integer powerType) {
         this.powerType = powerType;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder isInternal(final Boolean isInternal) {
         this.isInternal = isInternal;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder typeName(final String typeName) {
         this.typeName = typeName;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder penalty(final String penalty) {
         this.penalty = penalty;
         return this;
      }

      public ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder isInternalName(final String isInternalName) {
         this.isInternalName = isInternalName;
         return this;
      }

      public ProjectQhseProblemDTOV2 build() {
         return new ProjectQhseProblemDTOV2(
            this.id,
            this.number,
            this.projectId,
            this.project,
            this.subcontractOrderId,
            this.supplierId,
            this.supplierName,
            this.subcontractClassId,
            this.subcontractClassName,
            this.problemDate,
            this.promoterId,
            this.promoterName,
            this.userId,
            this.userName,
            this.parentClassDTO,
            this.problemDTO,
            this.beforeChangeImgs,
            this.afterChangeImgs,
            this.boolChangeStatusV2,
            this.remark,
            this.problemDesc,
            this.boolReply,
            this.qhseChange,
            this.powerType,
            this.type,
            this.isInternal,
            this.typeName,
            this.penalty,
            this.isInternalName
         );
      }

      @Override
      public String toString() {
         return "ProjectQhseProblemDTOV2.ProjectQhseProblemDTOV2Builder(id="
            + this.id
            + ", number="
            + this.number
            + ", projectId="
            + this.projectId
            + ", project="
            + this.project
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
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", parentClassDTO="
            + this.parentClassDTO
            + ", problemDTO="
            + this.problemDTO
            + ", beforeChangeImgs="
            + this.beforeChangeImgs
            + ", afterChangeImgs="
            + this.afterChangeImgs
            + ", boolChangeStatusV2="
            + this.boolChangeStatusV2
            + ", remark="
            + this.remark
            + ", problemDesc="
            + this.problemDesc
            + ", boolReply="
            + this.boolReply
            + ", qhseChange="
            + this.qhseChange
            + ", powerType="
            + this.powerType
            + ", type="
            + this.type
            + ", isInternal="
            + this.isInternal
            + ", typeName="
            + this.typeName
            + ", penalty="
            + this.penalty
            + ", isInternalName="
            + this.isInternalName
            + ")";
      }
   }
}
