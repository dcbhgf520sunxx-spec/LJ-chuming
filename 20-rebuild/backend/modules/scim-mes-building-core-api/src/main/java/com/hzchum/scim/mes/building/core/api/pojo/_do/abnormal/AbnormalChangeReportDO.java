package com.hzchum.scim.mes.building.core.api.pojo._do.abnormal;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AbnormalChangeReportDTO", description = "异常处理页面返回类")
public class AbnormalChangeReportDO {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "leaderName", notes = "班组负责人")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
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
   @ApiModelProperty(name = "quantity", notes = "处理数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成时间")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private String askCompleteTime;
   @ApiModelProperty(name = "completeTime", notes = "完成时间")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private String completeTime;
   @ApiModelProperty(name = "reportType", value = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Integer reportType;

   public static AbnormalChangeReportDO.AbnormalChangeReportDOBuilder builder() {
      return new AbnormalChangeReportDO.AbnormalChangeReportDOBuilder();
   }

   public AbnormalChangeReportDO() {
   }

   public AbnormalChangeReportDO(
      final Long id,
      final String leaderName,
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final Integer quantity,
      final Long processId,
      final String processName,
      final String askCompleteTime,
      final String completeTime,
      final Integer reportType
   ) {
      this.id = id;
      this.leaderName = leaderName;
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.quantity = quantity;
      this.processId = processId;
      this.processName = processName;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
      this.reportType = reportType;
   }

   public Long getId() {
      return this.id;
   }

   public String getLeaderName() {
      return this.leaderName;
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public String getCompleteTime() {
      return this.completeTime;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   @JsonProperty("id")
   public AbnormalChangeReportDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("leaderName")
   public AbnormalChangeReportDO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("factory")
   public AbnormalChangeReportDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public AbnormalChangeReportDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public AbnormalChangeReportDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("quantity")
   public AbnormalChangeReportDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("processId")
   public AbnormalChangeReportDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public AbnormalChangeReportDO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public AbnormalChangeReportDO setAskCompleteTime(final String askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("completeTime")
   public AbnormalChangeReportDO setCompleteTime(final String completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("reportType")
   public AbnormalChangeReportDO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @Override
   public String toString() {
      return "AbnormalChangeReportDO(id="
         + this.getId()
         + ", leaderName="
         + this.getLeaderName()
         + ", factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", quantity="
         + this.getQuantity()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ", reportType="
         + this.getReportType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AbnormalChangeReportDO)) {
         return false;
      }

      AbnormalChangeReportDO other = (AbnormalChangeReportDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$reportType = this.getReportType();
               Object other$reportType = other.getReportType();
               if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                  Object this$leaderName = this.getLeaderName();
                  Object other$leaderName = other.getLeaderName();
                  if (this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName)) {
                     Object this$factory = this.getFactory();
                     Object other$factory = other.getFactory();
                     if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                        Object this$workshop = this.getWorkshop();
                        Object other$workshop = other.getWorkshop();
                        if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                           Object this$productionLine = this.getProductionLine();
                           Object other$productionLine = other.getProductionLine();
                           if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                              Object this$processName = this.getProcessName();
                              Object other$processName = other.getProcessName();
                              if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                 Object this$askCompleteTime = this.getAskCompleteTime();
                                 Object other$askCompleteTime = other.getAskCompleteTime();
                                 if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                                    Object this$completeTime = this.getCompleteTime();
                                    Object other$completeTime = other.getCompleteTime();
                                    return this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime);
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
      return other instanceof AbnormalChangeReportDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $leaderName = this.getLeaderName();
      result = result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }

   public static class AbnormalChangeReportDOBuilder {
      private Long id;
      private String leaderName;
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private Integer quantity;
      private Long processId;
      private String processName;
      private String askCompleteTime;
      private String completeTime;
      private Integer reportType;

      AbnormalChangeReportDOBuilder() {
      }

      @JsonProperty("id")
      public AbnormalChangeReportDO.AbnormalChangeReportDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("leaderName")
      public AbnormalChangeReportDO.AbnormalChangeReportDOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("factory")
      public AbnormalChangeReportDO.AbnormalChangeReportDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public AbnormalChangeReportDO.AbnormalChangeReportDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public AbnormalChangeReportDO.AbnormalChangeReportDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("quantity")
      public AbnormalChangeReportDO.AbnormalChangeReportDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("processId")
      public AbnormalChangeReportDO.AbnormalChangeReportDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public AbnormalChangeReportDO.AbnormalChangeReportDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public AbnormalChangeReportDO.AbnormalChangeReportDOBuilder askCompleteTime(final String askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("completeTime")
      public AbnormalChangeReportDO.AbnormalChangeReportDOBuilder completeTime(final String completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("reportType")
      public AbnormalChangeReportDO.AbnormalChangeReportDOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      public AbnormalChangeReportDO build() {
         return new AbnormalChangeReportDO(
            this.id,
            this.leaderName,
            this.factory,
            this.workshop,
            this.productionLine,
            this.quantity,
            this.processId,
            this.processName,
            this.askCompleteTime,
            this.completeTime,
            this.reportType
         );
      }

      @Override
      public String toString() {
         return "AbnormalChangeReportDO.AbnormalChangeReportDOBuilder(id="
            + this.id
            + ", leaderName="
            + this.leaderName
            + ", factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", quantity="
            + this.quantity
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", completeTime="
            + this.completeTime
            + ", reportType="
            + this.reportType
            + ")";
      }
   }
}
