package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "WagesPutStatusDTOParam", description = "")
public class WagesPutStatusDTOParam {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "status", notes = "状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;

   public static WagesPutStatusDTOParam.WagesPutStatusDTOParamBuilder builder() {
      return new WagesPutStatusDTOParam.WagesPutStatusDTOParamBuilder();
   }

   public WagesPutStatusDTOParam(final Long id, final Integer status) {
      this.id = id;
      this.status = status;
   }

   public WagesPutStatusDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getStatus() {
      return this.status;
   }

   @JsonProperty("id")
   public WagesPutStatusDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("status")
   public WagesPutStatusDTOParam setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "WagesPutStatusDTOParam(id=" + this.getId() + ", status=" + this.getStatus() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof WagesPutStatusDTOParam)) {
         return false;
      } else {
         WagesPutStatusDTOParam other = (WagesPutStatusDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               return this$status == null ? other$status == null : this$status.equals(other$status);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WagesPutStatusDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      return result * 59 + ($status == null ? 43 : $status.hashCode());
   }

   public static class WagesPutStatusDTOParamBuilder {
      private Long id;
      private Integer status;

      WagesPutStatusDTOParamBuilder() {
      }

      @JsonProperty("id")
      public WagesPutStatusDTOParam.WagesPutStatusDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("status")
      public WagesPutStatusDTOParam.WagesPutStatusDTOParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public WagesPutStatusDTOParam build() {
         return new WagesPutStatusDTOParam(this.id, this.status);
      }

      @Override
      public String toString() {
         return "WagesPutStatusDTOParam.WagesPutStatusDTOParamBuilder(id=" + this.id + ", status=" + this.status + ")";
      }
   }
}
