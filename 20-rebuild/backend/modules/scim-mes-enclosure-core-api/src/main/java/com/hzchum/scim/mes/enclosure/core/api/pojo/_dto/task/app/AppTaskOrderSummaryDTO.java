package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "AppTaskOrderSummaryDTO", description = "可生产的任务工单")
public class AppTaskOrderSummaryDTO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectInfo project;
   @ApiModelProperty(name = "quantity", notes = "任务数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "orderNumber", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "totalLength", notes = "重量")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;

   public static AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder builder() {
      return new AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder();
   }

   public AppTaskOrderSummaryDTO() {
   }

   public AppTaskOrderSummaryDTO(
      final Long id,
      final ProjectInfo project,
      final Integer quantity,
      final LocalDateTime askCompleteTime,
      final String orderNumber,
      final BigDecimal totalLength
   ) {
      this.id = id;
      this.project = project;
      this.quantity = quantity;
      this.askCompleteTime = askCompleteTime;
      this.orderNumber = orderNumber;
      this.totalLength = totalLength;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   @JsonProperty("id")
   public AppTaskOrderSummaryDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public AppTaskOrderSummaryDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   @JsonProperty("quantity")
   public AppTaskOrderSummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public AppTaskOrderSummaryDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("orderNumber")
   public AppTaskOrderSummaryDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("totalLength")
   public AppTaskOrderSummaryDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @Override
   public String toString() {
      return "AppTaskOrderSummaryDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", quantity="
         + this.getQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", totalLength="
         + this.getTotalLength()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppTaskOrderSummaryDTO)) {
         return false;
      }

      AppTaskOrderSummaryDTO other = (AppTaskOrderSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$askCompleteTime = this.getAskCompleteTime();
               Object other$askCompleteTime = other.getAskCompleteTime();
               if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                  Object this$orderNumber = this.getOrderNumber();
                  Object other$orderNumber = other.getOrderNumber();
                  if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                     Object this$totalLength = this.getTotalLength();
                     Object other$totalLength = other.getTotalLength();
                     return this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength);
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
      return other instanceof AppTaskOrderSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $totalLength = this.getTotalLength();
      return result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
   }

   public static class AppTaskOrderSummaryDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private Integer quantity;
      private LocalDateTime askCompleteTime;
      private String orderNumber;
      private BigDecimal totalLength;

      AppTaskOrderSummaryDTOBuilder() {
      }

      @JsonProperty("id")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      @JsonProperty("quantity")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("orderNumber")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("totalLength")
      public AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public AppTaskOrderSummaryDTO build() {
         return new AppTaskOrderSummaryDTO(this.id, this.project, this.quantity, this.askCompleteTime, this.orderNumber, this.totalLength);
      }

      @Override
      public String toString() {
         return "AppTaskOrderSummaryDTO.AppTaskOrderSummaryDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", quantity="
            + this.quantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", orderNumber="
            + this.orderNumber
            + ", totalLength="
            + this.totalLength
            + ")";
      }
   }
}
