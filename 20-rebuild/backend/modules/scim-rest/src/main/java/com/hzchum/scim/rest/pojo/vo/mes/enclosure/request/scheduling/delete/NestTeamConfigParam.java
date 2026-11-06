package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.scheduling.delete;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class NestTeamConfigParam {
   @ApiModelProperty(name = "ids", value = "生产组id", notes = "生产组id")
   @JsonProperty("ids")
   @JSONField(name = "ids")
   private List<Long> ids;

   public static NestTeamConfigParam.NestTeamConfigParamBuilder builder() {
      return new NestTeamConfigParam.NestTeamConfigParamBuilder();
   }

   public NestTeamConfigParam(final List<Long> ids) {
      this.ids = ids;
   }

   public NestTeamConfigParam() {
   }

   public List<Long> getIds() {
      return this.ids;
   }

   @JsonProperty("ids")
   public NestTeamConfigParam setIds(final List<Long> ids) {
      this.ids = ids;
      return this;
   }

   @Override
   public String toString() {
      return "NestTeamConfigParam(ids=" + this.getIds() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NestTeamConfigParam)) {
         return false;
      }

      NestTeamConfigParam other = (NestTeamConfigParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$ids = this.getIds();
      Object other$ids = other.getIds();
      return this$ids == null ? other$ids == null : this$ids.equals(other$ids);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof NestTeamConfigParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $ids = this.getIds();
      return result * 59 + ($ids == null ? 43 : $ids.hashCode());
   }

   public static class NestTeamConfigParamBuilder {
      private List<Long> ids;

      NestTeamConfigParamBuilder() {
      }

      @JsonProperty("ids")
      public NestTeamConfigParam.NestTeamConfigParamBuilder ids(final List<Long> ids) {
         this.ids = ids;
         return this;
      }

      public NestTeamConfigParam build() {
         return new NestTeamConfigParam(this.ids);
      }

      @Override
      public String toString() {
         return "NestTeamConfigParam.NestTeamConfigParamBuilder(ids=" + this.ids + ")";
      }
   }
}
