package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.enums.quota_config.QuotaConfigMeasureUnitEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.Objects;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.DecimalMin;
import javax.validation.groups.Default;

@ApiModel("定额配置辅材新增编辑Param")
public class MesQuotaConfigAuxiliaryMaterialParam {
   @ApiModelProperty("主键ID")
   @NotNull(groups = Update.class, message = "id不能为空")
   private Long id;
   @ApiModelProperty("类型名称")
   @NotBlank(groups = {Add.class, Update.class}, message = "类型不能为空")
   private String typeName;
   @ApiModelProperty("单位")
   @NotBlank(groups = {Add.class, Update.class}, message = "单位不能为空")
   private String unit;
   @ApiModelProperty("单价(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "单价不能为空")
   @DecimalMin(value = "0", groups = {Add.class, Update.class, Default.class}, message = "单价不能为负数")
   private BigDecimal price;

   @AssertTrue(groups = {Add.class, Update.class}, message = "单位不存在")
   public boolean isExistsMeasureUnitEnum() {
      EnumSet<QuotaConfigMeasureUnitEnum> enumSet = EnumSet.of(
         QuotaConfigMeasureUnitEnum.SET, QuotaConfigMeasureUnitEnum.PIECE, QuotaConfigMeasureUnitEnum.GRAIN
      );
      return enumSet.stream().anyMatch(e -> Objects.equals(e.getName(), this.unit));
   }

   public Long getId() {
      return this.id;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setTypeName(final String typeName) {
      this.typeName = typeName;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigAuxiliaryMaterialParam)) {
         return false;
      }

      MesQuotaConfigAuxiliaryMaterialParam other = (MesQuotaConfigAuxiliaryMaterialParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$typeName = this.getTypeName();
         Object other$typeName = other.getTypeName();
         if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
            Object this$unit = this.getUnit();
            Object other$unit = other.getUnit();
            if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
               Object this$price = this.getPrice();
               Object other$price = other.getPrice();
               return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof MesQuotaConfigAuxiliaryMaterialParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "MesQuotaConfigAuxiliaryMaterialParam(id="
         + this.getId()
         + ", typeName="
         + this.getTypeName()
         + ", unit="
         + this.getUnit()
         + ", price="
         + this.getPrice()
         + ")";
   }
}
