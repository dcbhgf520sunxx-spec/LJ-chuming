package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesEnclosureNestCutPlateDTOParam", description = "切割指令")
public class MesEnclosureNestCutPlateDTOParam {
   @ApiModelProperty(name = "id", value = "切割id", notes = "切割id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "number", value = "钢板条形码编号", notes = "钢板条形码编号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private String number;

   public static MesEnclosureNestCutPlateDTOParam.MesEnclosureNestCutPlateDTOParamBuilder builder() {
      return new MesEnclosureNestCutPlateDTOParam.MesEnclosureNestCutPlateDTOParamBuilder();
   }

   public MesEnclosureNestCutPlateDTOParam(final Long id, final String number) {
      this.id = id;
      this.number = number;
   }

   public MesEnclosureNestCutPlateDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public String getNumber() {
      return this.number;
   }

   @JsonProperty("id")
   public MesEnclosureNestCutPlateDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("number")
   public MesEnclosureNestCutPlateDTOParam setNumber(final String number) {
      this.number = number;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureNestCutPlateDTOParam(id=" + this.getId() + ", number=" + this.getNumber() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesEnclosureNestCutPlateDTOParam)) {
         return false;
      } else {
         MesEnclosureNestCutPlateDTOParam other = (MesEnclosureNestCutPlateDTOParam)o;
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
      return other instanceof MesEnclosureNestCutPlateDTOParam;
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

   public static class MesEnclosureNestCutPlateDTOParamBuilder {
      private Long id;
      private String number;

      MesEnclosureNestCutPlateDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureNestCutPlateDTOParam.MesEnclosureNestCutPlateDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("number")
      public MesEnclosureNestCutPlateDTOParam.MesEnclosureNestCutPlateDTOParamBuilder number(final String number) {
         this.number = number;
         return this;
      }

      public MesEnclosureNestCutPlateDTOParam build() {
         return new MesEnclosureNestCutPlateDTOParam(this.id, this.number);
      }

      @Override
      public String toString() {
         return "MesEnclosureNestCutPlateDTOParam.MesEnclosureNestCutPlateDTOParamBuilder(id=" + this.id + ", number=" + this.number + ")";
      }
   }
}
