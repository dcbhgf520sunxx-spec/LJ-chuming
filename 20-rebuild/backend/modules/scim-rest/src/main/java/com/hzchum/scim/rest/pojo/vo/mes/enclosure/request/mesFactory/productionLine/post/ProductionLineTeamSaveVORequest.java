package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.productionLine.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProductionLineSaveVORequest", description = "")
public class ProductionLineTeamSaveVORequest {
   @ApiModelProperty(name = "id", notes = "生产线id", value = "生产线id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "teamIds", notes = "班组id", value = "班组id")
   @JsonProperty("teamIds")
   @JSONField(name = "teamIds")
   private List<Long> teamIds;

   public static ProductionLineTeamSaveVORequest.ProductionLineTeamSaveVORequestBuilder builder() {
      return new ProductionLineTeamSaveVORequest.ProductionLineTeamSaveVORequestBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public List<Long> getTeamIds() {
      return this.teamIds;
   }

   @JsonProperty("id")
   public ProductionLineTeamSaveVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamIds")
   public ProductionLineTeamSaveVORequest setTeamIds(final List<Long> teamIds) {
      this.teamIds = teamIds;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionLineTeamSaveVORequest(id=" + this.getId() + ", teamIds=" + this.getTeamIds() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductionLineTeamSaveVORequest)) {
         return false;
      } else {
         ProductionLineTeamSaveVORequest other = (ProductionLineTeamSaveVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$teamIds = this.getTeamIds();
               Object other$teamIds = other.getTeamIds();
               return this$teamIds == null ? other$teamIds == null : this$teamIds.equals(other$teamIds);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductionLineTeamSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamIds = this.getTeamIds();
      return result * 59 + ($teamIds == null ? 43 : $teamIds.hashCode());
   }

   public ProductionLineTeamSaveVORequest(final Long id, final List<Long> teamIds) {
      this.id = id;
      this.teamIds = teamIds;
   }

   public ProductionLineTeamSaveVORequest() {
   }

   public static class ProductionLineTeamSaveVORequestBuilder {
      private Long id;
      private List<Long> teamIds;

      ProductionLineTeamSaveVORequestBuilder() {
      }

      @JsonProperty("id")
      public ProductionLineTeamSaveVORequest.ProductionLineTeamSaveVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("teamIds")
      public ProductionLineTeamSaveVORequest.ProductionLineTeamSaveVORequestBuilder teamIds(final List<Long> teamIds) {
         this.teamIds = teamIds;
         return this;
      }

      public ProductionLineTeamSaveVORequest build() {
         return new ProductionLineTeamSaveVORequest(this.id, this.teamIds);
      }

      @Override
      public String toString() {
         return "ProductionLineTeamSaveVORequest.ProductionLineTeamSaveVORequestBuilder(id=" + this.id + ", teamIds=" + this.teamIds + ")";
      }
   }
}
