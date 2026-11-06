package com.hzchum.scim.mes.building.core.api.pojo._do.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProduceAbonrmalReportDO", description = "异常处理页面返回类")
public class ProduceAbonrmalReportDO {
   @ApiModelProperty(name = "id", value = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "taskId", value = "taskId")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "quantity", value = "生产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "reportType", value = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Integer reportType;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
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
   @ApiModelProperty(name = "userName", notes = "组长")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "processName", notes = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成时间")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private String askCompleteTime;

   public static ProduceAbonrmalReportDO.ProduceAbonrmalReportDOBuilder builder() {
      return new ProduceAbonrmalReportDO.ProduceAbonrmalReportDOBuilder();
   }

   public ProduceAbonrmalReportDO() {
   }

   public ProduceAbonrmalReportDO(
      final Long id,
      final Long taskId,
      final Integer quantity,
      final Integer reportType,
      final String serialNumber,
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final String userName,
      final String processName,
      final Long processId,
      final String askCompleteTime
   ) {
      this.id = id;
      this.taskId = taskId;
      this.quantity = quantity;
      this.reportType = reportType;
      this.serialNumber = serialNumber;
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.userName = userName;
      this.processName = processName;
      this.processId = processId;
      this.askCompleteTime = askCompleteTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
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

   public String getUserName() {
      return this.userName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getAskCompleteTime() {
      return this.askCompleteTime;
   }

   @JsonProperty("id")
   public ProduceAbonrmalReportDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskId")
   public ProduceAbonrmalReportDO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("quantity")
   public ProduceAbonrmalReportDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("reportType")
   public ProduceAbonrmalReportDO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProduceAbonrmalReportDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("factory")
   public ProduceAbonrmalReportDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public ProduceAbonrmalReportDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public ProduceAbonrmalReportDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("userName")
   public ProduceAbonrmalReportDO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("processName")
   public ProduceAbonrmalReportDO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("processId")
   public ProduceAbonrmalReportDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public ProduceAbonrmalReportDO setAskCompleteTime(final String askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @Override
   public String toString() {
      return "ProduceAbonrmalReportDO(id="
         + this.getId()
         + ", taskId="
         + this.getTaskId()
         + ", quantity="
         + this.getQuantity()
         + ", reportType="
         + this.getReportType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", userName="
         + this.getUserName()
         + ", processName="
         + this.getProcessName()
         + ", processId="
         + this.getProcessId()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProduceAbonrmalReportDO)) {
         return false;
      }

      ProduceAbonrmalReportDO other = (ProduceAbonrmalReportDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$reportType = this.getReportType();
               Object other$reportType = other.getReportType();
               if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$factory = this.getFactory();
                        Object other$factory = other.getFactory();
                        if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                           Object this$workshop = this.getWorkshop();
                           Object other$workshop = other.getWorkshop();
                           if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                              Object this$productionLine = this.getProductionLine();
                              Object other$productionLine = other.getProductionLine();
                              if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                 Object this$userName = this.getUserName();
                                 Object other$userName = other.getUserName();
                                 if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                    Object this$processName = this.getProcessName();
                                    Object other$processName = other.getProcessName();
                                    if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                       Object this$askCompleteTime = this.getAskCompleteTime();
                                       Object other$askCompleteTime = other.getAskCompleteTime();
                                       return this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime);
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
      return other instanceof ProduceAbonrmalReportDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   public static class ProduceAbonrmalReportDOBuilder {
      private Long id;
      private Long taskId;
      private Integer quantity;
      private Integer reportType;
      private String serialNumber;
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private String userName;
      private String processName;
      private Long processId;
      private String askCompleteTime;

      ProduceAbonrmalReportDOBuilder() {
      }

      @JsonProperty("id")
      public ProduceAbonrmalReportDO.ProduceAbonrmalReportDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskId")
      public ProduceAbonrmalReportDO.ProduceAbonrmalReportDOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("quantity")
      public ProduceAbonrmalReportDO.ProduceAbonrmalReportDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("reportType")
      public ProduceAbonrmalReportDO.ProduceAbonrmalReportDOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProduceAbonrmalReportDO.ProduceAbonrmalReportDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("factory")
      public ProduceAbonrmalReportDO.ProduceAbonrmalReportDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public ProduceAbonrmalReportDO.ProduceAbonrmalReportDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public ProduceAbonrmalReportDO.ProduceAbonrmalReportDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("userName")
      public ProduceAbonrmalReportDO.ProduceAbonrmalReportDOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("processName")
      public ProduceAbonrmalReportDO.ProduceAbonrmalReportDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("processId")
      public ProduceAbonrmalReportDO.ProduceAbonrmalReportDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public ProduceAbonrmalReportDO.ProduceAbonrmalReportDOBuilder askCompleteTime(final String askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public ProduceAbonrmalReportDO build() {
         return new ProduceAbonrmalReportDO(
            this.id,
            this.taskId,
            this.quantity,
            this.reportType,
            this.serialNumber,
            this.factory,
            this.workshop,
            this.productionLine,
            this.userName,
            this.processName,
            this.processId,
            this.askCompleteTime
         );
      }

      @Override
      public String toString() {
         return "ProduceAbonrmalReportDO.ProduceAbonrmalReportDOBuilder(id="
            + this.id
            + ", taskId="
            + this.taskId
            + ", quantity="
            + this.quantity
            + ", reportType="
            + this.reportType
            + ", serialNumber="
            + this.serialNumber
            + ", factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", userName="
            + this.userName
            + ", processName="
            + this.processName
            + ", processId="
            + this.processId
            + ", askCompleteTime="
            + this.askCompleteTime
            + ")";
      }
   }
}
