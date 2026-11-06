package com.hzchum.scim.system.core.api.pojo._do;

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

@Entity
@ApiModel(value = "SysEnclosureDictionary对象", description = "围护字典类型表")
@TableName("sys_enclosure_dictionary")
@Table(name = "sys_enclosure_dictionary")
public class SysEnclosureDictionary extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "label", notes = "字典详情名称")
   @JsonProperty("label")
   @JSONField(name = "label")
   @TableField("label")
   @Column(name = "label", columnDefinition = "varchar(255) comment '字典标签'", nullable = false)
   private String label;
   @ApiModelProperty(name = "name", notes = "字典类型名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) comment '字典名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "remark", notes = "字典类型描述")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255) comment '字典名称描述'", nullable = false)
   private String remark;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11) default 1 comment '排序'", nullable = false)
   private Integer sort;
   @ApiModelProperty(name = "type", notes = " 类型 2:压型彩板 4:夹芯板 8:桁架楼承板 16:压型楼承板")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) comment '围护类型: 2:压型彩板 4:夹芯板 8:桁架楼承板 16:压型楼承板'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "code", notes = " 编号:桁架楼承板特有  ")
   @JsonProperty("code")
   @JSONField(name = "code")
   @TableField("code")
   @Column(name = "code")
   private String code;
   @ApiModelProperty(name = "status", notes = " 状态 1启用 0禁用  ")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default 1 comment '1启用0禁用'", nullable = false)
   private Boolean status;

   public static SysEnclosureDictionary.SysEnclosureDictionaryBuilder builder() {
      return new SysEnclosureDictionary.SysEnclosureDictionaryBuilder();
   }

   public SysEnclosureDictionary() {
   }

   public SysEnclosureDictionary(
      final Long id,
      final String label,
      final String name,
      final String remark,
      final Integer sort,
      final Integer type,
      final String code,
      final Boolean status
   ) {
      this.id = id;
      this.label = label;
      this.name = name;
      this.remark = remark;
      this.sort = sort;
      this.type = type;
      this.code = code;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public String getLabel() {
      return this.label;
   }

   public String getName() {
      return this.name;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getType() {
      return this.type;
   }

   public String getCode() {
      return this.code;
   }

   public Boolean getStatus() {
      return this.status;
   }

   @JsonProperty("id")
   public SysEnclosureDictionary setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("label")
   public SysEnclosureDictionary setLabel(final String label) {
      this.label = label;
      return this;
   }

   @JsonProperty("name")
   public SysEnclosureDictionary setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("remark")
   public SysEnclosureDictionary setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("sort")
   public SysEnclosureDictionary setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("type")
   public SysEnclosureDictionary setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("code")
   public SysEnclosureDictionary setCode(final String code) {
      this.code = code;
      return this;
   }

   @JsonProperty("status")
   public SysEnclosureDictionary setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "SysEnclosureDictionary(id="
         + this.getId()
         + ", label="
         + this.getLabel()
         + ", name="
         + this.getName()
         + ", remark="
         + this.getRemark()
         + ", sort="
         + this.getSort()
         + ", type="
         + this.getType()
         + ", code="
         + this.getCode()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysEnclosureDictionary)) {
         return false;
      }

      SysEnclosureDictionary other = (SysEnclosureDictionary)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$label = this.getLabel();
                  Object other$label = other.getLabel();
                  if (this$label == null ? other$label == null : this$label.equals(other$label)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$remark = this.getRemark();
                        Object other$remark = other.getRemark();
                        if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                           Object this$code = this.getCode();
                           Object other$code = other.getCode();
                           return this$code == null ? other$code == null : this$code.equals(other$code);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysEnclosureDictionary;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $label = this.getLabel();
      result = result * 59 + ($label == null ? 43 : $label.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   public static class SysEnclosureDictionaryBuilder {
      private Long id;
      private String label;
      private String name;
      private String remark;
      private Integer sort;
      private Integer type;
      private String code;
      private Boolean status;

      SysEnclosureDictionaryBuilder() {
      }

      @JsonProperty("id")
      public SysEnclosureDictionary.SysEnclosureDictionaryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("label")
      public SysEnclosureDictionary.SysEnclosureDictionaryBuilder label(final String label) {
         this.label = label;
         return this;
      }

      @JsonProperty("name")
      public SysEnclosureDictionary.SysEnclosureDictionaryBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("remark")
      public SysEnclosureDictionary.SysEnclosureDictionaryBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("sort")
      public SysEnclosureDictionary.SysEnclosureDictionaryBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("type")
      public SysEnclosureDictionary.SysEnclosureDictionaryBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("code")
      public SysEnclosureDictionary.SysEnclosureDictionaryBuilder code(final String code) {
         this.code = code;
         return this;
      }

      @JsonProperty("status")
      public SysEnclosureDictionary.SysEnclosureDictionaryBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public SysEnclosureDictionary build() {
         return new SysEnclosureDictionary(this.id, this.label, this.name, this.remark, this.sort, this.type, this.code, this.status);
      }

      @Override
      public String toString() {
         return "SysEnclosureDictionary.SysEnclosureDictionaryBuilder(id="
            + this.id
            + ", label="
            + this.label
            + ", name="
            + this.name
            + ", remark="
            + this.remark
            + ", sort="
            + this.sort
            + ", type="
            + this.type
            + ", code="
            + this.code
            + ", status="
            + this.status
            + ")";
      }
   }
}
