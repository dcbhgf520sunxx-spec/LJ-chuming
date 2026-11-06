package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "ApproveCode对象", description = "")
@Entity
@TableName("approve_code")
@Table(name = "approve_code")
public class ApproveCode extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "code", value = "审批模板唯一代码", notes = "审批模板唯一代码")
   @JsonProperty("code")
   @JSONField(name = "code")
   @TableField("code")
   @Column(name = "code", columnDefinition = "varchar(255)  COMMENT '审批模板唯一代码'", nullable = false)
   private String code;
   @ApiModelProperty(name = "templateType", value = "模板类型", notes = "模板类型")
   @JsonProperty("templateType")
   @JSONField(name = "templateType")
   @TableField("template_type")
   @Column(name = "template_type", columnDefinition = "int  COMMENT '模板类型'", nullable = true)
   private Integer templateType;

   public static ApproveCode.ApproveCodeBuilder builder() {
      return new ApproveCode.ApproveCodeBuilder();
   }

   public ApproveCode() {
   }

   public ApproveCode(final Long id, final String code, final Integer templateType) {
      this.id = id;
      this.code = code;
      this.templateType = templateType;
   }

   public Long getId() {
      return this.id;
   }

   public String getCode() {
      return this.code;
   }

   public Integer getTemplateType() {
      return this.templateType;
   }

   @JsonProperty("id")
   public ApproveCode setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("code")
   public ApproveCode setCode(final String code) {
      this.code = code;
      return this;
   }

   @JsonProperty("templateType")
   public ApproveCode setTemplateType(final Integer templateType) {
      this.templateType = templateType;
      return this;
   }

   @Override
   public String toString() {
      return "ApproveCode(id=" + this.getId() + ", code=" + this.getCode() + ", templateType=" + this.getTemplateType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApproveCode)) {
         return false;
      }

      ApproveCode other = (ApproveCode)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$templateType = this.getTemplateType();
         Object other$templateType = other.getTemplateType();
         if (this$templateType == null ? other$templateType == null : this$templateType.equals(other$templateType)) {
            Object this$code = this.getCode();
            Object other$code = other.getCode();
            return this$code == null ? other$code == null : this$code.equals(other$code);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ApproveCode;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $templateType = this.getTemplateType();
      result = result * 59 + ($templateType == null ? 43 : $templateType.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   public static class ApproveCodeBuilder {
      private Long id;
      private String code;
      private Integer templateType;

      ApproveCodeBuilder() {
      }

      @JsonProperty("id")
      public ApproveCode.ApproveCodeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("code")
      public ApproveCode.ApproveCodeBuilder code(final String code) {
         this.code = code;
         return this;
      }

      @JsonProperty("templateType")
      public ApproveCode.ApproveCodeBuilder templateType(final Integer templateType) {
         this.templateType = templateType;
         return this;
      }

      public ApproveCode build() {
         return new ApproveCode(this.id, this.code, this.templateType);
      }

      @Override
      public String toString() {
         return "ApproveCode.ApproveCodeBuilder(id=" + this.id + ", code=" + this.code + ", templateType=" + this.templateType + ")";
      }
   }
}
