import { dZ as e } from "../shared/runtime.js";
const t = [{ key: "filingDate", label: "申请日期" }, { key: "projectAttributeName", label: "项目类型" }, { key: "initiatorName", label: "申请人" }, { key: "projectName", label: "项目" }, { key: "projectManagerName", label: "项目经理" }, { key: "supplierName", label: "供应商" }, { key: "contractSignBodyName", label: "签约主体" }, { key: "contractNumber", label: "采购合同号" }, { key: "amount", label: "合同额" }, { key: "subcontractClassId", label: "类型" }], a = [{ key: "invoiceAmount", label: "本次发票额", verify: true }, { key: "serialNumber", label: "发票编号" }];
e(a);
const n = [{ key: "applyDate", label: "创建日期" }, { key: "applyUserName", label: "创建人" }, { key: "supplierName", label: "分包商" }, { key: "contractNumber", label: "分包合同号" }, { key: "projectName", label: "项目" }, { key: "remark", label: "备注" }], o = [{ key: "amount", label: "合同额" }, { key: "settlementAmount", label: "最终结算额" }, { key: "remainingAmount", label: "剩余发票额" }], r = [{ key: "amount", label: "合同额" }, { key: "settlementAmount", label: "预结算额" }];
export {
  o as a,
  n as h,
  r as p,
  t as s
};
