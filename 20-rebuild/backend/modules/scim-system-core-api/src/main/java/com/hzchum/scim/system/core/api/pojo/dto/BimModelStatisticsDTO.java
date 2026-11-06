package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("BimModelStatisticsDTO对象")
public class BimModelStatisticsDTO {
   @ApiModelProperty(name = "enabled", value = "是否启用 true是 false否")
   private Boolean enabled;
   @ApiModelProperty(
      name = "modelUploadLimitType",
      value = "限制方式。1 总数 2 文件大小。BimModelRestrictedModeEnum",
      notes = "限制方式。1 总数 2 文件大小，BimModelRestrictedModeEnum"
   )
   private Integer modelUploadLimitType;
   @ApiModelProperty(name = "maxModelUploadNum", value = "最高成功次数")
   private Integer maxModelUploadNum;
   @ApiModelProperty(name = "currentModelUploadNum", value = "当前成功次数")
   private Integer currentModelUploadNum;
   @ApiModelProperty(name = "maxModelUploadFileSize", value = "文件最大值")
   private Double maxModelUploadFileSize;
   @ApiModelProperty(name = "currentModelUploadFileSize", value = "文件当前值")
   private Double currentModelUploadFileSize;
   @ApiModelProperty(name = "FileSizePoor", value = "文件大小差值")
   private double fileSizePoor;
   @ApiModelProperty(name = "UploadNumPoor", value = "次数差值")
   private Integer uploadNumPoor;

   public static BimModelStatisticsDTO.BimModelStatisticsDTOBuilder builder() {
      return new BimModelStatisticsDTO.BimModelStatisticsDTOBuilder();
   }

   public BimModelStatisticsDTO() {
   }

   public BimModelStatisticsDTO(
      final Boolean enabled,
      final Integer modelUploadLimitType,
      final Integer maxModelUploadNum,
      final Integer currentModelUploadNum,
      final Double maxModelUploadFileSize,
      final Double currentModelUploadFileSize,
      final double fileSizePoor,
      final Integer uploadNumPoor
   ) {
      this.enabled = enabled;
      this.modelUploadLimitType = modelUploadLimitType;
      this.maxModelUploadNum = maxModelUploadNum;
      this.currentModelUploadNum = currentModelUploadNum;
      this.maxModelUploadFileSize = maxModelUploadFileSize;
      this.currentModelUploadFileSize = currentModelUploadFileSize;
      this.fileSizePoor = fileSizePoor;
      this.uploadNumPoor = uploadNumPoor;
   }

   public Boolean getEnabled() {
      return this.enabled;
   }

   public Integer getModelUploadLimitType() {
      return this.modelUploadLimitType;
   }

   public Integer getMaxModelUploadNum() {
      return this.maxModelUploadNum;
   }

   public Integer getCurrentModelUploadNum() {
      return this.currentModelUploadNum;
   }

   public Double getMaxModelUploadFileSize() {
      return this.maxModelUploadFileSize;
   }

   public Double getCurrentModelUploadFileSize() {
      return this.currentModelUploadFileSize;
   }

   public double getFileSizePoor() {
      return this.fileSizePoor;
   }

   public Integer getUploadNumPoor() {
      return this.uploadNumPoor;
   }

   public void setEnabled(final Boolean enabled) {
      this.enabled = enabled;
   }

   public void setModelUploadLimitType(final Integer modelUploadLimitType) {
      this.modelUploadLimitType = modelUploadLimitType;
   }

   public void setMaxModelUploadNum(final Integer maxModelUploadNum) {
      this.maxModelUploadNum = maxModelUploadNum;
   }

   public void setCurrentModelUploadNum(final Integer currentModelUploadNum) {
      this.currentModelUploadNum = currentModelUploadNum;
   }

   public void setMaxModelUploadFileSize(final Double maxModelUploadFileSize) {
      this.maxModelUploadFileSize = maxModelUploadFileSize;
   }

   public void setCurrentModelUploadFileSize(final Double currentModelUploadFileSize) {
      this.currentModelUploadFileSize = currentModelUploadFileSize;
   }

   public void setFileSizePoor(final double fileSizePoor) {
      this.fileSizePoor = fileSizePoor;
   }

   public void setUploadNumPoor(final Integer uploadNumPoor) {
      this.uploadNumPoor = uploadNumPoor;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimModelStatisticsDTO)) {
         return false;
      }

      BimModelStatisticsDTO other = (BimModelStatisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (Double.compare(this.getFileSizePoor(), other.getFileSizePoor()) != 0) {
         return false;
      }

      Object this$enabled = this.getEnabled();
      Object other$enabled = other.getEnabled();
      if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
         Object this$modelUploadLimitType = this.getModelUploadLimitType();
         Object other$modelUploadLimitType = other.getModelUploadLimitType();
         if (this$modelUploadLimitType == null ? other$modelUploadLimitType == null : this$modelUploadLimitType.equals(other$modelUploadLimitType)) {
            Object this$maxModelUploadNum = this.getMaxModelUploadNum();
            Object other$maxModelUploadNum = other.getMaxModelUploadNum();
            if (this$maxModelUploadNum == null ? other$maxModelUploadNum == null : this$maxModelUploadNum.equals(other$maxModelUploadNum)) {
               Object this$currentModelUploadNum = this.getCurrentModelUploadNum();
               Object other$currentModelUploadNum = other.getCurrentModelUploadNum();
               if (this$currentModelUploadNum == null ? other$currentModelUploadNum == null : this$currentModelUploadNum.equals(other$currentModelUploadNum)) {
                  Object this$maxModelUploadFileSize = this.getMaxModelUploadFileSize();
                  Object other$maxModelUploadFileSize = other.getMaxModelUploadFileSize();
                  if (this$maxModelUploadFileSize == null
                     ? other$maxModelUploadFileSize == null
                     : this$maxModelUploadFileSize.equals(other$maxModelUploadFileSize)) {
                     Object this$currentModelUploadFileSize = this.getCurrentModelUploadFileSize();
                     Object other$currentModelUploadFileSize = other.getCurrentModelUploadFileSize();
                     if (this$currentModelUploadFileSize == null
                        ? other$currentModelUploadFileSize == null
                        : this$currentModelUploadFileSize.equals(other$currentModelUploadFileSize)) {
                        Object this$uploadNumPoor = this.getUploadNumPoor();
                        Object other$uploadNumPoor = other.getUploadNumPoor();
                        return this$uploadNumPoor == null ? other$uploadNumPoor == null : this$uploadNumPoor.equals(other$uploadNumPoor);
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
      return other instanceof BimModelStatisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $fileSizePoor = Double.doubleToLongBits(this.getFileSizePoor());
      result = result * 59 + (int)($fileSizePoor >>> 32 ^ $fileSizePoor);
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $modelUploadLimitType = this.getModelUploadLimitType();
      result = result * 59 + ($modelUploadLimitType == null ? 43 : $modelUploadLimitType.hashCode());
      Object $maxModelUploadNum = this.getMaxModelUploadNum();
      result = result * 59 + ($maxModelUploadNum == null ? 43 : $maxModelUploadNum.hashCode());
      Object $currentModelUploadNum = this.getCurrentModelUploadNum();
      result = result * 59 + ($currentModelUploadNum == null ? 43 : $currentModelUploadNum.hashCode());
      Object $maxModelUploadFileSize = this.getMaxModelUploadFileSize();
      result = result * 59 + ($maxModelUploadFileSize == null ? 43 : $maxModelUploadFileSize.hashCode());
      Object $currentModelUploadFileSize = this.getCurrentModelUploadFileSize();
      result = result * 59 + ($currentModelUploadFileSize == null ? 43 : $currentModelUploadFileSize.hashCode());
      Object $uploadNumPoor = this.getUploadNumPoor();
      return result * 59 + ($uploadNumPoor == null ? 43 : $uploadNumPoor.hashCode());
   }

   @Override
   public String toString() {
      return "BimModelStatisticsDTO(enabled="
         + this.getEnabled()
         + ", modelUploadLimitType="
         + this.getModelUploadLimitType()
         + ", maxModelUploadNum="
         + this.getMaxModelUploadNum()
         + ", currentModelUploadNum="
         + this.getCurrentModelUploadNum()
         + ", maxModelUploadFileSize="
         + this.getMaxModelUploadFileSize()
         + ", currentModelUploadFileSize="
         + this.getCurrentModelUploadFileSize()
         + ", fileSizePoor="
         + this.getFileSizePoor()
         + ", uploadNumPoor="
         + this.getUploadNumPoor()
         + ")";
   }

   public static class BimModelStatisticsDTOBuilder {
      private Boolean enabled;
      private Integer modelUploadLimitType;
      private Integer maxModelUploadNum;
      private Integer currentModelUploadNum;
      private Double maxModelUploadFileSize;
      private Double currentModelUploadFileSize;
      private double fileSizePoor;
      private Integer uploadNumPoor;

      BimModelStatisticsDTOBuilder() {
      }

      public BimModelStatisticsDTO.BimModelStatisticsDTOBuilder enabled(final Boolean enabled) {
         this.enabled = enabled;
         return this;
      }

      public BimModelStatisticsDTO.BimModelStatisticsDTOBuilder modelUploadLimitType(final Integer modelUploadLimitType) {
         this.modelUploadLimitType = modelUploadLimitType;
         return this;
      }

      public BimModelStatisticsDTO.BimModelStatisticsDTOBuilder maxModelUploadNum(final Integer maxModelUploadNum) {
         this.maxModelUploadNum = maxModelUploadNum;
         return this;
      }

      public BimModelStatisticsDTO.BimModelStatisticsDTOBuilder currentModelUploadNum(final Integer currentModelUploadNum) {
         this.currentModelUploadNum = currentModelUploadNum;
         return this;
      }

      public BimModelStatisticsDTO.BimModelStatisticsDTOBuilder maxModelUploadFileSize(final Double maxModelUploadFileSize) {
         this.maxModelUploadFileSize = maxModelUploadFileSize;
         return this;
      }

      public BimModelStatisticsDTO.BimModelStatisticsDTOBuilder currentModelUploadFileSize(final Double currentModelUploadFileSize) {
         this.currentModelUploadFileSize = currentModelUploadFileSize;
         return this;
      }

      public BimModelStatisticsDTO.BimModelStatisticsDTOBuilder fileSizePoor(final double fileSizePoor) {
         this.fileSizePoor = fileSizePoor;
         return this;
      }

      public BimModelStatisticsDTO.BimModelStatisticsDTOBuilder uploadNumPoor(final Integer uploadNumPoor) {
         this.uploadNumPoor = uploadNumPoor;
         return this;
      }

      public BimModelStatisticsDTO build() {
         return new BimModelStatisticsDTO(
            this.enabled,
            this.modelUploadLimitType,
            this.maxModelUploadNum,
            this.currentModelUploadNum,
            this.maxModelUploadFileSize,
            this.currentModelUploadFileSize,
            this.fileSizePoor,
            this.uploadNumPoor
         );
      }

      @Override
      public String toString() {
         return "BimModelStatisticsDTO.BimModelStatisticsDTOBuilder(enabled="
            + this.enabled
            + ", modelUploadLimitType="
            + this.modelUploadLimitType
            + ", maxModelUploadNum="
            + this.maxModelUploadNum
            + ", currentModelUploadNum="
            + this.currentModelUploadNum
            + ", maxModelUploadFileSize="
            + this.maxModelUploadFileSize
            + ", currentModelUploadFileSize="
            + this.currentModelUploadFileSize
            + ", fileSizePoor="
            + this.fileSizePoor
            + ", uploadNumPoor="
            + this.uploadNumPoor
            + ")";
      }
   }
}
