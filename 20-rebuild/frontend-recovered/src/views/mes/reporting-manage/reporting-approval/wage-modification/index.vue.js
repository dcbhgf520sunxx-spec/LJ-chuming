import { ref as g } from "vue";
import { computed as _ } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as h } from "vue";
import { createBlock as V } from "vue";
import { withCtx as r } from "vue";
import { createVNode as l } from "vue";
import { unref as i } from "vue";
import { createElementBlock as W } from "vue";
import { Fragment as E } from "vue";
import { withDirectives as v } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as c } from "vue";
import { withModifiers as F } from "vue";
import { createTextVNode as K } from "vue";
import { isRef as $ } from "vue";
import { ElTableColumn as G } from "element-plus";
import { vLoading as J } from "element-plus";
import { o as X, u as Y, x as Z, qg as ee, P as te } from "../../../../../shared/runtime.js";
import ae from "./module/header.vue.js";
import oe from "./module/initiate-approval.vue.js";
import "../../../../../modules/use-production-team-d8043fd6.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
const ne = { key: 0, style: { color: "red" } }, fe = { __name: "index", props: { visible: { type: Boolean, default: false }, projectData: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(H, { emit: Q }) {
  const k = Q, I = H, q = g(), C = g(), { maxHeight: j } = X({ mainBox: ".wage-modification", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, paginate: true, clientHRepMainH: true }, C), o = g([]), y = g(false), A = _(() => o.value.length ? o.value.map((n) => n.id) : []), R = _(() => {
    let n = 0;
    return o.value.length && (n = o.value.reduce((a, e) => a + +e.quantity, 0)), n;
  }), D = _(() => {
    let n = 0;
    return o.value.length && (n = o.value.reduce((a, e) => a + +e.netWeight, 0)), n;
  }), { visible: b, handleClose: L } = Y({ emit: k, props: I, field: "visible", showHook: T, closeHook: U }), { crud: d, columns: le, CRUD: O } = Z({ title: "工价修改", crudApi: { ...ee }, sort: [], requiredQuery: ["projectId", "monomerId"], queryOnPresenterCreated: false, hasPagination: true }, q);
  O.HOOK.handleRefresh = async (n, { data: a }) => {
    o.value = [], a.content = a.content.map((e) => {
      var u, p, m, f, t, w, N, B;
      return e.id = ((u = e == null ? void 0 : e.product) == null ? void 0 : u.id) || void 0, e.name = ((p = e == null ? void 0 : e.product) == null ? void 0 : p.name) || void 0, e.serialNumber = ((m = e == null ? void 0 : e.product) == null ? void 0 : m.serialNumber) || void 0, e.specification = ((f = e == null ? void 0 : e.product) == null ? void 0 : f.specification) || void 0, e.length = ((t = e == null ? void 0 : e.product) == null ? void 0 : t.length) || void 0, e.material = ((w = e == null ? void 0 : e.product) == null ? void 0 : w.material) || void 0, e.quantity = ((N = e == null ? void 0 : e.product) == null ? void 0 : N.quantity) || void 0, e.netWeight = ((B = e == null ? void 0 : e.product) == null ? void 0 : B.netWeight) || void 0, e;
    });
  };
  function P(n) {
    o.value.push(n);
  }
  function S(n) {
    if (o.value.length) {
      const a = o.value.findIndex((e) => {
        var u;
        return e.id === ((u = n.product) == null ? void 0 : u.id);
      });
      a > -1 && o.value.splice(a, 1);
    }
  }
  function T() {
    d.toQuery();
  }
  function U() {
    d.resetQuery(), o.value = [], k("refresh");
  }
  function M() {
    o.value.length < 1 || (y.value = true);
  }
  function z() {
    d.refresh();
  }
  return (n, a) => {
    const e = G, u = x("common-button"), p = x("common-table"), m = x("common-drawer"), f = J;
    return h(), V(m, { class: "wage-modification", "append-to-body": "", ref_key: "drawerRef", ref: C, title: "工价修改", modelValue: i(b), "onUpdate:modelValue": a[1] || (a[1] = (t) => $(b) ? b.value = t : null), "before-close": i(L), size: "100%" }, { content: r(() => [l(i(ae), { class: "head-container", addQuantity: R.value, totalBadge: o.value.length, onToCollect: M }, null, 8, ["addQuantity", "totalBadge"]), !i(d).query.projectId || !i(d).query.monomerId ? (h(), W("div", ne, "*请先选择项目和单体")) : (h(), W(E, { key: 1 }, [v((h(), V(p, { ref_key: "tableRef", ref: q, data: i(d).data, "empty-text": i(d).emptyText, "max-height": i(j), style: { width: "100%" } }, { default: r(() => [l(e, { label: "序号", type: "index", align: "center", width: "60" }), l(e, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "名称", align: "center" }, { default: r((t) => [s("span", null, c(t.row.name || "-"), 1)]), _: 1 }), l(e, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center" }, { default: r((t) => [s("span", null, c(t.row.serialNumber || "-"), 1)]), _: 1 }), l(e, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center" }, { default: r((t) => [s("span", null, c(t.row.specification || "-"), 1)]), _: 1 }), l(e, { key: "length", prop: "length", "show-overflow-tooltip": "", label: "长度(mm)", align: "center" }, { default: r((t) => [s("span", null, c(t.row.length || "-"), 1)]), _: 1 }), l(e, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "center" }, { default: r((t) => [s("span", null, c(t.row.material || "-"), 1)]), _: 1 }), l(e, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center" }, { default: r((t) => [s("span", null, c(t.row.quantity || "-"), 1)]), _: 1 }), l(e, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": "", label: "单净重(kg)", align: "center" }, { default: r((t) => [s("span", null, c(t.row.netWeight || "-"), 1)]), _: 1 }), l(e, { label: "操作", align: "center", fixed: "right" }, { default: r((t) => [l(u, { size: "default", type: "primary", disabled: A.value.includes(t.row.id), onClick: F((w) => P(t.row), ["stop"]) }, { default: r(() => a[2] || (a[2] = [K(" 添加 ")])), _: 2, __: [2] }, 1032, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[f, i(d).loading]]), l(i(te)), l(i(oe), { visible: y.value, "onUpdate:visible": a[0] || (a[0] = (t) => y.value = t), addList: o.value, addQuantity: R.value, addNetWeight: D.value, query: i(d).query, onRemoveRow: S, onSuccess: z }, null, 8, ["visible", "addList", "addQuantity", "addNetWeight", "query"])], 64))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  fe as default
};
