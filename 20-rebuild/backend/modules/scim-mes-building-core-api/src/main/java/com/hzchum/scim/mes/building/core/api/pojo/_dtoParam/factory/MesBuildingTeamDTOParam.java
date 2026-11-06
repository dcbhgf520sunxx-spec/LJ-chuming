package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.util.Collection;
import java.util.List;
import javax.validation.constraints.NotNull;

public class MesBuildingTeamDTOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @NotNull(message = "工厂id不能为空")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @NotNull(message = "车间id不能为空")
   private Long workshopId;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @NotNull(message = "工序id不能为空")
   private Long processId;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "userId", notes = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   @NotNull(message = "编制属性不能为空")
   private Boolean organizationType;
   @ApiModelProperty(name = "hasMen", value = "是否有组员0无，1有", notes = "是否有组员0无，1有")
   @JsonProperty("hasMen")
   @JSONField(name = "hasMen")
   private Boolean hasMen;
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
   @ApiModelProperty(name = "productType", notes = "产品类型", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty(name = "structureClassId", value = "构件种类id")
   @JsonProperty("structureClassId")
   @JSONField(name = "structureClassId")
   private Long structureClassId;
   @ApiModelProperty(name = "groupsName", value = "生产组名", notes = "生产组名")
   private String groupsName;
   @ApiModelProperty(name = "teamLeaderName", value = "班组长名", notes = "班组长名")
   private String teamLeaderName;
   @ApiModelProperty(name = "teamStatus", notes = "班组状态1开启 0关闭")
   private Boolean teamStatus;
   @ApiModelProperty("mes分类 1建刚 2桥梁")
   @JsonProperty("mesProductEnum")
   @JSONField(name = "mesProductEnum")
   private Integer mesProductEnum;
   @ApiModelProperty(name = "boolNestCutEnum", value = "切割方式", notes = "切割方式")
   private Boolean boolNestCutEnum;
   @ApiModelProperty(name = "teamUserName", notes = "组长/组员名称")
   private String teamUserName;
   @ApiModelProperty("是否精确查询")
   private Boolean boolAccurateQuery;
   @ApiModelProperty("工序名称List")
   private Collection<String> processNameList;

   public static MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder builder() {
      return new MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder();
   }

   public MesBuildingTeamDTOParam() {
   }

   public MesBuildingTeamDTOParam(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final Long processId,
      final Integer taskTypeEnum,
      final Integer productionLineTypeEnum,
      final Long userId,
      final Boolean organizationType,
      final Boolean hasMen,
      final List<MesBuildingTeamUserLinkDTOParam> userLinks,
      final Long productionLineId,
      final List<Long> productionLineIds,
      final Integer productType,
      final Long structureClassId,
      final String groupsName,
      final String teamLeaderName,
      final Boolean teamStatus,
      final Integer mesProductEnum,
      final Boolean boolNestCutEnum,
      final String teamUserName,
      final Boolean boolAccurateQuery,
      final Collection<String> processNameList
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.processId = processId;
      this.taskTypeEnum = taskTypeEnum;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.userId = userId;
      this.organizationType = organizationType;
      this.hasMen = hasMen;
      this.userLinks = userLinks;
      this.productionLineId = productionLineId;
      this.productionLineIds = productionLineIds;
      this.productType = productType;
      this.structureClassId = structureClassId;
      this.groupsName = groupsName;
      this.teamLeaderName = teamLeaderName;
      this.teamStatus = teamStatus;
      this.mesProductEnum = mesProductEnum;
      this.boolNestCutEnum = boolNestCutEnum;
      this.teamUserName = teamUserName;
      this.boolAccurateQuery = boolAccurateQuery;
      this.processNameList = processNameList;
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

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   public Boolean getHasMen() {
      return this.hasMen;
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

   public Integer getProductType() {
      return this.productType;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public String getGroupsName() {
      return this.groupsName;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
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

   public Collection<String> getProcessNameList() {
      return this.processNameList;
   }

   @JsonProperty("id")
   public MesBuildingTeamDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingTeamDTOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingTeamDTOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingTeamDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingTeamDTOParam setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingTeamDTOParam setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingTeamDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("organizationType")
   public MesBuildingTeamDTOParam setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("hasMen")
   public MesBuildingTeamDTOParam setHasMen(final Boolean hasMen) {
      this.hasMen = hasMen;
      return this;
   }

   @JsonProperty("userLinks")
   public MesBuildingTeamDTOParam setUserLinks(final List<MesBuildingTeamUserLinkDTOParam> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTeamDTOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineIds")
   public MesBuildingTeamDTOParam setProductionLineIds(final List<Long> productionLineIds) {
      this.productionLineIds = productionLineIds;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingTeamDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("structureClassId")
   public MesBuildingTeamDTOParam setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   public MesBuildingTeamDTOParam setGroupsName(final String groupsName) {
      this.groupsName = groupsName;
      return this;
   }

   public MesBuildingTeamDTOParam setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
      return this;
   }

   public MesBuildingTeamDTOParam setTeamStatus(final Boolean teamStatus) {
      this.teamStatus = teamStatus;
      return this;
   }

   @JsonProperty("mesProductEnum")
   public MesBuildingTeamDTOParam setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   public MesBuildingTeamDTOParam setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
      return this;
   }

   public MesBuildingTeamDTOParam setTeamUserName(final String teamUserName) {
      this.teamUserName = teamUserName;
      return this;
   }

   public MesBuildingTeamDTOParam setBoolAccurateQuery(final Boolean boolAccurateQuery) {
      this.boolAccurateQuery = boolAccurateQuery;
      return this;
   }

   public MesBuildingTeamDTOParam setProcessNameList(final Collection<String> processNameList) {
      this.processNameList = processNameList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTeamDTOParam(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", processId="
         + this.getProcessId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", userId="
         + this.getUserId()
         + ", organizationType="
         + this.getOrganizationType()
         + ", hasMen="
         + this.getHasMen()
         + ", userLinks="
         + this.getUserLinks()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineIds="
         + this.getProductionLineIds()
         + ", productType="
         + this.getProductType()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", groupsName="
         + this.getGroupsName()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
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
         + ", processNameList="
         + this.getProcessNameList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTeamDTOParam)) {
         return false;
      }

      MesBuildingTeamDTOParam other = (MesBuildingTeamDTOParam)o;
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
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                  Object this$taskTypeEnum = this.getTaskTypeEnum();
                  Object other$taskTypeEnum = other.getTaskTypeEnum();
                  if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                     Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                     Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                     if (this$productionLineTypeEnum == null
                        ? other$productionLineTypeEnum == null
                        : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$organizationType = this.getOrganizationType();
                           Object other$organizationType = other.getOrganizationType();
                           if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
                              Object this$hasMen = this.getHasMen();
                              Object other$hasMen = other.getHasMen();
                              if (this$hasMen == null ? other$hasMen == null : this$hasMen.equals(other$hasMen)) {
                                 Object this$productionLineId = this.getProductionLineId();
                                 Object other$productionLineId = other.getProductionLineId();
                                 if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                                    Object this$productType = this.getProductType();
                                    Object other$productType = other.getProductType();
                                    if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                       Object this$structureClassId = this.getStructureClassId();
                                       Object other$structureClassId = other.getStructureClassId();
                                       if (this$structureClassId == null
                                          ? other$structureClassId == null
                                          : this$structureClassId.equals(other$structureClassId)) {
                                          Object this$teamStatus = this.getTeamStatus();
                                          Object other$teamStatus = other.getTeamStatus();
                                          if (this$teamStatus == null ? other$teamStatus == null : this$teamStatus.equals(other$teamStatus)) {
                                             Object this$mesProductEnum = this.getMesProductEnum();
                                             Object other$mesProductEnum = other.getMesProductEnum();
                                             if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                                                Object this$boolNestCutEnum = this.getBoolNestCutEnum();
                                                Object other$boolNestCutEnum = other.getBoolNestCutEnum();
                                                if (this$boolNestCutEnum == null
                                                   ? other$boolNestCutEnum == null
                                                   : this$boolNestCutEnum.equals(other$boolNestCutEnum)) {
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
                                                            Object this$groupsName = this.getGroupsName();
                                                            Object other$groupsName = other.getGroupsName();
                                                            if (this$groupsName == null ? other$groupsName == null : this$groupsName.equals(other$groupsName)) {
                                                               Object this$teamLeaderName = this.getTeamLeaderName();
                                                               Object other$teamLeaderName = other.getTeamLeaderName();
                                                               if (this$teamLeaderName == null
                                                                  ? other$teamLeaderName == null
                                                                  : this$teamLeaderName.equals(other$teamLeaderName)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTeamDTOParam;
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
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $hasMen = this.getHasMen();
      result = result * 59 + ($hasMen == null ? 43 : $hasMen.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $teamStatus = this.getTeamStatus();
      result = result * 59 + ($teamStatus == null ? 43 : $teamStatus.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $boolNestCutEnum = this.getBoolNestCutEnum();
      result = result * 59 + ($boolNestCutEnum == null ? 43 : $boolNestCutEnum.hashCode());
      Object $boolAccurateQuery = this.getBoolAccurateQuery();
      result = result * 59 + ($boolAccurateQuery == null ? 43 : $boolAccurateQuery.hashCode());
      Object $userLinks = this.getUserLinks();
      result = result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
      Object $productionLineIds = this.getProductionLineIds();
      result = result * 59 + ($productionLineIds == null ? 43 : $productionLineIds.hashCode());
      Object $groupsName = this.getGroupsName();
      result = result * 59 + ($groupsName == null ? 43 : $groupsName.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      result = result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
      Object $teamUserName = this.getTeamUserName();
      result = result * 59 + ($teamUserName == null ? 43 : $teamUserName.hashCode());
      Object $processNameList = this.getProcessNameList();
      return result * 59 + ($processNameList == null ? 43 : $processNameList.hashCode());
   }

   public static class MesBuildingTeamDTOParamBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long processId;
      private Integer taskTypeEnum;
      private Integer productionLineTypeEnum;
      private Long userId;
      private Boolean organizationType;
      private Boolean hasMen;
      private List<MesBuildingTeamUserLinkDTOParam> userLinks;
      private Long productionLineId;
      private List<Long> productionLineIds;
      private Integer productType;
      private Long structureClassId;
      private String groupsName;
      private String teamLeaderName;
      private Boolean teamStatus;
      private Integer mesProductEnum;
      private Boolean boolNestCutEnum;
      private String teamUserName;
      private Boolean boolAccurateQuery;
      private Collection<String> processNameList;

      MesBuildingTeamDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("organizationType")
      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("hasMen")
      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder hasMen(final Boolean hasMen) {
         this.hasMen = hasMen;
         return this;
      }

      @JsonProperty("userLinks")
      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder userLinks(final List<MesBuildingTeamUserLinkDTOParam> userLinks) {
         this.userLinks = userLinks;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineIds")
      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder productionLineIds(final List<Long> productionLineIds) {
         this.productionLineIds = productionLineIds;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("structureClassId")
      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder groupsName(final String groupsName) {
         this.groupsName = groupsName;
         return this;
      }

      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder teamStatus(final Boolean teamStatus) {
         this.teamStatus = teamStatus;
         return this;
      }

      @JsonProperty("mesProductEnum")
      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder teamUserName(final String teamUserName) {
         this.teamUserName = teamUserName;
         return this;
      }

      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder boolAccurateQuery(final Boolean boolAccurateQuery) {
         this.boolAccurateQuery = boolAccurateQuery;
         return this;
      }

      public MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder processNameList(final Collection<String> processNameList) {
         this.processNameList = processNameList;
         return this;
      }

      public MesBuildingTeamDTOParam build() {
         return new MesBuildingTeamDTOParam(
            this.id,
            this.factoryId,
            this.workshopId,
            this.processId,
            this.taskTypeEnum,
            this.productionLineTypeEnum,
            this.userId,
            this.organizationType,
            this.hasMen,
            this.userLinks,
            this.productionLineId,
            this.productionLineIds,
            this.productType,
            this.structureClassId,
            this.groupsName,
            this.teamLeaderName,
            this.teamStatus,
            this.mesProductEnum,
            this.boolNestCutEnum,
            this.teamUserName,
            this.boolAccurateQuery,
            this.processNameList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTeamDTOParam.MesBuildingTeamDTOParamBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", processId="
            + this.processId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", userId="
            + this.userId
            + ", organizationType="
            + this.organizationType
            + ", hasMen="
            + this.hasMen
            + ", userLinks="
            + this.userLinks
            + ", productionLineId="
            + this.productionLineId
            + ", productionLineIds="
            + this.productionLineIds
            + ", productType="
            + this.productType
            + ", structureClassId="
            + this.structureClassId
            + ", groupsName="
            + this.groupsName
            + ", teamLeaderName="
            + this.teamLeaderName
            + ", teamStatus="
            + this.teamStatus
            + ", mesProductEnum="
            + this.mesProductEnum
            + ", boolNestCutEnum="
            + this.boolNestCutEnum
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
