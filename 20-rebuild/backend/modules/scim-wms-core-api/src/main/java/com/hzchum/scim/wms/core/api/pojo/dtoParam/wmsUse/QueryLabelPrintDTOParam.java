package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import java.util.List;

public class QueryLabelPrintDTOParam {
   private Boolean boolPrinted;
   private Integer materialLabelPrintType;
   private Integer projectWarehouseType;
   private Long projectId;
   private Integer basicClass;
   private List<LocalDateTime> createDate;
   private Boolean boolPartyA;

   public static QueryLabelPrintDTOParam.QueryLabelPrintDTOParamBuilder builder() {
      return new QueryLabelPrintDTOParam.QueryLabelPrintDTOParamBuilder();
   }

   public Boolean getBoolPrinted() {
      return this.boolPrinted;
   }

   public Integer getMaterialLabelPrintType() {
      return this.materialLabelPrintType;
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public List<LocalDateTime> getCreateDate() {
      return this.createDate;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public void setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
   }

   public void setMaterialLabelPrintType(final Integer materialLabelPrintType) {
      this.materialLabelPrintType = materialLabelPrintType;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setCreateDate(final List<LocalDateTime> createDate) {
      this.createDate = createDate;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryLabelPrintDTOParam)) {
         return false;
      }

      QueryLabelPrintDTOParam other = (QueryLabelPrintDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolPrinted = this.getBoolPrinted();
      Object other$boolPrinted = other.getBoolPrinted();
      if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
         Object this$materialLabelPrintType = this.getMaterialLabelPrintType();
         Object other$materialLabelPrintType = other.getMaterialLabelPrintType();
         if (this$materialLabelPrintType == null ? other$materialLabelPrintType == null : this$materialLabelPrintType.equals(other$materialLabelPrintType)) {
            Object this$projectWarehouseType = this.getProjectWarehouseType();
            Object other$projectWarehouseType = other.getProjectWarehouseType();
            if (this$projectWarehouseType == null ? other$projectWarehouseType == null : this$projectWarehouseType.equals(other$projectWarehouseType)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$boolPartyA = this.getBoolPartyA();
                     Object other$boolPartyA = other.getBoolPartyA();
                     if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                        Object this$createDate = this.getCreateDate();
                        Object other$createDate = other.getCreateDate();
                        return this$createDate == null ? other$createDate == null : this$createDate.equals(other$createDate);
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
      return other instanceof QueryLabelPrintDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $materialLabelPrintType = this.getMaterialLabelPrintType();
      result = result * 59 + ($materialLabelPrintType == null ? 43 : $materialLabelPrintType.hashCode());
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $createDate = this.getCreateDate();
      return result * 59 + ($createDate == null ? 43 : $createDate.hashCode());
   }

   @Override
   public String toString() {
      return "QueryLabelPrintDTOParam(boolPrinted="
         + this.getBoolPrinted()
         + ", materialLabelPrintType="
         + this.getMaterialLabelPrintType()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ", projectId="
         + this.getProjectId()
         + ", basicClass="
         + this.getBasicClass()
         + ", createDate="
         + this.getCreateDate()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ")";
   }

   public QueryLabelPrintDTOParam(
      final Boolean boolPrinted,
      final Integer materialLabelPrintType,
      final Integer projectWarehouseType,
      final Long projectId,
      final Integer basicClass,
      final List<LocalDateTime> createDate,
      final Boolean boolPartyA
   ) {
      this.boolPrinted = boolPrinted;
      this.materialLabelPrintType = materialLabelPrintType;
      this.projectWarehouseType = projectWarehouseType;
      this.projectId = projectId;
      this.basicClass = basicClass;
      this.createDate = createDate;
      this.boolPartyA = boolPartyA;
   }

   public QueryLabelPrintDTOParam() {
   }

   public static class QueryLabelPrintDTOParamBuilder {
      private Boolean boolPrinted;
      private Integer materialLabelPrintType;
      private Integer projectWarehouseType;
      private Long projectId;
      private Integer basicClass;
      private List<LocalDateTime> createDate;
      private Boolean boolPartyA;

      QueryLabelPrintDTOParamBuilder() {
      }

      public QueryLabelPrintDTOParam.QueryLabelPrintDTOParamBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      public QueryLabelPrintDTOParam.QueryLabelPrintDTOParamBuilder materialLabelPrintType(final Integer materialLabelPrintType) {
         this.materialLabelPrintType = materialLabelPrintType;
         return this;
      }

      public QueryLabelPrintDTOParam.QueryLabelPrintDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryLabelPrintDTOParam.QueryLabelPrintDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryLabelPrintDTOParam.QueryLabelPrintDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryLabelPrintDTOParam.QueryLabelPrintDTOParamBuilder createDate(final List<LocalDateTime> createDate) {
         this.createDate = createDate;
         return this;
      }

      public QueryLabelPrintDTOParam.QueryLabelPrintDTOParamBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public QueryLabelPrintDTOParam build() {
         return new QueryLabelPrintDTOParam(
            this.boolPrinted, this.materialLabelPrintType, this.projectWarehouseType, this.projectId, this.basicClass, this.createDate, this.boolPartyA
         );
      }

      @Override
      public String toString() {
         return "QueryLabelPrintDTOParam.QueryLabelPrintDTOParamBuilder(boolPrinted="
            + this.boolPrinted
            + ", materialLabelPrintType="
            + this.materialLabelPrintType
            + ", projectWarehouseType="
            + this.projectWarehouseType
            + ", projectId="
            + this.projectId
            + ", basicClass="
            + this.basicClass
            + ", createDate="
            + this.createDate
            + ", boolPartyA="
            + this.boolPartyA
            + ")";
      }
   }
}
