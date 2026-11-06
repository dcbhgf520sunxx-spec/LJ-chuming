import { ref as m } from "vue";
import { provide as C } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as V } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as t } from "vue";
import { unref as a } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as y } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as Q } from "vue";
import { ElTableColumn as D } from "element-plus";
import { vLoading as j } from "element-plus";
import { c as B } from "../../../../modules/personal-production-statistics-348e794f.js";
import { x as q, nE as g, o as E, G as I } from "../../../../shared/runtime.js";
import R from "./module/header.vue.js";
import W from "./detail/index.vue.js";
import "./detail/module/header.vue.js";
const $ = { class: "app-container" }, A = { class: "head-container" }, L = { __name: "index", setup(H) {
  const u = m(), { crud: s } = q({ title: "个人产量统计", sort: [], permission: { permission: g }, crudApi: { ...B }, dataPath: "", hasPagination: false }, u), p = m(false), d = m({}), { maxHeight: v } = E({ paginate: false });
  function b(f) {
    p.value = true, d.value = f;
  }
  return C("query", s.query), (f, _) => {
    const o = D, k = w("common-button"), x = w("common-table"), N = j;
    return c(), V("div", $, [l("div", A, [t(a(R))]), P((c(), y(x, { ref_key: "tableRef", ref: u, data: a(s).data, "empty-text": a(s).emptyText, "max-height": a(v), "return-source-data": "", style: { width: "100%" } }, { default: n(() => [t(o, { label: "序号", key: "index", type: "index", align: "center", width: "55" }), t(o, { key: "project", prop: "project", label: "项目名称", align: "center", "show-overflow-tooltip": "", "min-width": "240" }, { default: n((e) => {
      var i, h;
      return [l("span", null, r((i = e.row.project) == null ? void 0 : i.serialNumber) + " - " + r((h = e.row.project) == null ? void 0 : h.shortName), 1)];
    }), _: 1 }), t(o, { key: "monomer", prop: "monomer", label: "单体", align: "center", "show-overflow-tooltip": "", "min-width": "180" }, { default: n((e) => {
      var i;
      return [l("span", null, r(((i = e.row.monomer) == null ? void 0 : i.name) || "-"), 1)];
    }), _: 1 }), t(o, { key: "taskQuantity", prop: "taskQuantity", label: "清单数量", align: "center", "show-overflow-tooltip": "" }, { default: n((e) => [l("span", null, r(e.row.taskQuantity ?? "-"), 1)]), _: 1 }), t(o, { key: "reportQuantity", prop: "reportQuantity", label: "上报总数量", align: "center", "show-overflow-tooltip": "" }, { default: n((e) => [l("span", null, r(e.row.reportQuantity ?? "-"), 1)]), _: 1 }), t(o, { key: "reportNetWeight", prop: "reportNetWeight", label: "上报总净重（kg）", align: "center", "show-overflow-tooltip": "" }, { default: n((e) => [l("span", null, r(e.row.reportNetWeight ?? "-"), 1)]), _: 1 }), t(o, { key: "userName", prop: "userName", label: "上报人", align: "center", "show-overflow-tooltip": "", "min-width": "120" }, { default: n((e) => [l("span", null, r(e.row.userName || "-"), 1)]), _: 1 }), t(o, { label: "操作", align: "center", "min-width": "100", fixed: "right" }, { default: n((e) => [a(I)(a(g).detail) ? (c(), y(k, { key: 0, size: "default", icon: "el-icon-view", type: "primary", onClick: (i) => b(e.row) }, null, 8, ["onClick"])) : Q("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[N, a(s).loading]]), t(a(W), { modelValue: p.value, "onUpdate:modelValue": _[0] || (_[0] = (e) => p.value = e), detailInfo: d.value }, null, 8, ["modelValue", "detailInfo"])]);
  };
} };
export {
  L as default
};
