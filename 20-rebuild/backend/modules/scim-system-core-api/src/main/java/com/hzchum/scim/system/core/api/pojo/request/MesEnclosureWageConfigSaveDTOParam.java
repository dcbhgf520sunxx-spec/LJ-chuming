package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.plan.core.api.enums.EnclosureCategoryEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@ApiModel("零工配置新增类")
public class MesEnclosureWageConfigSaveDTOParam {
   @NotNull(groups = Update.class, message = "id不能为空")
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @NotNull(groups = {Add.class, Update.class}, message = "围护类型不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = EnclosureCategoryEnum.class, message = "围护类型不存在")
   @ApiModelProperty(name = "category", value = "围护类型", notes = "围护类型")
   private Integer category;
   @ApiModelProperty(name = "unit", value = "计量单位（统一为米）", notes = "计量单位（统一为米）")
   private String unit;
   @NotNull(groups = {Add.class, Update.class}, message = "单价不能为空")
   @DecimalMin(groups = {Add.class, Update.class}, value = "0.01", message = "单价不能小于0.01")
   @ApiModelProperty(name = "price", value = "单价（元）", notes = "单价（元）")
   private BigDecimal price;
   @NotNull(groups = Update.class, message = "状态不能为空")
   @ApiModelProperty(name = "status", value = "状态", notes = "状态")
   private Boolean status;

   public static MesEnclosureWageConfigSaveDTOParam.MesEnclosureWageConfigSaveDTOParamBuilder builder() {
      return new MesEnclosureWageConfigSaveDTOParam.MesEnclosureWageConfigSaveDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureWageConfigSaveDTOParam)) {
         return false;
      }

      MesEnclosureWageConfigSaveDTOParam other = (MesEnclosureWageConfigSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureWageConfigSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureWageConfigSaveDTOParam(id="
         + this.getId()
         + ", category="
         + this.getCategory()
         + ", unit="
         + this.getUnit()
         + ", price="
         + this.getPrice()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public MesEnclosureWageConfigSaveDTOParam(final Long id, final Integer category, final String unit, final BigDecimal price, final Boolean status) {
      this.id = id;
      this.category = category;
      this.unit = unit;
      this.price = price;
      this.status = status;
   }

   public MesEnclosureWageConfigSaveDTOParam() {
   }

   public static class MesEnclosureWageConfigSaveDTOParamBuilder {
      private Long id;
      private Integer category;
      private String unit;
      private BigDecimal price;
      private Boolean status;

      MesEnclosureWageConfigSaveDTOParamBuilder() {
      }

      public MesEnclosureWageConfigSaveDTOParam.MesEnclosureWageConfigSaveDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureWageConfigSaveDTOParam.MesEnclosureWageConfigSaveDTOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public MesEnclosureWageConfigSaveDTOParam.MesEnclosureWageConfigSaveDTOParamBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesEnclosureWageConfigSaveDTOParam.MesEnclosureWageConfigSaveDTOParamBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesEnclosureWageConfigSaveDTOParam.MesEnclosureWageConfigSaveDTOParamBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesEnclosureWageConfigSaveDTOParam build() {
         return new MesEnclosureWageConfigSaveDTOParam(this.id, this.category, this.unit, this.price, this.status);
      }

      @Override
      public String toString() {
         return "MesEnclosureWageConfigSaveDTOParam.MesEnclosureWageConfigSaveDTOParamBuilder(id="
            + this.id
            + ", category="
            + this.category
            + ", unit="
            + this.unit
            + ", price="
            + this.price
            + ", status="
            + this.status
            + ")";
      }
   }
}
