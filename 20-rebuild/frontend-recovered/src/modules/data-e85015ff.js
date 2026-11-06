const e = [{ key: "applyDate", label: "创建日期", verify: true }, { key: "applicantId", label: "创建人" }, { key: "supplierId", label: "供应商", verify: true }, { key: "orderId", label: "采购合同号", verify: true }, { key: "projectName", label: "项目" }], r = { applyDate: [{ required: true, message: "创建日期不能为空", trigger: ["change", "blur"] }], supplierId: [{ required: true, message: "供应商不能为空", trigger: ["change", "blur"] }], orderId: [{ required: true, message: "采购合同号不能为空", trigger: ["change", "blur"] }] }, t = [{ key: "createTime", label: "创建日期", verify: true }, { key: "userId", label: "创建人" }, { key: "supplierId", label: "供应商", verify: true }, { key: "orderId", label: "采购合同号", verify: true }, { key: "projectName", label: "项目" }, { key: "branchCompanyName", label: "采购单位" }], a = { createTime: [{ required: true, message: "申请日期不能为空", trigger: ["change", "blur"] }], supplierId: [{ required: true, message: "供应商不能为空", trigger: ["change", "blur"] }], orderId: [{ required: true, message: "采购合同号不能为空", trigger: ["change", "blur"] }] }, l = [{ key: "contractAmount", label: "合同额" }, { key: "settlementAmount", label: "最终结算额", verify: true }, { key: "remainingAmount", label: "剩余发票额" }], s = { settlementAmount: [{ required: true, message: "最终结算额不能为空", trigger: ["change", "blur"] }] };
export {
  e as a,
  l as b,
  a as c,
  t as d,
  r as p,
  s
};
