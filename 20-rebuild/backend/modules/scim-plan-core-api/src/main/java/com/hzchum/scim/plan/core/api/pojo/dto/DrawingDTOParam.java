package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("修改(替换)技术资料")
public class DrawingDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "serialNumber", value = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图")
   private Integer dataType;
   @ApiModelProperty(name = "productType", value = "产品类型【1零件, 2构件，16组立】")
   private Integer productType;
   @ApiModelProperty(name = "fileName", value = "文件名称")
   @NotBlank(message = "文件名称不能为空")
   private String fileName;
   @ApiModelProperty(name = "filePath", value = "文件路径")
   @NotBlank(message = "文件路径不能为空")
   private String filePath;
   @ApiModelProperty(name = "createUserId", value = "上传人id")
   @NotNull(message = "上传人id不能为空")
   private Long createUserId;

   public static DrawingDTOParam.DrawingDTOParamBuilder builder() {
      return new DrawingDTOParam.DrawingDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getDataType() {
      return this.dataType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getFilePath() {
      return this.filePath;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setDataType(final Integer dataType) {
      this.dataType = dataType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setFilePath(final String filePath) {
      this.filePath = filePath;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DrawingDTOParam)) {
         return false;
      }

      DrawingDTOParam other = (DrawingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$dataType = this.getDataType();
            Object other$dataType = other.getDataType();
            if (this$dataType == null ? other$dataType == null : this$dataType.equals(other$dataType)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$createUserId = this.getCreateUserId();
                  Object other$createUserId = other.getCreateUserId();
                  if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$fileName = this.getFileName();
                        Object other$fileName = other.getFileName();
                        if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                           Object this$filePath = this.getFilePath();
                           Object other$filePath = other.getFilePath();
                           return this$filePath == null ? other$filePath == null : this$filePath.equals(other$filePath);
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
      return other instanceof DrawingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $dataType = this.getDataType();
      result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $filePath = this.getFilePath();
      return result * 59 + ($filePath == null ? 43 : $filePath.hashCode());
   }

   @Override
   public String toString() {
      return "DrawingDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", dataType="
         + this.getDataType()
         + ", productType="
         + this.getProductType()
         + ", fileName="
         + this.getFileName()
         + ", filePath="
         + this.getFilePath()
         + ", createUserId="
         + this.getCreateUserId()
         + ")";
   }

   public DrawingDTOParam(
      final Long projectId,
      final Long monomerId,
      final String serialNumber,
      final Integer dataType,
      final Integer productType,
      final String fileName,
      final String filePath,
      final Long createUserId
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.serialNumber = serialNumber;
      this.dataType = dataType;
      this.productType = productType;
      this.fileName = fileName;
      this.filePath = filePath;
      this.createUserId = createUserId;
   }

   public DrawingDTOParam() {
   }

   public static class DrawingDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private String serialNumber;
      private Integer dataType;
      private Integer productType;
      private String fileName;
      private String filePath;
      private Long createUserId;

      DrawingDTOParamBuilder() {
      }

      public DrawingDTOParam.DrawingDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public DrawingDTOParam.DrawingDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public DrawingDTOParam.DrawingDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public DrawingDTOParam.DrawingDTOParamBuilder dataType(final Integer dataType) {
         this.dataType = dataType;
         return this;
      }

      public DrawingDTOParam.DrawingDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public DrawingDTOParam.DrawingDTOParamBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public DrawingDTOParam.DrawingDTOParamBuilder filePath(final String filePath) {
         this.filePath = filePath;
         return this;
      }

      public DrawingDTOParam.DrawingDTOParamBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public DrawingDTOParam build() {
         return new DrawingDTOParam(
            this.projectId, this.monomerId, this.serialNumber, this.dataType, this.productType, this.fileName, this.filePath, this.createUserId
         );
      }

      @Override
      public String toString() {
         return "DrawingDTOParam.DrawingDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", serialNumber="
            + this.serialNumber
            + ", dataType="
            + this.dataType
            + ", productType="
            + this.productType
            + ", fileName="
            + this.fileName
            + ", filePath="
            + this.filePath
            + ", createUserId="
            + this.createUserId
            + ")";
      }
   }
}
