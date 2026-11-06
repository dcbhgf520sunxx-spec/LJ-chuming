import { computed as I } from "vue";
import { ref as f } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as r } from "vue";
import { unref as t } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as a } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as n } from "vue";
import { createTextVNode as q } from "vue";
import { toDisplayString as x } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElTag as O } from "element-plus";
import { vLoading as z } from "element-plus";
import { _ as A, D as F, x as M, BB as g, BC as W, o as $, cO as G, jl as J, p as b, pB as k, G as K, z as Y } from "../../../../../shared/runtime.js";
import Q from "./module/header.vue.js";
import X from "./module/list/index.vue.js";
import "./module/list/module/header.vue.js";
import "../../../../../modules/material-inventory-71cd4559.js";
import "./module/list/module/detail.vue.js";
const Z = { class: "app-container" }, ee = { __name: "index", setup(te) {
  const C = { add: false, edit: false, del: false, download: false }, T = I(() => [["amountExcludingVat", ["to-thousand", F.YUAN]], ["project", "parse-project"]]), y = f(), u = f(false), m = f({}), { crud: _, CRUD: j, columns: s } = M({ title: "存货转换单报表", sort: [], permission: { ...g }, optShow: { ...C }, crudApi: { get: W }, hasPagination: false, dataPath: "" }, y), { maxHeight: V } = $({ paginate: true, extraHeight: 40 });
  function R(c) {
    m.value = c == null ? void 0 : c.sourceRow, u.value = true;
  }
  return j.HOOK.handleRefresh = async (c, { data: i }) => {
    await G(i), i = await J(i, { toSmallest: false, toNum: true }), i.forEach((e) => {
      var d;
      e.date = e.startTime && e.endTime ? b(e.startTime, "{y}-{m}-{d}") + "~" + b(e.endTime, "{y}-{m}-{d}") : void 0, e.projectWarehouseType = (d = e.project) != null && d.id ? k.PROJECT.V : k.PUBLIC.V;
    });
  }, (c, i) => {
    const e = H, d = h("common-button"), B = h("common-table"), E = O, D = h("common-drawer"), N = S("permission"), P = z;
    return o(), U("div", Z, [r(t(Q)), w((o(), a(B, { ref_key: "tableRef", ref: y, data: t(_).data, "data-format": T.value, "empty-text": t(_).emptyText, "max-height": t(V), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", stripe: false }, { default: p(() => {
      var l;
      return [r(e, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), t(s).visible("project") ? (o(), a(e, { key: "project", prop: "project", label: "项目名称", align: "left", "min-width": "150", "show-overflow-tooltip": "" })) : n("", true), t(s).visible("classifyName") ? (o(), a(e, { key: "classifyName", prop: "classifyName", label: "物料名称", align: "center", "show-overflow-tooltip": "", width: "100" })) : n("", true), t(s).visible("quantity") ? (o(), a(e, { key: "quantity", prop: "quantity", label: "转换总长度(m)", align: "right", "show-overflow-tooltip": "" })) : n("", true), t(s).visible("mete") ? (o(), a(e, { key: "mete", prop: "mete", label: "转换总重(kg)", align: "right", "show-overflow-tooltip": "" })) : n("", true), t(s).visible("amountExcludingVat") ? (o(), a(e, { key: "amountExcludingVat", prop: "amountExcludingVat", label: "转换总金额(不含税)", align: "right", "show-overflow-tooltip": "" })) : n("", true), t(s).visible("date") ? (o(), a(e, { key: "date", prop: "date", label: "转化时间", align: "center", "show-overflow-tooltip": "", "min-width": "150" })) : n("", true), t(K)([...(l = t(g).list) == null ? void 0 : l.get]) ? (o(), a(e, { key: 6, label: "操作", width: "80px", align: "center" }, { default: p((L) => {
        var v;
        return [w(r(d, { icon: "el-icon-view", type: "primary", size: "default", onClick: (oe) => R(L.row) }, null, 8, ["onClick"]), [[N, (v = t(g).list) == null ? void 0 : v.get]])];
      }), _: 1 })) : n("", true)];
    }), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[P, t(_).loading]]), r(D, { title: "条板转换列表", modelValue: u.value, "onUpdate:modelValue": i[0] || (i[0] = (l) => u.value = l), size: "95%" }, { titleAfter: p(() => [r(E, null, { default: p(() => {
      var l;
      return [q(x((l = m.value.project) != null && l.id ? "项目：" + t(Y)(m.value.project) : "公共库") + x(), 1)];
    }), _: 1 })]), content: p(() => [r(t(X), { showType: "coilPlate", currentInfo: m.value }, null, 8, ["currentInfo"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, pe = A(ee, [["__scopeId", "data-v-9cc4cac5"]]);
export {
  pe as default
};
