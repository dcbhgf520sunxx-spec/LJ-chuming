package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class SteelDensityDTOParam {
   private Long id;
   @ApiModelProperty("科目ID")
   @NotNull(message = "科目ID不能为空")
   private Long classifyId;
   @ApiModelProperty("密度")
   @NotNull(message = "密度不能为空")
   private BigDecimal density;

   public static SteelDensityDTOParam.SteelDensityDTOParamBuilder builder() {
      return new SteelDensityDTOParam.SteelDensityDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public BigDecimal getDensity() {
      return this.density;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setDensity(final BigDecimal density) {
      this.density = density;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelDensityDTOParam)) {
         return false;
      }

      SteelDensityDTOParam other = (SteelDensityDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$density = this.getDensity();
            Object other$density = other.getDensity();
            return this$density == null ? other$density == null : this$density.equals(other$density);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SteelDensityDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $density = this.getDensity();
      return result * 59 + ($density == null ? 43 : $density.hashCode());
   }

   @Override
   public String toString() {
      return "SteelDensityDTOParam(id=" + this.getId() + ", classifyId=" + this.getClassifyId() + ", density=" + this.getDensity() + ")";
   }

   public SteelDensityDTOParam(final Long id, final Long classifyId, final BigDecimal density) {
      this.id = id;
      this.classifyId = classifyId;
      this.density = density;
   }

   public SteelDensityDTOParam() {
   }

   public static class SteelDensityDTOParamBuilder {
      private Long id;
      private Long classifyId;
      private BigDecimal density;

      SteelDensityDTOParamBuilder() {
      }

      public SteelDensityDTOParam.SteelDensityDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SteelDensityDTOParam.SteelDensityDTOParamBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public SteelDensityDTOParam.SteelDensityDTOParamBuilder density(final BigDecimal density) {
         this.density = density;
         return this;
      }

      public SteelDensityDTOParam build() {
         return new SteelDensityDTOParam(this.id, this.classifyId, this.density);
      }

      @Override
      public String toString() {
         return "SteelDensityDTOParam.SteelDensityDTOParamBuilder(id=" + this.id + ", classifyId=" + this.classifyId + ", density=" + this.density + ")";
      }
   }
}
