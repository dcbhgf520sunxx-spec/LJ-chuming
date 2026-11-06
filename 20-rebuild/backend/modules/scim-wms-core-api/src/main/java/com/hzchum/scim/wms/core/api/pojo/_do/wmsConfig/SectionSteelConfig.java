package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

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

@ApiModel(value = "sectionSteelConfig对象", description = "型材配置")
@Entity
@TableName("wms_section_steel_config")
@Table(name = "wms_section_steel_config")
@org.hibernate.annotations.Table(appliesTo = "wms_section_steel_config", comment = "型材配置")
public class SectionSteelConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "classificationId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classificationId")
   @JSONField(name = "classificationId")
   @TableField("classification_id")
   @Column(name = "classification_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = false)
   private Long classificationId;
   @ApiModelProperty(name = "standardId", value = "国标ID", notes = "国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "国标名称", notes = "国标名称")
   @JsonProperty("standardName")
   @JSONField(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(255)  COMMENT '国标名称'", nullable = true)
   private String standardName;

   public static SectionSteelConfig.SectionSteelConfigBuilder builder() {
      return new SectionSteelConfig.SectionSteelConfigBuilder();
   }

   public SectionSteelConfig() {
   }

   public SectionSteelConfig(final Long id, final Long classificationId, final Long standardId, final String standardName) {
      this.id = id;
      this.classificationId = classificationId;
      this.standardId = standardId;
      this.standardName = standardName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassificationId() {
      return this.classificationId;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   @JsonProperty("id")
   public SectionSteelConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("classificationId")
   public SectionSteelConfig setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
      return this;
   }

   @JsonProperty("standardId")
   public SectionSteelConfig setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public SectionSteelConfig setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @Override
   public String toString() {
      return "SectionSteelConfig(id="
         + this.getId()
         + ", classificationId="
         + this.getClassificationId()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SectionSteelConfig)) {
         return false;
      }

      SectionSteelConfig other = (SectionSteelConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classificationId = this.getClassificationId();
         Object other$classificationId = other.getClassificationId();
         if (this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId)) {
            Object this$standardId = this.getStandardId();
            Object other$standardId = other.getStandardId();
            if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
               Object this$standardName = this.getStandardName();
               Object other$standardName = other.getStandardName();
               return this$standardName == null ? other$standardName == null : this$standardName.equals(other$standardName);
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
      return other instanceof SectionSteelConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $standardName = this.getStandardName();
      return result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
   }

   public static class SectionSteelConfigBuilder {
      private Long id;
      private Long classificationId;
      private Long standardId;
      private String standardName;

      SectionSteelConfigBuilder() {
      }

      @JsonProperty("id")
      public SectionSteelConfig.SectionSteelConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("classificationId")
      public SectionSteelConfig.SectionSteelConfigBuilder classificationId(final Long classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      @JsonProperty("standardId")
      public SectionSteelConfig.SectionSteelConfigBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public SectionSteelConfig.SectionSteelConfigBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      public SectionSteelConfig build() {
         return new SectionSteelConfig(this.id, this.classificationId, this.standardId, this.standardName);
      }

      @Override
      public String toString() {
         return "SectionSteelConfig.SectionSteelConfigBuilder(id="
            + this.id
            + ", classificationId="
            + this.classificationId
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ")";
      }
   }
}
