import { dZ as e } from "../shared/runtime.js";
const t = [{ key: "applyDate", label: "申请日期", verify: true }, { key: "projectAttribute", label: "项目类型" }, { key: "applyUserId", label: "申请人" }, { key: "projectId", label: "项目", verify: true }, { key: "projectManagerId", label: "项目经理", verify: true }, { key: "supplierId", label: "供应商", verify: true }, { key: "contractSignBodyName", label: "签约主体" }, { key: "purchaseContractNumber", label: "采购合同号", verify: true }, { key: "contractAmount", label: "合同额" }, { key: "subcontractClassId", label: "类型" }], l = { applyDate: [{ required: true, message: "申请日期不能为空", trigger: ["change", "blur"] }], projectId: [{ required: true, message: "项目不能为空", trigger: ["change", "blur"] }], projectManagerId: [{ required: true, message: "项目经理不能为空", trigger: ["change", "blur"] }], supplierId: [{ required: true, message: "供应商不能为空", trigger: ["change", "blur"] }], purchaseContractNumber: [{ required: true, message: "采购合同号不能为空", trigger: ["change", "blur"] }] }, r = [{ key: "applyDate", label: "申请日期", verify: true }, { key: "projectAttribute", label: "项目类型" }, { key: "applyUserId", label: "申请人" }, { key: "projectId", label: "项目", verify: true }, { key: "projectManagerId", label: "项目经理", verify: true }, { key: "supplierId", label: "供应商", verify: true }, { key: "branchCompanyName", label: "签约主体" }, { key: "purchaseContractNumber", label: "采购合同号", verify: true }, { key: "amount", label: "合同额" }, { key: "subcontractClassId", label: "类型" }], u = e(r);
export {
  t as a,
  r as b,
  l as p,
  u as s
};
