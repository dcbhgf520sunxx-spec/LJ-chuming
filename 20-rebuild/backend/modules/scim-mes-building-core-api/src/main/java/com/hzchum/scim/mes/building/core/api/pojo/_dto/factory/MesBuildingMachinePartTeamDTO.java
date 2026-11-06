package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class MesBuildingMachinePartTeamDTO {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "workshop", value = "车间", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private NameInfo workshop;
   @ApiModelProperty(name = "productionLine", notes = "生产线", value = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private NameInfo productionLine;
   @ApiModelProperty(name = "process", notes = "工序", value = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private NameInfo process;
   @ApiModelProperty(name = "MID", value = "MID", notes = "MID")
   @JsonProperty("MID")
   @JSONField(name = "MID")
   private String MID;
   @ApiModelProperty("零件类型[1 板材零件 2 型材零件]")
   @JsonProperty("partType")
   @JSONField(name = "partType")
   private Integer partType;
   @ApiModelProperty(name = "partFeature", value = "零件特征", notes = "零件特征")
   @JsonProperty("partFeature")
   @JSONField(name = "partFeature")
   private String partFeature;
   @ApiModelProperty(name = "partFeatureList", value = "零件特征", notes = "零件特征")
   @JsonProperty("partFeatureList")
   @JSONField(name = "partFeatureList")
   private List<Long> partFeatureList;
   @ApiModelProperty(name = "partTypeName", value = "零件类型名称", notes = "零件类型名称")
   @JsonProperty("partTypeName")
   @JSONField(name = "partTypeName")
   private String partTypeName;
   @ApiModelProperty(name = "partProdMode", value = "零件生产方式", notes = "零件生产方式")
   @JsonProperty("partProdMode")
   @JSONField(name = "partProdMode")
   private Integer partProdMode;
   @ApiModelProperty(name = "deviceType", value = "设备类型", notes = "设备类型")
   @JsonProperty("deviceType")
   @JSONField(name = "deviceType")
   private NameInfo deviceType;
   @ApiModelProperty(name = "deviceName", value = "设备名称", notes = "设备名称")
   @JsonProperty("deviceName")
   @JSONField(name = "deviceName")
   private String deviceName;
   @ApiModelProperty(name = "ncSystem", value = "数控系统", notes = "数控系统")
   @JsonProperty("ncSystem")
   @JSONField(name = "ncSystem")
   private NameInfo ncSystem;
   @ApiModelProperty(name = "ncFileFormat", value = "数控文件格式", notes = "数控文件格式")
   @JsonProperty("ncFileFormat")
   @JSONField(name = "ncFileFormat")
   private NameInfo ncFileFormat;
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
   @ApiModelProperty(name = "machineToolId", notes = "机床id")
   @JsonProperty("machineToolId")
   @JSONField(name = "machineToolId")
   private Long machineToolId;
   @ApiModelProperty(name = "cuttingReportMethod", value = "切割报工方式", notes = "切割报工方式")
   @JsonProperty("cuttingReportMethod")
   @JSONField(name = "cuttingReportMethod")
   private Integer cuttingReportMethod;
   @ApiModelProperty(name = "drillReportMethod", value = "钻孔报工方式", notes = "钻孔报工方式")
   @JsonProperty("drillReportMethod")
   @JSONField(name = "drillReportMethod")
   private Integer drillReportMethod;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "groupsName", value = "生产组名称", notes = "生产组名称")
   @JsonProperty("groupsName")
   @JSONField(name = "groupsName")
   private String groupsName;
   @ApiModelProperty(name = "downConfigId", value = "下料配置id", notes = "下料配置id")
   @JsonProperty("downConfigId")
   @JSONField(name = "downConfigId")
   private Long downConfigId;
   @ApiModelProperty(name = "drillMethod", value = "钻孔方式", notes = "钻孔方式")
   @JsonProperty("drillMethod")
   @JSONField(name = "drillMethod")
   private Integer drillMethod;
   @ApiModelProperty(name = "processType", value = "工序类型[4 下料类 8 钻孔类]", notes = "工序类型[4 下料类 8 钻孔类]")
   @JsonProperty("processType")
   @JSONField(name = "processType")
   private Integer processType;
   @ApiModelProperty(name = "productionStatus", value = "生产状态", notes = "生产状态")
   @JsonProperty("productionStatus")
   @JSONField(name = "productionStatus")
   private Boolean productionStatus;

   public static MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder builder() {
      return new MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder();
   }

   public MesBuildingMachinePartTeamDTO() {
   }

   public MesBuildingMachinePartTeamDTO(
      final Long id,
      final NameInfo workshop,
      final NameInfo productionLine,
      final NameInfo process,
      final String MID,
      final Integer partType,
      final String partFeature,
      final List<Long> partFeatureList,
      final String partTypeName,
      final Integer partProdMode,
      final NameInfo deviceType,
      final String deviceName,
      final NameInfo ncSystem,
      final NameInfo ncFileFormat,
      final Boolean teamStatus,
      final List<MesBuildingMachinePartTeamUserLinkDTO> userLinks,
      final Boolean organizationType,
      final Long userId,
      final Long machineToolId,
      final Integer cuttingReportMethod,
      final Integer drillReportMethod,
      final Long groupsId,
      final String groupsName,
      final Long downConfigId,
      final Integer drillMethod,
      final Integer processType,
      final Boolean productionStatus
   ) {
      this.id = id;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.process = process;
      this.MID = MID;
      this.partType = partType;
      this.partFeature = partFeature;
      this.partFeatureList = partFeatureList;
      this.partTypeName = partTypeName;
      this.partProdMode = partProdMode;
      this.deviceType = deviceType;
      this.deviceName = deviceName;
      this.ncSystem = ncSystem;
      this.ncFileFormat = ncFileFormat;
      this.teamStatus = teamStatus;
      this.userLinks = userLinks;
      this.organizationType = organizationType;
      this.userId = userId;
      this.machineToolId = machineToolId;
      this.cuttingReportMethod = cuttingReportMethod;
      this.drillReportMethod = drillReportMethod;
      this.groupsId = groupsId;
      this.groupsName = groupsName;
      this.downConfigId = downConfigId;
      this.drillMethod = drillMethod;
      this.processType = processType;
      this.productionStatus = productionStatus;
   }

   public Long getId() {
      return this.id;
   }

   public NameInfo getWorkshop() {
      return this.workshop;
   }

   public NameInfo getProductionLine() {
      return this.productionLine;
   }

   public NameInfo getProcess() {
      return this.process;
   }

   public String getMID() {
      return this.MID;
   }

   public Integer getPartType() {
      return this.partType;
   }

   public String getPartFeature() {
      return this.partFeature;
   }

   public List<Long> getPartFeatureList() {
      return this.partFeatureList;
   }

   public String getPartTypeName() {
      return this.partTypeName;
   }

   public Integer getPartProdMode() {
      return this.partProdMode;
   }

   public NameInfo getDeviceType() {
      return this.deviceType;
   }

   public String getDeviceName() {
      return this.deviceName;
   }

   public NameInfo getNcSystem() {
      return this.ncSystem;
   }

   public NameInfo getNcFileFormat() {
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

   public Long getMachineToolId() {
      return this.machineToolId;
   }

   public Integer getCuttingReportMethod() {
      return this.cuttingReportMethod;
   }

   public Integer getDrillReportMethod() {
      return this.drillReportMethod;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public String getGroupsName() {
      return this.groupsName;
   }

   public Long getDownConfigId() {
      return this.downConfigId;
   }

   public Integer getDrillMethod() {
      return this.drillMethod;
   }

   public Integer getProcessType() {
      return this.processType;
   }

   public Boolean getProductionStatus() {
      return this.productionStatus;
   }

   @JsonProperty("id")
   public MesBuildingMachinePartTeamDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("workshop")
   public MesBuildingMachinePartTeamDTO setWorkshop(final NameInfo workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public MesBuildingMachinePartTeamDTO setProductionLine(final NameInfo productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("process")
   public MesBuildingMachinePartTeamDTO setProcess(final NameInfo process) {
      this.process = process;
      return this;
   }

   @JsonProperty("MID")
   public MesBuildingMachinePartTeamDTO setMID(final String MID) {
      this.MID = MID;
      return this;
   }

   @JsonProperty("partType")
   public MesBuildingMachinePartTeamDTO setPartType(final Integer partType) {
      this.partType = partType;
      return this;
   }

   @JsonProperty("partFeature")
   public MesBuildingMachinePartTeamDTO setPartFeature(final String partFeature) {
      this.partFeature = partFeature;
      return this;
   }

   @JsonProperty("partFeatureList")
   public MesBuildingMachinePartTeamDTO setPartFeatureList(final List<Long> partFeatureList) {
      this.partFeatureList = partFeatureList;
      return this;
   }

   @JsonProperty("partTypeName")
   public MesBuildingMachinePartTeamDTO setPartTypeName(final String partTypeName) {
      this.partTypeName = partTypeName;
      return this;
   }

   @JsonProperty("partProdMode")
   public MesBuildingMachinePartTeamDTO setPartProdMode(final Integer partProdMode) {
      this.partProdMode = partProdMode;
      return this;
   }

   @JsonProperty("deviceType")
   public MesBuildingMachinePartTeamDTO setDeviceType(final NameInfo deviceType) {
      this.deviceType = deviceType;
      return this;
   }

   @JsonProperty("deviceName")
   public MesBuildingMachinePartTeamDTO setDeviceName(final String deviceName) {
      this.deviceName = deviceName;
      return this;
   }

   @JsonProperty("ncSystem")
   public MesBuildingMachinePartTeamDTO setNcSystem(final NameInfo ncSystem) {
      this.ncSystem = ncSystem;
      return this;
   }

   @JsonProperty("ncFileFormat")
   public MesBuildingMachinePartTeamDTO setNcFileFormat(final NameInfo ncFileFormat) {
      this.ncFileFormat = ncFileFormat;
      return this;
   }

   @JsonProperty("teamStatus")
   public MesBuildingMachinePartTeamDTO setTeamStatus(final Boolean teamStatus) {
      this.teamStatus = teamStatus;
      return this;
   }

   @JsonProperty("userLinks")
   public MesBuildingMachinePartTeamDTO setUserLinks(final List<MesBuildingMachinePartTeamUserLinkDTO> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @JsonProperty("organizationType")
   public MesBuildingMachinePartTeamDTO setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingMachinePartTeamDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("machineToolId")
   public MesBuildingMachinePartTeamDTO setMachineToolId(final Long machineToolId) {
      this.machineToolId = machineToolId;
      return this;
   }

   @JsonProperty("cuttingReportMethod")
   public MesBuildingMachinePartTeamDTO setCuttingReportMethod(final Integer cuttingReportMethod) {
      this.cuttingReportMethod = cuttingReportMethod;
      return this;
   }

   @JsonProperty("drillReportMethod")
   public MesBuildingMachinePartTeamDTO setDrillReportMethod(final Integer drillReportMethod) {
      this.drillReportMethod = drillReportMethod;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingMachinePartTeamDTO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("groupsName")
   public MesBuildingMachinePartTeamDTO setGroupsName(final String groupsName) {
      this.groupsName = groupsName;
      return this;
   }

   @JsonProperty("downConfigId")
   public MesBuildingMachinePartTeamDTO setDownConfigId(final Long downConfigId) {
      this.downConfigId = downConfigId;
      return this;
   }

   @JsonProperty("drillMethod")
   public MesBuildingMachinePartTeamDTO setDrillMethod(final Integer drillMethod) {
      this.drillMethod = drillMethod;
      return this;
   }

   @JsonProperty("processType")
   public MesBuildingMachinePartTeamDTO setProcessType(final Integer processType) {
      this.processType = processType;
      return this;
   }

   @JsonProperty("productionStatus")
   public MesBuildingMachinePartTeamDTO setProductionStatus(final Boolean productionStatus) {
      this.productionStatus = productionStatus;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartTeamDTO(id="
         + this.getId()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", process="
         + this.getProcess()
         + ", MID="
         + this.getMID()
         + ", partType="
         + this.getPartType()
         + ", partFeature="
         + this.getPartFeature()
         + ", partFeatureList="
         + this.getPartFeatureList()
         + ", partTypeName="
         + this.getPartTypeName()
         + ", partProdMode="
         + this.getPartProdMode()
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
         + ", machineToolId="
         + this.getMachineToolId()
         + ", cuttingReportMethod="
         + this.getCuttingReportMethod()
         + ", drillReportMethod="
         + this.getDrillReportMethod()
         + ", groupsId="
         + this.getGroupsId()
         + ", groupsName="
         + this.getGroupsName()
         + ", downConfigId="
         + this.getDownConfigId()
         + ", drillMethod="
         + this.getDrillMethod()
         + ", processType="
         + this.getProcessType()
         + ", productionStatus="
         + this.getProductionStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartTeamDTO)) {
         return false;
      }

      MesBuildingMachinePartTeamDTO other = (MesBuildingMachinePartTeamDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$partType = this.getPartType();
         Object other$partType = other.getPartType();
         if (this$partType == null ? other$partType == null : this$partType.equals(other$partType)) {
            Object this$partProdMode = this.getPartProdMode();
            Object other$partProdMode = other.getPartProdMode();
            if (this$partProdMode == null ? other$partProdMode == null : this$partProdMode.equals(other$partProdMode)) {
               Object this$teamStatus = this.getTeamStatus();
               Object other$teamStatus = other.getTeamStatus();
               if (this$teamStatus == null ? other$teamStatus == null : this$teamStatus.equals(other$teamStatus)) {
                  Object this$organizationType = this.getOrganizationType();
                  Object other$organizationType = other.getOrganizationType();
                  if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$machineToolId = this.getMachineToolId();
                        Object other$machineToolId = other.getMachineToolId();
                        if (this$machineToolId == null ? other$machineToolId == null : this$machineToolId.equals(other$machineToolId)) {
                           Object this$cuttingReportMethod = this.getCuttingReportMethod();
                           Object other$cuttingReportMethod = other.getCuttingReportMethod();
                           if (this$cuttingReportMethod == null
                              ? other$cuttingReportMethod == null
                              : this$cuttingReportMethod.equals(other$cuttingReportMethod)) {
                              Object this$drillReportMethod = this.getDrillReportMethod();
                              Object other$drillReportMethod = other.getDrillReportMethod();
                              if (this$drillReportMethod == null ? other$drillReportMethod == null : this$drillReportMethod.equals(other$drillReportMethod)) {
                                 Object this$groupsId = this.getGroupsId();
                                 Object other$groupsId = other.getGroupsId();
                                 if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                                    Object this$downConfigId = this.getDownConfigId();
                                    Object other$downConfigId = other.getDownConfigId();
                                    if (this$downConfigId == null ? other$downConfigId == null : this$downConfigId.equals(other$downConfigId)) {
                                       Object this$drillMethod = this.getDrillMethod();
                                       Object other$drillMethod = other.getDrillMethod();
                                       if (this$drillMethod == null ? other$drillMethod == null : this$drillMethod.equals(other$drillMethod)) {
                                          Object this$processType = this.getProcessType();
                                          Object other$processType = other.getProcessType();
                                          if (this$processType == null ? other$processType == null : this$processType.equals(other$processType)) {
                                             Object this$productionStatus = this.getProductionStatus();
                                             Object other$productionStatus = other.getProductionStatus();
                                             if (this$productionStatus == null
                                                ? other$productionStatus == null
                                                : this$productionStatus.equals(other$productionStatus)) {
                                                Object this$workshop = this.getWorkshop();
                                                Object other$workshop = other.getWorkshop();
                                                if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                   Object this$productionLine = this.getProductionLine();
                                                   Object other$productionLine = other.getProductionLine();
                                                   if (this$productionLine == null
                                                      ? other$productionLine == null
                                                      : this$productionLine.equals(other$productionLine)) {
                                                      Object this$process = this.getProcess();
                                                      Object other$process = other.getProcess();
                                                      if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                                                         Object this$MID = this.getMID();
                                                         Object other$MID = other.getMID();
                                                         if (this$MID == null ? other$MID == null : this$MID.equals(other$MID)) {
                                                            Object this$partFeature = this.getPartFeature();
                                                            Object other$partFeature = other.getPartFeature();
                                                            if (this$partFeature == null
                                                               ? other$partFeature == null
                                                               : this$partFeature.equals(other$partFeature)) {
                                                               Object this$partFeatureList = this.getPartFeatureList();
                                                               Object other$partFeatureList = other.getPartFeatureList();
                                                               if (this$partFeatureList == null
                                                                  ? other$partFeatureList == null
                                                                  : this$partFeatureList.equals(other$partFeatureList)) {
                                                                  Object this$partTypeName = this.getPartTypeName();
                                                                  Object other$partTypeName = other.getPartTypeName();
                                                                  if (this$partTypeName == null
                                                                     ? other$partTypeName == null
                                                                     : this$partTypeName.equals(other$partTypeName)) {
                                                                     Object this$deviceType = this.getDeviceType();
                                                                     Object other$deviceType = other.getDeviceType();
                                                                     if (this$deviceType == null
                                                                        ? other$deviceType == null
                                                                        : this$deviceType.equals(other$deviceType)) {
                                                                        Object this$deviceName = this.getDeviceName();
                                                                        Object other$deviceName = other.getDeviceName();
                                                                        if (this$deviceName == null
                                                                           ? other$deviceName == null
                                                                           : this$deviceName.equals(other$deviceName)) {
                                                                           Object this$ncSystem = this.getNcSystem();
                                                                           Object other$ncSystem = other.getNcSystem();
                                                                           if (this$ncSystem == null
                                                                              ? other$ncSystem == null
                                                                              : this$ncSystem.equals(other$ncSystem)) {
                                                                              Object this$ncFileFormat = this.getNcFileFormat();
                                                                              Object other$ncFileFormat = other.getNcFileFormat();
                                                                              if (this$ncFileFormat == null
                                                                                 ? other$ncFileFormat == null
                                                                                 : this$ncFileFormat.equals(other$ncFileFormat)) {
                                                                                 Object this$userLinks = this.getUserLinks();
                                                                                 Object other$userLinks = other.getUserLinks();
                                                                                 if (this$userLinks == null
                                                                                    ? other$userLinks == null
                                                                                    : this$userLinks.equals(other$userLinks)) {
                                                                                    Object this$groupsName = this.getGroupsName();
                                                                                    Object other$groupsName = other.getGroupsName();
                                                                                    return this$groupsName == null
                                                                                       ? other$groupsName == null
                                                                                       : this$groupsName.equals(other$groupsName);
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
      return other instanceof MesBuildingMachinePartTeamDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $partType = this.getPartType();
      result = result * 59 + ($partType == null ? 43 : $partType.hashCode());
      Object $partProdMode = this.getPartProdMode();
      result = result * 59 + ($partProdMode == null ? 43 : $partProdMode.hashCode());
      Object $teamStatus = this.getTeamStatus();
      result = result * 59 + ($teamStatus == null ? 43 : $teamStatus.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $machineToolId = this.getMachineToolId();
      result = result * 59 + ($machineToolId == null ? 43 : $machineToolId.hashCode());
      Object $cuttingReportMethod = this.getCuttingReportMethod();
      result = result * 59 + ($cuttingReportMethod == null ? 43 : $cuttingReportMethod.hashCode());
      Object $drillReportMethod = this.getDrillReportMethod();
      result = result * 59 + ($drillReportMethod == null ? 43 : $drillReportMethod.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $downConfigId = this.getDownConfigId();
      result = result * 59 + ($downConfigId == null ? 43 : $downConfigId.hashCode());
      Object $drillMethod = this.getDrillMethod();
      result = result * 59 + ($drillMethod == null ? 43 : $drillMethod.hashCode());
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $productionStatus = this.getProductionStatus();
      result = result * 59 + ($productionStatus == null ? 43 : $productionStatus.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $MID = this.getMID();
      result = result * 59 + ($MID == null ? 43 : $MID.hashCode());
      Object $partFeature = this.getPartFeature();
      result = result * 59 + ($partFeature == null ? 43 : $partFeature.hashCode());
      Object $partFeatureList = this.getPartFeatureList();
      result = result * 59 + ($partFeatureList == null ? 43 : $partFeatureList.hashCode());
      Object $partTypeName = this.getPartTypeName();
      result = result * 59 + ($partTypeName == null ? 43 : $partTypeName.hashCode());
      Object $deviceType = this.getDeviceType();
      result = result * 59 + ($deviceType == null ? 43 : $deviceType.hashCode());
      Object $deviceName = this.getDeviceName();
      result = result * 59 + ($deviceName == null ? 43 : $deviceName.hashCode());
      Object $ncSystem = this.getNcSystem();
      result = result * 59 + ($ncSystem == null ? 43 : $ncSystem.hashCode());
      Object $ncFileFormat = this.getNcFileFormat();
      result = result * 59 + ($ncFileFormat == null ? 43 : $ncFileFormat.hashCode());
      Object $userLinks = this.getUserLinks();
      result = result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
      Object $groupsName = this.getGroupsName();
      return result * 59 + ($groupsName == null ? 43 : $groupsName.hashCode());
   }

   public static class MesBuildingMachinePartTeamDTOBuilder {
      private Long id;
      private NameInfo workshop;
      private NameInfo productionLine;
      private NameInfo process;
      private String MID;
      private Integer partType;
      private String partFeature;
      private List<Long> partFeatureList;
      private String partTypeName;
      private Integer partProdMode;
      private NameInfo deviceType;
      private String deviceName;
      private NameInfo ncSystem;
      private NameInfo ncFileFormat;
      private Boolean teamStatus;
      private List<MesBuildingMachinePartTeamUserLinkDTO> userLinks;
      private Boolean organizationType;
      private Long userId;
      private Long machineToolId;
      private Integer cuttingReportMethod;
      private Integer drillReportMethod;
      private Long groupsId;
      private String groupsName;
      private Long downConfigId;
      private Integer drillMethod;
      private Integer processType;
      private Boolean productionStatus;

      MesBuildingMachinePartTeamDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("workshop")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder workshop(final NameInfo workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder productionLine(final NameInfo productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("process")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder process(final NameInfo process) {
         this.process = process;
         return this;
      }

      @JsonProperty("MID")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder MID(final String MID) {
         this.MID = MID;
         return this;
      }

      @JsonProperty("partType")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder partType(final Integer partType) {
         this.partType = partType;
         return this;
      }

      @JsonProperty("partFeature")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder partFeature(final String partFeature) {
         this.partFeature = partFeature;
         return this;
      }

      @JsonProperty("partFeatureList")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder partFeatureList(final List<Long> partFeatureList) {
         this.partFeatureList = partFeatureList;
         return this;
      }

      @JsonProperty("partTypeName")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder partTypeName(final String partTypeName) {
         this.partTypeName = partTypeName;
         return this;
      }

      @JsonProperty("partProdMode")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder partProdMode(final Integer partProdMode) {
         this.partProdMode = partProdMode;
         return this;
      }

      @JsonProperty("deviceType")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder deviceType(final NameInfo deviceType) {
         this.deviceType = deviceType;
         return this;
      }

      @JsonProperty("deviceName")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder deviceName(final String deviceName) {
         this.deviceName = deviceName;
         return this;
      }

      @JsonProperty("ncSystem")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder ncSystem(final NameInfo ncSystem) {
         this.ncSystem = ncSystem;
         return this;
      }

      @JsonProperty("ncFileFormat")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder ncFileFormat(final NameInfo ncFileFormat) {
         this.ncFileFormat = ncFileFormat;
         return this;
      }

      @JsonProperty("teamStatus")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder teamStatus(final Boolean teamStatus) {
         this.teamStatus = teamStatus;
         return this;
      }

      @JsonProperty("userLinks")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder userLinks(final List<MesBuildingMachinePartTeamUserLinkDTO> userLinks) {
         this.userLinks = userLinks;
         return this;
      }

      @JsonProperty("organizationType")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("machineToolId")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder machineToolId(final Long machineToolId) {
         this.machineToolId = machineToolId;
         return this;
      }

      @JsonProperty("cuttingReportMethod")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder cuttingReportMethod(final Integer cuttingReportMethod) {
         this.cuttingReportMethod = cuttingReportMethod;
         return this;
      }

      @JsonProperty("drillReportMethod")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder drillReportMethod(final Integer drillReportMethod) {
         this.drillReportMethod = drillReportMethod;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("groupsName")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder groupsName(final String groupsName) {
         this.groupsName = groupsName;
         return this;
      }

      @JsonProperty("downConfigId")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder downConfigId(final Long downConfigId) {
         this.downConfigId = downConfigId;
         return this;
      }

      @JsonProperty("drillMethod")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder drillMethod(final Integer drillMethod) {
         this.drillMethod = drillMethod;
         return this;
      }

      @JsonProperty("processType")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      @JsonProperty("productionStatus")
      public MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder productionStatus(final Boolean productionStatus) {
         this.productionStatus = productionStatus;
         return this;
      }

      public MesBuildingMachinePartTeamDTO build() {
         return new MesBuildingMachinePartTeamDTO(
            this.id,
            this.workshop,
            this.productionLine,
            this.process,
            this.MID,
            this.partType,
            this.partFeature,
            this.partFeatureList,
            this.partTypeName,
            this.partProdMode,
            this.deviceType,
            this.deviceName,
            this.ncSystem,
            this.ncFileFormat,
            this.teamStatus,
            this.userLinks,
            this.organizationType,
            this.userId,
            this.machineToolId,
            this.cuttingReportMethod,
            this.drillReportMethod,
            this.groupsId,
            this.groupsName,
            this.downConfigId,
            this.drillMethod,
            this.processType,
            this.productionStatus
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartTeamDTO.MesBuildingMachinePartTeamDTOBuilder(id="
            + this.id
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", process="
            + this.process
            + ", MID="
            + this.MID
            + ", partType="
            + this.partType
            + ", partFeature="
            + this.partFeature
            + ", partFeatureList="
            + this.partFeatureList
            + ", partTypeName="
            + this.partTypeName
            + ", partProdMode="
            + this.partProdMode
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
            + ", machineToolId="
            + this.machineToolId
            + ", cuttingReportMethod="
            + this.cuttingReportMethod
            + ", drillReportMethod="
            + this.drillReportMethod
            + ", groupsId="
            + this.groupsId
            + ", groupsName="
            + this.groupsName
            + ", downConfigId="
            + this.downConfigId
            + ", drillMethod="
            + this.drillMethod
            + ", processType="
            + this.processType
            + ", productionStatus="
            + this.productionStatus
            + ")";
      }
   }
}
