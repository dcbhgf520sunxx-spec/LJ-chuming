package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

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

@ApiModel(value = "WmsSectionSteelControlTable对象", description = "mes截面规格对照表")
@Entity
@TableName("wms_section_steel_control_table")
@Table(name = "wms_section_steel_control_table")
@org.hibernate.annotations.Table(appliesTo = "wms_section_steel_control_table", comment = "mes截面规格对照表")
public class WmsSectionSteelControlTable extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(1000)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "mesSectionSpecification", value = "mes截面", notes = "mes截面")
   @TableField("mes_section_specification")
   @Column(name = "mes_section_specification", columnDefinition = "varchar(255)  COMMENT 'mes截面'", nullable = true)
   private String mesSectionSpecification;
   @ApiModelProperty(name = "wmsClassifyId", value = "wms科目ID", notes = "wms科目ID")
   @TableField("wms_classify_id")
   @Column(name = "wms_classify_id", columnDefinition = "bigint  COMMENT 'wms科目ID'", nullable = true)
   private Long wmsClassifyId;
   @ApiModelProperty(name = "errorA", value = "误差a", notes = "误差a")
   @TableField("error_a")
   @Column(name = "error_a", columnDefinition = "decimal(10,0)  COMMENT '误差a'", nullable = true)
   private BigDecimal errorA;
   @ApiModelProperty(name = "errorB", value = "误差b", notes = "误差b")
   @TableField("error_b")
   @Column(name = "error_b", columnDefinition = "decimal(10,0)  COMMENT '误差b'", nullable = true)
   private BigDecimal errorB;
   @ApiModelProperty(name = "errorD", value = "误差d", notes = "误差d")
   @TableField("error_d")
   @Column(name = "error_d", columnDefinition = "decimal(10,0)  COMMENT '误差d'", nullable = true)
   private BigDecimal errorD;
   @ApiModelProperty(name = "errorH", value = "误差h", notes = "误差h")
   @TableField("error_h")
   @Column(name = "error_h", columnDefinition = "decimal(10,0)  COMMENT '误差h'", nullable = true)
   private BigDecimal errorH;
   @ApiModelProperty(name = "errorT", value = "误差t", notes = "误差t")
   @TableField("error_t")
   @Column(name = "error_t", columnDefinition = "decimal(10,0)  COMMENT '误差t'", nullable = true)
   private BigDecimal errorT;
   @ApiModelProperty(name = "errorS", value = "误差s", notes = "误差s")
   @TableField("error_s")
   @Column(name = "error_s", columnDefinition = "decimal(10,0)  COMMENT '误差s'", nullable = true)
   private BigDecimal errorS;
   @ApiModelProperty(name = "errorBigB", value = "误差B", notes = "误差B")
   @TableField("error_big_b")
   @Column(name = "error_big_b", columnDefinition = "decimal(10,0)  COMMENT '误差B'", nullable = true)
   private BigDecimal errorBigB;
   @ApiModelProperty(name = "errorBigD", value = "误差D", notes = "误差D")
   @TableField("error_big_d")
   @Column(name = "error_big_d", columnDefinition = "decimal(10,0)  COMMENT '误差D'", nullable = true)
   private BigDecimal errorBigD;
   @ApiModelProperty(name = "errorBigH", value = "误差H", notes = "误差H")
   @TableField("error_big_h")
   @Column(name = "error_big_h", columnDefinition = "decimal(10,0)  COMMENT '误差H'", nullable = true)
   private BigDecimal errorBigH;
   @ApiModelProperty(name = "errorBigT", value = "误差T", notes = "误差T")
   @TableField("error_big_t")
   @Column(name = "error_big_t", columnDefinition = "decimal(10,0)  COMMENT '误差T'", nullable = true)
   private BigDecimal errorBigT;
   @ApiModelProperty(name = "errorBigS", value = "误差S", notes = "误差S")
   @TableField("error_big_s")
   @Column(name = "error_big_s", columnDefinition = "decimal(10,0)  COMMENT '误差S'", nullable = true)
   private BigDecimal errorBigS;
   @ApiModelProperty(name = "image", value = "构件图片路径", notes = "构件图片路径")
   @TableField("image")
   @Column(name = "image", columnDefinition = "varchar(1024)  COMMENT '构件图片路径'", nullable = false)
   private String image;
   @ApiModelProperty(name = "errorType", value = "误差顺序", notes = "误差顺序")
   @TableField("error_type")
   @Column(name = "error_type", columnDefinition = "varchar(255)  COMMENT '误差顺序'", nullable = true)
   private String errorType;
   private Integer basicClass;
   private Integer mesProductEnum;

   public static WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder builder() {
      return new WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder();
   }

   public WmsSectionSteelControlTable() {
   }

   public WmsSectionSteelControlTable(
      final Long id,
      final String name,
      final String mesSectionSpecification,
      final Long wmsClassifyId,
      final BigDecimal errorA,
      final BigDecimal errorB,
      final BigDecimal errorD,
      final BigDecimal errorH,
      final BigDecimal errorT,
      final BigDecimal errorS,
      final BigDecimal errorBigB,
      final BigDecimal errorBigD,
      final BigDecimal errorBigH,
      final BigDecimal errorBigT,
      final BigDecimal errorBigS,
      final String image,
      final String errorType,
      final Integer basicClass,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.name = name;
      this.mesSectionSpecification = mesSectionSpecification;
      this.wmsClassifyId = wmsClassifyId;
      this.errorA = errorA;
      this.errorB = errorB;
      this.errorD = errorD;
      this.errorH = errorH;
      this.errorT = errorT;
      this.errorS = errorS;
      this.errorBigB = errorBigB;
      this.errorBigD = errorBigD;
      this.errorBigH = errorBigH;
      this.errorBigT = errorBigT;
      this.errorBigS = errorBigS;
      this.image = image;
      this.errorType = errorType;
      this.basicClass = basicClass;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getMesSectionSpecification() {
      return this.mesSectionSpecification;
   }

   public Long getWmsClassifyId() {
      return this.wmsClassifyId;
   }

   public BigDecimal getErrorA() {
      return this.errorA;
   }

   public BigDecimal getErrorB() {
      return this.errorB;
   }

   public BigDecimal getErrorD() {
      return this.errorD;
   }

   public BigDecimal getErrorH() {
      return this.errorH;
   }

   public BigDecimal getErrorT() {
      return this.errorT;
   }

   public BigDecimal getErrorS() {
      return this.errorS;
   }

   public BigDecimal getErrorBigB() {
      return this.errorBigB;
   }

   public BigDecimal getErrorBigD() {
      return this.errorBigD;
   }

   public BigDecimal getErrorBigH() {
      return this.errorBigH;
   }

   public BigDecimal getErrorBigT() {
      return this.errorBigT;
   }

   public BigDecimal getErrorBigS() {
      return this.errorBigS;
   }

   public String getImage() {
      return this.image;
   }

   public String getErrorType() {
      return this.errorType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public WmsSectionSteelControlTable setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsSectionSteelControlTable setName(final String name) {
      this.name = name;
      return this;
   }

   public WmsSectionSteelControlTable setMesSectionSpecification(final String mesSectionSpecification) {
      this.mesSectionSpecification = mesSectionSpecification;
      return this;
   }

   public WmsSectionSteelControlTable setWmsClassifyId(final Long wmsClassifyId) {
      this.wmsClassifyId = wmsClassifyId;
      return this;
   }

   public WmsSectionSteelControlTable setErrorA(final BigDecimal errorA) {
      this.errorA = errorA;
      return this;
   }

   public WmsSectionSteelControlTable setErrorB(final BigDecimal errorB) {
      this.errorB = errorB;
      return this;
   }

   public WmsSectionSteelControlTable setErrorD(final BigDecimal errorD) {
      this.errorD = errorD;
      return this;
   }

   public WmsSectionSteelControlTable setErrorH(final BigDecimal errorH) {
      this.errorH = errorH;
      return this;
   }

   public WmsSectionSteelControlTable setErrorT(final BigDecimal errorT) {
      this.errorT = errorT;
      return this;
   }

   public WmsSectionSteelControlTable setErrorS(final BigDecimal errorS) {
      this.errorS = errorS;
      return this;
   }

   public WmsSectionSteelControlTable setErrorBigB(final BigDecimal errorBigB) {
      this.errorBigB = errorBigB;
      return this;
   }

   public WmsSectionSteelControlTable setErrorBigD(final BigDecimal errorBigD) {
      this.errorBigD = errorBigD;
      return this;
   }

   public WmsSectionSteelControlTable setErrorBigH(final BigDecimal errorBigH) {
      this.errorBigH = errorBigH;
      return this;
   }

   public WmsSectionSteelControlTable setErrorBigT(final BigDecimal errorBigT) {
      this.errorBigT = errorBigT;
      return this;
   }

   public WmsSectionSteelControlTable setErrorBigS(final BigDecimal errorBigS) {
      this.errorBigS = errorBigS;
      return this;
   }

   public WmsSectionSteelControlTable setImage(final String image) {
      this.image = image;
      return this;
   }

   public WmsSectionSteelControlTable setErrorType(final String errorType) {
      this.errorType = errorType;
      return this;
   }

   public WmsSectionSteelControlTable setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public WmsSectionSteelControlTable setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "WmsSectionSteelControlTable(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", mesSectionSpecification="
         + this.getMesSectionSpecification()
         + ", wmsClassifyId="
         + this.getWmsClassifyId()
         + ", errorA="
         + this.getErrorA()
         + ", errorB="
         + this.getErrorB()
         + ", errorD="
         + this.getErrorD()
         + ", errorH="
         + this.getErrorH()
         + ", errorT="
         + this.getErrorT()
         + ", errorS="
         + this.getErrorS()
         + ", errorBigB="
         + this.getErrorBigB()
         + ", errorBigD="
         + this.getErrorBigD()
         + ", errorBigH="
         + this.getErrorBigH()
         + ", errorBigT="
         + this.getErrorBigT()
         + ", errorBigS="
         + this.getErrorBigS()
         + ", image="
         + this.getImage()
         + ", errorType="
         + this.getErrorType()
         + ", basicClass="
         + this.getBasicClass()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsSectionSteelControlTable)) {
         return false;
      }

      WmsSectionSteelControlTable other = (WmsSectionSteelControlTable)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$wmsClassifyId = this.getWmsClassifyId();
         Object other$wmsClassifyId = other.getWmsClassifyId();
         if (this$wmsClassifyId == null ? other$wmsClassifyId == null : this$wmsClassifyId.equals(other$wmsClassifyId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$mesProductEnum = this.getMesProductEnum();
               Object other$mesProductEnum = other.getMesProductEnum();
               if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$mesSectionSpecification = this.getMesSectionSpecification();
                     Object other$mesSectionSpecification = other.getMesSectionSpecification();
                     if (this$mesSectionSpecification == null
                        ? other$mesSectionSpecification == null
                        : this$mesSectionSpecification.equals(other$mesSectionSpecification)) {
                        Object this$errorA = this.getErrorA();
                        Object other$errorA = other.getErrorA();
                        if (this$errorA == null ? other$errorA == null : this$errorA.equals(other$errorA)) {
                           Object this$errorB = this.getErrorB();
                           Object other$errorB = other.getErrorB();
                           if (this$errorB == null ? other$errorB == null : this$errorB.equals(other$errorB)) {
                              Object this$errorD = this.getErrorD();
                              Object other$errorD = other.getErrorD();
                              if (this$errorD == null ? other$errorD == null : this$errorD.equals(other$errorD)) {
                                 Object this$errorH = this.getErrorH();
                                 Object other$errorH = other.getErrorH();
                                 if (this$errorH == null ? other$errorH == null : this$errorH.equals(other$errorH)) {
                                    Object this$errorT = this.getErrorT();
                                    Object other$errorT = other.getErrorT();
                                    if (this$errorT == null ? other$errorT == null : this$errorT.equals(other$errorT)) {
                                       Object this$errorS = this.getErrorS();
                                       Object other$errorS = other.getErrorS();
                                       if (this$errorS == null ? other$errorS == null : this$errorS.equals(other$errorS)) {
                                          Object this$errorBigB = this.getErrorBigB();
                                          Object other$errorBigB = other.getErrorBigB();
                                          if (this$errorBigB == null ? other$errorBigB == null : this$errorBigB.equals(other$errorBigB)) {
                                             Object this$errorBigD = this.getErrorBigD();
                                             Object other$errorBigD = other.getErrorBigD();
                                             if (this$errorBigD == null ? other$errorBigD == null : this$errorBigD.equals(other$errorBigD)) {
                                                Object this$errorBigH = this.getErrorBigH();
                                                Object other$errorBigH = other.getErrorBigH();
                                                if (this$errorBigH == null ? other$errorBigH == null : this$errorBigH.equals(other$errorBigH)) {
                                                   Object this$errorBigT = this.getErrorBigT();
                                                   Object other$errorBigT = other.getErrorBigT();
                                                   if (this$errorBigT == null ? other$errorBigT == null : this$errorBigT.equals(other$errorBigT)) {
                                                      Object this$errorBigS = this.getErrorBigS();
                                                      Object other$errorBigS = other.getErrorBigS();
                                                      if (this$errorBigS == null ? other$errorBigS == null : this$errorBigS.equals(other$errorBigS)) {
                                                         Object this$image = this.getImage();
                                                         Object other$image = other.getImage();
                                                         if (this$image == null ? other$image == null : this$image.equals(other$image)) {
                                                            Object this$errorType = this.getErrorType();
                                                            Object other$errorType = other.getErrorType();
                                                            return this$errorType == null ? other$errorType == null : this$errorType.equals(other$errorType);
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
      return other instanceof WmsSectionSteelControlTable;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $wmsClassifyId = this.getWmsClassifyId();
      result = result * 59 + ($wmsClassifyId == null ? 43 : $wmsClassifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $mesSectionSpecification = this.getMesSectionSpecification();
      result = result * 59 + ($mesSectionSpecification == null ? 43 : $mesSectionSpecification.hashCode());
      Object $errorA = this.getErrorA();
      result = result * 59 + ($errorA == null ? 43 : $errorA.hashCode());
      Object $errorB = this.getErrorB();
      result = result * 59 + ($errorB == null ? 43 : $errorB.hashCode());
      Object $errorD = this.getErrorD();
      result = result * 59 + ($errorD == null ? 43 : $errorD.hashCode());
      Object $errorH = this.getErrorH();
      result = result * 59 + ($errorH == null ? 43 : $errorH.hashCode());
      Object $errorT = this.getErrorT();
      result = result * 59 + ($errorT == null ? 43 : $errorT.hashCode());
      Object $errorS = this.getErrorS();
      result = result * 59 + ($errorS == null ? 43 : $errorS.hashCode());
      Object $errorBigB = this.getErrorBigB();
      result = result * 59 + ($errorBigB == null ? 43 : $errorBigB.hashCode());
      Object $errorBigD = this.getErrorBigD();
      result = result * 59 + ($errorBigD == null ? 43 : $errorBigD.hashCode());
      Object $errorBigH = this.getErrorBigH();
      result = result * 59 + ($errorBigH == null ? 43 : $errorBigH.hashCode());
      Object $errorBigT = this.getErrorBigT();
      result = result * 59 + ($errorBigT == null ? 43 : $errorBigT.hashCode());
      Object $errorBigS = this.getErrorBigS();
      result = result * 59 + ($errorBigS == null ? 43 : $errorBigS.hashCode());
      Object $image = this.getImage();
      result = result * 59 + ($image == null ? 43 : $image.hashCode());
      Object $errorType = this.getErrorType();
      return result * 59 + ($errorType == null ? 43 : $errorType.hashCode());
   }

   public static class WmsSectionSteelControlTableBuilder {
      private Long id;
      private String name;
      private String mesSectionSpecification;
      private Long wmsClassifyId;
      private BigDecimal errorA;
      private BigDecimal errorB;
      private BigDecimal errorD;
      private BigDecimal errorH;
      private BigDecimal errorT;
      private BigDecimal errorS;
      private BigDecimal errorBigB;
      private BigDecimal errorBigD;
      private BigDecimal errorBigH;
      private BigDecimal errorBigT;
      private BigDecimal errorBigS;
      private String image;
      private String errorType;
      private Integer basicClass;
      private Integer mesProductEnum;

      WmsSectionSteelControlTableBuilder() {
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder mesSectionSpecification(final String mesSectionSpecification) {
         this.mesSectionSpecification = mesSectionSpecification;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder wmsClassifyId(final Long wmsClassifyId) {
         this.wmsClassifyId = wmsClassifyId;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder errorA(final BigDecimal errorA) {
         this.errorA = errorA;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder errorB(final BigDecimal errorB) {
         this.errorB = errorB;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder errorD(final BigDecimal errorD) {
         this.errorD = errorD;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder errorH(final BigDecimal errorH) {
         this.errorH = errorH;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder errorT(final BigDecimal errorT) {
         this.errorT = errorT;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder errorS(final BigDecimal errorS) {
         this.errorS = errorS;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder errorBigB(final BigDecimal errorBigB) {
         this.errorBigB = errorBigB;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder errorBigD(final BigDecimal errorBigD) {
         this.errorBigD = errorBigD;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder errorBigH(final BigDecimal errorBigH) {
         this.errorBigH = errorBigH;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder errorBigT(final BigDecimal errorBigT) {
         this.errorBigT = errorBigT;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder errorBigS(final BigDecimal errorBigS) {
         this.errorBigS = errorBigS;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder image(final String image) {
         this.image = image;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder errorType(final String errorType) {
         this.errorType = errorType;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public WmsSectionSteelControlTable build() {
         return new WmsSectionSteelControlTable(
            this.id,
            this.name,
            this.mesSectionSpecification,
            this.wmsClassifyId,
            this.errorA,
            this.errorB,
            this.errorD,
            this.errorH,
            this.errorT,
            this.errorS,
            this.errorBigB,
            this.errorBigD,
            this.errorBigH,
            this.errorBigT,
            this.errorBigS,
            this.image,
            this.errorType,
            this.basicClass,
            this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "WmsSectionSteelControlTable.WmsSectionSteelControlTableBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", mesSectionSpecification="
            + this.mesSectionSpecification
            + ", wmsClassifyId="
            + this.wmsClassifyId
            + ", errorA="
            + this.errorA
            + ", errorB="
            + this.errorB
            + ", errorD="
            + this.errorD
            + ", errorH="
            + this.errorH
            + ", errorT="
            + this.errorT
            + ", errorS="
            + this.errorS
            + ", errorBigB="
            + this.errorBigB
            + ", errorBigD="
            + this.errorBigD
            + ", errorBigH="
            + this.errorBigH
            + ", errorBigT="
            + this.errorBigT
            + ", errorBigS="
            + this.errorBigS
            + ", image="
            + this.image
            + ", errorType="
            + this.errorType
            + ", basicClass="
            + this.basicClass
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
