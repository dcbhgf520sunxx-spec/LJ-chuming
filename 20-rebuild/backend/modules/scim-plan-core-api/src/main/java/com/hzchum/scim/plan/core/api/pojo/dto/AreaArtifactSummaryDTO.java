package com.hzchum.scim.plan.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AreaArtifactSummaryDTO", description = "区域下构件汇总信息")
public class AreaArtifactSummaryDTO {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public static AreaArtifactSummaryDTO.AreaArtifactSummaryDTOBuilder builder() {
      return new AreaArtifactSummaryDTO.AreaArtifactSummaryDTOBuilder();
   }

   public AreaArtifactSummaryDTO() {
   }

   public AreaArtifactSummaryDTO(final Long id, final String name, final Integer quantity) {
      this.id = id;
      this.name = name;
      this.quantity = quantity;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("id")
   public AreaArtifactSummaryDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public AreaArtifactSummaryDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("quantity")
   public AreaArtifactSummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "AreaArtifactSummaryDTO(id=" + this.getId() + ", name=" + this.getName() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AreaArtifactSummaryDTO)) {
         return false;
      }

      AreaArtifactSummaryDTO other = (AreaArtifactSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AreaArtifactSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class AreaArtifactSummaryDTOBuilder {
      private Long id;
      private String name;
      private Integer quantity;

      AreaArtifactSummaryDTOBuilder() {
      }

      @JsonProperty("id")
      public AreaArtifactSummaryDTO.AreaArtifactSummaryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public AreaArtifactSummaryDTO.AreaArtifactSummaryDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("quantity")
      public AreaArtifactSummaryDTO.AreaArtifactSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public AreaArtifactSummaryDTO build() {
         return new AreaArtifactSummaryDTO(this.id, this.name, this.quantity);
      }

      @Override
      public String toString() {
         return "AreaArtifactSummaryDTO.AreaArtifactSummaryDTOBuilder(id=" + this.id + ", name=" + this.name + ", quantity=" + this.quantity + ")";
      }
   }
}
