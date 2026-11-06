package com.hzchum.scim.mes.building.core.api.pojo._dto.device;

import com.hzchum.scim.mes.building.core.api.pojo._do.device.MesWeighbridgeManagement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesWeighbridgeManagementDTO", description = "地磅管理DTO")
public class MesWeighbridgeManagementDTO extends MesWeighbridgeManagement {
   @ApiModelProperty(name = "factoryName", value = "工厂名称", notes = "工厂名称")
   private String factoryName;
   @ApiModelProperty(name = "workshopName", value = "车间名称", notes = "车间名称")
   private String workshopName;
   @ApiModelProperty(name = "userName", value = "用户名称", notes = "用户名称")
   private String userName;
   @ApiModelProperty(name = "lastEditorUserName", value = "最后编辑人名称", notes = "最后编辑人名称")
   private String lastEditorUserName;

   public MesWeighbridgeManagementDTO() {
   }

   public MesWeighbridgeManagementDTO(final String factoryName, final String workshopName, final String userName, final String lastEditorUserName) {
      this.factoryName = factoryName;
      this.workshopName = workshopName;
      this.userName = userName;
      this.lastEditorUserName = lastEditorUserName;
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

   public MesWeighbridgeManagementDTO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   public MesWeighbridgeManagementDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   public MesWeighbridgeManagementDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public MesWeighbridgeManagementDTO setLastEditorUserName(final String lastEditorUserName) {
      this.lastEditorUserName = lastEditorUserName;
      return this;
   }

   @Override
   public String toString() {
      return "MesWeighbridgeManagementDTO(factoryName="
         + this.getFactoryName()
         + ", workshopName="
         + this.getWorkshopName()
         + ", userName="
         + this.getUserName()
         + ", lastEditorUserName="
         + this.getLastEditorUserName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWeighbridgeManagementDTO)) {
         return false;
      }

      MesWeighbridgeManagementDTO other = (MesWeighbridgeManagementDTO)o;
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
               return this$lastEditorUserName == null ? other$lastEditorUserName == null : this$lastEditorUserName.equals(other$lastEditorUserName);
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
      return other instanceof MesWeighbridgeManagementDTO;
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
      return result * 59 + ($lastEditorUserName == null ? 43 : $lastEditorUserName.hashCode());
   }
}
