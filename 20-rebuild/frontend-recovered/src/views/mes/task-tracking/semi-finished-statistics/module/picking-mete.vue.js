import { ref as w } from "vue";
import { inject as J } from "vue";
import { computed as O } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as C } from "vue";
import { createBlock as V } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { withKeys as z } from "vue";
import { withModifiers as x } from "vue";
import { createTextVNode as I } from "vue";
import { createElementVNode as u } from "vue";
import { withDirectives as N } from "vue";
import { unref as n } from "vue";
import { toDisplayString as c } from "vue";
import { isRef as G } from "vue";
import { ElInput as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElPagination as Z } from "element-plus";
import { vLoading as $ } from "element-plus";
import { a as ee } from "../../../../../modules/wip-statistics-f9d24ea0.js";
import { u as te, J as oe, o as ae, p as le, ba as ne } from "../../../../../shared/runtime.js";
const re = { style: { width: "300px" } }, me = { __name: "picking-mete", props: { visible: { type: Boolean, default: false }, pickingInfo: { type: Object } }, emits: ["update:visible"], setup(S, { emit: T }) {
  const y = w(), B = T, b = S, H = J("permission"), { visible: d, handleClose: K } = te({ emit: B, props: b, field: "visible", showHook: _ }), { handleSizeChange: M, handleCurrentChange: R, total: j, setTotalPage: q, queryPage: f } = oe({ fetchHook: _ }), { maxHeight: P } = ae({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, y), g = w(false), h = w([]), v = O(() => {
    var e, o;
    return { projectId: (o = (e = b.pickingInfo) == null ? void 0 : e.project) == null ? void 0 : o.id };
  });
  function D(e) {
    return ne(e, { props: ["quantity", "totalNetWeight"] });
  }
  async function _() {
    try {
      h.value = [], g.value = true;
      const { content: e = [], totalElements: o } = await ee({ ...v.value, ...f });
      h.value = e.map((i, p) => (i.rowId = p + "" + Math.random(), i)), q(o);
    } catch (e) {
      console.log("获取领料量详情失败", e);
    } finally {
      g.value = false;
    }
  }
  return (e, o) => {
    const i = X, p = m("common-button"), E = m("print-table"), l = Y, Q = m("common-table"), L = Z, U = m("common-drawer"), W = F("permission"), A = $;
    return C(), V(U, { ref_key: "drawerRef", ref: y, title: "领料量详情", modelValue: n(d), "onUpdate:modelValue": o[2] || (o[2] = (a) => G(d) ? d.value = a : null), direction: "rtl", "before-close": n(K), size: "70%" }, { titleAfter: r(() => [t(i, { modelValue: e.monomerId, "onUpdate:modelValue": o[0] || (o[0] = (a) => e.monomerId = a), modelModifiers: { trim: true }, size: "default", placeholder: "输入单体搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: z(e.searchQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(i, { modelValue: e.serialNumber, "onUpdate:modelValue": o[1] || (o[1] = (a) => e.serialNumber = a), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px", "margin-left": "8px" }, class: "filter-item", clearable: "", onKeyup: z(e.searchQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(p, { class: "filter-item", size: "default", style: { "margin-left": "8px" }, type: "success", icon: "el-icon-search", onClick: x(e.searchQuery, ["stop"]) }, { default: r(() => o[3] || (o[3] = [I(" 搜索 ")])), _: 1, __: [3] }, 8, ["onClick"]), t(p, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: x(e.resetQuery, ["stop"]) }, { default: r(() => o[4] || (o[4] = [I(" 重置 ")])), _: 1, __: [4] }, 8, ["onClick"])]), titleRight: r(() => [u("div", re, [N(t(E, { "api-key": e.apiKey, params: { ...v.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[W, n(H).print]])])]), content: r(() => [N((C(), V(Q, { data: h.value, "max-height": n(P) - 100, "show-empty-symbol": false, "row-key": "rowId", style: { width: "100%" }, "show-summary": "", "summary-method": D }, { default: r(() => [t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(l, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" }, { default: r(({ row: a }) => {
      var s;
      return [u("span", null, c(a.monomer ? (s = a.monomer) == null ? void 0 : s.name : "/"), 1)];
    }), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "length", label: "长度", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "quantity", label: "数量", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "netWeight", label: "单重", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "totalNetWeight", label: "总重", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "groups.name", label: "领料人", align: "center" }, { default: r(({ row: a }) => {
      var s, k;
      return [u("span", null, c((s = a.workshop) == null ? void 0 : s.name) + ">" + c((k = a.groups) == null ? void 0 : k.name), 1)];
    }), _: 1 }), t(l, { "show-overflow-tooltip": true, align: "center", prop: "completeTime", label: "领料日期", width: "120" }, { default: r(({ row: a }) => [u("span", null, c(n(le)(a.completeTime, "{y}-{m}-{d}")), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[A, g.value]]), t(L, { total: n(j), "current-page": n(f).pageNumber, "page-size": n(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(M), onCurrentChange: n(R) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  me as default
};
