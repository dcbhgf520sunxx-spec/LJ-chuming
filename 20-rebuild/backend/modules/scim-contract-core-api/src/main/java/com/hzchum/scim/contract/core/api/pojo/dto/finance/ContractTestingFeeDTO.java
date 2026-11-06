package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "ContractTestingFee对象", description = "检测费表 ")
public class ContractTestingFeeDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "payDate", value = "支付日期", notes = "支付日期")
   private LocalDate payDate;
   @ApiModelProperty(name = "year", value = "年份", notes = "年份")
   private Integer year;
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   private Integer month;
   @ApiModelProperty(name = "testingFeeTypeId", value = "类型id", notes = "类型id")
   private Long testingFeeTypeId;
   @ApiModelProperty(name = "testingFeeTypeName", value = "类型名称", notes = "类型名称")
   private String testingFeeTypeName;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "feeAmount", value = "费用(元)", notes = "费用(元)")
   private BigDecimal feeAmount;
   @ApiModelProperty(name = "userId", value = "录入用户ID", notes = "录入用户ID")
   private Long userId;
   @ApiModelProperty(name = "user", value = "录入用户", notes = "录入用户")
   private String userName;
   @ApiModelProperty(name = "auditStatusEnum", value = "审批状态 1未审批 2已通过 4已驳回", notes = "审批状态 1未审批 2已通过 4已驳回")
   private Integer auditStatusEnum;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   private String attachmentIds;
   @ApiModelProperty(name = "attachments", value = "附件对象列表", notes = "附件对象列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty("费用归属ID")
   private Long branchCompanyId;
   @ApiModelProperty("费用归属名称")
   private String branchCompanyName;
   @ApiModelProperty(name = "auditorId", value = "审核人id")
   private Long auditorId;
   @ApiModelProperty(name = "auditorName", value = "审核人名字")
   private String auditorName;
   @ApiModelProperty(name = "auditTime", value = "审核时间")
   private LocalDateTime auditTime;

   public static ContractTestingFeeDTO.ContractTestingFeeDTOBuilder builder() {
      return new ContractTestingFeeDTO.ContractTestingFeeDTOBuilder();
   }

   public ContractTestingFeeDTO() {
   }

   public ContractTestingFeeDTO(
      final Long id,
      final LocalDate payDate,
      final Integer year,
      final Integer month,
      final Long testingFeeTypeId,
      final String testingFeeTypeName,
      final ProjectInfo project,
      final BigDecimal feeAmount,
      final Long userId,
      final String userName,
      final Integer auditStatusEnum,
      final String attachmentIds,
      final List<AttachmentDTO> attachments,
      final String remark,
      final Long branchCompanyId,
      final String branchCompanyName,
      final Long auditorId,
      final String auditorName,
      final LocalDateTime auditTime
   ) {
      this.id = id;
      this.payDate = payDate;
      this.year = year;
      this.month = month;
      this.testingFeeTypeId = testingFeeTypeId;
      this.testingFeeTypeName = testingFeeTypeName;
      this.project = project;
      this.feeAmount = feeAmount;
      this.userId = userId;
      this.userName = userName;
      this.auditStatusEnum = auditStatusEnum;
      this.attachmentIds = attachmentIds;
      this.attachments = attachments;
      this.remark = remark;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.auditTime = auditTime;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDate getPayDate() {
      return this.payDate;
   }

   public Integer getYear() {
      return this.year;
   }

   public Integer getMonth() {
      return this.month;
   }

   public Long getTestingFeeTypeId() {
      return this.testingFeeTypeId;
   }

   public String getTestingFeeTypeName() {
      return this.testingFeeTypeName;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public BigDecimal getFeeAmount() {
      return this.feeAmount;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
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

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPayDate(final LocalDate payDate) {
      this.payDate = payDate;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setTestingFeeTypeId(final Long testingFeeTypeId) {
      this.testingFeeTypeId = testingFeeTypeId;
   }

   public void setTestingFeeTypeName(final String testingFeeTypeName) {
      this.testingFeeTypeName = testingFeeTypeName;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setFeeAmount(final BigDecimal feeAmount) {
      this.feeAmount = feeAmount;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
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

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
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
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractTestingFeeDTO)) {
         return false;
      }

      ContractTestingFeeDTO other = (ContractTestingFeeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$year = this.getYear();
         Object other$year = other.getYear();
         if (this$year == null ? other$year == null : this$year.equals(other$year)) {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$testingFeeTypeId = this.getTestingFeeTypeId();
               Object other$testingFeeTypeId = other.getTestingFeeTypeId();
               if (this$testingFeeTypeId == null ? other$testingFeeTypeId == null : this$testingFeeTypeId.equals(other$testingFeeTypeId)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$auditStatusEnum = this.getAuditStatusEnum();
                     Object other$auditStatusEnum = other.getAuditStatusEnum();
                     if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                        Object this$branchCompanyId = this.getBranchCompanyId();
                        Object other$branchCompanyId = other.getBranchCompanyId();
                        if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                           Object this$auditorId = this.getAuditorId();
                           Object other$auditorId = other.getAuditorId();
                           if (this$auditorId == null ? other$auditorId == null : this$auditorId.equals(other$auditorId)) {
                              Object this$payDate = this.getPayDate();
                              Object other$payDate = other.getPayDate();
                              if (this$payDate == null ? other$payDate == null : this$payDate.equals(other$payDate)) {
                                 Object this$testingFeeTypeName = this.getTestingFeeTypeName();
                                 Object other$testingFeeTypeName = other.getTestingFeeTypeName();
                                 if (this$testingFeeTypeName == null
                                    ? other$testingFeeTypeName == null
                                    : this$testingFeeTypeName.equals(other$testingFeeTypeName)) {
                                    Object this$project = this.getProject();
                                    Object other$project = other.getProject();
                                    if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                       Object this$feeAmount = this.getFeeAmount();
                                       Object other$feeAmount = other.getFeeAmount();
                                       if (this$feeAmount == null ? other$feeAmount == null : this$feeAmount.equals(other$feeAmount)) {
                                          Object this$userName = this.getUserName();
                                          Object other$userName = other.getUserName();
                                          if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                             Object this$attachmentIds = this.getAttachmentIds();
                                             Object other$attachmentIds = other.getAttachmentIds();
                                             if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                                                Object this$attachments = this.getAttachments();
                                                Object other$attachments = other.getAttachments();
                                                if (this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments)) {
                                                   Object this$remark = this.getRemark();
                                                   Object other$remark = other.getRemark();
                                                   if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                      Object this$branchCompanyName = this.getBranchCompanyName();
                                                      Object other$branchCompanyName = other.getBranchCompanyName();
                                                      if (this$branchCompanyName == null
                                                         ? other$branchCompanyName == null
                                                         : this$branchCompanyName.equals(other$branchCompanyName)) {
                                                         Object this$auditorName = this.getAuditorName();
                                                         Object other$auditorName = other.getAuditorName();
                                                         if (this$auditorName == null ? other$auditorName == null : this$auditorName.equals(other$auditorName)) {
                                                            Object this$auditTime = this.getAuditTime();
                                                            Object other$auditTime = other.getAuditTime();
                                                            return this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime);
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
      return other instanceof ContractTestingFeeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $testingFeeTypeId = this.getTestingFeeTypeId();
      result = result * 59 + ($testingFeeTypeId == null ? 43 : $testingFeeTypeId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $auditorId = this.getAuditorId();
      result = result * 59 + ($auditorId == null ? 43 : $auditorId.hashCode());
      Object $payDate = this.getPayDate();
      result = result * 59 + ($payDate == null ? 43 : $payDate.hashCode());
      Object $testingFeeTypeName = this.getTestingFeeTypeName();
      result = result * 59 + ($testingFeeTypeName == null ? 43 : $testingFeeTypeName.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $feeAmount = this.getFeeAmount();
      result = result * 59 + ($feeAmount == null ? 43 : $feeAmount.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   @Override
   public String toString() {
      return "ContractTestingFeeDTO(id="
         + this.getId()
         + ", payDate="
         + this.getPayDate()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", testingFeeTypeId="
         + this.getTestingFeeTypeId()
         + ", testingFeeTypeName="
         + this.getTestingFeeTypeName()
         + ", project="
         + this.getProject()
         + ", feeAmount="
         + this.getFeeAmount()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachments="
         + this.getAttachments()
         + ", remark="
         + this.getRemark()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", auditorId="
         + this.getAuditorId()
         + ", auditorName="
         + this.getAuditorName()
         + ", auditTime="
         + this.getAuditTime()
         + ")";
   }

   public static class ContractTestingFeeDTOBuilder {
      private Long id;
      private LocalDate payDate;
      private Integer year;
      private Integer month;
      private Long testingFeeTypeId;
      private String testingFeeTypeName;
      private ProjectInfo project;
      private BigDecimal feeAmount;
      private Long userId;
      private String userName;
      private Integer auditStatusEnum;
      private String attachmentIds;
      private List<AttachmentDTO> attachments;
      private String remark;
      private Long branchCompanyId;
      private String branchCompanyName;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;

      ContractTestingFeeDTOBuilder() {
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder payDate(final LocalDate payDate) {
         this.payDate = payDate;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder testingFeeTypeId(final Long testingFeeTypeId) {
         this.testingFeeTypeId = testingFeeTypeId;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder testingFeeTypeName(final String testingFeeTypeName) {
         this.testingFeeTypeName = testingFeeTypeName;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder feeAmount(final BigDecimal feeAmount) {
         this.feeAmount = feeAmount;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ContractTestingFeeDTO.ContractTestingFeeDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractTestingFeeDTO build() {
         return new ContractTestingFeeDTO(
            this.id,
            this.payDate,
            this.year,
            this.month,
            this.testingFeeTypeId,
            this.testingFeeTypeName,
            this.project,
            this.feeAmount,
            this.userId,
            this.userName,
            this.auditStatusEnum,
            this.attachmentIds,
            this.attachments,
            this.remark,
            this.branchCompanyId,
            this.branchCompanyName,
            this.auditorId,
            this.auditorName,
            this.auditTime
         );
      }

      @Override
      public String toString() {
         return "ContractTestingFeeDTO.ContractTestingFeeDTOBuilder(id="
            + this.id
            + ", payDate="
            + this.payDate
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", testingFeeTypeId="
            + this.testingFeeTypeId
            + ", testingFeeTypeName="
            + this.testingFeeTypeName
            + ", project="
            + this.project
            + ", feeAmount="
            + this.feeAmount
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachments="
            + this.attachments
            + ", remark="
            + this.remark
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
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
