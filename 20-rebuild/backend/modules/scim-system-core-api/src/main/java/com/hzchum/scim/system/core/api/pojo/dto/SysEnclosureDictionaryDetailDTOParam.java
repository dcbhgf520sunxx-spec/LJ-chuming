package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel("围护字典版型详情请求类 ")
public class SysEnclosureDictionaryDetailDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "effectiveWidth", value = "有效宽度")
   @NotNull(message = "有效宽度不能为空")
   private BigDecimal effectiveWidth;
   @NotNull(message = "展宽不能为空")
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽")
   private BigDecimal unfoldedWidth;

   public static SysEnclosureDictionaryDetailDTOParam.SysEnclosureDictionaryDetailDTOParamBuilder builder() {
      return new SysEnclosureDictionaryDetailDTOParam.SysEnclosureDictionaryDetailDTOParamBuilder();
   }

   public SysEnclosureDictionaryDetailDTOParam() {
   }

   public SysEnclosureDictionaryDetailDTOParam(final Long id, final BigDecimal effectiveWidth, final BigDecimal unfoldedWidth) {
      this.id = id;
      this.effectiveWidth = effectiveWidth;
      this.unfoldedWidth = unfoldedWidth;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getEffectiveWidth() {
      return this.effectiveWidth;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setEffectiveWidth(final BigDecimal effectiveWidth) {
      this.effectiveWidth = effectiveWidth;
   }

   public void setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysEnclosureDictionaryDetailDTOParam)) {
         return false;
      }

      SysEnclosureDictionaryDetailDTOParam other = (SysEnclosureDictionaryDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$effectiveWidth = this.getEffectiveWidth();
         Object other$effectiveWidth = other.getEffectiveWidth();
         if (this$effectiveWidth == null ? other$effectiveWidth == null : this$effectiveWidth.equals(other$effectiveWidth)) {
            Object this$unfoldedWidth = this.getUnfoldedWidth();
            Object other$unfoldedWidth = other.getUnfoldedWidth();
            return this$unfoldedWidth == null ? other$unfoldedWidth == null : this$unfoldedWidth.equals(other$unfoldedWidth);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysEnclosureDictionaryDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $effectiveWidth = this.getEffectiveWidth();
      result = result * 59 + ($effectiveWidth == null ? 43 : $effectiveWidth.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      return result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
   }

   @Override
   public String toString() {
      return "SysEnclosureDictionaryDetailDTOParam(id="
         + this.getId()
         + ", effectiveWidth="
         + this.getEffectiveWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ")";
   }

   public static class SysEnclosureDictionaryDetailDTOParamBuilder {
      private Long id;
      private BigDecimal effectiveWidth;
      private BigDecimal unfoldedWidth;

      SysEnclosureDictionaryDetailDTOParamBuilder() {
      }

      public SysEnclosureDictionaryDetailDTOParam.SysEnclosureDictionaryDetailDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysEnclosureDictionaryDetailDTOParam.SysEnclosureDictionaryDetailDTOParamBuilder effectiveWidth(final BigDecimal effectiveWidth) {
         this.effectiveWidth = effectiveWidth;
         return this;
      }

      public SysEnclosureDictionaryDetailDTOParam.SysEnclosureDictionaryDetailDTOParamBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      public SysEnclosureDictionaryDetailDTOParam build() {
         return new SysEnclosureDictionaryDetailDTOParam(this.id, this.effectiveWidth, this.unfoldedWidth);
      }

      @Override
      public String toString() {
         return "SysEnclosureDictionaryDetailDTOParam.SysEnclosureDictionaryDetailDTOParamBuilder(id="
            + this.id
            + ", effectiveWidth="
            + this.effectiveWidth
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ")";
      }
   }
}
