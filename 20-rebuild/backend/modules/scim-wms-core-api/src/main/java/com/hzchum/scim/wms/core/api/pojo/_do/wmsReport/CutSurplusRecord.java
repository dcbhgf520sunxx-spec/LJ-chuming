package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "CutSurplusRecord对象", description = "切割余料记录")
@Entity
@TableName("wms_cut_surplus_record")
@Table(name = "wms_cut_surplus_record")
public class CutSurplusRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name", columnDefinition = "varchar(255)  COMMENT '科目名称'", nullable = true)
   private String classifyName;
   @ApiModelProperty(name = "spec", value = "余料规格", notes = "余料规格")
   @JsonProperty("spec")
   @JSONField(name = "spec")
   @TableField("spec")
   @Column(name = "spec", columnDefinition = "varchar(255)  COMMENT '余料规格'", nullable = true)
   private String spec;
   @ApiModelProperty(name = "sourceSpec", value = "原钢板规格", notes = "原钢板规格")
   @JsonProperty("sourceSpec")
   @JSONField(name = "sourceSpec")
   @TableField("source_spec")
   @Column(name = "source_spec", columnDefinition = "varchar(255)  COMMENT '原钢板规格'", nullable = true)
   private String sourceSpec;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供物料", notes = "是否为甲供物料")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供物料'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度", notes = "理论厚度")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "int(11)  COMMENT '理论厚度'", nullable = true)
   private Integer theoryThickness;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(128)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号", notes = "炉批号")
   @JsonProperty("heatNoAndBatchNo")
   @JSONField(name = "heatNoAndBatchNo")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no", columnDefinition = "varchar(255)  COMMENT '炉批号'", nullable = true)
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID", notes = "仓库ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库ID'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "workshopId", value = "工厂ID", notes = "工厂ID")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '工厂ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "materialId", value = "原物料ID", notes = "原物料ID")
   @JsonProperty("materialId")
   @JSONField(name = "materialId")
   @TableField("material_id")
   @Column(name = "material_id", columnDefinition = "bigint  COMMENT '原物料ID'", nullable = true)
   private Long materialId;
   @ApiModelProperty(name = "barcode", value = "钢材条码", notes = "钢材条码")
   @JsonProperty("barcode")
   @JSONField(name = "barcode")
   @TableField("barcode")
   @Column(name = "barcode", columnDefinition = "varchar(255)  COMMENT '钢材条码'", nullable = true)
   private String barcode;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint  COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "surplusSn", value = "余料编号", notes = "余料编号")
   @JsonProperty("surplusSn")
   @JSONField(name = "surplusSn")
   @TableField("surplus_sn")
   @Column(name = "surplus_sn", columnDefinition = "varchar(255)  COMMENT '余料编号'", nullable = true)
   private String surplusSn;
   @ApiModelProperty(name = "cutTaskId", value = "套料工单号", notes = "套料工单号")
   @JsonProperty("cutTaskId")
   @JSONField(name = "cutTaskId")
   @TableField("cut_task_id")
   @Column(name = "cut_task_id", columnDefinition = "varchar(255)  COMMENT '套料工单号'", nullable = true)
   private String cutTaskId;
   @ApiModelProperty(name = "cutEndTime", value = "切割完成时间", notes = "切割完成时间")
   @JsonProperty("cutEndTime")
   @JSONField(name = "cutEndTime")
   @TableField("cut_end_time")
   @Column(name = "cut_end_time", columnDefinition = "datetime COMMENT '切割完成时间'", nullable = true)
   private LocalDateTime cutEndTime;

   public static CutSurplusRecord.CutSurplusRecordBuilder builder() {
      return new CutSurplusRecord.CutSurplusRecordBuilder();
   }

   public CutSurplusRecord() {
   }

   public CutSurplusRecord(
      final Long id,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String spec,
      final String sourceSpec,
      final Long projectId,
      final Boolean boolPartyA,
      final Integer theoryThickness,
      final BigDecimal quantity,
      final String brand,
      final String heatNoAndBatchNo,
      final BigDecimal mete,
      final Long warehouseId,
      final Long workshopId,
      final Long materialId,
      final String barcode,
      final Long areaId,
      final Long monomerId,
      final String surplusSn,
      final String cutTaskId,
      final LocalDateTime cutEndTime
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.spec = spec;
      this.sourceSpec = sourceSpec;
      this.projectId = projectId;
      this.boolPartyA = boolPartyA;
      this.theoryThickness = theoryThickness;
      this.quantity = quantity;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.mete = mete;
      this.warehouseId = warehouseId;
      this.workshopId = workshopId;
      this.materialId = materialId;
      this.barcode = barcode;
      this.areaId = areaId;
      this.monomerId = monomerId;
      this.surplusSn = surplusSn;
      this.cutTaskId = cutTaskId;
      this.cutEndTime = cutEndTime;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSpec() {
      return this.spec;
   }

   public String getSourceSpec() {
      return this.sourceSpec;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getTheoryThickness() {
      return this.theoryThickness;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getMaterialId() {
      return this.materialId;
   }

   public String getBarcode() {
      return this.barcode;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getSurplusSn() {
      return this.surplusSn;
   }

   public String getCutTaskId() {
      return this.cutTaskId;
   }

   public LocalDateTime getCutEndTime() {
      return this.cutEndTime;
   }

   @JsonProperty("id")
   public CutSurplusRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("basicClass")
   public CutSurplusRecord setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public CutSurplusRecord setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public CutSurplusRecord setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("spec")
   public CutSurplusRecord setSpec(final String spec) {
      this.spec = spec;
      return this;
   }

   @JsonProperty("sourceSpec")
   public CutSurplusRecord setSourceSpec(final String sourceSpec) {
      this.sourceSpec = sourceSpec;
      return this;
   }

   @JsonProperty("projectId")
   public CutSurplusRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("boolPartyA")
   public CutSurplusRecord setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("theoryThickness")
   public CutSurplusRecord setTheoryThickness(final Integer theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("quantity")
   public CutSurplusRecord setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("brand")
   public CutSurplusRecord setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public CutSurplusRecord setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("mete")
   public CutSurplusRecord setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("warehouseId")
   public CutSurplusRecord setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("workshopId")
   public CutSurplusRecord setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("materialId")
   public CutSurplusRecord setMaterialId(final Long materialId) {
      this.materialId = materialId;
      return this;
   }

   @JsonProperty("barcode")
   public CutSurplusRecord setBarcode(final String barcode) {
      this.barcode = barcode;
      return this;
   }

   @JsonProperty("areaId")
   public CutSurplusRecord setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("monomerId")
   public CutSurplusRecord setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("surplusSn")
   public CutSurplusRecord setSurplusSn(final String surplusSn) {
      this.surplusSn = surplusSn;
      return this;
   }

   @JsonProperty("cutTaskId")
   public CutSurplusRecord setCutTaskId(final String cutTaskId) {
      this.cutTaskId = cutTaskId;
      return this;
   }

   @JsonProperty("cutEndTime")
   public CutSurplusRecord setCutEndTime(final LocalDateTime cutEndTime) {
      this.cutEndTime = cutEndTime;
      return this;
   }

   @Override
   public String toString() {
      return "CutSurplusRecord(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", spec="
         + this.getSpec()
         + ", sourceSpec="
         + this.getSourceSpec()
         + ", projectId="
         + this.getProjectId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", quantity="
         + this.getQuantity()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", mete="
         + this.getMete()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", materialId="
         + this.getMaterialId()
         + ", barcode="
         + this.getBarcode()
         + ", areaId="
         + this.getAreaId()
         + ", monomerId="
         + this.getMonomerId()
         + ", surplusSn="
         + this.getSurplusSn()
         + ", cutTaskId="
         + this.getCutTaskId()
         + ", cutEndTime="
         + this.getCutEndTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CutSurplusRecord)) {
         return false;
      }

      CutSurplusRecord other = (CutSurplusRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$boolPartyA = this.getBoolPartyA();
                  Object other$boolPartyA = other.getBoolPartyA();
                  if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                     Object this$theoryThickness = this.getTheoryThickness();
                     Object other$theoryThickness = other.getTheoryThickness();
                     if (this$theoryThickness == null ? other$theoryThickness == null : this$theoryThickness.equals(other$theoryThickness)) {
                        Object this$warehouseId = this.getWarehouseId();
                        Object other$warehouseId = other.getWarehouseId();
                        if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                           Object this$workshopId = this.getWorkshopId();
                           Object other$workshopId = other.getWorkshopId();
                           if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                              Object this$materialId = this.getMaterialId();
                              Object other$materialId = other.getMaterialId();
                              if (this$materialId == null ? other$materialId == null : this$materialId.equals(other$materialId)) {
                                 Object this$areaId = this.getAreaId();
                                 Object other$areaId = other.getAreaId();
                                 if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                    Object this$monomerId = this.getMonomerId();
                                    Object other$monomerId = other.getMonomerId();
                                    if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                       Object this$classifyName = this.getClassifyName();
                                       Object other$classifyName = other.getClassifyName();
                                       if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                          Object this$spec = this.getSpec();
                                          Object other$spec = other.getSpec();
                                          if (this$spec == null ? other$spec == null : this$spec.equals(other$spec)) {
                                             Object this$sourceSpec = this.getSourceSpec();
                                             Object other$sourceSpec = other.getSourceSpec();
                                             if (this$sourceSpec == null ? other$sourceSpec == null : this$sourceSpec.equals(other$sourceSpec)) {
                                                Object this$quantity = this.getQuantity();
                                                Object other$quantity = other.getQuantity();
                                                if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                   Object this$brand = this.getBrand();
                                                   Object other$brand = other.getBrand();
                                                   if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                      Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                      Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                      if (this$heatNoAndBatchNo == null
                                                         ? other$heatNoAndBatchNo == null
                                                         : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                         Object this$mete = this.getMete();
                                                         Object other$mete = other.getMete();
                                                         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                            Object this$barcode = this.getBarcode();
                                                            Object other$barcode = other.getBarcode();
                                                            if (this$barcode == null ? other$barcode == null : this$barcode.equals(other$barcode)) {
                                                               Object this$surplusSn = this.getSurplusSn();
                                                               Object other$surplusSn = other.getSurplusSn();
                                                               if (this$surplusSn == null ? other$surplusSn == null : this$surplusSn.equals(other$surplusSn)) {
                                                                  Object this$cutTaskId = this.getCutTaskId();
                                                                  Object other$cutTaskId = other.getCutTaskId();
                                                                  if (this$cutTaskId == null ? other$cutTaskId == null : this$cutTaskId.equals(other$cutTaskId)
                                                                     )
                                                                   {
                                                                     Object this$cutEndTime = this.getCutEndTime();
                                                                     Object other$cutEndTime = other.getCutEndTime();
                                                                     return this$cutEndTime == null
                                                                        ? other$cutEndTime == null
                                                                        : this$cutEndTime.equals(other$cutEndTime);
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
      return other instanceof CutSurplusRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $spec = this.getSpec();
      result = result * 59 + ($spec == null ? 43 : $spec.hashCode());
      Object $sourceSpec = this.getSourceSpec();
      result = result * 59 + ($sourceSpec == null ? 43 : $sourceSpec.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $barcode = this.getBarcode();
      result = result * 59 + ($barcode == null ? 43 : $barcode.hashCode());
      Object $surplusSn = this.getSurplusSn();
      result = result * 59 + ($surplusSn == null ? 43 : $surplusSn.hashCode());
      Object $cutTaskId = this.getCutTaskId();
      result = result * 59 + ($cutTaskId == null ? 43 : $cutTaskId.hashCode());
      Object $cutEndTime = this.getCutEndTime();
      return result * 59 + ($cutEndTime == null ? 43 : $cutEndTime.hashCode());
   }

   public static class CutSurplusRecordBuilder {
      private Long id;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String spec;
      private String sourceSpec;
      private Long projectId;
      private Boolean boolPartyA;
      private Integer theoryThickness;
      private BigDecimal quantity;
      private String brand;
      private String heatNoAndBatchNo;
      private BigDecimal mete;
      private Long warehouseId;
      private Long workshopId;
      private Long materialId;
      private String barcode;
      private Long areaId;
      private Long monomerId;
      private String surplusSn;
      private String cutTaskId;
      private LocalDateTime cutEndTime;

      CutSurplusRecordBuilder() {
      }

      @JsonProperty("id")
      public CutSurplusRecord.CutSurplusRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("basicClass")
      public CutSurplusRecord.CutSurplusRecordBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public CutSurplusRecord.CutSurplusRecordBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public CutSurplusRecord.CutSurplusRecordBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("spec")
      public CutSurplusRecord.CutSurplusRecordBuilder spec(final String spec) {
         this.spec = spec;
         return this;
      }

      @JsonProperty("sourceSpec")
      public CutSurplusRecord.CutSurplusRecordBuilder sourceSpec(final String sourceSpec) {
         this.sourceSpec = sourceSpec;
         return this;
      }

      @JsonProperty("projectId")
      public CutSurplusRecord.CutSurplusRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("boolPartyA")
      public CutSurplusRecord.CutSurplusRecordBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("theoryThickness")
      public CutSurplusRecord.CutSurplusRecordBuilder theoryThickness(final Integer theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("quantity")
      public CutSurplusRecord.CutSurplusRecordBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("brand")
      public CutSurplusRecord.CutSurplusRecordBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public CutSurplusRecord.CutSurplusRecordBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("mete")
      public CutSurplusRecord.CutSurplusRecordBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("warehouseId")
      public CutSurplusRecord.CutSurplusRecordBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("workshopId")
      public CutSurplusRecord.CutSurplusRecordBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("materialId")
      public CutSurplusRecord.CutSurplusRecordBuilder materialId(final Long materialId) {
         this.materialId = materialId;
         return this;
      }

      @JsonProperty("barcode")
      public CutSurplusRecord.CutSurplusRecordBuilder barcode(final String barcode) {
         this.barcode = barcode;
         return this;
      }

      @JsonProperty("areaId")
      public CutSurplusRecord.CutSurplusRecordBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("monomerId")
      public CutSurplusRecord.CutSurplusRecordBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("surplusSn")
      public CutSurplusRecord.CutSurplusRecordBuilder surplusSn(final String surplusSn) {
         this.surplusSn = surplusSn;
         return this;
      }

      @JsonProperty("cutTaskId")
      public CutSurplusRecord.CutSurplusRecordBuilder cutTaskId(final String cutTaskId) {
         this.cutTaskId = cutTaskId;
         return this;
      }

      @JsonProperty("cutEndTime")
      public CutSurplusRecord.CutSurplusRecordBuilder cutEndTime(final LocalDateTime cutEndTime) {
         this.cutEndTime = cutEndTime;
         return this;
      }

      public CutSurplusRecord build() {
         return new CutSurplusRecord(
            this.id,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.spec,
            this.sourceSpec,
            this.projectId,
            this.boolPartyA,
            this.theoryThickness,
            this.quantity,
            this.brand,
            this.heatNoAndBatchNo,
            this.mete,
            this.warehouseId,
            this.workshopId,
            this.materialId,
            this.barcode,
            this.areaId,
            this.monomerId,
            this.surplusSn,
            this.cutTaskId,
            this.cutEndTime
         );
      }

      @Override
      public String toString() {
         return "CutSurplusRecord.CutSurplusRecordBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", spec="
            + this.spec
            + ", sourceSpec="
            + this.sourceSpec
            + ", projectId="
            + this.projectId
            + ", boolPartyA="
            + this.boolPartyA
            + ", theoryThickness="
            + this.theoryThickness
            + ", quantity="
            + this.quantity
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", mete="
            + this.mete
            + ", warehouseId="
            + this.warehouseId
            + ", workshopId="
            + this.workshopId
            + ", materialId="
            + this.materialId
            + ", barcode="
            + this.barcode
            + ", areaId="
            + this.areaId
            + ", monomerId="
            + this.monomerId
            + ", surplusSn="
            + this.surplusSn
            + ", cutTaskId="
            + this.cutTaskId
            + ", cutEndTime="
            + this.cutEndTime
            + ")";
      }
   }
}
