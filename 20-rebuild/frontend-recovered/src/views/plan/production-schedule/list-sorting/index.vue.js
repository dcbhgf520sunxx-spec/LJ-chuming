import { ref as p } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as g } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as a } from "vue";
import { createElementVNode as w } from "vue";
import { toDisplayString as n } from "vue";
import { unref as i } from "vue";
import { createCommentVNode as L } from "vue";
import { withDirectives as S } from "vue";
import { isRef as T } from "vue";
import { ElTag as z } from "element-plus";
import { ElBadge as O } from "element-plus";
import { ElTableColumn as P } from "element-plus";
import { vLoading as U } from "element-plus";
import { a as A, _ as E } from "./module/summary-list.vue.js";
import { _ as Q, u as K, x as M, o as $, P as F } from "../../../../shared/runtime.js";
import G from "./module/header.vue.js";
import "../../../../modules/index-8356a01a.js";
const J = { class: "header" }, X = { class: "button-list" }, Y = { __name: "index", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(c, { emit: k }) {
  const x = k, b = c, y = p(), { visible: u, handleClose: N } = K({ emit: x, props: b, field: "visible", showHook: D, closeHook: close }), { crud: r, CRUD: C } = M({ title: "清单分拣", sort: [], crudApi: { get: A }, hasPagination: true, queryOnPresenterCreated: false }, y), { maxHeight: R } = $({ paginate: true }), d = p([]), m = p(false);
  C.HOOK.beforeToQuery = () => {
    r.query.projectId = b.currentRow.projectId;
  };
  function V() {
    d.value = r.selections;
  }
  function j() {
    m.value = true;
  }
  function D() {
    r.toQuery();
  }
  return (Z, s) => {
    const I = z, h = f("common-button"), q = O, l = P, H = f("common-table"), W = f("common-drawer"), B = U;
    return _(), g(W, { ref: "drawerRef", title: "清单分拣", modelValue: i(u), "onUpdate:modelValue": s[1] || (s[1] = (e) => T(u) ? u.value = e : null), "before-close": i(N), size: "100%", "custom-class": "model-drawer" }, { titleAfter: o(() => [t(I, { size: "large", effect: "plain" }, { default: o(() => {
      var e, v;
      return [s[2] || (s[2] = a(" 项目：")), w("span", null, n((e = c.currentRow) == null ? void 0 : e.serialNumber) + " - " + n((v = c.currentRow) == null ? void 0 : v.shortName), 1)];
    }), _: 1, __: [2] })]), content: o(() => [w("div", J, [t(i(G), { projectId: c.currentRow.projectId }, null, 8, ["projectId"]), w("div", X, [t(h, { size: "default", type: "primary", class: "filter-item", icon: "el-icon-plus", disabled: !i(r).selections.length, onClick: V }, { default: o(() => s[3] || (s[3] = [a(" 添加 ")])), _: 1, __: [3] }, 8, ["disabled"]), i(r).query.projectId ? (_(), g(q, { key: 0, class: "ml-10", value: d.value.length, max: 99, hidden: d.value.length < 1 }, { default: o(() => [t(h, { size: "default", type: "success", class: "filter-item", onClick: j }, { default: o(() => s[4] || (s[4] = [a(" 汇总 ")])), _: 1, __: [4] })]), _: 1 }, 8, ["value", "hidden"])) : L("", true)])]), S((_(), g(H, { ref_key: "tableRef", ref: y, data: i(r).data, "empty-text": i(r).emptyText, "max-height": i(R), style: { width: "100%" }, onSelectionChange: i(r).selectionChangeHandler }, { default: o(() => [t(l, { type: "selection", width: "55", align: "center" }), t(l, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(l, { key: "areaName", prop: "areaName", "show-overflow-tooltip": "", label: "区域", align: "center" }, { default: o((e) => [a(n(e.row.areaName || "-"), 1)]), _: 1 }), t(l, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "名称", align: "center" }, { default: o((e) => [a(n(e.row.name || "-"), 1)]), _: 1 }), t(l, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center" }, { default: o((e) => [a(n(e.row.serialNumber || "-"), 1)]), _: 1 }), t(l, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center" }, { default: o((e) => [a(n(e.row.specification || "-"), 1)]), _: 1 }), t(l, { key: "length", prop: "length", "show-overflow-tooltip": "", label: "长度(mm)", align: "center" }, { default: o((e) => [a(n(e.row.length || "-"), 1)]), _: 1 }), t(l, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "center" }, { default: o((e) => [a(n(e.row.material || "-"), 1)]), _: 1 }), t(l, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center" }, { default: o((e) => [a(n(e.row.quantity || "-"), 1)]), _: 1 }), t(l, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": "", label: "单净重（kg）", align: "center" }, { default: o((e) => [a(n(e.row.netWeight || "-"), 1)]), _: 1 }), t(l, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": "", label: "总净重（kg）", align: "center" }, { default: o((e) => [a(n(e.row.totalNetWeight || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[B, i(r).loading]]), t(i(F)), t(E, { visible: m.value, "onUpdate:visible": s[0] || (s[0] = (e) => m.value = e), summaryListData: d.value }, null, 8, ["visible", "summaryListData"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ne = Q(Y, [["__scopeId", "data-v-9183d44d"]]);
export {
  ne as default
};
