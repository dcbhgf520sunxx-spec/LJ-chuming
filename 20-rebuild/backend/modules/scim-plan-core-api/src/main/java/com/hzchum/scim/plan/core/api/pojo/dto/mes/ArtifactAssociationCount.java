package com.hzchum.scim.plan.core.api.pojo.dto.mes;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ArtifactAssociationCount", description = "")
public class ArtifactAssociationCount {
   @ApiModelProperty(name = "artifactId", notes = "部件ID")
   @JsonProperty("artifactId")
   @JSONField(name = "artifactId")
   @JsonInclude(Include.NON_NULL)
   private Long artifactId;
   @ApiModelProperty(name = "asseOrPartId", notes = "部件ID或零件")
   @JsonProperty("asseOrPartId")
   @JSONField(name = "asseOrPartId")
   private Integer asseOrPartId;
   @ApiModelProperty(name = "quantity", notes = "比例数")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "unusedQuantity", notes = "未使用数")
   @JsonProperty("unusedQuantity")
   @JSONField(name = "unusedQuantity")
   private Integer unusedQuantity;

   public static ArtifactAssociationCount.ArtifactAssociationCountBuilder builder() {
      return new ArtifactAssociationCount.ArtifactAssociationCountBuilder();
   }

   public ArtifactAssociationCount() {
   }

   public ArtifactAssociationCount(final Long artifactId, final Integer asseOrPartId, final Integer quantity, final Integer unusedQuantity) {
      this.artifactId = artifactId;
      this.asseOrPartId = asseOrPartId;
      this.quantity = quantity;
      this.unusedQuantity = unusedQuantity;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Integer getAsseOrPartId() {
      return this.asseOrPartId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getUnusedQuantity() {
      return this.unusedQuantity;
   }

   @JsonProperty("artifactId")
   public ArtifactAssociationCount setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   @JsonProperty("asseOrPartId")
   public ArtifactAssociationCount setAsseOrPartId(final Integer asseOrPartId) {
      this.asseOrPartId = asseOrPartId;
      return this;
   }

   @JsonProperty("quantity")
   public ArtifactAssociationCount setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("unusedQuantity")
   public ArtifactAssociationCount setUnusedQuantity(final Integer unusedQuantity) {
      this.unusedQuantity = unusedQuantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactAssociationCount)) {
         return false;
      }

      ArtifactAssociationCount other = (ArtifactAssociationCount)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactId = this.getArtifactId();
      Object other$artifactId = other.getArtifactId();
      if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
         Object this$asseOrPartId = this.getAsseOrPartId();
         Object other$asseOrPartId = other.getAsseOrPartId();
         if (this$asseOrPartId == null ? other$asseOrPartId == null : this$asseOrPartId.equals(other$asseOrPartId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$unusedQuantity = this.getUnusedQuantity();
               Object other$unusedQuantity = other.getUnusedQuantity();
               return this$unusedQuantity == null ? other$unusedQuantity == null : this$unusedQuantity.equals(other$unusedQuantity);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactAssociationCount;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $asseOrPartId = this.getAsseOrPartId();
      result = result * 59 + ($asseOrPartId == null ? 43 : $asseOrPartId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $unusedQuantity = this.getUnusedQuantity();
      return result * 59 + ($unusedQuantity == null ? 43 : $unusedQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactAssociationCount(artifactId="
         + this.getArtifactId()
         + ", asseOrPartId="
         + this.getAsseOrPartId()
         + ", quantity="
         + this.getQuantity()
         + ", unusedQuantity="
         + this.getUnusedQuantity()
         + ")";
   }

   public static class ArtifactAssociationCountBuilder {
      private Long artifactId;
      private Integer asseOrPartId;
      private Integer quantity;
      private Integer unusedQuantity;

      ArtifactAssociationCountBuilder() {
      }

      @JsonProperty("artifactId")
      public ArtifactAssociationCount.ArtifactAssociationCountBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      @JsonProperty("asseOrPartId")
      public ArtifactAssociationCount.ArtifactAssociationCountBuilder asseOrPartId(final Integer asseOrPartId) {
         this.asseOrPartId = asseOrPartId;
         return this;
      }

      @JsonProperty("quantity")
      public ArtifactAssociationCount.ArtifactAssociationCountBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("unusedQuantity")
      public ArtifactAssociationCount.ArtifactAssociationCountBuilder unusedQuantity(final Integer unusedQuantity) {
         this.unusedQuantity = unusedQuantity;
         return this;
      }

      public ArtifactAssociationCount build() {
         return new ArtifactAssociationCount(this.artifactId, this.asseOrPartId, this.quantity, this.unusedQuantity);
      }

      @Override
      public String toString() {
         return "ArtifactAssociationCount.ArtifactAssociationCountBuilder(artifactId="
            + this.artifactId
            + ", asseOrPartId="
            + this.asseOrPartId
            + ", quantity="
            + this.quantity
            + ", unusedQuantity="
            + this.unusedQuantity
            + ")";
      }
   }
}
