package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "ContractPropertyFee对象", description = "物业费表 ")
public class ContractPropertyFeeDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "year", value = "年份", notes = "年份")
   private Integer year;
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   private Integer month;
   @ApiModelProperty(name = "feeAmount", value = "费用", notes = "费用")
   private BigDecimal feeAmount;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   private String attachmentIds;
   @ApiModelProperty(name = "attachments", value = "附件对象列表", notes = "附件对象列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "userId", value = "录入用户ID", notes = "录入用户ID")
   private Long userId;
   @ApiModelProperty(name = "boolConfirmStatus", value = "确认状态 0未确认 1已确认", notes = "确认状态 0未确认 1已确认")
   private Boolean boolConfirmStatus;

   public static ContractPropertyFeeDTO.ContractPropertyFeeDTOBuilder builder() {
      return new ContractPropertyFeeDTO.ContractPropertyFeeDTOBuilder();
   }

   public ContractPropertyFeeDTO() {
   }

   public ContractPropertyFeeDTO(
      final Long id,
      final Integer year,
      final Integer month,
      final BigDecimal feeAmount,
      final String attachmentIds,
      final List<AttachmentDTO> attachments,
      final String remark,
      final Long userId,
      final Boolean boolConfirmStatus
   ) {
      this.id = id;
      this.year = year;
      this.month = month;
      this.feeAmount = feeAmount;
      this.attachmentIds = attachmentIds;
      this.attachments = attachments;
      this.remark = remark;
      this.userId = userId;
      this.boolConfirmStatus = boolConfirmStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getYear() {
      return this.year;
   }

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getFeeAmount() {
      return this.feeAmount;
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

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getBoolConfirmStatus() {
      return this.boolConfirmStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setFeeAmount(final BigDecimal feeAmount) {
      this.feeAmount = feeAmount;
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

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setBoolConfirmStatus(final Boolean boolConfirmStatus) {
      this.boolConfirmStatus = boolConfirmStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractPropertyFeeDTO)) {
         return false;
      }

      ContractPropertyFeeDTO other = (ContractPropertyFeeDTO)o;
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
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$boolConfirmStatus = this.getBoolConfirmStatus();
                  Object other$boolConfirmStatus = other.getBoolConfirmStatus();
                  if (this$boolConfirmStatus == null ? other$boolConfirmStatus == null : this$boolConfirmStatus.equals(other$boolConfirmStatus)) {
                     Object this$feeAmount = this.getFeeAmount();
                     Object other$feeAmount = other.getFeeAmount();
                     if (this$feeAmount == null ? other$feeAmount == null : this$feeAmount.equals(other$feeAmount)) {
                        Object this$attachmentIds = this.getAttachmentIds();
                        Object other$attachmentIds = other.getAttachmentIds();
                        if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                           Object this$attachments = this.getAttachments();
                           Object other$attachments = other.getAttachments();
                           if (this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractPropertyFeeDTO;
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
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolConfirmStatus = this.getBoolConfirmStatus();
      result = result * 59 + ($boolConfirmStatus == null ? 43 : $boolConfirmStatus.hashCode());
      Object $feeAmount = this.getFeeAmount();
      result = result * 59 + ($feeAmount == null ? 43 : $feeAmount.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractPropertyFeeDTO(id="
         + this.getId()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", feeAmount="
         + this.getFeeAmount()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachments="
         + this.getAttachments()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", boolConfirmStatus="
         + this.getBoolConfirmStatus()
         + ")";
   }

   public static class ContractPropertyFeeDTOBuilder {
      private Long id;
      private Integer year;
      private Integer month;
      private BigDecimal feeAmount;
      private String attachmentIds;
      private List<AttachmentDTO> attachments;
      private String remark;
      private Long userId;
      private Boolean boolConfirmStatus;

      ContractPropertyFeeDTOBuilder() {
      }

      public ContractPropertyFeeDTO.ContractPropertyFeeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractPropertyFeeDTO.ContractPropertyFeeDTOBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractPropertyFeeDTO.ContractPropertyFeeDTOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractPropertyFeeDTO.ContractPropertyFeeDTOBuilder feeAmount(final BigDecimal feeAmount) {
         this.feeAmount = feeAmount;
         return this;
      }

      public ContractPropertyFeeDTO.ContractPropertyFeeDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractPropertyFeeDTO.ContractPropertyFeeDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public ContractPropertyFeeDTO.ContractPropertyFeeDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractPropertyFeeDTO.ContractPropertyFeeDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractPropertyFeeDTO.ContractPropertyFeeDTOBuilder boolConfirmStatus(final Boolean boolConfirmStatus) {
         this.boolConfirmStatus = boolConfirmStatus;
         return this;
      }

      public ContractPropertyFeeDTO build() {
         return new ContractPropertyFeeDTO(
            this.id, this.year, this.month, this.feeAmount, this.attachmentIds, this.attachments, this.remark, this.userId, this.boolConfirmStatus
         );
      }

      @Override
      public String toString() {
         return "ContractPropertyFeeDTO.ContractPropertyFeeDTOBuilder(id="
            + this.id
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", feeAmount="
            + this.feeAmount
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachments="
            + this.attachments
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", boolConfirmStatus="
            + this.boolConfirmStatus
            + ")";
      }
   }
}
