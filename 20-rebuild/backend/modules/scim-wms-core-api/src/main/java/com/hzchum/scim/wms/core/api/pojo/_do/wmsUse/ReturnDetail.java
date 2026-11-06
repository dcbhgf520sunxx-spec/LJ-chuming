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

@ApiModel(value = "ReturnDetail对象", description = "退库详情表 ")
@Entity
@TableName("wms_return_detail")
@Table(name = "wms_return_detail")
public class ReturnDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "科目编号", notes = "科目编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '科目编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "quantity", value = "计量量", notes = "计量量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '计量量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "unitNet", value = "单位净量", notes = "单位净量")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,8)  COMMENT '单位净量'", nullable = true)
   private BigDecimal unitNet;
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
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号", notes = "炉批号")
   @JsonProperty("heatNoAndBatchNo")
   @JSONField(name = "heatNoAndBatchNo")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no", columnDefinition = "varchar(255)  COMMENT '炉批号'", nullable = true)
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "remark", value = "退库备注", notes = "退库备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '退库备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID", notes = "仓库ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库ID'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "materialReturnableId", value = "可退库物料ID", notes = "可退库物料ID")
   @JsonProperty("materialReturnableId")
   @JSONField(name = "materialReturnableId")
   @TableField("material_returnable_id")
   @Column(name = "material_returnable_id", columnDefinition = "bigint  COMMENT '可退库物料ID'", nullable = true)
   private Long materialReturnableId;
   @ApiModelProperty(name = "returnId", value = "退库单ID", notes = "退库单ID")
   @JsonProperty("returnId")
   @JSONField(name = "returnId")
   @TableField("return_id")
   @Column(name = "return_id", columnDefinition = "bigint  COMMENT '退库单ID'", nullable = true)
   private Long returnId;
   @ApiModelProperty(name = "amount", value = "总价", notes = "总价")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = " 不含税总价", notes = " 不含税总价")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_vat")
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT ' 不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "进项税", notes = "进项税")
   @JsonProperty("inputVat")
   @JSONField(name = "inputVat")
   @TableField("input_vat")
   @Column(name = "input_vat", columnDefinition = "decimal(32,12)  COMMENT '进项税'", nullable = true)
   private BigDecimal inputVat;
   @ApiModelProperty(name = "invoiceType", value = "发票类型", notes = "发票类型")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int  COMMENT '发票类型'", nullable = true)
   private Integer invoiceType;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态", notes = "物料状态")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT '物料状态'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "outboundId", value = "出库单ID", notes = "出库单ID")
   @JsonProperty("outboundId")
   @JSONField(name = "outboundId")
   @TableField("outbound_id")
   @Column(name = "outbound_id", columnDefinition = "bigint  COMMENT '出库单ID'", nullable = true)
   private Long outboundId;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税单价", notes = "不含税单价")
   @JsonProperty("unitPriceExcludingVat")
   @JSONField(name = "unitPriceExcludingVat")
   @TableField("unit_price_excluding_vat")
   @Column(name = "unit_price_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税单价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚", notes = "理论厚")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '理论厚'", nullable = true)
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供材料", notes = "是否为甲供材料")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供材料'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "standardId", value = "型材执行的国标ID", notes = "型材执行的国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '型材执行的国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "型材执行国标名称", notes = "型材执行国标名称")
   @JsonProperty("standardName")
   @JSONField(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(255)  COMMENT '型材执行国标名称'", nullable = true)
   private String standardName;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint  COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "materialSn")
   @JsonProperty("materialSn")
   @JSONField(name = "materialSn")
   @TableField("material_sn")
   @Column(name = "material_sn", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String materialSn;
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "boolReturns", value = "是否为余料多退")
   @JsonProperty("boolReturns")
   @JSONField(name = "boolReturns")
   @TableField("bool_returns")
   @Column(name = "bool_returns")
   private Boolean boolReturns;
   @ApiModelProperty(name = "boardId", value = "余料多退整板的整板对应明细id", notes = "余料多退整板的整板对应明细id")
   @JsonProperty("boardId")
   @JSONField(name = "boardId")
   @TableField("board_id")
   @Column(name = "board_id", columnDefinition = "bigint(20)  COMMENT '余料多退整板的整板对应明细id'", nullable = true)
   private Long boardId;
   @ApiModelProperty(name = "singleReturnMete", value = "退库单件核算量(余料多退使用)")
   @JsonProperty("singleReturnMete")
   @JSONField(name = "singleReturnMete")
   @TableField("single_return_mete")
   @Column(name = "single_return_mete")
   private BigDecimal singleReturnMete;
   @ApiModelProperty(name = "singleQuantity", value = "退库单件余料计量(余料多退使用)")
   @JsonProperty("singleQuantity")
   @JSONField(name = "singleQuantity")
   @TableField("single_quantity")
   @Column(name = "single_quantity")
   private BigDecimal singleQuantity;
   @ApiModelProperty(name = "sourceWorkshopId", value = "原车间ID", notes = "原车间ID")
   @JsonProperty("sourceWorkshopId")
   @JSONField(name = "sourceWorkshopId")
   @TableField("source_workshop_id")
   @Column(name = "source_workshop_id", columnDefinition = "bigint  COMMENT '原车间ID'", nullable = true)
   private Long sourceWorkshopId;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "单价 不含运费", notes = "单价 不含运费")
   @JsonProperty("unitPriceNoFreight")
   @JSONField(name = "unitPriceNoFreight")
   @TableField("unit_price_no_freight")
   @Column(name = "unit_price_no_freight", columnDefinition = "decimal(32,12)  COMMENT '单价 不含运费'", nullable = true)
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "unitPriceExcludingVatNoFreight", value = "不含税单价 不含运费", notes = "不含税单价 不含运费")
   @JsonProperty("unitPriceExcludingVatNoFreight")
   @JSONField(name = "unitPriceExcludingVatNoFreight")
   @TableField("unit_price_excluding_vat_no_freight")
   @Column(name = "unit_price_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税单价 不含运费'", nullable = true)
   private BigDecimal unitPriceExcludingVatNoFreight;
   @ApiModelProperty(name = "amountNoFreight", value = "总价 不含运费", notes = "总价 不含运费")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '总价 不含运费'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = " 不含税总价 不含运费", notes = " 不含税总价 不含运费")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_vat_no_freight")
   @Column(name = "amount_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT ' 不含税总价 不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "inputVatNoFreight", value = "进项税 不含运费", notes = "进项税 不含运费")
   @JsonProperty("inputVatNoFreight")
   @JSONField(name = "inputVatNoFreight")
   @TableField("input_vat_no_freight")
   @Column(name = "input_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '进项税 不含运费'", nullable = true)
   private BigDecimal inputVatNoFreight;
   @ApiModelProperty(name = "returnDetailWholeId", value = "wms_return_detail_whole的id 将退的整料和余料退库明细关联起来")
   @JsonProperty("returnDetailWholeId")
   @JSONField(name = "returnDetailWholeId")
   @TableField("return_detail_whole_id")
   @Column(name = "return_detail_whole_id", columnDefinition = "bigint COMMENT 'wms_return_detail_whole的id 将退的整料和余料退库明细关联起来'", nullable = true)
   private Long returnDetailWholeId;
   @ApiModelProperty(name = "remnantId", value = "余料可退库单ID")
   @JsonProperty("remnantId")
   @JSONField(name = "remnantId")
   @TableField("remnant_id")
   @Column(name = "remnant_id", columnDefinition = "bigint COMMENT '余料可退库单ID'", nullable = true)
   private Long remnantId;
   @ApiModelProperty(name = "outboundTypeSelection", value = "出库类型 枚举类[OutboundTypeEnum]", notes = "出库类型 枚举类[OutboundTypeEnum]")
   @JsonProperty("outboundTypeSelection")
   @JSONField(name = "outboundTypeSelection")
   @TableField("outbound_type_selection")
   @Column(name = "outbound_type_selection", columnDefinition = "int default '1' COMMENT '出库类型 枚举类[OutboundTypeEnum]'", nullable = false)
   private Integer outboundTypeSelection;
   @ApiModelProperty(name = "boolNestSurplus", value = "柏楚余料(只有来柏楚拍照的余料和套料剩下的余料此属性才有true)", notes = "柏楚余料")
   @JsonProperty("boolNestSurplus")
   @JSONField(name = "boolNestSurplus")
   @TableField("bool_nest_surplus")
   @Column(name = "bool_nest_surplus", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '柏楚余料'", nullable = true)
   private Boolean boolNestSurplus;
   @ApiModelProperty(name = "area", value = "柏楚余料面积", notes = "柏楚余料面积")
   @JsonProperty("area")
   @JSONField(name = "area")
   @TableField("area")
   @Column(name = "area", columnDefinition = "decimal(32,12)  COMMENT ' 柏楚余料面积'", nullable = true)
   private BigDecimal area;
   @ApiModelProperty(name = "nestSurplusCode", value = "余料编码，拍照保存的时候就生成", notes = "拍照保存的时候就生成")
   @JsonProperty("nestSurplusCode")
   @JSONField(name = "nestSurplusCode")
   @TableField("nest_surplus_code")
   @Column(name = "nest_surplus_code", columnDefinition = "varchar(255)  COMMENT '余料编码，拍照保存的时候就生成'", nullable = true)
   private String nestSurplusCode;
   @ApiModelProperty(name = "surplusSn", value = "余料编号", notes = "余料编号")
   @JsonProperty("surplusSn")
   @JSONField(name = "surplusSn")
   @TableField("surplus_sn")
   @Column(name = "surplus_sn", columnDefinition = "varchar(255)  COMMENT '余料编号'", nullable = true)
   private String surplusSn;
   @ApiModelProperty(name = "dxfUrl", value = "app拍照dxfUrl", notes = "app拍照dxfUrl")
   @JsonProperty("dxfUrl")
   @JSONField(name = "dxfUrl")
   @TableField("dxf_url")
   @Column(name = "dxf_url", columnDefinition = "varchar(5000)  COMMENT 'app拍照dxfUrl'", nullable = true)
   private String dxfUrl;
   @ApiModelProperty(name = "imgUrl", value = "app拍照缩略图", notes = "app拍照缩略图")
   @JsonProperty("imgUrl")
   @JSONField(name = "imgUrl")
   @TableField("img_url")
   @Column(name = "img_url", columnDefinition = "varchar(5000)  COMMENT 'app拍照缩略图'", nullable = true)
   private String imgUrl;
   @ApiModelProperty(name = "realTime", value = "实际入库时间")
   @JsonProperty("realTime")
   @JSONField(name = "realTime")
   @TableField("real_time")
   @Column(name = "real_time")
   private LocalDateTime realTime;
   @ApiModelProperty(name = "wapId", value = "加权价ID", notes = "加权价ID")
   @JsonProperty("wapId")
   @JSONField(name = "wapId")
   @TableField("wap_id")
   @Column(name = "wap_id", columnDefinition = "bigint(20)  COMMENT '加权价ID'", nullable = true)
   private Long wapId;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态[1 待审核,2 审核通过, 15 该出库单已被删除]")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status")
   private Integer reviewStatus;

   public static ReturnDetail.ReturnDetailBuilder builder() {
      return new ReturnDetail.ReturnDetailBuilder();
   }

   public ReturnDetail() {
   }

   public ReturnDetail(
      final Long id,
      final String serialNumber,
      final Long classifyId,
      final Integer basicClass,
      final String specification,
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal unitNet,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final String remark,
      final Long projectId,
      final Long warehouseId,
      final Long materialReturnableId,
      final Long returnId,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final Integer invoiceType,
      final Integer materialIsWhole,
      final BigDecimal unitPrice,
      final Long outboundId,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal taxRate,
      final BigDecimal theoryThickness,
      final Boolean boolPartyA,
      final Long standardId,
      final String standardName,
      final Long monomerId,
      final Long areaId,
      final String materialSn,
      final Long workshopId,
      final Boolean boolReturns,
      final Long boardId,
      final BigDecimal singleReturnMete,
      final BigDecimal singleQuantity,
      final Long sourceWorkshopId,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal unitPriceExcludingVatNoFreight,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal inputVatNoFreight,
      final Long returnDetailWholeId,
      final Long remnantId,
      final Integer outboundTypeSelection,
      final Boolean boolNestSurplus,
      final BigDecimal area,
      final String nestSurplusCode,
      final String surplusSn,
      final String dxfUrl,
      final String imgUrl,
      final LocalDateTime realTime,
      final Long wapId,
      final Integer reviewStatus
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.specification = specification;
      this.quantity = quantity;
      this.mete = mete;
      this.unitNet = unitNet;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.remark = remark;
      this.projectId = projectId;
      this.warehouseId = warehouseId;
      this.materialReturnableId = materialReturnableId;
      this.returnId = returnId;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.invoiceType = invoiceType;
      this.materialIsWhole = materialIsWhole;
      this.unitPrice = unitPrice;
      this.outboundId = outboundId;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.taxRate = taxRate;
      this.theoryThickness = theoryThickness;
      this.boolPartyA = boolPartyA;
      this.standardId = standardId;
      this.standardName = standardName;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.materialSn = materialSn;
      this.workshopId = workshopId;
      this.boolReturns = boolReturns;
      this.boardId = boardId;
      this.singleReturnMete = singleReturnMete;
      this.singleQuantity = singleQuantity;
      this.sourceWorkshopId = sourceWorkshopId;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.inputVatNoFreight = inputVatNoFreight;
      this.returnDetailWholeId = returnDetailWholeId;
      this.remnantId = remnantId;
      this.outboundTypeSelection = outboundTypeSelection;
      this.boolNestSurplus = boolNestSurplus;
      this.area = area;
      this.nestSurplusCode = nestSurplusCode;
      this.surplusSn = surplusSn;
      this.dxfUrl = dxfUrl;
      this.imgUrl = imgUrl;
      this.realTime = realTime;
      this.wapId = wapId;
      this.reviewStatus = reviewStatus;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
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

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getMaterialReturnableId() {
      return this.materialReturnableId;
   }

   public Long getReturnId() {
      return this.returnId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Boolean getBoolReturns() {
      return this.boolReturns;
   }

   public Long getBoardId() {
      return this.boardId;
   }

   public BigDecimal getSingleReturnMete() {
      return this.singleReturnMete;
   }

   public BigDecimal getSingleQuantity() {
      return this.singleQuantity;
   }

   public Long getSourceWorkshopId() {
      return this.sourceWorkshopId;
   }

   public BigDecimal getUnitPriceNoFreight() {
      return this.unitPriceNoFreight;
   }

   public BigDecimal getUnitPriceExcludingVatNoFreight() {
      return this.unitPriceExcludingVatNoFreight;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public BigDecimal getAmountExcludingVatNoFreight() {
      return this.amountExcludingVatNoFreight;
   }

   public BigDecimal getInputVatNoFreight() {
      return this.inputVatNoFreight;
   }

   public Long getReturnDetailWholeId() {
      return this.returnDetailWholeId;
   }

   public Long getRemnantId() {
      return this.remnantId;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public Boolean getBoolNestSurplus() {
      return this.boolNestSurplus;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public String getNestSurplusCode() {
      return this.nestSurplusCode;
   }

   public String getSurplusSn() {
      return this.surplusSn;
   }

   public String getDxfUrl() {
      return this.dxfUrl;
   }

   public String getImgUrl() {
      return this.imgUrl;
   }

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   public Long getWapId() {
      return this.wapId;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   @JsonProperty("id")
   public ReturnDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public ReturnDetail setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("classifyId")
   public ReturnDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("basicClass")
   public ReturnDetail setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("specification")
   public ReturnDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("quantity")
   public ReturnDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("mete")
   public ReturnDetail setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("unitNet")
   public ReturnDetail setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("length")
   public ReturnDetail setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public ReturnDetail setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public ReturnDetail setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("brand")
   public ReturnDetail setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public ReturnDetail setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public ReturnDetail setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("remark")
   public ReturnDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("projectId")
   public ReturnDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("warehouseId")
   public ReturnDetail setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("materialReturnableId")
   public ReturnDetail setMaterialReturnableId(final Long materialReturnableId) {
      this.materialReturnableId = materialReturnableId;
      return this;
   }

   @JsonProperty("returnId")
   public ReturnDetail setReturnId(final Long returnId) {
      this.returnId = returnId;
      return this;
   }

   @JsonProperty("amount")
   public ReturnDetail setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public ReturnDetail setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("inputVat")
   public ReturnDetail setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("invoiceType")
   public ReturnDetail setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public ReturnDetail setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("unitPrice")
   public ReturnDetail setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("outboundId")
   public ReturnDetail setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public ReturnDetail setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("taxRate")
   public ReturnDetail setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("theoryThickness")
   public ReturnDetail setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("boolPartyA")
   public ReturnDetail setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("standardId")
   public ReturnDetail setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public ReturnDetail setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("monomerId")
   public ReturnDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ReturnDetail setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("materialSn")
   public ReturnDetail setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
      return this;
   }

   @JsonProperty("workshopId")
   public ReturnDetail setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("boolReturns")
   public ReturnDetail setBoolReturns(final Boolean boolReturns) {
      this.boolReturns = boolReturns;
      return this;
   }

   @JsonProperty("boardId")
   public ReturnDetail setBoardId(final Long boardId) {
      this.boardId = boardId;
      return this;
   }

   @JsonProperty("singleReturnMete")
   public ReturnDetail setSingleReturnMete(final BigDecimal singleReturnMete) {
      this.singleReturnMete = singleReturnMete;
      return this;
   }

   @JsonProperty("singleQuantity")
   public ReturnDetail setSingleQuantity(final BigDecimal singleQuantity) {
      this.singleQuantity = singleQuantity;
      return this;
   }

   @JsonProperty("sourceWorkshopId")
   public ReturnDetail setSourceWorkshopId(final Long sourceWorkshopId) {
      this.sourceWorkshopId = sourceWorkshopId;
      return this;
   }

   @JsonProperty("unitPriceNoFreight")
   public ReturnDetail setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
      return this;
   }

   @JsonProperty("unitPriceExcludingVatNoFreight")
   public ReturnDetail setUnitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public ReturnDetail setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public ReturnDetail setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("inputVatNoFreight")
   public ReturnDetail setInputVatNoFreight(final BigDecimal inputVatNoFreight) {
      this.inputVatNoFreight = inputVatNoFreight;
      return this;
   }

   @JsonProperty("returnDetailWholeId")
   public ReturnDetail setReturnDetailWholeId(final Long returnDetailWholeId) {
      this.returnDetailWholeId = returnDetailWholeId;
      return this;
   }

   @JsonProperty("remnantId")
   public ReturnDetail setRemnantId(final Long remnantId) {
      this.remnantId = remnantId;
      return this;
   }

   @JsonProperty("outboundTypeSelection")
   public ReturnDetail setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
      return this;
   }

   @JsonProperty("boolNestSurplus")
   public ReturnDetail setBoolNestSurplus(final Boolean boolNestSurplus) {
      this.boolNestSurplus = boolNestSurplus;
      return this;
   }

   @JsonProperty("area")
   public ReturnDetail setArea(final BigDecimal area) {
      this.area = area;
      return this;
   }

   @JsonProperty("nestSurplusCode")
   public ReturnDetail setNestSurplusCode(final String nestSurplusCode) {
      this.nestSurplusCode = nestSurplusCode;
      return this;
   }

   @JsonProperty("surplusSn")
   public ReturnDetail setSurplusSn(final String surplusSn) {
      this.surplusSn = surplusSn;
      return this;
   }

   @JsonProperty("dxfUrl")
   public ReturnDetail setDxfUrl(final String dxfUrl) {
      this.dxfUrl = dxfUrl;
      return this;
   }

   @JsonProperty("imgUrl")
   public ReturnDetail setImgUrl(final String imgUrl) {
      this.imgUrl = imgUrl;
      return this;
   }

   @JsonProperty("realTime")
   public ReturnDetail setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
      return this;
   }

   @JsonProperty("wapId")
   public ReturnDetail setWapId(final Long wapId) {
      this.wapId = wapId;
      return this;
   }

   @JsonProperty("reviewStatus")
   public ReturnDetail setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ReturnDetail(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", unitNet="
         + this.getUnitNet()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", remark="
         + this.getRemark()
         + ", projectId="
         + this.getProjectId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", materialReturnableId="
         + this.getMaterialReturnableId()
         + ", returnId="
         + this.getReturnId()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", outboundId="
         + this.getOutboundId()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", taxRate="
         + this.getTaxRate()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", materialSn="
         + this.getMaterialSn()
         + ", workshopId="
         + this.getWorkshopId()
         + ", boolReturns="
         + this.getBoolReturns()
         + ", boardId="
         + this.getBoardId()
         + ", singleReturnMete="
         + this.getSingleReturnMete()
         + ", singleQuantity="
         + this.getSingleQuantity()
         + ", sourceWorkshopId="
         + this.getSourceWorkshopId()
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", unitPriceExcludingVatNoFreight="
         + this.getUnitPriceExcludingVatNoFreight()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", inputVatNoFreight="
         + this.getInputVatNoFreight()
         + ", returnDetailWholeId="
         + this.getReturnDetailWholeId()
         + ", remnantId="
         + this.getRemnantId()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", boolNestSurplus="
         + this.getBoolNestSurplus()
         + ", area="
         + this.getArea()
         + ", nestSurplusCode="
         + this.getNestSurplusCode()
         + ", surplusSn="
         + this.getSurplusSn()
         + ", dxfUrl="
         + this.getDxfUrl()
         + ", imgUrl="
         + this.getImgUrl()
         + ", realTime="
         + this.getRealTime()
         + ", wapId="
         + this.getWapId()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReturnDetail)) {
         return false;
      }

      ReturnDetail other = (ReturnDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$warehouseId = this.getWarehouseId();
                  Object other$warehouseId = other.getWarehouseId();
                  if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                     Object this$materialReturnableId = this.getMaterialReturnableId();
                     Object other$materialReturnableId = other.getMaterialReturnableId();
                     if (this$materialReturnableId == null ? other$materialReturnableId == null : this$materialReturnableId.equals(other$materialReturnableId)) {
                        Object this$returnId = this.getReturnId();
                        Object other$returnId = other.getReturnId();
                        if (this$returnId == null ? other$returnId == null : this$returnId.equals(other$returnId)) {
                           Object this$invoiceType = this.getInvoiceType();
                           Object other$invoiceType = other.getInvoiceType();
                           if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                              Object this$materialIsWhole = this.getMaterialIsWhole();
                              Object other$materialIsWhole = other.getMaterialIsWhole();
                              if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                                 Object this$outboundId = this.getOutboundId();
                                 Object other$outboundId = other.getOutboundId();
                                 if (this$outboundId == null ? other$outboundId == null : this$outboundId.equals(other$outboundId)) {
                                    Object this$boolPartyA = this.getBoolPartyA();
                                    Object other$boolPartyA = other.getBoolPartyA();
                                    if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                       Object this$standardId = this.getStandardId();
                                       Object other$standardId = other.getStandardId();
                                       if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                          Object this$monomerId = this.getMonomerId();
                                          Object other$monomerId = other.getMonomerId();
                                          if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                             Object this$areaId = this.getAreaId();
                                             Object other$areaId = other.getAreaId();
                                             if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                                Object this$workshopId = this.getWorkshopId();
                                                Object other$workshopId = other.getWorkshopId();
                                                if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                   Object this$boolReturns = this.getBoolReturns();
                                                   Object other$boolReturns = other.getBoolReturns();
                                                   if (this$boolReturns == null ? other$boolReturns == null : this$boolReturns.equals(other$boolReturns)) {
                                                      Object this$boardId = this.getBoardId();
                                                      Object other$boardId = other.getBoardId();
                                                      if (this$boardId == null ? other$boardId == null : this$boardId.equals(other$boardId)) {
                                                         Object this$sourceWorkshopId = this.getSourceWorkshopId();
                                                         Object other$sourceWorkshopId = other.getSourceWorkshopId();
                                                         if (this$sourceWorkshopId == null
                                                            ? other$sourceWorkshopId == null
                                                            : this$sourceWorkshopId.equals(other$sourceWorkshopId)) {
                                                            Object this$returnDetailWholeId = this.getReturnDetailWholeId();
                                                            Object other$returnDetailWholeId = other.getReturnDetailWholeId();
                                                            if (this$returnDetailWholeId == null
                                                               ? other$returnDetailWholeId == null
                                                               : this$returnDetailWholeId.equals(other$returnDetailWholeId)) {
                                                               Object this$remnantId = this.getRemnantId();
                                                               Object other$remnantId = other.getRemnantId();
                                                               if (this$remnantId == null ? other$remnantId == null : this$remnantId.equals(other$remnantId)) {
                                                                  Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                                                                  Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                                                                  if (this$outboundTypeSelection == null
                                                                     ? other$outboundTypeSelection == null
                                                                     : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                                                                     Object this$boolNestSurplus = this.getBoolNestSurplus();
                                                                     Object other$boolNestSurplus = other.getBoolNestSurplus();
                                                                     if (this$boolNestSurplus == null
                                                                        ? other$boolNestSurplus == null
                                                                        : this$boolNestSurplus.equals(other$boolNestSurplus)) {
                                                                        Object this$wapId = this.getWapId();
                                                                        Object other$wapId = other.getWapId();
                                                                        if (this$wapId == null ? other$wapId == null : this$wapId.equals(other$wapId)) {
                                                                           Object this$reviewStatus = this.getReviewStatus();
                                                                           Object other$reviewStatus = other.getReviewStatus();
                                                                           if (this$reviewStatus == null
                                                                              ? other$reviewStatus == null
                                                                              : this$reviewStatus.equals(other$reviewStatus)) {
                                                                              Object this$serialNumber = this.getSerialNumber();
                                                                              Object other$serialNumber = other.getSerialNumber();
                                                                              if (this$serialNumber == null
                                                                                 ? other$serialNumber == null
                                                                                 : this$serialNumber.equals(other$serialNumber)) {
                                                                                 Object this$specification = this.getSpecification();
                                                                                 Object other$specification = other.getSpecification();
                                                                                 if (this$specification == null
                                                                                    ? other$specification == null
                                                                                    : this$specification.equals(other$specification)) {
                                                                                    Object this$quantity = this.getQuantity();
                                                                                    Object other$quantity = other.getQuantity();
                                                                                    if (this$quantity == null
                                                                                       ? other$quantity == null
                                                                                       : this$quantity.equals(other$quantity)) {
                                                                                       Object this$mete = this.getMete();
                                                                                       Object other$mete = other.getMete();
                                                                                       if (this$mete == null
                                                                                          ? other$mete == null
                                                                                          : this$mete.equals(other$mete)) {
                                                                                          Object this$unitNet = this.getUnitNet();
                                                                                          Object other$unitNet = other.getUnitNet();
                                                                                          if (this$unitNet == null
                                                                                             ? other$unitNet == null
                                                                                             : this$unitNet.equals(other$unitNet)) {
                                                                                             Object this$length = this.getLength();
                                                                                             Object other$length = other.getLength();
                                                                                             if (this$length == null
                                                                                                ? other$length == null
                                                                                                : this$length.equals(other$length)) {
                                                                                                Object this$width = this.getWidth();
                                                                                                Object other$width = other.getWidth();
                                                                                                if (this$width == null
                                                                                                   ? other$width == null
                                                                                                   : this$width.equals(other$width)) {
                                                                                                   Object this$thickness = this.getThickness();
                                                                                                   Object other$thickness = other.getThickness();
                                                                                                   if (this$thickness == null
                                                                                                      ? other$thickness == null
                                                                                                      : this$thickness.equals(other$thickness)) {
                                                                                                      Object this$brand = this.getBrand();
                                                                                                      Object other$brand = other.getBrand();
                                                                                                      if (this$brand == null
                                                                                                         ? other$brand == null
                                                                                                         : this$brand.equals(other$brand)) {
                                                                                                         Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                                         Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                                         if (this$heatNoAndBatchNo == null
                                                                                                            ? other$heatNoAndBatchNo == null
                                                                                                            : this$heatNoAndBatchNo.equals(
                                                                                                               other$heatNoAndBatchNo
                                                                                                            )) {
                                                                                                            Object this$color = this.getColor();
                                                                                                            Object other$color = other.getColor();
                                                                                                            if (this$color == null
                                                                                                               ? other$color == null
                                                                                                               : this$color.equals(other$color)) {
                                                                                                               Object this$remark = this.getRemark();
                                                                                                               Object other$remark = other.getRemark();
                                                                                                               if (this$remark == null
                                                                                                                  ? other$remark == null
                                                                                                                  : this$remark.equals(other$remark)) {
                                                                                                                  Object this$amount = this.getAmount();
                                                                                                                  Object other$amount = other.getAmount();
                                                                                                                  if (this$amount == null
                                                                                                                     ? other$amount == null
                                                                                                                     : this$amount.equals(other$amount)) {
                                                                                                                     Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                                                     Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                                                     if (this$amountExcludingVat == null
                                                                                                                        ? other$amountExcludingVat == null
                                                                                                                        : this$amountExcludingVat.equals(
                                                                                                                           other$amountExcludingVat
                                                                                                                        )) {
                                                                                                                        Object this$inputVat = this.getInputVat();
                                                                                                                        Object other$inputVat = other.getInputVat();
                                                                                                                        if (this$inputVat == null
                                                                                                                           ? other$inputVat == null
                                                                                                                           : this$inputVat.equals(
                                                                                                                              other$inputVat
                                                                                                                           )) {
                                                                                                                           Object this$unitPrice = this.getUnitPrice();
                                                                                                                           Object other$unitPrice = other.getUnitPrice();
                                                                                                                           if (this$unitPrice == null
                                                                                                                              ? other$unitPrice == null
                                                                                                                              : this$unitPrice.equals(
                                                                                                                                 other$unitPrice
                                                                                                                              )) {
                                                                                                                              Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                                                                                              Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                                                                                              if (this$unitPriceExcludingVat
                                                                                                                                    == null
                                                                                                                                 ? other$unitPriceExcludingVat
                                                                                                                                    == null
                                                                                                                                 : this$unitPriceExcludingVat.equals(
                                                                                                                                    other$unitPriceExcludingVat
                                                                                                                                 )) {
                                                                                                                                 Object this$taxRate = this.getTaxRate();
                                                                                                                                 Object other$taxRate = other.getTaxRate();
                                                                                                                                 if (this$taxRate == null
                                                                                                                                    ? other$taxRate == null
                                                                                                                                    : this$taxRate.equals(
                                                                                                                                       other$taxRate
                                                                                                                                    )) {
                                                                                                                                    Object this$theoryThickness = this.getTheoryThickness();
                                                                                                                                    Object other$theoryThickness = other.getTheoryThickness();
                                                                                                                                    if (this$theoryThickness
                                                                                                                                          == null
                                                                                                                                       ? other$theoryThickness
                                                                                                                                          == null
                                                                                                                                       : this$theoryThickness.equals(
                                                                                                                                          other$theoryThickness
                                                                                                                                       )) {
                                                                                                                                       Object this$standardName = this.getStandardName();
                                                                                                                                       Object other$standardName = other.getStandardName();
                                                                                                                                       if (this$standardName
                                                                                                                                             == null
                                                                                                                                          ? other$standardName
                                                                                                                                             == null
                                                                                                                                          : this$standardName.equals(
                                                                                                                                             other$standardName
                                                                                                                                          )) {
                                                                                                                                          Object this$materialSn = this.getMaterialSn();
                                                                                                                                          Object other$materialSn = other.getMaterialSn();
                                                                                                                                          if (this$materialSn
                                                                                                                                                == null
                                                                                                                                             ? other$materialSn
                                                                                                                                                == null
                                                                                                                                             : this$materialSn.equals(
                                                                                                                                                other$materialSn
                                                                                                                                             )) {
                                                                                                                                             Object this$singleReturnMete = this.getSingleReturnMete();
                                                                                                                                             Object other$singleReturnMete = other.getSingleReturnMete();
                                                                                                                                             if (this$singleReturnMete
                                                                                                                                                   == null
                                                                                                                                                ? other$singleReturnMete
                                                                                                                                                   == null
                                                                                                                                                : this$singleReturnMete.equals(
                                                                                                                                                   other$singleReturnMete
                                                                                                                                                )) {
                                                                                                                                                Object this$singleQuantity = this.getSingleQuantity();
                                                                                                                                                Object other$singleQuantity = other.getSingleQuantity();
                                                                                                                                                if (this$singleQuantity
                                                                                                                                                      == null
                                                                                                                                                   ? other$singleQuantity
                                                                                                                                                      == null
                                                                                                                                                   : this$singleQuantity.equals(
                                                                                                                                                      other$singleQuantity
                                                                                                                                                   )) {
                                                                                                                                                   Object this$unitPriceNoFreight = this.getUnitPriceNoFreight();
                                                                                                                                                   Object other$unitPriceNoFreight = other.getUnitPriceNoFreight();
                                                                                                                                                   if (this$unitPriceNoFreight
                                                                                                                                                         == null
                                                                                                                                                      ? other$unitPriceNoFreight
                                                                                                                                                         == null
                                                                                                                                                      : this$unitPriceNoFreight.equals(
                                                                                                                                                         other$unitPriceNoFreight
                                                                                                                                                      )) {
                                                                                                                                                      Object this$unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
                                                                                                                                                      Object other$unitPriceExcludingVatNoFreight = other.getUnitPriceExcludingVatNoFreight();
                                                                                                                                                      if (this$unitPriceExcludingVatNoFreight
                                                                                                                                                            == null
                                                                                                                                                         ? other$unitPriceExcludingVatNoFreight
                                                                                                                                                            == null
                                                                                                                                                         : this$unitPriceExcludingVatNoFreight.equals(
                                                                                                                                                            other$unitPriceExcludingVatNoFreight
                                                                                                                                                         )) {
                                                                                                                                                         Object this$amountNoFreight = this.getAmountNoFreight();
                                                                                                                                                         Object other$amountNoFreight = other.getAmountNoFreight();
                                                                                                                                                         if (this$amountNoFreight
                                                                                                                                                               == null
                                                                                                                                                            ? other$amountNoFreight
                                                                                                                                                               == null
                                                                                                                                                            : this$amountNoFreight.equals(
                                                                                                                                                               other$amountNoFreight
                                                                                                                                                            )) {
                                                                                                                                                            Object this$amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
                                                                                                                                                            Object other$amountExcludingVatNoFreight = other.getAmountExcludingVatNoFreight();
                                                                                                                                                            if (this$amountExcludingVatNoFreight
                                                                                                                                                                  == null
                                                                                                                                                               ? other$amountExcludingVatNoFreight
                                                                                                                                                                  == null
                                                                                                                                                               : this$amountExcludingVatNoFreight.equals(
                                                                                                                                                                  other$amountExcludingVatNoFreight
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$inputVatNoFreight = this.getInputVatNoFreight();
                                                                                                                                                               Object other$inputVatNoFreight = other.getInputVatNoFreight();
                                                                                                                                                               if (this$inputVatNoFreight
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$inputVatNoFreight
                                                                                                                                                                     == null
                                                                                                                                                                  : this$inputVatNoFreight.equals(
                                                                                                                                                                     other$inputVatNoFreight
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$area = this.getArea();
                                                                                                                                                                  Object other$area = other.getArea();
                                                                                                                                                                  if (this$area
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$area
                                                                                                                                                                        == null
                                                                                                                                                                     : this$area.equals(
                                                                                                                                                                        other$area
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$nestSurplusCode = this.getNestSurplusCode();
                                                                                                                                                                     Object other$nestSurplusCode = other.getNestSurplusCode();
                                                                                                                                                                     if (this$nestSurplusCode
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$nestSurplusCode
                                                                                                                                                                           == null
                                                                                                                                                                        : this$nestSurplusCode.equals(
                                                                                                                                                                           other$nestSurplusCode
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$surplusSn = this.getSurplusSn();
                                                                                                                                                                        Object other$surplusSn = other.getSurplusSn();
                                                                                                                                                                        if (this$surplusSn
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$surplusSn
                                                                                                                                                                              == null
                                                                                                                                                                           : this$surplusSn.equals(
                                                                                                                                                                              other$surplusSn
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$dxfUrl = this.getDxfUrl();
                                                                                                                                                                           Object other$dxfUrl = other.getDxfUrl();
                                                                                                                                                                           if (this$dxfUrl
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$dxfUrl
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$dxfUrl.equals(
                                                                                                                                                                                 other$dxfUrl
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$imgUrl = this.getImgUrl();
                                                                                                                                                                              Object other$imgUrl = other.getImgUrl();
                                                                                                                                                                              if (this$imgUrl
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$imgUrl
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$imgUrl.equals(
                                                                                                                                                                                    other$imgUrl
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$realTime = this.getRealTime();
                                                                                                                                                                                 Object other$realTime = other.getRealTime();
                                                                                                                                                                                 return this$realTime
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$realTime
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$realTime.equals(
                                                                                                                                                                                       other$realTime
                                                                                                                                                                                    );
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
      return other instanceof ReturnDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $materialReturnableId = this.getMaterialReturnableId();
      result = result * 59 + ($materialReturnableId == null ? 43 : $materialReturnableId.hashCode());
      Object $returnId = this.getReturnId();
      result = result * 59 + ($returnId == null ? 43 : $returnId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $boolReturns = this.getBoolReturns();
      result = result * 59 + ($boolReturns == null ? 43 : $boolReturns.hashCode());
      Object $boardId = this.getBoardId();
      result = result * 59 + ($boardId == null ? 43 : $boardId.hashCode());
      Object $sourceWorkshopId = this.getSourceWorkshopId();
      result = result * 59 + ($sourceWorkshopId == null ? 43 : $sourceWorkshopId.hashCode());
      Object $returnDetailWholeId = this.getReturnDetailWholeId();
      result = result * 59 + ($returnDetailWholeId == null ? 43 : $returnDetailWholeId.hashCode());
      Object $remnantId = this.getRemnantId();
      result = result * 59 + ($remnantId == null ? 43 : $remnantId.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $boolNestSurplus = this.getBoolNestSurplus();
      result = result * 59 + ($boolNestSurplus == null ? 43 : $boolNestSurplus.hashCode());
      Object $wapId = this.getWapId();
      result = result * 59 + ($wapId == null ? 43 : $wapId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $singleReturnMete = this.getSingleReturnMete();
      result = result * 59 + ($singleReturnMete == null ? 43 : $singleReturnMete.hashCode());
      Object $singleQuantity = this.getSingleQuantity();
      result = result * 59 + ($singleQuantity == null ? 43 : $singleQuantity.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
      result = result * 59 + ($unitPriceExcludingVatNoFreight == null ? 43 : $unitPriceExcludingVatNoFreight.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $inputVatNoFreight = this.getInputVatNoFreight();
      result = result * 59 + ($inputVatNoFreight == null ? 43 : $inputVatNoFreight.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $nestSurplusCode = this.getNestSurplusCode();
      result = result * 59 + ($nestSurplusCode == null ? 43 : $nestSurplusCode.hashCode());
      Object $surplusSn = this.getSurplusSn();
      result = result * 59 + ($surplusSn == null ? 43 : $surplusSn.hashCode());
      Object $dxfUrl = this.getDxfUrl();
      result = result * 59 + ($dxfUrl == null ? 43 : $dxfUrl.hashCode());
      Object $imgUrl = this.getImgUrl();
      result = result * 59 + ($imgUrl == null ? 43 : $imgUrl.hashCode());
      Object $realTime = this.getRealTime();
      return result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
   }

   public static class ReturnDetailBuilder {
      private Long id;
      private String serialNumber;
      private Long classifyId;
      private Integer basicClass;
      private String specification;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal unitNet;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private String remark;
      private Long projectId;
      private Long warehouseId;
      private Long materialReturnableId;
      private Long returnId;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private Integer invoiceType;
      private Integer materialIsWhole;
      private BigDecimal unitPrice;
      private Long outboundId;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal taxRate;
      private BigDecimal theoryThickness;
      private Boolean boolPartyA;
      private Long standardId;
      private String standardName;
      private Long monomerId;
      private Long areaId;
      private String materialSn;
      private Long workshopId;
      private Boolean boolReturns;
      private Long boardId;
      private BigDecimal singleReturnMete;
      private BigDecimal singleQuantity;
      private Long sourceWorkshopId;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal unitPriceExcludingVatNoFreight;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal inputVatNoFreight;
      private Long returnDetailWholeId;
      private Long remnantId;
      private Integer outboundTypeSelection;
      private Boolean boolNestSurplus;
      private BigDecimal area;
      private String nestSurplusCode;
      private String surplusSn;
      private String dxfUrl;
      private String imgUrl;
      private LocalDateTime realTime;
      private Long wapId;
      private Integer reviewStatus;

      ReturnDetailBuilder() {
      }

      @JsonProperty("id")
      public ReturnDetail.ReturnDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public ReturnDetail.ReturnDetailBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("classifyId")
      public ReturnDetail.ReturnDetailBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("basicClass")
      public ReturnDetail.ReturnDetailBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("specification")
      public ReturnDetail.ReturnDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("quantity")
      public ReturnDetail.ReturnDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public ReturnDetail.ReturnDetailBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("unitNet")
      public ReturnDetail.ReturnDetailBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("length")
      public ReturnDetail.ReturnDetailBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public ReturnDetail.ReturnDetailBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public ReturnDetail.ReturnDetailBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("brand")
      public ReturnDetail.ReturnDetailBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public ReturnDetail.ReturnDetailBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public ReturnDetail.ReturnDetailBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("remark")
      public ReturnDetail.ReturnDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("projectId")
      public ReturnDetail.ReturnDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("warehouseId")
      public ReturnDetail.ReturnDetailBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("materialReturnableId")
      public ReturnDetail.ReturnDetailBuilder materialReturnableId(final Long materialReturnableId) {
         this.materialReturnableId = materialReturnableId;
         return this;
      }

      @JsonProperty("returnId")
      public ReturnDetail.ReturnDetailBuilder returnId(final Long returnId) {
         this.returnId = returnId;
         return this;
      }

      @JsonProperty("amount")
      public ReturnDetail.ReturnDetailBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public ReturnDetail.ReturnDetailBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("inputVat")
      public ReturnDetail.ReturnDetailBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("invoiceType")
      public ReturnDetail.ReturnDetailBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public ReturnDetail.ReturnDetailBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("unitPrice")
      public ReturnDetail.ReturnDetailBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("outboundId")
      public ReturnDetail.ReturnDetailBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public ReturnDetail.ReturnDetailBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("taxRate")
      public ReturnDetail.ReturnDetailBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("theoryThickness")
      public ReturnDetail.ReturnDetailBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("boolPartyA")
      public ReturnDetail.ReturnDetailBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("standardId")
      public ReturnDetail.ReturnDetailBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public ReturnDetail.ReturnDetailBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("monomerId")
      public ReturnDetail.ReturnDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ReturnDetail.ReturnDetailBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("materialSn")
      public ReturnDetail.ReturnDetailBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      @JsonProperty("workshopId")
      public ReturnDetail.ReturnDetailBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("boolReturns")
      public ReturnDetail.ReturnDetailBuilder boolReturns(final Boolean boolReturns) {
         this.boolReturns = boolReturns;
         return this;
      }

      @JsonProperty("boardId")
      public ReturnDetail.ReturnDetailBuilder boardId(final Long boardId) {
         this.boardId = boardId;
         return this;
      }

      @JsonProperty("singleReturnMete")
      public ReturnDetail.ReturnDetailBuilder singleReturnMete(final BigDecimal singleReturnMete) {
         this.singleReturnMete = singleReturnMete;
         return this;
      }

      @JsonProperty("singleQuantity")
      public ReturnDetail.ReturnDetailBuilder singleQuantity(final BigDecimal singleQuantity) {
         this.singleQuantity = singleQuantity;
         return this;
      }

      @JsonProperty("sourceWorkshopId")
      public ReturnDetail.ReturnDetailBuilder sourceWorkshopId(final Long sourceWorkshopId) {
         this.sourceWorkshopId = sourceWorkshopId;
         return this;
      }

      @JsonProperty("unitPriceNoFreight")
      public ReturnDetail.ReturnDetailBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      @JsonProperty("unitPriceExcludingVatNoFreight")
      public ReturnDetail.ReturnDetailBuilder unitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
         this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public ReturnDetail.ReturnDetailBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public ReturnDetail.ReturnDetailBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("inputVatNoFreight")
      public ReturnDetail.ReturnDetailBuilder inputVatNoFreight(final BigDecimal inputVatNoFreight) {
         this.inputVatNoFreight = inputVatNoFreight;
         return this;
      }

      @JsonProperty("returnDetailWholeId")
      public ReturnDetail.ReturnDetailBuilder returnDetailWholeId(final Long returnDetailWholeId) {
         this.returnDetailWholeId = returnDetailWholeId;
         return this;
      }

      @JsonProperty("remnantId")
      public ReturnDetail.ReturnDetailBuilder remnantId(final Long remnantId) {
         this.remnantId = remnantId;
         return this;
      }

      @JsonProperty("outboundTypeSelection")
      public ReturnDetail.ReturnDetailBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      @JsonProperty("boolNestSurplus")
      public ReturnDetail.ReturnDetailBuilder boolNestSurplus(final Boolean boolNestSurplus) {
         this.boolNestSurplus = boolNestSurplus;
         return this;
      }

      @JsonProperty("area")
      public ReturnDetail.ReturnDetailBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      @JsonProperty("nestSurplusCode")
      public ReturnDetail.ReturnDetailBuilder nestSurplusCode(final String nestSurplusCode) {
         this.nestSurplusCode = nestSurplusCode;
         return this;
      }

      @JsonProperty("surplusSn")
      public ReturnDetail.ReturnDetailBuilder surplusSn(final String surplusSn) {
         this.surplusSn = surplusSn;
         return this;
      }

      @JsonProperty("dxfUrl")
      public ReturnDetail.ReturnDetailBuilder dxfUrl(final String dxfUrl) {
         this.dxfUrl = dxfUrl;
         return this;
      }

      @JsonProperty("imgUrl")
      public ReturnDetail.ReturnDetailBuilder imgUrl(final String imgUrl) {
         this.imgUrl = imgUrl;
         return this;
      }

      @JsonProperty("realTime")
      public ReturnDetail.ReturnDetailBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      @JsonProperty("wapId")
      public ReturnDetail.ReturnDetailBuilder wapId(final Long wapId) {
         this.wapId = wapId;
         return this;
      }

      @JsonProperty("reviewStatus")
      public ReturnDetail.ReturnDetailBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ReturnDetail build() {
         return new ReturnDetail(
            this.id,
            this.serialNumber,
            this.classifyId,
            this.basicClass,
            this.specification,
            this.quantity,
            this.mete,
            this.unitNet,
            this.length,
            this.width,
            this.thickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.remark,
            this.projectId,
            this.warehouseId,
            this.materialReturnableId,
            this.returnId,
            this.amount,
            this.amountExcludingVat,
            this.inputVat,
            this.invoiceType,
            this.materialIsWhole,
            this.unitPrice,
            this.outboundId,
            this.unitPriceExcludingVat,
            this.taxRate,
            this.theoryThickness,
            this.boolPartyA,
            this.standardId,
            this.standardName,
            this.monomerId,
            this.areaId,
            this.materialSn,
            this.workshopId,
            this.boolReturns,
            this.boardId,
            this.singleReturnMete,
            this.singleQuantity,
            this.sourceWorkshopId,
            this.unitPriceNoFreight,
            this.unitPriceExcludingVatNoFreight,
            this.amountNoFreight,
            this.amountExcludingVatNoFreight,
            this.inputVatNoFreight,
            this.returnDetailWholeId,
            this.remnantId,
            this.outboundTypeSelection,
            this.boolNestSurplus,
            this.area,
            this.nestSurplusCode,
            this.surplusSn,
            this.dxfUrl,
            this.imgUrl,
            this.realTime,
            this.wapId,
            this.reviewStatus
         );
      }

      @Override
      public String toString() {
         return "ReturnDetail.ReturnDetailBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", unitNet="
            + this.unitNet
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", remark="
            + this.remark
            + ", projectId="
            + this.projectId
            + ", warehouseId="
            + this.warehouseId
            + ", materialReturnableId="
            + this.materialReturnableId
            + ", returnId="
            + this.returnId
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", invoiceType="
            + this.invoiceType
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", unitPrice="
            + this.unitPrice
            + ", outboundId="
            + this.outboundId
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", taxRate="
            + this.taxRate
            + ", theoryThickness="
            + this.theoryThickness
            + ", boolPartyA="
            + this.boolPartyA
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", materialSn="
            + this.materialSn
            + ", workshopId="
            + this.workshopId
            + ", boolReturns="
            + this.boolReturns
            + ", boardId="
            + this.boardId
            + ", singleReturnMete="
            + this.singleReturnMete
            + ", singleQuantity="
            + this.singleQuantity
            + ", sourceWorkshopId="
            + this.sourceWorkshopId
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", unitPriceExcludingVatNoFreight="
            + this.unitPriceExcludingVatNoFreight
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", inputVatNoFreight="
            + this.inputVatNoFreight
            + ", returnDetailWholeId="
            + this.returnDetailWholeId
            + ", remnantId="
            + this.remnantId
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", boolNestSurplus="
            + this.boolNestSurplus
            + ", area="
            + this.area
            + ", nestSurplusCode="
            + this.nestSurplusCode
            + ", surplusSn="
            + this.surplusSn
            + ", dxfUrl="
            + this.dxfUrl
            + ", imgUrl="
            + this.imgUrl
            + ", realTime="
            + this.realTime
            + ", wapId="
            + this.wapId
            + ", reviewStatus="
            + this.reviewStatus
            + ")";
      }
   }
}
