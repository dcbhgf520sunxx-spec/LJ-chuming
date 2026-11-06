import { ref as _ } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as w } from "vue";
import { unref as o } from "vue";
import { withDirectives as M } from "vue";
import { createBlock as r } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as c } from "vue";
import { Fragment as N } from "vue";
import { renderList as H } from "vue";
import { createTextVNode as O } from "vue";
import { ElTableColumn as U } from "element-plus";
import { ElTooltip as $ } from "element-plus";
import { vLoading as j } from "element-plus";
import { c as F, _ as z } from "./module/detail.vue.js";
import { x as G, mW as C, o as K, a3 as W, G as J } from "../../../../shared/runtime.js";
import { u as Q } from "../../../../modules/use-process-af1f8c99.js";
import X from "./module/header.vue.js";
import "../../../../modules/factory-select-b8d0a4ac.js";
const Y = { class: "app-container" }, Z = { class: "head-container" }, ee = { class: "tc-danger" }, te = { key: 1 }, ae = { class: "tc-primary" }, de = { __name: "index", setup(oe) {
  const D = { add: false, edit: false, del: false, download: false }, y = _(), { crud: p, columns: b, CRUD: T } = G({ title: "", sort: [], dataPath: "", permission: { ...C }, optShow: { ...D }, crudApi: { ...F }, hasPagination: false }, y), { maxHeight: L } = K({ paginate: true });
  function q({ row: i, column: t, rowIndex: e, columnIndex: m }) {
    if (m === 1) return e > 0 && p.data[e].workshopId === p.data[e - 1].workshopId ? { rowspan: 0, colspan: 0 } : { rowspan: i.rowspan, colspan: 1 };
  }
  const u = _({});
  T.HOOK.handleRefresh = (i, t) => {
    u.value = {}, t.data = t.data.map((e, m) => (e.passRate = e.passRate ? e.passRate + "%" : e.passRate, e.rowspan = I(t.data, e.workshopId), e));
  };
  function I(i, t) {
    return u.value[t] || (u.value[t] = i.filter((e) => e.workshopId === t).length), u.value[t];
  }
  const { loaded: P, process: V } = Q(), x = _(false), k = _({});
  function S(i) {
    x.value = true, k.value = i;
  }
  return (i, t) => {
    const e = U, m = $, A = R("common-button"), B = R("common-table"), E = j;
    return s(), h("div", Y, [n("div", Z, [w(o(X))]), M((s(), r(B, { ref_key: "tableRef", ref: y, data: o(p).data, "empty-text": o(p).emptyText, "max-height": o(L), stripe: false, "span-method": q, style: { width: "100%" } }, { default: l(() => [w(e, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), o(b).visible("workshopName") ? (s(), r(e, { key: 0, "show-overflow-tooltip": true, align: "center", prop: "workshopName", label: "车间", "min-width": "120px", fixed: "left" }, { default: l(({ row: a }) => [n("span", null, d(a.workshopName), 1)]), _: 1 })) : c("", true), o(b).visible("productionLineName") ? (s(), r(e, { key: 1, "show-overflow-tooltip": true, align: "center", prop: "productionLineName", label: "生产线", "min-width": "120px", fixed: "left" }, { default: l(({ row: a }) => [n("span", null, d(a.productionLineName), 1)]), _: 1 })) : c("", true), (s(true), h(N, null, H(o(V), (a) => (s(), h(N, { key: a.id }, [a.productType & o(W).ARTIFACT.V ? (s(), r(e, { key: 0, label: a.name, align: "center", width: "110px" }, { default: l(({ row: f }) => [f.processData[a.id] ? (s(), r(m, { key: 0, content: "不合格数 / 检验数", placement: "top" }, { default: l(() => {
      var g, v;
      return [n("span", null, [n("span", ee, d((g = f.processData[a.id]) == null ? void 0 : g.unqualifiedNumber), 1), t[1] || (t[1] = n("span", null, " / ", -1)), n("span", null, d((v = f.processData[a.id]) == null ? void 0 : v.totalNumberInspection), 1)])];
    }), _: 2 }, 1024)) : (s(), h("span", te, " \\ "))]), _: 2 }, 1032, ["label"])) : c("", true)], 64))), 128)), o(b).visible("passRate") ? (s(), r(e, { key: 2, "show-overflow-tooltip": true, align: "center", prop: "passRate", label: "通过率", width: "100px", fixed: "right" }, { default: l(({ row: a }) => [n("span", ae, d(a.passRate), 1)]), _: 1 })) : c("", true), o(J)(o(C).detail) ? (s(), r(e, { key: 3, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: l(({ row: a }) => [w(A, { size: "default", type: "primary", onClick: (f) => S(a) }, { default: l(() => t[2] || (t[2] = [O("查看")])), _: 2, __: [2] }, 1032, ["onClick"])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[E, o(p).loading || !o(P)]]), w(o(z), { visible: x.value, "onUpdate:visible": t[0] || (t[0] = (a) => x.value = a), info: k.value, query: o(p).query }, null, 8, ["visible", "info", "query"])]);
  };
} };
export {
  de as default
};
