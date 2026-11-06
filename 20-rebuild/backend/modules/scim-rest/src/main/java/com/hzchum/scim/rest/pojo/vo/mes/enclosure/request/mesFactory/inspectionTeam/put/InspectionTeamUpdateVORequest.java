package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.inspectionTeam.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "InspectionTeamUpdateVORequest", description = "")
public class InspectionTeamUpdateVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @EnumValidator(value = ProductionLineTypeEnum.class, message = "生产线类型错误")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "userLinks", notes = "质检人员", value = "质检人员")
   @JsonProperty("userLinks")
   @JSONField(name = "userLinks")
   private List<InspectionTeamUserLinkUpdateVORequest> userLinks;

   public static InspectionTeamUpdateVORequest.InspectionTeamUpdateVORequestBuilder builder() {
      return new InspectionTeamUpdateVORequest.InspectionTeamUpdateVORequestBuilder();
   }

   public InspectionTeamUpdateVORequest() {
   }

   public InspectionTeamUpdateVORequest(final Long id, final Integer productionLineTypeEnum, final List<InspectionTeamUserLinkUpdateVORequest> userLinks) {
      this.id = id;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.userLinks = userLinks;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public List<InspectionTeamUserLinkUpdateVORequest> getUserLinks() {
      return this.userLinks;
   }

   @JsonProperty("id")
   public InspectionTeamUpdateVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public InspectionTeamUpdateVORequest setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("userLinks")
   public InspectionTeamUpdateVORequest setUserLinks(final List<InspectionTeamUserLinkUpdateVORequest> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @Override
   public String toString() {
      return "InspectionTeamUpdateVORequest(id="
         + this.getId()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", userLinks="
         + this.getUserLinks()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionTeamUpdateVORequest)) {
         return false;
      }

      InspectionTeamUpdateVORequest other = (InspectionTeamUpdateVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
         Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
         if (this$productionLineTypeEnum == null ? other$productionLineTypeEnum == null : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
            Object this$userLinks = this.getUserLinks();
            Object other$userLinks = other.getUserLinks();
            return this$userLinks == null ? other$userLinks == null : this$userLinks.equals(other$userLinks);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InspectionTeamUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $userLinks = this.getUserLinks();
      return result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
   }

   public static class InspectionTeamUpdateVORequestBuilder {
      private Long id;
      private Integer productionLineTypeEnum;
      private List<InspectionTeamUserLinkUpdateVORequest> userLinks;

      InspectionTeamUpdateVORequestBuilder() {
      }

      @JsonProperty("id")
      public InspectionTeamUpdateVORequest.InspectionTeamUpdateVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public InspectionTeamUpdateVORequest.InspectionTeamUpdateVORequestBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("userLinks")
      public InspectionTeamUpdateVORequest.InspectionTeamUpdateVORequestBuilder userLinks(final List<InspectionTeamUserLinkUpdateVORequest> userLinks) {
         this.userLinks = userLinks;
         return this;
      }

      public InspectionTeamUpdateVORequest build() {
         return new InspectionTeamUpdateVORequest(this.id, this.productionLineTypeEnum, this.userLinks);
      }

      @Override
      public String toString() {
         return "InspectionTeamUpdateVORequest.InspectionTeamUpdateVORequestBuilder(id="
            + this.id
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", userLinks="
            + this.userLinks
            + ")";
      }
   }
}
