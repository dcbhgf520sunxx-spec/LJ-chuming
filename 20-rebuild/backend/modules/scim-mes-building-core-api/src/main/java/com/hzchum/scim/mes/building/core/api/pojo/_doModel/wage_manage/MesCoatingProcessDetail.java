package com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage;

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
import javax.persistence.Table;

@ApiModel(value = "MesCoatingProcessDetail对象", description = "涂装工艺详情表")
@Entity
@TableName("mes_coating_process_detail")
@Table(name = "mes_coating_process_detail")
@org.hibernate.annotations.Table(appliesTo = "mes_coating_process_detail", comment = "涂装工艺详情表")
public class MesCoatingProcessDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "coatingProcessId", value = "涂装工艺ID", notes = "涂装工艺ID")
   @TableField("coating_process_id")
   @Column(name = "coating_process_id", columnDefinition = "bigint(20)  COMMENT '涂装工艺ID'", nullable = true)
   private Long coatingProcessId;
   @ApiModelProperty(name = "paintType", value = "油漆类型(PaintingTypeEnum)", notes = "油漆类型(PaintingTypeEnum)")
   @TableField("paint_type")
   @Column(name = "paint_type", columnDefinition = "int(11)  COMMENT '油漆类型(PaintingTypeEnum)'", nullable = true)
   private Integer paintType;
   @ApiModelProperty(name = "paintBrand", value = "油漆品牌", notes = "油漆品牌")
   @TableField("paint_brand")
   @Column(name = "paint_brand", columnDefinition = "varchar(255)  COMMENT '油漆品牌'", nullable = true)
   private String paintBrand;
   @ApiModelProperty(name = "paintCategory", value = "油漆种类", notes = "油漆种类")
   @TableField("paint_category")
   @Column(name = "paint_category", columnDefinition = "varchar(255)  COMMENT '油漆种类'", nullable = true)
   private String paintCategory;
   @ApiModelProperty(name = "thickness", value = "干膜厚度(μm)", notes = "干膜厚度(μm)")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "int(11)  COMMENT '干膜厚度(μm)'", nullable = true)
   private Integer thickness;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(500)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "useQuantity", value = "使用量(kg)", notes = "使用量(kg)")
   @TableField("use_quantity")
   @Column(name = "use_quantity", columnDefinition = "int(11)  COMMENT '使用量(kg)'", nullable = true)
   private Integer useQuantity;

   public static MesCoatingProcessDetail.MesCoatingProcessDetailBuilder builder() {
      return new MesCoatingProcessDetail.MesCoatingProcessDetailBuilder();
   }

   public MesCoatingProcessDetail() {
   }

   public MesCoatingProcessDetail(
      final Long id,
      final Long coatingProcessId,
      final Integer paintType,
      final String paintBrand,
      final String paintCategory,
      final Integer thickness,
      final String remark,
      final Integer useQuantity
   ) {
      this.id = id;
      this.coatingProcessId = coatingProcessId;
      this.paintType = paintType;
      this.paintBrand = paintBrand;
      this.paintCategory = paintCategory;
      this.thickness = thickness;
      this.remark = remark;
      this.useQuantity = useQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCoatingProcessId() {
      return this.coatingProcessId;
   }

   public Integer getPaintType() {
      return this.paintType;
   }

   public String getPaintBrand() {
      return this.paintBrand;
   }

   public String getPaintCategory() {
      return this.paintCategory;
   }

   public Integer getThickness() {
      return this.thickness;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getUseQuantity() {
      return this.useQuantity;
   }

   public MesCoatingProcessDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesCoatingProcessDetail setCoatingProcessId(final Long coatingProcessId) {
      this.coatingProcessId = coatingProcessId;
      return this;
   }

   public MesCoatingProcessDetail setPaintType(final Integer paintType) {
      this.paintType = paintType;
      return this;
   }

   public MesCoatingProcessDetail setPaintBrand(final String paintBrand) {
      this.paintBrand = paintBrand;
      return this;
   }

   public MesCoatingProcessDetail setPaintCategory(final String paintCategory) {
      this.paintCategory = paintCategory;
      return this;
   }

   public MesCoatingProcessDetail setThickness(final Integer thickness) {
      this.thickness = thickness;
      return this;
   }

   public MesCoatingProcessDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public MesCoatingProcessDetail setUseQuantity(final Integer useQuantity) {
      this.useQuantity = useQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesCoatingProcessDetail(id="
         + this.getId()
         + ", coatingProcessId="
         + this.getCoatingProcessId()
         + ", paintType="
         + this.getPaintType()
         + ", paintBrand="
         + this.getPaintBrand()
         + ", paintCategory="
         + this.getPaintCategory()
         + ", thickness="
         + this.getThickness()
         + ", remark="
         + this.getRemark()
         + ", useQuantity="
         + this.getUseQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesCoatingProcessDetail)) {
         return false;
      }

      MesCoatingProcessDetail other = (MesCoatingProcessDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$coatingProcessId = this.getCoatingProcessId();
         Object other$coatingProcessId = other.getCoatingProcessId();
         if (this$coatingProcessId == null ? other$coatingProcessId == null : this$coatingProcessId.equals(other$coatingProcessId)) {
            Object this$paintType = this.getPaintType();
            Object other$paintType = other.getPaintType();
            if (this$paintType == null ? other$paintType == null : this$paintType.equals(other$paintType)) {
               Object this$thickness = this.getThickness();
               Object other$thickness = other.getThickness();
               if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                  Object this$useQuantity = this.getUseQuantity();
                  Object other$useQuantity = other.getUseQuantity();
                  if (this$useQuantity == null ? other$useQuantity == null : this$useQuantity.equals(other$useQuantity)) {
                     Object this$paintBrand = this.getPaintBrand();
                     Object other$paintBrand = other.getPaintBrand();
                     if (this$paintBrand == null ? other$paintBrand == null : this$paintBrand.equals(other$paintBrand)) {
                        Object this$paintCategory = this.getPaintCategory();
                        Object other$paintCategory = other.getPaintCategory();
                        if (this$paintCategory == null ? other$paintCategory == null : this$paintCategory.equals(other$paintCategory)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesCoatingProcessDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $coatingProcessId = this.getCoatingProcessId();
      result = result * 59 + ($coatingProcessId == null ? 43 : $coatingProcessId.hashCode());
      Object $paintType = this.getPaintType();
      result = result * 59 + ($paintType == null ? 43 : $paintType.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $useQuantity = this.getUseQuantity();
      result = result * 59 + ($useQuantity == null ? 43 : $useQuantity.hashCode());
      Object $paintBrand = this.getPaintBrand();
      result = result * 59 + ($paintBrand == null ? 43 : $paintBrand.hashCode());
      Object $paintCategory = this.getPaintCategory();
      result = result * 59 + ($paintCategory == null ? 43 : $paintCategory.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class MesCoatingProcessDetailBuilder {
      private Long id;
      private Long coatingProcessId;
      private Integer paintType;
      private String paintBrand;
      private String paintCategory;
      private Integer thickness;
      private String remark;
      private Integer useQuantity;

      MesCoatingProcessDetailBuilder() {
      }

      public MesCoatingProcessDetail.MesCoatingProcessDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesCoatingProcessDetail.MesCoatingProcessDetailBuilder coatingProcessId(final Long coatingProcessId) {
         this.coatingProcessId = coatingProcessId;
         return this;
      }

      public MesCoatingProcessDetail.MesCoatingProcessDetailBuilder paintType(final Integer paintType) {
         this.paintType = paintType;
         return this;
      }

      public MesCoatingProcessDetail.MesCoatingProcessDetailBuilder paintBrand(final String paintBrand) {
         this.paintBrand = paintBrand;
         return this;
      }

      public MesCoatingProcessDetail.MesCoatingProcessDetailBuilder paintCategory(final String paintCategory) {
         this.paintCategory = paintCategory;
         return this;
      }

      public MesCoatingProcessDetail.MesCoatingProcessDetailBuilder thickness(final Integer thickness) {
         this.thickness = thickness;
         return this;
      }

      public MesCoatingProcessDetail.MesCoatingProcessDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MesCoatingProcessDetail.MesCoatingProcessDetailBuilder useQuantity(final Integer useQuantity) {
         this.useQuantity = useQuantity;
         return this;
      }

      public MesCoatingProcessDetail build() {
         return new MesCoatingProcessDetail(
            this.id, this.coatingProcessId, this.paintType, this.paintBrand, this.paintCategory, this.thickness, this.remark, this.useQuantity
         );
      }

      @Override
      public String toString() {
         return "MesCoatingProcessDetail.MesCoatingProcessDetailBuilder(id="
            + this.id
            + ", coatingProcessId="
            + this.coatingProcessId
            + ", paintType="
            + this.paintType
            + ", paintBrand="
            + this.paintBrand
            + ", paintCategory="
            + this.paintCategory
            + ", thickness="
            + this.thickness
            + ", remark="
            + this.remark
            + ", useQuantity="
            + this.useQuantity
            + ")";
      }
   }
}
