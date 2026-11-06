package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingWorkshopDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingWorkshopDTO", description = "")
public class MesBuildingWorkshopDTO extends MesBuildingWorkshopDO {
   @ApiModelProperty(name = "factoryName", notes = "工厂名称")
   @JsonProperty("factoryName")
   @JSONField(name = "factoryName")
   private String factoryName;
   @ApiModelProperty(name = "type", value = "车间类型 1:建钢车间 2:桥梁车间 4:围护车间", notes = "车间类型  1:建钢车间 2:桥梁车间 4:围护车间")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "ton", value = "目标产量", notes = "目标产量")
   @JsonProperty("ton")
   @JSONField(name = "ton")
   private BigDecimal ton;

   public String getFactoryName() {
      return this.factoryName;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getTon() {
      return this.ton;
   }

   @JsonProperty("factoryName")
   public MesBuildingWorkshopDTO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingWorkshopDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("ton")
   public MesBuildingWorkshopDTO setTon(final BigDecimal ton) {
      this.ton = ton;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingWorkshopDTO(factoryName=" + this.getFactoryName() + ", type=" + this.getType() + ", ton=" + this.getTon() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWorkshopDTO)) {
         return false;
      }

      MesBuildingWorkshopDTO other = (MesBuildingWorkshopDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$factoryName = this.getFactoryName();
         Object other$factoryName = other.getFactoryName();
         if (this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName)) {
            Object this$ton = this.getTon();
            Object other$ton = other.getTon();
            return this$ton == null ? other$ton == null : this$ton.equals(other$ton);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingWorkshopDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $ton = this.getTon();
      return result * 59 + ($ton == null ? 43 : $ton.hashCode());
   }
}
