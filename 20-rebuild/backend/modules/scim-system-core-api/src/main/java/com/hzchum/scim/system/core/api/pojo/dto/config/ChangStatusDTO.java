package com.hzchum.scim.system.core.api.pojo.dto.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class ChangStatusDTO {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "status", value = "状态  0 未冻结 1 冻结", notes = "状态  0 未冻结 1 冻结")
   @JsonProperty("status")
   @JSONField(name = "status")
   @NotNull(message = "status不能为空")
   private Boolean status;

   public static ChangStatusDTO.ChangStatusDTOBuilder builder() {
      return new ChangStatusDTO.ChangStatusDTOBuilder();
   }

   public ChangStatusDTO() {
   }

   public ChangStatusDTO(final Long id, final Boolean status) {
      this.id = id;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getStatus() {
      return this.status;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("status")
   public void setStatus(final Boolean status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ChangStatusDTO)) {
         return false;
      } else {
         ChangStatusDTO other = (ChangStatusDTO)o;
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
      return other instanceof ChangStatusDTO;
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

   @Override
   public String toString() {
      return "ChangStatusDTO(id=" + this.getId() + ", status=" + this.getStatus() + ")";
   }

   public static class ChangStatusDTOBuilder {
      private Long id;
      private Boolean status;

      ChangStatusDTOBuilder() {
      }

      @JsonProperty("id")
      public ChangStatusDTO.ChangStatusDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("status")
      public ChangStatusDTO.ChangStatusDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public ChangStatusDTO build() {
         return new ChangStatusDTO(this.id, this.status);
      }

      @Override
      public String toString() {
         return "ChangStatusDTO.ChangStatusDTOBuilder(id=" + this.id + ", status=" + this.status + ")";
      }
   }
}
