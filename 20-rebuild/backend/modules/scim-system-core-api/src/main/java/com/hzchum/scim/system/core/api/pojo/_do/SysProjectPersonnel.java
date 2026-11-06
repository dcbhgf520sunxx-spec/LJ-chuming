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

@ApiModel(value = "SysProjectPersonnel对象", description = "")
@Entity
@TableName("sys_project_personnel")
@Table(name = "sys_project_personnel")
public class SysProjectPersonnel extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "isDefault")
   @JsonProperty("isDefault")
   @JSONField(name = "isDefault")
   @TableField("is_default")
   @Column(name = "is_default")
   private Boolean isDefault;
   @ApiModelProperty(name = "remark")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "status")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status")
   private Integer status;
   @ApiModelProperty(name = "templateName")
   @JsonProperty("templateName")
   @JSONField(name = "templateName")
   @TableField("template_name")
   @Column(name = "template_name")
   private String templateName;

   public static SysProjectPersonnel.SysProjectPersonnelBuilder builder() {
      return new SysProjectPersonnel.SysProjectPersonnelBuilder();
   }

   public SysProjectPersonnel() {
   }

   public SysProjectPersonnel(final Long id, final Boolean isDefault, final String remark, final Integer status, final String templateName) {
      this.id = id;
      this.isDefault = isDefault;
      this.remark = remark;
      this.status = status;
      this.templateName = templateName;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getIsDefault() {
      return this.isDefault;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getTemplateName() {
      return this.templateName;
   }

   @JsonProperty("id")
   public SysProjectPersonnel setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("isDefault")
   public SysProjectPersonnel setIsDefault(final Boolean isDefault) {
      this.isDefault = isDefault;
      return this;
   }

   @JsonProperty("remark")
   public SysProjectPersonnel setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("status")
   public SysProjectPersonnel setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("templateName")
   public SysProjectPersonnel setTemplateName(final String templateName) {
      this.templateName = templateName;
      return this;
   }

   @Override
   public String toString() {
      return "SysProjectPersonnel(id="
         + this.getId()
         + ", isDefault="
         + this.getIsDefault()
         + ", remark="
         + this.getRemark()
         + ", status="
         + this.getStatus()
         + ", templateName="
         + this.getTemplateName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysProjectPersonnel)) {
         return false;
      }

      SysProjectPersonnel other = (SysProjectPersonnel)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$isDefault = this.getIsDefault();
         Object other$isDefault = other.getIsDefault();
         if (this$isDefault == null ? other$isDefault == null : this$isDefault.equals(other$isDefault)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                  Object this$templateName = this.getTemplateName();
                  Object other$templateName = other.getTemplateName();
                  return this$templateName == null ? other$templateName == null : this$templateName.equals(other$templateName);
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
      return other instanceof SysProjectPersonnel;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $isDefault = this.getIsDefault();
      result = result * 59 + ($isDefault == null ? 43 : $isDefault.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $templateName = this.getTemplateName();
      return result * 59 + ($templateName == null ? 43 : $templateName.hashCode());
   }

   public static class SysProjectPersonnelBuilder {
      private Long id;
      private Boolean isDefault;
      private String remark;
      private Integer status;
      private String templateName;

      SysProjectPersonnelBuilder() {
      }

      @JsonProperty("id")
      public SysProjectPersonnel.SysProjectPersonnelBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("isDefault")
      public SysProjectPersonnel.SysProjectPersonnelBuilder isDefault(final Boolean isDefault) {
         this.isDefault = isDefault;
         return this;
      }

      @JsonProperty("remark")
      public SysProjectPersonnel.SysProjectPersonnelBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("status")
      public SysProjectPersonnel.SysProjectPersonnelBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("templateName")
      public SysProjectPersonnel.SysProjectPersonnelBuilder templateName(final String templateName) {
         this.templateName = templateName;
         return this;
      }

      public SysProjectPersonnel build() {
         return new SysProjectPersonnel(this.id, this.isDefault, this.remark, this.status, this.templateName);
      }

      @Override
      public String toString() {
         return "SysProjectPersonnel.SysProjectPersonnelBuilder(id="
            + this.id
            + ", isDefault="
            + this.isDefault
            + ", remark="
            + this.remark
            + ", status="
            + this.status
            + ", templateName="
            + this.templateName
            + ")";
      }
   }
}
