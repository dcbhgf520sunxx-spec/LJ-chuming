package com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica;

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

@ApiModel(value = "MesBuildingAssembleRiveWeldLink对象", description = "部件组铆焊关联表")
@Entity
@TableName("mes_building_assemble_rive_weld_link")
@Table(name = "mes_building_assemble_rive_weld_link")
public class MesBuildingAssembleRiveWeldLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "sysAssembleId", value = "部件类型id")
   @JsonProperty("sysAssembleId")
   @JSONField(name = "sysAssembleId")
   @TableField("sys_assemble_id")
   @Column(name = "sys_assemble_id", columnDefinition = "bigint(20)  COMMENT '部件类型id'", nullable = false)
   private Long sysAssembleId;
   @ApiModelProperty(name = "minNumerical", value = "数值范围(最小)")
   @JsonProperty("minNumerical")
   @JSONField(name = "min_numerical")
   @TableField("min_numerical")
   @Column(name = "min_numerical", columnDefinition = "decimal(32,8)  COMMENT '数值范围(最小)'", nullable = false)
   private BigDecimal minNumerical;
   @ApiModelProperty(name = "maxNumerical", value = "数值范围(最大)")
   @JsonProperty("maxNumerical")
   @JSONField(name = "max_numerical")
   @TableField("max_numerical")
   @Column(name = "max_numerical", columnDefinition = "decimal(32,8)  COMMENT '数值范围(最大)'", nullable = false)
   private BigDecimal maxNumerical;

   public static MesBuildingAssembleRiveWeldLink.MesBuildingAssembleRiveWeldLinkBuilder builder() {
      return new MesBuildingAssembleRiveWeldLink.MesBuildingAssembleRiveWeldLinkBuilder();
   }

   public MesBuildingAssembleRiveWeldLink() {
   }

   public MesBuildingAssembleRiveWeldLink(final Long id, final Long sysAssembleId, final BigDecimal minNumerical, final BigDecimal maxNumerical) {
      this.id = id;
      this.sysAssembleId = sysAssembleId;
      this.minNumerical = minNumerical;
      this.maxNumerical = maxNumerical;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSysAssembleId() {
      return this.sysAssembleId;
   }

   public BigDecimal getMinNumerical() {
      return this.minNumerical;
   }

   public BigDecimal getMaxNumerical() {
      return this.maxNumerical;
   }

   @JsonProperty("id")
   public MesBuildingAssembleRiveWeldLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("sysAssembleId")
   public MesBuildingAssembleRiveWeldLink setSysAssembleId(final Long sysAssembleId) {
      this.sysAssembleId = sysAssembleId;
      return this;
   }

   @JsonProperty("minNumerical")
   public MesBuildingAssembleRiveWeldLink setMinNumerical(final BigDecimal minNumerical) {
      this.minNumerical = minNumerical;
      return this;
   }

   @JsonProperty("maxNumerical")
   public MesBuildingAssembleRiveWeldLink setMaxNumerical(final BigDecimal maxNumerical) {
      this.maxNumerical = maxNumerical;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleRiveWeldLink(id="
         + this.getId()
         + ", sysAssembleId="
         + this.getSysAssembleId()
         + ", minNumerical="
         + this.getMinNumerical()
         + ", maxNumerical="
         + this.getMaxNumerical()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssembleRiveWeldLink)) {
         return false;
      }

      MesBuildingAssembleRiveWeldLink other = (MesBuildingAssembleRiveWeldLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sysAssembleId = this.getSysAssembleId();
         Object other$sysAssembleId = other.getSysAssembleId();
         if (this$sysAssembleId == null ? other$sysAssembleId == null : this$sysAssembleId.equals(other$sysAssembleId)) {
            Object this$minNumerical = this.getMinNumerical();
            Object other$minNumerical = other.getMinNumerical();
            if (this$minNumerical == null ? other$minNumerical == null : this$minNumerical.equals(other$minNumerical)) {
               Object this$maxNumerical = this.getMaxNumerical();
               Object other$maxNumerical = other.getMaxNumerical();
               return this$maxNumerical == null ? other$maxNumerical == null : this$maxNumerical.equals(other$maxNumerical);
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
      return other instanceof MesBuildingAssembleRiveWeldLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sysAssembleId = this.getSysAssembleId();
      result = result * 59 + ($sysAssembleId == null ? 43 : $sysAssembleId.hashCode());
      Object $minNumerical = this.getMinNumerical();
      result = result * 59 + ($minNumerical == null ? 43 : $minNumerical.hashCode());
      Object $maxNumerical = this.getMaxNumerical();
      return result * 59 + ($maxNumerical == null ? 43 : $maxNumerical.hashCode());
   }

   public static class MesBuildingAssembleRiveWeldLinkBuilder {
      private Long id;
      private Long sysAssembleId;
      private BigDecimal minNumerical;
      private BigDecimal maxNumerical;

      MesBuildingAssembleRiveWeldLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingAssembleRiveWeldLink.MesBuildingAssembleRiveWeldLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("sysAssembleId")
      public MesBuildingAssembleRiveWeldLink.MesBuildingAssembleRiveWeldLinkBuilder sysAssembleId(final Long sysAssembleId) {
         this.sysAssembleId = sysAssembleId;
         return this;
      }

      @JsonProperty("minNumerical")
      public MesBuildingAssembleRiveWeldLink.MesBuildingAssembleRiveWeldLinkBuilder minNumerical(final BigDecimal minNumerical) {
         this.minNumerical = minNumerical;
         return this;
      }

      @JsonProperty("maxNumerical")
      public MesBuildingAssembleRiveWeldLink.MesBuildingAssembleRiveWeldLinkBuilder maxNumerical(final BigDecimal maxNumerical) {
         this.maxNumerical = maxNumerical;
         return this;
      }

      public MesBuildingAssembleRiveWeldLink build() {
         return new MesBuildingAssembleRiveWeldLink(this.id, this.sysAssembleId, this.minNumerical, this.maxNumerical);
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleRiveWeldLink.MesBuildingAssembleRiveWeldLinkBuilder(id="
            + this.id
            + ", sysAssembleId="
            + this.sysAssembleId
            + ", minNumerical="
            + this.minNumerical
            + ", maxNumerical="
            + this.maxNumerical
            + ")";
      }
   }
}
