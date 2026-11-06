package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.system.core.api.enums.PartDrawingLayerProcessMethodEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("零件图纸加工图层设置DTO")
public class PartDrawingLayerSettingDTO {
   @ApiModelProperty("图层名称")
   @NotBlank(message = "图层名称不能为空")
   private String layerName;
   @ApiModelProperty("处理方式")
   @NotBlank(message = "处理方式不能为空")
   @EnumValidator(value = PartDrawingLayerProcessMethodEnum.class, message = "处理方式不存在")
   private String processMethod;
   @ApiModelProperty("实体类型(0:实体,1:文字")
   @NotNull(message = "实体类型不能为空")
   private Integer objectType;

   public static PartDrawingLayerSettingDTO.PartDrawingLayerSettingDTOBuilder builder() {
      return new PartDrawingLayerSettingDTO.PartDrawingLayerSettingDTOBuilder();
   }

   public String getLayerName() {
      return this.layerName;
   }

   public String getProcessMethod() {
      return this.processMethod;
   }

   public Integer getObjectType() {
      return this.objectType;
   }

   public void setLayerName(final String layerName) {
      this.layerName = layerName;
   }

   public void setProcessMethod(final String processMethod) {
      this.processMethod = processMethod;
   }

   public void setObjectType(final Integer objectType) {
      this.objectType = objectType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PartDrawingLayerSettingDTO)) {
         return false;
      }

      PartDrawingLayerSettingDTO other = (PartDrawingLayerSettingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$objectType = this.getObjectType();
      Object other$objectType = other.getObjectType();
      if (this$objectType == null ? other$objectType == null : this$objectType.equals(other$objectType)) {
         Object this$layerName = this.getLayerName();
         Object other$layerName = other.getLayerName();
         if (this$layerName == null ? other$layerName == null : this$layerName.equals(other$layerName)) {
            Object this$processMethod = this.getProcessMethod();
            Object other$processMethod = other.getProcessMethod();
            return this$processMethod == null ? other$processMethod == null : this$processMethod.equals(other$processMethod);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PartDrawingLayerSettingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $objectType = this.getObjectType();
      result = result * 59 + ($objectType == null ? 43 : $objectType.hashCode());
      Object $layerName = this.getLayerName();
      result = result * 59 + ($layerName == null ? 43 : $layerName.hashCode());
      Object $processMethod = this.getProcessMethod();
      return result * 59 + ($processMethod == null ? 43 : $processMethod.hashCode());
   }

   @Override
   public String toString() {
      return "PartDrawingLayerSettingDTO(layerName="
         + this.getLayerName()
         + ", processMethod="
         + this.getProcessMethod()
         + ", objectType="
         + this.getObjectType()
         + ")";
   }

   public PartDrawingLayerSettingDTO() {
   }

   public PartDrawingLayerSettingDTO(final String layerName, final String processMethod, final Integer objectType) {
      this.layerName = layerName;
      this.processMethod = processMethod;
      this.objectType = objectType;
   }

   public static class PartDrawingLayerSettingDTOBuilder {
      private String layerName;
      private String processMethod;
      private Integer objectType;

      PartDrawingLayerSettingDTOBuilder() {
      }

      public PartDrawingLayerSettingDTO.PartDrawingLayerSettingDTOBuilder layerName(final String layerName) {
         this.layerName = layerName;
         return this;
      }

      public PartDrawingLayerSettingDTO.PartDrawingLayerSettingDTOBuilder processMethod(final String processMethod) {
         this.processMethod = processMethod;
         return this;
      }

      public PartDrawingLayerSettingDTO.PartDrawingLayerSettingDTOBuilder objectType(final Integer objectType) {
         this.objectType = objectType;
         return this;
      }

      public PartDrawingLayerSettingDTO build() {
         return new PartDrawingLayerSettingDTO(this.layerName, this.processMethod, this.objectType);
      }

      @Override
      public String toString() {
         return "PartDrawingLayerSettingDTO.PartDrawingLayerSettingDTOBuilder(layerName="
            + this.layerName
            + ", processMethod="
            + this.processMethod
            + ", objectType="
            + this.objectType
            + ")";
      }
   }
}
