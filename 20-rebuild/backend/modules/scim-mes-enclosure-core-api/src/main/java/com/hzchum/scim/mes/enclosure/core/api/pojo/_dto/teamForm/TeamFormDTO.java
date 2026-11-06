package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.teamForm;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.teamForm.TeamFormProcessDetailsDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "TeamFormRequestDTOParam", description = "")
public class TeamFormDTO {
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
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "processSummaryList", notes = "工序汇总信息")
   @JsonProperty("processSummaryList")
   @JSONField(name = "processSummaryList")
   private List<TeamFormProcessDetailsDO> processSummaryList;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务净重量")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal taskNetWeight;
   @ApiModelProperty(name = "taskGrossWeight", notes = "任务毛重量")
   @JsonProperty("taskGrossWeight")
   @JSONField(name = "taskGrossWeight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal taskGrossWeight;
   @ApiModelProperty(name = "taskLength", notes = "任务长度")
   @JsonProperty("taskLength")
   @JSONField(name = "taskLength")
   private BigDecimal taskLength;

   public static TeamFormDTO.TeamFormDTOBuilder builder() {
      return new TeamFormDTO.TeamFormDTOBuilder();
   }

   public TeamFormDTO(
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final Integer productType,
      final List<TeamFormProcessDetailsDO> processSummaryList,
      final Integer taskQuantity,
      final BigDecimal taskNetWeight,
      final BigDecimal taskGrossWeight,
      final BigDecimal taskLength
   ) {
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.productType = productType;
      this.processSummaryList = processSummaryList;
      this.taskQuantity = taskQuantity;
      this.taskNetWeight = taskNetWeight;
      this.taskGrossWeight = taskGrossWeight;
      this.taskLength = taskLength;
   }

   public TeamFormDTO() {
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

   public Integer getProductType() {
      return this.productType;
   }

   public List<TeamFormProcessDetailsDO> getProcessSummaryList() {
      return this.processSummaryList;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public BigDecimal getTaskGrossWeight() {
      return this.taskGrossWeight;
   }

   public BigDecimal getTaskLength() {
      return this.taskLength;
   }

   @JsonProperty("factory")
   public TeamFormDTO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public TeamFormDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public TeamFormDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("productType")
   public TeamFormDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("processSummaryList")
   public TeamFormDTO setProcessSummaryList(final List<TeamFormProcessDetailsDO> processSummaryList) {
      this.processSummaryList = processSummaryList;
      return this;
   }

   @JsonProperty("taskQuantity")
   public TeamFormDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public TeamFormDTO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public TeamFormDTO setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("taskLength")
   public TeamFormDTO setTaskLength(final BigDecimal taskLength) {
      this.taskLength = taskLength;
      return this;
   }

   @Override
   public String toString() {
      return "TeamFormDTO(factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", productType="
         + this.getProductType()
         + ", processSummaryList="
         + this.getProcessSummaryList()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", taskGrossWeight="
         + this.getTaskGrossWeight()
         + ", taskLength="
         + this.getTaskLength()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamFormDTO)) {
         return false;
      }

      TeamFormDTO other = (TeamFormDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$factory = this.getFactory();
            Object other$factory = other.getFactory();
            if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
               Object this$workshop = this.getWorkshop();
               Object other$workshop = other.getWorkshop();
               if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                  Object this$productionLine = this.getProductionLine();
                  Object other$productionLine = other.getProductionLine();
                  if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                     Object this$processSummaryList = this.getProcessSummaryList();
                     Object other$processSummaryList = other.getProcessSummaryList();
                     if (this$processSummaryList == null ? other$processSummaryList == null : this$processSummaryList.equals(other$processSummaryList)) {
                        Object this$taskNetWeight = this.getTaskNetWeight();
                        Object other$taskNetWeight = other.getTaskNetWeight();
                        if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                           Object this$taskGrossWeight = this.getTaskGrossWeight();
                           Object other$taskGrossWeight = other.getTaskGrossWeight();
                           if (this$taskGrossWeight == null ? other$taskGrossWeight == null : this$taskGrossWeight.equals(other$taskGrossWeight)) {
                              Object this$taskLength = this.getTaskLength();
                              Object other$taskLength = other.getTaskLength();
                              return this$taskLength == null ? other$taskLength == null : this$taskLength.equals(other$taskLength);
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
      return other instanceof TeamFormDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $processSummaryList = this.getProcessSummaryList();
      result = result * 59 + ($processSummaryList == null ? 43 : $processSummaryList.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $taskLength = this.getTaskLength();
      return result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
   }

   public static class TeamFormDTOBuilder {
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private Integer productType;
      private List<TeamFormProcessDetailsDO> processSummaryList;
      private Integer taskQuantity;
      private BigDecimal taskNetWeight;
      private BigDecimal taskGrossWeight;
      private BigDecimal taskLength;

      TeamFormDTOBuilder() {
      }

      @JsonProperty("factory")
      public TeamFormDTO.TeamFormDTOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public TeamFormDTO.TeamFormDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public TeamFormDTO.TeamFormDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("productType")
      public TeamFormDTO.TeamFormDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("processSummaryList")
      public TeamFormDTO.TeamFormDTOBuilder processSummaryList(final List<TeamFormProcessDetailsDO> processSummaryList) {
         this.processSummaryList = processSummaryList;
         return this;
      }

      @JsonProperty("taskQuantity")
      public TeamFormDTO.TeamFormDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public TeamFormDTO.TeamFormDTOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public TeamFormDTO.TeamFormDTOBuilder taskGrossWeight(final BigDecimal taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("taskLength")
      public TeamFormDTO.TeamFormDTOBuilder taskLength(final BigDecimal taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      public TeamFormDTO build() {
         return new TeamFormDTO(
            this.factory,
            this.workshop,
            this.productionLine,
            this.productType,
            this.processSummaryList,
            this.taskQuantity,
            this.taskNetWeight,
            this.taskGrossWeight,
            this.taskLength
         );
      }

      @Override
      public String toString() {
         return "TeamFormDTO.TeamFormDTOBuilder(factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", productType="
            + this.productType
            + ", processSummaryList="
            + this.processSummaryList
            + ", taskQuantity="
            + this.taskQuantity
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", taskGrossWeight="
            + this.taskGrossWeight
            + ", taskLength="
            + this.taskLength
            + ")";
      }
   }
}
