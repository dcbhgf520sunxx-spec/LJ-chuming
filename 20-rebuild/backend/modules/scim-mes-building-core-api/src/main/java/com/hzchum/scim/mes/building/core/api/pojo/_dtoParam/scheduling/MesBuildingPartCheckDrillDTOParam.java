package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingPartCheckDrillDTOParam", description = "零件验证排产请求类")
public class MesBuildingPartCheckDrillDTOParam {
   @ApiModelProperty(name = "id", value = "零件id", notes = "零件id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty("厚度")
   private String thick;

   public static MesBuildingPartCheckDrillDTOParam.MesBuildingPartCheckDrillDTOParamBuilder builder() {
      return new MesBuildingPartCheckDrillDTOParam.MesBuildingPartCheckDrillDTOParamBuilder();
   }

   public MesBuildingPartCheckDrillDTOParam(final Long id, final Integer quantity, final String thick) {
      this.id = id;
      this.quantity = quantity;
      this.thick = thick;
   }

   public MesBuildingPartCheckDrillDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getThick() {
      return this.thick;
   }

   @JsonProperty("id")
   public MesBuildingPartCheckDrillDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingPartCheckDrillDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MesBuildingPartCheckDrillDTOParam setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPartCheckDrillDTOParam)) {
         return false;
      }

      MesBuildingPartCheckDrillDTOParam other = (MesBuildingPartCheckDrillDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$thick = this.getThick();
            Object other$thick = other.getThick();
            return this$thick == null ? other$thick == null : this$thick.equals(other$thick);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPartCheckDrillDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $thick = this.getThick();
      return result * 59 + ($thick == null ? 43 : $thick.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingPartCheckDrillDTOParam(id=" + this.getId() + ", quantity=" + this.getQuantity() + ", thick=" + this.getThick() + ")";
   }

   public static class MesBuildingPartCheckDrillDTOParamBuilder {
      private Long id;
      private Integer quantity;
      private String thick;

      MesBuildingPartCheckDrillDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingPartCheckDrillDTOParam.MesBuildingPartCheckDrillDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingPartCheckDrillDTOParam.MesBuildingPartCheckDrillDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingPartCheckDrillDTOParam.MesBuildingPartCheckDrillDTOParamBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      public MesBuildingPartCheckDrillDTOParam build() {
         return new MesBuildingPartCheckDrillDTOParam(this.id, this.quantity, this.thick);
      }

      @Override
      public String toString() {
         return "MesBuildingPartCheckDrillDTOParam.MesBuildingPartCheckDrillDTOParamBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", thick="
            + this.thick
            + ")";
      }
   }
}
