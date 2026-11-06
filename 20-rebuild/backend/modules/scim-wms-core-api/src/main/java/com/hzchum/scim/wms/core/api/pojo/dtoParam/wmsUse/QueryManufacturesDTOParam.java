package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.util.List;

public class QueryManufacturesDTOParam {
   private Long projectId;
   private Long factoryId;
   private List<Long> areaIds;
   private String name;
   private String serialNumber;
   private Integer basicClass;
   private Integer projectWarehouseType;

   public static QueryManufacturesDTOParam.QueryManufacturesDTOParamBuilder builder() {
      return new QueryManufacturesDTOParam.QueryManufacturesDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public List<Long> getAreaIds() {
      return this.areaIds;
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

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setAreaIds(final List<Long> areaIds) {
      this.areaIds = areaIds;
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

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryManufacturesDTOParam)) {
         return false;
      }

      QueryManufacturesDTOParam other = (QueryManufacturesDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$projectWarehouseType = this.getProjectWarehouseType();
               Object other$projectWarehouseType = other.getProjectWarehouseType();
               if (this$projectWarehouseType == null ? other$projectWarehouseType == null : this$projectWarehouseType.equals(other$projectWarehouseType)) {
                  Object this$areaIds = this.getAreaIds();
                  Object other$areaIds = other.getAreaIds();
                  if (this$areaIds == null ? other$areaIds == null : this$areaIds.equals(other$areaIds)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryManufacturesDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $areaIds = this.getAreaIds();
      result = result * 59 + ($areaIds == null ? 43 : $areaIds.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "QueryManufacturesDTOParam(projectId="
         + this.getProjectId()
         + ", factoryId="
         + this.getFactoryId()
         + ", areaIds="
         + this.getAreaIds()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", basicClass="
         + this.getBasicClass()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ")";
   }

   public QueryManufacturesDTOParam(
      final Long projectId,
      final Long factoryId,
      final List<Long> areaIds,
      final String name,
      final String serialNumber,
      final Integer basicClass,
      final Integer projectWarehouseType
   ) {
      this.projectId = projectId;
      this.factoryId = factoryId;
      this.areaIds = areaIds;
      this.name = name;
      this.serialNumber = serialNumber;
      this.basicClass = basicClass;
      this.projectWarehouseType = projectWarehouseType;
   }

   public QueryManufacturesDTOParam() {
   }

   public static class QueryManufacturesDTOParamBuilder {
      private Long projectId;
      private Long factoryId;
      private List<Long> areaIds;
      private String name;
      private String serialNumber;
      private Integer basicClass;
      private Integer projectWarehouseType;

      QueryManufacturesDTOParamBuilder() {
      }

      public QueryManufacturesDTOParam.QueryManufacturesDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryManufacturesDTOParam.QueryManufacturesDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public QueryManufacturesDTOParam.QueryManufacturesDTOParamBuilder areaIds(final List<Long> areaIds) {
         this.areaIds = areaIds;
         return this;
      }

      public QueryManufacturesDTOParam.QueryManufacturesDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public QueryManufacturesDTOParam.QueryManufacturesDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryManufacturesDTOParam.QueryManufacturesDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryManufacturesDTOParam.QueryManufacturesDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryManufacturesDTOParam build() {
         return new QueryManufacturesDTOParam(
            this.projectId, this.factoryId, this.areaIds, this.name, this.serialNumber, this.basicClass, this.projectWarehouseType
         );
      }

      @Override
      public String toString() {
         return "QueryManufacturesDTOParam.QueryManufacturesDTOParamBuilder(projectId="
            + this.projectId
            + ", factoryId="
            + this.factoryId
            + ", areaIds="
            + this.areaIds
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", basicClass="
            + this.basicClass
            + ", projectWarehouseType="
            + this.projectWarehouseType
            + ")";
      }
   }
}
