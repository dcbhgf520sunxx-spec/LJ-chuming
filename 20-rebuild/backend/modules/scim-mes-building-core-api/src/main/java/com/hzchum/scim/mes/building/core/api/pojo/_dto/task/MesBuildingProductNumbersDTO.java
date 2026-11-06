package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingProductNumbersDTO", description = "绑码页面获取产品一物一码数据")
public class MesBuildingProductNumbersDTO {
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "number", value = "一物一码号", notes = "一物一码号")
   private Integer number;
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
   @ApiModelProperty(name = "processName", value = "工序情况", notes = "工序情况")
   private String processName;

   public static MesBuildingProductNumbersDTO.MesBuildingProductNumbersDTOBuilder builder() {
      return new MesBuildingProductNumbersDTO.MesBuildingProductNumbersDTOBuilder();
   }

   public MesBuildingProductNumbersDTO() {
   }

   public MesBuildingProductNumbersDTO(
      final Long productId,
      final String serialNumber,
      final Integer number,
      final NameInfo project,
      final NameInfo monomer,
      final Integer taskTypeEnum,
      final LocalDateTime askCompleteTime,
      final String orderNumber,
      final String processName
   ) {
      this.productId = productId;
      this.serialNumber = serialNumber;
      this.number = number;
      this.project = project;
      this.monomer = monomer;
      this.taskTypeEnum = taskTypeEnum;
      this.askCompleteTime = askCompleteTime;
      this.orderNumber = orderNumber;
      this.processName = processName;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getNumber() {
      return this.number;
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

   public String getProcessName() {
      return this.processName;
   }

   public MesBuildingProductNumbersDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesBuildingProductNumbersDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesBuildingProductNumbersDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public MesBuildingProductNumbersDTO setProject(final NameInfo project) {
      this.project = project;
      return this;
   }

   public MesBuildingProductNumbersDTO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   public MesBuildingProductNumbersDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   public MesBuildingProductNumbersDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   public MesBuildingProductNumbersDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   public MesBuildingProductNumbersDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductNumbersDTO(productId="
         + this.getProductId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", number="
         + this.getNumber()
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
         + ", processName="
         + this.getProcessName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductNumbersDTO)) {
         return false;
      }

      MesBuildingProductNumbersDTO other = (MesBuildingProductNumbersDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$number = this.getNumber();
         Object other$number = other.getNumber();
         if (this$number == null ? other$number == null : this$number.equals(other$number)) {
            Object this$taskTypeEnum = this.getTaskTypeEnum();
            Object other$taskTypeEnum = other.getTaskTypeEnum();
            if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
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
                              Object this$processName = this.getProcessName();
                              Object other$processName = other.getProcessName();
                              return this$processName == null ? other$processName == null : this$processName.equals(other$processName);
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
      return other instanceof MesBuildingProductNumbersDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $processName = this.getProcessName();
      return result * 59 + ($processName == null ? 43 : $processName.hashCode());
   }

   public static class MesBuildingProductNumbersDTOBuilder {
      private Long productId;
      private String serialNumber;
      private Integer number;
      private NameInfo project;
      private NameInfo monomer;
      private Integer taskTypeEnum;
      private LocalDateTime askCompleteTime;
      private String orderNumber;
      private String processName;

      MesBuildingProductNumbersDTOBuilder() {
      }

      public MesBuildingProductNumbersDTO.MesBuildingProductNumbersDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesBuildingProductNumbersDTO.MesBuildingProductNumbersDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesBuildingProductNumbersDTO.MesBuildingProductNumbersDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public MesBuildingProductNumbersDTO.MesBuildingProductNumbersDTOBuilder project(final NameInfo project) {
         this.project = project;
         return this;
      }

      public MesBuildingProductNumbersDTO.MesBuildingProductNumbersDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public MesBuildingProductNumbersDTO.MesBuildingProductNumbersDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public MesBuildingProductNumbersDTO.MesBuildingProductNumbersDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public MesBuildingProductNumbersDTO.MesBuildingProductNumbersDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public MesBuildingProductNumbersDTO.MesBuildingProductNumbersDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public MesBuildingProductNumbersDTO build() {
         return new MesBuildingProductNumbersDTO(
            this.productId,
            this.serialNumber,
            this.number,
            this.project,
            this.monomer,
            this.taskTypeEnum,
            this.askCompleteTime,
            this.orderNumber,
            this.processName
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductNumbersDTO.MesBuildingProductNumbersDTOBuilder(productId="
            + this.productId
            + ", serialNumber="
            + this.serialNumber
            + ", number="
            + this.number
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
            + ", processName="
            + this.processName
            + ")";
      }
   }
}
