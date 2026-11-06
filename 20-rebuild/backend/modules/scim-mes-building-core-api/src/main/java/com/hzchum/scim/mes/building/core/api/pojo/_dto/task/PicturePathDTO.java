package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PicturePathDTO", description = "图纸dto ")
public class PicturePathDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "productId")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "drwaingId")
   @JsonProperty("drwaingId")
   @JSONField(name = "drwaingId")
   private Long drwaingId;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "serialNumber", value = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "number", value = "产品序列号(构件)")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;
   @ApiModelProperty(name = "dwgNum", value = "图号(构件)")
   @JsonProperty("dwgNum")
   @JSONField(name = "dwgNum")
   private String dwgNum;
   @ApiModelProperty(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图 16XML文件")
   @JsonProperty("dataType")
   @JSONField(name = "dataType")
   private Integer dataType;
   @ApiModelProperty(name = "productType", value = "产品类型【1零件, 2构件，16组立】")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "filePath", value = "文件路径(NC1主部件记录转换后的文件的路径)")
   @JsonProperty("filePath")
   @JSONField(name = "filePath")
   private String filePath;
   @ApiModelProperty(name = "createUserId", value = "上传人id")
   @JsonProperty("createUserId")
   @JSONField(name = "createUserId")
   private Long createUserId;
   @ApiModelProperty(name = "cloudPath", value = "云路径")
   @JsonProperty("cloudPath")
   @JSONField(name = "cloudPath")
   private String cloudPath;
   @ApiModelProperty(name = "picture_path", value = "图片路径(DXF:记录转换后的.sug位置 )")
   @JsonProperty("picture_path")
   @JSONField(name = "picture_path")
   private String picturePath;

   public static PicturePathDTO.PicturePathDTOBuilder builder() {
      return new PicturePathDTO.PicturePathDTOBuilder();
   }

   public PicturePathDTO() {
   }

   public PicturePathDTO(
      final Long productId,
      final Long drwaingId,
      final Long projectId,
      final Long monomerId,
      final String serialNumber,
      final Integer number,
      final String dwgNum,
      final Integer dataType,
      final Integer productType,
      final String filePath,
      final Long createUserId,
      final String cloudPath,
      final String picturePath
   ) {
      this.productId = productId;
      this.drwaingId = drwaingId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.serialNumber = serialNumber;
      this.number = number;
      this.dwgNum = dwgNum;
      this.dataType = dataType;
      this.productType = productType;
      this.filePath = filePath;
      this.createUserId = createUserId;
      this.cloudPath = cloudPath;
      this.picturePath = picturePath;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getDrwaingId() {
      return this.drwaingId;
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

   public Integer getNumber() {
      return this.number;
   }

   public String getDwgNum() {
      return this.dwgNum;
   }

   public Integer getDataType() {
      return this.dataType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getFilePath() {
      return this.filePath;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCloudPath() {
      return this.cloudPath;
   }

   public String getPicturePath() {
      return this.picturePath;
   }

   @JsonProperty("productId")
   public PicturePathDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("drwaingId")
   public PicturePathDTO setDrwaingId(final Long drwaingId) {
      this.drwaingId = drwaingId;
      return this;
   }

   @JsonProperty("projectId")
   public PicturePathDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public PicturePathDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("serialNumber")
   public PicturePathDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("number")
   public PicturePathDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("dwgNum")
   public PicturePathDTO setDwgNum(final String dwgNum) {
      this.dwgNum = dwgNum;
      return this;
   }

   @JsonProperty("dataType")
   public PicturePathDTO setDataType(final Integer dataType) {
      this.dataType = dataType;
      return this;
   }

   @JsonProperty("productType")
   public PicturePathDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("filePath")
   public PicturePathDTO setFilePath(final String filePath) {
      this.filePath = filePath;
      return this;
   }

   @JsonProperty("createUserId")
   public PicturePathDTO setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   @JsonProperty("cloudPath")
   public PicturePathDTO setCloudPath(final String cloudPath) {
      this.cloudPath = cloudPath;
      return this;
   }

   @JsonProperty("picture_path")
   public PicturePathDTO setPicturePath(final String picturePath) {
      this.picturePath = picturePath;
      return this;
   }

   @Override
   public String toString() {
      return "PicturePathDTO(productId="
         + this.getProductId()
         + ", drwaingId="
         + this.getDrwaingId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", number="
         + this.getNumber()
         + ", dwgNum="
         + this.getDwgNum()
         + ", dataType="
         + this.getDataType()
         + ", productType="
         + this.getProductType()
         + ", filePath="
         + this.getFilePath()
         + ", createUserId="
         + this.getCreateUserId()
         + ", cloudPath="
         + this.getCloudPath()
         + ", picturePath="
         + this.getPicturePath()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PicturePathDTO)) {
         return false;
      }

      PicturePathDTO other = (PicturePathDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$drwaingId = this.getDrwaingId();
         Object other$drwaingId = other.getDrwaingId();
         if (this$drwaingId == null ? other$drwaingId == null : this$drwaingId.equals(other$drwaingId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$number = this.getNumber();
                  Object other$number = other.getNumber();
                  if (this$number == null ? other$number == null : this$number.equals(other$number)) {
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
                                 Object this$dwgNum = this.getDwgNum();
                                 Object other$dwgNum = other.getDwgNum();
                                 if (this$dwgNum == null ? other$dwgNum == null : this$dwgNum.equals(other$dwgNum)) {
                                    Object this$filePath = this.getFilePath();
                                    Object other$filePath = other.getFilePath();
                                    if (this$filePath == null ? other$filePath == null : this$filePath.equals(other$filePath)) {
                                       Object this$cloudPath = this.getCloudPath();
                                       Object other$cloudPath = other.getCloudPath();
                                       if (this$cloudPath == null ? other$cloudPath == null : this$cloudPath.equals(other$cloudPath)) {
                                          Object this$picturePath = this.getPicturePath();
                                          Object other$picturePath = other.getPicturePath();
                                          return this$picturePath == null ? other$picturePath == null : this$picturePath.equals(other$picturePath);
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
      return other instanceof PicturePathDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $drwaingId = this.getDrwaingId();
      result = result * 59 + ($drwaingId == null ? 43 : $drwaingId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $dataType = this.getDataType();
      result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $dwgNum = this.getDwgNum();
      result = result * 59 + ($dwgNum == null ? 43 : $dwgNum.hashCode());
      Object $filePath = this.getFilePath();
      result = result * 59 + ($filePath == null ? 43 : $filePath.hashCode());
      Object $cloudPath = this.getCloudPath();
      result = result * 59 + ($cloudPath == null ? 43 : $cloudPath.hashCode());
      Object $picturePath = this.getPicturePath();
      return result * 59 + ($picturePath == null ? 43 : $picturePath.hashCode());
   }

   public static class PicturePathDTOBuilder {
      private Long productId;
      private Long drwaingId;
      private Long projectId;
      private Long monomerId;
      private String serialNumber;
      private Integer number;
      private String dwgNum;
      private Integer dataType;
      private Integer productType;
      private String filePath;
      private Long createUserId;
      private String cloudPath;
      private String picturePath;

      PicturePathDTOBuilder() {
      }

      @JsonProperty("productId")
      public PicturePathDTO.PicturePathDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("drwaingId")
      public PicturePathDTO.PicturePathDTOBuilder drwaingId(final Long drwaingId) {
         this.drwaingId = drwaingId;
         return this;
      }

      @JsonProperty("projectId")
      public PicturePathDTO.PicturePathDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public PicturePathDTO.PicturePathDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("serialNumber")
      public PicturePathDTO.PicturePathDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("number")
      public PicturePathDTO.PicturePathDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("dwgNum")
      public PicturePathDTO.PicturePathDTOBuilder dwgNum(final String dwgNum) {
         this.dwgNum = dwgNum;
         return this;
      }

      @JsonProperty("dataType")
      public PicturePathDTO.PicturePathDTOBuilder dataType(final Integer dataType) {
         this.dataType = dataType;
         return this;
      }

      @JsonProperty("productType")
      public PicturePathDTO.PicturePathDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("filePath")
      public PicturePathDTO.PicturePathDTOBuilder filePath(final String filePath) {
         this.filePath = filePath;
         return this;
      }

      @JsonProperty("createUserId")
      public PicturePathDTO.PicturePathDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      @JsonProperty("cloudPath")
      public PicturePathDTO.PicturePathDTOBuilder cloudPath(final String cloudPath) {
         this.cloudPath = cloudPath;
         return this;
      }

      @JsonProperty("picture_path")
      public PicturePathDTO.PicturePathDTOBuilder picturePath(final String picturePath) {
         this.picturePath = picturePath;
         return this;
      }

      public PicturePathDTO build() {
         return new PicturePathDTO(
            this.productId,
            this.drwaingId,
            this.projectId,
            this.monomerId,
            this.serialNumber,
            this.number,
            this.dwgNum,
            this.dataType,
            this.productType,
            this.filePath,
            this.createUserId,
            this.cloudPath,
            this.picturePath
         );
      }

      @Override
      public String toString() {
         return "PicturePathDTO.PicturePathDTOBuilder(productId="
            + this.productId
            + ", drwaingId="
            + this.drwaingId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", serialNumber="
            + this.serialNumber
            + ", number="
            + this.number
            + ", dwgNum="
            + this.dwgNum
            + ", dataType="
            + this.dataType
            + ", productType="
            + this.productType
            + ", filePath="
            + this.filePath
            + ", createUserId="
            + this.createUserId
            + ", cloudPath="
            + this.cloudPath
            + ", picturePath="
            + this.picturePath
            + ")";
      }
   }
}
