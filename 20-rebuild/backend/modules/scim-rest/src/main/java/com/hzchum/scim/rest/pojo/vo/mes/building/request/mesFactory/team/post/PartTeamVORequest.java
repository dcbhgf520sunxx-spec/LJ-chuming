package com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.team.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingMachinePartTeamUserLinkDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "PartTeamVORequest", description = "")
public class PartTeamVORequest {
   @ApiModelProperty(name = "id", notes = "id")
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
   @NotNull(message = "生产线id不能为空")
   private Long productionLineId;
   @ApiModelProperty(name = "groupsId", value = "零件班组id", notes = "零件班组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "teamId", value = "生产班组id", notes = "生产班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private List<String> teamId;
   @ApiModelProperty("零件类型[1 板材零件 2 型材零件]")
   @JsonProperty("partType")
   @JSONField(name = "partType")
   @NotNull(message = "零件类型不能为空")
   private Integer partType;
   @ApiModelProperty(name = "partFeature", value = "零件特征", notes = "零件特征")
   @JsonProperty("partFeature")
   @JSONField(name = "partFeature")
   private List<Long> partFeature;
   @JsonProperty("partProdMode")
   @JSONField(name = "partProdMode")
   @NotNull(message = "零件生产方式不能为空")
   private Integer partProdMode;
   @ApiModelProperty(name = "MID", value = "MID", notes = "MID")
   @JsonProperty("MID")
   @JSONField(name = "MID")
   private String MID;
   @ApiModelProperty(name = "deviceType", value = "切割方式", notes = "切割方式")
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
   @ApiModelProperty(name = "cuttingReportMethod", value = "切割报工方式", notes = "切割报工方式")
   @JsonProperty("cuttingReportMethod")
   @JSONField(name = "cuttingReportMethod")
   private Integer cuttingReportMethod;
   @ApiModelProperty(name = "drillReportMethod", value = "钻孔报工方式", notes = "钻孔报工方式")
   @JsonProperty("drillReportMethod")
   @JSONField(name = "drillReportMethod")
   private Integer drillReportMethod;
   @ApiModelProperty(name = "processType", value = "工序类型[1 下料类 2 钻孔类]", notes = "工序类型[1 下料类 2 钻孔类]")
   @JsonProperty("processType")
   @JSONField(name = "processType")
   private Integer processType;
   @ApiModelProperty(name = "drillMethod", value = "钻孔方式", notes = "钻孔方式")
   @JsonProperty("drillMethod")
   @JSONField(name = "drillMethod")
   private Integer drillMethod;

   public static PartTeamVORequest.PartTeamVORequestBuilder builder() {
      return new PartTeamVORequest.PartTeamVORequestBuilder();
   }

   public PartTeamVORequest() {
   }

   public PartTeamVORequest(
      final Long id,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final List<String> teamId,
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
      final Integer cuttingReportMethod,
      final Integer drillReportMethod,
      final Integer processType,
      final Integer drillMethod
   ) {
      this.id = id;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.teamId = teamId;
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
      this.cuttingReportMethod = cuttingReportMethod;
      this.drillReportMethod = drillReportMethod;
      this.processType = processType;
      this.drillMethod = drillMethod;
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

   @JsonProperty("id")
   public PartTeamVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("workshopId")
   public PartTeamVORequest setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public PartTeamVORequest setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public PartTeamVORequest setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("teamId")
   public PartTeamVORequest setTeamId(final List<String> teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("partType")
   public PartTeamVORequest setPartType(final Integer partType) {
      this.partType = partType;
      return this;
   }

   @JsonProperty("partFeature")
   public PartTeamVORequest setPartFeature(final List<Long> partFeature) {
      this.partFeature = partFeature;
      return this;
   }

   @JsonProperty("partProdMode")
   public PartTeamVORequest setPartProdMode(final Integer partProdMode) {
      this.partProdMode = partProdMode;
      return this;
   }

   @JsonProperty("MID")
   public PartTeamVORequest setMID(final String MID) {
      this.MID = MID;
      return this;
   }

   @JsonProperty("deviceType")
   public PartTeamVORequest setDeviceType(final Integer deviceType) {
      this.deviceType = deviceType;
      return this;
   }

   @JsonProperty("deviceName")
   public PartTeamVORequest setDeviceName(final String deviceName) {
      this.deviceName = deviceName;
      return this;
   }

   @JsonProperty("ncSystem")
   public PartTeamVORequest setNcSystem(final Integer ncSystem) {
      this.ncSystem = ncSystem;
      return this;
   }

   @JsonProperty("ncFileFormat")
   public PartTeamVORequest setNcFileFormat(final Integer ncFileFormat) {
      this.ncFileFormat = ncFileFormat;
      return this;
   }

   @JsonProperty("teamStatus")
   public PartTeamVORequest setTeamStatus(final Boolean teamStatus) {
      this.teamStatus = teamStatus;
      return this;
   }

   @JsonProperty("userLinks")
   public PartTeamVORequest setUserLinks(final List<MesBuildingMachinePartTeamUserLinkDTO> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @JsonProperty("organizationType")
   public PartTeamVORequest setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("cuttingReportMethod")
   public PartTeamVORequest setCuttingReportMethod(final Integer cuttingReportMethod) {
      this.cuttingReportMethod = cuttingReportMethod;
      return this;
   }

   @JsonProperty("drillReportMethod")
   public PartTeamVORequest setDrillReportMethod(final Integer drillReportMethod) {
      this.drillReportMethod = drillReportMethod;
      return this;
   }

   @JsonProperty("processType")
   public PartTeamVORequest setProcessType(final Integer processType) {
      this.processType = processType;
      return this;
   }

   @JsonProperty("drillMethod")
   public PartTeamVORequest setDrillMethod(final Integer drillMethod) {
      this.drillMethod = drillMethod;
      return this;
   }

   @Override
   public String toString() {
      return "PartTeamVORequest(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", teamId="
         + this.getTeamId()
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
         + ", cuttingReportMethod="
         + this.getCuttingReportMethod()
         + ", drillReportMethod="
         + this.getDrillReportMethod()
         + ", processType="
         + this.getProcessType()
         + ", drillMethod="
         + this.getDrillMethod()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PartTeamVORequest)) {
         return false;
      }

      PartTeamVORequest other = (PartTeamVORequest)o;
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
                                    if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
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
                                                   Object this$teamId = this.getTeamId();
                                                   Object other$teamId = other.getTeamId();
                                                   if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                                      Object this$partFeature = this.getPartFeature();
                                                      Object other$partFeature = other.getPartFeature();
                                                      if (this$partFeature == null ? other$partFeature == null : this$partFeature.equals(other$partFeature)) {
                                                         Object this$MID = this.getMID();
                                                         Object other$MID = other.getMID();
                                                         if (this$MID == null ? other$MID == null : this$MID.equals(other$MID)) {
                                                            Object this$deviceName = this.getDeviceName();
                                                            Object other$deviceName = other.getDeviceName();
                                                            if (this$deviceName == null ? other$deviceName == null : this$deviceName.equals(other$deviceName)) {
                                                               Object this$userLinks = this.getUserLinks();
                                                               Object other$userLinks = other.getUserLinks();
                                                               return this$userLinks == null ? other$userLinks == null : this$userLinks.equals(other$userLinks);
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
      return other instanceof PartTeamVORequest;
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
      Object $cuttingReportMethod = this.getCuttingReportMethod();
      result = result * 59 + ($cuttingReportMethod == null ? 43 : $cuttingReportMethod.hashCode());
      Object $drillReportMethod = this.getDrillReportMethod();
      result = result * 59 + ($drillReportMethod == null ? 43 : $drillReportMethod.hashCode());
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $drillMethod = this.getDrillMethod();
      result = result * 59 + ($drillMethod == null ? 43 : $drillMethod.hashCode());
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

   public static class PartTeamVORequestBuilder {
      private Long id;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private List<String> teamId;
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
      private Integer cuttingReportMethod;
      private Integer drillReportMethod;
      private Integer processType;
      private Integer drillMethod;

      PartTeamVORequestBuilder() {
      }

      @JsonProperty("id")
      public PartTeamVORequest.PartTeamVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("workshopId")
      public PartTeamVORequest.PartTeamVORequestBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public PartTeamVORequest.PartTeamVORequestBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public PartTeamVORequest.PartTeamVORequestBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("teamId")
      public PartTeamVORequest.PartTeamVORequestBuilder teamId(final List<String> teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("partType")
      public PartTeamVORequest.PartTeamVORequestBuilder partType(final Integer partType) {
         this.partType = partType;
         return this;
      }

      @JsonProperty("partFeature")
      public PartTeamVORequest.PartTeamVORequestBuilder partFeature(final List<Long> partFeature) {
         this.partFeature = partFeature;
         return this;
      }

      @JsonProperty("partProdMode")
      public PartTeamVORequest.PartTeamVORequestBuilder partProdMode(final Integer partProdMode) {
         this.partProdMode = partProdMode;
         return this;
      }

      @JsonProperty("MID")
      public PartTeamVORequest.PartTeamVORequestBuilder MID(final String MID) {
         this.MID = MID;
         return this;
      }

      @JsonProperty("deviceType")
      public PartTeamVORequest.PartTeamVORequestBuilder deviceType(final Integer deviceType) {
         this.deviceType = deviceType;
         return this;
      }

      @JsonProperty("deviceName")
      public PartTeamVORequest.PartTeamVORequestBuilder deviceName(final String deviceName) {
         this.deviceName = deviceName;
         return this;
      }

      @JsonProperty("ncSystem")
      public PartTeamVORequest.PartTeamVORequestBuilder ncSystem(final Integer ncSystem) {
         this.ncSystem = ncSystem;
         return this;
      }

      @JsonProperty("ncFileFormat")
      public PartTeamVORequest.PartTeamVORequestBuilder ncFileFormat(final Integer ncFileFormat) {
         this.ncFileFormat = ncFileFormat;
         return this;
      }

      @JsonProperty("teamStatus")
      public PartTeamVORequest.PartTeamVORequestBuilder teamStatus(final Boolean teamStatus) {
         this.teamStatus = teamStatus;
         return this;
      }

      @JsonProperty("userLinks")
      public PartTeamVORequest.PartTeamVORequestBuilder userLinks(final List<MesBuildingMachinePartTeamUserLinkDTO> userLinks) {
         this.userLinks = userLinks;
         return this;
      }

      @JsonProperty("organizationType")
      public PartTeamVORequest.PartTeamVORequestBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("cuttingReportMethod")
      public PartTeamVORequest.PartTeamVORequestBuilder cuttingReportMethod(final Integer cuttingReportMethod) {
         this.cuttingReportMethod = cuttingReportMethod;
         return this;
      }

      @JsonProperty("drillReportMethod")
      public PartTeamVORequest.PartTeamVORequestBuilder drillReportMethod(final Integer drillReportMethod) {
         this.drillReportMethod = drillReportMethod;
         return this;
      }

      @JsonProperty("processType")
      public PartTeamVORequest.PartTeamVORequestBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      @JsonProperty("drillMethod")
      public PartTeamVORequest.PartTeamVORequestBuilder drillMethod(final Integer drillMethod) {
         this.drillMethod = drillMethod;
         return this;
      }

      public PartTeamVORequest build() {
         return new PartTeamVORequest(
            this.id,
            this.workshopId,
            this.productionLineId,
            this.groupsId,
            this.teamId,
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
            this.cuttingReportMethod,
            this.drillReportMethod,
            this.processType,
            this.drillMethod
         );
      }

      @Override
      public String toString() {
         return "PartTeamVORequest.PartTeamVORequestBuilder(id="
            + this.id
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", teamId="
            + this.teamId
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
            + ", cuttingReportMethod="
            + this.cuttingReportMethod
            + ", drillReportMethod="
            + this.drillReportMethod
            + ", processType="
            + this.processType
            + ", drillMethod="
            + this.drillMethod
            + ")";
      }
   }
}
