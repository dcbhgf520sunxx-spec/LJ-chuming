package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "TechDrawingDTO对象", description = "焊缝返回对象")
public class TechCappCraftCardProductWeldingMapDTO {
   @ApiModelProperty(name = "id", value = "焊缝id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图 16XML文件")
   private Integer dataType;
   @ApiModelProperty(name = "productType", value = "产品类型【1零件, 2构件，16组立】")
   private Integer productType;
   @ApiModelProperty(name = "createUserId", value = "上传人id")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "上传人")
   private String createUserName;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "updateTime", value = "上传时间")
   private LocalDateTime updateTime;

   public static TechCappCraftCardProductWeldingMapDTO.TechCappCraftCardProductWeldingMapDTOBuilder builder() {
      return new TechCappCraftCardProductWeldingMapDTO.TechCappCraftCardProductWeldingMapDTOBuilder();
   }

   public TechCappCraftCardProductWeldingMapDTO() {
   }

   public TechCappCraftCardProductWeldingMapDTO(
      final Long id,
      final String serialNumber,
      final Integer dataType,
      final Integer productType,
      final Long createUserId,
      final String createUserName,
      final LocalDateTime createTime,
      final LocalDateTime updateTime
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.dataType = dataType;
      this.productType = productType;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.createTime = createTime;
      this.updateTime = updateTime;
   }

   public Long getId() {
      return this.id;
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

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechCappCraftCardProductWeldingMapDTO)) {
         return false;
      }

      TechCappCraftCardProductWeldingMapDTO other = (TechCappCraftCardProductWeldingMapDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
                     Object this$createUserName = this.getCreateUserName();
                     Object other$createUserName = other.getCreateUserName();
                     if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                           Object this$updateTime = this.getUpdateTime();
                           Object other$updateTime = other.getUpdateTime();
                           return this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime);
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
      return other instanceof TechCappCraftCardProductWeldingMapDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $dataType = this.getDataType();
      result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "TechCappCraftCardProductWeldingMapDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", dataType="
         + this.getDataType()
         + ", productType="
         + this.getProductType()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ")";
   }

   public static class TechCappCraftCardProductWeldingMapDTOBuilder {
      private Long id;
      private String serialNumber;
      private Integer dataType;
      private Integer productType;
      private Long createUserId;
      private String createUserName;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;

      TechCappCraftCardProductWeldingMapDTOBuilder() {
      }

      public TechCappCraftCardProductWeldingMapDTO.TechCappCraftCardProductWeldingMapDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechCappCraftCardProductWeldingMapDTO.TechCappCraftCardProductWeldingMapDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechCappCraftCardProductWeldingMapDTO.TechCappCraftCardProductWeldingMapDTOBuilder dataType(final Integer dataType) {
         this.dataType = dataType;
         return this;
      }

      public TechCappCraftCardProductWeldingMapDTO.TechCappCraftCardProductWeldingMapDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public TechCappCraftCardProductWeldingMapDTO.TechCappCraftCardProductWeldingMapDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public TechCappCraftCardProductWeldingMapDTO.TechCappCraftCardProductWeldingMapDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public TechCappCraftCardProductWeldingMapDTO.TechCappCraftCardProductWeldingMapDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public TechCappCraftCardProductWeldingMapDTO.TechCappCraftCardProductWeldingMapDTOBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public TechCappCraftCardProductWeldingMapDTO build() {
         return new TechCappCraftCardProductWeldingMapDTO(
            this.id, this.serialNumber, this.dataType, this.productType, this.createUserId, this.createUserName, this.createTime, this.updateTime
         );
      }

      @Override
      public String toString() {
         return "TechCappCraftCardProductWeldingMapDTO.TechCappCraftCardProductWeldingMapDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", dataType="
            + this.dataType
            + ", productType="
            + this.productType
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", createTime="
            + this.createTime
            + ", updateTime="
            + this.updateTime
            + ")";
      }
   }
}
