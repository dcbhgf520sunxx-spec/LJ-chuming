import { ref as m } from "vue";
import { computed as S } from "vue";
import { watch as _ } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as $ } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as C } from "vue";
import { withDirectives as y } from "vue";
import { vShow as L } from "vue";
import { unref as o } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as u } from "vue";
import { normalizeStyle as P } from "vue";
import { withCtx as f } from "vue";
import { createBlock as b } from "vue";
import { createCommentVNode as k } from "vue";
import { createTextVNode as V } from "vue";
import { m as B, B as D, mc as E, m4 as N, G as U, L as w, E as O } from "../../../../../shared/runtime.js";
import { e as Q, a as R, d as z } from "../../../../../modules/standard-part-8c26f414.js";
import { _ as G } from "../../../../../modules/ExcelUploadBtn-acccae97.js";
import { a as M } from "../../../../../modules/index-8356a01a.js";
const H = { class: "monomer-batch-container" }, q = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, typeOption: { type: Array, default: void 0 } }, emits: ["enclosurePlan"], setup(F, { emit: J }) {
  const h = { projectId: { value: void 0, resetAble: false }, monomerId: void 0, areaId: void 0 }, s = m([]), p = m({}), { globalProjectId: j } = B("globalProjectId"), r = m([]);
  m([]);
  const { crud: l, query: a } = D(h), x = S(() => {
    const t = {};
    for (const e in a) a[e] && (t[e] = a[e]);
    return t;
  });
  _(j, (t) => {
    a.projectId = t, A();
  }, { immediate: true });
  async function A() {
    var t;
    try {
      const e = await E({ projectId: a.projectId });
      s.value = e.monomerList, (t = s.value) != null && t.length && (a.monomerId = s.value[0].id, v(a.monomerId));
    } catch (e) {
      console.log(e);
    }
  }
  function v(t) {
    var d;
    t || (a.areaId = void 0);
    const e = s.value.findIndex((n) => n.id === t);
    e !== -1 ? (r.value = s.value[e].areaList, r.value.forEach((n) => {
      n != null && n.specialAnnotation || (n.name = n.type == N.OUTSOURCE.V ? `${n.name} (外协)` : `${n.name} (自制)`, n.specialAnnotation = true);
    }), (d = r.value) != null && d.length && (p.value = { id: r.value[0].id + "", name: `${r.value[0].name}(${r.value[0].axis})` }), a.areaId = r.value[0].id) : r.value = [];
  }
  return _([() => a == null ? void 0 : a.monomerId, () => a == null ? void 0 : a.areaId], ([t, e]) => {
    l.toQuery();
  }, { deep: true }), (t, e) => {
    var I;
    const d = T("common-select-v2"), n = $("permission");
    return c(), C("div", null, [y(g("div", null, [g("div", H, [u(d, { modelValue: o(a).monomerId, "onUpdate:modelValue": e[0] || (e[0] = (i) => o(a).monomerId = i), options: s.value, class: "filter-item", default: "", onChange: v }, null, 8, ["modelValue", "options"]), u(o(M), { modelValue: o(a).areaId, "onUpdate:modelValue": e[1] || (e[1] = (i) => o(a).areaId = i), "area-info": r.value, "default-tab": p.value, style: P(((I = r.value) == null ? void 0 : I.length) > 0 ? "width:calc(100% - 230px)" : "width:calc(100% - 380px)"), class: "filter-item" }, null, 8, ["modelValue", "area-info", "default-tab", "style"])])], 512), [[L, o(l).searchToggle]]), u(o(O), null, { optRight: f(() => [o(l).query.projectId && o(U)(o(l).permission.import) ? (c(), b(o(G), { key: 0, data: x.value, "upload-fun": o(Q), "btn-name": "清单导入", "btn-size": "default", "btn-type": "primary", class: "filter-item", onSuccess: e[2] || (e[2] = (i) => o(l).toQuery()) }, null, 8, ["data", "upload-fun"])) : k("", true), y((c(), b(w, { fn: o(R), class: "filter-item" }, { default: f(() => e[3] || (e[3] = [V(" 清单模板 ")])), _: 1, __: [3] }, 8, ["fn"])), [[n, o(l).permission.templateDownload]]), u(w, { fn: o(z), params: { ...o(a), relationType: 4 }, class: "filter-item" }, { default: f(() => e[4] || (e[4] = [V("下载")])), _: 1, __: [4] }, 8, ["fn", "params"])]), _: 1 })]);
  };
} };
export {
  q as default
};
