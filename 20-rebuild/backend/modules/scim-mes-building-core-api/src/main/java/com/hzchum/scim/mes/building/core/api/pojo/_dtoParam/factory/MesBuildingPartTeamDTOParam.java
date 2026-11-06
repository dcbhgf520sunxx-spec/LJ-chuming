package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingMachinePartTeamUserLinkDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingPartTeamDTOParam", description = "零件创建班组对象 ")
public class MesBuildingPartTeamDTOParam {
   @ApiModelProperty(name = "id", notes = "班组id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "groupsId", value = "零件班组id", notes = "零件班组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "teamId", value = "生产班组id", notes = "生产班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private List<String> teamId;
   @ApiModelProperty(name = "processId", notes = "工序id", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty("零件类型[1 板材零件 2 型材零件]")
   @JsonProperty("partType")
   @JSONField(name = "partType")
   private Integer partType;
   @ApiModelProperty(name = "partFeature", value = "零件特征", notes = "零件特征")
   @JsonProperty("partFeature")
   @JSONField(name = "partFeature")
   private List<Long> partFeature;
   @ApiModelProperty(name = "partProdMode", value = "零件生产方式", notes = "零件生产方式")
   @JsonProperty("partProdMode")
   @JSONField(name = "partProdMode")
   private Integer partProdMode;
   @ApiModelProperty(name = "MID", value = "MID", notes = "MID")
   @JsonProperty("MID")
   @JSONField(name = "MID")
   private String MID;
   @ApiModelProperty(name = "deviceType", value = "设备类型", notes = "设备类型")
   @JsonProperty("deviceType")
   @JSONField(name = "deviceType")
   private Integer deviceType;
   @ApiModelProperty(name = "deviceName", value = "设备名称", notes = "设备名称")
   @JsonProperty("deviceName")
   @JSONField(name = "deviceName")
   private String deviceName;
   @ApiModelProperty(name = "ncSystem", value = "数控系统", notes = "数控系统")
   @JsonProperty("ncSystem")
   @JSONField(name = "ncSystem")
   private Integer ncSystem;
   @ApiModelProperty(name = "ncFileFormat", value = "数控文件格式", notes = "数控文件格式")
   @JsonProperty("ncFileFormat")
   @JSONField(name = "ncFileFormat")
   private Integer ncFileFormat;
   @ApiModelProperty(name = "teamStatus", notes = "班组状态1开启 0关闭", value = "班组状态1开启 0关闭")
   @JsonProperty("teamStatus")
   @JSONField(name = "teamStatus")
   private Boolean teamStatus;
   @ApiModelProperty(name = "userLinks", notes = "班组人员", value = "班组人员")
   @JsonProperty("userLinks")
   @JSONField(name = "userLinks")
   private List<MesBuildingMachinePartTeamUserLinkDTO> userLinks;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]", value = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   private Boolean organizationType;
   @ApiModelProperty(name = "userId", notes = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "cuttingReportMethod", value = "切割报工方式", notes = "切割报工方式")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   private Integer cuttingReportMethod;
   @ApiModelProperty(name = "drillReportMethod", value = "钻孔报工方式", notes = "钻孔报工方式")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   private Integer drillReportMethod;
   @ApiModelProperty(name = "processType", value = "工序类型[1 下料类 2 钻孔类]", notes = "工序类型[1 下料类 2 钻孔类]")
   @JsonProperty("processType")
   @JSONField(name = "processType")
   private Integer processType;
   @ApiModelProperty(name = "drillMethod", value = "钻孔方式", notes = "钻孔方式")
   @JsonProperty("drillMethod")
   @JSONField(name = "drillMethod")
   private Integer drillMethod;
   @ApiModelProperty(name = "pageNumber", notes = "页码", value = "页码")
   @JsonProperty("pageNumber")
   @JSONField(name = "pageNumber")
   private Integer pageNumber = 1;
   @ApiModelProperty(name = "pageSize", notes = "每页数量", value = "每页数量")
   @JsonProperty("pageSize")
   @JSONField(name = "pageSize")
   private Integer pageSize = 10;

   public static MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder builder() {
      return new MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder();
   }

   public MesBuildingPartTeamDTOParam() {
   }

   public MesBuildingPartTeamDTOParam(
      final Long id,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final List<String> teamId,
      final Long processId,
      final Integer partType,
      final List<Long> partFeature,
      final Integer partProdMode,
      final String MID,
      final Integer deviceType,
      final String deviceName,
      final Integer ncSystem,
      final Integer ncFileFormat,
      final Boolean teamStatus,
      final List<MesBuildingMachinePartTeamUserLinkDTO> userLinks,
      final Boolean organizationType,
      final Long userId,
      final Integer cuttingReportMethod,
      final Integer drillReportMethod,
      final Integer processType,
      final Integer drillMethod,
      final Integer pageNumber,
      final Integer pageSize
   ) {
      this.id = id;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.teamId = teamId;
      this.processId = processId;
      this.partType = partType;
      this.partFeature = partFeature;
      this.partProdMode = partProdMode;
      this.MID = MID;
      this.deviceType = deviceType;
      this.deviceName = deviceName;
      this.ncSystem = ncSystem;
      this.ncFileFormat = ncFileFormat;
      this.teamStatus = teamStatus;
      this.userLinks = userLinks;
      this.organizationType = organizationType;
      this.userId = userId;
      this.cuttingReportMethod = cuttingReportMethod;
      this.drillReportMethod = drillReportMethod;
      this.processType = processType;
      this.drillMethod = drillMethod;
      this.pageNumber = pageNumber;
      this.pageSize = pageSize;
   }

   public Long getId() {
      return this.id;
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

   public List<String> getTeamId() {
      return this.teamId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getPartType() {
      return this.partType;
   }

   public List<Long> getPartFeature() {
      return this.partFeature;
   }

   public Integer getPartProdMode() {
      return this.partProdMode;
   }

   public String getMID() {
      return this.MID;
   }

   public Integer getDeviceType() {
      return this.deviceType;
   }

   public String getDeviceName() {
      return this.deviceName;
   }

   public Integer getNcSystem() {
      return this.ncSystem;
   }

   public Integer getNcFileFormat() {
      return this.ncFileFormat;
   }

   public Boolean getTeamStatus() {
      return this.teamStatus;
   }

   public List<MesBuildingMachinePartTeamUserLinkDTO> getUserLinks() {
      return this.userLinks;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getCuttingReportMethod() {
      return this.cuttingReportMethod;
   }

   public Integer getDrillReportMethod() {
      return this.drillReportMethod;
   }

   public Integer getProcessType() {
      return this.processType;
   }

   public Integer getDrillMethod() {
      return this.drillMethod;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   @JsonProperty("id")
   public MesBuildingPartTeamDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingPartTeamDTOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingPartTeamDTOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingPartTeamDTOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingPartTeamDTOParam setTeamId(final List<String> teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingPartTeamDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("partType")
   public MesBuildingPartTeamDTOParam setPartType(final Integer partType) {
      this.partType = partType;
      return this;
   }

   @JsonProperty("partFeature")
   public MesBuildingPartTeamDTOParam setPartFeature(final List<Long> partFeature) {
      this.partFeature = partFeature;
      return this;
   }

   @JsonProperty("partProdMode")
   public MesBuildingPartTeamDTOParam setPartProdMode(final Integer partProdMode) {
      this.partProdMode = partProdMode;
      return this;
   }

   @JsonProperty("MID")
   public MesBuildingPartTeamDTOParam setMID(final String MID) {
      this.MID = MID;
      return this;
   }

   @JsonProperty("deviceType")
   public MesBuildingPartTeamDTOParam setDeviceType(final Integer deviceType) {
      this.deviceType = deviceType;
      return this;
   }

   @JsonProperty("deviceName")
   public MesBuildingPartTeamDTOParam setDeviceName(final String deviceName) {
      this.deviceName = deviceName;
      return this;
   }

   @JsonProperty("ncSystem")
   public MesBuildingPartTeamDTOParam setNcSystem(final Integer ncSystem) {
      this.ncSystem = ncSystem;
      return this;
   }

   @JsonProperty("ncFileFormat")
   public MesBuildingPartTeamDTOParam setNcFileFormat(final Integer ncFileFormat) {
      this.ncFileFormat = ncFileFormat;
      return this;
   }

   @JsonProperty("teamStatus")
   public MesBuildingPartTeamDTOParam setTeamStatus(final Boolean teamStatus) {
      this.teamStatus = teamStatus;
      return this;
   }

   @JsonProperty("userLinks")
   public MesBuildingPartTeamDTOParam setUserLinks(final List<MesBuildingMachinePartTeamUserLinkDTO> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @JsonProperty("organizationType")
   public MesBuildingPartTeamDTOParam setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingPartTeamDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("organizationType")
   public MesBuildingPartTeamDTOParam setCuttingReportMethod(final Integer cuttingReportMethod) {
      this.cuttingReportMethod = cuttingReportMethod;
      return this;
   }

   @JsonProperty("organizationType")
   public MesBuildingPartTeamDTOParam setDrillReportMethod(final Integer drillReportMethod) {
      this.drillReportMethod = drillReportMethod;
      return this;
   }

   @JsonProperty("processType")
   public MesBuildingPartTeamDTOParam setProcessType(final Integer processType) {
      this.processType = processType;
      return this;
   }

   @JsonProperty("drillMethod")
   public MesBuildingPartTeamDTOParam setDrillMethod(final Integer drillMethod) {
      this.drillMethod = drillMethod;
      return this;
   }

   @JsonProperty("pageNumber")
   public MesBuildingPartTeamDTOParam setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
      return this;
   }

   @JsonProperty("pageSize")
   public MesBuildingPartTeamDTOParam setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPartTeamDTOParam)) {
         return false;
      }

      MesBuildingPartTeamDTOParam other = (MesBuildingPartTeamDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$productionLineId = this.getProductionLineId();
            Object other$productionLineId = other.getProductionLineId();
            if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
               Object this$groupsId = this.getGroupsId();
               Object other$groupsId = other.getGroupsId();
               if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$partType = this.getPartType();
                     Object other$partType = other.getPartType();
                     if (this$partType == null ? other$partType == null : this$partType.equals(other$partType)) {
                        Object this$partProdMode = this.getPartProdMode();
                        Object other$partProdMode = other.getPartProdMode();
                        if (this$partProdMode == null ? other$partProdMode == null : this$partProdMode.equals(other$partProdMode)) {
                           Object this$deviceType = this.getDeviceType();
                           Object other$deviceType = other.getDeviceType();
                           if (this$deviceType == null ? other$deviceType == null : this$deviceType.equals(other$deviceType)) {
                              Object this$ncSystem = this.getNcSystem();
                              Object other$ncSystem = other.getNcSystem();
                              if (this$ncSystem == null ? other$ncSystem == null : this$ncSystem.equals(other$ncSystem)) {
                                 Object this$ncFileFormat = this.getNcFileFormat();
                                 Object other$ncFileFormat = other.getNcFileFormat();
                                 if (this$ncFileFormat == null ? other$ncFileFormat == null : this$ncFileFormat.equals(other$ncFileFormat)) {
                                    Object this$teamStatus = this.getTeamStatus();
                                    Object other$teamStatus = other.getTeamStatus();
                                    if (this$teamStatus == null ? other$teamStatus == null : this$teamStatus.equals(other$teamStatus)) {
                                       Object this$organizationType = this.getOrganizationType();
                                       Object other$organizationType = other.getOrganizationType();
                                       if (this$organizationType == null
                                          ? other$organizationType == null
                                          : this$organizationType.equals(other$organizationType)) {
                                          Object this$userId = this.getUserId();
                                          Object other$userId = other.getUserId();
                                          if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                             Object this$cuttingReportMethod = this.getCuttingReportMethod();
                                             Object other$cuttingReportMethod = other.getCuttingReportMethod();
                                             if (this$cuttingReportMethod == null
                                                ? other$cuttingReportMethod == null
                                                : this$cuttingReportMethod.equals(other$cuttingReportMethod)) {
                                                Object this$drillReportMethod = this.getDrillReportMethod();
                                                Object other$drillReportMethod = other.getDrillReportMethod();
                                                if (this$drillReportMethod == null
                                                   ? other$drillReportMethod == null
                                                   : this$drillReportMethod.equals(other$drillReportMethod)) {
                                                   Object this$processType = this.getProcessType();
                                                   Object other$processType = other.getProcessType();
                                                   if (this$processType == null ? other$processType == null : this$processType.equals(other$processType)) {
                                                      Object this$drillMethod = this.getDrillMethod();
                                                      Object other$drillMethod = other.getDrillMethod();
                                                      if (this$drillMethod == null ? other$drillMethod == null : this$drillMethod.equals(other$drillMethod)) {
                                                         Object this$pageNumber = this.getPageNumber();
                                                         Object other$pageNumber = other.getPageNumber();
                                                         if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                                                            Object this$pageSize = this.getPageSize();
                                                            Object other$pageSize = other.getPageSize();
                                                            if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                                                               Object this$teamId = this.getTeamId();
                                                               Object other$teamId = other.getTeamId();
                                                               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                                                  Object this$partFeature = this.getPartFeature();
                                                                  Object other$partFeature = other.getPartFeature();
                                                                  if (this$partFeature == null
                                                                     ? other$partFeature == null
                                                                     : this$partFeature.equals(other$partFeature)) {
                                                                     Object this$MID = this.getMID();
                                                                     Object other$MID = other.getMID();
                                                                     if (this$MID == null ? other$MID == null : this$MID.equals(other$MID)) {
                                                                        Object this$deviceName = this.getDeviceName();
                                                                        Object other$deviceName = other.getDeviceName();
                                                                        if (this$deviceName == null
                                                                           ? other$deviceName == null
                                                                           : this$deviceName.equals(other$deviceName)) {
                                                                           Object this$userLinks = this.getUserLinks();
                                                                           Object other$userLinks = other.getUserLinks();
                                                                           return this$userLinks == null
                                                                              ? other$userLinks == null
                                                                              : this$userLinks.equals(other$userLinks);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPartTeamDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $partType = this.getPartType();
      result = result * 59 + ($partType == null ? 43 : $partType.hashCode());
      Object $partProdMode = this.getPartProdMode();
      result = result * 59 + ($partProdMode == null ? 43 : $partProdMode.hashCode());
      Object $deviceType = this.getDeviceType();
      result = result * 59 + ($deviceType == null ? 43 : $deviceType.hashCode());
      Object $ncSystem = this.getNcSystem();
      result = result * 59 + ($ncSystem == null ? 43 : $ncSystem.hashCode());
      Object $ncFileFormat = this.getNcFileFormat();
      result = result * 59 + ($ncFileFormat == null ? 43 : $ncFileFormat.hashCode());
      Object $teamStatus = this.getTeamStatus();
      result = result * 59 + ($teamStatus == null ? 43 : $teamStatus.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $cuttingReportMethod = this.getCuttingReportMethod();
      result = result * 59 + ($cuttingReportMethod == null ? 43 : $cuttingReportMethod.hashCode());
      Object $drillReportMethod = this.getDrillReportMethod();
      result = result * 59 + ($drillReportMethod == null ? 43 : $drillReportMethod.hashCode());
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $drillMethod = this.getDrillMethod();
      result = result * 59 + ($drillMethod == null ? 43 : $drillMethod.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $partFeature = this.getPartFeature();
      result = result * 59 + ($partFeature == null ? 43 : $partFeature.hashCode());
      Object $MID = this.getMID();
      result = result * 59 + ($MID == null ? 43 : $MID.hashCode());
      Object $deviceName = this.getDeviceName();
      result = result * 59 + ($deviceName == null ? 43 : $deviceName.hashCode());
      Object $userLinks = this.getUserLinks();
      return result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingPartTeamDTOParam(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", teamId="
         + this.getTeamId()
         + ", processId="
         + this.getProcessId()
         + ", partType="
         + this.getPartType()
         + ", partFeature="
         + this.getPartFeature()
         + ", partProdMode="
         + this.getPartProdMode()
         + ", MID="
         + this.getMID()
         + ", deviceType="
         + this.getDeviceType()
         + ", deviceName="
         + this.getDeviceName()
         + ", ncSystem="
         + this.getNcSystem()
         + ", ncFileFormat="
         + this.getNcFileFormat()
         + ", teamStatus="
         + this.getTeamStatus()
         + ", userLinks="
         + this.getUserLinks()
         + ", organizationType="
         + this.getOrganizationType()
         + ", userId="
         + this.getUserId()
         + ", cuttingReportMethod="
         + this.getCuttingReportMethod()
         + ", drillReportMethod="
         + this.getDrillReportMethod()
         + ", processType="
         + this.getProcessType()
         + ", drillMethod="
         + this.getDrillMethod()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ")";
   }

   public static class MesBuildingPartTeamDTOParamBuilder {
      private Long id;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private List<String> teamId;
      private Long processId;
      private Integer partType;
      private List<Long> partFeature;
      private Integer partProdMode;
      private String MID;
      private Integer deviceType;
      private String deviceName;
      private Integer ncSystem;
      private Integer ncFileFormat;
      private Boolean teamStatus;
      private List<MesBuildingMachinePartTeamUserLinkDTO> userLinks;
      private Boolean organizationType;
      private Long userId;
      private Integer cuttingReportMethod;
      private Integer drillReportMethod;
      private Integer processType;
      private Integer drillMethod;
      private Integer pageNumber;
      private Integer pageSize;

      MesBuildingPartTeamDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder teamId(final List<String> teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("partType")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder partType(final Integer partType) {
         this.partType = partType;
         return this;
      }

      @JsonProperty("partFeature")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder partFeature(final List<Long> partFeature) {
         this.partFeature = partFeature;
         return this;
      }

      @JsonProperty("partProdMode")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder partProdMode(final Integer partProdMode) {
         this.partProdMode = partProdMode;
         return this;
      }

      @JsonProperty("MID")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder MID(final String MID) {
         this.MID = MID;
         return this;
      }

      @JsonProperty("deviceType")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder deviceType(final Integer deviceType) {
         this.deviceType = deviceType;
         return this;
      }

      @JsonProperty("deviceName")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder deviceName(final String deviceName) {
         this.deviceName = deviceName;
         return this;
      }

      @JsonProperty("ncSystem")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder ncSystem(final Integer ncSystem) {
         this.ncSystem = ncSystem;
         return this;
      }

      @JsonProperty("ncFileFormat")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder ncFileFormat(final Integer ncFileFormat) {
         this.ncFileFormat = ncFileFormat;
         return this;
      }

      @JsonProperty("teamStatus")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder teamStatus(final Boolean teamStatus) {
         this.teamStatus = teamStatus;
         return this;
      }

      @JsonProperty("userLinks")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder userLinks(final List<MesBuildingMachinePartTeamUserLinkDTO> userLinks) {
         this.userLinks = userLinks;
         return this;
      }

      @JsonProperty("organizationType")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("organizationType")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder cuttingReportMethod(final Integer cuttingReportMethod) {
         this.cuttingReportMethod = cuttingReportMethod;
         return this;
      }

      @JsonProperty("organizationType")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder drillReportMethod(final Integer drillReportMethod) {
         this.drillReportMethod = drillReportMethod;
         return this;
      }

      @JsonProperty("processType")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      @JsonProperty("drillMethod")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder drillMethod(final Integer drillMethod) {
         this.drillMethod = drillMethod;
         return this;
      }

      @JsonProperty("pageNumber")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder pageNumber(final Integer pageNumber) {
         this.pageNumber = pageNumber;
         return this;
      }

      @JsonProperty("pageSize")
      public MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder pageSize(final Integer pageSize) {
         this.pageSize = pageSize;
         return this;
      }

      public MesBuildingPartTeamDTOParam build() {
         return new MesBuildingPartTeamDTOParam(
            this.id,
            this.workshopId,
            this.productionLineId,
            this.groupsId,
            this.teamId,
            this.processId,
            this.partType,
            this.partFeature,
            this.partProdMode,
            this.MID,
            this.deviceType,
            this.deviceName,
            this.ncSystem,
            this.ncFileFormat,
            this.teamStatus,
            this.userLinks,
            this.organizationType,
            this.userId,
            this.cuttingReportMethod,
            this.drillReportMethod,
            this.processType,
            this.drillMethod,
            this.pageNumber,
            this.pageSize
         );
      }

      @Override
      public String toString() {
         return "MesBuildingPartTeamDTOParam.MesBuildingPartTeamDTOParamBuilder(id="
            + this.id
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", teamId="
            + this.teamId
            + ", processId="
            + this.processId
            + ", partType="
            + this.partType
            + ", partFeature="
            + this.partFeature
            + ", partProdMode="
            + this.partProdMode
            + ", MID="
            + this.MID
            + ", deviceType="
            + this.deviceType
            + ", deviceName="
            + this.deviceName
            + ", ncSystem="
            + this.ncSystem
            + ", ncFileFormat="
            + this.ncFileFormat
            + ", teamStatus="
            + this.teamStatus
            + ", userLinks="
            + this.userLinks
            + ", organizationType="
            + this.organizationType
            + ", userId="
            + this.userId
            + ", cuttingReportMethod="
            + this.cuttingReportMethod
            + ", drillReportMethod="
            + this.drillReportMethod
            + ", processType="
            + this.processType
            + ", drillMethod="
            + this.drillMethod
            + ", pageNumber="
            + this.pageNumber
            + ", pageSize="
            + this.pageSize
            + ")";
      }
   }
}
