package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.typesetting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingAssembleTypesettingDTOParam", description = "套料保存DTO")
public class MesBuildingAssembleSettingDTOParam {
   @ApiModelProperty(name = "id", value = "部件构件关联表id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "quantity", value = "套料数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @NotNull(message = "套料数量不能为空")
   @Min(value = 1L, message = "套料数量必须大于0")
   private Integer quantity;

   public static MesBuildingAssembleSettingDTOParam.MesBuildingAssembleSettingDTOParamBuilder builder() {
      return new MesBuildingAssembleSettingDTOParam.MesBuildingAssembleSettingDTOParamBuilder();
   }

   public MesBuildingAssembleSettingDTOParam() {
   }

   public MesBuildingAssembleSettingDTOParam(final Long id, final Integer quantity) {
      this.id = id;
      this.quantity = quantity;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("id")
   public MesBuildingAssembleSettingDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingAssembleSettingDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleSettingDTOParam(id=" + this.getId() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingAssembleSettingDTOParam)) {
         return false;
      } else {
         MesBuildingAssembleSettingDTOParam other = (MesBuildingAssembleSettingDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingAssembleSettingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class MesBuildingAssembleSettingDTOParamBuilder {
      private Long id;
      private Integer quantity;

      MesBuildingAssembleSettingDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingAssembleSettingDTOParam.MesBuildingAssembleSettingDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingAssembleSettingDTOParam.MesBuildingAssembleSettingDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingAssembleSettingDTOParam build() {
         return new MesBuildingAssembleSettingDTOParam(this.id, this.quantity);
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleSettingDTOParam.MesBuildingAssembleSettingDTOParamBuilder(id=" + this.id + ", quantity=" + this.quantity + ")";
      }
   }
}
