package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.util.List;

public class DeviceQueryByMaterialDTOParam {
   private String serialNumber;
   private Long workshopId;
   private Long warehouseId;
   private List<Long> workshopIds;
   private List<Long> classifyIds;
   private String classifyName;
   private Boolean boolCross;
   private Long warehouseConfigId;
   private String token;

   public static DeviceQueryByMaterialDTOParam.DeviceQueryByMaterialDTOParamBuilder builder() {
      return new DeviceQueryByMaterialDTOParam.DeviceQueryByMaterialDTOParamBuilder();
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public List<Long> getWorkshopIds() {
      return this.workshopIds;
   }

   public List<Long> getClassifyIds() {
      return this.classifyIds;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Boolean getBoolCross() {
      return this.boolCross;
   }

   public Long getWarehouseConfigId() {
      return this.warehouseConfigId;
   }

   public String getToken() {
      return this.token;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setWorkshopIds(final List<Long> workshopIds) {
      this.workshopIds = workshopIds;
   }

   public void setClassifyIds(final List<Long> classifyIds) {
      this.classifyIds = classifyIds;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setBoolCross(final Boolean boolCross) {
      this.boolCross = boolCross;
   }

   public void setWarehouseConfigId(final Long warehouseConfigId) {
      this.warehouseConfigId = warehouseConfigId;
   }

   public void setToken(final String token) {
      this.token = token;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DeviceQueryByMaterialDTOParam)) {
         return false;
      }

      DeviceQueryByMaterialDTOParam other = (DeviceQueryByMaterialDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$warehouseId = this.getWarehouseId();
         Object other$warehouseId = other.getWarehouseId();
         if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
            Object this$boolCross = this.getBoolCross();
            Object other$boolCross = other.getBoolCross();
            if (this$boolCross == null ? other$boolCross == null : this$boolCross.equals(other$boolCross)) {
               Object this$warehouseConfigId = this.getWarehouseConfigId();
               Object other$warehouseConfigId = other.getWarehouseConfigId();
               if (this$warehouseConfigId == null ? other$warehouseConfigId == null : this$warehouseConfigId.equals(other$warehouseConfigId)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$workshopIds = this.getWorkshopIds();
                     Object other$workshopIds = other.getWorkshopIds();
                     if (this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds)) {
                        Object this$classifyIds = this.getClassifyIds();
                        Object other$classifyIds = other.getClassifyIds();
                        if (this$classifyIds == null ? other$classifyIds == null : this$classifyIds.equals(other$classifyIds)) {
                           Object this$classifyName = this.getClassifyName();
                           Object other$classifyName = other.getClassifyName();
                           if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                              Object this$token = this.getToken();
                              Object other$token = other.getToken();
                              return this$token == null ? other$token == null : this$token.equals(other$token);
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
      return other instanceof DeviceQueryByMaterialDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $boolCross = this.getBoolCross();
      result = result * 59 + ($boolCross == null ? 43 : $boolCross.hashCode());
      Object $warehouseConfigId = this.getWarehouseConfigId();
      result = result * 59 + ($warehouseConfigId == null ? 43 : $warehouseConfigId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      result = result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
      Object $classifyIds = this.getClassifyIds();
      result = result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $token = this.getToken();
      return result * 59 + ($token == null ? 43 : $token.hashCode());
   }

   @Override
   public String toString() {
      return "DeviceQueryByMaterialDTOParam(serialNumber="
         + this.getSerialNumber()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", classifyName="
         + this.getClassifyName()
         + ", boolCross="
         + this.getBoolCross()
         + ", warehouseConfigId="
         + this.getWarehouseConfigId()
         + ", token="
         + this.getToken()
         + ")";
   }

   public DeviceQueryByMaterialDTOParam(
      final String serialNumber,
      final Long workshopId,
      final Long warehouseId,
      final List<Long> workshopIds,
      final List<Long> classifyIds,
      final String classifyName,
      final Boolean boolCross,
      final Long warehouseConfigId,
      final String token
   ) {
      this.serialNumber = serialNumber;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.workshopIds = workshopIds;
      this.classifyIds = classifyIds;
      this.classifyName = classifyName;
      this.boolCross = boolCross;
      this.warehouseConfigId = warehouseConfigId;
      this.token = token;
   }

   public DeviceQueryByMaterialDTOParam() {
   }

   public static class DeviceQueryByMaterialDTOParamBuilder {
      private String serialNumber;
      private Long workshopId;
      private Long warehouseId;
      private List<Long> workshopIds;
      private List<Long> classifyIds;
      private String classifyName;
      private Boolean boolCross;
      private Long warehouseConfigId;
      private String token;

      DeviceQueryByMaterialDTOParamBuilder() {
      }

      public DeviceQueryByMaterialDTOParam.DeviceQueryByMaterialDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public DeviceQueryByMaterialDTOParam.DeviceQueryByMaterialDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public DeviceQueryByMaterialDTOParam.DeviceQueryByMaterialDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public DeviceQueryByMaterialDTOParam.DeviceQueryByMaterialDTOParamBuilder workshopIds(final List<Long> workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public DeviceQueryByMaterialDTOParam.DeviceQueryByMaterialDTOParamBuilder classifyIds(final List<Long> classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      public DeviceQueryByMaterialDTOParam.DeviceQueryByMaterialDTOParamBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public DeviceQueryByMaterialDTOParam.DeviceQueryByMaterialDTOParamBuilder boolCross(final Boolean boolCross) {
         this.boolCross = boolCross;
         return this;
      }

      public DeviceQueryByMaterialDTOParam.DeviceQueryByMaterialDTOParamBuilder warehouseConfigId(final Long warehouseConfigId) {
         this.warehouseConfigId = warehouseConfigId;
         return this;
      }

      public DeviceQueryByMaterialDTOParam.DeviceQueryByMaterialDTOParamBuilder token(final String token) {
         this.token = token;
         return this;
      }

      public DeviceQueryByMaterialDTOParam build() {
         return new DeviceQueryByMaterialDTOParam(
            this.serialNumber,
            this.workshopId,
            this.warehouseId,
            this.workshopIds,
            this.classifyIds,
            this.classifyName,
            this.boolCross,
            this.warehouseConfigId,
            this.token
         );
      }

      @Override
      public String toString() {
         return "DeviceQueryByMaterialDTOParam.DeviceQueryByMaterialDTOParamBuilder(serialNumber="
            + this.serialNumber
            + ", workshopId="
            + this.workshopId
            + ", warehouseId="
            + this.warehouseId
            + ", workshopIds="
            + this.workshopIds
            + ", classifyIds="
            + this.classifyIds
            + ", classifyName="
            + this.classifyName
            + ", boolCross="
            + this.boolCross
            + ", warehouseConfigId="
            + this.warehouseConfigId
            + ", token="
            + this.token
            + ")";
      }
   }
}
