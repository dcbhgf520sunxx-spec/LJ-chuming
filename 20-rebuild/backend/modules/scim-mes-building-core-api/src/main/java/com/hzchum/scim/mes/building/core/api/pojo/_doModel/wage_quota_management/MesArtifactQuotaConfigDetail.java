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

@ApiModel(value = "MesArtifactQuotaConfigDetail对象", description = "构件定额配置详情表")
@Entity
@TableName("mes_artifact_quota_config_detail")
@Table(name = "mes_artifact_quota_config_detail")
@org.hibernate.annotations.Table(appliesTo = "mes_artifact_quota_config_detail", comment = "构件定额配置详情表")
public class MesArtifactQuotaConfigDetail extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("构件定额配置ID")
   @TableField("artifact_quota_config_id")
   @Column(name = "artifact_quota_config_id", columnDefinition = "bigint(20)  COMMENT '构件定额配置ID'", nullable = true)
   private Long artifactQuotaConfigId;
   @ApiModelProperty("比较运算符1")
   @TableField("comparison_operator_one")
   @Column(name = "comparison_operator_one", columnDefinition = "int(11)  COMMENT '比较运算符1'", nullable = true)
   private Integer comparisonOperatorOne;
   @ApiModelProperty("数字1")
   @TableField("number_one")
   @Column(name = "number_one", columnDefinition = "decimal(32,8) COMMENT '数字1'", nullable = true)
   private BigDecimal numberOne;
   @ApiModelProperty("比较运算符2")
   @TableField("comparison_operator_two")
   @Column(name = "comparison_operator_two", columnDefinition = "int(11)  COMMENT '比较运算符2'", nullable = true)
   private Integer comparisonOperatorTwo;
   @ApiModelProperty("数字2")
   @TableField("number_two")
   @Column(name = "number_two", columnDefinition = "decimal(32,8)  COMMENT '数字2'", nullable = true)
   private BigDecimal numberTwo;
   @ApiModelProperty("单价(元)")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8) COMMENT '单价(元)'", nullable = true)
   private BigDecimal price;

   public static MesArtifactQuotaConfigDetail.MesArtifactQuotaConfigDetailBuilder builder() {
      return new MesArtifactQuotaConfigDetail.MesArtifactQuotaConfigDetailBuilder();
   }

   public MesArtifactQuotaConfigDetail() {
   }

   public MesArtifactQuotaConfigDetail(
      final Long id,
      final Long artifactQuotaConfigId,
      final Integer comparisonOperatorOne,
      final BigDecimal numberOne,
      final Integer comparisonOperatorTwo,
      final BigDecimal numberTwo,
      final BigDecimal price
   ) {
      this.id = id;
      this.artifactQuotaConfigId = artifactQuotaConfigId;
      this.comparisonOperatorOne = comparisonOperatorOne;
      this.numberOne = numberOne;
      this.comparisonOperatorTwo = comparisonOperatorTwo;
      this.numberTwo = numberTwo;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public Long getArtifactQuotaConfigId() {
      return this.artifactQuotaConfigId;
   }

   public Integer getComparisonOperatorOne() {
      return this.comparisonOperatorOne;
   }

   public BigDecimal getNumberOne() {
      return this.numberOne;
   }

   public Integer getComparisonOperatorTwo() {
      return this.comparisonOperatorTwo;
   }

   public BigDecimal getNumberTwo() {
      return this.numberTwo;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public MesArtifactQuotaConfigDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesArtifactQuotaConfigDetail setArtifactQuotaConfigId(final Long artifactQuotaConfigId) {
      this.artifactQuotaConfigId = artifactQuotaConfigId;
      return this;
   }

   public MesArtifactQuotaConfigDetail setComparisonOperatorOne(final Integer comparisonOperatorOne) {
      this.comparisonOperatorOne = comparisonOperatorOne;
      return this;
   }

   public MesArtifactQuotaConfigDetail setNumberOne(final BigDecimal numberOne) {
      this.numberOne = numberOne;
      return this;
   }

   public MesArtifactQuotaConfigDetail setComparisonOperatorTwo(final Integer comparisonOperatorTwo) {
      this.comparisonOperatorTwo = comparisonOperatorTwo;
      return this;
   }

   public MesArtifactQuotaConfigDetail setNumberTwo(final BigDecimal numberTwo) {
      this.numberTwo = numberTwo;
      return this;
   }

   public MesArtifactQuotaConfigDetail setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesArtifactQuotaConfigDetail(id="
         + this.getId()
         + ", artifactQuotaConfigId="
         + this.getArtifactQuotaConfigId()
         + ", comparisonOperatorOne="
         + this.getComparisonOperatorOne()
         + ", numberOne="
         + this.getNumberOne()
         + ", comparisonOperatorTwo="
         + this.getComparisonOperatorTwo()
         + ", numberTwo="
         + this.getNumberTwo()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesArtifactQuotaConfigDetail)) {
         return false;
      }

      MesArtifactQuotaConfigDetail other = (MesArtifactQuotaConfigDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactQuotaConfigId = this.getArtifactQuotaConfigId();
         Object other$artifactQuotaConfigId = other.getArtifactQuotaConfigId();
         if (this$artifactQuotaConfigId == null ? other$artifactQuotaConfigId == null : this$artifactQuotaConfigId.equals(other$artifactQuotaConfigId)) {
            Object this$comparisonOperatorOne = this.getComparisonOperatorOne();
            Object other$comparisonOperatorOne = other.getComparisonOperatorOne();
            if (this$comparisonOperatorOne == null ? other$comparisonOperatorOne == null : this$comparisonOperatorOne.equals(other$comparisonOperatorOne)) {
               Object this$comparisonOperatorTwo = this.getComparisonOperatorTwo();
               Object other$comparisonOperatorTwo = other.getComparisonOperatorTwo();
               if (this$comparisonOperatorTwo == null ? other$comparisonOperatorTwo == null : this$comparisonOperatorTwo.equals(other$comparisonOperatorTwo)) {
                  Object this$numberOne = this.getNumberOne();
                  Object other$numberOne = other.getNumberOne();
                  if (this$numberOne == null ? other$numberOne == null : this$numberOne.equals(other$numberOne)) {
                     Object this$numberTwo = this.getNumberTwo();
                     Object other$numberTwo = other.getNumberTwo();
                     if (this$numberTwo == null ? other$numberTwo == null : this$numberTwo.equals(other$numberTwo)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesArtifactQuotaConfigDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactQuotaConfigId = this.getArtifactQuotaConfigId();
      result = result * 59 + ($artifactQuotaConfigId == null ? 43 : $artifactQuotaConfigId.hashCode());
      Object $comparisonOperatorOne = this.getComparisonOperatorOne();
      result = result * 59 + ($comparisonOperatorOne == null ? 43 : $comparisonOperatorOne.hashCode());
      Object $comparisonOperatorTwo = this.getComparisonOperatorTwo();
      result = result * 59 + ($comparisonOperatorTwo == null ? 43 : $comparisonOperatorTwo.hashCode());
      Object $numberOne = this.getNumberOne();
      result = result * 59 + ($numberOne == null ? 43 : $numberOne.hashCode());
      Object $numberTwo = this.getNumberTwo();
      result = result * 59 + ($numberTwo == null ? 43 : $numberTwo.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesArtifactQuotaConfigDetailBuilder {
      private Long id;
      private Long artifactQuotaConfigId;
      private Integer comparisonOperatorOne;
      private BigDecimal numberOne;
      private Integer comparisonOperatorTwo;
      private BigDecimal numberTwo;
      private BigDecimal price;

      MesArtifactQuotaConfigDetailBuilder() {
      }

      public MesArtifactQuotaConfigDetail.MesArtifactQuotaConfigDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesArtifactQuotaConfigDetail.MesArtifactQuotaConfigDetailBuilder artifactQuotaConfigId(final Long artifactQuotaConfigId) {
         this.artifactQuotaConfigId = artifactQuotaConfigId;
         return this;
      }

      public MesArtifactQuotaConfigDetail.MesArtifactQuotaConfigDetailBuilder comparisonOperatorOne(final Integer comparisonOperatorOne) {
         this.comparisonOperatorOne = comparisonOperatorOne;
         return this;
      }

      public MesArtifactQuotaConfigDetail.MesArtifactQuotaConfigDetailBuilder numberOne(final BigDecimal numberOne) {
         this.numberOne = numberOne;
         return this;
      }

      public MesArtifactQuotaConfigDetail.MesArtifactQuotaConfigDetailBuilder comparisonOperatorTwo(final Integer comparisonOperatorTwo) {
         this.comparisonOperatorTwo = comparisonOperatorTwo;
         return this;
      }

      public MesArtifactQuotaConfigDetail.MesArtifactQuotaConfigDetailBuilder numberTwo(final BigDecimal numberTwo) {
         this.numberTwo = numberTwo;
         return this;
      }

      public MesArtifactQuotaConfigDetail.MesArtifactQuotaConfigDetailBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesArtifactQuotaConfigDetail build() {
         return new MesArtifactQuotaConfigDetail(
            this.id, this.artifactQuotaConfigId, this.comparisonOperatorOne, this.numberOne, this.comparisonOperatorTwo, this.numberTwo, this.price
         );
      }

      @Override
      public String toString() {
         return "MesArtifactQuotaConfigDetail.MesArtifactQuotaConfigDetailBuilder(id="
            + this.id
            + ", artifactQuotaConfigId="
            + this.artifactQuotaConfigId
            + ", comparisonOperatorOne="
            + this.comparisonOperatorOne
            + ", numberOne="
            + this.numberOne
            + ", comparisonOperatorTwo="
            + this.comparisonOperatorTwo
            + ", numberTwo="
            + this.numberTwo
            + ", price="
            + this.price
            + ")";
      }
   }
}
