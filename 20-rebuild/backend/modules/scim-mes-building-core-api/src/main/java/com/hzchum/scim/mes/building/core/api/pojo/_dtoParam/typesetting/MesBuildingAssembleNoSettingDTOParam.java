package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.typesetting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingAssembleTypesettingDTOParam", description = "不参与套料的型材DTO")
public class MesBuildingAssembleNoSettingDTOParam {
   @ApiModelProperty(name = "assembleDetailId", value = "部件构件关联表id")
   @JsonProperty("assembleDetailId")
   @JSONField(name = "assembleDetailId")
   private Long assembleDetailId;

   public static MesBuildingAssembleNoSettingDTOParam.MesBuildingAssembleNoSettingDTOParamBuilder builder() {
      return new MesBuildingAssembleNoSettingDTOParam.MesBuildingAssembleNoSettingDTOParamBuilder();
   }

   public MesBuildingAssembleNoSettingDTOParam() {
   }

   public MesBuildingAssembleNoSettingDTOParam(final Long assembleDetailId) {
      this.assembleDetailId = assembleDetailId;
   }

   public Long getAssembleDetailId() {
      return this.assembleDetailId;
   }

   @JsonProperty("assembleDetailId")
   public MesBuildingAssembleNoSettingDTOParam setAssembleDetailId(final Long assembleDetailId) {
      this.assembleDetailId = assembleDetailId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleNoSettingDTOParam(assembleDetailId=" + this.getAssembleDetailId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssembleNoSettingDTOParam)) {
         return false;
      }

      MesBuildingAssembleNoSettingDTOParam other = (MesBuildingAssembleNoSettingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$assembleDetailId = this.getAssembleDetailId();
      Object other$assembleDetailId = other.getAssembleDetailId();
      return this$assembleDetailId == null ? other$assembleDetailId == null : this$assembleDetailId.equals(other$assembleDetailId);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingAssembleNoSettingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $assembleDetailId = this.getAssembleDetailId();
      return result * 59 + ($assembleDetailId == null ? 43 : $assembleDetailId.hashCode());
   }

   public static class MesBuildingAssembleNoSettingDTOParamBuilder {
      private Long assembleDetailId;

      MesBuildingAssembleNoSettingDTOParamBuilder() {
      }

      @JsonProperty("assembleDetailId")
      public MesBuildingAssembleNoSettingDTOParam.MesBuildingAssembleNoSettingDTOParamBuilder assembleDetailId(final Long assembleDetailId) {
         this.assembleDetailId = assembleDetailId;
         return this;
      }

      public MesBuildingAssembleNoSettingDTOParam build() {
         return new MesBuildingAssembleNoSettingDTOParam(this.assembleDetailId);
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleNoSettingDTOParam.MesBuildingAssembleNoSettingDTOParamBuilder(assembleDetailId=" + this.assembleDetailId + ")";
      }
   }
}
