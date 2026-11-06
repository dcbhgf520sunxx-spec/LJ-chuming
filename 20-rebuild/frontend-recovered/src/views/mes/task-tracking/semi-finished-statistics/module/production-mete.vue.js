import { ref as w } from "vue";
import { inject as J } from "vue";
import { computed as O } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as k } from "vue";
import { createBlock as V } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { withKeys as z } from "vue";
import { withModifiers as x } from "vue";
import { createTextVNode as I } from "vue";
import { createElementVNode as u } from "vue";
import { withDirectives as N } from "vue";
import { unref as r } from "vue";
import { toDisplayString as c } from "vue";
import { isRef as G } from "vue";
import { ElInput as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElPagination as Z } from "element-plus";
import { vLoading as $ } from "element-plus";
import { a as ee } from "../../../../../modules/wip-statistics-f9d24ea0.js";
import { u as te, J as oe, o as ae, p as le, ba as re } from "../../../../../shared/runtime.js";
const ne = { style: { width: "300px" } }, me = { __name: "production-mete", props: { visible: { type: Boolean, default: false }, productionInfo: { type: Object } }, emits: ["update:visible"], setup(S, { emit: T }) {
  const y = w(), B = T, b = S, H = J("permission"), { visible: d, handleClose: K } = te({ emit: B, props: b, field: "visible", showHook: _ }), { handleSizeChange: M, handleCurrentChange: R, total: j, setTotalPage: q, queryPage: f } = oe({ fetchHook: _ }), { maxHeight: P } = ae({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, y), g = w(false), h = w([]), v = O(() => {
    var e;
    return { projectId: (e = b.productionInfo.project) == null ? void 0 : e.id };
  });
  function D(e) {
    return re(e, { props: ["quantity", "totalNetWeight"] });
  }
  async function _() {
    try {
      h.value = [], g.value = true;
      const { content: e = [], totalElements: a } = await ee({ ...v.value, ...f });
      h.value = e.map((i, p) => (i.rowId = p + "" + Math.random(), i)), q(a);
    } catch (e) {
      console.log("获取生产量详情失败", e);
    } finally {
      g.value = false;
    }
  }
  return (e, a) => {
    const i = X, p = m("common-button"), E = m("print-table"), l = Y, Q = m("common-table"), L = Z, U = m("common-drawer"), W = F("permission"), A = $;
    return k(), V(U, { ref_key: "drawerRef", ref: y, title: "生产量详情", modelValue: r(d), "onUpdate:modelValue": a[2] || (a[2] = (o) => G(d) ? d.value = o : null), direction: "rtl", "before-close": r(K), size: "70%" }, { titleAfter: n(() => [t(i, { modelValue: e.monomerId, "onUpdate:modelValue": a[0] || (a[0] = (o) => e.monomerId = o), modelModifiers: { trim: true }, size: "default", placeholder: "输入单体搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: z(e.searchQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(i, { modelValue: e.serialNumber, "onUpdate:modelValue": a[1] || (a[1] = (o) => e.serialNumber = o), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px", "margin-left": "8px" }, class: "filter-item", clearable: "", onKeyup: z(e.searchQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(p, { class: "filter-item", size: "default", style: { "margin-left": "8px" }, type: "success", icon: "el-icon-search", onClick: x(e.searchQuery, ["stop"]) }, { default: n(() => a[3] || (a[3] = [I(" 搜索 ")])), _: 1, __: [3] }, 8, ["onClick"]), t(p, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: x(e.resetQuery, ["stop"]) }, { default: n(() => a[4] || (a[4] = [I(" 重置 ")])), _: 1, __: [4] }, 8, ["onClick"])]), titleRight: n(() => [u("div", ne, [N(t(E, { "api-key": e.apiKey, params: { ...v.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[W, r(H).print]])])]), content: n(() => [N((k(), V(Q, { data: h.value, "max-height": r(P) - 100, "show-empty-symbol": false, "row-key": "rowId", style: { width: "100%" }, "show-summary": "", "summary-method": D }, { default: n(() => [t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(l, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" }, { default: n(({ row: o }) => {
      var s;
      return [u("span", null, c(o.monomer ? (s = o.monomer) == null ? void 0 : s.name : "/"), 1)];
    }), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "length", label: "长度", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "quantity", label: "数量", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "netWeight", label: "单重", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "totalNetWeight", label: "总重", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "groups.name", label: "生产组", align: "center" }, { default: n(({ row: o }) => {
      var s, C;
      return [u("span", null, c((s = o.workshop) == null ? void 0 : s.name) + ">" + c((C = o.groups) == null ? void 0 : C.name), 1)];
    }), _: 1 }), t(l, { "show-overflow-tooltip": true, align: "center", prop: "completeTime", label: "生产日期", width: "120" }, { default: n(({ row: o }) => [u("span", null, c(r(le)(o.completeTime, "{y}-{m}-{d}")), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[A, g.value]]), t(L, { total: r(j), "current-page": r(f).pageNumber, "page-size": r(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: r(M), onCurrentChange: r(R) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  me as default
};
