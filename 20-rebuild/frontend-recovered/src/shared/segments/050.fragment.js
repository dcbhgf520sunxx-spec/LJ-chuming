const Kl = { NORMAL: { L: "普通", K: "NORMAL", V: 0 }, QUEUE: { L: "队列", K: "QUEUE", V: 1 }, RESULT: { L: "结果", K: "RESULT", V: 2 }, PREVIEW: { L: "预览", K: "PREVIEW", V: 3 }, PRINT_DESIGN: { L: "设计", K: "PRINT_DESIGN", V: 4 }, CUSTOM_NORMAL: { L: "自定义-普通", K: "CUSTOM_NORMAL", V: 5 }, CUSTOM_QUEUE: { L: "自定义-队列", K: "CUSTOM_QUEUE", V: 6 } };
ve(Kl);
const We = { YUAN: { L: "元", K: "YUAN", V: "y" }, WAN: { L: "万元", K: "WAN", V: "w" } };
ve(We);
const zt = { MM: { L: "毫米", K: "MM", V: "mm" }, M: { L: "米", K: "M", V: "m" } };
ve(zt);
const vr = { MM: { L: "毫米", K: "MM", V: "mm" } };
ve(vr);
const st = { G: { L: "克", K: "G", V: "g" }, KG: { L: "千克", K: "KG", V: "kg" }, T: { L: "吨", K: "T", V: "t" } };
ve(st);
const a = { BLANK: { L: "空值", K: "BLANK" }, OTHER: { L: "其它", K: "OTHER" }, DICT: { L: "字典", K: "DICT" }, ENUM: { L: "枚举", K: "ENUM" }, DATE: { L: "日期", K: "DATE" }, DATES: { L: "时间段", K: "DATES" }, AMOUNT: { L: "金额", K: "AMOUNT" }, QUANTITY: { L: "数量", K: "QUANTITY" }, LENGTH: { L: "长度", K: "LENGTH" }, WEIGHT: { L: "重量", K: "WEIGHT" }, THICKNESS: { L: "厚度", K: "THICKNESS" }, METE: { L: "量", K: "METE" }, RATE: { L: "百分比", K: "RATE" }, DP: { L: "小数精度", K: "DP" }, GUID: { L: "编号", K: "GUID" }, CONTRACT_NO: { L: "合同编号", K: "CONTRACT_NO" }, PROJECT: { L: "项目名称", K: "PROJECT" }, FACTORY_NAME: { L: "工厂名称", K: "FACTORY_NAME" }, MONOMER_NAME: { L: "单体名称", K: "MONOMER_NAME" }, AREA_NAME: { L: "区域名称", K: "AREA_NAME" }, AREA_DIVIDE: { L: "区域划分", K: "AREA_DIVIDE" }, AREA_AXIS: { L: "轴线/标高", K: "AREA_AXIS" }, WAREHOUSE_NAME: { L: "仓库", K: "WAREHOUSE_NAME" }, COMPONENT_PROCESS: { L: "工序", K: "COMPONENT_PROCESS" }, WORKSHOP: { L: "车间", K: "WORKSHOP" }, PRODUCTION_LINE: { L: "生产线", K: "PRODUCTION_LINE" }, TEAM_NAME: { L: "班组名称", K: "TEAM_NAME" }, SUBJECT_NAME: { L: "科目名称", K: "SUBJECT_NAME" }, SUBJECT_CODE: { L: "科目编号", K: "SUBJECT_CODE" }, SERIAL_NUMBER: { L: "物料编号", K: "SERIAL_NUMBER" }, STRUCTURE_NAME: { L: "构件名称", K: "STRUCTURE_NAME" }, ENCLOSURE_NAME: { L: "围护名称", K: "ENCLOSURE_NAME" }, MATERIAL_CLASS_FULL_NAME: { L: "物料种类全称", K: "MATERIAL_CLASS_FULL_NAME" }, MATERIAL_CLASS_NAME: { L: "物料种类", K: "MATERIAL_CLASS_NAME" }, MATERIAL: { L: "材质", K: "MATERIAL" }, PLATE_TYPE: { L: "板型", K: "PLATE_TYPE" }, SPECIFICATION: { L: "规格", K: "SPECIFICATION" }, COLOR: { L: "颜色", K: "COLOR" }, UNIT: { L: "单位", K: "UNIT" }, MEASUREMENT_UNIT: { L: "计量单位", K: "MEASUREMENT_UNIT" }, ACCOUNTING_UNIT: { L: "核算单位", K: "ACCOUNTING_UNIT" }, BRAND: { L: "品牌", K: "BRAND" }, PRODUCT_TYPE: { L: "产品类型", K: "PRODUCT_TYPE" }, ORDER_TYPE: { L: "订单类型", K: "ORDER_TYPE" }, STRUCTURE_TYPE: { L: "结构类型", K: "STRUCTURE_TYPE" }, REIMBURSEMENT_TYPE: { L: "报销类型", K: "REIMBURSEMENT_TYPE" }, SUPPLIER_FEE_TYPE: { L: "供应商费用类型", K: "SUPPLIER_FEE_TYPE" }, PAYMENT_REASON: { L: "付款事由", K: "PAYMENT_REASON" }, USER_NAME: { L: "用户名称", K: "USER_NAME" }, COMPANY_NAME: { L: "公司名称", K: "COMPANY_NAME" }, DEPT: { L: "部门", K: "DEPT" }, PHONE: { L: "手机号", K: "PHONE" }, TEL: { L: "电话", K: "TEL" }, LICENSE_PLATE: { L: "车牌/船牌号", K: "LICENSE_PLATE" }, ADDRESS: { L: "地址", K: "ADDRESS" }, INVOICE_NO: { L: "发票编号", K: "INVOICE_NO" }, BANK: { L: "银行", K: "BANK" }, BANK_ACCOUNT: { L: "银行账号", K: "BANK_ACCOUNT" }, IMAGE: { L: "图片", K: "IMAGE" } }, i = { SYSTEM: { L: "系统", K: "SYSTEM", V: 1 }, CUSTOMIZE: { L: "自定义", K: "CUSTOMIZE", V: 2 } };
ve(i);
const t = { LEFT: { L: "左对齐", K: "LEFT", V: 1 }, CENTER: { L: "居中对齐", K: "CENTER", V: 2 }, RIGHT: { L: "右对齐", K: "RIGHT", V: 3 } };
ve(t);
const D = { TOP: { L: "顶端对齐", K: "TOP", V: 1 }, BOTTOM: { L: "垂直居中", K: "BOTTOM", V: 2 }, CENTER: { L: "底端对齐", K: "CENTER", V: 3 } };
ve(D);
const RQ = { BASE: { L: "基础", K: "BASE", V: 1 }, TITLE: { L: "标题", K: "TITLE", V: 2 }, TABLE: { L: "表格", K: "TABLE", V: 3 }, HEADER: { L: "表头", K: "HEADER", V: 4 }, FOOTER: { L: "表尾", K: "FOOTER", V: 5 } };
ve(RQ);
const MQ = { DEFAULT: { L: "YY/MM/DD", K: "DEFAULT", V: "YY/MM/DD" }, ONE: { L: "YYYY/MM/DD", K: "ONE", V: "YYYY/MM/DD" }, TWO: { L: "YY/M/D", K: "TWO", V: "YYYY/M/D" } };
ve(MQ);
const De = { MM: { L: "毫米", K: "MM", V: "mm" }, CM: { L: "厘米", K: "CM", V: "cm" }, IN: { L: "英寸", K: "IN", V: "in" } };
ve(De);
const xe = { ZERO: { L: "0", K: "ZERO", V: 0 }, ONE: { L: "1", K: "ONE", V: 1 }, TWO: { L: "2", K: "TWO", V: 2 } };
ve(xe);
const AQ = { ZERO: { L: "0", K: "ZERO", V: 0 }, ONE: { L: "1", K: "ONE", V: 1 }, TWO: { L: "2", K: "TWO", V: 2 }, THREE: { L: "3", K: "THREE", V: 3 } };
ve(AQ);
const ke = { DEFAULT: { L: "1 / 1", K: "DEFAULT", V: 1 }, ONE: { L: "第1页 / 共1页", K: "ONE", V: 2 }, TWO: { L: "第一页 / 共一页", K: "TWO", V: 3 } };
ve(ke);
const NQ = { fontUnit: "pt", unit: De.MM.V, unitPrecision: xe.ZERO.V, type: "steelPlateRequisition", name: "钢板当前采购明细", width: 210, height: 297, paddingLR: 10, paddingTB: 10, logo: { show: false, allPage: false, height: 20, width: 20, top: 10, left: 10, url: "" }, page: { show: true, format: ke.DEFAULT.V, align: t.CENTER.V, size: 11, bold: "unset", bottom: 2 }, title: { show: true, allPage: false, title: "钢板明细", align: t.CENTER.V, verticleAlign: D.CENTER.V, size: 17, bold: "bold", height: 10 }, header: { show: true, allPage: false, align: t.LEFT.V, verticleAlign: D.CENTER.V, size: 10, bold: "bold", height: 25, width: 190, emptyVal: "", fields: [] }, footer: { show: true, allPage: false, align: t.LEFT.V, verticleAlign: D.CENTER.V, size: 10, bold: "bold", height: 8, width: 190, emptyVal: "", tip: { show: false, text: "", bold: "unset", size: 9, align: t.LEFT.V, above: true }, fields: [] }, table: { th: { size: 10, bold: "bold", lineHeight: 15, paddingTB: 1 }, td: { size: 9, bold: "unset", lineHeight: 13, paddingTB: 2 }, emptyVal: "", index: { show: true, title: "序号", width: 10, align: t.CENTER.V }, summary: { show: false, title: "合计" }, extraFields: [], fields: [{ show: true, key: "purchaseSN", title: "申购单号", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "classifyName", title: "物料类别", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.MATERIAL_CLASS_NAME.K }, { show: true, key: "specification", title: "规格", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.SPECIFICATION.K }, { show: true, key: "thickness", title: "厚度(mm)", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 12, type: a.THICKNESS.K }, { show: true, key: "width", title: "宽（mm）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.SPECIFICATION.K }, { show: true, key: "length", title: "长度(mm)", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 12, type: a.LENGTH.K }, { show: true, key: "quantity", title: "数量（张）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.QUANTITY.K }, { show: true, key: "weighingTotalWeight", title: "重量（kg）", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 18, type: a.METE.K }, { show: true, key: "unitPrice", title: "含税单价", source: i.SYSTEM.V, align: t.RIGHT.V, minWidth: 18, type: a.AMOUNT.K, format: { toThousand: true, precision: 2, unit: We.YUAN.V }, sum: false }, { show: true, key: "amount", title: "含税金额", source: i.SYSTEM.V, align: t.RIGHT.V, minWidth: 18, type: a.AMOUNT.K, format: { toThousand: true, precision: 2, unit: We.YUAN.V }, sum: false }, { show: true, key: "brand", title: "品牌", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.BRAND.K }, { show: true, key: "shortName", title: "所属项目（简称）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 25, type: a.OTHER.K }, { show: true, key: "workshopName", title: "仓库", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "weightMeasurementModeName", title: "计量方式", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 20, type: a.OTHER.K }, { show: true, key: "uid", title: "标识（不可修改）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 20, type: a.OTHER.K }] } }, LQ = { fontUnit: "pt", unit: De.MM.V, unitPrecision: xe.ZERO.V, type: "sectionSteelTempRequisition", name: "型材当前采购明细", width: 210, height: 297, paddingLR: 10, paddingTB: 10, logo: { show: false, allPage: false, height: 20, width: 20, top: 10, left: 10, url: "" }, page: { show: true, format: ke.DEFAULT.V, align: t.CENTER.V, size: 11, bold: "unset", bottom: 2 }, title: { show: true, allPage: false, title: "型材明细", align: t.CENTER.V, verticleAlign: D.CENTER.V, size: 17, bold: "bold", height: 10 }, header: { show: true, allPage: false, align: t.LEFT.V, verticleAlign: D.CENTER.V, size: 10, bold: "bold", height: 25, width: 190, emptyVal: "", fields: [] }, footer: { show: true, allPage: false, align: t.LEFT.V, verticleAlign: D.CENTER.V, size: 10, bold: "bold", height: 8, width: 190, emptyVal: "", tip: { show: false, text: "", bold: "unset", size: 9, align: t.LEFT.V, above: true }, fields: [] }, table: { th: { size: 10, bold: "bold", lineHeight: 15, paddingTB: 1 }, td: { size: 9, bold: "unset", lineHeight: 13, paddingTB: 2 }, emptyVal: "", index: { show: true, title: "序号", width: 10, align: t.CENTER.V }, summary: { show: false, title: "合计" }, extraFields: [], fields: [{ show: true, key: "purchaseSN", title: "申购单号", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "classifyName", title: "物料类别", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.MATERIAL_CLASS_NAME.K }, { show: true, key: "specification", title: "规格", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.SPECIFICATION.K }, { show: true, key: "length", title: "定尺长度（mm）", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 12, type: a.LENGTH.K }, { show: true, key: "quantity", title: "数量（根）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.QUANTITY.K }, { show: true, key: "totalLength", title: "总长度（m）", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 12, type: a.LENGTH.K }, { show: true, key: "weighingTotalWeight", title: "重量（kg）", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 18, type: a.METE.K }, { show: true, key: "unitPrice", title: "含税单价", source: i.SYSTEM.V, align: t.RIGHT.V, minWidth: 18, type: a.AMOUNT.K, format: { toThousand: true, precision: 2, unit: We.YUAN.V }, sum: false }, { show: true, key: "amount", title: "含税金额", source: i.SYSTEM.V, align: t.RIGHT.V, minWidth: 18, type: a.AMOUNT.K, format: { toThousand: true, precision: 2, unit: We.YUAN.V }, sum: false }, { show: true, key: "brand", title: "品牌", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.BRAND.K }, { show: true, key: "shortName", title: "所属项目（简称）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 25, type: a.OTHER.K }, { show: true, key: "workshopName", title: "仓库", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "weightMeasurementModeName", title: "计量方式", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 20, type: a.OTHER.K }, { show: true, key: "uid", title: "标识（不可修改）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 20, type: a.OTHER.K }] } }, IQ = { fontUnit: "pt", unit: De.MM.V, unitPrecision: xe.ZERO.V, type: "steelCoilTempRequisition", name: "钢卷当前采购明细", width: 210, height: 297, paddingLR: 10, paddingTB: 10, logo: { show: false, allPage: false, height: 20, width: 20, top: 10, left: 10, url: "" }, page: { show: true, format: ke.DEFAULT.V, align: t.CENTER.V, size: 11, bold: "unset", bottom: 2 }, title: { show: true, allPage: false, title: "钢卷明细", align: t.CENTER.V, verticleAlign: D.CENTER.V, size: 17, bold: "bold", height: 10 }, header: { show: true, allPage: false, align: t.LEFT.V, verticleAlign: D.CENTER.V, size: 10, bold: "bold", height: 25, width: 190, emptyVal: "", fields: [] }, footer: { show: true, allPage: false, align: t.LEFT.V, verticleAlign: D.CENTER.V, size: 10, bold: "bold", height: 8, width: 190, emptyVal: "", tip: { show: false, text: "", bold: "unset", size: 9, align: t.LEFT.V, above: true }, fields: [] }, table: { th: { size: 10, bold: "bold", lineHeight: 15, paddingTB: 1 }, td: { size: 9, bold: "unset", lineHeight: 13, paddingTB: 2 }, emptyVal: "", index: { show: true, title: "序号", width: 10, align: t.CENTER.V }, summary: { show: false, title: "合计" }, extraFields: [], fields: [{ show: true, key: "purchaseSN", title: "申购单号", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "classifyName", title: "物料类别", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.MATERIAL_CLASS_NAME.K }, { show: true, key: "specification", title: "规格", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.SPECIFICATION.K }, { show: true, key: "weighingTotalWeight", title: "重量（kg）", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 18, type: a.METE.K }, { show: true, key: "thickness", title: "厚度(mm)", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 12, type: a.THICKNESS.K }, { show: true, key: "width", title: "宽（mm）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.SPECIFICATION.K }, { show: true, key: "length", title: "长度(mm)", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 12, type: a.LENGTH.K }, { show: true, key: "unitPrice", title: "含税单价", source: i.SYSTEM.V, align: t.RIGHT.V, minWidth: 18, type: a.AMOUNT.K, format: { toThousand: true, precision: 2, unit: We.YUAN.V }, sum: false }, { show: true, key: "amount", title: "含税金额", source: i.SYSTEM.V, align: t.RIGHT.V, minWidth: 18, type: a.AMOUNT.K, format: { toThousand: true, precision: 2, unit: We.YUAN.V }, sum: false }, { show: true, key: "color", title: "颜色", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "brand", title: "品牌", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.BRAND.K }, { show: true, key: "shortName", title: "所属项目（简称）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 25, type: a.OTHER.K }, { show: true, key: "workshopName", title: "仓库", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "uid", title: "标识（不可修改）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 20, type: a.OTHER.K }] } }, CQ = { fontUnit: "pt", unit: De.MM.V, unitPrecision: xe.ZERO.V, type: "otherSteelMaterialRequisition", name: "其他钢材当前采购明细", width: 210, height: 297, paddingLR: 10, paddingTB: 10, logo: { show: false, allPage: false, height: 20, width: 20, top: 10, left: 10, url: "" }, page: { show: true, format: ke.DEFAULT.V, align: t.CENTER.V, size: 11, bold: "unset", bottom: 2 }, title: { show: true, allPage: false, title: "其他钢材明细", align: t.CENTER.V, verticleAlign: D.CENTER.V, size: 17, bold: "bold", height: 10 }, header: { show: true, allPage: false, align: t.LEFT.V, verticleAlign: D.CENTER.V, size: 10, bold: "bold", height: 25, width: 190, emptyVal: "", fields: [] }, footer: { show: true, allPage: false, align: t.LEFT.V, verticleAlign: D.CENTER.V, size: 10, bold: "bold", height: 8, width: 190, emptyVal: "", tip: { show: false, text: "", bold: "unset", size: 9, align: t.LEFT.V, above: true }, fields: [] }, table: { th: { size: 10, bold: "bold", lineHeight: 15, paddingTB: 1 }, td: { size: 9, bold: "unset", lineHeight: 13, paddingTB: 2 }, emptyVal: "", index: { show: true, title: "序号", width: 10, align: t.CENTER.V }, summary: { show: false, title: "合计" }, extraFields: [], fields: [{ show: true, key: "purchaseSN", title: "申购单号", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "classifyName", title: "物料类别", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.MATERIAL_CLASS_NAME.K }, { show: true, key: "specification", title: "规格", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.SPECIFICATION.K }, { show: true, key: "measureUnit", title: "计量单位", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 18, type: a.MEASUREMENT_UNIT.K }, { show: false, key: "quantity", title: "数量", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.QUANTITY.K }, { show: true, key: "accountingUnit", title: "核算单位", source: i.SYSTEM.V, align: t.CENTER.V, width: 18, type: a.ACCOUNTING_UNIT.K }, { show: false, key: "mete", title: "核算量", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 18, type: a.METE.K }, { show: true, key: "unitPrice", title: "含税单价", source: i.SYSTEM.V, align: t.RIGHT.V, minWidth: 18, type: a.AMOUNT.K, format: { toThousand: true, precision: 2, unit: We.YUAN.V }, sum: false }, { show: true, key: "amount", title: "含税金额", source: i.SYSTEM.V, align: t.RIGHT.V, minWidth: 18, type: a.AMOUNT.K, format: { toThousand: true, precision: 2, unit: We.YUAN.V }, sum: false }, { show: true, key: "color", title: "颜色", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "brand", title: "品牌", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.BRAND.K }, { show: true, key: "shortName", title: "所属项目（简称）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 25, type: a.OTHER.K }, { show: true, key: "workshopName", title: "仓库", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "uid", title: "标识（不可修改）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 20, type: a.OTHER.K }] } }, PQ = { fontUnit: "pt", unit: De.MM.V, unitPrecision: xe.ZERO.V, type: "auxMaterialTempRequisition", name: "辅材当前采购明细", width: 210, height: 297, paddingLR: 10, paddingTB: 10, logo: { show: false, allPage: false, height: 20, width: 20, top: 10, left: 10, url: "" }, page: { show: true, format: ke.DEFAULT.V, align: t.CENTER.V, size: 11, bold: "unset", bottom: 2 }, title: { show: true, allPage: false, title: "辅材明细", align: t.CENTER.V, verticleAlign: D.CENTER.V, size: 17, bold: "bold", height: 10 }, header: { show: true, allPage: false, align: t.LEFT.V, verticleAlign: D.CENTER.V, size: 10, bold: "bold", height: 25, width: 190, emptyVal: "", fields: [] }, footer: { show: true, allPage: false, align: t.LEFT.V, verticleAlign: D.CENTER.V, size: 10, bold: "bold", height: 8, width: 190, emptyVal: "", tip: { show: false, text: "", bold: "unset", size: 9, align: t.LEFT.V, above: true }, fields: [] }, table: { th: { size: 10, bold: "bold", lineHeight: 15, paddingTB: 1 }, td: { size: 9, bold: "unset", lineHeight: 13, paddingTB: 2 }, emptyVal: "", index: { show: true, title: "序号", width: 10, align: t.CENTER.V }, summary: { show: false, title: "合计" }, extraFields: [], fields: [{ show: true, key: "purchaseSN", title: "申购单号", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "classifyName", title: "物料类别", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.MATERIAL_CLASS_NAME.K }, { show: true, key: "specification", title: "规格", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.SPECIFICATION.K }, { show: true, key: "measureUnit", title: "计量单位", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 18, type: a.MEASUREMENT_UNIT.K }, { show: true, key: "quantity", title: "数量", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.QUANTITY.K }, { show: true, key: "accountingUnit", title: "核算单位", source: i.SYSTEM.V, align: t.CENTER.V, width: 18, type: a.ACCOUNTING_UNIT.K }, { show: true, key: "mete", title: "核算量", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 18, type: a.METE.K }, { show: true, key: "unitPrice", title: "含税单价", source: i.SYSTEM.V, align: t.RIGHT.V, minWidth: 18, type: a.AMOUNT.K, format: { toThousand: true, precision: 2, unit: We.YUAN.V }, sum: false }, { show: true, key: "amount", title: "含税金额", source: i.SYSTEM.V, align: t.RIGHT.V, minWidth: 18, type: a.AMOUNT.K, format: { toThousand: true, precision: 2, unit: We.YUAN.V }, sum: false }, { show: true, key: "color", title: "颜色", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "brand", title: "品牌", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.BRAND.K }, { show: true, key: "shortName", title: "所属项目（简称）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 25, type: a.OTHER.K }, { show: true, key: "workshopName", title: "仓库", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "uid", title: "标识（不可修改）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 20, type: a.OTHER.K }] } }, OQ = { fontUnit: "pt", unit: De.MM.V, unitPrecision: xe.ZERO.V, type: "otherRequisition", name: "办公用品当前采购明细", width: 210, height: 297, paddingLR: 10, paddingTB: 10, logo: { show: false, allPage: false, height: 20, width: 20, top: 10, left: 10, url: "" }, page: { show: true, format: ke.DEFAULT.V, align: t.CENTER.V, size: 11, bold: "unset", bottom: 2 }, title: { show: true, allPage: false, title: "办公用品明细", align: t.CENTER.V, verticleAlign: D.CENTER.V, size: 17, bold: "bold", height: 10 }, header: { show: true, allPage: false, align: t.LEFT.V, verticleAlign: D.CENTER.V, size: 10, bold: "bold", height: 25, width: 190, emptyVal: "", fields: [] }, footer: { show: true, allPage: false, align: t.LEFT.V, verticleAlign: D.CENTER.V, size: 10, bold: "bold", height: 8, width: 190, emptyVal: "", tip: { show: false, text: "", bold: "unset", size: 9, align: t.LEFT.V, above: true }, fields: [] }, table: { th: { size: 10, bold: "bold", lineHeight: 15, paddingTB: 1 }, td: { size: 9, bold: "unset", lineHeight: 13, paddingTB: 2 }, emptyVal: "", index: { show: true, title: "序号", width: 10, align: t.CENTER.V }, summary: { show: false, title: "合计" }, extraFields: [], fields: [{ show: true, key: "purchaseSN", title: "申购单号", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "classifyName", title: "物料类别", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.MATERIAL_CLASS_NAME.K }, { show: true, key: "specification", title: "规格", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.SPECIFICATION.K }, { show: true, key: "measureUnit", title: "计量单位", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 18, type: a.MEASUREMENT_UNIT.K }, { show: true, key: "quantity", title: "数量", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.QUANTITY.K }, { show: true, key: "accountingUnit", title: "核算单位", source: i.SYSTEM.V, align: t.CENTER.V, width: 18, type: a.ACCOUNTING_UNIT.K }, { show: true, key: "mete", title: "核算量", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 18, type: a.METE.K }, { show: true, key: "unitPrice", title: "含税单价", source: i.SYSTEM.V, align: t.RIGHT.V, minWidth: 18, type: a.AMOUNT.K, format: { toThousand: true, precision: 2, unit: We.YUAN.V }, sum: false }, { show: true, key: "amount", title: "含税金额", source: i.SYSTEM.V, align: t.RIGHT.V, minWidth: 18, type: a.AMOUNT.K, format: { toThousand: true, precision: 2, unit: We.YUAN.V }, sum: false }, { show: true, key: "color", title: "颜色", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "brand", title: "品牌", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.BRAND.K }, { show: true, key: "shortName", title: "所属项目（简称）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 25, type: a.OTHER.K }, { show: true, key: "workshopName", title: "仓库", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "uid", title: "标识（不可修改）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 20, type: a.OTHER.K }] } }, kQ = { fontUnit: "pt", unit: De.MM.V, unitPrecision: xe.ZERO.V, type: "gasRequisition", name: "气体当前采购明细", width: 210, height: 297, paddingLR: 10, paddingTB: 10, logo: { show: false, allPage: false, height: 20, width: 20, top: 10, left: 10, url: "" }, page: { show: true, format: ke.DEFAULT.V, align: t.CENTER.V, size: 11, bold: "unset", bottom: 2 }, title: { show: true, allPage: false, title: "气体明细", align: t.CENTER.V, verticleAlign: D.CENTER.V, size: 17, bold: "bold", height: 10 }, header: { show: true, allPage: false, align: t.LEFT.V, verticleAlign: D.CENTER.V, size: 10, bold: "bold", height: 25, width: 190, emptyVal: "", fields: [] }, footer: { show: true, allPage: false, align: t.LEFT.V, verticleAlign: D.CENTER.V, size: 10, bold: "bold", height: 8, width: 190, emptyVal: "", tip: { show: false, text: "", bold: "unset", size: 9, align: t.LEFT.V, above: true }, fields: [] }, table: { th: { size: 10, bold: "bold", lineHeight: 15, paddingTB: 1 }, td: { size: 9, bold: "unset", lineHeight: 13, paddingTB: 2 }, emptyVal: "", index: { show: true, title: "序号", width: 10, align: t.CENTER.V }, summary: { show: false, title: "合计" }, extraFields: [], fields: [{ show: true, key: "purchaseSN", title: "申购单号", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "classifyName", title: "物料类别", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.MATERIAL_CLASS_NAME.K }, { show: true, key: "specification", title: "规格", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.SPECIFICATION.K }, { show: true, key: "measureUnit", title: "计量单位", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 18, type: a.MEASUREMENT_UNIT.K }, { show: true, key: "quantity", title: "数量", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.QUANTITY.K }, { show: true, key: "accountingUnit", title: "核算单位", source: i.SYSTEM.V, align: t.CENTER.V, width: 18, type: a.ACCOUNTING_UNIT.K }, { show: true, key: "mete", title: "核算量", source: i.SYSTEM.V, align: t.CENTER.V, minWidth: 18, type: a.METE.K }, { show: true, key: "unitPrice", title: "含税单价", source: i.SYSTEM.V, align: t.RIGHT.V, minWidth: 18, type: a.AMOUNT.K, format: { toThousand: true, precision: 2, unit: We.YUAN.V }, sum: false }, { show: true, key: "amount", title: "含税金额", source: i.SYSTEM.V, align: t.RIGHT.V, minWidth: 18, type: a.AMOUNT.K, format: { toThousand: true, precision: 2, unit: We.YUAN.V }, sum: false }, { show: true, key: "color", title: "颜色", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "brand", title: "品牌", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.BRAND.K }, { show: true, key: "shortName", title: "所属项目（简称）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 25, type: a.OTHER.K }, { show: true, key: "workshopName", title: "仓库", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 18, type: a.OTHER.K }, { show: true, key: "uid", title: "标识（不可修改）", source: i.SYSTEM.V, align: t.LEFT.V, minWidth: 20, type: a.OTHER.K }] } }, { handleMeteChangeCalcPrice: DQ } = ma("mete"), xQ = vi[Ge.STEEL_PLATE.V], _R = { title: "钢板采购清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "申购单号", field: "purchaseSN", excelField: "__EMPTY" }, { label: "*物料种类", field: "classifyName", excelField: "__EMPTY_1" }, { label: "型号", field: "material", excelField: "__EMPTY_2" }, { label: "厚（mm）", field: "thickness", type: "number", excelField: "__EMPTY_3" }, { label: "宽（mm）", field: "width", type: "number", excelField: "__EMPTY_4" }, { label: "长（mm）", field: "length", type: "number", excelField: "__EMPTY_5" }, { label: "数量（张）", field: "quantity", type: "number", excelField: "__EMPTY_6" }, { label: "重量（t）", field: "weighingTotalWeight", type: "number", precision: xQ.weight.precision, excelField: "__EMPTY_7" }, { label: "含税单价", field: "unitPrice", type: "number", excelField: "__EMPTY_8" }, { label: "含税金额", field: "amount", type: "number", excelField: "__EMPTY_9" }, { label: "品牌", field: "brand", excelField: "__EMPTY_10" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "计量方式", field: "weightMeasurementModeName", excelField: "__EMPTY_13" }, { label: "标识（不可修改）", field: "uid", excelField: "__EMPTY_14" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var f;
  if (!gi(e, _R.rules)) return;
  const n = [];
  for (const m in Wt.ENUM) n.push(Wt.ENUM[m]);
  _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const c = _e.state.wms.steelDensityCfg;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2");
  const u = await _a();
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const r = _e.state.config.rawMatClsList.filter((m) => m.basicClass === Ge.STEEL_PLATE.V), E = _e.state.config.rawMatClsKV, y = At(e), b = [];
  let V = [], M = [], g = [], S = [];
  const h = [];
  if (y.forEach((m) => {
    let R = false;
    const v = pi(m.classifyName.split("/"));
    if (v.length === 1) {
      const N = r.filter((P) => P.name === m.classifyName) || [];
      if (A(N)) if (N.length === 1) R = true, m.classifyId = N[0].id, b.push(N[0].id);
      else {
        const P = [];
        for (const O of N) if (O.isLeaf) for (let x = 0; x < O.fullPathId.length; x++) O.id !== O.fullPathId[x] && P.push(O.fullPathId[x]);
        const L = N.find((O) => Ae(O.parent) && !P.includes(O.id));
        if (A(L)) R = true, m.classifyId = L.id, b.push(L.id);
        else {
          const O = N.filter((x) => x.isLeaf) || [];
          if (O.length === 1) {
            let x = true;
            N.forEach((I) => {
              O[0].fullPathId.includes(I.id) || (x = false);
            }), x && (R = true, m.classifyId = O[0].id, b.push(O[0].id));
          } else for (const x of N) A(x.parent) && !P.includes(x.id) && h.push(x);
        }
      }
      if (h.length > 1) throw new Error(`科目名称“${m.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const N of r) if (N.fullPathName.length >= v.length && mi(N.fullPathName.slice(-v.length), v)) {
      R = true, m.classifyId = N.id, b.push(N.id);
      break;
    }
    if (R || V.push(m.classifyName), m.shortName) {
      const N = _e.state.project.projectAllType.find((P) => P.shortName === m.shortName);
      A(N) ? m.projectId = N.id : M.push(m.shortName);
    }
    if (m.workshopName) {
      const N = _e.state.config.workshopNameV2.find((P) => P.name === m.workshopName);
      A(N) ? m.workshopId = N.id : g.push(m.workshopName);
    }
    if (m.weightMeasurementModeName) {
      const N = n.find((P) => P.L === m.weightMeasurementModeName);
      A(N) ? m.weightMeasurementMode = N.V : S.push(m.weightMeasurementModeName);
    }
  }), V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((m) => `“${m}”`).join("、")}${V.length > 1 ? "等" : ""}物料种类不存在`);
  if (M = Array.from(new Set(M)), M.length > 0) throw new Error(`${M.map((m) => `“${m}”`).join("、")}${M.length > 1 ? "等" : ""}项目不存在`);
  if (g = Array.from(new Set(g)), g.length > 0) throw new Error(`${g.map((m) => `“${m}”`).join("、")}${g.length > 1 ? "等" : ""}仓库不存在`);
  if (S = Array.from(new Set(S)), S.length > 0) throw new Error(`${S.map((m) => `“${m}”`).join("、")}${S.length > 1 ? "等" : ""}计量方式不存在，应填理计或磅计`);
  const T = _e.state.config.classifySpec, _ = b.filter((m) => T[m] === void 0);
  _.length > 0 && (_.forEach((m) => {
    T[m] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", _));
  for (const m of y) {
    if (((f = E == null ? void 0 : E[m.classifyId]) == null ? void 0 : f.isLeaf) === false) throw new Error(`${m.classifyName}不是末级科目`);
    const R = T[m.classifyId];
    if (R.hasUnitConfig === false) throw new Error(`${m.classifyName}未配置核算单位`);
    let v;
    const N = m.material ?? "";
    if (R && Array.isArray(R.specList)) {
      for (const P of R.specList) if (N === P.spec) {
        v = P;
        break;
      }
    }
    if (v) {
      m.sn = v.sn, m.specificationLabels = v.specificationLabels, m.serialNumber = v.serialNumber, m.classifySerialNumber = v.classify.serialNumber, m.classifyId = v.classify.id, m.classifyFullName = v.classify.fullName, m.classifyName = v.classify.name, m.classifyParentFullName = v.classify.parentFullName, m.basicClass = v.classify.basicClass, m.specification = v.spec, m.model = v.spec, m.specificationMap = v.specKV, m.measureUnit = v.classify.measureUnit, m.accountingUnit = v.classify.accountingUnit, m.accountingPrecision = v.classify.accountingPrecision, m.measurePrecision = v.classify.measurePrecision;
      let P = 0;
      for (const L in c) Number(L) === m.classifyId && (P = c[L]);
      m.steelDensity = P, m.theoryWeight = await na({ classifyId: m.classifyId, name: m.classifyFullName, length: m.length, width: m.width, thickness: m.thickness }), A(m.theoryWeight) && m.quantity ? m.theoryTotalWeight = Be(m.theoryWeight * m.quantity, u[Ge.STEEL_PLATE.V].weight.precision) : m.theoryTotalWeight = void 0, m.weighingTotalWeight = m.weighingTotalWeight || m.theoryTotalWeight, m.mete = m.weighingTotalWeight, (!m.unitPrice || !m.amount) && DQ(m);
    } else throw new Error(`${m.classifyName}下不存在规格为“${N}”的材料，请联系初鸣售后人员添加`);
  }
  return y;
} }, { handleMeteChangeCalcPrice: UQ } = ma("mete"), YQ = vi[Ge.SECTION_STEEL.V], bR = { title: "型材采购清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "申购单号", field: "purchaseSN", excelField: "__EMPTY" }, { label: "*物料种类", field: "classifyName", excelField: "__EMPTY_1" }, { label: "*规格", field: "specification", excelField: "__EMPTY_2" }, { label: "定尺长度（mm）", field: "length", type: "number", excelField: "__EMPTY_3" }, { label: "数量（根）", field: "quantity", type: "number", excelField: "__EMPTY_4" }, { label: "总长度（m）", field: "totalLength", type: "number", excelField: "__EMPTY_5" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: YQ.weight.precision, excelField: "__EMPTY_6" }, { label: "含税单价", field: "unitPrice", type: "number", excelField: "__EMPTY_7" }, { label: "金额", field: "amount", type: "number", excelField: "__EMPTY_8" }, { label: "品牌", field: "brand", excelField: "__EMPTY_9" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_10" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_11" }, { label: "计量方式", field: "weightMeasurementModeName", excelField: "__EMPTY_12" }, { label: "标识（不可修改）", field: "uid", excelField: "__EMPTY_13" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], specification: [{ required: true, message: "型材型号不能为空" }] }, format: async (e) => {
  var _, f;
  if (!gi(e, bR.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2");
  const n = [];
  for (const m in Wt.ENUM) n.push(Wt.ENUM[m]);
  const c = await _a();
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const u = _e.state.config.rawMatClsList.filter((m) => m.basicClass === Ge.SECTION_STEEL.V), r = _e.state.config.rawMatClsKV, E = At(e), y = [];
  let b = [], V = [], M = [], g = [];
  const S = [];
  if (E.forEach((m) => {
    let R = false;
    const v = pi(m.classifyName.split("/"));
    if (v.length === 1) {
      const N = u.filter((P) => P.name === m.classifyName) || [];
      if (A(N)) if (N.length === 1) R = true, m.classifyId = N[0].id, y.push(N[0].id);
      else {
        const P = [];
        for (const O of N) if (O.isLeaf) for (let x = 0; x < O.fullPathId.length; x++) O.id !== O.fullPathId[x] && P.push(O.fullPathId[x]);
        const L = N.find((O) => Ae(O.parent) && !P.includes(O.id));
        if (A(L)) R = true, m.classifyId = L.id, y.push(L.id);
        else {
          const O = N.filter((x) => x.isLeaf) || [];
          if (O.length === 1) {
            let x = true;
            N.forEach((I) => {
              O[0].fullPathId.includes(I.id) || (x = false);
            }), x && (R = true, m.classifyId = O[0].id, y.push(O[0].id));
          } else for (const x of N) A(x.parent) && !P.includes(x.id) && S.push(x);
        }
      }
      if (S.length > 1) throw new Error(`科目名称“${m.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const N of u) if (N.fullPathName.length >= v.length && mi(N.fullPathName.slice(-v.length), v)) {
      R = true, m.classifyId = N.id, y.push(N.id);
      break;
    }
    if (R || b.push(m.classifyName), m.shortName) {
      const N = _e.state.project.projectAllType.find((P) => P.shortName === m.shortName);
      A(N) ? m.projectId = N.id : V.push(m.shortName);
    }
    if (m.workshopName) {
      const N = _e.state.config.workshopNameV2.find((P) => P.name === m.workshopName);
      A(N) ? m.workshopId = N.id : M.push(m.workshopName);
    }
    if (m.weightMeasurementModeName) {
      const N = n.find((P) => P.L === m.weightMeasurementModeName);
      A(N) ? m.weightMeasurementMode = N.V : g.push(m.weightMeasurementModeName);
    }
  }), b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((m) => `“${m}”`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((m) => `“${m}”`).join("、")}${V.length > 1 ? "等" : ""}项目不存在`);
  if (g = Array.from(new Set(g)), g.length > 0) throw new Error(`${g.map((m) => `“${m}”`).join("、")}${g.length > 1 ? "等" : ""}计量方式不存在，应填理计或磅计`);
  const h = _e.state.config.classifySpec, T = y.filter((m) => h[m] === void 0);
  T.length > 0 && (T.forEach((m) => {
    h[m] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", T));
  for (const m of E) {
    if (((_ = r == null ? void 0 : r[m.classifyId]) == null ? void 0 : _.isLeaf) === false) throw new Error(`${m.classifyName}不是末级科目`);
    const R = h[m.classifyId];
    if (R.hasUnitConfig === false) throw new Error(`${m.classifyName}未配置核算单位`);
    let v;
    const N = WQ(m.specification);
    if (R && Array.isArray(R.specList)) {
      for (const P of R.specList) if (N === P.spec) {
        if (P.status) v = P;
        else throw new Error(`${N}被禁用，请开启后重新导入`);
        break;
      }
    }
    if (v) {
      const P = (f = v.nationalStandardOptions.find((x) => x.boolDefault === true)) == null ? void 0 : f.standardId;
      m.sn = v.sn, m.specificationLabels = v.specificationLabels, m.serialNumber = v.serialNumber, m.classifySerialNumber = v.classify.serialNumber, m.classifyId = v.classify.id, m.classifyFullName = v.classify.fullName, m.classifyName = v.classify.name, m.classifyParentFullName = v.classify.parentFullName, m.basicClass = v.classify.basicClass, m.specification = v.spec, m.model = v.spec, m.specificationMap = v.specKV, m.measureUnit = v.classify.measureUnit, m.accountingUnit = v.classify.accountingUnit, m.accountingPrecision = v.classify.accountingPrecision, m.measurePrecision = v.classify.measurePrecision, m.unitWeight = v.unitWeight, m.standardId = P;
      let L;
      const O = [];
      for (const x in m.specificationMap) x.indexOf("standard") > -1 ? L = m.specificationMap[x] : O.push(m.specificationMap[x]);
      m.sectionSteelSpec = L, m.doNotSectionSteelSpec = O.join(" * "), m.theoryWeight = await xa({ length: m.length, unitWeight: m.unitWeight }), A(m.theoryWeight) && m.quantity ? m.theoryTotalWeight = Be(m.theoryWeight * m.quantity, c[Ge.SECTION_STEEL.V].weight.precision) : m.theoryTotalWeight = void 0, m.weighingTotalWeight = m.weighingTotalWeight || m.theoryTotalWeight, KQ(m), m.mete = m.weighingTotalWeight, (!m.unitPrice || !m.amount) && UQ(m);
    } else throw new Error(`${m.classifyName}下不存在型号为“${N}”的材料，请联系初鸣售后人员添加`);
  }
  return E;
} };
function KQ(e) {
  A(e.length) && e.quantity ? e.totalLength = Na({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
}
function WQ(e) {
  const o = e.replace(/\s+/g, ""), n = o.lastIndexOf("*");
  return n > -1 ? o.substring(0, n) + " * " + o.substring(n + 1) : o.substring(n + 1);
}
const { handleMeteChangeCalcPrice: jQ } = ma("mete"), FQ = vi[Ge.STEEL_COIL.V], VR = { title: "钢卷采购清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "申购单号", field: "purchaseSN", excelField: "__EMPTY" }, { label: "*物料种类", field: "classifyName", excelField: "__EMPTY_1" }, { label: "型号", field: "material", excelField: "__EMPTY_2" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: FQ.weight.precision, excelField: "__EMPTY_3" }, { label: "厚（mm）", field: "thickness", type: "number", excelField: "__EMPTY_4" }, { label: "宽（mm）", field: "width", type: "number", excelField: "__EMPTY_5" }, { label: "长（mm）", field: "length", type: "number", excelField: "__EMPTY_6" }, { label: "含税单价", field: "unitPrice", type: "number", excelField: "__EMPTY_7" }, { label: "金额", field: "amount", type: "number", excelField: "__EMPTY_8" }, { label: "颜色", field: "color", excelField: "__EMPTY_9" }, { label: "品牌", field: "brand", excelField: "__EMPTY_10" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "标识（不可修改）", field: "uid", excelField: "__EMPTY_13" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var T;
  if (!gi(e, VR.rules)) return;
  const n = [];
  for (const _ in Wt.ENUM) n.push(Wt.ENUM[_]);
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const c = _e.state.wms.steelDensityCfg, u = _e.state.config.rawMatClsList.filter((_) => _.basicClass === Ge.STEEL_COIL.V), r = _e.state.config.rawMatClsKV, E = At(e), y = [];
  let b = [], V = [], M = [];
  const g = [];
  if (E.forEach((_) => {
    let f = false;
    const m = pi(_.classifyName.split("/"));
    if (m.length === 1) {
      const R = u.filter((v) => v.name === _.classifyName) || [];
      if (A(R)) if (R.length === 1) f = true, _.classifyId = R[0].id, y.push(R[0].id);
      else {
        const v = [];
        for (const P of R) if (P.isLeaf) for (let L = 0; L < P.fullPathId.length; L++) P.id !== P.fullPathId[L] && v.push(P.fullPathId[L]);
        const N = R.find((P) => Ae(P.parent) && !v.includes(P.id));
        if (A(N)) f = true, _.classifyId = N.id, y.push(N.id);
        else {
          const P = R.filter((L) => L.isLeaf) || [];
          if (P.length === 1) {
            let L = true;
            R.forEach((O) => {
              P[0].fullPathId.includes(O.id) || (L = false);
            }), L && (f = true, _.classifyId = P[0].id, y.push(P[0].id));
          } else for (const L of R) A(L.parent) && !v.includes(L.id) && g.push(L);
        }
      }
      if (g.length > 1) throw new Error(`科目名称“${_.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const R of u) if (R.fullPathName.length >= m.length && mi(R.fullPathName.slice(-m.length), m)) {
      f = true, _.classifyId = R.id, y.push(R.id);
      break;
    }
    if (f || b.push(_.classifyName), _.shortName) {
      const R = _e.state.project.projectAllType.find((v) => v.shortName === _.shortName);
      A(R) ? _.projectId = R.id : V.push(_.shortName);
    }
    if (_.workshopName) {
      const R = _e.state.config.workshopNameV2.find((v) => v.name === _.workshopName);
      A(R) ? _.workshopId = R.id : M.push(_.workshopName);
    }
  }), b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((_) => `“${_}”`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((_) => `“${_}”`).join("、")}${V.length > 1 ? "等" : ""}项目不存在`);
  if (M = Array.from(new Set(M)), M.length > 0) throw new Error(`${M.map((_) => `“${_}”`).join("、")}${M.length > 1 ? "等" : ""}仓库不存在`);
  const S = _e.state.config.classifySpec, h = y.filter((_) => S[_] === void 0);
  h.length > 0 && (h.forEach((_) => {
    S[_] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", h));
  for (const _ of E) {
    if (((T = r == null ? void 0 : r[_.classifyId]) == null ? void 0 : T.isLeaf) === false) throw new Error(`${_.classifyName}不是末级科目`);
    const f = S[_.classifyId];
    if (f.hasUnitConfig === false) throw new Error(`${_.classifyName}未配置核算单位`);
    let m;
    const R = _.material ?? "";
    if (f && Array.isArray(f.specList)) {
      for (const v of f.specList) if (R === v.spec) {
        m = v;
        break;
      }
    }
    if (m) {
      _.sn = m.sn, _.specificationLabels = m.specificationLabels, _.serialNumber = m.serialNumber, _.classifySerialNumber = m.classify.serialNumber, _.classifyId = m.classify.id, _.classifyFullName = m.classify.fullName, _.classifyName = m.classify.name, _.classifyParentFullName = m.classify.parentFullName, _.basicClass = m.classify.basicClass, _.specification = m.spec, _.model = m.spec, _.specificationMap = m.specKV, _.measureUnit = m.classify.measureUnit, _.accountingUnit = m.classify.accountingUnit, _.accountingPrecision = m.classify.accountingPrecision, _.measurePrecision = m.classify.measurePrecision;
      let v = 0;
      for (const N in c) Number(N) === _.classifyId && (v = c[N]);
      _.steelDensity = v, await zQ(_), _.length = _.length || _.theoryLength, _.quantity = _.length, _.mete = _.weighingTotalWeight, (!_.unitPrice || !_.amount) && jQ(_);
    } else throw new Error(`${_.classifyName}下不存在规格为“${R}”的材料，请联系初鸣售后人员添加`);
  }
  return E;
} };
async function zQ(e) {
  e.theoryLength = await il({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
}
const wR = { title: "其它钢材采购清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "申购单号", field: "purchaseSN", excelField: "__EMPTY" }, { label: "*物料种类", field: "classifyName", excelField: "__EMPTY_1" }, { label: "型号", field: "specification", excelField: "__EMPTY_2" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_3" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_4" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_5" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_6" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_7" }, { label: "金额", field: "amount", excelField: "__EMPTY_8" }, { label: "颜色", field: "color", excelField: "__EMPTY_9" }, { label: "品牌", field: "brand", excelField: "__EMPTY_10" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "标识", field: "uid", excelField: "__EMPTY_13" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var S;
  if (!gi(e, wR.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((h) => h.basicClass === Pe.OTHER_STEEL_MATERIALS.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [], y = [], b = [];
  const V = [];
  if (u.forEach((h) => {
    let T = false;
    const _ = pi(h.classifyName.split("/"));
    if (_.length === 1) {
      const f = n.filter((m) => m.name === h.classifyName) || [];
      if (A(f)) if (f.length === 1) T = true, h.classifyId = f[0].id, r.push(f[0].id);
      else {
        const m = [];
        for (const v of f) if (v.isLeaf) for (let N = 0; N < v.fullPathId.length; N++) v.id !== v.fullPathId[N] && m.push(v.fullPathId[N]);
        const R = f.find((v) => Ae(v.parent) && !m.includes(v.id));
        if (A(R)) T = true, h.classifyId = R.id, r.push(R.id);
        else {
          const v = f.filter((N) => N.isLeaf) || [];
          if (v.length === 1) {
            let N = true;
            f.forEach((P) => {
              v[0].fullPathId.includes(P.id) || (N = false);
            }), N && (T = true, h.classifyId = v[0].id, r.push(v[0].id));
          } else for (const N of f) A(N.parent) && !m.includes(N.id) && V.push(N);
        }
      }
      if (V.length > 1) throw new Error(`科目名称“${h.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const f of n) if (f.fullPathName.length >= _.length && mi(f.fullPathName.slice(-_.length), _)) {
      T = true, h.classifyId = f.id, r.push(f.id);
      break;
    }
    if (T || E.push(h.classifyName), h.shortName) {
      const f = _e.state.project.projectAllType.find((m) => m.shortName === h.shortName);
      A(f) ? h.projectId = f.id : y.push(h.shortName);
    }
    if (h.workshopName) {
      const f = _e.state.config.workshopNameV2.find((m) => m.name === h.workshopName);
      A(f) ? h.workshopId = f.id : b.push(h.workshopName);
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((h) => `“${h}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  if (y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((h) => `“${h}”`).join("、")}${y.length > 1 ? "等" : ""}项目不存在`);
  const M = _e.state.config.classifySpec, g = r.filter((h) => M[h] === void 0);
  g.length > 0 && (g.forEach((h) => {
    M[h] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", g));
  for (const h of u) {
    if (((S = c == null ? void 0 : c[h.classifyId]) == null ? void 0 : S.isLeaf) === false) throw new Error(`${h.classifyName}不是末级科目`);
    const T = M[h.classifyId];
    if (T.hasUnitConfig === false) throw new Error(`${h.classifyName}未配置核算单位`);
    let _;
    const f = h.specification ?? "";
    if (T && Array.isArray(T.specList)) {
      for (const m of T.specList) if (f === m.spec) {
        if (_ = m, h.measureUnit) {
          if (!_.classify.measureUnit) throw new Error(`${h.classifyName}不存在计量单位`);
          if (!await ti(_.classify.measureUnit, h.measureUnit)) throw new Error(`${h.classifyName}填写的计量单位错误，单位应为：“${_.classify.measureUnit}”`);
        }
        if (h.accountingUnit && !await ti(_.classify.accountingUnit, h.accountingUnit)) throw new Error(`${h.classifyName}填写的核算单位错误，单位应为：“${_.classify.accountingUnit}”`);
        break;
      }
    }
    if (console.log(_), _) h.sn = _.sn, h.specificationLabels = _.specificationLabels, h.serialNumber = _.serialNumber, h.classifySerialNumber = _.classify.serialNumber, h.classifyId = _.classify.id, h.classifyFullPathId = _.classify.fullPathId, h.classifyFullName = _.classify.fullName, h.classifyName = _.classify.name, h.classifyParentFullName = _.classify.parentFullName, h.basicClass = _.classify.basicClass, h.specification = _.spec, h.model = _.spec, h.specificationMap = _.specKV, h.measureUnit = _.classify.measureUnit, h.accountingUnit = _.classify.accountingUnit, h.accountingPrecision = _.classify.accountingPrecision, h.measurePrecision = _.classify.measurePrecision, h.measureUnit || (h.quantity = void 0), h.mete && h.unitPrice && (h.amount = Be(h.mete * h.unitPrice, Ze.YUAN));
    else throw new Error(`${h.classifyName}下不存在规格为“${f}”的材料，请联系初鸣售后人员添加`);
  }
  return console.log(u), u;
} }, SR = { title: "辅材采购清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "申购单号", field: "purchaseSN", excelField: "__EMPTY" }, { label: "*物料种类", field: "classifyName", excelField: "__EMPTY_1" }, { label: "规格", field: "specification", excelField: "__EMPTY_2" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_3" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_4" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_5" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_6" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_7" }, { label: "金额", field: "amount", excelField: "__EMPTY_8" }, { label: "颜色", field: "color", excelField: "__EMPTY_9" }, { label: "品牌", field: "brand", excelField: "__EMPTY_10" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "标识", field: "uid", excelField: "__EMPTY_13" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var S;
  if (!gi(e, SR.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((h) => h.basicClass === Pe.MATERIAL.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [], y = [];
  const b = [], V = [];
  if (u.forEach((h) => {
    let T = false;
    const _ = pi(h.classifyName.split("/"));
    if (_.length === 1) {
      const f = n.filter((m) => m.name === h.classifyName) || [];
      if (A(f)) if (f.length === 1) T = true, h.classifyId = f[0].id, r.push(f[0].id);
      else {
        const m = [];
        for (const v of f) if (v.isLeaf) for (let N = 0; N < v.fullPathId.length; N++) v.id !== v.fullPathId[N] && m.push(v.fullPathId[N]);
        const R = f.find((v) => Ae(v.parent) && !m.includes(v.id));
        if (A(R)) T = true, h.classifyId = R.id, r.push(R.id);
        else {
          const v = f.filter((N) => N.isLeaf) || [];
          if (v.length === 1) {
            let N = true;
            f.forEach((P) => {
              v[0].fullPathId.includes(P.id) || (N = false);
            }), N && (T = true, h.classifyId = v[0].id, r.push(v[0].id));
          } else for (const N of f) A(N.parent) && !m.includes(N.id) && V.push(N);
        }
      }
      if (V.length > 1) throw new Error(`科目名称“${h.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const f of n) if (f.fullPathName.length >= _.length && mi(f.fullPathName.slice(-_.length), _)) {
      T = true, h.classifyId = f.id, r.push(f.id);
      break;
    }
    if (T || E.push(h.classifyName), h.shortName) {
      const f = _e.state.project.projectAllType.find((m) => m.shortName === h.shortName);
      A(f) ? h.projectId = f.id : y.push(h.shortName);
    }
    if (h.workshopName) {
      const f = _e.state.config.workshopNameV2.find((m) => m.name === h.workshopName);
      A(f) ? h.workshopId = f.id : b.push(h.workshopName);
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((h) => `“${h}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  if (y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((h) => `“${h}”`).join("、")}${y.length > 1 ? "等" : ""}项目不存在`);
  const M = _e.state.config.classifySpec, g = r.filter((h) => M[h] === void 0);
  g.length > 0 && (g.forEach((h) => {
    M[h] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", g));
  for (const h of u) {
    if (((S = c == null ? void 0 : c[h.classifyId]) == null ? void 0 : S.isLeaf) === false) throw new Error(`${h.classifyName}不是末级科目`);
    const T = M[h.classifyId];
    if (T.hasUnitConfig === false) throw new Error(`${h.classifyName}未配置核算单位`);
    let _;
    const f = h.specification ?? "";
    if (T && Array.isArray(T.specList)) {
      for (const m of T.specList) if (f === m.spec) {
        if (_ = m, h.measureUnit) {
          if (!_.classify.measureUnit) throw new Error(`${h.classifyName}不存在计量单位`);
          if (!await ti(_.classify.measureUnit, h.measureUnit)) throw new Error(`${h.classifyName}填写的计量单位错误，单位应为：“${_.classify.measureUnit}”`);
        }
        if (h.accountingUnit && !await ti(_.classify.accountingUnit, h.accountingUnit)) throw new Error(`${h.classifyName}填写的核算单位错误，单位应为：“${_.classify.accountingUnit}”`);
        break;
      }
    }
    if (_) h.sn = _.sn, h.specificationLabels = _.specificationLabels, h.serialNumber = _.serialNumber, h.classifySerialNumber = _.classify.serialNumber, h.classifyId = _.classify.id, h.classifyFullPathId = _.classify.fullPathId, h.classifyFullName = _.classify.fullName, h.classifyName = _.classify.name, h.classifyParentFullName = _.classify.parentFullName, h.basicClass = _.classify.basicClass, h.specification = _.spec, h.model = _.spec, h.specificationMap = _.specKV, h.measureUnit = _.classify.measureUnit, h.accountingUnit = _.classify.accountingUnit, h.accountingPrecision = _.classify.accountingPrecision, h.measurePrecision = _.classify.measurePrecision, h.measureUnit || (h.quantity = void 0), h.mete && h.unitPrice && (h.amount = Be(h.mete * h.unitPrice, Ze.YUAN));
    else throw new Error(`${h.classifyName}下不存在规格为“${f}”的材料，请联系初鸣售后人员添加`);
  }
  return u;
} }, vR = { title: "办公用品采购清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "申购单号", field: "purchaseSN", excelField: "__EMPTY" }, { label: "*物料种类", field: "classifyName", excelField: "__EMPTY_1" }, { label: "规格", field: "specification", excelField: "__EMPTY_2" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_3" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_4" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_5" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_6" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_7" }, { label: "金额", field: "amount", excelField: "__EMPTY_8" }, { label: "颜色", field: "color", excelField: "__EMPTY_9" }, { label: "品牌", field: "brand", excelField: "__EMPTY_10" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "标识", field: "uid", excelField: "__EMPTY_13" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var S;
  if (!gi(e, vR.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((h) => h.basicClass === Ge.OTHER.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [], y = [], b = [];
  const V = [];
  if (u.forEach((h) => {
    let T = false;
    const _ = pi(h.classifyName.split("/"));
    if (_.length === 1) {
      const f = n.filter((m) => m.name === h.classifyName) || [];
      if (A(f)) if (f.length === 1) T = true, h.classifyId = f[0].id, r.push(f[0].id);
      else {
        const m = [];
        for (const v of f) if (v.isLeaf) for (let N = 0; N < v.fullPathId.length; N++) v.id !== v.fullPathId[N] && m.push(v.fullPathId[N]);
        const R = f.find((v) => Ae(v.parent) && !m.includes(v.id));
        if (A(R)) T = true, h.classifyId = R.id, r.push(R.id);
        else {
          const v = f.filter((N) => N.isLeaf) || [];
          if (v.length === 1) {
            let N = true;
            f.forEach((P) => {
              v[0].fullPathId.includes(P.id) || (N = false);
            }), N && (T = true, h.classifyId = v[0].id, r.push(v[0].id));
          } else for (const N of f) A(N.parent) && !m.includes(N.id) && V.push(N);
        }
      }
      if (V.length > 1) throw new Error(`科目名称“${h.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const f of n) if (f.fullPathName.length >= _.length && mi(f.fullPathName.slice(-_.length), _)) {
      T = true, h.classifyId = f.id, r.push(f.id);
      break;
    }
    if (T || E.push(h.classifyName), h.shortName) {
      const f = _e.state.project.projectAllType.find((m) => m.shortName === h.shortName);
      A(f) ? h.projectId = f.id : y.push(h.shortName);
    }
    if (h.workshopName) {
      const f = _e.state.config.workshopNameV2.find((m) => m.name === h.workshopName);
      A(f) ? h.workshopId = f.id : b.push(h.workshopName);
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((h) => `“${h}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  if (y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((h) => `“${h}”`).join("、")}${y.length > 1 ? "等" : ""}项目不存在`);
  const M = _e.state.config.classifySpec, g = r.filter((h) => M[h] === void 0);
  g.length > 0 && (g.forEach((h) => {
    M[h] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", g));
  for (const h of u) {
    if (((S = c == null ? void 0 : c[h.classifyId]) == null ? void 0 : S.isLeaf) === false) throw new Error(`${h.classifyName}不是末级科目`);
    const T = M[h.classifyId];
    if (T.hasUnitConfig === false) throw new Error(`${h.classifyName}未配置核算单位`);
    let _;
    const f = h.specification ?? "";
    if (T && Array.isArray(T.specList)) {
      for (const m of T.specList) if (f === m.spec) {
        if (_ = m, h.measureUnit) {
          if (!_.classify.measureUnit) throw new Error(`${h.classifyName}不存在计量单位`);
          if (!await ti(_.classify.measureUnit, h.measureUnit)) throw new Error(`${h.classifyName}填写的计量单位错误，单位应为：“${_.classify.measureUnit}”`);
        }
        if (h.accountingUnit && !await ti(_.classify.accountingUnit, h.accountingUnit)) throw new Error(`${h.classifyName}填写的核算单位错误，单位应为：“${_.classify.accountingUnit}”`);
        break;
      }
    }
    if (_) h.sn = _.sn, h.specificationLabels = _.specificationLabels, h.serialNumber = _.serialNumber, h.classifySerialNumber = _.classify.serialNumber, h.classifyId = _.classify.id, h.classifyFullPathId = _.classify.fullPathId, h.classifyFullName = _.classify.fullName, h.classifyName = _.classify.name, h.classifyParentFullName = _.classify.parentFullName, h.basicClass = _.classify.basicClass, h.specification = _.spec, h.model = _.spec, h.specificationMap = _.specKV, h.measureUnit = _.classify.measureUnit, h.accountingUnit = _.classify.accountingUnit, h.accountingPrecision = _.classify.accountingPrecision, h.measurePrecision = _.classify.measurePrecision, h.measureUnit || (h.quantity = void 0), h.mete && h.unitPrice && (h.amount = Be(h.mete * h.unitPrice, Ze.YUAN));
    else throw new Error(`${h.classifyName}下不存在规格为“${f}”的材料，请联系初鸣售后人员添加`);
  }
  return u;
} }, RR = { title: "气体采购清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "申购单号", field: "purchaseSN", excelField: "__EMPTY" }, { label: "*物料种类", field: "classifyName", excelField: "__EMPTY_1" }, { label: "规格", field: "specification", excelField: "__EMPTY_2" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_3" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_4" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_5" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_6" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_7" }, { label: "金额", field: "amount", excelField: "__EMPTY_8" }, { label: "颜色", field: "color", excelField: "__EMPTY_9" }, { label: "品牌", field: "brand", excelField: "__EMPTY_10" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "标识", field: "uid", excelField: "__EMPTY_13" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var S;
  if (!gi(e, RR.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((h) => h.basicClass === Pe.GAS.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [], y = [];
  const b = [], V = [];
  if (u.forEach((h) => {
    let T = false;
    const _ = pi(h.classifyName.split("/"));
    if (_.length === 1) {
      const f = n.filter((m) => m.name === h.classifyName) || [];
      if (A(f)) if (f.length === 1) T = true, h.classifyId = f[0].id, r.push(f[0].id);
      else {
        const m = [];
        for (const v of f) if (v.isLeaf) for (let N = 0; N < v.fullPathId.length; N++) v.id !== v.fullPathId[N] && m.push(v.fullPathId[N]);
        const R = f.find((v) => Ae(v.parent) && !m.includes(v.id));
        if (A(R)) T = true, h.classifyId = R.id, r.push(R.id);
        else {
          const v = f.filter((N) => N.isLeaf) || [];
          if (v.length === 1) {
            let N = true;
            f.forEach((P) => {
              v[0].fullPathId.includes(P.id) || (N = false);
            }), N && (T = true, h.classifyId = v[0].id, r.push(v[0].id));
          } else for (const N of f) A(N.parent) && !m.includes(N.id) && V.push(N);
        }
      }
      if (V.length > 1) throw new Error(`科目名称“${h.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const f of n) if (f.fullPathName.length >= _.length && mi(f.fullPathName.slice(-_.length), _)) {
      T = true, h.classifyId = f.id, r.push(f.id);
      break;
    }
    if (T || E.push(h.classifyName), h.shortName) {
      const f = _e.state.project.projectAllType.find((m) => m.shortName === h.shortName);
      A(f) ? h.projectId = f.id : y.push(h.shortName);
    }
    if (h.workshopName) {
      const f = _e.state.config.workshopNameV2.find((m) => m.name === h.workshopName);
      A(f) ? h.workshopId = f.id : b.push(h.workshopName);
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((h) => `“${h}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  if (y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((h) => `“${h}”`).join("、")}${y.length > 1 ? "等" : ""}项目不存在`);
  const M = _e.state.config.classifySpec, g = r.filter((h) => M[h] === void 0);
  g.length > 0 && (g.forEach((h) => {
    M[h] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", g));
  for (const h of u) {
    if (((S = c == null ? void 0 : c[h.classifyId]) == null ? void 0 : S.isLeaf) === false) throw new Error(`${h.classifyName}不是末级科目`);
    const T = M[h.classifyId];
    if (T.hasUnitConfig === false) throw new Error(`${h.classifyName}未配置核算单位`);
    let _;
    const f = h.specification ?? "";
    if (T && Array.isArray(T.specList)) {
      for (const m of T.specList) if (f === m.spec) {
        if (_ = m, h.measureUnit) {
          if (!_.classify.measureUnit) throw new Error(`${h.classifyName}不存在计量单位`);
          if (!await ti(_.classify.measureUnit, h.measureUnit)) throw new Error(`${h.classifyName}填写的计量单位错误，单位应为：“${_.classify.measureUnit}”`);
        }
        if (h.accountingUnit && !await ti(_.classify.accountingUnit, h.accountingUnit)) throw new Error(`${h.classifyName}填写的核算单位错误，单位应为：“${_.classify.accountingUnit}”`);
        break;
      }
    }
    if (_) h.sn = _.sn, h.specificationLabels = _.specificationLabels, h.serialNumber = _.serialNumber, h.classifySerialNumber = _.classify.serialNumber, h.classifyId = _.classify.id, h.classifyFullPathId = _.classify.fullPathId, h.classifyFullName = _.classify.fullName, h.classifyName = _.classify.name, h.classifyParentFullName = _.classify.parentFullName, h.basicClass = _.classify.basicClass, h.specification = _.spec, h.model = _.spec, h.specificationMap = _.specKV, h.measureUnit = _.classify.measureUnit, h.accountingUnit = _.classify.accountingUnit, h.accountingPrecision = _.classify.accountingPrecision, h.measurePrecision = _.classify.measurePrecision, h.measureUnit || (h.quantity = void 0), h.mete && h.unitPrice && (h.amount = Be(h.mete * h.unitPrice, Ze.YUAN));
    else throw new Error(`${h.classifyName}下不存在规格为“${f}”的材料，请联系初鸣售后人员添加`);
  }
  return u;
} }, BQ = { class: "head-container" }, HQ = { key: 0 }, hd = { __name: "manuf-select-summary", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, projectId: { type: Number, default: void 0 }, tableData: { type: Array, default: () => [] }, permission: { type: Object, default: () => {
} }, currentRow: { type: Object, default: () => {
} }, isEdit: { type: Boolean, default: false } }, emits: ["update:modelValue", "addManufSuccess", "rowDelete"], setup(e, { emit: o }) {
  var N;
  const n = o, c = e, { visible: u, handleClose: r } = Ta({ emit: n, props: c }), E = Z(), y = Z(false), b = (N = ft("cu")) == null ? void 0 : N.form, V = Z(dn.NEW.V), M = Z(), g = Z([]), S = Z(), h = Ee(() => {
    var x, I;
    const P = ((x = g.value) == null ? void 0 : x[0]) || {}, L = [], O = b.currentBasicClass === Pe.STRUC_MANUFACTURED.V ? "structureList" : "enclosureList";
    return (I = b[O]) == null || I.forEach((Y) => {
      b.currentBasicClass === Pe.STRUC_MANUFACTURED.V ? L.push({ id: Y.finishedGoodsTypeName, name: Y.finishedGoodsTypeName }) : Y.manufacturedType === P.manufacturedType && L.push({ id: Y.finishedGoodsTypeName, name: Y.finishedGoodsTypeName });
    }), L;
  }), T = Ee(() => {
    const P = [];
    return b.structureList.forEach((L) => {
      P.push({ id: L.finishedGoodsTypeName, name: L.finishedGoodsTypeName });
    }), b.enclosureList.forEach((L) => {
      P.push({ id: L.finishedGoodsTypeName, name: L.finishedGoodsTypeName });
    }), P;
  });
  function _(P) {
    P === dn.NEW.V ? M.value = void 0 : M.value = S.value;
  }
  const { maxHeight: f } = Kt({ mainBox: ".manuf-select-summary", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", extraHeight: "5vh", minHeight: 300, navbar: false, clientHRepMainH: true }, E);
  Ce(u, (P) => {
    P && (g.value = c.tableData || [], M.value = void 0, A(c.currentRow) ? (V.value = dn.EXIST.V, M.value = c.currentRow.finishedGoodsTypeName, S.value = c.currentRow.finishedGoodsTypeName) : S.value = void 0);
  });
  function m() {
    if (M.value && T.value.findIndex((P) => P.name === M.value) > -1) {
      const P = T.value.map((L) => L.name).join("、");
      ot.error("已存在" + P + ",请重新填写"), M.value = void 0;
    }
  }
  function R(P, L) {
    g.value.splice(L, 1), n("rowDelete", P);
  }
  function v() {
    if (!c.isEdit) {
      if (!g.value.length) return ot.warning("请至少添加一条数据"), false;
      if (!M.value) return ot.error(`请${V.value === dn.NEW.V ? "填写" : "选择"}类型`), false;
      g.value.map((Y) => {
        Y.finishedGoodsTypeName = M.value, Y.wageQuotaType = b.currentBasicClass === Pe.STRUC_MANUFACTURED.V ? b.artifactWageQuotaType : b.enclosureWageQuotaType;
      });
      let P = 0, L = 0, O = 0, x = 0;
      g.value.forEach((Y) => {
        P += Y.quantity || 0, L += Y.totalWeight || 0, O += Y.totalLength || 0, x += Y.totalArea || 0;
      });
      let I = {};
      b.currentBasicClass === Pe.STRUC_MANUFACTURED.V ? I = { basicClass: b.currentBasicClass, finishedGoodsTypeName: M.value, manufacturedSpecification: g.value[0].manufacturedSpecification, boolOriginalDetail: g.value.findIndex((Y) => Y.boolOriginalDetail) > -1 ? !!b.boolUsed : false, wageQuotaType: g.value[0].wageQuotaType, quantity: P, totalWeight: L, totalLength: O, unitPrice: g.value[0].unitPrice, listId: g.value.map((Y) => Y.applyPurchaseDetailId) || [], list: g.value } : I = { basicClass: b.currentBasicClass, finishedGoodsTypeName: M.value, manufacturedSpecification: g.value[0].manufacturedSpecification, boolOriginalDetail: g.value.findIndex((Y) => Y.boolOriginalDetail) > -1 ? !!b.boolUsed : false, wageQuotaType: g.value[0].wageQuotaType, quantity: P, unitPrice: g.value[0].unitPrice, manufacturedType: g.value[0].manufacturedType, totalWeight: L, totalLength: O, totalArea: x, listId: g.value.map((Y) => Y.applyPurchaseDetailId) || [], list: g.value }, n("addManufSuccess", I);
    }
    r();
  }
  return (P, L) => {
    const O = Ve("common-button"), x = Ve("common-radio-button"), I = Mt, Y = Ve("common-select"), ee = vt, B = Ve("common-table"), q = Ve("common-drawer"), ae = oi;
    return w(), U(q, { ref_key: "childRefList", ref: E, modelValue: l(u), "onUpdate:modelValue": L[3] || (L[3] = (j) => Gt(u) ? u.value = j : null), "before-close": l(r), "close-on-click-modal": false, "custom-class": "manuf-select-summary", direction: "rtl", size: "100%", title: "选择汇总" }, { titleRight: p(() => [s(O, { class: "filter-item", size: "default", type: "success", onClick: v }, { default: p(() => L[4] || (L[4] = [Te("保存")])), _: 1, __: [4] })]), content: p(() => [C("div", BQ, [s(x, { modelValue: V.value, "onUpdate:modelValue": L[0] || (L[0] = (j) => V.value = j), disabled: l(A)(e.currentRow) && e.currentRow.boolOriginalDetail, options: l(dn).ENUM, class: "filter-item", size: "default", type: "enum", onChange: _ }, null, 8, ["modelValue", "disabled", "options"]), V.value === l(dn).NEW.V ? (w(), U(I, { key: 0, modelValue: M.value, "onUpdate:modelValue": L[1] || (L[1] = (j) => M.value = j), modelModifiers: { trim: true }, disabled: l(A)(e.currentRow) && e.currentRow.boolOriginalDetail, class: "filter-item input-underline", maxlength: "30", placeholder: "请输入类型", size: "default", style: { width: "220px" }, onBlur: m }, null, 8, ["modelValue", "disabled"])) : (w(), U(Y, { key: 1, modelValue: M.value, "onUpdate:modelValue": L[2] || (L[2] = (j) => M.value = j), disabled: l(A)(e.currentRow) && e.currentRow.boolOriginalDetail, options: h.value, class: "filter-item", placeholder: "请选择类型", style: { width: "220px" }, size: "default" }, null, 8, ["modelValue", "disabled", "options"]))]), qe((w(), U(B, { data: g.value, "max-height": l(f) - 100, style: { width: "100%" } }, { default: p(() => [s(ee, { align: "center", label: "序号", type: "index", width: "60" }), l(b).currentBasicClass === l(Pe).STRUC_MANUFACTURED.V ? (w(), Q(Qe, { key: 0 }, [s(ee, { align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), s(ee, { align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), s(ee, { align: "center", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" }), s(ee, { align: "center", label: "编号", "min-width": "100px", prop: "manufacturedSn", "show-overflow-tooltip": "" }), s(ee, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), s(ee, { align: "center", label: "长度（mm）", prop: "length", "show-overflow-tooltip": "" }), s(ee, { key: "totalLength", label: "总长度(m)", align: "left", "min-width": "100px", prop: "totalLength" }), s(ee, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), s(ee, { align: "center", label: "清单数量", prop: "quantity", "show-overflow-tooltip": "" }), s(ee, { align: "center", label: "单净重（kg）", prop: "weight", "show-overflow-tooltip": "" }), s(ee, { align: "center", label: "总重（kg）", prop: "totalWeight", "show-overflow-tooltip": "" })], 64)) : H("", true), l(b).currentBasicClass === l(Pe).ENCL_MANUFACTURED.V ? (w(), Q(Qe, { key: 1 }, [s(ee, { align: "center", label: "类型", prop: "manufacturedType", "show-overflow-tooltip": "" }, { default: p(({ row: j }) => [j.manufacturedType ? (w(), Q("span", HQ, K(l(Xi).VL[j.manufacturedType]), 1)) : H("", true)]), _: 1 }), s(ee, { key: "manufacturedName", "show-overflow-tooltip": true, label: "名称", "min-width": "100", prop: "manufacturedName" }), s(ee, { key: "manufacturedSn", "show-overflow-tooltip": true, label: "编号", "min-width": "90px", prop: "manufacturedSn" }), s(ee, { key: "plate", "show-overflow-tooltip": true, label: "板型", "min-width": "100px", prop: "plate" }), s(ee, { key: "width", label: `有效宽度
(mm)`, "show-overflow-tooltip": true, "min-width": "100px", prop: "width" }), s(ee, { key: "unfoldedWidth", label: `展开宽度
(mm)`, "show-overflow-tooltip": true, "min-width": "100px", prop: "unfoldedWidth" }), s(ee, { key: "bendTimes", label: "折弯次数", "show-overflow-tooltip": true, prop: "bendTimes", width: "80px" }), s(ee, { key: "thickness", label: `厚度
(mm)`, "show-overflow-tooltip": true, align: "left", "min-width": "100px", prop: "thickness" }), s(ee, { key: "length", label: `单长
(㎜)`, "show-overflow-tooltip": true, align: "left", "min-width": "100px", prop: "length" }), s(ee, { key: "quantity", label: "数量(张)", align: "left", "min-width": "100px", prop: "quantity" }), s(ee, { key: "totalArea", label: "总面积(㎡)", "show-overflow-tooltip": true, align: "left", "min-width": "100px", prop: "totalArea" }), s(ee, { key: "totalLength", label: "总长度(m)", align: "left", "min-width": "100px", prop: "totalLength" }), s(ee, { align: "center", label: "总重（kg）", prop: "totalWeight", "show-overflow-tooltip": "" }), s(ee, { key: "brand", "show-overflow-tooltip": true, label: "品牌", prop: "brand", width: "100px" }), s(ee, { key: "color", "show-overflow-tooltip": true, label: "颜色", prop: "color", width: "80px" })], 64)) : H("", true), s(ee, { align: "center", fixed: "right", label: "操作", width: "+0px" }, { default: p((j) => [!j.row.boolOriginalDetail || !l(b).boolUsed ? (w(), U(O, { key: 0, icon: "el-icon-delete", size: "default", type: "danger", onClick: (le) => R(j.row, j.$index) }, null, 8, ["onClick"])) : H("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[ae, y.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, qQ = Object.freeze(Object.defineProperty({ __proto__: null, default: hd }, Symbol.toStringTag, { value: "Module" })), GQ = ["onClick"], QQ = { key: 0 }, ZQ = { key: 0 }, JQ = { key: 1 }, XQ = { key: 2 }, MR = { __name: "structure-list", props: { maxHeight: { type: Number } }, setup(e, { expose: o }) {
  var P;
  const n = /* @__PURE__ */ new Map([]), c = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }] }, { tableValidate: u, cleanUpData: r, wrongCellMask: E } = ui({ rules: c, ditto: n }), y = (P = ft("cu")) == null ? void 0 : P.form, b = Z([]), V = Z(false), M = Z({});
  function g(L) {
    Dt(() => {
      _(L);
    });
  }
  function S(L, O) {
    _(O);
  }
  function h(L, O) {
    let x;
    O.wageQuotaType === ha.WEIGHT.V && (x = St(O.totalWeight, "kg", "t", Ze.COM_WT__T)), O.wageQuotaType === ha.LENGTH.V && (x = O.totalLength), O.wageQuotaType === ha.QUANTITY.V && (x = O.quantity), O.unitPrice = A(L) ? Be(L / x, 10) : void 0, O.list.forEach((I) => {
      const Y = O.unitPrice;
      let ee;
      I.wageQuotaType === ha.WEIGHT.V && (ee = St(I.totalWeight, "kg", "t", Ze.COM_WT__T), I.unitPrice = Y), I.wageQuotaType === ha.LENGTH.V && (ee = I.totalLength, I.unitPrice = Y), I.wageQuotaType === ha.QUANTITY.V && (ee = I.quantity, I.unitPrice = Y), I.amount = A(Y) && A(ee) ? Be(Y * ee, 2) : void 0;
    });
  }
  function T(L) {
    L.manufacturedSpecification ? L.list.forEach((O) => {
      O.manufacturedSpecification = L.manufacturedSpecification;
    }) : L.list.forEach((O) => {
      O.manufacturedSpecification = void 0;
    });
  }
  function _(L) {
    const O = Ho(L.unitPrice);
    let x = L.unitPrice;
    O > 10 && (L.unitPrice = Be(L.unitPrice, 10), x = L.unitPrice);
    let I;
    L.wageQuotaType === ha.WEIGHT.V && (I = St(L.totalWeight, "kg", "t", Ze.COM_WT__T)), L.wageQuotaType === ha.LENGTH.V && (I = L.totalLength), L.wageQuotaType === ha.QUANTITY.V && (I = L.quantity), L.amount = A(x) && A(I) ? Be(x * I, 2) : void 0, L.list.forEach((Y) => {
      let ee;
      Y.wageQuotaType === ha.WEIGHT.V && (ee = St(Y.totalWeight, "kg", "t", Ze.COM_WT__T), Y.unitPrice = x), Y.wageQuotaType === ha.LENGTH.V && (ee = Y.totalLength, Y.unitPrice = x), Y.wageQuotaType === ha.QUANTITY.V && (ee = Y.quantity, Y.unitPrice = x), Y.amount = A(x) && A(ee) ? Be(x * ee, 2) : void 0;
    });
  }
  function f(L) {
    V.value = true, b.value = (L == null ? void 0 : L.list) || [], M.value = L;
  }
  function m(L) {
    var I;
    const O = y.structureList.findIndex((Y) => Y.finishedGoodsTypeName === M.value.finishedGoodsTypeName), x = y.structureList.find((Y) => Y.finishedGoodsTypeName === M.value.finishedGoodsTypeName);
    ((I = x == null ? void 0 : x.list) == null ? void 0 : I.length) > 0 ? (x.quantity = 0, x.totalWeight = 0, x.totalLength = 0, x.totalArea = 0, x.listId = [], x.list.forEach((Y) => {
      x.listId.push(Y.applyPurchaseDetailId), x.quantity += Y.quantity || 0, x.totalWeight += Y.totalWeight || 0, x.totalLength += Y.totalLength || 0, x.totalArea += Y.totalArea || 0;
    })) : y.structureList.splice(O, 1);
  }
  function R() {
    const L = y.enclosureList.filter((x) => true);
    if (Ae(L)) return true;
    const { validResult: O } = u(L);
    return O && y.enclosureList.forEach((x) => {
      x.basicClass = on.STRUC_MANUFACTURED.V;
    }), O;
  }
  function v() {
    return r(y.enclosureList);
  }
  function N(L) {
    const O = y.structureList.findIndex((x) => x.finishedGoodsTypeName === M.value.finishedGoodsTypeName);
    y.structureList[O] = L, g(L);
  }
  return o({ validate: R, fetchResList: v, rowWatch: g }), (L, O) => {
    const x = vt, I = Mt, Y = Ve("common-input-number"), ee = Ve("common-table");
    return w(), Q(Qe, null, [s(ee, { data: l(y).structureList, "return-source-data": "", "show-empty-symbol": false, "max-height": e.maxHeight, "cell-class-name": l(E), style: { width: "100%" } }, { default: p(() => [s(x, { label: "序号", type: "index", align: "center", width: "60" }), s(x, { key: "finishedGoodsTypeName", prop: "finishedGoodsTypeName", label: "名称", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), s(x, { key: "manufacturedSpecification", prop: "manufacturedSpecification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "140px" }, { default: p(({ row: B }) => [s(I, { modelValue: B.manufacturedSpecification, "onUpdate:modelValue": (q) => B.manufacturedSpecification = q, modelModifiers: { trim: true }, disabled: B.boolOriginalDetail ? !!l(y).boolUsed : false, placeholder: "规格", maxlength: "100", style: { width: "100%" }, onBlur: (q) => T(B) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), _: 1 }), s(x, { key: "wageQuotaType", prop: "wageQuotaType", "show-overflow-tooltip": "", label: "计价方式", align: "center", "min-width": "120" }, { default: p(({ row: B }) => [C("span", null, K(l(ha).VL[B.wageQuotaType]), 1)]), _: 1 }), s(x, { key: "material", prop: "material", label: "计量单位", align: "center", "show-overflow-tooltip": "" }, { default: p(() => O[1] || (O[1] = [C("span", null, "件", -1)])), _: 1 }), s(x, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": "" }, { default: p(({ row: B }) => [C("span", { style: { cursor: "pointer", color: "#409eff" }, onClick: (q) => f(B) }, K(B.quantity), 9, GQ)]), _: 1 }), s(x, { key: "manufacturedUnit", prop: "manufacturedUnit", label: "核算单位", align: "center", "show-overflow-tooltip": "" }, { default: p(({ row: B }) => [B.wageQuotaType ? (w(), Q("span", QQ, K(l(ha).V[B.wageQuotaType].C_UNIT), 1)) : H("", true)]), _: 1 }), s(x, { key: "totalWeight", prop: "totalWeight", label: "核算量", align: "center", "show-overflow-tooltip": "" }, { default: p(({ row: B }) => [B.wageQuotaType === l(ha).WEIGHT.V ? (w(), Q("span", ZQ, K(l(St)(B.totalWeight, "kg", "t", l(Ze).COM_WT__T)), 1)) : H("", true), B.wageQuotaType === l(ha).LENGTH.V ? (w(), Q("span", JQ, K(B.totalLength), 1)) : H("", true), B.wageQuotaType === l(ha).QUANTITY.V ? (w(), Q("span", XQ, K(B.quantity), 1)) : H("", true)]), _: 1 }), s(x, { key: "unitPrice", prop: "unitPrice", align: "center", width: "135px", label: `单价（${l(y).artifactWageQuotaType === l(ha).WEIGHT.V ? "元/吨" : l(y).artifactWageQuotaType === l(ha).LENGTH.V ? "元/米" : "元/件"}）` }, { default: p(({ row: B }) => [s(Y, { modelValue: B.unitPrice, "onUpdate:modelValue": (q) => B.unitPrice = q, min: 0, max: 9999999999, controls: false, step: 1, size: "default", disabled: B.boolOriginalDetail ? !!l(y).boolUsed : false, placeholder: "含税单价", onChange: (q) => S(q, B) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])]), _: 1 }, 8, ["label"]), s(x, { key: "amount", prop: "amount", align: "center", width: "135px", label: "金额" }, { default: p(({ row: B }) => [s(Y, { modelValue: B.amount, "onUpdate:modelValue": (q) => B.amount = q, min: 0, max: 9999999999, controls: false, step: 1, size: "default", disabled: B.boolOriginalDetail ? !!l(y).boolUsed : false, precision: l(Ze).YUAN, placeholder: "金额", onChange: (q) => h(q, B) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision", "onChange"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]), s(l(hd), { modelValue: V.value, "onUpdate:modelValue": O[0] || (O[0] = (B) => V.value = B), isEdit: "", tableData: b.value, onRowDelete: m, currentRow: M.value, onAddManufSuccess: N }, null, 8, ["modelValue", "tableData", "currentRow"])], 64);
  };
} }, $Q = Object.freeze(Object.defineProperty({ __proto__: null, default: MR }, Symbol.toStringTag, { value: "Module" })), eZ = { key: 0 }, tZ = ["onClick"], iZ = { key: 0 }, aZ = { key: 0 }, lZ = { key: 1 }, oZ = { key: 2 }, AR = { __name: "enclosure-list", props: { maxHeight: { type: Number } }, setup(e, { expose: o }) {
  var P;
  const n = /* @__PURE__ */ new Map([]), c = Z([]), u = Z(false), r = Z({}), E = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }] }, { tableValidate: y, cleanUpData: b, wrongCellMask: V } = ui({ rules: E, ditto: n }), M = (P = ft("cu")) == null ? void 0 : P.form;
  function g(L) {
    Dt(() => {
      _(L);
    });
  }
  function S(L, O) {
    _(O);
  }
  function h(L, O) {
    if (L) {
      let x;
      O.wageQuotaType === ga.AREA.V && (x = O.totalArea), O.wageQuotaType === ga.LENGTH.V && (x = O.totalLength), O.wageQuotaType === ga.QUANTITY.V && (x = O.quantity), O.unitPrice = A(L) ? Be(L / x, 10) : void 0, O.list.forEach((I) => {
        const Y = O.unitPrice;
        let ee;
        I.wageQuotaType === ga.AREA.V && (ee = I.totalArea, I.unitPrice = Y), I.wageQuotaType === ga.LENGTH.V && (ee = I.totalLength, I.unitPrice = Y), I.wageQuotaType === ga.QUANTITY.V && (ee = I.quantity, I.unitPrice = Y), I.amount = A(Y) && A(ee) ? Be(Y * ee, 2) : void 0;
      });
    } else A(O.unitPrice) ? (O.amount = 0, O.list.forEach((x) => {
      x.unitPrice = 0, x.amount = 0;
    })) : (O.amount = void 0, O.list.forEach((x) => {
      x.unitPrice = void 0, x.amount = void 0;
    }));
  }
  function T(L) {
    L.manufacturedSpecification ? L.list.forEach((O) => {
      O.manufacturedSpecification = L.manufacturedSpecification;
    }) : L.list.forEach((O) => {
      O.manufacturedSpecification = void 0;
    });
  }
  function _(L) {
    if (L.unitPrice) {
      const O = Ho(L.unitPrice);
      let x = L.unitPrice;
      O > 10 && (L.unitPrice = Be(L.unitPrice, 10), x = L.unitPrice);
      let I;
      L.wageQuotaType === ga.AREA.V && (I = L.totalArea), L.wageQuotaType === ga.LENGTH.V && (I = L.totalLength), L.wageQuotaType === ga.QUANTITY.V && (I = L.quantity), L.amount = A(x) && A(I) ? Be(x * I, 2) : void 0, L.list.forEach((Y) => {
        const ee = L.unitPrice;
        let B;
        Y.wageQuotaType === ga.AREA.V && (B = Y.totalArea, Y.unitPrice = ee), Y.wageQuotaType === ga.LENGTH.V && (B = Y.totalLength, Y.unitPrice = ee), Y.wageQuotaType === ga.QUANTITY.V && (B = Y.quantity, Y.unitPrice = ee), Y.amount = A(ee) && A(B) ? Be(ee * B, 2) : void 0;
      });
    } else A(L.unitPrice) ? (L.amount = 0, L.list.forEach((O) => {
      O.unitPrice = 0, O.amount = 0;
    })) : (L.amount = void 0, L.list.forEach((O) => {
      O.unitPrice = void 0, O.amount = void 0;
    }));
  }
  function f(L) {
    u.value = true, c.value = (L == null ? void 0 : L.list) || [], r.value = L;
  }
  function m(L) {
    var I;
    const O = M.enclosureList.findIndex((Y) => Y.finishedGoodsTypeName === r.value.finishedGoodsTypeName), x = M.enclosureList.find((Y) => Y.finishedGoodsTypeName === r.value.finishedGoodsTypeName);
    ((I = x == null ? void 0 : x.list) == null ? void 0 : I.length) > 0 ? (x.quantity = 0, x.totalWeight = 0, x.totalLength = 0, x.totalArea = 0, x.list.forEach((Y) => {
      x.listId.push(Y.applyPurchaseDetailId), x.quantity += Y.quantity || 0, x.totalWeight += Y.totalWeight || 0, x.totalLength += Y.totalLength || 0, x.totalArea += Y.totalArea || 0;
    })) : M.enclosureList.splice(O, 1);
  }
  function R() {
    const L = M.enclosureList.filter((x) => true);
    if (Ae(L)) return true;
    const { validResult: O } = y(L);
    return O && M.enclosureList.forEach((x) => {
      x.basicClass = on.ENCL_MANUFACTURED.V;
    }), O;
  }
  function v() {
    return b(M.enclosureList);
  }
  function N(L) {
    const O = M.structureList.findIndex((x) => x.finishedGoodsTypeName === r.value.finishedGoodsTypeName);
    M.enclosureList[O] = L, g(L);
  }
  return o({ validate: R, fetchResList: v, rowWatch: g }), (L, O) => {
    const x = vt, I = Mt, Y = Ve("common-select"), ee = Ve("common-input-number"), B = Ve("common-table");
    return w(), Q(Qe, null, [s(B, { data: l(M).enclosureList, "return-source-data": "", "show-empty-symbol": false, "max-height": e.maxHeight, "cell-class-name": l(V), style: { width: "100%" } }, { default: p(() => [s(x, { label: "序号", type: "index", align: "center", width: "60" }), s(x, { key: "manufacturedType", prop: "manufacturedType", label: "类型", align: "center", "show-overflow-tooltip": "" }, { default: p(({ row: q }) => [q.manufacturedType ? (w(), Q("span", eZ, K(l(Xi).VL[q.manufacturedType]), 1)) : H("", true)]), _: 1 }), s(x, { key: "finishedGoodsTypeName", prop: "finishedGoodsTypeName", label: "名称", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), s(x, { key: "manufacturedSpecification", prop: "manufacturedSpecification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "140px" }, { default: p(({ row: q }) => [s(I, { modelValue: q.manufacturedSpecification, "onUpdate:modelValue": (ae) => q.manufacturedSpecification = ae, modelModifiers: { trim: true }, disabled: q.boolOriginalDetail ? !!l(M).boolUsed : false, placeholder: "规格", maxlength: "100", style: { width: "100%" }, onBlur: (ae) => T(q) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), _: 1 }), s(x, { key: "totalLength", prop: "length", label: "总长度(m)", align: "center", "show-overflow-tooltip": "" }), s(x, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), s(x, { key: "wageQuotaType", prop: "wageQuotaType", "show-overflow-tooltip": "", label: "计价方式", align: "center", "min-width": "120" }, { default: p(({ row: q }) => [s(Y, { modelValue: q.wageQuotaType, "onUpdate:modelValue": (ae) => q.wageQuotaType = ae, options: l(ga).ENUM, disabled: q.boolOriginalDetail ? !!l(M).boolUsed : false, size: "default", type: "enum", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"])]), _: 1 }), s(x, { key: "material", prop: "material", label: "计量单位", align: "center", "show-overflow-tooltip": "" }, { default: p(() => O[1] || (O[1] = [C("span", null, "张", -1)])), _: 1 }), s(x, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": "" }, { default: p(({ row: q }) => [C("span", { style: { cursor: "pointer", color: "#409eff" }, onClick: (ae) => f(q) }, K(q.quantity), 9, tZ)]), _: 1 }), s(x, { key: "manufacturedUnit", prop: "manufacturedUnit", label: "核算单位", align: "center", "show-overflow-tooltip": "" }, { default: p(({ row: q }) => [q.wageQuotaType ? (w(), Q("span", iZ, K(l(ga).V[q.wageQuotaType].C_UNIT), 1)) : H("", true)]), _: 1 }), s(x, { key: "totalWeight", prop: "totalWeight", label: "核算量", align: "center", "show-overflow-tooltip": "" }, { default: p(({ row: q }) => [q.wageQuotaType === l(ga).LENGTH.V ? (w(), Q("span", aZ, K(q.totalLength), 1)) : H("", true), q.wageQuotaType === l(ga).AREA.V ? (w(), Q("span", lZ, K(q.totalArea), 1)) : H("", true), q.wageQuotaType === l(ga).QUANTITY.V ? (w(), Q("span", oZ, K(q.quantity), 1)) : H("", true)]), _: 1 }), s(x, { key: "unitPrice", prop: "unitPrice", align: "center", width: "135px", label: `单价（${l(M).enclosureWageQuotaType === l(ga).LENGTH.V ? "元/米" : l(M).enclosureWageQuotaType === l(ga).AREA.V ? "元/平方米" : "元/张"}）` }, { default: p(({ row: q }) => [s(ee, { modelValue: q.unitPrice, "onUpdate:modelValue": (ae) => q.unitPrice = ae, min: 0, max: 9999999999, controls: false, step: 1, size: "default", placeholder: "含税单价", onChange: (ae) => S(ae, q) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 }, 8, ["label"]), s(x, { key: "amount", prop: "amount", align: "center", width: "135px", label: "金额" }, { default: p(({ row: q }) => [s(ee, { modelValue: q.amount, "onUpdate:modelValue": (ae) => q.amount = ae, min: 0, max: 9999999999, controls: false, step: 1, size: "default", precision: l(Ze).YUAN, placeholder: "金额", onChange: (ae) => h(ae, q) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]), s(l(hd), { modelValue: u.value, "onUpdate:modelValue": O[0] || (O[0] = (q) => u.value = q), isEdit: "", tableData: c.value, onRowDelete: m, currentRow: r.value, onAddManufSuccess: N }, null, 8, ["modelValue", "tableData", "currentRow"])], 64);
  };
} }, nZ = Object.freeze(Object.defineProperty({ __proto__: null, default: AR }, Symbol.toStringTag, { value: "Module" })), NR = { __name: "index", setup(e, { expose: o }) {
  var h;
  const n = (h = ft("cu")) == null ? void 0 : h.form, c = Z();
  Dt(() => {
    let T = 0;
    ["structureList", "enclosureList"].forEach((f) => {
      A(n[f]) && n[f].forEach((m) => {
        T += Number(m.amount) || 0;
      });
    }), n.amount = Be(T, Ze.YUAN), n.mete = void 0, n.meteUnit = "";
  });
  const u = Ct({ structureList: null, enclosureList: null }), r = (T) => {
    ["structureList", "enclosureList"].forEach((f) => {
      A(T[f]) && (T[f] = T[f].map((m) => Ct(m)), Ce(u, (m) => {
        m[f] && T[f].forEach((R) => {
          var v;
          return (v = m[f]) == null ? void 0 : v.rowWatch(R);
        });
      }, { immediate: true, deep: true }));
    });
  };
  Ce(() => n.currentBasicClass, (T) => {
    T && pt(() => {
      var f;
      let _ = "";
      switch (T) {
        case Pe.STRUC_MANUFACTURED.V:
          _ = "structureList";
          break;
        case Pe.ENCL_MANUFACTURED.V:
          _ = "enclosureList";
          break;
      }
      u[_] || (u[_] = c.value), (f = n[_]) == null || f.forEach((m) => {
        var R;
        return (R = Z[_]) == null ? void 0 : R.rowWatch(m);
      });
    });
  }, { immediate: true });
  const E = Ee(() => {
    switch (n.currentBasicClass) {
      case Pe.STRUC_MANUFACTURED.V:
        return MR;
      case Pe.ENCL_MANUFACTURED.V:
        return AR;
      default:
        return null;
    }
  });
  function y(T) {
    var _;
    return (_ = c.value) == null ? void 0 : _.rowInit(T);
  }
  function b() {
    n.list = [], n.structureList.map((T) => {
      var _;
      (_ = T.list) == null || _.forEach((f) => {
        f.manufacturedSpecification = T.manufacturedSpecification, n.list.push(f);
      });
    }), n.enclosureList.map((T) => {
      var _;
      (_ = T.list) == null || _.forEach((f) => {
        f.manufacturedSpecification = T.manufacturedSpecification, n.list.push(f);
      });
    });
  }
  function V() {
    if (Ae(n.structureList) && Ae(n.enclosureList)) return ot.warning("请填写数据"), false;
    const T = ["structureList", "enclosureList"], _ = ["结构制品列表", "围护制品列表"];
    let f = 0, m = true;
    for (let v = 0; v < T.length; v++) n[T[v]].forEach((N) => {
      if (Ae(N.unitPrice) || Ae(N.amount)) return m = false, f = v, false;
    });
    if (!m) return ot.error(`${_[f]}单价必填`), false;
    const R = M();
    return R && b(), R;
  }
  function M() {
    return Ae(n.structureList) && Ae(n.enclosureList) ? (ot.warning("请填写数据"), false) : Object.keys(u).every((T) => u[T] ? u[T].validate() : true);
  }
  function g() {
    return Object.keys(u).every((T) => u[T] ? u[T].TSValidate() : true);
  }
  function S(T) {
    var _;
    (_ = c.value) == null || _.rowWatch(T);
  }
  return o({ rowInit: y, validate: V, rowWatch: S, setFormCallback: r, getData: b, TSValidateTable: g }), (T, _) => (w(), U(Ri(E.value), ii({ ref_key: "steelRef", ref: c }, T.$attrs), null, 16));
} }, sZ = Object.freeze(Object.defineProperty({ __proto__: null, default: NR }, Symbol.toStringTag, { value: "Module" }));
const rZ = { class: "main-content" }, uZ = { class: "form-content" }, cZ = { class: "form-left" }, dZ = { class: "flex-rss child-mr-10" }, mZ = { key: 0 }, pZ = { key: 0 }, hZ = { key: 0 }, fZ = { key: 0 }, gZ = { key: 0 }, EZ = { class: "form-right" }, yZ = { class: "right-head flex-rbs" }, TZ = { class: "right-head-content" }, _Z = { __name: "submit-preview", props: { modelValue: { type: Boolean, default: false }, isPassedEdit: { type: Boolean, default: false }, edit: { type: Boolean, default: false }, isClose: { type: Boolean, default: false } }, emits: ["update:modelValue", "submit"], setup(e, { emit: o }) {
  var _;
  const n = Ht(), c = Z(), u = o, r = e, { supplierKV: E } = hu(), y = (_ = ft("cu")) == null ? void 0 : _.form, b = ft("cu"), V = Z(false), { visible: M, handleClose: g } = Ta({ emit: u, props: r }), { maxHeight: S } = Kt({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, c);
  Ce(() => b == null ? void 0 : b.submitResult, () => {
    var f;
    ((f = b == null ? void 0 : b.submitResult) == null ? void 0 : f.code) === 40206 && (n.dispatch("config/fetchMatClsTree"), b.submitResult.code = null, n.state.config.classifySpec = { specKV: [] });
  }, { deep: true });
  const { steelDensityCfg: h } = cn();
  async function T(f) {
    var m;
    if (V.value = true, await n.dispatch("wms/fetchSteelDensityCfg"), y.materialType & ct.STEEL.V) {
      const R = [];
      let v = [];
      if ((m = y.list) == null || m.forEach((N) => {
        (N.basicClass === Pe.STEEL_PLATE.V || N.basicClass === Pe.STEEL_COIL.V) && N.steelDensity !== h.value[N.classifyId] && R.push(`<div>【${N.classifyName}】最新设置密度与该单据创建时设置密度不一致！！！</div>`);
      }), v = Array.from(new Set(R)), v.length) {
        const N = v.join("");
        ot({ message: N, dangerouslyUseHTMLString: true, type: "warning", duration: 5e3 });
      }
    }
    u("submit", f), setTimeout(() => {
      V.value = false, g();
    }, 1e3);
  }
  return (f, m) => {
    const R = Ve("common-button"), v = qa, N = Mt, P = Zi, L = Ga, O = Ml, x = wi, I = Li, Y = Ve("common-drawer"), ee = _t("parse-enum"), B = oi;
    return w(), U(Y, { ref_key: "previewRef", ref: c, modelValue: l(M), "onUpdate:modelValue": m[4] || (m[4] = (q) => Gt(M) ? M.value = q : null), "before-close": l(g), direction: "rtl", size: "100%", title: "提交预览" }, { titleRight: p(() => [l(Ai)(l(DS).scmTemporaryStoragePM.add) && e.isPassedEdit && !r.edit && l(y).purchaseType === l(Fi).RAW_MATERIAL.V ? (w(), U(R, { key: 0, loading: V.value, size: "default", type: "warning", onClick: m[0] || (m[0] = (q) => T(l(co).YES.V)) }, { default: p(() => m[5] || (m[5] = [Te(" 暂存 ")])), _: 1, __: [5] }, 8, ["loading"])) : H("", true), s(R, { loading: V.value, size: "mini", type: "success", onClick: l(g) }, { default: p(() => m[6] || (m[6] = [Te(" 上一步 ")])), _: 1, __: [6] }, 8, ["loading", "onClick"]), s(R, { loading: V.value, size: "mini", type: "primary", onClick: m[1] || (m[1] = (q) => T(l(co).NO.V)) }, { default: p(() => m[7] || (m[7] = [Te(" 预 览 ")])), _: 1, __: [7] }, 8, ["loading"])]), content: p(() => [qe((w(), Q("div", rZ, [l(A)(l(y)) ? (w(), U(I, { key: 0, model: l(y), "label-position": "left", "label-width": "100px", size: "default" }, { default: p(() => [C("div", uZ, [C("div", cZ, [s(L, { column: 4, border: "", style: { "margin-bottom": "10px" } }, { default: p(() => [s(v, { label: "合同类型", "label-class-name": "contractLabel" }, { default: p(() => [C("span", null, K(l(Vn).VL[l(y).boolAnnual]), 1)]), _: 1 }), s(v, { label: "材料类型", "label-class-name": "contractLabel" }, { default: p(() => [C("div", dZ, [l(y).materialType & l(ct).MATERIAL.V ? H("", true) : qe((w(), Q("span", mZ, null, 512)), [[ee, { e: l(ct), v: l(y).materialType, extra: "：" }]]), qe(C("span", null, null, 512), [[ee, { e: l(Pe), v: l(y).basicClass, bit: true, split: " | " }]])])]), _: 1 }), l(y).materialType & l(sl) ? (w(), U(v, { key: 0, label: "合同量", "label-class-name": "contractLabel" }, { default: p(() => [C("span", null, K(l(y).mete) + " " + K(l(y).meteUnit), 1)]), _: 1 })) : H("", true), s(v, { label: "合同额", "label-class-name": "contractLabel" }, { default: p(() => [C("span", null, K(l(y).amount) + " 元", 1)]), _: 1 }), s(v, { label: "订单类型", "label-class-name": "contractLabel" }, { default: p(() => [qe(C("span", null, null, 512), [[ee, { e: l(Jl), v: l(y).purchaseOrderPaymentMode }]])]), _: 1 }), s(v, { label: "物流信息", "label-class-name": "contractLabel" }, { default: p(() => [qe(C("span", null, null, 512), [[ee, { e: l(Xa), v: l(y).logisticsTransportType }]]), m[8] || (m[8] = Te(" （费用")), qe(C("span", null, null, 512), [[ee, { e: l(Bi), v: l(y).logisticsPayerType }]]), m[9] || (m[9] = Te("） "))]), _: 1, __: [8, 9] }), s(v, { label: "供应商", "label-class-name": "contractLabel" }, { default: p(() => [l(y).supplierId ? (w(), Q("span", pZ, K(l(E)[l(y).supplierId].name), 1)) : H("", true)]), _: 1 }), s(v, { label: "采购单位", "label-class-name": "contractLabel" }, { default: p(() => [l(y).branchCompany ? (w(), Q("span", hZ, K(l(y).branchCompany.name), 1)) : H("", true)]), _: 1 }), s(v, { label: "发票及税率", "label-class-name": "contractLabel" }, { default: p(() => [qe(C("span", null, null, 512), [[ee, { e: l(fi), v: l(y).invoiceType }]]), m[10] || (m[10] = Te(" 【")), l(y).invoiceType !== l(fi).RECEIPT.V ? (w(), Q("span", fZ, "（" + K(l(y).taxRate) + "%）", 1)) : H("", true), m[11] || (m[11] = Te("】 "))]), _: 1, __: [10, 11] }), s(v, { label: "目的地", "label-class-name": "contractLabel" }, { default: p(() => [l(y).orderPlace ? (w(), Q("span", gZ, K(l(Bt).VL[l(y).orderPlace]), 1)) : H("", true)]), _: 1 }), s(v, { label: "关联项目", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(y).projects ? l(y).projects.map((q) => l(di)(q, null, false)).join(`
`) : ""), 1)]), _: 1 }), s(v, { label: "备注", "label-class-name": "contractLabel" }, { default: p(() => [s(P, { class: "el-form-item-14", "label-width": "0", prop: "remark" }, { default: p(() => [s(N, { modelValue: l(y).remark, "onUpdate:modelValue": m[2] || (m[2] = (q) => l(y).remark = q), disabled: !!l(y).boolUsed, rows: 2, class: "input-border-none", maxlength: "1000", placeholder: "备注", "show-word-limit": "", style: { "min-width": "330px" }, type: "textarea" }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 }), s(v, { label: "附件", "label-class-name": "contractLabel" }, { default: p(() => [s(dl, { files: l(y).attachments, "onUpdate:files": m[3] || (m[3] = (q) => l(y).attachments = q), "file-classify": l(cl).PURCHASE_ORDER_ATT.V, showView: true, class: "el-form-item-15", "empty-text": "暂未上传采购合同附件", "show-download": "" }, null, 8, ["files", "file-classify"])]), _: 1 })]), _: 1 })]), s(O, null, { default: p(() => m[12] || (m[12] = [C("span", { class: "title" }, "采购清单", -1)])), _: 1, __: [12] }), C("div", EZ, [C("div", yZ, [C("span", TZ, [(w(true), Q(Qe, null, ki(l(y).actualRequisitionIds, (q, ae) => (w(), Q("span", { key: q }, [s(x, { class: "preparation-sn-tag", effect: "plain" }, { default: p(() => {
      var j;
      return [Te(K((j = l(y).requisitions[ae]) == null ? void 0 : j.serialNumber), 1)];
    }), _: 2 }, 1024)]))), 128))])]), s(R_, { form: l(y), list: l(y).list, "material-type": l(y).materialType, "max-height": l(S) - 400, orderPlace: l(y).orderPlace, level: l(y).level }, null, 8, ["form", "list", "material-type", "max-height", "orderPlace", "level"])])])]), _: 1 }, 8, ["model"])) : H("", true)])), [[B, V.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, LR = ut(_Z, [["__scopeId", "data-v-a8c6a1b7"]]), bZ = Object.freeze(Object.defineProperty({ __proto__: null, default: LR }, Symbol.toStringTag, { value: "Module" }));
function fd() {
  const e = Z(), o = Z(), n = Z([]), c = Z({}), u = Z(false), { maxHeight: r } = Kt({ mainBox: ".material-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => o.value.loaded);
  Ce(u, (b) => {
    b && pt(() => {
      e.value.initSelected([c.value.sn]);
    });
  });
  function E(b) {
    c.value = b, n.value = [b], u.value = true;
  }
  function y(b) {
    const V = b[0];
    if (c.value.sn = V.sn, c.value.specificationLabels = V.specificationLabels, c.value.serialNumber = V.serialNumber, c.value.classifyId = V.classify.id, c.value.classifyFullName = V.classify.fullName, c.value.classifyName = V.classify.name, c.value.classifyParentFullName = V.classify.parentFullName, c.value.basicClass = V.classify.basicClass, c.value.specification = V.spec, c.value.specificationMap = V.specKV, c.value.specMerge = V.specMerge, c.value.specKV = V.specKV, c.value.measureUnit = V.classify.measureUnit, c.value.accountingUnit = V.classify.accountingUnit, c.value.measurePrecision = V.classify.measurePrecision, c.value.accountingPrecision = V.classify.accountingPrecision, c.value.unitWeight = V.unitWeight, c.value.basicClass === Ge.SECTION_STEEL.V) {
      let M;
      const g = [];
      for (const S in c.value.specificationMap) S.indexOf("standard") > -1 ? M = c.value.specificationMap[S] : g.push(c.value.specificationMap[S]);
      c.value.sectionSteelSpec = M, c.value.doNotSectionSteelSpec = g.join(" * ");
    }
  }
  return { specSelectMaxHeight: r, specRef: e, drawerRef: o, editRow: c, editList: n, materialSelectVisible: u, handleClickEditSpec: E, handleSpecChange: y };
}
function Va(e, { cfgType: o = "inbound", weightField: n = "weighingTotalWeight", compareWeightField: c = "theoryTotalWeight", weightTip: u = "理论重量" } = {}) {
  const { loaded: r, inboundSteelCfg: E, purchaseCfg: y } = aa(), b = Ee(() => o === "inbound" ? E.value : o === "purchase" ? y.value : null), V = Ee(() => r ? b.value.steelDiffType === bo.PERCENTAGE.V ? `实际重量与${u}的误差不可超过${u}的${b.value.steelDiff || 0}%` : `实际重量与${u}的误差不可超过${b.value.steelDiff || 0} ${nr}` : `请等待${o === "inbound" ? "wms钢材入库" : "采购钢材"}重量配置信息加载后再试`);
  function M(S, h) {
    return !S.hasOver;
  }
  function g(S, { weightCfg: h, baseUnit: T }) {
    if (!r) return `请等待${o === "inbound" ? "wms钢材入库" : "采购钢材"}重量配置信息加载后再试`;
    if (Ae(S[n]) && Ae(S[c])) return;
    let _ = false;
    const f = S[n] - S[c], m = h.value.steelDiff, R = h.value.steelDiffType;
    R === bo.PERCENTAGE.V && (_ = Math.abs(parseInt(S[n] / S[c] * Math.pow(10, 5) - 1 * Math.pow(10, 5))) / Math.pow(10, 5) * 100 > m), R === bo.NUMBER.V && (_ = St(Math.abs(S[n] - S[c]), T.value.weight.unit, nr, T.value.weight.precision) > m), S.hasOver = _, S.overNum = f;
  }
  return { overDiffTip: V, currentCfg: b, weightOverDiff: (S) => g(S, { weightCfg: b, baseUnit: e }), diffSubmitValidate: (S, h) => M(h, b.value.overDiffSubmittable) };
}
const VZ = { style: { float: "right" } }, es = { __name: "price-set-columns", props: { weightAttribute: { type: String, default: "weighingTotalWeight" }, form: { type: Object, default: void 0 }, isRequiredIdentifier: { type: Boolean, default: false } }, emits: ["setTablePrice", "clearTablePrice"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), { handleUnitPriceChange: r, handleAmountChange: E } = Al(c.weightAttribute);
  function y() {
    n("setTablePrice", u.value);
  }
  function b() {
    u.value = void 0, n("setTablePrice", u.value);
  }
  return (V, M) => {
    const g = Ve("common-input-number"), S = vt;
    return w(), Q(Qe, null, [s(S, { align: "left", label: "含税单价", prop: "unitPrice", width: "260px" }, { header: p(() => [M[1] || (M[1] = Te(" 含税单价 ")), C("div", VZ, [s(g, { modelValue: u.value, "onUpdate:modelValue": M[0] || (M[0] = (h) => u.value = h), controls: false, max: 9999999999, min: 0, step: 1, placeholder: "单价批量设置", size: "default", style: { width: "110px" } }, null, 8, ["modelValue"]), C("span", { class: "text-clickable", onClick: y }, "设置"), C("span", { class: "text-clickable", style: { "margin-left": "10px" }, onClick: b }, "清空")])]), default: p(({ row: h }) => [h ? (w(), U(g, { key: 0, modelValue: h.unitPrice, "onUpdate:modelValue": (T) => h.unitPrice = T, controls: false, disabled: h.boolOriginalDetail ? !!h.boolUsed : false, max: 9999999999, min: 0, step: 1, placeholder: "含税单价", size: "default", onChange: (T) => l(r)(T, h) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])) : H("", true)]), _: 1 }), s(S, { align: "center", label: "金额", prop: "amount", width: "145px" }, { default: p(({ row: h }) => [h ? (w(), U(g, { key: 0, modelValue: h.amount, "onUpdate:modelValue": (T) => h.amount = T, controls: false, disabled: h.boolOriginalDetail ? !!h.boolUsed : false, max: 9999999999, min: 0, precision: l(Ze).YUAN, step: 1, placeholder: "金额", size: "default", onChange: (T) => l(E)(T, h) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision", "onChange"])) : H("", true)]), _: 1 })], 64);
  };
} }, wZ = Object.freeze(Object.defineProperty({ __proto__: null, default: es }, Symbol.toStringTag, { value: "Module" })), SZ = { key: 1 }, vZ = { key: 1 }, RZ = { key: 1 }, IR = { __name: "steel-plate-table", setup(e, { expose: o }) {
  var ne;
  const { handleUnitPriceChange: n } = Al("weighingTotalWeight"), c = Z([]), u = Ge.STEEL_PLATE.V, r = ft("matSpecRef"), E = (ne = ft("cu")) == null ? void 0 : ne.form, y = ft("cu"), b = ft("purchaseCfg"), V = Z([]), M = Ee(() => [Wt.MIXTURE.K]);
  function g(te) {
    return te.boolOriginalDetail ? !te.boolUsed : true;
  }
  function S(te) {
    V.value = te;
  }
  function h() {
    var te;
    (te = V.value) == null || te.forEach((de) => {
      var re;
      const pe = (re = E.steelPlateList) == null ? void 0 : re.findIndex((we) => we.uid === de.uid);
      pe > -1 && J(de.sn, pe, de);
    });
  }
  function T({ row: te, rowIndex: de }) {
    var pe, re;
    if ((re = (pe = y == null ? void 0 : y.submitResult) == null ? void 0 : pe.data) != null && re.includes(te.classifyId)) return { backgroundColor: "#ffdede" };
  }
  const { baseUnit: _ } = ai(u), { overDiffTip: f, weightOverDiff: m, diffSubmitValidate: R } = Va(_), { specSelectMaxHeight: v, specRef: N, drawerRef: P, editRow: L, editList: O, materialSelectVisible: x, handleClickEditSpec: I, handleSpecChange: Y } = fd(), ee = (te, de) => A(de.weighingTotalWeight) && A(de.unitPrice) ? +Be(de.weighingTotalWeight * de.unitPrice, Ze.YUAN) == +te : false, B = (te, de) => A(te) ? te > 0 : true, q = (te, de) => A(te) || E.orderPlace === Bt.CONSTRUCTION_SITE.V ? te >= 0 : true, ae = (te, de) => {
    var pe;
    if (te) {
      if (A(de.purchaseSN) && ((pe = b.value) != null && pe.applyAndProcureMeteDiffState)) return de.maxCanPurchaseMete ? te <= de.maxCanPurchaseMete : false;
      if (de.width && de.length && de.thickness && de.quantity) return R(te, de);
    }
    return true;
  }, j = Ee(() => ({ classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], width: [{ validator: B, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { validator: B, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: ae, message: "超出误差允许范围,不可提交", trigger: "blur" }, { validator: B, message: "重量必须大于0", trigger: "blur" }], length: [{ validator: B, message: "长度必须大于0", trigger: "blur" }], quantity: [{ validator: q, message: "数量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: ee, message: "金额有误，请手动修改", trigger: "blur" }] })), le = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["weightMeasurementMode", -1]]), { tableValidate: oe, wrongCellMask: ye, cleanUpData: ce } = ui({ rules: j, errorMsg: "请修正【钢板清单】中标红的信息", ditto: le }), se = ft("steelDensityCfg");
  function he(te) {
    E.steelPlateList.forEach((de) => {
      (!de.boolOriginalDetail || de.boolOriginalDetail && !de.boolUsed) && (de.unitPrice = te, n(de.unitPrice, de));
    });
  }
  function be(te) {
    const de = Ct({ uid: Tt(), sn: te.sn, specificationLabels: te.specificationLabels, classifySerialNumber: te.classify.serialNumber, serialNumber: te.serialNumber, classifyId: te.classify.id, classifyFullName: te.classify.fullName, classifyName: te.classify.name, classifyParentFullName: te.classify.parentFullName, basicClass: te.classify.basicClass, specification: te.spec, model: te.spec, specificationMap: te.specKV, measureUnit: te.classify.measureUnit, accountingUnit: te.classify.accountingUnit, accountingPrecision: te.classify.accountingPrecision, measurePrecision: te.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, projectId: E.steelPlateList.length > 0 ? -1 : void 0, workshopId: E.steelPlateList.length > 0 ? -1 : void 0, weightMeasurementMode: E.steelPlateList.length > 0 ? -1 : Wt.THEORY.V, steelDensity: A(te.steelDensity) ? te.steelDensity : se.value[te.classify.id] });
    return Se(de), E.originSteelPlateList.push(de), de;
  }
  const { projectAllType: me } = Wa();
  function ge(te) {
    const de = me.value.find((pe) => pe.id === te.projectId);
    te.project = de;
  }
  const { workshopNameV2: Le } = Io();
  function Ie(te) {
    const de = Le.value.find((pe) => pe.id === te.workshopId);
    te.workshop = de;
  }
  function Se(te) {
    Dt(() => {
      Ie(te), te.purchaseSN || m(te);
    }), Ce([() => te.length, () => te.width, () => te.thickness, _], () => {
      A(te.originDetailObj) && (te.originChange = true), X(te);
    }), Ce([() => te.theoryWeight, () => te.quantity], () => {
      A(te.originDetailObj) && (te.originChange = true), $(te);
    }), Ce(() => te.weighingTotalWeight, () => {
      A(te.originDetailObj) && (te.originChange = true), k(te);
    }), Ce([() => te.specification, () => te.unitPrice, () => te.brand, () => te.projectId, () => te.workshopId], () => {
      A(te.originDetailObj) && (te.originChange = true);
    });
  }
  async function X(te) {
    te.theoryWeight = await na({ classifyId: te.classifyId, name: te.classifyFullName, length: te.length, width: te.width, thickness: te.thickness });
  }
  function $(te) {
    A(te.theoryWeight) && te.quantity ? (te.theoryTotalWeight = Be(te.theoryWeight * te.quantity, _.value.weight.precision), te.weighingTotalWeight = Be(te.theoryWeight * te.quantity, _.value.weight.precision)) : (te.theoryTotalWeight = void 0, te.isFirst || (te.weighingTotalWeight = void 0)), te.isFirst = false;
  }
  function k(te) {
    A(te.unitPrice) && A(te.weighingTotalWeight) ? te.amount = Be(te.weighingTotalWeight * te.unitPrice, Ze.YUAN) : te.amount = void 0;
  }
  function J(te, de, pe) {
    var we, Ke, Me, Ne;
    const re = E.originSteelPlateList.findIndex((He) => He.uid === pe.uid);
    if (E.originSteelPlateList.splice(re, 1), A(pe.originDetailObj) && E.delDetailIds.push(pe.id), pe.purchaseSN) {
      E.steelPlateList.splice(de, 1);
      const He = ["list", "originList"];
      for (let ze = 0; ze < He.length; ze++) if (A(E[He[ze]])) {
        const Oe = E[He[ze]].findIndex((Re) => Re.id === pe.id);
        Oe > -1 && E[He[ze]].splice(Oe, 1);
      }
    } else {
      if ((Ke = (we = y == null ? void 0 : y.submitResult) == null ? void 0 : we.data) != null && Ke.includes(pe.classifyId)) {
        const He = (Me = y == null ? void 0 : y.submitResult) == null ? void 0 : Me.data.findIndex((Oe) => Oe === pe.classifyId);
        E.steelPlateList.filter((Oe) => Oe.classifyId === pe.classifyId).length === 1 && ((Ne = y == null ? void 0 : y.submitResult) == null || Ne.data.splice(He, 1));
      }
      r.value ? r.value.delListItem(te, de) : E.steelPlateList.splice(de, 1);
    }
  }
  function z() {
    const te = E.steelPlateList.filter((pe) => true);
    if (Ae(te)) return true;
    if (F()) {
      const { validResult: pe } = oe(te);
      return pe && G(te), pe;
    } else return false;
  }
  function F() {
    var pe, re;
    const te = {}, de = {};
    if (c.value = [], E.steelPlateList.forEach((we) => {
      we.applyPurchaseDetailId && (Ae(te[we.applyPurchaseDetailId]) && (te[we.applyPurchaseDetailId] = { applyPurchaseDetailId: we.applyPurchaseDetailId, maxCanPurchaseMete: we.maxCanPurchaseMete, classifyId: we.classifyId, classifyName: we.classifyName, accountingUnit: we.accountingUnit, basicClass: we.basicClass }), Ae(de[we.applyPurchaseDetailId]) ? de[we.applyPurchaseDetailId] = { applyPurchaseDetailId: we.applyPurchaseDetailId, maxCanPurchaseMete: we.maxCanPurchaseMete, mete: we.weighingTotalWeight || 0, classifyId: we.classifyId, classifyName: we.classifyName, accountingUnit: we.accountingUnit, basicClass: we.basicClass } : de[we.applyPurchaseDetailId].mete += we.weighingTotalWeight || 0);
    }), (pe = b.value) != null && pe.applyAndProcureMeteDiffState) for (const we in te) de[we].mete > te[we].maxCanPurchaseMete && c.value.push({ applyPurchaseDetailId: te[we].applyPurchaseDetailId, maxCanPurchaseMete: te[we].maxCanPurchaseMete, classifyId: te[we].classifyId, classifyName: te[we].classifyName, msg: Ge.VL[te[we].basicClass] + "-" + te[we].classifyName + " 超过最大采购量【" + te[we].maxCanPurchaseMete + te[we].accountingUnit + "】" });
    if ((re = c.value) != null && re.length) {
      const we = c.value.map((Ke) => `<div>${Ke.msg}<div>`).join("");
      ot({ message: "<div>请注意标红处!<div>" + we, dangerouslyUseHTMLString: true, type: "error", duration: 5e3 });
    }
    return !(c.value.length > 0);
  }
  function G(te) {
    ce(te), te.forEach((de, pe) => {
      E.steelPlateList[pe].projectId = de.projectId, E.steelPlateList[pe].workshopId = de.workshopId, E.steelPlateList[pe].weightMeasurementMode = de.weightMeasurementMode;
    });
  }
  function ie() {
    if (Ae(E.steelPlateList)) return true;
    const te = E.steelPlateList.filter((pe) => true);
    return F() ? (G(te), true) : false;
  }
  function ue(te) {
    return Hi(te, { props: ["amount", "weighingTotalWeight", "quantity"], toThousandFields: ["amount", "weighingTotalWeight", "quantity"] });
  }
  return o({ rowInit: be, rowWatch: Se, validate: z, TSValidate: ie, deleteTableData: h }), (te, de) => {
    const pe = vt, re = jt, we = ya, Ke = Ve("common-input-number"), Me = Mt, Ne = Ve("common-select"), He = Ve("common-button"), ze = Ve("common-table"), Oe = Ve("common-drawer"), Re = _t("empty-text");
    return w(), Q(Qe, null, [s(ze, ii({ "cell-class-name": l(ye), data: l(E).steelPlateList, "row-style": T, "show-empty-symbol": false, stripe: false, "summary-method": ue, "return-source-data": "", "row-key": "uid", "show-summary": "" }, te.$attrs, { onSelectionChange: S }), { default: p(() => [s(pe, { selectable: g, align: "center", fixed: "left", type: "selection", width: "40" }), s(pe, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), l(E).useRequisitions ? (w(), U(pe, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : H("", true), s(pe, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }), s(pe, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: p(({ row: fe }) => [s(re, { content: fe.classifyParentFullName, disabled: !fe.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[Re, fe.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(pe, { align: "center", fixed: "left", label: "规格", "min-width": "130", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: fe }) => {
      var Ue;
      return [((Ue = l(b)) == null ? void 0 : Ue.spec) & l(u) && (!fe.boolOriginalDetail || !fe.boolUsed) ? (w(), U(we, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Je) => l(I)(fe) }, null, 8, ["onClick"])) : H("", true), s(re, { content: fe.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(fe.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(pe, { label: `厚 (${l(_).thickness.unit})`, align: "center", "min-width": "120", prop: "thickness" }, { default: p(({ row: fe }) => {
      var Ue;
      return [!fe.purchaseSN || fe.purchaseSN && ((Ue = l(b)) == null ? void 0 : Ue.thickness) & l(u) ? (w(), U(Ke, { key: 0, modelValue: fe.thickness, "onUpdate:modelValue": (Je) => fe.thickness = Je, controls: false, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, max: 99999999, min: 0, precision: l(_).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (w(), Q("span", SZ, K(fe.thickness), 1))];
    }), _: 1 }, 8, ["label"]), s(pe, { label: `宽 (${l(_).width.unit})`, align: "center", "min-width": "120", prop: "width" }, { default: p(({ row: fe }) => {
      var Ue;
      return [!fe.purchaseSN || fe.purchaseSN && ((Ue = l(b)) == null ? void 0 : Ue.width) & l(u) ? (w(), U(Ke, { key: 0, modelValue: fe.width, "onUpdate:modelValue": (Je) => fe.width = Je, controls: false, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, max: 99999999, min: 0, precision: l(_).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (w(), Q("span", vZ, K(fe.width), 1))];
    }), _: 1 }, 8, ["label"]), s(pe, { label: `长 (${l(_).length.unit})`, align: "center", "min-width": "120", prop: "length" }, { default: p(({ row: fe }) => {
      var Ue;
      return [!fe.purchaseSN || fe.purchaseSN && ((Ue = l(b)) == null ? void 0 : Ue.length) & l(u) ? (w(), U(Ke, { key: 0, modelValue: fe.length, "onUpdate:modelValue": (Je) => fe.length = Je, controls: false, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, max: 999999999, min: 0, precision: l(_).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (w(), Q("span", RZ, K(fe.length), 1))];
    }), _: 1 }, 8, ["label"]), s(pe, { label: `数量 (${l(_).measure.unit})`, align: "center", "min-width": "120", prop: "quantity" }, { default: p(({ row: fe }) => [s(Ke, { modelValue: fe.quantity, "onUpdate:modelValue": (Ue) => fe.quantity = Ue, controls: false, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, max: 999999999, min: 1, precision: l(_).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(pe, { key: "weighingTotalWeight", label: `总重 (${l(_).weight.unit})`, align: "center", "min-width": "135", prop: "weighingTotalWeight" }, { default: p(({ row: fe }) => {
      var Ue, Je;
      return [s(re, { content: fe.purchaseSN ? `${fe.weighingTotalWeight > fe.maxCanPurchaseMete && ((Ue = l(b)) != null && Ue.applyAndProcureMeteDiffState) ? "申购最大采购重量：" + fe.maxCanPurchaseMete + l(_).weight.unit : ""}` : `理论重量：${fe.theoryTotalWeight} ${l(_).weight.unit}， ${l(f)}`, disabled: !fe.hasOver && !fe.purchaseSN || fe.purchaseSN && fe.weighingTotalWeight <= fe.maxCanPurchaseMete || !((Je = l(b)) != null && Je.applyAndProcureMeteDiffState) || !fe.weighingTotalWeight, class: "item", effect: "dark", placement: "top" }, { default: p(() => {
        var Xe;
        return [s(Ke, { modelValue: fe.weighingTotalWeight, "onUpdate:modelValue": (Ye) => fe.weighingTotalWeight = Ye, class: Zt({ "over-weight-tip": fe.purchaseSN ? (fe.weighingTotalWeight > fe.maxCanPurchaseMete || c.value.findIndex((Ye) => Ye.applyPurchaseDetailId === fe.applyPurchaseDetailId) > -1) && ((Xe = l(b)) == null ? void 0 : Xe.applyAndProcureMeteDiffState) : fe.hasOver }), controls: false, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, max: 999999999, min: 0, precision: l(_).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "disabled", "precision"])];
      }), _: 2 }, 1032, ["content", "disabled"])];
    }), _: 1 }, 8, ["label"]), s(pe, { label: "已采购数量/核算量", align: "center", "min-width": "130", prop: "productQuantity" }, { default: p(({ row: fe }) => [Te(K(fe.productQuantity || "-") + " / " + K(fe.productMete || "-"), 1)]), _: 1 }), s(es, { form: l(E), onSetTablePrice: he }, null, 8, ["form"]), s(pe, { align: "center", label: "品牌", prop: "brand" }, { default: p(({ row: fe }) => [s(Me, { modelValue: fe.brand, "onUpdate:modelValue": (Ue) => fe.brand = Ue, modelModifiers: { trim: true }, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), s(pe, { align: "center", fixed: "right", label: "计量方式", prop: "weightMeasurementMode", width: "140px" }, { default: p(({ row: fe, $index: Ue }) => [s(Ne, { modelValue: fe.weightMeasurementMode, "onUpdate:modelValue": (Je) => fe.weightMeasurementMode = Je, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, options: l(Wt).ENUM, unshowOptions: M.value, "show-extra": Ue !== 0, type: "enum", placeholder: "计量方式", style: { width: "100%" }, size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "options", "unshowOptions", "show-extra"])]), _: 1 }), l(E).orderPlace === l(Bt).FACTORY.V ? (w(), U(pe, { key: 1, align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, { default: p(({ row: fe, $index: Ue }) => [s(l(ca), { modelValue: fe.projectId, "onUpdate:modelValue": (Je) => fe.projectId = Je, branchCompanyId: l(E).branchCompanyId, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, projectAttribute: l(E).projectAttribute, "show-extra": Ue !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (Je) => ge(fe) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "projectAttribute", "show-extra", "onChange"])]), _: 1 })) : H("", true), l(E).orderPlace === l(Bt).FACTORY.V ? (w(), U(pe, { key: 2, align: "center", label: "仓库", prop: "workshopId", width: "140px" }, { default: p(({ row: fe, $index: Ue }) => [s(Ul, { modelValue: fe.workshopId, "onUpdate:modelValue": (Je) => fe.workshopId = Je, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, "show-extra": Ue !== 0, placeholder: "请选择仓库" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "show-extra"])]), _: 1 })) : H("", true), s(pe, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: fe, $index: Ue }) => [s(He, { disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, icon: "el-icon-delete", size: "default", type: "danger", onClick: (Je) => J(fe.sn, Ue, fe) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]), s(Oe, { ref_key: "drawerRef", ref: P, modelValue: l(x), "onUpdate:modelValue": de[1] || (de[1] = (fe) => Gt(x) ? x.value = fe : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: N, modelValue: l(O), "onUpdate:modelValue": de[0] || (de[0] = (fe) => Gt(O) ? O.value = fe : null), classifyId: l(L).classifyId, "max-height": l(v), "show-classify": false, visible: l(x), "expand-query": "", mode: "selector", onChange: l(Y) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} }, MZ = Object.freeze(Object.defineProperty({ __proto__: null, default: IR }, Symbol.toStringTag, { value: "Module" })), AZ = { key: 1 }, CR = { __name: "section-steel-table", setup(e, { expose: o }) {
  var ne;
  const n = Z([]), c = Ge.SECTION_STEEL.V, u = ft("matSpecRef"), r = (ne = ft("cu")) == null ? void 0 : ne.form, E = ft("cu"), y = ft("purchaseCfg"), b = Z([]), V = Ee(() => [Wt.MIXTURE.K]);
  function M(te) {
    return te.boolOriginalDetail ? !te.boolUsed : true;
  }
  function g(te) {
    b.value = te;
  }
  function S() {
    var te;
    (te = b.value) == null || te.forEach((de) => {
      var re;
      const pe = (re = r.sectionSteelList) == null ? void 0 : re.findIndex((we) => we.uid === de.uid);
      pe > -1 && Se(de.sn, pe, de);
    });
  }
  function h({ row: te, rowIndex: de }) {
    var pe, re, we;
    if ((re = (pe = E == null ? void 0 : E.submitResult) == null ? void 0 : pe.data) != null && re.includes(te.classifyId) && ((we = E == null ? void 0 : E.submitResult) == null ? void 0 : we.code) === 40206) return { backgroundColor: "#ffdede" };
  }
  const { baseUnit: T } = ai(c), { overDiffTip: _, weightOverDiff: f, diffSubmitValidate: m } = Va(T), { specSelectMaxHeight: R, specRef: v, drawerRef: N, editRow: P, editList: L, materialSelectVisible: O, handleClickEditSpec: x, handleSpecChange: I } = fd(), Y = (te, de) => A(de.weighingTotalWeight) && A(de.unitPrice) ? +Be(de.weighingTotalWeight * de.unitPrice, Ze.YUAN) == +te : false, ee = (te, de) => A(te) ? te > 0 : true, B = (te, de) => A(te) || r.orderPlace === Bt.CONSTRUCTION_SITE.V ? te >= 0 : true, q = (te, de) => {
    var pe;
    if (te) {
      if (A(de.purchaseSN) && ((pe = y.value) != null && pe.applyAndProcureMeteDiffState)) return de.maxCanPurchaseMete ? te <= de.maxCanPurchaseMete : false;
      if (de.length && de.quantity && de.unitWeight) return m(te, de);
    }
    return false;
  }, ae = Ee(() => ({ classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], length: [{ required: true, message: "请填写定尺长度", trigger: "blur" }, { validator: ee, message: "定尺长度必须大于0", trigger: "blur" }], quantity: [{ validator: B, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: q, message: "超出误差允许范围,不可提交", trigger: "blur" }, { validator: ee, message: "重量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: Y, message: "金额有误，请手动修改", trigger: "blur" }] })), { handleUnitPriceChange: j, handleMeteChangeCalcPrice: le } = Al("weighingTotalWeight"), oe = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["weightMeasurementMode", -1]]), { tableValidate: ye, wrongCellMask: ce, cleanUpData: se } = ui({ rules: ae, errorMsg: "请修正【型材清单】中标红的信息", ditto: oe });
  function he(te) {
    r.sectionSteelList.forEach((de) => {
      (!de.boolOriginalDetail || de.boolOriginalDetail && !de.boolUsed) && (de.unitPrice = te, j(de.unitPrice, de));
    });
  }
  function be(te) {
    var Ke;
    const de = (Ke = te.nationalStandardOptions.find((Me) => Me.boolDefault === true)) == null ? void 0 : Ke.standardId, pe = Ct({ uid: Tt(), sn: te.sn, specificationLabels: te.specificationLabels, serialNumber: te.serialNumber, classifySerialNumber: te.classify.serialNumber, classifyId: te.classify.id, classifyFullName: te.classify.fullName, classifyName: te.classify.name, classifyParentFullName: te.classify.parentFullName, basicClass: te.classify.basicClass, specification: te.spec, model: te.spec, specificationMap: te.specKV, measureUnit: te.classify.measureUnit, accountingUnit: te.classify.accountingUnit, accountingPrecision: te.classify.accountingPrecision, measurePrecision: te.classify.measurePrecision, unitWeight: te.unitWeight, nationalStandardOptions: te.nationalStandardOptions, quantity: void 0, length: void 0, totalLength: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, hasOver: false, standardId: de, sectionSteelSpec: void 0, doNotSectionSteelSpec: void 0, projectId: r.sectionSteelList.length > 0 ? -1 : void 0, workshopId: r.sectionSteelList.length > 0 ? -1 : void 0, weightMeasurementMode: r.sectionSteelList.length > 0 ? -1 : Wt.THEORY.V });
    let re;
    const we = [];
    for (const Me in pe.specificationMap) Me.indexOf("standard") > -1 ? re = pe.specificationMap[Me] : we.push(pe.specificationMap[Me]);
    return pe.sectionSteelSpec = re, pe.doNotSectionSteelSpec = we.join(" * "), me(pe), r.originSectionSteelList.push(pe), pe;
  }
  function me(te) {
    Dt(() => {
      G(te), te.purchaseSN || f(te);
    }), Ce([() => te.length, () => te.unitWeight, T], () => ge(te)), Ce([() => te.theoryWeight, () => te.quantity], () => {
      Ie(te);
    }), Ce([() => te.length, () => te.quantity], () => {
      Le(te);
    }), Ce([() => te.weighingTotalWeight], () => le(te)), Ce([() => te.specification, () => te.unitPrice, () => te.brand, () => te.projectId, () => te.workshopId], () => {
      A(te.originDetailObj) && (te.originChange = true);
    });
  }
  async function ge(te) {
    te.theoryWeight = await xa({ length: te.length, unitWeight: te.unitWeight });
  }
  function Le(te) {
    A(te.length) && te.quantity ? te.totalLength = Na({ length: te.length, quantity: te.quantity }) : te.totalLength = void 0;
  }
  function Ie(te) {
    A(te.theoryWeight) && te.quantity ? (te.theoryTotalWeight = Be(te.theoryWeight * te.quantity, T.value.weight.precision), te.weighingTotalWeight = Be(te.theoryWeight * te.quantity, T.value.weight.precision)) : (te.theoryTotalWeight = void 0, te.weighingTotalWeight = void 0);
  }
  function Se(te, de, pe) {
    var we, Ke, Me, Ne;
    const re = r.originSectionSteelList.findIndex((He) => He.uid === pe.uid);
    if (r.originSectionSteelList.splice(re, 1), A(pe.originDetailObj) && r.delDetailIds.push(pe.id), pe.purchaseSN) {
      r.sectionSteelList.splice(de, 1);
      const He = ["list", "originList"];
      for (let ze = 0; ze < He.length; ze++) if (A(r[He[ze]])) {
        const Oe = r[He[ze]].findIndex((Re) => Re.id === pe.id);
        Oe > -1 && r[He[ze]].splice(Oe, 1);
      }
    } else {
      if ((Ke = (we = E == null ? void 0 : E.submitResult) == null ? void 0 : we.data) != null && Ke.includes(pe.classifyId)) {
        const He = (Me = E == null ? void 0 : E.submitResult) == null ? void 0 : Me.data.findIndex((Oe) => Oe === pe.classifyId);
        r.sectionSteelList.filter((Oe) => Oe.classifyId === pe.classifyId).length === 1 && ((Ne = E == null ? void 0 : E.submitResult) == null || Ne.data.splice(He, 1));
      }
      u.value ? u.value.delListItem(te, de) : r.sectionSteelList.splice(de, 1);
    }
  }
  function X() {
    const te = r.sectionSteelList.filter((pe) => true);
    if (Ae(te)) return true;
    if (k()) {
      const { validResult: pe } = ye(te);
      return pe && $(te), pe;
    } else return false;
  }
  function $(te) {
    se(te), te.forEach((de, pe) => {
      r.sectionSteelList[pe].projectId = de.projectId, r.sectionSteelList[pe].workshopId = de.workshopId, r.sectionSteelList[pe].weightMeasurementMode = de.weightMeasurementMode;
    });
  }
  function k() {
    var pe, re;
    const te = {}, de = {};
    if (n.value = [], r.sectionSteelList.forEach((we) => {
      we.applyPurchaseDetailId && (Ae(te[we.applyPurchaseDetailId]) && (te[we.applyPurchaseDetailId] = { applyPurchaseDetailId: we.applyPurchaseDetailId, maxCanPurchaseMete: we.maxCanPurchaseMete, classifyId: we.classifyId, classifyName: we.classifyName, accountingUnit: we.accountingUnit, basicClass: we.basicClass }), Ae(de[we.applyPurchaseDetailId]) ? de[we.applyPurchaseDetailId] = { applyPurchaseDetailId: we.applyPurchaseDetailId, maxCanPurchaseMete: we.maxCanPurchaseMete, mete: we.weighingTotalWeight || 0, classifyId: we.classifyId, classifyName: we.classifyName, accountingUnit: we.accountingUnit, basicClass: we.basicClass } : de[we.applyPurchaseDetailId].mete += we.weighingTotalWeight || 0);
    }), (pe = y.value) != null && pe.applyAndProcureMeteDiffState) for (const we in te) de[we].mete > te[we].maxCanPurchaseMete && n.value.push({ applyPurchaseDetailId: te[we].applyPurchaseDetailId, maxCanPurchaseMete: te[we].maxCanPurchaseMete, classifyId: te[we].classifyId, classifyName: te[we].classifyName, msg: Ge.VL[te[we].basicClass] + "-" + te[we].classifyName + " 超过最大采购量【" + te[we].maxCanPurchaseMete + te[we].accountingUnit + "】" });
    if ((re = n.value) != null && re.length) {
      const we = n.value.map((Ke) => `<div>${Ke.msg}<div>`).join("");
      ot({ message: "<div>请注意标红处!<div>" + we, dangerouslyUseHTMLString: true, type: "error", duration: 5e3 });
    }
    return !(n.value.length > 0);
  }
  const { projectAllType: J } = Wa();
  function z(te) {
    const de = J.value.find((pe) => pe.id === te.projectId);
    te.project = de;
  }
  const { workshopNameV2: F } = Io();
  function G(te) {
    const de = F.value.find((pe) => pe.id === te.workshopId);
    te.workshop = de;
  }
  function ie() {
    if (Ae(r.sectionSteelList)) return true;
    const te = r.sectionSteelList.filter((pe) => true);
    return k() ? ($(te), true) : false;
  }
  function ue(te) {
    return Hi(te, { props: ["amount", "weighingTotalWeight", "quantity"], toThousandFields: ["amount", "weighingTotalWeight", "quantity"] });
  }
  return o({ rowInit: be, rowWatch: me, validate: X, TSValidate: ie, deleteTableData: S }), (te, de) => {
    const pe = vt, re = jt, we = ya, Ke = Ve("common-input-number"), Me = Mt, Ne = Ve("common-select"), He = Ve("common-button"), ze = Ve("common-table"), Oe = Ve("common-drawer"), Re = _t("empty-text");
    return w(), Q(Qe, null, [s(ze, ii({ "cell-class-name": l(ce), data: l(r).sectionSteelList, "row-style": h, "show-empty-symbol": false, stripe: false, "summary-method": ue, "return-source-data": "", "row-key": "uid", "show-summary": "" }, te.$attrs, { onSelectionChange: g }), { default: p(() => [s(pe, { selectable: M, align: "center", fixed: "left", type: "selection", width: "40" }), s(pe, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), l(r).useRequisitions ? (w(), U(pe, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : H("", true), s(pe, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }), s(pe, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: p(({ row: fe }) => [s(re, { content: fe.classifyParentFullName, disabled: !fe.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[Re, fe.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(pe, { align: "center", fixed: "left", label: "规格", "min-width": "140", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: fe }) => {
      var Ue;
      return [(!fe.boolOriginalDetail || !fe.boolUsed) && (!fe.purchaseSN || fe.purchaseSN && ((Ue = l(y)) == null ? void 0 : Ue.spec) & l(c)) && !fe.boolUsed ? (w(), U(we, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Je) => l(x)(fe) }, null, 8, ["onClick"])) : H("", true), s(re, { content: fe.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(fe.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(pe, { label: `定尺长度 (${l(T).length.unit})`, align: "center", "min-width": "120", prop: "length" }, { default: p(({ row: fe }) => {
      var Ue;
      return [!fe.purchaseSN || fe.purchaseSN && ((Ue = l(y)) == null ? void 0 : Ue.length) & l(c) ? (w(), U(Ke, { key: 0, modelValue: fe.length, "onUpdate:modelValue": (Je) => fe.length = Je, controls: false, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, max: 999999999, min: 0, precision: l(T).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (w(), Q("span", AZ, K(fe.length), 1))];
    }), _: 1 }, 8, ["label"]), s(pe, { label: `数量 (${l(T).measure.unit})`, align: "center", "min-width": "120", prop: "quantity" }, { default: p(({ row: fe }) => [s(Ke, { modelValue: fe.quantity, "onUpdate:modelValue": (Ue) => fe.quantity = Ue, controls: false, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, max: 999999999, min: 1, precision: l(T).measure.precision, step: 5, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(pe, { label: "总长度 (m)", align: "center", "min-width": "120", prop: "totalLength" }), s(pe, { key: "weighingTotalWeight", label: `总重 (${l(T).weight.unit})`, align: "center", "min-width": "135", prop: "weighingTotalWeight" }, { default: p(({ row: fe }) => {
      var Ue, Je;
      return [s(re, { content: fe.purchaseSN ? `${fe.weighingTotalWeight > fe.maxCanPurchaseMete && ((Ue = l(y)) != null && Ue.applyAndProcureMeteDiffState) ? "申购最大采购重量：" + fe.maxCanPurchaseMete + l(T).weight.unit : ""}` : `理论重量：${fe.theoryTotalWeight} ${l(T).weight.unit}， ${l(_)}`, disabled: !fe.hasOver && !fe.purchaseSN || fe.purchaseSN && fe.weighingTotalWeight <= fe.maxCanPurchaseMete || !((Je = l(y)) != null && Je.applyAndProcureMeteDiffState) || !fe.weighingTotalWeight, class: "item", effect: "dark", placement: "top" }, { default: p(() => {
        var Xe;
        return [s(Ke, { modelValue: fe.weighingTotalWeight, "onUpdate:modelValue": (Ye) => fe.weighingTotalWeight = Ye, class: Zt({ "over-weight-tip": fe.purchaseSN ? (fe.weighingTotalWeight > fe.maxCanPurchaseMete || n.value.findIndex((Ye) => Ye.applyPurchaseDetailId === fe.applyPurchaseDetailId) > -1) && ((Xe = l(y)) == null ? void 0 : Xe.applyAndProcureMeteDiffState) : fe.hasOver }), controls: false, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, max: 999999999, min: 0, precision: l(T).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "disabled", "precision"])];
      }), _: 2 }, 1032, ["content", "disabled"])];
    }), _: 1 }, 8, ["label"]), s(pe, { label: "已采购数量/核算量", align: "center", "min-width": "130", prop: "productQuantity" }, { default: p(({ row: fe }) => [Te(K(fe.productQuantity || "-") + " / " + K(fe.productMete || "-"), 1)]), _: 1 }), s(es, { form: l(r), onSetTablePrice: he }, null, 8, ["form"]), s(pe, { align: "center", label: "品牌", prop: "brand" }, { default: p(({ row: fe }) => [s(Me, { modelValue: fe.brand, "onUpdate:modelValue": (Ue) => fe.brand = Ue, modelModifiers: { trim: true }, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), s(pe, { align: "center", fixed: "right", label: "计量方式", prop: "weightMeasurementMode", width: "140px" }, { default: p(({ row: fe, $index: Ue }) => [s(Ne, { modelValue: fe.weightMeasurementMode, "onUpdate:modelValue": (Je) => fe.weightMeasurementMode = Je, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, options: l(Wt).ENUM, unshowOptions: V.value, "show-extra": Ue !== 0, type: "enum", placeholder: "计量方式", style: { width: "100%" }, size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "options", "unshowOptions", "show-extra"])]), _: 1 }), l(r).orderPlace === l(Bt).FACTORY.V ? (w(), U(pe, { key: 1, align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, { default: p(({ row: fe, $index: Ue }) => [s(l(ca), { modelValue: fe.projectId, "onUpdate:modelValue": (Je) => fe.projectId = Je, branchCompanyId: l(r).branchCompanyId, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, projectAttribute: l(r).projectAttribute, "show-extra": Ue !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (Je) => z(fe) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "projectAttribute", "show-extra", "onChange"])]), _: 1 })) : H("", true), l(r).orderPlace === l(Bt).FACTORY.V ? (w(), U(pe, { key: 2, align: "center", label: "仓库", prop: "workshopId", width: "140px" }, { default: p(({ row: fe, $index: Ue }) => [s(Ul, { modelValue: fe.workshopId, "onUpdate:modelValue": (Je) => fe.workshopId = Je, disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, "show-extra": Ue !== 0, placeholder: "请选择仓库" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "show-extra"])]), _: 1 })) : H("", true), s(pe, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: fe, $index: Ue }) => [s(He, { disabled: fe.boolOriginalDetail ? !!fe.boolUsed : false, icon: "el-icon-delete", size: "default", type: "danger", onClick: (Je) => Se(fe.sn, Ue, fe) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]), s(Oe, { ref_key: "drawerRef", ref: N, modelValue: l(O), "onUpdate:modelValue": de[1] || (de[1] = (fe) => Gt(O) ? O.value = fe : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "型材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: v, modelValue: l(L), "onUpdate:modelValue": de[0] || (de[0] = (fe) => Gt(L) ? L.value = fe : null), classifyId: l(P).classifyId, "max-height": l(R), "show-classify": false, visible: l(O), "expand-query": "", mode: "selector", onChange: l(I) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} }, NZ = Object.freeze(Object.defineProperty({ __proto__: null, default: CR }, Symbol.toStringTag, { value: "Module" }));
function Qa() {
  const e = Z(), o = Z(), n = Z([]), c = Z({}), u = Z(false), { maxHeight: r } = Kt({ mainBox: ".material-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => o.value.loaded);
  Ce(u, (b) => {
    b && pt(() => {
      e.value.initSelected([c.value.sn]);
    });
  });
  function E(b) {
    c.value = b, n.value = [b], u.value = true;
  }
  function y(b) {
    const V = b[0];
    c.value.sn = V.sn, c.value.specificationLabels = V.specificationLabels, c.value.serialNumber = V.serialNumber, c.value.classifyId = V.classify.id, c.value.classifyFullName = V.classify.fullName, c.value.classifyName = V.classify.name, c.value.classifyParentFullName = V.classify.parentFullName, c.value.basicClass = V.classify.basicClass, c.value.specification = V.spec, c.value.model = V.spec, c.value.specificationMap = V.specKV, c.value.measureUnit = V.classify.measureUnit, c.value.accountingUnit = V.classify.accountingUnit, c.value.measurePrecision = V.classify.measurePrecision, c.value.accountingPrecision = V.classify.accountingPrecision, c.value.unitWeight = V.unitWeight;
  }
  return { specSelectMaxHeight: r, specRef: e, drawerRef: o, editRow: c, editList: n, materialSelectVisible: u, handleClickEditSpec: E, handleSpecChange: y };
}
const PR = { __name: "steel-coil-table", setup(e, { expose: o }) {
  var F;
  const n = Z([]), c = Ge.STEEL_COIL.V, u = ft("cu"), r = ft("purchaseCfg"), E = Z([]);
  function y(G) {
    return G.boolOriginalDetail ? !G.boolUsed : true;
  }
  function b(G) {
    E.value = G;
  }
  function V() {
    var G;
    (G = E.value) == null || G.forEach((ie) => {
      var ne;
      const ue = (ne = m.steelCoilList) == null ? void 0 : ne.findIndex((te) => te.uid === ie.uid);
      ue > -1 && me(ie.sn, ue, ie);
    });
  }
  function M({ row: G, rowIndex: ie }) {
    var ue, ne, te;
    if ((ne = (ue = u == null ? void 0 : u.submitResult) == null ? void 0 : ue.data) != null && ne.includes(G.classifyId) && ((te = u == null ? void 0 : u.submitResult) == null ? void 0 : te.code) === 40206) return { backgroundColor: "#ffdede" };
  }
  const g = (G, ie) => A(ie.weighingTotalWeight) && A(ie.unitPrice) ? +Be(ie.weighingTotalWeight * ie.unitPrice, Ze.YUAN) == +G : false, S = (G, ie) => A(G) ? G > 0 : true, _ = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ validator: S, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { validator: S, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: (G, ie) => {
    var ue;
    return G ? A(ie.purchaseSN) && ((ue = r.value) != null && ue.applyAndProcureMeteDiffState) ? ie.maxCanPurchaseMete ? G <= ie.maxCanPurchaseMete : false : true : false;
  }, message: "重量必须大于0且不大于剩余申购量", trigger: "blur" }], length: [{ validator: (G, ie) => A(G) || m.orderPlace === Bt.CONSTRUCTION_SITE.V ? G >= 0 : true, message: "长度必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: g, message: "金额有误，请手动修改", trigger: "blur" }] }, f = ft("matSpecRef"), m = (F = ft("cu")) == null ? void 0 : F.form, { baseUnit: R } = ai(c), { handleUnitPriceChange: v, handleMeteChangeCalcPrice: N } = Al("weighingTotalWeight"), P = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1]]), { tableValidate: L, wrongCellMask: O, cleanUpData: x } = ui({ rules: _, errorMsg: "请修正【钢卷清单】中标红的信息", ditto: P }), { specSelectMaxHeight: I, specRef: Y, drawerRef: ee, editRow: B, editList: q, materialSelectVisible: ae, handleClickEditSpec: j, handleSpecChange: le } = Qa(), oe = ft("steelDensityCfg");
  function ye(G) {
    m.steelCoilList.forEach((ie) => {
      (!ie.boolOriginalDetail || ie.boolOriginalDetail && !ie.boolUsed) && (ie.unitPrice = G, v(ie.unitPrice, ie));
    });
  }
  function ce(G) {
    const ie = Ct({ uid: Tt(), sn: G.sn, specificationLabels: G.specificationLabels, serialNumber: G.serialNumber, classifyId: G.classify.id, classifyFullName: G.classify.fullName, classifySerialNumber: G.classify.serialNumber, classifyName: G.classify.name, classifyParentFullName: G.classify.parentFullName, basicClass: G.classify.basicClass, specification: G.spec, model: G.spec, specificationMap: G.specKV, measureUnit: G.classify.measureUnit, accountingUnit: G.classify.accountingUnit, accountingPrecision: G.classify.accountingPrecision, measurePrecision: G.classify.measurePrecision, quantity: void 0, color: void 0, brand: void 0, thickness: void 0, length: void 0, width: void 0, theoryLength: void 0, weighingTotalWeight: void 0, projectId: m.steelCoilList.length > 0 ? -1 : void 0, workshopId: m.steelCoilList.length > 0 ? -1 : void 0, steelDensity: A(G.steelDensity) ? G.steelDensity : oe.value[G.classify.id] });
    return se(ie), m.originSteelCoilList.push(ie), ie;
  }
  function se(G) {
    Dt(() => {
      k(G);
    }), Ce([() => G.weighingTotalWeight, () => G.width, () => G.thickness, R], () => he(G)), Ce([() => G.weighingTotalWeight], () => N(G)), Ce([() => G.theoryLength], () => be(G)), Ce([() => G.specification, () => G.unitPrice, () => G.brand, () => G.projectId, () => G.workshopId], () => {
      A(G.originDetailObj) && (G.originChange = true);
    }), G.isFirst = false;
  }
  async function he(G) {
    G.theoryLength = await il({ classifyId: G.classifyId, name: G.classifyFullName, weight: G.weighingTotalWeight, width: G.width, thickness: G.thickness }), console.log(G.theoryLength);
  }
  function be(G) {
    A(G.theoryLength) ? G.length = G.theoryLength * 1 : G.isFirst || (G.length = void 0);
  }
  function me(G, ie, ue) {
    var te, de, pe, re;
    const ne = m.originSteelCoilList.findIndex((we) => we.uid === ue.uid);
    if (m.originSteelCoilList.splice(ne, 1), A(ue.originDetailObj) && m.delDetailIds.push(ue.id), ue.purchaseSN) {
      m.steelCoilList.splice(ie, 1);
      const we = ["list", "originList"];
      for (let Ke = 0; Ke < we.length; Ke++) if (A(m[we[Ke]])) {
        const Me = m[we[Ke]].findIndex((Ne) => Ne.id === ue.id);
        Me > -1 && m[we[Ke]].splice(Me, 1);
      }
    } else {
      if ((de = (te = u == null ? void 0 : u.submitResult) == null ? void 0 : te.data) != null && de.includes(ue.classifyId)) {
        const we = (pe = u == null ? void 0 : u.submitResult) == null ? void 0 : pe.data.findIndex((Me) => Me === ue.classifyId);
        m.steelCoilList.filter((Me) => Me.classifyId === ue.classifyId).length === 1 && ((re = u == null ? void 0 : u.submitResult) == null || re.data.splice(we, 1));
      }
      f.value ? f.value.delListItem(G, ie) : m.steelCoilList.splice(ie, 1);
    }
  }
  function ge() {
    const G = m.steelCoilList.filter((ue) => true);
    if (Ae(G)) return true;
    if (Ie()) {
      const { validResult: ue } = L(G);
      return ue && Le(G), ue;
    } else return false;
  }
  function Le(G) {
    x(G), G.forEach((ie, ue) => {
      m.steelCoilList[ue].projectId = ie.projectId, m.steelCoilList[ue].quantity = ie.length, m.steelCoilList[ue].workshopId = ie.workshopId;
    });
  }
  function Ie() {
    var ue, ne;
    const G = {}, ie = {};
    if (n.value = [], m.steelCoilList.forEach((te) => {
      te.applyPurchaseDetailId && (Ae(G[te.applyPurchaseDetailId]) && (G[te.applyPurchaseDetailId] = { applyPurchaseDetailId: te.applyPurchaseDetailId, maxCanPurchaseMete: te.maxCanPurchaseMete, classifyId: te.classifyId, classifyName: te.classifyName, accountingUnit: te.accountingUnit, basicClass: te.basicClass }), Ae(ie[te.applyPurchaseDetailId]) ? ie[te.applyPurchaseDetailId] = { applyPurchaseDetailId: te.applyPurchaseDetailId, maxCanPurchaseMete: te.maxCanPurchaseMete, mete: te.weighingTotalWeight || 0, classifyId: te.classifyId, classifyName: te.classifyName, accountingUnit: te.accountingUnit, basicClass: te.basicClass } : ie[te.applyPurchaseDetailId].mete += te.weighingTotalWeight || 0);
    }), (ue = r.value) != null && ue.applyAndProcureMeteDiffState) for (const te in G) ie[te].mete > G[te].maxCanPurchaseMete && n.value.push({ applyPurchaseDetailId: G[te].applyPurchaseDetailId, maxCanPurchaseMete: G[te].maxCanPurchaseMete, classifyId: G[te].classifyId, classifyName: G[te].classifyName, msg: Ge.VL[G[te].basicClass] + "-" + G[te].classifyName + " 超过最大采购量【" + G[te].maxCanPurchaseMete + G[te].accountingUnit + "】" });
    if ((ne = n.value) != null && ne.length) {
      const te = n.value.map((de) => `<div>${de.msg}<div>`).join("");
      ot({ message: "<div>请注意标红处!<div>" + te, dangerouslyUseHTMLString: true, type: "error", duration: 5e3 });
    }
    return !(n.value.length > 0);
  }
  const { projectAllType: Se } = Wa();
  function X(G) {
    const ie = Se.value.find((ue) => ue.id === G.projectId);
    G.project = ie;
  }
  const { workshopNameV2: $ } = Io();
  function k(G) {
    const ie = $.value.find((ue) => ue.id === G.workshopId);
    G.workshop = ie;
  }
  function J() {
    if (Ae(m.steelCoilList)) return true;
    const G = m.steelCoilList.filter((ue) => true);
    return Ie() ? (Le(G), true) : false;
  }
  function z(G) {
    return Hi(G, { props: ["amount", "weighingTotalWeight", "quantity"], toThousandFields: ["amount", "weighingTotalWeight", "quantity"] });
  }
  return o({ rowInit: ce, rowWatch: se, validate: ge, TSValidate: J, deleteTableData: V }), (G, ie) => {
    const ue = vt, ne = jt, te = ya, de = Ve("common-input-number"), pe = Mt, re = Ve("common-button"), we = Ve("common-table"), Ke = Ve("common-drawer"), Me = _t("empty-text");
    return w(), Q(Qe, null, [s(we, ii({ "cell-class-name": l(O), data: l(m).steelCoilList, "row-style": M, "show-empty-symbol": false, stripe: false, "summary-method": z, "return-source-data": "", "row-key": "uid", "show-summary": "" }, G.$attrs, { onSelectionChange: b }), { default: p(() => [s(ue, { selectable: y, align: "center", fixed: "left", type: "selection", width: "40" }), s(ue, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(ue, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }), s(ue, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: p(({ row: Ne }) => [s(ne, { content: Ne.classifyParentFullName, disabled: !Ne.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[Me, Ne.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(ue, { align: "center", fixed: "left", label: "规格", "min-width": "130", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: Ne }) => [!Ne.boolOriginalDetail || !Ne.boolUsed ? (w(), U(te, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (He) => l(j)(Ne) }, null, 8, ["onClick"])) : H("", true), s(ne, { content: Ne.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(Ne.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(ue, { key: "weighingTotalWeight", label: `总重 (${l(R).weight.unit})`, align: "center", "min-width": "135", prop: "weighingTotalWeight" }, { default: p(({ row: Ne }) => {
      var He, ze;
      return [s(ne, { content: Ne.purchaseSN ? `${Ne.weighingTotalWeight > Ne.maxCanPurchaseMete && ((He = l(r)) != null && He.applyAndProcureMeteDiffState) ? "申购最大采购重量：" + Ne.maxCanPurchaseMete + l(R).weight.unit : ""}` : "", disabled: Ne.purchaseSN && Ne.weighingTotalWeight <= Ne.maxCanPurchaseMete || !((ze = l(r)) != null && ze.applyAndProcureMeteDiffState) || !Ne.weighingTotalWeight, class: "item", effect: "dark", placement: "top" }, { default: p(() => {
        var Oe;
        return [s(de, { modelValue: Ne.weighingTotalWeight, "onUpdate:modelValue": (Re) => Ne.weighingTotalWeight = Re, class: Zt({ "over-weight-tip": Ne.purchaseSN ? (Ne.weighingTotalWeight > Ne.maxCanPurchaseMete || n.value.findIndex((Re) => Re.applyPurchaseDetailId === Ne.applyPurchaseDetailId) > -1) && ((Oe = l(r)) == null ? void 0 : Oe.applyAndProcureMeteDiffState) : false }), controls: false, disabled: !!Ne.boolUsed, max: 999999999, min: 0, precision: l(R).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "disabled", "precision"])];
      }), _: 2 }, 1032, ["content", "disabled"])];
    }), _: 1 }, 8, ["label"]), s(ue, { label: "已采购量", align: "center", width: "120", prop: "productMete" }), s(ue, { label: `厚 (${l(R).thickness.unit})`, align: "center", "min-width": "120", prop: "thickness" }, { default: p(({ row: Ne }) => [s(de, { modelValue: Ne.thickness, "onUpdate:modelValue": (He) => Ne.thickness = He, controls: false, disabled: Ne.boolOriginalDetail ? !!Ne.boolUsed : false, max: 99999999, min: 0, precision: l(R).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(ue, { label: `宽 (${l(R).width.unit})`, align: "center", "min-width": "120", prop: "width" }, { default: p(({ row: Ne }) => [s(de, { modelValue: Ne.width, "onUpdate:modelValue": (He) => Ne.width = He, controls: false, disabled: Ne.boolOriginalDetail ? !!Ne.boolUsed : false, max: 99999999, min: 0, precision: l(R).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(ue, { label: "长 (m)", align: "center", "min-width": "120", prop: "length" }, { default: p(({ row: Ne }) => [s(de, { modelValue: Ne.length, "onUpdate:modelValue": (He) => Ne.length = He, controls: false, disabled: Ne.boolOriginalDetail ? !!Ne.boolUsed : false, max: 999999999, min: 0, precision: Ne.measurePrecision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }), s(es, { form: l(m), onSetTablePrice: ye }, null, 8, ["form"]), s(ue, { align: "center", label: "颜色", prop: "color" }, { default: p(({ row: Ne }) => [s(pe, { modelValue: Ne.color, "onUpdate:modelValue": (He) => Ne.color = He, modelModifiers: { trim: true }, disabled: Ne.boolOriginalDetail ? !!Ne.boolUsed : false, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), s(ue, { align: "center", label: "品牌", prop: "brand" }, { default: p(({ row: Ne }) => [s(pe, { modelValue: Ne.brand, "onUpdate:modelValue": (He) => Ne.brand = He, modelModifiers: { trim: true }, disabled: Ne.boolOriginalDetail ? !!Ne.boolUsed : false, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), l(m).orderPlace === l(Bt).FACTORY.V ? (w(), U(ue, { key: 0, align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, { default: p(({ row: Ne, $index: He }) => [s(l(ca), { modelValue: Ne.projectId, "onUpdate:modelValue": (ze) => Ne.projectId = ze, branchCompanyId: l(m).branchCompanyId, disabled: Ne.boolOriginalDetail ? !!Ne.boolUsed : false, projectAttribute: l(m).projectAttribute, "show-extra": He !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (ze) => X(Ne) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "projectAttribute", "show-extra", "onChange"])]), _: 1 })) : H("", true), l(m).orderPlace === l(Bt).FACTORY.V ? (w(), U(ue, { key: 1, align: "center", label: "仓库", prop: "workshopId", width: "140px" }, { default: p(({ row: Ne, $index: He }) => [s(Ul, { modelValue: Ne.workshopId, "onUpdate:modelValue": (ze) => Ne.workshopId = ze, disabled: Ne.boolOriginalDetail ? !!Ne.boolUsed : false, "show-extra": He !== 0, placeholder: "请选择仓库" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "show-extra"])]), _: 1 })) : H("", true), s(ue, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: Ne, $index: He }) => [s(re, { disabled: Ne.boolOriginalDetail ? !!Ne.boolUsed : false, icon: "el-icon-delete", size: "default", type: "danger", onClick: (ze) => me(Ne.sn, He, Ne) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]), s(Ke, { ref_key: "drawerRef", ref: ee, modelValue: l(ae), "onUpdate:modelValue": ie[1] || (ie[1] = (Ne) => Gt(ae) ? ae.value = Ne : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢卷选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: Y, modelValue: l(q), "onUpdate:modelValue": ie[0] || (ie[0] = (Ne) => Gt(q) ? q.value = Ne : null), classifyId: l(B).classifyId, "max-height": l(I), "show-classify": false, visible: l(ae), "expand-query": "", mode: "selector", onChange: l(le) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} }, LZ = Object.freeze(Object.defineProperty({ __proto__: null, default: PR }, Symbol.toStringTag, { value: "Module" }));
const IZ = { key: 1 }, CZ = { __name: "other-steel-material-table", setup(e, { expose: o }) {
  var $;
  const n = Z([]), c = ft("matSpecRef"), u = ($ = ft("cu")) == null ? void 0 : $.form, r = ft("cu"), E = ft("purchaseCfg"), y = Z([]);
  function b(k) {
    return k.boolOriginalDetail ? !k.boolUsed : true;
  }
  function V(k) {
    y.value = k;
  }
  function M() {
    var k;
    (k = y.value) == null || k.forEach((J) => {
      var F;
      const z = (F = u.otherSteelMaterialList) == null ? void 0 : F.findIndex((G) => G.uid === J.uid);
      z > -1 && ye(J.sn, z, J);
    });
  }
  const g = Pe.OTHER_STEEL_MATERIALS.V;
  function S({ row: k, rowIndex: J }) {
    var z, F, G;
    if ((F = (z = r == null ? void 0 : r.submitResult) == null ? void 0 : z.data) != null && F.includes(k.classifyId) && ((G = r == null ? void 0 : r.submitResult) == null ? void 0 : G.code) === 40206) return { backgroundColor: "#ffdede" };
  }
  const f = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (k, J) => A(k) ? k >= 0 : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (k, J) => {
    var z;
    return k ? A(J.purchaseSN) && ((z = E.value) != null && z.applyAndProcureMeteDiffState) ? J.maxCanPurchaseMete ? Be(k, J.accountingPrecision) <= Be(J.maxCanPurchaseMete, J.accountingPrecision) : false : true : false;
  }, message: "核算量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (k, J) => A(J.mete) && A(J.unitPrice) ? +Be(J.mete * J.unitPrice, Ze.YUAN) == +k : false, message: "金额有误，请手动修改", trigger: "blur" }] }, { handleUnitPriceChange: m, handleMeteChangeCalcPrice: R } = Al("mete"), v = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1]]), { tableValidate: N, wrongCellMask: P, cleanUpData: L } = ui({ rules: f, ditto: v }), { specSelectMaxHeight: O, specRef: x, drawerRef: I, editRow: Y, editList: ee, materialSelectVisible: B, handleClickEditSpec: q, handleSpecChange: ae } = Qa();
  function j(k) {
    u.otherSteelMaterialList.forEach((J) => {
      (!J.boolOriginalDetail || J.boolOriginalDetail && !J.boolUsed) && (J.unitPrice = k, m(J.unitPrice, J));
    });
  }
  function le(k) {
    const J = Ct({ uid: Tt(), sn: k.sn, specificationLabels: k.specificationLabels, serialNumber: k.serialNumber, classifySerialNumber: k.classify.serialNumber, classifyId: k.classify.id, classifyFullPathId: k.classify.fullPathId, classifyFullName: k.classify.fullName, classifyName: k.classify.name, classifyParentFullName: k.classify.parentFullName, basicClass: k.classify.basicClass, specification: k.spec, model: k.model, specificationMap: k.specKV, measureUnit: k.classify.measureUnit, accountingUnit: k.classify.accountingUnit, accountingPrecision: k.classify.accountingPrecision, measurePrecision: k.classify.measurePrecision, outboundUnitType: k.classify.outboundUnitType, unitNet: k.unitNet, accountingUnitNet: k.accountingUnitNet, mete: void 0, quantity: void 0, projectId: u.otherSteelMaterialList.length > 0 ? -1 : void 0, workshopId: u.otherSteelMaterialList.length > 0 ? -1 : void 0 });
    return oe(J), u.originOtherSteelMaterialList.push(J), J;
  }
  function oe(k) {
    Dt(() => {
      Se(k);
    }), Ce([() => k.mete], () => {
      R(k);
    }, { immediate: true }), Ce([() => k.specification, () => k.unitPrice, () => k.mete, () => k.brand, () => k.projectId, () => k.workshopId], () => {
      A(k.originDetailObj) && (k.originChange = true);
    });
  }
  function ye(k, J, z) {
    var G, ie, ue, ne;
    const F = u.originOtherSteelMaterialList.findIndex((te) => te.uid === z.uid);
    if (u.originOtherSteelMaterialList.splice(F, 1), A(z.originDetailObj) && u.delDetailIds.push(z.id), z.purchaseSN) {
      u.otherSteelMaterialList.splice(J, 1);
      const te = ["list", "originList"];
      for (let de = 0; de < te.length; de++) if (A(u[te[de]])) {
        const pe = u[te[de]].findIndex((re) => re.id === z.id);
        pe > -1 && u[te[de]].splice(pe, 1);
      }
    } else {
      if ((ie = (G = r == null ? void 0 : r.submitResult) == null ? void 0 : G.data) != null && ie.includes(z.classifyId)) {
        const te = (ue = r == null ? void 0 : r.submitResult) == null ? void 0 : ue.data.findIndex((pe) => pe === z.classifyId);
        u.otherSteelMaterialList.filter((pe) => pe.classifyId === z.classifyId).length === 1 && ((ne = r == null ? void 0 : r.submitResult) == null || ne.data.splice(te, 1));
      }
      c.value ? c.value.delListItem(k, J) : u.otherSteelMaterialList.splice(J, 1);
    }
  }
  function ce(k) {
    k.purchaseSN && (k.mete = Be(k.quantity * k.unitNet, k.accountingPrecision));
  }
  function se(k) {
    k.purchaseSN && (k.quantity = Be(k.mete * k.accountingUnitNet, k.measurePrecision));
  }
  function he() {
    const k = u.otherSteelMaterialList.filter((z) => true);
    if (Ae(k)) return true;
    if (me()) {
      const { validResult: z } = N(k);
      return z && be(k), z;
    } else return false;
  }
  function be(k) {
    L(k), k.forEach((J, z) => {
      u.otherSteelMaterialList[z].projectId = J.projectId, u.otherSteelMaterialList[z].workshopId = J.workshopId, u.otherSteelMaterialList[z].quantity = J.measureUnit && A(J.measurePrecision) ? J.quantity : void 0;
    });
  }
  function me() {
    var z, F;
    const k = {}, J = {};
    if (n.value = [], u.otherSteelMaterialList.forEach((G) => {
      G.applyPurchaseDetailId && (Ae(k[G.applyPurchaseDetailId]) && (k[G.applyPurchaseDetailId] = { applyPurchaseDetailId: G.applyPurchaseDetailId, maxCanPurchaseMete: G.maxCanPurchaseMete, classifyId: G.classifyId, classifyName: G.classifyName, accountingUnit: G.accountingUnit, basicClass: G.basicClass }), Ae(J[G.applyPurchaseDetailId]) ? J[G.applyPurchaseDetailId] = { applyPurchaseDetailId: G.applyPurchaseDetailId, maxCanPurchaseMete: G.maxCanPurchaseMete, mete: G.mete || 0, classifyId: G.classifyId, classifyName: G.classifyName, accountingUnit: G.accountingUnit, basicClass: G.basicClass } : J[G.applyPurchaseDetailId].mete += G.mete || 0);
    }), (z = E.value) != null && z.applyAndProcureMeteDiffState) for (const G in k) J[G].mete > k[G].maxCanPurchaseMete && n.value.push({ applyPurchaseDetailId: k[G].applyPurchaseDetailId, maxCanPurchaseMete: k[G].maxCanPurchaseMete, classifyId: k[G].classifyId, classifyName: k[G].classifyName, msg: Pe.VL[k[G].basicClass] + "-" + k[G].classifyName + " 超过最大采购量【" + k[G].maxCanPurchaseMete + k[G].accountingUnit + "】" });
    if ((F = n.value) != null && F.length) {
      const G = n.value.map((ie) => `<div>${ie.msg}<div>`).join("");
      ot({ message: "<div>请注意标红处!<div>" + G, dangerouslyUseHTMLString: true, type: "error", duration: 5e3 });
    }
    return !(n.value.length > 0);
  }
  const { projectAllType: ge } = Wa();
  function Le(k) {
    const J = ge.value.find((z) => z.id === k.projectId);
    k.project = J;
  }
  const { workshopNameV2: Ie } = Io();
  function Se(k) {
    const J = Ie.value.find((z) => z.id === k.workshopId);
    k.workshop = J;
  }
  function X() {
    if (Ae(u.otherSteelMaterialList)) return true;
    const k = u.otherSteelMaterialList.filter((z) => true);
    return me() ? (be(k), true) : false;
  }
  return o({ rowInit: le, validate: he, rowWatch: oe, TSValidate: X, deleteTableData: M }), (k, J) => {
    const z = vt, F = jt, G = ya, ie = Ve("common-input-number"), ue = Mt, ne = Ve("common-button"), te = Ve("common-table"), de = Ve("common-drawer"), pe = _t("empty-text");
    return w(), Q(Qe, null, [s(te, ii({ "cell-class-name": l(P), data: l(u).otherSteelMaterialList, "row-style": S, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, k.$attrs, { onSelectionChange: V }), { default: p(() => [s(z, { selectable: b, align: "center", fixed: "left", type: "selection", width: "40" }), s(z, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), l(u).useRequisitions ? (w(), U(z, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : H("", true), s(z, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), s(z, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: p(({ row: re }) => [s(F, { content: re.classifyParentFullName, disabled: !re.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[pe, re.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(z, { align: "center", fixed: "left", label: "规格", "min-width": "130", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: re }) => [!re.boolOriginalDetail || !re.boolUsed ? (w(), U(G, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (we) => l(q)(re) }, null, 8, ["onClick"])) : H("", true), s(F, { content: re.specificationLabels, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[pe, re.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), s(z, { align: "center", label: "计量单位", prop: "measureUnit" }, { default: p(({ row: re }) => [qe((w(), Q("span", null, [Te(K(re.measureUnit), 1)])), [[pe]])]), _: 1 }), s(z, { align: "center", label: "数量", prop: "quantity" }, { default: p(({ row: re }) => {
      var we;
      return [re.measureUnit && l(A)(re.measurePrecision) && (!re.purchaseSN || re.purchaseSN && ((we = l(E)) == null ? void 0 : we.quantity) & l(g) && re.outboundUnitType === l(hi).MEASURE.V) ? (w(), U(ie, { key: 0, modelValue: re.quantity, "onUpdate:modelValue": (Ke) => re.quantity = Ke, controls: false, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, max: 999999999, min: 0, precision: re.measurePrecision, step: 1, placeholder: "数量", size: "default", onChange: (Ke) => ce(re) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision", "onChange"])) : qe((w(), Q("span", IZ, [Te(K(re.quantity || "-"), 1)])), [[pe]])];
    }), _: 1 }), s(z, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: p(({ row: re }) => [qe((w(), Q("span", null, [Te(K(re.accountingUnit), 1)])), [[pe]])]), _: 1 }), s(z, { align: "center", label: "核算量", prop: "mete" }, { default: p(({ row: re }) => {
      var we, Ke, Me, Ne;
      return [!re.purchaseSN || re.purchaseSN && ((we = l(E)) == null ? void 0 : we.mete) & l(g) && re.outboundUnitType === l(hi).ACCOUNTING.V ? (w(), U(F, { key: 0, content: re.purchaseSN ? `${re.mete > re.maxCanPurchaseMete && ((Ke = l(E)) != null && Ke.applyAndProcureMeteDiffState) ? "申购最大采购重量：" + re.maxCanPurchaseMete + re.accountingUnit : ""}` : "", disabled: re.purchaseSN && re.mete <= re.maxCanPurchaseMete || !((Me = l(E)) != null && Me.applyAndProcureMeteDiffState) || !re.mete, class: "item", effect: "dark", placement: "top" }, { default: p(() => {
        var He;
        return [s(ie, { modelValue: re.mete, "onUpdate:modelValue": (ze) => re.mete = ze, class: Zt({ "over-weight-tip": re.purchaseSN ? (re.mete > re.maxCanPurchaseMete || n.value.findIndex((ze) => ze.applyPurchaseDetailId === re.applyPurchaseDetailId) > -1) && ((He = l(E)) == null ? void 0 : He.applyAndProcureMeteDiffState) : false }), controls: false, disabled: !!re.boolUsed, max: 999999999, min: 1e-6, precision: re.accountingPrecision, step: 1, placeholder: "核算量", size: "default", onChange: (ze) => se(re) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "disabled", "precision", "onChange"])];
      }), _: 2 }, 1032, ["content", "disabled"])) : (w(), Q("span", { key: 1, class: Zt({ "text-red": re.purchaseSN ? (re.mete > re.maxCanPurchaseMete || n.value.findIndex((He) => He.applyPurchaseDetailId === re.applyPurchaseDetailId) > -1) && ((Ne = l(E)) == null ? void 0 : Ne.applyAndProcureMeteDiffState) : false }) }, K(re.mete || "-"), 3))];
    }), _: 1 }), s(z, { label: "已采购数量/核算量", align: "center", "min-width": "130", prop: "productQuantity" }, { default: p(({ row: re }) => [Te(K(re.productQuantity || "-") + " / " + K(re.productMete || "-"), 1)]), _: 1 }), s(es, { form: l(u), "weight-attribute": "mete", onSetTablePrice: j }, null, 8, ["form"]), s(z, { align: "center", label: "颜色", prop: "color" }, { default: p(({ row: re }) => [s(ue, { modelValue: re.color, "onUpdate:modelValue": (we) => re.color = we, modelModifiers: { trim: true }, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), s(z, { align: "center", label: "品牌", prop: "brand" }, { default: p(({ row: re }) => [s(ue, { modelValue: re.brand, "onUpdate:modelValue": (we) => re.brand = we, modelModifiers: { trim: true }, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), l(u).orderPlace === l(Bt).FACTORY.V ? (w(), U(z, { key: 1, align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, { default: p(({ row: re, $index: we }) => [s(l(ca), { modelValue: re.projectId, "onUpdate:modelValue": (Ke) => re.projectId = Ke, branchCompanyId: l(u).branchCompanyId, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, projectAttribute: l(u).projectAttribute, "show-extra": we !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (Ke) => Le(re) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "projectAttribute", "show-extra", "onChange"])]), _: 1 })) : H("", true), l(u).orderPlace === l(Bt).FACTORY.V ? (w(), U(z, { key: 2, align: "center", label: "仓库", prop: "workshopId", width: "140px" }, { default: p(({ row: re, $index: we }) => [s(Ul, { modelValue: re.workshopId, "onUpdate:modelValue": (Ke) => re.workshopId = Ke, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, "show-extra": we !== 0, placeholder: "请选择仓库" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "show-extra"])]), _: 1 })) : H("", true), s(z, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: re, $index: we }) => [s(ne, { disabled: re.boolOriginalDetail ? !!re.boolUsed : false, icon: "el-icon-delete", size: "default", type: "danger", onClick: (Ke) => ye(re.sn, we, re) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]), s(de, { ref_key: "drawerRef", ref: I, modelValue: l(B), "onUpdate:modelValue": J[1] || (J[1] = (re) => Gt(B) ? B.value = re : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "其它钢材选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: x, modelValue: l(ee), "onUpdate:modelValue": J[0] || (J[0] = (re) => Gt(ee) ? ee.value = re : null), classifyId: l(Y).classifyId, "max-height": l(O), "show-classify": false, visible: l(B), "expand-query": "", mode: "selector", onChange: l(ae) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} }, OR = ut(CZ, [["__scopeId", "data-v-e543c594"]]), PZ = Object.freeze(Object.defineProperty({ __proto__: null, default: OR }, Symbol.toStringTag, { value: "Module" })), kR = { __name: "index", setup(e, { expose: o }) {
  var _;
  const n = (_ = ft("cu")) == null ? void 0 : _.form, c = ft("matSpecRef"), u = Z();
  Dt(() => {
    let f = 0, m = 0;
    ["steelPlateList", "sectionSteelList", "steelCoilList", "otherSteelMaterialList"].forEach((v) => {
      A(n[v]) && n[v].forEach((N) => {
        f += (v === "otherSteelMaterialList" ? N.mete : N.weighingTotalWeight) || 0, m += Number(N.amount) || 0;
      });
    }), n.amount = Be(m, Ze.YUAN), n.mete = f.toFixed(ei.weight.precision), n.meteUnit = "t";
  });
  const r = Ct({ steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null }), E = (f) => {
    const m = { steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null }, R = { steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null };
    ["steelPlateList", "sectionSteelList", "steelCoilList", "otherSteelMaterialList"].forEach((N) => {
      A(f[N]) && (f[N] = f[N].map((P) => Ct(P)), m[N] = Ce(r, (P) => {
        P[N] && (R[N] = Ce(c, () => {
          f[N].forEach((L) => {
            var O;
            return (O = P[N]) == null ? void 0 : O.rowWatch(L);
          }), c.value && (c.value.initSelected(f[N].map((L) => ({ sn: L.sn, classifyId: L.classifyId }))), pt(() => {
            R[N]();
          }));
        }, { immediate: true }), pt(() => {
          m[N]();
        }));
      }, { immediate: true, deep: true }));
    });
  };
  Ce(() => n.currentBasicClass, (f) => {
    f && pt(() => {
      var R;
      let m = "";
      switch (f) {
        case oa.STEEL_PLATE.V:
          m = "steelPlateList";
          break;
        case oa.SECTION_STEEL.V:
          m = "sectionSteelList";
          break;
        case oa.STEEL_COIL.V:
          m = "steelCoilList";
          break;
        default:
          m = "otherSteelMaterialList";
          break;
      }
      r[m] || (r[m] = u.value), (R = n[m]) == null || R.forEach((v) => {
        var N;
        return (N = Z[m]) == null ? void 0 : N.rowWatch(v);
      });
    });
  }, { immediate: true });
  const y = Ee(() => {
    switch (n.currentBasicClass) {
      case oa.STEEL_PLATE.V:
        return IR;
      case oa.SECTION_STEEL.V:
        return CR;
      case oa.STEEL_COIL.V:
        return PR;
      default:
        return OR;
    }
  });
  function b(f) {
    var m;
    return (m = u.value) == null ? void 0 : m.rowInit(f);
  }
  function V() {
    n.list = [...n.steelPlateList, ...n.sectionSteelList, ...n.steelCoilList, ...n.otherSteelMaterialList], n.list.forEach((f) => {
      f.basicClass !== oa.OTHER_STEEL_MATERIALS.V && (f.mete = f.weighingTotalWeight, f.weight = f.weighingTotalWeight);
    });
  }
  function M() {
    var P;
    if (Ae(n.steelPlateList) && Ae(n.sectionSteelList) && Ae(n.steelCoilList) && Ae(n.otherSteelMaterialList)) return ot.warning("请填写数据"), false;
    const f = ["steelPlateList", "sectionSteelList", "steelCoilList", "otherSteelMaterialList"], m = ["钢材列表", "型材列表", "钢卷列表", "其它钢材列表"];
    let R = 0, v = true;
    for (let L = 0; L < f.length; L++) (P = n[f[L]]) == null || P.forEach((O) => {
      const x = f[L] === "otherSteelMaterialList" ? "mete" : "weighingTotalWeight";
      if (!O[x] || Ae(O.unitPrice) || Ae(O.amount)) return v = false, R = L, false;
    });
    if (!v) return ot.error(`${m[R]}重量单价必填`), false;
    const N = g();
    return N && V(), N;
  }
  function g() {
    return Object.keys(r).every((f) => r[f] ? r[f].validate() : true);
  }
  function S() {
    return Object.keys(r).every((f) => r[f] ? r[f].TSValidate() : true);
  }
  function h(f) {
    var m;
    (m = u.value) == null || m.rowWatch(f);
  }
  function T() {
    var f;
    (f = u.value) == null || f.deleteTableData();
  }
  return o({ rowInit: b, validate: M, rowWatch: h, setFormCallback: E, getData: V, TSValidateTable: S, deleteTableData: T }), (f, m) => (w(), U(Ri(y.value), ii({ ref_key: "steelRef", ref: u }, f.$attrs), null, 16));
} }, OZ = Object.freeze(Object.defineProperty({ __proto__: null, default: kR }, Symbol.toStringTag, { value: "Module" }));
const kZ = { key: 1 }, DZ = { __name: "auxiliary-material", setup(e, { expose: o }) {
  var $;
  const n = Z([]), c = ft("matSpecRef"), u = ($ = ft("cu")) == null ? void 0 : $.form, r = Ge.MATERIAL.V, E = ft("purchaseCfg"), y = ft("cu"), b = Z([]);
  function V(k) {
    return k.boolOriginalDetail ? !k.boolUsed : true;
  }
  function M(k) {
    b.value = k;
  }
  function g() {
    var k;
    (k = b.value) == null || k.forEach((J) => {
      var F;
      const z = (F = u.auxiliaryMaterialList) == null ? void 0 : F.findIndex((G) => G.uid === J.uid);
      z > -1 && ye(J.sn, z, J);
    });
  }
  function S({ row: k, rowIndex: J }) {
    var z, F;
    if ((F = (z = y == null ? void 0 : y.submitResult) == null ? void 0 : z.data) != null && F.includes(k.classifyId)) return { backgroundColor: "#ffdede" };
  }
  const f = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (k, J) => A(k) ? k >= 0 : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (k, J) => {
    var z;
    return k ? A(J.purchaseSN) && ((z = E.value) != null && z.applyAndProcureMeteDiffState) ? J.maxCanPurchaseMete ? Be(k, J.accountingPrecision) <= Be(J.maxCanPurchaseMete, J.accountingPrecision) : false : true : false;
  }, message: "核算量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (k, J) => A(J.mete) && A(J.unitPrice) ? +Be(J.mete * J.unitPrice, Ze.YUAN) == +k : false, message: "金额有误，请手动修改", trigger: "blur" }] }, { handleUnitPriceChange: m, handleMeteChangeCalcPrice: R } = Al("mete"), v = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1]]), { tableValidate: N, wrongCellMask: P, cleanUpData: L } = ui({ rules: f, ditto: v }), { specSelectMaxHeight: O, specRef: x, drawerRef: I, editRow: Y, editList: ee, materialSelectVisible: B, handleClickEditSpec: q, handleSpecChange: ae } = Qa();
  function j(k) {
    u.auxiliaryMaterialList.forEach((J) => {
      (!J.boolOriginalDetail || J.boolOriginalDetail && !J.boolUsed) && (J.unitPrice = k, m(J.unitPrice, J));
    });
  }
  function le(k) {
    const J = Ct({ uid: Tt(), sn: k.sn, specificationLabels: k.specificationLabels, serialNumber: k.serialNumber, classifyId: k.classify.id, classifyFullPathId: k.classify.fullPathId, classifyFullName: k.classify.fullName, classifyName: k.classify.name, classifyParentFullName: k.classify.parentFullName, classifySerialNumber: k.classify.serialNumber, basicClass: k.classify.basicClass, specification: k.spec, model: k.spec, specificationMap: k.specKV, measureUnit: k.classify.measureUnit, accountingUnit: k.classify.accountingUnit, accountingPrecision: k.classify.accountingPrecision, measurePrecision: k.classify.measurePrecision, outboundUnitType: k.classify.outboundUnitType, unitNet: k.unitNet, accountingUnitNet: k.accountingUnitNet, mete: void 0, quantity: void 0, projectId: u.auxiliaryMaterialList.length > 0 ? -1 : void 0, workshopId: u.auxiliaryMaterialList.length > 0 ? -1 : void 0 });
    return oe(J), u.originAuxMatList.push(J), J;
  }
  function oe(k) {
    Dt(() => {
      Se(k);
    }), Ce([() => k.mete], () => R(k), { immediate: true }), Ce([() => k.specification, () => k.unitPrice, () => k.mete, () => k.brand, () => k.projectId, () => k.workshopId], () => {
      A(k.originDetailObj) && (k.originChange = true);
    });
  }
  function ye(k, J, z) {
    var G, ie, ue, ne;
    const F = u.originAuxMatList.findIndex((te) => te.uid === z.uid);
    if (u.originAuxMatList.splice(F, 1), A(z.originDetailObj) && u.delDetailIds.push(z.id), z.purchaseSN) {
      u.auxiliaryMaterialList.splice(J, 1);
      const te = ["list", "originList"];
      for (let de = 0; de < te.length; de++) if (A(u[te[de]])) {
        const pe = u[te[de]].findIndex((re) => re.id === z.id);
        pe > -1 && u[te[de]].splice(pe, 1);
      }
    } else {
      if ((ie = (G = y == null ? void 0 : y.submitResult) == null ? void 0 : G.data) != null && ie.includes(z.classifyId)) {
        const te = (ue = y == null ? void 0 : y.submitResult) == null ? void 0 : ue.data.findIndex((pe) => pe === z.classifyId);
        u.auxiliaryMaterialList.filter((pe) => pe.classifyId === z.classifyId).length === 1 && ((ne = y == null ? void 0 : y.submitResult) == null || ne.data.splice(te, 1));
      }
      c.value ? c.value.delListItem(k, J) : u.auxiliaryMaterialList.splice(J, 1);
    }
  }
  function ce(k) {
    k.purchaseSN && (k.mete = Be(k.quantity * k.unitNet, k.accountingPrecision));
  }
  function se(k) {
    k.purchaseSN && (k.quantity = Be(k.mete * k.accountingUnitNet, k.measurePrecision));
  }
  function he() {
    const k = u.auxiliaryMaterialList.filter((z) => true);
    if (Ae(k)) return true;
    if (me()) {
      const { validResult: z } = N(k);
      return z && be(k), z;
    } else return false;
  }
  function be(k) {
    L(k), k.forEach((J, z) => {
      u.auxiliaryMaterialList[z].projectId = J.projectId, u.auxiliaryMaterialList[z].workshopId = J.workshopId, u.auxiliaryMaterialList[z].quantity = J.measureUnit && A(J.measurePrecision) ? J.quantity : void 0;
    });
  }
  function me() {
    var z;
    const k = {}, J = {};
    if (n.value = [], u.auxiliaryMaterialList.forEach((F) => {
      F.applyPurchaseDetailId && (Ae(k[F.applyPurchaseDetailId]) && (k[F.applyPurchaseDetailId] = { applyPurchaseDetailId: F.applyPurchaseDetailId, maxCanPurchaseMete: F.maxCanPurchaseMete, classifyId: F.classifyId, classifyName: F.classifyName, accountingUnit: F.accountingUnit, basicClass: F.basicClass }), Ae(J[F.applyPurchaseDetailId]) ? J[F.applyPurchaseDetailId] = { applyPurchaseDetailId: F.applyPurchaseDetailId, maxCanPurchaseMete: F.maxCanPurchaseMete, mete: F.mete || 0, classifyId: F.classifyId, classifyName: F.classifyName, accountingUnit: F.accountingUnit, basicClass: F.basicClass } : J[F.applyPurchaseDetailId].mete += F.mete || 0);
    }), (z = E.value) != null && z.applyAndProcureMeteDiffState) for (const F in k) J[F].mete > k[F].maxCanPurchaseMete && n.value.push({ applyPurchaseDetailId: k[F].applyPurchaseDetailId, maxCanPurchaseMete: k[F].maxCanPurchaseMete, classifyId: k[F].classifyId, classifyName: k[F].classifyName, msg: Ge.VL[k[F].basicClass] + "-" + k[F].classifyName + " 超过最大采购量【" + k[F].maxCanPurchaseMete + k[F].accountingUnit + "】" });
    if (n.value.length) {
      const F = n.value.map((G) => `<div>${G.msg}<div>`).join("");
      ot({ message: "<div>请注意标红处!<div>" + F, dangerouslyUseHTMLString: true, type: "error", duration: 5e3 });
    }
    return !(n.value.length > 0);
  }
  const { projectAllType: ge } = Wa();
  function Le(k) {
    const J = ge.value.find((z) => z.id === k.projectId);
    k.project = J;
  }
  const { workshopNameV2: Ie } = Io();
  function Se(k) {
    const J = Ie.value.find((z) => z.id === k.workshopId);
    k.workshop = J;
  }
  function X() {
    if (Ae(u.auxiliaryMaterialList)) return true;
    const k = u.auxiliaryMaterialList.filter((z) => true);
    return me() ? (be(k), true) : false;
  }
  return o({ rowInit: le, validate: he, rowWatch: oe, TSValidate: X, deleteTableData: g }), (k, J) => {
    const z = vt, F = jt, G = ya, ie = Ve("common-input-number"), ue = Mt, ne = Ve("common-button"), te = Ve("common-table"), de = Ve("common-drawer"), pe = _t("empty-text");
    return w(), Q(Qe, null, [s(te, ii({ "cell-class-name": l(P), data: l(u).auxiliaryMaterialList, "row-style": S, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, k.$attrs, { onSelectionChange: M }), { default: p(() => [s(z, { selectable: V, align: "center", fixed: "left", type: "selection", width: "40" }), s(z, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), l(u).useRequisitions ? (w(), U(z, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : H("", true), s(z, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), s(z, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: p(({ row: re }) => [s(F, { content: re.classifyParentFullName, disabled: !re.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[pe, re.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(z, { align: "center", fixed: "left", label: "规格", "min-width": "130", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: re }) => [!re.boolOriginalDetail || !re.boolUsed ? (w(), U(G, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (we) => l(q)(re) }, null, 8, ["onClick"])) : H("", true), s(F, { content: re.specificationLabels, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[pe, re.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), s(z, { align: "center", label: "计量单位", prop: "measureUnit" }, { default: p(({ row: re }) => [qe((w(), Q("span", null, [Te(K(re.measureUnit), 1)])), [[pe]])]), _: 1 }), s(z, { align: "center", label: "数量", prop: "quantity" }, { default: p(({ row: re }) => {
      var we;
      return [re.measureUnit && l(A)(re.measurePrecision) && (!re.purchaseSN || re.purchaseSN && ((we = l(E)) == null ? void 0 : we.quantity) & l(r) && re.outboundUnitType === l(hi).MEASURE.V) ? (w(), U(ie, { key: 0, modelValue: re.quantity, "onUpdate:modelValue": (Ke) => re.quantity = Ke, controls: false, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, max: 999999999, min: 0, precision: re.measurePrecision, step: 1, placeholder: "数量", size: "default", onChange: (Ke) => ce(re) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision", "onChange"])) : qe((w(), Q("span", kZ, [Te(K(re.quantity || "-"), 1)])), [[pe]])];
    }), _: 1 }), s(z, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: p(({ row: re }) => [qe((w(), Q("span", null, [Te(K(re.accountingUnit), 1)])), [[pe]])]), _: 1 }), s(z, { align: "center", label: "核算量", prop: "mete" }, { default: p(({ row: re }) => {
      var we, Ke, Me, Ne;
      return [!re.purchaseSN || re.purchaseSN && ((we = l(E)) == null ? void 0 : we.mete) & l(r) && re.outboundUnitType === l(hi).ACCOUNTING.V ? (w(), U(F, { key: 0, content: re.purchaseSN ? `${re.mete > re.maxCanPurchaseMete && ((Ke = l(E)) != null && Ke.applyAndProcureMeteDiffState) ? "申购最大采购重量：" + re.maxCanPurchaseMete + re.accountingUnit : ""}` : "", disabled: re.purchaseSN && re.mete <= re.maxCanPurchaseMete || !((Me = l(E)) != null && Me.applyAndProcureMeteDiffState) || !re.mete, class: "item", effect: "dark", placement: "top" }, { default: p(() => {
        var He;
        return [s(ie, { modelValue: re.mete, "onUpdate:modelValue": (ze) => re.mete = ze, class: Zt({ "over-weight-tip": re.purchaseSN ? (re.mete > re.maxCanPurchaseMete || n.value.findIndex((ze) => ze.applyPurchaseDetailId === re.applyPurchaseDetailId) > -1) && ((He = l(E)) == null ? void 0 : He.applyAndProcureMeteDiffState) : false }), controls: false, disabled: !!re.boolUsed, max: 999999999, min: 1e-6, precision: re.accountingPrecision, step: 1, placeholder: "核算量", size: "default", onChange: (ze) => se(re) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "disabled", "precision", "onChange"])];
      }), _: 2 }, 1032, ["content", "disabled"])) : (w(), Q("span", { key: 1, class: Zt({ "text-red": re.purchaseSN ? (re.mete > re.maxCanPurchaseMete || n.value.findIndex((He) => He.applyPurchaseDetailId === re.applyPurchaseDetailId) > -1) && ((Ne = l(E)) == null ? void 0 : Ne.applyAndProcureMeteDiffState) : false }) }, K(re.mete || "-"), 3))];
    }), _: 1 }), s(z, { label: "已采购数量/核算量", align: "center", "min-width": "130", prop: "productQuantity" }, { default: p(({ row: re }) => [Te(K(re.productQuantity || "-") + " / " + K(re.productMete || "-"), 1)]), _: 1 }), s(es, { form: l(u), "weight-attribute": "mete", onSetTablePrice: j }, null, 8, ["form"]), s(z, { align: "center", label: "颜色", prop: "color" }, { default: p(({ row: re }) => [s(ue, { modelValue: re.color, "onUpdate:modelValue": (we) => re.color = we, modelModifiers: { trim: true }, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), s(z, { align: "center", label: "品牌", prop: "brand" }, { default: p(({ row: re }) => [s(ue, { modelValue: re.brand, "onUpdate:modelValue": (we) => re.brand = we, modelModifiers: { trim: true }, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), l(u).orderPlace === l(Bt).FACTORY.V ? (w(), U(z, { key: 1, align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, { default: p(({ row: re, $index: we }) => [s(l(ca), { modelValue: re.projectId, "onUpdate:modelValue": (Ke) => re.projectId = Ke, branchCompanyId: l(u).branchCompanyId, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, projectAttribute: l(u).projectAttribute, "show-extra": we !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (Ke) => Le(re) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "projectAttribute", "show-extra", "onChange"])]), _: 1 })) : H("", true), l(u).orderPlace === l(Bt).FACTORY.V ? (w(), U(z, { key: 2, align: "center", label: "仓库", prop: "workshopId", width: "140px" }, { default: p(({ row: re, $index: we }) => [s(Ul, { modelValue: re.workshopId, "onUpdate:modelValue": (Ke) => re.workshopId = Ke, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, "show-extra": we !== 0, placeholder: "请选择仓库" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "show-extra"])]), _: 1 })) : H("", true), s(z, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: re, $index: we }) => [s(ne, { disabled: re.boolOriginalDetail ? !!re.boolUsed : false, icon: "el-icon-delete", size: "default", type: "danger", onClick: (Ke) => ye(re.sn, we, re) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]), s(de, { ref_key: "drawerRef", ref: I, modelValue: l(B), "onUpdate:modelValue": J[1] || (J[1] = (re) => Gt(B) ? B.value = re : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢卷选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: x, modelValue: l(ee), "onUpdate:modelValue": J[0] || (J[0] = (re) => Gt(ee) ? ee.value = re : null), classifyId: l(Y).classifyId, "max-height": l(O), "show-classify": false, visible: l(B), "expand-query": "", mode: "selector", onChange: l(ae) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} }, DR = ut(DZ, [["__scopeId", "data-v-3da20538"]]), xZ = Object.freeze(Object.defineProperty({ __proto__: null, default: DR }, Symbol.toStringTag, { value: "Module" }));
const UZ = { key: 1 }, YZ = { __name: "gas", setup(e, { expose: o }) {
  var $;
  const n = Z([]), c = ft("matSpecRef"), u = ($ = ft("cu")) == null ? void 0 : $.form, r = Ge.GAS.V, E = ft("purchaseCfg"), y = ft("cu"), b = Z([]);
  function V(k) {
    return k.boolOriginalDetail ? !k.boolUsed : true;
  }
  function M(k) {
    b.value = k;
  }
  function g() {
    var k;
    (k = b.value) == null || k.forEach((J) => {
      var F;
      const z = (F = u.gasList) == null ? void 0 : F.findIndex((G) => G.uid === J.uid);
      z > -1 && ye(J.sn, z, J);
    });
  }
  function S({ row: k, rowIndex: J }) {
    var z, F;
    if ((F = (z = y == null ? void 0 : y.submitResult) == null ? void 0 : z.data) != null && F.includes(k.classifyId)) return { backgroundColor: "#ffdede" };
  }
  const f = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (k, J) => A(k) ? k >= 0 : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (k, J) => {
    var z;
    return k ? A(J.purchaseSN) && ((z = E.value) != null && z.applyAndProcureMeteDiffState) ? J.maxCanPurchaseMete ? Be(k, J.accountingPrecision) <= Be(J.maxCanPurchaseMete, J.accountingPrecision) : false : true : false;
  }, message: "核算量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (k, J) => A(J.mete) && A(J.unitPrice) ? +Be(J.mete * J.unitPrice, Ze.YUAN) == +k : false, message: "金额有误，请手动修改", trigger: "blur" }] }, { handleUnitPriceChange: m, handleMeteChangeCalcPrice: R } = Al("mete"), v = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1]]), { tableValidate: N, wrongCellMask: P, cleanUpData: L } = ui({ rules: f, ditto: v }), { specSelectMaxHeight: O, specRef: x, drawerRef: I, editRow: Y, editList: ee, materialSelectVisible: B, handleClickEditSpec: q, handleSpecChange: ae } = Qa();
  function j(k) {
    u.gasList.forEach((J) => {
      (!J.boolOriginalDetail || J.boolOriginalDetail && !J.boolUsed) && (J.unitPrice = k, m(J.unitPrice, J));
    });
  }
  function le(k) {
    const J = Ct({ uid: Tt(), sn: k.sn, specificationLabels: k.specificationLabels, serialNumber: k.serialNumber, classifyId: k.classify.id, classifyFullPathId: k.classify.fullPathId, classifyFullName: k.classify.fullName, classifySerialNumber: k.classify.serialNumber, classifyName: k.classify.name, classifyParentFullName: k.classify.parentFullName, basicClass: k.classify.basicClass, specification: k.spec, model: k.spec, specificationMap: k.specKV, measureUnit: k.classify.measureUnit, accountingUnit: k.classify.accountingUnit, accountingPrecision: k.classify.accountingPrecision, measurePrecision: k.classify.measurePrecision, outboundUnitType: k.classify.outboundUnitType, unitNet: k.unitNet, accountingUnitNet: k.accountingUnitNet, mete: void 0, quantity: void 0, projectId: u.gasList.length > 0 ? -1 : void 0, workshopId: u.gasList.length > 0 ? -1 : void 0 });
    return oe(J), u.originGasList.push(J), J;
  }
  function oe(k) {
    Dt(() => {
      Se(k);
    }), Ce([() => k.mete], () => R(k), { immediate: true }), Ce([() => k.specification, () => k.unitPrice, () => k.mete, () => k.brand, () => k.projectId, () => k.workshopId], () => {
      A(k.originDetailObj) && (k.originChange = true);
    });
  }
  function ye(k, J, z) {
    var G, ie, ue, ne;
    const F = u.originGasList.findIndex((te) => te.uid === z.uid);
    if (u.originGasList.splice(F, 1), A(z.originDetailObj) && u.delDetailIds.push(z.id), z.purchaseSN) {
      u.gasList.splice(J, 1);
      const te = ["list", "originList"];
      for (let de = 0; de < te.length; de++) if (A(u[te[de]])) {
        const pe = u[te[de]].findIndex((re) => re.id === z.id);
        pe > -1 && u[te[de]].splice(pe, 1);
      }
    } else {
      if ((ie = (G = y == null ? void 0 : y.submitResult) == null ? void 0 : G.data) != null && ie.includes(z.classifyId)) {
        const te = (ue = y == null ? void 0 : y.submitResult) == null ? void 0 : ue.data.findIndex((pe) => pe === z.classifyId);
        u.gasList.filter((pe) => pe.classifyId === z.classifyId).length === 1 && ((ne = y == null ? void 0 : y.submitResult) == null || ne.data.splice(te, 1));
      }
      c.value ? c.value.delListItem(k, J) : u.gasList.splice(J, 1);
    }
  }
  function ce(k) {
    k.purchaseSN && (k.mete = Be(k.quantity * k.unitNet, k.accountingPrecision));
  }
  function se(k) {
    k.purchaseSN && (k.quantity = Be(k.mete * k.accountingUnitNet, k.measurePrecision));
  }
  function he() {
    const k = u.gasList.filter((z) => true);
    if (Ae(k)) return true;
    if (me()) {
      const { validResult: z } = N(k);
      return z && be(k), z;
    } else return false;
  }
  function be(k) {
    L(k), k.forEach((J, z) => {
      u.gasList[z].projectId = J.projectId, u.gasList[z].workshopId = J.workshopId, u.gasList[z].quantity = J.measureUnit && A(J.measurePrecision) ? J.quantity : void 0;
    });
  }
  function me() {
    var z, F;
    const k = {}, J = {};
    if (n.value = [], u.gasList.forEach((G) => {
      G.applyPurchaseDetailId && (Ae(k[G.applyPurchaseDetailId]) && (k[G.applyPurchaseDetailId] = { applyPurchaseDetailId: G.applyPurchaseDetailId, maxCanPurchaseMete: G.maxCanPurchaseMete, classifyId: G.classifyId, classifyName: G.classifyName, accountingUnit: G.accountingUnit, basicClass: G.basicClass }), Ae(J[G.applyPurchaseDetailId]) ? J[G.applyPurchaseDetailId] = { applyPurchaseDetailId: G.applyPurchaseDetailId, maxCanPurchaseMete: G.maxCanPurchaseMete, mete: G.mete || 0, classifyId: G.classifyId, classifyName: G.classifyName, accountingUnit: G.accountingUnit, basicClass: G.basicClass } : J[G.applyPurchaseDetailId].mete += G.mete || 0);
    }), (z = E.value) != null && z.applyAndProcureMeteDiffState) for (const G in k) J[G].mete > k[G].maxCanPurchaseMete && n.value.push({ applyPurchaseDetailId: k[G].applyPurchaseDetailId, maxCanPurchaseMete: k[G].maxCanPurchaseMete, classifyId: k[G].classifyId, classifyName: k[G].classifyName, msg: Ge.VL[k[G].basicClass] + "-" + k[G].classifyName + " 超过最大采购量【" + k[G].maxCanPurchaseMete + k[G].accountingUnit + "】" });
    if ((F = n.value) != null && F.length) {
      const G = n.value.map((ie) => `<div>${ie.msg}<div>`).join("");
      ot({ message: "<div>请注意标红处!<div>" + G, dangerouslyUseHTMLString: true, type: "error", duration: 5e3 });
    }
    return !(n.value.length > 0);
  }
  const { projectAllType: ge } = Wa();
  function Le(k) {
    const J = ge.value.find((z) => z.id === k.projectId);
    k.project = J;
  }
  const { workshopNameV2: Ie } = Io();
  function Se(k) {
    const J = Ie.value.find((z) => z.id === k.workshopId);
    k.workshop = J;
  }
  function X() {
    if (Ae(u.gasList)) return true;
    const k = u.gasList.filter((z) => true);
    return me() ? (be(k), true) : false;
  }
  return o({ rowInit: le, validate: he, rowWatch: oe, TSValidate: X, deleteTableData: g }), (k, J) => {
    const z = vt, F = jt, G = ya, ie = Ve("common-input-number"), ue = Mt, ne = Ve("common-button"), te = Ve("common-table"), de = Ve("common-drawer"), pe = _t("empty-text");
    return w(), Q(Qe, null, [s(te, ii({ "cell-class-name": l(P), data: l(u).gasList, "row-style": S, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, k.$attrs, { onSelectionChange: M }), { default: p(() => [s(z, { selectable: V, align: "center", fixed: "left", type: "selection", width: "40" }), s(z, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), l(u).useRequisitions ? (w(), U(z, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : H("", true), s(z, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), s(z, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: p(({ row: re }) => [s(F, { content: re.classifyParentFullName, disabled: !re.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[pe, re.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(z, { align: "center", fixed: "left", label: "规格", "min-width": "130", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: re }) => [!re.boolOriginalDetail || !re.boolUsed ? (w(), U(G, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (we) => l(q)(re) }, null, 8, ["onClick"])) : H("", true), s(F, { content: re.specificationLabels, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[pe, re.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), s(z, { align: "center", label: "计量单位", prop: "measureUnit" }, { default: p(({ row: re }) => [qe((w(), Q("span", null, [Te(K(re.measureUnit), 1)])), [[pe]])]), _: 1 }), s(z, { align: "center", label: "数量", prop: "quantity" }, { default: p(({ row: re }) => {
      var we;
      return [re.measureUnit && l(A)(re.measurePrecision) && (!re.purchaseSN || re.purchaseSN && ((we = l(E)) == null ? void 0 : we.quantity) & l(r) && re.outboundUnitType === l(hi).MEASURE.V) ? (w(), U(ie, { key: 0, modelValue: re.quantity, "onUpdate:modelValue": (Ke) => re.quantity = Ke, controls: false, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, max: 999999999, min: 0, precision: re.measurePrecision, step: 1, placeholder: "数量", size: "default", onChange: (Ke) => ce(re) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision", "onChange"])) : qe((w(), Q("span", UZ, [Te(K(re.quantity || "-"), 1)])), [[pe]])];
    }), _: 1 }), s(z, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: p(({ row: re }) => [qe((w(), Q("span", null, [Te(K(re.accountingUnit), 1)])), [[pe]])]), _: 1 }), s(z, { align: "center", label: "核算量", prop: "mete" }, { default: p(({ row: re }) => {
      var we, Ke, Me, Ne;
      return [!re.purchaseSN || re.purchaseSN && ((we = l(E)) == null ? void 0 : we.mete) & l(r) && re.outboundUnitType === l(hi).ACCOUNTING.V ? (w(), U(F, { key: 0, content: re.purchaseSN ? `${re.mete > re.maxCanPurchaseMete && ((Ke = l(E)) != null && Ke.applyAndProcureMeteDiffState) ? "申购最大采购重量：" + re.maxCanPurchaseMete + re.accountingUnit : ""}` : "", disabled: re.purchaseSN && re.mete <= re.maxCanPurchaseMete || !((Me = l(E)) != null && Me.applyAndProcureMeteDiffState) || !re.mete, class: "item", effect: "dark", placement: "top" }, { default: p(() => {
        var He;
        return [s(ie, { modelValue: re.mete, "onUpdate:modelValue": (ze) => re.mete = ze, class: Zt({ "over-weight-tip": re.purchaseSN ? (re.mete > re.maxCanPurchaseMete || n.value.findIndex((ze) => ze.applyPurchaseDetailId === re.applyPurchaseDetailId) > -1) && ((He = l(E)) == null ? void 0 : He.applyAndProcureMeteDiffState) : false }), controls: false, disabled: !!re.boolUsed, max: 999999999, min: 1e-6, precision: re.accountingPrecision, step: 1, placeholder: "核算量", size: "default", onChange: (ze) => se(re) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "disabled", "precision", "onChange"])];
      }), _: 2 }, 1032, ["content", "disabled"])) : (w(), Q("span", { key: 1, class: Zt({ "text-red": re.purchaseSN ? (re.mete > re.maxCanPurchaseMete || n.value.findIndex((He) => He.applyPurchaseDetailId === re.applyPurchaseDetailId) > -1) && ((Ne = l(E)) == null ? void 0 : Ne.applyAndProcureMeteDiffState) : false }) }, K(re.mete || "-"), 3))];
    }), _: 1 }), s(z, { label: "已采购数量/核算量", align: "center", "min-width": "130", prop: "productQuantity" }, { default: p(({ row: re }) => [Te(K(re.productQuantity || "-") + " / " + K(re.productMete || "-"), 1)]), _: 1 }), s(es, { form: l(u), "weight-attribute": "mete", onSetTablePrice: j }, null, 8, ["form"]), s(z, { align: "center", label: "颜色", prop: "color" }, { default: p(({ row: re }) => [s(ue, { modelValue: re.color, "onUpdate:modelValue": (we) => re.color = we, modelModifiers: { trim: true }, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), s(z, { align: "center", label: "品牌", prop: "brand" }, { default: p(({ row: re }) => [s(ue, { modelValue: re.brand, "onUpdate:modelValue": (we) => re.brand = we, modelModifiers: { trim: true }, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), l(u).orderPlace === l(Bt).FACTORY.V ? (w(), U(z, { key: 1, align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, { default: p(({ row: re, $index: we }) => [s(l(ca), { modelValue: re.projectId, "onUpdate:modelValue": (Ke) => re.projectId = Ke, branchCompanyId: l(u).branchCompanyId, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, projectAttribute: l(u).projectAttribute, "show-extra": we !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (Ke) => Le(re) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "projectAttribute", "show-extra", "onChange"])]), _: 1 })) : H("", true), l(u).orderPlace === l(Bt).FACTORY.V ? (w(), U(z, { key: 2, align: "center", label: "仓库", prop: "workshopId", width: "140px" }, { default: p(({ row: re, $index: we }) => [s(Ul, { modelValue: re.workshopId, "onUpdate:modelValue": (Ke) => re.workshopId = Ke, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, "show-extra": we !== 0, placeholder: "请选择仓库" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "show-extra"])]), _: 1 })) : H("", true), s(z, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: re, $index: we }) => [s(ne, { disabled: re.boolOriginalDetail ? !!re.boolUsed : false, icon: "el-icon-delete", size: "default", type: "danger", onClick: (Ke) => ye(re.sn, we, re) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]), s(de, { ref_key: "drawerRef", ref: I, modelValue: l(B), "onUpdate:modelValue": J[1] || (J[1] = (re) => Gt(B) ? B.value = re : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢卷选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: x, modelValue: l(ee), "onUpdate:modelValue": J[0] || (J[0] = (re) => Gt(ee) ? ee.value = re : null), classifyId: l(Y).classifyId, "max-height": l(O), "show-classify": false, visible: l(B), "expand-query": "", mode: "selector", onChange: l(ae) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} }, xR = ut(YZ, [["__scopeId", "data-v-9a5e8fd5"]]), KZ = Object.freeze(Object.defineProperty({ __proto__: null, default: xR }, Symbol.toStringTag, { value: "Module" }));
const WZ = { key: 1 }, jZ = { __name: "other", setup(e, { expose: o }) {
  var $;
  const n = Z([]), c = ft("matSpecRef"), u = ($ = ft("cu")) == null ? void 0 : $.form, r = Pe.OTHER.V, E = ft("purchaseCfg"), y = ft("cu"), b = Z([]);
  function V(k) {
    return k.boolOriginalDetail ? !k.boolUsed : true;
  }
  function M(k) {
    b.value = k;
  }
  function g() {
    var k;
    (k = b.value) == null || k.forEach((J) => {
      var F;
      const z = (F = u.otherList) == null ? void 0 : F.findIndex((G) => G.uid === J.uid);
      z > -1 && ye(J.sn, z, J);
    });
  }
  function S({ row: k, rowIndex: J }) {
    var z, F;
    if ((F = (z = y == null ? void 0 : y.submitResult) == null ? void 0 : z.data) != null && F.includes(k.classifyId)) return { backgroundColor: "#ffdede" };
  }
  const f = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (k, J) => A(k) ? k >= 0 : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (k, J) => {
    var z;
    return k ? A(J.purchaseSN) && ((z = E.value) != null && z.applyAndProcureMeteDiffState) ? J.maxCanPurchaseMete ? Be(k, J.accountingPrecision) <= Be(J.maxCanPurchaseMete, J.accountingPrecision) : false : true : false;
  }, message: "核算量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (k, J) => A(J.mete) && A(J.unitPrice) ? +Be(J.mete * J.unitPrice, Ze.YUAN) == +k : false, message: "金额有误，请手动修改", trigger: "blur" }] }, { handleUnitPriceChange: m, handleMeteChangeCalcPrice: R } = Al("mete"), v = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1]]), { tableValidate: N, wrongCellMask: P, cleanUpData: L } = ui({ rules: f, ditto: v }), { specSelectMaxHeight: O, specRef: x, drawerRef: I, editRow: Y, editList: ee, materialSelectVisible: B, handleClickEditSpec: q, handleSpecChange: ae } = Qa();
  function j(k) {
    u.otherList.forEach((J) => {
      (!J.boolOriginalDetail || J.boolOriginalDetail && !J.boolUsed) && (J.unitPrice = k, m(J.unitPrice, J));
    });
  }
  function le(k) {
    const J = Ct({ uid: Tt(), sn: k.sn, specificationLabels: k.specificationLabels, serialNumber: k.serialNumber, classifyId: k.classify.id, classifyFullPathId: k.classify.fullPathId, classifyFullName: k.classify.fullName, classifySerialNumber: k.classify.serialNumber, classifyName: k.classify.name, classifyParentFullName: k.classify.parentFullName, basicClass: k.classify.basicClass, specification: k.spec, model: k.spec, specificationMap: k.specKV, measureUnit: k.classify.measureUnit, accountingUnit: k.classify.accountingUnit, accountingPrecision: k.classify.accountingPrecision, measurePrecision: k.classify.measurePrecision, mete: void 0, quantity: void 0, projectId: u.otherList.length > 0 ? -1 : void 0, workshopId: u.otherList.length > 0 ? -1 : void 0 });
    return oe(J), u.originOtherList.push(J), J;
  }
  function oe(k) {
    Dt(() => {
      Se(k);
    }), Ce([() => k.mete], () => R(k), { immediate: true }), Ce([() => k.specification, () => k.unitPrice, () => k.mete, () => k.brand, () => k.projectId, () => k.workshopId], () => {
      A(k.originDetailObj) && (k.originChange = true);
    });
  }
  function ye(k, J, z) {
    var G, ie, ue, ne;
    const F = u.originOtherList.findIndex((te) => te.uid === z.uid);
    if (u.originOtherList.splice(F, 1), A(z.originDetailObj) && u.delDetailIds.push(z.id), z.purchaseSN) {
      u.otherList.splice(J, 1);
      const te = ["list", "originList"];
      for (let de = 0; de < te.length; de++) if (A(u[te[de]])) {
        const pe = u[te[de]].findIndex((re) => re.id === z.id);
        pe > -1 && u[te[de]].splice(pe, 1);
      }
    } else {
      if ((ie = (G = y == null ? void 0 : y.submitResult) == null ? void 0 : G.data) != null && ie.includes(z.classifyId)) {
        const te = (ue = y == null ? void 0 : y.submitResult) == null ? void 0 : ue.data.findIndex((pe) => pe === z.classifyId);
        u.otherList.filter((pe) => pe.classifyId === z.classifyId).length === 1 && ((ne = y == null ? void 0 : y.submitResult) == null || ne.data.splice(te, 1));
      }
      c.value ? c.value.delListItem(k, J) : u.otherList.splice(J, 1);
    }
  }
  function ce(k) {
    k.purchaseSN && (k.mete = Be(k.quantity * k.unitNet, k.measurePrecision));
  }
  function se(k) {
    k.purchaseSN && (k.quantity = Be(k.mete * k.accountingUnitNet, k.accountingPrecision));
  }
  function he() {
    const k = u.otherList.filter((z) => true);
    if (Ae(k)) return true;
    if (me()) {
      const { validResult: z } = N(k);
      return z && be(k), z;
    } else return false;
  }
  function be(k) {
    L(k), k.forEach((J, z) => {
      u.otherList[z].projectId = J.projectId, u.otherList[z].workshopId = J.workshopId, u.otherList[z].quantity = J.measureUnit && A(J.measurePrecision) ? J.quantity : void 0;
    });
  }
  function me() {
    var z, F;
    const k = {}, J = {};
    if (n.value = [], u.otherList.forEach((G) => {
      G.applyPurchaseDetailId && (Ae(k[G.applyPurchaseDetailId]) && (k[G.applyPurchaseDetailId] = { applyPurchaseDetailId: G.applyPurchaseDetailId, maxCanPurchaseMete: G.maxCanPurchaseMete, classifyId: G.classifyId, classifyName: G.classifyName, accountingUnit: G.accountingUnit, basicClass: G.basicClass }), Ae(J[G.applyPurchaseDetailId]) ? J[G.applyPurchaseDetailId] = { applyPurchaseDetailId: G.applyPurchaseDetailId, maxCanPurchaseMete: G.maxCanPurchaseMete, mete: G.mete || 0, classifyId: G.classifyId, classifyName: G.classifyName, accountingUnit: G.accountingUnit, basicClass: G.basicClass } : J[G.applyPurchaseDetailId].mete += G.mete || 0);
    }), (z = E.value) != null && z.applyAndProcureMeteDiffState) for (const G in k) J[G].mete > k[G].maxCanPurchaseMete && n.value.push({ applyPurchaseDetailId: k[G].applyPurchaseDetailId, maxCanPurchaseMete: k[G].maxCanPurchaseMete, classifyId: k[G].classifyId, classifyName: k[G].classifyName, msg: Pe.VL[k[G].basicClass] + "-" + k[G].classifyName + " 超过最大采购量【" + k[G].maxCanPurchaseMete + k[G].accountingUnit + "】" });
    if ((F = n.value) != null && F.length) {
      const G = n.value.map((ie) => `<div>${ie.msg}<div>`).join("");
      ot({ message: "<div>请注意标红处!<div>" + G, dangerouslyUseHTMLString: true, type: "error", duration: 5e3 });
    }
    return !(n.value.length > 0);
  }
  const { projectAllType: ge } = Wa();
  function Le(k) {
    const J = ge.value.find((z) => z.id === k.projectId);
    k.project = J;
  }
  const { workshopNameV2: Ie } = Io();
  function Se(k) {
    const J = Ie.value.find((z) => z.id === k.workshopId);
    k.workshop = J;
  }
  function X() {
    if (Ae(u.otherList)) return true;
    const k = u.otherList.filter((z) => true);
    return me() ? (be(k), true) : false;
  }
  return o({ rowInit: le, validate: he, rowWatch: oe, TSValidate: X, deleteTableData: g }), (k, J) => {
    const z = vt, F = jt, G = ya, ie = Ve("common-input-number"), ue = Mt, ne = Ve("common-button"), te = Ve("common-table"), de = Ve("common-drawer"), pe = _t("empty-text");
    return w(), Q(Qe, null, [s(te, ii({ "cell-class-name": l(P), data: l(u).otherList, "row-style": S, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, k.$attrs, { onSelectionChange: M }), { default: p(() => [s(z, { selectable: V, align: "center", fixed: "left", type: "selection", width: "40" }), s(z, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), l(u).useRequisitions ? (w(), U(z, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : H("", true), s(z, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), s(z, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: p(({ row: re }) => [s(F, { content: re.classifyParentFullName, disabled: !re.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[pe, re.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(z, { align: "center", fixed: "left", label: "规格", "min-width": "130", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: re }) => [!re.boolOriginalDetail || !re.boolUsed ? (w(), U(G, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (we) => l(q)(re) }, null, 8, ["onClick"])) : H("", true), s(F, { content: re.specificationLabels, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[pe, re.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), s(z, { align: "center", label: "计量单位", prop: "measureUnit" }, { default: p(({ row: re }) => [qe((w(), Q("span", null, [Te(K(re.measureUnit), 1)])), [[pe]])]), _: 1 }), s(z, { align: "center", label: "数量", prop: "quantity" }, { default: p(({ row: re }) => {
      var we;
      return [re.measureUnit && l(A)(re.measurePrecision) && (!re.purchaseSN || re.purchaseSN && ((we = l(E)) == null ? void 0 : we.quantity) & l(r) && re.outboundUnitType === l(hi).MEASURE.V) ? (w(), U(ie, { key: 0, modelValue: re.quantity, "onUpdate:modelValue": (Ke) => re.quantity = Ke, controls: false, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, max: 999999999, min: 0, precision: re.measurePrecision, step: 1, placeholder: "数量", size: "default", onChange: (Ke) => ce(re) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision", "onChange"])) : qe((w(), Q("span", WZ, [Te(K(re.quantity || "-"), 1)])), [[pe]])];
    }), _: 1 }), s(z, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: p(({ row: re }) => [qe((w(), Q("span", null, [Te(K(re.accountingUnit), 1)])), [[pe]])]), _: 1 }), s(z, { align: "center", label: "核算量", prop: "mete" }, { default: p(({ row: re }) => {
      var we, Ke, Me, Ne;
      return [!re.purchaseSN || re.purchaseSN && ((we = l(E)) == null ? void 0 : we.mete) & l(r) && re.outboundUnitType === l(hi).ACCOUNTING.V ? (w(), U(F, { key: 0, content: re.purchaseSN ? `${re.mete > re.maxCanPurchaseMete && ((Ke = l(E)) != null && Ke.applyAndProcureMeteDiffState) ? "申购最大采购重量：" + re.maxCanPurchaseMete + re.accountingUnit : ""}` : "", disabled: re.purchaseSN && re.mete <= re.maxCanPurchaseMete || !((Me = l(E)) != null && Me.applyAndProcureMeteDiffState) || !re.mete, class: "item", effect: "dark", placement: "top" }, { default: p(() => {
        var He;
        return [s(ie, { modelValue: re.mete, "onUpdate:modelValue": (ze) => re.mete = ze, class: Zt({ "over-weight-tip": re.purchaseSN ? (re.mete > re.maxCanPurchaseMete || n.value.findIndex((ze) => ze.applyPurchaseDetailId === re.applyPurchaseDetailId) > -1) && ((He = l(E)) == null ? void 0 : He.applyAndProcureMeteDiffState) : false }), controls: false, disabled: !!re.boolUsed, max: 999999999, min: 1e-6, precision: re.accountingPrecision, step: 1, placeholder: "核算量", size: "default", onChange: (ze) => se(re) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "disabled", "precision", "onChange"])];
      }), _: 2 }, 1032, ["content", "disabled"])) : (w(), Q("span", { key: 1, class: Zt({ "text-red": re.purchaseSN ? (re.mete > re.maxCanPurchaseMete || n.value.findIndex((He) => He.applyPurchaseDetailId === re.applyPurchaseDetailId) > -1) && ((Ne = l(E)) == null ? void 0 : Ne.applyAndProcureMeteDiffState) : false }) }, K(re.mete || "-"), 3))];
    }), _: 1 }), s(z, { label: "已采购数量/核算量", align: "center", "min-width": "130", prop: "productQuantity" }, { default: p(({ row: re }) => [Te(K(re.productQuantity || "-") + " / " + K(re.productMete || "-"), 1)]), _: 1 }), s(es, { form: l(u), "weight-attribute": "mete", onSetTablePrice: j }, null, 8, ["form"]), s(z, { align: "center", label: "品牌", prop: "brand" }, { default: p(({ row: re }) => [s(ue, { modelValue: re.brand, "onUpdate:modelValue": (we) => re.brand = we, modelModifiers: { trim: true }, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), l(u).orderPlace === l(Bt).FACTORY.V ? (w(), U(z, { key: 1, align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, { default: p(({ row: re, $index: we }) => [s(l(ca), { modelValue: re.projectId, "onUpdate:modelValue": (Ke) => re.projectId = Ke, branchCompanyId: l(u).branchCompanyId, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, projectAttribute: l(u).projectAttribute, "show-extra": we !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (Ke) => Le(re) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "projectAttribute", "show-extra", "onChange"])]), _: 1 })) : H("", true), l(u).orderPlace === l(Bt).FACTORY.V ? (w(), U(z, { key: 2, align: "center", label: "仓库", prop: "workshopId", width: "140px" }, { default: p(({ row: re, $index: we }) => [s(Ul, { modelValue: re.workshopId, "onUpdate:modelValue": (Ke) => re.workshopId = Ke, disabled: re.boolOriginalDetail ? !!re.boolUsed : false, "show-extra": we !== 0, placeholder: "请选择仓库" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "show-extra"])]), _: 1 })) : H("", true), s(z, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: re, $index: we }) => [s(ne, { disabled: re.boolOriginalDetail ? !!re.boolUsed : false, icon: "el-icon-delete", size: "default", type: "danger", onClick: (Ke) => ye(re.sn, we, re) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]), s(de, { ref_key: "drawerRef", ref: I, modelValue: l(B), "onUpdate:modelValue": J[1] || (J[1] = (re) => Gt(B) ? B.value = re : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢卷选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: x, modelValue: l(ee), "onUpdate:modelValue": J[0] || (J[0] = (re) => Gt(ee) ? ee.value = re : null), classifyId: l(Y).classifyId, "max-height": l(O), "show-classify": false, visible: l(B), "expand-query": "", mode: "selector", onChange: l(ae) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} }, UR = ut(jZ, [["__scopeId", "data-v-589c5de6"]]), FZ = Object.freeze(Object.defineProperty({ __proto__: null, default: UR }, Symbol.toStringTag, { value: "Module" })), YR = { __name: "index", setup(e, { expose: o }) {
  var _;
  const n = (_ = ft("cu")) == null ? void 0 : _.form, c = ft("matSpecRef"), u = Z();
  Dt(() => {
    let f = 0;
    ["auxiliaryMaterialList", "otherList", "gasList"].forEach((R) => {
      A(n[R]) && n[R].forEach((v) => {
        f += Number(v.amount) || 0;
      });
    }), n.amount = Be(f, Ze.YUAN), n.mete = void 0, n.meteUnit = "";
  });
  const r = Ct({ auxiliaryMaterialList: null, otherList: null, gasList: null }), E = (f) => {
    const m = { auxiliaryMaterialList: null, otherList: null, gasList: null }, R = { auxiliaryMaterialList: null, otherList: null, gasList: null };
    ["auxiliaryMaterialList", "otherList", "gasList"].forEach((N) => {
      A(f[N]) && (f[N] = f[N].map((P) => Ct(P)), m[N] = Ce(r, (P) => {
        P[N] && (R[N] = Ce(c, () => {
          f[N].forEach((L) => {
            var O;
            return (O = P[N]) == null ? void 0 : O.rowWatch(L);
          }), c.value && (c.value.initSelected(f[N].map((L) => ({ sn: L.sn, classifyId: L.classifyId }))), pt(() => {
            R[N]();
          }));
        }, { immediate: true }), pt(() => {
          m[N]();
        }));
      }, { immediate: true, deep: true }));
    });
  };
  Ce(() => n.currentBasicClass, (f) => {
    f && pt(() => {
      var R;
      let m = "";
      switch (f) {
        case Pe.MATERIAL.V:
          m = "auxiliaryMaterialList";
          break;
        case Pe.GAS.V:
          m = "gasList";
          break;
        case Pe.OTHER.V:
          m = "otherList";
          break;
      }
      r[m] || (r[m] = u.value), (R = n[m]) == null || R.forEach((v) => {
        var N;
        return (N = Z[m]) == null ? void 0 : N.rowWatch(v);
      });
    });
  }, { immediate: true });
  const y = Ee(() => {
    switch (n.currentBasicClass) {
      case Pe.MATERIAL.V:
        return DR;
      case Pe.GAS.V:
        return xR;
      case Pe.OTHER.V:
        return UR;
      default:
        return null;
    }
  });
  function b(f) {
    var m;
    return (m = u.value) == null ? void 0 : m.rowInit(f);
  }
  function V() {
    n.list = [...n.auxiliaryMaterialList, ...n.gasList, ...n.otherList], n.list.forEach((f) => {
    });
  }
  function M() {
    if (Ae(n.auxiliaryMaterialList) && Ae(n.gasList) && Ae(n.otherList)) return ot.warning("请填写数据"), false;
    const f = g();
    return f && V(), f;
  }
  function g() {
    return Object.keys(r).every((f) => r[f] ? r[f].validate() : true);
  }
  function S() {
    return Object.keys(r).every((f) => r[f] ? r[f].TSValidate() : true);
  }
  function h(f) {
    var m;
    (m = u.value) == null || m.rowWatch(f);
  }
  function T() {
    var f;
    (f = u.value) == null || f.deleteTableData();
  }
  return o({ rowInit: b, validate: M, rowWatch: h, setFormCallback: E, getData: V, TSValidateTable: S, deleteTableData: T }), (f, m) => (w(), U(Ri(y.value), ii({ ref_key: "steelRef", ref: u }, f.$attrs), null, 16));
} }, zZ = Object.freeze(Object.defineProperty({ __proto__: null, default: YR }, Symbol.toStringTag, { value: "Module" })), BZ = { class: "head-container" }, HZ = { key: 0 }, KR = { __name: "manuf-select-list", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, projectId: { type: Number, default: void 0 }, actualRequisitionIds: { type: Array, default: () => [] }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "addManufSuccess"], setup(e, { emit: o }) {
  var q;
  const n = o, c = e, { visible: u, handleClose: r } = Ta({ emit: n, props: c }), E = Z(), y = Z({}), b = Z([]), V = Z(false), M = Z([]), g = (q = ft("cu")) == null ? void 0 : q.form, S = Z([]), h = Z(false), T = Z(), _ = Z([]), f = Z({});
  Z([]);
  const m = Z([]), R = Ee(() => {
    const ae = [];
    return g.currentBasicClass === Pe.STRUC_MANUFACTURED.V ? g.structureList.forEach((j) => {
      ae.push(...j.listId);
    }) : g.enclosureList.forEach((j) => {
      ae.push(...j.listId);
    }), ae;
  }), v = [{ name: "压型彩板", no: Xi.PROFILED_PLATE.V, alias: "ENCLOSURE" }, { name: "压型楼承板", no: Xi.PRESSURE_BEARING_PLATE.V, alias: "ENCLOSURE" }, { name: "桁架楼承板", no: Xi.TRUSS_FLOOR_PLATE.V, alias: "ENCLOSURE" }, { name: "夹芯板", no: Xi.SANDWICH_BOARD.V, alias: "ENCLOSURE" }, { name: "折边件", no: Xi.BENDING.V, alias: "ENCLOSURE" }], { maxHeight: N } = Kt({ mainBox: ".manuf-select-list", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", extraHeight: "5vh", minHeight: 300, navbar: false, clientHRepMainH: true }, E);
  Ce(() => u.value, (ae) => {
    ae && (y.value = {}, x());
  }, { deep: true, immediate: true });
  function P(ae) {
    let j = true;
    return g.currentBasicClass === Pe.ENCL_MANUFACTURED.V && A(f.value) && ae.manufacturedType !== f.value.manufacturedType && (j = false), j && S.value.findIndex((le) => le.applyPurchaseDetailId === ae.applyPurchaseDetailId) < 0;
  }
  function L() {
    y.value.monomerId = void 0, y.value.areaId = void 0, y.value.manufacturedSn = void 0, y.value.specification = void 0, y.value.material = void 0, y.value.manufacturedType = void 0, y.value.manufacturedName = void 0, M.value = JSON.parse(JSON.stringify(_.value)), M.value.forEach((ae) => {
      var j;
      b.value.findIndex((le) => le.id === ae.id) > -1 && ((j = T.value) == null || j.toggleRowSelection(ae, true));
    });
  }
  function O() {
    const ae = [], j = ["monomerId", "areaId", "manufacturedSn", "specification", "material", "manufacturedType", "manufacturedName"];
    _.value.forEach((le) => {
      var ye;
      let oe = true;
      for (let ce = 0; ce < j.length; ce++) {
        const se = j[ce];
        if (y.value[se]) {
          if ((se === "monomerId" || se === "areaId") && g.currentBasicClass === Pe.STRUC_MANUFACTURED.V) {
            if (le[se] !== y.value[se]) {
              oe = false;
              break;
            }
          } else if (((ye = le[se]) == null ? void 0 : ye.indexOf(y.value[se])) < 0) {
            oe = false;
            break;
          }
        }
      }
      oe && ae.push(le);
    }), M.value = ae, M.value.forEach((le) => {
      var oe;
      b.value.findIndex((ye) => ye.id === le.id) > -1 && ((oe = T.value) == null || oe.toggleRowSelection(le, true));
    });
  }
  async function x() {
    if (S.value = [], M.value = [], b.value = [], !(!A(c.actualRequisitionIds) || !c.projectId)) try {
      V.value = true;
      const ae = await av({ ids: c.actualRequisitionIds });
      ae.forEach((le) => {
        var ye, ce, se, he;
        le.projectId = (ye = le.project) == null ? void 0 : ye.id, le.monomerId = (ce = le.monomer) == null ? void 0 : ce.id, le.areaId = (se = le.area) == null ? void 0 : se.id, le.applyPurchaseDetailId = le.id;
        const oe = ((he = g.detailQuantityAndMetes) == null ? void 0 : he.find((be) => be.id === le.applyPurchaseDetailId)) || {};
        le.canPurchaseQuantity = le.quantity - le.productQuantity + ((oe == null ? void 0 : oe.quantity) || 0);
      });
      const j = ae.filter((le) => le.projectId === c.projectId && le.canPurchaseQuantity > 0 && le.quantity && !R.value.includes(le.applyPurchaseDetailId)) || [];
      await Qt(j), await fo(j, { toNum: true }, { mete: ["mete"], quantity: ["quantity"] }), _.value = j.filter((le) => le.basicClass === g.currentBasicClass), console.log(_.value, "filter1111"), M.value = JSON.parse(JSON.stringify(_.value)), M.value.forEach((le) => {
        R.value.includes(le.applyPurchaseDetailId);
      });
    } catch (ae) {
      console.log(ae, "获取成品清单");
    } finally {
      V.value = false;
    }
  }
  function I(ae) {
    f.value = (ae == null ? void 0 : ae[0]) || {};
    const j = [];
    g.currentBasicClass === Pe.STRUC_MANUFACTURED.V ? ae.forEach((le) => {
      b.value.findIndex((oe) => oe.id === le.id) < 0 && b.value.push(le);
    }) : ae.forEach((le) => {
      var oe;
      !(le.manufacturedType || f.value.manufacturedType) || le.manufacturedType === f.value.manufacturedType ? b.value.findIndex((ye) => ye.id === le.id) < 0 && b.value.push(le) : (b.value.findIndex((ye) => ye.id === le.id) > -1 && b.value.splice(b.value.findIndex((ye) => ye.id === le.id), 1), (oe = T.value) == null || oe.toggleRowSelection(le, false));
    }), M.value.forEach((le) => {
      ae.findIndex((oe) => oe.id === le.id) < 0 && j.push(le);
    }), j.forEach((le) => {
      b.value.findIndex((oe) => oe.id === le.id) > -1 && b.value.splice(b.value.findIndex((oe) => oe.id === le.id), 1);
    });
  }
  function Y() {
    if (!b.value.length) {
      ot.warning("请至少选择一条数据");
      return;
    }
    S.value = [...b.value];
  }
  function ee(ae) {
    var le;
    const j = M.value.find((oe) => oe.id === ae.id);
    b.value.splice(b.value.findIndex((oe) => oe.id === ae.id), 1), (le = T.value) == null || le.toggleRowSelection(j, false);
  }
  function B(ae) {
    n("addManufSuccess", ae), r();
  }
  return (ae, j) => {
    const le = Ve("common-button"), oe = zn, ye = Ve("common-select"), ce = Mt, se = vt, he = Ve("common-table"), be = Ve("common-drawer"), me = oi;
    return w(), U(be, { ref_key: "manufSelectRef", ref: E, title: "制成品选择", "close-on-click-modal": false, modelValue: l(u), "onUpdate:modelValue": j[10] || (j[10] = (ge) => Gt(u) ? u.value = ge : null), "before-close": l(r), "custom-class": "manuf-select-list", direction: "rtl", size: "100%" }, { titleRight: p(() => [s(le, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-plus", onClick: Y }, { default: p(() => j[11] || (j[11] = [Te(" 添加 ")])), _: 1, __: [11] }), s(oe, { value: S.value.length, max: 99, hidden: S.value.length < 1 }, { default: p(() => [s(le, { class: "filter-item", size: "default", type: "success", onClick: j[0] || (j[0] = (ge) => h.value = true) }, { default: p(() => j[12] || (j[12] = [Te("汇总")])), _: 1, __: [12] })]), _: 1 }, 8, ["value", "hidden"])]), content: p(() => [C("div", BZ, [l(g).currentBasicClass === l(Pe).STRUC_MANUFACTURED.V ? (w(), U(l(md), { key: 0, areaId: y.value.areaId, "onUpdate:areaId": j[1] || (j[1] = (ge) => y.value.areaId = ge), monomerId: y.value.monomerId, "onUpdate:monomerId": j[2] || (j[2] = (ge) => y.value.monomerId = ge), "project-id": c.projectId, areaClearable: "", clearable: "", onChange: O }, null, 8, ["areaId", "monomerId", "project-id"])) : (w(), Q(Qe, { key: 1 }, [s(ye, { modelValue: y.value.manufacturedType, "onUpdate:modelValue": j[3] || (j[3] = (ge) => y.value.manufacturedType = ge), dataStructure: { key: "no", label: "name", value: "no" }, options: v, type: "other", class: "filter-item", placeholder: "围护类型", onChange: O }, null, 8, ["modelValue"]), s(ye, { modelValue: y.value.enclosurePlanId, "onUpdate:modelValue": j[4] || (j[4] = (ge) => y.value.enclosurePlanId = ge), dataStructure: { key: "id", label: "name", value: "id" }, options: m.value, class: "filter-item", clearable: "", placeholder: "围护计划", size: "default", style: { width: "200px" }, type: "other", onChange: O }, null, 8, ["modelValue", "options"])], 64)), s(ce, { modelValue: y.value.manufacturedName, "onUpdate:modelValue": j[5] || (j[5] = (ge) => y.value.manufacturedName = ge), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "输入名称搜索", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), s(ce, { modelValue: y.value.manufacturedSn, "onUpdate:modelValue": j[6] || (j[6] = (ge) => y.value.manufacturedSn = ge), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "输入编号搜索", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), s(ce, { modelValue: y.value.specification, "onUpdate:modelValue": j[7] || (j[7] = (ge) => y.value.specification = ge), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "输入规格搜索", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), s(ce, { modelValue: y.value.material, "onUpdate:modelValue": j[8] || (j[8] = (ge) => y.value.material = ge), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "输入材质搜索", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), s(le, { class: "filter-item", icon: "el-icon-search", size: "default", type: "success", onClick: Pi(O, ["stop"]) }, { default: p(() => j[13] || (j[13] = [Te(" 搜索 ")])), _: 1, __: [13] }), s(le, { class: "filter-item", icon: "el-icon-refresh-left", size: "default", type: "warning", onClick: Pi(L, ["stop"]) }, { default: p(() => j[14] || (j[14] = [Te(" 重置 ")])), _: 1, __: [14] })]), qe((w(), U(he, { ref_key: "manufSelectTable", ref: T, data: M.value, "max-height": l(N) - 100, "return-source-data": "", style: { width: "100%" }, onSelectionChange: I }, { default: p(() => [s(se, { selectable: P, align: "center", type: "selection", width: "55" }), s(se, { align: "center", label: "序号", type: "index", width: "60" }), l(g).currentBasicClass === l(Pe).STRUC_MANUFACTURED.V ? (w(), Q(Qe, { key: 0 }, [s(se, { key: "monomer.name", align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), s(se, { key: "area.name", align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), s(se, { key: "manufacturedName", align: "center", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" }), s(se, { key: "manufacturedSn", align: "center", label: "编号", "min-width": "100px", prop: "manufacturedSn", "show-overflow-tooltip": "" }), s(se, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), s(se, { align: "center", label: "长度（mm）", prop: "length", "show-overflow-tooltip": "" }), s(se, { key: "totalLength", label: "总长度(m)", align: "left", "min-width": "100px", prop: "totalLength" }, { default: p(({ row: ge }) => [C("span", null, K(l(St)(ge.totalLength, "mm", "m", l(Ze).COM_T__MM)), 1)]), _: 1 }), s(se, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), s(se, { align: "center", label: "清单数量", prop: "quantity", "show-overflow-tooltip": "" }), s(se, { align: "center", label: "单净重（kg）", prop: "weight", "show-overflow-tooltip": "" }), s(se, { align: "center", label: "总重（kg）", prop: "totalWeight", "show-overflow-tooltip": "" })], 64)) : H("", true), l(g).currentBasicClass === l(Pe).ENCL_MANUFACTURED.V ? (w(), Q(Qe, { key: 1 }, [s(se, { align: "center", label: "类型", prop: "manufacturedType", "show-overflow-tooltip": "" }, { default: p(({ row: ge }) => [ge.manufacturedType ? (w(), Q("span", HZ, K(l(Xi).VL[ge.manufacturedType]), 1)) : H("", true)]), _: 1 }), s(se, { key: "manufacturedName", "show-overflow-tooltip": true, label: "名称", "min-width": "100", prop: "manufacturedName" }), s(se, { key: "manufacturedSn", "show-overflow-tooltip": true, label: "编号", "min-width": "90px", prop: "manufacturedSn" }), s(se, { align: "center", label: "板型", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), s(se, { key: "width", label: `有效宽度
(mm)`, "show-overflow-tooltip": true, "min-width": "100px", prop: "width" }), s(se, { key: "unfoldedWidth", label: `展开宽度
(mm)`, "show-overflow-tooltip": true, "min-width": "100px", prop: "unfoldedWidth" }), s(se, { key: "bendTimes", label: "折弯次数", "show-overflow-tooltip": true, prop: "bendTimes", width: "80px" }), s(se, { key: "thickness", label: `厚度
(mm)`, "show-overflow-tooltip": true, align: "left", "min-width": "100px", prop: "thickness" }), s(se, { key: "length", label: `单长
(㎜)`, "show-overflow-tooltip": true, align: "left", "min-width": "100px", prop: "length" }), s(se, { key: "quantity", label: "数量(张)", align: "left", "min-width": "100px", prop: "quantity" }), s(se, { key: "totalArea", label: "总面积(㎡)", "show-overflow-tooltip": true, align: "left", "min-width": "100px", prop: "totalArea" }), s(se, { key: "totalLength", label: "总长度(m)", align: "left", "min-width": "100px", prop: "totalLength" }), s(se, { key: "weight", label: "总重量(kg)", align: "left", "min-width": "100px", prop: "weight" }), s(se, { key: "brand", "show-overflow-tooltip": true, label: "品牌", prop: "brand", width: "100px" }), s(se, { key: "color", "show-overflow-tooltip": true, label: "颜色", prop: "color", width: "80px" })], 64)) : H("", true)]), _: 1 }, 8, ["data", "max-height"])), [[me, V.value]]), s(l(hd), { modelValue: h.value, "onUpdate:modelValue": j[9] || (j[9] = (ge) => h.value = ge), tableData: S.value, onAddManufSuccess: B, onRowDelete: ee }, null, 8, ["modelValue", "tableData"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, qZ = Object.freeze(Object.defineProperty({ __proto__: null, default: KR }, Symbol.toStringTag, { value: "Module" }));
function WR(e) {
  if (e) return new Promise(function(o, n) {
    if (e.slice(0, 4) === "data") {
      const u = new Image();
      u.onload = function() {
        o(u);
      }, u.onerror = function() {
        n("Image load error");
      }, u.src = e;
      return;
    }
    const c = new Image();
    c.setAttribute("crossOrigin", "Anonymous"), c.onload = function() {
      o(c);
    }, c.onerror = function() {
      o();
    }, c.src = e;
  });
}
const Cb = ";base64,";
function t2(e) {
  var o = e.indexOf(Cb) + Cb.length, n = e.substring(o), c = window.atob(n), u = c.length, r = new Uint8Array(new ArrayBuffer(u));
  for (let E = 0; E < u; E++) r[E] = c.charCodeAt(E);
  return r;
}
function jR(e) {
  const o = GZ(e);
  return t2(o);
}
function GZ(e) {
  var o = document.createElement("canvas");
  o.width = e.width, o.height = e.height;
  var n = o.getContext("2d");
  n.drawImage(e, 0, 0, e.width, e.height);
  var c = e.src.substring(e.src.lastIndexOf(".") + 1).toLowerCase(), u = o.toDataURL("image/" + c);
  return u;
}
const Pb = Object.assign({ "./modules/bim.js": Kw, "./modules/bridge.js": Ww, "./modules/building-steel.js": nw, "./modules/capp.js": jw, "./modules/classification.js": sw, "./modules/common.js": rw, "./modules/config.js": Ay, "./modules/contract.js": ph, "./modules/crm.js": Fw, "./modules/cutting.js": zw, "./modules/dd.js": Vw, "./modules/enclosure.js": Bw, "./modules/file.js": Hw, "./modules/finance.js": E0, "./modules/logistics.js": qw, "./modules/mes.js": uw, "./modules/operation.js": Gw, "./modules/plan.js": Qw, "./modules/production.js": bw, "./modules/project.js": Zw, "./modules/ship-manage.js": Jw, "./modules/supplier.js": Xw, "./modules/system.js": $w, "./modules/uploading-form.js": eS, "./modules/user.js": tS, "./modules/wms.js": Dw }), vn = {};
