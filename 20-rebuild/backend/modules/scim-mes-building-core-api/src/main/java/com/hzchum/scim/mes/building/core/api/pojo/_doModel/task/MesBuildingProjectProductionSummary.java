package com.hzchum.scim.mes.building.core.api.pojo._doModel.task;

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

@ApiModel(value = "MesBuildingProjectProductionSummary对象", description = "")
@Entity
@TableName("mes_building_project_production_summary")
@Table(name = "mes_building_project_production_summary")
public class MesBuildingProjectProductionSummary extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "quantity", value = "生产数量", notes = "生产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '生产数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "assemblyRivetingWeldingQuantity", value = "组铆焊数量", notes = "组铆焊数量")
   @JsonProperty("assemblyRivetingWeldingQuantity")
   @JSONField(name = "assemblyRivetingWeldingQuantity")
   @TableField("assembly_riveting_welding_quantity")
   @Column(name = "assembly_riveting_welding_quantity", columnDefinition = "int(11) default '0' COMMENT '组铆焊数量'", nullable = false)
   private Integer assemblyRivetingWeldingQuantity;
   @ApiModelProperty(name = "painingQuantity", value = "涂装数量", notes = "涂装数量")
   @JsonProperty("painingQuantity")
   @JSONField(name = "painingQuantity")
   @TableField("paining_quantity")
   @Column(name = "paining_quantity", columnDefinition = "int(11) default '0' COMMENT '涂装数量'", nullable = false)
   private Integer painingQuantity;
   @ApiModelProperty(name = "mete", value = "生产重量", notes = "生产重量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '生产重量'", nullable = false)
   private BigDecimal mete;
   @ApiModelProperty(name = "assemblyRivetingWeldingMete", value = "组铆焊重量", notes = "组铆焊重量")
   @JsonProperty("assemblyRivetingWeldingMete")
   @JSONField(name = "assemblyRivetingWeldingMete")
   @TableField("assembly_riveting_welding_mete")
   @Column(name = "assembly_riveting_welding_mete", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '组铆焊重量'", nullable = false)
   private BigDecimal assemblyRivetingWeldingMete;
   @ApiModelProperty(name = "painingMete", value = "涂装重量", notes = "涂装重量")
   @JsonProperty("painingMete")
   @JSONField(name = "painingMete")
   @TableField("paining_mete")
   @Column(name = "paining_mete", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '涂装重量'", nullable = false)
   private BigDecimal painingMete;
   @ApiModelProperty(name = "month", value = "记录月份 格式yyyy-mm", notes = "记录月份 格式yyyy-mm")
   @JsonProperty("month")
   @JSONField(name = "month")
   @TableField("month")
   @Column(name = "month", columnDefinition = "varchar(64)  COMMENT '记录月份 格式yyyy-mm'", nullable = false)
   private String month;

   public static MesBuildingProjectProductionSummary.MesBuildingProjectProductionSummaryBuilder builder() {
      return new MesBuildingProjectProductionSummary.MesBuildingProjectProductionSummaryBuilder();
   }

   public MesBuildingProjectProductionSummary() {
   }

   public MesBuildingProjectProductionSummary(
      final Long id,
      final Long projectId,
      final Integer quantity,
      final Integer assemblyRivetingWeldingQuantity,
      final Integer painingQuantity,
      final BigDecimal mete,
      final BigDecimal assemblyRivetingWeldingMete,
      final BigDecimal painingMete,
      final String month
   ) {
      this.id = id;
      this.projectId = projectId;
      this.quantity = quantity;
      this.assemblyRivetingWeldingQuantity = assemblyRivetingWeldingQuantity;
      this.painingQuantity = painingQuantity;
      this.mete = mete;
      this.assemblyRivetingWeldingMete = assemblyRivetingWeldingMete;
      this.painingMete = painingMete;
      this.month = month;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getAssemblyRivetingWeldingQuantity() {
      return this.assemblyRivetingWeldingQuantity;
   }

   public Integer getPainingQuantity() {
      return this.painingQuantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getAssemblyRivetingWeldingMete() {
      return this.assemblyRivetingWeldingMete;
   }

   public BigDecimal getPainingMete() {
      return this.painingMete;
   }

   public String getMonth() {
      return this.month;
   }

   @JsonProperty("id")
   public MesBuildingProjectProductionSummary setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingProjectProductionSummary setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingProjectProductionSummary setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("assemblyRivetingWeldingQuantity")
   public MesBuildingProjectProductionSummary setAssemblyRivetingWeldingQuantity(final Integer assemblyRivetingWeldingQuantity) {
      this.assemblyRivetingWeldingQuantity = assemblyRivetingWeldingQuantity;
      return this;
   }

   @JsonProperty("painingQuantity")
   public MesBuildingProjectProductionSummary setPainingQuantity(final Integer painingQuantity) {
      this.painingQuantity = painingQuantity;
      return this;
   }

   @JsonProperty("mete")
   public MesBuildingProjectProductionSummary setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("assemblyRivetingWeldingMete")
   public MesBuildingProjectProductionSummary setAssemblyRivetingWeldingMete(final BigDecimal assemblyRivetingWeldingMete) {
      this.assemblyRivetingWeldingMete = assemblyRivetingWeldingMete;
      return this;
   }

   @JsonProperty("painingMete")
   public MesBuildingProjectProductionSummary setPainingMete(final BigDecimal painingMete) {
      this.painingMete = painingMete;
      return this;
   }

   @JsonProperty("month")
   public MesBuildingProjectProductionSummary setMonth(final String month) {
      this.month = month;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProjectProductionSummary(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", quantity="
         + this.getQuantity()
         + ", assemblyRivetingWeldingQuantity="
         + this.getAssemblyRivetingWeldingQuantity()
         + ", painingQuantity="
         + this.getPainingQuantity()
         + ", mete="
         + this.getMete()
         + ", assemblyRivetingWeldingMete="
         + this.getAssemblyRivetingWeldingMete()
         + ", painingMete="
         + this.getPainingMete()
         + ", month="
         + this.getMonth()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProjectProductionSummary)) {
         return false;
      }

      MesBuildingProjectProductionSummary other = (MesBuildingProjectProductionSummary)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$assemblyRivetingWeldingQuantity = this.getAssemblyRivetingWeldingQuantity();
               Object other$assemblyRivetingWeldingQuantity = other.getAssemblyRivetingWeldingQuantity();
               if (this$assemblyRivetingWeldingQuantity == null
                  ? other$assemblyRivetingWeldingQuantity == null
                  : this$assemblyRivetingWeldingQuantity.equals(other$assemblyRivetingWeldingQuantity)) {
                  Object this$painingQuantity = this.getPainingQuantity();
                  Object other$painingQuantity = other.getPainingQuantity();
                  if (this$painingQuantity == null ? other$painingQuantity == null : this$painingQuantity.equals(other$painingQuantity)) {
                     Object this$mete = this.getMete();
                     Object other$mete = other.getMete();
                     if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                        Object this$assemblyRivetingWeldingMete = this.getAssemblyRivetingWeldingMete();
                        Object other$assemblyRivetingWeldingMete = other.getAssemblyRivetingWeldingMete();
                        if (this$assemblyRivetingWeldingMete == null
                           ? other$assemblyRivetingWeldingMete == null
                           : this$assemblyRivetingWeldingMete.equals(other$assemblyRivetingWeldingMete)) {
                           Object this$painingMete = this.getPainingMete();
                           Object other$painingMete = other.getPainingMete();
                           if (this$painingMete == null ? other$painingMete == null : this$painingMete.equals(other$painingMete)) {
                              Object this$month = this.getMonth();
                              Object other$month = other.getMonth();
                              return this$month == null ? other$month == null : this$month.equals(other$month);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProjectProductionSummary;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $assemblyRivetingWeldingQuantity = this.getAssemblyRivetingWeldingQuantity();
      result = result * 59 + ($assemblyRivetingWeldingQuantity == null ? 43 : $assemblyRivetingWeldingQuantity.hashCode());
      Object $painingQuantity = this.getPainingQuantity();
      result = result * 59 + ($painingQuantity == null ? 43 : $painingQuantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $assemblyRivetingWeldingMete = this.getAssemblyRivetingWeldingMete();
      result = result * 59 + ($assemblyRivetingWeldingMete == null ? 43 : $assemblyRivetingWeldingMete.hashCode());
      Object $painingMete = this.getPainingMete();
      result = result * 59 + ($painingMete == null ? 43 : $painingMete.hashCode());
      Object $month = this.getMonth();
      return result * 59 + ($month == null ? 43 : $month.hashCode());
   }

   public static class MesBuildingProjectProductionSummaryBuilder {
      private Long id;
      private Long projectId;
      private Integer quantity;
      private Integer assemblyRivetingWeldingQuantity;
      private Integer painingQuantity;
      private BigDecimal mete;
      private BigDecimal assemblyRivetingWeldingMete;
      private BigDecimal painingMete;
      private String month;

      MesBuildingProjectProductionSummaryBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProjectProductionSummary.MesBuildingProjectProductionSummaryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingProjectProductionSummary.MesBuildingProjectProductionSummaryBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingProjectProductionSummary.MesBuildingProjectProductionSummaryBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("assemblyRivetingWeldingQuantity")
      public MesBuildingProjectProductionSummary.MesBuildingProjectProductionSummaryBuilder assemblyRivetingWeldingQuantity(
         final Integer assemblyRivetingWeldingQuantity
      ) {
         this.assemblyRivetingWeldingQuantity = assemblyRivetingWeldingQuantity;
         return this;
      }

      @JsonProperty("painingQuantity")
      public MesBuildingProjectProductionSummary.MesBuildingProjectProductionSummaryBuilder painingQuantity(final Integer painingQuantity) {
         this.painingQuantity = painingQuantity;
         return this;
      }

      @JsonProperty("mete")
      public MesBuildingProjectProductionSummary.MesBuildingProjectProductionSummaryBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("assemblyRivetingWeldingMete")
      public MesBuildingProjectProductionSummary.MesBuildingProjectProductionSummaryBuilder assemblyRivetingWeldingMete(
         final BigDecimal assemblyRivetingWeldingMete
      ) {
         this.assemblyRivetingWeldingMete = assemblyRivetingWeldingMete;
         return this;
      }

      @JsonProperty("painingMete")
      public MesBuildingProjectProductionSummary.MesBuildingProjectProductionSummaryBuilder painingMete(final BigDecimal painingMete) {
         this.painingMete = painingMete;
         return this;
      }

      @JsonProperty("month")
      public MesBuildingProjectProductionSummary.MesBuildingProjectProductionSummaryBuilder month(final String month) {
         this.month = month;
         return this;
      }

      public MesBuildingProjectProductionSummary build() {
         return new MesBuildingProjectProductionSummary(
            this.id,
            this.projectId,
            this.quantity,
            this.assemblyRivetingWeldingQuantity,
            this.painingQuantity,
            this.mete,
            this.assemblyRivetingWeldingMete,
            this.painingMete,
            this.month
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProjectProductionSummary.MesBuildingProjectProductionSummaryBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", quantity="
            + this.quantity
            + ", assemblyRivetingWeldingQuantity="
            + this.assemblyRivetingWeldingQuantity
            + ", painingQuantity="
            + this.painingQuantity
            + ", mete="
            + this.mete
            + ", assemblyRivetingWeldingMete="
            + this.assemblyRivetingWeldingMete
            + ", painingMete="
            + this.painingMete
            + ", month="
            + this.month
            + ")";
      }
   }
}
