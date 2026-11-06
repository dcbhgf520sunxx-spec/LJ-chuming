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

@ApiModel("定额配置围护新增编辑Param")
public class MesQuotaConfigEnclosureParam {
   @ApiModelProperty("主键ID")
   @NotNull(groups = Update.class, message = "id不能为空")
   private Long id;
   @ApiModelProperty("围护类型字典id")
   @NotNull(groups = {Add.class, Update.class}, message = "围护类型不能为空")
   private Long enclosureTypeDictionaryId;
   @ApiModelProperty("单位")
   @NotBlank(groups = {Add.class, Update.class}, message = "单位不能为空")
   private String unit;
   @ApiModelProperty("单价(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "单价不能为空")
   @DecimalMin(value = "0", groups = {Add.class, Update.class, Default.class}, message = "单价不能为负数")
   private BigDecimal price;

   @AssertTrue(groups = {Add.class, Update.class}, message = "单位不存在")
   public boolean isExistsMeasureUnitEnum() {
      EnumSet<QuotaConfigMeasureUnitEnum> enumSet = EnumSet.of(QuotaConfigMeasureUnitEnum.METER);
      return enumSet.stream().anyMatch(e -> Objects.equals(e.getName(), this.unit));
   }

   public Long getId() {
      return this.id;
   }

   public Long getEnclosureTypeDictionaryId() {
      return this.enclosureTypeDictionaryId;
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

   public void setEnclosureTypeDictionaryId(final Long enclosureTypeDictionaryId) {
      this.enclosureTypeDictionaryId = enclosureTypeDictionaryId;
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

      if (!(o instanceof MesQuotaConfigEnclosureParam)) {
         return false;
      }

      MesQuotaConfigEnclosureParam other = (MesQuotaConfigEnclosureParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$enclosureTypeDictionaryId = this.getEnclosureTypeDictionaryId();
         Object other$enclosureTypeDictionaryId = other.getEnclosureTypeDictionaryId();
         if (this$enclosureTypeDictionaryId == null
            ? other$enclosureTypeDictionaryId == null
            : this$enclosureTypeDictionaryId.equals(other$enclosureTypeDictionaryId)) {
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
      return other instanceof MesQuotaConfigEnclosureParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $enclosureTypeDictionaryId = this.getEnclosureTypeDictionaryId();
      result = result * 59 + ($enclosureTypeDictionaryId == null ? 43 : $enclosureTypeDictionaryId.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "MesQuotaConfigEnclosureParam(id="
         + this.getId()
         + ", enclosureTypeDictionaryId="
         + this.getEnclosureTypeDictionaryId()
         + ", unit="
         + this.getUnit()
         + ", price="
         + this.getPrice()
         + ")";
   }
}
