package com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingArtifactSchedulingAsssembleVORequest", description = "构件排产删除请求类")
public class MesBuildingArtifactSchedulingAsssembleVORequest {
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

   public static MesBuildingArtifactSchedulingAsssembleVORequest.MesBuildingArtifactSchedulingAsssembleVORequestBuilder builder() {
      return new MesBuildingArtifactSchedulingAsssembleVORequest.MesBuildingArtifactSchedulingAsssembleVORequestBuilder();
   }

   public MesBuildingArtifactSchedulingAsssembleVORequest(final Long id, final Integer quantity) {
      this.id = id;
      this.quantity = quantity;
   }

   public MesBuildingArtifactSchedulingAsssembleVORequest() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("id")
   public MesBuildingArtifactSchedulingAsssembleVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingArtifactSchedulingAsssembleVORequest setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingArtifactSchedulingAsssembleVORequest)) {
         return false;
      } else {
         MesBuildingArtifactSchedulingAsssembleVORequest other = (MesBuildingArtifactSchedulingAsssembleVORequest)o;
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
      return other instanceof MesBuildingArtifactSchedulingAsssembleVORequest;
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
      return "MesBuildingArtifactSchedulingAsssembleVORequest(id=" + this.getId() + ", quantity=" + this.getQuantity() + ")";
   }

   public static class MesBuildingArtifactSchedulingAsssembleVORequestBuilder {
      private Long id;
      private Integer quantity;

      MesBuildingArtifactSchedulingAsssembleVORequestBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingArtifactSchedulingAsssembleVORequest.MesBuildingArtifactSchedulingAsssembleVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingArtifactSchedulingAsssembleVORequest.MesBuildingArtifactSchedulingAsssembleVORequestBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingArtifactSchedulingAsssembleVORequest build() {
         return new MesBuildingArtifactSchedulingAsssembleVORequest(this.id, this.quantity);
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactSchedulingAsssembleVORequest.MesBuildingArtifactSchedulingAsssembleVORequestBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
