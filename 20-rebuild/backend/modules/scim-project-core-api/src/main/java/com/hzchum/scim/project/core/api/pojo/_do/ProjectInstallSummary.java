package com.hzchum.scim.project.core.api.pojo._do;

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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ProjectInstallSummary对象", description = "项目安装汇总表 ")
@Entity
@TableName("project_install_summary")
@Table(name = "project_install_summary")
@org.hibernate.annotations.Table(appliesTo = "project_install_summary", comment = "项目安装汇总表 ")
public class ProjectInstallSummary extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域ID'")
   private Long areaId;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢项目 2桥梁项目 4立体停车库", notes = "项目类型 1建钢项目 2桥梁项目 4立体停车库")
   @TableField("project_type")
   @Column(name = "project_type", columnDefinition = "int(11) default 1  COMMENT '项目类型 1建钢项目 2桥梁项目 4立体停车库'", nullable = false)
   private Integer projectType;
   @ApiModelProperty(name = "productType", value = "产品类型(2,4,8)", notes = "产品类型(2,4,8)")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型(2,4,8)'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "category", value = "围护类型", notes = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11)  COMMENT '围护类型'")
   private Integer category;
   @ApiModelProperty(name = "productId", value = "产品ID(构件、围护、配套件id)", notes = "产品ID(构件、围护、配套件id)")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品ID(构件、围护、配套件id)'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '产品名称'")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(64)  COMMENT '产品编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(64)  COMMENT '规格'")
   private String specification;
   @ApiModelProperty(name = "actualQuantity", value = "实际数量", notes = "实际数量")
   @JsonProperty("actualQuantity")
   @JSONField(name = "actualQuantity")
   @TableField("actual_quantity")
   @Column(name = "actual_quantity", columnDefinition = "DECIMAL(18,4)  COMMENT '实际数量'", nullable = false)
   private BigDecimal actualQuantity;
   @ApiModelProperty(name = "actualMete", value = "实际量(重量kg/长度m)", notes = "实际量(重量kg/长度m)")
   @JsonProperty("actualMete")
   @JSONField(name = "actualMete")
   @TableField("actual_mete")
   @Column(name = "actual_mete", columnDefinition = "decimal(32,8)  COMMENT '实际量(重量kg/长度m)'", nullable = false)
   private BigDecimal actualMete;
   @ApiModelProperty(name = "actualTotalArea", value = "实际安装面积(mm2)", notes = "实际安装面积(mm2)")
   @JsonProperty("actualTotalArea")
   @JSONField(name = "actualTotalArea")
   @TableField("actual_total_area")
   @Column(name = "actual_total_area", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '实际安装面积(mm2)'")
   private BigDecimal actualTotalArea;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(64)  COMMENT '计量单位'")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(64)  COMMENT '核算单位'")
   private String accountingUnit;

   public static ProjectInstallSummary.ProjectInstallSummaryBuilder builder() {
      return new ProjectInstallSummary.ProjectInstallSummaryBuilder();
   }

   public ProjectInstallSummary() {
   }

   public ProjectInstallSummary(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer projectType,
      final Integer productType,
      final Integer category,
      final Long productId,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal actualQuantity,
      final BigDecimal actualMete,
      final BigDecimal actualTotalArea,
      final String measureUnit,
      final String accountingUnit
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.projectType = projectType;
      this.productType = productType;
      this.category = category;
      this.productId = productId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.actualQuantity = actualQuantity;
      this.actualMete = actualMete;
      this.actualTotalArea = actualTotalArea;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
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

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getActualQuantity() {
      return this.actualQuantity;
   }

   public BigDecimal getActualMete() {
      return this.actualMete;
   }

   public BigDecimal getActualTotalArea() {
      return this.actualTotalArea;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   @JsonProperty("id")
   public ProjectInstallSummary setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public ProjectInstallSummary setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ProjectInstallSummary setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ProjectInstallSummary setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public ProjectInstallSummary setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   @JsonProperty("productType")
   public ProjectInstallSummary setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("category")
   public ProjectInstallSummary setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("productId")
   public ProjectInstallSummary setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("name")
   public ProjectInstallSummary setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProjectInstallSummary setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ProjectInstallSummary setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("actualQuantity")
   public ProjectInstallSummary setActualQuantity(final BigDecimal actualQuantity) {
      this.actualQuantity = actualQuantity;
      return this;
   }

   @JsonProperty("actualMete")
   public ProjectInstallSummary setActualMete(final BigDecimal actualMete) {
      this.actualMete = actualMete;
      return this;
   }

   @JsonProperty("actualTotalArea")
   public ProjectInstallSummary setActualTotalArea(final BigDecimal actualTotalArea) {
      this.actualTotalArea = actualTotalArea;
      return this;
   }

   public ProjectInstallSummary setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public ProjectInstallSummary setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInstallSummary(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", projectType="
         + this.getProjectType()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", productId="
         + this.getProductId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", actualQuantity="
         + this.getActualQuantity()
         + ", actualMete="
         + this.getActualMete()
         + ", actualTotalArea="
         + this.getActualTotalArea()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInstallSummary)) {
         return false;
      }

      ProjectInstallSummary other = (ProjectInstallSummary)o;
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
                  Object this$projectType = this.getProjectType();
                  Object other$projectType = other.getProjectType();
                  if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$category = this.getCategory();
                        Object other$category = other.getCategory();
                        if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                           Object this$productId = this.getProductId();
                           Object other$productId = other.getProductId();
                           if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$actualQuantity = this.getActualQuantity();
                                       Object other$actualQuantity = other.getActualQuantity();
                                       if (this$actualQuantity == null ? other$actualQuantity == null : this$actualQuantity.equals(other$actualQuantity)) {
                                          Object this$actualMete = this.getActualMete();
                                          Object other$actualMete = other.getActualMete();
                                          if (this$actualMete == null ? other$actualMete == null : this$actualMete.equals(other$actualMete)) {
                                             Object this$actualTotalArea = this.getActualTotalArea();
                                             Object other$actualTotalArea = other.getActualTotalArea();
                                             if (this$actualTotalArea == null
                                                ? other$actualTotalArea == null
                                                : this$actualTotalArea.equals(other$actualTotalArea)) {
                                                Object this$measureUnit = this.getMeasureUnit();
                                                Object other$measureUnit = other.getMeasureUnit();
                                                if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                   Object this$accountingUnit = this.getAccountingUnit();
                                                   Object other$accountingUnit = other.getAccountingUnit();
                                                   return this$accountingUnit == null
                                                      ? other$accountingUnit == null
                                                      : this$accountingUnit.equals(other$accountingUnit);
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
      return other instanceof ProjectInstallSummary;
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
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $actualQuantity = this.getActualQuantity();
      result = result * 59 + ($actualQuantity == null ? 43 : $actualQuantity.hashCode());
      Object $actualMete = this.getActualMete();
      result = result * 59 + ($actualMete == null ? 43 : $actualMete.hashCode());
      Object $actualTotalArea = this.getActualTotalArea();
      result = result * 59 + ($actualTotalArea == null ? 43 : $actualTotalArea.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   public static class ProjectInstallSummaryBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer projectType;
      private Integer productType;
      private Integer category;
      private Long productId;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal actualQuantity;
      private BigDecimal actualMete;
      private BigDecimal actualTotalArea;
      private String measureUnit;
      private String accountingUnit;

      ProjectInstallSummaryBuilder() {
      }

      @JsonProperty("id")
      public ProjectInstallSummary.ProjectInstallSummaryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ProjectInstallSummary.ProjectInstallSummaryBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ProjectInstallSummary.ProjectInstallSummaryBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ProjectInstallSummary.ProjectInstallSummaryBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectInstallSummary.ProjectInstallSummaryBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      @JsonProperty("productType")
      public ProjectInstallSummary.ProjectInstallSummaryBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("category")
      public ProjectInstallSummary.ProjectInstallSummaryBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("productId")
      public ProjectInstallSummary.ProjectInstallSummaryBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("name")
      public ProjectInstallSummary.ProjectInstallSummaryBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectInstallSummary.ProjectInstallSummaryBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ProjectInstallSummary.ProjectInstallSummaryBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("actualQuantity")
      public ProjectInstallSummary.ProjectInstallSummaryBuilder actualQuantity(final BigDecimal actualQuantity) {
         this.actualQuantity = actualQuantity;
         return this;
      }

      @JsonProperty("actualMete")
      public ProjectInstallSummary.ProjectInstallSummaryBuilder actualMete(final BigDecimal actualMete) {
         this.actualMete = actualMete;
         return this;
      }

      @JsonProperty("actualTotalArea")
      public ProjectInstallSummary.ProjectInstallSummaryBuilder actualTotalArea(final BigDecimal actualTotalArea) {
         this.actualTotalArea = actualTotalArea;
         return this;
      }

      public ProjectInstallSummary.ProjectInstallSummaryBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectInstallSummary.ProjectInstallSummaryBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectInstallSummary build() {
         return new ProjectInstallSummary(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.projectType,
            this.productType,
            this.category,
            this.productId,
            this.name,
            this.serialNumber,
            this.specification,
            this.actualQuantity,
            this.actualMete,
            this.actualTotalArea,
            this.measureUnit,
            this.accountingUnit
         );
      }

      @Override
      public String toString() {
         return "ProjectInstallSummary.ProjectInstallSummaryBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", projectType="
            + this.projectType
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ", productId="
            + this.productId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", actualQuantity="
            + this.actualQuantity
            + ", actualMete="
            + this.actualMete
            + ", actualTotalArea="
            + this.actualTotalArea
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ")";
      }
   }
}
