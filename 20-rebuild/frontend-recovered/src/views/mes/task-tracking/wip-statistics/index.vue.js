import { ref as i } from "vue";
import { provide as U } from "vue";
import { resolveComponent as O } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as f } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as n } from "vue";
import { withDirectives as F } from "vue";
import { unref as s } from "vue";
import { createBlock as k } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as W } from "vue";
import { withModifiers as x } from "vue";
import { Fragment as M } from "vue";
import { renderList as H } from "vue";
import { ElTableColumn as q } from "element-plus";
import { vLoading as K } from "element-plus";
import { c as Q } from "../../../../modules/wip-statistics-f9d24ea0.js";
import { x as z, rT as V, o as G, a3 as E, aU as J, P as X } from "../../../../shared/runtime.js";
import { u as Y } from "../../../../modules/use-process-af1f8c99.js";
import Z from "./module/header.vue.js";
import ee from "./module/out-bound-detail.vue.js";
import te from "./module/task-detail.vue.js";
import ae from "./module/process-detail.vue.js";
const se = { class: "app-container" }, oe = { class: "head-container" }, ne = ["onClick"], ie = ["onClick"], re = ["onClick"], le = { class: "tc-danger" }, ce = { class: "tc-danger" }, pe = { key: 1 }, xe = { __name: "index", setup(de) {
  const B = { add: false, edit: false, del: false, download: false }, y = i(), g = i(false), w = i({}), h = i(false), C = i({}), v = i(false), N = i({}), T = i({}), { crud: b, CRUD: P, columns: R } = z({ title: "在制品统计", sort: [], optShow: { ...B }, permission: { ...V }, crudApi: { ...Q }, hasPagination: true }, y), { maxHeight: S } = G({ extraBox: [".head-container"], paginate: true });
  U("permission", V);
  const { loaded: $, process: j } = Y();
  function A(l) {
    g.value = true, w.value = l;
  }
  function I(l) {
    h.value = true, C.value = l;
  }
  function L(l, t) {
    v.value = true, N.value = t, T.value = l;
  }
  return P.HOOK.handleRefresh = (l, t) => {
    var o;
    t.data.content = (o = t.data.content) == null ? void 0 : o.map((p) => (p.processMap = {}, p.processDTOList.forEach((_) => {
      p.processMap[_.id] = _;
    }), p));
  }, (l, t) => {
    const o = q, p = O("common-table"), _ = K;
    return r(), f("div", se, [c("div", oe, [n(Z)]), F((r(), k(p, { ref_key: "tableRef", ref: y, data: s(b).data, "empty-text": s(b).emptyText, "max-height": s(S), "row-key": "projectId", style: { width: "100%" } }, { default: m(() => [n(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index", fixed: "left" }), s(R).visible("project") ? (r(), k(o, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", width: "200px", fixed: "left" }, { default: m((e) => {
      var a, d;
      return [c("span", null, u((a = e.row.project) == null ? void 0 : a.serialNumber) + "-" + u((d = e.row.project) == null ? void 0 : d.name), 1)];
    }), _: 1 })) : W("", true), n(o, { prop: "unit", key: "unit", label: "单位", align: "center", fixed: "left" }), n(o, { prop: "rawNetWeight", key: "rawNetWeight", label: "原材料出库量", align: "center", fixed: "left", width: "140" }, { default: m(({ row: e }) => {
      var a;
      return [c("span", { onClick: x((d) => A(e), ["stop"]), style: { cursor: "pointer" }, class: "tc-danger" }, u((a = e.rawNetWeight) == null ? void 0 : a.toFixed(2)), 9, ne)];
    }), _: 1 }), n(o, { prop: "taskNetWeight", key: "taskNetWeight", label: "任务量", align: "center", fixed: "left", width: "140" }, { default: m(({ row: e }) => [c("span", { onClick: x((a) => I(e), ["stop"]), style: { cursor: "pointer" }, class: "tc-danger" }, u(e.taskNetWeight), 9, ie)]), _: 1 }), (r(true), f(M, null, H(s(j), (e) => (r(), f(M, { key: e.id }, [e.productType & s(E).ARTIFACT.V | e.productType & s(E).ASSEMBLE.V && e.productionLineTypeEnum & s(J).TRADITION.V ? (r(), k(o, { key: 0, label: e.name, align: "center", width: "110px" }, { default: m(({ row: a }) => {
      var d, D;
      return [a.processMap[e.id] ? (r(), f("span", { key: 0, style: { cursor: "pointer" }, onClick: x((ue) => L(a, e), ["stop"]) }, [c("span", le, u((d = a.processMap[e.id]) == null ? void 0 : d.unQuantity), 1), t[3] || (t[3] = c("span", null, " / ", -1)), c("span", ce, u((D = a.processMap[e.id]) == null ? void 0 : D.unNetWeight), 1)], 8, re)) : (r(), f("span", pe, " / "))];
    }), _: 2 }, 1032, ["label"])) : W("", true)], 64))), 128)), n(o, { prop: "totalNetWeight", key: "totalNetWeight", label: "合计", align: "center", width: "140", fixed: "right" })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[_, s(b).loading || !s($)]]), n(s(X)), n(ee, { visible: g.value, "onUpdate:visible": t[0] || (t[0] = (e) => g.value = e), info: w.value }, null, 8, ["visible", "info"]), n(te, { visible: h.value, "onUpdate:visible": t[1] || (t[1] = (e) => h.value = e), "task-info": C.value }, null, 8, ["visible", "task-info"]), n(ae, { visible: v.value, "onUpdate:visible": t[2] || (t[2] = (e) => v.value = e), "process-info": N.value, "process-data": T.value }, null, 8, ["visible", "process-info", "process-data"])]);
  };
} };
export {
  xe as default
};
