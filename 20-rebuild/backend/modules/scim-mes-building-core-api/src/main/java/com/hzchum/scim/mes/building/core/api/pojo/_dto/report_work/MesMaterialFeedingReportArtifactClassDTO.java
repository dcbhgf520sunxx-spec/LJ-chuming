package com.hzchum.scim.mes.building.core.api.pojo._dto.report_work;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("投料填报构件类别DTO")
public class MesMaterialFeedingReportArtifactClassDTO {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("单体名称")
   private String monomerName;
   @ApiModelProperty("批次id")
   private Long areaBatchId;
   @ApiModelProperty("批次名称")
   private String areaBatchName;
   @ApiModelProperty("构件类别")
   private String structureType;
   @ApiModelProperty("总净重(㎏)")
   private BigDecimal totalNetWeight;
   @ApiModelProperty("总毛重(㎏)")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty("累计投料量(吨)")
   private BigDecimal cumulativeFeedingQuantity;
   @ApiModelProperty("投料量(㎏)")
   private BigDecimal feedingQuantity;
   @ApiModelProperty("车间id")
   private Long workshopId;
   @ApiModelProperty("车间名称")
   private String workshopName;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public String getAreaBatchName() {
      return this.areaBatchName;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getCumulativeFeedingQuantity() {
      return this.cumulativeFeedingQuantity;
   }

   public BigDecimal getFeedingQuantity() {
      return this.feedingQuantity;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
   }

   public void setAreaBatchName(final String areaBatchName) {
      this.areaBatchName = areaBatchName;
   }

   public void setStructureType(final String structureType) {
      this.structureType = structureType;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setCumulativeFeedingQuantity(final BigDecimal cumulativeFeedingQuantity) {
      this.cumulativeFeedingQuantity = cumulativeFeedingQuantity;
   }

   public void setFeedingQuantity(final BigDecimal feedingQuantity) {
      this.feedingQuantity = feedingQuantity;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesMaterialFeedingReportArtifactClassDTO)) {
         return false;
      }

      MesMaterialFeedingReportArtifactClassDTO other = (MesMaterialFeedingReportArtifactClassDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaBatchId = this.getAreaBatchId();
            Object other$areaBatchId = other.getAreaBatchId();
            if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$monomerName = this.getMonomerName();
                  Object other$monomerName = other.getMonomerName();
                  if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                     Object this$areaBatchName = this.getAreaBatchName();
                     Object other$areaBatchName = other.getAreaBatchName();
                     if (this$areaBatchName == null ? other$areaBatchName == null : this$areaBatchName.equals(other$areaBatchName)) {
                        Object this$structureType = this.getStructureType();
                        Object other$structureType = other.getStructureType();
                        if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                           Object this$totalNetWeight = this.getTotalNetWeight();
                           Object other$totalNetWeight = other.getTotalNetWeight();
                           if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                              Object this$totalGrossWeight = this.getTotalGrossWeight();
                              Object other$totalGrossWeight = other.getTotalGrossWeight();
                              if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                 Object this$cumulativeFeedingQuantity = this.getCumulativeFeedingQuantity();
                                 Object other$cumulativeFeedingQuantity = other.getCumulativeFeedingQuantity();
                                 if (this$cumulativeFeedingQuantity == null
                                    ? other$cumulativeFeedingQuantity == null
                                    : this$cumulativeFeedingQuantity.equals(other$cumulativeFeedingQuantity)) {
                                    Object this$feedingQuantity = this.getFeedingQuantity();
                                    Object other$feedingQuantity = other.getFeedingQuantity();
                                    if (this$feedingQuantity == null ? other$feedingQuantity == null : this$feedingQuantity.equals(other$feedingQuantity)) {
                                       Object this$workshopName = this.getWorkshopName();
                                       Object other$workshopName = other.getWorkshopName();
                                       return this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName);
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
      return other instanceof MesMaterialFeedingReportArtifactClassDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaBatchName = this.getAreaBatchName();
      result = result * 59 + ($areaBatchName == null ? 43 : $areaBatchName.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $cumulativeFeedingQuantity = this.getCumulativeFeedingQuantity();
      result = result * 59 + ($cumulativeFeedingQuantity == null ? 43 : $cumulativeFeedingQuantity.hashCode());
      Object $feedingQuantity = this.getFeedingQuantity();
      result = result * 59 + ($feedingQuantity == null ? 43 : $feedingQuantity.hashCode());
      Object $workshopName = this.getWorkshopName();
      return result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
   }

   @Override
   public String toString() {
      return "MesMaterialFeedingReportArtifactClassDTO(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", areaBatchName="
         + this.getAreaBatchName()
         + ", structureType="
         + this.getStructureType()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", cumulativeFeedingQuantity="
         + this.getCumulativeFeedingQuantity()
         + ", feedingQuantity="
         + this.getFeedingQuantity()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ")";
   }
}
