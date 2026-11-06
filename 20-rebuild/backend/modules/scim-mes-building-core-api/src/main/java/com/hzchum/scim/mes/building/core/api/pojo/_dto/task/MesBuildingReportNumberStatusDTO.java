package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import io.swagger.annotations.ApiModelProperty;

public class MesBuildingReportNumberStatusDTO {
   @ApiModelProperty(name = "id", notes = "班组生产上报记录表id")
   private Long id;
   @ApiModelProperty(name = "id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "taskId", notes = "任务id")
   private Long taskId;
   @ApiModelProperty(name = "number", notes = "一物一码的构件序号")
   private Long number;
   @ApiModelProperty(name = "processId", notes = "最后上报的工序id")
   private Long processId;
   @ApiModelProperty(name = "status", notes = "构件出入库状态")
   private Integer status;
   @ApiModelProperty(name = "name", notes = "构件状态")
   private String name;
   @ApiModelProperty(name = "name", notes = "是否打印")
   private Boolean boolPrint;

   public static MesBuildingReportNumberStatusDTO.MesBuildingReportNumberStatusDTOBuilder builder() {
      return new MesBuildingReportNumberStatusDTO.MesBuildingReportNumberStatusDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getNumber() {
      return this.number;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getBoolPrint() {
      return this.boolPrint;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   public void setNumber(final Long number) {
      this.number = number;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setBoolPrint(final Boolean boolPrint) {
      this.boolPrint = boolPrint;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingReportNumberStatusDTO)) {
         return false;
      }

      MesBuildingReportNumberStatusDTO other = (MesBuildingReportNumberStatusDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$taskId = this.getTaskId();
            Object other$taskId = other.getTaskId();
            if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
               Object this$number = this.getNumber();
               Object other$number = other.getNumber();
               if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$status = this.getStatus();
                     Object other$status = other.getStatus();
                     if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                        Object this$boolPrint = this.getBoolPrint();
                        Object other$boolPrint = other.getBoolPrint();
                        if (this$boolPrint == null ? other$boolPrint == null : this$boolPrint.equals(other$boolPrint)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof MesBuildingReportNumberStatusDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $boolPrint = this.getBoolPrint();
      result = result * 59 + ($boolPrint == null ? 43 : $boolPrint.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingReportNumberStatusDTO(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", taskId="
         + this.getTaskId()
         + ", number="
         + this.getNumber()
         + ", processId="
         + this.getProcessId()
         + ", status="
         + this.getStatus()
         + ", name="
         + this.getName()
         + ", boolPrint="
         + this.getBoolPrint()
         + ")";
   }

   public MesBuildingReportNumberStatusDTO(
      final Long id,
      final Long productId,
      final Long taskId,
      final Long number,
      final Long processId,
      final Integer status,
      final String name,
      final Boolean boolPrint
   ) {
      this.id = id;
      this.productId = productId;
      this.taskId = taskId;
      this.number = number;
      this.processId = processId;
      this.status = status;
      this.name = name;
      this.boolPrint = boolPrint;
   }

   public MesBuildingReportNumberStatusDTO() {
   }

   public static class MesBuildingReportNumberStatusDTOBuilder {
      private Long id;
      private Long productId;
      private Long taskId;
      private Long number;
      private Long processId;
      private Integer status;
      private String name;
      private Boolean boolPrint;

      MesBuildingReportNumberStatusDTOBuilder() {
      }

      public MesBuildingReportNumberStatusDTO.MesBuildingReportNumberStatusDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingReportNumberStatusDTO.MesBuildingReportNumberStatusDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesBuildingReportNumberStatusDTO.MesBuildingReportNumberStatusDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public MesBuildingReportNumberStatusDTO.MesBuildingReportNumberStatusDTOBuilder number(final Long number) {
         this.number = number;
         return this;
      }

      public MesBuildingReportNumberStatusDTO.MesBuildingReportNumberStatusDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBuildingReportNumberStatusDTO.MesBuildingReportNumberStatusDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public MesBuildingReportNumberStatusDTO.MesBuildingReportNumberStatusDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingReportNumberStatusDTO.MesBuildingReportNumberStatusDTOBuilder boolPrint(final Boolean boolPrint) {
         this.boolPrint = boolPrint;
         return this;
      }

      public MesBuildingReportNumberStatusDTO build() {
         return new MesBuildingReportNumberStatusDTO(this.id, this.productId, this.taskId, this.number, this.processId, this.status, this.name, this.boolPrint);
      }

      @Override
      public String toString() {
         return "MesBuildingReportNumberStatusDTO.MesBuildingReportNumberStatusDTOBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", taskId="
            + this.taskId
            + ", number="
            + this.number
            + ", processId="
            + this.processId
            + ", status="
            + this.status
            + ", name="
            + this.name
            + ", boolPrint="
            + this.boolPrint
            + ")";
      }
   }
}
