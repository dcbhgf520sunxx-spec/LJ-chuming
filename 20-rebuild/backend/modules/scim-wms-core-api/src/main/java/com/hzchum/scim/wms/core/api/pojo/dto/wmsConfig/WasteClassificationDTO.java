package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WasteClassification对象", description = "废料种类-配置 ")
public class WasteClassificationDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "measureUnit", value = "单位", notes = "单位")
   private String measureUnit;
   @ApiModelProperty(name = "userId", value = "创建人id", notes = "创建人id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建人", notes = "创建人")
   private String userName;

   public static WasteClassificationDTO.WasteClassificationDTOBuilder builder() {
      return new WasteClassificationDTO.WasteClassificationDTOBuilder();
   }

   public WasteClassificationDTO() {
   }

   public WasteClassificationDTO(final Long id, final String name, final String measureUnit, final Long userId, final String userName) {
      this.id = id;
      this.name = name;
      this.measureUnit = measureUnit;
      this.userId = userId;
      this.userName = userName;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WasteClassificationDTO)) {
         return false;
      }

      WasteClassificationDTO other = (WasteClassificationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$measureUnit = this.getMeasureUnit();
               Object other$measureUnit = other.getMeasureUnit();
               if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                  Object this$userName = this.getUserName();
                  Object other$userName = other.getUserName();
                  return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
      return other instanceof WasteClassificationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "WasteClassificationDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   public static class WasteClassificationDTOBuilder {
      private Long id;
      private String name;
      private String measureUnit;
      private Long userId;
      private String userName;

      WasteClassificationDTOBuilder() {
      }

      public WasteClassificationDTO.WasteClassificationDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WasteClassificationDTO.WasteClassificationDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WasteClassificationDTO.WasteClassificationDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public WasteClassificationDTO.WasteClassificationDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public WasteClassificationDTO.WasteClassificationDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public WasteClassificationDTO build() {
         return new WasteClassificationDTO(this.id, this.name, this.measureUnit, this.userId, this.userName);
      }

      @Override
      public String toString() {
         return "WasteClassificationDTO.WasteClassificationDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", measureUnit="
            + this.measureUnit
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
