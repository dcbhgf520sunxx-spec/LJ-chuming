import { ref as c } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as y } from "vue";
import { createBlock as g } from "vue";
import { withCtx as m } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as R } from "vue";
import { toDisplayString as I } from "vue";
import { unref as n } from "vue";
import { createElementVNode as N } from "vue";
import { normalizeStyle as Y } from "vue";
import { createCommentVNode as _ } from "vue";
import { withDirectives as L } from "vue";
import { isRef as A } from "vue";
import { ElTag as J } from "element-plus";
import { ElDatePicker as $ } from "element-plus";
import { ElTableColumn as X } from "element-plus";
import { ElPagination as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { a as te } from "../../../../../../modules/box-product-receive-send-storage-9ef20b12.js";
import { u as oe, J as ae, o as le, D as f, bM as C, z as ne, ba as re } from "../../../../../../shared/runtime.js";
const ie = { style: { width: "300px", "margin-bottom": "10px" } }, me = { __name: "type-detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, showType: { type: String, default: void 0 }, detailQuery: { type: Object, default: () => {
} }, workshopId: { type: Number }, productType: { type: Number } }, emits: ["update:modelValue", "success"], setup(e, { emit: D }) {
  const B = D, s = c({}), l = e, { visible: u, handleClose: U } = oe({ emit: B, props: l }), { handleSizeChange: W, handleCurrentChange: V, total: z, setTotalPage: S, queryPage: w } = ae({ fetchHook: T });
  Q(u, (r) => {
    var a;
    r && (s.value.dateTime = (a = l.detailQuery) == null ? void 0 : a.dateTime, T());
  });
  const k = c([]), x = c(), b = c(false), { maxHeight: j } = le({ mainBox: ".product-detail", extraBox: [".el-drawer__header", ".header-div"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, x), G = c([["netWeight", ["to-fixed", f.COM_WT__KG]], ["totalNetWeight", ["to-fixed", f.COM_WT__KG]], ["grossWeight", ["to-fixed", f.COM_WT__KG]], ["totalGrossWeight", ["to-fixed", f.COM_WT__KG]], ["createTime", "parse-time"]]);
  function E(r) {
    return re(r, { props: ["quantity", "totalNetWeight", "totalGrossWeight"] });
  }
  async function T() {
    var a;
    let r = [];
    b.value = true;
    try {
      const { content: p = [], totalElements: v } = await te({ projectId: (a = l.detailQuery) == null ? void 0 : a.projectId, workshopId: l.workshopId, productType: l.productType, ...w, ...s.value, type: C[l.showType].V });
      r = p, S(v);
    } catch (p) {
      console.log("明细", p);
    } finally {
      k.value = r, b.value = false;
    }
  }
  return (r, a) => {
    const p = J, v = $, M = h("print-table"), o = X, q = h("table-cell-tag"), P = h("common-table"), H = Z, K = h("common-drawer"), F = ee;
    return y(), g(K, { ref_key: "drawerRef", ref: x, title: e.showType === "INBOUND" ? "入库明细" : e.showType === "OUTBOUND" ? "出库明细" : e.showType === "STOCK" ? "期末库存明细" : e.showType === "BEGINNING" ? "期初库存明细" : "清单明细", "close-on-click-modal": false, modelValue: n(u), "onUpdate:modelValue": a[1] || (a[1] = (d) => A(u) ? u.value = d : null), direction: "rtl", "before-close": n(U), "custom-class": "product-detail", size: "80%" }, { titleAfter: m(() => [t(p, { size: "large" }, { default: m(() => [R(I(`项目：${n(ne)(e.detailInfo.project)}`), 1)]), _: 1 })]), content: m(() => {
      var d;
      return [N("div", { class: "header-div", style: Y(e.showType === "INBOUND" || e.showType === "OUTBOUND" ? "display: flex; justify-content: space-between" : "") }, [e.showType === "INBOUND" || e.showType === "OUTBOUND" ? (y(), g(v, { key: 0, modelValue: s.value.dateTime, "onUpdate:modelValue": a[0] || (a[0] = (i) => s.value.dateTime = i), type: "month", size: "default", class: "date-item filter-item", placeholder: "选择月", format: "YYYY-MM", "value-format": "x", style: { width: "120px", "margin-bottom": "10px" }, onChange: T }, null, 8, ["modelValue"])) : _("", true), N("div", ie, [t(M, { "api-key": e.showType === "INBOUND" ? "boxInboundInventoryDetail" : e.showType === "OUTBOUND" ? "boxOutboundInventoryDetail" : e.showType === "STOCK" ? "boxEndInventoryDetail" : "boxBeginningInventoryDetail", params: { projectId: (d = l.detailQuery) == null ? void 0 : d.projectId, workshopId: l.workshopId, productType: l.productType, ...s.value, type: n(C)[l.showType].V }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"])])], 4), L((y(), g(P, { data: k.value, "data-format": G.value, "show-summary": "", "summary-method": E, "max-height": n(j) - 100 }, { default: m(() => [t(o, { label: "序号", type: "index", align: "center", width: "60" }), t(o, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": true }, { default: m(({ row: i }) => {
        var O;
        return [t(q, { show: !!i.typeName, name: i.typeName, color: i.typeName === "构件" ? "#67C23A" : "#409EFF" }, null, 8, ["show", "name", "color"]), N("span", null, I(i.monomer ? (O = i.monomer) == null ? void 0 : O.name : "-"), 1)];
      }), _: 1 }), t(o, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": true }), t(o, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), t(o, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": true }), t(o, { key: "length", prop: "length", label: "长度(mm)", align: "center", "show-overflow-tooltip": true }), t(o, { key: "material", prop: "material", label: "材质", align: "center", "show-overflow-tooltip": true, width: "80px" }), t(o, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": true, width: "60px" }), t(o, { key: "netWeight", prop: "netWeight", label: "单净重（kg）", align: "center", "show-overflow-tooltip": true }), t(o, { key: "grossWeight", prop: "grossWeight", label: "单毛重（kg）", align: "center", "show-overflow-tooltip": true }), t(o, { key: "totalNetWeight", prop: "totalNetWeight", label: "总净重（kg）", align: "center", "show-overflow-tooltip": true }), t(o, { key: "totalGrossWeight", prop: "totalGrossWeight", label: "总毛重（kg）", align: "center", "show-overflow-tooltip": true }), e.showType === "INBOUND" || e.showType === "OUTBOUND" ? (y(), g(o, { key: "createTime", prop: "createTime", label: e.showType === "INBOUND" ? "入库日期" : "出库日期", align: "center", "show-overflow-tooltip": true }, null, 8, ["label"])) : _("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[F, b.value]]), t(H, { total: n(z), "current-page": n(w).pageNumber, "page-size": n(w).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(W), onCurrentChange: n(V) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])];
    }), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  me as default
};
