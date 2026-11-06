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

@ApiModel(value = "SectionSteelSpec对象", description = "型材规格表 ")
@Entity
@TableName("wms_section_steel_spec")
@Table(name = "wms_section_steel_spec")
public class SectionSteelSpec extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "sectionSteelId", value = "型材库ID", notes = "型材库ID")
   @JsonProperty("sectionSteelId")
   @JSONField(name = "sectionSteelId")
   @TableField("section_steel_id")
   @Column(name = "section_steel_id", columnDefinition = "bigint  COMMENT '型材库ID'", nullable = true)
   private Long sectionSteelId;
   @ApiModelProperty(name = "classificationId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classificationId")
   @JSONField(name = "classificationId")
   @TableField("classification_id")
   @Column(name = "classification_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classificationId;
   @ApiModelProperty(name = "specification", value = "规格 型材规格", notes = "规格 型材规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(128)  COMMENT '规格 型材规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "status", value = "状态 0禁用 1启用", notes = "状态 0禁用 1启用")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '1' COMMENT '状态 0禁用 1启用'", nullable = true)
   private Boolean status;

   public static SectionSteelSpec.SectionSteelSpecBuilder builder() {
      return new SectionSteelSpec.SectionSteelSpecBuilder();
   }

   public SectionSteelSpec() {
   }

   public SectionSteelSpec(final Long id, final Long sectionSteelId, final Long classificationId, final String specification, final Boolean status) {
      this.id = id;
      this.sectionSteelId = sectionSteelId;
      this.classificationId = classificationId;
      this.specification = specification;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSectionSteelId() {
      return this.sectionSteelId;
   }

   public Long getClassificationId() {
      return this.classificationId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Boolean getStatus() {
      return this.status;
   }

   @JsonProperty("id")
   public SectionSteelSpec setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("sectionSteelId")
   public SectionSteelSpec setSectionSteelId(final Long sectionSteelId) {
      this.sectionSteelId = sectionSteelId;
      return this;
   }

   @JsonProperty("classificationId")
   public SectionSteelSpec setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
      return this;
   }

   @JsonProperty("specification")
   public SectionSteelSpec setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("status")
   public SectionSteelSpec setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "SectionSteelSpec(id="
         + this.getId()
         + ", sectionSteelId="
         + this.getSectionSteelId()
         + ", classificationId="
         + this.getClassificationId()
         + ", specification="
         + this.getSpecification()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SectionSteelSpec)) {
         return false;
      }

      SectionSteelSpec other = (SectionSteelSpec)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sectionSteelId = this.getSectionSteelId();
         Object other$sectionSteelId = other.getSectionSteelId();
         if (this$sectionSteelId == null ? other$sectionSteelId == null : this$sectionSteelId.equals(other$sectionSteelId)) {
            Object this$classificationId = this.getClassificationId();
            Object other$classificationId = other.getClassificationId();
            if (this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  return this$specification == null ? other$specification == null : this$specification.equals(other$specification);
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
      return other instanceof SectionSteelSpec;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sectionSteelId = this.getSectionSteelId();
      result = result * 59 + ($sectionSteelId == null ? 43 : $sectionSteelId.hashCode());
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $specification = this.getSpecification();
      return result * 59 + ($specification == null ? 43 : $specification.hashCode());
   }

   public static class SectionSteelSpecBuilder {
      private Long id;
      private Long sectionSteelId;
      private Long classificationId;
      private String specification;
      private Boolean status;

      SectionSteelSpecBuilder() {
      }

      @JsonProperty("id")
      public SectionSteelSpec.SectionSteelSpecBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("sectionSteelId")
      public SectionSteelSpec.SectionSteelSpecBuilder sectionSteelId(final Long sectionSteelId) {
         this.sectionSteelId = sectionSteelId;
         return this;
      }

      @JsonProperty("classificationId")
      public SectionSteelSpec.SectionSteelSpecBuilder classificationId(final Long classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      @JsonProperty("specification")
      public SectionSteelSpec.SectionSteelSpecBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("status")
      public SectionSteelSpec.SectionSteelSpecBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public SectionSteelSpec build() {
         return new SectionSteelSpec(this.id, this.sectionSteelId, this.classificationId, this.specification, this.status);
      }

      @Override
      public String toString() {
         return "SectionSteelSpec.SectionSteelSpecBuilder(id="
            + this.id
            + ", sectionSteelId="
            + this.sectionSteelId
            + ", classificationId="
            + this.classificationId
            + ", specification="
            + this.specification
            + ", status="
            + this.status
            + ")";
      }
   }
}
