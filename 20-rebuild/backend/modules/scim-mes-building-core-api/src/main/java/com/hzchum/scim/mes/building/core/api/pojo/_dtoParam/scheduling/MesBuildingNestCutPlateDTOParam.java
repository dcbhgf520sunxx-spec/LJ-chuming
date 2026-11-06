package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingNestCutPlateDTOParam", description = "切割指令")
public class MesBuildingNestCutPlateDTOParam {
   @ApiModelProperty(name = "id", value = "切割id", notes = "切割id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "number", value = "钢板条形码编号", notes = "钢板条形码编号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private String number;

   public static MesBuildingNestCutPlateDTOParam.MesBuildingNestCutPlateDTOParamBuilder builder() {
      return new MesBuildingNestCutPlateDTOParam.MesBuildingNestCutPlateDTOParamBuilder();
   }

   public MesBuildingNestCutPlateDTOParam(final Long id, final String number) {
      this.id = id;
      this.number = number;
   }

   public MesBuildingNestCutPlateDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public String getNumber() {
      return this.number;
   }

   @JsonProperty("id")
   public MesBuildingNestCutPlateDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingNestCutPlateDTOParam setNumber(final String number) {
      this.number = number;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNestCutPlateDTOParam(id=" + this.getId() + ", number=" + this.getNumber() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingNestCutPlateDTOParam)) {
         return false;
      } else {
         MesBuildingNestCutPlateDTOParam other = (MesBuildingNestCutPlateDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$number = this.getNumber();
               Object other$number = other.getNumber();
               return this$number == null ? other$number == null : this$number.equals(other$number);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingNestCutPlateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $number = this.getNumber();
      return result * 59 + ($number == null ? 43 : $number.hashCode());
   }

   public static class MesBuildingNestCutPlateDTOParamBuilder {
      private Long id;
      private String number;

      MesBuildingNestCutPlateDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingNestCutPlateDTOParam.MesBuildingNestCutPlateDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingNestCutPlateDTOParam.MesBuildingNestCutPlateDTOParamBuilder number(final String number) {
         this.number = number;
         return this;
      }

      public MesBuildingNestCutPlateDTOParam build() {
         return new MesBuildingNestCutPlateDTOParam(this.id, this.number);
      }

      @Override
      public String toString() {
         return "MesBuildingNestCutPlateDTOParam.MesBuildingNestCutPlateDTOParamBuilder(id=" + this.id + ", number=" + this.number + ")";
      }
   }
}
