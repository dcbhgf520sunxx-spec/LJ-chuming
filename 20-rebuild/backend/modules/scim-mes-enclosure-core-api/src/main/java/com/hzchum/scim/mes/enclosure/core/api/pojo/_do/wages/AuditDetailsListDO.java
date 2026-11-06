package com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "AuditDetailsListDO", description = "")
public class AuditDetailsListDO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
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
   @ApiModelProperty(name = "teamId", value = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "leaderName", value = "班组长名")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "processName", value = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "oldPrice", value = "原价格")
   @JsonProperty("oldPrice")
   @JSONField(name = "oldPrice")
   private BigDecimal oldPrice;
   @ApiModelProperty(name = "newPrice", value = "更改后的价格")
   @JsonProperty("newPrice")
   @JSONField(name = "newPrice")
   private BigDecimal newPrice;
   @ApiModelProperty(name = "boolUsedEnum", value = "是否使用中")
   @JsonProperty("boolUsedEnum")
   @JSONField(name = "boolUsedEnum")
   private Boolean boolUsedEnum;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;

   public static AuditDetailsListDO.AuditDetailsListDOBuilder builder() {
      return new AuditDetailsListDO.AuditDetailsListDOBuilder();
   }

   public AuditDetailsListDO(
      final Long id,
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final Long teamId,
      final String leaderName,
      final String processName,
      final BigDecimal oldPrice,
      final BigDecimal newPrice,
      final Boolean boolUsedEnum,
      final Integer wageQuotaType
   ) {
      this.id = id;
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.teamId = teamId;
      this.leaderName = leaderName;
      this.processName = processName;
      this.oldPrice = oldPrice;
      this.newPrice = newPrice;
      this.boolUsedEnum = boolUsedEnum;
      this.wageQuotaType = wageQuotaType;
   }

   public AuditDetailsListDO() {
   }

   public Long getId() {
      return this.id;
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

   public String getProcessName() {
      return this.processName;
   }

   public BigDecimal getOldPrice() {
      return this.oldPrice;
   }

   public BigDecimal getNewPrice() {
      return this.newPrice;
   }

   public Boolean getBoolUsedEnum() {
      return this.boolUsedEnum;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   @JsonProperty("id")
   public AuditDetailsListDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factory")
   public AuditDetailsListDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public AuditDetailsListDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public AuditDetailsListDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("teamId")
   public AuditDetailsListDO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("leaderName")
   public AuditDetailsListDO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("processName")
   public AuditDetailsListDO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("oldPrice")
   public AuditDetailsListDO setOldPrice(final BigDecimal oldPrice) {
      this.oldPrice = oldPrice;
      return this;
   }

   @JsonProperty("newPrice")
   public AuditDetailsListDO setNewPrice(final BigDecimal newPrice) {
      this.newPrice = newPrice;
      return this;
   }

   @JsonProperty("boolUsedEnum")
   public AuditDetailsListDO setBoolUsedEnum(final Boolean boolUsedEnum) {
      this.boolUsedEnum = boolUsedEnum;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public AuditDetailsListDO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @Override
   public String toString() {
      return "AuditDetailsListDO(id="
         + this.getId()
         + ", factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", teamId="
         + this.getTeamId()
         + ", leaderName="
         + this.getLeaderName()
         + ", processName="
         + this.getProcessName()
         + ", oldPrice="
         + this.getOldPrice()
         + ", newPrice="
         + this.getNewPrice()
         + ", boolUsedEnum="
         + this.getBoolUsedEnum()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AuditDetailsListDO)) {
         return false;
      }

      AuditDetailsListDO other = (AuditDetailsListDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$teamId = this.getTeamId();
         Object other$teamId = other.getTeamId();
         if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
            Object this$boolUsedEnum = this.getBoolUsedEnum();
            Object other$boolUsedEnum = other.getBoolUsedEnum();
            if (this$boolUsedEnum == null ? other$boolUsedEnum == null : this$boolUsedEnum.equals(other$boolUsedEnum)) {
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
                              Object this$processName = this.getProcessName();
                              Object other$processName = other.getProcessName();
                              if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                 Object this$oldPrice = this.getOldPrice();
                                 Object other$oldPrice = other.getOldPrice();
                                 if (this$oldPrice == null ? other$oldPrice == null : this$oldPrice.equals(other$oldPrice)) {
                                    Object this$newPrice = this.getNewPrice();
                                    Object other$newPrice = other.getNewPrice();
                                    return this$newPrice == null ? other$newPrice == null : this$newPrice.equals(other$newPrice);
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
      return other instanceof AuditDetailsListDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $boolUsedEnum = this.getBoolUsedEnum();
      result = result * 59 + ($boolUsedEnum == null ? 43 : $boolUsedEnum.hashCode());
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
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $oldPrice = this.getOldPrice();
      result = result * 59 + ($oldPrice == null ? 43 : $oldPrice.hashCode());
      Object $newPrice = this.getNewPrice();
      return result * 59 + ($newPrice == null ? 43 : $newPrice.hashCode());
   }

   public static class AuditDetailsListDOBuilder {
      private Long id;
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private Long teamId;
      private String leaderName;
      private String processName;
      private BigDecimal oldPrice;
      private BigDecimal newPrice;
      private Boolean boolUsedEnum;
      private Integer wageQuotaType;

      AuditDetailsListDOBuilder() {
      }

      @JsonProperty("id")
      public AuditDetailsListDO.AuditDetailsListDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factory")
      public AuditDetailsListDO.AuditDetailsListDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public AuditDetailsListDO.AuditDetailsListDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public AuditDetailsListDO.AuditDetailsListDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("teamId")
      public AuditDetailsListDO.AuditDetailsListDOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("leaderName")
      public AuditDetailsListDO.AuditDetailsListDOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("processName")
      public AuditDetailsListDO.AuditDetailsListDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("oldPrice")
      public AuditDetailsListDO.AuditDetailsListDOBuilder oldPrice(final BigDecimal oldPrice) {
         this.oldPrice = oldPrice;
         return this;
      }

      @JsonProperty("newPrice")
      public AuditDetailsListDO.AuditDetailsListDOBuilder newPrice(final BigDecimal newPrice) {
         this.newPrice = newPrice;
         return this;
      }

      @JsonProperty("boolUsedEnum")
      public AuditDetailsListDO.AuditDetailsListDOBuilder boolUsedEnum(final Boolean boolUsedEnum) {
         this.boolUsedEnum = boolUsedEnum;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public AuditDetailsListDO.AuditDetailsListDOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public AuditDetailsListDO build() {
         return new AuditDetailsListDO(
            this.id,
            this.factory,
            this.workshop,
            this.productionLine,
            this.teamId,
            this.leaderName,
            this.processName,
            this.oldPrice,
            this.newPrice,
            this.boolUsedEnum,
            this.wageQuotaType
         );
      }

      @Override
      public String toString() {
         return "AuditDetailsListDO.AuditDetailsListDOBuilder(id="
            + this.id
            + ", factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", teamId="
            + this.teamId
            + ", leaderName="
            + this.leaderName
            + ", processName="
            + this.processName
            + ", oldPrice="
            + this.oldPrice
            + ", newPrice="
            + this.newPrice
            + ", boolUsedEnum="
            + this.boolUsedEnum
            + ", wageQuotaType="
            + this.wageQuotaType
            + ")";
      }
   }
}
