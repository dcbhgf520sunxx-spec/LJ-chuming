package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

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

@ApiModel(value = "WmsShipmentReceiveApproveDetail对象", description = "配套件领用明细排产出库审核对象")
@Entity
@TableName("wms_shipment_receive_approve_detail")
@Table(name = "wms_shipment_receive_approve_detail")
@org.hibernate.annotations.Table(appliesTo = "wms_shipment_receive_approve_detail")
public class WmsShipmentReceiveApproveDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键", notes = "主键")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "shipmentReceiveApproveId", value = "发运领用审核单ID", notes = "发运领用审核单ID")
   @TableField("shipment_receive_approve_id")
   @Column(name = "shipment_receive_approve_id", columnDefinition = "bigint  COMMENT '发运领用审核单ID'", nullable = true)
   private Long shipmentReceiveApproveId;
   @ApiModelProperty(name = "detailId", value = "配套件明细的ID", notes = "配套件明细的ID")
   @TableField("detail_id")
   @Column(name = "detail_id", columnDefinition = "bigint  COMMENT '配套件明细的ID'", nullable = true)
   private Long detailId;
   @ApiModelProperty(name = "outId", value = "关联出库单ID", notes = "关联出库单ID")
   @TableField("out_id")
   @Column(name = "out_id", columnDefinition = "bigint  COMMENT '关联出库单ID'", nullable = true)
   private Long outId;
   @ApiModelProperty(name = "outDetailId", value = "关联出库明细ID", notes = "关联出库明细ID")
   @TableField("out_detail_id")
   @Column(name = "out_detail_id", columnDefinition = "bigint  COMMENT '关联出库明细ID'", nullable = true)
   private Long outDetailId;
   @ApiModelProperty(name = "mesWorkshopId", value = "发运领用车间ID", notes = "发运领用车间ID")
   @TableField("mes_workshop_id")
   @Column(name = "mes_workshop_id", columnDefinition = "bigint  COMMENT '发运领用车间ID'", nullable = true)
   private Long mesWorkshopId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "basicClass", value = "基础类型", notes = "基础类型")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "shipmentName", value = "配套件名称", notes = "配套件名称")
   @TableField("shipment_name")
   @Column(name = "shipment_name", columnDefinition = "varchar(255)  COMMENT '配套件名称'", nullable = true)
   private String shipmentName;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "outSpecification", value = "出库规格", notes = "出库规格")
   @TableField("out_specification")
   @Column(name = "out_specification", columnDefinition = "varchar(128)  COMMENT '出库规格'", nullable = true)
   private String outSpecification;
   @ApiModelProperty(name = "outLength", value = "出库物料单个长度", notes = "出库物料单个长度")
   @TableField("out_length")
   @Column(name = "out_length", columnDefinition = "decimal(32,0)  COMMENT '出库物料单个长度'", nullable = true)
   private BigDecimal outLength;
   @ApiModelProperty(name = "outWidth", value = "出库物料单个宽度", notes = "出库物料单个宽度")
   @TableField("out_width")
   @Column(name = "out_width", columnDefinition = "decimal(32,0)  COMMENT '出库物料单个宽度'", nullable = true)
   private BigDecimal outWidth;
   @ApiModelProperty(name = "outThickness", value = "出库物料单个厚度", notes = "出库物料单个厚度")
   @TableField("out_thickness")
   @Column(name = "out_thickness", columnDefinition = "decimal(32,8)  COMMENT '出库物料单个厚度'", nullable = true)
   private BigDecimal outThickness;
   @ApiModelProperty(name = "outBrand", value = "出库品牌", notes = "出库品牌")
   @TableField("out_brand")
   @Column(name = "out_brand", columnDefinition = "varchar(255)  COMMENT '出库品牌'", nullable = true)
   private String outBrand;
   @ApiModelProperty(name = "outColor", value = "出库颜色", notes = "出库颜色")
   @TableField("out_color")
   @Column(name = "out_color", columnDefinition = "varchar(255)  COMMENT '出库颜色'", nullable = true)
   private String outColor;
   @ApiModelProperty(name = "outHeatNoAndBatchNo", value = "出库炉批号", notes = "出库炉批号")
   @TableField("out_heat_no_and_batch_no")
   @Column(name = "out_heat_no_and_batch_no", columnDefinition = "varchar(255)  COMMENT '出库炉批号'", nullable = true)
   private String outHeatNoAndBatchNo;
   @ApiModelProperty(name = "outBoolPartyA", value = "是否为甲供", notes = "是否为甲供")
   @TableField("out_bool_party_a")
   @Column(name = "out_bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供'", nullable = true)
   private Boolean outBoolPartyA;
   @ApiModelProperty(name = "outTheoryThickness", value = "出库理论厚", notes = "出库理论厚")
   @TableField("out_theory_thickness")
   @Column(name = "out_theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '出库理论厚'", nullable = true)
   private BigDecimal outTheoryThickness;
   @ApiModelProperty(name = "outStandardId", value = "出库型材执行的国标", notes = "出库型材执行的国标")
   @TableField("out_standard_id")
   @Column(name = "out_standard_id", columnDefinition = "bigint  COMMENT '出库型材执行的国标'", nullable = true)
   private Long outStandardId;
   @ApiModelProperty(name = "outStandardName", value = "出库型材执行的国标", notes = "出库型材执行的国标")
   @TableField("out_standard_name")
   @Column(name = "out_standard_name", columnDefinition = "varchar(255)  COMMENT '出库型材执行的国标'", nullable = true)
   private String outStandardName;
   @ApiModelProperty(name = "outMaterialSn", value = "出库物料编号", notes = "出库物料编号")
   @TableField("out_material_sn")
   @Column(name = "out_material_sn", columnDefinition = "varchar(255)  COMMENT '出库物料编号'", nullable = true)
   private String outMaterialSn;
   @ApiModelProperty(name = "outboundAddress", value = "出库目的地 1工厂 2工地", notes = "出库目的地 1工厂 2工地")
   @TableField("outbound_address")
   @Column(name = "outbound_address", columnDefinition = "int COMMENT '出库目的地 1工厂 2工地'", nullable = true)
   private Integer outboundAddress;
   @ApiModelProperty(name = "outMete", value = "出库核算量", notes = "出库核算量")
   @TableField("out_mete")
   @Column(name = "out_mete", columnDefinition = "decimal(32,8)  COMMENT '出库核算量'", nullable = true)
   private BigDecimal outMete;
   @ApiModelProperty(name = "outQuantity", value = "出库数量", notes = "出库数量")
   @TableField("out_quantity")
   @Column(name = "out_quantity", columnDefinition = "decimal(32,8)  COMMENT '出库数量'", nullable = true)
   private BigDecimal outQuantity;
   @ApiModelProperty(name = "unitNet", value = "单位净量", notes = "单位净量")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,8)  COMMENT '单位净量'", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "recipientId", value = "领用人ID", notes = "领用人ID")
   @TableField("recipient_id")
   @Column(name = "recipient_id", columnDefinition = "bigint  COMMENT '领用人ID'", nullable = true)
   private Long recipientId;
   @ApiModelProperty(name = "workshopId", value = "物料所属仓库", notes = "物料所属仓库")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '物料所属仓库'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "warehouseId", value = "物料所属仓库位置", notes = "物料所属仓库位置")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '物料所属仓库位置'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "materialInventoryId", value = "物料池ID", notes = "物料池ID")
   @TableField("material_Inventory_id")
   @Column(name = "material_Inventory_id", columnDefinition = "bigint  COMMENT '物料池ID'", nullable = true)
   private Long materialInventoryId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;

   public static WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder builder() {
      return new WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder();
   }

   public WmsShipmentReceiveApproveDetail() {
   }

   public WmsShipmentReceiveApproveDetail(
      final Long id,
      final Long shipmentReceiveApproveId,
      final Long detailId,
      final Long outId,
      final Long outDetailId,
      final Long mesWorkshopId,
      final Long projectId,
      final Integer basicClass,
      final String shipmentName,
      final Long classifyId,
      final String outSpecification,
      final BigDecimal outLength,
      final BigDecimal outWidth,
      final BigDecimal outThickness,
      final String outBrand,
      final String outColor,
      final String outHeatNoAndBatchNo,
      final Boolean outBoolPartyA,
      final BigDecimal outTheoryThickness,
      final Long outStandardId,
      final String outStandardName,
      final String outMaterialSn,
      final Integer outboundAddress,
      final BigDecimal outMete,
      final BigDecimal outQuantity,
      final BigDecimal unitNet,
      final Long recipientId,
      final Long workshopId,
      final Long warehouseId,
      final Long materialInventoryId,
      final String remark
   ) {
      this.id = id;
      this.shipmentReceiveApproveId = shipmentReceiveApproveId;
      this.detailId = detailId;
      this.outId = outId;
      this.outDetailId = outDetailId;
      this.mesWorkshopId = mesWorkshopId;
      this.projectId = projectId;
      this.basicClass = basicClass;
      this.shipmentName = shipmentName;
      this.classifyId = classifyId;
      this.outSpecification = outSpecification;
      this.outLength = outLength;
      this.outWidth = outWidth;
      this.outThickness = outThickness;
      this.outBrand = outBrand;
      this.outColor = outColor;
      this.outHeatNoAndBatchNo = outHeatNoAndBatchNo;
      this.outBoolPartyA = outBoolPartyA;
      this.outTheoryThickness = outTheoryThickness;
      this.outStandardId = outStandardId;
      this.outStandardName = outStandardName;
      this.outMaterialSn = outMaterialSn;
      this.outboundAddress = outboundAddress;
      this.outMete = outMete;
      this.outQuantity = outQuantity;
      this.unitNet = unitNet;
      this.recipientId = recipientId;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.materialInventoryId = materialInventoryId;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getShipmentReceiveApproveId() {
      return this.shipmentReceiveApproveId;
   }

   public Long getDetailId() {
      return this.detailId;
   }

   public Long getOutId() {
      return this.outId;
   }

   public Long getOutDetailId() {
      return this.outDetailId;
   }

   public Long getMesWorkshopId() {
      return this.mesWorkshopId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getShipmentName() {
      return this.shipmentName;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getOutSpecification() {
      return this.outSpecification;
   }

   public BigDecimal getOutLength() {
      return this.outLength;
   }

   public BigDecimal getOutWidth() {
      return this.outWidth;
   }

   public BigDecimal getOutThickness() {
      return this.outThickness;
   }

   public String getOutBrand() {
      return this.outBrand;
   }

   public String getOutColor() {
      return this.outColor;
   }

   public String getOutHeatNoAndBatchNo() {
      return this.outHeatNoAndBatchNo;
   }

   public Boolean getOutBoolPartyA() {
      return this.outBoolPartyA;
   }

   public BigDecimal getOutTheoryThickness() {
      return this.outTheoryThickness;
   }

   public Long getOutStandardId() {
      return this.outStandardId;
   }

   public String getOutStandardName() {
      return this.outStandardName;
   }

   public String getOutMaterialSn() {
      return this.outMaterialSn;
   }

   public Integer getOutboundAddress() {
      return this.outboundAddress;
   }

   public BigDecimal getOutMete() {
      return this.outMete;
   }

   public BigDecimal getOutQuantity() {
      return this.outQuantity;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public String getRemark() {
      return this.remark;
   }

   public WmsShipmentReceiveApproveDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setShipmentReceiveApproveId(final Long shipmentReceiveApproveId) {
      this.shipmentReceiveApproveId = shipmentReceiveApproveId;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setDetailId(final Long detailId) {
      this.detailId = detailId;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutId(final Long outId) {
      this.outId = outId;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutDetailId(final Long outDetailId) {
      this.outDetailId = outDetailId;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setMesWorkshopId(final Long mesWorkshopId) {
      this.mesWorkshopId = mesWorkshopId;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setShipmentName(final String shipmentName) {
      this.shipmentName = shipmentName;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutSpecification(final String outSpecification) {
      this.outSpecification = outSpecification;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutLength(final BigDecimal outLength) {
      this.outLength = outLength;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutWidth(final BigDecimal outWidth) {
      this.outWidth = outWidth;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutThickness(final BigDecimal outThickness) {
      this.outThickness = outThickness;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutBrand(final String outBrand) {
      this.outBrand = outBrand;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutColor(final String outColor) {
      this.outColor = outColor;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutHeatNoAndBatchNo(final String outHeatNoAndBatchNo) {
      this.outHeatNoAndBatchNo = outHeatNoAndBatchNo;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutBoolPartyA(final Boolean outBoolPartyA) {
      this.outBoolPartyA = outBoolPartyA;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutTheoryThickness(final BigDecimal outTheoryThickness) {
      this.outTheoryThickness = outTheoryThickness;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutStandardId(final Long outStandardId) {
      this.outStandardId = outStandardId;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutStandardName(final String outStandardName) {
      this.outStandardName = outStandardName;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutMaterialSn(final String outMaterialSn) {
      this.outMaterialSn = outMaterialSn;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutboundAddress(final Integer outboundAddress) {
      this.outboundAddress = outboundAddress;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutMete(final BigDecimal outMete) {
      this.outMete = outMete;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setOutQuantity(final BigDecimal outQuantity) {
      this.outQuantity = outQuantity;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   public WmsShipmentReceiveApproveDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "WmsShipmentReceiveApproveDetail(id="
         + this.getId()
         + ", shipmentReceiveApproveId="
         + this.getShipmentReceiveApproveId()
         + ", detailId="
         + this.getDetailId()
         + ", outId="
         + this.getOutId()
         + ", outDetailId="
         + this.getOutDetailId()
         + ", mesWorkshopId="
         + this.getMesWorkshopId()
         + ", projectId="
         + this.getProjectId()
         + ", basicClass="
         + this.getBasicClass()
         + ", shipmentName="
         + this.getShipmentName()
         + ", classifyId="
         + this.getClassifyId()
         + ", outSpecification="
         + this.getOutSpecification()
         + ", outLength="
         + this.getOutLength()
         + ", outWidth="
         + this.getOutWidth()
         + ", outThickness="
         + this.getOutThickness()
         + ", outBrand="
         + this.getOutBrand()
         + ", outColor="
         + this.getOutColor()
         + ", outHeatNoAndBatchNo="
         + this.getOutHeatNoAndBatchNo()
         + ", outBoolPartyA="
         + this.getOutBoolPartyA()
         + ", outTheoryThickness="
         + this.getOutTheoryThickness()
         + ", outStandardId="
         + this.getOutStandardId()
         + ", outStandardName="
         + this.getOutStandardName()
         + ", outMaterialSn="
         + this.getOutMaterialSn()
         + ", outboundAddress="
         + this.getOutboundAddress()
         + ", outMete="
         + this.getOutMete()
         + ", outQuantity="
         + this.getOutQuantity()
         + ", unitNet="
         + this.getUnitNet()
         + ", recipientId="
         + this.getRecipientId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsShipmentReceiveApproveDetail)) {
         return false;
      }

      WmsShipmentReceiveApproveDetail other = (WmsShipmentReceiveApproveDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$shipmentReceiveApproveId = this.getShipmentReceiveApproveId();
         Object other$shipmentReceiveApproveId = other.getShipmentReceiveApproveId();
         if (this$shipmentReceiveApproveId == null
            ? other$shipmentReceiveApproveId == null
            : this$shipmentReceiveApproveId.equals(other$shipmentReceiveApproveId)) {
            Object this$detailId = this.getDetailId();
            Object other$detailId = other.getDetailId();
            if (this$detailId == null ? other$detailId == null : this$detailId.equals(other$detailId)) {
               Object this$outId = this.getOutId();
               Object other$outId = other.getOutId();
               if (this$outId == null ? other$outId == null : this$outId.equals(other$outId)) {
                  Object this$outDetailId = this.getOutDetailId();
                  Object other$outDetailId = other.getOutDetailId();
                  if (this$outDetailId == null ? other$outDetailId == null : this$outDetailId.equals(other$outDetailId)) {
                     Object this$mesWorkshopId = this.getMesWorkshopId();
                     Object other$mesWorkshopId = other.getMesWorkshopId();
                     if (this$mesWorkshopId == null ? other$mesWorkshopId == null : this$mesWorkshopId.equals(other$mesWorkshopId)) {
                        Object this$projectId = this.getProjectId();
                        Object other$projectId = other.getProjectId();
                        if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                           Object this$basicClass = this.getBasicClass();
                           Object other$basicClass = other.getBasicClass();
                           if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                              Object this$classifyId = this.getClassifyId();
                              Object other$classifyId = other.getClassifyId();
                              if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                                 Object this$outBoolPartyA = this.getOutBoolPartyA();
                                 Object other$outBoolPartyA = other.getOutBoolPartyA();
                                 if (this$outBoolPartyA == null ? other$outBoolPartyA == null : this$outBoolPartyA.equals(other$outBoolPartyA)) {
                                    Object this$outStandardId = this.getOutStandardId();
                                    Object other$outStandardId = other.getOutStandardId();
                                    if (this$outStandardId == null ? other$outStandardId == null : this$outStandardId.equals(other$outStandardId)) {
                                       Object this$outboundAddress = this.getOutboundAddress();
                                       Object other$outboundAddress = other.getOutboundAddress();
                                       if (this$outboundAddress == null ? other$outboundAddress == null : this$outboundAddress.equals(other$outboundAddress)) {
                                          Object this$recipientId = this.getRecipientId();
                                          Object other$recipientId = other.getRecipientId();
                                          if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
                                             Object this$workshopId = this.getWorkshopId();
                                             Object other$workshopId = other.getWorkshopId();
                                             if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                Object this$warehouseId = this.getWarehouseId();
                                                Object other$warehouseId = other.getWarehouseId();
                                                if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                                   Object this$materialInventoryId = this.getMaterialInventoryId();
                                                   Object other$materialInventoryId = other.getMaterialInventoryId();
                                                   if (this$materialInventoryId == null
                                                      ? other$materialInventoryId == null
                                                      : this$materialInventoryId.equals(other$materialInventoryId)) {
                                                      Object this$shipmentName = this.getShipmentName();
                                                      Object other$shipmentName = other.getShipmentName();
                                                      if (this$shipmentName == null ? other$shipmentName == null : this$shipmentName.equals(other$shipmentName)
                                                         )
                                                       {
                                                         Object this$outSpecification = this.getOutSpecification();
                                                         Object other$outSpecification = other.getOutSpecification();
                                                         if (this$outSpecification == null
                                                            ? other$outSpecification == null
                                                            : this$outSpecification.equals(other$outSpecification)) {
                                                            Object this$outLength = this.getOutLength();
                                                            Object other$outLength = other.getOutLength();
                                                            if (this$outLength == null ? other$outLength == null : this$outLength.equals(other$outLength)) {
                                                               Object this$outWidth = this.getOutWidth();
                                                               Object other$outWidth = other.getOutWidth();
                                                               if (this$outWidth == null ? other$outWidth == null : this$outWidth.equals(other$outWidth)) {
                                                                  Object this$outThickness = this.getOutThickness();
                                                                  Object other$outThickness = other.getOutThickness();
                                                                  if (this$outThickness == null
                                                                     ? other$outThickness == null
                                                                     : this$outThickness.equals(other$outThickness)) {
                                                                     Object this$outBrand = this.getOutBrand();
                                                                     Object other$outBrand = other.getOutBrand();
                                                                     if (this$outBrand == null ? other$outBrand == null : this$outBrand.equals(other$outBrand)) {
                                                                        Object this$outColor = this.getOutColor();
                                                                        Object other$outColor = other.getOutColor();
                                                                        if (this$outColor == null
                                                                           ? other$outColor == null
                                                                           : this$outColor.equals(other$outColor)) {
                                                                           Object this$outHeatNoAndBatchNo = this.getOutHeatNoAndBatchNo();
                                                                           Object other$outHeatNoAndBatchNo = other.getOutHeatNoAndBatchNo();
                                                                           if (this$outHeatNoAndBatchNo == null
                                                                              ? other$outHeatNoAndBatchNo == null
                                                                              : this$outHeatNoAndBatchNo.equals(other$outHeatNoAndBatchNo)) {
                                                                              Object this$outTheoryThickness = this.getOutTheoryThickness();
                                                                              Object other$outTheoryThickness = other.getOutTheoryThickness();
                                                                              if (this$outTheoryThickness == null
                                                                                 ? other$outTheoryThickness == null
                                                                                 : this$outTheoryThickness.equals(other$outTheoryThickness)) {
                                                                                 Object this$outStandardName = this.getOutStandardName();
                                                                                 Object other$outStandardName = other.getOutStandardName();
                                                                                 if (this$outStandardName == null
                                                                                    ? other$outStandardName == null
                                                                                    : this$outStandardName.equals(other$outStandardName)) {
                                                                                    Object this$outMaterialSn = this.getOutMaterialSn();
                                                                                    Object other$outMaterialSn = other.getOutMaterialSn();
                                                                                    if (this$outMaterialSn == null
                                                                                       ? other$outMaterialSn == null
                                                                                       : this$outMaterialSn.equals(other$outMaterialSn)) {
                                                                                       Object this$outMete = this.getOutMete();
                                                                                       Object other$outMete = other.getOutMete();
                                                                                       if (this$outMete == null
                                                                                          ? other$outMete == null
                                                                                          : this$outMete.equals(other$outMete)) {
                                                                                          Object this$outQuantity = this.getOutQuantity();
                                                                                          Object other$outQuantity = other.getOutQuantity();
                                                                                          if (this$outQuantity == null
                                                                                             ? other$outQuantity == null
                                                                                             : this$outQuantity.equals(other$outQuantity)) {
                                                                                             Object this$unitNet = this.getUnitNet();
                                                                                             Object other$unitNet = other.getUnitNet();
                                                                                             if (this$unitNet == null
                                                                                                ? other$unitNet == null
                                                                                                : this$unitNet.equals(other$unitNet)) {
                                                                                                Object this$remark = this.getRemark();
                                                                                                Object other$remark = other.getRemark();
                                                                                                return this$remark == null
                                                                                                   ? other$remark == null
                                                                                                   : this$remark.equals(other$remark);
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
      return other instanceof WmsShipmentReceiveApproveDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $shipmentReceiveApproveId = this.getShipmentReceiveApproveId();
      result = result * 59 + ($shipmentReceiveApproveId == null ? 43 : $shipmentReceiveApproveId.hashCode());
      Object $detailId = this.getDetailId();
      result = result * 59 + ($detailId == null ? 43 : $detailId.hashCode());
      Object $outId = this.getOutId();
      result = result * 59 + ($outId == null ? 43 : $outId.hashCode());
      Object $outDetailId = this.getOutDetailId();
      result = result * 59 + ($outDetailId == null ? 43 : $outDetailId.hashCode());
      Object $mesWorkshopId = this.getMesWorkshopId();
      result = result * 59 + ($mesWorkshopId == null ? 43 : $mesWorkshopId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $outBoolPartyA = this.getOutBoolPartyA();
      result = result * 59 + ($outBoolPartyA == null ? 43 : $outBoolPartyA.hashCode());
      Object $outStandardId = this.getOutStandardId();
      result = result * 59 + ($outStandardId == null ? 43 : $outStandardId.hashCode());
      Object $outboundAddress = this.getOutboundAddress();
      result = result * 59 + ($outboundAddress == null ? 43 : $outboundAddress.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $shipmentName = this.getShipmentName();
      result = result * 59 + ($shipmentName == null ? 43 : $shipmentName.hashCode());
      Object $outSpecification = this.getOutSpecification();
      result = result * 59 + ($outSpecification == null ? 43 : $outSpecification.hashCode());
      Object $outLength = this.getOutLength();
      result = result * 59 + ($outLength == null ? 43 : $outLength.hashCode());
      Object $outWidth = this.getOutWidth();
      result = result * 59 + ($outWidth == null ? 43 : $outWidth.hashCode());
      Object $outThickness = this.getOutThickness();
      result = result * 59 + ($outThickness == null ? 43 : $outThickness.hashCode());
      Object $outBrand = this.getOutBrand();
      result = result * 59 + ($outBrand == null ? 43 : $outBrand.hashCode());
      Object $outColor = this.getOutColor();
      result = result * 59 + ($outColor == null ? 43 : $outColor.hashCode());
      Object $outHeatNoAndBatchNo = this.getOutHeatNoAndBatchNo();
      result = result * 59 + ($outHeatNoAndBatchNo == null ? 43 : $outHeatNoAndBatchNo.hashCode());
      Object $outTheoryThickness = this.getOutTheoryThickness();
      result = result * 59 + ($outTheoryThickness == null ? 43 : $outTheoryThickness.hashCode());
      Object $outStandardName = this.getOutStandardName();
      result = result * 59 + ($outStandardName == null ? 43 : $outStandardName.hashCode());
      Object $outMaterialSn = this.getOutMaterialSn();
      result = result * 59 + ($outMaterialSn == null ? 43 : $outMaterialSn.hashCode());
      Object $outMete = this.getOutMete();
      result = result * 59 + ($outMete == null ? 43 : $outMete.hashCode());
      Object $outQuantity = this.getOutQuantity();
      result = result * 59 + ($outQuantity == null ? 43 : $outQuantity.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class WmsShipmentReceiveApproveDetailBuilder {
      private Long id;
      private Long shipmentReceiveApproveId;
      private Long detailId;
      private Long outId;
      private Long outDetailId;
      private Long mesWorkshopId;
      private Long projectId;
      private Integer basicClass;
      private String shipmentName;
      private Long classifyId;
      private String outSpecification;
      private BigDecimal outLength;
      private BigDecimal outWidth;
      private BigDecimal outThickness;
      private String outBrand;
      private String outColor;
      private String outHeatNoAndBatchNo;
      private Boolean outBoolPartyA;
      private BigDecimal outTheoryThickness;
      private Long outStandardId;
      private String outStandardName;
      private String outMaterialSn;
      private Integer outboundAddress;
      private BigDecimal outMete;
      private BigDecimal outQuantity;
      private BigDecimal unitNet;
      private Long recipientId;
      private Long workshopId;
      private Long warehouseId;
      private Long materialInventoryId;
      private String remark;

      WmsShipmentReceiveApproveDetailBuilder() {
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder shipmentReceiveApproveId(final Long shipmentReceiveApproveId) {
         this.shipmentReceiveApproveId = shipmentReceiveApproveId;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder detailId(final Long detailId) {
         this.detailId = detailId;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outId(final Long outId) {
         this.outId = outId;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outDetailId(final Long outDetailId) {
         this.outDetailId = outDetailId;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder mesWorkshopId(final Long mesWorkshopId) {
         this.mesWorkshopId = mesWorkshopId;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder shipmentName(final String shipmentName) {
         this.shipmentName = shipmentName;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outSpecification(final String outSpecification) {
         this.outSpecification = outSpecification;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outLength(final BigDecimal outLength) {
         this.outLength = outLength;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outWidth(final BigDecimal outWidth) {
         this.outWidth = outWidth;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outThickness(final BigDecimal outThickness) {
         this.outThickness = outThickness;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outBrand(final String outBrand) {
         this.outBrand = outBrand;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outColor(final String outColor) {
         this.outColor = outColor;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outHeatNoAndBatchNo(final String outHeatNoAndBatchNo) {
         this.outHeatNoAndBatchNo = outHeatNoAndBatchNo;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outBoolPartyA(final Boolean outBoolPartyA) {
         this.outBoolPartyA = outBoolPartyA;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outTheoryThickness(final BigDecimal outTheoryThickness) {
         this.outTheoryThickness = outTheoryThickness;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outStandardId(final Long outStandardId) {
         this.outStandardId = outStandardId;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outStandardName(final String outStandardName) {
         this.outStandardName = outStandardName;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outMaterialSn(final String outMaterialSn) {
         this.outMaterialSn = outMaterialSn;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outboundAddress(final Integer outboundAddress) {
         this.outboundAddress = outboundAddress;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outMete(final BigDecimal outMete) {
         this.outMete = outMete;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder outQuantity(final BigDecimal outQuantity) {
         this.outQuantity = outQuantity;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      public WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public WmsShipmentReceiveApproveDetail build() {
         return new WmsShipmentReceiveApproveDetail(
            this.id,
            this.shipmentReceiveApproveId,
            this.detailId,
            this.outId,
            this.outDetailId,
            this.mesWorkshopId,
            this.projectId,
            this.basicClass,
            this.shipmentName,
            this.classifyId,
            this.outSpecification,
            this.outLength,
            this.outWidth,
            this.outThickness,
            this.outBrand,
            this.outColor,
            this.outHeatNoAndBatchNo,
            this.outBoolPartyA,
            this.outTheoryThickness,
            this.outStandardId,
            this.outStandardName,
            this.outMaterialSn,
            this.outboundAddress,
            this.outMete,
            this.outQuantity,
            this.unitNet,
            this.recipientId,
            this.workshopId,
            this.warehouseId,
            this.materialInventoryId,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "WmsShipmentReceiveApproveDetail.WmsShipmentReceiveApproveDetailBuilder(id="
            + this.id
            + ", shipmentReceiveApproveId="
            + this.shipmentReceiveApproveId
            + ", detailId="
            + this.detailId
            + ", outId="
            + this.outId
            + ", outDetailId="
            + this.outDetailId
            + ", mesWorkshopId="
            + this.mesWorkshopId
            + ", projectId="
            + this.projectId
            + ", basicClass="
            + this.basicClass
            + ", shipmentName="
            + this.shipmentName
            + ", classifyId="
            + this.classifyId
            + ", outSpecification="
            + this.outSpecification
            + ", outLength="
            + this.outLength
            + ", outWidth="
            + this.outWidth
            + ", outThickness="
            + this.outThickness
            + ", outBrand="
            + this.outBrand
            + ", outColor="
            + this.outColor
            + ", outHeatNoAndBatchNo="
            + this.outHeatNoAndBatchNo
            + ", outBoolPartyA="
            + this.outBoolPartyA
            + ", outTheoryThickness="
            + this.outTheoryThickness
            + ", outStandardId="
            + this.outStandardId
            + ", outStandardName="
            + this.outStandardName
            + ", outMaterialSn="
            + this.outMaterialSn
            + ", outboundAddress="
            + this.outboundAddress
            + ", outMete="
            + this.outMete
            + ", outQuantity="
            + this.outQuantity
            + ", unitNet="
            + this.unitNet
            + ", recipientId="
            + this.recipientId
            + ", workshopId="
            + this.workshopId
            + ", warehouseId="
            + this.warehouseId
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
