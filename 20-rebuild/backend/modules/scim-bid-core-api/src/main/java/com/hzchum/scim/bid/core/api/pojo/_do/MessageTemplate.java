package com.hzchum.scim.bid.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "短信模板", description = "")
@Entity
@TableName("message_template")
@Table(name = "message_template")
public class MessageTemplate extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "templateName", value = "名称")
   @JsonProperty("templateName")
   @JSONField(name = "templateName")
   @TableField("template_name")
   @Column(name = "template_name")
   private String templateName;
   @ApiModelProperty(name = "templateCode", value = "短信模板code")
   @JsonProperty("templateCode")
   @JSONField(name = "templateCode")
   @TableField("template_code")
   @Column(name = "template_code")
   private String templateCode;
   @ApiModelProperty(name = "templateContent", value = "短信模板内容")
   @JsonProperty("templateContent")
   @JSONField(name = "templateContent")
   @TableField("template_content")
   @Column(name = "template_content")
   private String templateContent;
   @ApiModelProperty(name = "templateStatus", value = "模板审核状态")
   @JsonProperty("templateStatus")
   @JSONField(name = "templateStatus")
   @TableField("template_status")
   @Column(name = "template_status", columnDefinition = "int default 0")
   private Integer templateStatus;
   @ApiModelProperty(name = "templateType", value = "短信类型")
   @JsonProperty("templateType")
   @JSONField(name = "templateType")
   @TableField("template_type")
   @Column(name = "template_type", columnDefinition = "int default 1")
   private Integer templateType;
   @ApiModelProperty(name = "source", value = "模板来源")
   @JsonProperty("source")
   @JSONField(name = "source")
   @TableField("source")
   @Column(name = "source")
   private Integer source;
   @ApiModelProperty(name = "remark", value = "短信用途")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "reason", value = "短信审核结果备注")
   @JsonProperty("reason")
   @JSONField(name = "reason")
   @TableField("reason")
   @Column(name = "reason")
   private String reason;

   public static MessageTemplate.MessageTemplateBuilder builder() {
      return new MessageTemplate.MessageTemplateBuilder();
   }

   public MessageTemplate() {
   }

   public MessageTemplate(
      final Long id,
      final String templateName,
      final String templateCode,
      final String templateContent,
      final Integer templateStatus,
      final Integer templateType,
      final Integer source,
      final String remark,
      final String reason
   ) {
      this.id = id;
      this.templateName = templateName;
      this.templateCode = templateCode;
      this.templateContent = templateContent;
      this.templateStatus = templateStatus;
      this.templateType = templateType;
      this.source = source;
      this.remark = remark;
      this.reason = reason;
   }

   public Long getId() {
      return this.id;
   }

   public String getTemplateName() {
      return this.templateName;
   }

   public String getTemplateCode() {
      return this.templateCode;
   }

   public String getTemplateContent() {
      return this.templateContent;
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

   public String getReason() {
      return this.reason;
   }

   @JsonProperty("id")
   public MessageTemplate setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("templateName")
   public MessageTemplate setTemplateName(final String templateName) {
      this.templateName = templateName;
      return this;
   }

   @JsonProperty("templateCode")
   public MessageTemplate setTemplateCode(final String templateCode) {
      this.templateCode = templateCode;
      return this;
   }

   @JsonProperty("templateContent")
   public MessageTemplate setTemplateContent(final String templateContent) {
      this.templateContent = templateContent;
      return this;
   }

   @JsonProperty("templateStatus")
   public MessageTemplate setTemplateStatus(final Integer templateStatus) {
      this.templateStatus = templateStatus;
      return this;
   }

   @JsonProperty("templateType")
   public MessageTemplate setTemplateType(final Integer templateType) {
      this.templateType = templateType;
      return this;
   }

   @JsonProperty("source")
   public MessageTemplate setSource(final Integer source) {
      this.source = source;
      return this;
   }

   @JsonProperty("remark")
   public MessageTemplate setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("reason")
   public MessageTemplate setReason(final String reason) {
      this.reason = reason;
      return this;
   }

   @Override
   public String toString() {
      return "MessageTemplate(id="
         + this.getId()
         + ", templateName="
         + this.getTemplateName()
         + ", templateCode="
         + this.getTemplateCode()
         + ", templateContent="
         + this.getTemplateContent()
         + ", templateStatus="
         + this.getTemplateStatus()
         + ", templateType="
         + this.getTemplateType()
         + ", source="
         + this.getSource()
         + ", remark="
         + this.getRemark()
         + ", reason="
         + this.getReason()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MessageTemplate)) {
         return false;
      }

      MessageTemplate other = (MessageTemplate)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                  Object this$templateName = this.getTemplateName();
                  Object other$templateName = other.getTemplateName();
                  if (this$templateName == null ? other$templateName == null : this$templateName.equals(other$templateName)) {
                     Object this$templateCode = this.getTemplateCode();
                     Object other$templateCode = other.getTemplateCode();
                     if (this$templateCode == null ? other$templateCode == null : this$templateCode.equals(other$templateCode)) {
                        Object this$templateContent = this.getTemplateContent();
                        Object other$templateContent = other.getTemplateContent();
                        if (this$templateContent == null ? other$templateContent == null : this$templateContent.equals(other$templateContent)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                              Object this$reason = this.getReason();
                              Object other$reason = other.getReason();
                              return this$reason == null ? other$reason == null : this$reason.equals(other$reason);
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
      return other instanceof MessageTemplate;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $templateStatus = this.getTemplateStatus();
      result = result * 59 + ($templateStatus == null ? 43 : $templateStatus.hashCode());
      Object $templateType = this.getTemplateType();
      result = result * 59 + ($templateType == null ? 43 : $templateType.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $templateName = this.getTemplateName();
      result = result * 59 + ($templateName == null ? 43 : $templateName.hashCode());
      Object $templateCode = this.getTemplateCode();
      result = result * 59 + ($templateCode == null ? 43 : $templateCode.hashCode());
      Object $templateContent = this.getTemplateContent();
      result = result * 59 + ($templateContent == null ? 43 : $templateContent.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $reason = this.getReason();
      return result * 59 + ($reason == null ? 43 : $reason.hashCode());
   }

   public static class MessageTemplateBuilder {
      private Long id;
      private String templateName;
      private String templateCode;
      private String templateContent;
      private Integer templateStatus;
      private Integer templateType;
      private Integer source;
      private String remark;
      private String reason;

      MessageTemplateBuilder() {
      }

      @JsonProperty("id")
      public MessageTemplate.MessageTemplateBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("templateName")
      public MessageTemplate.MessageTemplateBuilder templateName(final String templateName) {
         this.templateName = templateName;
         return this;
      }

      @JsonProperty("templateCode")
      public MessageTemplate.MessageTemplateBuilder templateCode(final String templateCode) {
         this.templateCode = templateCode;
         return this;
      }

      @JsonProperty("templateContent")
      public MessageTemplate.MessageTemplateBuilder templateContent(final String templateContent) {
         this.templateContent = templateContent;
         return this;
      }

      @JsonProperty("templateStatus")
      public MessageTemplate.MessageTemplateBuilder templateStatus(final Integer templateStatus) {
         this.templateStatus = templateStatus;
         return this;
      }

      @JsonProperty("templateType")
      public MessageTemplate.MessageTemplateBuilder templateType(final Integer templateType) {
         this.templateType = templateType;
         return this;
      }

      @JsonProperty("source")
      public MessageTemplate.MessageTemplateBuilder source(final Integer source) {
         this.source = source;
         return this;
      }

      @JsonProperty("remark")
      public MessageTemplate.MessageTemplateBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("reason")
      public MessageTemplate.MessageTemplateBuilder reason(final String reason) {
         this.reason = reason;
         return this;
      }

      public MessageTemplate build() {
         return new MessageTemplate(
            this.id, this.templateName, this.templateCode, this.templateContent, this.templateStatus, this.templateType, this.source, this.remark, this.reason
         );
      }

      @Override
      public String toString() {
         return "MessageTemplate.MessageTemplateBuilder(id="
            + this.id
            + ", templateName="
            + this.templateName
            + ", templateCode="
            + this.templateCode
            + ", templateContent="
            + this.templateContent
            + ", templateStatus="
            + this.templateStatus
            + ", templateType="
            + this.templateType
            + ", source="
            + this.source
            + ", remark="
            + this.remark
            + ", reason="
            + this.reason
            + ")";
      }
   }
}
