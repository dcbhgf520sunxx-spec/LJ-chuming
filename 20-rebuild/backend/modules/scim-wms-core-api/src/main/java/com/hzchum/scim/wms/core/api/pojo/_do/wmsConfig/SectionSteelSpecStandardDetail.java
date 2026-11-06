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

@ApiModel(value = "SectionSteelSpecStandardDetail对象", description = "型材规格国标重量 ")
@Entity
@TableName("wms_section_steel_spec_standard_detail")
@Table(name = "wms_section_steel_spec_standard_detail")
public class SectionSteelSpecStandardDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "sectionSteelId", value = "型材配置国标ID", notes = "型材配置国标ID")
   @JsonProperty("sectionSteelId")
   @JSONField(name = "sectionSteelId")
   @TableField("section_steel_id")
   @Column(name = "section_steel_id", columnDefinition = "bigint  COMMENT '型材配置国标ID'", nullable = true)
   private Long sectionSteelId;
   @ApiModelProperty(name = "standardId", value = "国标ID", notes = "国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "specId", value = "规格ID", notes = "规格ID")
   @JsonProperty("specId")
   @JSONField(name = "specId")
   @TableField("spec_id")
   @Column(name = "spec_id", columnDefinition = "bigint  COMMENT '规格ID'", nullable = true)
   private Long specId;
   @ApiModelProperty(name = "unitNet", value = "单位净重", notes = "单位净重")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,8)  COMMENT '单位净重'", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "code", value = "每个国标重量唯一表示", notes = "每个国标重量唯一表示")
   @JsonProperty("code")
   @JSONField(name = "code")
   @TableField("code")
   @Column(name = "code", columnDefinition = "int  COMMENT '每个国标重量唯一表示'", nullable = true)
   private Integer code;

   public static SectionSteelSpecStandardDetail.SectionSteelSpecStandardDetailBuilder builder() {
      return new SectionSteelSpecStandardDetail.SectionSteelSpecStandardDetailBuilder();
   }

   public SectionSteelSpecStandardDetail() {
   }

   public SectionSteelSpecStandardDetail(
      final Long id, final Long sectionSteelId, final Long standardId, final Long specId, final BigDecimal unitNet, final Integer code
   ) {
      this.id = id;
      this.sectionSteelId = sectionSteelId;
      this.standardId = standardId;
      this.specId = specId;
      this.unitNet = unitNet;
      this.code = code;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSectionSteelId() {
      return this.sectionSteelId;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public Long getSpecId() {
      return this.specId;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public Integer getCode() {
      return this.code;
   }

   @JsonProperty("id")
   public SectionSteelSpecStandardDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("sectionSteelId")
   public SectionSteelSpecStandardDetail setSectionSteelId(final Long sectionSteelId) {
      this.sectionSteelId = sectionSteelId;
      return this;
   }

   @JsonProperty("standardId")
   public SectionSteelSpecStandardDetail setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("specId")
   public SectionSteelSpecStandardDetail setSpecId(final Long specId) {
      this.specId = specId;
      return this;
   }

   @JsonProperty("unitNet")
   public SectionSteelSpecStandardDetail setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("code")
   public SectionSteelSpecStandardDetail setCode(final Integer code) {
      this.code = code;
      return this;
   }

   @Override
   public String toString() {
      return "SectionSteelSpecStandardDetail(id="
         + this.getId()
         + ", sectionSteelId="
         + this.getSectionSteelId()
         + ", standardId="
         + this.getStandardId()
         + ", specId="
         + this.getSpecId()
         + ", unitNet="
         + this.getUnitNet()
         + ", code="
         + this.getCode()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SectionSteelSpecStandardDetail)) {
         return false;
      }

      SectionSteelSpecStandardDetail other = (SectionSteelSpecStandardDetail)o;
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
            Object this$standardId = this.getStandardId();
            Object other$standardId = other.getStandardId();
            if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
               Object this$specId = this.getSpecId();
               Object other$specId = other.getSpecId();
               if (this$specId == null ? other$specId == null : this$specId.equals(other$specId)) {
                  Object this$code = this.getCode();
                  Object other$code = other.getCode();
                  if (this$code == null ? other$code == null : this$code.equals(other$code)) {
                     Object this$unitNet = this.getUnitNet();
                     Object other$unitNet = other.getUnitNet();
                     return this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet);
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
      return other instanceof SectionSteelSpecStandardDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sectionSteelId = this.getSectionSteelId();
      result = result * 59 + ($sectionSteelId == null ? 43 : $sectionSteelId.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $specId = this.getSpecId();
      result = result * 59 + ($specId == null ? 43 : $specId.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $unitNet = this.getUnitNet();
      return result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
   }

   public static class SectionSteelSpecStandardDetailBuilder {
      private Long id;
      private Long sectionSteelId;
      private Long standardId;
      private Long specId;
      private BigDecimal unitNet;
      private Integer code;

      SectionSteelSpecStandardDetailBuilder() {
      }

      @JsonProperty("id")
      public SectionSteelSpecStandardDetail.SectionSteelSpecStandardDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("sectionSteelId")
      public SectionSteelSpecStandardDetail.SectionSteelSpecStandardDetailBuilder sectionSteelId(final Long sectionSteelId) {
         this.sectionSteelId = sectionSteelId;
         return this;
      }

      @JsonProperty("standardId")
      public SectionSteelSpecStandardDetail.SectionSteelSpecStandardDetailBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("specId")
      public SectionSteelSpecStandardDetail.SectionSteelSpecStandardDetailBuilder specId(final Long specId) {
         this.specId = specId;
         return this;
      }

      @JsonProperty("unitNet")
      public SectionSteelSpecStandardDetail.SectionSteelSpecStandardDetailBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("code")
      public SectionSteelSpecStandardDetail.SectionSteelSpecStandardDetailBuilder code(final Integer code) {
         this.code = code;
         return this;
      }

      public SectionSteelSpecStandardDetail build() {
         return new SectionSteelSpecStandardDetail(this.id, this.sectionSteelId, this.standardId, this.specId, this.unitNet, this.code);
      }

      @Override
      public String toString() {
         return "SectionSteelSpecStandardDetail.SectionSteelSpecStandardDetailBuilder(id="
            + this.id
            + ", sectionSteelId="
            + this.sectionSteelId
            + ", standardId="
            + this.standardId
            + ", specId="
            + this.specId
            + ", unitNet="
            + this.unitNet
            + ", code="
            + this.code
            + ")";
      }
   }
}
