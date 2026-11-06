package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ArtifactGroupsDetailsDTO", description = "构件信息和分组数量")
public class ArtifactGroupsDetailsDTO {
   @ApiModelProperty(name = "artifactId", notes = "构件id")
   @JsonProperty("artifactId")
   @JSONField(name = "artifactId")
   private Long artifactId;
   @ApiModelProperty(name = "quantity", value = "组立分配数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   protected ArtifactGroupsDetailsDTO(final ArtifactGroupsDetailsDTO.ArtifactGroupsDetailsDTOBuilder<?, ?> b) {
      this.artifactId = b.artifactId;
      this.quantity = b.quantity;
   }

   public static ArtifactGroupsDetailsDTO.ArtifactGroupsDetailsDTOBuilder<?, ?> builder() {
      return new ArtifactGroupsDetailsDTO.ArtifactGroupsDetailsDTOBuilderImpl();
   }

   public ArtifactGroupsDetailsDTO() {
   }

   public ArtifactGroupsDetailsDTO(final Long artifactId, final Integer quantity) {
      this.artifactId = artifactId;
      this.quantity = quantity;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("artifactId")
   public ArtifactGroupsDetailsDTO setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   @JsonProperty("quantity")
   public ArtifactGroupsDetailsDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactGroupsDetailsDTO(artifactId=" + this.getArtifactId() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ArtifactGroupsDetailsDTO)) {
         return false;
      } else {
         ArtifactGroupsDetailsDTO other = (ArtifactGroupsDetailsDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$artifactId = this.getArtifactId();
            Object other$artifactId = other.getArtifactId();
            if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
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
      return other instanceof ArtifactGroupsDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public abstract static class ArtifactGroupsDetailsDTOBuilder<C extends ArtifactGroupsDetailsDTO, B extends ArtifactGroupsDetailsDTO.ArtifactGroupsDetailsDTOBuilder<C, B>> {
      private Long artifactId;
      private Integer quantity;

      protected abstract B self();

      public abstract C build();

      @JsonProperty("artifactId")
      public B artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this.self();
      }

      @JsonProperty("quantity")
      public B quantity(final Integer quantity) {
         this.quantity = quantity;
         return this.self();
      }

      @Override
      public String toString() {
         return "ArtifactGroupsDetailsDTO.ArtifactGroupsDetailsDTOBuilder(artifactId=" + this.artifactId + ", quantity=" + this.quantity + ")";
      }
   }

   private static final class ArtifactGroupsDetailsDTOBuilderImpl
      extends ArtifactGroupsDetailsDTO.ArtifactGroupsDetailsDTOBuilder<ArtifactGroupsDetailsDTO, ArtifactGroupsDetailsDTO.ArtifactGroupsDetailsDTOBuilderImpl> {
      private ArtifactGroupsDetailsDTOBuilderImpl() {
      }

      protected ArtifactGroupsDetailsDTO.ArtifactGroupsDetailsDTOBuilderImpl self() {
         return this;
      }

      @Override
      public ArtifactGroupsDetailsDTO build() {
         return new ArtifactGroupsDetailsDTO(this);
      }
   }
}
