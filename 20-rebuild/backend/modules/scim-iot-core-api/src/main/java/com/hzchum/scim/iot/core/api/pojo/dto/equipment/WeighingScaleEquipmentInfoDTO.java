package com.hzchum.scim.iot.core.api.pojo.dto.equipment;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.WeighingScaleEquipmentInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WeighingScaleEquipmentInfoDTO", description = "地磅管理DTO")
public class WeighingScaleEquipmentInfoDTO extends WeighingScaleEquipmentInfo {
   @ApiModelProperty(name = "factoryName", value = "工厂名称", notes = "工厂名称")
   private String factoryName;
   @ApiModelProperty(name = "workshopName", value = "车间名称", notes = "车间名称")
   private String workshopName;
   @ApiModelProperty(name = "userName", value = "用户名称", notes = "用户名称")
   private String userName;
   @ApiModelProperty(name = "lastEditorUserName", value = "最后编辑人名称", notes = "最后编辑人名称")
   private String lastEditorUserName;
   @ApiModelProperty(name = "factory", notes = "工厂(app展示使用)")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private NameInfo factory;
   @ApiModelProperty(name = "workshop", notes = "车间(app展示使用)")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private NameInfo workshop;

   public WeighingScaleEquipmentInfoDTO() {
   }

   public WeighingScaleEquipmentInfoDTO(
      final String factoryName,
      final String workshopName,
      final String userName,
      final String lastEditorUserName,
      final NameInfo factory,
      final NameInfo workshop
   ) {
      this.factoryName = factoryName;
      this.workshopName = workshopName;
      this.userName = userName;
      this.lastEditorUserName = lastEditorUserName;
      this.factory = factory;
      this.workshop = workshop;
   }

   public String getFactoryName() {
      return this.factoryName;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getLastEditorUserName() {
      return this.lastEditorUserName;
   }

   public NameInfo getFactory() {
      return this.factory;
   }

   public NameInfo getWorkshop() {
      return this.workshop;
   }

   public WeighingScaleEquipmentInfoDTO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   public WeighingScaleEquipmentInfoDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   public WeighingScaleEquipmentInfoDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public WeighingScaleEquipmentInfoDTO setLastEditorUserName(final String lastEditorUserName) {
      this.lastEditorUserName = lastEditorUserName;
      return this;
   }

   @JsonProperty("factory")
   public WeighingScaleEquipmentInfoDTO setFactory(final NameInfo factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public WeighingScaleEquipmentInfoDTO setWorkshop(final NameInfo workshop) {
      this.workshop = workshop;
      return this;
   }

   @Override
   public String toString() {
      return "WeighingScaleEquipmentInfoDTO(factoryName="
         + this.getFactoryName()
         + ", workshopName="
         + this.getWorkshopName()
         + ", userName="
         + this.getUserName()
         + ", lastEditorUserName="
         + this.getLastEditorUserName()
         + ", factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WeighingScaleEquipmentInfoDTO)) {
         return false;
      }

      WeighingScaleEquipmentInfoDTO other = (WeighingScaleEquipmentInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$factoryName = this.getFactoryName();
      Object other$factoryName = other.getFactoryName();
      if (this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName)) {
         Object this$workshopName = this.getWorkshopName();
         Object other$workshopName = other.getWorkshopName();
         if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
            Object this$userName = this.getUserName();
            Object other$userName = other.getUserName();
            if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
               Object this$lastEditorUserName = this.getLastEditorUserName();
               Object other$lastEditorUserName = other.getLastEditorUserName();
               if (this$lastEditorUserName == null ? other$lastEditorUserName == null : this$lastEditorUserName.equals(other$lastEditorUserName)) {
                  Object this$factory = this.getFactory();
                  Object other$factory = other.getFactory();
                  if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                     Object this$workshop = this.getWorkshop();
                     Object other$workshop = other.getWorkshop();
                     return this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WeighingScaleEquipmentInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $lastEditorUserName = this.getLastEditorUserName();
      result = result * 59 + ($lastEditorUserName == null ? 43 : $lastEditorUserName.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      return result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
   }
}
