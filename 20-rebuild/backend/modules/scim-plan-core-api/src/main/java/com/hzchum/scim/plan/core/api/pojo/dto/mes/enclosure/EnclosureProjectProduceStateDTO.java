package com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
@ApiModel(value = "ProjectSchedulingDTO", description = "围护项目生产跟踪状态 ")
public class EnclosureProjectProduceStateDTO {
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

   public static EnclosureProjectProduceStateDTO.EnclosureProjectProduceStateDTOBuilder builder() {
      return new EnclosureProjectProduceStateDTO.EnclosureProjectProduceStateDTOBuilder();
   }

   public EnclosureProjectProduceStateDTO() {
   }

   public EnclosureProjectProduceStateDTO(
      final ProjectInfo project, final Long productId, final Integer quantity, final Integer schedulingQuantity, final Integer status
   ) {
      this.project = project;
      this.productId = productId;
      this.quantity = quantity;
      this.schedulingQuantity = schedulingQuantity;
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

   public Integer getStatus() {
      return this.status;
   }

   @JsonProperty("project")
   public EnclosureProjectProduceStateDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   public EnclosureProjectProduceStateDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public EnclosureProjectProduceStateDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public EnclosureProjectProduceStateDTO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("status")
   public EnclosureProjectProduceStateDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureProjectProduceStateDTO)) {
         return false;
      }

      EnclosureProjectProduceStateDTO other = (EnclosureProjectProduceStateDTO)o;
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureProjectProduceStateDTO;
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
      Object $project = this.getProject();
      return result * 59 + ($project == null ? 43 : $project.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureProjectProduceStateDTO(project="
         + this.getProject()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class EnclosureProjectProduceStateDTOBuilder {
      private ProjectInfo project;
      private Long productId;
      private Integer quantity;
      private Integer schedulingQuantity;
      private Integer status;

      EnclosureProjectProduceStateDTOBuilder() {
      }

      @JsonProperty("project")
      public EnclosureProjectProduceStateDTO.EnclosureProjectProduceStateDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public EnclosureProjectProduceStateDTO.EnclosureProjectProduceStateDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public EnclosureProjectProduceStateDTO.EnclosureProjectProduceStateDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public EnclosureProjectProduceStateDTO.EnclosureProjectProduceStateDTOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("status")
      public EnclosureProjectProduceStateDTO.EnclosureProjectProduceStateDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public EnclosureProjectProduceStateDTO build() {
         return new EnclosureProjectProduceStateDTO(this.project, this.productId, this.quantity, this.schedulingQuantity, this.status);
      }

      @Override
      public String toString() {
         return "EnclosureProjectProduceStateDTO.EnclosureProjectProduceStateDTOBuilder(project="
            + this.project
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", status="
            + this.status
            + ")";
      }
   }
}
