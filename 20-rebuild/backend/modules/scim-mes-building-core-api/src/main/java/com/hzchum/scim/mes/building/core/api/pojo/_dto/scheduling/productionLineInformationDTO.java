package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "productionLineInformationDTO对象", description = "产线详细信息 ")
public class productionLineInformationDTO {
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
   @ApiModelProperty(name = "capacity", value = "产能", notes = "产能")
   private BigDecimal capacity;
   @ApiModelProperty(name = "factoryId", value = "分配量", notes = "分配量")
   private Long allocationWeight;
   @ApiModelProperty(name = "completed", value = "已完成", notes = "已完成")
   private Long completed;
   @ApiModelProperty(name = "incomplete", value = "未完成", notes = "未完成")
   private Long incomplete;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "date", value = "完成时间", notes = "完成时间")
   private LocalDateTime date;

   public static productionLineInformationDTO.productionLineInformationDTOBuilder builder() {
      return new productionLineInformationDTO.productionLineInformationDTOBuilder();
   }

   public productionLineInformationDTO() {
   }

   public productionLineInformationDTO(
      final Long factoryId,
      final String factoryName,
      final Long workshopId,
      final String workshopName,
      final Long productionLineId,
      final String productionLineName,
      final BigDecimal capacity,
      final Long allocationWeight,
      final Long completed,
      final Long incomplete,
      final Integer productionLineTypeEnum,
      final LocalDateTime date
   ) {
      this.factoryId = factoryId;
      this.factoryName = factoryName;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.capacity = capacity;
      this.allocationWeight = allocationWeight;
      this.completed = completed;
      this.incomplete = incomplete;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.date = date;
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

   public BigDecimal getCapacity() {
      return this.capacity;
   }

   public Long getAllocationWeight() {
      return this.allocationWeight;
   }

   public Long getCompleted() {
      return this.completed;
   }

   public Long getIncomplete() {
      return this.incomplete;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   public productionLineInformationDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   public productionLineInformationDTO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   public productionLineInformationDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public productionLineInformationDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   public productionLineInformationDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   public productionLineInformationDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   public productionLineInformationDTO setCapacity(final BigDecimal capacity) {
      this.capacity = capacity;
      return this;
   }

   public productionLineInformationDTO setAllocationWeight(final Long allocationWeight) {
      this.allocationWeight = allocationWeight;
      return this;
   }

   public productionLineInformationDTO setCompleted(final Long completed) {
      this.completed = completed;
      return this;
   }

   public productionLineInformationDTO setIncomplete(final Long incomplete) {
      this.incomplete = incomplete;
      return this;
   }

   public productionLineInformationDTO setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   public productionLineInformationDTO setDate(final LocalDateTime date) {
      this.date = date;
      return this;
   }

   @Override
   public String toString() {
      return "productionLineInformationDTO(factoryId="
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
         + ", capacity="
         + this.getCapacity()
         + ", allocationWeight="
         + this.getAllocationWeight()
         + ", completed="
         + this.getCompleted()
         + ", incomplete="
         + this.getIncomplete()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", date="
         + this.getDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof productionLineInformationDTO)) {
         return false;
      }

      productionLineInformationDTO other = (productionLineInformationDTO)o;
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
               Object this$allocationWeight = this.getAllocationWeight();
               Object other$allocationWeight = other.getAllocationWeight();
               if (this$allocationWeight == null ? other$allocationWeight == null : this$allocationWeight.equals(other$allocationWeight)) {
                  Object this$completed = this.getCompleted();
                  Object other$completed = other.getCompleted();
                  if (this$completed == null ? other$completed == null : this$completed.equals(other$completed)) {
                     Object this$incomplete = this.getIncomplete();
                     Object other$incomplete = other.getIncomplete();
                     if (this$incomplete == null ? other$incomplete == null : this$incomplete.equals(other$incomplete)) {
                        Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                        Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                        if (this$productionLineTypeEnum == null
                           ? other$productionLineTypeEnum == null
                           : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                           Object this$factoryName = this.getFactoryName();
                           Object other$factoryName = other.getFactoryName();
                           if (this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName)) {
                              Object this$workshopName = this.getWorkshopName();
                              Object other$workshopName = other.getWorkshopName();
                              if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                 Object this$productionLineName = this.getProductionLineName();
                                 Object other$productionLineName = other.getProductionLineName();
                                 if (this$productionLineName == null
                                    ? other$productionLineName == null
                                    : this$productionLineName.equals(other$productionLineName)) {
                                    Object this$capacity = this.getCapacity();
                                    Object other$capacity = other.getCapacity();
                                    if (this$capacity == null ? other$capacity == null : this$capacity.equals(other$capacity)) {
                                       Object this$date = this.getDate();
                                       Object other$date = other.getDate();
                                       return this$date == null ? other$date == null : this$date.equals(other$date);
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
      return other instanceof productionLineInformationDTO;
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
      Object $allocationWeight = this.getAllocationWeight();
      result = result * 59 + ($allocationWeight == null ? 43 : $allocationWeight.hashCode());
      Object $completed = this.getCompleted();
      result = result * 59 + ($completed == null ? 43 : $completed.hashCode());
      Object $incomplete = this.getIncomplete();
      result = result * 59 + ($incomplete == null ? 43 : $incomplete.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $capacity = this.getCapacity();
      result = result * 59 + ($capacity == null ? 43 : $capacity.hashCode());
      Object $date = this.getDate();
      return result * 59 + ($date == null ? 43 : $date.hashCode());
   }

   public static class productionLineInformationDTOBuilder {
      private Long factoryId;
      private String factoryName;
      private Long workshopId;
      private String workshopName;
      private Long productionLineId;
      private String productionLineName;
      private BigDecimal capacity;
      private Long allocationWeight;
      private Long completed;
      private Long incomplete;
      private Integer productionLineTypeEnum;
      private LocalDateTime date;

      productionLineInformationDTOBuilder() {
      }

      public productionLineInformationDTO.productionLineInformationDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public productionLineInformationDTO.productionLineInformationDTOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      public productionLineInformationDTO.productionLineInformationDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public productionLineInformationDTO.productionLineInformationDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public productionLineInformationDTO.productionLineInformationDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public productionLineInformationDTO.productionLineInformationDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      public productionLineInformationDTO.productionLineInformationDTOBuilder capacity(final BigDecimal capacity) {
         this.capacity = capacity;
         return this;
      }

      public productionLineInformationDTO.productionLineInformationDTOBuilder allocationWeight(final Long allocationWeight) {
         this.allocationWeight = allocationWeight;
         return this;
      }

      public productionLineInformationDTO.productionLineInformationDTOBuilder completed(final Long completed) {
         this.completed = completed;
         return this;
      }

      public productionLineInformationDTO.productionLineInformationDTOBuilder incomplete(final Long incomplete) {
         this.incomplete = incomplete;
         return this;
      }

      public productionLineInformationDTO.productionLineInformationDTOBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public productionLineInformationDTO.productionLineInformationDTOBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      public productionLineInformationDTO build() {
         return new productionLineInformationDTO(
            this.factoryId,
            this.factoryName,
            this.workshopId,
            this.workshopName,
            this.productionLineId,
            this.productionLineName,
            this.capacity,
            this.allocationWeight,
            this.completed,
            this.incomplete,
            this.productionLineTypeEnum,
            this.date
         );
      }

      @Override
      public String toString() {
         return "productionLineInformationDTO.productionLineInformationDTOBuilder(factoryId="
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
            + ", capacity="
            + this.capacity
            + ", allocationWeight="
            + this.allocationWeight
            + ", completed="
            + this.completed
            + ", incomplete="
            + this.incomplete
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", date="
            + this.date
            + ")";
      }
   }
}
