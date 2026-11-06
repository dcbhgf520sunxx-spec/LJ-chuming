package com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.factory.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "FactoryStatusUpdateVORequest", description = "工厂状态请求类")
public class FactoryUpdateStatusVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "boolEnabledEnum", notes = "启用状态 [0 禁用, 1 启用]", value = "启用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   @NotNull(message = "状态不能为空")
   private Boolean boolEnabledEnum;

   public static FactoryUpdateStatusVORequest.FactoryUpdateStatusVORequestBuilder builder() {
      return new FactoryUpdateStatusVORequest.FactoryUpdateStatusVORequestBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   @JsonProperty("id")
   public FactoryUpdateStatusVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public FactoryUpdateStatusVORequest setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @Override
   public String toString() {
      return "FactoryUpdateStatusVORequest(id=" + this.getId() + ", boolEnabledEnum=" + this.getBoolEnabledEnum() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof FactoryUpdateStatusVORequest)) {
         return false;
      } else {
         FactoryUpdateStatusVORequest other = (FactoryUpdateStatusVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$boolEnabledEnum = this.getBoolEnabledEnum();
               Object other$boolEnabledEnum = other.getBoolEnabledEnum();
               return this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof FactoryUpdateStatusVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      return result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
   }

   public FactoryUpdateStatusVORequest(final Long id, final Boolean boolEnabledEnum) {
      this.id = id;
      this.boolEnabledEnum = boolEnabledEnum;
   }

   public FactoryUpdateStatusVORequest() {
   }

   public static class FactoryUpdateStatusVORequestBuilder {
      private Long id;
      private Boolean boolEnabledEnum;

      FactoryUpdateStatusVORequestBuilder() {
      }

      @JsonProperty("id")
      public FactoryUpdateStatusVORequest.FactoryUpdateStatusVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public FactoryUpdateStatusVORequest.FactoryUpdateStatusVORequestBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      public FactoryUpdateStatusVORequest build() {
         return new FactoryUpdateStatusVORequest(this.id, this.boolEnabledEnum);
      }

      @Override
      public String toString() {
         return "FactoryUpdateStatusVORequest.FactoryUpdateStatusVORequestBuilder(id=" + this.id + ", boolEnabledEnum=" + this.boolEnabledEnum + ")";
      }
   }
}
