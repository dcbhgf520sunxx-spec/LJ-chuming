package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductMonitorKanbanByProductionLineDTO", description = "")
public class ProductMonitorKanbanByGroupDTO {
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private NameInfo groups;
   @ApiModelProperty(name = "team", notes = "班组")
   @JsonProperty("team")
   @JSONField(name = "team")
   private IdAndNameDO team;
   @ApiModelProperty(name = "taskTypeEnum", notes = "产品类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "lastMonthQuantity", notes = "上个月产量（数量）")
   @JsonProperty("lastMonthQuantity")
   @JSONField(name = "lastMonthQuantity")
   private Integer lastMonthQuantity;
   @ApiModelProperty(name = "lastMonthNetWeight", notes = "上月产量(净重)")
   @JsonProperty("lastMonthNetWeight")
   @JSONField(name = "lastMonthNetWeight")
   private BigDecimal lastMonthNetWeight;
   @ApiModelProperty(name = "lastMonthGrossWeight", notes = "上月产量(毛重)")
   @JsonProperty("lastMonthGrossWeight")
   @JSONField(name = "lastMonthGrossWeight")
   private BigDecimal lastMonthGrossWeight;
   @ApiModelProperty(name = "yearQuantity", notes = "年度产量（数量）")
   @JsonProperty("yearQuantity")
   @JSONField(name = "yearQuantity")
   private Integer yearQuantity;
   @ApiModelProperty(name = "yearNetWeight", notes = "年度产量(净重)")
   @JsonProperty("yearNetWeight")
   @JSONField(name = "yearNetWeight")
   private BigDecimal yearNetWeight;
   @ApiModelProperty(name = "yearGrossWeight", notes = "年度产量(毛重)")
   @JsonProperty("yearGrossWeight")
   @JSONField(name = "yearGrossWeight")
   private BigDecimal yearGrossWeight;
   @ApiModelProperty(name = "unQuantity", notes = "未完成数量")
   @JsonProperty("unQuantity")
   @JSONField(name = "unQuantity")
   private Integer unQuantity;
   @ApiModelProperty(name = "unNetWeight", notes = "未完成量(净重)")
   @JsonProperty("unNetWeight")
   @JSONField(name = "unNetWeight")
   private BigDecimal unNetWeight;
   @ApiModelProperty(name = "unGrossWeight", notes = "未完成量(毛重)")
   @JsonProperty("unGrossWeight")
   @JSONField(name = "unGrossWeight")
   private BigDecimal unGrossWeight;

   public static ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder builder() {
      return new ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder();
   }

   public ProductMonitorKanbanByGroupDTO() {
   }

   public ProductMonitorKanbanByGroupDTO(
      final ProductionLineDetailDO productionLine,
      final NameInfo groups,
      final IdAndNameDO team,
      final Integer taskTypeEnum,
      final Integer lastMonthQuantity,
      final BigDecimal lastMonthNetWeight,
      final BigDecimal lastMonthGrossWeight,
      final Integer yearQuantity,
      final BigDecimal yearNetWeight,
      final BigDecimal yearGrossWeight,
      final Integer unQuantity,
      final BigDecimal unNetWeight,
      final BigDecimal unGrossWeight
   ) {
      this.productionLine = productionLine;
      this.groups = groups;
      this.team = team;
      this.taskTypeEnum = taskTypeEnum;
      this.lastMonthQuantity = lastMonthQuantity;
      this.lastMonthNetWeight = lastMonthNetWeight;
      this.lastMonthGrossWeight = lastMonthGrossWeight;
      this.yearQuantity = yearQuantity;
      this.yearNetWeight = yearNetWeight;
      this.yearGrossWeight = yearGrossWeight;
      this.unQuantity = unQuantity;
      this.unNetWeight = unNetWeight;
      this.unGrossWeight = unGrossWeight;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public NameInfo getGroups() {
      return this.groups;
   }

   public IdAndNameDO getTeam() {
      return this.team;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getLastMonthQuantity() {
      return this.lastMonthQuantity;
   }

   public BigDecimal getLastMonthNetWeight() {
      return this.lastMonthNetWeight;
   }

   public BigDecimal getLastMonthGrossWeight() {
      return this.lastMonthGrossWeight;
   }

   public Integer getYearQuantity() {
      return this.yearQuantity;
   }

   public BigDecimal getYearNetWeight() {
      return this.yearNetWeight;
   }

   public BigDecimal getYearGrossWeight() {
      return this.yearGrossWeight;
   }

   public Integer getUnQuantity() {
      return this.unQuantity;
   }

   public BigDecimal getUnNetWeight() {
      return this.unNetWeight;
   }

   public BigDecimal getUnGrossWeight() {
      return this.unGrossWeight;
   }

   @JsonProperty("productionLine")
   public ProductMonitorKanbanByGroupDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public ProductMonitorKanbanByGroupDTO setGroups(final NameInfo groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("team")
   public ProductMonitorKanbanByGroupDTO setTeam(final IdAndNameDO team) {
      this.team = team;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public ProductMonitorKanbanByGroupDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("lastMonthQuantity")
   public ProductMonitorKanbanByGroupDTO setLastMonthQuantity(final Integer lastMonthQuantity) {
      this.lastMonthQuantity = lastMonthQuantity;
      return this;
   }

   @JsonProperty("lastMonthNetWeight")
   public ProductMonitorKanbanByGroupDTO setLastMonthNetWeight(final BigDecimal lastMonthNetWeight) {
      this.lastMonthNetWeight = lastMonthNetWeight;
      return this;
   }

   @JsonProperty("lastMonthGrossWeight")
   public ProductMonitorKanbanByGroupDTO setLastMonthGrossWeight(final BigDecimal lastMonthGrossWeight) {
      this.lastMonthGrossWeight = lastMonthGrossWeight;
      return this;
   }

   @JsonProperty("yearQuantity")
   public ProductMonitorKanbanByGroupDTO setYearQuantity(final Integer yearQuantity) {
      this.yearQuantity = yearQuantity;
      return this;
   }

   @JsonProperty("yearNetWeight")
   public ProductMonitorKanbanByGroupDTO setYearNetWeight(final BigDecimal yearNetWeight) {
      this.yearNetWeight = yearNetWeight;
      return this;
   }

   @JsonProperty("yearGrossWeight")
   public ProductMonitorKanbanByGroupDTO setYearGrossWeight(final BigDecimal yearGrossWeight) {
      this.yearGrossWeight = yearGrossWeight;
      return this;
   }

   @JsonProperty("unQuantity")
   public ProductMonitorKanbanByGroupDTO setUnQuantity(final Integer unQuantity) {
      this.unQuantity = unQuantity;
      return this;
   }

   @JsonProperty("unNetWeight")
   public ProductMonitorKanbanByGroupDTO setUnNetWeight(final BigDecimal unNetWeight) {
      this.unNetWeight = unNetWeight;
      return this;
   }

   @JsonProperty("unGrossWeight")
   public ProductMonitorKanbanByGroupDTO setUnGrossWeight(final BigDecimal unGrossWeight) {
      this.unGrossWeight = unGrossWeight;
      return this;
   }

   @Override
   public String toString() {
      return "ProductMonitorKanbanByGroupDTO(productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", team="
         + this.getTeam()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", lastMonthQuantity="
         + this.getLastMonthQuantity()
         + ", lastMonthNetWeight="
         + this.getLastMonthNetWeight()
         + ", lastMonthGrossWeight="
         + this.getLastMonthGrossWeight()
         + ", yearQuantity="
         + this.getYearQuantity()
         + ", yearNetWeight="
         + this.getYearNetWeight()
         + ", yearGrossWeight="
         + this.getYearGrossWeight()
         + ", unQuantity="
         + this.getUnQuantity()
         + ", unNetWeight="
         + this.getUnNetWeight()
         + ", unGrossWeight="
         + this.getUnGrossWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductMonitorKanbanByGroupDTO)) {
         return false;
      }

      ProductMonitorKanbanByGroupDTO other = (ProductMonitorKanbanByGroupDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskTypeEnum = this.getTaskTypeEnum();
      Object other$taskTypeEnum = other.getTaskTypeEnum();
      if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
         Object this$lastMonthQuantity = this.getLastMonthQuantity();
         Object other$lastMonthQuantity = other.getLastMonthQuantity();
         if (this$lastMonthQuantity == null ? other$lastMonthQuantity == null : this$lastMonthQuantity.equals(other$lastMonthQuantity)) {
            Object this$yearQuantity = this.getYearQuantity();
            Object other$yearQuantity = other.getYearQuantity();
            if (this$yearQuantity == null ? other$yearQuantity == null : this$yearQuantity.equals(other$yearQuantity)) {
               Object this$unQuantity = this.getUnQuantity();
               Object other$unQuantity = other.getUnQuantity();
               if (this$unQuantity == null ? other$unQuantity == null : this$unQuantity.equals(other$unQuantity)) {
                  Object this$productionLine = this.getProductionLine();
                  Object other$productionLine = other.getProductionLine();
                  if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                     Object this$groups = this.getGroups();
                     Object other$groups = other.getGroups();
                     if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
                        Object this$team = this.getTeam();
                        Object other$team = other.getTeam();
                        if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                           Object this$lastMonthNetWeight = this.getLastMonthNetWeight();
                           Object other$lastMonthNetWeight = other.getLastMonthNetWeight();
                           if (this$lastMonthNetWeight == null ? other$lastMonthNetWeight == null : this$lastMonthNetWeight.equals(other$lastMonthNetWeight)) {
                              Object this$lastMonthGrossWeight = this.getLastMonthGrossWeight();
                              Object other$lastMonthGrossWeight = other.getLastMonthGrossWeight();
                              if (this$lastMonthGrossWeight == null
                                 ? other$lastMonthGrossWeight == null
                                 : this$lastMonthGrossWeight.equals(other$lastMonthGrossWeight)) {
                                 Object this$yearNetWeight = this.getYearNetWeight();
                                 Object other$yearNetWeight = other.getYearNetWeight();
                                 if (this$yearNetWeight == null ? other$yearNetWeight == null : this$yearNetWeight.equals(other$yearNetWeight)) {
                                    Object this$yearGrossWeight = this.getYearGrossWeight();
                                    Object other$yearGrossWeight = other.getYearGrossWeight();
                                    if (this$yearGrossWeight == null ? other$yearGrossWeight == null : this$yearGrossWeight.equals(other$yearGrossWeight)) {
                                       Object this$unNetWeight = this.getUnNetWeight();
                                       Object other$unNetWeight = other.getUnNetWeight();
                                       if (this$unNetWeight == null ? other$unNetWeight == null : this$unNetWeight.equals(other$unNetWeight)) {
                                          Object this$unGrossWeight = this.getUnGrossWeight();
                                          Object other$unGrossWeight = other.getUnGrossWeight();
                                          return this$unGrossWeight == null ? other$unGrossWeight == null : this$unGrossWeight.equals(other$unGrossWeight);
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
      return other instanceof ProductMonitorKanbanByGroupDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $lastMonthQuantity = this.getLastMonthQuantity();
      result = result * 59 + ($lastMonthQuantity == null ? 43 : $lastMonthQuantity.hashCode());
      Object $yearQuantity = this.getYearQuantity();
      result = result * 59 + ($yearQuantity == null ? 43 : $yearQuantity.hashCode());
      Object $unQuantity = this.getUnQuantity();
      result = result * 59 + ($unQuantity == null ? 43 : $unQuantity.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $lastMonthNetWeight = this.getLastMonthNetWeight();
      result = result * 59 + ($lastMonthNetWeight == null ? 43 : $lastMonthNetWeight.hashCode());
      Object $lastMonthGrossWeight = this.getLastMonthGrossWeight();
      result = result * 59 + ($lastMonthGrossWeight == null ? 43 : $lastMonthGrossWeight.hashCode());
      Object $yearNetWeight = this.getYearNetWeight();
      result = result * 59 + ($yearNetWeight == null ? 43 : $yearNetWeight.hashCode());
      Object $yearGrossWeight = this.getYearGrossWeight();
      result = result * 59 + ($yearGrossWeight == null ? 43 : $yearGrossWeight.hashCode());
      Object $unNetWeight = this.getUnNetWeight();
      result = result * 59 + ($unNetWeight == null ? 43 : $unNetWeight.hashCode());
      Object $unGrossWeight = this.getUnGrossWeight();
      return result * 59 + ($unGrossWeight == null ? 43 : $unGrossWeight.hashCode());
   }

   public static class ProductMonitorKanbanByGroupDTOBuilder {
      private ProductionLineDetailDO productionLine;
      private NameInfo groups;
      private IdAndNameDO team;
      private Integer taskTypeEnum;
      private Integer lastMonthQuantity;
      private BigDecimal lastMonthNetWeight;
      private BigDecimal lastMonthGrossWeight;
      private Integer yearQuantity;
      private BigDecimal yearNetWeight;
      private BigDecimal yearGrossWeight;
      private Integer unQuantity;
      private BigDecimal unNetWeight;
      private BigDecimal unGrossWeight;

      ProductMonitorKanbanByGroupDTOBuilder() {
      }

      @JsonProperty("productionLine")
      public ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder groups(final NameInfo groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("team")
      public ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder team(final IdAndNameDO team) {
         this.team = team;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("lastMonthQuantity")
      public ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder lastMonthQuantity(final Integer lastMonthQuantity) {
         this.lastMonthQuantity = lastMonthQuantity;
         return this;
      }

      @JsonProperty("lastMonthNetWeight")
      public ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder lastMonthNetWeight(final BigDecimal lastMonthNetWeight) {
         this.lastMonthNetWeight = lastMonthNetWeight;
         return this;
      }

      @JsonProperty("lastMonthGrossWeight")
      public ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder lastMonthGrossWeight(final BigDecimal lastMonthGrossWeight) {
         this.lastMonthGrossWeight = lastMonthGrossWeight;
         return this;
      }

      @JsonProperty("yearQuantity")
      public ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder yearQuantity(final Integer yearQuantity) {
         this.yearQuantity = yearQuantity;
         return this;
      }

      @JsonProperty("yearNetWeight")
      public ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder yearNetWeight(final BigDecimal yearNetWeight) {
         this.yearNetWeight = yearNetWeight;
         return this;
      }

      @JsonProperty("yearGrossWeight")
      public ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder yearGrossWeight(final BigDecimal yearGrossWeight) {
         this.yearGrossWeight = yearGrossWeight;
         return this;
      }

      @JsonProperty("unQuantity")
      public ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder unQuantity(final Integer unQuantity) {
         this.unQuantity = unQuantity;
         return this;
      }

      @JsonProperty("unNetWeight")
      public ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder unNetWeight(final BigDecimal unNetWeight) {
         this.unNetWeight = unNetWeight;
         return this;
      }

      @JsonProperty("unGrossWeight")
      public ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder unGrossWeight(final BigDecimal unGrossWeight) {
         this.unGrossWeight = unGrossWeight;
         return this;
      }

      public ProductMonitorKanbanByGroupDTO build() {
         return new ProductMonitorKanbanByGroupDTO(
            this.productionLine,
            this.groups,
            this.team,
            this.taskTypeEnum,
            this.lastMonthQuantity,
            this.lastMonthNetWeight,
            this.lastMonthGrossWeight,
            this.yearQuantity,
            this.yearNetWeight,
            this.yearGrossWeight,
            this.unQuantity,
            this.unNetWeight,
            this.unGrossWeight
         );
      }

      @Override
      public String toString() {
         return "ProductMonitorKanbanByGroupDTO.ProductMonitorKanbanByGroupDTOBuilder(productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", team="
            + this.team
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", lastMonthQuantity="
            + this.lastMonthQuantity
            + ", lastMonthNetWeight="
            + this.lastMonthNetWeight
            + ", lastMonthGrossWeight="
            + this.lastMonthGrossWeight
            + ", yearQuantity="
            + this.yearQuantity
            + ", yearNetWeight="
            + this.yearNetWeight
            + ", yearGrossWeight="
            + this.yearGrossWeight
            + ", unQuantity="
            + this.unQuantity
            + ", unNetWeight="
            + this.unNetWeight
            + ", unGrossWeight="
            + this.unGrossWeight
            + ")";
      }
   }
}
