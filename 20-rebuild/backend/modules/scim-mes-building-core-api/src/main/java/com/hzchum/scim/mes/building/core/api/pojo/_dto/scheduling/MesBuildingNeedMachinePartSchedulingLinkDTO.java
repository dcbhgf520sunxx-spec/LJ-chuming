package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingNeedMachinePartSchedulingDTO", description = "每个月份需要排产的数量")
public class MesBuildingNeedMachinePartSchedulingLinkDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @JsonInclude(Include.NON_NULL)
   private Long id;
   @ApiModelProperty(name = "taskId", value = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @JsonInclude(Include.NON_NULL)
   private Long taskId;
   @ApiModelProperty(name = "groupsId", value = "生产组")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @JsonInclude(Include.NON_NULL)
   private Long groupsId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @JsonInclude(Include.NON_NULL)
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @JsonInclude(Include.NON_NULL)
   private Long productionLineId;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @JsonInclude(Include.NON_NULL)
   private Integer quantity;
   @ApiModelProperty(name = "date", value = "排产日期", notes = "排产日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   @JsonInclude(Include.NON_NULL)
   private String month;

   public static MesBuildingNeedMachinePartSchedulingLinkDTO.MesBuildingNeedMachinePartSchedulingLinkDTOBuilder builder() {
      return new MesBuildingNeedMachinePartSchedulingLinkDTO.MesBuildingNeedMachinePartSchedulingLinkDTOBuilder();
   }

   public MesBuildingNeedMachinePartSchedulingLinkDTO(
      final Long id, final Long taskId, final Long groupsId, final Long workshopId, final Long productionLineId, final Integer quantity, final String month
   ) {
      this.id = id;
      this.taskId = taskId;
      this.groupsId = groupsId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.quantity = quantity;
      this.month = month;
   }

   public MesBuildingNeedMachinePartSchedulingLinkDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getMonth() {
      return this.month;
   }

   @JsonProperty("id")
   public MesBuildingNeedMachinePartSchedulingLinkDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingNeedMachinePartSchedulingLinkDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingNeedMachinePartSchedulingLinkDTO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingNeedMachinePartSchedulingLinkDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingNeedMachinePartSchedulingLinkDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingNeedMachinePartSchedulingLinkDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("date")
   public MesBuildingNeedMachinePartSchedulingLinkDTO setMonth(final String month) {
      this.month = month;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNeedMachinePartSchedulingLinkDTO(id="
         + this.getId()
         + ", taskId="
         + this.getTaskId()
         + ", groupsId="
         + this.getGroupsId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", quantity="
         + this.getQuantity()
         + ", month="
         + this.getMonth()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNeedMachinePartSchedulingLinkDTO)) {
         return false;
      }

      MesBuildingNeedMachinePartSchedulingLinkDTO other = (MesBuildingNeedMachinePartSchedulingLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$groupsId = this.getGroupsId();
            Object other$groupsId = other.getGroupsId();
            if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$productionLineId = this.getProductionLineId();
                  Object other$productionLineId = other.getProductionLineId();
                  if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$month = this.getMonth();
                        Object other$month = other.getMonth();
                        return this$month == null ? other$month == null : this$month.equals(other$month);
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
      return other instanceof MesBuildingNeedMachinePartSchedulingLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $month = this.getMonth();
      return result * 59 + ($month == null ? 43 : $month.hashCode());
   }

   public static class MesBuildingNeedMachinePartSchedulingLinkDTOBuilder {
      private Long id;
      private Long taskId;
      private Long groupsId;
      private Long workshopId;
      private Long productionLineId;
      private Integer quantity;
      private String month;

      MesBuildingNeedMachinePartSchedulingLinkDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingNeedMachinePartSchedulingLinkDTO.MesBuildingNeedMachinePartSchedulingLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingNeedMachinePartSchedulingLinkDTO.MesBuildingNeedMachinePartSchedulingLinkDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingNeedMachinePartSchedulingLinkDTO.MesBuildingNeedMachinePartSchedulingLinkDTOBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingNeedMachinePartSchedulingLinkDTO.MesBuildingNeedMachinePartSchedulingLinkDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingNeedMachinePartSchedulingLinkDTO.MesBuildingNeedMachinePartSchedulingLinkDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingNeedMachinePartSchedulingLinkDTO.MesBuildingNeedMachinePartSchedulingLinkDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("date")
      public MesBuildingNeedMachinePartSchedulingLinkDTO.MesBuildingNeedMachinePartSchedulingLinkDTOBuilder month(final String month) {
         this.month = month;
         return this;
      }

      public MesBuildingNeedMachinePartSchedulingLinkDTO build() {
         return new MesBuildingNeedMachinePartSchedulingLinkDTO(
            this.id, this.taskId, this.groupsId, this.workshopId, this.productionLineId, this.quantity, this.month
         );
      }

      @Override
      public String toString() {
         return "MesBuildingNeedMachinePartSchedulingLinkDTO.MesBuildingNeedMachinePartSchedulingLinkDTOBuilder(id="
            + this.id
            + ", taskId="
            + this.taskId
            + ", groupsId="
            + this.groupsId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", quantity="
            + this.quantity
            + ", month="
            + this.month
            + ")";
      }
   }
}
