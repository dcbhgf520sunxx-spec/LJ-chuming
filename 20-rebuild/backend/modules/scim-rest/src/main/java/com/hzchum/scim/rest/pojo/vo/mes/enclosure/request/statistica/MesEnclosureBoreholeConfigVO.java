package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.statistica;

import com.hzchum.pangu.common.valid.AddBatch;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.enclosure.core.api.enums.statistica.SpecPrefixEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureCoatingConfigVO", description = "钻孔配置VO ")
public class MesEnclosureBoreholeConfigVO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(message = "钻孔配置id不能为空", groups = Update.class)
   private Long id;
   @ApiModelProperty(name = "specPrefix", value = "零件规格前缀")
   @NotBlank(message = "零件规格前缀不能为空", groups = AddBatch.class)
   @EnumValidator(value = SpecPrefixEnum.class, message = "规格前缀不正确")
   private String specPrefix;
   @ApiModelProperty(name = "minThickness", value = "最小板厚(毫米)")
   @NotNull(message = "最小板厚不能为空", groups = {AddBatch.class, Update.class})
   @Min(0L)
   private BigDecimal minThickness;
   @ApiModelProperty(name = "maxThickness", value = "最大板厚(毫米)")
   @NotNull(message = "最大板厚不能为空", groups = {AddBatch.class, Update.class})
   @Min(0L)
   private BigDecimal maxThickness;

   public static MesEnclosureBoreholeConfigVO.MesEnclosureBoreholeConfigVOBuilder builder() {
      return new MesEnclosureBoreholeConfigVO.MesEnclosureBoreholeConfigVOBuilder();
   }

   public MesEnclosureBoreholeConfigVO() {
   }

   public MesEnclosureBoreholeConfigVO(final Long id, final String specPrefix, final BigDecimal minThickness, final BigDecimal maxThickness) {
      this.id = id;
      this.specPrefix = specPrefix;
      this.minThickness = minThickness;
      this.maxThickness = maxThickness;
   }

   public Long getId() {
      return this.id;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public BigDecimal getMinThickness() {
      return this.minThickness;
   }

   public BigDecimal getMaxThickness() {
      return this.maxThickness;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setMinThickness(final BigDecimal minThickness) {
      this.minThickness = minThickness;
   }

   public void setMaxThickness(final BigDecimal maxThickness) {
      this.maxThickness = maxThickness;
   }

   @Override
   public String toString() {
      return "MesEnclosureBoreholeConfigVO(id="
         + this.getId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", minThickness="
         + this.getMinThickness()
         + ", maxThickness="
         + this.getMaxThickness()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureBoreholeConfigVO)) {
         return false;
      }

      MesEnclosureBoreholeConfigVO other = (MesEnclosureBoreholeConfigVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$specPrefix = this.getSpecPrefix();
         Object other$specPrefix = other.getSpecPrefix();
         if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
            Object this$minThickness = this.getMinThickness();
            Object other$minThickness = other.getMinThickness();
            if (this$minThickness == null ? other$minThickness == null : this$minThickness.equals(other$minThickness)) {
               Object this$maxThickness = this.getMaxThickness();
               Object other$maxThickness = other.getMaxThickness();
               return this$maxThickness == null ? other$maxThickness == null : this$maxThickness.equals(other$maxThickness);
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
      return other instanceof MesEnclosureBoreholeConfigVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $minThickness = this.getMinThickness();
      result = result * 59 + ($minThickness == null ? 43 : $minThickness.hashCode());
      Object $maxThickness = this.getMaxThickness();
      return result * 59 + ($maxThickness == null ? 43 : $maxThickness.hashCode());
   }

   public static class MesEnclosureBoreholeConfigVOBuilder {
      private Long id;
      private String specPrefix;
      private BigDecimal minThickness;
      private BigDecimal maxThickness;

      MesEnclosureBoreholeConfigVOBuilder() {
      }

      public MesEnclosureBoreholeConfigVO.MesEnclosureBoreholeConfigVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureBoreholeConfigVO.MesEnclosureBoreholeConfigVOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public MesEnclosureBoreholeConfigVO.MesEnclosureBoreholeConfigVOBuilder minThickness(final BigDecimal minThickness) {
         this.minThickness = minThickness;
         return this;
      }

      public MesEnclosureBoreholeConfigVO.MesEnclosureBoreholeConfigVOBuilder maxThickness(final BigDecimal maxThickness) {
         this.maxThickness = maxThickness;
         return this;
      }

      public MesEnclosureBoreholeConfigVO build() {
         return new MesEnclosureBoreholeConfigVO(this.id, this.specPrefix, this.minThickness, this.maxThickness);
      }

      @Override
      public String toString() {
         return "MesEnclosureBoreholeConfigVO.MesEnclosureBoreholeConfigVOBuilder(id="
            + this.id
            + ", specPrefix="
            + this.specPrefix
            + ", minThickness="
            + this.minThickness
            + ", maxThickness="
            + this.maxThickness
            + ")";
      }
   }
}
