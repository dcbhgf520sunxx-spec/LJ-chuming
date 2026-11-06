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

@ApiModel(value = "ContractProjectRecordDetail对象", description = "")
@Entity
@TableName("contract_project_record_detail")
@Table(name = "contract_project_record_detail")
public class ContractProjectRecordDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "recordId", value = "项目变更记录表id")
   @JsonProperty("recordId")
   @JSONField(name = "recordId")
   @TableField("record_id")
   @Column(name = "record_id")
   private Long recordId;
   @ApiModelProperty(name = "field", value = "字段")
   @JsonProperty("field")
   @JSONField(name = "field")
   @TableField("field")
   @Column(name = "field")
   private String field;
   @ApiModelProperty(name = "description", value = "描述")
   @JsonProperty("description")
   @JSONField(name = "description")
   @TableField("description")
   @Column(name = "description")
   private String description;

   public static ContractProjectRecordDetail.ContractProjectRecordDetailBuilder builder() {
      return new ContractProjectRecordDetail.ContractProjectRecordDetailBuilder();
   }

   public ContractProjectRecordDetail() {
   }

   public ContractProjectRecordDetail(final Long id, final Long recordId, final String field, final String description) {
      this.id = id;
      this.recordId = recordId;
      this.field = field;
      this.description = description;
   }

   public Long getId() {
      return this.id;
   }

   public Long getRecordId() {
      return this.recordId;
   }

   public String getField() {
      return this.field;
   }

   public String getDescription() {
      return this.description;
   }

   @JsonProperty("id")
   public ContractProjectRecordDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("recordId")
   public ContractProjectRecordDetail setRecordId(final Long recordId) {
      this.recordId = recordId;
      return this;
   }

   @JsonProperty("field")
   public ContractProjectRecordDetail setField(final String field) {
      this.field = field;
      return this;
   }

   @JsonProperty("description")
   public ContractProjectRecordDetail setDescription(final String description) {
      this.description = description;
      return this;
   }

   @Override
   public String toString() {
      return "ContractProjectRecordDetail(id="
         + this.getId()
         + ", recordId="
         + this.getRecordId()
         + ", field="
         + this.getField()
         + ", description="
         + this.getDescription()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectRecordDetail)) {
         return false;
      }

      ContractProjectRecordDetail other = (ContractProjectRecordDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$recordId = this.getRecordId();
         Object other$recordId = other.getRecordId();
         if (this$recordId == null ? other$recordId == null : this$recordId.equals(other$recordId)) {
            Object this$field = this.getField();
            Object other$field = other.getField();
            if (this$field == null ? other$field == null : this$field.equals(other$field)) {
               Object this$description = this.getDescription();
               Object other$description = other.getDescription();
               return this$description == null ? other$description == null : this$description.equals(other$description);
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
      return other instanceof ContractProjectRecordDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $recordId = this.getRecordId();
      result = result * 59 + ($recordId == null ? 43 : $recordId.hashCode());
      Object $field = this.getField();
      result = result * 59 + ($field == null ? 43 : $field.hashCode());
      Object $description = this.getDescription();
      return result * 59 + ($description == null ? 43 : $description.hashCode());
   }

   public static class ContractProjectRecordDetailBuilder {
      private Long id;
      private Long recordId;
      private String field;
      private String description;

      ContractProjectRecordDetailBuilder() {
      }

      @JsonProperty("id")
      public ContractProjectRecordDetail.ContractProjectRecordDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("recordId")
      public ContractProjectRecordDetail.ContractProjectRecordDetailBuilder recordId(final Long recordId) {
         this.recordId = recordId;
         return this;
      }

      @JsonProperty("field")
      public ContractProjectRecordDetail.ContractProjectRecordDetailBuilder field(final String field) {
         this.field = field;
         return this;
      }

      @JsonProperty("description")
      public ContractProjectRecordDetail.ContractProjectRecordDetailBuilder description(final String description) {
         this.description = description;
         return this;
      }

      public ContractProjectRecordDetail build() {
         return new ContractProjectRecordDetail(this.id, this.recordId, this.field, this.description);
      }

      @Override
      public String toString() {
         return "ContractProjectRecordDetail.ContractProjectRecordDetailBuilder(id="
            + this.id
            + ", recordId="
            + this.recordId
            + ", field="
            + this.field
            + ", description="
            + this.description
            + ")";
      }
   }
}
