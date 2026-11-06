package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingNumberTaskOrderDTO", description = "绑码页面获取工单数据")
public class MesBuildingNumberTaskOrderDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private NameInfo project;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   private String orderNumber;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   private Integer quantity;

   public static MesBuildingNumberTaskOrderDTO.MesBuildingNumberTaskOrderDTOBuilder builder() {
      return new MesBuildingNumberTaskOrderDTO.MesBuildingNumberTaskOrderDTOBuilder();
   }

   public MesBuildingNumberTaskOrderDTO() {
   }

   public MesBuildingNumberTaskOrderDTO(
      final Long id,
      final NameInfo project,
      final NameInfo monomer,
      final Integer taskTypeEnum,
      final LocalDateTime askCompleteTime,
      final String orderNumber,
      final Long productId,
      final String serialNumber,
      final Integer quantity
   ) {
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.taskTypeEnum = taskTypeEnum;
      this.askCompleteTime = askCompleteTime;
      this.orderNumber = orderNumber;
      this.productId = productId;
      this.serialNumber = serialNumber;
      this.quantity = quantity;
   }

   public Long getId() {
      return this.id;
   }

   public NameInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public MesBuildingNumberTaskOrderDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingNumberTaskOrderDTO setProject(final NameInfo project) {
      this.project = project;
      return this;
   }

   public MesBuildingNumberTaskOrderDTO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   public MesBuildingNumberTaskOrderDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   public MesBuildingNumberTaskOrderDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   public MesBuildingNumberTaskOrderDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   public MesBuildingNumberTaskOrderDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesBuildingNumberTaskOrderDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesBuildingNumberTaskOrderDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNumberTaskOrderDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", productId="
         + this.getProductId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNumberTaskOrderDTO)) {
         return false;
      }

      MesBuildingNumberTaskOrderDTO other = (MesBuildingNumberTaskOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskTypeEnum = this.getTaskTypeEnum();
         Object other$taskTypeEnum = other.getTaskTypeEnum();
         if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$monomer = this.getMonomer();
                     Object other$monomer = other.getMonomer();
                     if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                        Object this$askCompleteTime = this.getAskCompleteTime();
                        Object other$askCompleteTime = other.getAskCompleteTime();
                        if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                           Object this$orderNumber = this.getOrderNumber();
                           Object other$orderNumber = other.getOrderNumber();
                           if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof MesBuildingNumberTaskOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   public static class MesBuildingNumberTaskOrderDTOBuilder {
      private Long id;
      private NameInfo project;
      private NameInfo monomer;
      private Integer taskTypeEnum;
      private LocalDateTime askCompleteTime;
      private String orderNumber;
      private Long productId;
      private String serialNumber;
      private Integer quantity;

      MesBuildingNumberTaskOrderDTOBuilder() {
      }

      public MesBuildingNumberTaskOrderDTO.MesBuildingNumberTaskOrderDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingNumberTaskOrderDTO.MesBuildingNumberTaskOrderDTOBuilder project(final NameInfo project) {
         this.project = project;
         return this;
      }

      public MesBuildingNumberTaskOrderDTO.MesBuildingNumberTaskOrderDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public MesBuildingNumberTaskOrderDTO.MesBuildingNumberTaskOrderDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public MesBuildingNumberTaskOrderDTO.MesBuildingNumberTaskOrderDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public MesBuildingNumberTaskOrderDTO.MesBuildingNumberTaskOrderDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public MesBuildingNumberTaskOrderDTO.MesBuildingNumberTaskOrderDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesBuildingNumberTaskOrderDTO.MesBuildingNumberTaskOrderDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesBuildingNumberTaskOrderDTO.MesBuildingNumberTaskOrderDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingNumberTaskOrderDTO build() {
         return new MesBuildingNumberTaskOrderDTO(
            this.id, this.project, this.monomer, this.taskTypeEnum, this.askCompleteTime, this.orderNumber, this.productId, this.serialNumber, this.quantity
         );
      }

      @Override
      public String toString() {
         return "MesBuildingNumberTaskOrderDTO.MesBuildingNumberTaskOrderDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", orderNumber="
            + this.orderNumber
            + ", productId="
            + this.productId
            + ", serialNumber="
            + this.serialNumber
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
