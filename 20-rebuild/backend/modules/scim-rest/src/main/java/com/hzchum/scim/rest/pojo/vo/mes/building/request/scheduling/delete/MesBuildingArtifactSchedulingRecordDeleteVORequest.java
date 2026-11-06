package com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.delete;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingArtifactSchedulingRecordDeleteVORequest", description = "构件排产删除请求类")
public class MesBuildingArtifactSchedulingRecordDeleteVORequest {
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

   public static MesBuildingArtifactSchedulingRecordDeleteVORequest.MesBuildingArtifactSchedulingRecordDeleteVORequestBuilder builder() {
      return new MesBuildingArtifactSchedulingRecordDeleteVORequest.MesBuildingArtifactSchedulingRecordDeleteVORequestBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("id")
   public MesBuildingArtifactSchedulingRecordDeleteVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingArtifactSchedulingRecordDeleteVORequest setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingArtifactSchedulingRecordDeleteVORequest)) {
         return false;
      } else {
         MesBuildingArtifactSchedulingRecordDeleteVORequest other = (MesBuildingArtifactSchedulingRecordDeleteVORequest)o;
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
      return other instanceof MesBuildingArtifactSchedulingRecordDeleteVORequest;
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
      return "MesBuildingArtifactSchedulingRecordDeleteVORequest(id=" + this.getId() + ", quantity=" + this.getQuantity() + ")";
   }

   public MesBuildingArtifactSchedulingRecordDeleteVORequest(final Long id, final Integer quantity) {
      this.id = id;
      this.quantity = quantity;
   }

   public MesBuildingArtifactSchedulingRecordDeleteVORequest() {
   }

   public static class MesBuildingArtifactSchedulingRecordDeleteVORequestBuilder {
      private Long id;
      private Integer quantity;

      MesBuildingArtifactSchedulingRecordDeleteVORequestBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingArtifactSchedulingRecordDeleteVORequest.MesBuildingArtifactSchedulingRecordDeleteVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingArtifactSchedulingRecordDeleteVORequest.MesBuildingArtifactSchedulingRecordDeleteVORequestBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingArtifactSchedulingRecordDeleteVORequest build() {
         return new MesBuildingArtifactSchedulingRecordDeleteVORequest(this.id, this.quantity);
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactSchedulingRecordDeleteVORequest.MesBuildingArtifactSchedulingRecordDeleteVORequestBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
