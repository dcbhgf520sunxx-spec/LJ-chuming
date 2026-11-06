import { ref as v } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as P } from "vue";
import { openBlock as k } from "vue";
import { createBlock as W } from "vue";
import { withCtx as l } from "vue";
import { withDirectives as N } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as p } from "vue";
import { isRef as Q } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElPagination as K } from "element-plus";
import { vLoading as R } from "element-plus";
import { i as E, f as X } from "../../../../../../modules/bridge-ship-summary-aa634ae7.js";
import { un as f, u as L, J, o as U, bV as u, D as c, ba as $ } from "../../../../../../shared/runtime.js";
import { n as A } from "../../../../../../modules/ship-manage-3066b2ed.js";
const te = { __name: "detail-drawer", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, query: { type: Object }, workshopId: { type: Number }, projectId: { type: Number }, category: { type: [Number, String], default: f.BOX.V } }, emits: ["update:visible"], setup(g, { emit: C }) {
  const x = C, h = v([]), m = v(false), r = g, { visible: d, handleClose: D } = L({ emit: x, props: r, field: "visible", showHook: _ }), { handleSizeChange: S, handleCurrentChange: j, total: I, setTotalPage: V, queryPage: b } = J({ fetchHook: _ }), { maxHeight: B } = U({ mainBox: ".detail-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, d);
  async function _() {
    h.value = [], m.value = true;
    try {
      const i = r.category === f.BOX.V ? E : X, n = { projectId: r.projectId, ...r.query, workshopId: r.workshopId, ...b }, { content: y = [], totalElements: t } = await i(n);
      h.value = y, V(t), m.value = false;
    } catch (i) {
      console.log("获取详情失败", i), m.value = false;
    }
  }
  function G(i) {
    return $(i, { props: ["quantity", "totalNetWeight", "totalGrossWeight", "inboundQuantity", "cargoQuantity", "cargoQuantity", "cargoNetWeight", "cargoGrossWeight"] });
  }
  return (i, n) => {
    const y = w("print-table"), t = H, O = w("common-table"), z = K, T = w("common-drawer"), q = P("permission"), M = R;
    return k(), W(T, { ref: "drawerRef", "custom-class": "detail-drawer", title: `项目:${g.detailData.project.serialNumber + " " + g.detailData.project.shortName}`, modelValue: e(d), "onUpdate:modelValue": n[0] || (n[0] = (o) => Q(d) ? d.value = o : null), direction: "rtl", "before-close": e(D), size: "70%" }, { titleRight: l(() => [N(a(y, { "api-key": g.category === e(f).BOX.V ? "bridgeProjectDetail" : "bridgeProjectShipDetailDirect", params: { projectId: r.projectId, workshopId: r.workshopId, ...r.query }, size: "default", type: "warning" }, null, 8, ["api-key", "params"]), [[q, e(A).print]])]), content: l(() => [N((k(), W(O, { data: h.value, "show-summary": "", "summary-method": G, "max-height": e(B) - 70 }, { default: l(() => [a(t, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), a(t, { key: "monomerName", prop: "monomerName", label: "单体", align: "center", "show-overflow-tooltip": true }), a(t, { key: "areaName", prop: "areaName", label: "区域", align: "center", "show-overflow-tooltip": true }), a(t, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), a(t, { key: "netWeight", prop: "netWeight", label: "单净重（kg）", align: "center", "show-overflow-tooltip": true }, { default: l((o) => [s("span", null, p(e(u)(o.row.netWeight, e(c).COM_WT__KG)), 1)]), _: 1 }), a(t, { key: "grossWeight", prop: "grossWeight", label: "单毛重（kg）", align: "center", "show-overflow-tooltip": true }, { default: l((o) => [s("span", null, p(e(u)(o.row.grossWeight, e(c).COM_WT__KG)), 1)]), _: 1 }), a(t, { key: "totalNetWeight", prop: "totalNetWeight", label: "总净重（kg）", align: "center", "show-overflow-tooltip": true }, { default: l((o) => [s("span", null, p(e(u)(o.row.totalNetWeight, e(c).COM_WT__KG)), 1)]), _: 1 }), a(t, { key: "totalGrossWeight", prop: "totalGrossWeight（kg）", label: "总毛重（kg）", align: "center", "show-overflow-tooltip": true }, { default: l((o) => [s("span", null, p(e(u)(o.row.totalGrossWeight, e(c).COM_WT__KG)), 1)]), _: 1 }), a(t, { key: "quantity", prop: "quantity", label: "清单数", align: "center", "show-overflow-tooltip": true }), a(t, { key: "inboundQuantity", prop: "inboundQuantity", label: "入库数", align: "center", "show-overflow-tooltip": true }), a(t, { key: "cargoQuantity", prop: "cargoQuantity", label: "发运数", align: "center", "show-overflow-tooltip": true }), a(t, { key: "cargoNetWeight", prop: "cargoNetWeight", label: "发运量（kg）", align: "center", "show-overflow-tooltip": true }, { default: l((o) => [s("span", null, p(e(u)(o.row.cargoNetWeight, e(c).COM_WT__KG)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[M, m.value]]), a(z, { total: e(I), "current-page": e(b).pageNumber, "page-size": e(b).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: e(S), onCurrentChange: e(j) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  te as default
};
