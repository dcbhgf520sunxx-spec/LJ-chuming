import { ref as V } from "vue";
import { resolveComponent as a } from "vue";
import { openBlock as h } from "vue";
import { createBlock as E } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as T } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as d } from "vue";
import { ElFormItem as k } from "element-plus";
import { ElForm as B } from "element-plus";
import { lF as c, ao as S, cy as U } from "../../../../../shared/runtime.js";
const j = { style: { float: "right" } }, z = { __name: "form", props: { projectList: { type: Array, default: () => [] } }, setup(p) {
  const i = V(), f = { id: void 0, crmProjectInformationWarehousingId: void 0, crmSettlementBusinessTypeEnum: c.DIRECT.V, userId: void 0 }, { crud: n, CRUD: _, form: s } = S(f, i), g = { crmProjectInformationWarehousingId: [{ required: true, message: "请选择项目", trigger: "change" }], crmSettlementBusinessTypeEnum: [{ required: true, message: "请选择项目业务属性", trigger: "change" }], userId: [{ required: true, message: "请选择指定负责人", trigger: "change" }] };
  return (x, o) => {
    const u = a("common-button"), b = a("common-select-v2"), m = k, y = a("common-radio"), I = B, C = a("common-dialog");
    return h(), E(C, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(n).cancelCU, visible: e(n).status.cu > 0, title: e(n).status.title, "show-close": false, width: "530px" }, { titleRight: l(() => [T("span", j, [t(u, { loading: e(n).status.cu === e(_).STATUS.PROCESSING, size: "default", type: "primary", onClick: e(n).submitCU }, { default: l(() => o[3] || (o[3] = [d(" 保 存 ")])), _: 1, __: [3] }, 8, ["loading", "onClick"]), t(u, { size: "default", onClick: e(n).cancelCU }, { default: l(() => o[4] || (o[4] = [d("关 闭")])), _: 1, __: [4] }, 8, ["onClick"])])]), default: l(() => [t(I, { ref_key: "formRef", ref: i, model: e(s), rules: g, size: "default", "label-width": "135px" }, { default: l(() => [t(m, { label: "项目", prop: "crmProjectInformationWarehousingId" }, { default: l(() => [t(b, { modelValue: e(s).crmProjectInformationWarehousingId, "onUpdate:modelValue": o[0] || (o[0] = (r) => e(s).crmProjectInformationWarehousingId = r), "data-structure": { key: "id", label: "name", value: "id" }, options: p.projectList, class: "filter-item", clearable: "", filterable: "", type: "other", size: "default", placeholder: "请选择项目", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), t(m, { prop: "crmSettlementBusinessTypeEnum", label: "项目业务属性" }, { default: l(() => [t(y, { class: "filter-item", modelValue: e(s).crmSettlementBusinessTypeEnum, "onUpdate:modelValue": o[1] || (o[1] = (r) => e(s).crmSettlementBusinessTypeEnum = r), options: e(c).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(m, { label: "指定负责人", prop: "userId" }, { default: l(() => [t(U, { modelValue: e(s).userId, "onUpdate:modelValue": o[2] || (o[2] = (r) => e(s).userId = r), filterable: "", "collapse-tags": false, clearable: "", "show-all-levels": "", style: { width: "270px" }, placeholder: "选择指定负责人" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  z as default
};
