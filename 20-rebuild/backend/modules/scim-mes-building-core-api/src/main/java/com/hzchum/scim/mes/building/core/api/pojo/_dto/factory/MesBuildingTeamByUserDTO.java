package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class MesBuildingTeamByUserDTO {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "processId", notes = "工序id", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名", value = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "productType", notes = "产品类型", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "workshopId", notes = "车间id", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", notes = "车间名", value = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineName", notes = "产线名", value = "产线名")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "groupsId", notes = "生产组id", value = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "groupsName", notes = "生产组名", value = "生产组名")
   @JsonProperty("groupsName")
   @JSONField(name = "groupsName")
   private String groupsName;
   @ApiModelProperty(name = "teamId", notes = "班组id", value = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;

   public static MesBuildingTeamByUserDTO.MesBuildingTeamByUserDTOBuilder builder() {
      return new MesBuildingTeamByUserDTO.MesBuildingTeamByUserDTOBuilder();
   }

   public MesBuildingTeamByUserDTO() {
   }

   public MesBuildingTeamByUserDTO(
      final Long id,
      final Long processId,
      final String processName,
      final Integer productType,
      final Long workshopId,
      final String workshopName,
      final Long productionLineId,
      final String productionLineName,
      final Long groupsId,
      final String groupsName,
      final Long teamId
   ) {
      this.id = id;
      this.processId = processId;
      this.processName = processName;
      this.productType = productType;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.groupsId = groupsId;
      this.groupsName = groupsName;
      this.teamId = teamId;
   }

   public Long getId() {
      return this.id;
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

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public String getGroupsName() {
      return this.groupsName;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   @JsonProperty("id")
   public MesBuildingTeamByUserDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingTeamByUserDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public MesBuildingTeamByUserDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingTeamByUserDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingTeamByUserDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("workshopName")
   public MesBuildingTeamByUserDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTeamByUserDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineName")
   public MesBuildingTeamByUserDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingTeamByUserDTO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("groupsName")
   public MesBuildingTeamByUserDTO setGroupsName(final String groupsName) {
      this.groupsName = groupsName;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingTeamByUserDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTeamByUserDTO(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", productType="
         + this.getProductType()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", groupsId="
         + this.getGroupsId()
         + ", groupsName="
         + this.getGroupsName()
         + ", teamId="
         + this.getTeamId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTeamByUserDTO)) {
         return false;
      }

      MesBuildingTeamByUserDTO other = (MesBuildingTeamByUserDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$productionLineId = this.getProductionLineId();
                  Object other$productionLineId = other.getProductionLineId();
                  if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                     Object this$groupsId = this.getGroupsId();
                     Object other$groupsId = other.getGroupsId();
                     if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                        Object this$teamId = this.getTeamId();
                        Object other$teamId = other.getTeamId();
                        if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                           Object this$processName = this.getProcessName();
                           Object other$processName = other.getProcessName();
                           if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                              Object this$workshopName = this.getWorkshopName();
                              Object other$workshopName = other.getWorkshopName();
                              if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                 Object this$productionLineName = this.getProductionLineName();
                                 Object other$productionLineName = other.getProductionLineName();
                                 if (this$productionLineName == null
                                    ? other$productionLineName == null
                                    : this$productionLineName.equals(other$productionLineName)) {
                                    Object this$groupsName = this.getGroupsName();
                                    Object other$groupsName = other.getGroupsName();
                                    return this$groupsName == null ? other$groupsName == null : this$groupsName.equals(other$groupsName);
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTeamByUserDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $groupsName = this.getGroupsName();
      return result * 59 + ($groupsName == null ? 43 : $groupsName.hashCode());
   }

   public static class MesBuildingTeamByUserDTOBuilder {
      private Long id;
      private Long processId;
      private String processName;
      private Integer productType;
      private Long workshopId;
      private String workshopName;
      private Long productionLineId;
      private String productionLineName;
      private Long groupsId;
      private String groupsName;
      private Long teamId;

      MesBuildingTeamByUserDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTeamByUserDTO.MesBuildingTeamByUserDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingTeamByUserDTO.MesBuildingTeamByUserDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public MesBuildingTeamByUserDTO.MesBuildingTeamByUserDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingTeamByUserDTO.MesBuildingTeamByUserDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingTeamByUserDTO.MesBuildingTeamByUserDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("workshopName")
      public MesBuildingTeamByUserDTO.MesBuildingTeamByUserDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingTeamByUserDTO.MesBuildingTeamByUserDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineName")
      public MesBuildingTeamByUserDTO.MesBuildingTeamByUserDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingTeamByUserDTO.MesBuildingTeamByUserDTOBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("groupsName")
      public MesBuildingTeamByUserDTO.MesBuildingTeamByUserDTOBuilder groupsName(final String groupsName) {
         this.groupsName = groupsName;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingTeamByUserDTO.MesBuildingTeamByUserDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesBuildingTeamByUserDTO build() {
         return new MesBuildingTeamByUserDTO(
            this.id,
            this.processId,
            this.processName,
            this.productType,
            this.workshopId,
            this.workshopName,
            this.productionLineId,
            this.productionLineName,
            this.groupsId,
            this.groupsName,
            this.teamId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTeamByUserDTO.MesBuildingTeamByUserDTOBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", productType="
            + this.productType
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", productionLineId="
            + this.productionLineId
            + ", productionLineName="
            + this.productionLineName
            + ", groupsId="
            + this.groupsId
            + ", groupsName="
            + this.groupsName
            + ", teamId="
            + this.teamId
            + ")";
      }
   }
}
