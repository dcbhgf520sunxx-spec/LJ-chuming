package com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
@ApiModel(value = "ProjectSchedulingDTO", description = "围护项目排期信息 ")
public class EnclosureProjectSchedulingStateDTO {
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
   @ApiModelProperty("已申购数量")
   private Integer subscribeQuantity;
   @ApiModelProperty(name = "status", notes = "排产状态 1: 未排产 2:部分排产 4:已完全排产")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;

   public static EnclosureProjectSchedulingStateDTO.EnclosureProjectSchedulingStateDTOBuilder builder() {
      return new EnclosureProjectSchedulingStateDTO.EnclosureProjectSchedulingStateDTOBuilder();
   }

   public EnclosureProjectSchedulingStateDTO() {
   }

   public EnclosureProjectSchedulingStateDTO(
      final ProjectInfo project,
      final Long productId,
      final Integer quantity,
      final Integer schedulingQuantity,
      final Integer subscribeQuantity,
      final Integer status
   ) {
      this.project = project;
      this.productId = productId;
      this.quantity = quantity;
      this.schedulingQuantity = schedulingQuantity;
      this.subscribeQuantity = subscribeQuantity;
      this.status = status;
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

   public Integer getSubscribeQuantity() {
      return this.subscribeQuantity;
   }

   public Integer getStatus() {
      return this.status;
   }

   @JsonProperty("project")
   public EnclosureProjectSchedulingStateDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   public EnclosureProjectSchedulingStateDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public EnclosureProjectSchedulingStateDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public EnclosureProjectSchedulingStateDTO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   public EnclosureProjectSchedulingStateDTO setSubscribeQuantity(final Integer subscribeQuantity) {
      this.subscribeQuantity = subscribeQuantity;
      return this;
   }

   @JsonProperty("status")
   public EnclosureProjectSchedulingStateDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureProjectSchedulingStateDTO)) {
         return false;
      }

      EnclosureProjectSchedulingStateDTO other = (EnclosureProjectSchedulingStateDTO)o;
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
               Object this$subscribeQuantity = this.getSubscribeQuantity();
               Object other$subscribeQuantity = other.getSubscribeQuantity();
               if (this$subscribeQuantity == null ? other$subscribeQuantity == null : this$subscribeQuantity.equals(other$subscribeQuantity)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureProjectSchedulingStateDTO;
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
      Object $subscribeQuantity = this.getSubscribeQuantity();
      result = result * 59 + ($subscribeQuantity == null ? 43 : $subscribeQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $project = this.getProject();
      return result * 59 + ($project == null ? 43 : $project.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureProjectSchedulingStateDTO(project="
         + this.getProject()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", subscribeQuantity="
         + this.getSubscribeQuantity()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class EnclosureProjectSchedulingStateDTOBuilder {
      private ProjectInfo project;
      private Long productId;
      private Integer quantity;
      private Integer schedulingQuantity;
      private Integer subscribeQuantity;
      private Integer status;

      EnclosureProjectSchedulingStateDTOBuilder() {
      }

      @JsonProperty("project")
      public EnclosureProjectSchedulingStateDTO.EnclosureProjectSchedulingStateDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public EnclosureProjectSchedulingStateDTO.EnclosureProjectSchedulingStateDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public EnclosureProjectSchedulingStateDTO.EnclosureProjectSchedulingStateDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public EnclosureProjectSchedulingStateDTO.EnclosureProjectSchedulingStateDTOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      public EnclosureProjectSchedulingStateDTO.EnclosureProjectSchedulingStateDTOBuilder subscribeQuantity(final Integer subscribeQuantity) {
         this.subscribeQuantity = subscribeQuantity;
         return this;
      }

      @JsonProperty("status")
      public EnclosureProjectSchedulingStateDTO.EnclosureProjectSchedulingStateDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public EnclosureProjectSchedulingStateDTO build() {
         return new EnclosureProjectSchedulingStateDTO(
            this.project, this.productId, this.quantity, this.schedulingQuantity, this.subscribeQuantity, this.status
         );
      }

      @Override
      public String toString() {
         return "EnclosureProjectSchedulingStateDTO.EnclosureProjectSchedulingStateDTOBuilder(project="
            + this.project
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", subscribeQuantity="
            + this.subscribeQuantity
            + ", status="
            + this.status
            + ")";
      }
   }
}
