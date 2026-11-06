import { dZ as e } from "../shared/runtime.js";
const r = [{ key: "filingDate", label: "创建时间" }, { key: "applyUserName", label: "创建人" }, { key: "projectName", label: "项目" }, { key: "supplierName", label: "供应商" }, { key: "contractNumber", label: "采购合同号" }, { key: "amount", label: "合同额" }, { key: "basicClass", label: "物资类型" }, { key: "settlementAmount", label: "结算额", vColor: "#f56c6c" }, { key: "remark", label: "备注" }], t = [{ key: "supplierName", label: "供应商" }, { key: "contractNumber", label: "采购合同号" }, { key: "remark", label: "备注" }], b = [{ key: "supplierName", label: "分包商" }, { key: "contractNumber", label: "分包合同号" }, { key: "branchCompanyName", label: "签约主体" }, { key: "amount", label: "合同额" }, { key: "basicClassName", label: "分包类型" }, { key: "remark", label: "备注" }], a = [{ key: "invoiceAmount", label: "本次发票额", verify: true }, { key: "invoiceSerialNumber", label: "发票编号", verify: true }], s = e(a);
export {
  r as a,
  s as b,
  t as h,
  a as i,
  b as s
};
