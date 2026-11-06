package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.persistence.Column;

@ApiModel(value = "MesBuildingMachinePartTeamDetailDTO", description = "")
public class MesBuildingMachinePartTeamDetailDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "mesBuildingPartCutConfigWorkShopDTOList", value = "车间-产线-班组", notes = "车间-产线-班组")
   @JsonProperty("mesBuildingPartCutConfigWorkShopDTOList")
   @JSONField(name = "mesBuildingPartCutConfigWorkShopDTOList")
   private List<MesBuildingPartCutConfigWorkShopDTO> mesBuildingPartCutConfigWorkShopDTOList;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "teamId", value = "生产班组id", notes = "生产班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "teamName", value = "班组名称", notes = "班组名称")
   @JsonProperty("teamName")
   @JSONField(name = "teamName")
   private String teamName;
   @ApiModelProperty(name = "partTeamId", value = "零件班组id", notes = "零件班组id")
   private String partTeamId;
   @ApiModelProperty(name = "partType", value = "零件类型[1 板材零件 2 型材零件]", notes = "零件类型[1 板材零件 2 型材零件]")
   private Integer partType;
   @ApiModelProperty(name = "processType", value = "工序类型[1 下料类 2 钻孔类]", notes = "工序类型[1 下料类 2 钻孔类]")
   @TableField("processType")
   @Column(name = "processType", columnDefinition = "int(11)  COMMENT '工序类型[1 下料类 2 钻孔类]'", nullable = false)
   private Integer processType;
   @ApiModelProperty(name = "partProdMode", value = "零件生产方式[1 数控切割 2 半自动切割]", notes = "零件生产方式[1 数控切割 2 半自动切割]")
   @TableField("part_prod_mode")
   @Column(name = "part_prod_mode", columnDefinition = "int(11)  COMMENT '零件生产方式[1 数控切割 2 半自动切割]'", nullable = false)
   private Integer partProdMode;
   @ApiModelProperty(name = "MID", value = "MID", notes = "MID")
   @TableField("MID")
   @Column(name = "MID", columnDefinition = " varchar(255) COMMENT 'MID'")
   private String MID;
   @ApiModelProperty(name = "drillMethod", value = "钻孔方式", notes = "钻孔方式")
   @TableField("drill_method")
   @Column(name = "drill_method", columnDefinition = "int(11)  COMMENT '钻孔方式'")
   private Integer drillMethod;
   @ApiModelProperty(name = "deviceType", value = "切割方式", notes = "切割方式")
   @JsonProperty("deviceType")
   @JSONField(name = "deviceType")
   private Integer deviceType;
   @ApiModelProperty(name = "deviceTypeName", value = "设备id", notes = "设备id")
   @JsonProperty("deviceTypeName")
   @JSONField(name = "deviceTypeName")
   private String deviceTypeName;
   @ApiModelProperty(name = "deviceName", value = "设备名称", notes = "设备名称")
   @TableField("device_name")
   @Column(name = "device_name", columnDefinition = "varchar(255)  COMMENT '设备名称'")
   private String deviceName;
   @ApiModelProperty(name = "ncSystem", value = "数控系统", notes = "数控系统")
   @TableField("nc_system")
   @Column(name = "nc_system", columnDefinition = "int(11)  COMMENT '数控系统'")
   private Integer ncSystem;
   @ApiModelProperty(name = "ncFileFormat", value = "数控文件格式", notes = "数控文件格式")
   @TableField("nc_file_format")
   @Column(name = "nc_file_format", columnDefinition = "int(11)  COMMENT '数控文件格式'")
   private Integer ncFileFormat;
   @ApiModelProperty(name = "cuttingReportMethod", value = "切割报工方式", notes = "切割报工方式")
   @TableField("cutting_report_method")
   @Column(name = "cutting_report_method", columnDefinition = "int(11)  COMMENT '切割报工方式'")
   private Integer cuttingReportMethod;
   @ApiModelProperty(name = "drillReportMethod", value = "钻孔报工方式", notes = "钻孔报工方式")
   private Integer drillReportMethod;
   @ApiModelProperty(name = "teamStatus", value = "班组状态1开启 0关闭", notes = "班组状态1开启 0关闭")
   @JsonProperty("teamStatus")
   @JSONField(name = "teamStatus")
   private Boolean teamStatus;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", value = "车间名称", notes = "车间名称")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;

   public static MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder builder() {
      return new MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder();
   }

   public MesBuildingMachinePartTeamDetailDTO() {
   }

   public MesBuildingMachinePartTeamDetailDTO(
      final Long id,
      final List<MesBuildingPartCutConfigWorkShopDTO> mesBuildingPartCutConfigWorkShopDTOList,
      final Long groupsId,
      final Long productionLineId,
      final Long teamId,
      final String teamName,
      final String partTeamId,
      final Integer partType,
      final Integer processType,
      final Integer partProdMode,
      final String MID,
      final Integer drillMethod,
      final Integer deviceType,
      final String deviceTypeName,
      final String deviceName,
      final Integer ncSystem,
      final Integer ncFileFormat,
      final Integer cuttingReportMethod,
      final Integer drillReportMethod,
      final Boolean teamStatus,
      final Long workshopId,
      final String workshopName
   ) {
      this.id = id;
      this.mesBuildingPartCutConfigWorkShopDTOList = mesBuildingPartCutConfigWorkShopDTOList;
      this.groupsId = groupsId;
      this.productionLineId = productionLineId;
      this.teamId = teamId;
      this.teamName = teamName;
      this.partTeamId = partTeamId;
      this.partType = partType;
      this.processType = processType;
      this.partProdMode = partProdMode;
      this.MID = MID;
      this.drillMethod = drillMethod;
      this.deviceType = deviceType;
      this.deviceTypeName = deviceTypeName;
      this.deviceName = deviceName;
      this.ncSystem = ncSystem;
      this.ncFileFormat = ncFileFormat;
      this.cuttingReportMethod = cuttingReportMethod;
      this.drillReportMethod = drillReportMethod;
      this.teamStatus = teamStatus;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
   }

   public Long getId() {
      return this.id;
   }

   public List<MesBuildingPartCutConfigWorkShopDTO> getMesBuildingPartCutConfigWorkShopDTOList() {
      return this.mesBuildingPartCutConfigWorkShopDTOList;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getPartTeamId() {
      return this.partTeamId;
   }

   public Integer getPartType() {
      return this.partType;
   }

   public Integer getProcessType() {
      return this.processType;
   }

   public Integer getPartProdMode() {
      return this.partProdMode;
   }

   public String getMID() {
      return this.MID;
   }

   public Integer getDrillMethod() {
      return this.drillMethod;
   }

   public Integer getDeviceType() {
      return this.deviceType;
   }

   public String getDeviceTypeName() {
      return this.deviceTypeName;
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

   public Integer getCuttingReportMethod() {
      return this.cuttingReportMethod;
   }

   public Integer getDrillReportMethod() {
      return this.drillReportMethod;
   }

   public Boolean getTeamStatus() {
      return this.teamStatus;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public MesBuildingMachinePartTeamDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("mesBuildingPartCutConfigWorkShopDTOList")
   public MesBuildingMachinePartTeamDetailDTO setMesBuildingPartCutConfigWorkShopDTOList(
      final List<MesBuildingPartCutConfigWorkShopDTO> mesBuildingPartCutConfigWorkShopDTOList
   ) {
      this.mesBuildingPartCutConfigWorkShopDTOList = mesBuildingPartCutConfigWorkShopDTOList;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingMachinePartTeamDetailDTO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingMachinePartTeamDetailDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingMachinePartTeamDetailDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("teamName")
   public MesBuildingMachinePartTeamDetailDTO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   public MesBuildingMachinePartTeamDetailDTO setPartTeamId(final String partTeamId) {
      this.partTeamId = partTeamId;
      return this;
   }

   public MesBuildingMachinePartTeamDetailDTO setPartType(final Integer partType) {
      this.partType = partType;
      return this;
   }

   public MesBuildingMachinePartTeamDetailDTO setProcessType(final Integer processType) {
      this.processType = processType;
      return this;
   }

   public MesBuildingMachinePartTeamDetailDTO setPartProdMode(final Integer partProdMode) {
      this.partProdMode = partProdMode;
      return this;
   }

   public MesBuildingMachinePartTeamDetailDTO setMID(final String MID) {
      this.MID = MID;
      return this;
   }

   public MesBuildingMachinePartTeamDetailDTO setDrillMethod(final Integer drillMethod) {
      this.drillMethod = drillMethod;
      return this;
   }

   @JsonProperty("deviceType")
   public MesBuildingMachinePartTeamDetailDTO setDeviceType(final Integer deviceType) {
      this.deviceType = deviceType;
      return this;
   }

   @JsonProperty("deviceTypeName")
   public MesBuildingMachinePartTeamDetailDTO setDeviceTypeName(final String deviceTypeName) {
      this.deviceTypeName = deviceTypeName;
      return this;
   }

   public MesBuildingMachinePartTeamDetailDTO setDeviceName(final String deviceName) {
      this.deviceName = deviceName;
      return this;
   }

   public MesBuildingMachinePartTeamDetailDTO setNcSystem(final Integer ncSystem) {
      this.ncSystem = ncSystem;
      return this;
   }

   public MesBuildingMachinePartTeamDetailDTO setNcFileFormat(final Integer ncFileFormat) {
      this.ncFileFormat = ncFileFormat;
      return this;
   }

   public MesBuildingMachinePartTeamDetailDTO setCuttingReportMethod(final Integer cuttingReportMethod) {
      this.cuttingReportMethod = cuttingReportMethod;
      return this;
   }

   public MesBuildingMachinePartTeamDetailDTO setDrillReportMethod(final Integer drillReportMethod) {
      this.drillReportMethod = drillReportMethod;
      return this;
   }

   @JsonProperty("teamStatus")
   public MesBuildingMachinePartTeamDetailDTO setTeamStatus(final Boolean teamStatus) {
      this.teamStatus = teamStatus;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingMachinePartTeamDetailDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("workshopName")
   public MesBuildingMachinePartTeamDetailDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartTeamDetailDTO(id="
         + this.getId()
         + ", mesBuildingPartCutConfigWorkShopDTOList="
         + this.getMesBuildingPartCutConfigWorkShopDTOList()
         + ", groupsId="
         + this.getGroupsId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", teamId="
         + this.getTeamId()
         + ", teamName="
         + this.getTeamName()
         + ", partTeamId="
         + this.getPartTeamId()
         + ", partType="
         + this.getPartType()
         + ", processType="
         + this.getProcessType()
         + ", partProdMode="
         + this.getPartProdMode()
         + ", MID="
         + this.getMID()
         + ", drillMethod="
         + this.getDrillMethod()
         + ", deviceType="
         + this.getDeviceType()
         + ", deviceTypeName="
         + this.getDeviceTypeName()
         + ", deviceName="
         + this.getDeviceName()
         + ", ncSystem="
         + this.getNcSystem()
         + ", ncFileFormat="
         + this.getNcFileFormat()
         + ", cuttingReportMethod="
         + this.getCuttingReportMethod()
         + ", drillReportMethod="
         + this.getDrillReportMethod()
         + ", teamStatus="
         + this.getTeamStatus()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartTeamDetailDTO)) {
         return false;
      }

      MesBuildingMachinePartTeamDetailDTO other = (MesBuildingMachinePartTeamDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$groupsId = this.getGroupsId();
         Object other$groupsId = other.getGroupsId();
         if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
            Object this$productionLineId = this.getProductionLineId();
            Object other$productionLineId = other.getProductionLineId();
            if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$partType = this.getPartType();
                  Object other$partType = other.getPartType();
                  if (this$partType == null ? other$partType == null : this$partType.equals(other$partType)) {
                     Object this$processType = this.getProcessType();
                     Object other$processType = other.getProcessType();
                     if (this$processType == null ? other$processType == null : this$processType.equals(other$processType)) {
                        Object this$partProdMode = this.getPartProdMode();
                        Object other$partProdMode = other.getPartProdMode();
                        if (this$partProdMode == null ? other$partProdMode == null : this$partProdMode.equals(other$partProdMode)) {
                           Object this$drillMethod = this.getDrillMethod();
                           Object other$drillMethod = other.getDrillMethod();
                           if (this$drillMethod == null ? other$drillMethod == null : this$drillMethod.equals(other$drillMethod)) {
                              Object this$deviceType = this.getDeviceType();
                              Object other$deviceType = other.getDeviceType();
                              if (this$deviceType == null ? other$deviceType == null : this$deviceType.equals(other$deviceType)) {
                                 Object this$ncSystem = this.getNcSystem();
                                 Object other$ncSystem = other.getNcSystem();
                                 if (this$ncSystem == null ? other$ncSystem == null : this$ncSystem.equals(other$ncSystem)) {
                                    Object this$ncFileFormat = this.getNcFileFormat();
                                    Object other$ncFileFormat = other.getNcFileFormat();
                                    if (this$ncFileFormat == null ? other$ncFileFormat == null : this$ncFileFormat.equals(other$ncFileFormat)) {
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
                                             Object this$teamStatus = this.getTeamStatus();
                                             Object other$teamStatus = other.getTeamStatus();
                                             if (this$teamStatus == null ? other$teamStatus == null : this$teamStatus.equals(other$teamStatus)) {
                                                Object this$workshopId = this.getWorkshopId();
                                                Object other$workshopId = other.getWorkshopId();
                                                if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                   Object this$mesBuildingPartCutConfigWorkShopDTOList = this.getMesBuildingPartCutConfigWorkShopDTOList();
                                                   Object other$mesBuildingPartCutConfigWorkShopDTOList = other.getMesBuildingPartCutConfigWorkShopDTOList();
                                                   if (this$mesBuildingPartCutConfigWorkShopDTOList == null
                                                      ? other$mesBuildingPartCutConfigWorkShopDTOList == null
                                                      : this$mesBuildingPartCutConfigWorkShopDTOList.equals(other$mesBuildingPartCutConfigWorkShopDTOList)) {
                                                      Object this$teamName = this.getTeamName();
                                                      Object other$teamName = other.getTeamName();
                                                      if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
                                                         Object this$partTeamId = this.getPartTeamId();
                                                         Object other$partTeamId = other.getPartTeamId();
                                                         if (this$partTeamId == null ? other$partTeamId == null : this$partTeamId.equals(other$partTeamId)) {
                                                            Object this$MID = this.getMID();
                                                            Object other$MID = other.getMID();
                                                            if (this$MID == null ? other$MID == null : this$MID.equals(other$MID)) {
                                                               Object this$deviceTypeName = this.getDeviceTypeName();
                                                               Object other$deviceTypeName = other.getDeviceTypeName();
                                                               if (this$deviceTypeName == null
                                                                  ? other$deviceTypeName == null
                                                                  : this$deviceTypeName.equals(other$deviceTypeName)) {
                                                                  Object this$deviceName = this.getDeviceName();
                                                                  Object other$deviceName = other.getDeviceName();
                                                                  if (this$deviceName == null
                                                                     ? other$deviceName == null
                                                                     : this$deviceName.equals(other$deviceName)) {
                                                                     Object this$workshopName = this.getWorkshopName();
                                                                     Object other$workshopName = other.getWorkshopName();
                                                                     return this$workshopName == null
                                                                        ? other$workshopName == null
                                                                        : this$workshopName.equals(other$workshopName);
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
      return other instanceof MesBuildingMachinePartTeamDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $partType = this.getPartType();
      result = result * 59 + ($partType == null ? 43 : $partType.hashCode());
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $partProdMode = this.getPartProdMode();
      result = result * 59 + ($partProdMode == null ? 43 : $partProdMode.hashCode());
      Object $drillMethod = this.getDrillMethod();
      result = result * 59 + ($drillMethod == null ? 43 : $drillMethod.hashCode());
      Object $deviceType = this.getDeviceType();
      result = result * 59 + ($deviceType == null ? 43 : $deviceType.hashCode());
      Object $ncSystem = this.getNcSystem();
      result = result * 59 + ($ncSystem == null ? 43 : $ncSystem.hashCode());
      Object $ncFileFormat = this.getNcFileFormat();
      result = result * 59 + ($ncFileFormat == null ? 43 : $ncFileFormat.hashCode());
      Object $cuttingReportMethod = this.getCuttingReportMethod();
      result = result * 59 + ($cuttingReportMethod == null ? 43 : $cuttingReportMethod.hashCode());
      Object $drillReportMethod = this.getDrillReportMethod();
      result = result * 59 + ($drillReportMethod == null ? 43 : $drillReportMethod.hashCode());
      Object $teamStatus = this.getTeamStatus();
      result = result * 59 + ($teamStatus == null ? 43 : $teamStatus.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $mesBuildingPartCutConfigWorkShopDTOList = this.getMesBuildingPartCutConfigWorkShopDTOList();
      result = result * 59 + ($mesBuildingPartCutConfigWorkShopDTOList == null ? 43 : $mesBuildingPartCutConfigWorkShopDTOList.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $partTeamId = this.getPartTeamId();
      result = result * 59 + ($partTeamId == null ? 43 : $partTeamId.hashCode());
      Object $MID = this.getMID();
      result = result * 59 + ($MID == null ? 43 : $MID.hashCode());
      Object $deviceTypeName = this.getDeviceTypeName();
      result = result * 59 + ($deviceTypeName == null ? 43 : $deviceTypeName.hashCode());
      Object $deviceName = this.getDeviceName();
      result = result * 59 + ($deviceName == null ? 43 : $deviceName.hashCode());
      Object $workshopName = this.getWorkshopName();
      return result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
   }

   public static class MesBuildingMachinePartTeamDetailDTOBuilder {
      private Long id;
      private List<MesBuildingPartCutConfigWorkShopDTO> mesBuildingPartCutConfigWorkShopDTOList;
      private Long groupsId;
      private Long productionLineId;
      private Long teamId;
      private String teamName;
      private String partTeamId;
      private Integer partType;
      private Integer processType;
      private Integer partProdMode;
      private String MID;
      private Integer drillMethod;
      private Integer deviceType;
      private String deviceTypeName;
      private String deviceName;
      private Integer ncSystem;
      private Integer ncFileFormat;
      private Integer cuttingReportMethod;
      private Integer drillReportMethod;
      private Boolean teamStatus;
      private Long workshopId;
      private String workshopName;

      MesBuildingMachinePartTeamDetailDTOBuilder() {
      }

      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("mesBuildingPartCutConfigWorkShopDTOList")
      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder mesBuildingPartCutConfigWorkShopDTOList(
         final List<MesBuildingPartCutConfigWorkShopDTO> mesBuildingPartCutConfigWorkShopDTOList
      ) {
         this.mesBuildingPartCutConfigWorkShopDTOList = mesBuildingPartCutConfigWorkShopDTOList;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("teamName")
      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder partTeamId(final String partTeamId) {
         this.partTeamId = partTeamId;
         return this;
      }

      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder partType(final Integer partType) {
         this.partType = partType;
         return this;
      }

      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder partProdMode(final Integer partProdMode) {
         this.partProdMode = partProdMode;
         return this;
      }

      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder MID(final String MID) {
         this.MID = MID;
         return this;
      }

      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder drillMethod(final Integer drillMethod) {
         this.drillMethod = drillMethod;
         return this;
      }

      @JsonProperty("deviceType")
      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder deviceType(final Integer deviceType) {
         this.deviceType = deviceType;
         return this;
      }

      @JsonProperty("deviceTypeName")
      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder deviceTypeName(final String deviceTypeName) {
         this.deviceTypeName = deviceTypeName;
         return this;
      }

      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder deviceName(final String deviceName) {
         this.deviceName = deviceName;
         return this;
      }

      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder ncSystem(final Integer ncSystem) {
         this.ncSystem = ncSystem;
         return this;
      }

      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder ncFileFormat(final Integer ncFileFormat) {
         this.ncFileFormat = ncFileFormat;
         return this;
      }

      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder cuttingReportMethod(final Integer cuttingReportMethod) {
         this.cuttingReportMethod = cuttingReportMethod;
         return this;
      }

      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder drillReportMethod(final Integer drillReportMethod) {
         this.drillReportMethod = drillReportMethod;
         return this;
      }

      @JsonProperty("teamStatus")
      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder teamStatus(final Boolean teamStatus) {
         this.teamStatus = teamStatus;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("workshopName")
      public MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public MesBuildingMachinePartTeamDetailDTO build() {
         return new MesBuildingMachinePartTeamDetailDTO(
            this.id,
            this.mesBuildingPartCutConfigWorkShopDTOList,
            this.groupsId,
            this.productionLineId,
            this.teamId,
            this.teamName,
            this.partTeamId,
            this.partType,
            this.processType,
            this.partProdMode,
            this.MID,
            this.drillMethod,
            this.deviceType,
            this.deviceTypeName,
            this.deviceName,
            this.ncSystem,
            this.ncFileFormat,
            this.cuttingReportMethod,
            this.drillReportMethod,
            this.teamStatus,
            this.workshopId,
            this.workshopName
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartTeamDetailDTO.MesBuildingMachinePartTeamDetailDTOBuilder(id="
            + this.id
            + ", mesBuildingPartCutConfigWorkShopDTOList="
            + this.mesBuildingPartCutConfigWorkShopDTOList
            + ", groupsId="
            + this.groupsId
            + ", productionLineId="
            + this.productionLineId
            + ", teamId="
            + this.teamId
            + ", teamName="
            + this.teamName
            + ", partTeamId="
            + this.partTeamId
            + ", partType="
            + this.partType
            + ", processType="
            + this.processType
            + ", partProdMode="
            + this.partProdMode
            + ", MID="
            + this.MID
            + ", drillMethod="
            + this.drillMethod
            + ", deviceType="
            + this.deviceType
            + ", deviceTypeName="
            + this.deviceTypeName
            + ", deviceName="
            + this.deviceName
            + ", ncSystem="
            + this.ncSystem
            + ", ncFileFormat="
            + this.ncFileFormat
            + ", cuttingReportMethod="
            + this.cuttingReportMethod
            + ", drillReportMethod="
            + this.drillReportMethod
            + ", teamStatus="
            + this.teamStatus
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ")";
      }
   }
}
