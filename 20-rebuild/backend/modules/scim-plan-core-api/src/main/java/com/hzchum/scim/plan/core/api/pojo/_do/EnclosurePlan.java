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

@ApiModel(value = "enclosure_plan对象", description = "围护计划表")
@Entity
@TableName("enclosure_plan")
@Table(name = "enclosure_plan")
public class EnclosurePlan extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", notes = "批次名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) comment '批次名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "date", notes = "交货日期")
   @TableField("date")
   @Column(name = "date", columnDefinition = "date comment '交货日期'")
   private LocalDate date;
   @ApiModelProperty(name = "quantityWork", notes = "工程量")
   @TableField("quantity_work")
   @Column(name = "quantity_work", columnDefinition = "decimal(32,8) default 0.0 comment '工程量'", nullable = false)
   private BigDecimal quantityWork;
   @ApiModelProperty(name = "remark", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255) comment '备注'")
   private String remark;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) comment '项目id'")
   private Long projectId;
   @ApiModelProperty(name = "category", value = "类型 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件 64配套件 128箱体件")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11) comment '类型 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件'")
   private Integer category;

   public static EnclosurePlan.EnclosurePlanBuilder builder() {
      return new EnclosurePlan.EnclosurePlanBuilder();
   }

   public EnclosurePlan() {
   }

   public EnclosurePlan(
      final Long id, final String name, final LocalDate date, final BigDecimal quantityWork, final String remark, final Long projectId, final Integer category
   ) {
      this.id = id;
      this.name = name;
      this.date = date;
      this.quantityWork = quantityWork;
      this.remark = remark;
      this.projectId = projectId;
      this.category = category;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public BigDecimal getQuantityWork() {
      return this.quantityWork;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getCategory() {
      return this.category;
   }

   @JsonProperty("id")
   public EnclosurePlan setId(final Long id) {
      this.id = id;
      return this;
   }

   public EnclosurePlan setName(final String name) {
      this.name = name;
      return this;
   }

   public EnclosurePlan setDate(final LocalDate date) {
      this.date = date;
      return this;
   }

   public EnclosurePlan setQuantityWork(final BigDecimal quantityWork) {
      this.quantityWork = quantityWork;
      return this;
   }

   public EnclosurePlan setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public EnclosurePlan setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("category")
   public EnclosurePlan setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @Override
   public String toString() {
      return "EnclosurePlan(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", date="
         + this.getDate()
         + ", quantityWork="
         + this.getQuantityWork()
         + ", remark="
         + this.getRemark()
         + ", projectId="
         + this.getProjectId()
         + ", category="
         + this.getCategory()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosurePlan)) {
         return false;
      }

      EnclosurePlan other = (EnclosurePlan)o;
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
            Object this$category = this.getCategory();
            Object other$category = other.getCategory();
            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$date = this.getDate();
                  Object other$date = other.getDate();
                  if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                     Object this$quantityWork = this.getQuantityWork();
                     Object other$quantityWork = other.getQuantityWork();
                     if (this$quantityWork == null ? other$quantityWork == null : this$quantityWork.equals(other$quantityWork)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof EnclosurePlan;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $quantityWork = this.getQuantityWork();
      result = result * 59 + ($quantityWork == null ? 43 : $quantityWork.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class EnclosurePlanBuilder {
      private Long id;
      private String name;
      private LocalDate date;
      private BigDecimal quantityWork;
      private String remark;
      private Long projectId;
      private Integer category;

      EnclosurePlanBuilder() {
      }

      @JsonProperty("id")
      public EnclosurePlan.EnclosurePlanBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public EnclosurePlan.EnclosurePlanBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public EnclosurePlan.EnclosurePlanBuilder date(final LocalDate date) {
         this.date = date;
         return this;
      }

      public EnclosurePlan.EnclosurePlanBuilder quantityWork(final BigDecimal quantityWork) {
         this.quantityWork = quantityWork;
         return this;
      }

      public EnclosurePlan.EnclosurePlanBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public EnclosurePlan.EnclosurePlanBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("category")
      public EnclosurePlan.EnclosurePlanBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public EnclosurePlan build() {
         return new EnclosurePlan(this.id, this.name, this.date, this.quantityWork, this.remark, this.projectId, this.category);
      }

      @Override
      public String toString() {
         return "EnclosurePlan.EnclosurePlanBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", date="
            + this.date
            + ", quantityWork="
            + this.quantityWork
            + ", remark="
            + this.remark
            + ", projectId="
            + this.projectId
            + ", category="
            + this.category
            + ")";
      }
   }
}
