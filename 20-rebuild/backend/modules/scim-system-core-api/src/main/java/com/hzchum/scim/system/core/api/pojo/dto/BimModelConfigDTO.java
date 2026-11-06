package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("BimModelConfigDTO对象")
public class BimModelConfigDTO {
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
   @ApiModelProperty(name = "maxModelUploadFileSize", value = "文件最大值")
   private Double maxModelUploadFileSize;

   public static BimModelConfigDTO.BimModelConfigDTOBuilder builder() {
      return new BimModelConfigDTO.BimModelConfigDTOBuilder();
   }

   public BimModelConfigDTO() {
   }

   public BimModelConfigDTO(final Boolean enabled, final Integer modelUploadLimitType, final Integer maxModelUploadNum, final Double maxModelUploadFileSize) {
      this.enabled = enabled;
      this.modelUploadLimitType = modelUploadLimitType;
      this.maxModelUploadNum = maxModelUploadNum;
      this.maxModelUploadFileSize = maxModelUploadFileSize;
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

   public Double getMaxModelUploadFileSize() {
      return this.maxModelUploadFileSize;
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

   public void setMaxModelUploadFileSize(final Double maxModelUploadFileSize) {
      this.maxModelUploadFileSize = maxModelUploadFileSize;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimModelConfigDTO)) {
         return false;
      }

      BimModelConfigDTO other = (BimModelConfigDTO)o;
      if (!other.canEqual(this)) {
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
               Object this$maxModelUploadFileSize = this.getMaxModelUploadFileSize();
               Object other$maxModelUploadFileSize = other.getMaxModelUploadFileSize();
               return this$maxModelUploadFileSize == null
                  ? other$maxModelUploadFileSize == null
                  : this$maxModelUploadFileSize.equals(other$maxModelUploadFileSize);
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
      return other instanceof BimModelConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $modelUploadLimitType = this.getModelUploadLimitType();
      result = result * 59 + ($modelUploadLimitType == null ? 43 : $modelUploadLimitType.hashCode());
      Object $maxModelUploadNum = this.getMaxModelUploadNum();
      result = result * 59 + ($maxModelUploadNum == null ? 43 : $maxModelUploadNum.hashCode());
      Object $maxModelUploadFileSize = this.getMaxModelUploadFileSize();
      return result * 59 + ($maxModelUploadFileSize == null ? 43 : $maxModelUploadFileSize.hashCode());
   }

   @Override
   public String toString() {
      return "BimModelConfigDTO(enabled="
         + this.getEnabled()
         + ", modelUploadLimitType="
         + this.getModelUploadLimitType()
         + ", maxModelUploadNum="
         + this.getMaxModelUploadNum()
         + ", maxModelUploadFileSize="
         + this.getMaxModelUploadFileSize()
         + ")";
   }

   public static class BimModelConfigDTOBuilder {
      private Boolean enabled;
      private Integer modelUploadLimitType;
      private Integer maxModelUploadNum;
      private Double maxModelUploadFileSize;

      BimModelConfigDTOBuilder() {
      }

      public BimModelConfigDTO.BimModelConfigDTOBuilder enabled(final Boolean enabled) {
         this.enabled = enabled;
         return this;
      }

      public BimModelConfigDTO.BimModelConfigDTOBuilder modelUploadLimitType(final Integer modelUploadLimitType) {
         this.modelUploadLimitType = modelUploadLimitType;
         return this;
      }

      public BimModelConfigDTO.BimModelConfigDTOBuilder maxModelUploadNum(final Integer maxModelUploadNum) {
         this.maxModelUploadNum = maxModelUploadNum;
         return this;
      }

      public BimModelConfigDTO.BimModelConfigDTOBuilder maxModelUploadFileSize(final Double maxModelUploadFileSize) {
         this.maxModelUploadFileSize = maxModelUploadFileSize;
         return this;
      }

      public BimModelConfigDTO build() {
         return new BimModelConfigDTO(this.enabled, this.modelUploadLimitType, this.maxModelUploadNum, this.maxModelUploadFileSize);
      }

      @Override
      public String toString() {
         return "BimModelConfigDTO.BimModelConfigDTOBuilder(enabled="
            + this.enabled
            + ", modelUploadLimitType="
            + this.modelUploadLimitType
            + ", maxModelUploadNum="
            + this.maxModelUploadNum
            + ", maxModelUploadFileSize="
            + this.maxModelUploadFileSize
            + ")";
      }
   }
}
