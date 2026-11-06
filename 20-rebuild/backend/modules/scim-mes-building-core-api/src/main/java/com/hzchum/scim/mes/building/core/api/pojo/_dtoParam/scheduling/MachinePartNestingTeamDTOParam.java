package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MachinePartNestingTeamDTOParam", description = "零件套料排产班组查询")
public class MachinePartNestingTeamDTOParam {
   @ApiModelProperty(name = "workshopId", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private List<Long> workshopId;
   @ApiModelProperty(name = "yearMonthArray", value = "日期")
   @JsonProperty("yearMonthArray")
   @JSONField(name = "yearMonthArray")
   private List<Long> yearMonthArray;
   @ApiModelProperty(name = "yearMonthArrayStr", value = "日期")
   @JsonProperty("yearMonthArrayStr")
   @JSONField(name = "yearMonthArrayStr")
   private List<String> yearMonthArrayStr;
   @ApiModelProperty(name = "yearMonth", value = "日期")
   @JsonProperty("yearMonth")
   @JSONField(name = "yearMonth")
   private String yearMonth;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "sendNestingStatus", value = "下发状态")
   @JsonProperty("sendNestingStatus")
   @JSONField(name = "sendNestingStatus")
   private Boolean sendNestingStatus;
   @ApiModelProperty(name = "steelPlateTypeEnum", value = "零件类型 1.零件板 2.翼腹板 4成品型材 ")
   @JsonProperty("steelPlateTypeEnum")
   @JSONField(name = "steelPlateTypeEnum")
   private List<Integer> steelPlateTypeEnum;
   @ApiModelProperty(name = "projectIds", value = "项目Id")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   private List<Long> projectIds;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("区域id")
   private Long areaId;

   public static MachinePartNestingTeamDTOParam.MachinePartNestingTeamDTOParamBuilder builder() {
      return new MachinePartNestingTeamDTOParam.MachinePartNestingTeamDTOParamBuilder();
   }

   public MachinePartNestingTeamDTOParam(
      final List<Long> workshopId,
      final List<Long> yearMonthArray,
      final List<String> yearMonthArrayStr,
      final String yearMonth,
      final Long projectId,
      final Boolean sendNestingStatus,
      final List<Integer> steelPlateTypeEnum,
      final List<Long> projectIds,
      final Long monomerId,
      final Long areaId
   ) {
      this.workshopId = workshopId;
      this.yearMonthArray = yearMonthArray;
      this.yearMonthArrayStr = yearMonthArrayStr;
      this.yearMonth = yearMonth;
      this.projectId = projectId;
      this.sendNestingStatus = sendNestingStatus;
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      this.projectIds = projectIds;
      this.monomerId = monomerId;
      this.areaId = areaId;
   }

   public MachinePartNestingTeamDTOParam() {
   }

   public List<Long> getWorkshopId() {
      return this.workshopId;
   }

   public List<Long> getYearMonthArray() {
      return this.yearMonthArray;
   }

   public List<String> getYearMonthArrayStr() {
      return this.yearMonthArrayStr;
   }

   public String getYearMonth() {
      return this.yearMonth;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Boolean getSendNestingStatus() {
      return this.sendNestingStatus;
   }

   public List<Integer> getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   @JsonProperty("workshopId")
   public MachinePartNestingTeamDTOParam setWorkshopId(final List<Long> workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("yearMonthArray")
   public MachinePartNestingTeamDTOParam setYearMonthArray(final List<Long> yearMonthArray) {
      this.yearMonthArray = yearMonthArray;
      return this;
   }

   @JsonProperty("yearMonthArrayStr")
   public MachinePartNestingTeamDTOParam setYearMonthArrayStr(final List<String> yearMonthArrayStr) {
      this.yearMonthArrayStr = yearMonthArrayStr;
      return this;
   }

   @JsonProperty("yearMonth")
   public MachinePartNestingTeamDTOParam setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
      return this;
   }

   @JsonProperty("projectId")
   public MachinePartNestingTeamDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("sendNestingStatus")
   public MachinePartNestingTeamDTOParam setSendNestingStatus(final Boolean sendNestingStatus) {
      this.sendNestingStatus = sendNestingStatus;
      return this;
   }

   @JsonProperty("steelPlateTypeEnum")
   public MachinePartNestingTeamDTOParam setSteelPlateTypeEnum(final List<Integer> steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      return this;
   }

   @JsonProperty("projectIds")
   public MachinePartNestingTeamDTOParam setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   public MachinePartNestingTeamDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MachinePartNestingTeamDTOParam setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartNestingTeamDTOParam(workshopId="
         + this.getWorkshopId()
         + ", yearMonthArray="
         + this.getYearMonthArray()
         + ", yearMonthArrayStr="
         + this.getYearMonthArrayStr()
         + ", yearMonth="
         + this.getYearMonth()
         + ", projectId="
         + this.getProjectId()
         + ", sendNestingStatus="
         + this.getSendNestingStatus()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ", projectIds="
         + this.getProjectIds()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartNestingTeamDTOParam)) {
         return false;
      }

      MachinePartNestingTeamDTOParam other = (MachinePartNestingTeamDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$sendNestingStatus = this.getSendNestingStatus();
         Object other$sendNestingStatus = other.getSendNestingStatus();
         if (this$sendNestingStatus == null ? other$sendNestingStatus == null : this$sendNestingStatus.equals(other$sendNestingStatus)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$yearMonthArray = this.getYearMonthArray();
                     Object other$yearMonthArray = other.getYearMonthArray();
                     if (this$yearMonthArray == null ? other$yearMonthArray == null : this$yearMonthArray.equals(other$yearMonthArray)) {
                        Object this$yearMonthArrayStr = this.getYearMonthArrayStr();
                        Object other$yearMonthArrayStr = other.getYearMonthArrayStr();
                        if (this$yearMonthArrayStr == null ? other$yearMonthArrayStr == null : this$yearMonthArrayStr.equals(other$yearMonthArrayStr)) {
                           Object this$yearMonth = this.getYearMonth();
                           Object other$yearMonth = other.getYearMonth();
                           if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
                              Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
                              Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
                              if (this$steelPlateTypeEnum == null ? other$steelPlateTypeEnum == null : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)
                                 )
                               {
                                 Object this$projectIds = this.getProjectIds();
                                 Object other$projectIds = other.getProjectIds();
                                 return this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds);
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
      return other instanceof MachinePartNestingTeamDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $sendNestingStatus = this.getSendNestingStatus();
      result = result * 59 + ($sendNestingStatus == null ? 43 : $sendNestingStatus.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $yearMonthArray = this.getYearMonthArray();
      result = result * 59 + ($yearMonthArray == null ? 43 : $yearMonthArray.hashCode());
      Object $yearMonthArrayStr = this.getYearMonthArrayStr();
      result = result * 59 + ($yearMonthArrayStr == null ? 43 : $yearMonthArrayStr.hashCode());
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $projectIds = this.getProjectIds();
      return result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
   }

   public static class MachinePartNestingTeamDTOParamBuilder {
      private List<Long> workshopId;
      private List<Long> yearMonthArray;
      private List<String> yearMonthArrayStr;
      private String yearMonth;
      private Long projectId;
      private Boolean sendNestingStatus;
      private List<Integer> steelPlateTypeEnum;
      private List<Long> projectIds;
      private Long monomerId;
      private Long areaId;

      MachinePartNestingTeamDTOParamBuilder() {
      }

      @JsonProperty("workshopId")
      public MachinePartNestingTeamDTOParam.MachinePartNestingTeamDTOParamBuilder workshopId(final List<Long> workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("yearMonthArray")
      public MachinePartNestingTeamDTOParam.MachinePartNestingTeamDTOParamBuilder yearMonthArray(final List<Long> yearMonthArray) {
         this.yearMonthArray = yearMonthArray;
         return this;
      }

      @JsonProperty("yearMonthArrayStr")
      public MachinePartNestingTeamDTOParam.MachinePartNestingTeamDTOParamBuilder yearMonthArrayStr(final List<String> yearMonthArrayStr) {
         this.yearMonthArrayStr = yearMonthArrayStr;
         return this;
      }

      @JsonProperty("yearMonth")
      public MachinePartNestingTeamDTOParam.MachinePartNestingTeamDTOParamBuilder yearMonth(final String yearMonth) {
         this.yearMonth = yearMonth;
         return this;
      }

      @JsonProperty("projectId")
      public MachinePartNestingTeamDTOParam.MachinePartNestingTeamDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("sendNestingStatus")
      public MachinePartNestingTeamDTOParam.MachinePartNestingTeamDTOParamBuilder sendNestingStatus(final Boolean sendNestingStatus) {
         this.sendNestingStatus = sendNestingStatus;
         return this;
      }

      @JsonProperty("steelPlateTypeEnum")
      public MachinePartNestingTeamDTOParam.MachinePartNestingTeamDTOParamBuilder steelPlateTypeEnum(final List<Integer> steelPlateTypeEnum) {
         this.steelPlateTypeEnum = steelPlateTypeEnum;
         return this;
      }

      @JsonProperty("projectIds")
      public MachinePartNestingTeamDTOParam.MachinePartNestingTeamDTOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public MachinePartNestingTeamDTOParam.MachinePartNestingTeamDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MachinePartNestingTeamDTOParam.MachinePartNestingTeamDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MachinePartNestingTeamDTOParam build() {
         return new MachinePartNestingTeamDTOParam(
            this.workshopId,
            this.yearMonthArray,
            this.yearMonthArrayStr,
            this.yearMonth,
            this.projectId,
            this.sendNestingStatus,
            this.steelPlateTypeEnum,
            this.projectIds,
            this.monomerId,
            this.areaId
         );
      }

      @Override
      public String toString() {
         return "MachinePartNestingTeamDTOParam.MachinePartNestingTeamDTOParamBuilder(workshopId="
            + this.workshopId
            + ", yearMonthArray="
            + this.yearMonthArray
            + ", yearMonthArrayStr="
            + this.yearMonthArrayStr
            + ", yearMonth="
            + this.yearMonth
            + ", projectId="
            + this.projectId
            + ", sendNestingStatus="
            + this.sendNestingStatus
            + ", steelPlateTypeEnum="
            + this.steelPlateTypeEnum
            + ", projectIds="
            + this.projectIds
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ")";
      }
   }
}
