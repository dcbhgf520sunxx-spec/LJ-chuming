package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report;

import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesEnclosureProduceTeamReportDTO", description = "围护班组生产上报记录表 ")
public class MesEnclosureProduceTeamReportDTO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "task_order_id", value = "工单id", notes = "工单id")
   private Long taskOrderId;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   private Long taskId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   private Long processId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "生产数量", notes = "生产数量")
   private Integer quantity;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id")
   private Long productionLineId;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   private Long teamId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   private Long userId;
   @ApiModelProperty(name = "price", value = "工价 每米")
   private BigDecimal price;
   @ApiModelProperty(name = "enclosureName", value = "围护编号")
   private Integer enclosureId;
   @ApiModelProperty(name = "enclosureName", value = "围护名称")
   private String enclosureName;
   @ApiModelProperty(name = "boolStatusEnum", value = "冻结状态")
   private Integer boolStatusEnum;

   public static MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder builder() {
      return new MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder();
   }

   public MesEnclosureProduceTeamReportDTO() {
   }

   public MesEnclosureProduceTeamReportDTO(
      final Long id,
      final Long taskOrderId,
      final Long taskId,
      final Long processId,
      final Long productId,
      final Integer quantity,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long teamId,
      final Long userId,
      final BigDecimal price,
      final Integer enclosureId,
      final String enclosureName,
      final Integer boolStatusEnum
   ) {
      this.id = id;
      this.taskOrderId = taskOrderId;
      this.taskId = taskId;
      this.processId = processId;
      this.productId = productId;
      this.quantity = quantity;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.teamId = teamId;
      this.userId = userId;
      this.price = price;
      this.enclosureId = enclosureId;
      this.enclosureName = enclosureName;
      this.boolStatusEnum = boolStatusEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Integer getEnclosureId() {
      return this.enclosureId;
   }

   public String getEnclosureName() {
      return this.enclosureName;
   }

   public Integer getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public MesEnclosureProduceTeamReportDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesEnclosureProduceTeamReportDTO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   public MesEnclosureProduceTeamReportDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public MesEnclosureProduceTeamReportDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesEnclosureProduceTeamReportDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesEnclosureProduceTeamReportDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MesEnclosureProduceTeamReportDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   public MesEnclosureProduceTeamReportDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public MesEnclosureProduceTeamReportDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   public MesEnclosureProduceTeamReportDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   public MesEnclosureProduceTeamReportDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public MesEnclosureProduceTeamReportDTO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public MesEnclosureProduceTeamReportDTO setEnclosureId(final Integer enclosureId) {
      this.enclosureId = enclosureId;
      return this;
   }

   public MesEnclosureProduceTeamReportDTO setEnclosureName(final String enclosureName) {
      this.enclosureName = enclosureName;
      return this;
   }

   public MesEnclosureProduceTeamReportDTO setBoolStatusEnum(final Integer boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProduceTeamReportDTO(id="
         + this.getId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", taskId="
         + this.getTaskId()
         + ", processId="
         + this.getProcessId()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", teamId="
         + this.getTeamId()
         + ", userId="
         + this.getUserId()
         + ", price="
         + this.getPrice()
         + ", enclosureId="
         + this.getEnclosureId()
         + ", enclosureName="
         + this.getEnclosureName()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProduceTeamReportDTO)) {
         return false;
      }

      MesEnclosureProduceTeamReportDTO other = (MesEnclosureProduceTeamReportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskOrderId = this.getTaskOrderId();
         Object other$taskOrderId = other.getTaskOrderId();
         if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
            Object this$taskId = this.getTaskId();
            Object other$taskId = other.getTaskId();
            if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                  Object this$productId = this.getProductId();
                  Object other$productId = other.getProductId();
                  if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$factoryId = this.getFactoryId();
                        Object other$factoryId = other.getFactoryId();
                        if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                           Object this$workshopId = this.getWorkshopId();
                           Object other$workshopId = other.getWorkshopId();
                           if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                              Object this$productionLineId = this.getProductionLineId();
                              Object other$productionLineId = other.getProductionLineId();
                              if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                                 Object this$teamId = this.getTeamId();
                                 Object other$teamId = other.getTeamId();
                                 if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$enclosureId = this.getEnclosureId();
                                       Object other$enclosureId = other.getEnclosureId();
                                       if (this$enclosureId == null ? other$enclosureId == null : this$enclosureId.equals(other$enclosureId)) {
                                          Object this$boolStatusEnum = this.getBoolStatusEnum();
                                          Object other$boolStatusEnum = other.getBoolStatusEnum();
                                          if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                                             Object this$price = this.getPrice();
                                             Object other$price = other.getPrice();
                                             if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                Object this$enclosureName = this.getEnclosureName();
                                                Object other$enclosureName = other.getEnclosureName();
                                                return this$enclosureName == null
                                                   ? other$enclosureName == null
                                                   : this$enclosureName.equals(other$enclosureName);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureProduceTeamReportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $enclosureId = this.getEnclosureId();
      result = result * 59 + ($enclosureId == null ? 43 : $enclosureId.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $enclosureName = this.getEnclosureName();
      return result * 59 + ($enclosureName == null ? 43 : $enclosureName.hashCode());
   }

   public static class MesEnclosureProduceTeamReportDTOBuilder {
      private Long id;
      private Long taskOrderId;
      private Long taskId;
      private Long processId;
      private Long productId;
      private Integer quantity;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long teamId;
      private Long userId;
      private BigDecimal price;
      private Integer enclosureId;
      private String enclosureName;
      private Integer boolStatusEnum;

      MesEnclosureProduceTeamReportDTOBuilder() {
      }

      public MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder enclosureId(final Integer enclosureId) {
         this.enclosureId = enclosureId;
         return this;
      }

      public MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder enclosureName(final String enclosureName) {
         this.enclosureName = enclosureName;
         return this;
      }

      public MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder boolStatusEnum(final Integer boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      public MesEnclosureProduceTeamReportDTO build() {
         return new MesEnclosureProduceTeamReportDTO(
            this.id,
            this.taskOrderId,
            this.taskId,
            this.processId,
            this.productId,
            this.quantity,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.teamId,
            this.userId,
            this.price,
            this.enclosureId,
            this.enclosureName,
            this.boolStatusEnum
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureProduceTeamReportDTO.MesEnclosureProduceTeamReportDTOBuilder(id="
            + this.id
            + ", taskOrderId="
            + this.taskOrderId
            + ", taskId="
            + this.taskId
            + ", processId="
            + this.processId
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", teamId="
            + this.teamId
            + ", userId="
            + this.userId
            + ", price="
            + this.price
            + ", enclosureId="
            + this.enclosureId
            + ", enclosureName="
            + this.enclosureName
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ")";
      }
   }
}
