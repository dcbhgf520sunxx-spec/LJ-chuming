package com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingPartCheckDrillVORequest", description = "零件验证排产请求类")
public class MesBuildingPartCheckDrillVORequest {
   @ApiModelProperty(name = "id", value = "零件id", notes = "零件id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty("厚度")
   private String thick;

   public static MesBuildingPartCheckDrillVORequest.MesBuildingPartCheckDrillVORequestBuilder builder() {
      return new MesBuildingPartCheckDrillVORequest.MesBuildingPartCheckDrillVORequestBuilder();
   }

   public MesBuildingPartCheckDrillVORequest(final Long id, final Integer quantity, final String thick) {
      this.id = id;
      this.quantity = quantity;
      this.thick = thick;
   }

   public MesBuildingPartCheckDrillVORequest() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getThick() {
      return this.thick;
   }

   @JsonProperty("id")
   public MesBuildingPartCheckDrillVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingPartCheckDrillVORequest setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MesBuildingPartCheckDrillVORequest setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPartCheckDrillVORequest)) {
         return false;
      }

      MesBuildingPartCheckDrillVORequest other = (MesBuildingPartCheckDrillVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$thick = this.getThick();
            Object other$thick = other.getThick();
            return this$thick == null ? other$thick == null : this$thick.equals(other$thick);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPartCheckDrillVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $thick = this.getThick();
      return result * 59 + ($thick == null ? 43 : $thick.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingPartCheckDrillVORequest(id=" + this.getId() + ", quantity=" + this.getQuantity() + ", thick=" + this.getThick() + ")";
   }

   public static class MesBuildingPartCheckDrillVORequestBuilder {
      private Long id;
      private Integer quantity;
      private String thick;

      MesBuildingPartCheckDrillVORequestBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingPartCheckDrillVORequest.MesBuildingPartCheckDrillVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingPartCheckDrillVORequest.MesBuildingPartCheckDrillVORequestBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingPartCheckDrillVORequest.MesBuildingPartCheckDrillVORequestBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      public MesBuildingPartCheckDrillVORequest build() {
         return new MesBuildingPartCheckDrillVORequest(this.id, this.quantity, this.thick);
      }

      @Override
      public String toString() {
         return "MesBuildingPartCheckDrillVORequest.MesBuildingPartCheckDrillVORequestBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", thick="
            + this.thick
            + ")";
      }
   }
}
