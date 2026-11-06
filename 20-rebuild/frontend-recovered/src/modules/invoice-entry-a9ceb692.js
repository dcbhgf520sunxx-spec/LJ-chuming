const e = [{ key: "supplierId", label: "供应商", verify: true }, { key: "orderId", label: "采购合同号", verify: true }, { key: "branchCompanyName", label: "签约主体" }, { key: "amount", label: "合同额" }, { key: "basicClass", label: "物资类型" }, { key: "settlementAmount", label: "结算额" }], r = { supplierId: [{ required: true, message: "供应商不能为空", trigger: ["change", "blur"] }], orderId: [{ required: true, message: "采购合同号不能为空", trigger: ["change", "blur"] }] }, a = [{ key: "invoiceAmount", label: "本次发票额", verify: true }, { key: "invoiceSerialNumber", label: "发票编号", verify: true }], i = { invoiceAmount: [{ required: true, message: "发票额不能为空", trigger: ["change", "blur"] }], invoiceSerialNumber: [{ required: true, message: "发票编号不能为空", trigger: ["change", "blur"] }] };
export {
  e as a,
  a as b,
  r as h,
  i
};
