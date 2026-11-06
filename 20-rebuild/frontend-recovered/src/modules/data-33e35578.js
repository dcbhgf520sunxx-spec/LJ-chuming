const e = [{ key: "applyDate", label: "创建日期", verify: true }, { key: "applicantId", label: "创建人" }, { key: "supplierId", label: "供应商", verify: true }, { key: "orderIds", label: "采购合同号", verify: true }, { key: "projectName", label: "项目" }], r = { applyDate: [{ required: true, message: "创建日期不能为空", trigger: ["change", "blur"] }], supplierId: [{ required: true, message: "供应商不能为空", trigger: ["change", "blur"] }], orderIds: [{ required: true, message: "采购合同号不能为空", trigger: ["change", "blur"] }] }, t = [{ key: "paymentBank", label: "付款银行", verify: false }, { key: "paymentBankAccount", label: "账号", verify: false }, { key: "currentPaymentAmount", label: "本次付款申请额" }], a = { paymentBank: [{ required: false, message: "付款银行不能为空", trigger: ["change", "blur"] }], paymentBankAccount: [{ required: false, message: "账号不能为空", trigger: ["change", "blur"] }] }, l = [{ key: "createTime", label: "创建日期", verify: true }, { key: "userId", label: "创建人" }, { key: "supplierId", label: "供应商", verify: true }, { key: "orderId", label: "采购合同号", verify: true }, { key: "projectName", label: "项目" }], s = { createTime: [{ required: true, message: "申请日期不能为空", trigger: ["change", "blur"] }], supplierId: [{ required: true, message: "供应商不能为空", trigger: ["change", "blur"] }], orderId: [{ required: true, message: "采购合同号不能为空", trigger: ["change", "blur"] }] }, n = [{ key: "contractAmount", label: "合同额" }, { key: "settlementAmount", label: "最终结算额", verify: true }, { key: "remainingAmount", label: "剩余发票额" }], u = { settlementAmount: [{ required: true, message: "最终结算额不能为空", trigger: ["change", "blur"] }] }, i = [{ key: "createTime", label: "创建日期", verify: true }, { key: "userId", label: "创建人" }, { key: "supplierId", label: "供应商", verify: true }, { key: "orderId", label: "采购合同号", verify: true }, { key: "projectName", label: "项目" }], m = { createTime: [{ required: true, message: "申请日期不能为空", trigger: ["change", "blur"] }], supplierId: [{ required: true, message: "供应商不能为空", trigger: ["change", "blur"] }], orderId: [{ required: true, message: "采购合同号不能为空", trigger: ["change", "blur"] }] }, g = [{ key: "inboundAmountSum", label: "累计入库额" }, { key: "paymentAmountSum", label: "累计付款" }, { key: "preSettlementAmount", label: "累计预结算" }, { key: "residualPresettlement", label: "剩余可预结" }, { key: "settlementAmount", label: "本次预结", verify: true }, { key: "uPThisPresettlement", label: "大写" }], y = { settlementAmount: [{ required: true, message: "本次预结算金额不能为空", trigger: ["change", "blur"] }] };
export {
  t as a,
  r as b,
  e as c,
  m as d,
  i as e,
  g as f,
  y as g,
  n as h,
  s as i,
  l as j,
  a as p,
  u as s
};
