import { ref as f } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as c } from "vue";
import { unref as e } from "vue";
import { createVNode as t } from "vue";
import { withCtx as i } from "vue";
import { createBlock as x } from "vue";
import { createTextVNode as C } from "vue";
import { createCommentVNode as P } from "vue";
import { withDirectives as T } from "vue";
import { Fragment as I } from "vue";
import { createElementVNode as N } from "vue";
import { toDisplayString as B } from "vue";
import { nextTick as H } from "vue";
import { ElBadge as M } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { ElTag as U } from "element-plus";
import { vLoading as L } from "element-plus";
import { c as z, m as A } from "./module/detail.vue.js";
import { _ as G, m as K, x as W, o as $, tY as j, G as Y, tQ as J, D as X, P as Z } from "../../../../shared/runtime.js";
import { r as _ } from "../../../../modules/project-19a12d6b.js";
import ee from "./module/header.vue.js";
import "../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../modules/index-8356a01a.js";
const te = { class: "app-container" }, oe = { key: 0 }, ae = { key: 1 }, le = { __name: "index", setup(ne) {
  const { globalProjectId: y, globalProject: p } = K(["globalProjectId", "globalProject"]), V = { add: false, edit: false, del: false, download: false }, S = f([]), m = f(), u = f(false), { crud: o, CRUD: h } = W({ title: "安装填报", sort: [], permission: { ..._ }, optShow: { ...V }, crudApi: { ...z }, requiredQuery: ["projectId", "productType", "areaId"], hasPagination: true }, m), { maxHeight: D } = $({ paginate: true, extraHeight: 40 });
  h.HOOK.beforeRefresh = () => (o.query.projectId = y.value || void 0, !!o.query.projectId), h.HOOK.handleRefresh = (g, { data: l }) => {
    l.content.forEach((d) => {
      d.selectQuantity = d.canInstallQuantity;
    });
  };
  function R(g) {
    H(async () => {
      await m.value.toggleRowSelection(g, false);
    });
  }
  return (g, l) => {
    var b, w;
    const d = k("common-button"), E = M, a = F, Q = k("common-table"), q = U, O = L;
    return s(), c("div", te, [((b = e(p)) == null ? void 0 : b.installReportMethod) === e(j).PC.V ? (s(), c("div", oe, [t(e(ee), { projectId: e(y), globalProject: e(p) }, { summaryBtn: i(() => {
      var n, r;
      return [e(Y)(e(_).summary) ? (s(), x(E, { key: 0, value: (n = e(o).selections) == null ? void 0 : n.length, max: 99, style: { float: "right" }, hidden: !((r = e(o).selections) != null && r.length) }, { default: i(() => {
        var v;
        return [t(d, { type: "warning", size: "default", disabled: !((v = e(o).selections) != null && v.length), class: "filter-item", onClick: l[0] || (l[0] = (se) => u.value = true) }, { default: i(() => l[2] || (l[2] = [C("汇总")])), _: 1, __: [2] }, 8, ["disabled"])];
      }), _: 1 }, 8, ["value", "hidden"])) : P("", true)];
    }), _: 1 }, 8, ["projectId", "globalProject"]), T((s(), x(Q, { ref_key: "tableRef", ref: m, data: e(o).data, "data-format": S.value, "empty-text": e(o).emptyText, "max-height": e(D), style: { width: "100%", "margin-top": "10px" }, stripe: false, onSelectionChange: e(o).selectionChangeHandler }, { default: i(() => [t(a, { type: "selection", align: "center", width: "60" }), t(a, { label: "序号", type: "index", align: "center", width: "60" }), t(a, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "" }), t(a, { key: "serialNumber", prop: "serialNumber", align: "center", "show-overflow-tooltip": true, label: "编号" }), t(a, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "120" }), e(o).query.productType === e(J).ENCLOSURE.V ? (s(), c(I, { key: 0 }, [t(a, { key: "length", prop: "length", label: "单长（mm）", align: "center", "show-overflow-tooltip": "" }), t(a, { key: "canInstallQuantity", prop: "canInstallQuantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), t(a, { key: "mete", prop: "mete", label: "总长（m）", align: "center", "show-overflow-tooltip": "" }, { default: i(({ row: n }) => {
      var r;
      return [N("span", null, B(n.mete ? (r = n.mete) == null ? void 0 : r.toFixed(e(X).COM_L__M) : 0), 1)];
    }), _: 1 })], 64)) : (s(), c(I, { key: 1 }, [t(a, { key: "length", prop: "length", label: "长度（mm）", align: "center", "show-overflow-tooltip": "" }), t(a, { key: "material", prop: "material", label: "材质", align: "center", "show-overflow-tooltip": "" }), t(a, { key: "canInstallQuantity", prop: "canInstallQuantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), t(a, { key: "netWeight", prop: "netWeight", label: "单净重（kg）", align: "center", "show-overflow-tooltip": "" }), t(a, { key: "mete", prop: "mete", label: "总净重（kg）", align: "center", "show-overflow-tooltip": "" })], 64))]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "onSelectionChange"])), [[O, e(o).loading]]), t(e(Z)), t(e(A), { modelValue: u.value, "onUpdate:modelValue": l[1] || (l[1] = (n) => u.value = n), permission: e(_), queryVO: e(o).query, selections: e(o).selections, globalProject: e(p), onSuccess: e(o).toQuery, onDelChange: R }, null, 8, ["modelValue", "permission", "queryVO", "selections", "globalProject", "onSuccess"])])) : ((w = e(p)) == null ? void 0 : w.installReportMethod) !== e(j).PC.V ? (s(), c("div", ae, [t(q, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: i(() => l[3] || (l[3] = [C(" * 您好，当前页面需要选择项目部自报模式可查看 ")])), _: 1, __: [3] })])) : P("", true)]);
  };
} }, fe = G(le, [["__scopeId", "data-v-2af4b391"]]);
export {
  fe as default
};
