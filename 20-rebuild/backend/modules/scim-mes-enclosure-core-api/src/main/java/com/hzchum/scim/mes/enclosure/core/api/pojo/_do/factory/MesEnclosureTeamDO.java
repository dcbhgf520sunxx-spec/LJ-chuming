package com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

public class MesEnclosureTeamDO extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "mesEnclosureTeamUserLinkList", notes = "班组人员")
   @JsonProperty("mesEnclosureTeamUserLinkList")
   @JSONField(name = "mesEnclosureTeamUserLinkList")
   private List<MesEnclosureTeamUserLinkDO> mesEnclosureTeamUserLinkList;

   public static MesEnclosureTeamDO.MesEnclosureTeamDOBuilder builder() {
      return new MesEnclosureTeamDO.MesEnclosureTeamDOBuilder();
   }

   public MesEnclosureTeamDO() {
   }

   public MesEnclosureTeamDO(
      final Long id,
      final Long processId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long userId,
      final List<MesEnclosureTeamUserLinkDO> mesEnclosureTeamUserLinkList
   ) {
      this.id = id;
      this.processId = processId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.userId = userId;
      this.mesEnclosureTeamUserLinkList = mesEnclosureTeamUserLinkList;
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

   public List<MesEnclosureTeamUserLinkDO> getMesEnclosureTeamUserLinkList() {
      return this.mesEnclosureTeamUserLinkList;
   }

   @JsonProperty("id")
   public MesEnclosureTeamDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureTeamDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureTeamDO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureTeamDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureTeamDO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureTeamDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("mesEnclosureTeamUserLinkList")
   public MesEnclosureTeamDO setMesEnclosureTeamUserLinkList(final List<MesEnclosureTeamUserLinkDO> mesEnclosureTeamUserLinkList) {
      this.mesEnclosureTeamUserLinkList = mesEnclosureTeamUserLinkList;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTeamDO(id="
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
         + ", mesEnclosureTeamUserLinkList="
         + this.getMesEnclosureTeamUserLinkList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTeamDO)) {
         return false;
      }

      MesEnclosureTeamDO other = (MesEnclosureTeamDO)o;
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
                        Object this$mesEnclosureTeamUserLinkList = this.getMesEnclosureTeamUserLinkList();
                        Object other$mesEnclosureTeamUserLinkList = other.getMesEnclosureTeamUserLinkList();
                        return this$mesEnclosureTeamUserLinkList == null
                           ? other$mesEnclosureTeamUserLinkList == null
                           : this$mesEnclosureTeamUserLinkList.equals(other$mesEnclosureTeamUserLinkList);
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
      return other instanceof MesEnclosureTeamDO;
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
      Object $mesEnclosureTeamUserLinkList = this.getMesEnclosureTeamUserLinkList();
      return result * 59 + ($mesEnclosureTeamUserLinkList == null ? 43 : $mesEnclosureTeamUserLinkList.hashCode());
   }

   public static class MesEnclosureTeamDOBuilder {
      private Long id;
      private Long processId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long userId;
      private List<MesEnclosureTeamUserLinkDO> mesEnclosureTeamUserLinkList;

      MesEnclosureTeamDOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureTeamDO.MesEnclosureTeamDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureTeamDO.MesEnclosureTeamDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureTeamDO.MesEnclosureTeamDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureTeamDO.MesEnclosureTeamDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureTeamDO.MesEnclosureTeamDOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureTeamDO.MesEnclosureTeamDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("mesEnclosureTeamUserLinkList")
      public MesEnclosureTeamDO.MesEnclosureTeamDOBuilder mesEnclosureTeamUserLinkList(final List<MesEnclosureTeamUserLinkDO> mesEnclosureTeamUserLinkList) {
         this.mesEnclosureTeamUserLinkList = mesEnclosureTeamUserLinkList;
         return this;
      }

      public MesEnclosureTeamDO build() {
         return new MesEnclosureTeamDO(
            this.id, this.processId, this.factoryId, this.workshopId, this.productionLineId, this.userId, this.mesEnclosureTeamUserLinkList
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureTeamDO.MesEnclosureTeamDOBuilder(id="
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
            + ", mesEnclosureTeamUserLinkList="
            + this.mesEnclosureTeamUserLinkList
            + ")";
      }
   }
}
