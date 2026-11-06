package com.hzchum.scim.mes.building.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ReckonPriceTeamDO", description = "")
public class ReckonPriceTeamDO {
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
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "leaderName", notes = "班组组长名")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "unit", notes = "单位")
   @JsonProperty("unit")
   @JSONField(name = "unit")
   private String unit;
   @ApiModelProperty(name = "mate", notes = "产量")
   @JsonProperty("mate")
   @JSONField(name = "mate")
   private BigDecimal mate;
   @ApiModelProperty(name = "price", notes = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;
   @ApiModelProperty(name = "wageQuotaType", notes = "工价计算方式")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "wage", notes = "工价")
   @JsonProperty("wage")
   @JSONField(name = "wage")
   private Integer wage;

   public static ReckonPriceTeamDO.ReckonPriceTeamDOBuilder builder() {
      return new ReckonPriceTeamDO.ReckonPriceTeamDOBuilder();
   }

   public ReckonPriceTeamDO(
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final Long teamId,
      final String leaderName,
      final Long processId,
      final String processName,
      final String unit,
      final BigDecimal mate,
      final BigDecimal price,
      final Integer wageQuotaType,
      final Integer wage
   ) {
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.teamId = teamId;
      this.leaderName = leaderName;
      this.processId = processId;
      this.processName = processName;
      this.unit = unit;
      this.mate = mate;
      this.price = price;
      this.wageQuotaType = wageQuotaType;
      this.wage = wage;
   }

   public ReckonPriceTeamDO() {
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

   public Long getTeamId() {
      return this.teamId;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getMate() {
      return this.mate;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public Integer getWage() {
      return this.wage;
   }

   @JsonProperty("factory")
   public ReckonPriceTeamDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public ReckonPriceTeamDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public ReckonPriceTeamDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("teamId")
   public ReckonPriceTeamDO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("leaderName")
   public ReckonPriceTeamDO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("processId")
   public ReckonPriceTeamDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public ReckonPriceTeamDO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("unit")
   public ReckonPriceTeamDO setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   @JsonProperty("mate")
   public ReckonPriceTeamDO setMate(final BigDecimal mate) {
      this.mate = mate;
      return this;
   }

   @JsonProperty("price")
   public ReckonPriceTeamDO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public ReckonPriceTeamDO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("wage")
   public ReckonPriceTeamDO setWage(final Integer wage) {
      this.wage = wage;
      return this;
   }

   @Override
   public String toString() {
      return "ReckonPriceTeamDO(factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", teamId="
         + this.getTeamId()
         + ", leaderName="
         + this.getLeaderName()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", unit="
         + this.getUnit()
         + ", mate="
         + this.getMate()
         + ", price="
         + this.getPrice()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", wage="
         + this.getWage()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReckonPriceTeamDO)) {
         return false;
      }

      ReckonPriceTeamDO other = (ReckonPriceTeamDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$teamId = this.getTeamId();
      Object other$teamId = other.getTeamId();
      if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$wageQuotaType = this.getWageQuotaType();
            Object other$wageQuotaType = other.getWageQuotaType();
            if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
               Object this$wage = this.getWage();
               Object other$wage = other.getWage();
               if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
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
                              Object this$processName = this.getProcessName();
                              Object other$processName = other.getProcessName();
                              if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                 Object this$unit = this.getUnit();
                                 Object other$unit = other.getUnit();
                                 if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                    Object this$mate = this.getMate();
                                    Object other$mate = other.getMate();
                                    if (this$mate == null ? other$mate == null : this$mate.equals(other$mate)) {
                                       Object this$price = this.getPrice();
                                       Object other$price = other.getPrice();
                                       return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof ReckonPriceTeamDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $leaderName = this.getLeaderName();
      result = result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $mate = this.getMate();
      result = result * 59 + ($mate == null ? 43 : $mate.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class ReckonPriceTeamDOBuilder {
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private Long teamId;
      private String leaderName;
      private Long processId;
      private String processName;
      private String unit;
      private BigDecimal mate;
      private BigDecimal price;
      private Integer wageQuotaType;
      private Integer wage;

      ReckonPriceTeamDOBuilder() {
      }

      @JsonProperty("factory")
      public ReckonPriceTeamDO.ReckonPriceTeamDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public ReckonPriceTeamDO.ReckonPriceTeamDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public ReckonPriceTeamDO.ReckonPriceTeamDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("teamId")
      public ReckonPriceTeamDO.ReckonPriceTeamDOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("leaderName")
      public ReckonPriceTeamDO.ReckonPriceTeamDOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("processId")
      public ReckonPriceTeamDO.ReckonPriceTeamDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public ReckonPriceTeamDO.ReckonPriceTeamDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("unit")
      public ReckonPriceTeamDO.ReckonPriceTeamDOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      @JsonProperty("mate")
      public ReckonPriceTeamDO.ReckonPriceTeamDOBuilder mate(final BigDecimal mate) {
         this.mate = mate;
         return this;
      }

      @JsonProperty("price")
      public ReckonPriceTeamDO.ReckonPriceTeamDOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public ReckonPriceTeamDO.ReckonPriceTeamDOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("wage")
      public ReckonPriceTeamDO.ReckonPriceTeamDOBuilder wage(final Integer wage) {
         this.wage = wage;
         return this;
      }

      public ReckonPriceTeamDO build() {
         return new ReckonPriceTeamDO(
            this.factory,
            this.workshop,
            this.productionLine,
            this.teamId,
            this.leaderName,
            this.processId,
            this.processName,
            this.unit,
            this.mate,
            this.price,
            this.wageQuotaType,
            this.wage
         );
      }

      @Override
      public String toString() {
         return "ReckonPriceTeamDO.ReckonPriceTeamDOBuilder(factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", teamId="
            + this.teamId
            + ", leaderName="
            + this.leaderName
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", unit="
            + this.unit
            + ", mate="
            + this.mate
            + ", price="
            + this.price
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", wage="
            + this.wage
            + ")";
      }
   }
}
