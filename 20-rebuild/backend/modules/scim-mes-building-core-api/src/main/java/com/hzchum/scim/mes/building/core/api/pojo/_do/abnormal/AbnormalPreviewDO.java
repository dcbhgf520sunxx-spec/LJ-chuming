package com.hzchum.scim.mes.building.core.api.pojo._do.abnormal;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AbnormalPreviewDO", description = "异常预览")
public class AbnormalPreviewDO {
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
   @ApiModelProperty(name = "processName", notes = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   @JsonInclude(Include.NON_NULL)
   private String processName;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @JsonInclude(Include.NON_NULL)
   private Integer quantity;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   @JsonInclude(Include.NON_NULL)
   private Integer taskQuantity;
   @ApiModelProperty(name = "inProductionQuantity", notes = "进入生产数量")
   @JsonProperty("inProductionQuantity")
   @JSONField(name = "inProductionQuantity")
   @JsonInclude(Include.NON_NULL)
   private Integer inProductionQuantity;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成时间")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @JsonInclude(Include.NON_NULL)
   private String askCompleteTime;
   @ApiModelProperty(name = "reportType", notes = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   @JsonInclude(Include.NON_NULL)
   private Integer reportType;
   @ApiModelProperty(name = "createTime", notes = "上报时间")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   @JsonInclude(Include.NON_NULL)
   private String createTime;
   @ApiModelProperty(name = "userName", notes = "上报班组长名")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @JsonInclude(Include.NON_NULL)
   private String userName;

   public static AbnormalPreviewDO.AbnormalPreviewDOBuilder builder() {
      return new AbnormalPreviewDO.AbnormalPreviewDOBuilder();
   }

   public AbnormalPreviewDO() {
   }

   public AbnormalPreviewDO(
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final String processName,
      final Integer quantity,
      final Integer taskQuantity,
      final Integer inProductionQuantity,
      final String askCompleteTime,
      final Integer reportType,
      final String createTime,
      final String userName
   ) {
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.processName = processName;
      this.quantity = quantity;
      this.taskQuantity = taskQuantity;
      this.inProductionQuantity = inProductionQuantity;
      this.askCompleteTime = askCompleteTime;
      this.reportType = reportType;
      this.createTime = createTime;
      this.userName = userName;
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

   public String getProcessName() {
      return this.processName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public String getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   public String getCreateTime() {
      return this.createTime;
   }

   public String getUserName() {
      return this.userName;
   }

   @JsonProperty("factory")
   public AbnormalPreviewDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public AbnormalPreviewDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public AbnormalPreviewDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("processName")
   public AbnormalPreviewDO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("quantity")
   public AbnormalPreviewDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("taskQuantity")
   public AbnormalPreviewDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("inProductionQuantity")
   public AbnormalPreviewDO setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public AbnormalPreviewDO setAskCompleteTime(final String askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("reportType")
   public AbnormalPreviewDO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("createTime")
   public AbnormalPreviewDO setCreateTime(final String createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonProperty("userName")
   public AbnormalPreviewDO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @Override
   public String toString() {
      return "AbnormalPreviewDO(factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", processName="
         + this.getProcessName()
         + ", quantity="
         + this.getQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", reportType="
         + this.getReportType()
         + ", createTime="
         + this.getCreateTime()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AbnormalPreviewDO)) {
         return false;
      }

      AbnormalPreviewDO other = (AbnormalPreviewDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$inProductionQuantity = this.getInProductionQuantity();
            Object other$inProductionQuantity = other.getInProductionQuantity();
            if (this$inProductionQuantity == null ? other$inProductionQuantity == null : this$inProductionQuantity.equals(other$inProductionQuantity)) {
               Object this$reportType = this.getReportType();
               Object other$reportType = other.getReportType();
               if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
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
                                 Object this$createTime = this.getCreateTime();
                                 Object other$createTime = other.getCreateTime();
                                 if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                    Object this$userName = this.getUserName();
                                    Object other$userName = other.getUserName();
                                    return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
      return other instanceof AbnormalPreviewDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
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
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   public static class AbnormalPreviewDOBuilder {
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private String processName;
      private Integer quantity;
      private Integer taskQuantity;
      private Integer inProductionQuantity;
      private String askCompleteTime;
      private Integer reportType;
      private String createTime;
      private String userName;

      AbnormalPreviewDOBuilder() {
      }

      @JsonProperty("factory")
      public AbnormalPreviewDO.AbnormalPreviewDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public AbnormalPreviewDO.AbnormalPreviewDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public AbnormalPreviewDO.AbnormalPreviewDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("processName")
      public AbnormalPreviewDO.AbnormalPreviewDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("quantity")
      public AbnormalPreviewDO.AbnormalPreviewDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("taskQuantity")
      public AbnormalPreviewDO.AbnormalPreviewDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("inProductionQuantity")
      public AbnormalPreviewDO.AbnormalPreviewDOBuilder inProductionQuantity(final Integer inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public AbnormalPreviewDO.AbnormalPreviewDOBuilder askCompleteTime(final String askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("reportType")
      public AbnormalPreviewDO.AbnormalPreviewDOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("createTime")
      public AbnormalPreviewDO.AbnormalPreviewDOBuilder createTime(final String createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("userName")
      public AbnormalPreviewDO.AbnormalPreviewDOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public AbnormalPreviewDO build() {
         return new AbnormalPreviewDO(
            this.factory,
            this.workshop,
            this.productionLine,
            this.processName,
            this.quantity,
            this.taskQuantity,
            this.inProductionQuantity,
            this.askCompleteTime,
            this.reportType,
            this.createTime,
            this.userName
         );
      }

      @Override
      public String toString() {
         return "AbnormalPreviewDO.AbnormalPreviewDOBuilder(factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", processName="
            + this.processName
            + ", quantity="
            + this.quantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", reportType="
            + this.reportType
            + ", createTime="
            + this.createTime
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
