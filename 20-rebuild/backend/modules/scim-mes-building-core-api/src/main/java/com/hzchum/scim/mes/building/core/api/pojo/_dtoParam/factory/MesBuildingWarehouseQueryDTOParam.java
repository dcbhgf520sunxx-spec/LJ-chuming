package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingWarehouse对象", description = "仓库表")
public class MesBuildingWarehouseQueryDTOParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "name", value = "仓库名称", notes = "仓库名称")
   private String name;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   private Long workshopId;
   @ApiModelProperty(name = "boolEnableEnum", value = "启用状态 true启用 false禁用", notes = "启用状态 true启用 false禁用")
   private Boolean boolEnableEnum;

   public static MesBuildingWarehouseQueryDTOParam.MesBuildingWarehouseQueryDTOParamBuilder builder() {
      return new MesBuildingWarehouseQueryDTOParam.MesBuildingWarehouseQueryDTOParamBuilder();
   }

   public MesBuildingWarehouseQueryDTOParam() {
   }

   public MesBuildingWarehouseQueryDTOParam(final String name, final Long workshopId, final Boolean boolEnableEnum) {
      this.name = name;
      this.workshopId = workshopId;
      this.boolEnableEnum = boolEnableEnum;
   }

   public String getName() {
      return this.name;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Boolean getBoolEnableEnum() {
      return this.boolEnableEnum;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setBoolEnableEnum(final Boolean boolEnableEnum) {
      this.boolEnableEnum = boolEnableEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWarehouseQueryDTOParam)) {
         return false;
      }

      MesBuildingWarehouseQueryDTOParam other = (MesBuildingWarehouseQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$boolEnableEnum = this.getBoolEnableEnum();
         Object other$boolEnableEnum = other.getBoolEnableEnum();
         if (this$boolEnableEnum == null ? other$boolEnableEnum == null : this$boolEnableEnum.equals(other$boolEnableEnum)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingWarehouseQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $boolEnableEnum = this.getBoolEnableEnum();
      result = result * 59 + ($boolEnableEnum == null ? 43 : $boolEnableEnum.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingWarehouseQueryDTOParam(name="
         + this.getName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", boolEnableEnum="
         + this.getBoolEnableEnum()
         + ")";
   }

   public static class MesBuildingWarehouseQueryDTOParamBuilder {
      private String name;
      private Long workshopId;
      private Boolean boolEnableEnum;

      MesBuildingWarehouseQueryDTOParamBuilder() {
      }

      public MesBuildingWarehouseQueryDTOParam.MesBuildingWarehouseQueryDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingWarehouseQueryDTOParam.MesBuildingWarehouseQueryDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesBuildingWarehouseQueryDTOParam.MesBuildingWarehouseQueryDTOParamBuilder boolEnableEnum(final Boolean boolEnableEnum) {
         this.boolEnableEnum = boolEnableEnum;
         return this;
      }

      public MesBuildingWarehouseQueryDTOParam build() {
         return new MesBuildingWarehouseQueryDTOParam(this.name, this.workshopId, this.boolEnableEnum);
      }

      @Override
      public String toString() {
         return "MesBuildingWarehouseQueryDTOParam.MesBuildingWarehouseQueryDTOParamBuilder(name="
            + this.name
            + ", workshopId="
            + this.workshopId
            + ", boolEnableEnum="
            + this.boolEnableEnum
            + ")";
      }
   }
}
