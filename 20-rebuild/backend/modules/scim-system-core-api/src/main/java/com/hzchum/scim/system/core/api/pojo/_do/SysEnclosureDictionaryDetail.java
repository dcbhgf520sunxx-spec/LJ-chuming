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
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SysEnclosureDictionaryDetail对象", description = "围护字典详情表 ")
@Entity
@TableName("sys_enclosure_dictionary_detail")
@Table(name = "sys_enclosure_dictionary_detail")
public class SysEnclosureDictionaryDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "enclosureDictionaryId", value = "围护字典id")
   @JsonProperty("enclosureDictionaryId")
   @JSONField(name = "enclosureDictionaryId")
   @TableField("enclosure_dictionary_id")
   @Column(name = "enclosure_dictionary_id")
   private Long enclosureDictionaryId;
   @ApiModelProperty(name = "plateType", value = "版型")
   @JsonProperty("plateType")
   @JSONField(name = "plateType")
   @TableField("plate_type")
   @Column(name = "plate_type")
   private String plateType;
   @ApiModelProperty(name = "effectiveWidth", value = "有效宽度")
   @JsonProperty("effectiveWidth")
   @JSONField(name = "effectiveWidth")
   @TableField("effective_width")
   @Column(name = "effective_width")
   private BigDecimal effectiveWidth;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽")
   @JsonProperty("unfoldedWidth")
   @JSONField(name = "unfoldedWidth")
   @TableField("unfolded_width")
   @Column(name = "unfolded_width")
   private BigDecimal unfoldedWidth;

   public static SysEnclosureDictionaryDetail.SysEnclosureDictionaryDetailBuilder builder() {
      return new SysEnclosureDictionaryDetail.SysEnclosureDictionaryDetailBuilder();
   }

   public SysEnclosureDictionaryDetail() {
   }

   public SysEnclosureDictionaryDetail(
      final Long id, final Long enclosureDictionaryId, final String plateType, final BigDecimal effectiveWidth, final BigDecimal unfoldedWidth
   ) {
      this.id = id;
      this.enclosureDictionaryId = enclosureDictionaryId;
      this.plateType = plateType;
      this.effectiveWidth = effectiveWidth;
      this.unfoldedWidth = unfoldedWidth;
   }

   public Long getId() {
      return this.id;
   }

   public Long getEnclosureDictionaryId() {
      return this.enclosureDictionaryId;
   }

   public String getPlateType() {
      return this.plateType;
   }

   public BigDecimal getEffectiveWidth() {
      return this.effectiveWidth;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   @JsonProperty("id")
   public SysEnclosureDictionaryDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("enclosureDictionaryId")
   public SysEnclosureDictionaryDetail setEnclosureDictionaryId(final Long enclosureDictionaryId) {
      this.enclosureDictionaryId = enclosureDictionaryId;
      return this;
   }

   @JsonProperty("plateType")
   public SysEnclosureDictionaryDetail setPlateType(final String plateType) {
      this.plateType = plateType;
      return this;
   }

   @JsonProperty("effectiveWidth")
   public SysEnclosureDictionaryDetail setEffectiveWidth(final BigDecimal effectiveWidth) {
      this.effectiveWidth = effectiveWidth;
      return this;
   }

   @JsonProperty("unfoldedWidth")
   public SysEnclosureDictionaryDetail setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
      return this;
   }

   @Override
   public String toString() {
      return "SysEnclosureDictionaryDetail(id="
         + this.getId()
         + ", enclosureDictionaryId="
         + this.getEnclosureDictionaryId()
         + ", plateType="
         + this.getPlateType()
         + ", effectiveWidth="
         + this.getEffectiveWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysEnclosureDictionaryDetail)) {
         return false;
      }

      SysEnclosureDictionaryDetail other = (SysEnclosureDictionaryDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$enclosureDictionaryId = this.getEnclosureDictionaryId();
         Object other$enclosureDictionaryId = other.getEnclosureDictionaryId();
         if (this$enclosureDictionaryId == null ? other$enclosureDictionaryId == null : this$enclosureDictionaryId.equals(other$enclosureDictionaryId)) {
            Object this$plateType = this.getPlateType();
            Object other$plateType = other.getPlateType();
            if (this$plateType == null ? other$plateType == null : this$plateType.equals(other$plateType)) {
               Object this$effectiveWidth = this.getEffectiveWidth();
               Object other$effectiveWidth = other.getEffectiveWidth();
               if (this$effectiveWidth == null ? other$effectiveWidth == null : this$effectiveWidth.equals(other$effectiveWidth)) {
                  Object this$unfoldedWidth = this.getUnfoldedWidth();
                  Object other$unfoldedWidth = other.getUnfoldedWidth();
                  return this$unfoldedWidth == null ? other$unfoldedWidth == null : this$unfoldedWidth.equals(other$unfoldedWidth);
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
      return other instanceof SysEnclosureDictionaryDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $enclosureDictionaryId = this.getEnclosureDictionaryId();
      result = result * 59 + ($enclosureDictionaryId == null ? 43 : $enclosureDictionaryId.hashCode());
      Object $plateType = this.getPlateType();
      result = result * 59 + ($plateType == null ? 43 : $plateType.hashCode());
      Object $effectiveWidth = this.getEffectiveWidth();
      result = result * 59 + ($effectiveWidth == null ? 43 : $effectiveWidth.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      return result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
   }

   public static class SysEnclosureDictionaryDetailBuilder {
      private Long id;
      private Long enclosureDictionaryId;
      private String plateType;
      private BigDecimal effectiveWidth;
      private BigDecimal unfoldedWidth;

      SysEnclosureDictionaryDetailBuilder() {
      }

      @JsonProperty("id")
      public SysEnclosureDictionaryDetail.SysEnclosureDictionaryDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("enclosureDictionaryId")
      public SysEnclosureDictionaryDetail.SysEnclosureDictionaryDetailBuilder enclosureDictionaryId(final Long enclosureDictionaryId) {
         this.enclosureDictionaryId = enclosureDictionaryId;
         return this;
      }

      @JsonProperty("plateType")
      public SysEnclosureDictionaryDetail.SysEnclosureDictionaryDetailBuilder plateType(final String plateType) {
         this.plateType = plateType;
         return this;
      }

      @JsonProperty("effectiveWidth")
      public SysEnclosureDictionaryDetail.SysEnclosureDictionaryDetailBuilder effectiveWidth(final BigDecimal effectiveWidth) {
         this.effectiveWidth = effectiveWidth;
         return this;
      }

      @JsonProperty("unfoldedWidth")
      public SysEnclosureDictionaryDetail.SysEnclosureDictionaryDetailBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      public SysEnclosureDictionaryDetail build() {
         return new SysEnclosureDictionaryDetail(this.id, this.enclosureDictionaryId, this.plateType, this.effectiveWidth, this.unfoldedWidth);
      }

      @Override
      public String toString() {
         return "SysEnclosureDictionaryDetail.SysEnclosureDictionaryDetailBuilder(id="
            + this.id
            + ", enclosureDictionaryId="
            + this.enclosureDictionaryId
            + ", plateType="
            + this.plateType
            + ", effectiveWidth="
            + this.effectiveWidth
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ")";
      }
   }
}
