package com.hzchum.scim.mes.building.core.api.pojo._doModel.record;

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

@ApiModel(value = "MesBuildingProductProductionSummary对象", description = "生产报表 ")
@Entity
@TableName("mes_building_product_production_summary")
@Table(name = "mes_building_product_production_summary")
public class MesBuildingProductProductionSummary extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
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
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'")
   private Long monomerId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'")
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "beginQuantity", value = "期初数量 上月剩余数量=上月期初数量+任务数量-完成数量", notes = "期初数量 上月剩余数量=上月期初数量+任务数量-完成数量")
   @JsonProperty("beginQuantity")
   @JSONField(name = "beginQuantity")
   @TableField("begin_quantity")
   @Column(name = "begin_quantity", columnDefinition = "int(11) default '0' COMMENT '期初数量 上月剩余数量=上月期初数量+任务数量-完成数量'", nullable = false)
   private Integer beginQuantity;
   @ApiModelProperty(name = "inProductionQuantity", value = "全部进入生产数量", notes = "全部进入生产数量")
   @JsonProperty("inProductionQuantity")
   @JSONField(name = "inProductionQuantity")
   @TableField("in_production_quantity")
   @Column(name = "in_production_quantity", columnDefinition = "int(11) default '0' COMMENT '全部进入生产数量'", nullable = false)
   private Integer inProductionQuantity;
   @ApiModelProperty(name = "taskQuantity", value = "当月任务分配数量", notes = "当月任务分配数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   @TableField("task_quantity")
   @Column(name = "task_quantity", columnDefinition = "int(11) default '0' COMMENT '当月任务分配数量'", nullable = false)
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeQuantity", value = "当月完成数量", notes = "当月完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   @TableField("complete_quantity")
   @Column(name = "complete_quantity", columnDefinition = "int(11) default '0' COMMENT '当月完成数量'", nullable = false)
   private Integer completeQuantity;
   @ApiModelProperty(name = "month", value = "记录月份 格式yyyy-mm", notes = "记录月份 格式yyyy-mm")
   @JsonProperty("month")
   @JSONField(name = "month")
   @TableField("month")
   @Column(name = "month", columnDefinition = "varchar(64)  COMMENT '记录月份 格式yyyy-mm'", nullable = false)
   private String month;

   public static MesBuildingProductProductionSummary.MesBuildingProductProductionSummaryBuilder builder() {
      return new MesBuildingProductProductionSummary.MesBuildingProductProductionSummaryBuilder();
   }

   public MesBuildingProductProductionSummary() {
   }

   public MesBuildingProductProductionSummary(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long productId,
      final Integer productType,
      final Integer beginQuantity,
      final Integer inProductionQuantity,
      final Integer taskQuantity,
      final Integer completeQuantity,
      final String month
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.productId = productId;
      this.productType = productType;
      this.beginQuantity = beginQuantity;
      this.inProductionQuantity = inProductionQuantity;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.month = month;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getBeginQuantity() {
      return this.beginQuantity;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public String getMonth() {
      return this.month;
   }

   @JsonProperty("id")
   public MesBuildingProductProductionSummary setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingProductProductionSummary setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingProductProductionSummary setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingProductProductionSummary setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProductProductionSummary setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("beginQuantity")
   public MesBuildingProductProductionSummary setBeginQuantity(final Integer beginQuantity) {
      this.beginQuantity = beginQuantity;
      return this;
   }

   @JsonProperty("inProductionQuantity")
   public MesBuildingProductProductionSummary setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingProductProductionSummary setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesBuildingProductProductionSummary setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("month")
   public MesBuildingProductProductionSummary setMonth(final String month) {
      this.month = month;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductProductionSummary(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", beginQuantity="
         + this.getBeginQuantity()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", month="
         + this.getMonth()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductProductionSummary)) {
         return false;
      }

      MesBuildingProductProductionSummary other = (MesBuildingProductProductionSummary)o;
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
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$beginQuantity = this.getBeginQuantity();
                     Object other$beginQuantity = other.getBeginQuantity();
                     if (this$beginQuantity == null ? other$beginQuantity == null : this$beginQuantity.equals(other$beginQuantity)) {
                        Object this$inProductionQuantity = this.getInProductionQuantity();
                        Object other$inProductionQuantity = other.getInProductionQuantity();
                        if (this$inProductionQuantity == null
                           ? other$inProductionQuantity == null
                           : this$inProductionQuantity.equals(other$inProductionQuantity)) {
                           Object this$taskQuantity = this.getTaskQuantity();
                           Object other$taskQuantity = other.getTaskQuantity();
                           if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                              Object this$completeQuantity = this.getCompleteQuantity();
                              Object other$completeQuantity = other.getCompleteQuantity();
                              if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProductProductionSummary;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $beginQuantity = this.getBeginQuantity();
      result = result * 59 + ($beginQuantity == null ? 43 : $beginQuantity.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $month = this.getMonth();
      return result * 59 + ($month == null ? 43 : $month.hashCode());
   }

   public static class MesBuildingProductProductionSummaryBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long productId;
      private Integer productType;
      private Integer beginQuantity;
      private Integer inProductionQuantity;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private String month;

      MesBuildingProductProductionSummaryBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductProductionSummary.MesBuildingProductProductionSummaryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingProductProductionSummary.MesBuildingProductProductionSummaryBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingProductProductionSummary.MesBuildingProductProductionSummaryBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingProductProductionSummary.MesBuildingProductProductionSummaryBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProductProductionSummary.MesBuildingProductProductionSummaryBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("beginQuantity")
      public MesBuildingProductProductionSummary.MesBuildingProductProductionSummaryBuilder beginQuantity(final Integer beginQuantity) {
         this.beginQuantity = beginQuantity;
         return this;
      }

      @JsonProperty("inProductionQuantity")
      public MesBuildingProductProductionSummary.MesBuildingProductProductionSummaryBuilder inProductionQuantity(final Integer inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingProductProductionSummary.MesBuildingProductProductionSummaryBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesBuildingProductProductionSummary.MesBuildingProductProductionSummaryBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("month")
      public MesBuildingProductProductionSummary.MesBuildingProductProductionSummaryBuilder month(final String month) {
         this.month = month;
         return this;
      }

      public MesBuildingProductProductionSummary build() {
         return new MesBuildingProductProductionSummary(
            this.id,
            this.projectId,
            this.monomerId,
            this.productId,
            this.productType,
            this.beginQuantity,
            this.inProductionQuantity,
            this.taskQuantity,
            this.completeQuantity,
            this.month
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductProductionSummary.MesBuildingProductProductionSummaryBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", beginQuantity="
            + this.beginQuantity
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", month="
            + this.month
            + ")";
      }
   }
}
