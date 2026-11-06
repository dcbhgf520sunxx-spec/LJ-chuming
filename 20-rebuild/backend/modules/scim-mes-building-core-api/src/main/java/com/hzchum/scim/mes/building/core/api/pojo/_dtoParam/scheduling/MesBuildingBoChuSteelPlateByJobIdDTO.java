package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel("柏楚(/api/job/nspf_list/v2)获取作业下排版列表")
public class MesBuildingBoChuSteelPlateByJobIdDTO {
   private Integer jobId;
   private String guid;
   private String portionID;
   private String resultName;
   private String material;
   private BigDecimal thickness;
   private String gas;
   private Integer amount;
   private Integer partAmount;
   private BigDecimal utilization;
   private BigDecimal plateWidth;
   private BigDecimal plateHeight;
   private String nspfPath;
   private String thumbnailPath;
   private String planStatus;
   private Integer isExported;
   private String plateGuid;
   private String plateName;
   private Long nestNumber;
   private String nestName;
   private BigDecimal unCutAmount;
   private BigDecimal inCutAmount;
   private BigDecimal finishCutAmount;
   private Integer extendStatus;
   private String gmid;
   private String nspfUrl;
   private String thumbnailUrl;
   private Integer isPlaned;
   private String machine;
   private String machineDesc;
   private String lastModifyTime;
   private Integer isOpen;
   private String labelPrintTime;
   private Integer plateCategory;

   public Integer getJobId() {
      return this.jobId;
   }

   public String getGuid() {
      return this.guid;
   }

   public String getPortionID() {
      return this.portionID;
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

   public Integer getAmount() {
      return this.amount;
   }

   public Integer getPartAmount() {
      return this.partAmount;
   }

   public BigDecimal getUtilization() {
      return this.utilization;
   }

   public BigDecimal getPlateWidth() {
      return this.plateWidth;
   }

   public BigDecimal getPlateHeight() {
      return this.plateHeight;
   }

   public String getNspfPath() {
      return this.nspfPath;
   }

   public String getThumbnailPath() {
      return this.thumbnailPath;
   }

   public String getPlanStatus() {
      return this.planStatus;
   }

   public Integer getIsExported() {
      return this.isExported;
   }

   public String getPlateGuid() {
      return this.plateGuid;
   }

   public String getPlateName() {
      return this.plateName;
   }

   public Long getNestNumber() {
      return this.nestNumber;
   }

   public String getNestName() {
      return this.nestName;
   }

   public BigDecimal getUnCutAmount() {
      return this.unCutAmount;
   }

   public BigDecimal getInCutAmount() {
      return this.inCutAmount;
   }

   public BigDecimal getFinishCutAmount() {
      return this.finishCutAmount;
   }

   public Integer getExtendStatus() {
      return this.extendStatus;
   }

   public String getGmid() {
      return this.gmid;
   }

   public String getNspfUrl() {
      return this.nspfUrl;
   }

   public String getThumbnailUrl() {
      return this.thumbnailUrl;
   }

   public Integer getIsPlaned() {
      return this.isPlaned;
   }

   public String getMachine() {
      return this.machine;
   }

   public String getMachineDesc() {
      return this.machineDesc;
   }

   public String getLastModifyTime() {
      return this.lastModifyTime;
   }

   public Integer getIsOpen() {
      return this.isOpen;
   }

   public String getLabelPrintTime() {
      return this.labelPrintTime;
   }

   public Integer getPlateCategory() {
      return this.plateCategory;
   }

   public void setJobId(final Integer jobId) {
      this.jobId = jobId;
   }

   public void setGuid(final String guid) {
      this.guid = guid;
   }

   public void setPortionID(final String portionID) {
      this.portionID = portionID;
   }

   public void setResultName(final String resultName) {
      this.resultName = resultName;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setGas(final String gas) {
      this.gas = gas;
   }

   public void setAmount(final Integer amount) {
      this.amount = amount;
   }

   public void setPartAmount(final Integer partAmount) {
      this.partAmount = partAmount;
   }

   public void setUtilization(final BigDecimal utilization) {
      this.utilization = utilization;
   }

   public void setPlateWidth(final BigDecimal plateWidth) {
      this.plateWidth = plateWidth;
   }

   public void setPlateHeight(final BigDecimal plateHeight) {
      this.plateHeight = plateHeight;
   }

   public void setNspfPath(final String nspfPath) {
      this.nspfPath = nspfPath;
   }

   public void setThumbnailPath(final String thumbnailPath) {
      this.thumbnailPath = thumbnailPath;
   }

   public void setPlanStatus(final String planStatus) {
      this.planStatus = planStatus;
   }

   public void setIsExported(final Integer isExported) {
      this.isExported = isExported;
   }

   public void setPlateGuid(final String plateGuid) {
      this.plateGuid = plateGuid;
   }

   public void setPlateName(final String plateName) {
      this.plateName = plateName;
   }

   public void setNestNumber(final Long nestNumber) {
      this.nestNumber = nestNumber;
   }

   public void setNestName(final String nestName) {
      this.nestName = nestName;
   }

   public void setUnCutAmount(final BigDecimal unCutAmount) {
      this.unCutAmount = unCutAmount;
   }

   public void setInCutAmount(final BigDecimal inCutAmount) {
      this.inCutAmount = inCutAmount;
   }

   public void setFinishCutAmount(final BigDecimal finishCutAmount) {
      this.finishCutAmount = finishCutAmount;
   }

   public void setExtendStatus(final Integer extendStatus) {
      this.extendStatus = extendStatus;
   }

   public void setGmid(final String gmid) {
      this.gmid = gmid;
   }

   public void setNspfUrl(final String nspfUrl) {
      this.nspfUrl = nspfUrl;
   }

   public void setThumbnailUrl(final String thumbnailUrl) {
      this.thumbnailUrl = thumbnailUrl;
   }

   public void setIsPlaned(final Integer isPlaned) {
      this.isPlaned = isPlaned;
   }

   public void setMachine(final String machine) {
      this.machine = machine;
   }

   public void setMachineDesc(final String machineDesc) {
      this.machineDesc = machineDesc;
   }

   public void setLastModifyTime(final String lastModifyTime) {
      this.lastModifyTime = lastModifyTime;
   }

   public void setIsOpen(final Integer isOpen) {
      this.isOpen = isOpen;
   }

   public void setLabelPrintTime(final String labelPrintTime) {
      this.labelPrintTime = labelPrintTime;
   }

   public void setPlateCategory(final Integer plateCategory) {
      this.plateCategory = plateCategory;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingBoChuSteelPlateByJobIdDTO)) {
         return false;
      }

      MesBuildingBoChuSteelPlateByJobIdDTO other = (MesBuildingBoChuSteelPlateByJobIdDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$jobId = this.getJobId();
      Object other$jobId = other.getJobId();
      if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
         Object this$amount = this.getAmount();
         Object other$amount = other.getAmount();
         if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
            Object this$partAmount = this.getPartAmount();
            Object other$partAmount = other.getPartAmount();
            if (this$partAmount == null ? other$partAmount == null : this$partAmount.equals(other$partAmount)) {
               Object this$isExported = this.getIsExported();
               Object other$isExported = other.getIsExported();
               if (this$isExported == null ? other$isExported == null : this$isExported.equals(other$isExported)) {
                  Object this$nestNumber = this.getNestNumber();
                  Object other$nestNumber = other.getNestNumber();
                  if (this$nestNumber == null ? other$nestNumber == null : this$nestNumber.equals(other$nestNumber)) {
                     Object this$extendStatus = this.getExtendStatus();
                     Object other$extendStatus = other.getExtendStatus();
                     if (this$extendStatus == null ? other$extendStatus == null : this$extendStatus.equals(other$extendStatus)) {
                        Object this$isPlaned = this.getIsPlaned();
                        Object other$isPlaned = other.getIsPlaned();
                        if (this$isPlaned == null ? other$isPlaned == null : this$isPlaned.equals(other$isPlaned)) {
                           Object this$isOpen = this.getIsOpen();
                           Object other$isOpen = other.getIsOpen();
                           if (this$isOpen == null ? other$isOpen == null : this$isOpen.equals(other$isOpen)) {
                              Object this$plateCategory = this.getPlateCategory();
                              Object other$plateCategory = other.getPlateCategory();
                              if (this$plateCategory == null ? other$plateCategory == null : this$plateCategory.equals(other$plateCategory)) {
                                 Object this$guid = this.getGuid();
                                 Object other$guid = other.getGuid();
                                 if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
                                    Object this$portionID = this.getPortionID();
                                    Object other$portionID = other.getPortionID();
                                    if (this$portionID == null ? other$portionID == null : this$portionID.equals(other$portionID)) {
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
                                                   Object this$utilization = this.getUtilization();
                                                   Object other$utilization = other.getUtilization();
                                                   if (this$utilization == null ? other$utilization == null : this$utilization.equals(other$utilization)) {
                                                      Object this$plateWidth = this.getPlateWidth();
                                                      Object other$plateWidth = other.getPlateWidth();
                                                      if (this$plateWidth == null ? other$plateWidth == null : this$plateWidth.equals(other$plateWidth)) {
                                                         Object this$plateHeight = this.getPlateHeight();
                                                         Object other$plateHeight = other.getPlateHeight();
                                                         if (this$plateHeight == null ? other$plateHeight == null : this$plateHeight.equals(other$plateHeight)) {
                                                            Object this$nspfPath = this.getNspfPath();
                                                            Object other$nspfPath = other.getNspfPath();
                                                            if (this$nspfPath == null ? other$nspfPath == null : this$nspfPath.equals(other$nspfPath)) {
                                                               Object this$thumbnailPath = this.getThumbnailPath();
                                                               Object other$thumbnailPath = other.getThumbnailPath();
                                                               if (this$thumbnailPath == null
                                                                  ? other$thumbnailPath == null
                                                                  : this$thumbnailPath.equals(other$thumbnailPath)) {
                                                                  Object this$planStatus = this.getPlanStatus();
                                                                  Object other$planStatus = other.getPlanStatus();
                                                                  if (this$planStatus == null
                                                                     ? other$planStatus == null
                                                                     : this$planStatus.equals(other$planStatus)) {
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
                                                                           Object this$nestName = this.getNestName();
                                                                           Object other$nestName = other.getNestName();
                                                                           if (this$nestName == null
                                                                              ? other$nestName == null
                                                                              : this$nestName.equals(other$nestName)) {
                                                                              Object this$unCutAmount = this.getUnCutAmount();
                                                                              Object other$unCutAmount = other.getUnCutAmount();
                                                                              if (this$unCutAmount == null
                                                                                 ? other$unCutAmount == null
                                                                                 : this$unCutAmount.equals(other$unCutAmount)) {
                                                                                 Object this$inCutAmount = this.getInCutAmount();
                                                                                 Object other$inCutAmount = other.getInCutAmount();
                                                                                 if (this$inCutAmount == null
                                                                                    ? other$inCutAmount == null
                                                                                    : this$inCutAmount.equals(other$inCutAmount)) {
                                                                                    Object this$finishCutAmount = this.getFinishCutAmount();
                                                                                    Object other$finishCutAmount = other.getFinishCutAmount();
                                                                                    if (this$finishCutAmount == null
                                                                                       ? other$finishCutAmount == null
                                                                                       : this$finishCutAmount.equals(other$finishCutAmount)) {
                                                                                       Object this$gmid = this.getGmid();
                                                                                       Object other$gmid = other.getGmid();
                                                                                       if (this$gmid == null
                                                                                          ? other$gmid == null
                                                                                          : this$gmid.equals(other$gmid)) {
                                                                                          Object this$nspfUrl = this.getNspfUrl();
                                                                                          Object other$nspfUrl = other.getNspfUrl();
                                                                                          if (this$nspfUrl == null
                                                                                             ? other$nspfUrl == null
                                                                                             : this$nspfUrl.equals(other$nspfUrl)) {
                                                                                             Object this$thumbnailUrl = this.getThumbnailUrl();
                                                                                             Object other$thumbnailUrl = other.getThumbnailUrl();
                                                                                             if (this$thumbnailUrl == null
                                                                                                ? other$thumbnailUrl == null
                                                                                                : this$thumbnailUrl.equals(other$thumbnailUrl)) {
                                                                                                Object this$machine = this.getMachine();
                                                                                                Object other$machine = other.getMachine();
                                                                                                if (this$machine == null
                                                                                                   ? other$machine == null
                                                                                                   : this$machine.equals(other$machine)) {
                                                                                                   Object this$machineDesc = this.getMachineDesc();
                                                                                                   Object other$machineDesc = other.getMachineDesc();
                                                                                                   if (this$machineDesc == null
                                                                                                      ? other$machineDesc == null
                                                                                                      : this$machineDesc.equals(other$machineDesc)) {
                                                                                                      Object this$lastModifyTime = this.getLastModifyTime();
                                                                                                      Object other$lastModifyTime = other.getLastModifyTime();
                                                                                                      if (this$lastModifyTime == null
                                                                                                         ? other$lastModifyTime == null
                                                                                                         : this$lastModifyTime.equals(other$lastModifyTime)) {
                                                                                                         Object this$labelPrintTime = this.getLabelPrintTime();
                                                                                                         Object other$labelPrintTime = other.getLabelPrintTime();
                                                                                                         return this$labelPrintTime == null
                                                                                                            ? other$labelPrintTime == null
                                                                                                            : this$labelPrintTime.equals(other$labelPrintTime);
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
      return other instanceof MesBuildingBoChuSteelPlateByJobIdDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $partAmount = this.getPartAmount();
      result = result * 59 + ($partAmount == null ? 43 : $partAmount.hashCode());
      Object $isExported = this.getIsExported();
      result = result * 59 + ($isExported == null ? 43 : $isExported.hashCode());
      Object $nestNumber = this.getNestNumber();
      result = result * 59 + ($nestNumber == null ? 43 : $nestNumber.hashCode());
      Object $extendStatus = this.getExtendStatus();
      result = result * 59 + ($extendStatus == null ? 43 : $extendStatus.hashCode());
      Object $isPlaned = this.getIsPlaned();
      result = result * 59 + ($isPlaned == null ? 43 : $isPlaned.hashCode());
      Object $isOpen = this.getIsOpen();
      result = result * 59 + ($isOpen == null ? 43 : $isOpen.hashCode());
      Object $plateCategory = this.getPlateCategory();
      result = result * 59 + ($plateCategory == null ? 43 : $plateCategory.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $portionID = this.getPortionID();
      result = result * 59 + ($portionID == null ? 43 : $portionID.hashCode());
      Object $resultName = this.getResultName();
      result = result * 59 + ($resultName == null ? 43 : $resultName.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $gas = this.getGas();
      result = result * 59 + ($gas == null ? 43 : $gas.hashCode());
      Object $utilization = this.getUtilization();
      result = result * 59 + ($utilization == null ? 43 : $utilization.hashCode());
      Object $plateWidth = this.getPlateWidth();
      result = result * 59 + ($plateWidth == null ? 43 : $plateWidth.hashCode());
      Object $plateHeight = this.getPlateHeight();
      result = result * 59 + ($plateHeight == null ? 43 : $plateHeight.hashCode());
      Object $nspfPath = this.getNspfPath();
      result = result * 59 + ($nspfPath == null ? 43 : $nspfPath.hashCode());
      Object $thumbnailPath = this.getThumbnailPath();
      result = result * 59 + ($thumbnailPath == null ? 43 : $thumbnailPath.hashCode());
      Object $planStatus = this.getPlanStatus();
      result = result * 59 + ($planStatus == null ? 43 : $planStatus.hashCode());
      Object $plateGuid = this.getPlateGuid();
      result = result * 59 + ($plateGuid == null ? 43 : $plateGuid.hashCode());
      Object $plateName = this.getPlateName();
      result = result * 59 + ($plateName == null ? 43 : $plateName.hashCode());
      Object $nestName = this.getNestName();
      result = result * 59 + ($nestName == null ? 43 : $nestName.hashCode());
      Object $unCutAmount = this.getUnCutAmount();
      result = result * 59 + ($unCutAmount == null ? 43 : $unCutAmount.hashCode());
      Object $inCutAmount = this.getInCutAmount();
      result = result * 59 + ($inCutAmount == null ? 43 : $inCutAmount.hashCode());
      Object $finishCutAmount = this.getFinishCutAmount();
      result = result * 59 + ($finishCutAmount == null ? 43 : $finishCutAmount.hashCode());
      Object $gmid = this.getGmid();
      result = result * 59 + ($gmid == null ? 43 : $gmid.hashCode());
      Object $nspfUrl = this.getNspfUrl();
      result = result * 59 + ($nspfUrl == null ? 43 : $nspfUrl.hashCode());
      Object $thumbnailUrl = this.getThumbnailUrl();
      result = result * 59 + ($thumbnailUrl == null ? 43 : $thumbnailUrl.hashCode());
      Object $machine = this.getMachine();
      result = result * 59 + ($machine == null ? 43 : $machine.hashCode());
      Object $machineDesc = this.getMachineDesc();
      result = result * 59 + ($machineDesc == null ? 43 : $machineDesc.hashCode());
      Object $lastModifyTime = this.getLastModifyTime();
      result = result * 59 + ($lastModifyTime == null ? 43 : $lastModifyTime.hashCode());
      Object $labelPrintTime = this.getLabelPrintTime();
      return result * 59 + ($labelPrintTime == null ? 43 : $labelPrintTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingBoChuSteelPlateByJobIdDTO(jobId="
         + this.getJobId()
         + ", guid="
         + this.getGuid()
         + ", portionID="
         + this.getPortionID()
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
         + ", partAmount="
         + this.getPartAmount()
         + ", utilization="
         + this.getUtilization()
         + ", plateWidth="
         + this.getPlateWidth()
         + ", plateHeight="
         + this.getPlateHeight()
         + ", nspfPath="
         + this.getNspfPath()
         + ", thumbnailPath="
         + this.getThumbnailPath()
         + ", planStatus="
         + this.getPlanStatus()
         + ", isExported="
         + this.getIsExported()
         + ", plateGuid="
         + this.getPlateGuid()
         + ", plateName="
         + this.getPlateName()
         + ", nestNumber="
         + this.getNestNumber()
         + ", nestName="
         + this.getNestName()
         + ", unCutAmount="
         + this.getUnCutAmount()
         + ", inCutAmount="
         + this.getInCutAmount()
         + ", finishCutAmount="
         + this.getFinishCutAmount()
         + ", extendStatus="
         + this.getExtendStatus()
         + ", gmid="
         + this.getGmid()
         + ", nspfUrl="
         + this.getNspfUrl()
         + ", thumbnailUrl="
         + this.getThumbnailUrl()
         + ", isPlaned="
         + this.getIsPlaned()
         + ", machine="
         + this.getMachine()
         + ", machineDesc="
         + this.getMachineDesc()
         + ", lastModifyTime="
         + this.getLastModifyTime()
         + ", isOpen="
         + this.getIsOpen()
         + ", labelPrintTime="
         + this.getLabelPrintTime()
         + ", plateCategory="
         + this.getPlateCategory()
         + ")";
   }
}
