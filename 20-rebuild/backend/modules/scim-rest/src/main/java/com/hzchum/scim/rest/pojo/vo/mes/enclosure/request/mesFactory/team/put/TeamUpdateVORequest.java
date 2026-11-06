package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.team.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureTeamUserLinkDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "TeamUpdateVORequest", description = "")
public class TeamUpdateVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]", value = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   private Boolean organizationType;
   @ApiModelProperty(name = "userLinks", notes = "班组人员", value = "班组人员")
   @JsonProperty("userLinks")
   @JSONField(name = "userLinks")
   private List<MesEnclosureTeamUserLinkDTOParam> userLinks;
   @ApiModelProperty(name = "price", notes = "工价", value = "工价")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;

   public static TeamUpdateVORequest.TeamUpdateVORequestBuilder builder() {
      return new TeamUpdateVORequest.TeamUpdateVORequestBuilder();
   }

   public TeamUpdateVORequest() {
   }

   public TeamUpdateVORequest(final Long id, final Boolean organizationType, final List<MesEnclosureTeamUserLinkDTOParam> userLinks, final BigDecimal price) {
      this.id = id;
      this.organizationType = organizationType;
      this.userLinks = userLinks;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   public List<MesEnclosureTeamUserLinkDTOParam> getUserLinks() {
      return this.userLinks;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("id")
   public TeamUpdateVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("organizationType")
   public TeamUpdateVORequest setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("userLinks")
   public TeamUpdateVORequest setUserLinks(final List<MesEnclosureTeamUserLinkDTOParam> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @JsonProperty("price")
   public TeamUpdateVORequest setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "TeamUpdateVORequest(id="
         + this.getId()
         + ", organizationType="
         + this.getOrganizationType()
         + ", userLinks="
         + this.getUserLinks()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamUpdateVORequest)) {
         return false;
      }

      TeamUpdateVORequest other = (TeamUpdateVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$organizationType = this.getOrganizationType();
         Object other$organizationType = other.getOrganizationType();
         if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
            Object this$userLinks = this.getUserLinks();
            Object other$userLinks = other.getUserLinks();
            if (this$userLinks == null ? other$userLinks == null : this$userLinks.equals(other$userLinks)) {
               Object this$price = this.getPrice();
               Object other$price = other.getPrice();
               return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof TeamUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $userLinks = this.getUserLinks();
      result = result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class TeamUpdateVORequestBuilder {
      private Long id;
      private Boolean organizationType;
      private List<MesEnclosureTeamUserLinkDTOParam> userLinks;
      private BigDecimal price;

      TeamUpdateVORequestBuilder() {
      }

      @JsonProperty("id")
      public TeamUpdateVORequest.TeamUpdateVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("organizationType")
      public TeamUpdateVORequest.TeamUpdateVORequestBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("userLinks")
      public TeamUpdateVORequest.TeamUpdateVORequestBuilder userLinks(final List<MesEnclosureTeamUserLinkDTOParam> userLinks) {
         this.userLinks = userLinks;
         return this;
      }

      @JsonProperty("price")
      public TeamUpdateVORequest.TeamUpdateVORequestBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public TeamUpdateVORequest build() {
         return new TeamUpdateVORequest(this.id, this.organizationType, this.userLinks, this.price);
      }

      @Override
      public String toString() {
         return "TeamUpdateVORequest.TeamUpdateVORequestBuilder(id="
            + this.id
            + ", organizationType="
            + this.organizationType
            + ", userLinks="
            + this.userLinks
            + ", price="
            + this.price
            + ")";
      }
   }
}
