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

@ApiModel(value = "ContractFieldConfig对象", description = "合同表字段配置")
@Entity
@TableName("contract_field_config")
@Table(name = "contract_field_config")
public class ContractFieldConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "fieldEnumType", value = "字段枚举值")
   @JsonProperty("fieldEnumType")
   @JSONField(name = "fieldEnumType")
   @TableField("field_enum_type")
   @Column(name = "field_enum_type ", columnDefinition = "int(11) comment '字段枚举值'")
   private Integer fieldEnumType;
   @ApiModelProperty(name = "fieldValue", value = "字段可选值")
   @JsonProperty("fieldValue")
   @JSONField(name = "fieldValue")
   @TableField("field_value")
   @Column(name = "field_value", columnDefinition = "varchar(255) comment '字段可选值'")
   private String fieldValue;
   @ApiModelProperty(name = "fieldSort", value = "字段排序")
   @JsonProperty("fieldSort")
   @JSONField(name = "fieldSort")
   @TableField("field_sort")
   @Column(name = "field_sort", columnDefinition = "int(11) comment '字段排序'")
   private Integer fieldSort;
   @ApiModelProperty(name = "parentId", value = "上级字段ID")
   @JsonProperty("parentId")
   @JSONField(name = "parentId")
   @TableField("parent_id")
   @Column(name = "parent_id", columnDefinition = "bigint(20) comment '上级字段ID'")
   private Long parentId;
   @ApiModelProperty(name = "fieldJson", value = "字段Json")
   @JsonProperty("fieldJson")
   @JSONField(name = "fieldJson")
   @TableField("field_json")
   @Column(name = "field_json", columnDefinition = "text comment '字段Json'")
   private String fieldJson;

   public static ContractFieldConfig.ContractFieldConfigBuilder builder() {
      return new ContractFieldConfig.ContractFieldConfigBuilder();
   }

   public ContractFieldConfig() {
   }

   public ContractFieldConfig(
      final Long id, final Integer fieldEnumType, final String fieldValue, final Integer fieldSort, final Long parentId, final String fieldJson
   ) {
      this.id = id;
      this.fieldEnumType = fieldEnumType;
      this.fieldValue = fieldValue;
      this.fieldSort = fieldSort;
      this.parentId = parentId;
      this.fieldJson = fieldJson;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getFieldEnumType() {
      return this.fieldEnumType;
   }

   public String getFieldValue() {
      return this.fieldValue;
   }

   public Integer getFieldSort() {
      return this.fieldSort;
   }

   public Long getParentId() {
      return this.parentId;
   }

   public String getFieldJson() {
      return this.fieldJson;
   }

   @JsonProperty("id")
   public ContractFieldConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("fieldEnumType")
   public ContractFieldConfig setFieldEnumType(final Integer fieldEnumType) {
      this.fieldEnumType = fieldEnumType;
      return this;
   }

   @JsonProperty("fieldValue")
   public ContractFieldConfig setFieldValue(final String fieldValue) {
      this.fieldValue = fieldValue;
      return this;
   }

   @JsonProperty("fieldSort")
   public ContractFieldConfig setFieldSort(final Integer fieldSort) {
      this.fieldSort = fieldSort;
      return this;
   }

   @JsonProperty("parentId")
   public ContractFieldConfig setParentId(final Long parentId) {
      this.parentId = parentId;
      return this;
   }

   @JsonProperty("fieldJson")
   public ContractFieldConfig setFieldJson(final String fieldJson) {
      this.fieldJson = fieldJson;
      return this;
   }

   @Override
   public String toString() {
      return "ContractFieldConfig(id="
         + this.getId()
         + ", fieldEnumType="
         + this.getFieldEnumType()
         + ", fieldValue="
         + this.getFieldValue()
         + ", fieldSort="
         + this.getFieldSort()
         + ", parentId="
         + this.getParentId()
         + ", fieldJson="
         + this.getFieldJson()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractFieldConfig)) {
         return false;
      }

      ContractFieldConfig other = (ContractFieldConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$fieldEnumType = this.getFieldEnumType();
         Object other$fieldEnumType = other.getFieldEnumType();
         if (this$fieldEnumType == null ? other$fieldEnumType == null : this$fieldEnumType.equals(other$fieldEnumType)) {
            Object this$fieldSort = this.getFieldSort();
            Object other$fieldSort = other.getFieldSort();
            if (this$fieldSort == null ? other$fieldSort == null : this$fieldSort.equals(other$fieldSort)) {
               Object this$parentId = this.getParentId();
               Object other$parentId = other.getParentId();
               if (this$parentId == null ? other$parentId == null : this$parentId.equals(other$parentId)) {
                  Object this$fieldValue = this.getFieldValue();
                  Object other$fieldValue = other.getFieldValue();
                  if (this$fieldValue == null ? other$fieldValue == null : this$fieldValue.equals(other$fieldValue)) {
                     Object this$fieldJson = this.getFieldJson();
                     Object other$fieldJson = other.getFieldJson();
                     return this$fieldJson == null ? other$fieldJson == null : this$fieldJson.equals(other$fieldJson);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractFieldConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $fieldEnumType = this.getFieldEnumType();
      result = result * 59 + ($fieldEnumType == null ? 43 : $fieldEnumType.hashCode());
      Object $fieldSort = this.getFieldSort();
      result = result * 59 + ($fieldSort == null ? 43 : $fieldSort.hashCode());
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $fieldValue = this.getFieldValue();
      result = result * 59 + ($fieldValue == null ? 43 : $fieldValue.hashCode());
      Object $fieldJson = this.getFieldJson();
      return result * 59 + ($fieldJson == null ? 43 : $fieldJson.hashCode());
   }

   public static class ContractFieldConfigBuilder {
      private Long id;
      private Integer fieldEnumType;
      private String fieldValue;
      private Integer fieldSort;
      private Long parentId;
      private String fieldJson;

      ContractFieldConfigBuilder() {
      }

      @JsonProperty("id")
      public ContractFieldConfig.ContractFieldConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("fieldEnumType")
      public ContractFieldConfig.ContractFieldConfigBuilder fieldEnumType(final Integer fieldEnumType) {
         this.fieldEnumType = fieldEnumType;
         return this;
      }

      @JsonProperty("fieldValue")
      public ContractFieldConfig.ContractFieldConfigBuilder fieldValue(final String fieldValue) {
         this.fieldValue = fieldValue;
         return this;
      }

      @JsonProperty("fieldSort")
      public ContractFieldConfig.ContractFieldConfigBuilder fieldSort(final Integer fieldSort) {
         this.fieldSort = fieldSort;
         return this;
      }

      @JsonProperty("parentId")
      public ContractFieldConfig.ContractFieldConfigBuilder parentId(final Long parentId) {
         this.parentId = parentId;
         return this;
      }

      @JsonProperty("fieldJson")
      public ContractFieldConfig.ContractFieldConfigBuilder fieldJson(final String fieldJson) {
         this.fieldJson = fieldJson;
         return this;
      }

      public ContractFieldConfig build() {
         return new ContractFieldConfig(this.id, this.fieldEnumType, this.fieldValue, this.fieldSort, this.parentId, this.fieldJson);
      }

      @Override
      public String toString() {
         return "ContractFieldConfig.ContractFieldConfigBuilder(id="
            + this.id
            + ", fieldEnumType="
            + this.fieldEnumType
            + ", fieldValue="
            + this.fieldValue
            + ", fieldSort="
            + this.fieldSort
            + ", parentId="
            + this.parentId
            + ", fieldJson="
            + this.fieldJson
            + ")";
      }
   }
}
