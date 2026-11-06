package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TaskTrackingProcessDTO", description = "任务跟踪列表")
public class TaskTrackingProcessDTO {
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
   @ApiModelProperty(name = "workShop", notes = "车间")
   @JsonProperty("workShop")
   @JSONField(name = "workShop")
   private NameInfo workShop;
   @ApiModelProperty(name = "quantity", notes = "总数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "mete", notes = "总重量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeMete", notes = "已完成的重量")
   @JsonProperty("completeMete")
   @JSONField(name = "completeMete")
   private BigDecimal completeMete;
   @ApiModelProperty(name = "completeGrossWeight", notes = "已完成重量(毛重)")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(name = "completeNetWeight", notes = "已完成重量(净重)")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "unQuantity", notes = "未完成")
   @JsonProperty("unQuantity")
   @JSONField(name = "unQuantity")
   private Integer unQuantity;
   @ApiModelProperty(name = "rate", notes = "完成率")
   @JsonProperty("rate")
   @JSONField(name = "rate")
   private BigDecimal rate;
   @ApiModelProperty(name = "status", notes = "状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "operator", notes = "操作人")
   @JsonProperty("operator")
   @JSONField(name = "operator")
   private String operator;
   @ApiModelProperty(name = "cutConfigId", notes = "切割配置id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   private Long cutConfigId;
   @ApiModelProperty(name = "partProdModeName", notes = "切割方式")
   @JsonProperty("partProdModeName")
   @JSONField(name = "partProdModeName")
   private String partProdModeName;

   public static TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder builder() {
      return new TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder();
   }

   public TaskTrackingProcessDTO() {
   }

   public TaskTrackingProcessDTO(
      final Long id,
      final String name,
      final Integer type,
      final Integer productType,
      final Long taskOrderId,
      final String orderNumber,
      final ProductionLineDetailDO productionLine,
      final NameInfo workShop,
      final Integer quantity,
      final BigDecimal mete,
      final BigDecimal totalGrossWeight,
      final BigDecimal totalNetWeight,
      final Integer completeQuantity,
      final BigDecimal completeMete,
      final BigDecimal completeGrossWeight,
      final BigDecimal completeNetWeight,
      final Integer unQuantity,
      final BigDecimal rate,
      final Integer status,
      final String operator,
      final Long cutConfigId,
      final String partProdModeName
   ) {
      this.id = id;
      this.name = name;
      this.type = type;
      this.productType = productType;
      this.taskOrderId = taskOrderId;
      this.orderNumber = orderNumber;
      this.productionLine = productionLine;
      this.workShop = workShop;
      this.quantity = quantity;
      this.mete = mete;
      this.totalGrossWeight = totalGrossWeight;
      this.totalNetWeight = totalNetWeight;
      this.completeQuantity = completeQuantity;
      this.completeMete = completeMete;
      this.completeGrossWeight = completeGrossWeight;
      this.completeNetWeight = completeNetWeight;
      this.unQuantity = unQuantity;
      this.rate = rate;
      this.status = status;
      this.operator = operator;
      this.cutConfigId = cutConfigId;
      this.partProdModeName = partProdModeName;
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

   public NameInfo getWorkShop() {
      return this.workShop;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteMete() {
      return this.completeMete;
   }

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public Integer getUnQuantity() {
      return this.unQuantity;
   }

   public BigDecimal getRate() {
      return this.rate;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getOperator() {
      return this.operator;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public String getPartProdModeName() {
      return this.partProdModeName;
   }

   @JsonProperty("id")
   public TaskTrackingProcessDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public TaskTrackingProcessDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("type")
   public TaskTrackingProcessDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("productType")
   public TaskTrackingProcessDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("taskOrderId")
   public TaskTrackingProcessDTO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("orderNumber")
   public TaskTrackingProcessDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("productionLine")
   public TaskTrackingProcessDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("workShop")
   public TaskTrackingProcessDTO setWorkShop(final NameInfo workShop) {
      this.workShop = workShop;
      return this;
   }

   @JsonProperty("quantity")
   public TaskTrackingProcessDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("mete")
   public TaskTrackingProcessDTO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public TaskTrackingProcessDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public TaskTrackingProcessDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("completeQuantity")
   public TaskTrackingProcessDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeMete")
   public TaskTrackingProcessDTO setCompleteMete(final BigDecimal completeMete) {
      this.completeMete = completeMete;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public TaskTrackingProcessDTO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public TaskTrackingProcessDTO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("unQuantity")
   public TaskTrackingProcessDTO setUnQuantity(final Integer unQuantity) {
      this.unQuantity = unQuantity;
      return this;
   }

   @JsonProperty("rate")
   public TaskTrackingProcessDTO setRate(final BigDecimal rate) {
      this.rate = rate;
      return this;
   }

   @JsonProperty("status")
   public TaskTrackingProcessDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("operator")
   public TaskTrackingProcessDTO setOperator(final String operator) {
      this.operator = operator;
      return this;
   }

   @JsonProperty("cutConfigId")
   public TaskTrackingProcessDTO setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("partProdModeName")
   public TaskTrackingProcessDTO setPartProdModeName(final String partProdModeName) {
      this.partProdModeName = partProdModeName;
      return this;
   }

   @Override
   public String toString() {
      return "TaskTrackingProcessDTO(id="
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
         + ", workShop="
         + this.getWorkShop()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeMete="
         + this.getCompleteMete()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", unQuantity="
         + this.getUnQuantity()
         + ", rate="
         + this.getRate()
         + ", status="
         + this.getStatus()
         + ", operator="
         + this.getOperator()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", partProdModeName="
         + this.getPartProdModeName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskTrackingProcessDTO)) {
         return false;
      }

      TaskTrackingProcessDTO other = (TaskTrackingProcessDTO)o;
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
                        Object this$unQuantity = this.getUnQuantity();
                        Object other$unQuantity = other.getUnQuantity();
                        if (this$unQuantity == null ? other$unQuantity == null : this$unQuantity.equals(other$unQuantity)) {
                           Object this$status = this.getStatus();
                           Object other$status = other.getStatus();
                           if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                              Object this$cutConfigId = this.getCutConfigId();
                              Object other$cutConfigId = other.getCutConfigId();
                              if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$orderNumber = this.getOrderNumber();
                                    Object other$orderNumber = other.getOrderNumber();
                                    if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                       Object this$productionLine = this.getProductionLine();
                                       Object other$productionLine = other.getProductionLine();
                                       if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                          Object this$workShop = this.getWorkShop();
                                          Object other$workShop = other.getWorkShop();
                                          if (this$workShop == null ? other$workShop == null : this$workShop.equals(other$workShop)) {
                                             Object this$mete = this.getMete();
                                             Object other$mete = other.getMete();
                                             if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                if (this$totalGrossWeight == null
                                                   ? other$totalGrossWeight == null
                                                   : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                   Object this$totalNetWeight = this.getTotalNetWeight();
                                                   Object other$totalNetWeight = other.getTotalNetWeight();
                                                   if (this$totalNetWeight == null
                                                      ? other$totalNetWeight == null
                                                      : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                      Object this$completeMete = this.getCompleteMete();
                                                      Object other$completeMete = other.getCompleteMete();
                                                      if (this$completeMete == null ? other$completeMete == null : this$completeMete.equals(other$completeMete)
                                                         )
                                                       {
                                                         Object this$completeGrossWeight = this.getCompleteGrossWeight();
                                                         Object other$completeGrossWeight = other.getCompleteGrossWeight();
                                                         if (this$completeGrossWeight == null
                                                            ? other$completeGrossWeight == null
                                                            : this$completeGrossWeight.equals(other$completeGrossWeight)) {
                                                            Object this$completeNetWeight = this.getCompleteNetWeight();
                                                            Object other$completeNetWeight = other.getCompleteNetWeight();
                                                            if (this$completeNetWeight == null
                                                               ? other$completeNetWeight == null
                                                               : this$completeNetWeight.equals(other$completeNetWeight)) {
                                                               Object this$rate = this.getRate();
                                                               Object other$rate = other.getRate();
                                                               if (this$rate == null ? other$rate == null : this$rate.equals(other$rate)) {
                                                                  Object this$operator = this.getOperator();
                                                                  Object other$operator = other.getOperator();
                                                                  if (this$operator == null ? other$operator == null : this$operator.equals(other$operator)) {
                                                                     Object this$partProdModeName = this.getPartProdModeName();
                                                                     Object other$partProdModeName = other.getPartProdModeName();
                                                                     return this$partProdModeName == null
                                                                        ? other$partProdModeName == null
                                                                        : this$partProdModeName.equals(other$partProdModeName);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TaskTrackingProcessDTO;
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
      Object $unQuantity = this.getUnQuantity();
      result = result * 59 + ($unQuantity == null ? 43 : $unQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $workShop = this.getWorkShop();
      result = result * 59 + ($workShop == null ? 43 : $workShop.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $completeMete = this.getCompleteMete();
      result = result * 59 + ($completeMete == null ? 43 : $completeMete.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $rate = this.getRate();
      result = result * 59 + ($rate == null ? 43 : $rate.hashCode());
      Object $operator = this.getOperator();
      result = result * 59 + ($operator == null ? 43 : $operator.hashCode());
      Object $partProdModeName = this.getPartProdModeName();
      return result * 59 + ($partProdModeName == null ? 43 : $partProdModeName.hashCode());
   }

   public static class TaskTrackingProcessDTOBuilder {
      private Long id;
      private String name;
      private Integer type;
      private Integer productType;
      private Long taskOrderId;
      private String orderNumber;
      private ProductionLineDetailDO productionLine;
      private NameInfo workShop;
      private Integer quantity;
      private BigDecimal mete;
      private BigDecimal totalGrossWeight;
      private BigDecimal totalNetWeight;
      private Integer completeQuantity;
      private BigDecimal completeMete;
      private BigDecimal completeGrossWeight;
      private BigDecimal completeNetWeight;
      private Integer unQuantity;
      private BigDecimal rate;
      private Integer status;
      private String operator;
      private Long cutConfigId;
      private String partProdModeName;

      TaskTrackingProcessDTOBuilder() {
      }

      @JsonProperty("id")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("type")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("productType")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("taskOrderId")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("orderNumber")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("productionLine")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("workShop")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder workShop(final NameInfo workShop) {
         this.workShop = workShop;
         return this;
      }

      @JsonProperty("quantity")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeMete")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder completeMete(final BigDecimal completeMete) {
         this.completeMete = completeMete;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("unQuantity")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder unQuantity(final Integer unQuantity) {
         this.unQuantity = unQuantity;
         return this;
      }

      @JsonProperty("rate")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder rate(final BigDecimal rate) {
         this.rate = rate;
         return this;
      }

      @JsonProperty("status")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("operator")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder operator(final String operator) {
         this.operator = operator;
         return this;
      }

      @JsonProperty("cutConfigId")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("partProdModeName")
      public TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder partProdModeName(final String partProdModeName) {
         this.partProdModeName = partProdModeName;
         return this;
      }

      public TaskTrackingProcessDTO build() {
         return new TaskTrackingProcessDTO(
            this.id,
            this.name,
            this.type,
            this.productType,
            this.taskOrderId,
            this.orderNumber,
            this.productionLine,
            this.workShop,
            this.quantity,
            this.mete,
            this.totalGrossWeight,
            this.totalNetWeight,
            this.completeQuantity,
            this.completeMete,
            this.completeGrossWeight,
            this.completeNetWeight,
            this.unQuantity,
            this.rate,
            this.status,
            this.operator,
            this.cutConfigId,
            this.partProdModeName
         );
      }

      @Override
      public String toString() {
         return "TaskTrackingProcessDTO.TaskTrackingProcessDTOBuilder(id="
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
            + ", workShop="
            + this.workShop
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeMete="
            + this.completeMete
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", unQuantity="
            + this.unQuantity
            + ", rate="
            + this.rate
            + ", status="
            + this.status
            + ", operator="
            + this.operator
            + ", cutConfigId="
            + this.cutConfigId
            + ", partProdModeName="
            + this.partProdModeName
            + ")";
      }
   }
}
