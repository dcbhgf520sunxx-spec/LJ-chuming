import { ref as x } from "vue";
import { provide as V } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as N } from "vue";
import { unref as o } from "vue";
import { withDirectives as G } from "vue";
import { createBlock as r } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as _ } from "vue";
import { createCommentVNode as d } from "vue";
import { createTextVNode as K } from "vue";
import { ElTableColumn as q } from "element-plus";
import { vLoading as B } from "element-plus";
import { c as $ } from "../../../../../modules/production-statistics-0477fed6.js";
import { _ as F, x as H, pt as S, o as I, o8 as C, bs as l, D as c, c as f, G as j } from "../../../../../shared/runtime.js";
import z from "./module/header.vue.js";
import J from "./module/artifact-group-detail.vue.js";
import Q from "./module/enclosure-group-detail.vue.js";
import "./module/artifact-detail.vue.js";
import "./module/enclosure-detail.vue.js";
const X = { class: "app-container" }, Y = { class: "head-container" }, Z = { class: "tc-success" }, ee = { class: "tc-success" }, te = { class: "tc-warning" }, oe = { class: "tc-warning" }, ne = { class: "tc-danger" }, ae = { class: "tc-danger" }, se = { __name: "index", setup(ie) {
  const T = { add: false, edit: false, del: false, download: false }, L = x(), { crud: g, columns: p, CRUD: W } = H({ title: "在制品统计", permission: { ...S }, optShow: { ...T }, crudApi: { ...$ }, dataPath: "", hasPagination: false }, L), { maxHeight: O } = I({ paginate: false });
  V("query", g.query);
  function U({ row: v, column: a, rowIndex: e, columnIndex: b }) {
    if ([4, 6, 8, 9].includes(b)) return e === 0 ? { rowspan: 2, colspan: 1 } : { rowspan: 0, colspan: 0 };
  }
  W.HOOK.handleRefresh = (v, a) => {
    if (v.query.productType === C.ARTIFACT.V) {
      const e = a.data.artifactAnalysis, b = l(e.surplusNetWeight, c.COM_WT__KG), h = l(e.taskNetWeight, c.COM_WT__KG), n = l(e.surplusNetWeight + e.taskNetWeight, c.COM_WT__KG), t = l(e.completeNetWeight, c.COM_WT__KG), m = l(e.inProductionNetWeight, c.COM_WT__KG), M = l(e.surplusNetWeight + e.taskNetWeight - e.completeNetWeight - e.inProductionNetWeight, c.COM_WT__KG), w = Number(t) && Number(n) ? l(t / n * 100, 2) + "%" : "0%", y = Number(m) && Number(n) ? l(m / n * 100, 2) + "%" : "0%", k = Number(M) && Number(n) ? l(M / n * 100, 2) + "%" : "0%";
      a.data = [{ beginMete: b, taskMete: h, totalMete: n, completeRate: w, inProductionRate: y, completeMete: t, inProductionMete: m, unProducedMete: M, unProducedRate: k }];
    }
    if (v.query.productType === C.ENCLOSURE.V) {
      const e = a.data.enclosureAnalysis, b = f(e.surplusLength, "mm", "m", c.MES_ENCLOSURE_L__M), h = f(e.taskLength, "mm", "m", c.MES_ENCLOSURE_L__M), n = f(e.surplusLength + e.taskLength, "mm", "m", c.MES_ENCLOSURE_L__M), t = f(e.completeLength, "mm", "m", c.MES_ENCLOSURE_L__M), m = f(e.inProductionLength, "mm", "m", c.MES_ENCLOSURE_L__M), M = f(e.surplusLength + e.taskLength - e.completeLength - e.inProductionLength, "mm", "m", c.MES_ENCLOSURE_L__M), w = Number(t) && Number(n) ? l(t / n * 100, 2) + "%" : "0%", y = Number(m) && Number(n) ? l(m / n * 100, 2) + "%" : "0%", k = Number(M) && Number(n) ? l(M / n * 100, 2) + "%" : "0%";
      a.data = [{ beginMete: b, taskMete: h, totalMete: n, completeRate: w, inProductionRate: y, completeMete: t, inProductionMete: m, unProducedMete: M, unProducedRate: k }];
    }
  };
  const P = x(false), R = x(false);
  function D() {
    g.query.productType === C.ARTIFACT.V ? P.value = true : R.value = true;
  }
  return (v, a) => {
    const e = q, b = E("common-button"), h = E("common-table"), n = B;
    return s(), A("div", X, [u("div", Y, [N(o(z))]), G((s(), r(h, { ref_key: "tableRef", ref: L, data: o(g).data, "empty-text": o(g).emptyText, "max-height": o(O), "span-method": U, stripe: false, style: { width: "100%" } }, { default: i(() => [o(p).visible("beginMete") ? (s(), r(e, { key: "beginMete", prop: "beginMete", label: "期初量", align: "center", "min-width": "70px" }, { default: i((t) => [u("span", null, _(t.row.beginMete), 1)]), _: 1 })) : d("", true), o(p).visible("taskMete") ? (s(), r(e, { key: "taskMete", prop: "taskMete", label: "本月分配", align: "center", "min-width": "70px" }, { default: i((t) => [u("span", null, _(t.row.taskMete), 1)]), _: 1 })) : d("", true), o(p).visible("totalMete") ? (s(), r(e, { key: "totalMete", prop: "totalMete", label: "总量", align: "center", "min-width": "70px" }, { default: i((t) => [u("span", null, _(t.row.totalMete), 1)]), _: 1 })) : d("", true), o(p).visible("completeMete") ? (s(), r(e, { key: "completeMete", prop: "completeMete", label: "已完成", align: "center", "min-width": "70px" }, { default: i((t) => [u("span", Z, _(t.row.completeMete), 1)]), _: 1 })) : d("", true), o(p).visible("completeRate") ? (s(), r(e, { key: "completeRate", prop: "completeRate", label: "完成率", align: "center", "min-width": "70px" }, { default: i((t) => [u("span", ee, _(t.row.completeRate), 1)]), _: 1 })) : d("", true), o(p).visible("inProductionMete") ? (s(), r(e, { key: "inProductionMete", prop: "inProductionMete", label: "在制品", align: "center", "min-width": "70px" }, { default: i((t) => [u("span", te, _(t.row.inProductionMete), 1)]), _: 1 })) : d("", true), o(p).visible("inProductionRate") ? (s(), r(e, { key: "inProductionRate", prop: "inProductionRate", label: "在制品率", align: "center", "min-width": "70px" }, { default: i((t) => [u("span", oe, _(t.row.inProductionRate), 1)]), _: 1 })) : d("", true), o(p).visible("unProducedMete") ? (s(), r(e, { key: "unProducedMete", prop: "unProducedMete", label: "未生产", align: "center", "min-width": "70px" }, { default: i((t) => [u("span", ne, _(t.row.unProducedMete), 1)]), _: 1 })) : d("", true), o(p).visible("unProducedRate") ? (s(), r(e, { key: "unProducedRate", prop: "unProducedRate", label: "未生产率", align: "center", "min-width": "70px" }, { default: i((t) => [u("span", ae, _(t.row.unProducedRate), 1)]), _: 1 })) : d("", true), o(j)(o(S).detail) ? (s(), r(e, { key: 9, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: i((t) => [N(b, { size: "default", type: "info", onClick: (m) => D(t.row) }, { default: i(() => a[2] || (a[2] = [K("查看")])), _: 2, __: [2] }, 1032, ["onClick"])]), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[n, o(g).loading]]), N(o(J), { visible: P.value, "onUpdate:visible": a[0] || (a[0] = (t) => P.value = t) }, null, 8, ["visible"]), N(o(Q), { visible: R.value, "onUpdate:visible": a[1] || (a[1] = (t) => R.value = t) }, null, 8, ["visible"])]);
  };
} }, be = F(se, [["__scopeId", "data-v-d68b0fb1"]]);
export {
  be as default
};
