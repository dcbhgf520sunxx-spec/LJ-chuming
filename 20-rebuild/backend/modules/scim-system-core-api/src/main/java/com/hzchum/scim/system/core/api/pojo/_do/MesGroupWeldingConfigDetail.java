package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "MesGroupWeldingConfigDetail对象", description = "组焊配置详情表")
@Entity
@TableName("mes_group_welding_config_detail")
@Table(name = "mes_group_welding_config_detail")
@org.hibernate.annotations.Table(appliesTo = "mes_group_welding_config_detail", comment = "组焊配置详情表")
public class MesGroupWeldingConfigDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "groupWeldingConfigId", value = "组焊配置ID", notes = "组焊配置ID")
   @TableField("group_welding_config_id")
   @Column(name = "group_welding_config_id", columnDefinition = "bigint(20)  COMMENT '组焊配置ID'", nullable = true)
   private Long groupWeldingConfigId;
   @ApiModelProperty(name = "comparisonOperatorOne", value = "比较运算符1", notes = "比较运算符1")
   @TableField("comparison_operator_one")
   @Column(name = "comparison_operator_one", columnDefinition = "int(11)  COMMENT '比较运算符1'", nullable = true)
   private Integer comparisonOperatorOne;
   @ApiModelProperty(name = "numberOne", value = "数字1", notes = "数字1")
   @TableField("number_one")
   @Column(name = "number_one", columnDefinition = "int(11)  COMMENT '数字1'", nullable = true)
   private Integer numberOne;
   @ApiModelProperty(name = "comparisonOperatorTwo", value = "比较运算符2", notes = "比较运算符2")
   @TableField("comparison_operator_two")
   @Column(name = "comparison_operator_two", columnDefinition = "int(11)  COMMENT '比较运算符2'", nullable = true)
   private Integer comparisonOperatorTwo;
   @ApiModelProperty(name = "numberTwo", value = "数字2", notes = "数字2")
   @TableField("number_two")
   @Column(name = "number_two", columnDefinition = "int(11)  COMMENT '数字2'", nullable = true)
   private Integer numberTwo;
   @ApiModelProperty(name = "organizationInsidePrice", value = "编制内单价(元)", notes = "编制内单价(元)")
   @TableField("organization_inside_price")
   @Column(name = "organization_inside_price", columnDefinition = "decimal(32,8)  COMMENT '编制内单价(元)'", nullable = true)
   private BigDecimal organizationInsidePrice;
   @ApiModelProperty(name = "organizationOutsidePrice", value = "编制外单价(元)", notes = "编制外单价(元)")
   @TableField("organization_outside_price")
   @Column(name = "organization_outside_price", columnDefinition = "decimal(32,8)  COMMENT '编制外单价(元)'", nullable = true)
   private BigDecimal organizationOutsidePrice;

   public static MesGroupWeldingConfigDetail.MesGroupWeldingConfigDetailBuilder builder() {
      return new MesGroupWeldingConfigDetail.MesGroupWeldingConfigDetailBuilder();
   }

   public MesGroupWeldingConfigDetail() {
   }

   public MesGroupWeldingConfigDetail(
      final Long id,
      final Long groupWeldingConfigId,
      final Integer comparisonOperatorOne,
      final Integer numberOne,
      final Integer comparisonOperatorTwo,
      final Integer numberTwo,
      final BigDecimal organizationInsidePrice,
      final BigDecimal organizationOutsidePrice
   ) {
      this.id = id;
      this.groupWeldingConfigId = groupWeldingConfigId;
      this.comparisonOperatorOne = comparisonOperatorOne;
      this.numberOne = numberOne;
      this.comparisonOperatorTwo = comparisonOperatorTwo;
      this.numberTwo = numberTwo;
      this.organizationInsidePrice = organizationInsidePrice;
      this.organizationOutsidePrice = organizationOutsidePrice;
   }

   public Long getId() {
      return this.id;
   }

   public Long getGroupWeldingConfigId() {
      return this.groupWeldingConfigId;
   }

   public Integer getComparisonOperatorOne() {
      return this.comparisonOperatorOne;
   }

   public Integer getNumberOne() {
      return this.numberOne;
   }

   public Integer getComparisonOperatorTwo() {
      return this.comparisonOperatorTwo;
   }

   public Integer getNumberTwo() {
      return this.numberTwo;
   }

   public BigDecimal getOrganizationInsidePrice() {
      return this.organizationInsidePrice;
   }

   public BigDecimal getOrganizationOutsidePrice() {
      return this.organizationOutsidePrice;
   }

   public MesGroupWeldingConfigDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesGroupWeldingConfigDetail setGroupWeldingConfigId(final Long groupWeldingConfigId) {
      this.groupWeldingConfigId = groupWeldingConfigId;
      return this;
   }

   public MesGroupWeldingConfigDetail setComparisonOperatorOne(final Integer comparisonOperatorOne) {
      this.comparisonOperatorOne = comparisonOperatorOne;
      return this;
   }

   public MesGroupWeldingConfigDetail setNumberOne(final Integer numberOne) {
      this.numberOne = numberOne;
      return this;
   }

   public MesGroupWeldingConfigDetail setComparisonOperatorTwo(final Integer comparisonOperatorTwo) {
      this.comparisonOperatorTwo = comparisonOperatorTwo;
      return this;
   }

   public MesGroupWeldingConfigDetail setNumberTwo(final Integer numberTwo) {
      this.numberTwo = numberTwo;
      return this;
   }

   public MesGroupWeldingConfigDetail setOrganizationInsidePrice(final BigDecimal organizationInsidePrice) {
      this.organizationInsidePrice = organizationInsidePrice;
      return this;
   }

   public MesGroupWeldingConfigDetail setOrganizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
      this.organizationOutsidePrice = organizationOutsidePrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesGroupWeldingConfigDetail(id="
         + this.getId()
         + ", groupWeldingConfigId="
         + this.getGroupWeldingConfigId()
         + ", comparisonOperatorOne="
         + this.getComparisonOperatorOne()
         + ", numberOne="
         + this.getNumberOne()
         + ", comparisonOperatorTwo="
         + this.getComparisonOperatorTwo()
         + ", numberTwo="
         + this.getNumberTwo()
         + ", organizationInsidePrice="
         + this.getOrganizationInsidePrice()
         + ", organizationOutsidePrice="
         + this.getOrganizationOutsidePrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesGroupWeldingConfigDetail)) {
         return false;
      }

      MesGroupWeldingConfigDetail other = (MesGroupWeldingConfigDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$groupWeldingConfigId = this.getGroupWeldingConfigId();
         Object other$groupWeldingConfigId = other.getGroupWeldingConfigId();
         if (this$groupWeldingConfigId == null ? other$groupWeldingConfigId == null : this$groupWeldingConfigId.equals(other$groupWeldingConfigId)) {
            Object this$comparisonOperatorOne = this.getComparisonOperatorOne();
            Object other$comparisonOperatorOne = other.getComparisonOperatorOne();
            if (this$comparisonOperatorOne == null ? other$comparisonOperatorOne == null : this$comparisonOperatorOne.equals(other$comparisonOperatorOne)) {
               Object this$numberOne = this.getNumberOne();
               Object other$numberOne = other.getNumberOne();
               if (this$numberOne == null ? other$numberOne == null : this$numberOne.equals(other$numberOne)) {
                  Object this$comparisonOperatorTwo = this.getComparisonOperatorTwo();
                  Object other$comparisonOperatorTwo = other.getComparisonOperatorTwo();
                  if (this$comparisonOperatorTwo == null ? other$comparisonOperatorTwo == null : this$comparisonOperatorTwo.equals(other$comparisonOperatorTwo)
                     )
                   {
                     Object this$numberTwo = this.getNumberTwo();
                     Object other$numberTwo = other.getNumberTwo();
                     if (this$numberTwo == null ? other$numberTwo == null : this$numberTwo.equals(other$numberTwo)) {
                        Object this$organizationInsidePrice = this.getOrganizationInsidePrice();
                        Object other$organizationInsidePrice = other.getOrganizationInsidePrice();
                        if (this$organizationInsidePrice == null
                           ? other$organizationInsidePrice == null
                           : this$organizationInsidePrice.equals(other$organizationInsidePrice)) {
                           Object this$organizationOutsidePrice = this.getOrganizationOutsidePrice();
                           Object other$organizationOutsidePrice = other.getOrganizationOutsidePrice();
                           return this$organizationOutsidePrice == null
                              ? other$organizationOutsidePrice == null
                              : this$organizationOutsidePrice.equals(other$organizationOutsidePrice);
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
      return other instanceof MesGroupWeldingConfigDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $groupWeldingConfigId = this.getGroupWeldingConfigId();
      result = result * 59 + ($groupWeldingConfigId == null ? 43 : $groupWeldingConfigId.hashCode());
      Object $comparisonOperatorOne = this.getComparisonOperatorOne();
      result = result * 59 + ($comparisonOperatorOne == null ? 43 : $comparisonOperatorOne.hashCode());
      Object $numberOne = this.getNumberOne();
      result = result * 59 + ($numberOne == null ? 43 : $numberOne.hashCode());
      Object $comparisonOperatorTwo = this.getComparisonOperatorTwo();
      result = result * 59 + ($comparisonOperatorTwo == null ? 43 : $comparisonOperatorTwo.hashCode());
      Object $numberTwo = this.getNumberTwo();
      result = result * 59 + ($numberTwo == null ? 43 : $numberTwo.hashCode());
      Object $organizationInsidePrice = this.getOrganizationInsidePrice();
      result = result * 59 + ($organizationInsidePrice == null ? 43 : $organizationInsidePrice.hashCode());
      Object $organizationOutsidePrice = this.getOrganizationOutsidePrice();
      return result * 59 + ($organizationOutsidePrice == null ? 43 : $organizationOutsidePrice.hashCode());
   }

   public static class MesGroupWeldingConfigDetailBuilder {
      private Long id;
      private Long groupWeldingConfigId;
      private Integer comparisonOperatorOne;
      private Integer numberOne;
      private Integer comparisonOperatorTwo;
      private Integer numberTwo;
      private BigDecimal organizationInsidePrice;
      private BigDecimal organizationOutsidePrice;

      MesGroupWeldingConfigDetailBuilder() {
      }

      public MesGroupWeldingConfigDetail.MesGroupWeldingConfigDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesGroupWeldingConfigDetail.MesGroupWeldingConfigDetailBuilder groupWeldingConfigId(final Long groupWeldingConfigId) {
         this.groupWeldingConfigId = groupWeldingConfigId;
         return this;
      }

      public MesGroupWeldingConfigDetail.MesGroupWeldingConfigDetailBuilder comparisonOperatorOne(final Integer comparisonOperatorOne) {
         this.comparisonOperatorOne = comparisonOperatorOne;
         return this;
      }

      public MesGroupWeldingConfigDetail.MesGroupWeldingConfigDetailBuilder numberOne(final Integer numberOne) {
         this.numberOne = numberOne;
         return this;
      }

      public MesGroupWeldingConfigDetail.MesGroupWeldingConfigDetailBuilder comparisonOperatorTwo(final Integer comparisonOperatorTwo) {
         this.comparisonOperatorTwo = comparisonOperatorTwo;
         return this;
      }

      public MesGroupWeldingConfigDetail.MesGroupWeldingConfigDetailBuilder numberTwo(final Integer numberTwo) {
         this.numberTwo = numberTwo;
         return this;
      }

      public MesGroupWeldingConfigDetail.MesGroupWeldingConfigDetailBuilder organizationInsidePrice(final BigDecimal organizationInsidePrice) {
         this.organizationInsidePrice = organizationInsidePrice;
         return this;
      }

      public MesGroupWeldingConfigDetail.MesGroupWeldingConfigDetailBuilder organizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
         this.organizationOutsidePrice = organizationOutsidePrice;
         return this;
      }

      public MesGroupWeldingConfigDetail build() {
         return new MesGroupWeldingConfigDetail(
            this.id,
            this.groupWeldingConfigId,
            this.comparisonOperatorOne,
            this.numberOne,
            this.comparisonOperatorTwo,
            this.numberTwo,
            this.organizationInsidePrice,
            this.organizationOutsidePrice
         );
      }

      @Override
      public String toString() {
         return "MesGroupWeldingConfigDetail.MesGroupWeldingConfigDetailBuilder(id="
            + this.id
            + ", groupWeldingConfigId="
            + this.groupWeldingConfigId
            + ", comparisonOperatorOne="
            + this.comparisonOperatorOne
            + ", numberOne="
            + this.numberOne
            + ", comparisonOperatorTwo="
            + this.comparisonOperatorTwo
            + ", numberTwo="
            + this.numberTwo
            + ", organizationInsidePrice="
            + this.organizationInsidePrice
            + ", organizationOutsidePrice="
            + this.organizationOutsidePrice
            + ")";
      }
   }
}
