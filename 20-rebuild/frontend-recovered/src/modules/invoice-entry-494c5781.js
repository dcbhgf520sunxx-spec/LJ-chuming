import { dZ as e } from "../shared/runtime.js";
const r = [{ key: "projectManagerId", label: "项目经理", verify: true }, { key: "projectId", label: "项目", verify: true }, { key: "supplierId", label: "供应商", verify: true }, { key: "orderId", label: "采购合同号", verify: true }, { key: "signatoryName", label: "签约主体" }, { key: "contractAmount", label: "合同额" }, { key: "basicClass", label: "物资类型" }, { key: "settlementAmount", label: "结算额" }], t = e(r), i = [{ key: "invoiceAmount", label: "本次发票额", verify: true }, { key: "invoiceSerialNumber", label: "发票编号", verify: true }], l = { invoiceAmount: [{ required: true, message: "发票额不能为空", trigger: ["change", "blur"] }], invoiceSerialNumber: [{ required: true, message: "发票编号不能为空", trigger: ["change", "blur"] }] };
export {
  r as a,
  i as b,
  t as h,
  l as i
};
