const e = [{ key: "applyDate", label: "创建日期", verify: true }, { key: "applicantId", label: "创建人" }, { key: "projectId", label: "项目", verify: true }, { key: "supplierId", label: "分包商", verify: true }, { key: "orderIds", label: "分包合同号", verify: true }, { key: "paymentAttributeId", label: "付款属性", verify: true }], r = { applyDate: [{ required: true, message: "创建日期不能为空", trigger: ["change", "blur"] }], projectId: [{ required: true, message: "项目不能为空", trigger: ["change", "blur"] }], supplierId: [{ required: true, message: "供应商不能为空", trigger: ["change", "blur"] }], orderIds: [{ required: true, message: "采购合同号不能为空", trigger: ["change", "blur"] }], paymentAttributeId: [{ required: true, message: "付款属性不能为空", trigger: ["change", "blur"] }] }, t = [{ key: "createTime", label: "创建日期", verify: true }, { key: "userId", label: "创建人" }, { key: "supplierId", label: "分包商", verify: true }, { key: "orderId", label: "分包合同号", verify: true }, { key: "projectName", label: "项目" }], a = { createTime: [{ required: true, message: "申请日期不能为空", trigger: ["change", "blur"] }], supplierId: [{ required: true, message: "供应商不能为空", trigger: ["change", "blur"] }], orderId: [{ required: true, message: "采购合同号不能为空", trigger: ["change", "blur"] }] }, l = [{ key: "contractAmount", label: "合同额" }, { key: "settlementAmount", label: "最终结算额", verify: true }, { key: "remainingAmount", label: "剩余发票额" }], s = { settlementAmount: [{ required: true, message: "最终结算额不能为空", trigger: ["change", "blur"] }] }, u = [{ key: "contractAmount", label: "合同额" }, { key: "settlementAmount", label: "预结算额", verify: true }], n = { settlementAmount: [{ required: true, message: "结算额不能为空", trigger: ["change", "blur"] }] };
export {
  e as a,
  n as b,
  u as c,
  t as d,
  s as e,
  l as f,
  r as p,
  a as s
};
