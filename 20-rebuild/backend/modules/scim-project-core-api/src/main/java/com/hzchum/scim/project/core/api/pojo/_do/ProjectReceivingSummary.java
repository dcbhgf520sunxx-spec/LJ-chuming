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

@ApiModel(value = "ProjectReceivingSummary对象", description = "项目管理收货产品汇总表 ")
@Entity
@TableName("project_receiving_summary")
@Table(name = "project_receiving_summary")
@org.hibernate.annotations.Table(appliesTo = "project_receiving_summary", comment = "项目管理收货产品汇总表 ")
public class ProjectReceivingSummary extends BaseEntity<Long> {
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
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢项目 2桥梁项目 4立体停车库", notes = "项目类型 1建钢项目 2桥梁项目 4立体停车库")
   @TableField("project_type")
   @Column(name = "project_type", columnDefinition = "int(11) default 1  COMMENT '项目类型 1建钢项目 2桥梁项目 4立体停车库'", nullable = false)
   private Integer projectType;
   @ApiModelProperty(name = "productType", value = "产品类型 2构件 4围护 8配套件", notes = "产品类型 2构件 4围护 8配套件")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型 2构件 4围护 8配套件'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "category", value = "围护分类 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件", notes = "围护分类 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11)  COMMENT '围护分类 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件'", nullable = true)
   private Integer category;
   @ApiModelProperty(name = "measureMode", notes = "计量方式 构件:1理计2磅记, 围护:1长度计量2面积计量")
   @TableField("measure_mode")
   @Column(name = "measure_mode", columnDefinition = "int(11) comment '计量方式  构件:1理计2磅记, 围护:1长度计量2面积计量'")
   private Integer measureMode;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(128)  COMMENT '名称'")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(128)  COMMENT '编号'")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(128)  COMMENT '规格'")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(64) COMMENT '材质'")
   private String material;
   @ApiModelProperty(name = "length", value = "单长度（mm）")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8) COMMENT '单长度(mm)'")
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "围护宽度(mm)")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,8) COMMENT '围护展宽(mm)'")
   private BigDecimal width;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @TableField("net_weight")
   @Column(name = "net_weight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "quantity", value = "收货总数量", notes = "收货总数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(18,4)  COMMENT '收货总数量'", nullable = false)
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "产品收货总量(重量kg/长度mm)", notes = "产品收货总量(重量kg/长度mm)")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '产品收货总量(重量kg/长度mm)'", nullable = false)
   private BigDecimal mete;
   @ApiModelProperty(name = "totalArea", value = "收货总面积mm2", notes = "收货总面积mm2")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   @TableField("total_area")
   @Column(name = "total_area", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '收货总面积mm2'")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "installQuantity", value = "已安装数量", notes = "已安装总数量")
   @TableField("install_quantity")
   @Column(name = "install_quantity", columnDefinition = "decimal(18,4) default '0' COMMENT '已安装总数量'", nullable = false)
   private BigDecimal installQuantity;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(64)  COMMENT '计量单位'")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(64)  COMMENT '核算单位'")
   private String accountingUnit;
   @Deprecated
   @ApiModelProperty(name = "source_type", value = "来源类型", notes = "参考 SourceTypeEnum")
   @JsonProperty("sourceType")
   @JSONField(name = "sourceType")
   @TableField("source_type")
   @Column(name = "source_type", columnDefinition = "int(11) default '1' COMMENT '参考 SourceTypeEnum'", nullable = false)
   private Integer sourceType;
   @ApiModelProperty(name = "purchaseDetailsId", value = "采购详情id", notes = "采购详情id")
   @JsonProperty("purchaseDetailsId")
   @JSONField(name = "purchaseDetailsId")
   @TableField("purchase_details_id")
   @Column(name = "purchase_details_id", columnDefinition = "bigint(20)  COMMENT '采购详情id'")
   private Long purchaseDetailsId;
   @ApiModelProperty(name = "actualReceivedMete", value = "实际收货核算量 ", notes = "实际收货核算量")
   @JsonProperty("actualReceivedMete")
   @JSONField(name = "actualReceivedMete")
   @TableField("actual_received_mete")
   @Column(name = "actual_received_mete", columnDefinition = "decimal(32,8) DEFAULT '0.00000000' COMMENT '实际收货核算量'", nullable = true)
   private BigDecimal actualReceivedMete;

   public static ProjectReceivingSummary.ProjectReceivingSummaryBuilder builder() {
      return new ProjectReceivingSummary.ProjectReceivingSummaryBuilder();
   }

   public ProjectReceivingSummary() {
   }

   public ProjectReceivingSummary(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer projectType,
      final Integer productType,
      final Integer category,
      final Integer measureMode,
      final Long productId,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal netWeight,
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal totalArea,
      final BigDecimal installQuantity,
      final String measureUnit,
      final String accountingUnit,
      final Integer sourceType,
      final Long purchaseDetailsId,
      final BigDecimal actualReceivedMete
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.projectType = projectType;
      this.productType = productType;
      this.category = category;
      this.measureMode = measureMode;
      this.productId = productId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.length = length;
      this.width = width;
      this.netWeight = netWeight;
      this.quantity = quantity;
      this.mete = mete;
      this.totalArea = totalArea;
      this.installQuantity = installQuantity;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.sourceType = sourceType;
      this.purchaseDetailsId = purchaseDetailsId;
      this.actualReceivedMete = actualReceivedMete;
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

   public Integer getMeasureMode() {
      return this.measureMode;
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

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getInstallQuantity() {
      return this.installQuantity;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   @Deprecated
   public Integer getSourceType() {
      return this.sourceType;
   }

   public Long getPurchaseDetailsId() {
      return this.purchaseDetailsId;
   }

   public BigDecimal getActualReceivedMete() {
      return this.actualReceivedMete;
   }

   @JsonProperty("id")
   public ProjectReceivingSummary setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public ProjectReceivingSummary setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ProjectReceivingSummary setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ProjectReceivingSummary setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public ProjectReceivingSummary setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   @JsonProperty("productType")
   public ProjectReceivingSummary setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("category")
   public ProjectReceivingSummary setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public ProjectReceivingSummary setMeasureMode(final Integer measureMode) {
      this.measureMode = measureMode;
      return this;
   }

   @JsonProperty("productId")
   public ProjectReceivingSummary setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("name")
   public ProjectReceivingSummary setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProjectReceivingSummary setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ProjectReceivingSummary setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public ProjectReceivingSummary setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public ProjectReceivingSummary setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public ProjectReceivingSummary setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   public ProjectReceivingSummary setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("quantity")
   public ProjectReceivingSummary setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("mete")
   public ProjectReceivingSummary setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("totalArea")
   public ProjectReceivingSummary setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   public ProjectReceivingSummary setInstallQuantity(final BigDecimal installQuantity) {
      this.installQuantity = installQuantity;
      return this;
   }

   public ProjectReceivingSummary setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public ProjectReceivingSummary setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @Deprecated
   @JsonProperty("sourceType")
   public ProjectReceivingSummary setSourceType(final Integer sourceType) {
      this.sourceType = sourceType;
      return this;
   }

   @JsonProperty("purchaseDetailsId")
   public ProjectReceivingSummary setPurchaseDetailsId(final Long purchaseDetailsId) {
      this.purchaseDetailsId = purchaseDetailsId;
      return this;
   }

   @JsonProperty("actualReceivedMete")
   public ProjectReceivingSummary setActualReceivedMete(final BigDecimal actualReceivedMete) {
      this.actualReceivedMete = actualReceivedMete;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectReceivingSummary(id="
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
         + ", measureMode="
         + this.getMeasureMode()
         + ", productId="
         + this.getProductId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", netWeight="
         + this.getNetWeight()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", totalArea="
         + this.getTotalArea()
         + ", installQuantity="
         + this.getInstallQuantity()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", sourceType="
         + this.getSourceType()
         + ", purchaseDetailsId="
         + this.getPurchaseDetailsId()
         + ", actualReceivedMete="
         + this.getActualReceivedMete()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReceivingSummary)) {
         return false;
      }

      ProjectReceivingSummary other = (ProjectReceivingSummary)o;
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
                           Object this$measureMode = this.getMeasureMode();
                           Object other$measureMode = other.getMeasureMode();
                           if (this$measureMode == null ? other$measureMode == null : this$measureMode.equals(other$measureMode)) {
                              Object this$productId = this.getProductId();
                              Object other$productId = other.getProductId();
                              if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                 Object this$sourceType = this.getSourceType();
                                 Object other$sourceType = other.getSourceType();
                                 if (this$sourceType == null ? other$sourceType == null : this$sourceType.equals(other$sourceType)) {
                                    Object this$purchaseDetailsId = this.getPurchaseDetailsId();
                                    Object other$purchaseDetailsId = other.getPurchaseDetailsId();
                                    if (this$purchaseDetailsId == null
                                       ? other$purchaseDetailsId == null
                                       : this$purchaseDetailsId.equals(other$purchaseDetailsId)) {
                                       Object this$name = this.getName();
                                       Object other$name = other.getName();
                                       if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$specification = this.getSpecification();
                                             Object other$specification = other.getSpecification();
                                             if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                Object this$material = this.getMaterial();
                                                Object other$material = other.getMaterial();
                                                if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                   Object this$length = this.getLength();
                                                   Object other$length = other.getLength();
                                                   if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                      Object this$width = this.getWidth();
                                                      Object other$width = other.getWidth();
                                                      if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                         Object this$netWeight = this.getNetWeight();
                                                         Object other$netWeight = other.getNetWeight();
                                                         if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                            Object this$quantity = this.getQuantity();
                                                            Object other$quantity = other.getQuantity();
                                                            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                               Object this$mete = this.getMete();
                                                               Object other$mete = other.getMete();
                                                               if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                  Object this$totalArea = this.getTotalArea();
                                                                  Object other$totalArea = other.getTotalArea();
                                                                  if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)
                                                                     )
                                                                   {
                                                                     Object this$installQuantity = this.getInstallQuantity();
                                                                     Object other$installQuantity = other.getInstallQuantity();
                                                                     if (this$installQuantity == null
                                                                        ? other$installQuantity == null
                                                                        : this$installQuantity.equals(other$installQuantity)) {
                                                                        Object this$measureUnit = this.getMeasureUnit();
                                                                        Object other$measureUnit = other.getMeasureUnit();
                                                                        if (this$measureUnit == null
                                                                           ? other$measureUnit == null
                                                                           : this$measureUnit.equals(other$measureUnit)) {
                                                                           Object this$accountingUnit = this.getAccountingUnit();
                                                                           Object other$accountingUnit = other.getAccountingUnit();
                                                                           if (this$accountingUnit == null
                                                                              ? other$accountingUnit == null
                                                                              : this$accountingUnit.equals(other$accountingUnit)) {
                                                                              Object this$actualReceivedMete = this.getActualReceivedMete();
                                                                              Object other$actualReceivedMete = other.getActualReceivedMete();
                                                                              return this$actualReceivedMete == null
                                                                                 ? other$actualReceivedMete == null
                                                                                 : this$actualReceivedMete.equals(other$actualReceivedMete);
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
      return other instanceof ProjectReceivingSummary;
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
      Object $measureMode = this.getMeasureMode();
      result = result * 59 + ($measureMode == null ? 43 : $measureMode.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $sourceType = this.getSourceType();
      result = result * 59 + ($sourceType == null ? 43 : $sourceType.hashCode());
      Object $purchaseDetailsId = this.getPurchaseDetailsId();
      result = result * 59 + ($purchaseDetailsId == null ? 43 : $purchaseDetailsId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $installQuantity = this.getInstallQuantity();
      result = result * 59 + ($installQuantity == null ? 43 : $installQuantity.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $actualReceivedMete = this.getActualReceivedMete();
      return result * 59 + ($actualReceivedMete == null ? 43 : $actualReceivedMete.hashCode());
   }

   public static class ProjectReceivingSummaryBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer projectType;
      private Integer productType;
      private Integer category;
      private Integer measureMode;
      private Long productId;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal netWeight;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal totalArea;
      private BigDecimal installQuantity;
      private String measureUnit;
      private String accountingUnit;
      private Integer sourceType;
      private Long purchaseDetailsId;
      private BigDecimal actualReceivedMete;

      ProjectReceivingSummaryBuilder() {
      }

      @JsonProperty("id")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      @JsonProperty("productType")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("category")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder measureMode(final Integer measureMode) {
         this.measureMode = measureMode;
         return this;
      }

      @JsonProperty("productId")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("name")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("totalArea")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder installQuantity(final BigDecimal installQuantity) {
         this.installQuantity = installQuantity;
         return this;
      }

      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @Deprecated
      @JsonProperty("sourceType")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder sourceType(final Integer sourceType) {
         this.sourceType = sourceType;
         return this;
      }

      @JsonProperty("purchaseDetailsId")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder purchaseDetailsId(final Long purchaseDetailsId) {
         this.purchaseDetailsId = purchaseDetailsId;
         return this;
      }

      @JsonProperty("actualReceivedMete")
      public ProjectReceivingSummary.ProjectReceivingSummaryBuilder actualReceivedMete(final BigDecimal actualReceivedMete) {
         this.actualReceivedMete = actualReceivedMete;
         return this;
      }

      public ProjectReceivingSummary build() {
         return new ProjectReceivingSummary(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.projectType,
            this.productType,
            this.category,
            this.measureMode,
            this.productId,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.length,
            this.width,
            this.netWeight,
            this.quantity,
            this.mete,
            this.totalArea,
            this.installQuantity,
            this.measureUnit,
            this.accountingUnit,
            this.sourceType,
            this.purchaseDetailsId,
            this.actualReceivedMete
         );
      }

      @Override
      public String toString() {
         return "ProjectReceivingSummary.ProjectReceivingSummaryBuilder(id="
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
            + ", measureMode="
            + this.measureMode
            + ", productId="
            + this.productId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", netWeight="
            + this.netWeight
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", totalArea="
            + this.totalArea
            + ", installQuantity="
            + this.installQuantity
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", sourceType="
            + this.sourceType
            + ", purchaseDetailsId="
            + this.purchaseDetailsId
            + ", actualReceivedMete="
            + this.actualReceivedMete
            + ")";
      }
   }
}
