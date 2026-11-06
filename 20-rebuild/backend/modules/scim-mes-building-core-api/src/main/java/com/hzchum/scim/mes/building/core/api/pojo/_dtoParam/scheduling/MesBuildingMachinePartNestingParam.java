package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingMachinePartNestingParam", description = "零件套料排产零件")
public class MesBuildingMachinePartNestingParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty(name = "teamCode", value = "团队码", notes = "团队码")
   @JsonProperty("teamCode")
   @JSONField(name = "teamCode")
   private Long teamCode;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "completionDate", value = "完成日期", notes = "完成日期")
   @JsonProperty("completionDate")
   @JSONField(name = "completionDate")
   private String completionDate;
   @ApiModelProperty(name = "machinePartList", value = "零件集合", notes = "零件集合")
   @JsonProperty("machinePartList")
   @JSONField(name = "machinePartList")
   private List<MachinePartParam> machinePartList;

   public static MesBuildingMachinePartNestingParam.MesBuildingMachinePartNestingParamBuilder builder() {
      return new MesBuildingMachinePartNestingParam.MesBuildingMachinePartNestingParamBuilder();
   }

   public MesBuildingMachinePartNestingParam(
      final Long projectId,
      final Long teamCode,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final String completionDate,
      final List<MachinePartParam> machinePartList
   ) {
      this.projectId = projectId;
      this.teamCode = teamCode;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.completionDate = completionDate;
      this.machinePartList = machinePartList;
   }

   public MesBuildingMachinePartNestingParam() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getTeamCode() {
      return this.teamCode;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public String getCompletionDate() {
      return this.completionDate;
   }

   public List<MachinePartParam> getMachinePartList() {
      return this.machinePartList;
   }

   public MesBuildingMachinePartNestingParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("teamCode")
   public MesBuildingMachinePartNestingParam setTeamCode(final Long teamCode) {
      this.teamCode = teamCode;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingMachinePartNestingParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingMachinePartNestingParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingMachinePartNestingParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("completionDate")
   public MesBuildingMachinePartNestingParam setCompletionDate(final String completionDate) {
      this.completionDate = completionDate;
      return this;
   }

   @JsonProperty("machinePartList")
   public MesBuildingMachinePartNestingParam setMachinePartList(final List<MachinePartParam> machinePartList) {
      this.machinePartList = machinePartList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartNestingParam(projectId="
         + this.getProjectId()
         + ", teamCode="
         + this.getTeamCode()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", completionDate="
         + this.getCompletionDate()
         + ", machinePartList="
         + this.getMachinePartList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartNestingParam)) {
         return false;
      }

      MesBuildingMachinePartNestingParam other = (MesBuildingMachinePartNestingParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$teamCode = this.getTeamCode();
         Object other$teamCode = other.getTeamCode();
         if (this$teamCode == null ? other$teamCode == null : this$teamCode.equals(other$teamCode)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$groupsId = this.getGroupsId();
                  Object other$groupsId = other.getGroupsId();
                  if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                     Object this$completionDate = this.getCompletionDate();
                     Object other$completionDate = other.getCompletionDate();
                     if (this$completionDate == null ? other$completionDate == null : this$completionDate.equals(other$completionDate)) {
                        Object this$machinePartList = this.getMachinePartList();
                        Object other$machinePartList = other.getMachinePartList();
                        return this$machinePartList == null ? other$machinePartList == null : this$machinePartList.equals(other$machinePartList);
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
      return other instanceof MesBuildingMachinePartNestingParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $teamCode = this.getTeamCode();
      result = result * 59 + ($teamCode == null ? 43 : $teamCode.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $completionDate = this.getCompletionDate();
      result = result * 59 + ($completionDate == null ? 43 : $completionDate.hashCode());
      Object $machinePartList = this.getMachinePartList();
      return result * 59 + ($machinePartList == null ? 43 : $machinePartList.hashCode());
   }

   public static class MesBuildingMachinePartNestingParamBuilder {
      private Long projectId;
      private Long teamCode;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private String completionDate;
      private List<MachinePartParam> machinePartList;

      MesBuildingMachinePartNestingParamBuilder() {
      }

      public MesBuildingMachinePartNestingParam.MesBuildingMachinePartNestingParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("teamCode")
      public MesBuildingMachinePartNestingParam.MesBuildingMachinePartNestingParamBuilder teamCode(final Long teamCode) {
         this.teamCode = teamCode;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingMachinePartNestingParam.MesBuildingMachinePartNestingParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingMachinePartNestingParam.MesBuildingMachinePartNestingParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingMachinePartNestingParam.MesBuildingMachinePartNestingParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("completionDate")
      public MesBuildingMachinePartNestingParam.MesBuildingMachinePartNestingParamBuilder completionDate(final String completionDate) {
         this.completionDate = completionDate;
         return this;
      }

      @JsonProperty("machinePartList")
      public MesBuildingMachinePartNestingParam.MesBuildingMachinePartNestingParamBuilder machinePartList(final List<MachinePartParam> machinePartList) {
         this.machinePartList = machinePartList;
         return this;
      }

      public MesBuildingMachinePartNestingParam build() {
         return new MesBuildingMachinePartNestingParam(
            this.projectId, this.teamCode, this.workshopId, this.productionLineId, this.groupsId, this.completionDate, this.machinePartList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartNestingParam.MesBuildingMachinePartNestingParamBuilder(projectId="
            + this.projectId
            + ", teamCode="
            + this.teamCode
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", completionDate="
            + this.completionDate
            + ", machinePartList="
            + this.machinePartList
            + ")";
      }
   }
}
