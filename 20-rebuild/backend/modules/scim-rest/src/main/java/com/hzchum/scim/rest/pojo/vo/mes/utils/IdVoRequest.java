package com.hzchum.scim.rest.pojo.vo.mes.utils;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "id对象", description = "")
public class IdVoRequest {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;

   public Long getId() {
      return this.id;
   }

   @JsonProperty("id")
   public IdVoRequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @Override
   public String toString() {
      return "IdVoRequest(id=" + this.getId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof IdVoRequest)) {
         return false;
      }

      IdVoRequest other = (IdVoRequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      return this$id == null ? other$id == null : this$id.equals(other$id);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof IdVoRequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      return result * 59 + ($id == null ? 43 : $id.hashCode());
   }
}
