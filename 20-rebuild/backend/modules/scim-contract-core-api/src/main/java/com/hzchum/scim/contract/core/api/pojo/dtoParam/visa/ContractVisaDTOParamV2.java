package com.hzchum.scim.contract.core.api.pojo.dtoParam.visa;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.contract.core.api.enums.visa.VisaModeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(description = "新版签证")
public class ContractVisaDTOParamV2 {
   @ApiModelProperty("id")
   @NotNull(groups = Update.class, message = "id不能为空")
   private Integer id;
   @ApiModelProperty("签证模式 1对内 2对外")
   @NotNull(groups = Add.class, message = "项目id不能为空")
   @EnumValidator(value = VisaModeEnum.class, message = "签证类型不正确！")
   private Integer mode;
   @ApiModelProperty("项目id")
   @NotNull(groups = Add.class, message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty("签证日期")
   @NotNull(message = "签证日期不能为空")
   private LocalDate visaDate;
   @ApiModelProperty("签证人对象")
   private Long supplierId;
   @ApiModelProperty("签证人对象")
   private String recipients;
   @ApiModelProperty("签证事由id")
   @NotNull(message = "签证事由不能为空")
   private String reasonId;
   @ApiModelProperty("签证额")
   @NotNull(message = "签证额不能为空")
   private BigDecimal visaAmount;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("附件")
   @NotEmpty(groups = Add.class, message = "附件不能为空")
   private List<Long> attachmentIds;

   public Integer getId() {
      return this.id;
   }

   public Integer getMode() {
      return this.mode;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public LocalDate getVisaDate() {
      return this.visaDate;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getRecipients() {
      return this.recipients;
   }

   public String getReasonId() {
      return this.reasonId;
   }

   public BigDecimal getVisaAmount() {
      return this.visaAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public void setId(final Integer id) {
      this.id = id;
   }

   public void setMode(final Integer mode) {
      this.mode = mode;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setVisaDate(final LocalDate visaDate) {
      this.visaDate = visaDate;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setRecipients(final String recipients) {
      this.recipients = recipients;
   }

   public void setReasonId(final String reasonId) {
      this.reasonId = reasonId;
   }

   public void setVisaAmount(final BigDecimal visaAmount) {
      this.visaAmount = visaAmount;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractVisaDTOParamV2)) {
         return false;
      }

      ContractVisaDTOParamV2 other = (ContractVisaDTOParamV2)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$mode = this.getMode();
         Object other$mode = other.getMode();
         if (this$mode == null ? other$mode == null : this$mode.equals(other$mode)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$supplierId = this.getSupplierId();
               Object other$supplierId = other.getSupplierId();
               if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                  Object this$visaDate = this.getVisaDate();
                  Object other$visaDate = other.getVisaDate();
                  if (this$visaDate == null ? other$visaDate == null : this$visaDate.equals(other$visaDate)) {
                     Object this$recipients = this.getRecipients();
                     Object other$recipients = other.getRecipients();
                     if (this$recipients == null ? other$recipients == null : this$recipients.equals(other$recipients)) {
                        Object this$reasonId = this.getReasonId();
                        Object other$reasonId = other.getReasonId();
                        if (this$reasonId == null ? other$reasonId == null : this$reasonId.equals(other$reasonId)) {
                           Object this$visaAmount = this.getVisaAmount();
                           Object other$visaAmount = other.getVisaAmount();
                           if (this$visaAmount == null ? other$visaAmount == null : this$visaAmount.equals(other$visaAmount)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                 Object this$attachmentIds = this.getAttachmentIds();
                                 Object other$attachmentIds = other.getAttachmentIds();
                                 return this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds);
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
      return other instanceof ContractVisaDTOParamV2;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $mode = this.getMode();
      result = result * 59 + ($mode == null ? 43 : $mode.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $visaDate = this.getVisaDate();
      result = result * 59 + ($visaDate == null ? 43 : $visaDate.hashCode());
      Object $recipients = this.getRecipients();
      result = result * 59 + ($recipients == null ? 43 : $recipients.hashCode());
      Object $reasonId = this.getReasonId();
      result = result * 59 + ($reasonId == null ? 43 : $reasonId.hashCode());
      Object $visaAmount = this.getVisaAmount();
      result = result * 59 + ($visaAmount == null ? 43 : $visaAmount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "ContractVisaDTOParamV2(id="
         + this.getId()
         + ", mode="
         + this.getMode()
         + ", projectId="
         + this.getProjectId()
         + ", visaDate="
         + this.getVisaDate()
         + ", supplierId="
         + this.getSupplierId()
         + ", recipients="
         + this.getRecipients()
         + ", reasonId="
         + this.getReasonId()
         + ", visaAmount="
         + this.getVisaAmount()
         + ", remark="
         + this.getRemark()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }
}
