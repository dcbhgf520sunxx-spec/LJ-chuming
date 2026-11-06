package com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.team.get;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.Collection;
import java.util.List;

public class TeamListVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "processId", notes = "工序id", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "productionLineIds", notes = "生产线ids")
   @JsonProperty("productionLineIds")
   @JSONField(name = "productionLineIds")
   private List<Long> productionLineIds;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]", value = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   private Boolean organizationType;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "boolExtraCountEnum", notes = "编制属性[0 不单独计算,单独计算]")
   @JsonProperty("boolExtraCountEnum")
   @JSONField(name = "boolExtraCountEnum")
   private Boolean boolExtraCountEnum;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式 [1 重量, 2 长度，4 面积]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "teamStatus", notes = "班组状态1开启 0关闭")
   @JsonProperty("teamStatus")
   @JSONField(name = "teamStatus")
   private Boolean teamStatus;
   @ApiModelProperty("mes分类 1建刚 2桥梁")
   @JsonProperty("mesProductEnum")
   @JSONField(name = "mesProductEnum")
   private Integer mesProductEnum;
   @ApiModelProperty(name = "boolNestCutEnum", value = "切割方式", notes = "切割方式")
   @JsonProperty("boolNestCutEnum")
   @JSONField(name = "boolNestCutEnum")
   private Boolean boolNestCutEnum;
   @ApiModelProperty(name = "teamUserName", notes = "组长/组员名称")
   @JsonProperty("teamUserName")
   @JSONField(name = "teamUserName")
   private String teamUserName;
   @ApiModelProperty("是否精确查询")
   private Boolean boolAccurateQuery;
   @ApiModelProperty("多个工序名称")
   private String processNameJoin;
   @ApiModelProperty("工序名称List")
   private Collection<String> processNameList;

   public Collection<String> getProcessNameList() {
      return CollUtil.isEmpty(this.processNameList) && StrUtil.isNotBlank(this.getProcessNameJoin())
         ? StrUtil.split(this.getProcessNameJoin(), ",")
         : this.processNameList;
   }

   private static Boolean $default$boolAccurateQuery() {
      return Boolean.FALSE;
   }

   public static TeamListVORequest.TeamListVORequestBuilder builder() {
      return new TeamListVORequest.TeamListVORequestBuilder();
   }

   public TeamListVORequest() {
      this.boolAccurateQuery = $default$boolAccurateQuery();
   }

   public TeamListVORequest(
      final Long id,
      final Long processId,
      final Long workshopId,
      final Long factoryId,
      final List<Long> productionLineIds,
      final Long productionLineId,
      final Boolean organizationType,
      final Integer taskTypeEnum,
      final Boolean boolExtraCountEnum,
      final Integer wageQuotaType,
      final Integer productionLineTypeEnum,
      final Boolean teamStatus,
      final Integer mesProductEnum,
      final Boolean boolNestCutEnum,
      final String teamUserName,
      final Boolean boolAccurateQuery,
      final String processNameJoin,
      final Collection<String> processNameList
   ) {
      this.id = id;
      this.processId = processId;
      this.workshopId = workshopId;
      this.factoryId = factoryId;
      this.productionLineIds = productionLineIds;
      this.productionLineId = productionLineId;
      this.organizationType = organizationType;
      this.taskTypeEnum = taskTypeEnum;
      this.boolExtraCountEnum = boolExtraCountEnum;
      this.wageQuotaType = wageQuotaType;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.teamStatus = teamStatus;
      this.mesProductEnum = mesProductEnum;
      this.boolNestCutEnum = boolNestCutEnum;
      this.teamUserName = teamUserName;
      this.boolAccurateQuery = boolAccurateQuery;
      this.processNameJoin = processNameJoin;
      this.processNameList = processNameList;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public List<Long> getProductionLineIds() {
      return this.productionLineIds;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Boolean getBoolExtraCountEnum() {
      return this.boolExtraCountEnum;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Boolean getTeamStatus() {
      return this.teamStatus;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public Boolean getBoolNestCutEnum() {
      return this.boolNestCutEnum;
   }

   public String getTeamUserName() {
      return this.teamUserName;
   }

   public Boolean getBoolAccurateQuery() {
      return this.boolAccurateQuery;
   }

   public String getProcessNameJoin() {
      return this.processNameJoin;
   }

   @JsonProperty("id")
   public TeamListVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public TeamListVORequest setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("workshopId")
   public TeamListVORequest setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("factoryId")
   public TeamListVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("productionLineIds")
   public TeamListVORequest setProductionLineIds(final List<Long> productionLineIds) {
      this.productionLineIds = productionLineIds;
      return this;
   }

   @JsonProperty("productionLineId")
   public TeamListVORequest setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("organizationType")
   public TeamListVORequest setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public TeamListVORequest setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("boolExtraCountEnum")
   public TeamListVORequest setBoolExtraCountEnum(final Boolean boolExtraCountEnum) {
      this.boolExtraCountEnum = boolExtraCountEnum;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public TeamListVORequest setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public TeamListVORequest setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("teamStatus")
   public TeamListVORequest setTeamStatus(final Boolean teamStatus) {
      this.teamStatus = teamStatus;
      return this;
   }

   @JsonProperty("mesProductEnum")
   public TeamListVORequest setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @JsonProperty("boolNestCutEnum")
   public TeamListVORequest setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
      return this;
   }

   @JsonProperty("teamUserName")
   public TeamListVORequest setTeamUserName(final String teamUserName) {
      this.teamUserName = teamUserName;
      return this;
   }

   public TeamListVORequest setBoolAccurateQuery(final Boolean boolAccurateQuery) {
      this.boolAccurateQuery = boolAccurateQuery;
      return this;
   }

   public TeamListVORequest setProcessNameJoin(final String processNameJoin) {
      this.processNameJoin = processNameJoin;
      return this;
   }

   public TeamListVORequest setProcessNameList(final Collection<String> processNameList) {
      this.processNameList = processNameList;
      return this;
   }

   @Override
   public String toString() {
      return "TeamListVORequest(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", factoryId="
         + this.getFactoryId()
         + ", productionLineIds="
         + this.getProductionLineIds()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", organizationType="
         + this.getOrganizationType()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", boolExtraCountEnum="
         + this.getBoolExtraCountEnum()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", teamStatus="
         + this.getTeamStatus()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ", boolNestCutEnum="
         + this.getBoolNestCutEnum()
         + ", teamUserName="
         + this.getTeamUserName()
         + ", boolAccurateQuery="
         + this.getBoolAccurateQuery()
         + ", processNameJoin="
         + this.getProcessNameJoin()
         + ", processNameList="
         + this.getProcessNameList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamListVORequest)) {
         return false;
      }

      TeamListVORequest other = (TeamListVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$factoryId = this.getFactoryId();
               Object other$factoryId = other.getFactoryId();
               if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                  Object this$productionLineId = this.getProductionLineId();
                  Object other$productionLineId = other.getProductionLineId();
                  if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                     Object this$organizationType = this.getOrganizationType();
                     Object other$organizationType = other.getOrganizationType();
                     if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
                        Object this$taskTypeEnum = this.getTaskTypeEnum();
                        Object other$taskTypeEnum = other.getTaskTypeEnum();
                        if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                           Object this$boolExtraCountEnum = this.getBoolExtraCountEnum();
                           Object other$boolExtraCountEnum = other.getBoolExtraCountEnum();
                           if (this$boolExtraCountEnum == null ? other$boolExtraCountEnum == null : this$boolExtraCountEnum.equals(other$boolExtraCountEnum)) {
                              Object this$wageQuotaType = this.getWageQuotaType();
                              Object other$wageQuotaType = other.getWageQuotaType();
                              if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                                 Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                                 Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                                 if (this$productionLineTypeEnum == null
                                    ? other$productionLineTypeEnum == null
                                    : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                                    Object this$teamStatus = this.getTeamStatus();
                                    Object other$teamStatus = other.getTeamStatus();
                                    if (this$teamStatus == null ? other$teamStatus == null : this$teamStatus.equals(other$teamStatus)) {
                                       Object this$mesProductEnum = this.getMesProductEnum();
                                       Object other$mesProductEnum = other.getMesProductEnum();
                                       if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                                          Object this$boolNestCutEnum = this.getBoolNestCutEnum();
                                          Object other$boolNestCutEnum = other.getBoolNestCutEnum();
                                          if (this$boolNestCutEnum == null ? other$boolNestCutEnum == null : this$boolNestCutEnum.equals(other$boolNestCutEnum)
                                             )
                                           {
                                             Object this$boolAccurateQuery = this.getBoolAccurateQuery();
                                             Object other$boolAccurateQuery = other.getBoolAccurateQuery();
                                             if (this$boolAccurateQuery == null
                                                ? other$boolAccurateQuery == null
                                                : this$boolAccurateQuery.equals(other$boolAccurateQuery)) {
                                                Object this$productionLineIds = this.getProductionLineIds();
                                                Object other$productionLineIds = other.getProductionLineIds();
                                                if (this$productionLineIds == null
                                                   ? other$productionLineIds == null
                                                   : this$productionLineIds.equals(other$productionLineIds)) {
                                                   Object this$teamUserName = this.getTeamUserName();
                                                   Object other$teamUserName = other.getTeamUserName();
                                                   if (this$teamUserName == null ? other$teamUserName == null : this$teamUserName.equals(other$teamUserName)) {
                                                      Object this$processNameJoin = this.getProcessNameJoin();
                                                      Object other$processNameJoin = other.getProcessNameJoin();
                                                      if (this$processNameJoin == null
                                                         ? other$processNameJoin == null
                                                         : this$processNameJoin.equals(other$processNameJoin)) {
                                                         Object this$processNameList = this.getProcessNameList();
                                                         Object other$processNameList = other.getProcessNameList();
                                                         return this$processNameList == null
                                                            ? other$processNameList == null
                                                            : this$processNameList.equals(other$processNameList);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TeamListVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $boolExtraCountEnum = this.getBoolExtraCountEnum();
      result = result * 59 + ($boolExtraCountEnum == null ? 43 : $boolExtraCountEnum.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $teamStatus = this.getTeamStatus();
      result = result * 59 + ($teamStatus == null ? 43 : $teamStatus.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $boolNestCutEnum = this.getBoolNestCutEnum();
      result = result * 59 + ($boolNestCutEnum == null ? 43 : $boolNestCutEnum.hashCode());
      Object $boolAccurateQuery = this.getBoolAccurateQuery();
      result = result * 59 + ($boolAccurateQuery == null ? 43 : $boolAccurateQuery.hashCode());
      Object $productionLineIds = this.getProductionLineIds();
      result = result * 59 + ($productionLineIds == null ? 43 : $productionLineIds.hashCode());
      Object $teamUserName = this.getTeamUserName();
      result = result * 59 + ($teamUserName == null ? 43 : $teamUserName.hashCode());
      Object $processNameJoin = this.getProcessNameJoin();
      result = result * 59 + ($processNameJoin == null ? 43 : $processNameJoin.hashCode());
      Object $processNameList = this.getProcessNameList();
      return result * 59 + ($processNameList == null ? 43 : $processNameList.hashCode());
   }

   public static class TeamListVORequestBuilder {
      private Long id;
      private Long processId;
      private Long workshopId;
      private Long factoryId;
      private List<Long> productionLineIds;
      private Long productionLineId;
      private Boolean organizationType;
      private Integer taskTypeEnum;
      private Boolean boolExtraCountEnum;
      private Integer wageQuotaType;
      private Integer productionLineTypeEnum;
      private Boolean teamStatus;
      private Integer mesProductEnum;
      private Boolean boolNestCutEnum;
      private String teamUserName;
      private boolean boolAccurateQuery$set;
      private Boolean boolAccurateQuery$value;
      private String processNameJoin;
      private Collection<String> processNameList;

      TeamListVORequestBuilder() {
      }

      @JsonProperty("id")
      public TeamListVORequest.TeamListVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public TeamListVORequest.TeamListVORequestBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("workshopId")
      public TeamListVORequest.TeamListVORequestBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("factoryId")
      public TeamListVORequest.TeamListVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("productionLineIds")
      public TeamListVORequest.TeamListVORequestBuilder productionLineIds(final List<Long> productionLineIds) {
         this.productionLineIds = productionLineIds;
         return this;
      }

      @JsonProperty("productionLineId")
      public TeamListVORequest.TeamListVORequestBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("organizationType")
      public TeamListVORequest.TeamListVORequestBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public TeamListVORequest.TeamListVORequestBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("boolExtraCountEnum")
      public TeamListVORequest.TeamListVORequestBuilder boolExtraCountEnum(final Boolean boolExtraCountEnum) {
         this.boolExtraCountEnum = boolExtraCountEnum;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public TeamListVORequest.TeamListVORequestBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public TeamListVORequest.TeamListVORequestBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("teamStatus")
      public TeamListVORequest.TeamListVORequestBuilder teamStatus(final Boolean teamStatus) {
         this.teamStatus = teamStatus;
         return this;
      }

      @JsonProperty("mesProductEnum")
      public TeamListVORequest.TeamListVORequestBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      @JsonProperty("boolNestCutEnum")
      public TeamListVORequest.TeamListVORequestBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      @JsonProperty("teamUserName")
      public TeamListVORequest.TeamListVORequestBuilder teamUserName(final String teamUserName) {
         this.teamUserName = teamUserName;
         return this;
      }

      public TeamListVORequest.TeamListVORequestBuilder boolAccurateQuery(final Boolean boolAccurateQuery) {
         this.boolAccurateQuery$value = boolAccurateQuery;
         this.boolAccurateQuery$set = true;
         return this;
      }

      public TeamListVORequest.TeamListVORequestBuilder processNameJoin(final String processNameJoin) {
         this.processNameJoin = processNameJoin;
         return this;
      }

      public TeamListVORequest.TeamListVORequestBuilder processNameList(final Collection<String> processNameList) {
         this.processNameList = processNameList;
         return this;
      }

      public TeamListVORequest build() {
         Boolean boolAccurateQuery$value = this.boolAccurateQuery$value;
         if (!this.boolAccurateQuery$set) {
            boolAccurateQuery$value = TeamListVORequest.$default$boolAccurateQuery();
         }

         return new TeamListVORequest(
            this.id,
            this.processId,
            this.workshopId,
            this.factoryId,
            this.productionLineIds,
            this.productionLineId,
            this.organizationType,
            this.taskTypeEnum,
            this.boolExtraCountEnum,
            this.wageQuotaType,
            this.productionLineTypeEnum,
            this.teamStatus,
            this.mesProductEnum,
            this.boolNestCutEnum,
            this.teamUserName,
            boolAccurateQuery$value,
            this.processNameJoin,
            this.processNameList
         );
      }

      @Override
      public String toString() {
         return "TeamListVORequest.TeamListVORequestBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", workshopId="
            + this.workshopId
            + ", factoryId="
            + this.factoryId
            + ", productionLineIds="
            + this.productionLineIds
            + ", productionLineId="
            + this.productionLineId
            + ", organizationType="
            + this.organizationType
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", boolExtraCountEnum="
            + this.boolExtraCountEnum
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", teamStatus="
            + this.teamStatus
            + ", mesProductEnum="
            + this.mesProductEnum
            + ", boolNestCutEnum="
            + this.boolNestCutEnum
            + ", teamUserName="
            + this.teamUserName
            + ", boolAccurateQuery$value="
            + this.boolAccurateQuery$value
            + ", processNameJoin="
            + this.processNameJoin
            + ", processNameList="
            + this.processNameList
            + ")";
      }
   }
}
