import { ref as i } from "vue";
import { inject as k } from "vue";
import { watch as K } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as z } from "vue";
import { createElementBlock as W } from "vue";
import { createVNode as t } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as _ } from "vue";
import { unref as a } from "vue";
import { withDirectives as X } from "vue";
import { createBlock as Y } from "vue";
import { toDisplayString as b } from "vue";
import { createTextVNode as T } from "vue";
import { isRef as Z } from "vue";
import { Fragment as ee } from "vue";
import { ElTableColumn as te } from "element-plus";
import { ElTag as ae } from "element-plus";
import { ElPagination as oe } from "element-plus";
import { vLoading as le } from "element-plus";
import { a as ne } from "../../../../../modules/index-31ff7034.js";
import { u as se, J as ie, o as re, kD as h, q as ue } from "../../../../../shared/runtime.js";
import { _ as me } from "../../../../../modules/index-3b2628f3.js";
import de from "./audit-detail-drawer.vue.js";
const ce = { class: "head-container" }, he = { __name: "audit-drawer", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible", "refresh"], setup(I, { emit: N }) {
  const w = i(), y = N, C = I, { visible: p, handleClose: j } = se({ emit: y, props: C, field: "visible", closeHook: D }), { handleSizeChange: B, handleCurrentChange: E, total: U, setTotalPage: H, queryPage: V } = ie({ fetchHook: m }), L = i([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["auditTime", ["parse-time", "{y}-{m}-{d}"]]]), { maxHeight: M } = re({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, w), P = k("fQuery"), R = k("organizationType"), r = i({}), f = i(false), x = i(), v = i(false);
  K(() => C.visible, (s) => {
    var e;
    s && (r.value = { projectId: (e = P.value) == null ? void 0 : e.projectId }, v.value = false, m());
  }, { immediate: true });
  const g = i(false), S = i([]);
  async function m() {
    try {
      g.value = true;
      const { content: s, totalElements: e } = await ne({ organizationType: R, ...r.value });
      S.value = s.map((d, l) => (d.rowId = l + "" + Math.random(), d)), H(e);
    } catch (s) {
      console.log("获取工价调整审核列表失败", s);
    } finally {
      g.value = false;
    }
  }
  function q(s) {
    x.value = s, f.value = true;
  }
  function A() {
    v.value = true, m();
  }
  function D() {
    v.value && y("refresh");
  }
  return (s, e) => {
    const d = c("common-radio-button"), l = te, $ = ae, F = c("common-button"), Q = c("common-table"), G = oe, J = c("common-drawer"), O = le;
    return z(), W(ee, null, [t(J, { ref_key: "drawerRef", ref: w, title: "班组工价审核列表", modelValue: a(p), "onUpdate:modelValue": e[2] || (e[2] = (u) => Z(p) ? p.value = u : null), direction: "rtl", "before-close": a(j), size: "60%" }, { titleRight: n(() => e[4] || (e[4] = [])), content: n(() => {
      var u;
      return [_("div", ce, [t(d, { modelValue: r.value.status, "onUpdate:modelValue": e[0] || (e[0] = (o) => r.value.status = o), options: a(h).ENUM, type: "enum", showOptionAll: "", class: "filter-item", onChange: m }, null, 8, ["modelValue", "options"]), t(a(ue), { modelValue: r.value.monomerId, "onUpdate:modelValue": e[1] || (e[1] = (o) => r.value.monomerId = o), clearable: "", default: false, "project-id": (u = r.value) == null ? void 0 : u.projectId, class: "filter-item", onChange: m }, null, 8, ["modelValue", "project-id"])]), X((z(), Y(Q, { "data-format": L.value, "row-key": "rowId", data: S.value, "max-height": a(M), style: { width: "100%" } }, { default: n(() => [t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(a(me), { showProject: "", showMonomer: "" }), t(l, { prop: "userName", "show-overflow-tooltip": "", label: "编辑人" }, { default: n(({ row: o }) => [_("span", null, b(o.userName), 1)]), _: 1 }), t(l, { prop: "createTime", "show-overflow-tooltip": "", label: "编辑日期", align: "center" }), t(l, { prop: "auditUserName", "show-overflow-tooltip": "", label: "审核人" }, { default: n(({ row: o }) => [_("span", null, b(o.auditUserName), 1)]), _: 1 }), t(l, { prop: "auditTime", "show-overflow-tooltip": "", label: "审核日期", align: "center" }), t(l, { prop: "auditStatus", "show-overflow-tooltip": "", label: "状态", width: "100px", align: "center" }, { default: n(({ row: o }) => [t($, { type: a(h).V[o.auditStatus].TAG }, { default: n(() => [T(b(a(h).VL[o.auditStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), t(l, { align: "center", label: "操作", width: "100" }, { default: n(({ row: o }) => [t(F, { size: "default", type: "primary", onClick: (pe) => q(o) }, { default: n(() => e[5] || (e[5] = [T("查看")])), _: 2, __: [5] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[O, g.value]]), t(G, { total: a(U), "current-page": a(V).pageNumber, "page-size": a(V).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(B), onCurrentChange: a(E) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]), t(a(de), { visible: f.value, "onUpdate:visible": e[3] || (e[3] = (u) => f.value = u), itemInfo: x.value, onSuccess: A }, null, 8, ["visible", "itemInfo"])], 64);
  };
} };
export {
  he as default
};
