package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MachinePartNestingTeamDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MachinePartNestingTeamDTOParam", description = "零件套料排产零件查询")
public class MachinePartNestingProductDTOParam {
   @ApiModelProperty("零件套料排产班组集合")
   @JsonProperty("machinePartNestingTeamDTOList")
   @JSONField(name = "machinePartNestingTeamDTOList")
   private List<MachinePartNestingTeamDTO> machinePartNestingTeamDTOList;
   @ApiModelProperty("年月集合")
   @JsonProperty("monthList")
   @JSONField(name = "monthList")
   private List<Long> monthList;
   @ApiModelProperty("组装后的日期")
   @JsonProperty("yearMonth")
   @JSONField(name = "yearMonth")
   private String yearMonth;
   @ApiModelProperty("项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty("班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty("生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty("车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty("零件类型")
   @JsonProperty("partType")
   @JSONField(name = "partType")
   private String partType;
   @ApiModelProperty("零件来源")
   @JsonProperty("partSource")
   @JSONField(name = "partSource")
   private String partSource;
   @ApiModelProperty("厚度")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   private String thick;
   @ApiModelProperty("最小宽度")
   @JsonProperty("minWidth")
   @JSONField(name = "minWidth")
   private String minWidth;
   @ApiModelProperty("最大宽度")
   @JsonProperty("maxWidth")
   @JSONField(name = "maxWidth")
   private String maxWidth;
   @ApiModelProperty("最小长度")
   @JsonProperty("minLength")
   @JSONField(name = "minLength")
   private String minLength;
   @ApiModelProperty("最大长度")
   @JsonProperty("maxLength")
   @JSONField(name = "maxLength")
   private String maxLength;
   @ApiModelProperty("是否有图纸")
   @JsonProperty("boolDxfEnum")
   @JSONField(name = "boolDxfEnum")
   private Boolean boolDxfEnum;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;

   public static MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder builder() {
      return new MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder();
   }

   public MachinePartNestingProductDTOParam(
      final List<MachinePartNestingTeamDTO> machinePartNestingTeamDTOList,
      final List<Long> monthList,
      final String yearMonth,
      final Long projectId,
      final Long teamId,
      final Long groupsId,
      final Long workshopId,
      final String partType,
      final String partSource,
      final String thick,
      final String minWidth,
      final String maxWidth,
      final String minLength,
      final String maxLength,
      final Boolean boolDxfEnum,
      final Integer taskTypeEnum
   ) {
      this.machinePartNestingTeamDTOList = machinePartNestingTeamDTOList;
      this.monthList = monthList;
      this.yearMonth = yearMonth;
      this.projectId = projectId;
      this.teamId = teamId;
      this.groupsId = groupsId;
      this.workshopId = workshopId;
      this.partType = partType;
      this.partSource = partSource;
      this.thick = thick;
      this.minWidth = minWidth;
      this.maxWidth = maxWidth;
      this.minLength = minLength;
      this.maxLength = maxLength;
      this.boolDxfEnum = boolDxfEnum;
      this.taskTypeEnum = taskTypeEnum;
   }

   public MachinePartNestingProductDTOParam() {
   }

   public List<MachinePartNestingTeamDTO> getMachinePartNestingTeamDTOList() {
      return this.machinePartNestingTeamDTOList;
   }

   public List<Long> getMonthList() {
      return this.monthList;
   }

   public String getYearMonth() {
      return this.yearMonth;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getPartType() {
      return this.partType;
   }

   public String getPartSource() {
      return this.partSource;
   }

   public String getThick() {
      return this.thick;
   }

   public String getMinWidth() {
      return this.minWidth;
   }

   public String getMaxWidth() {
      return this.maxWidth;
   }

   public String getMinLength() {
      return this.minLength;
   }

   public String getMaxLength() {
      return this.maxLength;
   }

   public Boolean getBoolDxfEnum() {
      return this.boolDxfEnum;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   @JsonProperty("machinePartNestingTeamDTOList")
   public MachinePartNestingProductDTOParam setMachinePartNestingTeamDTOList(final List<MachinePartNestingTeamDTO> machinePartNestingTeamDTOList) {
      this.machinePartNestingTeamDTOList = machinePartNestingTeamDTOList;
      return this;
   }

   @JsonProperty("monthList")
   public MachinePartNestingProductDTOParam setMonthList(final List<Long> monthList) {
      this.monthList = monthList;
      return this;
   }

   @JsonProperty("yearMonth")
   public MachinePartNestingProductDTOParam setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
      return this;
   }

   @JsonProperty("projectId")
   public MachinePartNestingProductDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("teamId")
   public MachinePartNestingProductDTOParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("groupsId")
   public MachinePartNestingProductDTOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("workshopId")
   public MachinePartNestingProductDTOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("partType")
   public MachinePartNestingProductDTOParam setPartType(final String partType) {
      this.partType = partType;
      return this;
   }

   @JsonProperty("partSource")
   public MachinePartNestingProductDTOParam setPartSource(final String partSource) {
      this.partSource = partSource;
      return this;
   }

   @JsonProperty("thick")
   public MachinePartNestingProductDTOParam setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("minWidth")
   public MachinePartNestingProductDTOParam setMinWidth(final String minWidth) {
      this.minWidth = minWidth;
      return this;
   }

   @JsonProperty("maxWidth")
   public MachinePartNestingProductDTOParam setMaxWidth(final String maxWidth) {
      this.maxWidth = maxWidth;
      return this;
   }

   @JsonProperty("minLength")
   public MachinePartNestingProductDTOParam setMinLength(final String minLength) {
      this.minLength = minLength;
      return this;
   }

   @JsonProperty("maxLength")
   public MachinePartNestingProductDTOParam setMaxLength(final String maxLength) {
      this.maxLength = maxLength;
      return this;
   }

   @JsonProperty("boolDxfEnum")
   public MachinePartNestingProductDTOParam setBoolDxfEnum(final Boolean boolDxfEnum) {
      this.boolDxfEnum = boolDxfEnum;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MachinePartNestingProductDTOParam setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartNestingProductDTOParam(machinePartNestingTeamDTOList="
         + this.getMachinePartNestingTeamDTOList()
         + ", monthList="
         + this.getMonthList()
         + ", yearMonth="
         + this.getYearMonth()
         + ", projectId="
         + this.getProjectId()
         + ", teamId="
         + this.getTeamId()
         + ", groupsId="
         + this.getGroupsId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", partType="
         + this.getPartType()
         + ", partSource="
         + this.getPartSource()
         + ", thick="
         + this.getThick()
         + ", minWidth="
         + this.getMinWidth()
         + ", maxWidth="
         + this.getMaxWidth()
         + ", minLength="
         + this.getMinLength()
         + ", maxLength="
         + this.getMaxLength()
         + ", boolDxfEnum="
         + this.getBoolDxfEnum()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartNestingProductDTOParam)) {
         return false;
      }

      MachinePartNestingProductDTOParam other = (MachinePartNestingProductDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$teamId = this.getTeamId();
         Object other$teamId = other.getTeamId();
         if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
            Object this$groupsId = this.getGroupsId();
            Object other$groupsId = other.getGroupsId();
            if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$boolDxfEnum = this.getBoolDxfEnum();
                  Object other$boolDxfEnum = other.getBoolDxfEnum();
                  if (this$boolDxfEnum == null ? other$boolDxfEnum == null : this$boolDxfEnum.equals(other$boolDxfEnum)) {
                     Object this$taskTypeEnum = this.getTaskTypeEnum();
                     Object other$taskTypeEnum = other.getTaskTypeEnum();
                     if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                        Object this$machinePartNestingTeamDTOList = this.getMachinePartNestingTeamDTOList();
                        Object other$machinePartNestingTeamDTOList = other.getMachinePartNestingTeamDTOList();
                        if (this$machinePartNestingTeamDTOList == null
                           ? other$machinePartNestingTeamDTOList == null
                           : this$machinePartNestingTeamDTOList.equals(other$machinePartNestingTeamDTOList)) {
                           Object this$monthList = this.getMonthList();
                           Object other$monthList = other.getMonthList();
                           if (this$monthList == null ? other$monthList == null : this$monthList.equals(other$monthList)) {
                              Object this$yearMonth = this.getYearMonth();
                              Object other$yearMonth = other.getYearMonth();
                              if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
                                 Object this$partType = this.getPartType();
                                 Object other$partType = other.getPartType();
                                 if (this$partType == null ? other$partType == null : this$partType.equals(other$partType)) {
                                    Object this$partSource = this.getPartSource();
                                    Object other$partSource = other.getPartSource();
                                    if (this$partSource == null ? other$partSource == null : this$partSource.equals(other$partSource)) {
                                       Object this$thick = this.getThick();
                                       Object other$thick = other.getThick();
                                       if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                          Object this$minWidth = this.getMinWidth();
                                          Object other$minWidth = other.getMinWidth();
                                          if (this$minWidth == null ? other$minWidth == null : this$minWidth.equals(other$minWidth)) {
                                             Object this$maxWidth = this.getMaxWidth();
                                             Object other$maxWidth = other.getMaxWidth();
                                             if (this$maxWidth == null ? other$maxWidth == null : this$maxWidth.equals(other$maxWidth)) {
                                                Object this$minLength = this.getMinLength();
                                                Object other$minLength = other.getMinLength();
                                                if (this$minLength == null ? other$minLength == null : this$minLength.equals(other$minLength)) {
                                                   Object this$maxLength = this.getMaxLength();
                                                   Object other$maxLength = other.getMaxLength();
                                                   return this$maxLength == null ? other$maxLength == null : this$maxLength.equals(other$maxLength);
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
      return other instanceof MachinePartNestingProductDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $boolDxfEnum = this.getBoolDxfEnum();
      result = result * 59 + ($boolDxfEnum == null ? 43 : $boolDxfEnum.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $machinePartNestingTeamDTOList = this.getMachinePartNestingTeamDTOList();
      result = result * 59 + ($machinePartNestingTeamDTOList == null ? 43 : $machinePartNestingTeamDTOList.hashCode());
      Object $monthList = this.getMonthList();
      result = result * 59 + ($monthList == null ? 43 : $monthList.hashCode());
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $partType = this.getPartType();
      result = result * 59 + ($partType == null ? 43 : $partType.hashCode());
      Object $partSource = this.getPartSource();
      result = result * 59 + ($partSource == null ? 43 : $partSource.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $minWidth = this.getMinWidth();
      result = result * 59 + ($minWidth == null ? 43 : $minWidth.hashCode());
      Object $maxWidth = this.getMaxWidth();
      result = result * 59 + ($maxWidth == null ? 43 : $maxWidth.hashCode());
      Object $minLength = this.getMinLength();
      result = result * 59 + ($minLength == null ? 43 : $minLength.hashCode());
      Object $maxLength = this.getMaxLength();
      return result * 59 + ($maxLength == null ? 43 : $maxLength.hashCode());
   }

   public static class MachinePartNestingProductDTOParamBuilder {
      private List<MachinePartNestingTeamDTO> machinePartNestingTeamDTOList;
      private List<Long> monthList;
      private String yearMonth;
      private Long projectId;
      private Long teamId;
      private Long groupsId;
      private Long workshopId;
      private String partType;
      private String partSource;
      private String thick;
      private String minWidth;
      private String maxWidth;
      private String minLength;
      private String maxLength;
      private Boolean boolDxfEnum;
      private Integer taskTypeEnum;

      MachinePartNestingProductDTOParamBuilder() {
      }

      @JsonProperty("machinePartNestingTeamDTOList")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder machinePartNestingTeamDTOList(
         final List<MachinePartNestingTeamDTO> machinePartNestingTeamDTOList
      ) {
         this.machinePartNestingTeamDTOList = machinePartNestingTeamDTOList;
         return this;
      }

      @JsonProperty("monthList")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder monthList(final List<Long> monthList) {
         this.monthList = monthList;
         return this;
      }

      @JsonProperty("yearMonth")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder yearMonth(final String yearMonth) {
         this.yearMonth = yearMonth;
         return this;
      }

      @JsonProperty("projectId")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("teamId")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("groupsId")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("workshopId")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("partType")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder partType(final String partType) {
         this.partType = partType;
         return this;
      }

      @JsonProperty("partSource")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder partSource(final String partSource) {
         this.partSource = partSource;
         return this;
      }

      @JsonProperty("thick")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("minWidth")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder minWidth(final String minWidth) {
         this.minWidth = minWidth;
         return this;
      }

      @JsonProperty("maxWidth")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder maxWidth(final String maxWidth) {
         this.maxWidth = maxWidth;
         return this;
      }

      @JsonProperty("minLength")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder minLength(final String minLength) {
         this.minLength = minLength;
         return this;
      }

      @JsonProperty("maxLength")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder maxLength(final String maxLength) {
         this.maxLength = maxLength;
         return this;
      }

      @JsonProperty("boolDxfEnum")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder boolDxfEnum(final Boolean boolDxfEnum) {
         this.boolDxfEnum = boolDxfEnum;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public MachinePartNestingProductDTOParam build() {
         return new MachinePartNestingProductDTOParam(
            this.machinePartNestingTeamDTOList,
            this.monthList,
            this.yearMonth,
            this.projectId,
            this.teamId,
            this.groupsId,
            this.workshopId,
            this.partType,
            this.partSource,
            this.thick,
            this.minWidth,
            this.maxWidth,
            this.minLength,
            this.maxLength,
            this.boolDxfEnum,
            this.taskTypeEnum
         );
      }

      @Override
      public String toString() {
         return "MachinePartNestingProductDTOParam.MachinePartNestingProductDTOParamBuilder(machinePartNestingTeamDTOList="
            + this.machinePartNestingTeamDTOList
            + ", monthList="
            + this.monthList
            + ", yearMonth="
            + this.yearMonth
            + ", projectId="
            + this.projectId
            + ", teamId="
            + this.teamId
            + ", groupsId="
            + this.groupsId
            + ", workshopId="
            + this.workshopId
            + ", partType="
            + this.partType
            + ", partSource="
            + this.partSource
            + ", thick="
            + this.thick
            + ", minWidth="
            + this.minWidth
            + ", maxWidth="
            + this.maxWidth
            + ", minLength="
            + this.minLength
            + ", maxLength="
            + this.maxLength
            + ", boolDxfEnum="
            + this.boolDxfEnum
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ")";
      }
   }
}
