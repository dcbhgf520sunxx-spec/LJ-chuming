import { computed as k } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as g } from "vue";
import { withDirectives as E } from "vue";
import { vShow as I } from "vue";
import { unref as e } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as n } from "vue";
import { withCtx as T } from "vue";
import { toDisplayString as _ } from "vue";
import { Fragment as M } from "vue";
import { dM as f, B as b, oS as p, oT as x, C as A, E as N } from "../../../../../shared/runtime.js";
const S = { style: { display: "flex" } }, O = { class: "label" }, U = { __name: "header", props: { workShopList: { type: Array, default: () => [] }, workshopLines: { type: Array, default: () => [] } }, setup(u) {
  const c = u, w = { processId: void 0, leaderName: void 0, workshopId: void 0, partType: void 0 }, L = k(() => {
    var t;
    let i = [];
    return (t = c.workshopLines) != null && t.length && c.workshopLines.forEach((s) => {
      var o, m, h;
      if (a.workshopId) {
        const d = (o = s == null ? void 0 : s.workshopList) == null ? void 0 : o.find((l) => l.id === a.workshopId);
        d && (i = d.productionLineList.filter((l) => l.productType === f.MACHINE_PART.V));
      } else i = ((h = (m = s == null ? void 0 : s.workshopList) == null ? void 0 : m.flatMap((l) => l.productionLineList || [])) == null ? void 0 : h.filter((l) => l.productType === f.MACHINE_PART.V)) || [];
    }), i;
  }), { crud: r, query: a } = b(w);
  return (i, t) => {
    const s = C("common-select");
    return V(), g(M, null, [E(y("div", S, [n(s, { modelValue: e(a).workshopId, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(a).workshopId = o), options: u.workShopList, "data-structure": { key: "id", label: "name", value: "id" }, style: { width: "200px" }, placeholder: "全部车间", class: "filter-item", clearable: "", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(s, { dataStructure: { key: "id", label: "name", value: "id" }, modelValue: e(a).productionLineId, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(a).productionLineId = o), options: L.value, placeholder: "全部产线", style: { width: "270px" }, class: "filter-item", clearable: "", onChange: e(r).toQuery }, { view: T(({ data: o }) => [y("span", O, _(o.name), 1)]), _: 1 }, 8, ["modelValue", "options", "onChange"]), n(s, { modelValue: e(a).partType, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(a).partType = o), options: e(p).ENUM, unshowOptions: [e(p).PRIMARY_SECONDARY.K, e(p).WELDED_PROFILE.K], placeholder: "零件类型筛选", type: "enum", class: "filter-item", clearable: "", style: { width: "200px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "unshowOptions", "onChange"]), n(s, { modelValue: e(a).partProdMode, "onUpdate:modelValue": t[3] || (t[3] = (o) => e(a).partProdMode = o), options: e(x).ENUM, placeholder: "生产方式筛选", type: "enum", class: "filter-item", clearable: "", style: { width: "200px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(e(A))], 512), [[I, e(r).searchToggle]]), n(e(N))], 64);
  };
} };
export {
  U as default
};
