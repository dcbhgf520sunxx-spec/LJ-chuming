package com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "OutStaffSummaryDO", description = "")
public class OutStaffSummaryDO {
   @ApiModelProperty(name = "factory", notes = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private FactoryDetailDO factory;
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "leaderName", notes = "班组长名")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeNetWeight", notes = "完成重量")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务净重")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   private BigDecimal taskNetWeight;
   @ApiModelProperty(name = "taskLength", notes = "任务长度")
   @JsonProperty("taskLength")
   @JSONField(name = "taskLength")
   private BigDecimal taskLength;
   @ApiModelProperty(name = "completeLength", notes = "完成长度")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private BigDecimal completeLength;
   @ApiModelProperty(name = "completeGrossWeight", notes = "完成毛重")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(name = "taskGrossWeight", notes = "任务毛重")
   @JsonProperty("taskGrossWeight")
   @JSONField(name = "taskGrossWeight")
   private BigDecimal taskGrossWeight;
   @ApiModelProperty(name = "mate", notes = "核算量")
   @JsonProperty("mate")
   @JSONField(name = "mate")
   private BigDecimal mate;
   @ApiModelProperty(name = "price", notes = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "processName", notes = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "wage", notes = "工价")
   @JsonProperty("wage")
   @JSONField(name = "wage")
   private BigDecimal wage;
   @ApiModelProperty(name = "wageQuotaType", notes = "计价方式")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;

   public static OutStaffSummaryDO.OutStaffSummaryDOBuilder builder() {
      return new OutStaffSummaryDO.OutStaffSummaryDOBuilder();
   }

   public OutStaffSummaryDO(
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final String leaderName,
      final Integer completeQuantity,
      final Integer taskQuantity,
      final BigDecimal completeNetWeight,
      final BigDecimal taskNetWeight,
      final BigDecimal taskLength,
      final BigDecimal completeLength,
      final BigDecimal completeGrossWeight,
      final BigDecimal taskGrossWeight,
      final BigDecimal mate,
      final BigDecimal price,
      final Long teamId,
      final Integer productType,
      final String processName,
      final String serialNumber,
      final BigDecimal wage,
      final Integer wageQuotaType
   ) {
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.leaderName = leaderName;
      this.completeQuantity = completeQuantity;
      this.taskQuantity = taskQuantity;
      this.completeNetWeight = completeNetWeight;
      this.taskNetWeight = taskNetWeight;
      this.taskLength = taskLength;
      this.completeLength = completeLength;
      this.completeGrossWeight = completeGrossWeight;
      this.taskGrossWeight = taskGrossWeight;
      this.mate = mate;
      this.price = price;
      this.teamId = teamId;
      this.productType = productType;
      this.processName = processName;
      this.serialNumber = serialNumber;
      this.wage = wage;
      this.wageQuotaType = wageQuotaType;
   }

   public OutStaffSummaryDO() {
   }

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public BigDecimal getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public BigDecimal getTaskLength() {
      return this.taskLength;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public BigDecimal getTaskGrossWeight() {
      return this.taskGrossWeight;
   }

   public BigDecimal getMate() {
      return this.mate;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   @JsonProperty("factory")
   public OutStaffSummaryDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public OutStaffSummaryDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public OutStaffSummaryDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("leaderName")
   public OutStaffSummaryDO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("completeQuantity")
   public OutStaffSummaryDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("taskQuantity")
   public OutStaffSummaryDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public OutStaffSummaryDO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public OutStaffSummaryDO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskLength")
   public OutStaffSummaryDO setTaskLength(final BigDecimal taskLength) {
      this.taskLength = taskLength;
      return this;
   }

   @JsonProperty("completeLength")
   public OutStaffSummaryDO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public OutStaffSummaryDO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public OutStaffSummaryDO setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("mate")
   public OutStaffSummaryDO setMate(final BigDecimal mate) {
      this.mate = mate;
      return this;
   }

   @JsonProperty("price")
   public OutStaffSummaryDO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("teamId")
   public OutStaffSummaryDO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("productType")
   public OutStaffSummaryDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("processName")
   public OutStaffSummaryDO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("serialNumber")
   public OutStaffSummaryDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("wage")
   public OutStaffSummaryDO setWage(final BigDecimal wage) {
      this.wage = wage;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public OutStaffSummaryDO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @Override
   public String toString() {
      return "OutStaffSummaryDO(factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", leaderName="
         + this.getLeaderName()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", taskLength="
         + this.getTaskLength()
         + ", completeLength="
         + this.getCompleteLength()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", taskGrossWeight="
         + this.getTaskGrossWeight()
         + ", mate="
         + this.getMate()
         + ", price="
         + this.getPrice()
         + ", teamId="
         + this.getTeamId()
         + ", productType="
         + this.getProductType()
         + ", processName="
         + this.getProcessName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", wage="
         + this.getWage()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutStaffSummaryDO)) {
         return false;
      }

      OutStaffSummaryDO other = (OutStaffSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$completeQuantity = this.getCompleteQuantity();
      Object other$completeQuantity = other.getCompleteQuantity();
      if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$wageQuotaType = this.getWageQuotaType();
                  Object other$wageQuotaType = other.getWageQuotaType();
                  if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                     Object this$factory = this.getFactory();
                     Object other$factory = other.getFactory();
                     if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                        Object this$workshop = this.getWorkshop();
                        Object other$workshop = other.getWorkshop();
                        if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                           Object this$productionLine = this.getProductionLine();
                           Object other$productionLine = other.getProductionLine();
                           if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                              Object this$leaderName = this.getLeaderName();
                              Object other$leaderName = other.getLeaderName();
                              if (this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName)) {
                                 Object this$completeNetWeight = this.getCompleteNetWeight();
                                 Object other$completeNetWeight = other.getCompleteNetWeight();
                                 if (this$completeNetWeight == null ? other$completeNetWeight == null : this$completeNetWeight.equals(other$completeNetWeight)) {
                                    Object this$taskNetWeight = this.getTaskNetWeight();
                                    Object other$taskNetWeight = other.getTaskNetWeight();
                                    if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                                       Object this$taskLength = this.getTaskLength();
                                       Object other$taskLength = other.getTaskLength();
                                       if (this$taskLength == null ? other$taskLength == null : this$taskLength.equals(other$taskLength)) {
                                          Object this$completeLength = this.getCompleteLength();
                                          Object other$completeLength = other.getCompleteLength();
                                          if (this$completeLength == null ? other$completeLength == null : this$completeLength.equals(other$completeLength)) {
                                             Object this$completeGrossWeight = this.getCompleteGrossWeight();
                                             Object other$completeGrossWeight = other.getCompleteGrossWeight();
                                             if (this$completeGrossWeight == null
                                                ? other$completeGrossWeight == null
                                                : this$completeGrossWeight.equals(other$completeGrossWeight)) {
                                                Object this$taskGrossWeight = this.getTaskGrossWeight();
                                                Object other$taskGrossWeight = other.getTaskGrossWeight();
                                                if (this$taskGrossWeight == null
                                                   ? other$taskGrossWeight == null
                                                   : this$taskGrossWeight.equals(other$taskGrossWeight)) {
                                                   Object this$mate = this.getMate();
                                                   Object other$mate = other.getMate();
                                                   if (this$mate == null ? other$mate == null : this$mate.equals(other$mate)) {
                                                      Object this$price = this.getPrice();
                                                      Object other$price = other.getPrice();
                                                      if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                         Object this$processName = this.getProcessName();
                                                         Object other$processName = other.getProcessName();
                                                         if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                                            Object this$serialNumber = this.getSerialNumber();
                                                            Object other$serialNumber = other.getSerialNumber();
                                                            if (this$serialNumber == null
                                                               ? other$serialNumber == null
                                                               : this$serialNumber.equals(other$serialNumber)) {
                                                               Object this$wage = this.getWage();
                                                               Object other$wage = other.getWage();
                                                               return this$wage == null ? other$wage == null : this$wage.equals(other$wage);
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
      return other instanceof OutStaffSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $leaderName = this.getLeaderName();
      result = result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $completeLength = this.getCompleteLength();
      result = result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $mate = this.getMate();
      result = result * 59 + ($mate == null ? 43 : $mate.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $wage = this.getWage();
      return result * 59 + ($wage == null ? 43 : $wage.hashCode());
   }

   public static class OutStaffSummaryDOBuilder {
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private String leaderName;
      private Integer completeQuantity;
      private Integer taskQuantity;
      private BigDecimal completeNetWeight;
      private BigDecimal taskNetWeight;
      private BigDecimal taskLength;
      private BigDecimal completeLength;
      private BigDecimal completeGrossWeight;
      private BigDecimal taskGrossWeight;
      private BigDecimal mate;
      private BigDecimal price;
      private Long teamId;
      private Integer productType;
      private String processName;
      private String serialNumber;
      private BigDecimal wage;
      private Integer wageQuotaType;

      OutStaffSummaryDOBuilder() {
      }

      @JsonProperty("factory")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("leaderName")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("completeQuantity")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("taskQuantity")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskLength")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder taskLength(final BigDecimal taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      @JsonProperty("completeLength")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder taskGrossWeight(final BigDecimal taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("mate")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder mate(final BigDecimal mate) {
         this.mate = mate;
         return this;
      }

      @JsonProperty("price")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("teamId")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("productType")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("processName")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("serialNumber")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("wage")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder wage(final BigDecimal wage) {
         this.wage = wage;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public OutStaffSummaryDO.OutStaffSummaryDOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public OutStaffSummaryDO build() {
         return new OutStaffSummaryDO(
            this.factory,
            this.workshop,
            this.productionLine,
            this.leaderName,
            this.completeQuantity,
            this.taskQuantity,
            this.completeNetWeight,
            this.taskNetWeight,
            this.taskLength,
            this.completeLength,
            this.completeGrossWeight,
            this.taskGrossWeight,
            this.mate,
            this.price,
            this.teamId,
            this.productType,
            this.processName,
            this.serialNumber,
            this.wage,
            this.wageQuotaType
         );
      }

      @Override
      public String toString() {
         return "OutStaffSummaryDO.OutStaffSummaryDOBuilder(factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", leaderName="
            + this.leaderName
            + ", completeQuantity="
            + this.completeQuantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", taskLength="
            + this.taskLength
            + ", completeLength="
            + this.completeLength
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", taskGrossWeight="
            + this.taskGrossWeight
            + ", mate="
            + this.mate
            + ", price="
            + this.price
            + ", teamId="
            + this.teamId
            + ", productType="
            + this.productType
            + ", processName="
            + this.processName
            + ", serialNumber="
            + this.serialNumber
            + ", wage="
            + this.wage
            + ", wageQuotaType="
            + this.wageQuotaType
            + ")";
      }
   }
}
