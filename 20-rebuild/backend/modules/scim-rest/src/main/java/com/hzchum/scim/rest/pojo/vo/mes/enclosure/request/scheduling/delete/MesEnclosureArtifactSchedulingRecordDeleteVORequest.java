package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.scheduling.delete;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureArtifactSchedulingRecordDeleteVORequest", description = "构件排产删除请求类")
public class MesEnclosureArtifactSchedulingRecordDeleteVORequest {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "quantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @NotNull(message = "排产数量不能为空")
   @Min(value = 1L, message = "排产数量不能小于1")
   private Integer quantity;

   MesEnclosureArtifactSchedulingRecordDeleteVORequest(final Long id, final Integer quantity) {
      this.id = id;
      this.quantity = quantity;
   }

   public static MesEnclosureArtifactSchedulingRecordDeleteVORequest.MesEnclosureArtifactSchedulingRecordDeleteVORequestBuilder builder() {
      return new MesEnclosureArtifactSchedulingRecordDeleteVORequest.MesEnclosureArtifactSchedulingRecordDeleteVORequestBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("id")
   public MesEnclosureArtifactSchedulingRecordDeleteVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureArtifactSchedulingRecordDeleteVORequest setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesEnclosureArtifactSchedulingRecordDeleteVORequest)) {
         return false;
      } else {
         MesEnclosureArtifactSchedulingRecordDeleteVORequest other = (MesEnclosureArtifactSchedulingRecordDeleteVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureArtifactSchedulingRecordDeleteVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureArtifactSchedulingRecordDeleteVORequest(id=" + this.getId() + ", quantity=" + this.getQuantity() + ")";
   }

   public static class MesEnclosureArtifactSchedulingRecordDeleteVORequestBuilder {
      private Long id;
      private Integer quantity;

      MesEnclosureArtifactSchedulingRecordDeleteVORequestBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureArtifactSchedulingRecordDeleteVORequest.MesEnclosureArtifactSchedulingRecordDeleteVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureArtifactSchedulingRecordDeleteVORequest.MesEnclosureArtifactSchedulingRecordDeleteVORequestBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesEnclosureArtifactSchedulingRecordDeleteVORequest build() {
         return new MesEnclosureArtifactSchedulingRecordDeleteVORequest(this.id, this.quantity);
      }

      @Override
      public String toString() {
         return "MesEnclosureArtifactSchedulingRecordDeleteVORequest.MesEnclosureArtifactSchedulingRecordDeleteVORequestBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
