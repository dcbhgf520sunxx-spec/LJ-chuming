import { ref as d } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as b } from "vue";
import { createBlock as h } from "vue";
import { withCtx as l } from "vue";
import { createVNode as o } from "vue";
import { unref as a } from "vue";
import { withDirectives as N } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as n } from "vue";
import { createTextVNode as P } from "vue";
import { withModifiers as Q } from "vue";
import { isRef as L } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTag as W } from "element-plus";
import { vLoading as q } from "element-plus";
import { c as z } from "../../../../../modules/wage-adjustment-585903f7.js";
import { _ as I, u as O, x as $, o as G, p6 as F, p as g, ib as k, P as J } from "../../../../../shared/runtime.js";
import K from "./module/header.vue.js";
import X from "../wage-modification/index.vue.js";
import Y from "./module/detail.vue.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
import "../../../../../modules/index-7da9f094.js";
import "../../../../../modules/use-users-4d979987.js";
import "../wage-modification/module/header.vue.js";
import "../wage-modification/module/initiate-approval.vue.js";
import "../../../../../modules/use-production-team-d8043fd6.js";
const Z = { __name: "index", props: { visible: { type: Boolean, default: false }, projectData: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(x, { emit: T }) {
  const f = T, V = x, { visible: m, handleClose: w } = O({ emit: f, props: V, field: "visible", showHook: D, closeHook: R }), _ = d(), v = d(), c = d(false), { crud: i } = $({ title: "工价调整", crudApi: { ...z }, sort: ["id.desc"], queryOnPresenterCreated: false, hasPagination: true }, _), { maxHeight: C } = G({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"] }, () => v.value.loaded);
  function D() {
    i.toQuery();
  }
  function U() {
    c.value = true;
  }
  function j() {
    i.refresh();
  }
  function R() {
    f("refresh");
  }
  return (ee, p) => {
    const r = M, E = W, A = u("common-button"), B = u("common-table"), S = u("common-drawer"), H = q;
    return b(), h(S, { "append-to-body": "", ref_key: "drawerRef", ref: v, "with-header": false, modelValue: a(m), "onUpdate:modelValue": p[1] || (p[1] = (e) => L(m) ? m.value = e : null), "before-close": a(w), size: "100%" }, { content: l(() => [o(a(K), { onClose: a(w), onToAdd: U }, null, 8, ["onClose"]), N((b(), h(B, { ref_key: "tableRef", ref: _, data: a(i).data, "empty-text": a(i).emptyText, "show-empty-symbol": false, "max-height": a(C), style: { width: "100%" } }, { default: l(() => [o(r, { label: "序号", type: "index", align: "center", width: "60" }), o(r, { key: "project", prop: "project", "show-overflow-tooltip": "", label: "项目", align: "center" }, { default: l((e) => {
      var t, y;
      return [s("span", null, n(((t = e.row.project) == null ? void 0 : t.serialNumber) || "-") + " - " + n(((y = e.row.project) == null ? void 0 : y.shortName) || "-"), 1)];
    }), _: 1 }), o(r, { key: "monomer", prop: "monomer", "show-overflow-tooltip": "", label: "单体", align: "center" }, { default: l((e) => {
      var t;
      return [s("span", null, n(((t = e.row.monomer) == null ? void 0 : t.name) || "-"), 1)];
    }), _: 1 }), o(r, { key: "productTypeEnum", prop: "productTypeEnum", "show-overflow-tooltip": "", label: "类型", align: "center" }, { default: l((e) => [s("span", null, n(a(F).VL[e.row.productTypeEnum] || "-"), 1)]), _: 1 }), o(r, { key: "totalQuantity", prop: "totalQuantity", "show-overflow-tooltip": "", label: "数量", align: "center" }, { default: l((e) => [s("span", null, n(e.row.totalQuantity || "-"), 1)]), _: 1 }), o(r, { key: "totalWeight", prop: "totalWeight", "show-overflow-tooltip": "", label: "重量（kg）", align: "center" }, { default: l((e) => [s("span", null, n(e.row.totalWeight || "-"), 1)]), _: 1 }), o(r, { key: "process", prop: "process", "show-overflow-tooltip": "", label: "工序", align: "center" }, { default: l((e) => {
      var t;
      return [s("span", null, n(((t = e.row.process) == null ? void 0 : t.name) || "-"), 1)];
    }), _: 1 }), o(r, { key: "createUser", prop: "createUser", "show-overflow-tooltip": "", label: "创建人", align: "center" }, { default: l((e) => {
      var t;
      return [s("span", null, n(((t = e.row.createUser) == null ? void 0 : t.name) || "-"), 1)];
    }), _: 1 }), o(r, { key: "createTime", prop: "createTime", "show-overflow-tooltip": "", label: "创建日期", align: "center" }, { default: l((e) => [s("span", null, n(e.row.createTime ? a(g)(e.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), o(r, { key: "approveUser", prop: "approveUser", "show-overflow-tooltip": "", label: "审核人", align: "center" }, { default: l((e) => {
      var t;
      return [s("span", null, n(((t = e.row.approveUser) == null ? void 0 : t.name) || "-"), 1)];
    }), _: 1 }), o(r, { key: "approveDate", prop: "approveDate", "show-overflow-tooltip": "", label: "审核日期", align: "center" }, { default: l((e) => [s("span", null, n(e.row.approveDate ? a(g)(e.row.approveDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), o(r, { key: "approvalStatus", prop: "approvalStatus", "show-overflow-tooltip": "", label: "状态", align: "center" }, { default: l((e) => {
      var t;
      return [o(E, { type: (t = a(k).V[e.row.approvalStatus]) == null ? void 0 : t.TAG, effect: "plain" }, { default: l(() => [P(n(a(k).VL[e.row.approvalStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 }), o(r, { label: "操作", align: "center", fixed: "right" }, { default: l((e) => [o(A, { icon: "el-icon-view", type: "primary", size: "default", onClick: Q((t) => a(i).toDetail(e.row), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[H, a(i).loading]]), o(a(J)), o(Y), o(a(X), { visible: c.value, "onUpdate:visible": p[0] || (p[0] = (e) => c.value = e), onRefresh: j }, null, 8, ["visible"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, we = I(Z, [["__scopeId", "data-v-7656948a"]]);
export {
  we as default
};
