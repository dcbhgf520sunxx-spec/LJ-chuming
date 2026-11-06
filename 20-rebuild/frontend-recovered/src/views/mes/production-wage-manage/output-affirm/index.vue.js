import { ref as d } from "vue";
import { provide as w } from "vue";
import { computed as b } from "vue";
import { watch as l } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as N } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as a } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as D } from "vue";
import { withDirectives as j } from "vue";
import { unref as s } from "vue";
import { createBlock as q } from "vue";
import { ElTag as S } from "element-plus";
import { ElTableColumn as P } from "element-plus";
import { vLoading as T } from "element-plus";
import { c as B, _ as I } from "./module/header.vue.js";
import { _ as R, o as E, x as H, p$ as L, P as M } from "../../../../shared/runtime.js";
import Q from "./project-detail/index.vue.js";
import "./project-detail/module/header.vue.js";
const V = { class: "app-container" }, A = { style: { display: "flex" } }, $ = { style: { "min-width": "24%" } }, z = { class: "head-container" }, U = { __name: "index", setup(F) {
  const _ = { add: false, edit: false, del: false, download: false }, c = d(), o = d({}), { maxHeight: m } = E({ paginate: true, extraHeight: "40px" }), { crud: t } = H({ title: "产量确认", optShow: { ..._ }, permission: { ...L }, crudApi: { ...B }, hasPagination: true }, c);
  w("query", t.query);
  const f = b(() => t.data.reduce((e, n) => e + n.totalQuantity, 0));
  l(() => t.query.yearMonthDaySelect, (e) => {
    e && (o.value = {});
  }), l(() => t.query.selectedDate, (e) => {
    e && (o.value = {});
  }), l(() => t.query.processId, (e) => {
    e && (o.value = {});
  }), l(() => t.query.workshopId, (e) => {
    e && (o.value = {});
  });
  const h = (e) => {
    o.value = e;
  };
  function y() {
    t.refresh();
  }
  return (e, n) => {
    const g = S, r = P, x = k("common-table"), v = T;
    return p(), N("div", V, [i("div", A, [i("div", $, [i("div", z, [a(I)]), a(g, { effect: "plain", size: "large", type: "danger", style: { "margin-bottom": "10px" } }, { default: u(() => [C("未审核：" + D(f.value), 1)]), _: 1 }), j((p(), q(x, { ref_key: "tableRef", ref: c, data: s(t).data, "empty-text": s(t).emptyText, "max-height": s(m), "highlight-current-row": "", "row-key": "projectId", class: "table", onRowClick: h }, { default: u(() => [a(r, { label: "车间", prop: "workshopName", key: "workshopName", align: "center", width: "120px" }), a(r, { label: "工序", prop: "processName", key: "processName", align: "center" }), a(r, { label: "姓名", prop: "teamLeaderName", key: "teamLeaderName", align: "center" }), a(r, { label: "件数", prop: "totalQuantity", key: "totalQuantity", align: "center" })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[v, s(t).loading]]), a(s(M))]), n[0] || (n[0] = i("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px" } }, null, -1)), a(Q, { "project-data": o.value, style: { flex: "1" }, onSuccess: y }, null, 8, ["project-data"])])]);
  };
} }, X = R(U, [["__scopeId", "data-v-a33c5d78"]]);
export {
  X as default
};
