import { dZ as e } from "../shared/runtime.js";
const a = [{ key: "applyDate", label: "申请日期", verify: true }, { key: "projectAttribute", label: "项目类型" }, { key: "applyUserId", label: "申请人" }, { key: "projectId", label: "项目", verify: true }, { key: "projectManagerId", label: "项目经理", verify: true }, { key: "supplierId", label: "供应商", verify: true }, { key: "contractSignBodyName", label: "签约主体" }, { key: "orderId", label: "采购合同号", verify: true }, { key: "contractAmount", label: "合同额" }, { key: "basicClass", label: "类型" }], l = { applyDate: [{ required: true, message: "申请日期不能为空", trigger: ["change", "blur"] }], projectId: [{ required: true, message: "项目不能为空", trigger: ["change", "blur"] }], projectManagerId: [{ required: true, message: "项目经理不能为空", trigger: ["change", "blur"] }], supplierId: [{ required: true, message: "供应商不能为空", trigger: ["change", "blur"] }], orderId: [{ required: true, message: "采购合同号不能为空", trigger: ["change", "blur"] }] }, r = [{ key: "applyDate", label: "申请日期", verify: true }, { key: "projectAttribute", label: "项目类型" }, { key: "applyUserId", label: "申请人" }, { key: "projectId", label: "项目", verify: true }, { key: "projectManagerId", label: "项目经理", verify: true }, { key: "supplierId", label: "供应商", verify: true }, { key: "signatoryName", label: "签约主体" }, { key: "orderId", label: "采购合同号", verify: true }, { key: "contractAmount", label: "合同额" }, { key: "basicClass", label: "物资类型" }], s = e(r), u = [{ key: "paymentContractAmount", label: "合同额" }, { key: "settlementAmount", label: "最终结算额", verify: true }, { key: "remainingAmount", label: "剩余发票额" }], y = { settlementAmount: [{ required: true, message: "最终结算额不能为空", trigger: ["change", "blur"] }] };
export {
  a,
  u as b,
  s as c,
  r as d,
  l as p,
  y as s
};
