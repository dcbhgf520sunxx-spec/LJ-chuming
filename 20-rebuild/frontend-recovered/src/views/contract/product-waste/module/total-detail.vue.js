import { ref as _ } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as c } from "vue";
import { createBlock as m } from "vue";
import { withCtx as l } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as H } from "vue";
import { toDisplayString as d } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as q } from "vue";
import { withDirectives as P } from "vue";
import { createElementVNode as h } from "vue";
import { isRef as B } from "vue";
import { ElTag as I } from "element-plus";
import { ElTableColumn as M } from "element-plus";
import { vLoading as N } from "element-plus";
import { x as U, u as A, o as E, E as O, G as S, ka as W, p as z, P as G } from "../../../../shared/runtime.js";
import { a as L } from "../../../../modules/product-waste-c86c76d6.js";
const F = { __name: "total-detail", props: ["visible", "currentLine"], emits: ["update:visible"], setup(u, { emit: y }) {
  const b = u, w = y, g = _(null), f = _(null), { crud: o, CRUD: x } = U({ optShow: { add: false }, crudApi: { get: L }, queryOnPresenterCreated: false }, f), { visible: i, handleClose: v } = A({ emit: w, props: b, field: "visible", showHook: o.toQuery }), { maxHeight: C } = E({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, paginate: true, extraHeight: 100, clientHRepMainH: true }, g);
  return x.HOOK.beforeToQuery = (s) => {
    const { currentLine: n } = b;
    s.query.branchCompanyId = n == null ? void 0 : n.branchCompanyId, s.query.contractWasteId = n == null ? void 0 : n.contractWasteId;
  }, (s, n) => {
    const k = I, V = p("print-table"), a = M, R = p("common-table"), T = p("common-drawer"), D = N;
    return c(), m(T, { ref_key: "drawerRef", ref: g, modelValue: t(i), "onUpdate:modelValue": n[0] || (n[0] = (r) => B(i) ? i.value = r : null), "before-close": t(v), size: "100%", title: "累计出售金额" }, { titleAfter: l(() => [e(k, { type: "primary" }, { default: l(() => {
      var r;
      return [H("购买方：" + d((r = u.currentLine) == null ? void 0 : r.purchaser), 1)];
    }), _: 1 })]), content: l(() => [e(t(O), { showGrid: false, showRefresh: false, showSearch: false }, { viewLeft: l(() => [t(S)(t(o).permission.print) ? (c(), m(V, { key: 0, params: t(o).query, "api-key": "productWasteDetail", size: "small", type: "warning" }, null, 8, ["params"])) : q("", true)]), _: 1 }), P((c(), m(R, { ref_key: "tableRef", ref: f, data: t(o).data, "empty-text": t(o).emptyText, "max-height": t(C) }, { default: l(() => [e(a, { align: "center", label: "序号", type: "index", width: "60" }), e(a, { align: "center", label: "名称", prop: "name" }), e(a, { align: "center", label: "编号", prop: "serialNumber" }), e(a, { align: "center", label: "规格", prop: "specification", width: "200" }), e(a, { align: "center", label: "长度（m）", prop: "length" }), e(a, { align: "center", label: "材质", prop: "material" }), e(a, { align: "center", label: "计价方式", prop: "pricingManner" }, { default: l(({ row: r }) => [h("span", null, d(t(W).VL[r.pricingManner]), 1)]), _: 1 }), e(a, { align: "center", label: "数量", prop: "quantity" }), e(a, { align: "center", label: "核算量", prop: "mete" }), e(a, { align: "center", label: "核算单位", prop: "accountingUnit" }), e(a, { align: "center", label: "计量单位", prop: "measureUnit" }), e(a, { align: "center", label: "成本单价（元）", prop: "unitPrice" }), e(a, { align: "center", label: "成本总价（元）", prop: "totalAmount" }), e(a, { align: "center", label: "审核日期", prop: "auditTime", width: "140" }, { default: l(({ row: r }) => [h("span", null, d(t(z)(r.auditTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[D, t(o).loading]]), e(G)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  F as default
};
