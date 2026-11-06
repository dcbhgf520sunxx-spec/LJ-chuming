package com.hzchum.scim.mes.enclosure.core.api.pojo._do.teamForm;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TeamFormDO", description = "")
public class TeamFormEnclosureDO {
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
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "taskLength", notes = "任务长度")
   @JsonProperty("taskLength")
   @JSONField(name = "taskLength")
   private BigDecimal taskLength;
   @ApiModelProperty(name = "taskArea", notes = "任务面积")
   @JsonProperty("taskArea")
   @JSONField(name = "taskArea")
   private BigDecimal taskArea;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeLength", notes = "完成长度")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private BigDecimal completeLength;
   @ApiModelProperty(name = "completekArea", notes = "完成面积")
   @JsonProperty("completekArea")
   @JSONField(name = "completekArea")
   private BigDecimal completekArea;

   public static TeamFormEnclosureDO.TeamFormEnclosureDOBuilder builder() {
      return new TeamFormEnclosureDO.TeamFormEnclosureDOBuilder();
   }

   public TeamFormEnclosureDO(
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final Integer productType,
      final Integer taskQuantity,
      final BigDecimal taskLength,
      final BigDecimal taskArea,
      final Integer completeQuantity,
      final BigDecimal completeLength,
      final BigDecimal completekArea
   ) {
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.productType = productType;
      this.taskQuantity = taskQuantity;
      this.taskLength = taskLength;
      this.taskArea = taskArea;
      this.completeQuantity = completeQuantity;
      this.completeLength = completeLength;
      this.completekArea = completekArea;
   }

   public TeamFormEnclosureDO() {
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

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTaskLength() {
      return this.taskLength;
   }

   public BigDecimal getTaskArea() {
      return this.taskArea;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   public BigDecimal getCompletekArea() {
      return this.completekArea;
   }

   @JsonProperty("factory")
   public TeamFormEnclosureDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public TeamFormEnclosureDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public TeamFormEnclosureDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("productType")
   public TeamFormEnclosureDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("taskQuantity")
   public TeamFormEnclosureDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskLength")
   public TeamFormEnclosureDO setTaskLength(final BigDecimal taskLength) {
      this.taskLength = taskLength;
      return this;
   }

   @JsonProperty("taskArea")
   public TeamFormEnclosureDO setTaskArea(final BigDecimal taskArea) {
      this.taskArea = taskArea;
      return this;
   }

   @JsonProperty("completeQuantity")
   public TeamFormEnclosureDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeLength")
   public TeamFormEnclosureDO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @JsonProperty("completekArea")
   public TeamFormEnclosureDO setCompletekArea(final BigDecimal completekArea) {
      this.completekArea = completekArea;
      return this;
   }

   @Override
   public String toString() {
      return "TeamFormEnclosureDO(factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", productType="
         + this.getProductType()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskLength="
         + this.getTaskLength()
         + ", taskArea="
         + this.getTaskArea()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeLength="
         + this.getCompleteLength()
         + ", completekArea="
         + this.getCompletekArea()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamFormEnclosureDO)) {
         return false;
      }

      TeamFormEnclosureDO other = (TeamFormEnclosureDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
               Object this$factory = this.getFactory();
               Object other$factory = other.getFactory();
               if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                  Object this$workshop = this.getWorkshop();
                  Object other$workshop = other.getWorkshop();
                  if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                     Object this$productionLine = this.getProductionLine();
                     Object other$productionLine = other.getProductionLine();
                     if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                        Object this$taskLength = this.getTaskLength();
                        Object other$taskLength = other.getTaskLength();
                        if (this$taskLength == null ? other$taskLength == null : this$taskLength.equals(other$taskLength)) {
                           Object this$taskArea = this.getTaskArea();
                           Object other$taskArea = other.getTaskArea();
                           if (this$taskArea == null ? other$taskArea == null : this$taskArea.equals(other$taskArea)) {
                              Object this$completeLength = this.getCompleteLength();
                              Object other$completeLength = other.getCompleteLength();
                              if (this$completeLength == null ? other$completeLength == null : this$completeLength.equals(other$completeLength)) {
                                 Object this$completekArea = this.getCompletekArea();
                                 Object other$completekArea = other.getCompletekArea();
                                 return this$completekArea == null ? other$completekArea == null : this$completekArea.equals(other$completekArea);
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
      return other instanceof TeamFormEnclosureDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $taskArea = this.getTaskArea();
      result = result * 59 + ($taskArea == null ? 43 : $taskArea.hashCode());
      Object $completeLength = this.getCompleteLength();
      result = result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
      Object $completekArea = this.getCompletekArea();
      return result * 59 + ($completekArea == null ? 43 : $completekArea.hashCode());
   }

   public static class TeamFormEnclosureDOBuilder {
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private Integer productType;
      private Integer taskQuantity;
      private BigDecimal taskLength;
      private BigDecimal taskArea;
      private Integer completeQuantity;
      private BigDecimal completeLength;
      private BigDecimal completekArea;

      TeamFormEnclosureDOBuilder() {
      }

      @JsonProperty("factory")
      public TeamFormEnclosureDO.TeamFormEnclosureDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public TeamFormEnclosureDO.TeamFormEnclosureDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public TeamFormEnclosureDO.TeamFormEnclosureDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("productType")
      public TeamFormEnclosureDO.TeamFormEnclosureDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("taskQuantity")
      public TeamFormEnclosureDO.TeamFormEnclosureDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskLength")
      public TeamFormEnclosureDO.TeamFormEnclosureDOBuilder taskLength(final BigDecimal taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      @JsonProperty("taskArea")
      public TeamFormEnclosureDO.TeamFormEnclosureDOBuilder taskArea(final BigDecimal taskArea) {
         this.taskArea = taskArea;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TeamFormEnclosureDO.TeamFormEnclosureDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeLength")
      public TeamFormEnclosureDO.TeamFormEnclosureDOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      @JsonProperty("completekArea")
      public TeamFormEnclosureDO.TeamFormEnclosureDOBuilder completekArea(final BigDecimal completekArea) {
         this.completekArea = completekArea;
         return this;
      }

      public TeamFormEnclosureDO build() {
         return new TeamFormEnclosureDO(
            this.factory,
            this.workshop,
            this.productionLine,
            this.productType,
            this.taskQuantity,
            this.taskLength,
            this.taskArea,
            this.completeQuantity,
            this.completeLength,
            this.completekArea
         );
      }

      @Override
      public String toString() {
         return "TeamFormEnclosureDO.TeamFormEnclosureDOBuilder(factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", productType="
            + this.productType
            + ", taskQuantity="
            + this.taskQuantity
            + ", taskLength="
            + this.taskLength
            + ", taskArea="
            + this.taskArea
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeLength="
            + this.completeLength
            + ", completekArea="
            + this.completekArea
            + ")";
      }
   }
}
