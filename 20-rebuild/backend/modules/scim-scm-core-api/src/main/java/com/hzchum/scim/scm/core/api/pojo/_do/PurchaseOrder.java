package com.hzchum.scim.scm.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
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

@ApiModel(value = "PurchaseOrder对象", description = "采购订单 ")
@Entity
@TableName("scm_purchase_order")
@Table(name = "scm_purchase_order")
public class PurchaseOrder extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "purchaseType", value = "采购类型[1 原材料采购,2 制成品采购]")
   @JsonProperty("purchaseType")
   @JSONField(name = "purchaseType")
   @TableField("purchase_type")
   @Column(name = "purchase_type", columnDefinition = "int  COMMENT '采购类型[1 原材料采购,2 制成品采购] PurchaseEnum'", nullable = true)
   private Integer purchaseType;
   @ApiModelProperty(name = "supplyType", value = "供货类型[1 自采,2 甲供]")
   @JsonProperty("supplyType")
   @JSONField(name = "supplyType")
   @TableField("supply_type")
   @Column(name = "supply_type")
   private Integer supplyType;
   @ApiModelProperty(name = "materialType", value = "材料类型", notes = "材料类型")
   @JsonProperty("materialType")
   @JSONField(name = "materialType")
   @TableField("material_type")
   @Column(name = "material_type", columnDefinition = "int(11)  COMMENT '材料类型'", nullable = true)
   private Integer materialType;
   @ApiModelProperty(name = "basicClass", value = "物料种类")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class")
   private Integer basicClass;
   @ApiModelProperty(name = "serialNumber", value = "采购单号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "projectIds", value = "项目ID集")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   @TableField(value = "project_ids ", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "project_ids")
   private String projectIds;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性-采购单类型[1 自营,2 合营,3 内包]")
   @JsonProperty("projectAttribute")
   @JSONField(name = "projectAttribute")
   @TableField("project_attribute")
   @Column(name = "project_attribute", columnDefinition = "int  COMMENT '项目属性-采购单类型[1 自营,2 合营,3 内包]'", nullable = true)
   private Integer projectAttribute;
   @ApiModelProperty(name = "lastOperatorNameId", value = "最后编辑人ID")
   @JsonProperty("lastOperatorNameId")
   @JSONField(name = "lastOperatorNameId")
   @TableField("last_operator_name_id")
   @Column(name = "last_operator_name_id")
   private Long lastOperatorNameId;
   @ApiModelProperty(name = "lastOperatorName", value = "最后编辑人")
   @JsonProperty("lastOperatorName")
   @JSONField(name = "lastOperatorName")
   @TableField("last_operator_name")
   @Column(name = "last_operator_name")
   private String lastOperatorName;
   @ApiModelProperty(name = "applicantId", value = "创建人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "创建人")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name")
   private String applicantName;
   @ApiModelProperty(name = "applyPurchaseIds", value = "申购单ID集")
   @JsonProperty("applyPurchaseIds")
   @JSONField(name = "applyPurchaseIds")
   @TableField(value = "apply_purchase_ids", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "apply_purchase_ids")
   private String applyPurchaseIds;
   @ApiModelProperty(name = "applyPurchaseSN", value = "申购单编号集")
   @JsonProperty("applyPurchaseSN")
   @JSONField(name = "applyPurchaseSN")
   @TableField(value = "apply_purchase_sn", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "apply_purchase_sn", columnDefinition = "varchar(255)  COMMENT '申购单编号集'", nullable = true)
   private String applyPurchaseSN;
   @ApiModelProperty(name = "branchCompanyId", value = "签订主体公司ID")
   @JsonProperty("branchCompanyId")
   @JSONField(name = "branchCompanyId")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id")
   private Long branchCompanyId;
   @ApiModelProperty(name = "auxMaterialIds", value = "辅材采购明细")
   @JsonProperty("auxMaterialIds")
   @JSONField(name = "auxMaterialIds")
   @TableField(value = "aux_material_ids", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "aux_material_ids")
   private String auxMaterialIds;
   @ApiModelProperty(name = "otherMaterialIds", value = "办公用品采购明细")
   @JsonProperty("otherMaterialIds")
   @JSONField(name = "otherMaterialIds")
   @TableField(value = "other_material_ids", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "other_material_ids")
   private String otherMaterialIds;
   @ApiModelProperty(name = "gasMaterialIds", value = "气体采购明细")
   @JsonProperty("gasMaterialIds")
   @JSONField(name = "gasMaterialIds")
   @TableField(value = "gas_material_ids", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "gas_material_ids")
   private String gasMaterialIds;
   @ApiModelProperty(name = "supplierId", value = "供应商ID")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id")
   private Long supplierId;
   @ApiModelProperty(name = "mete", value = "合同量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField(value = "mete", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "meteUnit", value = "单位")
   @JsonProperty("meteUnit")
   @JSONField(name = "meteUnit")
   @TableField(value = "mete_unit", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "mete_unit")
   private String meteUnit;
   @ApiModelProperty(name = "amount", value = "合同额")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField(value = "amount", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "amount", columnDefinition = "decimal(32,12)COMMENT '合同额'")
   private BigDecimal amount;
   @ApiModelProperty(name = "taxRate", value = "税率(百分比)")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField(value = "tax_rate", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "tax_rate")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 [1 专用增值税发票,2 普通增值税发票,4 收据]")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField(value = "invoice_type", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "invoice_type")
   private Integer invoiceType;
   @ApiModelProperty(name = "logisticsTransportType", value = "物流运输方式 1货运 2邮递 ,参考枚举[LogisticsTransportTypeEnum]")
   @JsonProperty("logisticsTransportType")
   @JSONField(name = "logisticsTransportType")
   @TableField(value = "logistics_transport_type", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "logistics_transport_type")
   private Integer logisticsTransportType;
   @ApiModelProperty(name = "logisticsPayerType", value = "付款方 1需方承担 2供方承担,参考[LogisticsPayerEnum]")
   @JsonProperty("logisticsPayerType")
   @JSONField(name = "logisticsPayerType")
   @TableField(value = "logistics_payer_type", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "logistics_payer_type")
   private Integer logisticsPayerType;
   @ApiModelProperty(name = "purchaseOrderPaymentMode", value = "订单类型 [1 期货订单,2 现货订单,4 到货订单]")
   @JsonProperty("purchaseOrderPaymentMode")
   @JSONField(name = "purchaseOrderPaymentMode")
   @TableField(value = "purchase_order_payment_mode", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "purchase_order_payment_mode")
   private Integer purchaseOrderPaymentMode;
   @ApiModelProperty(name = "attachments", value = "附件ID集")
   @JsonProperty("attachments")
   @JSONField(name = "attachments")
   @TableField(value = "attachments", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "attachments")
   private String attachments;
   @ApiModelProperty(name = "purchaseStatus", value = "采购状态[1 采购中,2 采购完成]")
   @JsonProperty("purchaseStatus")
   @JSONField(name = "purchaseStatus")
   @TableField("purchase_status")
   @Column(name = "purchase_status")
   private Integer purchaseStatus;
   @ApiModelProperty(name = "settlementStatus", value = "结算状态 [SettlementStatusEnum]")
   @JsonProperty("settlementStatus")
   @JSONField(name = "settlementStatus")
   @TableField("settlement_status")
   @Column(name = "settlement_status")
   private Integer settlementStatus;
   @ApiModelProperty(name = "settlementAmount", value = "结算金额")
   @Column(name = "settlement_amount")
   private BigDecimal settlementAmount;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "editable", value = "是否可修改[默认可修改]")
   @JsonProperty("editable")
   @JSONField(name = "editable")
   @TableField("editable")
   @Column(name = "editable", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '是否可修改[默认可修改] 0不可修改 1可以修改'", nullable = true)
   private Boolean editable;
   @ApiModelProperty(name = "boolRewrite", value = "是否可重写[默认不可重写]")
   @JsonProperty("boolRewrite")
   @JSONField(name = "boolRewrite")
   @TableField("bool_rewrite")
   @Column(name = "bool_rewrite", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '是否可重写[默认不可重写] 0不可重写 1可以重写'", nullable = true)
   private Boolean boolRewrite;
   @ApiModelProperty(name = "boolUsed", value = "是否使用[0 没有被使用, 1 已被使用]")
   @JsonProperty("boolUsed")
   @JSONField(name = "boolUsed")
   @TableField("bool_used")
   @Column(name = "bool_used")
   private Integer boolUsed;
   @ApiModelProperty(name = "useRequisitions", value = "是否绑定[0 未绑定, 1 已绑定]")
   @JsonProperty("useRequisitions")
   @JSONField(name = "useRequisitions")
   @TableField("use_requisitions")
   @Column(name = "use_requisitions")
   private Boolean useRequisitions;
   @ApiModelProperty(name = "userUpdateTime", value = "用户编辑时间")
   @JsonProperty("userUpdateTime")
   @JSONField(name = "userUpdateTime")
   @TableField("user_update_time")
   @Column(name = "user_update_time")
   private LocalDateTime userUpdateTime;
   @ApiModelProperty(name = "signingTime", value = "签订时间")
   @JsonProperty("signingTime")
   @JSONField(name = "signingTime")
   @TableField("signing_time")
   @Column(name = "signing_time")
   private LocalDateTime signingTime;
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式 [1 理计,2 磅计,4 混合计]")
   @JsonProperty("weightMeasurementMode")
   @JSONField(name = "weightMeasurementMode")
   @TableField(value = "weight_measurement_mode", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "weight_measurement_mode")
   private Integer weightMeasurementMode;
   @ApiModelProperty(name = "level", value = "采购单位的等级", notes = "采购单位的等级")
   @JsonProperty("level")
   @JSONField(name = "level")
   @TableField("level")
   @Column(name = "level", columnDefinition = "int(11)  COMMENT '采购单位的等级'", nullable = true)
   private Integer level;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态[2 审核通过，4 审核退回，16 审核中]")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int")
   private Integer reviewStatus;
   @ApiModelProperty(name = "BoolAnnual", value = "年度合同 [0非年度 1年度 默认非年度]")
   @JsonProperty("BoolAnnual")
   @JSONField(name = "BoolAnnual")
   @TableField(value = "bool_annual", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "bool_annual", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '年度合同[0非年度 1年度  默认非年度]'", nullable = true)
   private Boolean BoolAnnual;
   @ApiModelProperty(name = "reviewPassTime", value = "审核通过时间")
   @JsonProperty("reviewPassTime")
   @JSONField(name = "reviewPassTime")
   @TableField("review_pass_time")
   @Column(name = "review_pass_time")
   private LocalDateTime reviewPassTime;
   @ApiModelProperty(name = "boolTemporaryStorage", value = "是否暂存[1 true ,0 false]", notes = "是否暂存[1 true ,0 false]")
   @JsonProperty("boolTemporaryStorage")
   @JSONField(name = "boolTemporaryStorage")
   @TableField("bool_temporary_storage")
   @Column(name = "bool_temporary_storage", columnDefinition = "tinyint(1) DEFAULT '0'  COMMENT '是否暂存[1 true ,0 false]'", nullable = true)
   private Boolean boolTemporaryStorage;
   @ApiModelProperty(name = "boolDetail", value = "是否有明细")
   @JsonProperty("boolDetail")
   @JSONField(name = "boolDetail")
   @TableField(value = "bool_detail", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "bool_detail", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '是否有明细'")
   private Boolean boolDetail;
   @ApiModelProperty(name = "applyPurchaseStatus", value = "在暂存时或审批中时不对申购单进行修改，暂时将存在关联申购单的json数据存起来")
   @JsonProperty("applyPurchaseStatus")
   @JSONField(name = "applyPurchaseStatus")
   @TableField("apply_purchase_status")
   @Column(name = "apply_purchase_status")
   private String applyPurchaseStatus;
   @ApiModelProperty(name = "approveRecordIds", value = "审批日志ID集合")
   @JsonProperty("approveRecordIds")
   @JSONField(name = "approveRecordIds")
   @TableField("approve_record_ids")
   @Column(name = "approve_record_ids", columnDefinition = "varchar(255) COMMENT '审批日志ID集合'", nullable = true)
   private String approveRecordIds;
   @ApiModelProperty(name = "approveRecordIdNow", value = "当前审批日志ID")
   @JsonProperty("approveRecordIdNow")
   @JSONField(name = "approveRecordIdNow")
   @TableField("approve_record_id_now")
   @Column(name = "approve_record_id_now", columnDefinition = "bigint COMMENT '当前审批日志ID'", nullable = true)
   private Long approveRecordIdNow;
   @ApiModelProperty(name = "dataStatus", value = "数据当前状态 0失效(未创建成功撤销) 1创建中 2创建成功 3作废中 4作废成功,8撤销  DataStatusEnum")
   @JsonProperty("dataStatus")
   @JSONField(name = "dataStatus")
   @TableField("data_status")
   @Column(name = "data_status", columnDefinition = "int(11)  COMMENT '数据当前状态 0失效(未创建成功撤销) 1创建中 2创建成功 3作废中 4作废成功 DataStatusEnum'", nullable = true)
   private Integer dataStatus;
   @ApiModelProperty(name = "annualContractId", value = "年度合同ID")
   @JsonProperty("annualContractId")
   @JSONField(name = "annualContractId")
   @TableField("annual_contract_id")
   @Column(name = "annual_contract_id", columnDefinition = "bigint COMMENT '年度合同ID'", nullable = true)
   private Long annualContractId;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理ID", notes = "项目经理ID")
   @JsonProperty("projectManagerId")
   @JSONField(name = "projectManagerId")
   @TableField("project_manager_id")
   @Column(name = "project_manager_id", columnDefinition = "bigint")
   private Long projectManagerId;
   @ApiModelProperty(name = "requestId", value = "提交OA审批流成功返回的ID", notes = "提交OA审批流成功返回的ID")
   @JsonProperty("requestId")
   @JSONField(name = "requestId")
   @TableField("request_id")
   @Column(name = "request_id", columnDefinition = "varchar(20) COMMENT '提交OA审批流成功返回的ID'")
   private String requestId;
   @ApiModelProperty(name = "workshopId", value = "车间Id(中南定制 自营使用)")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "classifyIds", value = "科目ID集")
   @JsonProperty("classifyIds")
   @JSONField(name = "classifyIds")
   @TableField("classify_ids")
   @Column(name = "classify_ids", columnDefinition = "varchar(5000) COMMENT '科目ID集'", nullable = true)
   private String classifyIds;
   @ApiModelProperty(name = "passParentId", value = "通过的采购单父级ID", notes = "通过的采购单父级ID")
   @JsonProperty("passParentId")
   @JSONField(name = "passParentId")
   @TableField("pass_parent_id")
   @Column(name = "pass_parent_id", columnDefinition = "bigint COMMENT '通过的采购单父级ID'", nullable = true)
   private Long passParentId;
   @ApiModelProperty(name = "detailIds", value = "通过的采购单进行二次编辑时保存的关联采购明细ID集合", notes = "通过的采购单进行二次编辑时保存的关联采购明细ID集合")
   @JsonProperty("detailIds")
   @JSONField(name = "detailIds")
   @TableField("detail_ids")
   @Column(name = "detail_ids", columnDefinition = "text COMMENT '通过的采购单进行二次编辑时保存的关联采购明细ID集合'", nullable = true)
   private String detailIds;
   @ApiModelProperty(name = "boolSysgen", value = "采购单编号是否为系统自动生成 默认为true", notes = "采购单编号是否为系统自动生成 默认为true")
   @JsonProperty("boolSysgen")
   @JSONField(name = "boolSysgen")
   @TableField("bool_sysgen")
   @Column(name = "bool_sysgen", columnDefinition = "tinyint(1) DEFAULT '1' COMMENT '采购单编号是否为系统自动生成 默认为true'", nullable = true)
   private Boolean boolSysgen;
   @ApiModelProperty(name = "applyDetailMeteJson", value = "采购单绑定申购单的明细数量和核算量 DetailQuantityAndMete", notes = "采购单绑定申购单的明细数量和核算量 DetailQuantityAndMete")
   @JsonProperty("applyDetailMeteJson")
   @JSONField(name = "applyDetailMeteJson")
   @TableField("apply_detail_mete_json")
   @Column(name = "apply_detail_mete_json", columnDefinition = "text COMMENT '采购单绑定申购单的明细数量和核算量 DetailQuantityAndMete'", nullable = true)
   private String applyDetailMeteJson;
   @ApiModelProperty(name = "orderPlace", value = "目的地 PlaceEnum", notes = "目的地 PlaceEnum")
   @JsonProperty("orderPlace")
   @JSONField(name = "orderPlace")
   @TableField("order_place")
   @Column(name = "order_place", columnDefinition = "int(11)  COMMENT '目的地 PlaceEnum'", nullable = true)
   private Integer orderPlace;
   @ApiModelProperty(name = "artifactWageQuotaType", value = "构件制品计价方式 WmsWageQuotaTypeEnum", notes = "构件制品计价方式 WmsWageQuotaTypeEnum")
   @JsonProperty("artifactWageQuotaType")
   @JSONField(name = "artifactWageQuotaType")
   @TableField("artifact_wage_quota_type")
   @Column(name = "artifact_wage_quota_type", columnDefinition = "int(11)  COMMENT '构件制品计价方式 WmsWageQuotaTypeEnum'", nullable = true)
   private Integer artifactWageQuotaType;
   @ApiModelProperty(name = "artifactUnit", value = "构件制品单位", notes = "构件制品单位")
   @JsonProperty("artifactUnit")
   @JSONField(name = "artifactUnit")
   @TableField("artifact_unit")
   @Column(name = "artifact_unit", columnDefinition = "varchar(255)  COMMENT '构件制品单位'", nullable = true)
   private String artifactUnit;
   @ApiModelProperty(name = "enclosureUnit", value = "围护制品单位", notes = "围护制品单位")
   @JsonProperty("enclosureUnit")
   @JSONField(name = "enclosureUnit")
   @TableField("enclosure_unit")
   @Column(name = "enclosure_unit", columnDefinition = "int(11)  COMMENT '围护制品单位'", nullable = true)
   private Integer enclosureUnit;
   @ApiModelProperty(name = "receiveState", value = "工地外购收货状态")
   @JsonProperty("receiveState")
   @JSONField(name = "receiveState")
   @TableField("receive_state")
   @Column(name = "receive_state", columnDefinition = "int(5) DEFAULT '1' COMMENT '1未收货 2部分收货 4收货完成'")
   private Integer receiveState;
   @ApiModelProperty(name = "standingBookIsPrint", value = "是否在采购对账打印过")
   @JsonProperty("standingBookIsPrint")
   @JSONField(name = "standingBookIsPrint")
   @TableField("standing_book_is_print")
   @Column(name = "standing_book_is_print", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '是否在采购对账打印过 0未打印 1已打印'", nullable = true)
   private Boolean standingBookIsPrint;
   @ApiModelProperty(name = "isGoForOaApproval", value = "是否走OA审批流（中南定制）")
   @JsonProperty("isGoForOaApproval")
   @JSONField(name = "isGoForOaApproval")
   @TableField("is_go_for_oa_approval")
   @Column(name = "is_go_for_oa_approval", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '是否前往OA审批流（中南定制）'")
   private Boolean isGoForOaApproval;
   @ApiModelProperty(name = "delDetailIds", value = "删除的采购明细ID（编辑通过的采购单，在审核中重新编辑的时候有用）")
   @JsonProperty("delDetailIds")
   @JSONField(name = "delDetailIds")
   @TableField("del_detail_ids")
   @Column(name = "del_detail_ids", columnDefinition = "varchar(5000) COMMENT '删除的采购明细ID（编辑通过的采购单，在审核中重新编辑的时候有用'", nullable = true)
   private String delDetailIds;
   @ApiModelProperty(name = "branchAttributeEnum", value = "分支机构-属性 1安装 2加工 4其他")
   @TableField("branch_attribute_enum")
   @Column(name = "branch_attribute_enum", columnDefinition = "int(11) default 0 COMMENT '分支机构-属性 1安装 2加工 4其他'", nullable = false)
   private Integer branchAttributeEnum;

   public static PurchaseOrder.PurchaseOrderBuilder builder() {
      return new PurchaseOrder.PurchaseOrderBuilder();
   }

   public PurchaseOrder() {
   }

   public PurchaseOrder(
      final Long id,
      final Integer purchaseType,
      final Integer supplyType,
      final Integer materialType,
      final Integer basicClass,
      final String serialNumber,
      final String projectIds,
      final Integer projectAttribute,
      final Long lastOperatorNameId,
      final String lastOperatorName,
      final Long applicantId,
      final String applicantName,
      final String applyPurchaseIds,
      final String applyPurchaseSN,
      final Long branchCompanyId,
      final String auxMaterialIds,
      final String otherMaterialIds,
      final String gasMaterialIds,
      final Long supplierId,
      final BigDecimal mete,
      final String meteUnit,
      final BigDecimal amount,
      final BigDecimal taxRate,
      final Integer invoiceType,
      final Integer logisticsTransportType,
      final Integer logisticsPayerType,
      final Integer purchaseOrderPaymentMode,
      final String attachments,
      final Integer purchaseStatus,
      final Integer settlementStatus,
      final BigDecimal settlementAmount,
      final String remark,
      final Boolean editable,
      final Boolean boolRewrite,
      final Integer boolUsed,
      final Boolean useRequisitions,
      final LocalDateTime userUpdateTime,
      final LocalDateTime signingTime,
      final Integer weightMeasurementMode,
      final Integer level,
      final Integer reviewStatus,
      final Boolean BoolAnnual,
      final LocalDateTime reviewPassTime,
      final Boolean boolTemporaryStorage,
      final Boolean boolDetail,
      final String applyPurchaseStatus,
      final String approveRecordIds,
      final Long approveRecordIdNow,
      final Integer dataStatus,
      final Long annualContractId,
      final Long projectManagerId,
      final String requestId,
      final Long workshopId,
      final String classifyIds,
      final Long passParentId,
      final String detailIds,
      final Boolean boolSysgen,
      final String applyDetailMeteJson,
      final Integer orderPlace,
      final Integer artifactWageQuotaType,
      final String artifactUnit,
      final Integer enclosureUnit,
      final Integer receiveState,
      final Boolean standingBookIsPrint,
      final Boolean isGoForOaApproval,
      final String delDetailIds,
      final Integer branchAttributeEnum
   ) {
      this.id = id;
      this.purchaseType = purchaseType;
      this.supplyType = supplyType;
      this.materialType = materialType;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.projectIds = projectIds;
      this.projectAttribute = projectAttribute;
      this.lastOperatorNameId = lastOperatorNameId;
      this.lastOperatorName = lastOperatorName;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.applyPurchaseIds = applyPurchaseIds;
      this.applyPurchaseSN = applyPurchaseSN;
      this.branchCompanyId = branchCompanyId;
      this.auxMaterialIds = auxMaterialIds;
      this.otherMaterialIds = otherMaterialIds;
      this.gasMaterialIds = gasMaterialIds;
      this.supplierId = supplierId;
      this.mete = mete;
      this.meteUnit = meteUnit;
      this.amount = amount;
      this.taxRate = taxRate;
      this.invoiceType = invoiceType;
      this.logisticsTransportType = logisticsTransportType;
      this.logisticsPayerType = logisticsPayerType;
      this.purchaseOrderPaymentMode = purchaseOrderPaymentMode;
      this.attachments = attachments;
      this.purchaseStatus = purchaseStatus;
      this.settlementStatus = settlementStatus;
      this.settlementAmount = settlementAmount;
      this.remark = remark;
      this.editable = editable;
      this.boolRewrite = boolRewrite;
      this.boolUsed = boolUsed;
      this.useRequisitions = useRequisitions;
      this.userUpdateTime = userUpdateTime;
      this.signingTime = signingTime;
      this.weightMeasurementMode = weightMeasurementMode;
      this.level = level;
      this.reviewStatus = reviewStatus;
      this.BoolAnnual = BoolAnnual;
      this.reviewPassTime = reviewPassTime;
      this.boolTemporaryStorage = boolTemporaryStorage;
      this.boolDetail = boolDetail;
      this.applyPurchaseStatus = applyPurchaseStatus;
      this.approveRecordIds = approveRecordIds;
      this.approveRecordIdNow = approveRecordIdNow;
      this.dataStatus = dataStatus;
      this.annualContractId = annualContractId;
      this.projectManagerId = projectManagerId;
      this.requestId = requestId;
      this.workshopId = workshopId;
      this.classifyIds = classifyIds;
      this.passParentId = passParentId;
      this.detailIds = detailIds;
      this.boolSysgen = boolSysgen;
      this.applyDetailMeteJson = applyDetailMeteJson;
      this.orderPlace = orderPlace;
      this.artifactWageQuotaType = artifactWageQuotaType;
      this.artifactUnit = artifactUnit;
      this.enclosureUnit = enclosureUnit;
      this.receiveState = receiveState;
      this.standingBookIsPrint = standingBookIsPrint;
      this.isGoForOaApproval = isGoForOaApproval;
      this.delDetailIds = delDetailIds;
      this.branchAttributeEnum = branchAttributeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getPurchaseType() {
      return this.purchaseType;
   }

   public Integer getSupplyType() {
      return this.supplyType;
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Long getLastOperatorNameId() {
      return this.lastOperatorNameId;
   }

   public String getLastOperatorName() {
      return this.lastOperatorName;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getApplyPurchaseIds() {
      return this.applyPurchaseIds;
   }

   public String getApplyPurchaseSN() {
      return this.applyPurchaseSN;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getAuxMaterialIds() {
      return this.auxMaterialIds;
   }

   public String getOtherMaterialIds() {
      return this.otherMaterialIds;
   }

   public String getGasMaterialIds() {
      return this.gasMaterialIds;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getMeteUnit() {
      return this.meteUnit;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Integer getLogisticsTransportType() {
      return this.logisticsTransportType;
   }

   public Integer getLogisticsPayerType() {
      return this.logisticsPayerType;
   }

   public Integer getPurchaseOrderPaymentMode() {
      return this.purchaseOrderPaymentMode;
   }

   public String getAttachments() {
      return this.attachments;
   }

   public Integer getPurchaseStatus() {
      return this.purchaseStatus;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getEditable() {
      return this.editable;
   }

   public Boolean getBoolRewrite() {
      return this.boolRewrite;
   }

   public Integer getBoolUsed() {
      return this.boolUsed;
   }

   public Boolean getUseRequisitions() {
      return this.useRequisitions;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public LocalDateTime getSigningTime() {
      return this.signingTime;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Boolean getBoolAnnual() {
      return this.BoolAnnual;
   }

   public LocalDateTime getReviewPassTime() {
      return this.reviewPassTime;
   }

   public Boolean getBoolTemporaryStorage() {
      return this.boolTemporaryStorage;
   }

   public Boolean getBoolDetail() {
      return this.boolDetail;
   }

   public String getApplyPurchaseStatus() {
      return this.applyPurchaseStatus;
   }

   public String getApproveRecordIds() {
      return this.approveRecordIds;
   }

   public Long getApproveRecordIdNow() {
      return this.approveRecordIdNow;
   }

   public Integer getDataStatus() {
      return this.dataStatus;
   }

   public Long getAnnualContractId() {
      return this.annualContractId;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getRequestId() {
      return this.requestId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getClassifyIds() {
      return this.classifyIds;
   }

   public Long getPassParentId() {
      return this.passParentId;
   }

   public String getDetailIds() {
      return this.detailIds;
   }

   public Boolean getBoolSysgen() {
      return this.boolSysgen;
   }

   public String getApplyDetailMeteJson() {
      return this.applyDetailMeteJson;
   }

   public Integer getOrderPlace() {
      return this.orderPlace;
   }

   public Integer getArtifactWageQuotaType() {
      return this.artifactWageQuotaType;
   }

   public String getArtifactUnit() {
      return this.artifactUnit;
   }

   public Integer getEnclosureUnit() {
      return this.enclosureUnit;
   }

   public Integer getReceiveState() {
      return this.receiveState;
   }

   public Boolean getStandingBookIsPrint() {
      return this.standingBookIsPrint;
   }

   public Boolean getIsGoForOaApproval() {
      return this.isGoForOaApproval;
   }

   public String getDelDetailIds() {
      return this.delDetailIds;
   }

   public Integer getBranchAttributeEnum() {
      return this.branchAttributeEnum;
   }

   @JsonProperty("id")
   public PurchaseOrder setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("purchaseType")
   public PurchaseOrder setPurchaseType(final Integer purchaseType) {
      this.purchaseType = purchaseType;
      return this;
   }

   @JsonProperty("supplyType")
   public PurchaseOrder setSupplyType(final Integer supplyType) {
      this.supplyType = supplyType;
      return this;
   }

   @JsonProperty("materialType")
   public PurchaseOrder setMaterialType(final Integer materialType) {
      this.materialType = materialType;
      return this;
   }

   @JsonProperty("basicClass")
   public PurchaseOrder setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("serialNumber")
   public PurchaseOrder setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("projectIds")
   public PurchaseOrder setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("projectAttribute")
   public PurchaseOrder setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   @JsonProperty("lastOperatorNameId")
   public PurchaseOrder setLastOperatorNameId(final Long lastOperatorNameId) {
      this.lastOperatorNameId = lastOperatorNameId;
      return this;
   }

   @JsonProperty("lastOperatorName")
   public PurchaseOrder setLastOperatorName(final String lastOperatorName) {
      this.lastOperatorName = lastOperatorName;
      return this;
   }

   @JsonProperty("applicantId")
   public PurchaseOrder setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public PurchaseOrder setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("applyPurchaseIds")
   public PurchaseOrder setApplyPurchaseIds(final String applyPurchaseIds) {
      this.applyPurchaseIds = applyPurchaseIds;
      return this;
   }

   @JsonProperty("applyPurchaseSN")
   public PurchaseOrder setApplyPurchaseSN(final String applyPurchaseSN) {
      this.applyPurchaseSN = applyPurchaseSN;
      return this;
   }

   @JsonProperty("branchCompanyId")
   public PurchaseOrder setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   @JsonProperty("auxMaterialIds")
   public PurchaseOrder setAuxMaterialIds(final String auxMaterialIds) {
      this.auxMaterialIds = auxMaterialIds;
      return this;
   }

   @JsonProperty("otherMaterialIds")
   public PurchaseOrder setOtherMaterialIds(final String otherMaterialIds) {
      this.otherMaterialIds = otherMaterialIds;
      return this;
   }

   @JsonProperty("gasMaterialIds")
   public PurchaseOrder setGasMaterialIds(final String gasMaterialIds) {
      this.gasMaterialIds = gasMaterialIds;
      return this;
   }

   @JsonProperty("supplierId")
   public PurchaseOrder setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("mete")
   public PurchaseOrder setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("meteUnit")
   public PurchaseOrder setMeteUnit(final String meteUnit) {
      this.meteUnit = meteUnit;
      return this;
   }

   @JsonProperty("amount")
   public PurchaseOrder setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("taxRate")
   public PurchaseOrder setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("invoiceType")
   public PurchaseOrder setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("logisticsTransportType")
   public PurchaseOrder setLogisticsTransportType(final Integer logisticsTransportType) {
      this.logisticsTransportType = logisticsTransportType;
      return this;
   }

   @JsonProperty("logisticsPayerType")
   public PurchaseOrder setLogisticsPayerType(final Integer logisticsPayerType) {
      this.logisticsPayerType = logisticsPayerType;
      return this;
   }

   @JsonProperty("purchaseOrderPaymentMode")
   public PurchaseOrder setPurchaseOrderPaymentMode(final Integer purchaseOrderPaymentMode) {
      this.purchaseOrderPaymentMode = purchaseOrderPaymentMode;
      return this;
   }

   @JsonProperty("attachments")
   public PurchaseOrder setAttachments(final String attachments) {
      this.attachments = attachments;
      return this;
   }

   @JsonProperty("purchaseStatus")
   public PurchaseOrder setPurchaseStatus(final Integer purchaseStatus) {
      this.purchaseStatus = purchaseStatus;
      return this;
   }

   @JsonProperty("settlementStatus")
   public PurchaseOrder setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
      return this;
   }

   public PurchaseOrder setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
      return this;
   }

   @JsonProperty("remark")
   public PurchaseOrder setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("editable")
   public PurchaseOrder setEditable(final Boolean editable) {
      this.editable = editable;
      return this;
   }

   @JsonProperty("boolRewrite")
   public PurchaseOrder setBoolRewrite(final Boolean boolRewrite) {
      this.boolRewrite = boolRewrite;
      return this;
   }

   @JsonProperty("boolUsed")
   public PurchaseOrder setBoolUsed(final Integer boolUsed) {
      this.boolUsed = boolUsed;
      return this;
   }

   @JsonProperty("useRequisitions")
   public PurchaseOrder setUseRequisitions(final Boolean useRequisitions) {
      this.useRequisitions = useRequisitions;
      return this;
   }

   @JsonProperty("userUpdateTime")
   public PurchaseOrder setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
      return this;
   }

   @JsonProperty("signingTime")
   public PurchaseOrder setSigningTime(final LocalDateTime signingTime) {
      this.signingTime = signingTime;
      return this;
   }

   @JsonProperty("weightMeasurementMode")
   public PurchaseOrder setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
      return this;
   }

   @JsonProperty("level")
   public PurchaseOrder setLevel(final Integer level) {
      this.level = level;
      return this;
   }

   @JsonProperty("reviewStatus")
   public PurchaseOrder setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("BoolAnnual")
   public PurchaseOrder setBoolAnnual(final Boolean BoolAnnual) {
      this.BoolAnnual = BoolAnnual;
      return this;
   }

   @JsonProperty("reviewPassTime")
   public PurchaseOrder setReviewPassTime(final LocalDateTime reviewPassTime) {
      this.reviewPassTime = reviewPassTime;
      return this;
   }

   @JsonProperty("boolTemporaryStorage")
   public PurchaseOrder setBoolTemporaryStorage(final Boolean boolTemporaryStorage) {
      this.boolTemporaryStorage = boolTemporaryStorage;
      return this;
   }

   @JsonProperty("boolDetail")
   public PurchaseOrder setBoolDetail(final Boolean boolDetail) {
      this.boolDetail = boolDetail;
      return this;
   }

   @JsonProperty("applyPurchaseStatus")
   public PurchaseOrder setApplyPurchaseStatus(final String applyPurchaseStatus) {
      this.applyPurchaseStatus = applyPurchaseStatus;
      return this;
   }

   @JsonProperty("approveRecordIds")
   public PurchaseOrder setApproveRecordIds(final String approveRecordIds) {
      this.approveRecordIds = approveRecordIds;
      return this;
   }

   @JsonProperty("approveRecordIdNow")
   public PurchaseOrder setApproveRecordIdNow(final Long approveRecordIdNow) {
      this.approveRecordIdNow = approveRecordIdNow;
      return this;
   }

   @JsonProperty("dataStatus")
   public PurchaseOrder setDataStatus(final Integer dataStatus) {
      this.dataStatus = dataStatus;
      return this;
   }

   @JsonProperty("annualContractId")
   public PurchaseOrder setAnnualContractId(final Long annualContractId) {
      this.annualContractId = annualContractId;
      return this;
   }

   @JsonProperty("projectManagerId")
   public PurchaseOrder setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   @JsonProperty("requestId")
   public PurchaseOrder setRequestId(final String requestId) {
      this.requestId = requestId;
      return this;
   }

   @JsonProperty("workshopId")
   public PurchaseOrder setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("classifyIds")
   public PurchaseOrder setClassifyIds(final String classifyIds) {
      this.classifyIds = classifyIds;
      return this;
   }

   @JsonProperty("passParentId")
   public PurchaseOrder setPassParentId(final Long passParentId) {
      this.passParentId = passParentId;
      return this;
   }

   @JsonProperty("detailIds")
   public PurchaseOrder setDetailIds(final String detailIds) {
      this.detailIds = detailIds;
      return this;
   }

   @JsonProperty("boolSysgen")
   public PurchaseOrder setBoolSysgen(final Boolean boolSysgen) {
      this.boolSysgen = boolSysgen;
      return this;
   }

   @JsonProperty("applyDetailMeteJson")
   public PurchaseOrder setApplyDetailMeteJson(final String applyDetailMeteJson) {
      this.applyDetailMeteJson = applyDetailMeteJson;
      return this;
   }

   @JsonProperty("orderPlace")
   public PurchaseOrder setOrderPlace(final Integer orderPlace) {
      this.orderPlace = orderPlace;
      return this;
   }

   @JsonProperty("artifactWageQuotaType")
   public PurchaseOrder setArtifactWageQuotaType(final Integer artifactWageQuotaType) {
      this.artifactWageQuotaType = artifactWageQuotaType;
      return this;
   }

   @JsonProperty("artifactUnit")
   public PurchaseOrder setArtifactUnit(final String artifactUnit) {
      this.artifactUnit = artifactUnit;
      return this;
   }

   @JsonProperty("enclosureUnit")
   public PurchaseOrder setEnclosureUnit(final Integer enclosureUnit) {
      this.enclosureUnit = enclosureUnit;
      return this;
   }

   @JsonProperty("receiveState")
   public PurchaseOrder setReceiveState(final Integer receiveState) {
      this.receiveState = receiveState;
      return this;
   }

   @JsonProperty("standingBookIsPrint")
   public PurchaseOrder setStandingBookIsPrint(final Boolean standingBookIsPrint) {
      this.standingBookIsPrint = standingBookIsPrint;
      return this;
   }

   @JsonProperty("isGoForOaApproval")
   public PurchaseOrder setIsGoForOaApproval(final Boolean isGoForOaApproval) {
      this.isGoForOaApproval = isGoForOaApproval;
      return this;
   }

   @JsonProperty("delDetailIds")
   public PurchaseOrder setDelDetailIds(final String delDetailIds) {
      this.delDetailIds = delDetailIds;
      return this;
   }

   public PurchaseOrder setBranchAttributeEnum(final Integer branchAttributeEnum) {
      this.branchAttributeEnum = branchAttributeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "PurchaseOrder(id="
         + this.getId()
         + ", purchaseType="
         + this.getPurchaseType()
         + ", supplyType="
         + this.getSupplyType()
         + ", materialType="
         + this.getMaterialType()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectIds="
         + this.getProjectIds()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", lastOperatorNameId="
         + this.getLastOperatorNameId()
         + ", lastOperatorName="
         + this.getLastOperatorName()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", applyPurchaseIds="
         + this.getApplyPurchaseIds()
         + ", applyPurchaseSN="
         + this.getApplyPurchaseSN()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", auxMaterialIds="
         + this.getAuxMaterialIds()
         + ", otherMaterialIds="
         + this.getOtherMaterialIds()
         + ", gasMaterialIds="
         + this.getGasMaterialIds()
         + ", supplierId="
         + this.getSupplierId()
         + ", mete="
         + this.getMete()
         + ", meteUnit="
         + this.getMeteUnit()
         + ", amount="
         + this.getAmount()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", logisticsTransportType="
         + this.getLogisticsTransportType()
         + ", logisticsPayerType="
         + this.getLogisticsPayerType()
         + ", purchaseOrderPaymentMode="
         + this.getPurchaseOrderPaymentMode()
         + ", attachments="
         + this.getAttachments()
         + ", purchaseStatus="
         + this.getPurchaseStatus()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", remark="
         + this.getRemark()
         + ", editable="
         + this.getEditable()
         + ", boolRewrite="
         + this.getBoolRewrite()
         + ", boolUsed="
         + this.getBoolUsed()
         + ", useRequisitions="
         + this.getUseRequisitions()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", signingTime="
         + this.getSigningTime()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", level="
         + this.getLevel()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", BoolAnnual="
         + this.getBoolAnnual()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", boolTemporaryStorage="
         + this.getBoolTemporaryStorage()
         + ", boolDetail="
         + this.getBoolDetail()
         + ", applyPurchaseStatus="
         + this.getApplyPurchaseStatus()
         + ", approveRecordIds="
         + this.getApproveRecordIds()
         + ", approveRecordIdNow="
         + this.getApproveRecordIdNow()
         + ", dataStatus="
         + this.getDataStatus()
         + ", annualContractId="
         + this.getAnnualContractId()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", requestId="
         + this.getRequestId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", passParentId="
         + this.getPassParentId()
         + ", detailIds="
         + this.getDetailIds()
         + ", boolSysgen="
         + this.getBoolSysgen()
         + ", applyDetailMeteJson="
         + this.getApplyDetailMeteJson()
         + ", orderPlace="
         + this.getOrderPlace()
         + ", artifactWageQuotaType="
         + this.getArtifactWageQuotaType()
         + ", artifactUnit="
         + this.getArtifactUnit()
         + ", enclosureUnit="
         + this.getEnclosureUnit()
         + ", receiveState="
         + this.getReceiveState()
         + ", standingBookIsPrint="
         + this.getStandingBookIsPrint()
         + ", isGoForOaApproval="
         + this.getIsGoForOaApproval()
         + ", delDetailIds="
         + this.getDelDetailIds()
         + ", branchAttributeEnum="
         + this.getBranchAttributeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseOrder)) {
         return false;
      }

      PurchaseOrder other = (PurchaseOrder)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseType = this.getPurchaseType();
         Object other$purchaseType = other.getPurchaseType();
         if (this$purchaseType == null ? other$purchaseType == null : this$purchaseType.equals(other$purchaseType)) {
            Object this$supplyType = this.getSupplyType();
            Object other$supplyType = other.getSupplyType();
            if (this$supplyType == null ? other$supplyType == null : this$supplyType.equals(other$supplyType)) {
               Object this$materialType = this.getMaterialType();
               Object other$materialType = other.getMaterialType();
               if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$projectAttribute = this.getProjectAttribute();
                     Object other$projectAttribute = other.getProjectAttribute();
                     if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                        Object this$lastOperatorNameId = this.getLastOperatorNameId();
                        Object other$lastOperatorNameId = other.getLastOperatorNameId();
                        if (this$lastOperatorNameId == null ? other$lastOperatorNameId == null : this$lastOperatorNameId.equals(other$lastOperatorNameId)) {
                           Object this$applicantId = this.getApplicantId();
                           Object other$applicantId = other.getApplicantId();
                           if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                              Object this$branchCompanyId = this.getBranchCompanyId();
                              Object other$branchCompanyId = other.getBranchCompanyId();
                              if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                                 Object this$supplierId = this.getSupplierId();
                                 Object other$supplierId = other.getSupplierId();
                                 if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                    Object this$invoiceType = this.getInvoiceType();
                                    Object other$invoiceType = other.getInvoiceType();
                                    if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                       Object this$logisticsTransportType = this.getLogisticsTransportType();
                                       Object other$logisticsTransportType = other.getLogisticsTransportType();
                                       if (this$logisticsTransportType == null
                                          ? other$logisticsTransportType == null
                                          : this$logisticsTransportType.equals(other$logisticsTransportType)) {
                                          Object this$logisticsPayerType = this.getLogisticsPayerType();
                                          Object other$logisticsPayerType = other.getLogisticsPayerType();
                                          if (this$logisticsPayerType == null
                                             ? other$logisticsPayerType == null
                                             : this$logisticsPayerType.equals(other$logisticsPayerType)) {
                                             Object this$purchaseOrderPaymentMode = this.getPurchaseOrderPaymentMode();
                                             Object other$purchaseOrderPaymentMode = other.getPurchaseOrderPaymentMode();
                                             if (this$purchaseOrderPaymentMode == null
                                                ? other$purchaseOrderPaymentMode == null
                                                : this$purchaseOrderPaymentMode.equals(other$purchaseOrderPaymentMode)) {
                                                Object this$purchaseStatus = this.getPurchaseStatus();
                                                Object other$purchaseStatus = other.getPurchaseStatus();
                                                if (this$purchaseStatus == null
                                                   ? other$purchaseStatus == null
                                                   : this$purchaseStatus.equals(other$purchaseStatus)) {
                                                   Object this$settlementStatus = this.getSettlementStatus();
                                                   Object other$settlementStatus = other.getSettlementStatus();
                                                   if (this$settlementStatus == null
                                                      ? other$settlementStatus == null
                                                      : this$settlementStatus.equals(other$settlementStatus)) {
                                                      Object this$editable = this.getEditable();
                                                      Object other$editable = other.getEditable();
                                                      if (this$editable == null ? other$editable == null : this$editable.equals(other$editable)) {
                                                         Object this$boolRewrite = this.getBoolRewrite();
                                                         Object other$boolRewrite = other.getBoolRewrite();
                                                         if (this$boolRewrite == null ? other$boolRewrite == null : this$boolRewrite.equals(other$boolRewrite)) {
                                                            Object this$boolUsed = this.getBoolUsed();
                                                            Object other$boolUsed = other.getBoolUsed();
                                                            if (this$boolUsed == null ? other$boolUsed == null : this$boolUsed.equals(other$boolUsed)) {
                                                               Object this$useRequisitions = this.getUseRequisitions();
                                                               Object other$useRequisitions = other.getUseRequisitions();
                                                               if (this$useRequisitions == null
                                                                  ? other$useRequisitions == null
                                                                  : this$useRequisitions.equals(other$useRequisitions)) {
                                                                  Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                                                  Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                                                  if (this$weightMeasurementMode == null
                                                                     ? other$weightMeasurementMode == null
                                                                     : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                                                     Object this$level = this.getLevel();
                                                                     Object other$level = other.getLevel();
                                                                     if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                                                                        Object this$reviewStatus = this.getReviewStatus();
                                                                        Object other$reviewStatus = other.getReviewStatus();
                                                                        if (this$reviewStatus == null
                                                                           ? other$reviewStatus == null
                                                                           : this$reviewStatus.equals(other$reviewStatus)) {
                                                                           Object this$BoolAnnual = this.getBoolAnnual();
                                                                           Object other$BoolAnnual = other.getBoolAnnual();
                                                                           if (this$BoolAnnual == null
                                                                              ? other$BoolAnnual == null
                                                                              : this$BoolAnnual.equals(other$BoolAnnual)) {
                                                                              Object this$boolTemporaryStorage = this.getBoolTemporaryStorage();
                                                                              Object other$boolTemporaryStorage = other.getBoolTemporaryStorage();
                                                                              if (this$boolTemporaryStorage == null
                                                                                 ? other$boolTemporaryStorage == null
                                                                                 : this$boolTemporaryStorage.equals(other$boolTemporaryStorage)) {
                                                                                 Object this$boolDetail = this.getBoolDetail();
                                                                                 Object other$boolDetail = other.getBoolDetail();
                                                                                 if (this$boolDetail == null
                                                                                    ? other$boolDetail == null
                                                                                    : this$boolDetail.equals(other$boolDetail)) {
                                                                                    Object this$approveRecordIdNow = this.getApproveRecordIdNow();
                                                                                    Object other$approveRecordIdNow = other.getApproveRecordIdNow();
                                                                                    if (this$approveRecordIdNow == null
                                                                                       ? other$approveRecordIdNow == null
                                                                                       : this$approveRecordIdNow.equals(other$approveRecordIdNow)) {
                                                                                       Object this$dataStatus = this.getDataStatus();
                                                                                       Object other$dataStatus = other.getDataStatus();
                                                                                       if (this$dataStatus == null
                                                                                          ? other$dataStatus == null
                                                                                          : this$dataStatus.equals(other$dataStatus)) {
                                                                                          Object this$annualContractId = this.getAnnualContractId();
                                                                                          Object other$annualContractId = other.getAnnualContractId();
                                                                                          if (this$annualContractId == null
                                                                                             ? other$annualContractId == null
                                                                                             : this$annualContractId.equals(other$annualContractId)) {
                                                                                             Object this$projectManagerId = this.getProjectManagerId();
                                                                                             Object other$projectManagerId = other.getProjectManagerId();
                                                                                             if (this$projectManagerId == null
                                                                                                ? other$projectManagerId == null
                                                                                                : this$projectManagerId.equals(other$projectManagerId)) {
                                                                                                Object this$workshopId = this.getWorkshopId();
                                                                                                Object other$workshopId = other.getWorkshopId();
                                                                                                if (this$workshopId == null
                                                                                                   ? other$workshopId == null
                                                                                                   : this$workshopId.equals(other$workshopId)) {
                                                                                                   Object this$passParentId = this.getPassParentId();
                                                                                                   Object other$passParentId = other.getPassParentId();
                                                                                                   if (this$passParentId == null
                                                                                                      ? other$passParentId == null
                                                                                                      : this$passParentId.equals(other$passParentId)) {
                                                                                                      Object this$boolSysgen = this.getBoolSysgen();
                                                                                                      Object other$boolSysgen = other.getBoolSysgen();
                                                                                                      if (this$boolSysgen == null
                                                                                                         ? other$boolSysgen == null
                                                                                                         : this$boolSysgen.equals(other$boolSysgen)) {
                                                                                                         Object this$orderPlace = this.getOrderPlace();
                                                                                                         Object other$orderPlace = other.getOrderPlace();
                                                                                                         if (this$orderPlace == null
                                                                                                            ? other$orderPlace == null
                                                                                                            : this$orderPlace.equals(other$orderPlace)) {
                                                                                                            Object this$artifactWageQuotaType = this.getArtifactWageQuotaType();
                                                                                                            Object other$artifactWageQuotaType = other.getArtifactWageQuotaType();
                                                                                                            if (this$artifactWageQuotaType == null
                                                                                                               ? other$artifactWageQuotaType == null
                                                                                                               : this$artifactWageQuotaType.equals(
                                                                                                                  other$artifactWageQuotaType
                                                                                                               )) {
                                                                                                               Object this$enclosureUnit = this.getEnclosureUnit();
                                                                                                               Object other$enclosureUnit = other.getEnclosureUnit();
                                                                                                               if (this$enclosureUnit == null
                                                                                                                  ? other$enclosureUnit == null
                                                                                                                  : this$enclosureUnit.equals(
                                                                                                                     other$enclosureUnit
                                                                                                                  )) {
                                                                                                                  Object this$receiveState = this.getReceiveState();
                                                                                                                  Object other$receiveState = other.getReceiveState();
                                                                                                                  if (this$receiveState == null
                                                                                                                     ? other$receiveState == null
                                                                                                                     : this$receiveState.equals(
                                                                                                                        other$receiveState
                                                                                                                     )) {
                                                                                                                     Object this$standingBookIsPrint = this.getStandingBookIsPrint();
                                                                                                                     Object other$standingBookIsPrint = other.getStandingBookIsPrint();
                                                                                                                     if (this$standingBookIsPrint == null
                                                                                                                        ? other$standingBookIsPrint == null
                                                                                                                        : this$standingBookIsPrint.equals(
                                                                                                                           other$standingBookIsPrint
                                                                                                                        )) {
                                                                                                                        Object this$isGoForOaApproval = this.getIsGoForOaApproval();
                                                                                                                        Object other$isGoForOaApproval = other.getIsGoForOaApproval();
                                                                                                                        if (this$isGoForOaApproval == null
                                                                                                                           ? other$isGoForOaApproval == null
                                                                                                                           : this$isGoForOaApproval.equals(
                                                                                                                              other$isGoForOaApproval
                                                                                                                           )) {
                                                                                                                           Object this$branchAttributeEnum = this.getBranchAttributeEnum();
                                                                                                                           Object other$branchAttributeEnum = other.getBranchAttributeEnum();
                                                                                                                           if (this$branchAttributeEnum == null
                                                                                                                              ? other$branchAttributeEnum
                                                                                                                                 == null
                                                                                                                              : this$branchAttributeEnum.equals(
                                                                                                                                 other$branchAttributeEnum
                                                                                                                              )) {
                                                                                                                              Object this$serialNumber = this.getSerialNumber();
                                                                                                                              Object other$serialNumber = other.getSerialNumber();
                                                                                                                              if (this$serialNumber == null
                                                                                                                                 ? other$serialNumber == null
                                                                                                                                 : this$serialNumber.equals(
                                                                                                                                    other$serialNumber
                                                                                                                                 )) {
                                                                                                                                 Object this$projectIds = this.getProjectIds();
                                                                                                                                 Object other$projectIds = other.getProjectIds();
                                                                                                                                 if (this$projectIds == null
                                                                                                                                    ? other$projectIds == null
                                                                                                                                    : this$projectIds.equals(
                                                                                                                                       other$projectIds
                                                                                                                                    )) {
                                                                                                                                    Object this$lastOperatorName = this.getLastOperatorName();
                                                                                                                                    Object other$lastOperatorName = other.getLastOperatorName();
                                                                                                                                    if (this$lastOperatorName
                                                                                                                                          == null
                                                                                                                                       ? other$lastOperatorName
                                                                                                                                          == null
                                                                                                                                       : this$lastOperatorName.equals(
                                                                                                                                          other$lastOperatorName
                                                                                                                                       )) {
                                                                                                                                       Object this$applicantName = this.getApplicantName();
                                                                                                                                       Object other$applicantName = other.getApplicantName();
                                                                                                                                       if (this$applicantName
                                                                                                                                             == null
                                                                                                                                          ? other$applicantName
                                                                                                                                             == null
                                                                                                                                          : this$applicantName.equals(
                                                                                                                                             other$applicantName
                                                                                                                                          )) {
                                                                                                                                          Object this$applyPurchaseIds = this.getApplyPurchaseIds();
                                                                                                                                          Object other$applyPurchaseIds = other.getApplyPurchaseIds();
                                                                                                                                          if (this$applyPurchaseIds
                                                                                                                                                == null
                                                                                                                                             ? other$applyPurchaseIds
                                                                                                                                                == null
                                                                                                                                             : this$applyPurchaseIds.equals(
                                                                                                                                                other$applyPurchaseIds
                                                                                                                                             )) {
                                                                                                                                             Object this$applyPurchaseSN = this.getApplyPurchaseSN();
                                                                                                                                             Object other$applyPurchaseSN = other.getApplyPurchaseSN();
                                                                                                                                             if (this$applyPurchaseSN
                                                                                                                                                   == null
                                                                                                                                                ? other$applyPurchaseSN
                                                                                                                                                   == null
                                                                                                                                                : this$applyPurchaseSN.equals(
                                                                                                                                                   other$applyPurchaseSN
                                                                                                                                                )) {
                                                                                                                                                Object this$auxMaterialIds = this.getAuxMaterialIds();
                                                                                                                                                Object other$auxMaterialIds = other.getAuxMaterialIds();
                                                                                                                                                if (this$auxMaterialIds
                                                                                                                                                      == null
                                                                                                                                                   ? other$auxMaterialIds
                                                                                                                                                      == null
                                                                                                                                                   : this$auxMaterialIds.equals(
                                                                                                                                                      other$auxMaterialIds
                                                                                                                                                   )) {
                                                                                                                                                   Object this$otherMaterialIds = this.getOtherMaterialIds();
                                                                                                                                                   Object other$otherMaterialIds = other.getOtherMaterialIds();
                                                                                                                                                   if (this$otherMaterialIds
                                                                                                                                                         == null
                                                                                                                                                      ? other$otherMaterialIds
                                                                                                                                                         == null
                                                                                                                                                      : this$otherMaterialIds.equals(
                                                                                                                                                         other$otherMaterialIds
                                                                                                                                                      )) {
                                                                                                                                                      Object this$gasMaterialIds = this.getGasMaterialIds();
                                                                                                                                                      Object other$gasMaterialIds = other.getGasMaterialIds();
                                                                                                                                                      if (this$gasMaterialIds
                                                                                                                                                            == null
                                                                                                                                                         ? other$gasMaterialIds
                                                                                                                                                            == null
                                                                                                                                                         : this$gasMaterialIds.equals(
                                                                                                                                                            other$gasMaterialIds
                                                                                                                                                         )) {
                                                                                                                                                         Object this$mete = this.getMete();
                                                                                                                                                         Object other$mete = other.getMete();
                                                                                                                                                         if (this$mete
                                                                                                                                                               == null
                                                                                                                                                            ? other$mete
                                                                                                                                                               == null
                                                                                                                                                            : this$mete.equals(
                                                                                                                                                               other$mete
                                                                                                                                                            )) {
                                                                                                                                                            Object this$meteUnit = this.getMeteUnit();
                                                                                                                                                            Object other$meteUnit = other.getMeteUnit();
                                                                                                                                                            if (this$meteUnit
                                                                                                                                                                  == null
                                                                                                                                                               ? other$meteUnit
                                                                                                                                                                  == null
                                                                                                                                                               : this$meteUnit.equals(
                                                                                                                                                                  other$meteUnit
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$amount = this.getAmount();
                                                                                                                                                               Object other$amount = other.getAmount();
                                                                                                                                                               if (this$amount
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$amount
                                                                                                                                                                     == null
                                                                                                                                                                  : this$amount.equals(
                                                                                                                                                                     other$amount
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$taxRate = this.getTaxRate();
                                                                                                                                                                  Object other$taxRate = other.getTaxRate();
                                                                                                                                                                  if (this$taxRate
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$taxRate
                                                                                                                                                                        == null
                                                                                                                                                                     : this$taxRate.equals(
                                                                                                                                                                        other$taxRate
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$attachments = this.getAttachments();
                                                                                                                                                                     Object other$attachments = other.getAttachments();
                                                                                                                                                                     if (this$attachments
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$attachments
                                                                                                                                                                           == null
                                                                                                                                                                        : this$attachments.equals(
                                                                                                                                                                           other$attachments
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$settlementAmount = this.getSettlementAmount();
                                                                                                                                                                        Object other$settlementAmount = other.getSettlementAmount();
                                                                                                                                                                        if (this$settlementAmount
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$settlementAmount
                                                                                                                                                                              == null
                                                                                                                                                                           : this$settlementAmount.equals(
                                                                                                                                                                              other$settlementAmount
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$remark = this.getRemark();
                                                                                                                                                                           Object other$remark = other.getRemark();
                                                                                                                                                                           if (this$remark
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$remark
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$remark.equals(
                                                                                                                                                                                 other$remark
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$userUpdateTime = this.getUserUpdateTime();
                                                                                                                                                                              Object other$userUpdateTime = other.getUserUpdateTime();
                                                                                                                                                                              if (this$userUpdateTime
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$userUpdateTime
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$userUpdateTime.equals(
                                                                                                                                                                                    other$userUpdateTime
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$signingTime = this.getSigningTime();
                                                                                                                                                                                 Object other$signingTime = other.getSigningTime();
                                                                                                                                                                                 if (this$signingTime
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$signingTime
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$signingTime.equals(
                                                                                                                                                                                       other$signingTime
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$reviewPassTime = this.getReviewPassTime();
                                                                                                                                                                                    Object other$reviewPassTime = other.getReviewPassTime();
                                                                                                                                                                                    if (this$reviewPassTime
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$reviewPassTime
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$reviewPassTime.equals(
                                                                                                                                                                                          other$reviewPassTime
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$applyPurchaseStatus = this.getApplyPurchaseStatus();
                                                                                                                                                                                       Object other$applyPurchaseStatus = other.getApplyPurchaseStatus();
                                                                                                                                                                                       if (this$applyPurchaseStatus
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$applyPurchaseStatus
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$applyPurchaseStatus.equals(
                                                                                                                                                                                             other$applyPurchaseStatus
                                                                                                                                                                                          )
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Object this$approveRecordIds = this.getApproveRecordIds();
                                                                                                                                                                                          Object other$approveRecordIds = other.getApproveRecordIds();
                                                                                                                                                                                          if (this$approveRecordIds
                                                                                                                                                                                                == null
                                                                                                                                                                                             ? other$approveRecordIds
                                                                                                                                                                                                == null
                                                                                                                                                                                             : this$approveRecordIds.equals(
                                                                                                                                                                                                other$approveRecordIds
                                                                                                                                                                                             )
                                                                                                                                                                                             )
                                                                                                                                                                                           {
                                                                                                                                                                                             Object this$requestId = this.getRequestId();
                                                                                                                                                                                             Object other$requestId = other.getRequestId();
                                                                                                                                                                                             if (this$requestId
                                                                                                                                                                                                   == null
                                                                                                                                                                                                ? other$requestId
                                                                                                                                                                                                   == null
                                                                                                                                                                                                : this$requestId.equals(
                                                                                                                                                                                                   other$requestId
                                                                                                                                                                                                )
                                                                                                                                                                                                )
                                                                                                                                                                                              {
                                                                                                                                                                                                Object this$classifyIds = this.getClassifyIds();
                                                                                                                                                                                                Object other$classifyIds = other.getClassifyIds();
                                                                                                                                                                                                if (this$classifyIds
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   ? other$classifyIds
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   : this$classifyIds.equals(
                                                                                                                                                                                                      other$classifyIds
                                                                                                                                                                                                   )
                                                                                                                                                                                                   )
                                                                                                                                                                                                 {
                                                                                                                                                                                                   Object this$detailIds = this.getDetailIds();
                                                                                                                                                                                                   Object other$detailIds = other.getDetailIds();
                                                                                                                                                                                                   if (this$detailIds
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      ? other$detailIds
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      : this$detailIds.equals(
                                                                                                                                                                                                         other$detailIds
                                                                                                                                                                                                      )
                                                                                                                                                                                                      )
                                                                                                                                                                                                    {
                                                                                                                                                                                                      Object this$applyDetailMeteJson = this.getApplyDetailMeteJson();
                                                                                                                                                                                                      Object other$applyDetailMeteJson = other.getApplyDetailMeteJson();
                                                                                                                                                                                                      if (this$applyDetailMeteJson
                                                                                                                                                                                                            == null
                                                                                                                                                                                                         ? other$applyDetailMeteJson
                                                                                                                                                                                                            == null
                                                                                                                                                                                                         : this$applyDetailMeteJson.equals(
                                                                                                                                                                                                            other$applyDetailMeteJson
                                                                                                                                                                                                         )
                                                                                                                                                                                                         )
                                                                                                                                                                                                       {
                                                                                                                                                                                                         Object this$artifactUnit = this.getArtifactUnit();
                                                                                                                                                                                                         Object other$artifactUnit = other.getArtifactUnit();
                                                                                                                                                                                                         if (this$artifactUnit
                                                                                                                                                                                                               == null
                                                                                                                                                                                                            ? other$artifactUnit
                                                                                                                                                                                                               == null
                                                                                                                                                                                                            : this$artifactUnit.equals(
                                                                                                                                                                                                               other$artifactUnit
                                                                                                                                                                                                            )
                                                                                                                                                                                                            )
                                                                                                                                                                                                          {
                                                                                                                                                                                                            Object this$delDetailIds = this.getDelDetailIds();
                                                                                                                                                                                                            Object other$delDetailIds = other.getDelDetailIds();
                                                                                                                                                                                                            return this$delDetailIds
                                                                                                                                                                                                                  == null
                                                                                                                                                                                                               ? other$delDetailIds
                                                                                                                                                                                                                  == null
                                                                                                                                                                                                               : this$delDetailIds.equals(
                                                                                                                                                                                                                  other$delDetailIds
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
      return other instanceof PurchaseOrder;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $supplyType = this.getSupplyType();
      result = result * 59 + ($supplyType == null ? 43 : $supplyType.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $lastOperatorNameId = this.getLastOperatorNameId();
      result = result * 59 + ($lastOperatorNameId == null ? 43 : $lastOperatorNameId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $logisticsTransportType = this.getLogisticsTransportType();
      result = result * 59 + ($logisticsTransportType == null ? 43 : $logisticsTransportType.hashCode());
      Object $logisticsPayerType = this.getLogisticsPayerType();
      result = result * 59 + ($logisticsPayerType == null ? 43 : $logisticsPayerType.hashCode());
      Object $purchaseOrderPaymentMode = this.getPurchaseOrderPaymentMode();
      result = result * 59 + ($purchaseOrderPaymentMode == null ? 43 : $purchaseOrderPaymentMode.hashCode());
      Object $purchaseStatus = this.getPurchaseStatus();
      result = result * 59 + ($purchaseStatus == null ? 43 : $purchaseStatus.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $editable = this.getEditable();
      result = result * 59 + ($editable == null ? 43 : $editable.hashCode());
      Object $boolRewrite = this.getBoolRewrite();
      result = result * 59 + ($boolRewrite == null ? 43 : $boolRewrite.hashCode());
      Object $boolUsed = this.getBoolUsed();
      result = result * 59 + ($boolUsed == null ? 43 : $boolUsed.hashCode());
      Object $useRequisitions = this.getUseRequisitions();
      result = result * 59 + ($useRequisitions == null ? 43 : $useRequisitions.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $BoolAnnual = this.getBoolAnnual();
      result = result * 59 + ($BoolAnnual == null ? 43 : $BoolAnnual.hashCode());
      Object $boolTemporaryStorage = this.getBoolTemporaryStorage();
      result = result * 59 + ($boolTemporaryStorage == null ? 43 : $boolTemporaryStorage.hashCode());
      Object $boolDetail = this.getBoolDetail();
      result = result * 59 + ($boolDetail == null ? 43 : $boolDetail.hashCode());
      Object $approveRecordIdNow = this.getApproveRecordIdNow();
      result = result * 59 + ($approveRecordIdNow == null ? 43 : $approveRecordIdNow.hashCode());
      Object $dataStatus = this.getDataStatus();
      result = result * 59 + ($dataStatus == null ? 43 : $dataStatus.hashCode());
      Object $annualContractId = this.getAnnualContractId();
      result = result * 59 + ($annualContractId == null ? 43 : $annualContractId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $passParentId = this.getPassParentId();
      result = result * 59 + ($passParentId == null ? 43 : $passParentId.hashCode());
      Object $boolSysgen = this.getBoolSysgen();
      result = result * 59 + ($boolSysgen == null ? 43 : $boolSysgen.hashCode());
      Object $orderPlace = this.getOrderPlace();
      result = result * 59 + ($orderPlace == null ? 43 : $orderPlace.hashCode());
      Object $artifactWageQuotaType = this.getArtifactWageQuotaType();
      result = result * 59 + ($artifactWageQuotaType == null ? 43 : $artifactWageQuotaType.hashCode());
      Object $enclosureUnit = this.getEnclosureUnit();
      result = result * 59 + ($enclosureUnit == null ? 43 : $enclosureUnit.hashCode());
      Object $receiveState = this.getReceiveState();
      result = result * 59 + ($receiveState == null ? 43 : $receiveState.hashCode());
      Object $standingBookIsPrint = this.getStandingBookIsPrint();
      result = result * 59 + ($standingBookIsPrint == null ? 43 : $standingBookIsPrint.hashCode());
      Object $isGoForOaApproval = this.getIsGoForOaApproval();
      result = result * 59 + ($isGoForOaApproval == null ? 43 : $isGoForOaApproval.hashCode());
      Object $branchAttributeEnum = this.getBranchAttributeEnum();
      result = result * 59 + ($branchAttributeEnum == null ? 43 : $branchAttributeEnum.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $lastOperatorName = this.getLastOperatorName();
      result = result * 59 + ($lastOperatorName == null ? 43 : $lastOperatorName.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $applyPurchaseIds = this.getApplyPurchaseIds();
      result = result * 59 + ($applyPurchaseIds == null ? 43 : $applyPurchaseIds.hashCode());
      Object $applyPurchaseSN = this.getApplyPurchaseSN();
      result = result * 59 + ($applyPurchaseSN == null ? 43 : $applyPurchaseSN.hashCode());
      Object $auxMaterialIds = this.getAuxMaterialIds();
      result = result * 59 + ($auxMaterialIds == null ? 43 : $auxMaterialIds.hashCode());
      Object $otherMaterialIds = this.getOtherMaterialIds();
      result = result * 59 + ($otherMaterialIds == null ? 43 : $otherMaterialIds.hashCode());
      Object $gasMaterialIds = this.getGasMaterialIds();
      result = result * 59 + ($gasMaterialIds == null ? 43 : $gasMaterialIds.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $meteUnit = this.getMeteUnit();
      result = result * 59 + ($meteUnit == null ? 43 : $meteUnit.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $signingTime = this.getSigningTime();
      result = result * 59 + ($signingTime == null ? 43 : $signingTime.hashCode());
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $applyPurchaseStatus = this.getApplyPurchaseStatus();
      result = result * 59 + ($applyPurchaseStatus == null ? 43 : $applyPurchaseStatus.hashCode());
      Object $approveRecordIds = this.getApproveRecordIds();
      result = result * 59 + ($approveRecordIds == null ? 43 : $approveRecordIds.hashCode());
      Object $requestId = this.getRequestId();
      result = result * 59 + ($requestId == null ? 43 : $requestId.hashCode());
      Object $classifyIds = this.getClassifyIds();
      result = result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
      Object $detailIds = this.getDetailIds();
      result = result * 59 + ($detailIds == null ? 43 : $detailIds.hashCode());
      Object $applyDetailMeteJson = this.getApplyDetailMeteJson();
      result = result * 59 + ($applyDetailMeteJson == null ? 43 : $applyDetailMeteJson.hashCode());
      Object $artifactUnit = this.getArtifactUnit();
      result = result * 59 + ($artifactUnit == null ? 43 : $artifactUnit.hashCode());
      Object $delDetailIds = this.getDelDetailIds();
      return result * 59 + ($delDetailIds == null ? 43 : $delDetailIds.hashCode());
   }

   public static class PurchaseOrderBuilder {
      private Long id;
      private Integer purchaseType;
      private Integer supplyType;
      private Integer materialType;
      private Integer basicClass;
      private String serialNumber;
      private String projectIds;
      private Integer projectAttribute;
      private Long lastOperatorNameId;
      private String lastOperatorName;
      private Long applicantId;
      private String applicantName;
      private String applyPurchaseIds;
      private String applyPurchaseSN;
      private Long branchCompanyId;
      private String auxMaterialIds;
      private String otherMaterialIds;
      private String gasMaterialIds;
      private Long supplierId;
      private BigDecimal mete;
      private String meteUnit;
      private BigDecimal amount;
      private BigDecimal taxRate;
      private Integer invoiceType;
      private Integer logisticsTransportType;
      private Integer logisticsPayerType;
      private Integer purchaseOrderPaymentMode;
      private String attachments;
      private Integer purchaseStatus;
      private Integer settlementStatus;
      private BigDecimal settlementAmount;
      private String remark;
      private Boolean editable;
      private Boolean boolRewrite;
      private Integer boolUsed;
      private Boolean useRequisitions;
      private LocalDateTime userUpdateTime;
      private LocalDateTime signingTime;
      private Integer weightMeasurementMode;
      private Integer level;
      private Integer reviewStatus;
      private Boolean BoolAnnual;
      private LocalDateTime reviewPassTime;
      private Boolean boolTemporaryStorage;
      private Boolean boolDetail;
      private String applyPurchaseStatus;
      private String approveRecordIds;
      private Long approveRecordIdNow;
      private Integer dataStatus;
      private Long annualContractId;
      private Long projectManagerId;
      private String requestId;
      private Long workshopId;
      private String classifyIds;
      private Long passParentId;
      private String detailIds;
      private Boolean boolSysgen;
      private String applyDetailMeteJson;
      private Integer orderPlace;
      private Integer artifactWageQuotaType;
      private String artifactUnit;
      private Integer enclosureUnit;
      private Integer receiveState;
      private Boolean standingBookIsPrint;
      private Boolean isGoForOaApproval;
      private String delDetailIds;
      private Integer branchAttributeEnum;

      PurchaseOrderBuilder() {
      }

      @JsonProperty("id")
      public PurchaseOrder.PurchaseOrderBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("purchaseType")
      public PurchaseOrder.PurchaseOrderBuilder purchaseType(final Integer purchaseType) {
         this.purchaseType = purchaseType;
         return this;
      }

      @JsonProperty("supplyType")
      public PurchaseOrder.PurchaseOrderBuilder supplyType(final Integer supplyType) {
         this.supplyType = supplyType;
         return this;
      }

      @JsonProperty("materialType")
      public PurchaseOrder.PurchaseOrderBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      @JsonProperty("basicClass")
      public PurchaseOrder.PurchaseOrderBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("serialNumber")
      public PurchaseOrder.PurchaseOrderBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("projectIds")
      public PurchaseOrder.PurchaseOrderBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("projectAttribute")
      public PurchaseOrder.PurchaseOrderBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      @JsonProperty("lastOperatorNameId")
      public PurchaseOrder.PurchaseOrderBuilder lastOperatorNameId(final Long lastOperatorNameId) {
         this.lastOperatorNameId = lastOperatorNameId;
         return this;
      }

      @JsonProperty("lastOperatorName")
      public PurchaseOrder.PurchaseOrderBuilder lastOperatorName(final String lastOperatorName) {
         this.lastOperatorName = lastOperatorName;
         return this;
      }

      @JsonProperty("applicantId")
      public PurchaseOrder.PurchaseOrderBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public PurchaseOrder.PurchaseOrderBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("applyPurchaseIds")
      public PurchaseOrder.PurchaseOrderBuilder applyPurchaseIds(final String applyPurchaseIds) {
         this.applyPurchaseIds = applyPurchaseIds;
         return this;
      }

      @JsonProperty("applyPurchaseSN")
      public PurchaseOrder.PurchaseOrderBuilder applyPurchaseSN(final String applyPurchaseSN) {
         this.applyPurchaseSN = applyPurchaseSN;
         return this;
      }

      @JsonProperty("branchCompanyId")
      public PurchaseOrder.PurchaseOrderBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      @JsonProperty("auxMaterialIds")
      public PurchaseOrder.PurchaseOrderBuilder auxMaterialIds(final String auxMaterialIds) {
         this.auxMaterialIds = auxMaterialIds;
         return this;
      }

      @JsonProperty("otherMaterialIds")
      public PurchaseOrder.PurchaseOrderBuilder otherMaterialIds(final String otherMaterialIds) {
         this.otherMaterialIds = otherMaterialIds;
         return this;
      }

      @JsonProperty("gasMaterialIds")
      public PurchaseOrder.PurchaseOrderBuilder gasMaterialIds(final String gasMaterialIds) {
         this.gasMaterialIds = gasMaterialIds;
         return this;
      }

      @JsonProperty("supplierId")
      public PurchaseOrder.PurchaseOrderBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("mete")
      public PurchaseOrder.PurchaseOrderBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("meteUnit")
      public PurchaseOrder.PurchaseOrderBuilder meteUnit(final String meteUnit) {
         this.meteUnit = meteUnit;
         return this;
      }

      @JsonProperty("amount")
      public PurchaseOrder.PurchaseOrderBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("taxRate")
      public PurchaseOrder.PurchaseOrderBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("invoiceType")
      public PurchaseOrder.PurchaseOrderBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("logisticsTransportType")
      public PurchaseOrder.PurchaseOrderBuilder logisticsTransportType(final Integer logisticsTransportType) {
         this.logisticsTransportType = logisticsTransportType;
         return this;
      }

      @JsonProperty("logisticsPayerType")
      public PurchaseOrder.PurchaseOrderBuilder logisticsPayerType(final Integer logisticsPayerType) {
         this.logisticsPayerType = logisticsPayerType;
         return this;
      }

      @JsonProperty("purchaseOrderPaymentMode")
      public PurchaseOrder.PurchaseOrderBuilder purchaseOrderPaymentMode(final Integer purchaseOrderPaymentMode) {
         this.purchaseOrderPaymentMode = purchaseOrderPaymentMode;
         return this;
      }

      @JsonProperty("attachments")
      public PurchaseOrder.PurchaseOrderBuilder attachments(final String attachments) {
         this.attachments = attachments;
         return this;
      }

      @JsonProperty("purchaseStatus")
      public PurchaseOrder.PurchaseOrderBuilder purchaseStatus(final Integer purchaseStatus) {
         this.purchaseStatus = purchaseStatus;
         return this;
      }

      @JsonProperty("settlementStatus")
      public PurchaseOrder.PurchaseOrderBuilder settlementStatus(final Integer settlementStatus) {
         this.settlementStatus = settlementStatus;
         return this;
      }

      public PurchaseOrder.PurchaseOrderBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      @JsonProperty("remark")
      public PurchaseOrder.PurchaseOrderBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("editable")
      public PurchaseOrder.PurchaseOrderBuilder editable(final Boolean editable) {
         this.editable = editable;
         return this;
      }

      @JsonProperty("boolRewrite")
      public PurchaseOrder.PurchaseOrderBuilder boolRewrite(final Boolean boolRewrite) {
         this.boolRewrite = boolRewrite;
         return this;
      }

      @JsonProperty("boolUsed")
      public PurchaseOrder.PurchaseOrderBuilder boolUsed(final Integer boolUsed) {
         this.boolUsed = boolUsed;
         return this;
      }

      @JsonProperty("useRequisitions")
      public PurchaseOrder.PurchaseOrderBuilder useRequisitions(final Boolean useRequisitions) {
         this.useRequisitions = useRequisitions;
         return this;
      }

      @JsonProperty("userUpdateTime")
      public PurchaseOrder.PurchaseOrderBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      @JsonProperty("signingTime")
      public PurchaseOrder.PurchaseOrderBuilder signingTime(final LocalDateTime signingTime) {
         this.signingTime = signingTime;
         return this;
      }

      @JsonProperty("weightMeasurementMode")
      public PurchaseOrder.PurchaseOrderBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      @JsonProperty("level")
      public PurchaseOrder.PurchaseOrderBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      @JsonProperty("reviewStatus")
      public PurchaseOrder.PurchaseOrderBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("BoolAnnual")
      public PurchaseOrder.PurchaseOrderBuilder BoolAnnual(final Boolean BoolAnnual) {
         this.BoolAnnual = BoolAnnual;
         return this;
      }

      @JsonProperty("reviewPassTime")
      public PurchaseOrder.PurchaseOrderBuilder reviewPassTime(final LocalDateTime reviewPassTime) {
         this.reviewPassTime = reviewPassTime;
         return this;
      }

      @JsonProperty("boolTemporaryStorage")
      public PurchaseOrder.PurchaseOrderBuilder boolTemporaryStorage(final Boolean boolTemporaryStorage) {
         this.boolTemporaryStorage = boolTemporaryStorage;
         return this;
      }

      @JsonProperty("boolDetail")
      public PurchaseOrder.PurchaseOrderBuilder boolDetail(final Boolean boolDetail) {
         this.boolDetail = boolDetail;
         return this;
      }

      @JsonProperty("applyPurchaseStatus")
      public PurchaseOrder.PurchaseOrderBuilder applyPurchaseStatus(final String applyPurchaseStatus) {
         this.applyPurchaseStatus = applyPurchaseStatus;
         return this;
      }

      @JsonProperty("approveRecordIds")
      public PurchaseOrder.PurchaseOrderBuilder approveRecordIds(final String approveRecordIds) {
         this.approveRecordIds = approveRecordIds;
         return this;
      }

      @JsonProperty("approveRecordIdNow")
      public PurchaseOrder.PurchaseOrderBuilder approveRecordIdNow(final Long approveRecordIdNow) {
         this.approveRecordIdNow = approveRecordIdNow;
         return this;
      }

      @JsonProperty("dataStatus")
      public PurchaseOrder.PurchaseOrderBuilder dataStatus(final Integer dataStatus) {
         this.dataStatus = dataStatus;
         return this;
      }

      @JsonProperty("annualContractId")
      public PurchaseOrder.PurchaseOrderBuilder annualContractId(final Long annualContractId) {
         this.annualContractId = annualContractId;
         return this;
      }

      @JsonProperty("projectManagerId")
      public PurchaseOrder.PurchaseOrderBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      @JsonProperty("requestId")
      public PurchaseOrder.PurchaseOrderBuilder requestId(final String requestId) {
         this.requestId = requestId;
         return this;
      }

      @JsonProperty("workshopId")
      public PurchaseOrder.PurchaseOrderBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("classifyIds")
      public PurchaseOrder.PurchaseOrderBuilder classifyIds(final String classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      @JsonProperty("passParentId")
      public PurchaseOrder.PurchaseOrderBuilder passParentId(final Long passParentId) {
         this.passParentId = passParentId;
         return this;
      }

      @JsonProperty("detailIds")
      public PurchaseOrder.PurchaseOrderBuilder detailIds(final String detailIds) {
         this.detailIds = detailIds;
         return this;
      }

      @JsonProperty("boolSysgen")
      public PurchaseOrder.PurchaseOrderBuilder boolSysgen(final Boolean boolSysgen) {
         this.boolSysgen = boolSysgen;
         return this;
      }

      @JsonProperty("applyDetailMeteJson")
      public PurchaseOrder.PurchaseOrderBuilder applyDetailMeteJson(final String applyDetailMeteJson) {
         this.applyDetailMeteJson = applyDetailMeteJson;
         return this;
      }

      @JsonProperty("orderPlace")
      public PurchaseOrder.PurchaseOrderBuilder orderPlace(final Integer orderPlace) {
         this.orderPlace = orderPlace;
         return this;
      }

      @JsonProperty("artifactWageQuotaType")
      public PurchaseOrder.PurchaseOrderBuilder artifactWageQuotaType(final Integer artifactWageQuotaType) {
         this.artifactWageQuotaType = artifactWageQuotaType;
         return this;
      }

      @JsonProperty("artifactUnit")
      public PurchaseOrder.PurchaseOrderBuilder artifactUnit(final String artifactUnit) {
         this.artifactUnit = artifactUnit;
         return this;
      }

      @JsonProperty("enclosureUnit")
      public PurchaseOrder.PurchaseOrderBuilder enclosureUnit(final Integer enclosureUnit) {
         this.enclosureUnit = enclosureUnit;
         return this;
      }

      @JsonProperty("receiveState")
      public PurchaseOrder.PurchaseOrderBuilder receiveState(final Integer receiveState) {
         this.receiveState = receiveState;
         return this;
      }

      @JsonProperty("standingBookIsPrint")
      public PurchaseOrder.PurchaseOrderBuilder standingBookIsPrint(final Boolean standingBookIsPrint) {
         this.standingBookIsPrint = standingBookIsPrint;
         return this;
      }

      @JsonProperty("isGoForOaApproval")
      public PurchaseOrder.PurchaseOrderBuilder isGoForOaApproval(final Boolean isGoForOaApproval) {
         this.isGoForOaApproval = isGoForOaApproval;
         return this;
      }

      @JsonProperty("delDetailIds")
      public PurchaseOrder.PurchaseOrderBuilder delDetailIds(final String delDetailIds) {
         this.delDetailIds = delDetailIds;
         return this;
      }

      public PurchaseOrder.PurchaseOrderBuilder branchAttributeEnum(final Integer branchAttributeEnum) {
         this.branchAttributeEnum = branchAttributeEnum;
         return this;
      }

      public PurchaseOrder build() {
         return new PurchaseOrder(
            this.id,
            this.purchaseType,
            this.supplyType,
            this.materialType,
            this.basicClass,
            this.serialNumber,
            this.projectIds,
            this.projectAttribute,
            this.lastOperatorNameId,
            this.lastOperatorName,
            this.applicantId,
            this.applicantName,
            this.applyPurchaseIds,
            this.applyPurchaseSN,
            this.branchCompanyId,
            this.auxMaterialIds,
            this.otherMaterialIds,
            this.gasMaterialIds,
            this.supplierId,
            this.mete,
            this.meteUnit,
            this.amount,
            this.taxRate,
            this.invoiceType,
            this.logisticsTransportType,
            this.logisticsPayerType,
            this.purchaseOrderPaymentMode,
            this.attachments,
            this.purchaseStatus,
            this.settlementStatus,
            this.settlementAmount,
            this.remark,
            this.editable,
            this.boolRewrite,
            this.boolUsed,
            this.useRequisitions,
            this.userUpdateTime,
            this.signingTime,
            this.weightMeasurementMode,
            this.level,
            this.reviewStatus,
            this.BoolAnnual,
            this.reviewPassTime,
            this.boolTemporaryStorage,
            this.boolDetail,
            this.applyPurchaseStatus,
            this.approveRecordIds,
            this.approveRecordIdNow,
            this.dataStatus,
            this.annualContractId,
            this.projectManagerId,
            this.requestId,
            this.workshopId,
            this.classifyIds,
            this.passParentId,
            this.detailIds,
            this.boolSysgen,
            this.applyDetailMeteJson,
            this.orderPlace,
            this.artifactWageQuotaType,
            this.artifactUnit,
            this.enclosureUnit,
            this.receiveState,
            this.standingBookIsPrint,
            this.isGoForOaApproval,
            this.delDetailIds,
            this.branchAttributeEnum
         );
      }

      @Override
      public String toString() {
         return "PurchaseOrder.PurchaseOrderBuilder(id="
            + this.id
            + ", purchaseType="
            + this.purchaseType
            + ", supplyType="
            + this.supplyType
            + ", materialType="
            + this.materialType
            + ", basicClass="
            + this.basicClass
            + ", serialNumber="
            + this.serialNumber
            + ", projectIds="
            + this.projectIds
            + ", projectAttribute="
            + this.projectAttribute
            + ", lastOperatorNameId="
            + this.lastOperatorNameId
            + ", lastOperatorName="
            + this.lastOperatorName
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", applyPurchaseIds="
            + this.applyPurchaseIds
            + ", applyPurchaseSN="
            + this.applyPurchaseSN
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", auxMaterialIds="
            + this.auxMaterialIds
            + ", otherMaterialIds="
            + this.otherMaterialIds
            + ", gasMaterialIds="
            + this.gasMaterialIds
            + ", supplierId="
            + this.supplierId
            + ", mete="
            + this.mete
            + ", meteUnit="
            + this.meteUnit
            + ", amount="
            + this.amount
            + ", taxRate="
            + this.taxRate
            + ", invoiceType="
            + this.invoiceType
            + ", logisticsTransportType="
            + this.logisticsTransportType
            + ", logisticsPayerType="
            + this.logisticsPayerType
            + ", purchaseOrderPaymentMode="
            + this.purchaseOrderPaymentMode
            + ", attachments="
            + this.attachments
            + ", purchaseStatus="
            + this.purchaseStatus
            + ", settlementStatus="
            + this.settlementStatus
            + ", settlementAmount="
            + this.settlementAmount
            + ", remark="
            + this.remark
            + ", editable="
            + this.editable
            + ", boolRewrite="
            + this.boolRewrite
            + ", boolUsed="
            + this.boolUsed
            + ", useRequisitions="
            + this.useRequisitions
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", signingTime="
            + this.signingTime
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", level="
            + this.level
            + ", reviewStatus="
            + this.reviewStatus
            + ", BoolAnnual="
            + this.BoolAnnual
            + ", reviewPassTime="
            + this.reviewPassTime
            + ", boolTemporaryStorage="
            + this.boolTemporaryStorage
            + ", boolDetail="
            + this.boolDetail
            + ", applyPurchaseStatus="
            + this.applyPurchaseStatus
            + ", approveRecordIds="
            + this.approveRecordIds
            + ", approveRecordIdNow="
            + this.approveRecordIdNow
            + ", dataStatus="
            + this.dataStatus
            + ", annualContractId="
            + this.annualContractId
            + ", projectManagerId="
            + this.projectManagerId
            + ", requestId="
            + this.requestId
            + ", workshopId="
            + this.workshopId
            + ", classifyIds="
            + this.classifyIds
            + ", passParentId="
            + this.passParentId
            + ", detailIds="
            + this.detailIds
            + ", boolSysgen="
            + this.boolSysgen
            + ", applyDetailMeteJson="
            + this.applyDetailMeteJson
            + ", orderPlace="
            + this.orderPlace
            + ", artifactWageQuotaType="
            + this.artifactWageQuotaType
            + ", artifactUnit="
            + this.artifactUnit
            + ", enclosureUnit="
            + this.enclosureUnit
            + ", receiveState="
            + this.receiveState
            + ", standingBookIsPrint="
            + this.standingBookIsPrint
            + ", isGoForOaApproval="
            + this.isGoForOaApproval
            + ", delDetailIds="
            + this.delDetailIds
            + ", branchAttributeEnum="
            + this.branchAttributeEnum
            + ")";
      }
   }
}
