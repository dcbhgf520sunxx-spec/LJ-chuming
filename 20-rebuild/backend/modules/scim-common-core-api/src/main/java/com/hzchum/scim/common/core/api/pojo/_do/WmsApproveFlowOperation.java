package com.hzchum.scim.common.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "WmsApproveFlowOperation对象", description = "审批流程操作类型表")
@Entity
@TableName("wms_approve_flow_operation")
@Table(name = "wms_approve_flow_operation")
@org.hibernate.annotations.Table(appliesTo = "wms_approve_flow_operation", comment = "审批流程操作类型表")
public class WmsApproveFlowOperation extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "flowId", value = "流程ID", notes = "流程ID")
   @TableField("flow_id")
   @Column(name = "flow_id", columnDefinition = "bigint  COMMENT '流程ID'", nullable = true)
   private Long flowId;
   @ApiModelProperty(name = "operationType", value = "操作类型 ApproveFlowOperationEnum", notes = "操作类型 ApproveFlowOperationEnum")
   @TableField("operation_type")
   @Column(name = "operation_type", columnDefinition = "int  COMMENT '操作类型 ApproveFlowOperationEnum'", nullable = true)
   private Integer operationType;
   @ApiModelProperty(name = "operation", value = "操作", notes = "操作")
   @TableField("operation")
   @Column(name = "operation", columnDefinition = "varchar(20) COMMENT '操作'", nullable = true)
   private String operation;

   public static WmsApproveFlowOperation.WmsApproveFlowOperationBuilder builder() {
      return new WmsApproveFlowOperation.WmsApproveFlowOperationBuilder();
   }

   public WmsApproveFlowOperation() {
   }

   public WmsApproveFlowOperation(final Long id, final Long flowId, final Integer operationType, final String operation) {
      this.id = id;
      this.flowId = flowId;
      this.operationType = operationType;
      this.operation = operation;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFlowId() {
      return this.flowId;
   }

   public Integer getOperationType() {
      return this.operationType;
   }

   public String getOperation() {
      return this.operation;
   }

   public WmsApproveFlowOperation setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsApproveFlowOperation setFlowId(final Long flowId) {
      this.flowId = flowId;
      return this;
   }

   public WmsApproveFlowOperation setOperationType(final Integer operationType) {
      this.operationType = operationType;
      return this;
   }

   public WmsApproveFlowOperation setOperation(final String operation) {
      this.operation = operation;
      return this;
   }

   @Override
   public String toString() {
      return "WmsApproveFlowOperation(id="
         + this.getId()
         + ", flowId="
         + this.getFlowId()
         + ", operationType="
         + this.getOperationType()
         + ", operation="
         + this.getOperation()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsApproveFlowOperation)) {
         return false;
      }

      WmsApproveFlowOperation other = (WmsApproveFlowOperation)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$flowId = this.getFlowId();
         Object other$flowId = other.getFlowId();
         if (this$flowId == null ? other$flowId == null : this$flowId.equals(other$flowId)) {
            Object this$operationType = this.getOperationType();
            Object other$operationType = other.getOperationType();
            if (this$operationType == null ? other$operationType == null : this$operationType.equals(other$operationType)) {
               Object this$operation = this.getOperation();
               Object other$operation = other.getOperation();
               return this$operation == null ? other$operation == null : this$operation.equals(other$operation);
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
      return other instanceof WmsApproveFlowOperation;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $flowId = this.getFlowId();
      result = result * 59 + ($flowId == null ? 43 : $flowId.hashCode());
      Object $operationType = this.getOperationType();
      result = result * 59 + ($operationType == null ? 43 : $operationType.hashCode());
      Object $operation = this.getOperation();
      return result * 59 + ($operation == null ? 43 : $operation.hashCode());
   }

   public static class WmsApproveFlowOperationBuilder {
      private Long id;
      private Long flowId;
      private Integer operationType;
      private String operation;

      WmsApproveFlowOperationBuilder() {
      }

      public WmsApproveFlowOperation.WmsApproveFlowOperationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsApproveFlowOperation.WmsApproveFlowOperationBuilder flowId(final Long flowId) {
         this.flowId = flowId;
         return this;
      }

      public WmsApproveFlowOperation.WmsApproveFlowOperationBuilder operationType(final Integer operationType) {
         this.operationType = operationType;
         return this;
      }

      public WmsApproveFlowOperation.WmsApproveFlowOperationBuilder operation(final String operation) {
         this.operation = operation;
         return this;
      }

      public WmsApproveFlowOperation build() {
         return new WmsApproveFlowOperation(this.id, this.flowId, this.operationType, this.operation);
      }

      @Override
      public String toString() {
         return "WmsApproveFlowOperation.WmsApproveFlowOperationBuilder(id="
            + this.id
            + ", flowId="
            + this.flowId
            + ", operationType="
            + this.operationType
            + ", operation="
            + this.operation
            + ")";
      }
   }
}
