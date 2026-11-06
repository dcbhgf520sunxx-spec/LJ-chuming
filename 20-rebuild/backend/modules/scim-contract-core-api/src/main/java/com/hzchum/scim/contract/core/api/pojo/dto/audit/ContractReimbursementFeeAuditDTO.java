package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "ContractReimbursementFee对象", description = "报销费用表")
public class ContractReimbursementFeeAuditDTO extends ContractFeeBaseInfo {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "reimbursementDate", value = "报销日期", notes = "报销日期")
   private LocalDateTime reimbursementDate;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构ID", notes = "分支机构ID")
   private Long branchCompanyId;
   @ApiModelProperty("费用归属名称")
   private String branchCompanyName;
   @ApiModelProperty(name = "expenseTypeId", value = "费用类型ID", notes = "费用类型ID")
   private Long expenseTypeId;
   @ApiModelProperty("费用类型名称")
   private String expenseTypeName;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty(name = "reimbursementAmount", value = "报销金额(元)", notes = "报销金额(元)")
   private BigDecimal reimbursementAmount;
   @ApiModelProperty(name = "deptId", value = "部门ID", notes = "部门ID")
   private Long deptId;
   @ApiModelProperty("部门名称")
   private String deptName;
   @ApiModelProperty(name = "reimburserId", value = "报销人ID", notes = "报销人ID")
   private Long reimburserId;
   @ApiModelProperty("报销人名称")
   private String reimburserName;
   @ApiModelProperty(name = "reimbursementVoucherNumber", value = "报销凭证号", notes = "报销凭证号")
   private String reimbursementVoucherNumber;
   @ApiModelProperty(name = "writtenById", value = "填报人ID", notes = "填报人ID")
   private Long writtenById;
   @ApiModelProperty("填报人名称")
   private String writtenByName;
   @ApiModelProperty(name = "attachmentIds", value = "附件id字符串", notes = "附件id字符串")
   private String attachmentIds;
   @ApiModelProperty(name = "attachmentList", value = "附件对象列表", notes = "附件对象列表")
   private List<AttachmentDTO> attachmentList;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "auditStatusEnum", value = "审批状态 1未审批 2已通过 4已驳回", notes = "审批状态 1未审批 2已通过 4已驳回")
   private Integer auditStatusEnum;
   @ApiModelProperty(name = "auditorId", value = "审核人id")
   private Long auditorId;
   @ApiModelProperty(name = "auditorName", value = "审核人名字")
   private String auditorName;
   @ApiModelProperty(name = "auditTime", value = "审核时间")
   private LocalDateTime auditTime;

   public static ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder builder() {
      return new ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder();
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractReimbursementFeeAuditDTO)) {
         return false;
      }

      ContractReimbursementFeeAuditDTO other = (ContractReimbursementFeeAuditDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$branchCompanyId = this.getBranchCompanyId();
      Object other$branchCompanyId = other.getBranchCompanyId();
      if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
         Object this$expenseTypeId = this.getExpenseTypeId();
         Object other$expenseTypeId = other.getExpenseTypeId();
         if (this$expenseTypeId == null ? other$expenseTypeId == null : this$expenseTypeId.equals(other$expenseTypeId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$deptId = this.getDeptId();
               Object other$deptId = other.getDeptId();
               if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
                  Object this$reimburserId = this.getReimburserId();
                  Object other$reimburserId = other.getReimburserId();
                  if (this$reimburserId == null ? other$reimburserId == null : this$reimburserId.equals(other$reimburserId)) {
                     Object this$writtenById = this.getWrittenById();
                     Object other$writtenById = other.getWrittenById();
                     if (this$writtenById == null ? other$writtenById == null : this$writtenById.equals(other$writtenById)) {
                        Object this$auditStatusEnum = this.getAuditStatusEnum();
                        Object other$auditStatusEnum = other.getAuditStatusEnum();
                        if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                           Object this$auditorId = this.getAuditorId();
                           Object other$auditorId = other.getAuditorId();
                           if (this$auditorId == null ? other$auditorId == null : this$auditorId.equals(other$auditorId)) {
                              Object this$reimbursementDate = this.getReimbursementDate();
                              Object other$reimbursementDate = other.getReimbursementDate();
                              if (this$reimbursementDate == null ? other$reimbursementDate == null : this$reimbursementDate.equals(other$reimbursementDate)) {
                                 Object this$branchCompanyName = this.getBranchCompanyName();
                                 Object other$branchCompanyName = other.getBranchCompanyName();
                                 if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
                                    Object this$expenseTypeName = this.getExpenseTypeName();
                                    Object other$expenseTypeName = other.getExpenseTypeName();
                                    if (this$expenseTypeName == null ? other$expenseTypeName == null : this$expenseTypeName.equals(other$expenseTypeName)) {
                                       Object this$projectName = this.getProjectName();
                                       Object other$projectName = other.getProjectName();
                                       if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                          Object this$reimbursementAmount = this.getReimbursementAmount();
                                          Object other$reimbursementAmount = other.getReimbursementAmount();
                                          if (this$reimbursementAmount == null
                                             ? other$reimbursementAmount == null
                                             : this$reimbursementAmount.equals(other$reimbursementAmount)) {
                                             Object this$deptName = this.getDeptName();
                                             Object other$deptName = other.getDeptName();
                                             if (this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName)) {
                                                Object this$reimburserName = this.getReimburserName();
                                                Object other$reimburserName = other.getReimburserName();
                                                if (this$reimburserName == null
                                                   ? other$reimburserName == null
                                                   : this$reimburserName.equals(other$reimburserName)) {
                                                   Object this$reimbursementVoucherNumber = this.getReimbursementVoucherNumber();
                                                   Object other$reimbursementVoucherNumber = other.getReimbursementVoucherNumber();
                                                   if (this$reimbursementVoucherNumber == null
                                                      ? other$reimbursementVoucherNumber == null
                                                      : this$reimbursementVoucherNumber.equals(other$reimbursementVoucherNumber)) {
                                                      Object this$writtenByName = this.getWrittenByName();
                                                      Object other$writtenByName = other.getWrittenByName();
                                                      if (this$writtenByName == null
                                                         ? other$writtenByName == null
                                                         : this$writtenByName.equals(other$writtenByName)) {
                                                         Object this$attachmentIds = this.getAttachmentIds();
                                                         Object other$attachmentIds = other.getAttachmentIds();
                                                         if (this$attachmentIds == null
                                                            ? other$attachmentIds == null
                                                            : this$attachmentIds.equals(other$attachmentIds)) {
                                                            Object this$attachmentList = this.getAttachmentList();
                                                            Object other$attachmentList = other.getAttachmentList();
                                                            if (this$attachmentList == null
                                                               ? other$attachmentList == null
                                                               : this$attachmentList.equals(other$attachmentList)) {
                                                               Object this$remark = this.getRemark();
                                                               Object other$remark = other.getRemark();
                                                               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                  Object this$auditorName = this.getAuditorName();
                                                                  Object other$auditorName = other.getAuditorName();
                                                                  if (this$auditorName == null
                                                                     ? other$auditorName == null
                                                                     : this$auditorName.equals(other$auditorName)) {
                                                                     Object this$auditTime = this.getAuditTime();
                                                                     Object other$auditTime = other.getAuditTime();
                                                                     return this$auditTime == null
                                                                        ? other$auditTime == null
                                                                        : this$auditTime.equals(other$auditTime);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractReimbursementFeeAuditDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $expenseTypeId = this.getExpenseTypeId();
      result = result * 59 + ($expenseTypeId == null ? 43 : $expenseTypeId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $reimburserId = this.getReimburserId();
      result = result * 59 + ($reimburserId == null ? 43 : $reimburserId.hashCode());
      Object $writtenById = this.getWrittenById();
      result = result * 59 + ($writtenById == null ? 43 : $writtenById.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $auditorId = this.getAuditorId();
      result = result * 59 + ($auditorId == null ? 43 : $auditorId.hashCode());
      Object $reimbursementDate = this.getReimbursementDate();
      result = result * 59 + ($reimbursementDate == null ? 43 : $reimbursementDate.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $expenseTypeName = this.getExpenseTypeName();
      result = result * 59 + ($expenseTypeName == null ? 43 : $expenseTypeName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $reimbursementAmount = this.getReimbursementAmount();
      result = result * 59 + ($reimbursementAmount == null ? 43 : $reimbursementAmount.hashCode());
      Object $deptName = this.getDeptName();
      result = result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
      Object $reimburserName = this.getReimburserName();
      result = result * 59 + ($reimburserName == null ? 43 : $reimburserName.hashCode());
      Object $reimbursementVoucherNumber = this.getReimbursementVoucherNumber();
      result = result * 59 + ($reimbursementVoucherNumber == null ? 43 : $reimbursementVoucherNumber.hashCode());
      Object $writtenByName = this.getWrittenByName();
      result = result * 59 + ($writtenByName == null ? 43 : $writtenByName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentList = this.getAttachmentList();
      result = result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   public ContractReimbursementFeeAuditDTO() {
   }

   public ContractReimbursementFeeAuditDTO(
      final LocalDateTime reimbursementDate,
      final Long branchCompanyId,
      final String branchCompanyName,
      final Long expenseTypeId,
      final String expenseTypeName,
      final Long projectId,
      final String projectName,
      final BigDecimal reimbursementAmount,
      final Long deptId,
      final String deptName,
      final Long reimburserId,
      final String reimburserName,
      final String reimbursementVoucherNumber,
      final Long writtenById,
      final String writtenByName,
      final String attachmentIds,
      final List<AttachmentDTO> attachmentList,
      final String remark,
      final Integer auditStatusEnum,
      final Long auditorId,
      final String auditorName,
      final LocalDateTime auditTime
   ) {
      this.reimbursementDate = reimbursementDate;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.expenseTypeId = expenseTypeId;
      this.expenseTypeName = expenseTypeName;
      this.projectId = projectId;
      this.projectName = projectName;
      this.reimbursementAmount = reimbursementAmount;
      this.deptId = deptId;
      this.deptName = deptName;
      this.reimburserId = reimburserId;
      this.reimburserName = reimburserName;
      this.reimbursementVoucherNumber = reimbursementVoucherNumber;
      this.writtenById = writtenById;
      this.writtenByName = writtenByName;
      this.attachmentIds = attachmentIds;
      this.attachmentList = attachmentList;
      this.remark = remark;
      this.auditStatusEnum = auditStatusEnum;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.auditTime = auditTime;
   }

   public LocalDateTime getReimbursementDate() {
      return this.reimbursementDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public Long getExpenseTypeId() {
      return this.expenseTypeId;
   }

   public String getExpenseTypeName() {
      return this.expenseTypeName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getReimbursementAmount() {
      return this.reimbursementAmount;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public Long getReimburserId() {
      return this.reimburserId;
   }

   public String getReimburserName() {
      return this.reimburserName;
   }

   public String getReimbursementVoucherNumber() {
      return this.reimbursementVoucherNumber;
   }

   public Long getWrittenById() {
      return this.writtenById;
   }

   public String getWrittenByName() {
      return this.writtenByName;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public Long getAuditorId() {
      return this.auditorId;
   }

   public String getAuditorName() {
      return this.auditorName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public void setReimbursementDate(final LocalDateTime reimbursementDate) {
      this.reimbursementDate = reimbursementDate;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setExpenseTypeId(final Long expenseTypeId) {
      this.expenseTypeId = expenseTypeId;
   }

   public void setExpenseTypeName(final String expenseTypeName) {
      this.expenseTypeName = expenseTypeName;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setReimbursementAmount(final BigDecimal reimbursementAmount) {
      this.reimbursementAmount = reimbursementAmount;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   public void setDeptName(final String deptName) {
      this.deptName = deptName;
   }

   public void setReimburserId(final Long reimburserId) {
      this.reimburserId = reimburserId;
   }

   public void setReimburserName(final String reimburserName) {
      this.reimburserName = reimburserName;
   }

   public void setReimbursementVoucherNumber(final String reimbursementVoucherNumber) {
      this.reimbursementVoucherNumber = reimbursementVoucherNumber;
   }

   public void setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
   }

   public void setWrittenByName(final String writtenByName) {
      this.writtenByName = writtenByName;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   public void setAuditorId(final Long auditorId) {
      this.auditorId = auditorId;
   }

   public void setAuditorName(final String auditorName) {
      this.auditorName = auditorName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   @Override
   public String toString() {
      return "ContractReimbursementFeeAuditDTO(reimbursementDate="
         + this.getReimbursementDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", expenseTypeId="
         + this.getExpenseTypeId()
         + ", expenseTypeName="
         + this.getExpenseTypeName()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", reimbursementAmount="
         + this.getReimbursementAmount()
         + ", deptId="
         + this.getDeptId()
         + ", deptName="
         + this.getDeptName()
         + ", reimburserId="
         + this.getReimburserId()
         + ", reimburserName="
         + this.getReimburserName()
         + ", reimbursementVoucherNumber="
         + this.getReimbursementVoucherNumber()
         + ", writtenById="
         + this.getWrittenById()
         + ", writtenByName="
         + this.getWrittenByName()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachmentList="
         + this.getAttachmentList()
         + ", remark="
         + this.getRemark()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", auditorId="
         + this.getAuditorId()
         + ", auditorName="
         + this.getAuditorName()
         + ", auditTime="
         + this.getAuditTime()
         + ")";
   }

   public static class ContractReimbursementFeeAuditDTOBuilder {
      private LocalDateTime reimbursementDate;
      private Long branchCompanyId;
      private String branchCompanyName;
      private Long expenseTypeId;
      private String expenseTypeName;
      private Long projectId;
      private String projectName;
      private BigDecimal reimbursementAmount;
      private Long deptId;
      private String deptName;
      private Long reimburserId;
      private String reimburserName;
      private String reimbursementVoucherNumber;
      private Long writtenById;
      private String writtenByName;
      private String attachmentIds;
      private List<AttachmentDTO> attachmentList;
      private String remark;
      private Integer auditStatusEnum;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;

      ContractReimbursementFeeAuditDTOBuilder() {
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder reimbursementDate(final LocalDateTime reimbursementDate) {
         this.reimbursementDate = reimbursementDate;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder expenseTypeId(final Long expenseTypeId) {
         this.expenseTypeId = expenseTypeId;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder expenseTypeName(final String expenseTypeName) {
         this.expenseTypeName = expenseTypeName;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder reimbursementAmount(final BigDecimal reimbursementAmount) {
         this.reimbursementAmount = reimbursementAmount;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder deptId(final Long deptId) {
         this.deptId = deptId;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder deptName(final String deptName) {
         this.deptName = deptName;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder reimburserId(final Long reimburserId) {
         this.reimburserId = reimburserId;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder reimburserName(final String reimburserName) {
         this.reimburserName = reimburserName;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder reimbursementVoucherNumber(final String reimbursementVoucherNumber) {
         this.reimbursementVoucherNumber = reimbursementVoucherNumber;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder writtenById(final Long writtenById) {
         this.writtenById = writtenById;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder writtenByName(final String writtenByName) {
         this.writtenByName = writtenByName;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder attachmentList(final List<AttachmentDTO> attachmentList) {
         this.attachmentList = attachmentList;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractReimbursementFeeAuditDTO build() {
         return new ContractReimbursementFeeAuditDTO(
            this.reimbursementDate,
            this.branchCompanyId,
            this.branchCompanyName,
            this.expenseTypeId,
            this.expenseTypeName,
            this.projectId,
            this.projectName,
            this.reimbursementAmount,
            this.deptId,
            this.deptName,
            this.reimburserId,
            this.reimburserName,
            this.reimbursementVoucherNumber,
            this.writtenById,
            this.writtenByName,
            this.attachmentIds,
            this.attachmentList,
            this.remark,
            this.auditStatusEnum,
            this.auditorId,
            this.auditorName,
            this.auditTime
         );
      }

      @Override
      public String toString() {
         return "ContractReimbursementFeeAuditDTO.ContractReimbursementFeeAuditDTOBuilder(reimbursementDate="
            + this.reimbursementDate
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", expenseTypeId="
            + this.expenseTypeId
            + ", expenseTypeName="
            + this.expenseTypeName
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", reimbursementAmount="
            + this.reimbursementAmount
            + ", deptId="
            + this.deptId
            + ", deptName="
            + this.deptName
            + ", reimburserId="
            + this.reimburserId
            + ", reimburserName="
            + this.reimburserName
            + ", reimbursementVoucherNumber="
            + this.reimbursementVoucherNumber
            + ", writtenById="
            + this.writtenById
            + ", writtenByName="
            + this.writtenByName
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachmentList="
            + this.attachmentList
            + ", remark="
            + this.remark
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", auditorId="
            + this.auditorId
            + ", auditorName="
            + this.auditorName
            + ", auditTime="
            + this.auditTime
            + ")";
      }
   }
}
