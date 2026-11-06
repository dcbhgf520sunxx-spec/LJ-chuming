import { dZ as e } from "../shared/runtime.js";
const l = [{ key: "createDate", label: "创建日期" }, { key: "createUserName", label: "创建人" }, { key: "supplierName", label: "供应商" }, { key: "serialNumber", label: "采购合同号", verify: true }, { key: "projectName", label: "项目" }], a = [{ label: "本次实付金额", key: "actuallyPayAmount", verify: true }, { label: "大写", key: "capital" }, { label: "付款类型", key: "paymentType" }, { label: "付款日期", key: "paymentDate", verify: true }, { key: "attachmentIds", label: "附件" }, { key: "remark", label: "备注" }];
e(a);
const n = [{ key: "paymentBank", label: "付款银行", verify: true }, { key: "paymentBankAccount", label: "账号", verify: true }], r = { paymentBank: [{ required: true, message: "付款银行不能为空", trigger: ["change", "blur"] }], paymentBankAccount: [{ required: true, message: "账号不能为空", trigger: ["change", "blur"] }] }, y = [{ key: "contractAmount", label: "合同额" }, { key: "settlementAmount", label: "最终结算额" }, { key: "remainingAmount", label: "剩余发票额" }], u = [{ key: "inboundAmountSum", label: "累计入库额" }, { key: "settlementAmount", label: "最终结算额" }];
export {
  l as a,
  n as b,
  r as c,
  u as d,
  y as i,
  a as p
};
