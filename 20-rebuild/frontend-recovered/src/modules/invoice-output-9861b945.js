import "../shared/runtime.js";
const a = [{ key: "applyDate", label: "开票日期" }, { key: "applyName", label: "创建人" }, { key: "projectName", label: "项目" }, { key: "applyAmount", label: "本次开票" }, { key: "capital", label: "大写" }, { key: "invoiceType", label: "发票类型" }, { key: "taxRate", label: "税率" }, { key: "invoiceUnit", label: "开票单位" }, { key: "collectionUnit", label: "收票单位" }, { key: "invoiceNumber", label: "发票号码" }], l = [{ key: "AcquiringEnterprise", label: "购方全称" }, { key: "identifyNumber", label: "纳税人识别号" }, { key: "openBank", label: "开户行" }, { key: "account", label: "账号" }, { key: "address", label: "地址 \\ 电话" }], i = [{ key: "practicalInvoice", label: "本次实开金额", verify: true }, { key: "taxRateTypeValue", label: "税率", verify: false }, { key: "invoiceNumber", label: "发票编号", verify: true }];
export {
  a as h,
  i,
  l as s
};
