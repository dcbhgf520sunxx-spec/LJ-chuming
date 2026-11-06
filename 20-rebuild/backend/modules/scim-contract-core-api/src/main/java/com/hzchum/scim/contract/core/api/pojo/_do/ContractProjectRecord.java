package com.hzchum.scim.contract.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractProjectRecord对象", description = "")
@Entity
@TableName("contract_project_record")
@Table(name = "contract_project_record")
public class ContractProjectRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "operationUserId", notes = "操作用户id")
   @JsonProperty("operationUserId")
   @JSONField(name = "operationUserId")
   @TableField("operation_user_id")
   @Column(name = "operation_user_id")
   private Long operationUserId;
   @ApiModelProperty(name = "projectId")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "type", notes = "操作类型 1新增 2删除 3修改 4暂停 5继续")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type")
   private Integer type;

   public static ContractProjectRecord.ContractProjectRecordBuilder builder() {
      return new ContractProjectRecord.ContractProjectRecordBuilder();
   }

   public ContractProjectRecord() {
   }

   public ContractProjectRecord(final Long id, final Long operationUserId, final Long projectId, final Integer type) {
      this.id = id;
      this.operationUserId = operationUserId;
      this.projectId = projectId;
      this.type = type;
   }

   public Long getId() {
      return this.id;
   }

   public Long getOperationUserId() {
      return this.operationUserId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("id")
   public ContractProjectRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("operationUserId")
   public ContractProjectRecord setOperationUserId(final Long operationUserId) {
      this.operationUserId = operationUserId;
      return this;
   }

   @JsonProperty("projectId")
   public ContractProjectRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("type")
   public ContractProjectRecord setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "ContractProjectRecord(id="
         + this.getId()
         + ", operationUserId="
         + this.getOperationUserId()
         + ", projectId="
         + this.getProjectId()
         + ", type="
         + this.getType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectRecord)) {
         return false;
      }

      ContractProjectRecord other = (ContractProjectRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$operationUserId = this.getOperationUserId();
         Object other$operationUserId = other.getOperationUserId();
         if (this$operationUserId == null ? other$operationUserId == null : this$operationUserId.equals(other$operationUserId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               return this$type == null ? other$type == null : this$type.equals(other$type);
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
      return other instanceof ContractProjectRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $operationUserId = this.getOperationUserId();
      result = result * 59 + ($operationUserId == null ? 43 : $operationUserId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   public static class ContractProjectRecordBuilder {
      private Long id;
      private Long operationUserId;
      private Long projectId;
      private Integer type;

      ContractProjectRecordBuilder() {
      }

      @JsonProperty("id")
      public ContractProjectRecord.ContractProjectRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("operationUserId")
      public ContractProjectRecord.ContractProjectRecordBuilder operationUserId(final Long operationUserId) {
         this.operationUserId = operationUserId;
         return this;
      }

      @JsonProperty("projectId")
      public ContractProjectRecord.ContractProjectRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("type")
      public ContractProjectRecord.ContractProjectRecordBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractProjectRecord build() {
         return new ContractProjectRecord(this.id, this.operationUserId, this.projectId, this.type);
      }

      @Override
      public String toString() {
         return "ContractProjectRecord.ContractProjectRecordBuilder(id="
            + this.id
            + ", operationUserId="
            + this.operationUserId
            + ", projectId="
            + this.projectId
            + ", type="
            + this.type
            + ")";
      }
   }
}
