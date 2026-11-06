package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesEnclosureProductionTaskDO", description = "任务清单 ")
public class MesEnclosureProductionTaskDO {
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "completeTime", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "taskType", notes = "任务属性")
   @JsonProperty("taskType")
   @JSONField(name = "taskType")
   private Integer taskType;
   @ApiModelProperty(name = "quantity", notes = "任务数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "单毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;

   public static MesEnclosureProductionTaskDO.MesEnclosureProductionTaskDOBuilder builder() {
      return new MesEnclosureProductionTaskDO.MesEnclosureProductionTaskDOBuilder();
   }

   public MesEnclosureProductionTaskDO() {
   }

   public MesEnclosureProductionTaskDO(
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final LocalDateTime completeTime,
      final Integer taskType,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal grossWeight
   ) {
      this.monomer = monomer;
      this.area = area;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.completeTime = completeTime;
      this.taskType = taskType;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Integer getTaskType() {
      return this.taskType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   @JsonProperty("monomer")
   public MesEnclosureProductionTaskDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public MesEnclosureProductionTaskDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesEnclosureProductionTaskDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesEnclosureProductionTaskDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MesEnclosureProductionTaskDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("completeTime")
   public MesEnclosureProductionTaskDO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("taskType")
   public MesEnclosureProductionTaskDO setTaskType(final Integer taskType) {
      this.taskType = taskType;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureProductionTaskDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesEnclosureProductionTaskDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesEnclosureProductionTaskDO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProductionTaskDO(monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", completeTime="
         + this.getCompleteTime()
         + ", taskType="
         + this.getTaskType()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProductionTaskDO)) {
         return false;
      }

      MesEnclosureProductionTaskDO other = (MesEnclosureProductionTaskDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskType = this.getTaskType();
      Object other$taskType = other.getTaskType();
      if (this$taskType == null ? other$taskType == null : this$taskType.equals(other$taskType)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$monomer = this.getMonomer();
            Object other$monomer = other.getMonomer();
            if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
               Object this$area = this.getArea();
               Object other$area = other.getArea();
               if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$length = this.getLength();
                        Object other$length = other.getLength();
                        if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                           Object this$completeTime = this.getCompleteTime();
                           Object other$completeTime = other.getCompleteTime();
                           if (this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime)) {
                              Object this$netWeight = this.getNetWeight();
                              Object other$netWeight = other.getNetWeight();
                              if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                 Object this$grossWeight = this.getGrossWeight();
                                 Object other$grossWeight = other.getGrossWeight();
                                 return this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight);
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
      return other instanceof MesEnclosureProductionTaskDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskType = this.getTaskType();
      result = result * 59 + ($taskType == null ? 43 : $taskType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      return result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
   }

   public static class MesEnclosureProductionTaskDOBuilder {
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private LocalDateTime completeTime;
      private Integer taskType;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;

      MesEnclosureProductionTaskDOBuilder() {
      }

      @JsonProperty("monomer")
      public MesEnclosureProductionTaskDO.MesEnclosureProductionTaskDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public MesEnclosureProductionTaskDO.MesEnclosureProductionTaskDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesEnclosureProductionTaskDO.MesEnclosureProductionTaskDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesEnclosureProductionTaskDO.MesEnclosureProductionTaskDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MesEnclosureProductionTaskDO.MesEnclosureProductionTaskDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("completeTime")
      public MesEnclosureProductionTaskDO.MesEnclosureProductionTaskDOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("taskType")
      public MesEnclosureProductionTaskDO.MesEnclosureProductionTaskDOBuilder taskType(final Integer taskType) {
         this.taskType = taskType;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureProductionTaskDO.MesEnclosureProductionTaskDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesEnclosureProductionTaskDO.MesEnclosureProductionTaskDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesEnclosureProductionTaskDO.MesEnclosureProductionTaskDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public MesEnclosureProductionTaskDO build() {
         return new MesEnclosureProductionTaskDO(
            this.monomer,
            this.area,
            this.serialNumber,
            this.specification,
            this.length,
            this.completeTime,
            this.taskType,
            this.quantity,
            this.netWeight,
            this.grossWeight
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureProductionTaskDO.MesEnclosureProductionTaskDOBuilder(monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", completeTime="
            + this.completeTime
            + ", taskType="
            + this.taskType
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ")";
      }
   }
}
