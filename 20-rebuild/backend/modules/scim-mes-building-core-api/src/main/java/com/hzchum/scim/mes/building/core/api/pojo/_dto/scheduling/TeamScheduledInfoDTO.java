package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TeamScheduledInfoDTO", description = "班组已排产信息")
public class TeamScheduledInfoDTO {
   @ApiModelProperty(name = "shopName", notes = "车间名称")
   @JsonProperty("shopName")
   @JSONField(name = "shopName")
   private String shopName;
   @ApiModelProperty(name = "lineName", notes = "产线名称")
   @JsonProperty("lineName")
   @JSONField(name = "lineName")
   private String lineName;
   @ApiModelProperty(name = "leaderName", notes = "班组长名称")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "scheduledQuantity", notes = "已排产数量")
   @JsonProperty("scheduledQuantity")
   @JSONField(name = "scheduledQuantity")
   private Integer scheduledQuantity;
   @ApiModelProperty(name = "scheduledWeight", notes = "已排产重量")
   @JsonProperty("scheduledWeight")
   @JSONField(name = "scheduledWeight")
   private BigDecimal scheduledWeight;
   @ApiModelProperty(name = "unScheduledQuantity", notes = "已排产数量")
   @JsonProperty("unScheduledQuantity")
   @JSONField(name = "unScheduledQuantity")
   private Integer unScheduledQuantity;
   @ApiModelProperty(name = "unScheduledWeight", notes = "已排产重量")
   @JsonProperty("unScheduledWeight")
   @JSONField(name = "unScheduledWeight")
   private BigDecimal unScheduledWeight;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeWeight", notes = "完成重量")
   @JsonProperty("completeWeight")
   @JSONField(name = "completeWeight")
   private BigDecimal completeWeight;

   public static TeamScheduledInfoDTO.TeamScheduledInfoDTOBuilder builder() {
      return new TeamScheduledInfoDTO.TeamScheduledInfoDTOBuilder();
   }

   public TeamScheduledInfoDTO() {
   }

   public TeamScheduledInfoDTO(
      final String shopName,
      final String lineName,
      final String leaderName,
      final Integer scheduledQuantity,
      final BigDecimal scheduledWeight,
      final Integer unScheduledQuantity,
      final BigDecimal unScheduledWeight,
      final Integer completeQuantity,
      final BigDecimal completeWeight
   ) {
      this.shopName = shopName;
      this.lineName = lineName;
      this.leaderName = leaderName;
      this.scheduledQuantity = scheduledQuantity;
      this.scheduledWeight = scheduledWeight;
      this.unScheduledQuantity = unScheduledQuantity;
      this.unScheduledWeight = unScheduledWeight;
      this.completeQuantity = completeQuantity;
      this.completeWeight = completeWeight;
   }

   public String getShopName() {
      return this.shopName;
   }

   public String getLineName() {
      return this.lineName;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   public Integer getScheduledQuantity() {
      return this.scheduledQuantity;
   }

   public BigDecimal getScheduledWeight() {
      return this.scheduledWeight;
   }

   public Integer getUnScheduledQuantity() {
      return this.unScheduledQuantity;
   }

   public BigDecimal getUnScheduledWeight() {
      return this.unScheduledWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteWeight() {
      return this.completeWeight;
   }

   @JsonProperty("shopName")
   public TeamScheduledInfoDTO setShopName(final String shopName) {
      this.shopName = shopName;
      return this;
   }

   @JsonProperty("lineName")
   public TeamScheduledInfoDTO setLineName(final String lineName) {
      this.lineName = lineName;
      return this;
   }

   @JsonProperty("leaderName")
   public TeamScheduledInfoDTO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("scheduledQuantity")
   public TeamScheduledInfoDTO setScheduledQuantity(final Integer scheduledQuantity) {
      this.scheduledQuantity = scheduledQuantity;
      return this;
   }

   @JsonProperty("scheduledWeight")
   public TeamScheduledInfoDTO setScheduledWeight(final BigDecimal scheduledWeight) {
      this.scheduledWeight = scheduledWeight;
      return this;
   }

   @JsonProperty("unScheduledQuantity")
   public TeamScheduledInfoDTO setUnScheduledQuantity(final Integer unScheduledQuantity) {
      this.unScheduledQuantity = unScheduledQuantity;
      return this;
   }

   @JsonProperty("unScheduledWeight")
   public TeamScheduledInfoDTO setUnScheduledWeight(final BigDecimal unScheduledWeight) {
      this.unScheduledWeight = unScheduledWeight;
      return this;
   }

   @JsonProperty("completeQuantity")
   public TeamScheduledInfoDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeWeight")
   public TeamScheduledInfoDTO setCompleteWeight(final BigDecimal completeWeight) {
      this.completeWeight = completeWeight;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamScheduledInfoDTO)) {
         return false;
      }

      TeamScheduledInfoDTO other = (TeamScheduledInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$scheduledQuantity = this.getScheduledQuantity();
      Object other$scheduledQuantity = other.getScheduledQuantity();
      if (this$scheduledQuantity == null ? other$scheduledQuantity == null : this$scheduledQuantity.equals(other$scheduledQuantity)) {
         Object this$unScheduledQuantity = this.getUnScheduledQuantity();
         Object other$unScheduledQuantity = other.getUnScheduledQuantity();
         if (this$unScheduledQuantity == null ? other$unScheduledQuantity == null : this$unScheduledQuantity.equals(other$unScheduledQuantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
               Object this$shopName = this.getShopName();
               Object other$shopName = other.getShopName();
               if (this$shopName == null ? other$shopName == null : this$shopName.equals(other$shopName)) {
                  Object this$lineName = this.getLineName();
                  Object other$lineName = other.getLineName();
                  if (this$lineName == null ? other$lineName == null : this$lineName.equals(other$lineName)) {
                     Object this$leaderName = this.getLeaderName();
                     Object other$leaderName = other.getLeaderName();
                     if (this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName)) {
                        Object this$scheduledWeight = this.getScheduledWeight();
                        Object other$scheduledWeight = other.getScheduledWeight();
                        if (this$scheduledWeight == null ? other$scheduledWeight == null : this$scheduledWeight.equals(other$scheduledWeight)) {
                           Object this$unScheduledWeight = this.getUnScheduledWeight();
                           Object other$unScheduledWeight = other.getUnScheduledWeight();
                           if (this$unScheduledWeight == null ? other$unScheduledWeight == null : this$unScheduledWeight.equals(other$unScheduledWeight)) {
                              Object this$completeWeight = this.getCompleteWeight();
                              Object other$completeWeight = other.getCompleteWeight();
                              return this$completeWeight == null ? other$completeWeight == null : this$completeWeight.equals(other$completeWeight);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TeamScheduledInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $scheduledQuantity = this.getScheduledQuantity();
      result = result * 59 + ($scheduledQuantity == null ? 43 : $scheduledQuantity.hashCode());
      Object $unScheduledQuantity = this.getUnScheduledQuantity();
      result = result * 59 + ($unScheduledQuantity == null ? 43 : $unScheduledQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $shopName = this.getShopName();
      result = result * 59 + ($shopName == null ? 43 : $shopName.hashCode());
      Object $lineName = this.getLineName();
      result = result * 59 + ($lineName == null ? 43 : $lineName.hashCode());
      Object $leaderName = this.getLeaderName();
      result = result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
      Object $scheduledWeight = this.getScheduledWeight();
      result = result * 59 + ($scheduledWeight == null ? 43 : $scheduledWeight.hashCode());
      Object $unScheduledWeight = this.getUnScheduledWeight();
      result = result * 59 + ($unScheduledWeight == null ? 43 : $unScheduledWeight.hashCode());
      Object $completeWeight = this.getCompleteWeight();
      return result * 59 + ($completeWeight == null ? 43 : $completeWeight.hashCode());
   }

   @Override
   public String toString() {
      return "TeamScheduledInfoDTO(shopName="
         + this.getShopName()
         + ", lineName="
         + this.getLineName()
         + ", leaderName="
         + this.getLeaderName()
         + ", scheduledQuantity="
         + this.getScheduledQuantity()
         + ", scheduledWeight="
         + this.getScheduledWeight()
         + ", unScheduledQuantity="
         + this.getUnScheduledQuantity()
         + ", unScheduledWeight="
         + this.getUnScheduledWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeWeight="
         + this.getCompleteWeight()
         + ")";
   }

   public static class TeamScheduledInfoDTOBuilder {
      private String shopName;
      private String lineName;
      private String leaderName;
      private Integer scheduledQuantity;
      private BigDecimal scheduledWeight;
      private Integer unScheduledQuantity;
      private BigDecimal unScheduledWeight;
      private Integer completeQuantity;
      private BigDecimal completeWeight;

      TeamScheduledInfoDTOBuilder() {
      }

      @JsonProperty("shopName")
      public TeamScheduledInfoDTO.TeamScheduledInfoDTOBuilder shopName(final String shopName) {
         this.shopName = shopName;
         return this;
      }

      @JsonProperty("lineName")
      public TeamScheduledInfoDTO.TeamScheduledInfoDTOBuilder lineName(final String lineName) {
         this.lineName = lineName;
         return this;
      }

      @JsonProperty("leaderName")
      public TeamScheduledInfoDTO.TeamScheduledInfoDTOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("scheduledQuantity")
      public TeamScheduledInfoDTO.TeamScheduledInfoDTOBuilder scheduledQuantity(final Integer scheduledQuantity) {
         this.scheduledQuantity = scheduledQuantity;
         return this;
      }

      @JsonProperty("scheduledWeight")
      public TeamScheduledInfoDTO.TeamScheduledInfoDTOBuilder scheduledWeight(final BigDecimal scheduledWeight) {
         this.scheduledWeight = scheduledWeight;
         return this;
      }

      @JsonProperty("unScheduledQuantity")
      public TeamScheduledInfoDTO.TeamScheduledInfoDTOBuilder unScheduledQuantity(final Integer unScheduledQuantity) {
         this.unScheduledQuantity = unScheduledQuantity;
         return this;
      }

      @JsonProperty("unScheduledWeight")
      public TeamScheduledInfoDTO.TeamScheduledInfoDTOBuilder unScheduledWeight(final BigDecimal unScheduledWeight) {
         this.unScheduledWeight = unScheduledWeight;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TeamScheduledInfoDTO.TeamScheduledInfoDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeWeight")
      public TeamScheduledInfoDTO.TeamScheduledInfoDTOBuilder completeWeight(final BigDecimal completeWeight) {
         this.completeWeight = completeWeight;
         return this;
      }

      public TeamScheduledInfoDTO build() {
         return new TeamScheduledInfoDTO(
            this.shopName,
            this.lineName,
            this.leaderName,
            this.scheduledQuantity,
            this.scheduledWeight,
            this.unScheduledQuantity,
            this.unScheduledWeight,
            this.completeQuantity,
            this.completeWeight
         );
      }

      @Override
      public String toString() {
         return "TeamScheduledInfoDTO.TeamScheduledInfoDTOBuilder(shopName="
            + this.shopName
            + ", lineName="
            + this.lineName
            + ", leaderName="
            + this.leaderName
            + ", scheduledQuantity="
            + this.scheduledQuantity
            + ", scheduledWeight="
            + this.scheduledWeight
            + ", unScheduledQuantity="
            + this.unScheduledQuantity
            + ", unScheduledWeight="
            + this.unScheduledWeight
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeWeight="
            + this.completeWeight
            + ")";
      }
   }
}
