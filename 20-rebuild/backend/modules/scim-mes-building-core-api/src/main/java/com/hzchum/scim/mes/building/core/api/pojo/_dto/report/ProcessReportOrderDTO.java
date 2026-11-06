package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProcessReportOrderDTO", description = "工序报工工单信息")
public class ProcessReportOrderDTO {
   @ApiModelProperty(name = "id", value = "项目id")
   private String id;
   @ApiModelProperty(name = "serialNumber", value = "项目编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "项目名称")
   private String name;
   @ApiModelProperty(name = "shortName", value = "简称")
   private String shortName;
   @ApiModelProperty(name = "taskQuantity", value = "总任务数")
   private String taskQuantity;
   @ApiModelProperty(name = "InCompleteQuantity", value = "未完成任务数")
   private String inCompleteQuantity;

   public static ProcessReportOrderDTO.ProcessReportOrderDTOBuilder builder() {
      return new ProcessReportOrderDTO.ProcessReportOrderDTOBuilder();
   }

   public ProcessReportOrderDTO() {
   }

   public ProcessReportOrderDTO(
      final String id, final String serialNumber, final String name, final String shortName, final String taskQuantity, final String inCompleteQuantity
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.name = name;
      this.shortName = shortName;
      this.taskQuantity = taskQuantity;
      this.inCompleteQuantity = inCompleteQuantity;
   }

   public String getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getTaskQuantity() {
      return this.taskQuantity;
   }

   public String getInCompleteQuantity() {
      return this.inCompleteQuantity;
   }

   public ProcessReportOrderDTO setId(final String id) {
      this.id = id;
      return this;
   }

   public ProcessReportOrderDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ProcessReportOrderDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public ProcessReportOrderDTO setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   public ProcessReportOrderDTO setTaskQuantity(final String taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   public ProcessReportOrderDTO setInCompleteQuantity(final String inCompleteQuantity) {
      this.inCompleteQuantity = inCompleteQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessReportOrderDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", inCompleteQuantity="
         + this.getInCompleteQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessReportOrderDTO)) {
         return false;
      }

      ProcessReportOrderDTO other = (ProcessReportOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$shortName = this.getShortName();
               Object other$shortName = other.getShortName();
               if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                  Object this$taskQuantity = this.getTaskQuantity();
                  Object other$taskQuantity = other.getTaskQuantity();
                  if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                     Object this$inCompleteQuantity = this.getInCompleteQuantity();
                     Object other$inCompleteQuantity = other.getInCompleteQuantity();
                     return this$inCompleteQuantity == null ? other$inCompleteQuantity == null : this$inCompleteQuantity.equals(other$inCompleteQuantity);
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
      return other instanceof ProcessReportOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $inCompleteQuantity = this.getInCompleteQuantity();
      return result * 59 + ($inCompleteQuantity == null ? 43 : $inCompleteQuantity.hashCode());
   }

   public static class ProcessReportOrderDTOBuilder {
      private String id;
      private String serialNumber;
      private String name;
      private String shortName;
      private String taskQuantity;
      private String inCompleteQuantity;

      ProcessReportOrderDTOBuilder() {
      }

      public ProcessReportOrderDTO.ProcessReportOrderDTOBuilder id(final String id) {
         this.id = id;
         return this;
      }

      public ProcessReportOrderDTO.ProcessReportOrderDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProcessReportOrderDTO.ProcessReportOrderDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProcessReportOrderDTO.ProcessReportOrderDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public ProcessReportOrderDTO.ProcessReportOrderDTOBuilder taskQuantity(final String taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      public ProcessReportOrderDTO.ProcessReportOrderDTOBuilder inCompleteQuantity(final String inCompleteQuantity) {
         this.inCompleteQuantity = inCompleteQuantity;
         return this;
      }

      public ProcessReportOrderDTO build() {
         return new ProcessReportOrderDTO(this.id, this.serialNumber, this.name, this.shortName, this.taskQuantity, this.inCompleteQuantity);
      }

      @Override
      public String toString() {
         return "ProcessReportOrderDTO.ProcessReportOrderDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", taskQuantity="
            + this.taskQuantity
            + ", inCompleteQuantity="
            + this.inCompleteQuantity
            + ")";
      }
   }
}
