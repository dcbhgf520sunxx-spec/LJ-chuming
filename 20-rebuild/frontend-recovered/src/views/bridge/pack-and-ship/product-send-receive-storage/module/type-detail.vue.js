import { ref as i } from "vue";
import { watch as P } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as u } from "vue";
import { createBlock as c } from "vue";
import { withCtx as m } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as j } from "vue";
import { toDisplayString as E } from "vue";
import { unref as n } from "vue";
import { createElementVNode as H } from "vue";
import { createCommentVNode as _ } from "vue";
import { withDirectives as K } from "vue";
import { isRef as R } from "vue";
import { ElTag as L } from "element-plus";
import { ElDatePicker as F } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { ElPagination as A } from "element-plus";
import { vLoading as J } from "element-plus";
import { a as $ } from "../../../../../modules/product-receive-send-storage-07e30ee6.js";
import { u as X, J as Y, o as Z, D as d, bM as ee, z as te, ba as ae } from "../../../../../shared/runtime.js";
const oe = { class: "header-div" }, ie = { __name: "type-detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, showType: { type: String, default: void 0 }, detailQuery: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(o, { emit: k }) {
  const x = k, l = i({}), p = o, { visible: s, handleClose: C } = X({ emit: x, props: p }), { handleSizeChange: N, handleCurrentChange: D, total: O, setTotalPage: W, queryPage: g } = Y({ fetchHook: f });
  P(s, (t) => {
    t && (l.value.createTime = [], l.value.startDate = void 0, l.value.endDate = void 0, f());
  });
  const v = i([]), b = i(), h = i(false), { maxHeight: B } = Z({ mainBox: ".product-detail", extraBox: [".el-drawer__header", ".header-div"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, b), V = i([["netWeight", ["to-fixed", d.COM_WT__KG]], ["totalNetWeight", ["to-fixed", d.COM_WT__KG]], ["grossWeight", ["to-fixed", d.COM_WT__KG]], ["totalGrossWeight", ["to-fixed", d.COM_WT__KG]], ["createTime", "parse-time"]]);
  function U(t) {
    return ae(t, { props: ["quantity", "netWeight", "totalNetWeight", "grossWeight", "totalGrossWeight"] });
  }
  function z(t) {
    t && t.length ? (l.value.startDate = t[0], l.value.endDate = t[1]) : (l.value.startDate = void 0, l.value.endDate = void 0), f();
  }
  async function f() {
    let t = [];
    h.value = true;
    try {
      const { content: r = [], totalElements: y } = await $({ ...p.detailQuery, ...g, ...l.value, type: ee[p.showType].V });
      t = r, W(y);
    } catch (r) {
      console.log("明细", r);
    } finally {
      v.value = t, h.value = false;
    }
  }
  return (t, r) => {
    const y = L, S = F, a = Q, G = T("common-table"), q = A, I = T("common-drawer"), M = J;
    return u(), c(I, { ref_key: "drawerRef", ref: b, title: o.showType === "INBOUND" ? "入库明细" : o.showType === "OUTBOUND" ? "出库明细" : o.showType === "STOCK" ? "库存明细" : "清单明细", "close-on-click-modal": false, modelValue: n(s), "onUpdate:modelValue": r[1] || (r[1] = (w) => R(s) ? s.value = w : null), direction: "rtl", "before-close": n(C), "custom-class": "product-detail", size: "80%" }, { titleAfter: m(() => [e(y, { size: "large" }, { default: m(() => [j(E(`项目：${n(te)(o.detailInfo.project)}`), 1)]), _: 1 })]), content: m(() => [H("div", oe, [o.showType === "INBOUND" || o.showType === "OUTBOUND" ? (u(), c(S, { key: 0, modelValue: l.value.createTime, "onUpdate:modelValue": r[0] || (r[0] = (w) => l.value.createTime = w), type: "daterange", "range-separator": ":", size: "default", class: "date-item filter-item", "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "margin-bottom": "10px" }, onChange: z }, null, 8, ["modelValue"])) : _("", true)]), K((u(), c(G, { data: v.value, "data-format": V.value, "show-summary": "", "summary-method": U, "max-height": n(B) }, { default: m(() => [e(a, { label: "序号", type: "index", align: "center", width: "60" }), e(a, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": true }), e(a, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": true }), e(a, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), e(a, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": true }), e(a, { key: "length", prop: "length", label: "长度(mm)", align: "center", "show-overflow-tooltip": true }), e(a, { key: "material", prop: "material", label: "材质", align: "center", "show-overflow-tooltip": true }), e(a, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": true }), e(a, { key: "netWeight", prop: "netWeight", label: "单净重（kg）", align: "center", "show-overflow-tooltip": true }), e(a, { key: "grossWeight", prop: "grossWeight", label: "单毛重（kg）", align: "center", "show-overflow-tooltip": true }), e(a, { key: "totalGrossWeight", prop: "totalGrossWeight", label: "总毛重（kg）", align: "center", "show-overflow-tooltip": true }), o.showType === "INBOUND" || o.showType === "OUTBOUND" ? (u(), c(a, { key: "createTime", prop: "createTime", label: o.showType === "INBOUND" ? "入库日期" : "出库日期", align: "center", "show-overflow-tooltip": true }, null, 8, ["label"])) : _("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[M, h.value]]), e(q, { total: n(O), "current-page": n(g).pageNumber, "page-size": n(g).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(N), onCurrentChange: n(D) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  ie as default
};
