package com.hzchum.scim.mes.building.core.api.pojo._doParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingTeamUserLinkDTOParam;
import io.swagger.annotations.ApiModelProperty;
import java.util.Collection;
import java.util.List;
import javax.validation.constraints.NotNull;

public class MesBuildingTeamDOParam extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "workshopId", notes = "车间id", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "userId", notes = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   @NotNull(message = "编制属性不能为空")
   private Boolean organizationType;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "userLinks", notes = "班组人员")
   @JsonProperty("userLinks")
   @JSONField(name = "userLinks")
   private List<MesBuildingTeamUserLinkDTOParam> userLinks;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineIds", notes = "生产线ids")
   @JsonProperty("productionLineIds")
   @JSONField(name = "productionLineIds")
   private List<Long> productionLineIds;
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
   @ApiModelProperty(name = "productType", notes = "产品类型", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty(name = "structureClassId", value = "构件种类id")
   @JsonProperty("structureClassId")
   @JSONField(name = "structureClassId")
   private Long structureClassId;
   @ApiModelProperty("mes分类 1建刚 2桥梁")
   @JsonProperty("mesProductEnum")
   @JSONField(name = "mesProductEnum")
   private Integer mesProductEnum;
   @ApiModelProperty(name = "teamUserName", notes = "组长/组员名称")
   private String teamUserName;
   @ApiModelProperty("是否精确查询")
   private Boolean boolAccurateQuery;
   @ApiModelProperty("工序名称List")
   private Collection<String> processNameList;

   public static MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder builder() {
      return new MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder();
   }

   public MesBuildingTeamDOParam() {
   }

   public MesBuildingTeamDOParam(
      final Long id,
      final Long processId,
      final Long factoryId,
      final Long workshopId,
      final Long userId,
      final Boolean organizationType,
      final Integer taskTypeEnum,
      final List<MesBuildingTeamUserLinkDTOParam> userLinks,
      final Long productionLineId,
      final List<Long> productionLineIds,
      final Boolean boolExtraCountEnum,
      final Integer wageQuotaType,
      final Integer productionLineTypeEnum,
      final Boolean teamStatus,
      final Integer productType,
      final Long structureClassId,
      final Integer mesProductEnum,
      final String teamUserName,
      final Boolean boolAccurateQuery,
      final Collection<String> processNameList
   ) {
      this.id = id;
      this.processId = processId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.userId = userId;
      this.organizationType = organizationType;
      this.taskTypeEnum = taskTypeEnum;
      this.userLinks = userLinks;
      this.productionLineId = productionLineId;
      this.productionLineIds = productionLineIds;
      this.boolExtraCountEnum = boolExtraCountEnum;
      this.wageQuotaType = wageQuotaType;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.teamStatus = teamStatus;
      this.productType = productType;
      this.structureClassId = structureClassId;
      this.mesProductEnum = mesProductEnum;
      this.teamUserName = teamUserName;
      this.boolAccurateQuery = boolAccurateQuery;
      this.processNameList = processNameList;
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

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public List<MesBuildingTeamUserLinkDTOParam> getUserLinks() {
      return this.userLinks;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public List<Long> getProductionLineIds() {
      return this.productionLineIds;
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

   public Integer getProductType() {
      return this.productType;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public String getTeamUserName() {
      return this.teamUserName;
   }

   public Boolean getBoolAccurateQuery() {
      return this.boolAccurateQuery;
   }

   public Collection<String> getProcessNameList() {
      return this.processNameList;
   }

   @JsonProperty("id")
   public MesBuildingTeamDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingTeamDOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingTeamDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingTeamDOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingTeamDOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("organizationType")
   public MesBuildingTeamDOParam setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingTeamDOParam setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("userLinks")
   public MesBuildingTeamDOParam setUserLinks(final List<MesBuildingTeamUserLinkDTOParam> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTeamDOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineIds")
   public MesBuildingTeamDOParam setProductionLineIds(final List<Long> productionLineIds) {
      this.productionLineIds = productionLineIds;
      return this;
   }

   @JsonProperty("boolExtraCountEnum")
   public MesBuildingTeamDOParam setBoolExtraCountEnum(final Boolean boolExtraCountEnum) {
      this.boolExtraCountEnum = boolExtraCountEnum;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public MesBuildingTeamDOParam setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingTeamDOParam setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("teamStatus")
   public MesBuildingTeamDOParam setTeamStatus(final Boolean teamStatus) {
      this.teamStatus = teamStatus;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingTeamDOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("structureClassId")
   public MesBuildingTeamDOParam setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   @JsonProperty("mesProductEnum")
   public MesBuildingTeamDOParam setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   public MesBuildingTeamDOParam setTeamUserName(final String teamUserName) {
      this.teamUserName = teamUserName;
      return this;
   }

   public MesBuildingTeamDOParam setBoolAccurateQuery(final Boolean boolAccurateQuery) {
      this.boolAccurateQuery = boolAccurateQuery;
      return this;
   }

   public MesBuildingTeamDOParam setProcessNameList(final Collection<String> processNameList) {
      this.processNameList = processNameList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTeamDOParam(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", userId="
         + this.getUserId()
         + ", organizationType="
         + this.getOrganizationType()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", userLinks="
         + this.getUserLinks()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineIds="
         + this.getProductionLineIds()
         + ", boolExtraCountEnum="
         + this.getBoolExtraCountEnum()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", teamStatus="
         + this.getTeamStatus()
         + ", productType="
         + this.getProductType()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ", teamUserName="
         + this.getTeamUserName()
         + ", boolAccurateQuery="
         + this.getBoolAccurateQuery()
         + ", processNameList="
         + this.getProcessNameList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTeamDOParam)) {
         return false;
      }

      MesBuildingTeamDOParam other = (MesBuildingTeamDOParam)o;
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
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$organizationType = this.getOrganizationType();
                     Object other$organizationType = other.getOrganizationType();
                     if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
                        Object this$taskTypeEnum = this.getTaskTypeEnum();
                        Object other$taskTypeEnum = other.getTaskTypeEnum();
                        if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                           Object this$productionLineId = this.getProductionLineId();
                           Object other$productionLineId = other.getProductionLineId();
                           if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                              Object this$boolExtraCountEnum = this.getBoolExtraCountEnum();
                              Object other$boolExtraCountEnum = other.getBoolExtraCountEnum();
                              if (this$boolExtraCountEnum == null ? other$boolExtraCountEnum == null : this$boolExtraCountEnum.equals(other$boolExtraCountEnum)
                                 )
                               {
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
                                          Object this$productType = this.getProductType();
                                          Object other$productType = other.getProductType();
                                          if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                             Object this$structureClassId = this.getStructureClassId();
                                             Object other$structureClassId = other.getStructureClassId();
                                             if (this$structureClassId == null
                                                ? other$structureClassId == null
                                                : this$structureClassId.equals(other$structureClassId)) {
                                                Object this$mesProductEnum = this.getMesProductEnum();
                                                Object other$mesProductEnum = other.getMesProductEnum();
                                                if (this$mesProductEnum == null
                                                   ? other$mesProductEnum == null
                                                   : this$mesProductEnum.equals(other$mesProductEnum)) {
                                                   Object this$boolAccurateQuery = this.getBoolAccurateQuery();
                                                   Object other$boolAccurateQuery = other.getBoolAccurateQuery();
                                                   if (this$boolAccurateQuery == null
                                                      ? other$boolAccurateQuery == null
                                                      : this$boolAccurateQuery.equals(other$boolAccurateQuery)) {
                                                      Object this$userLinks = this.getUserLinks();
                                                      Object other$userLinks = other.getUserLinks();
                                                      if (this$userLinks == null ? other$userLinks == null : this$userLinks.equals(other$userLinks)) {
                                                         Object this$productionLineIds = this.getProductionLineIds();
                                                         Object other$productionLineIds = other.getProductionLineIds();
                                                         if (this$productionLineIds == null
                                                            ? other$productionLineIds == null
                                                            : this$productionLineIds.equals(other$productionLineIds)) {
                                                            Object this$teamUserName = this.getTeamUserName();
                                                            Object other$teamUserName = other.getTeamUserName();
                                                            if (this$teamUserName == null
                                                               ? other$teamUserName == null
                                                               : this$teamUserName.equals(other$teamUserName)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTeamDOParam;
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
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $boolExtraCountEnum = this.getBoolExtraCountEnum();
      result = result * 59 + ($boolExtraCountEnum == null ? 43 : $boolExtraCountEnum.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $teamStatus = this.getTeamStatus();
      result = result * 59 + ($teamStatus == null ? 43 : $teamStatus.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $boolAccurateQuery = this.getBoolAccurateQuery();
      result = result * 59 + ($boolAccurateQuery == null ? 43 : $boolAccurateQuery.hashCode());
      Object $userLinks = this.getUserLinks();
      result = result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
      Object $productionLineIds = this.getProductionLineIds();
      result = result * 59 + ($productionLineIds == null ? 43 : $productionLineIds.hashCode());
      Object $teamUserName = this.getTeamUserName();
      result = result * 59 + ($teamUserName == null ? 43 : $teamUserName.hashCode());
      Object $processNameList = this.getProcessNameList();
      return result * 59 + ($processNameList == null ? 43 : $processNameList.hashCode());
   }

   public static class MesBuildingTeamDOParamBuilder {
      private Long id;
      private Long processId;
      private Long factoryId;
      private Long workshopId;
      private Long userId;
      private Boolean organizationType;
      private Integer taskTypeEnum;
      private List<MesBuildingTeamUserLinkDTOParam> userLinks;
      private Long productionLineId;
      private List<Long> productionLineIds;
      private Boolean boolExtraCountEnum;
      private Integer wageQuotaType;
      private Integer productionLineTypeEnum;
      private Boolean teamStatus;
      private Integer productType;
      private Long structureClassId;
      private Integer mesProductEnum;
      private String teamUserName;
      private Boolean boolAccurateQuery;
      private Collection<String> processNameList;

      MesBuildingTeamDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("organizationType")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("userLinks")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder userLinks(final List<MesBuildingTeamUserLinkDTOParam> userLinks) {
         this.userLinks = userLinks;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineIds")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder productionLineIds(final List<Long> productionLineIds) {
         this.productionLineIds = productionLineIds;
         return this;
      }

      @JsonProperty("boolExtraCountEnum")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder boolExtraCountEnum(final Boolean boolExtraCountEnum) {
         this.boolExtraCountEnum = boolExtraCountEnum;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("teamStatus")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder teamStatus(final Boolean teamStatus) {
         this.teamStatus = teamStatus;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("structureClassId")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      @JsonProperty("mesProductEnum")
      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder teamUserName(final String teamUserName) {
         this.teamUserName = teamUserName;
         return this;
      }

      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder boolAccurateQuery(final Boolean boolAccurateQuery) {
         this.boolAccurateQuery = boolAccurateQuery;
         return this;
      }

      public MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder processNameList(final Collection<String> processNameList) {
         this.processNameList = processNameList;
         return this;
      }

      public MesBuildingTeamDOParam build() {
         return new MesBuildingTeamDOParam(
            this.id,
            this.processId,
            this.factoryId,
            this.workshopId,
            this.userId,
            this.organizationType,
            this.taskTypeEnum,
            this.userLinks,
            this.productionLineId,
            this.productionLineIds,
            this.boolExtraCountEnum,
            this.wageQuotaType,
            this.productionLineTypeEnum,
            this.teamStatus,
            this.productType,
            this.structureClassId,
            this.mesProductEnum,
            this.teamUserName,
            this.boolAccurateQuery,
            this.processNameList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTeamDOParam.MesBuildingTeamDOParamBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", userId="
            + this.userId
            + ", organizationType="
            + this.organizationType
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", userLinks="
            + this.userLinks
            + ", productionLineId="
            + this.productionLineId
            + ", productionLineIds="
            + this.productionLineIds
            + ", boolExtraCountEnum="
            + this.boolExtraCountEnum
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", teamStatus="
            + this.teamStatus
            + ", productType="
            + this.productType
            + ", structureClassId="
            + this.structureClassId
            + ", mesProductEnum="
            + this.mesProductEnum
            + ", teamUserName="
            + this.teamUserName
            + ", boolAccurateQuery="
            + this.boolAccurateQuery
            + ", processNameList="
            + this.processNameList
            + ")";
      }
   }
}
