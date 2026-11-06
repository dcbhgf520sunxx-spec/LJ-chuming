import { ref as g } from "vue";
import { computed as _ } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as h } from "vue";
import { createBlock as W } from "vue";
import { withCtx as r } from "vue";
import { createVNode as o } from "vue";
import { unref as l } from "vue";
import { createElementBlock as V } from "vue";
import { Fragment as z } from "vue";
import { withDirectives as E } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as c } from "vue";
import { withModifiers as F } from "vue";
import { createTextVNode as K } from "vue";
import { isRef as $ } from "vue";
import { ElTableColumn as G } from "element-plus";
import { vLoading as J } from "element-plus";
import { o as X, u as Y, x as Z, qg as ee, P as te } from "../../../../../shared/runtime.js";
import ae from "./module/header.vue.js";
import ne from "./module/initiate-approval.vue.js";
import "../../../../../modules/project-select-94bb5bbd.js";
import "../../../../../modules/use-production-team-d8043fd6.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
const oe = { key: 0, style: { color: "red" } }, fe = { __name: "index", props: { visible: { type: Boolean, default: false }, projectData: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(H, { emit: Q }) {
  const N = Q, I = H, k = g(), q = g(), { maxHeight: j } = X({ mainBox: ".wage-modification", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, paginate: true, clientHRepMainH: true }, () => q.value.loaded), n = g([]), y = g(false), A = _(() => n.value.length ? n.value.map((i) => i.id) : []), C = _(() => n.value.length ? n.value.reduce((i, a) => {
    const e = Number(a.quantity);
    return i + (isNaN(e) ? 0 : e);
  }, 0) : 0), D = _(() => n.value.length ? n.value.reduce((i, a) => {
    const e = Number(a.netWeight), d = Number(a.quantity);
    return isNaN(e) || isNaN(d) ? i : i + e * d;
  }, 0) : 0), { visible: b, handleClose: v } = Y({ emit: N, props: I, field: "visible", showHook: S, closeHook: T }), { crud: u, CRUD: L } = Z({ title: "工价修改", crudApi: { ...ee }, sort: [], requiredQuery: ["projectId", "monomerId"], queryOnPresenterCreated: false, hasPagination: true }, k);
  L.HOOK.handleRefresh = async (i, { data: a }) => {
    n.value = [], a.content = a.content.map((e) => {
      var d, p, m, f, t, w, R, B;
      return e.id = ((d = e == null ? void 0 : e.product) == null ? void 0 : d.id) || void 0, e.name = ((p = e == null ? void 0 : e.product) == null ? void 0 : p.name) || void 0, e.serialNumber = ((m = e == null ? void 0 : e.product) == null ? void 0 : m.serialNumber) || void 0, e.specification = ((f = e == null ? void 0 : e.product) == null ? void 0 : f.specification) || void 0, e.length = ((t = e == null ? void 0 : e.product) == null ? void 0 : t.length) || void 0, e.material = ((w = e == null ? void 0 : e.product) == null ? void 0 : w.material) || void 0, e.quantity = ((R = e == null ? void 0 : e.product) == null ? void 0 : R.quantity) || void 0, e.netWeight = ((B = e == null ? void 0 : e.product) == null ? void 0 : B.netWeight) || void 0, e;
    });
  };
  function O(i) {
    n.value.push(i);
  }
  function P(i) {
    if (n.value.length) {
      const a = n.value.findIndex((e) => {
        var d;
        return e.id === ((d = i.product) == null ? void 0 : d.id);
      });
      a > -1 && n.value.splice(a, 1);
    }
  }
  function S() {
    u.toQuery();
  }
  function T() {
    u.resetQuery(), n.value = [], N("refresh");
  }
  function U() {
    n.value.length < 1 || (y.value = true);
  }
  function M() {
    u.refresh();
  }
  return (i, a) => {
    const e = G, d = x("common-button"), p = x("common-table"), m = x("common-drawer"), f = J;
    return h(), W(m, { "append-to-body": "", ref_key: "drawerRef", ref: q, title: "工价修改", modelValue: l(b), "onUpdate:modelValue": a[1] || (a[1] = (t) => $(b) ? b.value = t : null), "before-close": l(v), size: "100%", "custom-class": "wage-modification" }, { content: r(() => [o(l(ae), { class: "head-container", addQuantity: C.value, totalBadge: n.value.length, onToCollect: U }, null, 8, ["addQuantity", "totalBadge"]), !l(u).query.projectId || !l(u).query.monomerId ? (h(), V("div", oe, "*请先选择项目和单体")) : (h(), V(z, { key: 1 }, [E((h(), W(p, { ref_key: "tableRef", ref: k, data: l(u).data, "empty-text": l(u).emptyText, "max-height": l(j), style: { width: "100%" } }, { default: r(() => [o(e, { label: "序号", type: "index", align: "center", width: "60" }), o(e, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "名称", align: "center" }, { default: r((t) => [s("span", null, c(t.row.name || "-"), 1)]), _: 1 }), o(e, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center" }, { default: r((t) => [s("span", null, c(t.row.serialNumber || "-"), 1)]), _: 1 }), o(e, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center" }, { default: r((t) => [s("span", null, c(t.row.specification || "-"), 1)]), _: 1 }), o(e, { key: "length", prop: "length", "show-overflow-tooltip": "", label: "长度(mm)", align: "center" }, { default: r((t) => [s("span", null, c(t.row.length || "-"), 1)]), _: 1 }), o(e, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "center" }, { default: r((t) => [s("span", null, c(t.row.material || "-"), 1)]), _: 1 }), o(e, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center", width: "100" }, { default: r((t) => [s("span", null, c(t.row.quantity || "-"), 1)]), _: 1 }), o(e, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": "", label: "单净重(kg)", align: "center" }, { default: r((t) => [s("span", null, c(t.row.netWeight || "-"), 1)]), _: 1 }), o(e, { label: "操作", align: "center", fixed: "right", width: "120" }, { default: r((t) => [o(d, { size: "default", type: "primary", disabled: A.value.includes(t.row.id), onClick: F((w) => O(t.row), ["stop"]) }, { default: r(() => a[2] || (a[2] = [K(" 添加 ")])), _: 2, __: [2] }, 1032, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[f, l(u).loading]]), o(l(te)), o(l(ne), { visible: y.value, "onUpdate:visible": a[0] || (a[0] = (t) => y.value = t), addList: n.value, addQuantity: C.value, addNetWeight: D.value, query: l(u).query, onRemoveRow: P, onSuccess: M }, null, 8, ["visible", "addList", "addQuantity", "addNetWeight", "query"])], 64))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  fe as default
};
