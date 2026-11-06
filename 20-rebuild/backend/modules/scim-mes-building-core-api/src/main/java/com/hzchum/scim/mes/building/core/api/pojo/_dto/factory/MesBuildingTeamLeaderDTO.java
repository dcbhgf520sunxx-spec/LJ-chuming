package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class MesBuildingTeamLeaderDTO {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "workshopId", notes = "车间id", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @NotNull(message = "车间id不能为空")
   private Long workshopId;
   @ApiModelProperty(name = "processId", notes = "工序id", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @NotNull(message = "工序id不能为空")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名", value = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "productType", notes = "产品类型", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "orgType", notes = "编制属性[0 编制外,1 编制内]", value = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("orgType")
   @JSONField(name = "orgType")
   @NotNull(message = "编制属性必填")
   private Boolean orgType;
   @ApiModelProperty(name = "leaderUserId", notes = "组长id", value = "组长id")
   @JsonProperty("leaderUserId")
   @JSONField(name = "leaderUserId")
   private Long leaderUserId;
   @ApiModelProperty(name = "leaderName", notes = "组长名", value = "组长名")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;

   public static MesBuildingTeamLeaderDTO.MesBuildingTeamLeaderDTOBuilder builder() {
      return new MesBuildingTeamLeaderDTO.MesBuildingTeamLeaderDTOBuilder();
   }

   public MesBuildingTeamLeaderDTO() {
   }

   public MesBuildingTeamLeaderDTO(
      final Long id,
      final Long workshopId,
      final Long processId,
      final String processName,
      final Integer productType,
      final Boolean orgType,
      final Long leaderUserId,
      final String leaderName
   ) {
      this.id = id;
      this.workshopId = workshopId;
      this.processId = processId;
      this.processName = processName;
      this.productType = productType;
      this.orgType = orgType;
      this.leaderUserId = leaderUserId;
      this.leaderName = leaderName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Boolean getOrgType() {
      return this.orgType;
   }

   public Long getLeaderUserId() {
      return this.leaderUserId;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   @JsonProperty("id")
   public MesBuildingTeamLeaderDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingTeamLeaderDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingTeamLeaderDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public MesBuildingTeamLeaderDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingTeamLeaderDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("orgType")
   public MesBuildingTeamLeaderDTO setOrgType(final Boolean orgType) {
      this.orgType = orgType;
      return this;
   }

   @JsonProperty("leaderUserId")
   public MesBuildingTeamLeaderDTO setLeaderUserId(final Long leaderUserId) {
      this.leaderUserId = leaderUserId;
      return this;
   }

   @JsonProperty("leaderName")
   public MesBuildingTeamLeaderDTO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTeamLeaderDTO(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", productType="
         + this.getProductType()
         + ", orgType="
         + this.getOrgType()
         + ", leaderUserId="
         + this.getLeaderUserId()
         + ", leaderName="
         + this.getLeaderName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTeamLeaderDTO)) {
         return false;
      }

      MesBuildingTeamLeaderDTO other = (MesBuildingTeamLeaderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$orgType = this.getOrgType();
                  Object other$orgType = other.getOrgType();
                  if (this$orgType == null ? other$orgType == null : this$orgType.equals(other$orgType)) {
                     Object this$leaderUserId = this.getLeaderUserId();
                     Object other$leaderUserId = other.getLeaderUserId();
                     if (this$leaderUserId == null ? other$leaderUserId == null : this$leaderUserId.equals(other$leaderUserId)) {
                        Object this$processName = this.getProcessName();
                        Object other$processName = other.getProcessName();
                        if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                           Object this$leaderName = this.getLeaderName();
                           Object other$leaderName = other.getLeaderName();
                           return this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName);
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTeamLeaderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $orgType = this.getOrgType();
      result = result * 59 + ($orgType == null ? 43 : $orgType.hashCode());
      Object $leaderUserId = this.getLeaderUserId();
      result = result * 59 + ($leaderUserId == null ? 43 : $leaderUserId.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $leaderName = this.getLeaderName();
      return result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
   }

   public static class MesBuildingTeamLeaderDTOBuilder {
      private Long id;
      private Long workshopId;
      private Long processId;
      private String processName;
      private Integer productType;
      private Boolean orgType;
      private Long leaderUserId;
      private String leaderName;

      MesBuildingTeamLeaderDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTeamLeaderDTO.MesBuildingTeamLeaderDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingTeamLeaderDTO.MesBuildingTeamLeaderDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingTeamLeaderDTO.MesBuildingTeamLeaderDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public MesBuildingTeamLeaderDTO.MesBuildingTeamLeaderDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingTeamLeaderDTO.MesBuildingTeamLeaderDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("orgType")
      public MesBuildingTeamLeaderDTO.MesBuildingTeamLeaderDTOBuilder orgType(final Boolean orgType) {
         this.orgType = orgType;
         return this;
      }

      @JsonProperty("leaderUserId")
      public MesBuildingTeamLeaderDTO.MesBuildingTeamLeaderDTOBuilder leaderUserId(final Long leaderUserId) {
         this.leaderUserId = leaderUserId;
         return this;
      }

      @JsonProperty("leaderName")
      public MesBuildingTeamLeaderDTO.MesBuildingTeamLeaderDTOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      public MesBuildingTeamLeaderDTO build() {
         return new MesBuildingTeamLeaderDTO(
            this.id, this.workshopId, this.processId, this.processName, this.productType, this.orgType, this.leaderUserId, this.leaderName
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTeamLeaderDTO.MesBuildingTeamLeaderDTOBuilder(id="
            + this.id
            + ", workshopId="
            + this.workshopId
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", productType="
            + this.productType
            + ", orgType="
            + this.orgType
            + ", leaderUserId="
            + this.leaderUserId
            + ", leaderName="
            + this.leaderName
            + ")";
      }
   }
}
