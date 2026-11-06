package com.hzchum.scim.project.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ProjectSubVisaDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "number", value = "流水号", notes = "流水号")
   private String number;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "applyDate", value = "申请日期", notes = "申请日期")
   private LocalDateTime applyDate;
   @ApiModelProperty(name = "visaReasonId", value = "签证原因ID", notes = "签证原因ID")
   private Long visaReasonId;
   @ApiModelProperty(name = "visaReasonName", value = "签证原因", notes = "签证原因")
   private String visaReasonName;
   @ApiModelProperty(name = "visaAmount", value = "签证金额", notes = "签证金额")
   private BigDecimal visaAmount;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "subcontractOrderId", value = "分包订单ID", notes = "分包订单ID")
   private Long subcontractOrderId;
   @ApiModelProperty(name = "supplierId", value = "分包单位id", notes = "分包单位id")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "分包单位", notes = "分包单位")
   private String supplierName;
   @ApiModelProperty(name = "subcontractClassId", value = "分包类别id", notes = "分包类别id")
   private Long subcontractClassId;
   @ApiModelProperty(name = "subcontractClassName", value = "分包类别名称", notes = "分包类别名称")
   private String subcontractClassName;
   @ApiModelProperty(name = "auditUserId", value = "审核人ID", notes = "审核人ID")
   private Long auditUserId;
   @ApiModelProperty(name = "auditUserName", value = "审核人", notes = "审核人")
   private String auditUserName;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1待审核 2通过 4驳回", notes = "审核状态 1待审核2通过4驳回")
   private Integer auditStatus;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "approverId", value = "审批人ID", notes = "审批人ID")
   private Long approverId;
   @ApiModelProperty(name = "approverName", value = "审批人", notes = "审批人")
   private String approverName;
   @ApiModelProperty(name = "approveTime", value = "审批时间", notes = "审批时间")
   private LocalDateTime approveTime;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   private String attachmentIds;
   @ApiModelProperty(name = "attachments", value = "附件对象列表", notes = "附件对象列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public static ProjectSubVisaDTO.ProjectSubVisaDTOBuilder builder() {
      return new ProjectSubVisaDTO.ProjectSubVisaDTOBuilder();
   }

   public ProjectSubVisaDTO() {
   }

   public ProjectSubVisaDTO(
      final Long id,
      final String number,
      final String serialNumber,
      final LocalDateTime applyDate,
      final Long visaReasonId,
      final String visaReasonName,
      final BigDecimal visaAmount,
      final Long projectId,
      final ProjectInfo project,
      final Long monomerId,
      final NameInfo monomer,
      final Long subcontractOrderId,
      final Long supplierId,
      final String supplierName,
      final Long subcontractClassId,
      final String subcontractClassName,
      final Long auditUserId,
      final String auditUserName,
      final Integer auditStatus,
      final LocalDateTime auditTime,
      final Long approverId,
      final String approverName,
      final LocalDateTime approveTime,
      final String attachmentIds,
      final List<AttachmentDTO> attachments,
      final String remark
   ) {
      this.id = id;
      this.number = number;
      this.serialNumber = serialNumber;
      this.applyDate = applyDate;
      this.visaReasonId = visaReasonId;
      this.visaReasonName = visaReasonName;
      this.visaAmount = visaAmount;
      this.projectId = projectId;
      this.project = project;
      this.monomerId = monomerId;
      this.monomer = monomer;
      this.subcontractOrderId = subcontractOrderId;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.subcontractClassId = subcontractClassId;
      this.subcontractClassName = subcontractClassName;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditStatus = auditStatus;
      this.auditTime = auditTime;
      this.approverId = approverId;
      this.approverName = approverName;
      this.approveTime = approveTime;
      this.attachmentIds = attachmentIds;
      this.attachments = attachments;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public String getNumber() {
      return this.number;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public LocalDateTime getApplyDate() {
      return this.applyDate;
   }

   public Long getVisaReasonId() {
      return this.visaReasonId;
   }

   public String getVisaReasonName() {
      return this.visaReasonName;
   }

   public BigDecimal getVisaAmount() {
      return this.visaAmount;
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

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Long getApproverId() {
      return this.approverId;
   }

   public String getApproverName() {
      return this.approverName;
   }

   public LocalDateTime getApproveTime() {
      return this.approveTime;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setNumber(final String number) {
      this.number = number;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setApplyDate(final LocalDateTime applyDate) {
      this.applyDate = applyDate;
   }

   public void setVisaReasonId(final Long visaReasonId) {
      this.visaReasonId = visaReasonId;
   }

   public void setVisaReasonName(final String visaReasonName) {
      this.visaReasonName = visaReasonName;
   }

   public void setVisaAmount(final BigDecimal visaAmount) {
      this.visaAmount = visaAmount;
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

   public void setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setApproverId(final Long approverId) {
      this.approverId = approverId;
   }

   public void setApproverName(final String approverName) {
      this.approverName = approverName;
   }

   public void setApproveTime(final LocalDateTime approveTime) {
      this.approveTime = approveTime;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSubVisaDTO)) {
         return false;
      }

      ProjectSubVisaDTO other = (ProjectSubVisaDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$visaReasonId = this.getVisaReasonId();
         Object other$visaReasonId = other.getVisaReasonId();
         if (this$visaReasonId == null ? other$visaReasonId == null : this$visaReasonId.equals(other$visaReasonId)) {
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
                           Object this$auditUserId = this.getAuditUserId();
                           Object other$auditUserId = other.getAuditUserId();
                           if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                              Object this$auditStatus = this.getAuditStatus();
                              Object other$auditStatus = other.getAuditStatus();
                              if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                 Object this$approverId = this.getApproverId();
                                 Object other$approverId = other.getApproverId();
                                 if (this$approverId == null ? other$approverId == null : this$approverId.equals(other$approverId)) {
                                    Object this$number = this.getNumber();
                                    Object other$number = other.getNumber();
                                    if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$applyDate = this.getApplyDate();
                                          Object other$applyDate = other.getApplyDate();
                                          if (this$applyDate == null ? other$applyDate == null : this$applyDate.equals(other$applyDate)) {
                                             Object this$visaReasonName = this.getVisaReasonName();
                                             Object other$visaReasonName = other.getVisaReasonName();
                                             if (this$visaReasonName == null ? other$visaReasonName == null : this$visaReasonName.equals(other$visaReasonName)) {
                                                Object this$visaAmount = this.getVisaAmount();
                                                Object other$visaAmount = other.getVisaAmount();
                                                if (this$visaAmount == null ? other$visaAmount == null : this$visaAmount.equals(other$visaAmount)) {
                                                   Object this$project = this.getProject();
                                                   Object other$project = other.getProject();
                                                   if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                      Object this$monomer = this.getMonomer();
                                                      Object other$monomer = other.getMonomer();
                                                      if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                         Object this$supplierName = this.getSupplierName();
                                                         Object other$supplierName = other.getSupplierName();
                                                         if (this$supplierName == null
                                                            ? other$supplierName == null
                                                            : this$supplierName.equals(other$supplierName)) {
                                                            Object this$subcontractClassName = this.getSubcontractClassName();
                                                            Object other$subcontractClassName = other.getSubcontractClassName();
                                                            if (this$subcontractClassName == null
                                                               ? other$subcontractClassName == null
                                                               : this$subcontractClassName.equals(other$subcontractClassName)) {
                                                               Object this$auditUserName = this.getAuditUserName();
                                                               Object other$auditUserName = other.getAuditUserName();
                                                               if (this$auditUserName == null
                                                                  ? other$auditUserName == null
                                                                  : this$auditUserName.equals(other$auditUserName)) {
                                                                  Object this$auditTime = this.getAuditTime();
                                                                  Object other$auditTime = other.getAuditTime();
                                                                  if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)
                                                                     )
                                                                   {
                                                                     Object this$approverName = this.getApproverName();
                                                                     Object other$approverName = other.getApproverName();
                                                                     if (this$approverName == null
                                                                        ? other$approverName == null
                                                                        : this$approverName.equals(other$approverName)) {
                                                                        Object this$approveTime = this.getApproveTime();
                                                                        Object other$approveTime = other.getApproveTime();
                                                                        if (this$approveTime == null
                                                                           ? other$approveTime == null
                                                                           : this$approveTime.equals(other$approveTime)) {
                                                                           Object this$attachmentIds = this.getAttachmentIds();
                                                                           Object other$attachmentIds = other.getAttachmentIds();
                                                                           if (this$attachmentIds == null
                                                                              ? other$attachmentIds == null
                                                                              : this$attachmentIds.equals(other$attachmentIds)) {
                                                                              Object this$attachments = this.getAttachments();
                                                                              Object other$attachments = other.getAttachments();
                                                                              if (this$attachments == null
                                                                                 ? other$attachments == null
                                                                                 : this$attachments.equals(other$attachments)) {
                                                                                 Object this$remark = this.getRemark();
                                                                                 Object other$remark = other.getRemark();
                                                                                 return this$remark == null
                                                                                    ? other$remark == null
                                                                                    : this$remark.equals(other$remark);
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
      return other instanceof ProjectSubVisaDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $visaReasonId = this.getVisaReasonId();
      result = result * 59 + ($visaReasonId == null ? 43 : $visaReasonId.hashCode());
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
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $approverId = this.getApproverId();
      result = result * 59 + ($approverId == null ? 43 : $approverId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applyDate = this.getApplyDate();
      result = result * 59 + ($applyDate == null ? 43 : $applyDate.hashCode());
      Object $visaReasonName = this.getVisaReasonName();
      result = result * 59 + ($visaReasonName == null ? 43 : $visaReasonName.hashCode());
      Object $visaAmount = this.getVisaAmount();
      result = result * 59 + ($visaAmount == null ? 43 : $visaAmount.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $subcontractClassName = this.getSubcontractClassName();
      result = result * 59 + ($subcontractClassName == null ? 43 : $subcontractClassName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $approverName = this.getApproverName();
      result = result * 59 + ($approverName == null ? 43 : $approverName.hashCode());
      Object $approveTime = this.getApproveTime();
      result = result * 59 + ($approveTime == null ? 43 : $approveTime.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSubVisaDTO(id="
         + this.getId()
         + ", number="
         + this.getNumber()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", applyDate="
         + this.getApplyDate()
         + ", visaReasonId="
         + this.getVisaReasonId()
         + ", visaReasonName="
         + this.getVisaReasonName()
         + ", visaAmount="
         + this.getVisaAmount()
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
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditTime="
         + this.getAuditTime()
         + ", approverId="
         + this.getApproverId()
         + ", approverName="
         + this.getApproverName()
         + ", approveTime="
         + this.getApproveTime()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachments="
         + this.getAttachments()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ProjectSubVisaDTOBuilder {
      private Long id;
      private String number;
      private String serialNumber;
      private LocalDateTime applyDate;
      private Long visaReasonId;
      private String visaReasonName;
      private BigDecimal visaAmount;
      private Long projectId;
      private ProjectInfo project;
      private Long monomerId;
      private NameInfo monomer;
      private Long subcontractOrderId;
      private Long supplierId;
      private String supplierName;
      private Long subcontractClassId;
      private String subcontractClassName;
      private Long auditUserId;
      private String auditUserName;
      private Integer auditStatus;
      private LocalDateTime auditTime;
      private Long approverId;
      private String approverName;
      private LocalDateTime approveTime;
      private String attachmentIds;
      private List<AttachmentDTO> attachments;
      private String remark;

      ProjectSubVisaDTOBuilder() {
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder number(final String number) {
         this.number = number;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder applyDate(final LocalDateTime applyDate) {
         this.applyDate = applyDate;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder visaReasonId(final Long visaReasonId) {
         this.visaReasonId = visaReasonId;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder visaReasonName(final String visaReasonName) {
         this.visaReasonName = visaReasonName;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder visaAmount(final BigDecimal visaAmount) {
         this.visaAmount = visaAmount;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder subcontractOrderId(final Long subcontractOrderId) {
         this.subcontractOrderId = subcontractOrderId;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder subcontractClassName(final String subcontractClassName) {
         this.subcontractClassName = subcontractClassName;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder approverId(final Long approverId) {
         this.approverId = approverId;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder approverName(final String approverName) {
         this.approverName = approverName;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder approveTime(final LocalDateTime approveTime) {
         this.approveTime = approveTime;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public ProjectSubVisaDTO.ProjectSubVisaDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectSubVisaDTO build() {
         return new ProjectSubVisaDTO(
            this.id,
            this.number,
            this.serialNumber,
            this.applyDate,
            this.visaReasonId,
            this.visaReasonName,
            this.visaAmount,
            this.projectId,
            this.project,
            this.monomerId,
            this.monomer,
            this.subcontractOrderId,
            this.supplierId,
            this.supplierName,
            this.subcontractClassId,
            this.subcontractClassName,
            this.auditUserId,
            this.auditUserName,
            this.auditStatus,
            this.auditTime,
            this.approverId,
            this.approverName,
            this.approveTime,
            this.attachmentIds,
            this.attachments,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ProjectSubVisaDTO.ProjectSubVisaDTOBuilder(id="
            + this.id
            + ", number="
            + this.number
            + ", serialNumber="
            + this.serialNumber
            + ", applyDate="
            + this.applyDate
            + ", visaReasonId="
            + this.visaReasonId
            + ", visaReasonName="
            + this.visaReasonName
            + ", visaAmount="
            + this.visaAmount
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
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditStatus="
            + this.auditStatus
            + ", auditTime="
            + this.auditTime
            + ", approverId="
            + this.approverId
            + ", approverName="
            + this.approverName
            + ", approveTime="
            + this.approveTime
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachments="
            + this.attachments
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
