import { ref as N } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as f } from "vue";
import { createBlock as w } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as H } from "vue";
import { toDisplayString as m } from "vue";
import { withDirectives as q } from "vue";
import { unref as a } from "vue";
import { createElementVNode as b } from "vue";
import { createCommentVNode as P } from "vue";
import { isRef as G } from "vue";
import { ElTag as Q } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { ElPagination as L } from "element-plus";
import { vLoading as M } from "element-plus";
import { o as O, q as J } from "../../../../../../modules/ship-summary-d5d4a58f.js";
import { uo as y, u as F, J as K, o as X, bo as k, ba as Y } from "../../../../../../shared/runtime.js";
const te = { __name: "package-detail-drawer", props: { visible: { type: Boolean, default: false }, packageInfo: { type: Object, default: () => {
} }, query: { type: Object }, workshopId: { type: Number }, projectId: { type: Number }, category: { type: [Number, String], default: y.STRUCTURE.V }, weightStatus: { type: Number } }, emits: ["update:visible", "changeDate"], setup(i, { emit: x }) {
  const C = x, c = N([]), p = N(false), l = i, { visible: u, handleClose: S } = F({ emit: C, props: l, field: "visible", showHook: v }), { handleSizeChange: T, handleCurrentChange: V, total: E, setTotalPage: I, queryPage: g } = K({ fetchHook: v }), { maxHeight: W } = X({ mainBox: ".detail-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, u);
  async function v() {
    c.value = [], p.value = true;
    try {
      const r = l.category === y.STRUCTURE.V ? O : J, s = { projectId: l.projectId, ...l.query, workshopId: l.workshopId, packageId: l.packageInfo.id, ...g }, { content: d = [], totalElements: e } = await r(s);
      c.value = d, I(e), p.value = false, console.log(c.value);
    } catch (r) {
      console.log("获取详情失败", r), p.value = false;
    }
  }
  function D(r) {
    return Y(r, { props: ["packageQuantity", "totalNetWeight", "totalGrossWeight"] });
  }
  return (r, s) => {
    const d = Q, e = A, R = h("table-cell-tag"), z = h("common-table"), B = L, U = h("common-drawer"), j = M;
    return f(), w(U, { ref: "drawerRef", "custom-class": "detail-drawer", title: "打包明细", modelValue: a(u), "onUpdate:modelValue": s[0] || (s[0] = (o) => G(u) ? u.value = o : null), direction: "rtl", "before-close": a(S), size: "70%" }, { titleAfter: n(() => [t(d, { effect: "plain" }, { default: n(() => [H("包单号：" + m(i.packageInfo.serialNumber), 1)]), _: 1 })]), content: n(() => [q((f(), w(z, { data: c.value, "show-summary": "", "summary-method": D, style: { width: "100%" }, "max-height": a(W) - 70 }, { default: n(() => [t(e, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), t(e, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": true }, { default: n(({ row: o }) => {
      var _;
      return [t(R, { show: o.boolAllPartSendDirectly, name: "檩条直发", color: "#f56c6c" }, null, 8, ["show"]), b("span", null, m((_ = o.monomer) == null ? void 0 : _.name), 1)];
    }), _: 1 }), t(e, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": true }), l.category === a(y).STRUCTURE.V ? (f(), w(e, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true })) : P("", true), t(e, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), t(e, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": true, "min-width": "120px" }), t(e, { key: "length", prop: "length", label: "长度（mm）", align: "center", "show-overflow-tooltip": true }), t(e, { key: "packageQuantity", prop: "packageQuantity", label: "数量", align: "center", "show-overflow-tooltip": true, width: "80px" }), t(e, { key: "netWeight", prop: "netWeight", label: "单重（kg）", align: "center", "show-overflow-tooltip": true }, { default: n(({ row: o }) => [b("span", null, m(i.weightStatus === a(k).NET.V ? o.netWeight || "-" : o.grossWeight || "-"), 1)]), _: 1 }), t(e, { prop: i.weightStatus === a(k).NET.V ? "totalNetWeight" : "totalGrossNetWeight", label: "总重（kg）", align: "center", "show-overflow-tooltip": true }, { default: n(({ row: o }) => [b("span", null, m(i.weightStatus === a(k).NET.V ? o.totalNetWeight || "-" : o.totalGrossNetWeight || "-"), 1)]), _: 1 }, 8, ["prop"])]), _: 1 }, 8, ["data", "max-height"])), [[j, p.value]]), t(B, { total: a(E), "current-page": a(g).pageNumber, "page-size": a(g).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(T), onCurrentChange: a(V) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  te as default
};
