package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@ApiModel("点工定额配置新增修改参数")
public class MesTempWorkQuotaConfigParam {
   @ApiModelProperty("主键ID")
   @NotNull(groups = Update.class, message = "ID不能为空")
   private Long id;
   @ApiModelProperty("点工名称")
   @NotBlank(groups = {Add.class, Update.class}, message = "点工类型不能为空")
   @Size(max = 60, message = "点工名称长度不能超过60")
   private String name;
   @ApiModelProperty("类型")
   @NotNull(groups = {Add.class, Update.class}, message = "类型不能为空")
   private Integer type;
   @ApiModelProperty("工时单价(元/小时)")
   @Positive(groups = {Add.class, Update.class}, message = "工时单价必须大于0")
   private BigDecimal price;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTempWorkQuotaConfigParam)) {
         return false;
      }

      MesTempWorkQuotaConfigParam other = (MesTempWorkQuotaConfigParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
      return other instanceof MesTempWorkQuotaConfigParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "MesTempWorkQuotaConfigParam(id=" + this.getId() + ", name=" + this.getName() + ", type=" + this.getType() + ", price=" + this.getPrice() + ")";
   }
}
