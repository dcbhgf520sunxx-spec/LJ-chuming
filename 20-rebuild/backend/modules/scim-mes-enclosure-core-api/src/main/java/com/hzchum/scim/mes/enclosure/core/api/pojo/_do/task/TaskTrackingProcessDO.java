package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TaskTrackingProcessDO", description = "任务跟踪列表")
public class TaskTrackingProcessDO {
   @ApiModelProperty(name = "id", notes = "工序id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "工序名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "type", notes = "工序类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "taskOrderId", notes = "任务工单Id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private Long taskOrderId;
   @ApiModelProperty(name = "orderNumber", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "group", notes = "生产组")
   @JsonProperty("group")
   @JSONField(name = "group")
   private NameInfo group;
   @ApiModelProperty(name = "quantity", notes = "总数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "mete", notes = "总重量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeMete", notes = "已完成的重量")
   @JsonProperty("completeMete")
   @JSONField(name = "completeMete")
   private BigDecimal completeMete;
   @ApiModelProperty(name = "rate", notes = "完成率")
   @JsonProperty("rate")
   @JSONField(name = "rate")
   private BigDecimal rate;
   @ApiModelProperty(name = "status", notes = "状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;

   public static TaskTrackingProcessDO.TaskTrackingProcessDOBuilder builder() {
      return new TaskTrackingProcessDO.TaskTrackingProcessDOBuilder();
   }

   public TaskTrackingProcessDO() {
   }

   public TaskTrackingProcessDO(
      final Long id,
      final String name,
      final Integer type,
      final Integer productType,
      final Long taskOrderId,
      final String orderNumber,
      final ProductionLineDetailDO productionLine,
      final NameInfo group,
      final Integer quantity,
      final BigDecimal mete,
      final Integer completeQuantity,
      final BigDecimal completeMete,
      final BigDecimal rate,
      final Integer status
   ) {
      this.id = id;
      this.name = name;
      this.type = type;
      this.productType = productType;
      this.taskOrderId = taskOrderId;
      this.orderNumber = orderNumber;
      this.productionLine = productionLine;
      this.group = group;
      this.quantity = quantity;
      this.mete = mete;
      this.completeQuantity = completeQuantity;
      this.completeMete = completeMete;
      this.rate = rate;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public NameInfo getGroup() {
      return this.group;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteMete() {
      return this.completeMete;
   }

   public BigDecimal getRate() {
      return this.rate;
   }

   public Integer getStatus() {
      return this.status;
   }

   @JsonProperty("id")
   public TaskTrackingProcessDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public TaskTrackingProcessDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("type")
   public TaskTrackingProcessDO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("productType")
   public TaskTrackingProcessDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("taskOrderId")
   public TaskTrackingProcessDO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("orderNumber")
   public TaskTrackingProcessDO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("productionLine")
   public TaskTrackingProcessDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("group")
   public TaskTrackingProcessDO setGroup(final NameInfo group) {
      this.group = group;
      return this;
   }

   @JsonProperty("quantity")
   public TaskTrackingProcessDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("mete")
   public TaskTrackingProcessDO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("completeQuantity")
   public TaskTrackingProcessDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeMete")
   public TaskTrackingProcessDO setCompleteMete(final BigDecimal completeMete) {
      this.completeMete = completeMete;
      return this;
   }

   @JsonProperty("rate")
   public TaskTrackingProcessDO setRate(final BigDecimal rate) {
      this.rate = rate;
      return this;
   }

   @JsonProperty("status")
   public TaskTrackingProcessDO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "TaskTrackingProcessDO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", type="
         + this.getType()
         + ", productType="
         + this.getProductType()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", productionLine="
         + this.getProductionLine()
         + ", group="
         + this.getGroup()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeMete="
         + this.getCompleteMete()
         + ", rate="
         + this.getRate()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskTrackingProcessDO)) {
         return false;
      }

      TaskTrackingProcessDO other = (TaskTrackingProcessDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$taskOrderId = this.getTaskOrderId();
               Object other$taskOrderId = other.getTaskOrderId();
               if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$completeQuantity = this.getCompleteQuantity();
                     Object other$completeQuantity = other.getCompleteQuantity();
                     if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$orderNumber = this.getOrderNumber();
                              Object other$orderNumber = other.getOrderNumber();
                              if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                 Object this$productionLine = this.getProductionLine();
                                 Object other$productionLine = other.getProductionLine();
                                 if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                    Object this$group = this.getGroup();
                                    Object other$group = other.getGroup();
                                    if (this$group == null ? other$group == null : this$group.equals(other$group)) {
                                       Object this$mete = this.getMete();
                                       Object other$mete = other.getMete();
                                       if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                          Object this$completeMete = this.getCompleteMete();
                                          Object other$completeMete = other.getCompleteMete();
                                          if (this$completeMete == null ? other$completeMete == null : this$completeMete.equals(other$completeMete)) {
                                             Object this$rate = this.getRate();
                                             Object other$rate = other.getRate();
                                             return this$rate == null ? other$rate == null : this$rate.equals(other$rate);
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
      return other instanceof TaskTrackingProcessDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $group = this.getGroup();
      result = result * 59 + ($group == null ? 43 : $group.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $completeMete = this.getCompleteMete();
      result = result * 59 + ($completeMete == null ? 43 : $completeMete.hashCode());
      Object $rate = this.getRate();
      return result * 59 + ($rate == null ? 43 : $rate.hashCode());
   }

   public static class TaskTrackingProcessDOBuilder {
      private Long id;
      private String name;
      private Integer type;
      private Integer productType;
      private Long taskOrderId;
      private String orderNumber;
      private ProductionLineDetailDO productionLine;
      private NameInfo group;
      private Integer quantity;
      private BigDecimal mete;
      private Integer completeQuantity;
      private BigDecimal completeMete;
      private BigDecimal rate;
      private Integer status;

      TaskTrackingProcessDOBuilder() {
      }

      @JsonProperty("id")
      public TaskTrackingProcessDO.TaskTrackingProcessDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public TaskTrackingProcessDO.TaskTrackingProcessDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("type")
      public TaskTrackingProcessDO.TaskTrackingProcessDOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("productType")
      public TaskTrackingProcessDO.TaskTrackingProcessDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("taskOrderId")
      public TaskTrackingProcessDO.TaskTrackingProcessDOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("orderNumber")
      public TaskTrackingProcessDO.TaskTrackingProcessDOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("productionLine")
      public TaskTrackingProcessDO.TaskTrackingProcessDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("group")
      public TaskTrackingProcessDO.TaskTrackingProcessDOBuilder group(final NameInfo group) {
         this.group = group;
         return this;
      }

      @JsonProperty("quantity")
      public TaskTrackingProcessDO.TaskTrackingProcessDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public TaskTrackingProcessDO.TaskTrackingProcessDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TaskTrackingProcessDO.TaskTrackingProcessDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeMete")
      public TaskTrackingProcessDO.TaskTrackingProcessDOBuilder completeMete(final BigDecimal completeMete) {
         this.completeMete = completeMete;
         return this;
      }

      @JsonProperty("rate")
      public TaskTrackingProcessDO.TaskTrackingProcessDOBuilder rate(final BigDecimal rate) {
         this.rate = rate;
         return this;
      }

      @JsonProperty("status")
      public TaskTrackingProcessDO.TaskTrackingProcessDOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public TaskTrackingProcessDO build() {
         return new TaskTrackingProcessDO(
            this.id,
            this.name,
            this.type,
            this.productType,
            this.taskOrderId,
            this.orderNumber,
            this.productionLine,
            this.group,
            this.quantity,
            this.mete,
            this.completeQuantity,
            this.completeMete,
            this.rate,
            this.status
         );
      }

      @Override
      public String toString() {
         return "TaskTrackingProcessDO.TaskTrackingProcessDOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", type="
            + this.type
            + ", productType="
            + this.productType
            + ", taskOrderId="
            + this.taskOrderId
            + ", orderNumber="
            + this.orderNumber
            + ", productionLine="
            + this.productionLine
            + ", group="
            + this.group
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeMete="
            + this.completeMete
            + ", rate="
            + this.rate
            + ", status="
            + this.status
            + ")";
      }
   }
}
