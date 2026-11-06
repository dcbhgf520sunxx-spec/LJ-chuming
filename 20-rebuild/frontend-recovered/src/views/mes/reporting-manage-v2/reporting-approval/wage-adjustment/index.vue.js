import { ref as c } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as b } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { unref as a } from "vue";
import { withDirectives as N } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as n } from "vue";
import { createTextVNode as P } from "vue";
import { withModifiers as Q } from "vue";
import { isRef as q } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElTag as M } from "element-plus";
import { vLoading as W } from "element-plus";
import { c as z } from "../../../../../modules/wage-adjustment-585903f7.js";
import { _ as I, u as O, x as $, o as G, p6 as F, p as g, ib as k, P as J, qf as K } from "../../../../../shared/runtime.js";
import X from "./module/header.vue.js";
import Y from "../wage-modification/index.vue.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
import "../../../../../modules/project-select-94bb5bbd.js";
import "../../../../../modules/index-7da9f094.js";
import "../../../../../modules/use-users-4d979987.js";
import "../wage-modification/module/header.vue.js";
import "../wage-modification/module/initiate-approval.vue.js";
import "../../../../../modules/use-production-team-d8043fd6.js";
const Z = { __name: "index", props: { visible: { type: Boolean, default: false }, projectData: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(x, { emit: T }) {
  const f = T, V = x, { visible: d, handleClose: w } = O({ emit: f, props: V, field: "visible", showHook: j, closeHook: R }), _ = c(), h = c(), m = c(false), { crud: s } = $({ title: "工价调整", crudApi: { ...z }, sort: ["id.desc"], queryOnPresenterCreated: false, hasPagination: true }, _), { maxHeight: C } = G({ mainBox: ".wage-adjustment", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"] }, () => h.value.loaded);
  function j() {
    s.toQuery();
  }
  function D() {
    m.value = true;
  }
  function U() {
    s.refresh();
  }
  function R() {
    f("refresh");
  }
  return (ee, p) => {
    const r = L, B = M, E = u("common-button"), A = u("common-table"), S = u("common-drawer"), H = W;
    return b(), y(S, { "append-to-body": "", ref_key: "drawerRef", ref: h, "with-header": false, modelValue: a(d), "onUpdate:modelValue": p[1] || (p[1] = (e) => q(d) ? d.value = e : null), "before-close": a(w), size: "100%", "custom-class": "wage-adjustment" }, { content: l(() => [t(a(X), { onClose: a(w), onToAdd: D }, null, 8, ["onClose"]), N((b(), y(A, { ref_key: "tableRef", ref: _, data: a(s).data, "empty-text": a(s).emptyText, "show-empty-symbol": false, "max-height": a(C), style: { width: "100%" } }, { default: l(() => [t(r, { label: "序号", type: "index", align: "center", width: "60" }), t(r, { key: "project", prop: "project", "show-overflow-tooltip": "", label: "项目", align: "center", "min-width": "200" }, { default: l((e) => {
      var o, v;
      return [i("span", null, n(((o = e.row.project) == null ? void 0 : o.serialNumber) || "-") + " - " + n(((v = e.row.project) == null ? void 0 : v.shortName) || "-"), 1)];
    }), _: 1 }), t(r, { key: "monomer", prop: "monomer", "show-overflow-tooltip": "", label: "单体", align: "center" }, { default: l((e) => {
      var o;
      return [i("span", null, n(((o = e.row.monomer) == null ? void 0 : o.name) || "-"), 1)];
    }), _: 1 }), t(r, { key: "productTypeEnum", prop: "productTypeEnum", "show-overflow-tooltip": "", label: "类型", align: "center", width: "100" }, { default: l((e) => [i("span", null, n(a(F).VL[e.row.productTypeEnum] || "-"), 1)]), _: 1 }), t(r, { key: "totalQuantity", prop: "totalQuantity", "show-overflow-tooltip": "", label: "数量", align: "center", width: "100" }, { default: l((e) => [i("span", null, n(e.row.totalQuantity || "-"), 1)]), _: 1 }), t(r, { key: "totalWeight", prop: "totalWeight", "show-overflow-tooltip": "", label: "重量（kg）", align: "center", width: "100" }, { default: l((e) => [i("span", null, n(e.row.totalWeight || "-"), 1)]), _: 1 }), t(r, { key: "process", prop: "process", "show-overflow-tooltip": "", label: "工序", align: "center", width: "100" }, { default: l((e) => {
      var o;
      return [i("span", null, n(((o = e.row.process) == null ? void 0 : o.name) || "-"), 1)];
    }), _: 1 }), t(r, { key: "createUser", prop: "createUser", "show-overflow-tooltip": "", label: "创建人", align: "center", width: "100" }, { default: l((e) => {
      var o;
      return [i("span", null, n(((o = e.row.createUser) == null ? void 0 : o.name) || "-"), 1)];
    }), _: 1 }), t(r, { key: "createTime", prop: "createTime", "show-overflow-tooltip": "", label: "创建日期", align: "center", width: "100" }, { default: l((e) => [i("span", null, n(e.row.createTime ? a(g)(e.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), t(r, { key: "approveUser", prop: "approveUser", "show-overflow-tooltip": "", label: "审核人", align: "center", width: "100" }, { default: l((e) => {
      var o;
      return [i("span", null, n(((o = e.row.approveUser) == null ? void 0 : o.name) || "-"), 1)];
    }), _: 1 }), t(r, { key: "approveDate", prop: "approveDate", "show-overflow-tooltip": "", label: "审核日期", align: "center", width: "100" }, { default: l((e) => [i("span", null, n(e.row.approveDate ? a(g)(e.row.approveDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), t(r, { key: "approvalStatus", prop: "approvalStatus", "show-overflow-tooltip": "", label: "状态", align: "center", width: "100" }, { default: l((e) => {
      var o;
      return [t(B, { type: (o = a(k).V[e.row.approvalStatus]) == null ? void 0 : o.TAG, effect: "plain" }, { default: l(() => [P(n(a(k).VL[e.row.approvalStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 }), t(r, { label: "操作", align: "center", fixed: "right", width: "100" }, { default: l((e) => [t(E, { icon: "el-icon-view", type: "primary", size: "default", onClick: Q((o) => a(s).toDetail(e.row), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[H, a(s).loading]]), t(a(J)), t(K), t(a(Y), { visible: m.value, "onUpdate:visible": p[0] || (p[0] = (e) => m.value = e), onRefresh: U }, null, 8, ["visible"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, we = I(Z, [["__scopeId", "data-v-c6528b9c"]]);
export {
  we as default
};
