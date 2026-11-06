package com.hzchum.scim.rest.pojo.vo.mes.building.request.wages.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "OutStaffPutRequest", description = "")
public class OutStaffStatusPutRequest {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "status", notes = "status")
   @JsonProperty("status")
   @JSONField(name = "status")
   @NotNull(message = "status不能为空")
   private Integer status;

   public static OutStaffStatusPutRequest.OutStaffStatusPutRequestBuilder builder() {
      return new OutStaffStatusPutRequest.OutStaffStatusPutRequestBuilder();
   }

   public OutStaffStatusPutRequest(final Long id, final Integer status) {
      this.id = id;
      this.status = status;
   }

   public OutStaffStatusPutRequest() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getStatus() {
      return this.status;
   }

   @JsonProperty("id")
   public OutStaffStatusPutRequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("status")
   public OutStaffStatusPutRequest setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "OutStaffStatusPutRequest(id=" + this.getId() + ", status=" + this.getStatus() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof OutStaffStatusPutRequest)) {
         return false;
      } else {
         OutStaffStatusPutRequest other = (OutStaffStatusPutRequest)o;
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
      return other instanceof OutStaffStatusPutRequest;
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

   public static class OutStaffStatusPutRequestBuilder {
      private Long id;
      private Integer status;

      OutStaffStatusPutRequestBuilder() {
      }

      @JsonProperty("id")
      public OutStaffStatusPutRequest.OutStaffStatusPutRequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("status")
      public OutStaffStatusPutRequest.OutStaffStatusPutRequestBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public OutStaffStatusPutRequest build() {
         return new OutStaffStatusPutRequest(this.id, this.status);
      }

      @Override
      public String toString() {
         return "OutStaffStatusPutRequest.OutStaffStatusPutRequestBuilder(id=" + this.id + ", status=" + this.status + ")";
      }
   }
}
