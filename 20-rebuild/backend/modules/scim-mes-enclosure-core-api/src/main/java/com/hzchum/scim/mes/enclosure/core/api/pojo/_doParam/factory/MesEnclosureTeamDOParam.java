package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureTeamUserLinkDTOParam;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

public class MesEnclosureTeamDOParam extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "boolExtraCountEnum", notes = "编制属性[0 不单独计算,单独计算]")
   @JsonProperty("boolExtraCountEnum")
   @JSONField(name = "boolExtraCountEnum")
   private Boolean boolExtraCountEnum;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式 [1 重量, 2 长度，4 面积]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "hasMen", value = "是否有组员0无，1有", notes = "是否有组员0无，1有")
   @JsonProperty("hasMen")
   @JSONField(name = "hasMen")
   private Boolean hasMen;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;

   public static MesEnclosureTeamDOParam.MesEnclosureTeamDOParamBuilder builder() {
      return new MesEnclosureTeamDOParam.MesEnclosureTeamDOParamBuilder();
   }

   public MesEnclosureTeamDOParam() {
   }

   public MesEnclosureTeamDOParam(
      final Long id,
      final Long processId,
      final Long factoryId,
      final Long productionLineId,
      final Long userId,
      final Boolean organizationType,
      final List<MesEnclosureTeamUserLinkDTOParam> userLinks,
      final List<Long> productionLineIds,
      final Boolean boolExtraCountEnum,
      final Integer wageQuotaType,
      final Boolean hasMen,
      final Integer productionLineTypeEnum
   ) {
      this.id = id;
      this.processId = processId;
      this.factoryId = factoryId;
      this.productionLineId = productionLineId;
      this.userId = userId;
      this.organizationType = organizationType;
      this.userLinks = userLinks;
      this.productionLineIds = productionLineIds;
      this.boolExtraCountEnum = boolExtraCountEnum;
      this.wageQuotaType = wageQuotaType;
      this.hasMen = hasMen;
      this.productionLineTypeEnum = productionLineTypeEnum;
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

   public Boolean getBoolExtraCountEnum() {
      return this.boolExtraCountEnum;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public Boolean getHasMen() {
      return this.hasMen;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   @JsonProperty("id")
   public MesEnclosureTeamDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureTeamDOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureTeamDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureTeamDOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureTeamDOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("organizationType")
   public MesEnclosureTeamDOParam setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("userLinks")
   public MesEnclosureTeamDOParam setUserLinks(final List<MesEnclosureTeamUserLinkDTOParam> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @JsonProperty("productionLineIds")
   public MesEnclosureTeamDOParam setProductionLineIds(final List<Long> productionLineIds) {
      this.productionLineIds = productionLineIds;
      return this;
   }

   @JsonProperty("boolExtraCountEnum")
   public MesEnclosureTeamDOParam setBoolExtraCountEnum(final Boolean boolExtraCountEnum) {
      this.boolExtraCountEnum = boolExtraCountEnum;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public MesEnclosureTeamDOParam setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("hasMen")
   public MesEnclosureTeamDOParam setHasMen(final Boolean hasMen) {
      this.hasMen = hasMen;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesEnclosureTeamDOParam setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTeamDOParam(id="
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
         + ", boolExtraCountEnum="
         + this.getBoolExtraCountEnum()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", hasMen="
         + this.getHasMen()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTeamDOParam)) {
         return false;
      }

      MesEnclosureTeamDOParam other = (MesEnclosureTeamDOParam)o;
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
                        Object this$boolExtraCountEnum = this.getBoolExtraCountEnum();
                        Object other$boolExtraCountEnum = other.getBoolExtraCountEnum();
                        if (this$boolExtraCountEnum == null ? other$boolExtraCountEnum == null : this$boolExtraCountEnum.equals(other$boolExtraCountEnum)) {
                           Object this$wageQuotaType = this.getWageQuotaType();
                           Object other$wageQuotaType = other.getWageQuotaType();
                           if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                              Object this$hasMen = this.getHasMen();
                              Object other$hasMen = other.getHasMen();
                              if (this$hasMen == null ? other$hasMen == null : this$hasMen.equals(other$hasMen)) {
                                 Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                                 Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                                 if (this$productionLineTypeEnum == null
                                    ? other$productionLineTypeEnum == null
                                    : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                                    Object this$userLinks = this.getUserLinks();
                                    Object other$userLinks = other.getUserLinks();
                                    if (this$userLinks == null ? other$userLinks == null : this$userLinks.equals(other$userLinks)) {
                                       Object this$productionLineIds = this.getProductionLineIds();
                                       Object other$productionLineIds = other.getProductionLineIds();
                                       return this$productionLineIds == null
                                          ? other$productionLineIds == null
                                          : this$productionLineIds.equals(other$productionLineIds);
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
      return other instanceof MesEnclosureTeamDOParam;
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
      Object $boolExtraCountEnum = this.getBoolExtraCountEnum();
      result = result * 59 + ($boolExtraCountEnum == null ? 43 : $boolExtraCountEnum.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $hasMen = this.getHasMen();
      result = result * 59 + ($hasMen == null ? 43 : $hasMen.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $userLinks = this.getUserLinks();
      result = result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
      Object $productionLineIds = this.getProductionLineIds();
      return result * 59 + ($productionLineIds == null ? 43 : $productionLineIds.hashCode());
   }

   public static class MesEnclosureTeamDOParamBuilder {
      private Long id;
      private Long processId;
      private Long factoryId;
      private Long productionLineId;
      private Long userId;
      private Boolean organizationType;
      private List<MesEnclosureTeamUserLinkDTOParam> userLinks;
      private List<Long> productionLineIds;
      private Boolean boolExtraCountEnum;
      private Integer wageQuotaType;
      private Boolean hasMen;
      private Integer productionLineTypeEnum;

      MesEnclosureTeamDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureTeamDOParam.MesEnclosureTeamDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureTeamDOParam.MesEnclosureTeamDOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureTeamDOParam.MesEnclosureTeamDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureTeamDOParam.MesEnclosureTeamDOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureTeamDOParam.MesEnclosureTeamDOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("organizationType")
      public MesEnclosureTeamDOParam.MesEnclosureTeamDOParamBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("userLinks")
      public MesEnclosureTeamDOParam.MesEnclosureTeamDOParamBuilder userLinks(final List<MesEnclosureTeamUserLinkDTOParam> userLinks) {
         this.userLinks = userLinks;
         return this;
      }

      @JsonProperty("productionLineIds")
      public MesEnclosureTeamDOParam.MesEnclosureTeamDOParamBuilder productionLineIds(final List<Long> productionLineIds) {
         this.productionLineIds = productionLineIds;
         return this;
      }

      @JsonProperty("boolExtraCountEnum")
      public MesEnclosureTeamDOParam.MesEnclosureTeamDOParamBuilder boolExtraCountEnum(final Boolean boolExtraCountEnum) {
         this.boolExtraCountEnum = boolExtraCountEnum;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public MesEnclosureTeamDOParam.MesEnclosureTeamDOParamBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("hasMen")
      public MesEnclosureTeamDOParam.MesEnclosureTeamDOParamBuilder hasMen(final Boolean hasMen) {
         this.hasMen = hasMen;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesEnclosureTeamDOParam.MesEnclosureTeamDOParamBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public MesEnclosureTeamDOParam build() {
         return new MesEnclosureTeamDOParam(
            this.id,
            this.processId,
            this.factoryId,
            this.productionLineId,
            this.userId,
            this.organizationType,
            this.userLinks,
            this.productionLineIds,
            this.boolExtraCountEnum,
            this.wageQuotaType,
            this.hasMen,
            this.productionLineTypeEnum
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureTeamDOParam.MesEnclosureTeamDOParamBuilder(id="
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
            + ", boolExtraCountEnum="
            + this.boolExtraCountEnum
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", hasMen="
            + this.hasMen
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ")";
      }
   }
}
