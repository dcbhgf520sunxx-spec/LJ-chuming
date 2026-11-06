package com.hzchum.scim.mes.building.core.api.pojo._doParam.workshop;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ids对象", description = "")
public class IdsVoRequest {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("ids")
   @JSONField(name = "ids")
   private List<Long> ids;

   public List<Long> getIds() {
      return this.ids;
   }

   @JsonProperty("ids")
   public IdsVoRequest setIds(final List<Long> ids) {
      this.ids = ids;
      return this;
   }

   @Override
   public String toString() {
      return "IdsVoRequest(ids=" + this.getIds() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof IdsVoRequest)) {
         return false;
      }

      IdsVoRequest other = (IdsVoRequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$ids = this.getIds();
      Object other$ids = other.getIds();
      return this$ids == null ? other$ids == null : this$ids.equals(other$ids);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof IdsVoRequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $ids = this.getIds();
      return result * 59 + ($ids == null ? 43 : $ids.hashCode());
   }
}
