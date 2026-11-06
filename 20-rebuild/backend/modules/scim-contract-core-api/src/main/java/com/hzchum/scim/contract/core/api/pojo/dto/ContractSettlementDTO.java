package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "ContractProjectSettlement对象", description = "项目预结算表")
public class ContractSettlementDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "amount", value = "结算额", notes = "结算额")
   private BigDecimal amount;
   @ApiModelProperty(name = "settlementDate", value = "结算日期", notes = "结算日期")
   private LocalDate settlementDate;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人", notes = "创建人")
   private String createUserName;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核 2已通过 4已驳回", notes = "审核状态 1未审核 2已通过 4已驳回")
   private Integer auditStatus;
   @ApiModelProperty(name = "auditUserId", value = "审核人id", notes = "审核人id")
   private Long auditUserId;
   @ApiModelProperty(name = "auditUserName", value = "审核人", notes = "审核人")
   private String auditUserName;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "attachmentIds", value = "附加id字符串", notes = "附加id字符串")
   private String attachmentIds;
   @ApiModelProperty(name = "attachmentList", value = "附件对象列表", notes = "附件对象列表")
   private List<AttachmentDTO> attachmentList;

   public static ContractSettlementDTO.ContractSettlementDTOBuilder builder() {
      return new ContractSettlementDTO.ContractSettlementDTOBuilder();
   }

   public ContractSettlementDTO() {
   }

   public ContractSettlementDTO(
      final Long id,
      final Long projectId,
      final BigDecimal amount,
      final LocalDate settlementDate,
      final Long createUserId,
      final String createUserName,
      final Integer auditStatus,
      final Long auditUserId,
      final String auditUserName,
      final LocalDateTime auditTime,
      final String remark,
      final String attachmentIds,
      final List<AttachmentDTO> attachmentList
   ) {
      this.id = id;
      this.projectId = projectId;
      this.amount = amount;
      this.settlementDate = settlementDate;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.auditStatus = auditStatus;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
      this.remark = remark;
      this.attachmentIds = attachmentIds;
      this.attachmentList = attachmentList;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public LocalDate getSettlementDate() {
      return this.settlementDate;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setSettlementDate(final LocalDate settlementDate) {
      this.settlementDate = settlementDate;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractSettlementDTO)) {
         return false;
      }

      ContractSettlementDTO other = (ContractSettlementDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$auditStatus = this.getAuditStatus();
               Object other$auditStatus = other.getAuditStatus();
               if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                  Object this$auditUserId = this.getAuditUserId();
                  Object other$auditUserId = other.getAuditUserId();
                  if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                     Object this$amount = this.getAmount();
                     Object other$amount = other.getAmount();
                     if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                        Object this$settlementDate = this.getSettlementDate();
                        Object other$settlementDate = other.getSettlementDate();
                        if (this$settlementDate == null ? other$settlementDate == null : this$settlementDate.equals(other$settlementDate)) {
                           Object this$createUserName = this.getCreateUserName();
                           Object other$createUserName = other.getCreateUserName();
                           if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                              Object this$auditUserName = this.getAuditUserName();
                              Object other$auditUserName = other.getAuditUserName();
                              if (this$auditUserName == null ? other$auditUserName == null : this$auditUserName.equals(other$auditUserName)) {
                                 Object this$auditTime = this.getAuditTime();
                                 Object other$auditTime = other.getAuditTime();
                                 if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                       Object this$attachmentIds = this.getAttachmentIds();
                                       Object other$attachmentIds = other.getAttachmentIds();
                                       if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                                          Object this$attachmentList = this.getAttachmentList();
                                          Object other$attachmentList = other.getAttachmentList();
                                          return this$attachmentList == null ? other$attachmentList == null : this$attachmentList.equals(other$attachmentList);
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
      return other instanceof ContractSettlementDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $settlementDate = this.getSettlementDate();
      result = result * 59 + ($settlementDate == null ? 43 : $settlementDate.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentList = this.getAttachmentList();
      return result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
   }

   @Override
   public String toString() {
      return "ContractSettlementDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", amount="
         + this.getAmount()
         + ", settlementDate="
         + this.getSettlementDate()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", remark="
         + this.getRemark()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachmentList="
         + this.getAttachmentList()
         + ")";
   }

   public static class ContractSettlementDTOBuilder {
      private Long id;
      private Long projectId;
      private BigDecimal amount;
      private LocalDate settlementDate;
      private Long createUserId;
      private String createUserName;
      private Integer auditStatus;
      private Long auditUserId;
      private String auditUserName;
      private LocalDateTime auditTime;
      private String remark;
      private String attachmentIds;
      private List<AttachmentDTO> attachmentList;

      ContractSettlementDTOBuilder() {
      }

      public ContractSettlementDTO.ContractSettlementDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractSettlementDTO.ContractSettlementDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractSettlementDTO.ContractSettlementDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ContractSettlementDTO.ContractSettlementDTOBuilder settlementDate(final LocalDate settlementDate) {
         this.settlementDate = settlementDate;
         return this;
      }

      public ContractSettlementDTO.ContractSettlementDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public ContractSettlementDTO.ContractSettlementDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public ContractSettlementDTO.ContractSettlementDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractSettlementDTO.ContractSettlementDTOBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public ContractSettlementDTO.ContractSettlementDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public ContractSettlementDTO.ContractSettlementDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractSettlementDTO.ContractSettlementDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractSettlementDTO.ContractSettlementDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractSettlementDTO.ContractSettlementDTOBuilder attachmentList(final List<AttachmentDTO> attachmentList) {
         this.attachmentList = attachmentList;
         return this;
      }

      public ContractSettlementDTO build() {
         return new ContractSettlementDTO(
            this.id,
            this.projectId,
            this.amount,
            this.settlementDate,
            this.createUserId,
            this.createUserName,
            this.auditStatus,
            this.auditUserId,
            this.auditUserName,
            this.auditTime,
            this.remark,
            this.attachmentIds,
            this.attachmentList
         );
      }

      @Override
      public String toString() {
         return "ContractSettlementDTO.ContractSettlementDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", amount="
            + this.amount
            + ", settlementDate="
            + this.settlementDate
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", auditStatus="
            + this.auditStatus
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ", remark="
            + this.remark
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachmentList="
            + this.attachmentList
            + ")";
      }
   }
}
