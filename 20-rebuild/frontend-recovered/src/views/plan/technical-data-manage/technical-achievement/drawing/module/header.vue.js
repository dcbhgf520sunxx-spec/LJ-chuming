import { ref as i } from "vue";
import { computed as C } from "vue";
import { watch as M } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as L } from "vue";
import { createVNode as n } from "vue";
import { withCtx as d } from "vue";
import { unref as e } from "vue";
import { createBlock as b } from "vue";
import { createCommentVNode as w } from "vue";
import { createTextVNode as D } from "vue";
import { toDisplayString as h } from "vue";
import { Fragment as I } from "vue";
import { ElTag as R } from "element-plus";
import { aa as u, ms as S, B as k, oW as O, t5 as E, t0 as v, E as j, t3 as U, t6 as c } from "../../../../../../shared/runtime.js";
import W from "../../../../../supply-chain/components/audit-records.vue.js";
const H = { __name: "header", props: { globalProject: { type: Object, default: () => ({}) }, APPtotal: { type: [String, Number], default: void 0 }, subTotal: { type: [String, Number], default: void 0 }, rejTotal: { type: Number, default: 0 } }, setup(V) {
  const f = i("PDF格式"), s = V, p = C(() => u.ARTIFACT.V | u.ASSEMBLY.V | u.MACHINE_PART.V), P = { dataType: S.DEEPEN.V, productType: p.value, steelPlateTypeEnum: void 0 }, { crud: r, query: l } = k(P), m = i(false), t = i({});
  function N(T) {
    const a = T;
    t.value.moduleType = E.PLAN_MANAGEMENT.V, t.value.componentNameList = [v.PLAN_DRAWING_DOCUMENT_MANAGE.V], a === 1 ? (t.value.reviewStatus = c.WITHDRAW.V, t.value.waitMeCheck = true, t.value.meLaunch = false) : a === 2 ? (t.value.reviewStatus = c.WITHDRAW.V, t.value.waitMeCheck = false, t.value.meLaunch = true) : a === 3 && (t.value.reviewStatus = c.REJECT.V, t.value.waitMeCheck = false, t.value.meLaunch = false), m.value = true;
  }
  return M(() => l.productType, () => {
    l.productType !== u.MACHINE_PART.V && (l.steelPlateTypeEnum = void 0);
  }), (T, a) => {
    const A = _("common-radio-button"), g = R;
    return y(), L(I, null, [n(e(j), null, { optLeft: d(() => [n(A, { modelValue: e(l).productType, "onUpdate:modelValue": a[0] || (a[0] = (o) => e(l).productType = o), options: e(u).ENUM, class: "filter-item mr-10", size: "default", showOptionAll: "", optionAllValue: p.value, type: "enum", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "optionAllValue", "onChange"]), e(l).productType === e(u).MACHINE_PART.V ? (y(), b(A, { key: 0, modelValue: e(l).steelPlateTypeEnum, "onUpdate:modelValue": a[1] || (a[1] = (o) => e(l).steelPlateTypeEnum = o), options: e(O).ENUM, class: "filter-item", showOptionAll: "", size: "default", type: "enum", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : w("", true)]), viewLeft: d(() => [n(g, { class: "filter-item", effect: "plain", size: "large" }, { default: d(() => [D(h(e(l).productType === p.value ? "文件导入仅支持ZIP压缩包格式(内容为PDF格式)" : `文件导入仅支持${f.value}、ZIP压缩包格式(内容为${f.value})`), 1)]), _: 1 }), n(W, { "module-type": e(E).PLAN_MANAGEMENT.V, "component-name-list": e(v).PLAN_DRAWING_DOCUMENT_MANAGE.V, APPtotal: s.APPtotal, rejTotal: s.rejTotal, subTotal: s.subTotal, style: { "margin-left": "10px", "padding-right": "10px" }, onOpenAPLists: N }, null, 8, ["module-type", "component-name-list", "APPtotal", "rejTotal", "subTotal"])]), _: 1 }), n(U, { modelValue: m.value, "onUpdate:modelValue": a[2] || (a[2] = (o) => m.value = o), form: t.value, onSuccess: a[3] || (a[3] = (o) => e(r).toQuery()) }, null, 8, ["modelValue", "form"])], 64);
  };
} };
export {
  H as default
};
