package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel(value = "MesBuildingSteelFeedingDTO", description = "钢水投料DTO")
public class MesBuildingSteelFeedingDTO {
   @ApiModelProperty(name = "type", notes = "出入库类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "stuffType", notes = "产品类型")
   @JsonProperty("stuffType")
   @JSONField(name = "stuffType")
   private Integer stuffType;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalWeight", notes = "总重量")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "feedingTime", notes = "投料时间")
   @JsonProperty("feedingTime")
   @JSONField(name = "feedingTime")
   private LocalDate feedingTime;
   @ApiModelProperty(name = "feedingUser", notes = "投料人")
   @JsonProperty("feedingUser")
   @JSONField(name = "feedingUser")
   private String feedingUser;

   public static MesBuildingSteelFeedingDTO.MesBuildingSteelFeedingDTOBuilder builder() {
      return new MesBuildingSteelFeedingDTO.MesBuildingSteelFeedingDTOBuilder();
   }

   public MesBuildingSteelFeedingDTO() {
   }

   public MesBuildingSteelFeedingDTO(
      final Integer type,
      final Integer stuffType,
      final String specification,
      final String material,
      final Integer quantity,
      final BigDecimal totalWeight,
      final LocalDate feedingTime,
      final String feedingUser
   ) {
      this.type = type;
      this.stuffType = stuffType;
      this.specification = specification;
      this.material = material;
      this.quantity = quantity;
      this.totalWeight = totalWeight;
      this.feedingTime = feedingTime;
      this.feedingUser = feedingUser;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getStuffType() {
      return this.stuffType;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public LocalDate getFeedingTime() {
      return this.feedingTime;
   }

   public String getFeedingUser() {
      return this.feedingUser;
   }

   @JsonProperty("type")
   public MesBuildingSteelFeedingDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("stuffType")
   public MesBuildingSteelFeedingDTO setStuffType(final Integer stuffType) {
      this.stuffType = stuffType;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingSteelFeedingDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingSteelFeedingDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingSteelFeedingDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalWeight")
   public MesBuildingSteelFeedingDTO setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @JsonProperty("feedingTime")
   public MesBuildingSteelFeedingDTO setFeedingTime(final LocalDate feedingTime) {
      this.feedingTime = feedingTime;
      return this;
   }

   @JsonProperty("feedingUser")
   public MesBuildingSteelFeedingDTO setFeedingUser(final String feedingUser) {
      this.feedingUser = feedingUser;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSteelFeedingDTO)) {
         return false;
      }

      MesBuildingSteelFeedingDTO other = (MesBuildingSteelFeedingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$stuffType = this.getStuffType();
         Object other$stuffType = other.getStuffType();
         if (this$stuffType == null ? other$stuffType == null : this$stuffType.equals(other$stuffType)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$material = this.getMaterial();
                  Object other$material = other.getMaterial();
                  if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                     Object this$totalWeight = this.getTotalWeight();
                     Object other$totalWeight = other.getTotalWeight();
                     if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                        Object this$feedingTime = this.getFeedingTime();
                        Object other$feedingTime = other.getFeedingTime();
                        if (this$feedingTime == null ? other$feedingTime == null : this$feedingTime.equals(other$feedingTime)) {
                           Object this$feedingUser = this.getFeedingUser();
                           Object other$feedingUser = other.getFeedingUser();
                           return this$feedingUser == null ? other$feedingUser == null : this$feedingUser.equals(other$feedingUser);
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesBuildingSteelFeedingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $stuffType = this.getStuffType();
      result = result * 59 + ($stuffType == null ? 43 : $stuffType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $feedingTime = this.getFeedingTime();
      result = result * 59 + ($feedingTime == null ? 43 : $feedingTime.hashCode());
      Object $feedingUser = this.getFeedingUser();
      return result * 59 + ($feedingUser == null ? 43 : $feedingUser.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingSteelFeedingDTO(type="
         + this.getType()
         + ", stuffType="
         + this.getStuffType()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", feedingTime="
         + this.getFeedingTime()
         + ", feedingUser="
         + this.getFeedingUser()
         + ")";
   }

   public static class MesBuildingSteelFeedingDTOBuilder {
      private Integer type;
      private Integer stuffType;
      private String specification;
      private String material;
      private Integer quantity;
      private BigDecimal totalWeight;
      private LocalDate feedingTime;
      private String feedingUser;

      MesBuildingSteelFeedingDTOBuilder() {
      }

      @JsonProperty("type")
      public MesBuildingSteelFeedingDTO.MesBuildingSteelFeedingDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("stuffType")
      public MesBuildingSteelFeedingDTO.MesBuildingSteelFeedingDTOBuilder stuffType(final Integer stuffType) {
         this.stuffType = stuffType;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingSteelFeedingDTO.MesBuildingSteelFeedingDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingSteelFeedingDTO.MesBuildingSteelFeedingDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingSteelFeedingDTO.MesBuildingSteelFeedingDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalWeight")
      public MesBuildingSteelFeedingDTO.MesBuildingSteelFeedingDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("feedingTime")
      public MesBuildingSteelFeedingDTO.MesBuildingSteelFeedingDTOBuilder feedingTime(final LocalDate feedingTime) {
         this.feedingTime = feedingTime;
         return this;
      }

      @JsonProperty("feedingUser")
      public MesBuildingSteelFeedingDTO.MesBuildingSteelFeedingDTOBuilder feedingUser(final String feedingUser) {
         this.feedingUser = feedingUser;
         return this;
      }

      public MesBuildingSteelFeedingDTO build() {
         return new MesBuildingSteelFeedingDTO(
            this.type, this.stuffType, this.specification, this.material, this.quantity, this.totalWeight, this.feedingTime, this.feedingUser
         );
      }

      @Override
      public String toString() {
         return "MesBuildingSteelFeedingDTO.MesBuildingSteelFeedingDTOBuilder(type="
            + this.type
            + ", stuffType="
            + this.stuffType
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", totalWeight="
            + this.totalWeight
            + ", feedingTime="
            + this.feedingTime
            + ", feedingUser="
            + this.feedingUser
            + ")";
      }
   }
}
