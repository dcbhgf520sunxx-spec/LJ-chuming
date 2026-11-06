package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import java.math.BigDecimal;

public class QueryProjectPickingDTOParam {
   private Integer basicClass;
   private Long workShopId;
   private BigDecimal thickness;
   private String material;
   private String specification;
   private Long projectId;
   private String time;
   private String prefixSpecification;

   public static QueryProjectPickingDTOParam.QueryProjectPickingDTOParamBuilder builder() {
      return new QueryProjectPickingDTOParam.QueryProjectPickingDTOParamBuilder();
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getTime() {
      return this.time;
   }

   public String getPrefixSpecification() {
      return this.prefixSpecification;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setTime(final String time) {
      this.time = time;
   }

   public void setPrefixSpecification(final String prefixSpecification) {
      this.prefixSpecification = prefixSpecification;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryProjectPickingDTOParam)) {
         return false;
      }

      QueryProjectPickingDTOParam other = (QueryProjectPickingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$workShopId = this.getWorkShopId();
         Object other$workShopId = other.getWorkShopId();
         if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$thickness = this.getThickness();
               Object other$thickness = other.getThickness();
               if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                  Object this$material = this.getMaterial();
                  Object other$material = other.getMaterial();
                  if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$time = this.getTime();
                        Object other$time = other.getTime();
                        if (this$time == null ? other$time == null : this$time.equals(other$time)) {
                           Object this$prefixSpecification = this.getPrefixSpecification();
                           Object other$prefixSpecification = other.getPrefixSpecification();
                           return this$prefixSpecification == null
                              ? other$prefixSpecification == null
                              : this$prefixSpecification.equals(other$prefixSpecification);
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
      return other instanceof QueryProjectPickingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $time = this.getTime();
      result = result * 59 + ($time == null ? 43 : $time.hashCode());
      Object $prefixSpecification = this.getPrefixSpecification();
      return result * 59 + ($prefixSpecification == null ? 43 : $prefixSpecification.hashCode());
   }

   @Override
   public String toString() {
      return "QueryProjectPickingDTOParam(basicClass="
         + this.getBasicClass()
         + ", workShopId="
         + this.getWorkShopId()
         + ", thickness="
         + this.getThickness()
         + ", material="
         + this.getMaterial()
         + ", specification="
         + this.getSpecification()
         + ", projectId="
         + this.getProjectId()
         + ", time="
         + this.getTime()
         + ", prefixSpecification="
         + this.getPrefixSpecification()
         + ")";
   }

   public QueryProjectPickingDTOParam(
      final Integer basicClass,
      final Long workShopId,
      final BigDecimal thickness,
      final String material,
      final String specification,
      final Long projectId,
      final String time,
      final String prefixSpecification
   ) {
      this.basicClass = basicClass;
      this.workShopId = workShopId;
      this.thickness = thickness;
      this.material = material;
      this.specification = specification;
      this.projectId = projectId;
      this.time = time;
      this.prefixSpecification = prefixSpecification;
   }

   public QueryProjectPickingDTOParam() {
   }

   public static class QueryProjectPickingDTOParamBuilder {
      private Integer basicClass;
      private Long workShopId;
      private BigDecimal thickness;
      private String material;
      private String specification;
      private Long projectId;
      private String time;
      private String prefixSpecification;

      QueryProjectPickingDTOParamBuilder() {
      }

      public QueryProjectPickingDTOParam.QueryProjectPickingDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryProjectPickingDTOParam.QueryProjectPickingDTOParamBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      public QueryProjectPickingDTOParam.QueryProjectPickingDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public QueryProjectPickingDTOParam.QueryProjectPickingDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public QueryProjectPickingDTOParam.QueryProjectPickingDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public QueryProjectPickingDTOParam.QueryProjectPickingDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryProjectPickingDTOParam.QueryProjectPickingDTOParamBuilder time(final String time) {
         this.time = time;
         return this;
      }

      public QueryProjectPickingDTOParam.QueryProjectPickingDTOParamBuilder prefixSpecification(final String prefixSpecification) {
         this.prefixSpecification = prefixSpecification;
         return this;
      }

      public QueryProjectPickingDTOParam build() {
         return new QueryProjectPickingDTOParam(
            this.basicClass, this.workShopId, this.thickness, this.material, this.specification, this.projectId, this.time, this.prefixSpecification
         );
      }

      @Override
      public String toString() {
         return "QueryProjectPickingDTOParam.QueryProjectPickingDTOParamBuilder(basicClass="
            + this.basicClass
            + ", workShopId="
            + this.workShopId
            + ", thickness="
            + this.thickness
            + ", material="
            + this.material
            + ", specification="
            + this.specification
            + ", projectId="
            + this.projectId
            + ", time="
            + this.time
            + ", prefixSpecification="
            + this.prefixSpecification
            + ")";
      }
   }
}
