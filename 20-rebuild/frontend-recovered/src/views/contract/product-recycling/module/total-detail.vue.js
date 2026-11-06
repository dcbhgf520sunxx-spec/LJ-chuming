import { ref as h } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as m } from "vue";
import { createBlock as d } from "vue";
import { withCtx as l } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as D } from "vue";
import { toDisplayString as i } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as H } from "vue";
import { withDirectives as q } from "vue";
import { createElementVNode as u } from "vue";
import { isRef as N } from "vue";
import { ElTag as P } from "element-plus";
import { ElTableColumn as B } from "element-plus";
import { vLoading as M } from "element-plus";
import { x as A, u as E, o as O, E as j, G as z, z as I, ka as L, p as S, P as G } from "../../../../shared/runtime.js";
import { a as Q } from "../../../../modules/product-recycling-d772694e.js";
const W = { __name: "total-detail", props: ["visible", "currentLine"], emits: ["update:visible"], setup(b, { emit: y }) {
  const g = b, w = y, f = h(null), _ = h(null), { crud: o, CRUD: x } = A({ optShow: { add: false }, crudApi: { get: Q }, queryOnPresenterCreated: false }, _), { visible: s, handleClose: v } = E({ emit: w, props: g, field: "visible", showHook: o.toQuery }), { maxHeight: C } = O({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, paginate: true, extraHeight: 100, clientHRepMainH: true }, f);
  return x.HOOK.beforeToQuery = (p) => {
    const { currentLine: r } = g;
    p.query.branchCompanyId = r == null ? void 0 : r.branchCompanyId, p.query.customerUnit = r == null ? void 0 : r.customerUnit;
  }, (p, r) => {
    const k = P, V = c("print-table"), a = B, R = c("common-table"), T = c("common-drawer"), U = M;
    return m(), d(T, { ref_key: "drawerRef", ref: f, modelValue: t(s), "onUpdate:modelValue": r[0] || (r[0] = (n) => N(s) ? s.value = n : null), "before-close": t(v), size: "100%", title: "累计回收金额" }, { titleAfter: l(() => [e(k, { type: "primary" }, { default: l(() => {
      var n;
      return [D("出售方：" + i((n = b.currentLine) == null ? void 0 : n.customerUnit), 1)];
    }), _: 1 })]), content: l(() => [e(t(j), { showGrid: false, showRefresh: false, showSearch: false }, { viewLeft: l(() => [t(z)(t(o).permission.print) ? (m(), d(V, { key: 0, params: t(o).query, "api-key": "returnLedgerDetail", size: "mini", type: "warning" }, null, 8, ["params"])) : H("", true)]), _: 1 }), q((m(), d(R, { ref_key: "tableRef", ref: _, data: t(o).data, "empty-text": t(o).emptyText, "max-height": t(C) }, { default: l(() => [e(a, { align: "center", label: "序号", type: "index", width: "60" }), e(a, { align: "center", label: "项目", width: "350" }, { default: l(({ row: n }) => [u("span", null, i(t(I)(n.project)), 1)]), _: 1 }), e(a, { align: "center", label: "单体", prop: "monomer.name" }), e(a, { align: "center", label: "区域", prop: "area.name" }), e(a, { align: "center", label: "名称", prop: "name" }), e(a, { align: "center", label: "编号", prop: "serialNumber" }), e(a, { align: "center", label: "规格", prop: "specification", width: "200" }), e(a, { align: "center", label: "长度（m）", prop: "length" }), e(a, { align: "center", label: "材质", prop: "material" }), e(a, { align: "center", label: "计价方式", prop: "pricingManner" }, { default: l(({ row: n }) => [u("span", null, i(t(L).VL[n.pricingManner]), 1)]), _: 1 }), e(a, { align: "center", label: "数量", prop: "quantity" }), e(a, { align: "center", label: "核算量", prop: "mete" }), e(a, { align: "center", label: "核算单位", prop: "accountingUnit" }), e(a, { align: "center", label: "计量单位", prop: "measureUnit" }), e(a, { align: "center", label: "单价（元）", prop: "unitPrice" }), e(a, { align: "center", label: "总价（元）", prop: "totalAmount" }), e(a, { align: "center", label: "审核日期", prop: "auditTime", width: "140" }, { default: l(({ row: n }) => [u("span", null, i(t(S)(n.auditTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[U, t(o).loading]]), e(G)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  W as default
};
