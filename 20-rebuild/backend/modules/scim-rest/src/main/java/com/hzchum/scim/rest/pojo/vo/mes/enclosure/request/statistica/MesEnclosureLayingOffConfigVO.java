package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.statistica;

import com.hzchum.pangu.common.valid.AddBatch;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.enclosure.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.mes.enclosure.core.api.enums.statistica.SpecPrefixEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureLayingOffConfig对象", description = "MES零件-下料配置")
public class MesEnclosureLayingOffConfigVO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(message = "零件下料配置id不能为空", groups = Update.class)
   private Long id;
   @ApiModelProperty(name = "specPrefix", value = "零件规格前缀")
   @NotBlank(message = "零件规格前缀不能为空", groups = AddBatch.class)
   @EnumValidator(value = SpecPrefixEnum.class, message = "规格前缀不正确")
   private String specPrefix;
   @ApiModelProperty(name = "cutConfigId", value = "切割配置id", notes = "切割配置id")
   @NotNull(message = "切割配置id不能为空", groups = {AddBatch.class, Update.class})
   private Long cutConfigId;
   @ApiModelProperty(name = "minNumerical", value = "数值范围(最小)")
   @NotNull(message = "数值范围(最小)不能为空", groups = {AddBatch.class, Update.class})
   @Min(0L)
   private BigDecimal minNumerical;
   @ApiModelProperty(name = "maxNumerical", value = "数值范围(最大)")
   @NotNull(message = "数值范围(最大)不能为空", groups = {AddBatch.class, Update.class})
   private BigDecimal maxNumerical;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式", notes = "计价方式 [1 重量, 2 长度，4 面积, 8 数量]")
   @NotNull(message = "计价方式不能为空", groups = {AddBatch.class, Update.class})
   @EnumValidator(value = WageQuotaTypeEnum.class, message = "计价方式不正确")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "unitPrice", value = "单价(元)")
   @NotNull(message = "单价不能为空", groups = {AddBatch.class, Update.class})
   private BigDecimal unitPrice;

   public static MesEnclosureLayingOffConfigVO.MesEnclosureLayingOffConfigVOBuilder builder() {
      return new MesEnclosureLayingOffConfigVO.MesEnclosureLayingOffConfigVOBuilder();
   }

   public MesEnclosureLayingOffConfigVO() {
   }

   public MesEnclosureLayingOffConfigVO(
      final Long id,
      final String specPrefix,
      final Long cutConfigId,
      final BigDecimal minNumerical,
      final BigDecimal maxNumerical,
      final Integer wageQuotaType,
      final BigDecimal unitPrice
   ) {
      this.id = id;
      this.specPrefix = specPrefix;
      this.cutConfigId = cutConfigId;
      this.minNumerical = minNumerical;
      this.maxNumerical = maxNumerical;
      this.wageQuotaType = wageQuotaType;
      this.unitPrice = unitPrice;
   }

   public Long getId() {
      return this.id;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public BigDecimal getMinNumerical() {
      return this.minNumerical;
   }

   public BigDecimal getMaxNumerical() {
      return this.maxNumerical;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
   }

   public void setMinNumerical(final BigDecimal minNumerical) {
      this.minNumerical = minNumerical;
   }

   public void setMaxNumerical(final BigDecimal maxNumerical) {
      this.maxNumerical = maxNumerical;
   }

   public void setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   @Override
   public String toString() {
      return "MesEnclosureLayingOffConfigVO(id="
         + this.getId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", minNumerical="
         + this.getMinNumerical()
         + ", maxNumerical="
         + this.getMaxNumerical()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", unitPrice="
         + this.getUnitPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureLayingOffConfigVO)) {
         return false;
      }

      MesEnclosureLayingOffConfigVO other = (MesEnclosureLayingOffConfigVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cutConfigId = this.getCutConfigId();
         Object other$cutConfigId = other.getCutConfigId();
         if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
            Object this$wageQuotaType = this.getWageQuotaType();
            Object other$wageQuotaType = other.getWageQuotaType();
            if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
               Object this$specPrefix = this.getSpecPrefix();
               Object other$specPrefix = other.getSpecPrefix();
               if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                  Object this$minNumerical = this.getMinNumerical();
                  Object other$minNumerical = other.getMinNumerical();
                  if (this$minNumerical == null ? other$minNumerical == null : this$minNumerical.equals(other$minNumerical)) {
                     Object this$maxNumerical = this.getMaxNumerical();
                     Object other$maxNumerical = other.getMaxNumerical();
                     if (this$maxNumerical == null ? other$maxNumerical == null : this$maxNumerical.equals(other$maxNumerical)) {
                        Object this$unitPrice = this.getUnitPrice();
                        Object other$unitPrice = other.getUnitPrice();
                        return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
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
      return other instanceof MesEnclosureLayingOffConfigVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $minNumerical = this.getMinNumerical();
      result = result * 59 + ($minNumerical == null ? 43 : $minNumerical.hashCode());
      Object $maxNumerical = this.getMaxNumerical();
      result = result * 59 + ($maxNumerical == null ? 43 : $maxNumerical.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   public static class MesEnclosureLayingOffConfigVOBuilder {
      private Long id;
      private String specPrefix;
      private Long cutConfigId;
      private BigDecimal minNumerical;
      private BigDecimal maxNumerical;
      private Integer wageQuotaType;
      private BigDecimal unitPrice;

      MesEnclosureLayingOffConfigVOBuilder() {
      }

      public MesEnclosureLayingOffConfigVO.MesEnclosureLayingOffConfigVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureLayingOffConfigVO.MesEnclosureLayingOffConfigVOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public MesEnclosureLayingOffConfigVO.MesEnclosureLayingOffConfigVOBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      public MesEnclosureLayingOffConfigVO.MesEnclosureLayingOffConfigVOBuilder minNumerical(final BigDecimal minNumerical) {
         this.minNumerical = minNumerical;
         return this;
      }

      public MesEnclosureLayingOffConfigVO.MesEnclosureLayingOffConfigVOBuilder maxNumerical(final BigDecimal maxNumerical) {
         this.maxNumerical = maxNumerical;
         return this;
      }

      public MesEnclosureLayingOffConfigVO.MesEnclosureLayingOffConfigVOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public MesEnclosureLayingOffConfigVO.MesEnclosureLayingOffConfigVOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MesEnclosureLayingOffConfigVO build() {
         return new MesEnclosureLayingOffConfigVO(
            this.id, this.specPrefix, this.cutConfigId, this.minNumerical, this.maxNumerical, this.wageQuotaType, this.unitPrice
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureLayingOffConfigVO.MesEnclosureLayingOffConfigVOBuilder(id="
            + this.id
            + ", specPrefix="
            + this.specPrefix
            + ", cutConfigId="
            + this.cutConfigId
            + ", minNumerical="
            + this.minNumerical
            + ", maxNumerical="
            + this.maxNumerical
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", unitPrice="
            + this.unitPrice
            + ")";
      }
   }
}
