package com.hzchum.scim.mes.building.core.api.pojo._doModel.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingMachinePartTeamDetail对象", description = "")
@Entity
@TableName("mes_building_machine_part_team_detail")
@Table(name = "mes_building_machine_part_team_detail")
@org.hibernate.annotations.Table(appliesTo = "mes_building_machine_part_team_detail")
public class MesBuildingMachinePartTeamDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'")
   private Long productionLineId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20)  COMMENT '生产组id'", nullable = false)
   private Long groupsId;
   @ApiModelProperty(name = "teamId", value = "生产班组id", notes = "生产班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "varchar(255) COMMENT '生产班组id'", nullable = true)
   private String teamId;
   @ApiModelProperty(name = "partTeamId", value = "零件班组id", notes = "零件班组id")
   @TableField("part_team_id")
   @Column(name = "part_team_id", columnDefinition = "varchar(255) COMMENT '零件班组id'", nullable = true)
   private String partTeamId;
   @ApiModelProperty(name = "partType", value = "零件类型[8 板材零件 4 型材零件]", notes = "零件类型[8 板材零件 4 型材零件]")
   @TableField("part_type")
   @Column(name = "part_type", columnDefinition = "int(11)  COMMENT '零件类型[8 板材零件 4 型材零件]'", nullable = false)
   private Integer partType;
   @ApiModelProperty(name = "partFeature", value = "零件特征", notes = "零件特征")
   @TableField("part_feature")
   @Column(name = "part_feature", columnDefinition = "varchar(500)  COMMENT '零件特征'", nullable = true)
   private String partFeature;
   @ApiModelProperty(name = "processType", value = "工序类型[4 下料类 8 钻孔类]", notes = "工序类型[4 下料类 8 钻孔类]")
   @TableField("process_type")
   @Column(name = "process_type", columnDefinition = "int(11)  COMMENT '工序类型[4 下料类 8 钻孔类]'", nullable = false)
   private Integer processType;
   @ApiModelProperty(name = "partProdMode", value = "零件生产方式[1 数控切割 2 半自动切割]", notes = "零件生产方式[1 数控切割 2 半自动切割]")
   @TableField("part_prod_mode")
   @Column(name = "part_prod_mode", columnDefinition = "int(11)  COMMENT '零件生产方式[1 数控切割 2 半自动切割]'", nullable = false)
   private Integer partProdMode;
   @ApiModelProperty(name = "MID", value = "MID", notes = "MID")
   @TableField("MID")
   @Column(name = "MID", columnDefinition = "varchar(255) COMMENT 'MID'")
   private String MID;
   @ApiModelProperty(name = "drillMethod", value = "钻孔方式", notes = "钻孔方式")
   @TableField("drill_method")
   @Column(name = "drill_method", columnDefinition = "int(11)  COMMENT '钻孔方式'")
   private Integer drillMethod;
   @ApiModelProperty(name = "deviceType", value = "切割方式", notes = "切割方式")
   @TableField("device_type")
   @Column(name = "device_type", columnDefinition = "int(11)  COMMENT '切割方式'")
   private Integer deviceType;
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
   @TableField("drill_report_method")
   @Column(name = "drill_report_method", columnDefinition = "int(11)  COMMENT '钻孔报工方式'")
   private Integer drillReportMethod;
   @ApiModelProperty(name = "teamStatus", value = "班组状态1开启 0关闭", notes = "班组状态1开启 0关闭")
   @JsonProperty("teamStatus")
   @JSONField(name = "teamStatus")
   @TableField("team_status")
   @Column(name = "team_status", columnDefinition = "tinyint(1) default '1' COMMENT '班组状态1开启 0关闭'", nullable = false)
   private Boolean teamStatus;

   public static MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder builder() {
      return new MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder();
   }

   public MesBuildingMachinePartTeamDetail() {
   }

   public MesBuildingMachinePartTeamDetail(
      final Long id,
      final Long productionLineId,
      final Long groupsId,
      final String teamId,
      final String partTeamId,
      final Integer partType,
      final String partFeature,
      final Integer processType,
      final Integer partProdMode,
      final String MID,
      final Integer drillMethod,
      final Integer deviceType,
      final String deviceName,
      final Integer ncSystem,
      final Integer ncFileFormat,
      final Integer cuttingReportMethod,
      final Integer drillReportMethod,
      final Boolean teamStatus
   ) {
      this.id = id;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.teamId = teamId;
      this.partTeamId = partTeamId;
      this.partType = partType;
      this.partFeature = partFeature;
      this.processType = processType;
      this.partProdMode = partProdMode;
      this.MID = MID;
      this.drillMethod = drillMethod;
      this.deviceType = deviceType;
      this.deviceName = deviceName;
      this.ncSystem = ncSystem;
      this.ncFileFormat = ncFileFormat;
      this.cuttingReportMethod = cuttingReportMethod;
      this.drillReportMethod = drillReportMethod;
      this.teamStatus = teamStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public String getTeamId() {
      return this.teamId;
   }

   public String getPartTeamId() {
      return this.partTeamId;
   }

   public Integer getPartType() {
      return this.partType;
   }

   public String getPartFeature() {
      return this.partFeature;
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

   public MesBuildingMachinePartTeamDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingMachinePartTeamDetail setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingMachinePartTeamDetail setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingMachinePartTeamDetail setTeamId(final String teamId) {
      this.teamId = teamId;
      return this;
   }

   public MesBuildingMachinePartTeamDetail setPartTeamId(final String partTeamId) {
      this.partTeamId = partTeamId;
      return this;
   }

   public MesBuildingMachinePartTeamDetail setPartType(final Integer partType) {
      this.partType = partType;
      return this;
   }

   public MesBuildingMachinePartTeamDetail setPartFeature(final String partFeature) {
      this.partFeature = partFeature;
      return this;
   }

   public MesBuildingMachinePartTeamDetail setProcessType(final Integer processType) {
      this.processType = processType;
      return this;
   }

   public MesBuildingMachinePartTeamDetail setPartProdMode(final Integer partProdMode) {
      this.partProdMode = partProdMode;
      return this;
   }

   public MesBuildingMachinePartTeamDetail setMID(final String MID) {
      this.MID = MID;
      return this;
   }

   public MesBuildingMachinePartTeamDetail setDrillMethod(final Integer drillMethod) {
      this.drillMethod = drillMethod;
      return this;
   }

   public MesBuildingMachinePartTeamDetail setDeviceType(final Integer deviceType) {
      this.deviceType = deviceType;
      return this;
   }

   public MesBuildingMachinePartTeamDetail setDeviceName(final String deviceName) {
      this.deviceName = deviceName;
      return this;
   }

   public MesBuildingMachinePartTeamDetail setNcSystem(final Integer ncSystem) {
      this.ncSystem = ncSystem;
      return this;
   }

   public MesBuildingMachinePartTeamDetail setNcFileFormat(final Integer ncFileFormat) {
      this.ncFileFormat = ncFileFormat;
      return this;
   }

   public MesBuildingMachinePartTeamDetail setCuttingReportMethod(final Integer cuttingReportMethod) {
      this.cuttingReportMethod = cuttingReportMethod;
      return this;
   }

   public MesBuildingMachinePartTeamDetail setDrillReportMethod(final Integer drillReportMethod) {
      this.drillReportMethod = drillReportMethod;
      return this;
   }

   @JsonProperty("teamStatus")
   public MesBuildingMachinePartTeamDetail setTeamStatus(final Boolean teamStatus) {
      this.teamStatus = teamStatus;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartTeamDetail(id="
         + this.getId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", teamId="
         + this.getTeamId()
         + ", partTeamId="
         + this.getPartTeamId()
         + ", partType="
         + this.getPartType()
         + ", partFeature="
         + this.getPartFeature()
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartTeamDetail)) {
         return false;
      }

      MesBuildingMachinePartTeamDetail other = (MesBuildingMachinePartTeamDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$groupsId = this.getGroupsId();
            Object other$groupsId = other.getGroupsId();
            if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
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
                                             Object this$teamId = this.getTeamId();
                                             Object other$teamId = other.getTeamId();
                                             if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                                Object this$partTeamId = this.getPartTeamId();
                                                Object other$partTeamId = other.getPartTeamId();
                                                if (this$partTeamId == null ? other$partTeamId == null : this$partTeamId.equals(other$partTeamId)) {
                                                   Object this$partFeature = this.getPartFeature();
                                                   Object other$partFeature = other.getPartFeature();
                                                   if (this$partFeature == null ? other$partFeature == null : this$partFeature.equals(other$partFeature)) {
                                                      Object this$MID = this.getMID();
                                                      Object other$MID = other.getMID();
                                                      if (this$MID == null ? other$MID == null : this$MID.equals(other$MID)) {
                                                         Object this$deviceName = this.getDeviceName();
                                                         Object other$deviceName = other.getDeviceName();
                                                         return this$deviceName == null ? other$deviceName == null : this$deviceName.equals(other$deviceName);
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
      return other instanceof MesBuildingMachinePartTeamDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
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
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $partTeamId = this.getPartTeamId();
      result = result * 59 + ($partTeamId == null ? 43 : $partTeamId.hashCode());
      Object $partFeature = this.getPartFeature();
      result = result * 59 + ($partFeature == null ? 43 : $partFeature.hashCode());
      Object $MID = this.getMID();
      result = result * 59 + ($MID == null ? 43 : $MID.hashCode());
      Object $deviceName = this.getDeviceName();
      return result * 59 + ($deviceName == null ? 43 : $deviceName.hashCode());
   }

   public static class MesBuildingMachinePartTeamDetailBuilder {
      private Long id;
      private Long productionLineId;
      private Long groupsId;
      private String teamId;
      private String partTeamId;
      private Integer partType;
      private String partFeature;
      private Integer processType;
      private Integer partProdMode;
      private String MID;
      private Integer drillMethod;
      private Integer deviceType;
      private String deviceName;
      private Integer ncSystem;
      private Integer ncFileFormat;
      private Integer cuttingReportMethod;
      private Integer drillReportMethod;
      private Boolean teamStatus;

      MesBuildingMachinePartTeamDetailBuilder() {
      }

      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder teamId(final String teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder partTeamId(final String partTeamId) {
         this.partTeamId = partTeamId;
         return this;
      }

      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder partType(final Integer partType) {
         this.partType = partType;
         return this;
      }

      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder partFeature(final String partFeature) {
         this.partFeature = partFeature;
         return this;
      }

      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder partProdMode(final Integer partProdMode) {
         this.partProdMode = partProdMode;
         return this;
      }

      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder MID(final String MID) {
         this.MID = MID;
         return this;
      }

      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder drillMethod(final Integer drillMethod) {
         this.drillMethod = drillMethod;
         return this;
      }

      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder deviceType(final Integer deviceType) {
         this.deviceType = deviceType;
         return this;
      }

      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder deviceName(final String deviceName) {
         this.deviceName = deviceName;
         return this;
      }

      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder ncSystem(final Integer ncSystem) {
         this.ncSystem = ncSystem;
         return this;
      }

      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder ncFileFormat(final Integer ncFileFormat) {
         this.ncFileFormat = ncFileFormat;
         return this;
      }

      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder cuttingReportMethod(final Integer cuttingReportMethod) {
         this.cuttingReportMethod = cuttingReportMethod;
         return this;
      }

      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder drillReportMethod(final Integer drillReportMethod) {
         this.drillReportMethod = drillReportMethod;
         return this;
      }

      @JsonProperty("teamStatus")
      public MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder teamStatus(final Boolean teamStatus) {
         this.teamStatus = teamStatus;
         return this;
      }

      public MesBuildingMachinePartTeamDetail build() {
         return new MesBuildingMachinePartTeamDetail(
            this.id,
            this.productionLineId,
            this.groupsId,
            this.teamId,
            this.partTeamId,
            this.partType,
            this.partFeature,
            this.processType,
            this.partProdMode,
            this.MID,
            this.drillMethod,
            this.deviceType,
            this.deviceName,
            this.ncSystem,
            this.ncFileFormat,
            this.cuttingReportMethod,
            this.drillReportMethod,
            this.teamStatus
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartTeamDetail.MesBuildingMachinePartTeamDetailBuilder(id="
            + this.id
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", teamId="
            + this.teamId
            + ", partTeamId="
            + this.partTeamId
            + ", partType="
            + this.partType
            + ", partFeature="
            + this.partFeature
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
            + ")";
      }
   }
}
