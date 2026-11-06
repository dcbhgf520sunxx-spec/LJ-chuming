package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

public class MesBuildingTeamDTO {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
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
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @NotNull(message = "工厂id不能为空")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @NotNull(message = "车间id不能为空")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", notes = "车间名", value = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @NotNull(message = "生产线id不能为空")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineName", notes = "生产线名称", value = "生产线名称")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   @NotNull(message = "生产线名称不能为空")
   private String productionLineName;
   @ApiModelProperty(name = "userId", notes = "用户id", value = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]", value = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   @NotNull(message = "编制属性不能为空")
   private Boolean organizationType;
   @ApiModelProperty(name = "hasMen", value = "是否有组员0无，1有", notes = "是否有组员0无，1有")
   @JsonProperty("hasMen")
   @JSONField(name = "hasMen")
   private Boolean hasMen;
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
   @ApiModelProperty(name = "teamStatus", notes = "班组状态0关闭 1开启", value = "班组状态0关闭 1开启")
   @JsonProperty("teamStatus")
   @JSONField(name = "teamStatus")
   private Boolean teamStatus;
   @ApiModelProperty("是否绑定工序")
   @JsonProperty("boolBindProcess")
   @JSONField(name = "boolBindProcess")
   private Boolean boolBindProcess;
   @ApiModelProperty(name = "boolNestCutEnum", value = "切割方式", notes = "切割方式")
   @JsonProperty("boolNestCutEnum")
   @JSONField(name = "boolNestCutEnum")
   private Boolean boolNestCutEnum;
   @ApiModelProperty(name = "userLinkList", notes = "班组人员", value = "班组人员")
   @JsonProperty("userLinkList")
   @JSONField(name = "userLinkList")
   private List<MesBuildingTeamUserLinkDTO> userLinkList;
   @ApiModelProperty(name = "teamName", notes = "班组名称", value = "班组名称")
   @JsonProperty("teamName")
   @JSONField(name = "teamName")
   private String teamName;
   @ApiModelProperty("工序班组名称")
   private String processTeamName;

   public static MesBuildingTeamDTO.MesBuildingTeamDTOBuilder builder() {
      return new MesBuildingTeamDTO.MesBuildingTeamDTOBuilder();
   }

   public MesBuildingTeamDTO() {
   }

   public MesBuildingTeamDTO(
      final Long id,
      final Long processId,
      final String processName,
      final Integer productType,
      final Long factoryId,
      final Long workshopId,
      final String workshopName,
      final Long productionLineId,
      final String productionLineName,
      final Long userId,
      final Boolean organizationType,
      final Boolean hasMen,
      final Boolean boolExtraCountEnum,
      final Integer wageQuotaType,
      final Integer productionLineTypeEnum,
      final Boolean teamStatus,
      final Boolean boolBindProcess,
      final Boolean boolNestCutEnum,
      final List<MesBuildingTeamUserLinkDTO> userLinkList,
      final String teamName,
      final String processTeamName
   ) {
      this.id = id;
      this.processId = processId;
      this.processName = processName;
      this.productType = productType;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.userId = userId;
      this.organizationType = organizationType;
      this.hasMen = hasMen;
      this.boolExtraCountEnum = boolExtraCountEnum;
      this.wageQuotaType = wageQuotaType;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.teamStatus = teamStatus;
      this.boolBindProcess = boolBindProcess;
      this.boolNestCutEnum = boolNestCutEnum;
      this.userLinkList = userLinkList;
      this.teamName = teamName;
      this.processTeamName = processTeamName;
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

   public Long getFactoryId() {
      return this.factoryId;
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

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   public Boolean getHasMen() {
      return this.hasMen;
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

   public Boolean getBoolBindProcess() {
      return this.boolBindProcess;
   }

   public Boolean getBoolNestCutEnum() {
      return this.boolNestCutEnum;
   }

   public List<MesBuildingTeamUserLinkDTO> getUserLinkList() {
      return this.userLinkList;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getProcessTeamName() {
      return this.processTeamName;
   }

   @JsonProperty("id")
   public MesBuildingTeamDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingTeamDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public MesBuildingTeamDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingTeamDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingTeamDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingTeamDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("workshopName")
   public MesBuildingTeamDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTeamDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineName")
   public MesBuildingTeamDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingTeamDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("organizationType")
   public MesBuildingTeamDTO setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("hasMen")
   public MesBuildingTeamDTO setHasMen(final Boolean hasMen) {
      this.hasMen = hasMen;
      return this;
   }

   @JsonProperty("boolExtraCountEnum")
   public MesBuildingTeamDTO setBoolExtraCountEnum(final Boolean boolExtraCountEnum) {
      this.boolExtraCountEnum = boolExtraCountEnum;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public MesBuildingTeamDTO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingTeamDTO setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("teamStatus")
   public MesBuildingTeamDTO setTeamStatus(final Boolean teamStatus) {
      this.teamStatus = teamStatus;
      return this;
   }

   @JsonProperty("boolBindProcess")
   public MesBuildingTeamDTO setBoolBindProcess(final Boolean boolBindProcess) {
      this.boolBindProcess = boolBindProcess;
      return this;
   }

   @JsonProperty("boolNestCutEnum")
   public MesBuildingTeamDTO setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
      return this;
   }

   @JsonProperty("userLinkList")
   public MesBuildingTeamDTO setUserLinkList(final List<MesBuildingTeamUserLinkDTO> userLinkList) {
      this.userLinkList = userLinkList;
      return this;
   }

   @JsonProperty("teamName")
   public MesBuildingTeamDTO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   public MesBuildingTeamDTO setProcessTeamName(final String processTeamName) {
      this.processTeamName = processTeamName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTeamDTO(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", productType="
         + this.getProductType()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", userId="
         + this.getUserId()
         + ", organizationType="
         + this.getOrganizationType()
         + ", hasMen="
         + this.getHasMen()
         + ", boolExtraCountEnum="
         + this.getBoolExtraCountEnum()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", teamStatus="
         + this.getTeamStatus()
         + ", boolBindProcess="
         + this.getBoolBindProcess()
         + ", boolNestCutEnum="
         + this.getBoolNestCutEnum()
         + ", userLinkList="
         + this.getUserLinkList()
         + ", teamName="
         + this.getTeamName()
         + ", processTeamName="
         + this.getProcessTeamName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTeamDTO)) {
         return false;
      }

      MesBuildingTeamDTO other = (MesBuildingTeamDTO)o;
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
               Object this$factoryId = this.getFactoryId();
               Object other$factoryId = other.getFactoryId();
               if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$productionLineId = this.getProductionLineId();
                     Object other$productionLineId = other.getProductionLineId();
                     if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$organizationType = this.getOrganizationType();
                           Object other$organizationType = other.getOrganizationType();
                           if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
                              Object this$hasMen = this.getHasMen();
                              Object other$hasMen = other.getHasMen();
                              if (this$hasMen == null ? other$hasMen == null : this$hasMen.equals(other$hasMen)) {
                                 Object this$boolExtraCountEnum = this.getBoolExtraCountEnum();
                                 Object other$boolExtraCountEnum = other.getBoolExtraCountEnum();
                                 if (this$boolExtraCountEnum == null
                                    ? other$boolExtraCountEnum == null
                                    : this$boolExtraCountEnum.equals(other$boolExtraCountEnum)) {
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
                                             Object this$boolBindProcess = this.getBoolBindProcess();
                                             Object other$boolBindProcess = other.getBoolBindProcess();
                                             if (this$boolBindProcess == null
                                                ? other$boolBindProcess == null
                                                : this$boolBindProcess.equals(other$boolBindProcess)) {
                                                Object this$boolNestCutEnum = this.getBoolNestCutEnum();
                                                Object other$boolNestCutEnum = other.getBoolNestCutEnum();
                                                if (this$boolNestCutEnum == null
                                                   ? other$boolNestCutEnum == null
                                                   : this$boolNestCutEnum.equals(other$boolNestCutEnum)) {
                                                   Object this$processName = this.getProcessName();
                                                   Object other$processName = other.getProcessName();
                                                   if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                                      Object this$workshopName = this.getWorkshopName();
                                                      Object other$workshopName = other.getWorkshopName();
                                                      if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)
                                                         )
                                                       {
                                                         Object this$productionLineName = this.getProductionLineName();
                                                         Object other$productionLineName = other.getProductionLineName();
                                                         if (this$productionLineName == null
                                                            ? other$productionLineName == null
                                                            : this$productionLineName.equals(other$productionLineName)) {
                                                            Object this$userLinkList = this.getUserLinkList();
                                                            Object other$userLinkList = other.getUserLinkList();
                                                            if (this$userLinkList == null
                                                               ? other$userLinkList == null
                                                               : this$userLinkList.equals(other$userLinkList)) {
                                                               Object this$teamName = this.getTeamName();
                                                               Object other$teamName = other.getTeamName();
                                                               if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
                                                                  Object this$processTeamName = this.getProcessTeamName();
                                                                  Object other$processTeamName = other.getProcessTeamName();
                                                                  return this$processTeamName == null
                                                                     ? other$processTeamName == null
                                                                     : this$processTeamName.equals(other$processTeamName);
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTeamDTO;
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
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $hasMen = this.getHasMen();
      result = result * 59 + ($hasMen == null ? 43 : $hasMen.hashCode());
      Object $boolExtraCountEnum = this.getBoolExtraCountEnum();
      result = result * 59 + ($boolExtraCountEnum == null ? 43 : $boolExtraCountEnum.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $teamStatus = this.getTeamStatus();
      result = result * 59 + ($teamStatus == null ? 43 : $teamStatus.hashCode());
      Object $boolBindProcess = this.getBoolBindProcess();
      result = result * 59 + ($boolBindProcess == null ? 43 : $boolBindProcess.hashCode());
      Object $boolNestCutEnum = this.getBoolNestCutEnum();
      result = result * 59 + ($boolNestCutEnum == null ? 43 : $boolNestCutEnum.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $userLinkList = this.getUserLinkList();
      result = result * 59 + ($userLinkList == null ? 43 : $userLinkList.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $processTeamName = this.getProcessTeamName();
      return result * 59 + ($processTeamName == null ? 43 : $processTeamName.hashCode());
   }

   public static class MesBuildingTeamDTOBuilder {
      private Long id;
      private Long processId;
      private String processName;
      private Integer productType;
      private Long factoryId;
      private Long workshopId;
      private String workshopName;
      private Long productionLineId;
      private String productionLineName;
      private Long userId;
      private Boolean organizationType;
      private Boolean hasMen;
      private Boolean boolExtraCountEnum;
      private Integer wageQuotaType;
      private Integer productionLineTypeEnum;
      private Boolean teamStatus;
      private Boolean boolBindProcess;
      private Boolean boolNestCutEnum;
      private List<MesBuildingTeamUserLinkDTO> userLinkList;
      private String teamName;
      private String processTeamName;

      MesBuildingTeamDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("workshopName")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineName")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("organizationType")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("hasMen")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder hasMen(final Boolean hasMen) {
         this.hasMen = hasMen;
         return this;
      }

      @JsonProperty("boolExtraCountEnum")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder boolExtraCountEnum(final Boolean boolExtraCountEnum) {
         this.boolExtraCountEnum = boolExtraCountEnum;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("teamStatus")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder teamStatus(final Boolean teamStatus) {
         this.teamStatus = teamStatus;
         return this;
      }

      @JsonProperty("boolBindProcess")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder boolBindProcess(final Boolean boolBindProcess) {
         this.boolBindProcess = boolBindProcess;
         return this;
      }

      @JsonProperty("boolNestCutEnum")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      @JsonProperty("userLinkList")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder userLinkList(final List<MesBuildingTeamUserLinkDTO> userLinkList) {
         this.userLinkList = userLinkList;
         return this;
      }

      @JsonProperty("teamName")
      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      public MesBuildingTeamDTO.MesBuildingTeamDTOBuilder processTeamName(final String processTeamName) {
         this.processTeamName = processTeamName;
         return this;
      }

      public MesBuildingTeamDTO build() {
         return new MesBuildingTeamDTO(
            this.id,
            this.processId,
            this.processName,
            this.productType,
            this.factoryId,
            this.workshopId,
            this.workshopName,
            this.productionLineId,
            this.productionLineName,
            this.userId,
            this.organizationType,
            this.hasMen,
            this.boolExtraCountEnum,
            this.wageQuotaType,
            this.productionLineTypeEnum,
            this.teamStatus,
            this.boolBindProcess,
            this.boolNestCutEnum,
            this.userLinkList,
            this.teamName,
            this.processTeamName
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTeamDTO.MesBuildingTeamDTOBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", productType="
            + this.productType
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", productionLineId="
            + this.productionLineId
            + ", productionLineName="
            + this.productionLineName
            + ", userId="
            + this.userId
            + ", organizationType="
            + this.organizationType
            + ", hasMen="
            + this.hasMen
            + ", boolExtraCountEnum="
            + this.boolExtraCountEnum
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", teamStatus="
            + this.teamStatus
            + ", boolBindProcess="
            + this.boolBindProcess
            + ", boolNestCutEnum="
            + this.boolNestCutEnum
            + ", userLinkList="
            + this.userLinkList
            + ", teamName="
            + this.teamName
            + ", processTeamName="
            + this.processTeamName
            + ")";
      }
   }
}
