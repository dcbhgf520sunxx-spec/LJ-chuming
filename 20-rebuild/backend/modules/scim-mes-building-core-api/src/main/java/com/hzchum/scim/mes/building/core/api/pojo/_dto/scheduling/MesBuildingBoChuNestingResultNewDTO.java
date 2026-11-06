package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MesBuildingBoChuNestingResultNewDTO", description = "柏楚作业目录记录表")
public class MesBuildingBoChuNestingResultNewDTO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   private Long id;
   @ApiModelProperty(name = "jobId")
   @JsonProperty("jobId")
   private Integer jobId;
   @ApiModelProperty(name = "guid")
   @JsonProperty("guid")
   private String guid;
   @ApiModelProperty(name = "resultName")
   @JsonProperty("resultName")
   @JSONField(name = "resultName")
   private String resultName;
   @ApiModelProperty(name = "material")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "thickness")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "gas")
   @JsonProperty("gas")
   @JSONField(name = "gas")
   private String gas;
   @ApiModelProperty(name = "amount")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   private BigDecimal amount;
   @ApiModelProperty(name = "utilization")
   @JsonProperty("utilization")
   @JSONField(name = "utilization")
   private BigDecimal utilization;
   @ApiModelProperty(name = "partAmount")
   @JsonProperty("partAmount")
   @JSONField(name = "partAmount")
   private BigDecimal partAmount;
   @ApiModelProperty(name = "plateHeight")
   @JsonProperty("plateHeight")
   private BigDecimal plateHeight;
   @ApiModelProperty(name = "plateWidth")
   @JsonProperty("plateWidth")
   private BigDecimal plateWidth;
   @ApiModelProperty(name = "nspfUrl")
   @JsonProperty("nspfUrl")
   private String nspfUrl;
   @ApiModelProperty(name = "nspfPath")
   @JsonProperty("nspfPath")
   private String nspfPath;
   @ApiModelProperty(name = "thumbnailUrl")
   @JsonProperty("thumbnailUrl")
   private String thumbnailUrl;
   @ApiModelProperty(name = "thumbnailPath")
   @JsonProperty("thumbnailPath")
   private String thumbnailPath;
   @ApiModelProperty(name = "plateGuid")
   @JsonProperty("plateGuid")
   private String plateGuid;
   @ApiModelProperty(name = "plateName")
   @JsonProperty("plateName")
   private String plateName;
   @ApiModelProperty(name = "cutSendStatus")
   @JsonProperty("cutSendStatus")
   private Integer cutSendStatus;
   @ApiModelProperty(name = "cutSendUserId")
   @JsonProperty("cutSendUserId")
   private Long cutSendUserId;
   @ApiModelProperty(name = "cutSendUserName")
   @JsonProperty("cutSendUserName")
   private String cutSendUserName;
   @ApiModelProperty(name = "cutStatus")
   @JsonProperty("cutStatus")
   private Integer cutStatus;
   @ApiModelProperty(name = "machineToolId")
   @JsonProperty("machineToolId")
   private Long machineToolId;
   @ApiModelProperty(name = "taskRate")
   @JsonProperty("taskRate")
   private BigDecimal taskRate;
   @ApiModelProperty(name = "childOrderNumber")
   @JsonProperty("childOrderNumber")
   private String childOrderNumber;
   @ApiModelProperty(name = "childGuid")
   @JsonProperty("childGuid")
   private String childGuid;
   @ApiModelProperty(name = "partList", value = "零件", notes = "零件")
   @JsonProperty("partList")
   @JSONField(name = "partList")
   private List<MesBuildingPartCheckDrillDTO> partList;
   @ApiModelProperty(name = "nestUserId", value = "套料人", notes = "套料人")
   @JsonProperty("nestUserId")
   @JSONField(name = "nestUserId")
   private String nestUserId;
   @ApiModelProperty(name = "cutSendTime")
   @JsonProperty("cutSendTime")
   @JSONField(name = "cutSendTime")
   private LocalDateTime cutSendTime;
   @ApiModelProperty(name = "isMixNest")
   @JsonProperty("isMixNest")
   private Boolean isMixNest;
   @ApiModelProperty(name = "nestJobName")
   @JsonProperty("nestJobName")
   private String nestJobName;

   public static MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder builder() {
      return new MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder();
   }

   public MesBuildingBoChuNestingResultNewDTO() {
   }

   public MesBuildingBoChuNestingResultNewDTO(
      final Long id,
      final Integer jobId,
      final String guid,
      final String resultName,
      final String material,
      final BigDecimal thickness,
      final String gas,
      final BigDecimal amount,
      final BigDecimal utilization,
      final BigDecimal partAmount,
      final BigDecimal plateHeight,
      final BigDecimal plateWidth,
      final String nspfUrl,
      final String nspfPath,
      final String thumbnailUrl,
      final String thumbnailPath,
      final String plateGuid,
      final String plateName,
      final Integer cutSendStatus,
      final Long cutSendUserId,
      final String cutSendUserName,
      final Integer cutStatus,
      final Long machineToolId,
      final BigDecimal taskRate,
      final String childOrderNumber,
      final String childGuid,
      final List<MesBuildingPartCheckDrillDTO> partList,
      final String nestUserId,
      final LocalDateTime cutSendTime,
      final Boolean isMixNest,
      final String nestJobName
   ) {
      this.id = id;
      this.jobId = jobId;
      this.guid = guid;
      this.resultName = resultName;
      this.material = material;
      this.thickness = thickness;
      this.gas = gas;
      this.amount = amount;
      this.utilization = utilization;
      this.partAmount = partAmount;
      this.plateHeight = plateHeight;
      this.plateWidth = plateWidth;
      this.nspfUrl = nspfUrl;
      this.nspfPath = nspfPath;
      this.thumbnailUrl = thumbnailUrl;
      this.thumbnailPath = thumbnailPath;
      this.plateGuid = plateGuid;
      this.plateName = plateName;
      this.cutSendStatus = cutSendStatus;
      this.cutSendUserId = cutSendUserId;
      this.cutSendUserName = cutSendUserName;
      this.cutStatus = cutStatus;
      this.machineToolId = machineToolId;
      this.taskRate = taskRate;
      this.childOrderNumber = childOrderNumber;
      this.childGuid = childGuid;
      this.partList = partList;
      this.nestUserId = nestUserId;
      this.cutSendTime = cutSendTime;
      this.isMixNest = isMixNest;
      this.nestJobName = nestJobName;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public String getGuid() {
      return this.guid;
   }

   public String getResultName() {
      return this.resultName;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getGas() {
      return this.gas;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getUtilization() {
      return this.utilization;
   }

   public BigDecimal getPartAmount() {
      return this.partAmount;
   }

   public BigDecimal getPlateHeight() {
      return this.plateHeight;
   }

   public BigDecimal getPlateWidth() {
      return this.plateWidth;
   }

   public String getNspfUrl() {
      return this.nspfUrl;
   }

   public String getNspfPath() {
      return this.nspfPath;
   }

   public String getThumbnailUrl() {
      return this.thumbnailUrl;
   }

   public String getThumbnailPath() {
      return this.thumbnailPath;
   }

   public String getPlateGuid() {
      return this.plateGuid;
   }

   public String getPlateName() {
      return this.plateName;
   }

   public Integer getCutSendStatus() {
      return this.cutSendStatus;
   }

   public Long getCutSendUserId() {
      return this.cutSendUserId;
   }

   public String getCutSendUserName() {
      return this.cutSendUserName;
   }

   public Integer getCutStatus() {
      return this.cutStatus;
   }

   public Long getMachineToolId() {
      return this.machineToolId;
   }

   public BigDecimal getTaskRate() {
      return this.taskRate;
   }

   public String getChildOrderNumber() {
      return this.childOrderNumber;
   }

   public String getChildGuid() {
      return this.childGuid;
   }

   public List<MesBuildingPartCheckDrillDTO> getPartList() {
      return this.partList;
   }

   public String getNestUserId() {
      return this.nestUserId;
   }

   public LocalDateTime getCutSendTime() {
      return this.cutSendTime;
   }

   public Boolean getIsMixNest() {
      return this.isMixNest;
   }

   public String getNestJobName() {
      return this.nestJobName;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("jobId")
   public void setJobId(final Integer jobId) {
      this.jobId = jobId;
   }

   @JsonProperty("guid")
   public void setGuid(final String guid) {
      this.guid = guid;
   }

   @JsonProperty("resultName")
   public void setResultName(final String resultName) {
      this.resultName = resultName;
   }

   @JsonProperty("material")
   public void setMaterial(final String material) {
      this.material = material;
   }

   @JsonProperty("thickness")
   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   @JsonProperty("gas")
   public void setGas(final String gas) {
      this.gas = gas;
   }

   @JsonProperty("amount")
   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @JsonProperty("utilization")
   public void setUtilization(final BigDecimal utilization) {
      this.utilization = utilization;
   }

   @JsonProperty("partAmount")
   public void setPartAmount(final BigDecimal partAmount) {
      this.partAmount = partAmount;
   }

   @JsonProperty("plateHeight")
   public void setPlateHeight(final BigDecimal plateHeight) {
      this.plateHeight = plateHeight;
   }

   @JsonProperty("plateWidth")
   public void setPlateWidth(final BigDecimal plateWidth) {
      this.plateWidth = plateWidth;
   }

   @JsonProperty("nspfUrl")
   public void setNspfUrl(final String nspfUrl) {
      this.nspfUrl = nspfUrl;
   }

   @JsonProperty("nspfPath")
   public void setNspfPath(final String nspfPath) {
      this.nspfPath = nspfPath;
   }

   @JsonProperty("thumbnailUrl")
   public void setThumbnailUrl(final String thumbnailUrl) {
      this.thumbnailUrl = thumbnailUrl;
   }

   @JsonProperty("thumbnailPath")
   public void setThumbnailPath(final String thumbnailPath) {
      this.thumbnailPath = thumbnailPath;
   }

   @JsonProperty("plateGuid")
   public void setPlateGuid(final String plateGuid) {
      this.plateGuid = plateGuid;
   }

   @JsonProperty("plateName")
   public void setPlateName(final String plateName) {
      this.plateName = plateName;
   }

   @JsonProperty("cutSendStatus")
   public void setCutSendStatus(final Integer cutSendStatus) {
      this.cutSendStatus = cutSendStatus;
   }

   @JsonProperty("cutSendUserId")
   public void setCutSendUserId(final Long cutSendUserId) {
      this.cutSendUserId = cutSendUserId;
   }

   @JsonProperty("cutSendUserName")
   public void setCutSendUserName(final String cutSendUserName) {
      this.cutSendUserName = cutSendUserName;
   }

   @JsonProperty("cutStatus")
   public void setCutStatus(final Integer cutStatus) {
      this.cutStatus = cutStatus;
   }

   @JsonProperty("machineToolId")
   public void setMachineToolId(final Long machineToolId) {
      this.machineToolId = machineToolId;
   }

   @JsonProperty("taskRate")
   public void setTaskRate(final BigDecimal taskRate) {
      this.taskRate = taskRate;
   }

   @JsonProperty("childOrderNumber")
   public void setChildOrderNumber(final String childOrderNumber) {
      this.childOrderNumber = childOrderNumber;
   }

   @JsonProperty("childGuid")
   public void setChildGuid(final String childGuid) {
      this.childGuid = childGuid;
   }

   @JsonProperty("partList")
   public void setPartList(final List<MesBuildingPartCheckDrillDTO> partList) {
      this.partList = partList;
   }

   @JsonProperty("nestUserId")
   public void setNestUserId(final String nestUserId) {
      this.nestUserId = nestUserId;
   }

   @JsonProperty("cutSendTime")
   public void setCutSendTime(final LocalDateTime cutSendTime) {
      this.cutSendTime = cutSendTime;
   }

   @JsonProperty("isMixNest")
   public void setIsMixNest(final Boolean isMixNest) {
      this.isMixNest = isMixNest;
   }

   @JsonProperty("nestJobName")
   public void setNestJobName(final String nestJobName) {
      this.nestJobName = nestJobName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingBoChuNestingResultNewDTO)) {
         return false;
      }

      MesBuildingBoChuNestingResultNewDTO other = (MesBuildingBoChuNestingResultNewDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$jobId = this.getJobId();
         Object other$jobId = other.getJobId();
         if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
            Object this$cutSendStatus = this.getCutSendStatus();
            Object other$cutSendStatus = other.getCutSendStatus();
            if (this$cutSendStatus == null ? other$cutSendStatus == null : this$cutSendStatus.equals(other$cutSendStatus)) {
               Object this$cutSendUserId = this.getCutSendUserId();
               Object other$cutSendUserId = other.getCutSendUserId();
               if (this$cutSendUserId == null ? other$cutSendUserId == null : this$cutSendUserId.equals(other$cutSendUserId)) {
                  Object this$cutStatus = this.getCutStatus();
                  Object other$cutStatus = other.getCutStatus();
                  if (this$cutStatus == null ? other$cutStatus == null : this$cutStatus.equals(other$cutStatus)) {
                     Object this$machineToolId = this.getMachineToolId();
                     Object other$machineToolId = other.getMachineToolId();
                     if (this$machineToolId == null ? other$machineToolId == null : this$machineToolId.equals(other$machineToolId)) {
                        Object this$isMixNest = this.getIsMixNest();
                        Object other$isMixNest = other.getIsMixNest();
                        if (this$isMixNest == null ? other$isMixNest == null : this$isMixNest.equals(other$isMixNest)) {
                           Object this$guid = this.getGuid();
                           Object other$guid = other.getGuid();
                           if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
                              Object this$resultName = this.getResultName();
                              Object other$resultName = other.getResultName();
                              if (this$resultName == null ? other$resultName == null : this$resultName.equals(other$resultName)) {
                                 Object this$material = this.getMaterial();
                                 Object other$material = other.getMaterial();
                                 if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                    Object this$thickness = this.getThickness();
                                    Object other$thickness = other.getThickness();
                                    if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                       Object this$gas = this.getGas();
                                       Object other$gas = other.getGas();
                                       if (this$gas == null ? other$gas == null : this$gas.equals(other$gas)) {
                                          Object this$amount = this.getAmount();
                                          Object other$amount = other.getAmount();
                                          if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                             Object this$utilization = this.getUtilization();
                                             Object other$utilization = other.getUtilization();
                                             if (this$utilization == null ? other$utilization == null : this$utilization.equals(other$utilization)) {
                                                Object this$partAmount = this.getPartAmount();
                                                Object other$partAmount = other.getPartAmount();
                                                if (this$partAmount == null ? other$partAmount == null : this$partAmount.equals(other$partAmount)) {
                                                   Object this$plateHeight = this.getPlateHeight();
                                                   Object other$plateHeight = other.getPlateHeight();
                                                   if (this$plateHeight == null ? other$plateHeight == null : this$plateHeight.equals(other$plateHeight)) {
                                                      Object this$plateWidth = this.getPlateWidth();
                                                      Object other$plateWidth = other.getPlateWidth();
                                                      if (this$plateWidth == null ? other$plateWidth == null : this$plateWidth.equals(other$plateWidth)) {
                                                         Object this$nspfUrl = this.getNspfUrl();
                                                         Object other$nspfUrl = other.getNspfUrl();
                                                         if (this$nspfUrl == null ? other$nspfUrl == null : this$nspfUrl.equals(other$nspfUrl)) {
                                                            Object this$nspfPath = this.getNspfPath();
                                                            Object other$nspfPath = other.getNspfPath();
                                                            if (this$nspfPath == null ? other$nspfPath == null : this$nspfPath.equals(other$nspfPath)) {
                                                               Object this$thumbnailUrl = this.getThumbnailUrl();
                                                               Object other$thumbnailUrl = other.getThumbnailUrl();
                                                               if (this$thumbnailUrl == null
                                                                  ? other$thumbnailUrl == null
                                                                  : this$thumbnailUrl.equals(other$thumbnailUrl)) {
                                                                  Object this$thumbnailPath = this.getThumbnailPath();
                                                                  Object other$thumbnailPath = other.getThumbnailPath();
                                                                  if (this$thumbnailPath == null
                                                                     ? other$thumbnailPath == null
                                                                     : this$thumbnailPath.equals(other$thumbnailPath)) {
                                                                     Object this$plateGuid = this.getPlateGuid();
                                                                     Object other$plateGuid = other.getPlateGuid();
                                                                     if (this$plateGuid == null
                                                                        ? other$plateGuid == null
                                                                        : this$plateGuid.equals(other$plateGuid)) {
                                                                        Object this$plateName = this.getPlateName();
                                                                        Object other$plateName = other.getPlateName();
                                                                        if (this$plateName == null
                                                                           ? other$plateName == null
                                                                           : this$plateName.equals(other$plateName)) {
                                                                           Object this$cutSendUserName = this.getCutSendUserName();
                                                                           Object other$cutSendUserName = other.getCutSendUserName();
                                                                           if (this$cutSendUserName == null
                                                                              ? other$cutSendUserName == null
                                                                              : this$cutSendUserName.equals(other$cutSendUserName)) {
                                                                              Object this$taskRate = this.getTaskRate();
                                                                              Object other$taskRate = other.getTaskRate();
                                                                              if (this$taskRate == null
                                                                                 ? other$taskRate == null
                                                                                 : this$taskRate.equals(other$taskRate)) {
                                                                                 Object this$childOrderNumber = this.getChildOrderNumber();
                                                                                 Object other$childOrderNumber = other.getChildOrderNumber();
                                                                                 if (this$childOrderNumber == null
                                                                                    ? other$childOrderNumber == null
                                                                                    : this$childOrderNumber.equals(other$childOrderNumber)) {
                                                                                    Object this$childGuid = this.getChildGuid();
                                                                                    Object other$childGuid = other.getChildGuid();
                                                                                    if (this$childGuid == null
                                                                                       ? other$childGuid == null
                                                                                       : this$childGuid.equals(other$childGuid)) {
                                                                                       Object this$partList = this.getPartList();
                                                                                       Object other$partList = other.getPartList();
                                                                                       if (this$partList == null
                                                                                          ? other$partList == null
                                                                                          : this$partList.equals(other$partList)) {
                                                                                          Object this$nestUserId = this.getNestUserId();
                                                                                          Object other$nestUserId = other.getNestUserId();
                                                                                          if (this$nestUserId == null
                                                                                             ? other$nestUserId == null
                                                                                             : this$nestUserId.equals(other$nestUserId)) {
                                                                                             Object this$cutSendTime = this.getCutSendTime();
                                                                                             Object other$cutSendTime = other.getCutSendTime();
                                                                                             if (this$cutSendTime == null
                                                                                                ? other$cutSendTime == null
                                                                                                : this$cutSendTime.equals(other$cutSendTime)) {
                                                                                                Object this$nestJobName = this.getNestJobName();
                                                                                                Object other$nestJobName = other.getNestJobName();
                                                                                                return this$nestJobName == null
                                                                                                   ? other$nestJobName == null
                                                                                                   : this$nestJobName.equals(other$nestJobName);
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
      return other instanceof MesBuildingBoChuNestingResultNewDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $cutSendStatus = this.getCutSendStatus();
      result = result * 59 + ($cutSendStatus == null ? 43 : $cutSendStatus.hashCode());
      Object $cutSendUserId = this.getCutSendUserId();
      result = result * 59 + ($cutSendUserId == null ? 43 : $cutSendUserId.hashCode());
      Object $cutStatus = this.getCutStatus();
      result = result * 59 + ($cutStatus == null ? 43 : $cutStatus.hashCode());
      Object $machineToolId = this.getMachineToolId();
      result = result * 59 + ($machineToolId == null ? 43 : $machineToolId.hashCode());
      Object $isMixNest = this.getIsMixNest();
      result = result * 59 + ($isMixNest == null ? 43 : $isMixNest.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $resultName = this.getResultName();
      result = result * 59 + ($resultName == null ? 43 : $resultName.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $gas = this.getGas();
      result = result * 59 + ($gas == null ? 43 : $gas.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $utilization = this.getUtilization();
      result = result * 59 + ($utilization == null ? 43 : $utilization.hashCode());
      Object $partAmount = this.getPartAmount();
      result = result * 59 + ($partAmount == null ? 43 : $partAmount.hashCode());
      Object $plateHeight = this.getPlateHeight();
      result = result * 59 + ($plateHeight == null ? 43 : $plateHeight.hashCode());
      Object $plateWidth = this.getPlateWidth();
      result = result * 59 + ($plateWidth == null ? 43 : $plateWidth.hashCode());
      Object $nspfUrl = this.getNspfUrl();
      result = result * 59 + ($nspfUrl == null ? 43 : $nspfUrl.hashCode());
      Object $nspfPath = this.getNspfPath();
      result = result * 59 + ($nspfPath == null ? 43 : $nspfPath.hashCode());
      Object $thumbnailUrl = this.getThumbnailUrl();
      result = result * 59 + ($thumbnailUrl == null ? 43 : $thumbnailUrl.hashCode());
      Object $thumbnailPath = this.getThumbnailPath();
      result = result * 59 + ($thumbnailPath == null ? 43 : $thumbnailPath.hashCode());
      Object $plateGuid = this.getPlateGuid();
      result = result * 59 + ($plateGuid == null ? 43 : $plateGuid.hashCode());
      Object $plateName = this.getPlateName();
      result = result * 59 + ($plateName == null ? 43 : $plateName.hashCode());
      Object $cutSendUserName = this.getCutSendUserName();
      result = result * 59 + ($cutSendUserName == null ? 43 : $cutSendUserName.hashCode());
      Object $taskRate = this.getTaskRate();
      result = result * 59 + ($taskRate == null ? 43 : $taskRate.hashCode());
      Object $childOrderNumber = this.getChildOrderNumber();
      result = result * 59 + ($childOrderNumber == null ? 43 : $childOrderNumber.hashCode());
      Object $childGuid = this.getChildGuid();
      result = result * 59 + ($childGuid == null ? 43 : $childGuid.hashCode());
      Object $partList = this.getPartList();
      result = result * 59 + ($partList == null ? 43 : $partList.hashCode());
      Object $nestUserId = this.getNestUserId();
      result = result * 59 + ($nestUserId == null ? 43 : $nestUserId.hashCode());
      Object $cutSendTime = this.getCutSendTime();
      result = result * 59 + ($cutSendTime == null ? 43 : $cutSendTime.hashCode());
      Object $nestJobName = this.getNestJobName();
      return result * 59 + ($nestJobName == null ? 43 : $nestJobName.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingBoChuNestingResultNewDTO(id="
         + this.getId()
         + ", jobId="
         + this.getJobId()
         + ", guid="
         + this.getGuid()
         + ", resultName="
         + this.getResultName()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", gas="
         + this.getGas()
         + ", amount="
         + this.getAmount()
         + ", utilization="
         + this.getUtilization()
         + ", partAmount="
         + this.getPartAmount()
         + ", plateHeight="
         + this.getPlateHeight()
         + ", plateWidth="
         + this.getPlateWidth()
         + ", nspfUrl="
         + this.getNspfUrl()
         + ", nspfPath="
         + this.getNspfPath()
         + ", thumbnailUrl="
         + this.getThumbnailUrl()
         + ", thumbnailPath="
         + this.getThumbnailPath()
         + ", plateGuid="
         + this.getPlateGuid()
         + ", plateName="
         + this.getPlateName()
         + ", cutSendStatus="
         + this.getCutSendStatus()
         + ", cutSendUserId="
         + this.getCutSendUserId()
         + ", cutSendUserName="
         + this.getCutSendUserName()
         + ", cutStatus="
         + this.getCutStatus()
         + ", machineToolId="
         + this.getMachineToolId()
         + ", taskRate="
         + this.getTaskRate()
         + ", childOrderNumber="
         + this.getChildOrderNumber()
         + ", childGuid="
         + this.getChildGuid()
         + ", partList="
         + this.getPartList()
         + ", nestUserId="
         + this.getNestUserId()
         + ", cutSendTime="
         + this.getCutSendTime()
         + ", isMixNest="
         + this.getIsMixNest()
         + ", nestJobName="
         + this.getNestJobName()
         + ")";
   }

   public static class MesBuildingBoChuNestingResultNewDTOBuilder {
      private Long id;
      private Integer jobId;
      private String guid;
      private String resultName;
      private String material;
      private BigDecimal thickness;
      private String gas;
      private BigDecimal amount;
      private BigDecimal utilization;
      private BigDecimal partAmount;
      private BigDecimal plateHeight;
      private BigDecimal plateWidth;
      private String nspfUrl;
      private String nspfPath;
      private String thumbnailUrl;
      private String thumbnailPath;
      private String plateGuid;
      private String plateName;
      private Integer cutSendStatus;
      private Long cutSendUserId;
      private String cutSendUserName;
      private Integer cutStatus;
      private Long machineToolId;
      private BigDecimal taskRate;
      private String childOrderNumber;
      private String childGuid;
      private List<MesBuildingPartCheckDrillDTO> partList;
      private String nestUserId;
      private LocalDateTime cutSendTime;
      private Boolean isMixNest;
      private String nestJobName;

      MesBuildingBoChuNestingResultNewDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("jobId")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      @JsonProperty("guid")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      @JsonProperty("resultName")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder resultName(final String resultName) {
         this.resultName = resultName;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("thickness")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("gas")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder gas(final String gas) {
         this.gas = gas;
         return this;
      }

      @JsonProperty("amount")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("utilization")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder utilization(final BigDecimal utilization) {
         this.utilization = utilization;
         return this;
      }

      @JsonProperty("partAmount")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder partAmount(final BigDecimal partAmount) {
         this.partAmount = partAmount;
         return this;
      }

      @JsonProperty("plateHeight")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder plateHeight(final BigDecimal plateHeight) {
         this.plateHeight = plateHeight;
         return this;
      }

      @JsonProperty("plateWidth")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder plateWidth(final BigDecimal plateWidth) {
         this.plateWidth = plateWidth;
         return this;
      }

      @JsonProperty("nspfUrl")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder nspfUrl(final String nspfUrl) {
         this.nspfUrl = nspfUrl;
         return this;
      }

      @JsonProperty("nspfPath")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder nspfPath(final String nspfPath) {
         this.nspfPath = nspfPath;
         return this;
      }

      @JsonProperty("thumbnailUrl")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder thumbnailUrl(final String thumbnailUrl) {
         this.thumbnailUrl = thumbnailUrl;
         return this;
      }

      @JsonProperty("thumbnailPath")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder thumbnailPath(final String thumbnailPath) {
         this.thumbnailPath = thumbnailPath;
         return this;
      }

      @JsonProperty("plateGuid")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder plateGuid(final String plateGuid) {
         this.plateGuid = plateGuid;
         return this;
      }

      @JsonProperty("plateName")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder plateName(final String plateName) {
         this.plateName = plateName;
         return this;
      }

      @JsonProperty("cutSendStatus")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder cutSendStatus(final Integer cutSendStatus) {
         this.cutSendStatus = cutSendStatus;
         return this;
      }

      @JsonProperty("cutSendUserId")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder cutSendUserId(final Long cutSendUserId) {
         this.cutSendUserId = cutSendUserId;
         return this;
      }

      @JsonProperty("cutSendUserName")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder cutSendUserName(final String cutSendUserName) {
         this.cutSendUserName = cutSendUserName;
         return this;
      }

      @JsonProperty("cutStatus")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder cutStatus(final Integer cutStatus) {
         this.cutStatus = cutStatus;
         return this;
      }

      @JsonProperty("machineToolId")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder machineToolId(final Long machineToolId) {
         this.machineToolId = machineToolId;
         return this;
      }

      @JsonProperty("taskRate")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder taskRate(final BigDecimal taskRate) {
         this.taskRate = taskRate;
         return this;
      }

      @JsonProperty("childOrderNumber")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder childOrderNumber(final String childOrderNumber) {
         this.childOrderNumber = childOrderNumber;
         return this;
      }

      @JsonProperty("childGuid")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder childGuid(final String childGuid) {
         this.childGuid = childGuid;
         return this;
      }

      @JsonProperty("partList")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder partList(final List<MesBuildingPartCheckDrillDTO> partList) {
         this.partList = partList;
         return this;
      }

      @JsonProperty("nestUserId")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder nestUserId(final String nestUserId) {
         this.nestUserId = nestUserId;
         return this;
      }

      @JsonProperty("cutSendTime")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder cutSendTime(final LocalDateTime cutSendTime) {
         this.cutSendTime = cutSendTime;
         return this;
      }

      @JsonProperty("isMixNest")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder isMixNest(final Boolean isMixNest) {
         this.isMixNest = isMixNest;
         return this;
      }

      @JsonProperty("nestJobName")
      public MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder nestJobName(final String nestJobName) {
         this.nestJobName = nestJobName;
         return this;
      }

      public MesBuildingBoChuNestingResultNewDTO build() {
         return new MesBuildingBoChuNestingResultNewDTO(
            this.id,
            this.jobId,
            this.guid,
            this.resultName,
            this.material,
            this.thickness,
            this.gas,
            this.amount,
            this.utilization,
            this.partAmount,
            this.plateHeight,
            this.plateWidth,
            this.nspfUrl,
            this.nspfPath,
            this.thumbnailUrl,
            this.thumbnailPath,
            this.plateGuid,
            this.plateName,
            this.cutSendStatus,
            this.cutSendUserId,
            this.cutSendUserName,
            this.cutStatus,
            this.machineToolId,
            this.taskRate,
            this.childOrderNumber,
            this.childGuid,
            this.partList,
            this.nestUserId,
            this.cutSendTime,
            this.isMixNest,
            this.nestJobName
         );
      }

      @Override
      public String toString() {
         return "MesBuildingBoChuNestingResultNewDTO.MesBuildingBoChuNestingResultNewDTOBuilder(id="
            + this.id
            + ", jobId="
            + this.jobId
            + ", guid="
            + this.guid
            + ", resultName="
            + this.resultName
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", gas="
            + this.gas
            + ", amount="
            + this.amount
            + ", utilization="
            + this.utilization
            + ", partAmount="
            + this.partAmount
            + ", plateHeight="
            + this.plateHeight
            + ", plateWidth="
            + this.plateWidth
            + ", nspfUrl="
            + this.nspfUrl
            + ", nspfPath="
            + this.nspfPath
            + ", thumbnailUrl="
            + this.thumbnailUrl
            + ", thumbnailPath="
            + this.thumbnailPath
            + ", plateGuid="
            + this.plateGuid
            + ", plateName="
            + this.plateName
            + ", cutSendStatus="
            + this.cutSendStatus
            + ", cutSendUserId="
            + this.cutSendUserId
            + ", cutSendUserName="
            + this.cutSendUserName
            + ", cutStatus="
            + this.cutStatus
            + ", machineToolId="
            + this.machineToolId
            + ", taskRate="
            + this.taskRate
            + ", childOrderNumber="
            + this.childOrderNumber
            + ", childGuid="
            + this.childGuid
            + ", partList="
            + this.partList
            + ", nestUserId="
            + this.nestUserId
            + ", cutSendTime="
            + this.cutSendTime
            + ", isMixNest="
            + this.isMixNest
            + ", nestJobName="
            + this.nestJobName
            + ")";
      }
   }
}
