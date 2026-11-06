import { ref as l } from "vue";
import { provide as R } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as U } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as n } from "vue";
import { withDirectives as H } from "vue";
import { unref as r } from "vue";
import { createBlock as C } from "vue";
import { withCtx as p } from "vue";
import { toDisplayString as a } from "vue";
import { createCommentVNode as I } from "vue";
import { withModifiers as v } from "vue";
import { ElTableColumn as M } from "element-plus";
import { vLoading as T } from "element-plus";
import { c as W } from "../../../../modules/wip-statistics-f9d24ea0.js";
import { x as A, rS as w, o as E, P as O } from "../../../../shared/runtime.js";
import q from "./module/header.vue.js";
import F from "./module/task-mete.vue.js";
import K from "./module/production-mete.vue.js";
import L from "./module/picking-mete.vue.js";
const z = { class: "app-container" }, G = { class: "head-container" }, J = ["onClick"], X = { class: "tc-danger" }, Y = { class: "tc-danger" }, Z = ["onClick"], tt = { class: "tc-danger" }, et = { class: "tc-danger" }, it = ["onClick"], nt = { class: "tc-danger" }, ot = { class: "tc-danger" }, ft = { __name: "index", setup(at) {
  const D = { add: false, edit: false, del: false, download: false }, k = l(), d = l(false), b = l({}), u = l(false), y = l({}), f = l(false), h = l({}), { crud: m, CRUD: Q, columns: N } = A({ title: "半成品统计", sort: [], optShow: { ...D }, permission: { ...w }, crudApi: { ...W }, hasPagination: true }, k);
  R("permission", w);
  const { maxHeight: $ } = E({ extraBox: [".head-container"], paginate: true });
  function j(s) {
    d.value = true, b.value = s;
  }
  function P(s) {
    u.value = true, y.value = s;
  }
  function V(s) {
    f.value = true, h.value = s;
  }
  return Q.HOOK.handleRefresh = (s, e) => {
    var o;
    e.data.content = (o = e.data.content) == null ? void 0 : o.map((g) => g);
  }, (s, e) => {
    const o = M, g = S("common-table"), B = T;
    return _(), U("div", z, [i("div", G, [n(q)]), H((_(), C(g, { ref_key: "tableRef", ref: k, data: r(m).data, "empty-text": r(m).emptyText, "show-empty-symbol": false, "max-height": r($), "row-key": "projectId", style: { width: "100%" } }, { default: p(() => [n(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index", fixed: "left" }), r(N).visible("project") ? (_(), C(o, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", width: "200px" }, { default: p((t) => {
      var c, x;
      return [i("span", null, a((c = t.row.project) == null ? void 0 : c.serialNumber) + "-" + a((x = t.row.project) == null ? void 0 : x.name), 1)];
    }), _: 1 })) : I("", true), n(o, { prop: "unit", key: "unit", label: "单位", align: "center" }), n(o, { prop: "taskQuantity", key: "taskQuantity", label: "任务量（件/kg）", align: "center" }, { default: p(({ row: t }) => [i("div", { onClick: v((c) => j(t), ["stop"]), style: { cursor: "pointer" } }, [i("span", X, a(t.taskQuantity), 1), e[3] || (e[3] = i("span", null, " / ", -1)), i("span", Y, a(t.taskNetWeight), 1)], 8, J)]), _: 1 }), n(o, { prop: "productionQuantity", key: "productionQuantity", label: "生产量（件/kg）", align: "center" }, { default: p(({ row: t }) => [i("div", { onClick: v((c) => P(t), ["stop"]), style: { cursor: "pointer" } }, [i("span", tt, a(t.productionQuantity), 1), e[4] || (e[4] = i("span", null, " / ", -1)), i("span", et, a(t.productionNetWeight), 1)], 8, Z)]), _: 1 }), n(o, { prop: "pickingQuantity", key: "pickingQuantity", label: "领料量（件/kg）", align: "center" }, { default: p(({ row: t }) => [i("div", { onClick: v((c) => V(t), ["stop"]), style: { cursor: "pointer" } }, [i("span", nt, a(t.pickingQuantity), 1), e[5] || (e[5] = i("span", null, " / ", -1)), i("span", ot, a(t.pickingNetWeight), 1)], 8, it)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[B, r(m).loading]]), n(r(O)), n(F, { visible: d.value, "onUpdate:visible": e[0] || (e[0] = (t) => d.value = t), info: b.value }, null, 8, ["visible", "info"]), n(K, { visible: u.value, "onUpdate:visible": e[1] || (e[1] = (t) => u.value = t), "production-info": y.value }, null, 8, ["visible", "production-info"]), n(L, { visible: f.value, "onUpdate:visible": e[2] || (e[2] = (t) => f.value = t), "pricking-info": h.value }, null, 8, ["visible", "pricking-info"])]);
  };
} };
export {
  ft as default
};
