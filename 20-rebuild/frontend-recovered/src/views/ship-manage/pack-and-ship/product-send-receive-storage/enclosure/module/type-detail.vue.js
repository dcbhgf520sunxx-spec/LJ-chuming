import { ref as g } from "vue";
import { watch as F } from "vue";
import { resolveComponent as U } from "vue";
import { resolveDirective as $ } from "vue";
import { openBlock as w } from "vue";
import { createBlock as f } from "vue";
import { withCtx as N } from "vue";
import { createVNode as r } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as S } from "vue";
import { unref as l } from "vue";
import { createElementVNode as B } from "vue";
import { normalizeStyle as A } from "vue";
import { createCommentVNode as k } from "vue";
import { withDirectives as x } from "vue";
import { isRef as J } from "vue";
import { ElTag as W } from "element-plus";
import { ElDatePicker as X } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElPagination as ee } from "element-plus";
import { vLoading as te } from "element-plus";
import { e as ae } from "../../../../../../modules/enclosure-product-receive-send-storage-2e87d697.js";
import { u as oe, J as le, o as ne, bM as V, z as re, uj as se, c as z, D as j } from "../../../../../../shared/runtime.js";
const ie = { style: { width: "300px", "margin-bottom": "10px" } }, pe = { __name: "type-detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, showType: { type: String, default: void 0 }, detailQuery: { type: Object, default: () => {
} }, workshopId: { type: Number }, productType: { type: Number }, category: { type: Number } }, emits: ["update:modelValue", "success"], setup(e, { emit: L }) {
  const M = L, y = g({}), a = e, { visible: T, handleClose: P } = oe({ emit: M, props: a }), { handleSizeChange: q, handleCurrentChange: G, total: R, setTotalPage: H, queryPage: b } = le({ fetchHook: O });
  F(T, (u) => {
    var n;
    u && (y.value.dateTime = (n = a.detailQuery) == null ? void 0 : n.dateTime, O());
  });
  const C = g([]), E = g(), I = g(false), { maxHeight: K } = ne({ mainBox: ".product-detail", extraBox: [".el-drawer__header", ".header-div"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, E), Q = g([["createTime", "parse-time"]]);
  function Y(u) {
    const { columns: n, data: s } = u, i = [];
    return n.forEach((d, o) => {
      if (o === 0) {
        i[o] = "合计";
        return;
      }
      if (d.property === "quantity") {
        const c = s.map((t) => Number(t[d.property]));
        let m = 0;
        c.every((t) => isNaN(t)) || (m = c.reduce((t, p) => {
          const h = Number(p);
          return isNaN(h) ? t : t + p;
        }, 0)), i[o] = m;
      }
      if (d.property === "totalLength") {
        const c = s.map((t) => Number(t[d.property]));
        let m = 0;
        c.every((t) => isNaN(t)) || (m = c.reduce((t, p) => {
          const h = Number(p);
          return isNaN(h) ? t : t + p;
        }, 0)), i[o] = z(m, "mm", "m", j.MES_ENCLOSURE_L__M);
      }
    }), i;
  }
  async function O() {
    var n;
    let u = [];
    I.value = true;
    try {
      const { content: s = [], totalElements: i } = await ae({ projectId: (n = a.detailQuery) == null ? void 0 : n.projectId, workshopId: a.workshopId, productType: a.productType, category: a.category, ...b, ...y.value, type: V[a.showType].V });
      u = s, H(i);
    } catch (s) {
      console.log("明细", s);
    } finally {
      C.value = u, I.value = false;
    }
  }
  return (u, n) => {
    const s = W, i = X, d = U("print-table"), o = Z, c = U("common-table"), m = ee, t = U("common-drawer"), p = $("permission"), h = te;
    return w(), f(t, { ref_key: "drawerRef", ref: E, title: e.showType === "INBOUND" ? "入库明细" : e.showType === "OUTBOUND" ? "出库明细" : e.showType === "STOCK" ? "期末库存明细" : e.showType === "BEGINNING" ? "期初库存明细" : "清单明细", "close-on-click-modal": false, modelValue: l(T), "onUpdate:modelValue": n[1] || (n[1] = (v) => J(T) ? T.value = v : null), direction: "rtl", "before-close": l(P), "custom-class": "product-detail", size: "80%" }, { titleAfter: N(() => [r(s, { size: "large" }, { default: N(() => [_(S(`项目：${l(re)(e.detailInfo.project)}`), 1)]), _: 1 })]), content: N(() => {
      var v;
      return [B("div", { class: "header-div", style: A(e.showType === "INBOUND" || e.showType === "OUTBOUND" ? "display: flex; justify-content: space-between" : "") }, [e.showType === "INBOUND" || e.showType === "OUTBOUND" ? (w(), f(i, { key: 0, modelValue: y.value.dateTime, "onUpdate:modelValue": n[0] || (n[0] = (D) => y.value.dateTime = D), type: "month", size: "default", class: "date-item filter-item", placeholder: "选择月", format: "YYYY-MM", "value-format": "x", style: { width: "120px", "margin-bottom": "10px" }, onChange: O }, null, 8, ["modelValue"])) : k("", true), B("div", ie, [x(r(d, { "api-key": e.showType === "INBOUND" ? "enclosureInboundInventoryDetail" : e.showType === "OUTBOUND" ? "enclosureOutboundInventoryDetail" : e.showType === "STOCK" ? "enclosureEndInventoryDetail" : "enclosureBeginningInventoryDetail", params: { projectId: (v = a.detailQuery) == null ? void 0 : v.projectId, workshopId: a.workshopId, productType: a.productType, category: a.category, ...y.value, type: l(V)[a.showType].V }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[p, e.permission.detailPrint]])])], 4), x((w(), f(c, { data: C.value, "data-format": Q.value, "show-summary": "", "summary-method": Y, "max-height": l(K) - 100 }, { default: N(() => [r(o, { label: "序号", type: "index", align: "center", width: "60" }), r(o, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true }), r(o, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), a.category !== l(se).FOLDING_PIECE.V ? (w(), f(o, { key: "plate", prop: "plate", label: "板型", align: "center", "show-overflow-tooltip": true })) : k("", true), r(o, { key: "length", prop: "length", label: "单长（mm）", align: "center", "show-overflow-tooltip": true }), r(o, { key: "quantity", prop: "quantity", label: `${e.showType === "INBOUND" ? "入库" : e.showType === "OUTBOUND" ? "出库" : e.showType === "STOCK" ? "期末" : e.showType === "BEGINNING" ? "期初" : "清单"}数（件）`, align: "center", "show-overflow-tooltip": true }, null, 8, ["label"]), r(o, { key: "totalLength", prop: "totalLength", label: `${e.showType === "INBOUND" ? "入库" : e.showType === "OUTBOUND" ? "出库" : e.showType === "STOCK" ? "期末" : e.showType === "BEGINNING" ? "期初" : "清单"}量（m）`, align: "center", "show-overflow-tooltip": true }, { default: N(({ row: D }) => [B("span", null, S(l(z)(D.totalLength, "mm", "m", l(j).MES_ENCLOSURE_L__M) || 0), 1)]), _: 1 }, 8, ["label"]), e.showType === "INBOUND" || e.showType === "OUTBOUND" ? (w(), f(o, { key: "createTime", prop: "createTime", label: e.showType === "INBOUND" ? "入库日期" : "出库日期", align: "center", "show-overflow-tooltip": true }, null, 8, ["label"])) : k("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[h, I.value]]), r(m, { total: l(R), "current-page": l(b).pageNumber, "page-size": l(b).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(q), onCurrentChange: l(G) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])];
    }), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  pe as default
};
