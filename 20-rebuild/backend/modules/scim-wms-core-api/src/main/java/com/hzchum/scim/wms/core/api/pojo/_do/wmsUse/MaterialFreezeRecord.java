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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MaterialFreezeRecord对象", description = "冻结记录表 ")
@Entity
@TableName("wms_material_freeze_record")
@Table(name = "wms_material_freeze_record", indexes = @Index(name = "freeze_type", columnList = "freeze_type"))
public class MaterialFreezeRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "materialFreezeId", value = "冻结表ID", notes = "冻结表ID")
   @JsonProperty("materialFreezeId")
   @JSONField(name = "materialFreezeId")
   @TableField("material_freeze_id")
   @Column(name = "material_freeze_id", columnDefinition = "bigint  COMMENT '冻结表ID'", nullable = true)
   private Long materialFreezeId;
   @ApiModelProperty(name = "freezeDetailId", value = "冻结ID,产生冻结量的操作详情ID", notes = "冻结ID,产生冻结量的操作详情ID")
   @JsonProperty("freezeDetailId")
   @JSONField(name = "freezeDetailId")
   @TableField("freeze_detail_id")
   @Column(name = "freeze_detail_id", columnDefinition = "bigint  COMMENT '冻结ID,产生冻结量的操作详情ID'", nullable = true)
   private Long freezeDetailId;
   @ApiModelProperty(name = "freezeType", value = "冻结类型", notes = "冻结类型 MaterialFreezeTypeEnum")
   @JsonProperty("freezeType")
   @JSONField(name = "freezeType")
   @TableField("freeze_type")
   @Column(name = "freeze_type", columnDefinition = "int  COMMENT '冻结类型 MaterialFreezeTypeEnum'", nullable = true)
   private Integer freezeType;
   @ApiModelProperty(name = "freezeSourceId", value = "冻结来源ID", notes = "冻结来源ID")
   @JsonProperty("freezeSourceId")
   @JSONField(name = "freezeSourceId")
   @TableField("freeze_source_id")
   @Column(name = "freeze_source_id", columnDefinition = "bigint  COMMENT '冻结来源ID'", nullable = true)
   private Long freezeSourceId;
   @ApiModelProperty(name = "freezeSourceSn", value = "冻结来源单号冻结单号 [1 出库, 2 调拨 ,3 退货 ,4 备料]", notes = "冻结来源单号冻结单号 [1 出库, 2 调拨 ,3 退货 ,4 备料]")
   @JsonProperty("freezeSourceSn")
   @JSONField(name = "freezeSourceSn")
   @TableField("freeze_source_SN")
   @Column(name = "freeze_source_SN", columnDefinition = "varchar(255)  COMMENT '冻结来源单号冻结单号 [1 出库, 2 调拨 ,3 退货 ,4 备料]'", nullable = true)
   private String freezeSourceSn;
   @ApiModelProperty(name = "operatorId", value = "操作人ID", notes = "操作人ID")
   @JsonProperty("operatorId")
   @JSONField(name = "operatorId")
   @TableField("operator_id")
   @Column(name = "operator_id", columnDefinition = "bigint  COMMENT '操作人ID'", nullable = true)
   private Long operatorId;
   @ApiModelProperty(name = "operatorName", value = "操作人名称", notes = "操作人名称")
   @JsonProperty("operatorName")
   @JSONField(name = "operatorName")
   @TableField("operator_name")
   @Column(name = "operator_name", columnDefinition = "varchar(255)  COMMENT '操作人名称'", nullable = true)
   private String operatorName;
   @ApiModelProperty(name = "quantity", value = "冻结数量", notes = "冻结数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '冻结数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "冻结核算量", notes = "冻结核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '冻结核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "frozenTime", value = "冻结时间", notes = "冻结时间")
   @JsonProperty("frozenTime")
   @JSONField(name = "frozenTime")
   @TableField("frozen_time")
   @Column(name = "frozen_time", columnDefinition = "datetime  COMMENT '冻结时间'", nullable = true)
   private LocalDateTime frozenTime;
   @ApiModelProperty(name = "projectId", value = "操作项目ID", notes = "操作项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '操作项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "outboundUnitType", value = "出库方式[1 计量, 2 核算]", notes = "出库方式[1 计量, 2 核算]")
   @JsonProperty("outboundUnitType")
   @JSONField(name = "outboundUnitType")
   @TableField("outbound_unit_type")
   @Column(name = "outbound_unit_type", columnDefinition = "int  COMMENT '出库方式[1 计量, 2 核算]'", nullable = true)
   private Integer outboundUnitType;
   @ApiModelProperty(name = "boolBatten", value = "是否为条板", notes = "是否为条板")
   @JsonProperty("boolBatten")
   @JSONField(name = "boolBatten")
   @TableField("bool_batten")
   @Column(name = "bool_batten", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '是否为条板'", nullable = true)
   private Boolean boolBatten;
   @ApiModelProperty(name = "boolChangeOutbound", value = "是否为申购转出库冻结 ", notes = "是否为申购转出库冻结")
   @JsonProperty("boolChangeOutbound")
   @JSONField(name = "boolChangeOutbound")
   @TableField("bool_change_outbound")
   @Column(name = "bool_change_outbound", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '是否为申购转出库冻结'", nullable = true)
   private Boolean boolChangeOutbound;
   @ApiModelProperty(name = "applyPurchaseId", value = "申购单ID", notes = "申购单ID")
   @JsonProperty("applyPurchaseId")
   @JSONField(name = "applyPurchaseId")
   @TableField("apply_purchase_id")
   @Column(name = "apply_purchase_id", columnDefinition = "bigint  COMMENT '申购单ID'", nullable = true)
   private Long applyPurchaseId;
   @ApiModelProperty(name = "applyPurchaseDetailId", value = "申购详情ID", notes = "申购详情ID")
   @JsonProperty("applyPurchaseDetailId")
   @JSONField(name = "applyPurchaseDetailId")
   @TableField("apply_purchase_detail_id")
   @Column(name = "apply_purchase_detail_id", columnDefinition = "bigint  COMMENT '申购详情ID'", nullable = true)
   private Long applyPurchaseDetailId;
   @ApiModelProperty(name = "applyPurchaseSn", value = "申购单编号", notes = "申购单编号")
   @JsonProperty("applyPurchaseSn")
   @JSONField(name = "applyPurchaseSn")
   @TableField("apply_purchase_SN")
   @Column(name = "apply_purchase_SN", columnDefinition = "varchar(255)  COMMENT '申购单编号'", nullable = true)
   private String applyPurchaseSn;
   @ApiModelProperty(name = "applyPurchaseQuantity", value = "申购冻结数量", notes = "申购冻结数量")
   @JsonProperty("applyPurchaseQuantity")
   @JSONField(name = "applyPurchaseQuantity")
   @TableField("apply_purchase_quantity")
   @Column(name = "apply_purchase_quantity", columnDefinition = "decimal(32,8)  COMMENT '申购冻结数量'", nullable = true)
   private BigDecimal applyPurchaseQuantity;
   @ApiModelProperty(name = "applyPurchaseMete", value = "申购冻结核算量", notes = "冻结核算量")
   @JsonProperty("applyPurchaseMete")
   @JSONField(name = "applyPurchaseMete")
   @TableField("apply_purchase_mete")
   @Column(name = "apply_purchase_mete", columnDefinition = "decimal(32,8)  COMMENT '申购冻结核算量'", nullable = true)
   private BigDecimal applyPurchaseMete;
   @ApiModelProperty(name = "remark", value = "冻结备注", notes = "冻结备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '冻结备注'", nullable = true)
   private String remark;

   public static MaterialFreezeRecord.MaterialFreezeRecordBuilder builder() {
      return new MaterialFreezeRecord.MaterialFreezeRecordBuilder();
   }

   public MaterialFreezeRecord() {
   }

   public MaterialFreezeRecord(
      final Long id,
      final Long materialFreezeId,
      final Long freezeDetailId,
      final Integer freezeType,
      final Long freezeSourceId,
      final String freezeSourceSn,
      final Long operatorId,
      final String operatorName,
      final BigDecimal quantity,
      final BigDecimal mete,
      final LocalDateTime frozenTime,
      final Long projectId,
      final Integer outboundUnitType,
      final Boolean boolBatten,
      final Boolean boolChangeOutbound,
      final Long applyPurchaseId,
      final Long applyPurchaseDetailId,
      final String applyPurchaseSn,
      final BigDecimal applyPurchaseQuantity,
      final BigDecimal applyPurchaseMete,
      final String remark
   ) {
      this.id = id;
      this.materialFreezeId = materialFreezeId;
      this.freezeDetailId = freezeDetailId;
      this.freezeType = freezeType;
      this.freezeSourceId = freezeSourceId;
      this.freezeSourceSn = freezeSourceSn;
      this.operatorId = operatorId;
      this.operatorName = operatorName;
      this.quantity = quantity;
      this.mete = mete;
      this.frozenTime = frozenTime;
      this.projectId = projectId;
      this.outboundUnitType = outboundUnitType;
      this.boolBatten = boolBatten;
      this.boolChangeOutbound = boolChangeOutbound;
      this.applyPurchaseId = applyPurchaseId;
      this.applyPurchaseDetailId = applyPurchaseDetailId;
      this.applyPurchaseSn = applyPurchaseSn;
      this.applyPurchaseQuantity = applyPurchaseQuantity;
      this.applyPurchaseMete = applyPurchaseMete;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMaterialFreezeId() {
      return this.materialFreezeId;
   }

   public Long getFreezeDetailId() {
      return this.freezeDetailId;
   }

   public Integer getFreezeType() {
      return this.freezeType;
   }

   public Long getFreezeSourceId() {
      return this.freezeSourceId;
   }

   public String getFreezeSourceSn() {
      return this.freezeSourceSn;
   }

   public Long getOperatorId() {
      return this.operatorId;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public LocalDateTime getFrozenTime() {
      return this.frozenTime;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getOutboundUnitType() {
      return this.outboundUnitType;
   }

   public Boolean getBoolBatten() {
      return this.boolBatten;
   }

   public Boolean getBoolChangeOutbound() {
      return this.boolChangeOutbound;
   }

   public Long getApplyPurchaseId() {
      return this.applyPurchaseId;
   }

   public Long getApplyPurchaseDetailId() {
      return this.applyPurchaseDetailId;
   }

   public String getApplyPurchaseSn() {
      return this.applyPurchaseSn;
   }

   public BigDecimal getApplyPurchaseQuantity() {
      return this.applyPurchaseQuantity;
   }

   public BigDecimal getApplyPurchaseMete() {
      return this.applyPurchaseMete;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public MaterialFreezeRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("materialFreezeId")
   public MaterialFreezeRecord setMaterialFreezeId(final Long materialFreezeId) {
      this.materialFreezeId = materialFreezeId;
      return this;
   }

   @JsonProperty("freezeDetailId")
   public MaterialFreezeRecord setFreezeDetailId(final Long freezeDetailId) {
      this.freezeDetailId = freezeDetailId;
      return this;
   }

   @JsonProperty("freezeType")
   public MaterialFreezeRecord setFreezeType(final Integer freezeType) {
      this.freezeType = freezeType;
      return this;
   }

   @JsonProperty("freezeSourceId")
   public MaterialFreezeRecord setFreezeSourceId(final Long freezeSourceId) {
      this.freezeSourceId = freezeSourceId;
      return this;
   }

   @JsonProperty("freezeSourceSn")
   public MaterialFreezeRecord setFreezeSourceSn(final String freezeSourceSn) {
      this.freezeSourceSn = freezeSourceSn;
      return this;
   }

   @JsonProperty("operatorId")
   public MaterialFreezeRecord setOperatorId(final Long operatorId) {
      this.operatorId = operatorId;
      return this;
   }

   @JsonProperty("operatorName")
   public MaterialFreezeRecord setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
      return this;
   }

   @JsonProperty("quantity")
   public MaterialFreezeRecord setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("mete")
   public MaterialFreezeRecord setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("frozenTime")
   public MaterialFreezeRecord setFrozenTime(final LocalDateTime frozenTime) {
      this.frozenTime = frozenTime;
      return this;
   }

   @JsonProperty("projectId")
   public MaterialFreezeRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("outboundUnitType")
   public MaterialFreezeRecord setOutboundUnitType(final Integer outboundUnitType) {
      this.outboundUnitType = outboundUnitType;
      return this;
   }

   @JsonProperty("boolBatten")
   public MaterialFreezeRecord setBoolBatten(final Boolean boolBatten) {
      this.boolBatten = boolBatten;
      return this;
   }

   @JsonProperty("boolChangeOutbound")
   public MaterialFreezeRecord setBoolChangeOutbound(final Boolean boolChangeOutbound) {
      this.boolChangeOutbound = boolChangeOutbound;
      return this;
   }

   @JsonProperty("applyPurchaseId")
   public MaterialFreezeRecord setApplyPurchaseId(final Long applyPurchaseId) {
      this.applyPurchaseId = applyPurchaseId;
      return this;
   }

   @JsonProperty("applyPurchaseDetailId")
   public MaterialFreezeRecord setApplyPurchaseDetailId(final Long applyPurchaseDetailId) {
      this.applyPurchaseDetailId = applyPurchaseDetailId;
      return this;
   }

   @JsonProperty("applyPurchaseSn")
   public MaterialFreezeRecord setApplyPurchaseSn(final String applyPurchaseSn) {
      this.applyPurchaseSn = applyPurchaseSn;
      return this;
   }

   @JsonProperty("applyPurchaseQuantity")
   public MaterialFreezeRecord setApplyPurchaseQuantity(final BigDecimal applyPurchaseQuantity) {
      this.applyPurchaseQuantity = applyPurchaseQuantity;
      return this;
   }

   @JsonProperty("applyPurchaseMete")
   public MaterialFreezeRecord setApplyPurchaseMete(final BigDecimal applyPurchaseMete) {
      this.applyPurchaseMete = applyPurchaseMete;
      return this;
   }

   @JsonProperty("remark")
   public MaterialFreezeRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "MaterialFreezeRecord(id="
         + this.getId()
         + ", materialFreezeId="
         + this.getMaterialFreezeId()
         + ", freezeDetailId="
         + this.getFreezeDetailId()
         + ", freezeType="
         + this.getFreezeType()
         + ", freezeSourceId="
         + this.getFreezeSourceId()
         + ", freezeSourceSn="
         + this.getFreezeSourceSn()
         + ", operatorId="
         + this.getOperatorId()
         + ", operatorName="
         + this.getOperatorName()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", frozenTime="
         + this.getFrozenTime()
         + ", projectId="
         + this.getProjectId()
         + ", outboundUnitType="
         + this.getOutboundUnitType()
         + ", boolBatten="
         + this.getBoolBatten()
         + ", boolChangeOutbound="
         + this.getBoolChangeOutbound()
         + ", applyPurchaseId="
         + this.getApplyPurchaseId()
         + ", applyPurchaseDetailId="
         + this.getApplyPurchaseDetailId()
         + ", applyPurchaseSn="
         + this.getApplyPurchaseSn()
         + ", applyPurchaseQuantity="
         + this.getApplyPurchaseQuantity()
         + ", applyPurchaseMete="
         + this.getApplyPurchaseMete()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialFreezeRecord)) {
         return false;
      }

      MaterialFreezeRecord other = (MaterialFreezeRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$materialFreezeId = this.getMaterialFreezeId();
         Object other$materialFreezeId = other.getMaterialFreezeId();
         if (this$materialFreezeId == null ? other$materialFreezeId == null : this$materialFreezeId.equals(other$materialFreezeId)) {
            Object this$freezeDetailId = this.getFreezeDetailId();
            Object other$freezeDetailId = other.getFreezeDetailId();
            if (this$freezeDetailId == null ? other$freezeDetailId == null : this$freezeDetailId.equals(other$freezeDetailId)) {
               Object this$freezeType = this.getFreezeType();
               Object other$freezeType = other.getFreezeType();
               if (this$freezeType == null ? other$freezeType == null : this$freezeType.equals(other$freezeType)) {
                  Object this$freezeSourceId = this.getFreezeSourceId();
                  Object other$freezeSourceId = other.getFreezeSourceId();
                  if (this$freezeSourceId == null ? other$freezeSourceId == null : this$freezeSourceId.equals(other$freezeSourceId)) {
                     Object this$operatorId = this.getOperatorId();
                     Object other$operatorId = other.getOperatorId();
                     if (this$operatorId == null ? other$operatorId == null : this$operatorId.equals(other$operatorId)) {
                        Object this$projectId = this.getProjectId();
                        Object other$projectId = other.getProjectId();
                        if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                           Object this$outboundUnitType = this.getOutboundUnitType();
                           Object other$outboundUnitType = other.getOutboundUnitType();
                           if (this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType)) {
                              Object this$boolBatten = this.getBoolBatten();
                              Object other$boolBatten = other.getBoolBatten();
                              if (this$boolBatten == null ? other$boolBatten == null : this$boolBatten.equals(other$boolBatten)) {
                                 Object this$boolChangeOutbound = this.getBoolChangeOutbound();
                                 Object other$boolChangeOutbound = other.getBoolChangeOutbound();
                                 if (this$boolChangeOutbound == null
                                    ? other$boolChangeOutbound == null
                                    : this$boolChangeOutbound.equals(other$boolChangeOutbound)) {
                                    Object this$applyPurchaseId = this.getApplyPurchaseId();
                                    Object other$applyPurchaseId = other.getApplyPurchaseId();
                                    if (this$applyPurchaseId == null ? other$applyPurchaseId == null : this$applyPurchaseId.equals(other$applyPurchaseId)) {
                                       Object this$applyPurchaseDetailId = this.getApplyPurchaseDetailId();
                                       Object other$applyPurchaseDetailId = other.getApplyPurchaseDetailId();
                                       if (this$applyPurchaseDetailId == null
                                          ? other$applyPurchaseDetailId == null
                                          : this$applyPurchaseDetailId.equals(other$applyPurchaseDetailId)) {
                                          Object this$freezeSourceSn = this.getFreezeSourceSn();
                                          Object other$freezeSourceSn = other.getFreezeSourceSn();
                                          if (this$freezeSourceSn == null ? other$freezeSourceSn == null : this$freezeSourceSn.equals(other$freezeSourceSn)) {
                                             Object this$operatorName = this.getOperatorName();
                                             Object other$operatorName = other.getOperatorName();
                                             if (this$operatorName == null ? other$operatorName == null : this$operatorName.equals(other$operatorName)) {
                                                Object this$quantity = this.getQuantity();
                                                Object other$quantity = other.getQuantity();
                                                if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                   Object this$mete = this.getMete();
                                                   Object other$mete = other.getMete();
                                                   if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                      Object this$frozenTime = this.getFrozenTime();
                                                      Object other$frozenTime = other.getFrozenTime();
                                                      if (this$frozenTime == null ? other$frozenTime == null : this$frozenTime.equals(other$frozenTime)) {
                                                         Object this$applyPurchaseSn = this.getApplyPurchaseSn();
                                                         Object other$applyPurchaseSn = other.getApplyPurchaseSn();
                                                         if (this$applyPurchaseSn == null
                                                            ? other$applyPurchaseSn == null
                                                            : this$applyPurchaseSn.equals(other$applyPurchaseSn)) {
                                                            Object this$applyPurchaseQuantity = this.getApplyPurchaseQuantity();
                                                            Object other$applyPurchaseQuantity = other.getApplyPurchaseQuantity();
                                                            if (this$applyPurchaseQuantity == null
                                                               ? other$applyPurchaseQuantity == null
                                                               : this$applyPurchaseQuantity.equals(other$applyPurchaseQuantity)) {
                                                               Object this$applyPurchaseMete = this.getApplyPurchaseMete();
                                                               Object other$applyPurchaseMete = other.getApplyPurchaseMete();
                                                               if (this$applyPurchaseMete == null
                                                                  ? other$applyPurchaseMete == null
                                                                  : this$applyPurchaseMete.equals(other$applyPurchaseMete)) {
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
      return other instanceof MaterialFreezeRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $materialFreezeId = this.getMaterialFreezeId();
      result = result * 59 + ($materialFreezeId == null ? 43 : $materialFreezeId.hashCode());
      Object $freezeDetailId = this.getFreezeDetailId();
      result = result * 59 + ($freezeDetailId == null ? 43 : $freezeDetailId.hashCode());
      Object $freezeType = this.getFreezeType();
      result = result * 59 + ($freezeType == null ? 43 : $freezeType.hashCode());
      Object $freezeSourceId = this.getFreezeSourceId();
      result = result * 59 + ($freezeSourceId == null ? 43 : $freezeSourceId.hashCode());
      Object $operatorId = this.getOperatorId();
      result = result * 59 + ($operatorId == null ? 43 : $operatorId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $outboundUnitType = this.getOutboundUnitType();
      result = result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
      Object $boolBatten = this.getBoolBatten();
      result = result * 59 + ($boolBatten == null ? 43 : $boolBatten.hashCode());
      Object $boolChangeOutbound = this.getBoolChangeOutbound();
      result = result * 59 + ($boolChangeOutbound == null ? 43 : $boolChangeOutbound.hashCode());
      Object $applyPurchaseId = this.getApplyPurchaseId();
      result = result * 59 + ($applyPurchaseId == null ? 43 : $applyPurchaseId.hashCode());
      Object $applyPurchaseDetailId = this.getApplyPurchaseDetailId();
      result = result * 59 + ($applyPurchaseDetailId == null ? 43 : $applyPurchaseDetailId.hashCode());
      Object $freezeSourceSn = this.getFreezeSourceSn();
      result = result * 59 + ($freezeSourceSn == null ? 43 : $freezeSourceSn.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $frozenTime = this.getFrozenTime();
      result = result * 59 + ($frozenTime == null ? 43 : $frozenTime.hashCode());
      Object $applyPurchaseSn = this.getApplyPurchaseSn();
      result = result * 59 + ($applyPurchaseSn == null ? 43 : $applyPurchaseSn.hashCode());
      Object $applyPurchaseQuantity = this.getApplyPurchaseQuantity();
      result = result * 59 + ($applyPurchaseQuantity == null ? 43 : $applyPurchaseQuantity.hashCode());
      Object $applyPurchaseMete = this.getApplyPurchaseMete();
      result = result * 59 + ($applyPurchaseMete == null ? 43 : $applyPurchaseMete.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class MaterialFreezeRecordBuilder {
      private Long id;
      private Long materialFreezeId;
      private Long freezeDetailId;
      private Integer freezeType;
      private Long freezeSourceId;
      private String freezeSourceSn;
      private Long operatorId;
      private String operatorName;
      private BigDecimal quantity;
      private BigDecimal mete;
      private LocalDateTime frozenTime;
      private Long projectId;
      private Integer outboundUnitType;
      private Boolean boolBatten;
      private Boolean boolChangeOutbound;
      private Long applyPurchaseId;
      private Long applyPurchaseDetailId;
      private String applyPurchaseSn;
      private BigDecimal applyPurchaseQuantity;
      private BigDecimal applyPurchaseMete;
      private String remark;

      MaterialFreezeRecordBuilder() {
      }

      @JsonProperty("id")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("materialFreezeId")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder materialFreezeId(final Long materialFreezeId) {
         this.materialFreezeId = materialFreezeId;
         return this;
      }

      @JsonProperty("freezeDetailId")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder freezeDetailId(final Long freezeDetailId) {
         this.freezeDetailId = freezeDetailId;
         return this;
      }

      @JsonProperty("freezeType")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder freezeType(final Integer freezeType) {
         this.freezeType = freezeType;
         return this;
      }

      @JsonProperty("freezeSourceId")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder freezeSourceId(final Long freezeSourceId) {
         this.freezeSourceId = freezeSourceId;
         return this;
      }

      @JsonProperty("freezeSourceSn")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder freezeSourceSn(final String freezeSourceSn) {
         this.freezeSourceSn = freezeSourceSn;
         return this;
      }

      @JsonProperty("operatorId")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder operatorId(final Long operatorId) {
         this.operatorId = operatorId;
         return this;
      }

      @JsonProperty("operatorName")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      @JsonProperty("quantity")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("frozenTime")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder frozenTime(final LocalDateTime frozenTime) {
         this.frozenTime = frozenTime;
         return this;
      }

      @JsonProperty("projectId")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("outboundUnitType")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      @JsonProperty("boolBatten")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder boolBatten(final Boolean boolBatten) {
         this.boolBatten = boolBatten;
         return this;
      }

      @JsonProperty("boolChangeOutbound")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder boolChangeOutbound(final Boolean boolChangeOutbound) {
         this.boolChangeOutbound = boolChangeOutbound;
         return this;
      }

      @JsonProperty("applyPurchaseId")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder applyPurchaseId(final Long applyPurchaseId) {
         this.applyPurchaseId = applyPurchaseId;
         return this;
      }

      @JsonProperty("applyPurchaseDetailId")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder applyPurchaseDetailId(final Long applyPurchaseDetailId) {
         this.applyPurchaseDetailId = applyPurchaseDetailId;
         return this;
      }

      @JsonProperty("applyPurchaseSn")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder applyPurchaseSn(final String applyPurchaseSn) {
         this.applyPurchaseSn = applyPurchaseSn;
         return this;
      }

      @JsonProperty("applyPurchaseQuantity")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder applyPurchaseQuantity(final BigDecimal applyPurchaseQuantity) {
         this.applyPurchaseQuantity = applyPurchaseQuantity;
         return this;
      }

      @JsonProperty("applyPurchaseMete")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder applyPurchaseMete(final BigDecimal applyPurchaseMete) {
         this.applyPurchaseMete = applyPurchaseMete;
         return this;
      }

      @JsonProperty("remark")
      public MaterialFreezeRecord.MaterialFreezeRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MaterialFreezeRecord build() {
         return new MaterialFreezeRecord(
            this.id,
            this.materialFreezeId,
            this.freezeDetailId,
            this.freezeType,
            this.freezeSourceId,
            this.freezeSourceSn,
            this.operatorId,
            this.operatorName,
            this.quantity,
            this.mete,
            this.frozenTime,
            this.projectId,
            this.outboundUnitType,
            this.boolBatten,
            this.boolChangeOutbound,
            this.applyPurchaseId,
            this.applyPurchaseDetailId,
            this.applyPurchaseSn,
            this.applyPurchaseQuantity,
            this.applyPurchaseMete,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "MaterialFreezeRecord.MaterialFreezeRecordBuilder(id="
            + this.id
            + ", materialFreezeId="
            + this.materialFreezeId
            + ", freezeDetailId="
            + this.freezeDetailId
            + ", freezeType="
            + this.freezeType
            + ", freezeSourceId="
            + this.freezeSourceId
            + ", freezeSourceSn="
            + this.freezeSourceSn
            + ", operatorId="
            + this.operatorId
            + ", operatorName="
            + this.operatorName
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", frozenTime="
            + this.frozenTime
            + ", projectId="
            + this.projectId
            + ", outboundUnitType="
            + this.outboundUnitType
            + ", boolBatten="
            + this.boolBatten
            + ", boolChangeOutbound="
            + this.boolChangeOutbound
            + ", applyPurchaseId="
            + this.applyPurchaseId
            + ", applyPurchaseDetailId="
            + this.applyPurchaseDetailId
            + ", applyPurchaseSn="
            + this.applyPurchaseSn
            + ", applyPurchaseQuantity="
            + this.applyPurchaseQuantity
            + ", applyPurchaseMete="
            + this.applyPurchaseMete
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
