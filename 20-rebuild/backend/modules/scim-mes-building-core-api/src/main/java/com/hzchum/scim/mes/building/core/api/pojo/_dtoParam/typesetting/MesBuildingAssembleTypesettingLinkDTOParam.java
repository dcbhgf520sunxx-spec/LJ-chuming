package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.typesetting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingAssembleTypesettingLinkDTOParam对象", description = "")
public class MesBuildingAssembleTypesettingLinkDTOParam {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "assembleTypesettingId", value = "母件id", notes = "母件id")
   @JsonProperty("assembleTypesettingId")
   @JSONField(name = "assembleTypesettingId")
   private Long assembleTypesettingId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "sequence", value = "顺序", notes = "顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   private Integer sequence;

   public static MesBuildingAssembleTypesettingLinkDTOParam.MesBuildingAssembleTypesettingLinkDTOParamBuilder builder() {
      return new MesBuildingAssembleTypesettingLinkDTOParam.MesBuildingAssembleTypesettingLinkDTOParamBuilder();
   }

   public MesBuildingAssembleTypesettingLinkDTOParam() {
   }

   public MesBuildingAssembleTypesettingLinkDTOParam(final Long id, final Long assembleTypesettingId, final Long productId, final Integer sequence) {
      this.id = id;
      this.assembleTypesettingId = assembleTypesettingId;
      this.productId = productId;
      this.sequence = sequence;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAssembleTypesettingId() {
      return this.assembleTypesettingId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   @JsonProperty("id")
   public MesBuildingAssembleTypesettingLinkDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("assembleTypesettingId")
   public MesBuildingAssembleTypesettingLinkDTOParam setAssembleTypesettingId(final Long assembleTypesettingId) {
      this.assembleTypesettingId = assembleTypesettingId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingAssembleTypesettingLinkDTOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingAssembleTypesettingLinkDTOParam setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssembleTypesettingLinkDTOParam)) {
         return false;
      }

      MesBuildingAssembleTypesettingLinkDTOParam other = (MesBuildingAssembleTypesettingLinkDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assembleTypesettingId = this.getAssembleTypesettingId();
         Object other$assembleTypesettingId = other.getAssembleTypesettingId();
         if (this$assembleTypesettingId == null ? other$assembleTypesettingId == null : this$assembleTypesettingId.equals(other$assembleTypesettingId)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$sequence = this.getSequence();
               Object other$sequence = other.getSequence();
               return this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence);
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
      return other instanceof MesBuildingAssembleTypesettingLinkDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assembleTypesettingId = this.getAssembleTypesettingId();
      result = result * 59 + ($assembleTypesettingId == null ? 43 : $assembleTypesettingId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $sequence = this.getSequence();
      return result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleTypesettingLinkDTOParam(id="
         + this.getId()
         + ", assembleTypesettingId="
         + this.getAssembleTypesettingId()
         + ", productId="
         + this.getProductId()
         + ", sequence="
         + this.getSequence()
         + ")";
   }

   public static class MesBuildingAssembleTypesettingLinkDTOParamBuilder {
      private Long id;
      private Long assembleTypesettingId;
      private Long productId;
      private Integer sequence;

      MesBuildingAssembleTypesettingLinkDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingAssembleTypesettingLinkDTOParam.MesBuildingAssembleTypesettingLinkDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("assembleTypesettingId")
      public MesBuildingAssembleTypesettingLinkDTOParam.MesBuildingAssembleTypesettingLinkDTOParamBuilder assembleTypesettingId(
         final Long assembleTypesettingId
      ) {
         this.assembleTypesettingId = assembleTypesettingId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingAssembleTypesettingLinkDTOParam.MesBuildingAssembleTypesettingLinkDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingAssembleTypesettingLinkDTOParam.MesBuildingAssembleTypesettingLinkDTOParamBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      public MesBuildingAssembleTypesettingLinkDTOParam build() {
         return new MesBuildingAssembleTypesettingLinkDTOParam(this.id, this.assembleTypesettingId, this.productId, this.sequence);
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleTypesettingLinkDTOParam.MesBuildingAssembleTypesettingLinkDTOParamBuilder(id="
            + this.id
            + ", assembleTypesettingId="
            + this.assembleTypesettingId
            + ", productId="
            + this.productId
            + ", sequence="
            + this.sequence
            + ")";
      }
   }
}
