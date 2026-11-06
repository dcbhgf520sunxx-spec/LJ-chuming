package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.team.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureTeamUserLinkDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "TeamSaveVORequest", description = "")
public class TeamSaveVORequest {
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @NotNull(message = "工厂id")
   private Long factoryId;
   @ApiModelProperty(name = "productionLineId", notes = "产线id", value = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @NotNull(message = "产线id")
   private Long productionLineId;
   @ApiModelProperty(name = "price", notes = "工价", value = "工价")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;
   @ApiModelProperty(name = "userLinks", notes = "班组人员", value = "班组人员")
   @JsonProperty("userLinks")
   @JSONField(name = "userLinks")
   private List<MesEnclosureTeamUserLinkDTOParam> userLinks;

   public static TeamSaveVORequest.TeamSaveVORequestBuilder builder() {
      return new TeamSaveVORequest.TeamSaveVORequestBuilder();
   }

   public TeamSaveVORequest() {
   }

   public TeamSaveVORequest(final Long factoryId, final Long productionLineId, final BigDecimal price, final List<MesEnclosureTeamUserLinkDTOParam> userLinks) {
      this.factoryId = factoryId;
      this.productionLineId = productionLineId;
      this.price = price;
      this.userLinks = userLinks;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public List<MesEnclosureTeamUserLinkDTOParam> getUserLinks() {
      return this.userLinks;
   }

   @JsonProperty("factoryId")
   public TeamSaveVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("productionLineId")
   public TeamSaveVORequest setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("price")
   public TeamSaveVORequest setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("userLinks")
   public TeamSaveVORequest setUserLinks(final List<MesEnclosureTeamUserLinkDTOParam> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @Override
   public String toString() {
      return "TeamSaveVORequest(factoryId="
         + this.getFactoryId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", price="
         + this.getPrice()
         + ", userLinks="
         + this.getUserLinks()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamSaveVORequest)) {
         return false;
      }

      TeamSaveVORequest other = (TeamSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$factoryId = this.getFactoryId();
      Object other$factoryId = other.getFactoryId();
      if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$price = this.getPrice();
            Object other$price = other.getPrice();
            if (this$price == null ? other$price == null : this$price.equals(other$price)) {
               Object this$userLinks = this.getUserLinks();
               Object other$userLinks = other.getUserLinks();
               return this$userLinks == null ? other$userLinks == null : this$userLinks.equals(other$userLinks);
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
      return other instanceof TeamSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $userLinks = this.getUserLinks();
      return result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
   }

   public static class TeamSaveVORequestBuilder {
      private Long factoryId;
      private Long productionLineId;
      private BigDecimal price;
      private List<MesEnclosureTeamUserLinkDTOParam> userLinks;

      TeamSaveVORequestBuilder() {
      }

      @JsonProperty("factoryId")
      public TeamSaveVORequest.TeamSaveVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("productionLineId")
      public TeamSaveVORequest.TeamSaveVORequestBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("price")
      public TeamSaveVORequest.TeamSaveVORequestBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("userLinks")
      public TeamSaveVORequest.TeamSaveVORequestBuilder userLinks(final List<MesEnclosureTeamUserLinkDTOParam> userLinks) {
         this.userLinks = userLinks;
         return this;
      }

      public TeamSaveVORequest build() {
         return new TeamSaveVORequest(this.factoryId, this.productionLineId, this.price, this.userLinks);
      }

      @Override
      public String toString() {
         return "TeamSaveVORequest.TeamSaveVORequestBuilder(factoryId="
            + this.factoryId
            + ", productionLineId="
            + this.productionLineId
            + ", price="
            + this.price
            + ", userLinks="
            + this.userLinks
            + ")";
      }
   }
}
