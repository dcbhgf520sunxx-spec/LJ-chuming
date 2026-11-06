import l from "moment";
import { computed as i } from "vue";
import { ref as O } from "vue";
import { watch as S } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as P } from "vue";
import { createElementBlock as k } from "vue";
import { withDirectives as y } from "vue";
import { vShow as g } from "vue";
import { unref as e } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as n } from "vue";
import { withCtx as v } from "vue";
import { Fragment as Q } from "vue";
import { ElDatePicker as U } from "element-plus";
import { B as j, bu as T, a3 as u, bv as w, bZ as A, I as N, C as x, E as B } from "../../../../../../shared/runtime.js";
import { u as q } from "../../../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
import { _ as F } from "../../../../../../modules/index-b238c21c.js";
const $ = { __name: "header", setup(z) {
  const C = { category: void 0, date: [l().startOf("month").valueOf(), l().valueOf()], startDate: l().startOf("month").valueOf(), endDate: l().valueOf() }, { crud: o, query: t } = j(C), d = q(o);
  function I() {
    t.date && t.date.length > 1 ? (t.startDate = t.date[0], t.endDate = t.date[1]) : (t.startDate = void 0, t.endDate = void 0), o.toQuery();
  }
  const m = i(() => t.category === T.ARTIFACT.V ? u.ARTIFACT.V : u.ENCLOSURE.V), b = i(() => {
    if (m.value === u.ARTIFACT.V) return "mesStructureProjectSummary";
    if (m.value === u.ENCLOSURE.V) return "mesEnclosureProjectSummary";
  }), p = O(), c = i(() => {
    var a;
    const s = ((a = p.value) == null ? void 0 : a.getProductType()) || 0;
    return w.getBits(T.ENUM, s);
  });
  return S(() => c.value, (s) => {
    s.length ? (t.category = s[0].V, o.refresh()) : t.category = void 0;
  }, { deep: true }), (s, a) => {
    const h = f("common-radio-button"), D = U, V = f("print-table"), E = R("permission");
    return P(), k(Q, null, [y(_("div", null, [n(e(A), { ref_key: "monomerRef", ref: p, monomerId: e(t).monomerId, "onUpdate:monomerId": a[1] || (a[1] = (r) => e(t).monomerId = r), areaId: e(t).areaId, "onUpdate:areaId": a[2] || (a[2] = (r) => e(t).areaId = r), productType: e(t).category, "project-id": e(d), areaClearable: "", monomerDisabled: !e(d), areaDisabled: !e(d), monomerDefault: "", onChange: e(o).toQuery }, { middle: v(() => [n(h, { class: "filter-item", modelValue: e(t).category, "onUpdate:modelValue": a[0] || (a[0] = (r) => e(t).category = r), options: c.value, type: "enum", size: "default", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), _: 1 }, 8, ["monomerId", "areaId", "productType", "project-id", "monomerDisabled", "areaDisabled", "onChange"]), a[4] || (a[4] = _("br", null, null, -1)), n(D, { modelValue: e(t).date, "onUpdate:modelValue": a[3] || (a[3] = (r) => e(t).date = r), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "300px" }, clearable: false, shortcuts: e(N), "value-format": "x", onChange: I }, null, 8, ["modelValue", "shortcuts"]), n(e(F), { productType: m.value, category: e(t).category, toQuery: e(o).toQuery, query: e(t) }, null, 8, ["productType", "category", "toQuery", "query"]), n(e(x))], 512), [[g, e(o).searchToggle]]), n(e(B), null, { optLeft: v(() => [y(n(V, { "api-key": b.value, params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[g, e(t).category], [E, e(o).permission.print]])]), _: 1 })], 64);
  };
} };
export {
  $ as default
};
