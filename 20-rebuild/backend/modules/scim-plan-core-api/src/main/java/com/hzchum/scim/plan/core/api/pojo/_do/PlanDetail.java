package com.hzchum.scim.plan.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "PlanDetail对象", description = " 计划详情表")
@Entity
@TableName("plan_detail")
@Table(name = "plan_detail")
public class PlanDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   @TableField("area_id")
   @Column(name = "area_id")
   private Long areaId;
   @ApiModelProperty(name = "type", value = "计划类型 1 - 深化计划  2 - 加工计划   4 - 安装计划  8 - 发运计划  ")
   @TableField("type")
   @Column(name = "type")
   private Integer type;
   @ApiModelProperty(name = "areaProductType", value = "区域产品类型  1结构件 2压型彩板 4夹芯板  8桁架楼承板 16压型楼承板  32折边件 128箱体件 ")
   @TableField("area_product_type")
   @Column(name = "area_product_type", columnDefinition = "int(11) comment '区域产品类型  1结构件 2压型彩板 4夹芯板  8桁架楼承板 16压型楼承板  32折边件 128箱体件'", nullable = false)
   private Integer areaProductType;
   @ApiModelProperty(name = "productCategory", notes = "区域产品分类(大类)  2结构件 4围护 8配套件 16箱体件")
   @TableField("product_category")
   @Column(name = "product_category", columnDefinition = "int(11) comment '区域产品分类(大类) 2结构件 4围护 8配套件 16箱体件'", nullable = false)
   private Integer productCategory;
   @ApiModelProperty(name = "startDate", value = "计划开始日期")
   @TableField("start_date")
   @Column(name = "start_date", columnDefinition = "date comment '计划开始日期'")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "计划结束日期")
   @TableField("end_date")
   @Column(name = "end_date", columnDefinition = "date comment '计划结束日期'")
   private LocalDate endDate;
   @ApiModelProperty(name = "completeDate", value = "实际完成日期")
   @TableField(value = "complete_date", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "complete_date", columnDefinition = "date comment '计划实际完成时间'")
   private LocalDate completeDate;
   @ApiModelProperty(name = "remark", value = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255) comment '备注'")
   private String remark;

   public static PlanDetail.PlanDetailBuilder builder() {
      return new PlanDetail.PlanDetailBuilder();
   }

   public PlanDetail() {
   }

   public PlanDetail(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer type,
      final Integer areaProductType,
      final Integer productCategory,
      final LocalDate startDate,
      final LocalDate endDate,
      final LocalDate completeDate,
      final String remark
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.type = type;
      this.areaProductType = areaProductType;
      this.productCategory = productCategory;
      this.startDate = startDate;
      this.endDate = endDate;
      this.completeDate = completeDate;
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

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getAreaProductType() {
      return this.areaProductType;
   }

   public Integer getProductCategory() {
      return this.productCategory;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public LocalDate getCompleteDate() {
      return this.completeDate;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public PlanDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public PlanDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public PlanDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public PlanDetail setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public PlanDetail setType(final Integer type) {
      this.type = type;
      return this;
   }

   public PlanDetail setAreaProductType(final Integer areaProductType) {
      this.areaProductType = areaProductType;
      return this;
   }

   public PlanDetail setProductCategory(final Integer productCategory) {
      this.productCategory = productCategory;
      return this;
   }

   public PlanDetail setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
      return this;
   }

   public PlanDetail setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
      return this;
   }

   public PlanDetail setCompleteDate(final LocalDate completeDate) {
      this.completeDate = completeDate;
      return this;
   }

   public PlanDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "PlanDetail(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", type="
         + this.getType()
         + ", areaProductType="
         + this.getAreaProductType()
         + ", productCategory="
         + this.getProductCategory()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", completeDate="
         + this.getCompleteDate()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanDetail)) {
         return false;
      }

      PlanDetail other = (PlanDetail)o;
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
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$type = this.getType();
                  Object other$type = other.getType();
                  if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                     Object this$areaProductType = this.getAreaProductType();
                     Object other$areaProductType = other.getAreaProductType();
                     if (this$areaProductType == null ? other$areaProductType == null : this$areaProductType.equals(other$areaProductType)) {
                        Object this$productCategory = this.getProductCategory();
                        Object other$productCategory = other.getProductCategory();
                        if (this$productCategory == null ? other$productCategory == null : this$productCategory.equals(other$productCategory)) {
                           Object this$startDate = this.getStartDate();
                           Object other$startDate = other.getStartDate();
                           if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                              Object this$endDate = this.getEndDate();
                              Object other$endDate = other.getEndDate();
                              if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                 Object this$completeDate = this.getCompleteDate();
                                 Object other$completeDate = other.getCompleteDate();
                                 if (this$completeDate == null ? other$completeDate == null : this$completeDate.equals(other$completeDate)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof PlanDetail;
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
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $areaProductType = this.getAreaProductType();
      result = result * 59 + ($areaProductType == null ? 43 : $areaProductType.hashCode());
      Object $productCategory = this.getProductCategory();
      result = result * 59 + ($productCategory == null ? 43 : $productCategory.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $completeDate = this.getCompleteDate();
      result = result * 59 + ($completeDate == null ? 43 : $completeDate.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class PlanDetailBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer type;
      private Integer areaProductType;
      private Integer productCategory;
      private LocalDate startDate;
      private LocalDate endDate;
      private LocalDate completeDate;
      private String remark;

      PlanDetailBuilder() {
      }

      @JsonProperty("id")
      public PlanDetail.PlanDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PlanDetail.PlanDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public PlanDetail.PlanDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public PlanDetail.PlanDetailBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public PlanDetail.PlanDetailBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public PlanDetail.PlanDetailBuilder areaProductType(final Integer areaProductType) {
         this.areaProductType = areaProductType;
         return this;
      }

      public PlanDetail.PlanDetailBuilder productCategory(final Integer productCategory) {
         this.productCategory = productCategory;
         return this;
      }

      public PlanDetail.PlanDetailBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public PlanDetail.PlanDetailBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public PlanDetail.PlanDetailBuilder completeDate(final LocalDate completeDate) {
         this.completeDate = completeDate;
         return this;
      }

      public PlanDetail.PlanDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public PlanDetail build() {
         return new PlanDetail(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.type,
            this.areaProductType,
            this.productCategory,
            this.startDate,
            this.endDate,
            this.completeDate,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "PlanDetail.PlanDetailBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", type="
            + this.type
            + ", areaProductType="
            + this.areaProductType
            + ", productCategory="
            + this.productCategory
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", completeDate="
            + this.completeDate
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
