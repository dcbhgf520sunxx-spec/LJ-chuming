package com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "MesAssembleQuotaConfigDetail对象", description = "部件定额配置详情表")
@Entity
@TableName("mes_assemble_quota_config_detail")
@Table(name = "mes_assemble_quota_config_detail")
@org.hibernate.annotations.Table(appliesTo = "mes_assemble_quota_config_detail", comment = "部件定额配置详情表")
public class MesAssembleQuotaConfigDetail extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("部件定额配置ID")
   @TableField("assemble_quota_config_id")
   @Column(name = "assemble_quota_config_id", columnDefinition = "bigint(20)  COMMENT '部件定额配置ID'", nullable = true)
   private Long assembleQuotaConfigId;
   @ApiModelProperty("截面高度比较运算符1")
   @TableField("section_height_comparison_operator_one")
   @Column(name = "section_height_comparison_operator_one", columnDefinition = "int(11) COMMENT '截面高度比较运算符1'", nullable = true)
   private Integer sectionHeightComparisonOperatorOne;
   @ApiModelProperty("截面高度数字1")
   @TableField("section_height_number_one")
   @Column(name = "section_height_number_one", columnDefinition = "decimal(32,8) COMMENT '截面高度数字1'", nullable = true)
   private BigDecimal sectionHeightNumberOne;
   @ApiModelProperty("截面高度比较运算符2")
   @TableField("section_height_comparison_operator_two")
   @Column(name = "section_height_comparison_operator_two", columnDefinition = "int(11) COMMENT '截面高度比较运算符2'", nullable = true)
   private Integer sectionHeightComparisonOperatorTwo;
   @ApiModelProperty("截面高度数字2")
   @TableField("section_height_number_two")
   @Column(name = "section_height_number_two", columnDefinition = "decimal(32,8) COMMENT '截面高度数字2'", nullable = true)
   private BigDecimal sectionHeightNumberTwo;
   @ApiModelProperty("腹板厚度比较运算符1")
   @TableField("web_thickness_comparison_operator_one")
   @Column(name = "web_thickness_comparison_operator_one", columnDefinition = "int(11) COMMENT '腹板厚度比较运算符1'", nullable = true)
   private Integer webThicknessComparisonOperatorOne;
   @ApiModelProperty("腹板厚度数字1")
   @TableField("web_thickness_number_one")
   @Column(name = "web_thickness_number_one", columnDefinition = "decimal(32,8) COMMENT '腹板厚度数字1'", nullable = true)
   private BigDecimal webThicknessNumberOne;
   @ApiModelProperty("腹板厚度比较运算符2")
   @TableField("web_thickness_comparison_operator_two")
   @Column(name = "web_thickness_comparison_operator_two", columnDefinition = "int(11) COMMENT '腹板厚度比较运算符2'", nullable = true)
   private Integer webThicknessComparisonOperatorTwo;
   @ApiModelProperty("腹板厚度数字2")
   @TableField("web_thickness_number_two")
   @Column(name = "web_thickness_number_two", columnDefinition = "decimal(32,8) COMMENT '腹板厚度数字2'", nullable = true)
   private BigDecimal webThicknessNumberTwo;
   @ApiModelProperty("单价(元)")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8) COMMENT '单价(元)'", nullable = true)
   private BigDecimal price;

   public static MesAssembleQuotaConfigDetail.MesAssembleQuotaConfigDetailBuilder builder() {
      return new MesAssembleQuotaConfigDetail.MesAssembleQuotaConfigDetailBuilder();
   }

   public MesAssembleQuotaConfigDetail() {
   }

   public MesAssembleQuotaConfigDetail(
      final Long id,
      final Long assembleQuotaConfigId,
      final Integer sectionHeightComparisonOperatorOne,
      final BigDecimal sectionHeightNumberOne,
      final Integer sectionHeightComparisonOperatorTwo,
      final BigDecimal sectionHeightNumberTwo,
      final Integer webThicknessComparisonOperatorOne,
      final BigDecimal webThicknessNumberOne,
      final Integer webThicknessComparisonOperatorTwo,
      final BigDecimal webThicknessNumberTwo,
      final BigDecimal price
   ) {
      this.id = id;
      this.assembleQuotaConfigId = assembleQuotaConfigId;
      this.sectionHeightComparisonOperatorOne = sectionHeightComparisonOperatorOne;
      this.sectionHeightNumberOne = sectionHeightNumberOne;
      this.sectionHeightComparisonOperatorTwo = sectionHeightComparisonOperatorTwo;
      this.sectionHeightNumberTwo = sectionHeightNumberTwo;
      this.webThicknessComparisonOperatorOne = webThicknessComparisonOperatorOne;
      this.webThicknessNumberOne = webThicknessNumberOne;
      this.webThicknessComparisonOperatorTwo = webThicknessComparisonOperatorTwo;
      this.webThicknessNumberTwo = webThicknessNumberTwo;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAssembleQuotaConfigId() {
      return this.assembleQuotaConfigId;
   }

   public Integer getSectionHeightComparisonOperatorOne() {
      return this.sectionHeightComparisonOperatorOne;
   }

   public BigDecimal getSectionHeightNumberOne() {
      return this.sectionHeightNumberOne;
   }

   public Integer getSectionHeightComparisonOperatorTwo() {
      return this.sectionHeightComparisonOperatorTwo;
   }

   public BigDecimal getSectionHeightNumberTwo() {
      return this.sectionHeightNumberTwo;
   }

   public Integer getWebThicknessComparisonOperatorOne() {
      return this.webThicknessComparisonOperatorOne;
   }

   public BigDecimal getWebThicknessNumberOne() {
      return this.webThicknessNumberOne;
   }

   public Integer getWebThicknessComparisonOperatorTwo() {
      return this.webThicknessComparisonOperatorTwo;
   }

   public BigDecimal getWebThicknessNumberTwo() {
      return this.webThicknessNumberTwo;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public MesAssembleQuotaConfigDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesAssembleQuotaConfigDetail setAssembleQuotaConfigId(final Long assembleQuotaConfigId) {
      this.assembleQuotaConfigId = assembleQuotaConfigId;
      return this;
   }

   public MesAssembleQuotaConfigDetail setSectionHeightComparisonOperatorOne(final Integer sectionHeightComparisonOperatorOne) {
      this.sectionHeightComparisonOperatorOne = sectionHeightComparisonOperatorOne;
      return this;
   }

   public MesAssembleQuotaConfigDetail setSectionHeightNumberOne(final BigDecimal sectionHeightNumberOne) {
      this.sectionHeightNumberOne = sectionHeightNumberOne;
      return this;
   }

   public MesAssembleQuotaConfigDetail setSectionHeightComparisonOperatorTwo(final Integer sectionHeightComparisonOperatorTwo) {
      this.sectionHeightComparisonOperatorTwo = sectionHeightComparisonOperatorTwo;
      return this;
   }

   public MesAssembleQuotaConfigDetail setSectionHeightNumberTwo(final BigDecimal sectionHeightNumberTwo) {
      this.sectionHeightNumberTwo = sectionHeightNumberTwo;
      return this;
   }

   public MesAssembleQuotaConfigDetail setWebThicknessComparisonOperatorOne(final Integer webThicknessComparisonOperatorOne) {
      this.webThicknessComparisonOperatorOne = webThicknessComparisonOperatorOne;
      return this;
   }

   public MesAssembleQuotaConfigDetail setWebThicknessNumberOne(final BigDecimal webThicknessNumberOne) {
      this.webThicknessNumberOne = webThicknessNumberOne;
      return this;
   }

   public MesAssembleQuotaConfigDetail setWebThicknessComparisonOperatorTwo(final Integer webThicknessComparisonOperatorTwo) {
      this.webThicknessComparisonOperatorTwo = webThicknessComparisonOperatorTwo;
      return this;
   }

   public MesAssembleQuotaConfigDetail setWebThicknessNumberTwo(final BigDecimal webThicknessNumberTwo) {
      this.webThicknessNumberTwo = webThicknessNumberTwo;
      return this;
   }

   public MesAssembleQuotaConfigDetail setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesAssembleQuotaConfigDetail(id="
         + this.getId()
         + ", assembleQuotaConfigId="
         + this.getAssembleQuotaConfigId()
         + ", sectionHeightComparisonOperatorOne="
         + this.getSectionHeightComparisonOperatorOne()
         + ", sectionHeightNumberOne="
         + this.getSectionHeightNumberOne()
         + ", sectionHeightComparisonOperatorTwo="
         + this.getSectionHeightComparisonOperatorTwo()
         + ", sectionHeightNumberTwo="
         + this.getSectionHeightNumberTwo()
         + ", webThicknessComparisonOperatorOne="
         + this.getWebThicknessComparisonOperatorOne()
         + ", webThicknessNumberOne="
         + this.getWebThicknessNumberOne()
         + ", webThicknessComparisonOperatorTwo="
         + this.getWebThicknessComparisonOperatorTwo()
         + ", webThicknessNumberTwo="
         + this.getWebThicknessNumberTwo()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesAssembleQuotaConfigDetail)) {
         return false;
      }

      MesAssembleQuotaConfigDetail other = (MesAssembleQuotaConfigDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assembleQuotaConfigId = this.getAssembleQuotaConfigId();
         Object other$assembleQuotaConfigId = other.getAssembleQuotaConfigId();
         if (this$assembleQuotaConfigId == null ? other$assembleQuotaConfigId == null : this$assembleQuotaConfigId.equals(other$assembleQuotaConfigId)) {
            Object this$sectionHeightComparisonOperatorOne = this.getSectionHeightComparisonOperatorOne();
            Object other$sectionHeightComparisonOperatorOne = other.getSectionHeightComparisonOperatorOne();
            if (this$sectionHeightComparisonOperatorOne == null
               ? other$sectionHeightComparisonOperatorOne == null
               : this$sectionHeightComparisonOperatorOne.equals(other$sectionHeightComparisonOperatorOne)) {
               Object this$sectionHeightComparisonOperatorTwo = this.getSectionHeightComparisonOperatorTwo();
               Object other$sectionHeightComparisonOperatorTwo = other.getSectionHeightComparisonOperatorTwo();
               if (this$sectionHeightComparisonOperatorTwo == null
                  ? other$sectionHeightComparisonOperatorTwo == null
                  : this$sectionHeightComparisonOperatorTwo.equals(other$sectionHeightComparisonOperatorTwo)) {
                  Object this$webThicknessComparisonOperatorOne = this.getWebThicknessComparisonOperatorOne();
                  Object other$webThicknessComparisonOperatorOne = other.getWebThicknessComparisonOperatorOne();
                  if (this$webThicknessComparisonOperatorOne == null
                     ? other$webThicknessComparisonOperatorOne == null
                     : this$webThicknessComparisonOperatorOne.equals(other$webThicknessComparisonOperatorOne)) {
                     Object this$webThicknessComparisonOperatorTwo = this.getWebThicknessComparisonOperatorTwo();
                     Object other$webThicknessComparisonOperatorTwo = other.getWebThicknessComparisonOperatorTwo();
                     if (this$webThicknessComparisonOperatorTwo == null
                        ? other$webThicknessComparisonOperatorTwo == null
                        : this$webThicknessComparisonOperatorTwo.equals(other$webThicknessComparisonOperatorTwo)) {
                        Object this$sectionHeightNumberOne = this.getSectionHeightNumberOne();
                        Object other$sectionHeightNumberOne = other.getSectionHeightNumberOne();
                        if (this$sectionHeightNumberOne == null
                           ? other$sectionHeightNumberOne == null
                           : this$sectionHeightNumberOne.equals(other$sectionHeightNumberOne)) {
                           Object this$sectionHeightNumberTwo = this.getSectionHeightNumberTwo();
                           Object other$sectionHeightNumberTwo = other.getSectionHeightNumberTwo();
                           if (this$sectionHeightNumberTwo == null
                              ? other$sectionHeightNumberTwo == null
                              : this$sectionHeightNumberTwo.equals(other$sectionHeightNumberTwo)) {
                              Object this$webThicknessNumberOne = this.getWebThicknessNumberOne();
                              Object other$webThicknessNumberOne = other.getWebThicknessNumberOne();
                              if (this$webThicknessNumberOne == null
                                 ? other$webThicknessNumberOne == null
                                 : this$webThicknessNumberOne.equals(other$webThicknessNumberOne)) {
                                 Object this$webThicknessNumberTwo = this.getWebThicknessNumberTwo();
                                 Object other$webThicknessNumberTwo = other.getWebThicknessNumberTwo();
                                 if (this$webThicknessNumberTwo == null
                                    ? other$webThicknessNumberTwo == null
                                    : this$webThicknessNumberTwo.equals(other$webThicknessNumberTwo)) {
                                    Object this$price = this.getPrice();
                                    Object other$price = other.getPrice();
                                    return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof MesAssembleQuotaConfigDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assembleQuotaConfigId = this.getAssembleQuotaConfigId();
      result = result * 59 + ($assembleQuotaConfigId == null ? 43 : $assembleQuotaConfigId.hashCode());
      Object $sectionHeightComparisonOperatorOne = this.getSectionHeightComparisonOperatorOne();
      result = result * 59 + ($sectionHeightComparisonOperatorOne == null ? 43 : $sectionHeightComparisonOperatorOne.hashCode());
      Object $sectionHeightComparisonOperatorTwo = this.getSectionHeightComparisonOperatorTwo();
      result = result * 59 + ($sectionHeightComparisonOperatorTwo == null ? 43 : $sectionHeightComparisonOperatorTwo.hashCode());
      Object $webThicknessComparisonOperatorOne = this.getWebThicknessComparisonOperatorOne();
      result = result * 59 + ($webThicknessComparisonOperatorOne == null ? 43 : $webThicknessComparisonOperatorOne.hashCode());
      Object $webThicknessComparisonOperatorTwo = this.getWebThicknessComparisonOperatorTwo();
      result = result * 59 + ($webThicknessComparisonOperatorTwo == null ? 43 : $webThicknessComparisonOperatorTwo.hashCode());
      Object $sectionHeightNumberOne = this.getSectionHeightNumberOne();
      result = result * 59 + ($sectionHeightNumberOne == null ? 43 : $sectionHeightNumberOne.hashCode());
      Object $sectionHeightNumberTwo = this.getSectionHeightNumberTwo();
      result = result * 59 + ($sectionHeightNumberTwo == null ? 43 : $sectionHeightNumberTwo.hashCode());
      Object $webThicknessNumberOne = this.getWebThicknessNumberOne();
      result = result * 59 + ($webThicknessNumberOne == null ? 43 : $webThicknessNumberOne.hashCode());
      Object $webThicknessNumberTwo = this.getWebThicknessNumberTwo();
      result = result * 59 + ($webThicknessNumberTwo == null ? 43 : $webThicknessNumberTwo.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesAssembleQuotaConfigDetailBuilder {
      private Long id;
      private Long assembleQuotaConfigId;
      private Integer sectionHeightComparisonOperatorOne;
      private BigDecimal sectionHeightNumberOne;
      private Integer sectionHeightComparisonOperatorTwo;
      private BigDecimal sectionHeightNumberTwo;
      private Integer webThicknessComparisonOperatorOne;
      private BigDecimal webThicknessNumberOne;
      private Integer webThicknessComparisonOperatorTwo;
      private BigDecimal webThicknessNumberTwo;
      private BigDecimal price;

      MesAssembleQuotaConfigDetailBuilder() {
      }

      public MesAssembleQuotaConfigDetail.MesAssembleQuotaConfigDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesAssembleQuotaConfigDetail.MesAssembleQuotaConfigDetailBuilder assembleQuotaConfigId(final Long assembleQuotaConfigId) {
         this.assembleQuotaConfigId = assembleQuotaConfigId;
         return this;
      }

      public MesAssembleQuotaConfigDetail.MesAssembleQuotaConfigDetailBuilder sectionHeightComparisonOperatorOne(
         final Integer sectionHeightComparisonOperatorOne
      ) {
         this.sectionHeightComparisonOperatorOne = sectionHeightComparisonOperatorOne;
         return this;
      }

      public MesAssembleQuotaConfigDetail.MesAssembleQuotaConfigDetailBuilder sectionHeightNumberOne(final BigDecimal sectionHeightNumberOne) {
         this.sectionHeightNumberOne = sectionHeightNumberOne;
         return this;
      }

      public MesAssembleQuotaConfigDetail.MesAssembleQuotaConfigDetailBuilder sectionHeightComparisonOperatorTwo(
         final Integer sectionHeightComparisonOperatorTwo
      ) {
         this.sectionHeightComparisonOperatorTwo = sectionHeightComparisonOperatorTwo;
         return this;
      }

      public MesAssembleQuotaConfigDetail.MesAssembleQuotaConfigDetailBuilder sectionHeightNumberTwo(final BigDecimal sectionHeightNumberTwo) {
         this.sectionHeightNumberTwo = sectionHeightNumberTwo;
         return this;
      }

      public MesAssembleQuotaConfigDetail.MesAssembleQuotaConfigDetailBuilder webThicknessComparisonOperatorOne(final Integer webThicknessComparisonOperatorOne) {
         this.webThicknessComparisonOperatorOne = webThicknessComparisonOperatorOne;
         return this;
      }

      public MesAssembleQuotaConfigDetail.MesAssembleQuotaConfigDetailBuilder webThicknessNumberOne(final BigDecimal webThicknessNumberOne) {
         this.webThicknessNumberOne = webThicknessNumberOne;
         return this;
      }

      public MesAssembleQuotaConfigDetail.MesAssembleQuotaConfigDetailBuilder webThicknessComparisonOperatorTwo(final Integer webThicknessComparisonOperatorTwo) {
         this.webThicknessComparisonOperatorTwo = webThicknessComparisonOperatorTwo;
         return this;
      }

      public MesAssembleQuotaConfigDetail.MesAssembleQuotaConfigDetailBuilder webThicknessNumberTwo(final BigDecimal webThicknessNumberTwo) {
         this.webThicknessNumberTwo = webThicknessNumberTwo;
         return this;
      }

      public MesAssembleQuotaConfigDetail.MesAssembleQuotaConfigDetailBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesAssembleQuotaConfigDetail build() {
         return new MesAssembleQuotaConfigDetail(
            this.id,
            this.assembleQuotaConfigId,
            this.sectionHeightComparisonOperatorOne,
            this.sectionHeightNumberOne,
            this.sectionHeightComparisonOperatorTwo,
            this.sectionHeightNumberTwo,
            this.webThicknessComparisonOperatorOne,
            this.webThicknessNumberOne,
            this.webThicknessComparisonOperatorTwo,
            this.webThicknessNumberTwo,
            this.price
         );
      }

      @Override
      public String toString() {
         return "MesAssembleQuotaConfigDetail.MesAssembleQuotaConfigDetailBuilder(id="
            + this.id
            + ", assembleQuotaConfigId="
            + this.assembleQuotaConfigId
            + ", sectionHeightComparisonOperatorOne="
            + this.sectionHeightComparisonOperatorOne
            + ", sectionHeightNumberOne="
            + this.sectionHeightNumberOne
            + ", sectionHeightComparisonOperatorTwo="
            + this.sectionHeightComparisonOperatorTwo
            + ", sectionHeightNumberTwo="
            + this.sectionHeightNumberTwo
            + ", webThicknessComparisonOperatorOne="
            + this.webThicknessComparisonOperatorOne
            + ", webThicknessNumberOne="
            + this.webThicknessNumberOne
            + ", webThicknessComparisonOperatorTwo="
            + this.webThicknessComparisonOperatorTwo
            + ", webThicknessNumberTwo="
            + this.webThicknessNumberTwo
            + ", price="
            + this.price
            + ")";
      }
   }
}
