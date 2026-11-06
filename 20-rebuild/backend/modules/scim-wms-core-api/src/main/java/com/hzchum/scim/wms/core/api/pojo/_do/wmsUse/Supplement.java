package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

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

@ApiModel(value = "Supplement对象", description = "物料红冲 ")
@Entity
@TableName("wms_supplement")
@Table(name = "wms_supplement")
public class Supplement extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "basicClass", value = "物料基础分类", notes = "物料基础分类")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础分类'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "length", value = "长", notes = "长")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8)  COMMENT '长'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽", notes = "宽")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,8)  COMMENT '宽'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚", notes = "厚")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "brand")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "accountingUnit", value = "核算量单位", notes = "核算量单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(255)  COMMENT '核算量单位'", nullable = true)
   private String accountingUnit;
   @ApiModelProperty(name = "mete", value = "红称重量", notes = "红称重量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '红称重量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "amount", value = "红冲含税金额", notes = "红冲含税金额")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,8)  COMMENT '红冲含税金额'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = "红冲不含税总价", notes = "红冲不含税总价")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_vat")
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,8)  COMMENT '红冲不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "serialNumber", value = "红冲单编号", notes = "红冲单编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '红冲单编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "receiptId", value = "红冲产生单据ID", notes = "红冲产生单据ID")
   @JsonProperty("receiptId")
   @JSONField(name = "receiptId")
   @TableField("receipt_id")
   @Column(name = "receipt_id", columnDefinition = "bigint  COMMENT '红冲产生单据ID'", nullable = true)
   private Long receiptId;
   @ApiModelProperty(name = "receiptSn", value = "红冲产生单据编号", notes = "红冲产生单据编号")
   @JsonProperty("receiptSn")
   @JSONField(name = "receiptSn")
   @TableField("receipt_sn")
   @Column(name = "receipt_sn", columnDefinition = "varchar(255)  COMMENT '红冲产生单据编号'", nullable = true)
   private String receiptSn;
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "amountNoFreight", value = "红冲含税金额 不含运费", notes = "红冲含税金额 不含运费")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,8)  COMMENT '红冲含税金额 不含运费'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = "红冲不含税总价 不含运费", notes = "红冲不含税总价 不含运费")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_vat_no_freight")
   @Column(name = "amount_excluding_vat_no_freight", columnDefinition = "decimal(32,8)  COMMENT '红冲不含税总价 不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "materialInventoryId", value = "库存ID", notes = "库存ID")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_inventory_id")
   @Column(name = "material_inventory_id", columnDefinition = "bigint  COMMENT '库存ID'", nullable = true)
   private Long materialInventoryId;
   @ApiModelProperty(name = "realTime", value = "实际时间")
   @JsonProperty("realTime")
   @JSONField(name = "realTime")
   @TableField("real_time")
   @Column(name = "real_time")
   private LocalDateTime realTime;

   public static Supplement.SupplementBuilder builder() {
      return new Supplement.SupplementBuilder();
   }

   public Supplement() {
   }

   public Supplement(
      final Long id,
      final Integer basicClass,
      final Long classifyId,
      final String specification,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String color,
      final String brand,
      final Long projectId,
      final String accountingUnit,
      final BigDecimal mete,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final String serialNumber,
      final Long receiptId,
      final String receiptSn,
      final Long workshopId,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVatNoFreight,
      final Long materialInventoryId,
      final LocalDateTime realTime
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.specification = specification;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.color = color;
      this.brand = brand;
      this.projectId = projectId;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.serialNumber = serialNumber;
      this.receiptId = receiptId;
      this.receiptSn = receiptSn;
      this.workshopId = workshopId;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.materialInventoryId = materialInventoryId;
      this.realTime = realTime;
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

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getReceiptId() {
      return this.receiptId;
   }

   public String getReceiptSn() {
      return this.receiptSn;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public BigDecimal getAmountExcludingVatNoFreight() {
      return this.amountExcludingVatNoFreight;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   @JsonProperty("id")
   public Supplement setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("basicClass")
   public Supplement setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public Supplement setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("specification")
   public Supplement setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public Supplement setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public Supplement setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public Supplement setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("color")
   public Supplement setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("brand")
   public Supplement setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("projectId")
   public Supplement setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("accountingUnit")
   public Supplement setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("mete")
   public Supplement setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("amount")
   public Supplement setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public Supplement setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("serialNumber")
   public Supplement setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("receiptId")
   public Supplement setReceiptId(final Long receiptId) {
      this.receiptId = receiptId;
      return this;
   }

   @JsonProperty("receiptSn")
   public Supplement setReceiptSn(final String receiptSn) {
      this.receiptSn = receiptSn;
      return this;
   }

   @JsonProperty("workshopId")
   public Supplement setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public Supplement setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public Supplement setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public Supplement setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   @JsonProperty("realTime")
   public Supplement setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
      return this;
   }

   @Override
   public String toString() {
      return "Supplement(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", projectId="
         + this.getProjectId()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", receiptId="
         + this.getReceiptId()
         + ", receiptSn="
         + this.getReceiptSn()
         + ", workshopId="
         + this.getWorkshopId()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", realTime="
         + this.getRealTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Supplement)) {
         return false;
      }

      Supplement other = (Supplement)o;
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
                  Object this$receiptId = this.getReceiptId();
                  Object other$receiptId = other.getReceiptId();
                  if (this$receiptId == null ? other$receiptId == null : this$receiptId.equals(other$receiptId)) {
                     Object this$workshopId = this.getWorkshopId();
                     Object other$workshopId = other.getWorkshopId();
                     if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                        Object this$materialInventoryId = this.getMaterialInventoryId();
                        Object other$materialInventoryId = other.getMaterialInventoryId();
                        if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$length = this.getLength();
                              Object other$length = other.getLength();
                              if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                 Object this$width = this.getWidth();
                                 Object other$width = other.getWidth();
                                 if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                    Object this$thickness = this.getThickness();
                                    Object other$thickness = other.getThickness();
                                    if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                       Object this$color = this.getColor();
                                       Object other$color = other.getColor();
                                       if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                          Object this$brand = this.getBrand();
                                          Object other$brand = other.getBrand();
                                          if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                             Object this$accountingUnit = this.getAccountingUnit();
                                             Object other$accountingUnit = other.getAccountingUnit();
                                             if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                                Object this$mete = this.getMete();
                                                Object other$mete = other.getMete();
                                                if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                   Object this$amount = this.getAmount();
                                                   Object other$amount = other.getAmount();
                                                   if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                      Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                      Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                      if (this$amountExcludingVat == null
                                                         ? other$amountExcludingVat == null
                                                         : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                         Object this$serialNumber = this.getSerialNumber();
                                                         Object other$serialNumber = other.getSerialNumber();
                                                         if (this$serialNumber == null
                                                            ? other$serialNumber == null
                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                            Object this$receiptSn = this.getReceiptSn();
                                                            Object other$receiptSn = other.getReceiptSn();
                                                            if (this$receiptSn == null ? other$receiptSn == null : this$receiptSn.equals(other$receiptSn)) {
                                                               Object this$amountNoFreight = this.getAmountNoFreight();
                                                               Object other$amountNoFreight = other.getAmountNoFreight();
                                                               if (this$amountNoFreight == null
                                                                  ? other$amountNoFreight == null
                                                                  : this$amountNoFreight.equals(other$amountNoFreight)) {
                                                                  Object this$amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
                                                                  Object other$amountExcludingVatNoFreight = other.getAmountExcludingVatNoFreight();
                                                                  if (this$amountExcludingVatNoFreight == null
                                                                     ? other$amountExcludingVatNoFreight == null
                                                                     : this$amountExcludingVatNoFreight.equals(other$amountExcludingVatNoFreight)) {
                                                                     Object this$realTime = this.getRealTime();
                                                                     Object other$realTime = other.getRealTime();
                                                                     return this$realTime == null
                                                                        ? other$realTime == null
                                                                        : this$realTime.equals(other$realTime);
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
      return other instanceof Supplement;
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
      Object $receiptId = this.getReceiptId();
      result = result * 59 + ($receiptId == null ? 43 : $receiptId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $receiptSn = this.getReceiptSn();
      result = result * 59 + ($receiptSn == null ? 43 : $receiptSn.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $realTime = this.getRealTime();
      return result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
   }

   public static class SupplementBuilder {
      private Long id;
      private Integer basicClass;
      private Long classifyId;
      private String specification;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String color;
      private String brand;
      private Long projectId;
      private String accountingUnit;
      private BigDecimal mete;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private String serialNumber;
      private Long receiptId;
      private String receiptSn;
      private Long workshopId;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVatNoFreight;
      private Long materialInventoryId;
      private LocalDateTime realTime;

      SupplementBuilder() {
      }

      @JsonProperty("id")
      public Supplement.SupplementBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("basicClass")
      public Supplement.SupplementBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public Supplement.SupplementBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("specification")
      public Supplement.SupplementBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public Supplement.SupplementBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public Supplement.SupplementBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public Supplement.SupplementBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("color")
      public Supplement.SupplementBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("brand")
      public Supplement.SupplementBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("projectId")
      public Supplement.SupplementBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("accountingUnit")
      public Supplement.SupplementBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("mete")
      public Supplement.SupplementBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("amount")
      public Supplement.SupplementBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public Supplement.SupplementBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("serialNumber")
      public Supplement.SupplementBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("receiptId")
      public Supplement.SupplementBuilder receiptId(final Long receiptId) {
         this.receiptId = receiptId;
         return this;
      }

      @JsonProperty("receiptSn")
      public Supplement.SupplementBuilder receiptSn(final String receiptSn) {
         this.receiptSn = receiptSn;
         return this;
      }

      @JsonProperty("workshopId")
      public Supplement.SupplementBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public Supplement.SupplementBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public Supplement.SupplementBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public Supplement.SupplementBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      @JsonProperty("realTime")
      public Supplement.SupplementBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      public Supplement build() {
         return new Supplement(
            this.id,
            this.basicClass,
            this.classifyId,
            this.specification,
            this.length,
            this.width,
            this.thickness,
            this.color,
            this.brand,
            this.projectId,
            this.accountingUnit,
            this.mete,
            this.amount,
            this.amountExcludingVat,
            this.serialNumber,
            this.receiptId,
            this.receiptSn,
            this.workshopId,
            this.amountNoFreight,
            this.amountExcludingVatNoFreight,
            this.materialInventoryId,
            this.realTime
         );
      }

      @Override
      public String toString() {
         return "Supplement.SupplementBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", projectId="
            + this.projectId
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", serialNumber="
            + this.serialNumber
            + ", receiptId="
            + this.receiptId
            + ", receiptSn="
            + this.receiptSn
            + ", workshopId="
            + this.workshopId
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", realTime="
            + this.realTime
            + ")";
      }
   }
}
