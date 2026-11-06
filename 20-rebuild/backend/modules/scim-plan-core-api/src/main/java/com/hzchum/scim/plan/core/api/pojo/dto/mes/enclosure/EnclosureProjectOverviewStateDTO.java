package com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
@ApiModel(value = "EnclosureProjectOverviewStateDTO", description = "围护项目全部产品生产状态返回类 ")
public class EnclosureProjectOverviewStateDTO {
   @ApiModelProperty(name = "project", value = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectInfo project;
   @ApiModelProperty("产品id")
   private Long productId;
   @ApiModelProperty("数量")
   private Integer quantity;
   @ApiModelProperty("排产数数量")
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "status", notes = "排产状态 1: 生产中 2:已完成")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "totalQuantity", value = "总数")
   private Integer totalQuantity;
   @ApiModelProperty("总完成数量")
   private Integer totalCompleteQuantity;

   public static EnclosureProjectOverviewStateDTO.EnclosureProjectOverviewStateDTOBuilder builder() {
      return new EnclosureProjectOverviewStateDTO.EnclosureProjectOverviewStateDTOBuilder();
   }

   public EnclosureProjectOverviewStateDTO() {
   }

   public EnclosureProjectOverviewStateDTO(
      final ProjectInfo project,
      final Long productId,
      final Integer quantity,
      final Integer schedulingQuantity,
      final Integer status,
      final Integer totalQuantity,
      final Integer totalCompleteQuantity
   ) {
      this.project = project;
      this.productId = productId;
      this.quantity = quantity;
      this.schedulingQuantity = schedulingQuantity;
      this.status = status;
      this.totalQuantity = totalQuantity;
      this.totalCompleteQuantity = totalCompleteQuantity;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public Integer getTotalCompleteQuantity() {
      return this.totalCompleteQuantity;
   }

   @JsonProperty("project")
   public EnclosureProjectOverviewStateDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   public EnclosureProjectOverviewStateDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public EnclosureProjectOverviewStateDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public EnclosureProjectOverviewStateDTO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("status")
   public EnclosureProjectOverviewStateDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public EnclosureProjectOverviewStateDTO setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   public EnclosureProjectOverviewStateDTO setTotalCompleteQuantity(final Integer totalCompleteQuantity) {
      this.totalCompleteQuantity = totalCompleteQuantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureProjectOverviewStateDTO)) {
         return false;
      }

      EnclosureProjectOverviewStateDTO other = (EnclosureProjectOverviewStateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$schedulingQuantity = this.getSchedulingQuantity();
            Object other$schedulingQuantity = other.getSchedulingQuantity();
            if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$totalQuantity = this.getTotalQuantity();
                  Object other$totalQuantity = other.getTotalQuantity();
                  if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
                     Object this$totalCompleteQuantity = this.getTotalCompleteQuantity();
                     Object other$totalCompleteQuantity = other.getTotalCompleteQuantity();
                     if (this$totalCompleteQuantity == null
                        ? other$totalCompleteQuantity == null
                        : this$totalCompleteQuantity.equals(other$totalCompleteQuantity)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        return this$project == null ? other$project == null : this$project.equals(other$project);
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
      return other instanceof EnclosureProjectOverviewStateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $totalCompleteQuantity = this.getTotalCompleteQuantity();
      result = result * 59 + ($totalCompleteQuantity == null ? 43 : $totalCompleteQuantity.hashCode());
      Object $project = this.getProject();
      return result * 59 + ($project == null ? 43 : $project.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureProjectOverviewStateDTO(project="
         + this.getProject()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", status="
         + this.getStatus()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalCompleteQuantity="
         + this.getTotalCompleteQuantity()
         + ")";
   }

   public static class EnclosureProjectOverviewStateDTOBuilder {
      private ProjectInfo project;
      private Long productId;
      private Integer quantity;
      private Integer schedulingQuantity;
      private Integer status;
      private Integer totalQuantity;
      private Integer totalCompleteQuantity;

      EnclosureProjectOverviewStateDTOBuilder() {
      }

      @JsonProperty("project")
      public EnclosureProjectOverviewStateDTO.EnclosureProjectOverviewStateDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public EnclosureProjectOverviewStateDTO.EnclosureProjectOverviewStateDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public EnclosureProjectOverviewStateDTO.EnclosureProjectOverviewStateDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public EnclosureProjectOverviewStateDTO.EnclosureProjectOverviewStateDTOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("status")
      public EnclosureProjectOverviewStateDTO.EnclosureProjectOverviewStateDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public EnclosureProjectOverviewStateDTO.EnclosureProjectOverviewStateDTOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public EnclosureProjectOverviewStateDTO.EnclosureProjectOverviewStateDTOBuilder totalCompleteQuantity(final Integer totalCompleteQuantity) {
         this.totalCompleteQuantity = totalCompleteQuantity;
         return this;
      }

      public EnclosureProjectOverviewStateDTO build() {
         return new EnclosureProjectOverviewStateDTO(
            this.project, this.productId, this.quantity, this.schedulingQuantity, this.status, this.totalQuantity, this.totalCompleteQuantity
         );
      }

      @Override
      public String toString() {
         return "EnclosureProjectOverviewStateDTO.EnclosureProjectOverviewStateDTOBuilder(project="
            + this.project
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", status="
            + this.status
            + ", totalQuantity="
            + this.totalQuantity
            + ", totalCompleteQuantity="
            + this.totalCompleteQuantity
            + ")";
      }
   }
}
