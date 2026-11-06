package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@ApiModel(value = "MesBuildingMachinePartSchedulingDTOParam", description = "零件排产信息")
public class MesBuildingMachinePartSchedulingDTOParam {
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "thick", value = "厚")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   private String thick;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "linkList", value = "关联产品", notes = "关联产品")
   @JsonProperty("linkList")
   @JSONField(name = "linkList")
   @Length(min = 1, message = "不能为空")
   private List<MesBuildingMachinePartSchedulingLinkDTOParam> linkList;
   @ApiModelProperty(name = "batchOutboundDTOParam", value = "出库信息", notes = "出库信息")
   @JsonProperty("batchOutboundDTOParam")
   @JSONField(name = "batchOutboundDTOParam")
   private BatchSchedulingOutboundDTOParam batchOutboundDTOParam;
   @ApiModelProperty(name = "cutConfigId", value = "切割配置id", notes = "切割配置id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   private Long cutConfigId;
   @ApiModelProperty(name = "saveType", value = "保存类型 1不套料下发，2套料下发，4追加新工单", notes = "保存类型 1不套料下发，2套料下发，4追加新工单")
   @JsonProperty("saveType")
   @JSONField(name = "saveType")
   @NotNull(message = "保存类型不能为空")
   private Integer saveType;
   @ApiModelProperty(name = "schedulingId", value = "追加的排产id", notes = "追加的排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   private Long schedulingId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "drillProductionLineId", value = "钻孔产线id", notes = "钻孔产线id")
   @JsonProperty("drillProductionLineId")
   @JSONField(name = "drillProductionLineId")
   private Long drillProductionLineId;
   @ApiModelProperty(name = "drillCutConfigId", value = "钻孔产线id", notes = "钻孔产线id")
   @JsonProperty("drillCutConfigId")
   @JSONField(name = "drillCutConfigId")
   private Long drillCutConfigId;
   @ApiModelProperty(name = "drillProcessId", value = "钻孔工序id", notes = "钻孔工序id")
   @JsonProperty("drillProcessId")
   @JSONField(name = "drillProcessId")
   private Long drillProcessId;
   @ApiModelProperty(name = "drillTeamId", value = "钻孔班组id", notes = "钻孔班组id")
   @JsonProperty("drillTeamId")
   @JSONField(name = "drillTeamId")
   private Long drillTeamId;
   @ApiModelProperty(name = "drillGroupsId", value = "钻孔生产组id", notes = "钻孔生产组id")
   @JsonProperty("drillGroupsId")
   @JSONField(name = "drillGroupsId")
   private Long drillGroupsId;
   @ApiModelProperty(name = "drillAskCompleteTime", value = "钻孔要求完成日期", notes = "钻孔要求完成日期")
   @JsonProperty("drillAskCompleteTime")
   @JSONField(name = "drillAskCompleteTime")
   private LocalDateTime drillAskCompleteTime;
   @ApiModelProperty(name = "boolOffLine", value = "套料类型 0:正常套料 1:线下套料", notes = "套料类型 0:正常套料 1:线下套料")
   @JsonProperty("boolOffLine")
   @JSONField(name = "boolOffLine")
   @NotNull(message = "套料类型不能为空")
   private Boolean boolOffLine;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "bcGuid", value = "柏楚套料guid", notes = "柏楚套料guid")
   @JsonProperty("bcGuid")
   private String bcGuid;
   @ApiModelProperty(name = "jobId", value = "柏楚作业单id", notes = "柏楚作业单id")
   @JsonProperty("jobId")
   private Integer jobId;
   @ApiModelProperty("零件分类 4.成品型材 8.钢板")
   @TableField("product_classification_enum")
   @Column(name = "product_classification_enum", columnDefinition = "int(11) comment '零件类型 4.成品型材 8.钢板'", nullable = true)
   private Integer productClassificationEnum;
   @ApiModelProperty(name = "childOrderNumber")
   @JsonProperty("childOrderNumber")
   private String childOrderNumber;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序 true是 false否")
   @JsonProperty("boolProcess")
   @JSONField(name = "boolProcess")
   private Boolean boolProcess;

   public static MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder builder() {
      return new MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder();
   }

   public MesBuildingMachinePartSchedulingDTOParam(
      final Long productId,
      final String thick,
      final String material,
      final List<MesBuildingMachinePartSchedulingLinkDTOParam> linkList,
      final BatchSchedulingOutboundDTOParam batchOutboundDTOParam,
      final Long cutConfigId,
      final Integer saveType,
      final Long schedulingId,
      final Long groupsId,
      final LocalDateTime askCompleteTime,
      final Long drillProductionLineId,
      final Long drillCutConfigId,
      final Long drillProcessId,
      final Long drillTeamId,
      final Long drillGroupsId,
      final LocalDateTime drillAskCompleteTime,
      final Boolean boolOffLine,
      final Long productionLineId,
      final String bcGuid,
      final Integer jobId,
      final Integer productClassificationEnum,
      final String childOrderNumber,
      final Boolean boolProcess
   ) {
      this.productId = productId;
      this.thick = thick;
      this.material = material;
      this.linkList = linkList;
      this.batchOutboundDTOParam = batchOutboundDTOParam;
      this.cutConfigId = cutConfigId;
      this.saveType = saveType;
      this.schedulingId = schedulingId;
      this.groupsId = groupsId;
      this.askCompleteTime = askCompleteTime;
      this.drillProductionLineId = drillProductionLineId;
      this.drillCutConfigId = drillCutConfigId;
      this.drillProcessId = drillProcessId;
      this.drillTeamId = drillTeamId;
      this.drillGroupsId = drillGroupsId;
      this.drillAskCompleteTime = drillAskCompleteTime;
      this.boolOffLine = boolOffLine;
      this.productionLineId = productionLineId;
      this.bcGuid = bcGuid;
      this.jobId = jobId;
      this.productClassificationEnum = productClassificationEnum;
      this.childOrderNumber = childOrderNumber;
      this.boolProcess = boolProcess;
   }

   public MesBuildingMachinePartSchedulingDTOParam() {
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getThick() {
      return this.thick;
   }

   public String getMaterial() {
      return this.material;
   }

   public List<MesBuildingMachinePartSchedulingLinkDTOParam> getLinkList() {
      return this.linkList;
   }

   public BatchSchedulingOutboundDTOParam getBatchOutboundDTOParam() {
      return this.batchOutboundDTOParam;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public Integer getSaveType() {
      return this.saveType;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Long getDrillProductionLineId() {
      return this.drillProductionLineId;
   }

   public Long getDrillCutConfigId() {
      return this.drillCutConfigId;
   }

   public Long getDrillProcessId() {
      return this.drillProcessId;
   }

   public Long getDrillTeamId() {
      return this.drillTeamId;
   }

   public Long getDrillGroupsId() {
      return this.drillGroupsId;
   }

   public LocalDateTime getDrillAskCompleteTime() {
      return this.drillAskCompleteTime;
   }

   public Boolean getBoolOffLine() {
      return this.boolOffLine;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getBcGuid() {
      return this.bcGuid;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public String getChildOrderNumber() {
      return this.childOrderNumber;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   @JsonProperty("productId")
   public MesBuildingMachinePartSchedulingDTOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("thick")
   public MesBuildingMachinePartSchedulingDTOParam setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingMachinePartSchedulingDTOParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("linkList")
   public MesBuildingMachinePartSchedulingDTOParam setLinkList(final List<MesBuildingMachinePartSchedulingLinkDTOParam> linkList) {
      this.linkList = linkList;
      return this;
   }

   @JsonProperty("batchOutboundDTOParam")
   public MesBuildingMachinePartSchedulingDTOParam setBatchOutboundDTOParam(final BatchSchedulingOutboundDTOParam batchOutboundDTOParam) {
      this.batchOutboundDTOParam = batchOutboundDTOParam;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesBuildingMachinePartSchedulingDTOParam setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("saveType")
   public MesBuildingMachinePartSchedulingDTOParam setSaveType(final Integer saveType) {
      this.saveType = saveType;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingMachinePartSchedulingDTOParam setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingMachinePartSchedulingDTOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingMachinePartSchedulingDTOParam setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("drillProductionLineId")
   public MesBuildingMachinePartSchedulingDTOParam setDrillProductionLineId(final Long drillProductionLineId) {
      this.drillProductionLineId = drillProductionLineId;
      return this;
   }

   @JsonProperty("drillCutConfigId")
   public MesBuildingMachinePartSchedulingDTOParam setDrillCutConfigId(final Long drillCutConfigId) {
      this.drillCutConfigId = drillCutConfigId;
      return this;
   }

   @JsonProperty("drillProcessId")
   public MesBuildingMachinePartSchedulingDTOParam setDrillProcessId(final Long drillProcessId) {
      this.drillProcessId = drillProcessId;
      return this;
   }

   @JsonProperty("drillTeamId")
   public MesBuildingMachinePartSchedulingDTOParam setDrillTeamId(final Long drillTeamId) {
      this.drillTeamId = drillTeamId;
      return this;
   }

   @JsonProperty("drillGroupsId")
   public MesBuildingMachinePartSchedulingDTOParam setDrillGroupsId(final Long drillGroupsId) {
      this.drillGroupsId = drillGroupsId;
      return this;
   }

   @JsonProperty("drillAskCompleteTime")
   public MesBuildingMachinePartSchedulingDTOParam setDrillAskCompleteTime(final LocalDateTime drillAskCompleteTime) {
      this.drillAskCompleteTime = drillAskCompleteTime;
      return this;
   }

   @JsonProperty("boolOffLine")
   public MesBuildingMachinePartSchedulingDTOParam setBoolOffLine(final Boolean boolOffLine) {
      this.boolOffLine = boolOffLine;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingMachinePartSchedulingDTOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("bcGuid")
   public MesBuildingMachinePartSchedulingDTOParam setBcGuid(final String bcGuid) {
      this.bcGuid = bcGuid;
      return this;
   }

   @JsonProperty("jobId")
   public MesBuildingMachinePartSchedulingDTOParam setJobId(final Integer jobId) {
      this.jobId = jobId;
      return this;
   }

   public MesBuildingMachinePartSchedulingDTOParam setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
      return this;
   }

   @JsonProperty("childOrderNumber")
   public MesBuildingMachinePartSchedulingDTOParam setChildOrderNumber(final String childOrderNumber) {
      this.childOrderNumber = childOrderNumber;
      return this;
   }

   @JsonProperty("boolProcess")
   public MesBuildingMachinePartSchedulingDTOParam setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartSchedulingDTOParam(productId="
         + this.getProductId()
         + ", thick="
         + this.getThick()
         + ", material="
         + this.getMaterial()
         + ", linkList="
         + this.getLinkList()
         + ", batchOutboundDTOParam="
         + this.getBatchOutboundDTOParam()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", saveType="
         + this.getSaveType()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", groupsId="
         + this.getGroupsId()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", drillProductionLineId="
         + this.getDrillProductionLineId()
         + ", drillCutConfigId="
         + this.getDrillCutConfigId()
         + ", drillProcessId="
         + this.getDrillProcessId()
         + ", drillTeamId="
         + this.getDrillTeamId()
         + ", drillGroupsId="
         + this.getDrillGroupsId()
         + ", drillAskCompleteTime="
         + this.getDrillAskCompleteTime()
         + ", boolOffLine="
         + this.getBoolOffLine()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", bcGuid="
         + this.getBcGuid()
         + ", jobId="
         + this.getJobId()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", childOrderNumber="
         + this.getChildOrderNumber()
         + ", boolProcess="
         + this.getBoolProcess()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSchedulingDTOParam)) {
         return false;
      }

      MesBuildingMachinePartSchedulingDTOParam other = (MesBuildingMachinePartSchedulingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$cutConfigId = this.getCutConfigId();
         Object other$cutConfigId = other.getCutConfigId();
         if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
            Object this$saveType = this.getSaveType();
            Object other$saveType = other.getSaveType();
            if (this$saveType == null ? other$saveType == null : this$saveType.equals(other$saveType)) {
               Object this$schedulingId = this.getSchedulingId();
               Object other$schedulingId = other.getSchedulingId();
               if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
                  Object this$groupsId = this.getGroupsId();
                  Object other$groupsId = other.getGroupsId();
                  if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                     Object this$drillProductionLineId = this.getDrillProductionLineId();
                     Object other$drillProductionLineId = other.getDrillProductionLineId();
                     if (this$drillProductionLineId == null
                        ? other$drillProductionLineId == null
                        : this$drillProductionLineId.equals(other$drillProductionLineId)) {
                        Object this$drillCutConfigId = this.getDrillCutConfigId();
                        Object other$drillCutConfigId = other.getDrillCutConfigId();
                        if (this$drillCutConfigId == null ? other$drillCutConfigId == null : this$drillCutConfigId.equals(other$drillCutConfigId)) {
                           Object this$drillProcessId = this.getDrillProcessId();
                           Object other$drillProcessId = other.getDrillProcessId();
                           if (this$drillProcessId == null ? other$drillProcessId == null : this$drillProcessId.equals(other$drillProcessId)) {
                              Object this$drillTeamId = this.getDrillTeamId();
                              Object other$drillTeamId = other.getDrillTeamId();
                              if (this$drillTeamId == null ? other$drillTeamId == null : this$drillTeamId.equals(other$drillTeamId)) {
                                 Object this$drillGroupsId = this.getDrillGroupsId();
                                 Object other$drillGroupsId = other.getDrillGroupsId();
                                 if (this$drillGroupsId == null ? other$drillGroupsId == null : this$drillGroupsId.equals(other$drillGroupsId)) {
                                    Object this$boolOffLine = this.getBoolOffLine();
                                    Object other$boolOffLine = other.getBoolOffLine();
                                    if (this$boolOffLine == null ? other$boolOffLine == null : this$boolOffLine.equals(other$boolOffLine)) {
                                       Object this$productionLineId = this.getProductionLineId();
                                       Object other$productionLineId = other.getProductionLineId();
                                       if (this$productionLineId == null
                                          ? other$productionLineId == null
                                          : this$productionLineId.equals(other$productionLineId)) {
                                          Object this$jobId = this.getJobId();
                                          Object other$jobId = other.getJobId();
                                          if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
                                             Object this$productClassificationEnum = this.getProductClassificationEnum();
                                             Object other$productClassificationEnum = other.getProductClassificationEnum();
                                             if (this$productClassificationEnum == null
                                                ? other$productClassificationEnum == null
                                                : this$productClassificationEnum.equals(other$productClassificationEnum)) {
                                                Object this$boolProcess = this.getBoolProcess();
                                                Object other$boolProcess = other.getBoolProcess();
                                                if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
                                                   Object this$thick = this.getThick();
                                                   Object other$thick = other.getThick();
                                                   if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                      Object this$material = this.getMaterial();
                                                      Object other$material = other.getMaterial();
                                                      if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                         Object this$linkList = this.getLinkList();
                                                         Object other$linkList = other.getLinkList();
                                                         if (this$linkList == null ? other$linkList == null : this$linkList.equals(other$linkList)) {
                                                            Object this$batchOutboundDTOParam = this.getBatchOutboundDTOParam();
                                                            Object other$batchOutboundDTOParam = other.getBatchOutboundDTOParam();
                                                            if (this$batchOutboundDTOParam == null
                                                               ? other$batchOutboundDTOParam == null
                                                               : this$batchOutboundDTOParam.equals(other$batchOutboundDTOParam)) {
                                                               Object this$askCompleteTime = this.getAskCompleteTime();
                                                               Object other$askCompleteTime = other.getAskCompleteTime();
                                                               if (this$askCompleteTime == null
                                                                  ? other$askCompleteTime == null
                                                                  : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                  Object this$drillAskCompleteTime = this.getDrillAskCompleteTime();
                                                                  Object other$drillAskCompleteTime = other.getDrillAskCompleteTime();
                                                                  if (this$drillAskCompleteTime == null
                                                                     ? other$drillAskCompleteTime == null
                                                                     : this$drillAskCompleteTime.equals(other$drillAskCompleteTime)) {
                                                                     Object this$bcGuid = this.getBcGuid();
                                                                     Object other$bcGuid = other.getBcGuid();
                                                                     if (this$bcGuid == null ? other$bcGuid == null : this$bcGuid.equals(other$bcGuid)) {
                                                                        Object this$childOrderNumber = this.getChildOrderNumber();
                                                                        Object other$childOrderNumber = other.getChildOrderNumber();
                                                                        return this$childOrderNumber == null
                                                                           ? other$childOrderNumber == null
                                                                           : this$childOrderNumber.equals(other$childOrderNumber);
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
      return other instanceof MesBuildingMachinePartSchedulingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $saveType = this.getSaveType();
      result = result * 59 + ($saveType == null ? 43 : $saveType.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $drillProductionLineId = this.getDrillProductionLineId();
      result = result * 59 + ($drillProductionLineId == null ? 43 : $drillProductionLineId.hashCode());
      Object $drillCutConfigId = this.getDrillCutConfigId();
      result = result * 59 + ($drillCutConfigId == null ? 43 : $drillCutConfigId.hashCode());
      Object $drillProcessId = this.getDrillProcessId();
      result = result * 59 + ($drillProcessId == null ? 43 : $drillProcessId.hashCode());
      Object $drillTeamId = this.getDrillTeamId();
      result = result * 59 + ($drillTeamId == null ? 43 : $drillTeamId.hashCode());
      Object $drillGroupsId = this.getDrillGroupsId();
      result = result * 59 + ($drillGroupsId == null ? 43 : $drillGroupsId.hashCode());
      Object $boolOffLine = this.getBoolOffLine();
      result = result * 59 + ($boolOffLine == null ? 43 : $boolOffLine.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $linkList = this.getLinkList();
      result = result * 59 + ($linkList == null ? 43 : $linkList.hashCode());
      Object $batchOutboundDTOParam = this.getBatchOutboundDTOParam();
      result = result * 59 + ($batchOutboundDTOParam == null ? 43 : $batchOutboundDTOParam.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $drillAskCompleteTime = this.getDrillAskCompleteTime();
      result = result * 59 + ($drillAskCompleteTime == null ? 43 : $drillAskCompleteTime.hashCode());
      Object $bcGuid = this.getBcGuid();
      result = result * 59 + ($bcGuid == null ? 43 : $bcGuid.hashCode());
      Object $childOrderNumber = this.getChildOrderNumber();
      return result * 59 + ($childOrderNumber == null ? 43 : $childOrderNumber.hashCode());
   }

   public static class MesBuildingMachinePartSchedulingDTOParamBuilder {
      private Long productId;
      private String thick;
      private String material;
      private List<MesBuildingMachinePartSchedulingLinkDTOParam> linkList;
      private BatchSchedulingOutboundDTOParam batchOutboundDTOParam;
      private Long cutConfigId;
      private Integer saveType;
      private Long schedulingId;
      private Long groupsId;
      private LocalDateTime askCompleteTime;
      private Long drillProductionLineId;
      private Long drillCutConfigId;
      private Long drillProcessId;
      private Long drillTeamId;
      private Long drillGroupsId;
      private LocalDateTime drillAskCompleteTime;
      private Boolean boolOffLine;
      private Long productionLineId;
      private String bcGuid;
      private Integer jobId;
      private Integer productClassificationEnum;
      private String childOrderNumber;
      private Boolean boolProcess;

      MesBuildingMachinePartSchedulingDTOParamBuilder() {
      }

      @JsonProperty("productId")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("thick")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("linkList")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder linkList(
         final List<MesBuildingMachinePartSchedulingLinkDTOParam> linkList
      ) {
         this.linkList = linkList;
         return this;
      }

      @JsonProperty("batchOutboundDTOParam")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder batchOutboundDTOParam(
         final BatchSchedulingOutboundDTOParam batchOutboundDTOParam
      ) {
         this.batchOutboundDTOParam = batchOutboundDTOParam;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("saveType")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder saveType(final Integer saveType) {
         this.saveType = saveType;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("drillProductionLineId")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder drillProductionLineId(final Long drillProductionLineId) {
         this.drillProductionLineId = drillProductionLineId;
         return this;
      }

      @JsonProperty("drillCutConfigId")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder drillCutConfigId(final Long drillCutConfigId) {
         this.drillCutConfigId = drillCutConfigId;
         return this;
      }

      @JsonProperty("drillProcessId")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder drillProcessId(final Long drillProcessId) {
         this.drillProcessId = drillProcessId;
         return this;
      }

      @JsonProperty("drillTeamId")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder drillTeamId(final Long drillTeamId) {
         this.drillTeamId = drillTeamId;
         return this;
      }

      @JsonProperty("drillGroupsId")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder drillGroupsId(final Long drillGroupsId) {
         this.drillGroupsId = drillGroupsId;
         return this;
      }

      @JsonProperty("drillAskCompleteTime")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder drillAskCompleteTime(
         final LocalDateTime drillAskCompleteTime
      ) {
         this.drillAskCompleteTime = drillAskCompleteTime;
         return this;
      }

      @JsonProperty("boolOffLine")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder boolOffLine(final Boolean boolOffLine) {
         this.boolOffLine = boolOffLine;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("bcGuid")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder bcGuid(final String bcGuid) {
         this.bcGuid = bcGuid;
         return this;
      }

      @JsonProperty("jobId")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder productClassificationEnum(
         final Integer productClassificationEnum
      ) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      @JsonProperty("childOrderNumber")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder childOrderNumber(final String childOrderNumber) {
         this.childOrderNumber = childOrderNumber;
         return this;
      }

      @JsonProperty("boolProcess")
      public MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      public MesBuildingMachinePartSchedulingDTOParam build() {
         return new MesBuildingMachinePartSchedulingDTOParam(
            this.productId,
            this.thick,
            this.material,
            this.linkList,
            this.batchOutboundDTOParam,
            this.cutConfigId,
            this.saveType,
            this.schedulingId,
            this.groupsId,
            this.askCompleteTime,
            this.drillProductionLineId,
            this.drillCutConfigId,
            this.drillProcessId,
            this.drillTeamId,
            this.drillGroupsId,
            this.drillAskCompleteTime,
            this.boolOffLine,
            this.productionLineId,
            this.bcGuid,
            this.jobId,
            this.productClassificationEnum,
            this.childOrderNumber,
            this.boolProcess
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartSchedulingDTOParam.MesBuildingMachinePartSchedulingDTOParamBuilder(productId="
            + this.productId
            + ", thick="
            + this.thick
            + ", material="
            + this.material
            + ", linkList="
            + this.linkList
            + ", batchOutboundDTOParam="
            + this.batchOutboundDTOParam
            + ", cutConfigId="
            + this.cutConfigId
            + ", saveType="
            + this.saveType
            + ", schedulingId="
            + this.schedulingId
            + ", groupsId="
            + this.groupsId
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", drillProductionLineId="
            + this.drillProductionLineId
            + ", drillCutConfigId="
            + this.drillCutConfigId
            + ", drillProcessId="
            + this.drillProcessId
            + ", drillTeamId="
            + this.drillTeamId
            + ", drillGroupsId="
            + this.drillGroupsId
            + ", drillAskCompleteTime="
            + this.drillAskCompleteTime
            + ", boolOffLine="
            + this.boolOffLine
            + ", productionLineId="
            + this.productionLineId
            + ", bcGuid="
            + this.bcGuid
            + ", jobId="
            + this.jobId
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ", childOrderNumber="
            + this.childOrderNumber
            + ", boolProcess="
            + this.boolProcess
            + ")";
      }
   }
}
