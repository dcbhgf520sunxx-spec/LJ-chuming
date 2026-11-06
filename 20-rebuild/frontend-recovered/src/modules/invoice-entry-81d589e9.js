const e = [{ key: "projectManagerId", label: "项目经理", verify: true }, { key: "projectId", label: "项目", verify: true }, { key: "supplierId", label: "供应商", verify: true }, { key: "purchaseContractNumber", label: "采购合同号", verify: true }, { key: "signatoryName", label: "签约主体" }, { key: "contractAmount", label: "合同额" }, { key: "materialType", label: "物资类型" }, { key: "settlementAmount", label: "结算额" }], r = { projectManagerId: [{ required: true, message: "项目经理不能为空", trigger: ["change", "blur"] }], projectId: [{ required: true, message: "项目不能为空", trigger: ["change", "blur"] }], supplierId: [{ required: true, message: "供应商不能为空", trigger: ["change", "blur"] }], purchaseContractNumber: [{ required: true, message: "采购合同号不能为空", trigger: ["change", "blur"] }] }, a = [{ key: "invoiceAmount", label: "本次发票额", verify: true }, { key: "invoiceSerialNumber", label: "发票编号", verify: true }], t = { invoiceAmount: [{ required: true, message: "发票额不能为空", trigger: ["change", "blur"] }], invoiceSerialNumber: [{ required: true, message: "发票编号不能为空", trigger: ["change", "blur"] }] };
export {
  e as a,
  t as b,
  r as h,
  a as i
};
