package com.hzchum.scim.mes.building.core.api.pojo._do.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

public class MesBuildingTeamDO extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @NotNull(message = "车间id不能为空")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @NotNull(message = "生产线id不能为空")
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
   @ApiModelProperty(name = "mesBuildingTeamUserLinkList", notes = "班组人员")
   @JsonProperty("mesBuildingTeamUserLinkList")
   @JSONField(name = "mesBuildingTeamUserLinkList")
   private List<MesBuildingTeamUserLinkDO> mesBuildingTeamUserLinkList;

   public static MesBuildingTeamDO.MesBuildingTeamDOBuilder builder() {
      return new MesBuildingTeamDO.MesBuildingTeamDOBuilder();
   }

   public MesBuildingTeamDO() {
   }

   public MesBuildingTeamDO(
      final Long id,
      final Long processId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long userId,
      final Boolean organizationType,
      final List<MesBuildingTeamUserLinkDO> mesBuildingTeamUserLinkList
   ) {
      this.id = id;
      this.processId = processId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.userId = userId;
      this.organizationType = organizationType;
      this.mesBuildingTeamUserLinkList = mesBuildingTeamUserLinkList;
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

   public Long getWorkshopId() {
      return this.workshopId;
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

   public List<MesBuildingTeamUserLinkDO> getMesBuildingTeamUserLinkList() {
      return this.mesBuildingTeamUserLinkList;
   }

   @JsonProperty("id")
   public MesBuildingTeamDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingTeamDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingTeamDO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingTeamDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTeamDO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingTeamDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("organizationType")
   public MesBuildingTeamDO setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("mesBuildingTeamUserLinkList")
   public MesBuildingTeamDO setMesBuildingTeamUserLinkList(final List<MesBuildingTeamUserLinkDO> mesBuildingTeamUserLinkList) {
      this.mesBuildingTeamUserLinkList = mesBuildingTeamUserLinkList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTeamDO(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", userId="
         + this.getUserId()
         + ", organizationType="
         + this.getOrganizationType()
         + ", mesBuildingTeamUserLinkList="
         + this.getMesBuildingTeamUserLinkList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTeamDO)) {
         return false;
      }

      MesBuildingTeamDO other = (MesBuildingTeamDO)o;
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
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$productionLineId = this.getProductionLineId();
                  Object other$productionLineId = other.getProductionLineId();
                  if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$organizationType = this.getOrganizationType();
                        Object other$organizationType = other.getOrganizationType();
                        if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
                           Object this$mesBuildingTeamUserLinkList = this.getMesBuildingTeamUserLinkList();
                           Object other$mesBuildingTeamUserLinkList = other.getMesBuildingTeamUserLinkList();
                           return this$mesBuildingTeamUserLinkList == null
                              ? other$mesBuildingTeamUserLinkList == null
                              : this$mesBuildingTeamUserLinkList.equals(other$mesBuildingTeamUserLinkList);
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
      return other instanceof MesBuildingTeamDO;
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
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $mesBuildingTeamUserLinkList = this.getMesBuildingTeamUserLinkList();
      return result * 59 + ($mesBuildingTeamUserLinkList == null ? 43 : $mesBuildingTeamUserLinkList.hashCode());
   }

   public static class MesBuildingTeamDOBuilder {
      private Long id;
      private Long processId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long userId;
      private Boolean organizationType;
      private List<MesBuildingTeamUserLinkDO> mesBuildingTeamUserLinkList;

      MesBuildingTeamDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTeamDO.MesBuildingTeamDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingTeamDO.MesBuildingTeamDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingTeamDO.MesBuildingTeamDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingTeamDO.MesBuildingTeamDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingTeamDO.MesBuildingTeamDOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingTeamDO.MesBuildingTeamDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("organizationType")
      public MesBuildingTeamDO.MesBuildingTeamDOBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("mesBuildingTeamUserLinkList")
      public MesBuildingTeamDO.MesBuildingTeamDOBuilder mesBuildingTeamUserLinkList(final List<MesBuildingTeamUserLinkDO> mesBuildingTeamUserLinkList) {
         this.mesBuildingTeamUserLinkList = mesBuildingTeamUserLinkList;
         return this;
      }

      public MesBuildingTeamDO build() {
         return new MesBuildingTeamDO(
            this.id,
            this.processId,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.userId,
            this.organizationType,
            this.mesBuildingTeamUserLinkList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTeamDO.MesBuildingTeamDOBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", userId="
            + this.userId
            + ", organizationType="
            + this.organizationType
            + ", mesBuildingTeamUserLinkList="
            + this.mesBuildingTeamUserLinkList
            + ")";
      }
   }
}
