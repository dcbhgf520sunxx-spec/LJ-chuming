package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

public class MesEnclosureTeamDTOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @NotNull(message = "工序id不能为空")
   private Long processId;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @NotNull(message = "工厂id不能为空")
   private Long factoryId;
   @ApiModelProperty(name = "productionLineId", notes = "产线id", value = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "userId", notes = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   @NotNull(message = "编制属性不能为空")
   private Boolean organizationType;
   @ApiModelProperty(name = "userLinks", notes = "班组人员")
   @JsonProperty("userLinks")
   @JSONField(name = "userLinks")
   private List<MesEnclosureTeamUserLinkDTOParam> userLinks;
   @ApiModelProperty(name = "productionLineIds", notes = "生产线ids")
   @JsonProperty("productionLineIds")
   @JSONField(name = "productionLineIds")
   private List<Long> productionLineIds;
   @ApiModelProperty(name = "price", notes = "工价", value = "工价")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;

   public static MesEnclosureTeamDTOParam.MesEnclosureTeamDTOParamBuilder builder() {
      return new MesEnclosureTeamDTOParam.MesEnclosureTeamDTOParamBuilder();
   }

   public MesEnclosureTeamDTOParam() {
   }

   public MesEnclosureTeamDTOParam(
      final Long id,
      final Long processId,
      final Long factoryId,
      final Long productionLineId,
      final Long userId,
      final Boolean organizationType,
      final List<MesEnclosureTeamUserLinkDTOParam> userLinks,
      final List<Long> productionLineIds,
      final BigDecimal price
   ) {
      this.id = id;
      this.processId = processId;
      this.factoryId = factoryId;
      this.productionLineId = productionLineId;
      this.userId = userId;
      this.organizationType = organizationType;
      this.userLinks = userLinks;
      this.productionLineIds = productionLineIds;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   public List<MesEnclosureTeamUserLinkDTOParam> getUserLinks() {
      return this.userLinks;
   }

   public List<Long> getProductionLineIds() {
      return this.productionLineIds;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("id")
   public MesEnclosureTeamDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureTeamDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureTeamDTOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureTeamDTOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureTeamDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("organizationType")
   public MesEnclosureTeamDTOParam setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("userLinks")
   public MesEnclosureTeamDTOParam setUserLinks(final List<MesEnclosureTeamUserLinkDTOParam> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @JsonProperty("productionLineIds")
   public MesEnclosureTeamDTOParam setProductionLineIds(final List<Long> productionLineIds) {
      this.productionLineIds = productionLineIds;
      return this;
   }

   @JsonProperty("price")
   public MesEnclosureTeamDTOParam setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTeamDTOParam(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", factoryId="
         + this.getFactoryId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", userId="
         + this.getUserId()
         + ", organizationType="
         + this.getOrganizationType()
         + ", userLinks="
         + this.getUserLinks()
         + ", productionLineIds="
         + this.getProductionLineIds()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTeamDTOParam)) {
         return false;
      }

      MesEnclosureTeamDTOParam other = (MesEnclosureTeamDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$organizationType = this.getOrganizationType();
                     Object other$organizationType = other.getOrganizationType();
                     if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
                        Object this$userLinks = this.getUserLinks();
                        Object other$userLinks = other.getUserLinks();
                        if (this$userLinks == null ? other$userLinks == null : this$userLinks.equals(other$userLinks)) {
                           Object this$productionLineIds = this.getProductionLineIds();
                           Object other$productionLineIds = other.getProductionLineIds();
                           if (this$productionLineIds == null ? other$productionLineIds == null : this$productionLineIds.equals(other$productionLineIds)) {
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureTeamDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $userLinks = this.getUserLinks();
      result = result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
      Object $productionLineIds = this.getProductionLineIds();
      result = result * 59 + ($productionLineIds == null ? 43 : $productionLineIds.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesEnclosureTeamDTOParamBuilder {
      private Long id;
      private Long processId;
      private Long factoryId;
      private Long productionLineId;
      private Long userId;
      private Boolean organizationType;
      private List<MesEnclosureTeamUserLinkDTOParam> userLinks;
      private List<Long> productionLineIds;
      private BigDecimal price;

      MesEnclosureTeamDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureTeamDTOParam.MesEnclosureTeamDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureTeamDTOParam.MesEnclosureTeamDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureTeamDTOParam.MesEnclosureTeamDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureTeamDTOParam.MesEnclosureTeamDTOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureTeamDTOParam.MesEnclosureTeamDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("organizationType")
      public MesEnclosureTeamDTOParam.MesEnclosureTeamDTOParamBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("userLinks")
      public MesEnclosureTeamDTOParam.MesEnclosureTeamDTOParamBuilder userLinks(final List<MesEnclosureTeamUserLinkDTOParam> userLinks) {
         this.userLinks = userLinks;
         return this;
      }

      @JsonProperty("productionLineIds")
      public MesEnclosureTeamDTOParam.MesEnclosureTeamDTOParamBuilder productionLineIds(final List<Long> productionLineIds) {
         this.productionLineIds = productionLineIds;
         return this;
      }

      @JsonProperty("price")
      public MesEnclosureTeamDTOParam.MesEnclosureTeamDTOParamBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesEnclosureTeamDTOParam build() {
         return new MesEnclosureTeamDTOParam(
            this.id,
            this.processId,
            this.factoryId,
            this.productionLineId,
            this.userId,
            this.organizationType,
            this.userLinks,
            this.productionLineIds,
            this.price
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureTeamDTOParam.MesEnclosureTeamDTOParamBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", factoryId="
            + this.factoryId
            + ", productionLineId="
            + this.productionLineId
            + ", userId="
            + this.userId
            + ", organizationType="
            + this.organizationType
            + ", userLinks="
            + this.userLinks
            + ", productionLineIds="
            + this.productionLineIds
            + ", price="
            + this.price
            + ")";
      }
   }
}
