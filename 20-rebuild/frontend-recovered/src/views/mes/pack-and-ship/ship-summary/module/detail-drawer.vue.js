import { ref as y } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as f } from "vue";
import { createBlock as v } from "vue";
import { withCtx as r } from "vue";
import { withDirectives as W } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as p } from "vue";
import { isRef as O } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { ElPagination as H } from "element-plus";
import { vLoading as K } from "element-plus";
import { i as R } from "../../../../../modules/ship-summary-06293e56.js";
import { u as E, J as L, o as J, oo as U, bV as u, D as c, ba as $ } from "../../../../../shared/runtime.js";
const Y = { __name: "detail-drawer", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, query: { type: Object }, workshopId: { type: Number }, projectId: { type: Number } }, emits: ["update:visible"], setup(d, { emit: k }) {
  const N = k, h = y([]), g = y(false), l = d, { visible: m, handleClose: C } = E({ emit: N, props: l, field: "visible", showHook: b }), { handleSizeChange: x, handleCurrentChange: D, total: I, setTotalPage: j, queryPage: w } = L({ fetchHook: b }), { maxHeight: G } = J({ mainBox: ".detail-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, m);
  async function b() {
    h.value = [], g.value = true;
    try {
      const { content: n = [], totalElements: i } = await R({ projectId: l.projectId, ...l.query, workshopId: l.workshopId, ...w });
      h.value = n, j(i), g.value = false;
    } catch (n) {
      console.log("获取详情失败", n), g.value = false;
    }
  }
  function z(n) {
    return $(n, { props: ["quantity", "totalNetWeight", "totalGrossWeight", "inboundQuantity", "cargoQuantity", "cargoQuantity", "cargoNetWeight", "cargoGrossWeight"] });
  }
  return (n, i) => {
    const T = _("print-table"), o = Q, q = _("common-table"), M = H, P = _("common-drawer"), S = B("permission"), V = K;
    return f(), v(P, { ref: "drawerRef", "custom-class": "detail-drawer", title: `项目:${d.detailData.project.serialNumber + " " + d.detailData.project.shortName}`, modelValue: e(m), "onUpdate:modelValue": i[0] || (i[0] = (a) => O(m) ? m.value = a : null), direction: "rtl", "before-close": e(C), size: "70%" }, { titleRight: r(() => [W(t(T, { "api-key": "mesProjectShipDetail", params: { projectId: l.projectId, workshopId: l.workshopId, ...l.query }, size: "default", type: "warning" }, null, 8, ["params"]), [[S, e(U).print]])]), content: r(() => [W((f(), v(q, { data: h.value, "show-summary": "", "summary-method": z, "max-height": e(G) - 70 }, { default: r(() => [t(o, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), t(o, { key: "monomerName", prop: "monomerName", label: "单体", align: "center", "show-overflow-tooltip": true }), t(o, { key: "areaName", prop: "areaName", label: "区域", align: "center", "show-overflow-tooltip": true }), t(o, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), t(o, { key: "netWeight", prop: "netWeight", label: "单净重", align: "center", "show-overflow-tooltip": true }, { default: r((a) => [s("span", null, p(e(u)(a.row.netWeight, e(c).COM_WT__KG)), 1)]), _: 1 }), t(o, { key: "grossWeight", prop: "grossWeight", label: "单毛重", align: "center", "show-overflow-tooltip": true }, { default: r((a) => [s("span", null, p(e(u)(a.row.grossWeight, e(c).COM_WT__KG)), 1)]), _: 1 }), t(o, { key: "totalNetWeight", prop: "totalNetWeight", label: "总净重", align: "center", "show-overflow-tooltip": true }, { default: r((a) => [s("span", null, p(e(u)(a.row.totalNetWeight, e(c).COM_WT__KG)), 1)]), _: 1 }), t(o, { key: "totalGrossWeight", prop: "totalGrossWeight", label: "总毛重", align: "center", "show-overflow-tooltip": true }, { default: r((a) => [s("span", null, p(e(u)(a.row.totalGrossWeight, e(c).COM_WT__KG)), 1)]), _: 1 }), t(o, { key: "quantity", prop: "quantity", label: "清单数", align: "center", "show-overflow-tooltip": true }), t(o, { key: "inboundQuantity", prop: "inboundQuantity", label: "入库数", align: "center", "show-overflow-tooltip": true }), t(o, { key: "cargoQuantity", prop: "cargoQuantity", label: "发运数", align: "center", "show-overflow-tooltip": true }), t(o, { key: "cargoNetWeight", prop: "cargoNetWeight", label: "发运量", align: "center", "show-overflow-tooltip": true }, { default: r((a) => [s("span", null, p(e(u)(a.row.cargoNetWeight, e(c).COM_WT__KG)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[V, g.value]]), t(M, { total: e(I), "current-page": e(w).pageNumber, "page-size": e(w).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: e(x), onCurrentChange: e(D) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  Y as default
};
