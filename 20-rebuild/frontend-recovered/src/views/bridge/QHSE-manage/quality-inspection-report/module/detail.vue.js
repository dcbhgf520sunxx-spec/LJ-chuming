import { ref as _ } from "vue";
import { inject as O } from "vue";
import { watch as U } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as N } from "vue";
import { createBlock as j } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as a } from "vue";
import { withKeys as I } from "vue";
import { withModifiers as k } from "vue";
import { createTextVNode as C } from "vue";
import { withDirectives as $ } from "vue";
import { unref as n } from "vue";
import { toDisplayString as u } from "vue";
import { isRef as A } from "vue";
import { ElInput as J } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { ElTag as G } from "element-plus";
import { ElPagination as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { l as S, u as Y, J as Z, o as ee } from "../../../../../shared/runtime.js";
import { _ as te } from "../../../../../modules/index-5ab69a0f.js";
function ae(p) {
  return S({ module: "bridge", url: "report/inspection/summary/page", method: "get", params: p });
}
function oe(p) {
  return S({ module: "bridge", url: "report/inspection/summary/details/page", method: "get", params: p });
}
const pe = { get: ae }, le = { class: "head-container" }, ne = { class: "tc-danger" }, re = { __name: "detail", props: { visible: { type: Boolean, default: false }, info: { type: Object }, projectId: { type: Number } }, emits: ["update:visible"], setup(p, { emit: q }) {
  const V = _(), B = q, c = p, { visible: h, handleClose: P } = Y({ emit: B, props: c, field: "visible" }), { handleSizeChange: Q, handleCurrentChange: T, total: E, setTotalPage: H, queryPage: w } = Z({ fetchHook: s }), { maxHeight: M } = ee({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, V), b = _(false), z = _([]), r = _({}), R = O("query");
  U(() => c.visible, (d) => {
    d ? s() : r.value = {};
  }, { immediate: true });
  function D() {
    r.value = {}, s();
  }
  async function s() {
    var d;
    try {
      b.value = true;
      const { endDate: t, productType: m, startDate: f } = R, { content: l, totalElements: y } = await oe({ endDate: t, productType: m, startDate: f, userId: (d = c.info) == null ? void 0 : d.userId, projectId: c.projectId, ...w, ...r.value });
      z.value = l.map((g, v) => (g.rowId = v + "" + Math.random(), g)), H(y);
    } catch (t) {
      console.log("获取质检报表详情", t);
    } finally {
      b.value = false;
    }
  }
  return (d, t) => {
    const m = J, f = x("common-button"), l = F, y = G, g = x("common-table"), v = W, K = x("common-drawer"), L = X;
    return N(), j(K, { ref_key: "drawerRef", ref: V, title: "质检报表详情", modelValue: n(h), "onUpdate:modelValue": t[2] || (t[2] = (e) => A(h) ? h.value = e : null), direction: "rtl", "before-close": n(P), size: "60%" }, { titleRight: o(() => t[3] || (t[3] = [])), content: o(() => [i("div", le, [a(m, { modelValue: r.value.projectName, "onUpdate:modelValue": t[0] || (t[0] = (e) => r.value.projectName = e), placeholder: "输入项目搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: I(s, ["enter"]) }, null, 8, ["modelValue"]), a(m, { modelValue: r.value.serialNumber, "onUpdate:modelValue": t[1] || (t[1] = (e) => r.value.serialNumber = e), placeholder: "输入编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: I(s, ["enter"]) }, null, 8, ["modelValue"]), a(f, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: k(s, ["stop"]) }, { default: o(() => t[4] || (t[4] = [C("搜索")])), _: 1, __: [4] }), a(f, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: k(D, ["stop"]) }, { default: o(() => t[5] || (t[5] = [C(" 重置 ")])), _: 1, __: [5] })]), $((N(), j(g, { data: z.value, "max-height": n(M) - 155, "row-key": "rowId", style: { width: "100%" } }, { default: o(() => [a(l, { label: "序号", type: "index", align: "center", width: "60" }), a(n(te), { showProject: "" }), a(l, { "show-overflow-tooltip": true, prop: "name", label: "名称", width: "120px" }, { default: o(({ row: e }) => [i("span", null, u(e.name), 1)]), _: 1 }), a(l, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", width: "120px" }, { default: o(({ row: e }) => [i("span", null, u(e.serialNumber), 1)]), _: 1 }), a(l, { "show-overflow-tooltip": true, prop: "processName", label: "检验工序", width: "120px", align: "center" }, { default: o(({ row: e }) => [a(y, { type: "warning", effect: "plain" }, { default: o(() => [C(u(e.processName), 1)]), _: 2 }, 1024)]), _: 1 }), a(l, { "show-overflow-tooltip": true, align: "center", prop: "inspectionQuantity", label: "检验数" }, { default: o(({ row: e }) => [i("span", null, u(e.inspectionQuantity), 1)]), _: 1 }), a(l, { "show-overflow-tooltip": true, align: "center", prop: "qhseQuantity", label: "不合格数" }, { default: o(({ row: e }) => [i("span", ne, u(e.qhseQuantity), 1)]), _: 1 }), a(l, { "show-overflow-tooltip": true, align: "center", prop: "date", label: "检验日期", width: "120" }, { default: o(({ row: e }) => [i("span", null, u(e.date), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[L, b.value]]), a(v, { total: n(E), "current-page": n(w).pageNumber, "page-size": n(w).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(Q), onCurrentChange: n(T) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, de = Object.freeze(Object.defineProperty({ __proto__: null, default: re }, Symbol.toStringTag, { value: "Module" }));
export {
  re as _,
  pe as c,
  de as d
};
