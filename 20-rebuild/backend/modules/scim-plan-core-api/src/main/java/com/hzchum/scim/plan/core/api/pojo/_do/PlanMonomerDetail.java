package com.hzchum.scim.plan.core.api.pojo._do;

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
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "PlanMonomerDetail对象", description = "单体详情表 ")
@Entity
@TableName("plan_monomer_detail")
@Table(name = "plan_monomer_detail")
public class PlanMonomerDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) comment '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) comment '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "type", value = "类型  1结构件 128箱体件")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) comment '类型  1结构件 128箱体件'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "productCategory", notes = "产品分类(大类)  2结构件 16箱体件")
   @TableField("product_category")
   @Column(name = "product_category", columnDefinition = "int(11) comment '产品分类(大类) 2结构件 16箱体件'", nullable = false)
   private Integer productCategory;
   @ApiModelProperty(name = "date", value = "计划完成日期")
   @TableField("date")
   @Column(name = "date", columnDefinition = "date comment '计划完成日期'", nullable = false)
   private LocalDate date;
   @ApiModelProperty(name = "completeDate", value = "实际完成日期")
   @TableField("complete_date")
   @Column(name = "complete_date", columnDefinition = "date DEFAULT NULL COMMENT '实际完成日期'")
   private LocalDate completeDate;
   @ApiModelProperty(name = "mete", value = "量(重量或长度)")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8) default 0.0 comment '量(重量或长度)'", nullable = false)
   private BigDecimal mete;
   @ApiModelProperty(name = "remark", value = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255) comment '备注'")
   private String remark;

   public static PlanMonomerDetail.PlanMonomerDetailBuilder builder() {
      return new PlanMonomerDetail.PlanMonomerDetailBuilder();
   }

   public PlanMonomerDetail() {
   }

   public PlanMonomerDetail(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Integer type,
      final Integer productCategory,
      final LocalDate date,
      final LocalDate completeDate,
      final BigDecimal mete,
      final String remark
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.type = type;
      this.productCategory = productCategory;
      this.date = date;
      this.completeDate = completeDate;
      this.mete = mete;
      this.remark = remark;
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

   public Integer getType() {
      return this.type;
   }

   public Integer getProductCategory() {
      return this.productCategory;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public LocalDate getCompleteDate() {
      return this.completeDate;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public PlanMonomerDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public PlanMonomerDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public PlanMonomerDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public PlanMonomerDetail setType(final Integer type) {
      this.type = type;
      return this;
   }

   public PlanMonomerDetail setProductCategory(final Integer productCategory) {
      this.productCategory = productCategory;
      return this;
   }

   public PlanMonomerDetail setDate(final LocalDate date) {
      this.date = date;
      return this;
   }

   public PlanMonomerDetail setCompleteDate(final LocalDate completeDate) {
      this.completeDate = completeDate;
      return this;
   }

   public PlanMonomerDetail setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   public PlanMonomerDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "PlanMonomerDetail(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", type="
         + this.getType()
         + ", productCategory="
         + this.getProductCategory()
         + ", date="
         + this.getDate()
         + ", completeDate="
         + this.getCompleteDate()
         + ", mete="
         + this.getMete()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanMonomerDetail)) {
         return false;
      }

      PlanMonomerDetail other = (PlanMonomerDetail)o;
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
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$productCategory = this.getProductCategory();
                  Object other$productCategory = other.getProductCategory();
                  if (this$productCategory == null ? other$productCategory == null : this$productCategory.equals(other$productCategory)) {
                     Object this$date = this.getDate();
                     Object other$date = other.getDate();
                     if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                        Object this$completeDate = this.getCompleteDate();
                        Object other$completeDate = other.getCompleteDate();
                        if (this$completeDate == null ? other$completeDate == null : this$completeDate.equals(other$completeDate)) {
                           Object this$mete = this.getMete();
                           Object other$mete = other.getMete();
                           if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof PlanMonomerDetail;
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
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $productCategory = this.getProductCategory();
      result = result * 59 + ($productCategory == null ? 43 : $productCategory.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $completeDate = this.getCompleteDate();
      result = result * 59 + ($completeDate == null ? 43 : $completeDate.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class PlanMonomerDetailBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Integer type;
      private Integer productCategory;
      private LocalDate date;
      private LocalDate completeDate;
      private BigDecimal mete;
      private String remark;

      PlanMonomerDetailBuilder() {
      }

      @JsonProperty("id")
      public PlanMonomerDetail.PlanMonomerDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PlanMonomerDetail.PlanMonomerDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public PlanMonomerDetail.PlanMonomerDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public PlanMonomerDetail.PlanMonomerDetailBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public PlanMonomerDetail.PlanMonomerDetailBuilder productCategory(final Integer productCategory) {
         this.productCategory = productCategory;
         return this;
      }

      public PlanMonomerDetail.PlanMonomerDetailBuilder date(final LocalDate date) {
         this.date = date;
         return this;
      }

      public PlanMonomerDetail.PlanMonomerDetailBuilder completeDate(final LocalDate completeDate) {
         this.completeDate = completeDate;
         return this;
      }

      public PlanMonomerDetail.PlanMonomerDetailBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public PlanMonomerDetail.PlanMonomerDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public PlanMonomerDetail build() {
         return new PlanMonomerDetail(
            this.id, this.projectId, this.monomerId, this.type, this.productCategory, this.date, this.completeDate, this.mete, this.remark
         );
      }

      @Override
      public String toString() {
         return "PlanMonomerDetail.PlanMonomerDetailBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", type="
            + this.type
            + ", productCategory="
            + this.productCategory
            + ", date="
            + this.date
            + ", completeDate="
            + this.completeDate
            + ", mete="
            + this.mete
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
