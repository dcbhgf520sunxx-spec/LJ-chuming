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
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SteelDensity对象", description = "钢材密度表")
@Entity
@TableName("wms_steel_density")
@Table(name = "wms_steel_density")
public class SteelDensity extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "basicClass", value = "基础类型", notes = "基础类型")
   @JsonProperty("basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "density", value = "密度", notes = "密度")
   @JsonProperty("density")
   @JSONField(name = "density")
   @TableField("density")
   @Column(name = "density", columnDefinition = "decimal(10,5)  COMMENT '密度'", nullable = true)
   private BigDecimal density;
   @ApiModelProperty(name = "createBy", value = "创建人", notes = "创建人")
   @JsonProperty("createBy")
   @JSONField(name = "createBy")
   @TableField("create_by")
   @Column(name = "create_by", columnDefinition = "bigint  COMMENT '创建人'", nullable = true)
   private Long createBy;
   @ApiModelProperty(name = "createName", value = "创建人名称", notes = "创建人名称")
   @JsonProperty("createName")
   @JSONField(name = "createName")
   @TableField("create_name")
   @Column(name = "create_name", columnDefinition = "varchar(255)  COMMENT '创建人名称'", nullable = true)
   private String createName;
   @ApiModelProperty(name = "updateBy", value = "编辑人", notes = "编辑人")
   @JsonProperty("updateBy")
   @JSONField(name = "updateBy")
   @TableField("update_by")
   @Column(name = "update_by", columnDefinition = "bigint  COMMENT '编辑人'", nullable = true)
   private Long updateBy;
   @ApiModelProperty(name = "updateName", value = "编辑人名称", notes = "编辑人名称")
   @JsonProperty("updateName")
   @JSONField(name = "updateName")
   @TableField("update_name")
   @Column(name = "update_name", columnDefinition = "varchar(255)  COMMENT '编辑人名称'", nullable = true)
   private String updateName;

   public static SteelDensity.SteelDensityBuilder builder() {
      return new SteelDensity.SteelDensityBuilder();
   }

   public SteelDensity() {
   }

   public SteelDensity(
      final Long id,
      final Integer basicClass,
      final Long classifyId,
      final BigDecimal density,
      final Long createBy,
      final String createName,
      final Long updateBy,
      final String updateName
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.density = density;
      this.createBy = createBy;
      this.createName = createName;
      this.updateBy = updateBy;
      this.updateName = updateName;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public BigDecimal getDensity() {
      return this.density;
   }

   public Long getCreateBy() {
      return this.createBy;
   }

   public String getCreateName() {
      return this.createName;
   }

   public Long getUpdateBy() {
      return this.updateBy;
   }

   public String getUpdateName() {
      return this.updateName;
   }

   @JsonProperty("id")
   public SteelDensity setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("basicClass")
   public SteelDensity setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public SteelDensity setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("density")
   public SteelDensity setDensity(final BigDecimal density) {
      this.density = density;
      return this;
   }

   @JsonProperty("createBy")
   public SteelDensity setCreateBy(final Long createBy) {
      this.createBy = createBy;
      return this;
   }

   @JsonProperty("createName")
   public SteelDensity setCreateName(final String createName) {
      this.createName = createName;
      return this;
   }

   @JsonProperty("updateBy")
   public SteelDensity setUpdateBy(final Long updateBy) {
      this.updateBy = updateBy;
      return this;
   }

   @JsonProperty("updateName")
   public SteelDensity setUpdateName(final String updateName) {
      this.updateName = updateName;
      return this;
   }

   @Override
   public String toString() {
      return "SteelDensity(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", density="
         + this.getDensity()
         + ", createBy="
         + this.getCreateBy()
         + ", createName="
         + this.getCreateName()
         + ", updateBy="
         + this.getUpdateBy()
         + ", updateName="
         + this.getUpdateName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelDensity)) {
         return false;
      }

      SteelDensity other = (SteelDensity)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$createBy = this.getCreateBy();
               Object other$createBy = other.getCreateBy();
               if (this$createBy == null ? other$createBy == null : this$createBy.equals(other$createBy)) {
                  Object this$updateBy = this.getUpdateBy();
                  Object other$updateBy = other.getUpdateBy();
                  if (this$updateBy == null ? other$updateBy == null : this$updateBy.equals(other$updateBy)) {
                     Object this$density = this.getDensity();
                     Object other$density = other.getDensity();
                     if (this$density == null ? other$density == null : this$density.equals(other$density)) {
                        Object this$createName = this.getCreateName();
                        Object other$createName = other.getCreateName();
                        if (this$createName == null ? other$createName == null : this$createName.equals(other$createName)) {
                           Object this$updateName = this.getUpdateName();
                           Object other$updateName = other.getUpdateName();
                           return this$updateName == null ? other$updateName == null : this$updateName.equals(other$updateName);
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
      return other instanceof SteelDensity;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $createBy = this.getCreateBy();
      result = result * 59 + ($createBy == null ? 43 : $createBy.hashCode());
      Object $updateBy = this.getUpdateBy();
      result = result * 59 + ($updateBy == null ? 43 : $updateBy.hashCode());
      Object $density = this.getDensity();
      result = result * 59 + ($density == null ? 43 : $density.hashCode());
      Object $createName = this.getCreateName();
      result = result * 59 + ($createName == null ? 43 : $createName.hashCode());
      Object $updateName = this.getUpdateName();
      return result * 59 + ($updateName == null ? 43 : $updateName.hashCode());
   }

   public static class SteelDensityBuilder {
      private Long id;
      private Integer basicClass;
      private Long classifyId;
      private BigDecimal density;
      private Long createBy;
      private String createName;
      private Long updateBy;
      private String updateName;

      SteelDensityBuilder() {
      }

      @JsonProperty("id")
      public SteelDensity.SteelDensityBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("basicClass")
      public SteelDensity.SteelDensityBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public SteelDensity.SteelDensityBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("density")
      public SteelDensity.SteelDensityBuilder density(final BigDecimal density) {
         this.density = density;
         return this;
      }

      @JsonProperty("createBy")
      public SteelDensity.SteelDensityBuilder createBy(final Long createBy) {
         this.createBy = createBy;
         return this;
      }

      @JsonProperty("createName")
      public SteelDensity.SteelDensityBuilder createName(final String createName) {
         this.createName = createName;
         return this;
      }

      @JsonProperty("updateBy")
      public SteelDensity.SteelDensityBuilder updateBy(final Long updateBy) {
         this.updateBy = updateBy;
         return this;
      }

      @JsonProperty("updateName")
      public SteelDensity.SteelDensityBuilder updateName(final String updateName) {
         this.updateName = updateName;
         return this;
      }

      public SteelDensity build() {
         return new SteelDensity(this.id, this.basicClass, this.classifyId, this.density, this.createBy, this.createName, this.updateBy, this.updateName);
      }

      @Override
      public String toString() {
         return "SteelDensity.SteelDensityBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", density="
            + this.density
            + ", createBy="
            + this.createBy
            + ", createName="
            + this.createName
            + ", updateBy="
            + this.updateBy
            + ", updateName="
            + this.updateName
            + ")";
      }
   }
}
