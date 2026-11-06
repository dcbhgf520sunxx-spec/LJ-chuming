import { ref as x } from "vue";
import { inject as U } from "vue";
import { computed as k } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as d } from "vue";
import { createBlock as c } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { createTextVNode as E } from "vue";
import { ElInputNumber as N } from "element-plus";
import { ElFormItem as P } from "element-plus";
import { ElCascader as z } from "element-plus";
import { ElForm as F } from "element-plus";
import { ao as M, dM as i } from "../../../../../../shared/runtime.js";
import { _ as j } from "../../../../../../modules/process-select-b35dffc0.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-process-af1f8c99.js";
const K = { __name: "editFrom", props: { artifactCurrentRow: { type: Object, default: () => ({}) } }, setup(u) {
  const f = u, m = x(), _ = U("machinePartProcess"), b = { conversionRate: void 0, processType: void 0, processIds: [] }, { crud: s, CRUD: y, form: o } = M(b, m), g = k(() => ({ value: "id", label: "name", children: "nameInfos", expandTrigger: "hover", multiple: true, emitPath: false })), h = { conversionRate: [{ required: true, message: "请填写折合完工率", trigger: "change" }], processType: [{ required: true, message: "请选择工序类型", trigger: "change" }], processIds: [{ required: true, message: "请选择工序", trigger: "change" }] };
  y.HOOK.beforeSubmit = () => {
    s.form.processIds = s.form.processIds.join(","), o.artifactClassId = f.artifactCurrentRow.id, s.form.processNames = void 0, s.form.processTypeName = void 0, s.form.sourceRow = void 0, s.form.processIdArray = void 0;
  };
  function I() {
    o.processIds = [];
  }
  return (O, t) => {
    const T = p("common-button"), R = N, n = P, C = p("common-select"), V = z, w = F, v = p("common-dialog");
    return d(), c(v, { "close-on-click-modal": false, "before-close": e(s).cancelCU, visible: e(s).status.cu > 0, title: e(s).status.title, width: "500px" }, { titleRight: l(() => [a(T, { loading: e(s).status.cu === 2, type: "primary", size: "default", onClick: e(s).submitCU }, { default: l(() => t[4] || (t[4] = [E("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), default: l(() => [a(w, { ref_key: "formRef", ref: m, model: e(o), rules: h, size: "default", "label-width": "150px" }, { default: l(() => [a(n, { label: "折合完工率（%）：", prop: "conversionRate" }, { default: l(() => [a(R, { modelValue: e(o).conversionRate, "onUpdate:modelValue": t[0] || (t[0] = (r) => e(o).conversionRate = r), modelModifiers: { number: true }, min: 0, max: 100, step: 1, precision: 2, "controls-position": "right", placeholder: "请填写", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), a(n, { label: "工序类型：", prop: "processType" }, { default: l(() => [a(C, { modelValue: e(o).processType, "onUpdate:modelValue": t[1] || (t[1] = (r) => e(o).processType = r), options: e(i).ENUM, "unshow-options": [e(i).ENCLOSURE.K], clearable: "", type: "enum", size: "default", placeholder: "请选择工序类型", class: "filter-item", style: { width: "270px" }, onChange: I }, null, 8, ["modelValue", "options", "unshow-options"])]), _: 1 }), a(n, { label: "工序：", prop: "processIds" }, { default: l(() => [e(o).processType === e(i).MACHINE_PART.V ? (d(), c(V, { key: 0, ref: "processIdRef", options: e(_), "check-strictly": "", modelValue: e(o).processIds, "onUpdate:modelValue": t[2] || (t[2] = (r) => e(o).processIds = r), disabled: !e(o).processType, props: g.value, separator: " > ", "show-all-levels": "", clearable: "", size: "default", style: { width: "270px" }, placeholder: "选择工序" }, null, 8, ["options", "modelValue", "disabled", "props"])) : (d(), c(e(j), { key: 1, ref: "processSelectRef", modelValue: e(o).processIds, "onUpdate:modelValue": t[3] || (t[3] = (r) => e(o).processIds = r), productType: e(o).processType, disabled: !e(o).processType, size: "default", filterable: "", clearable: "", multiple: "", style: { width: "270px" } }, null, 8, ["modelValue", "productType", "disabled"]))]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  K as default
};
