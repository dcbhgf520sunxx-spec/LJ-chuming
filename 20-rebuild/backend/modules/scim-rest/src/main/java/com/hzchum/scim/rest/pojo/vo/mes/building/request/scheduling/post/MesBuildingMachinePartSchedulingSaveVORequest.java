package com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.BatchSchedulingOutboundDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingLinkDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingMachinePartSchedulingSaveVORequest", description = "零件排产请求类")
public class MesBuildingMachinePartSchedulingSaveVORequest {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty(name = "cutConfigId", value = "切割配置id", notes = "切割配置id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   private Long cutConfigId;
   @ApiModelProperty(name = "saveType", value = "保存类型 1不套料下发，2套料下发，4追加旧工单", notes = "保存类型 1不套料下发，2套料下发，4追加旧工单")
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
   @ApiModelProperty(name = "workShopId", value = "车间id", notes = "车间id")
   @JsonProperty("workShopId")
   @JSONField(name = "workShopId")
   private Long workShopId;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "drillCutConfigId", value = "钻孔产线id", notes = "钻孔产线id")
   @JsonProperty("drillCutConfigId")
   @JSONField(name = "drillCutConfigId")
   private Long drillCutConfigId;
   @ApiModelProperty(name = "drillProductionLineId", value = "钻孔产线id", notes = "钻孔产线id")
   @JsonProperty("drillProductionLineId")
   @JSONField(name = "drillProductionLineId")
   private Long drillProductionLineId;
   @ApiModelProperty(name = "drillProcessId", value = "钻孔工序id", notes = "钻孔工序id")
   @JsonProperty("drillProcessId")
   @JSONField(name = "drillProcessId")
   private Long drillProcessId;
   @ApiModelProperty(name = "drillGroupsId", value = "钻孔生产组id", notes = "钻孔生产组id")
   @JsonProperty("drillGroupsId")
   @JSONField(name = "drillGroupsId")
   private Long drillGroupsId;
   @ApiModelProperty(name = "drillAskCompleteTime", value = "钻孔要求完成日期", notes = "钻孔要求完成日期")
   @JsonProperty("drillAskCompleteTime")
   @JSONField(name = "drillAskCompleteTime")
   private LocalDateTime drillAskCompleteTime;
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
   private List<MesBuildingMachinePartSchedulingLinkDTOParam> linkList;
   @ApiModelProperty(name = "batchOutboundDTOParam", value = "出库信息", notes = "出库信息")
   @JsonProperty("batchOutboundDTOParam")
   @JSONField(name = "batchOutboundDTOParam")
   private BatchSchedulingOutboundDTOParam batchOutboundDTOParam;
   @ApiModelProperty(name = "boolOffLine", value = "套料类型 0:正常套料 1:线下套料", notes = "套料类型 0:正常套料 1:线下套料")
   @JsonProperty("boolOffLine")
   @JSONField(name = "boolOffLine")
   @NotNull(message = "套料类型不能为空")
   private Boolean boolOffLine;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   private Long productionLineId;
   @ApiModelProperty("零件分类 4.成品型材 8.钢板")
   @JsonProperty("productClassificationEnum")
   private Integer productClassificationEnum;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序 true是 false否")
   @JsonProperty("boolProcess")
   @JSONField(name = "boolProcess")
   private Boolean boolProcess = Boolean.TRUE;

   public static MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder builder() {
      return new MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder();
   }

   public MesBuildingMachinePartSchedulingSaveVORequest(
      final Long projectId,
      final Long cutConfigId,
      final Integer saveType,
      final Long schedulingId,
      final Long groupsId,
      final Long workShopId,
      final LocalDateTime askCompleteTime,
      final Long drillCutConfigId,
      final Long drillProductionLineId,
      final Long drillProcessId,
      final Long drillGroupsId,
      final LocalDateTime drillAskCompleteTime,
      final String thick,
      final String material,
      final List<MesBuildingMachinePartSchedulingLinkDTOParam> linkList,
      final BatchSchedulingOutboundDTOParam batchOutboundDTOParam,
      final Boolean boolOffLine,
      final Long productionLineId,
      final Integer productClassificationEnum,
      final Boolean boolProcess
   ) {
      this.projectId = projectId;
      this.cutConfigId = cutConfigId;
      this.saveType = saveType;
      this.schedulingId = schedulingId;
      this.groupsId = groupsId;
      this.workShopId = workShopId;
      this.askCompleteTime = askCompleteTime;
      this.drillCutConfigId = drillCutConfigId;
      this.drillProductionLineId = drillProductionLineId;
      this.drillProcessId = drillProcessId;
      this.drillGroupsId = drillGroupsId;
      this.drillAskCompleteTime = drillAskCompleteTime;
      this.thick = thick;
      this.material = material;
      this.linkList = linkList;
      this.batchOutboundDTOParam = batchOutboundDTOParam;
      this.boolOffLine = boolOffLine;
      this.productionLineId = productionLineId;
      this.productClassificationEnum = productClassificationEnum;
      this.boolProcess = boolProcess;
   }

   public MesBuildingMachinePartSchedulingSaveVORequest() {
   }

   public Long getProjectId() {
      return this.projectId;
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

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Long getDrillCutConfigId() {
      return this.drillCutConfigId;
   }

   public Long getDrillProductionLineId() {
      return this.drillProductionLineId;
   }

   public Long getDrillProcessId() {
      return this.drillProcessId;
   }

   public Long getDrillGroupsId() {
      return this.drillGroupsId;
   }

   public LocalDateTime getDrillAskCompleteTime() {
      return this.drillAskCompleteTime;
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

   public Boolean getBoolOffLine() {
      return this.boolOffLine;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public MesBuildingMachinePartSchedulingSaveVORequest setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesBuildingMachinePartSchedulingSaveVORequest setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("saveType")
   public MesBuildingMachinePartSchedulingSaveVORequest setSaveType(final Integer saveType) {
      this.saveType = saveType;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingMachinePartSchedulingSaveVORequest setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingMachinePartSchedulingSaveVORequest setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("workShopId")
   public MesBuildingMachinePartSchedulingSaveVORequest setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingMachinePartSchedulingSaveVORequest setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("drillCutConfigId")
   public MesBuildingMachinePartSchedulingSaveVORequest setDrillCutConfigId(final Long drillCutConfigId) {
      this.drillCutConfigId = drillCutConfigId;
      return this;
   }

   @JsonProperty("drillProductionLineId")
   public MesBuildingMachinePartSchedulingSaveVORequest setDrillProductionLineId(final Long drillProductionLineId) {
      this.drillProductionLineId = drillProductionLineId;
      return this;
   }

   @JsonProperty("drillProcessId")
   public MesBuildingMachinePartSchedulingSaveVORequest setDrillProcessId(final Long drillProcessId) {
      this.drillProcessId = drillProcessId;
      return this;
   }

   @JsonProperty("drillGroupsId")
   public MesBuildingMachinePartSchedulingSaveVORequest setDrillGroupsId(final Long drillGroupsId) {
      this.drillGroupsId = drillGroupsId;
      return this;
   }

   @JsonProperty("drillAskCompleteTime")
   public MesBuildingMachinePartSchedulingSaveVORequest setDrillAskCompleteTime(final LocalDateTime drillAskCompleteTime) {
      this.drillAskCompleteTime = drillAskCompleteTime;
      return this;
   }

   @JsonProperty("thick")
   public MesBuildingMachinePartSchedulingSaveVORequest setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingMachinePartSchedulingSaveVORequest setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("linkList")
   public MesBuildingMachinePartSchedulingSaveVORequest setLinkList(final List<MesBuildingMachinePartSchedulingLinkDTOParam> linkList) {
      this.linkList = linkList;
      return this;
   }

   @JsonProperty("batchOutboundDTOParam")
   public MesBuildingMachinePartSchedulingSaveVORequest setBatchOutboundDTOParam(final BatchSchedulingOutboundDTOParam batchOutboundDTOParam) {
      this.batchOutboundDTOParam = batchOutboundDTOParam;
      return this;
   }

   @JsonProperty("boolOffLine")
   public MesBuildingMachinePartSchedulingSaveVORequest setBoolOffLine(final Boolean boolOffLine) {
      this.boolOffLine = boolOffLine;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingMachinePartSchedulingSaveVORequest setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productClassificationEnum")
   public MesBuildingMachinePartSchedulingSaveVORequest setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
      return this;
   }

   @JsonProperty("boolProcess")
   public MesBuildingMachinePartSchedulingSaveVORequest setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSchedulingSaveVORequest)) {
         return false;
      }

      MesBuildingMachinePartSchedulingSaveVORequest other = (MesBuildingMachinePartSchedulingSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
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
                     Object this$workShopId = this.getWorkShopId();
                     Object other$workShopId = other.getWorkShopId();
                     if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
                        Object this$drillCutConfigId = this.getDrillCutConfigId();
                        Object other$drillCutConfigId = other.getDrillCutConfigId();
                        if (this$drillCutConfigId == null ? other$drillCutConfigId == null : this$drillCutConfigId.equals(other$drillCutConfigId)) {
                           Object this$drillProductionLineId = this.getDrillProductionLineId();
                           Object other$drillProductionLineId = other.getDrillProductionLineId();
                           if (this$drillProductionLineId == null
                              ? other$drillProductionLineId == null
                              : this$drillProductionLineId.equals(other$drillProductionLineId)) {
                              Object this$drillProcessId = this.getDrillProcessId();
                              Object other$drillProcessId = other.getDrillProcessId();
                              if (this$drillProcessId == null ? other$drillProcessId == null : this$drillProcessId.equals(other$drillProcessId)) {
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
                                          Object this$productClassificationEnum = this.getProductClassificationEnum();
                                          Object other$productClassificationEnum = other.getProductClassificationEnum();
                                          if (this$productClassificationEnum == null
                                             ? other$productClassificationEnum == null
                                             : this$productClassificationEnum.equals(other$productClassificationEnum)) {
                                             Object this$boolProcess = this.getBoolProcess();
                                             Object other$boolProcess = other.getBoolProcess();
                                             if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
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
                                                               return this$batchOutboundDTOParam == null
                                                                  ? other$batchOutboundDTOParam == null
                                                                  : this$batchOutboundDTOParam.equals(other$batchOutboundDTOParam);
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
      return other instanceof MesBuildingMachinePartSchedulingSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $saveType = this.getSaveType();
      result = result * 59 + ($saveType == null ? 43 : $saveType.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $drillCutConfigId = this.getDrillCutConfigId();
      result = result * 59 + ($drillCutConfigId == null ? 43 : $drillCutConfigId.hashCode());
      Object $drillProductionLineId = this.getDrillProductionLineId();
      result = result * 59 + ($drillProductionLineId == null ? 43 : $drillProductionLineId.hashCode());
      Object $drillProcessId = this.getDrillProcessId();
      result = result * 59 + ($drillProcessId == null ? 43 : $drillProcessId.hashCode());
      Object $drillGroupsId = this.getDrillGroupsId();
      result = result * 59 + ($drillGroupsId == null ? 43 : $drillGroupsId.hashCode());
      Object $boolOffLine = this.getBoolOffLine();
      result = result * 59 + ($boolOffLine == null ? 43 : $boolOffLine.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $drillAskCompleteTime = this.getDrillAskCompleteTime();
      result = result * 59 + ($drillAskCompleteTime == null ? 43 : $drillAskCompleteTime.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $linkList = this.getLinkList();
      result = result * 59 + ($linkList == null ? 43 : $linkList.hashCode());
      Object $batchOutboundDTOParam = this.getBatchOutboundDTOParam();
      return result * 59 + ($batchOutboundDTOParam == null ? 43 : $batchOutboundDTOParam.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartSchedulingSaveVORequest(projectId="
         + this.getProjectId()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", saveType="
         + this.getSaveType()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", groupsId="
         + this.getGroupsId()
         + ", workShopId="
         + this.getWorkShopId()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", drillCutConfigId="
         + this.getDrillCutConfigId()
         + ", drillProductionLineId="
         + this.getDrillProductionLineId()
         + ", drillProcessId="
         + this.getDrillProcessId()
         + ", drillGroupsId="
         + this.getDrillGroupsId()
         + ", drillAskCompleteTime="
         + this.getDrillAskCompleteTime()
         + ", thick="
         + this.getThick()
         + ", material="
         + this.getMaterial()
         + ", linkList="
         + this.getLinkList()
         + ", batchOutboundDTOParam="
         + this.getBatchOutboundDTOParam()
         + ", boolOffLine="
         + this.getBoolOffLine()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", boolProcess="
         + this.getBoolProcess()
         + ")";
   }

   public static class MesBuildingMachinePartSchedulingSaveVORequestBuilder {
      private Long projectId;
      private Long cutConfigId;
      private Integer saveType;
      private Long schedulingId;
      private Long groupsId;
      private Long workShopId;
      private LocalDateTime askCompleteTime;
      private Long drillCutConfigId;
      private Long drillProductionLineId;
      private Long drillProcessId;
      private Long drillGroupsId;
      private LocalDateTime drillAskCompleteTime;
      private String thick;
      private String material;
      private List<MesBuildingMachinePartSchedulingLinkDTOParam> linkList;
      private BatchSchedulingOutboundDTOParam batchOutboundDTOParam;
      private Boolean boolOffLine;
      private Long productionLineId;
      private Integer productClassificationEnum;
      private Boolean boolProcess;

      MesBuildingMachinePartSchedulingSaveVORequestBuilder() {
      }

      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("saveType")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder saveType(final Integer saveType) {
         this.saveType = saveType;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("workShopId")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder askCompleteTime(
         final LocalDateTime askCompleteTime
      ) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("drillCutConfigId")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder drillCutConfigId(final Long drillCutConfigId) {
         this.drillCutConfigId = drillCutConfigId;
         return this;
      }

      @JsonProperty("drillProductionLineId")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder drillProductionLineId(
         final Long drillProductionLineId
      ) {
         this.drillProductionLineId = drillProductionLineId;
         return this;
      }

      @JsonProperty("drillProcessId")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder drillProcessId(final Long drillProcessId) {
         this.drillProcessId = drillProcessId;
         return this;
      }

      @JsonProperty("drillGroupsId")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder drillGroupsId(final Long drillGroupsId) {
         this.drillGroupsId = drillGroupsId;
         return this;
      }

      @JsonProperty("drillAskCompleteTime")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder drillAskCompleteTime(
         final LocalDateTime drillAskCompleteTime
      ) {
         this.drillAskCompleteTime = drillAskCompleteTime;
         return this;
      }

      @JsonProperty("thick")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("linkList")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder linkList(
         final List<MesBuildingMachinePartSchedulingLinkDTOParam> linkList
      ) {
         this.linkList = linkList;
         return this;
      }

      @JsonProperty("batchOutboundDTOParam")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder batchOutboundDTOParam(
         final BatchSchedulingOutboundDTOParam batchOutboundDTOParam
      ) {
         this.batchOutboundDTOParam = batchOutboundDTOParam;
         return this;
      }

      @JsonProperty("boolOffLine")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder boolOffLine(final Boolean boolOffLine) {
         this.boolOffLine = boolOffLine;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productClassificationEnum")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder productClassificationEnum(
         final Integer productClassificationEnum
      ) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      @JsonProperty("boolProcess")
      public MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      public MesBuildingMachinePartSchedulingSaveVORequest build() {
         return new MesBuildingMachinePartSchedulingSaveVORequest(
            this.projectId,
            this.cutConfigId,
            this.saveType,
            this.schedulingId,
            this.groupsId,
            this.workShopId,
            this.askCompleteTime,
            this.drillCutConfigId,
            this.drillProductionLineId,
            this.drillProcessId,
            this.drillGroupsId,
            this.drillAskCompleteTime,
            this.thick,
            this.material,
            this.linkList,
            this.batchOutboundDTOParam,
            this.boolOffLine,
            this.productionLineId,
            this.productClassificationEnum,
            this.boolProcess
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartSchedulingSaveVORequest.MesBuildingMachinePartSchedulingSaveVORequestBuilder(projectId="
            + this.projectId
            + ", cutConfigId="
            + this.cutConfigId
            + ", saveType="
            + this.saveType
            + ", schedulingId="
            + this.schedulingId
            + ", groupsId="
            + this.groupsId
            + ", workShopId="
            + this.workShopId
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", drillCutConfigId="
            + this.drillCutConfigId
            + ", drillProductionLineId="
            + this.drillProductionLineId
            + ", drillProcessId="
            + this.drillProcessId
            + ", drillGroupsId="
            + this.drillGroupsId
            + ", drillAskCompleteTime="
            + this.drillAskCompleteTime
            + ", thick="
            + this.thick
            + ", material="
            + this.material
            + ", linkList="
            + this.linkList
            + ", batchOutboundDTOParam="
            + this.batchOutboundDTOParam
            + ", boolOffLine="
            + this.boolOffLine
            + ", productionLineId="
            + this.productionLineId
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ", boolProcess="
            + this.boolProcess
            + ")";
      }
   }
}
