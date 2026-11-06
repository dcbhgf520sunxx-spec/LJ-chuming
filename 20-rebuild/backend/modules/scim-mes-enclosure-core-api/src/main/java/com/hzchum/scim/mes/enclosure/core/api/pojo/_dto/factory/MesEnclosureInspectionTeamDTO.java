package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesEnclosureInspectionTeamDTO", description = "质检班组请求类")
public class MesEnclosureInspectionTeamDTO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "processId", notes = "工序id", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名", value = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "userId", notes = "操作人", value = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "userLinkList", notes = "质检人员")
   @JsonProperty("userLinkList")
   @JSONField(name = "userLinkList")
   private List<MesEnclosureInspectionTeamUserLinkDTO> userLinkList;

   public static MesEnclosureInspectionTeamDTO.MesEnclosureInspectionTeamDTOBuilder builder() {
      return new MesEnclosureInspectionTeamDTO.MesEnclosureInspectionTeamDTOBuilder();
   }

   public MesEnclosureInspectionTeamDTO() {
   }

   public MesEnclosureInspectionTeamDTO(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long processId,
      final String processName,
      final Long userId,
      final List<MesEnclosureInspectionTeamUserLinkDTO> userLinkList
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.processId = processId;
      this.processName = processName;
      this.userId = userId;
      this.userLinkList = userLinkList;
   }

   public Long getId() {
      return this.id;
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

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Long getUserId() {
      return this.userId;
   }

   public List<MesEnclosureInspectionTeamUserLinkDTO> getUserLinkList() {
      return this.userLinkList;
   }

   @JsonProperty("id")
   public MesEnclosureInspectionTeamDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureInspectionTeamDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureInspectionTeamDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureInspectionTeamDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureInspectionTeamDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public MesEnclosureInspectionTeamDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureInspectionTeamDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userLinkList")
   public MesEnclosureInspectionTeamDTO setUserLinkList(final List<MesEnclosureInspectionTeamUserLinkDTO> userLinkList) {
      this.userLinkList = userLinkList;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureInspectionTeamDTO(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", userId="
         + this.getUserId()
         + ", userLinkList="
         + this.getUserLinkList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureInspectionTeamDTO)) {
         return false;
      }

      MesEnclosureInspectionTeamDTO other = (MesEnclosureInspectionTeamDTO)o;
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
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$processName = this.getProcessName();
                        Object other$processName = other.getProcessName();
                        if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                           Object this$userLinkList = this.getUserLinkList();
                           Object other$userLinkList = other.getUserLinkList();
                           return this$userLinkList == null ? other$userLinkList == null : this$userLinkList.equals(other$userLinkList);
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
      return other instanceof MesEnclosureInspectionTeamDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $userLinkList = this.getUserLinkList();
      return result * 59 + ($userLinkList == null ? 43 : $userLinkList.hashCode());
   }

   public static class MesEnclosureInspectionTeamDTOBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long processId;
      private String processName;
      private Long userId;
      private List<MesEnclosureInspectionTeamUserLinkDTO> userLinkList;

      MesEnclosureInspectionTeamDTOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureInspectionTeamDTO.MesEnclosureInspectionTeamDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureInspectionTeamDTO.MesEnclosureInspectionTeamDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureInspectionTeamDTO.MesEnclosureInspectionTeamDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureInspectionTeamDTO.MesEnclosureInspectionTeamDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureInspectionTeamDTO.MesEnclosureInspectionTeamDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public MesEnclosureInspectionTeamDTO.MesEnclosureInspectionTeamDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureInspectionTeamDTO.MesEnclosureInspectionTeamDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userLinkList")
      public MesEnclosureInspectionTeamDTO.MesEnclosureInspectionTeamDTOBuilder userLinkList(final List<MesEnclosureInspectionTeamUserLinkDTO> userLinkList) {
         this.userLinkList = userLinkList;
         return this;
      }

      public MesEnclosureInspectionTeamDTO build() {
         return new MesEnclosureInspectionTeamDTO(
            this.id, this.factoryId, this.workshopId, this.productionLineId, this.processId, this.processName, this.userId, this.userLinkList
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureInspectionTeamDTO.MesEnclosureInspectionTeamDTOBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", userId="
            + this.userId
            + ", userLinkList="
            + this.userLinkList
            + ")";
      }
   }
}
