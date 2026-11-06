package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import java.time.LocalDateTime;
import java.util.List;

public class QueryManufacturesOutboundDTOParam {
   private List<LocalDateTime> outboundTime;
   private Long workshopId;
   private String trainNumber;
   private String name;
   private String serialNumber;
   private Integer basicClass;
   private Long projectId;
   private Integer productType;

   public static QueryManufacturesOutboundDTOParam.QueryManufacturesOutboundDTOParamBuilder builder() {
      return new QueryManufacturesOutboundDTOParam.QueryManufacturesOutboundDTOParamBuilder();
   }

   public List<LocalDateTime> getOutboundTime() {
      return this.outboundTime;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getTrainNumber() {
      return this.trainNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public void setOutboundTime(final List<LocalDateTime> outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setTrainNumber(final String trainNumber) {
      this.trainNumber = trainNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryManufacturesOutboundDTOParam)) {
         return false;
      }

      QueryManufacturesOutboundDTOParam other = (QueryManufacturesOutboundDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$outboundTime = this.getOutboundTime();
                  Object other$outboundTime = other.getOutboundTime();
                  if (this$outboundTime == null ? other$outboundTime == null : this$outboundTime.equals(other$outboundTime)) {
                     Object this$trainNumber = this.getTrainNumber();
                     Object other$trainNumber = other.getTrainNumber();
                     if (this$trainNumber == null ? other$trainNumber == null : this$trainNumber.equals(other$trainNumber)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof QueryManufacturesOutboundDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $trainNumber = this.getTrainNumber();
      result = result * 59 + ($trainNumber == null ? 43 : $trainNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "QueryManufacturesOutboundDTOParam(outboundTime="
         + this.getOutboundTime()
         + ", workshopId="
         + this.getWorkshopId()
         + ", trainNumber="
         + this.getTrainNumber()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", basicClass="
         + this.getBasicClass()
         + ", projectId="
         + this.getProjectId()
         + ", productType="
         + this.getProductType()
         + ")";
   }

   public QueryManufacturesOutboundDTOParam(
      final List<LocalDateTime> outboundTime,
      final Long workshopId,
      final String trainNumber,
      final String name,
      final String serialNumber,
      final Integer basicClass,
      final Long projectId,
      final Integer productType
   ) {
      this.outboundTime = outboundTime;
      this.workshopId = workshopId;
      this.trainNumber = trainNumber;
      this.name = name;
      this.serialNumber = serialNumber;
      this.basicClass = basicClass;
      this.projectId = projectId;
      this.productType = productType;
   }

   public QueryManufacturesOutboundDTOParam() {
   }

   public static class QueryManufacturesOutboundDTOParamBuilder {
      private List<LocalDateTime> outboundTime;
      private Long workshopId;
      private String trainNumber;
      private String name;
      private String serialNumber;
      private Integer basicClass;
      private Long projectId;
      private Integer productType;

      QueryManufacturesOutboundDTOParamBuilder() {
      }

      public QueryManufacturesOutboundDTOParam.QueryManufacturesOutboundDTOParamBuilder outboundTime(final List<LocalDateTime> outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public QueryManufacturesOutboundDTOParam.QueryManufacturesOutboundDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public QueryManufacturesOutboundDTOParam.QueryManufacturesOutboundDTOParamBuilder trainNumber(final String trainNumber) {
         this.trainNumber = trainNumber;
         return this;
      }

      public QueryManufacturesOutboundDTOParam.QueryManufacturesOutboundDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public QueryManufacturesOutboundDTOParam.QueryManufacturesOutboundDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryManufacturesOutboundDTOParam.QueryManufacturesOutboundDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryManufacturesOutboundDTOParam.QueryManufacturesOutboundDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryManufacturesOutboundDTOParam.QueryManufacturesOutboundDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public QueryManufacturesOutboundDTOParam build() {
         return new QueryManufacturesOutboundDTOParam(
            this.outboundTime, this.workshopId, this.trainNumber, this.name, this.serialNumber, this.basicClass, this.projectId, this.productType
         );
      }

      @Override
      public String toString() {
         return "QueryManufacturesOutboundDTOParam.QueryManufacturesOutboundDTOParamBuilder(outboundTime="
            + this.outboundTime
            + ", workshopId="
            + this.workshopId
            + ", trainNumber="
            + this.trainNumber
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", basicClass="
            + this.basicClass
            + ", projectId="
            + this.projectId
            + ", productType="
            + this.productType
            + ")";
      }
   }
}
