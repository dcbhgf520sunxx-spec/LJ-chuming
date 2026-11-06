package com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.building.core.api.enums.MeteUnitEnum;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

public class MesDailyProductionTaskDOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "workShopId", value = "车间Id")
   private Long workShopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线Id", notes = "生产线Id")
   private Long productionLineId;
   @ApiModelProperty(name = "teamId", value = "班组Id", notes = "班组Id")
   private Long teamId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaIdList", value = "区域Id")
   private List<Long> areaIdList;
   @ApiModelProperty(name = "processId", value = "工序Id")
   private Long processId;
   @ApiModelProperty(name = "dateTime", value = "查询时间")
   @NotNull(message = "搜索时间不可为空!")
   private LocalDateTime dateTime;
   @ApiModelProperty(name = "productionLineIds", value = "产线id列表")
   private List<Long> productionLineIds;
   @ApiModelProperty(name = "meteUnitEnum", value = "净重/毛重")
   @EnumValidator(value = MeteUnitEnum.class, message = "净重毛重参数不存在")
   private Integer meteUnitEnum;

   public static MesDailyProductionTaskDOParam.MesDailyProductionTaskDOParamBuilder builder() {
      return new MesDailyProductionTaskDOParam.MesDailyProductionTaskDOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public List<Long> getAreaIdList() {
      return this.areaIdList;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public LocalDateTime getDateTime() {
      return this.dateTime;
   }

   public List<Long> getProductionLineIds() {
      return this.productionLineIds;
   }

   public Integer getMeteUnitEnum() {
      return this.meteUnitEnum;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
   }

   public void setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaIdList(final List<Long> areaIdList) {
      this.areaIdList = areaIdList;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setDateTime(final LocalDateTime dateTime) {
      this.dateTime = dateTime;
   }

   public void setProductionLineIds(final List<Long> productionLineIds) {
      this.productionLineIds = productionLineIds;
   }

   public void setMeteUnitEnum(final Integer meteUnitEnum) {
      this.meteUnitEnum = meteUnitEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesDailyProductionTaskDOParam)) {
         return false;
      }

      MesDailyProductionTaskDOParam other = (MesDailyProductionTaskDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$workShopId = this.getWorkShopId();
         Object other$workShopId = other.getWorkShopId();
         if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
            Object this$productionLineId = this.getProductionLineId();
            Object other$productionLineId = other.getProductionLineId();
            if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$processId = this.getProcessId();
                     Object other$processId = other.getProcessId();
                     if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                        Object this$meteUnitEnum = this.getMeteUnitEnum();
                        Object other$meteUnitEnum = other.getMeteUnitEnum();
                        if (this$meteUnitEnum == null ? other$meteUnitEnum == null : this$meteUnitEnum.equals(other$meteUnitEnum)) {
                           Object this$areaIdList = this.getAreaIdList();
                           Object other$areaIdList = other.getAreaIdList();
                           if (this$areaIdList == null ? other$areaIdList == null : this$areaIdList.equals(other$areaIdList)) {
                              Object this$dateTime = this.getDateTime();
                              Object other$dateTime = other.getDateTime();
                              if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesDailyProductionTaskDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $meteUnitEnum = this.getMeteUnitEnum();
      result = result * 59 + ($meteUnitEnum == null ? 43 : $meteUnitEnum.hashCode());
      Object $areaIdList = this.getAreaIdList();
      result = result * 59 + ($areaIdList == null ? 43 : $areaIdList.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $productionLineIds = this.getProductionLineIds();
      return result * 59 + ($productionLineIds == null ? 43 : $productionLineIds.hashCode());
   }

   @Override
   public String toString() {
      return "MesDailyProductionTaskDOParam(projectId="
         + this.getProjectId()
         + ", workShopId="
         + this.getWorkShopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", teamId="
         + this.getTeamId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaIdList="
         + this.getAreaIdList()
         + ", processId="
         + this.getProcessId()
         + ", dateTime="
         + this.getDateTime()
         + ", productionLineIds="
         + this.getProductionLineIds()
         + ", meteUnitEnum="
         + this.getMeteUnitEnum()
         + ")";
   }

   public MesDailyProductionTaskDOParam() {
   }

   public MesDailyProductionTaskDOParam(
      final Long projectId,
      final Long workShopId,
      final Long productionLineId,
      final Long teamId,
      final Long monomerId,
      final List<Long> areaIdList,
      final Long processId,
      final LocalDateTime dateTime,
      final List<Long> productionLineIds,
      final Integer meteUnitEnum
   ) {
      this.projectId = projectId;
      this.workShopId = workShopId;
      this.productionLineId = productionLineId;
      this.teamId = teamId;
      this.monomerId = monomerId;
      this.areaIdList = areaIdList;
      this.processId = processId;
      this.dateTime = dateTime;
      this.productionLineIds = productionLineIds;
      this.meteUnitEnum = meteUnitEnum;
   }

   public static class MesDailyProductionTaskDOParamBuilder {
      private Long projectId;
      private Long workShopId;
      private Long productionLineId;
      private Long teamId;
      private Long monomerId;
      private List<Long> areaIdList;
      private Long processId;
      private LocalDateTime dateTime;
      private List<Long> productionLineIds;
      private Integer meteUnitEnum;

      MesDailyProductionTaskDOParamBuilder() {
      }

      public MesDailyProductionTaskDOParam.MesDailyProductionTaskDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesDailyProductionTaskDOParam.MesDailyProductionTaskDOParamBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      public MesDailyProductionTaskDOParam.MesDailyProductionTaskDOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public MesDailyProductionTaskDOParam.MesDailyProductionTaskDOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesDailyProductionTaskDOParam.MesDailyProductionTaskDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesDailyProductionTaskDOParam.MesDailyProductionTaskDOParamBuilder areaIdList(final List<Long> areaIdList) {
         this.areaIdList = areaIdList;
         return this;
      }

      public MesDailyProductionTaskDOParam.MesDailyProductionTaskDOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesDailyProductionTaskDOParam.MesDailyProductionTaskDOParamBuilder dateTime(final LocalDateTime dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public MesDailyProductionTaskDOParam.MesDailyProductionTaskDOParamBuilder productionLineIds(final List<Long> productionLineIds) {
         this.productionLineIds = productionLineIds;
         return this;
      }

      public MesDailyProductionTaskDOParam.MesDailyProductionTaskDOParamBuilder meteUnitEnum(final Integer meteUnitEnum) {
         this.meteUnitEnum = meteUnitEnum;
         return this;
      }

      public MesDailyProductionTaskDOParam build() {
         return new MesDailyProductionTaskDOParam(
            this.projectId,
            this.workShopId,
            this.productionLineId,
            this.teamId,
            this.monomerId,
            this.areaIdList,
            this.processId,
            this.dateTime,
            this.productionLineIds,
            this.meteUnitEnum
         );
      }

      @Override
      public String toString() {
         return "MesDailyProductionTaskDOParam.MesDailyProductionTaskDOParamBuilder(projectId="
            + this.projectId
            + ", workShopId="
            + this.workShopId
            + ", productionLineId="
            + this.productionLineId
            + ", teamId="
            + this.teamId
            + ", monomerId="
            + this.monomerId
            + ", areaIdList="
            + this.areaIdList
            + ", processId="
            + this.processId
            + ", dateTime="
            + this.dateTime
            + ", productionLineIds="
            + this.productionLineIds
            + ", meteUnitEnum="
            + this.meteUnitEnum
            + ")";
      }
   }
}
