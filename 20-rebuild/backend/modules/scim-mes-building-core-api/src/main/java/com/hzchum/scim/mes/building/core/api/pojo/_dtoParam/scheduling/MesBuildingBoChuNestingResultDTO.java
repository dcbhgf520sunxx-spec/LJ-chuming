package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingBoChuNestingResultDTO", description = "零件套料排版查询")
public class MesBuildingBoChuNestingResultDTO {
   private String guid;
   private String portionID;
   private String resultName;
   private String material;
   private double thickness;
   private String gas;
   private int amount;
   private int partAmount;
   private double utilization;
   private double plateWidth;
   private double plateHeight;
   private String nspfPath;
   private String thumbnailPath;
   private String planStatus;
   private int isExported;
   private String plateGuid;
   private String plateName;
   private long nestNumber;
   private String nestName;
   private double inCutAmount;
   private double finishCutAmount;
   private int extendStatus;
   private String gmid;
   private String nspfUrl;
   private String thumbnailUrl;
   private int isPlaned;
   private double unCutAmount;
   private String machine;
   private String machineDesc;
   private String lastModifyTime;
   private int isOpen;
   private String labelPrintTime;
   private Integer jobId;

   public static MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder builder() {
      return new MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder();
   }

   public MesBuildingBoChuNestingResultDTO(
      final String guid,
      final String portionID,
      final String resultName,
      final String material,
      final double thickness,
      final String gas,
      final int amount,
      final int partAmount,
      final double utilization,
      final double plateWidth,
      final double plateHeight,
      final String nspfPath,
      final String thumbnailPath,
      final String planStatus,
      final int isExported,
      final String plateGuid,
      final String plateName,
      final long nestNumber,
      final String nestName,
      final double inCutAmount,
      final double finishCutAmount,
      final int extendStatus,
      final String gmid,
      final String nspfUrl,
      final String thumbnailUrl,
      final int isPlaned,
      final double unCutAmount,
      final String machine,
      final String machineDesc,
      final String lastModifyTime,
      final int isOpen,
      final String labelPrintTime,
      final Integer jobId
   ) {
      this.guid = guid;
      this.portionID = portionID;
      this.resultName = resultName;
      this.material = material;
      this.thickness = thickness;
      this.gas = gas;
      this.amount = amount;
      this.partAmount = partAmount;
      this.utilization = utilization;
      this.plateWidth = plateWidth;
      this.plateHeight = plateHeight;
      this.nspfPath = nspfPath;
      this.thumbnailPath = thumbnailPath;
      this.planStatus = planStatus;
      this.isExported = isExported;
      this.plateGuid = plateGuid;
      this.plateName = plateName;
      this.nestNumber = nestNumber;
      this.nestName = nestName;
      this.inCutAmount = inCutAmount;
      this.finishCutAmount = finishCutAmount;
      this.extendStatus = extendStatus;
      this.gmid = gmid;
      this.nspfUrl = nspfUrl;
      this.thumbnailUrl = thumbnailUrl;
      this.isPlaned = isPlaned;
      this.unCutAmount = unCutAmount;
      this.machine = machine;
      this.machineDesc = machineDesc;
      this.lastModifyTime = lastModifyTime;
      this.isOpen = isOpen;
      this.labelPrintTime = labelPrintTime;
      this.jobId = jobId;
   }

   public MesBuildingBoChuNestingResultDTO() {
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

   public double getThickness() {
      return this.thickness;
   }

   public String getGas() {
      return this.gas;
   }

   public int getAmount() {
      return this.amount;
   }

   public int getPartAmount() {
      return this.partAmount;
   }

   public double getUtilization() {
      return this.utilization;
   }

   public double getPlateWidth() {
      return this.plateWidth;
   }

   public double getPlateHeight() {
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

   public int getIsExported() {
      return this.isExported;
   }

   public String getPlateGuid() {
      return this.plateGuid;
   }

   public String getPlateName() {
      return this.plateName;
   }

   public long getNestNumber() {
      return this.nestNumber;
   }

   public String getNestName() {
      return this.nestName;
   }

   public double getInCutAmount() {
      return this.inCutAmount;
   }

   public double getFinishCutAmount() {
      return this.finishCutAmount;
   }

   public int getExtendStatus() {
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

   public int getIsPlaned() {
      return this.isPlaned;
   }

   public double getUnCutAmount() {
      return this.unCutAmount;
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

   public int getIsOpen() {
      return this.isOpen;
   }

   public String getLabelPrintTime() {
      return this.labelPrintTime;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public MesBuildingBoChuNestingResultDTO setGuid(final String guid) {
      this.guid = guid;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setPortionID(final String portionID) {
      this.portionID = portionID;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setResultName(final String resultName) {
      this.resultName = resultName;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setThickness(final double thickness) {
      this.thickness = thickness;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setGas(final String gas) {
      this.gas = gas;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setAmount(final int amount) {
      this.amount = amount;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setPartAmount(final int partAmount) {
      this.partAmount = partAmount;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setUtilization(final double utilization) {
      this.utilization = utilization;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setPlateWidth(final double plateWidth) {
      this.plateWidth = plateWidth;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setPlateHeight(final double plateHeight) {
      this.plateHeight = plateHeight;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setNspfPath(final String nspfPath) {
      this.nspfPath = nspfPath;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setThumbnailPath(final String thumbnailPath) {
      this.thumbnailPath = thumbnailPath;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setPlanStatus(final String planStatus) {
      this.planStatus = planStatus;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setIsExported(final int isExported) {
      this.isExported = isExported;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setPlateGuid(final String plateGuid) {
      this.plateGuid = plateGuid;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setPlateName(final String plateName) {
      this.plateName = plateName;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setNestNumber(final long nestNumber) {
      this.nestNumber = nestNumber;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setNestName(final String nestName) {
      this.nestName = nestName;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setInCutAmount(final double inCutAmount) {
      this.inCutAmount = inCutAmount;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setFinishCutAmount(final double finishCutAmount) {
      this.finishCutAmount = finishCutAmount;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setExtendStatus(final int extendStatus) {
      this.extendStatus = extendStatus;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setGmid(final String gmid) {
      this.gmid = gmid;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setNspfUrl(final String nspfUrl) {
      this.nspfUrl = nspfUrl;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setThumbnailUrl(final String thumbnailUrl) {
      this.thumbnailUrl = thumbnailUrl;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setIsPlaned(final int isPlaned) {
      this.isPlaned = isPlaned;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setUnCutAmount(final double unCutAmount) {
      this.unCutAmount = unCutAmount;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setMachine(final String machine) {
      this.machine = machine;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setMachineDesc(final String machineDesc) {
      this.machineDesc = machineDesc;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setLastModifyTime(final String lastModifyTime) {
      this.lastModifyTime = lastModifyTime;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setIsOpen(final int isOpen) {
      this.isOpen = isOpen;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setLabelPrintTime(final String labelPrintTime) {
      this.labelPrintTime = labelPrintTime;
      return this;
   }

   public MesBuildingBoChuNestingResultDTO setJobId(final Integer jobId) {
      this.jobId = jobId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingBoChuNestingResultDTO(guid="
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
         + ", unCutAmount="
         + this.getUnCutAmount()
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
         + ", jobId="
         + this.getJobId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingBoChuNestingResultDTO)) {
         return false;
      }

      MesBuildingBoChuNestingResultDTO other = (MesBuildingBoChuNestingResultDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (Double.compare(this.getThickness(), other.getThickness()) != 0) {
         return false;
      }

      if (this.getAmount() != other.getAmount()) {
         return false;
      }

      if (this.getPartAmount() != other.getPartAmount()) {
         return false;
      }

      if (Double.compare(this.getUtilization(), other.getUtilization()) != 0) {
         return false;
      }

      if (Double.compare(this.getPlateWidth(), other.getPlateWidth()) != 0) {
         return false;
      }

      if (Double.compare(this.getPlateHeight(), other.getPlateHeight()) != 0) {
         return false;
      }

      if (this.getIsExported() != other.getIsExported()) {
         return false;
      }

      if (this.getNestNumber() != other.getNestNumber()) {
         return false;
      }

      if (Double.compare(this.getInCutAmount(), other.getInCutAmount()) != 0) {
         return false;
      }

      if (Double.compare(this.getFinishCutAmount(), other.getFinishCutAmount()) != 0) {
         return false;
      }

      if (this.getExtendStatus() != other.getExtendStatus()) {
         return false;
      }

      if (this.getIsPlaned() != other.getIsPlaned()) {
         return false;
      }

      if (Double.compare(this.getUnCutAmount(), other.getUnCutAmount()) != 0) {
         return false;
      }

      if (this.getIsOpen() != other.getIsOpen()) {
         return false;
      }

      Object this$jobId = this.getJobId();
      Object other$jobId = other.getJobId();
      if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
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
                     Object this$gas = this.getGas();
                     Object other$gas = other.getGas();
                     if (this$gas == null ? other$gas == null : this$gas.equals(other$gas)) {
                        Object this$nspfPath = this.getNspfPath();
                        Object other$nspfPath = other.getNspfPath();
                        if (this$nspfPath == null ? other$nspfPath == null : this$nspfPath.equals(other$nspfPath)) {
                           Object this$thumbnailPath = this.getThumbnailPath();
                           Object other$thumbnailPath = other.getThumbnailPath();
                           if (this$thumbnailPath == null ? other$thumbnailPath == null : this$thumbnailPath.equals(other$thumbnailPath)) {
                              Object this$planStatus = this.getPlanStatus();
                              Object other$planStatus = other.getPlanStatus();
                              if (this$planStatus == null ? other$planStatus == null : this$planStatus.equals(other$planStatus)) {
                                 Object this$plateGuid = this.getPlateGuid();
                                 Object other$plateGuid = other.getPlateGuid();
                                 if (this$plateGuid == null ? other$plateGuid == null : this$plateGuid.equals(other$plateGuid)) {
                                    Object this$plateName = this.getPlateName();
                                    Object other$plateName = other.getPlateName();
                                    if (this$plateName == null ? other$plateName == null : this$plateName.equals(other$plateName)) {
                                       Object this$nestName = this.getNestName();
                                       Object other$nestName = other.getNestName();
                                       if (this$nestName == null ? other$nestName == null : this$nestName.equals(other$nestName)) {
                                          Object this$gmid = this.getGmid();
                                          Object other$gmid = other.getGmid();
                                          if (this$gmid == null ? other$gmid == null : this$gmid.equals(other$gmid)) {
                                             Object this$nspfUrl = this.getNspfUrl();
                                             Object other$nspfUrl = other.getNspfUrl();
                                             if (this$nspfUrl == null ? other$nspfUrl == null : this$nspfUrl.equals(other$nspfUrl)) {
                                                Object this$thumbnailUrl = this.getThumbnailUrl();
                                                Object other$thumbnailUrl = other.getThumbnailUrl();
                                                if (this$thumbnailUrl == null ? other$thumbnailUrl == null : this$thumbnailUrl.equals(other$thumbnailUrl)) {
                                                   Object this$machine = this.getMachine();
                                                   Object other$machine = other.getMachine();
                                                   if (this$machine == null ? other$machine == null : this$machine.equals(other$machine)) {
                                                      Object this$machineDesc = this.getMachineDesc();
                                                      Object other$machineDesc = other.getMachineDesc();
                                                      if (this$machineDesc == null ? other$machineDesc == null : this$machineDesc.equals(other$machineDesc)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingBoChuNestingResultDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $thickness = Double.doubleToLongBits(this.getThickness());
      result = result * 59 + (int)($thickness >>> 32 ^ $thickness);
      result = result * 59 + this.getAmount();
      result = result * 59 + this.getPartAmount();
      long $utilization = Double.doubleToLongBits(this.getUtilization());
      result = result * 59 + (int)($utilization >>> 32 ^ $utilization);
      long $plateWidth = Double.doubleToLongBits(this.getPlateWidth());
      result = result * 59 + (int)($plateWidth >>> 32 ^ $plateWidth);
      long $plateHeight = Double.doubleToLongBits(this.getPlateHeight());
      result = result * 59 + (int)($plateHeight >>> 32 ^ $plateHeight);
      result = result * 59 + this.getIsExported();
      long $nestNumber = this.getNestNumber();
      result = result * 59 + (int)($nestNumber >>> 32 ^ $nestNumber);
      long $inCutAmount = Double.doubleToLongBits(this.getInCutAmount());
      result = result * 59 + (int)($inCutAmount >>> 32 ^ $inCutAmount);
      long $finishCutAmount = Double.doubleToLongBits(this.getFinishCutAmount());
      result = result * 59 + (int)($finishCutAmount >>> 32 ^ $finishCutAmount);
      result = result * 59 + this.getExtendStatus();
      result = result * 59 + this.getIsPlaned();
      long $unCutAmount = Double.doubleToLongBits(this.getUnCutAmount());
      result = result * 59 + (int)($unCutAmount >>> 32 ^ $unCutAmount);
      result = result * 59 + this.getIsOpen();
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $portionID = this.getPortionID();
      result = result * 59 + ($portionID == null ? 43 : $portionID.hashCode());
      Object $resultName = this.getResultName();
      result = result * 59 + ($resultName == null ? 43 : $resultName.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $gas = this.getGas();
      result = result * 59 + ($gas == null ? 43 : $gas.hashCode());
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

   public static class MesBuildingBoChuNestingResultDTOBuilder {
      private String guid;
      private String portionID;
      private String resultName;
      private String material;
      private double thickness;
      private String gas;
      private int amount;
      private int partAmount;
      private double utilization;
      private double plateWidth;
      private double plateHeight;
      private String nspfPath;
      private String thumbnailPath;
      private String planStatus;
      private int isExported;
      private String plateGuid;
      private String plateName;
      private long nestNumber;
      private String nestName;
      private double inCutAmount;
      private double finishCutAmount;
      private int extendStatus;
      private String gmid;
      private String nspfUrl;
      private String thumbnailUrl;
      private int isPlaned;
      private double unCutAmount;
      private String machine;
      private String machineDesc;
      private String lastModifyTime;
      private int isOpen;
      private String labelPrintTime;
      private Integer jobId;

      MesBuildingBoChuNestingResultDTOBuilder() {
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder portionID(final String portionID) {
         this.portionID = portionID;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder resultName(final String resultName) {
         this.resultName = resultName;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder thickness(final double thickness) {
         this.thickness = thickness;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder gas(final String gas) {
         this.gas = gas;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder amount(final int amount) {
         this.amount = amount;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder partAmount(final int partAmount) {
         this.partAmount = partAmount;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder utilization(final double utilization) {
         this.utilization = utilization;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder plateWidth(final double plateWidth) {
         this.plateWidth = plateWidth;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder plateHeight(final double plateHeight) {
         this.plateHeight = plateHeight;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder nspfPath(final String nspfPath) {
         this.nspfPath = nspfPath;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder thumbnailPath(final String thumbnailPath) {
         this.thumbnailPath = thumbnailPath;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder planStatus(final String planStatus) {
         this.planStatus = planStatus;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder isExported(final int isExported) {
         this.isExported = isExported;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder plateGuid(final String plateGuid) {
         this.plateGuid = plateGuid;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder plateName(final String plateName) {
         this.plateName = plateName;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder nestNumber(final long nestNumber) {
         this.nestNumber = nestNumber;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder nestName(final String nestName) {
         this.nestName = nestName;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder inCutAmount(final double inCutAmount) {
         this.inCutAmount = inCutAmount;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder finishCutAmount(final double finishCutAmount) {
         this.finishCutAmount = finishCutAmount;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder extendStatus(final int extendStatus) {
         this.extendStatus = extendStatus;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder gmid(final String gmid) {
         this.gmid = gmid;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder nspfUrl(final String nspfUrl) {
         this.nspfUrl = nspfUrl;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder thumbnailUrl(final String thumbnailUrl) {
         this.thumbnailUrl = thumbnailUrl;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder isPlaned(final int isPlaned) {
         this.isPlaned = isPlaned;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder unCutAmount(final double unCutAmount) {
         this.unCutAmount = unCutAmount;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder machine(final String machine) {
         this.machine = machine;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder machineDesc(final String machineDesc) {
         this.machineDesc = machineDesc;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder lastModifyTime(final String lastModifyTime) {
         this.lastModifyTime = lastModifyTime;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder isOpen(final int isOpen) {
         this.isOpen = isOpen;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder labelPrintTime(final String labelPrintTime) {
         this.labelPrintTime = labelPrintTime;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      public MesBuildingBoChuNestingResultDTO build() {
         return new MesBuildingBoChuNestingResultDTO(
            this.guid,
            this.portionID,
            this.resultName,
            this.material,
            this.thickness,
            this.gas,
            this.amount,
            this.partAmount,
            this.utilization,
            this.plateWidth,
            this.plateHeight,
            this.nspfPath,
            this.thumbnailPath,
            this.planStatus,
            this.isExported,
            this.plateGuid,
            this.plateName,
            this.nestNumber,
            this.nestName,
            this.inCutAmount,
            this.finishCutAmount,
            this.extendStatus,
            this.gmid,
            this.nspfUrl,
            this.thumbnailUrl,
            this.isPlaned,
            this.unCutAmount,
            this.machine,
            this.machineDesc,
            this.lastModifyTime,
            this.isOpen,
            this.labelPrintTime,
            this.jobId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingBoChuNestingResultDTO.MesBuildingBoChuNestingResultDTOBuilder(guid="
            + this.guid
            + ", portionID="
            + this.portionID
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
            + ", partAmount="
            + this.partAmount
            + ", utilization="
            + this.utilization
            + ", plateWidth="
            + this.plateWidth
            + ", plateHeight="
            + this.plateHeight
            + ", nspfPath="
            + this.nspfPath
            + ", thumbnailPath="
            + this.thumbnailPath
            + ", planStatus="
            + this.planStatus
            + ", isExported="
            + this.isExported
            + ", plateGuid="
            + this.plateGuid
            + ", plateName="
            + this.plateName
            + ", nestNumber="
            + this.nestNumber
            + ", nestName="
            + this.nestName
            + ", inCutAmount="
            + this.inCutAmount
            + ", finishCutAmount="
            + this.finishCutAmount
            + ", extendStatus="
            + this.extendStatus
            + ", gmid="
            + this.gmid
            + ", nspfUrl="
            + this.nspfUrl
            + ", thumbnailUrl="
            + this.thumbnailUrl
            + ", isPlaned="
            + this.isPlaned
            + ", unCutAmount="
            + this.unCutAmount
            + ", machine="
            + this.machine
            + ", machineDesc="
            + this.machineDesc
            + ", lastModifyTime="
            + this.lastModifyTime
            + ", isOpen="
            + this.isOpen
            + ", labelPrintTime="
            + this.labelPrintTime
            + ", jobId="
            + this.jobId
            + ")";
      }
   }
}
