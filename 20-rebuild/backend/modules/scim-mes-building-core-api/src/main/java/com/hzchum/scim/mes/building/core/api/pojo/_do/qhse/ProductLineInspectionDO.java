package com.hzchum.scim.mes.building.core.api.pojo._do.qhse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;

@ApiModel(value = "productLineInspectionDO对象", description = "产线质检信息统计返回类")
public class ProductLineInspectionDO {
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   private Long factoryId;
   @ApiModelProperty(name = "factoryName", value = "工厂名", notes = "工厂名")
   private String factoryName;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", value = "车间名", notes = "车间名")
   private String workshopName;
   @ApiModelProperty(name = "productionLineId", value = "产线id", notes = "产线id")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineName", value = "产线名", notes = "产线名")
   private String productionLineName;
   @ApiModelProperty(name = "passRate", value = "总合格率", notes = "总合格率")
   private String passRate;
   @ApiModelProperty(name = "processData", value = "工序质检详情", notes = "工序质检详情")
   private Map<Long, QualifiedNumberDO> processData;

   public static ProductLineInspectionDO.ProductLineInspectionDOBuilder builder() {
      return new ProductLineInspectionDO.ProductLineInspectionDOBuilder();
   }

   public ProductLineInspectionDO() {
   }

   public ProductLineInspectionDO(
      final Long factoryId,
      final String factoryName,
      final Long workshopId,
      final String workshopName,
      final Long productionLineId,
      final String productionLineName,
      final String passRate,
      final Map<Long, QualifiedNumberDO> processData
   ) {
      this.factoryId = factoryId;
      this.factoryName = factoryName;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.passRate = passRate;
      this.processData = processData;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getFactoryName() {
      return this.factoryName;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public String getPassRate() {
      return this.passRate;
   }

   public Map<Long, QualifiedNumberDO> getProcessData() {
      return this.processData;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
   }

   public void setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
   }

   public void setPassRate(final String passRate) {
      this.passRate = passRate;
   }

   public void setProcessData(final Map<Long, QualifiedNumberDO> processData) {
      this.processData = processData;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductLineInspectionDO)) {
         return false;
      }

      ProductLineInspectionDO other = (ProductLineInspectionDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$factoryId = this.getFactoryId();
      Object other$factoryId = other.getFactoryId();
      if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$productionLineId = this.getProductionLineId();
            Object other$productionLineId = other.getProductionLineId();
            if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
               Object this$factoryName = this.getFactoryName();
               Object other$factoryName = other.getFactoryName();
               if (this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName)) {
                  Object this$workshopName = this.getWorkshopName();
                  Object other$workshopName = other.getWorkshopName();
                  if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                     Object this$productionLineName = this.getProductionLineName();
                     Object other$productionLineName = other.getProductionLineName();
                     if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
                        Object this$passRate = this.getPassRate();
                        Object other$passRate = other.getPassRate();
                        if (this$passRate == null ? other$passRate == null : this$passRate.equals(other$passRate)) {
                           Object this$processData = this.getProcessData();
                           Object other$processData = other.getProcessData();
                           return this$processData == null ? other$processData == null : this$processData.equals(other$processData);
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
      return other instanceof ProductLineInspectionDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $passRate = this.getPassRate();
      result = result * 59 + ($passRate == null ? 43 : $passRate.hashCode());
      Object $processData = this.getProcessData();
      return result * 59 + ($processData == null ? 43 : $processData.hashCode());
   }

   @Override
   public String toString() {
      return "ProductLineInspectionDO(factoryId="
         + this.getFactoryId()
         + ", factoryName="
         + this.getFactoryName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", passRate="
         + this.getPassRate()
         + ", processData="
         + this.getProcessData()
         + ")";
   }

   public static class ProductLineInspectionDOBuilder {
      private Long factoryId;
      private String factoryName;
      private Long workshopId;
      private String workshopName;
      private Long productionLineId;
      private String productionLineName;
      private String passRate;
      private Map<Long, QualifiedNumberDO> processData;

      ProductLineInspectionDOBuilder() {
      }

      public ProductLineInspectionDO.ProductLineInspectionDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public ProductLineInspectionDO.ProductLineInspectionDOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      public ProductLineInspectionDO.ProductLineInspectionDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public ProductLineInspectionDO.ProductLineInspectionDOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public ProductLineInspectionDO.ProductLineInspectionDOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public ProductLineInspectionDO.ProductLineInspectionDOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      public ProductLineInspectionDO.ProductLineInspectionDOBuilder passRate(final String passRate) {
         this.passRate = passRate;
         return this;
      }

      public ProductLineInspectionDO.ProductLineInspectionDOBuilder processData(final Map<Long, QualifiedNumberDO> processData) {
         this.processData = processData;
         return this;
      }

      public ProductLineInspectionDO build() {
         return new ProductLineInspectionDO(
            this.factoryId,
            this.factoryName,
            this.workshopId,
            this.workshopName,
            this.productionLineId,
            this.productionLineName,
            this.passRate,
            this.processData
         );
      }

      @Override
      public String toString() {
         return "ProductLineInspectionDO.ProductLineInspectionDOBuilder(factoryId="
            + this.factoryId
            + ", factoryName="
            + this.factoryName
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", productionLineId="
            + this.productionLineId
            + ", productionLineName="
            + this.productionLineName
            + ", passRate="
            + this.passRate
            + ", processData="
            + this.processData
            + ")";
      }
   }
}
