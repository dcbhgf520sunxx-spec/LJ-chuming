const e = [{ key: "supplierId", label: "供应商", verify: true }, { key: "orderIds", label: "采购合同号", verify: true }], r = { supplierId: [{ required: true, message: "供应商不能为空", trigger: ["change", "blur"] }], orderIds: [{ required: true, message: "采购合同号不能为空", trigger: ["change", "blur"] }] }, i = [{ key: "invoiceAmount", label: "本次发票额", verify: true }, { key: "invoiceSerialNumber", label: "发票编号", verify: true }], a = { invoiceAmount: [{ required: true, message: "发票额不能为空", trigger: ["change", "blur"] }], invoiceSerialNumber: [{ required: true, message: "发票编号不能为空", trigger: ["change", "blur"] }] };
export {
  e as a,
  i as b,
  r as h,
  a as i
};
