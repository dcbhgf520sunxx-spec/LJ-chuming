import { dZ as e } from "../shared/runtime.js";
const r = [{ key: "projectManagerId", label: "项目经理", verify: true }, { key: "projectId", label: "项目", verify: true }, { key: "supplierId", label: "供应商", verify: true }, { key: "purchaseContractNumber", label: "采购合同号", verify: true }, { key: "branchCompanyName", label: "签约主体" }, { key: "amount", label: "合同额" }, { key: "subcontractClassId", label: "类型" }, { key: "settlementAmount", label: "结算额" }], t = e(r), l = [{ key: "invoiceAmount", label: "本次发票额", verify: true }, { key: "invoiceSerialNumber", label: "发票编号", verify: true }], i = { invoiceAmount: [{ required: true, message: "发票额不能为空", trigger: ["change", "blur"] }], invoiceSerialNumber: [{ required: true, message: "发票编号不能为空", trigger: ["change", "blur"] }] };
export {
  r as a,
  l as b,
  t as h,
  i
};
