import { resolveComponent as v } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as C } from "vue";
import { withDirectives as N } from "vue";
import { vShow as k } from "vue";
import { unref as e } from "vue";
import { createElementVNode as w } from "vue";
import { createBlock as u } from "vue";
import { createCommentVNode as c } from "vue";
import { createVNode as l } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as I } from "vue";
import { toDisplayString as E } from "vue";
import { ElInput as R } from "element-plus";
import { ElTag as x } from "element-plus";
import { m as B, B as D, fg as S, t8 as T, C as M, E as Q } from "../../../../../../../shared/runtime.js";
const q = { __name: "header", props: { tip: { type: String, default: "覆盖导入仅支持PDF格式" } }, setup(p) {
  const { drawingMatchRange: f } = B(["drawingMatchRange"]), s = p, g = { areaId: void 0, serialNumber: void 0 }, { CRUD: _, crud: o, query: a } = D(g), { monomerMap: y } = S();
  return _.HOOK.beforeResetQuery = () => (a.areaId = void 0, a.serialNumber = void 0, o.toQuery(), false), (O, r) => {
    var d, i;
    const h = v("common-select"), V = R, b = x;
    return n(), C("div", null, [N(w("div", null, [e(f) !== e(T).AREA.V ? (n(), u(h, { key: 0, modelValue: e(a).areaId, "onUpdate:modelValue": r[0] || (r[0] = (t) => e(a).areaId = t), options: e(a).monomerId && ((i = (d = e(y)) == null ? void 0 : d[e(a).monomerId]) == null ? void 0 : i.children.filter((t) => t.productType === 1)) || [], dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", type: "other", placeholder: "可选择区域", class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : c("", true), l(V, { modelValue: e(a).serialNumber, "onUpdate:modelValue": r[1] || (r[1] = (t) => e(a).serialNumber = t), placeholder: "编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), l(e(M))], 512), [[k, e(o).searchToggle]]), l(e(Q), null, { viewLeft: m(() => [s.tip ? (n(), u(b, { key: 0, class: "filter-item", size: "large", effect: "plain" }, { default: m(() => [I(E(s.tip), 1)]), _: 1 })) : c("", true)]), _: 1 })]);
  };
} };
export {
  q as default
};
