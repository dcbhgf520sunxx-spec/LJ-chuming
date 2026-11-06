package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingInspectionTeamDTOParam对象", description = "")
public class MesBuildingInspectionTeamDTOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @NotNull(message = "工厂id不能为空")
   private Long factoryId;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @NotNull(message = "工序id不能为空")
   private Long processId;
   @ApiModelProperty(name = "userId", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "userLinks", notes = "质检人员")
   @JsonProperty("userLinks")
   @JSONField(name = "userLinks")
   private List<MesBuildingInspectionTeamUserLinkDTOParam> userLinks;

   public static MesBuildingInspectionTeamDTOParam.MesBuildingInspectionTeamDTOParamBuilder builder() {
      return new MesBuildingInspectionTeamDTOParam.MesBuildingInspectionTeamDTOParamBuilder();
   }

   public MesBuildingInspectionTeamDTOParam() {
   }

   public MesBuildingInspectionTeamDTOParam(
      final Long id,
      final Long factoryId,
      final Long processId,
      final Long userId,
      final Integer productionLineTypeEnum,
      final List<MesBuildingInspectionTeamUserLinkDTOParam> userLinks
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.processId = processId;
      this.userId = userId;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.userLinks = userLinks;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public List<MesBuildingInspectionTeamUserLinkDTOParam> getUserLinks() {
      return this.userLinks;
   }

   @JsonProperty("id")
   public MesBuildingInspectionTeamDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingInspectionTeamDTOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingInspectionTeamDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingInspectionTeamDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingInspectionTeamDTOParam setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("userLinks")
   public MesBuildingInspectionTeamDTOParam setUserLinks(final List<MesBuildingInspectionTeamUserLinkDTOParam> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingInspectionTeamDTOParam(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", processId="
         + this.getProcessId()
         + ", userId="
         + this.getUserId()
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

      if (!(o instanceof MesBuildingInspectionTeamDTOParam)) {
         return false;
      }

      MesBuildingInspectionTeamDTOParam other = (MesBuildingInspectionTeamDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                  Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                  if (this$productionLineTypeEnum == null
                     ? other$productionLineTypeEnum == null
                     : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingInspectionTeamDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $userLinks = this.getUserLinks();
      return result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
   }

   public static class MesBuildingInspectionTeamDTOParamBuilder {
      private Long id;
      private Long factoryId;
      private Long processId;
      private Long userId;
      private Integer productionLineTypeEnum;
      private List<MesBuildingInspectionTeamUserLinkDTOParam> userLinks;

      MesBuildingInspectionTeamDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingInspectionTeamDTOParam.MesBuildingInspectionTeamDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingInspectionTeamDTOParam.MesBuildingInspectionTeamDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingInspectionTeamDTOParam.MesBuildingInspectionTeamDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingInspectionTeamDTOParam.MesBuildingInspectionTeamDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingInspectionTeamDTOParam.MesBuildingInspectionTeamDTOParamBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("userLinks")
      public MesBuildingInspectionTeamDTOParam.MesBuildingInspectionTeamDTOParamBuilder userLinks(
         final List<MesBuildingInspectionTeamUserLinkDTOParam> userLinks
      ) {
         this.userLinks = userLinks;
         return this;
      }

      public MesBuildingInspectionTeamDTOParam build() {
         return new MesBuildingInspectionTeamDTOParam(this.id, this.factoryId, this.processId, this.userId, this.productionLineTypeEnum, this.userLinks);
      }

      @Override
      public String toString() {
         return "MesBuildingInspectionTeamDTOParam.MesBuildingInspectionTeamDTOParamBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", processId="
            + this.processId
            + ", userId="
            + this.userId
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", userLinks="
            + this.userLinks
            + ")";
      }
   }
}
