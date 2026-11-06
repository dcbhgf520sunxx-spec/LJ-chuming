package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import io.swagger.annotations.ApiModelProperty;

public class ArtifactCompleteDTO {
   @ApiModelProperty("构件编号")
   private String serialNumber;
   @ApiModelProperty("数量")
   private Integer artifactQuantity;
   @ApiModelProperty("零件板生产量")
   private Integer partBoardProductionQuantity;
   @ApiModelProperty("零件板需要量")
   private Integer partBoardNeedQuantity;
   @ApiModelProperty("翼腹板生产量")
   private Integer wingBoardProductionQuantity;
   @ApiModelProperty("翼腹板需要量")
   private Integer wingBoardNeedQuantity;
   @ApiModelProperty("部件生产量")
   private Integer partProductionQuantity;
   @ApiModelProperty("部件需要量")
   private Integer partNeedQuantity;
   @ApiModelProperty("齐套数量")
   private Integer completeQuantity;
   @ApiModelProperty("状态 1齐套 2部分齐套 3未齐套")
   private String status;

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getArtifactQuantity() {
      return this.artifactQuantity;
   }

   public Integer getPartBoardProductionQuantity() {
      return this.partBoardProductionQuantity;
   }

   public Integer getPartBoardNeedQuantity() {
      return this.partBoardNeedQuantity;
   }

   public Integer getWingBoardProductionQuantity() {
      return this.wingBoardProductionQuantity;
   }

   public Integer getWingBoardNeedQuantity() {
      return this.wingBoardNeedQuantity;
   }

   public Integer getPartProductionQuantity() {
      return this.partProductionQuantity;
   }

   public Integer getPartNeedQuantity() {
      return this.partNeedQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public String getStatus() {
      return this.status;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setArtifactQuantity(final Integer artifactQuantity) {
      this.artifactQuantity = artifactQuantity;
   }

   public void setPartBoardProductionQuantity(final Integer partBoardProductionQuantity) {
      this.partBoardProductionQuantity = partBoardProductionQuantity;
   }

   public void setPartBoardNeedQuantity(final Integer partBoardNeedQuantity) {
      this.partBoardNeedQuantity = partBoardNeedQuantity;
   }

   public void setWingBoardProductionQuantity(final Integer wingBoardProductionQuantity) {
      this.wingBoardProductionQuantity = wingBoardProductionQuantity;
   }

   public void setWingBoardNeedQuantity(final Integer wingBoardNeedQuantity) {
      this.wingBoardNeedQuantity = wingBoardNeedQuantity;
   }

   public void setPartProductionQuantity(final Integer partProductionQuantity) {
      this.partProductionQuantity = partProductionQuantity;
   }

   public void setPartNeedQuantity(final Integer partNeedQuantity) {
      this.partNeedQuantity = partNeedQuantity;
   }

   public void setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   public void setStatus(final String status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactCompleteDTO)) {
         return false;
      }

      ArtifactCompleteDTO other = (ArtifactCompleteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactQuantity = this.getArtifactQuantity();
      Object other$artifactQuantity = other.getArtifactQuantity();
      if (this$artifactQuantity == null ? other$artifactQuantity == null : this$artifactQuantity.equals(other$artifactQuantity)) {
         Object this$partBoardProductionQuantity = this.getPartBoardProductionQuantity();
         Object other$partBoardProductionQuantity = other.getPartBoardProductionQuantity();
         if (this$partBoardProductionQuantity == null
            ? other$partBoardProductionQuantity == null
            : this$partBoardProductionQuantity.equals(other$partBoardProductionQuantity)) {
            Object this$partBoardNeedQuantity = this.getPartBoardNeedQuantity();
            Object other$partBoardNeedQuantity = other.getPartBoardNeedQuantity();
            if (this$partBoardNeedQuantity == null ? other$partBoardNeedQuantity == null : this$partBoardNeedQuantity.equals(other$partBoardNeedQuantity)) {
               Object this$wingBoardProductionQuantity = this.getWingBoardProductionQuantity();
               Object other$wingBoardProductionQuantity = other.getWingBoardProductionQuantity();
               if (this$wingBoardProductionQuantity == null
                  ? other$wingBoardProductionQuantity == null
                  : this$wingBoardProductionQuantity.equals(other$wingBoardProductionQuantity)) {
                  Object this$wingBoardNeedQuantity = this.getWingBoardNeedQuantity();
                  Object other$wingBoardNeedQuantity = other.getWingBoardNeedQuantity();
                  if (this$wingBoardNeedQuantity == null ? other$wingBoardNeedQuantity == null : this$wingBoardNeedQuantity.equals(other$wingBoardNeedQuantity)
                     )
                   {
                     Object this$partProductionQuantity = this.getPartProductionQuantity();
                     Object other$partProductionQuantity = other.getPartProductionQuantity();
                     if (this$partProductionQuantity == null
                        ? other$partProductionQuantity == null
                        : this$partProductionQuantity.equals(other$partProductionQuantity)) {
                        Object this$partNeedQuantity = this.getPartNeedQuantity();
                        Object other$partNeedQuantity = other.getPartNeedQuantity();
                        if (this$partNeedQuantity == null ? other$partNeedQuantity == null : this$partNeedQuantity.equals(other$partNeedQuantity)) {
                           Object this$completeQuantity = this.getCompleteQuantity();
                           Object other$completeQuantity = other.getCompleteQuantity();
                           if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$status = this.getStatus();
                                 Object other$status = other.getStatus();
                                 return this$status == null ? other$status == null : this$status.equals(other$status);
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
      return other instanceof ArtifactCompleteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactQuantity = this.getArtifactQuantity();
      result = result * 59 + ($artifactQuantity == null ? 43 : $artifactQuantity.hashCode());
      Object $partBoardProductionQuantity = this.getPartBoardProductionQuantity();
      result = result * 59 + ($partBoardProductionQuantity == null ? 43 : $partBoardProductionQuantity.hashCode());
      Object $partBoardNeedQuantity = this.getPartBoardNeedQuantity();
      result = result * 59 + ($partBoardNeedQuantity == null ? 43 : $partBoardNeedQuantity.hashCode());
      Object $wingBoardProductionQuantity = this.getWingBoardProductionQuantity();
      result = result * 59 + ($wingBoardProductionQuantity == null ? 43 : $wingBoardProductionQuantity.hashCode());
      Object $wingBoardNeedQuantity = this.getWingBoardNeedQuantity();
      result = result * 59 + ($wingBoardNeedQuantity == null ? 43 : $wingBoardNeedQuantity.hashCode());
      Object $partProductionQuantity = this.getPartProductionQuantity();
      result = result * 59 + ($partProductionQuantity == null ? 43 : $partProductionQuantity.hashCode());
      Object $partNeedQuantity = this.getPartNeedQuantity();
      result = result * 59 + ($partNeedQuantity == null ? 43 : $partNeedQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $status = this.getStatus();
      return result * 59 + ($status == null ? 43 : $status.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactCompleteDTO(serialNumber="
         + this.getSerialNumber()
         + ", artifactQuantity="
         + this.getArtifactQuantity()
         + ", partBoardProductionQuantity="
         + this.getPartBoardProductionQuantity()
         + ", partBoardNeedQuantity="
         + this.getPartBoardNeedQuantity()
         + ", wingBoardProductionQuantity="
         + this.getWingBoardProductionQuantity()
         + ", wingBoardNeedQuantity="
         + this.getWingBoardNeedQuantity()
         + ", partProductionQuantity="
         + this.getPartProductionQuantity()
         + ", partNeedQuantity="
         + this.getPartNeedQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public ArtifactCompleteDTO(
      final String serialNumber,
      final Integer artifactQuantity,
      final Integer partBoardProductionQuantity,
      final Integer partBoardNeedQuantity,
      final Integer wingBoardProductionQuantity,
      final Integer wingBoardNeedQuantity,
      final Integer partProductionQuantity,
      final Integer partNeedQuantity,
      final Integer completeQuantity,
      final String status
   ) {
      this.serialNumber = serialNumber;
      this.artifactQuantity = artifactQuantity;
      this.partBoardProductionQuantity = partBoardProductionQuantity;
      this.partBoardNeedQuantity = partBoardNeedQuantity;
      this.wingBoardProductionQuantity = wingBoardProductionQuantity;
      this.wingBoardNeedQuantity = wingBoardNeedQuantity;
      this.partProductionQuantity = partProductionQuantity;
      this.partNeedQuantity = partNeedQuantity;
      this.completeQuantity = completeQuantity;
      this.status = status;
   }

   public ArtifactCompleteDTO() {
   }
}
