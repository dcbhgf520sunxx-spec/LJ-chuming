package com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@ApiModel(value = "MesProductionReportingApprovalPassedProduceTeamReport对象", description = "报工审核通过与班组生产上报记录关联表")
@Entity
@TableName("mes_production_reporting_approval_passed_produce_team_report")
@Table(
   name = "mes_production_reporting_approval_passed_produce_team_report",
   indexes = {
         @Index(name = "index_production_reporting_approval_passed_id", columnList = "production_reporting_approval_passed_id"),
         @Index(name = "index_produce_team_report_id", columnList = "produce_team_report_id")
   },
   uniqueConstraints = @UniqueConstraint(columnNames = {"production_reporting_approval_passed_id", "produce_team_report_id"})
)
@org.hibernate.annotations.Table(appliesTo = "mes_production_reporting_approval_passed_produce_team_report", comment = "报工审核通过与班组生产上报记录关联表")
public class MesProductionReportingApprovalPassedProduceTeamReport extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("报工审核通过id")
   @TableField("production_reporting_approval_passed_id")
   @Column(name = "production_reporting_approval_passed_id", columnDefinition = "bigint(20) COMMENT '报工审核通过id'", nullable = false)
   private Long productionReportingApprovalPassedId;
   @ApiModelProperty("班组生产上报记录id")
   @TableField("produce_team_report_id")
   @Column(name = "produce_team_report_id", columnDefinition = "bigint(20) COMMENT '班组生产上报记录id'", unique = true, nullable = false)
   private Long produceTeamReportId;
   @ApiModelProperty("产品类型")
   @TableField("product_type_enum")
   @Column(name = "product_type_enum", columnDefinition = "bigint(20) COMMENT '产品类型'", nullable = false)
   private Integer productTypeEnum;

   public static MesProductionReportingApprovalPassedProduceTeamReport.MesProductionReportingApprovalPassedProduceTeamReportBuilder builder() {
      return new MesProductionReportingApprovalPassedProduceTeamReport.MesProductionReportingApprovalPassedProduceTeamReportBuilder();
   }

   public MesProductionReportingApprovalPassedProduceTeamReport() {
   }

   public MesProductionReportingApprovalPassedProduceTeamReport(
      final Long id, final Long productionReportingApprovalPassedId, final Long produceTeamReportId, final Integer productTypeEnum
   ) {
      this.id = id;
      this.productionReportingApprovalPassedId = productionReportingApprovalPassedId;
      this.produceTeamReportId = produceTeamReportId;
      this.productTypeEnum = productTypeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductionReportingApprovalPassedId() {
      return this.productionReportingApprovalPassedId;
   }

   public Long getProduceTeamReportId() {
      return this.produceTeamReportId;
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public MesProductionReportingApprovalPassedProduceTeamReport setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesProductionReportingApprovalPassedProduceTeamReport setProductionReportingApprovalPassedId(final Long productionReportingApprovalPassedId) {
      this.productionReportingApprovalPassedId = productionReportingApprovalPassedId;
      return this;
   }

   public MesProductionReportingApprovalPassedProduceTeamReport setProduceTeamReportId(final Long produceTeamReportId) {
      this.produceTeamReportId = produceTeamReportId;
      return this;
   }

   public MesProductionReportingApprovalPassedProduceTeamReport setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesProductionReportingApprovalPassedProduceTeamReport(id="
         + this.getId()
         + ", productionReportingApprovalPassedId="
         + this.getProductionReportingApprovalPassedId()
         + ", produceTeamReportId="
         + this.getProduceTeamReportId()
         + ", productTypeEnum="
         + this.getProductTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionReportingApprovalPassedProduceTeamReport)) {
         return false;
      }

      MesProductionReportingApprovalPassedProduceTeamReport other = (MesProductionReportingApprovalPassedProduceTeamReport)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productionReportingApprovalPassedId = this.getProductionReportingApprovalPassedId();
         Object other$productionReportingApprovalPassedId = other.getProductionReportingApprovalPassedId();
         if (this$productionReportingApprovalPassedId == null
            ? other$productionReportingApprovalPassedId == null
            : this$productionReportingApprovalPassedId.equals(other$productionReportingApprovalPassedId)) {
            Object this$produceTeamReportId = this.getProduceTeamReportId();
            Object other$produceTeamReportId = other.getProduceTeamReportId();
            if (this$produceTeamReportId == null ? other$produceTeamReportId == null : this$produceTeamReportId.equals(other$produceTeamReportId)) {
               Object this$productTypeEnum = this.getProductTypeEnum();
               Object other$productTypeEnum = other.getProductTypeEnum();
               return this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum);
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
      return other instanceof MesProductionReportingApprovalPassedProduceTeamReport;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productionReportingApprovalPassedId = this.getProductionReportingApprovalPassedId();
      result = result * 59 + ($productionReportingApprovalPassedId == null ? 43 : $productionReportingApprovalPassedId.hashCode());
      Object $produceTeamReportId = this.getProduceTeamReportId();
      result = result * 59 + ($produceTeamReportId == null ? 43 : $produceTeamReportId.hashCode());
      Object $productTypeEnum = this.getProductTypeEnum();
      return result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
   }

   public static class MesProductionReportingApprovalPassedProduceTeamReportBuilder {
      private Long id;
      private Long productionReportingApprovalPassedId;
      private Long produceTeamReportId;
      private Integer productTypeEnum;

      MesProductionReportingApprovalPassedProduceTeamReportBuilder() {
      }

      public MesProductionReportingApprovalPassedProduceTeamReport.MesProductionReportingApprovalPassedProduceTeamReportBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesProductionReportingApprovalPassedProduceTeamReport.MesProductionReportingApprovalPassedProduceTeamReportBuilder productionReportingApprovalPassedId(
         final Long productionReportingApprovalPassedId
      ) {
         this.productionReportingApprovalPassedId = productionReportingApprovalPassedId;
         return this;
      }

      public MesProductionReportingApprovalPassedProduceTeamReport.MesProductionReportingApprovalPassedProduceTeamReportBuilder produceTeamReportId(
         final Long produceTeamReportId
      ) {
         this.produceTeamReportId = produceTeamReportId;
         return this;
      }

      public MesProductionReportingApprovalPassedProduceTeamReport.MesProductionReportingApprovalPassedProduceTeamReportBuilder productTypeEnum(
         final Integer productTypeEnum
      ) {
         this.productTypeEnum = productTypeEnum;
         return this;
      }

      public MesProductionReportingApprovalPassedProduceTeamReport build() {
         return new MesProductionReportingApprovalPassedProduceTeamReport(
            this.id, this.productionReportingApprovalPassedId, this.produceTeamReportId, this.productTypeEnum
         );
      }

      @Override
      public String toString() {
         return "MesProductionReportingApprovalPassedProduceTeamReport.MesProductionReportingApprovalPassedProduceTeamReportBuilder(id="
            + this.id
            + ", productionReportingApprovalPassedId="
            + this.productionReportingApprovalPassedId
            + ", produceTeamReportId="
            + this.produceTeamReportId
            + ", productTypeEnum="
            + this.productTypeEnum
            + ")";
      }
   }
}
