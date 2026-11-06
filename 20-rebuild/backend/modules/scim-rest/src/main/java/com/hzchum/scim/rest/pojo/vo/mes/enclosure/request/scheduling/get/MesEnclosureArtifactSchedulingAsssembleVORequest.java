package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.scheduling.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureArtifactSchedulingAsssembleVORequest", description = "构件排产删除请求类")
public class MesEnclosureArtifactSchedulingAsssembleVORequest {
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

   public static MesEnclosureArtifactSchedulingAsssembleVORequest.MesEnclosureArtifactSchedulingAsssembleVORequestBuilder builder() {
      return new MesEnclosureArtifactSchedulingAsssembleVORequest.MesEnclosureArtifactSchedulingAsssembleVORequestBuilder();
   }

   public MesEnclosureArtifactSchedulingAsssembleVORequest(final Long id, final Integer quantity) {
      this.id = id;
      this.quantity = quantity;
   }

   public MesEnclosureArtifactSchedulingAsssembleVORequest() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("id")
   public MesEnclosureArtifactSchedulingAsssembleVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureArtifactSchedulingAsssembleVORequest setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesEnclosureArtifactSchedulingAsssembleVORequest)) {
         return false;
      } else {
         MesEnclosureArtifactSchedulingAsssembleVORequest other = (MesEnclosureArtifactSchedulingAsssembleVORequest)o;
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
      return other instanceof MesEnclosureArtifactSchedulingAsssembleVORequest;
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
      return "MesEnclosureArtifactSchedulingAsssembleVORequest(id=" + this.getId() + ", quantity=" + this.getQuantity() + ")";
   }

   public static class MesEnclosureArtifactSchedulingAsssembleVORequestBuilder {
      private Long id;
      private Integer quantity;

      MesEnclosureArtifactSchedulingAsssembleVORequestBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureArtifactSchedulingAsssembleVORequest.MesEnclosureArtifactSchedulingAsssembleVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureArtifactSchedulingAsssembleVORequest.MesEnclosureArtifactSchedulingAsssembleVORequestBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesEnclosureArtifactSchedulingAsssembleVORequest build() {
         return new MesEnclosureArtifactSchedulingAsssembleVORequest(this.id, this.quantity);
      }

      @Override
      public String toString() {
         return "MesEnclosureArtifactSchedulingAsssembleVORequest.MesEnclosureArtifactSchedulingAsssembleVORequestBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
