import { ref as g } from "vue";
import { inject as F } from "vue";
import { watch as G } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as S } from "vue";
import { createBlock as T } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as o } from "vue";
import { withKeys as D } from "vue";
import { withModifiers as q } from "vue";
import { createTextVNode as w } from "vue";
import { unref as s } from "vue";
import { withDirectives as W } from "vue";
import { toDisplayString as p } from "vue";
import { isRef as X } from "vue";
import { ElInput as Y } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElTag as ee } from "element-plus";
import { ElPagination as te } from "element-plus";
import { vLoading as oe } from "element-plus";
import { l as v, u as ae, J as le, o as ne, L as se } from "../../../../../shared/runtime.js";
import { _ as re } from "../../../../../modules/index-3b2628f3.js";
function ie(i) {
  return v({ module: "mes", url: "report/inspection/summary/page", method: "get", params: i });
}
function ue(i) {
  return v({ module: "mes", url: "report/inspection/summary/details/page", method: "get", params: i });
}
function pe(i) {
  return v({ module: "mes", url: "report/inspection/summary/details/getprocesslist", method: "get", params: i });
}
function de(i) {
  return v({ module: "mes", url: "report/inspection/summary/details/print", method: "get", responseType: "blob", params: i });
}
const be = { get: ie }, ce = { class: "head-container" }, me = { style: { display: "flex", "justify-content": "space-between" } }, fe = { class: "tc-danger" }, _e = { __name: "detail", props: { visible: { type: Boolean, default: false }, info: { type: Object }, projectId: { type: Number } }, emits: ["update:visible"], setup(i, { emit: B }) {
  const N = g(), Q = B, d = i, { visible: x, handleClose: E } = ae({ emit: Q, props: d, field: "visible" }), { handleSizeChange: H, handleCurrentChange: L, total: M, setTotalPage: R, queryPage: C } = le({ fetchHook: c }), { maxHeight: U } = ne({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, N), I = g([]), V = g(false), k = g([]), n = g({}), j = F("query");
  G(() => d.visible, (u) => {
    u ? (O(), c()) : n.value = {};
  }, { immediate: true });
  function K() {
    n.value = {}, c();
  }
  async function O() {
    var u;
    I.value = [];
    try {
      const { endDate: e, productType: f, startDate: _ } = j, m = await pe({ endDate: e, productType: f, startDate: _, userId: (u = d.info) == null ? void 0 : u.userId, projectId: d.projectId, ...n.value });
      for (const l in m) I.value.push({ id: l, name: m[l] });
    } catch (e) {
      console.log("获取工序失败", e);
    }
  }
  async function c() {
    var u;
    try {
      V.value = true;
      const { endDate: e, productType: f, startDate: _ } = j, { content: m, totalElements: l } = await ue({ endDate: e, productType: f, startDate: _, userId: (u = d.info) == null ? void 0 : u.userId, projectId: d.projectId, ...C, ...n.value });
      k.value = m.map((h, z) => (h.rowId = z + "" + Math.random(), h)), R(l);
    } catch (e) {
      console.log("获取质检报表详情", e);
    } finally {
      V.value = false;
    }
  }
  return (u, e) => {
    const f = Y, _ = b("common-select"), m = b("common-button"), l = Z, h = ee, z = b("common-table"), $ = te, A = b("common-drawer"), J = oe;
    return S(), T(A, { ref_key: "drawerRef", ref: N, title: "质检报表详情", modelValue: s(x), "onUpdate:modelValue": e[3] || (e[3] = (y) => X(x) ? x.value = y : null), direction: "rtl", "before-close": s(E), size: "60%" }, { titleRight: a(() => e[4] || (e[4] = [])), content: a(() => {
      var y;
      return [r("div", ce, [r("div", me, [r("div", null, [o(f, { modelValue: n.value.projectName, "onUpdate:modelValue": e[0] || (e[0] = (t) => n.value.projectName = t), placeholder: "输入项目搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: D(c, ["enter"]) }, null, 8, ["modelValue"]), o(f, { modelValue: n.value.serialNumber, "onUpdate:modelValue": e[1] || (e[1] = (t) => n.value.serialNumber = t), placeholder: "输入编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: D(c, ["enter"]) }, null, 8, ["modelValue"]), o(_, { modelValue: n.value.processId, "onUpdate:modelValue": e[2] || (e[2] = (t) => n.value.processId = t), options: I.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "选择工序", class: "filter-item", style: { width: "200px" }, onChange: c }, null, 8, ["modelValue", "options"]), o(m, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: q(c, ["stop"]) }, { default: a(() => e[5] || (e[5] = [w("搜索")])), _: 1, __: [5] }), o(m, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: q(K, ["stop"]) }, { default: a(() => e[6] || (e[6] = [w(" 重置 ")])), _: 1, __: [6] })]), o(se, { fn: s(de), class: "filter-item", params: { ...s(j), ...n.value, userId: (y = d.info) == null ? void 0 : y.userId } }, { default: a(() => e[7] || (e[7] = [w("下载")])), _: 1, __: [7] }, 8, ["fn", "params"])])]), W((S(), T(z, { data: k.value, "max-height": s(U) - 155, "row-key": "rowId", style: { width: "100%" } }, { default: a(() => [o(l, { label: "序号", type: "index", align: "center", width: "60" }), o(s(re), { showProject: "" }), o(l, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体", width: "160px" }, { default: a(({ row: t }) => {
        var P;
        return [r("span", null, p((P = t == null ? void 0 : t.monomer) == null ? void 0 : P.name), 1)];
      }), _: 1 }), o(l, { "show-overflow-tooltip": true, prop: "name", label: "名称", width: "120px" }, { default: a(({ row: t }) => [r("span", null, p(t.name), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", width: "120px" }, { default: a(({ row: t }) => [r("span", null, p(t.serialNumber), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": true, prop: "number", label: "编码", width: "120px" }, { default: a(({ row: t }) => [r("span", null, p(t.number), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": true, prop: "processName", label: "检验工序", width: "120px", align: "center" }, { default: a(({ row: t }) => [o(h, { type: "warning", effect: "plain" }, { default: a(() => [w(p(t.processName), 1)]), _: 2 }, 1024)]), _: 1 }), o(l, { "show-overflow-tooltip": true, align: "center", prop: "inspectionQuantity", label: "检验数" }, { default: a(({ row: t }) => [r("span", null, p(t.inspectionQuantity), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": true, align: "center", prop: "qhseQuantity", label: "不合格数" }, { default: a(({ row: t }) => [r("span", fe, p(t.qhseQuantity), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": true, align: "center", prop: "date", label: "检验日期", width: "120" }, { default: a(({ row: t }) => [r("span", null, p(t.date), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[J, V.value]]), o($, { total: s(M), "current-page": s(C).pageNumber, "page-size": s(C).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: s(H), onCurrentChange: s(L) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, we = Object.freeze(Object.defineProperty({ __proto__: null, default: _e }, Symbol.toStringTag, { value: "Module" }));
export {
  _e as _,
  be as c,
  we as d
};
