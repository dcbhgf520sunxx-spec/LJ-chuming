package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.workShop.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "WorkshopStatusUpdateVORequest", description = "")
public class WorkshopStatusUpdateVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "boolEnabledEnum", notes = "禁用状态 启用状态 [0 禁用, 1 启用]", value = "禁用状态 启用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   @NotNull(message = "禁用状态不能为空")
   private Boolean boolEnabledEnum;

   public static WorkshopStatusUpdateVORequest.WorkshopStatusUpdateVORequestBuilder builder() {
      return new WorkshopStatusUpdateVORequest.WorkshopStatusUpdateVORequestBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   @JsonProperty("id")
   public WorkshopStatusUpdateVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public WorkshopStatusUpdateVORequest setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @Override
   public String toString() {
      return "WorkshopStatusUpdateVORequest(id=" + this.getId() + ", boolEnabledEnum=" + this.getBoolEnabledEnum() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof WorkshopStatusUpdateVORequest)) {
         return false;
      } else {
         WorkshopStatusUpdateVORequest other = (WorkshopStatusUpdateVORequest)o;
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
      return other instanceof WorkshopStatusUpdateVORequest;
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

   public WorkshopStatusUpdateVORequest(final Long id, final Boolean boolEnabledEnum) {
      this.id = id;
      this.boolEnabledEnum = boolEnabledEnum;
   }

   public WorkshopStatusUpdateVORequest() {
   }

   public static class WorkshopStatusUpdateVORequestBuilder {
      private Long id;
      private Boolean boolEnabledEnum;

      WorkshopStatusUpdateVORequestBuilder() {
      }

      @JsonProperty("id")
      public WorkshopStatusUpdateVORequest.WorkshopStatusUpdateVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public WorkshopStatusUpdateVORequest.WorkshopStatusUpdateVORequestBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      public WorkshopStatusUpdateVORequest build() {
         return new WorkshopStatusUpdateVORequest(this.id, this.boolEnabledEnum);
      }

      @Override
      public String toString() {
         return "WorkshopStatusUpdateVORequest.WorkshopStatusUpdateVORequestBuilder(id=" + this.id + ", boolEnabledEnum=" + this.boolEnabledEnum + ")";
      }
   }
}
