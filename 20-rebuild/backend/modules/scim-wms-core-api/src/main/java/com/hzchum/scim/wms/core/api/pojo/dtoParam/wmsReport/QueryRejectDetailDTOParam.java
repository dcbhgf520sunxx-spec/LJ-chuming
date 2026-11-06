package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class QueryRejectDetailDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "warehouseId", value = "存储位置ID", notes = "存储位置ID")
   private Long warehouseId;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   private String brand;
   @ApiModelProperty(name = "classifyId", value = "科目id", notes = "科目id")
   private List<Long> classifyId;
   private List<Long> classifyIds;
   @ApiModelProperty(name = "projectWarehouseType", value = "1 公共 , 2 项目", notes = "1 公共 , 2 项目")
   private Integer projectWarehouseType;
   @ApiModelProperty(name = "orderSupplyType", value = "是否甲供 1非甲供 2甲供", notes = "是否甲供 1非甲供 2甲供")
   private Long orderSupplyType;
   @ApiModelProperty(name = "basicClass", value = "基础类型ID", notes = "基础类型ID")
   private Integer basicClass;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "rejectSN", value = "退货单号", notes = "退货单号")
   private String rejectSN;
   @ApiModelProperty(name = "purchaseSN", value = "采购单编号", notes = "采购单编号")
   private String purchaseSN;
   @ApiModelProperty(name = "inboundSN", value = "入库单编号", notes = "入库单编号")
   private String inboundSN;
   @ApiModelProperty(name = "supplierId", value = "供应商ID", notes = "供应商ID")
   private Long supplierId;
   @ApiModelProperty(name = "operatorName", value = "操作人姓名", notes = "操作人姓名")
   private String operatorName;
   @ApiModelProperty(name = "reviewTime", value = "审核时间", notes = "审核时间")
   private List<LocalDateTime> reviewTime;
   @ApiModelProperty(name = "rejectTime", value = "退货时间", notes = "退货时间")
   private List<LocalDateTime> rejectTime;
   @ApiModelProperty(name = "workshopIds", value = "仓库ID集", notes = "仓库ID集")
   private List<Long> workshopIds;

   public static QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder builder() {
      return new QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public String getBrand() {
      return this.brand;
   }

   public List<Long> getClassifyId() {
      return this.classifyId;
   }

   public List<Long> getClassifyIds() {
      return this.classifyIds;
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public Long getOrderSupplyType() {
      return this.orderSupplyType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getRejectSN() {
      return this.rejectSN;
   }

   public String getPurchaseSN() {
      return this.purchaseSN;
   }

   public String getInboundSN() {
      return this.inboundSN;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public List<LocalDateTime> getReviewTime() {
      return this.reviewTime;
   }

   public List<LocalDateTime> getRejectTime() {
      return this.rejectTime;
   }

   public List<Long> getWorkshopIds() {
      return this.workshopIds;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setClassifyId(final List<Long> classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyIds(final List<Long> classifyIds) {
      this.classifyIds = classifyIds;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   public void setOrderSupplyType(final Long orderSupplyType) {
      this.orderSupplyType = orderSupplyType;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setRejectSN(final String rejectSN) {
      this.rejectSN = rejectSN;
   }

   public void setPurchaseSN(final String purchaseSN) {
      this.purchaseSN = purchaseSN;
   }

   public void setInboundSN(final String inboundSN) {
      this.inboundSN = inboundSN;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   public void setReviewTime(final List<LocalDateTime> reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setRejectTime(final List<LocalDateTime> rejectTime) {
      this.rejectTime = rejectTime;
   }

   public void setWorkshopIds(final List<Long> workshopIds) {
      this.workshopIds = workshopIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryRejectDetailDTOParam)) {
         return false;
      }

      QueryRejectDetailDTOParam other = (QueryRejectDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$warehouseId = this.getWarehouseId();
         Object other$warehouseId = other.getWarehouseId();
         if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
            Object this$projectWarehouseType = this.getProjectWarehouseType();
            Object other$projectWarehouseType = other.getProjectWarehouseType();
            if (this$projectWarehouseType == null ? other$projectWarehouseType == null : this$projectWarehouseType.equals(other$projectWarehouseType)) {
               Object this$orderSupplyType = this.getOrderSupplyType();
               Object other$orderSupplyType = other.getOrderSupplyType();
               if (this$orderSupplyType == null ? other$orderSupplyType == null : this$orderSupplyType.equals(other$orderSupplyType)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$supplierId = this.getSupplierId();
                     Object other$supplierId = other.getSupplierId();
                     if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                        Object this$brand = this.getBrand();
                        Object other$brand = other.getBrand();
                        if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                           Object this$classifyId = this.getClassifyId();
                           Object other$classifyId = other.getClassifyId();
                           if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                              Object this$classifyIds = this.getClassifyIds();
                              Object other$classifyIds = other.getClassifyIds();
                              if (this$classifyIds == null ? other$classifyIds == null : this$classifyIds.equals(other$classifyIds)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$rejectSN = this.getRejectSN();
                                    Object other$rejectSN = other.getRejectSN();
                                    if (this$rejectSN == null ? other$rejectSN == null : this$rejectSN.equals(other$rejectSN)) {
                                       Object this$purchaseSN = this.getPurchaseSN();
                                       Object other$purchaseSN = other.getPurchaseSN();
                                       if (this$purchaseSN == null ? other$purchaseSN == null : this$purchaseSN.equals(other$purchaseSN)) {
                                          Object this$inboundSN = this.getInboundSN();
                                          Object other$inboundSN = other.getInboundSN();
                                          if (this$inboundSN == null ? other$inboundSN == null : this$inboundSN.equals(other$inboundSN)) {
                                             Object this$operatorName = this.getOperatorName();
                                             Object other$operatorName = other.getOperatorName();
                                             if (this$operatorName == null ? other$operatorName == null : this$operatorName.equals(other$operatorName)) {
                                                Object this$reviewTime = this.getReviewTime();
                                                Object other$reviewTime = other.getReviewTime();
                                                if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                                                   Object this$rejectTime = this.getRejectTime();
                                                   Object other$rejectTime = other.getRejectTime();
                                                   if (this$rejectTime == null ? other$rejectTime == null : this$rejectTime.equals(other$rejectTime)) {
                                                      Object this$workshopIds = this.getWorkshopIds();
                                                      Object other$workshopIds = other.getWorkshopIds();
                                                      return this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds);
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
      return other instanceof QueryRejectDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $orderSupplyType = this.getOrderSupplyType();
      result = result * 59 + ($orderSupplyType == null ? 43 : $orderSupplyType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $classifyIds = this.getClassifyIds();
      result = result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $rejectSN = this.getRejectSN();
      result = result * 59 + ($rejectSN == null ? 43 : $rejectSN.hashCode());
      Object $purchaseSN = this.getPurchaseSN();
      result = result * 59 + ($purchaseSN == null ? 43 : $purchaseSN.hashCode());
      Object $inboundSN = this.getInboundSN();
      result = result * 59 + ($inboundSN == null ? 43 : $inboundSN.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $rejectTime = this.getRejectTime();
      result = result * 59 + ($rejectTime == null ? 43 : $rejectTime.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      return result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
   }

   @Override
   public String toString() {
      return "QueryRejectDetailDTOParam(projectId="
         + this.getProjectId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", brand="
         + this.getBrand()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ", orderSupplyType="
         + this.getOrderSupplyType()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", rejectSN="
         + this.getRejectSN()
         + ", purchaseSN="
         + this.getPurchaseSN()
         + ", inboundSN="
         + this.getInboundSN()
         + ", supplierId="
         + this.getSupplierId()
         + ", operatorName="
         + this.getOperatorName()
         + ", reviewTime="
         + this.getReviewTime()
         + ", rejectTime="
         + this.getRejectTime()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ")";
   }

   public QueryRejectDetailDTOParam(
      final Long projectId,
      final Long warehouseId,
      final String brand,
      final List<Long> classifyId,
      final List<Long> classifyIds,
      final Integer projectWarehouseType,
      final Long orderSupplyType,
      final Integer basicClass,
      final String specification,
      final String rejectSN,
      final String purchaseSN,
      final String inboundSN,
      final Long supplierId,
      final String operatorName,
      final List<LocalDateTime> reviewTime,
      final List<LocalDateTime> rejectTime,
      final List<Long> workshopIds
   ) {
      this.projectId = projectId;
      this.warehouseId = warehouseId;
      this.brand = brand;
      this.classifyId = classifyId;
      this.classifyIds = classifyIds;
      this.projectWarehouseType = projectWarehouseType;
      this.orderSupplyType = orderSupplyType;
      this.basicClass = basicClass;
      this.specification = specification;
      this.rejectSN = rejectSN;
      this.purchaseSN = purchaseSN;
      this.inboundSN = inboundSN;
      this.supplierId = supplierId;
      this.operatorName = operatorName;
      this.reviewTime = reviewTime;
      this.rejectTime = rejectTime;
      this.workshopIds = workshopIds;
   }

   public QueryRejectDetailDTOParam() {
   }

   public static class QueryRejectDetailDTOParamBuilder {
      private Long projectId;
      private Long warehouseId;
      private String brand;
      private List<Long> classifyId;
      private List<Long> classifyIds;
      private Integer projectWarehouseType;
      private Long orderSupplyType;
      private Integer basicClass;
      private String specification;
      private String rejectSN;
      private String purchaseSN;
      private String inboundSN;
      private Long supplierId;
      private String operatorName;
      private List<LocalDateTime> reviewTime;
      private List<LocalDateTime> rejectTime;
      private List<Long> workshopIds;

      QueryRejectDetailDTOParamBuilder() {
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder classifyId(final List<Long> classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder classifyIds(final List<Long> classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder orderSupplyType(final Long orderSupplyType) {
         this.orderSupplyType = orderSupplyType;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder rejectSN(final String rejectSN) {
         this.rejectSN = rejectSN;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder purchaseSN(final String purchaseSN) {
         this.purchaseSN = purchaseSN;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder inboundSN(final String inboundSN) {
         this.inboundSN = inboundSN;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder reviewTime(final List<LocalDateTime> reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder rejectTime(final List<LocalDateTime> rejectTime) {
         this.rejectTime = rejectTime;
         return this;
      }

      public QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder workshopIds(final List<Long> workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public QueryRejectDetailDTOParam build() {
         return new QueryRejectDetailDTOParam(
            this.projectId,
            this.warehouseId,
            this.brand,
            this.classifyId,
            this.classifyIds,
            this.projectWarehouseType,
            this.orderSupplyType,
            this.basicClass,
            this.specification,
            this.rejectSN,
            this.purchaseSN,
            this.inboundSN,
            this.supplierId,
            this.operatorName,
            this.reviewTime,
            this.rejectTime,
            this.workshopIds
         );
      }

      @Override
      public String toString() {
         return "QueryRejectDetailDTOParam.QueryRejectDetailDTOParamBuilder(projectId="
            + this.projectId
            + ", warehouseId="
            + this.warehouseId
            + ", brand="
            + this.brand
            + ", classifyId="
            + this.classifyId
            + ", classifyIds="
            + this.classifyIds
            + ", projectWarehouseType="
            + this.projectWarehouseType
            + ", orderSupplyType="
            + this.orderSupplyType
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", rejectSN="
            + this.rejectSN
            + ", purchaseSN="
            + this.purchaseSN
            + ", inboundSN="
            + this.inboundSN
            + ", supplierId="
            + this.supplierId
            + ", operatorName="
            + this.operatorName
            + ", reviewTime="
            + this.reviewTime
            + ", rejectTime="
            + this.rejectTime
            + ", workshopIds="
            + this.workshopIds
            + ")";
      }
   }
}
