package com.hzchum.scim.bid.core.api.pojo.dto;

import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.hzchum.pangu.common.valid.Add;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SmsDTO {
   @NotNull(message = "短信模板id不能为空", groups = Update.class)
   private Long id;
   private String reason;
   private String templateCode;
   @NotEmpty(message = "短信模板内容不能为空", groups = {Add.class, Update.class})
   private String templateContent;
   @NotEmpty(message = "模板名称不能为空", groups = {Add.class, Update.class})
   private String templateName;
   private Integer templateStatus;
   private Integer templateType;
   private Integer source;
   private String remark;

   public Long getId() {
      return this.id;
   }

   public String getReason() {
      return this.reason;
   }

   public String getTemplateCode() {
      return this.templateCode;
   }

   public String getTemplateContent() {
      return this.templateContent;
   }

   public String getTemplateName() {
      return this.templateName;
   }

   public Integer getTemplateStatus() {
      return this.templateStatus;
   }

   public Integer getTemplateType() {
      return this.templateType;
   }

   public Integer getSource() {
      return this.source;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setReason(final String reason) {
      this.reason = reason;
   }

   public void setTemplateCode(final String templateCode) {
      this.templateCode = templateCode;
   }

   public void setTemplateContent(final String templateContent) {
      this.templateContent = templateContent;
   }

   public void setTemplateName(final String templateName) {
      this.templateName = templateName;
   }

   public void setTemplateStatus(final Integer templateStatus) {
      this.templateStatus = templateStatus;
   }

   public void setTemplateType(final Integer templateType) {
      this.templateType = templateType;
   }

   public void setSource(final Integer source) {
      this.source = source;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SmsDTO)) {
         return false;
      }

      SmsDTO other = (SmsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$templateStatus = this.getTemplateStatus();
         Object other$templateStatus = other.getTemplateStatus();
         if (this$templateStatus == null ? other$templateStatus == null : this$templateStatus.equals(other$templateStatus)) {
            Object this$templateType = this.getTemplateType();
            Object other$templateType = other.getTemplateType();
            if (this$templateType == null ? other$templateType == null : this$templateType.equals(other$templateType)) {
               Object this$source = this.getSource();
               Object other$source = other.getSource();
               if (this$source == null ? other$source == null : this$source.equals(other$source)) {
                  Object this$reason = this.getReason();
                  Object other$reason = other.getReason();
                  if (this$reason == null ? other$reason == null : this$reason.equals(other$reason)) {
                     Object this$templateCode = this.getTemplateCode();
                     Object other$templateCode = other.getTemplateCode();
                     if (this$templateCode == null ? other$templateCode == null : this$templateCode.equals(other$templateCode)) {
                        Object this$templateContent = this.getTemplateContent();
                        Object other$templateContent = other.getTemplateContent();
                        if (this$templateContent == null ? other$templateContent == null : this$templateContent.equals(other$templateContent)) {
                           Object this$templateName = this.getTemplateName();
                           Object other$templateName = other.getTemplateName();
                           if (this$templateName == null ? other$templateName == null : this$templateName.equals(other$templateName)) {
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
      return other instanceof SmsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $templateStatus = this.getTemplateStatus();
      result = result * 59 + ($templateStatus == null ? 43 : $templateStatus.hashCode());
      Object $templateType = this.getTemplateType();
      result = result * 59 + ($templateType == null ? 43 : $templateType.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $reason = this.getReason();
      result = result * 59 + ($reason == null ? 43 : $reason.hashCode());
      Object $templateCode = this.getTemplateCode();
      result = result * 59 + ($templateCode == null ? 43 : $templateCode.hashCode());
      Object $templateContent = this.getTemplateContent();
      result = result * 59 + ($templateContent == null ? 43 : $templateContent.hashCode());
      Object $templateName = this.getTemplateName();
      result = result * 59 + ($templateName == null ? 43 : $templateName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "SmsDTO(id="
         + this.getId()
         + ", reason="
         + this.getReason()
         + ", templateCode="
         + this.getTemplateCode()
         + ", templateContent="
         + this.getTemplateContent()
         + ", templateName="
         + this.getTemplateName()
         + ", templateStatus="
         + this.getTemplateStatus()
         + ", templateType="
         + this.getTemplateType()
         + ", source="
         + this.getSource()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
