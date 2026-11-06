package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "技术成果-创建审批流时缓存数据对象", description = "技术成果-创建审批流时缓存数据对象 ")
public class PlanApproveCacheDTOParam {
   @ApiModelProperty("文件名")
   private String fileName;
   @ApiModelProperty("文件格式")
   private String contentType;
   @ApiModelProperty("项目id")
   private Long projectld;
   @ApiModelProperty("单体id")
   private Long monomerld;
   @ApiModelProperty("区域id")
   private Long areaId;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty("模型类型")
   private Integer dataType;
   @ApiModelProperty("其他缓存数据")
   private PlanApproveCacheObjectDTOParam cacheObjectDTOParam;

   public static PlanApproveCacheDTOParam.PlanApproveCacheDTOParamBuilder builder() {
      return new PlanApproveCacheDTOParam.PlanApproveCacheDTOParamBuilder();
   }

   public PlanApproveCacheDTOParam() {
   }

   public PlanApproveCacheDTOParam(
      final String fileName,
      final String contentType,
      final Long projectld,
      final Long monomerld,
      final Long areaId,
      final Integer productType,
      final Integer dataType,
      final PlanApproveCacheObjectDTOParam cacheObjectDTOParam
   ) {
      this.fileName = fileName;
      this.contentType = contentType;
      this.projectld = projectld;
      this.monomerld = monomerld;
      this.areaId = areaId;
      this.productType = productType;
      this.dataType = dataType;
      this.cacheObjectDTOParam = cacheObjectDTOParam;
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getContentType() {
      return this.contentType;
   }

   public Long getProjectld() {
      return this.projectld;
   }

   public Long getMonomerld() {
      return this.monomerld;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getDataType() {
      return this.dataType;
   }

   public PlanApproveCacheObjectDTOParam getCacheObjectDTOParam() {
      return this.cacheObjectDTOParam;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setContentType(final String contentType) {
      this.contentType = contentType;
   }

   public void setProjectld(final Long projectld) {
      this.projectld = projectld;
   }

   public void setMonomerld(final Long monomerld) {
      this.monomerld = monomerld;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setDataType(final Integer dataType) {
      this.dataType = dataType;
   }

   public void setCacheObjectDTOParam(final PlanApproveCacheObjectDTOParam cacheObjectDTOParam) {
      this.cacheObjectDTOParam = cacheObjectDTOParam;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanApproveCacheDTOParam)) {
         return false;
      }

      PlanApproveCacheDTOParam other = (PlanApproveCacheDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectld = this.getProjectld();
      Object other$projectld = other.getProjectld();
      if (this$projectld == null ? other$projectld == null : this$projectld.equals(other$projectld)) {
         Object this$monomerld = this.getMonomerld();
         Object other$monomerld = other.getMonomerld();
         if (this$monomerld == null ? other$monomerld == null : this$monomerld.equals(other$monomerld)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$dataType = this.getDataType();
                  Object other$dataType = other.getDataType();
                  if (this$dataType == null ? other$dataType == null : this$dataType.equals(other$dataType)) {
                     Object this$fileName = this.getFileName();
                     Object other$fileName = other.getFileName();
                     if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                        Object this$contentType = this.getContentType();
                        Object other$contentType = other.getContentType();
                        if (this$contentType == null ? other$contentType == null : this$contentType.equals(other$contentType)) {
                           Object this$cacheObjectDTOParam = this.getCacheObjectDTOParam();
                           Object other$cacheObjectDTOParam = other.getCacheObjectDTOParam();
                           return this$cacheObjectDTOParam == null
                              ? other$cacheObjectDTOParam == null
                              : this$cacheObjectDTOParam.equals(other$cacheObjectDTOParam);
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
      return other instanceof PlanApproveCacheDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectld = this.getProjectld();
      result = result * 59 + ($projectld == null ? 43 : $projectld.hashCode());
      Object $monomerld = this.getMonomerld();
      result = result * 59 + ($monomerld == null ? 43 : $monomerld.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $dataType = this.getDataType();
      result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $contentType = this.getContentType();
      result = result * 59 + ($contentType == null ? 43 : $contentType.hashCode());
      Object $cacheObjectDTOParam = this.getCacheObjectDTOParam();
      return result * 59 + ($cacheObjectDTOParam == null ? 43 : $cacheObjectDTOParam.hashCode());
   }

   @Override
   public String toString() {
      return "PlanApproveCacheDTOParam(fileName="
         + this.getFileName()
         + ", contentType="
         + this.getContentType()
         + ", projectld="
         + this.getProjectld()
         + ", monomerld="
         + this.getMonomerld()
         + ", areaId="
         + this.getAreaId()
         + ", productType="
         + this.getProductType()
         + ", dataType="
         + this.getDataType()
         + ", cacheObjectDTOParam="
         + this.getCacheObjectDTOParam()
         + ")";
   }

   public static class PlanApproveCacheDTOParamBuilder {
      private String fileName;
      private String contentType;
      private Long projectld;
      private Long monomerld;
      private Long areaId;
      private Integer productType;
      private Integer dataType;
      private PlanApproveCacheObjectDTOParam cacheObjectDTOParam;

      PlanApproveCacheDTOParamBuilder() {
      }

      public PlanApproveCacheDTOParam.PlanApproveCacheDTOParamBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public PlanApproveCacheDTOParam.PlanApproveCacheDTOParamBuilder contentType(final String contentType) {
         this.contentType = contentType;
         return this;
      }

      public PlanApproveCacheDTOParam.PlanApproveCacheDTOParamBuilder projectld(final Long projectld) {
         this.projectld = projectld;
         return this;
      }

      public PlanApproveCacheDTOParam.PlanApproveCacheDTOParamBuilder monomerld(final Long monomerld) {
         this.monomerld = monomerld;
         return this;
      }

      public PlanApproveCacheDTOParam.PlanApproveCacheDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public PlanApproveCacheDTOParam.PlanApproveCacheDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public PlanApproveCacheDTOParam.PlanApproveCacheDTOParamBuilder dataType(final Integer dataType) {
         this.dataType = dataType;
         return this;
      }

      public PlanApproveCacheDTOParam.PlanApproveCacheDTOParamBuilder cacheObjectDTOParam(final PlanApproveCacheObjectDTOParam cacheObjectDTOParam) {
         this.cacheObjectDTOParam = cacheObjectDTOParam;
         return this;
      }

      public PlanApproveCacheDTOParam build() {
         return new PlanApproveCacheDTOParam(
            this.fileName, this.contentType, this.projectld, this.monomerld, this.areaId, this.productType, this.dataType, this.cacheObjectDTOParam
         );
      }

      @Override
      public String toString() {
         return "PlanApproveCacheDTOParam.PlanApproveCacheDTOParamBuilder(fileName="
            + this.fileName
            + ", contentType="
            + this.contentType
            + ", projectld="
            + this.projectld
            + ", monomerld="
            + this.monomerld
            + ", areaId="
            + this.areaId
            + ", productType="
            + this.productType
            + ", dataType="
            + this.dataType
            + ", cacheObjectDTOParam="
            + this.cacheObjectDTOParam
            + ")";
      }
   }
}
