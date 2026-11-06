package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("项目模板列表 返回类")
public class SysProjectPersonnelDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "templateName", value = "模板名称")
   private String templateName;
   @ApiModelProperty(name = "isDefault", value = "是否默认 1是0否")
   private Boolean isDefault;
   @ApiModelProperty(name = "status", value = "状态1启用 0备用")
   private Integer status;
   @ApiModelProperty(name = "remark", value = "备注(描述)")
   private String remark;

   public static SysProjectPersonnelDTO.SysProjectPersonnelDTOBuilder builder() {
      return new SysProjectPersonnelDTO.SysProjectPersonnelDTOBuilder();
   }

   public SysProjectPersonnelDTO() {
   }

   public SysProjectPersonnelDTO(final Long id, final String templateName, final Boolean isDefault, final Integer status, final String remark) {
      this.id = id;
      this.templateName = templateName;
      this.isDefault = isDefault;
      this.status = status;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public String getTemplateName() {
      return this.templateName;
   }

   public Boolean getIsDefault() {
      return this.isDefault;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setTemplateName(final String templateName) {
      this.templateName = templateName;
   }

   public void setIsDefault(final Boolean isDefault) {
      this.isDefault = isDefault;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysProjectPersonnelDTO)) {
         return false;
      }

      SysProjectPersonnelDTO other = (SysProjectPersonnelDTO)o;
      if (!other.canEqual(this)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysProjectPersonnelDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $isDefault = this.getIsDefault();
      result = result * 59 + ($isDefault == null ? 43 : $isDefault.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $templateName = this.getTemplateName();
      result = result * 59 + ($templateName == null ? 43 : $templateName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "SysProjectPersonnelDTO(id="
         + this.getId()
         + ", templateName="
         + this.getTemplateName()
         + ", isDefault="
         + this.getIsDefault()
         + ", status="
         + this.getStatus()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class SysProjectPersonnelDTOBuilder {
      private Long id;
      private String templateName;
      private Boolean isDefault;
      private Integer status;
      private String remark;

      SysProjectPersonnelDTOBuilder() {
      }

      public SysProjectPersonnelDTO.SysProjectPersonnelDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysProjectPersonnelDTO.SysProjectPersonnelDTOBuilder templateName(final String templateName) {
         this.templateName = templateName;
         return this;
      }

      public SysProjectPersonnelDTO.SysProjectPersonnelDTOBuilder isDefault(final Boolean isDefault) {
         this.isDefault = isDefault;
         return this;
      }

      public SysProjectPersonnelDTO.SysProjectPersonnelDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public SysProjectPersonnelDTO.SysProjectPersonnelDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SysProjectPersonnelDTO build() {
         return new SysProjectPersonnelDTO(this.id, this.templateName, this.isDefault, this.status, this.remark);
      }

      @Override
      public String toString() {
         return "SysProjectPersonnelDTO.SysProjectPersonnelDTOBuilder(id="
            + this.id
            + ", templateName="
            + this.templateName
            + ", isDefault="
            + this.isDefault
            + ", status="
            + this.status
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
