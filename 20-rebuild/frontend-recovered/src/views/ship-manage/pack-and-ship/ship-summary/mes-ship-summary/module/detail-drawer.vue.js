import { ref as k } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as H } from "vue";
import { openBlock as w } from "vue";
import { createBlock as D } from "vue";
import { withCtx as l } from "vue";
import { withDirectives as S } from "vue";
import { createVNode as e } from "vue";
import { unref as t } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as s } from "vue";
import { createElementBlock as x } from "vue";
import { isRef as K } from "vue";
import { ElDatePicker as L } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { ElPagination as A } from "element-plus";
import { vLoading as J } from "element-plus";
import { m as F, n as X } from "../../../../../../modules/ship-summary-d5d4a58f.js";
import { uo as W, u as Y, J as Z, o as ee, bV as c, D as u, p as te, ba as oe } from "../../../../../../shared/runtime.js";
import { q as ae } from "../../../../../../modules/ship-manage-3066b2ed.js";
const le = { key: 0 }, re = { key: 1 }, ce = { __name: "detail-drawer", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, query: { type: Object }, workshopId: { type: Number }, projectId: { type: Number }, category: { type: [Number, String], default: W.STRUCTURE.V } }, emits: ["update:visible", "changeDate"], setup(g, { emit: T }) {
  const N = T, m = k([]), h = k(false), n = g, { visible: d, handleClose: V } = Y({ emit: N, props: n, field: "visible", showHook: _ }), { handleSizeChange: G, handleCurrentChange: j, total: I, setTotalPage: R, queryPage: b } = Z({ fetchHook: _ }), C = k([]), { maxHeight: P } = ee({ mainBox: ".detail-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, d), q = (r) => {
    console.log(r), N("changeDate", r), _();
  };
  async function _() {
    m.value = [], h.value = true;
    try {
      const r = n.category === W.STRUCTURE.V ? F : X, i = { projectId: n.projectId, ...n.query, workshopId: n.workshopId, ...b }, { content: f = [], totalElements: v } = await r(i);
      m.value = f, R(v), h.value = false, console.log(m.value);
    } catch (r) {
      console.log("获取详情失败", r), h.value = false;
    }
  }
  function z(r) {
    return oe(r, { props: ["quantity", "totalNetWeight", "totalGrossWeight", "inboundQuantity", "cargoQuantity", "cargoQuantity", "cargoNetWeight", "cargoGrossWeight", "inventory", "inventoryNetWeight", "inventoryGrossWeight"] });
  }
  return (r, i) => {
    const f = y("print-table"), v = L, o = $, E = y("table-cell-tag"), B = y("common-table"), M = A, U = y("common-drawer"), O = H("permission"), Q = J;
    return w(), D(U, { ref: "drawerRef", "custom-class": "detail-drawer", title: `项目:${g.detailData.project.serialNumber + " " + g.detailData.project.shortName}`, modelValue: t(d), "onUpdate:modelValue": i[1] || (i[1] = (a) => K(d) ? d.value = a : null), direction: "rtl", "before-close": t(V), size: "70%" }, { titleRight: l(() => [S(e(f, { "api-key": g.category === t(W).STRUCTURE.V ? "mesProjectShipDetail" : "mesProjectShipDetailDirect", params: { projectId: n.projectId, workshopId: n.workshopId, ...n.query }, size: "default", type: "warning" }, null, 8, ["api-key", "params"]), [[O, t(ae).print]])]), content: l(() => [e(v, { modelValue: C.value, "onUpdate:modelValue": i[0] || (i[0] = (a) => C.value = a), "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { "margin-bottom": "20px" }, "value-format": "x", type: "daterange", onChange: q }, null, 8, ["modelValue"]), S((w(), D(B, { data: m.value, "show-summary": "", "summary-method": z, style: { width: "100%" }, "max-height": t(P) - 70 }, { default: l(() => [e(o, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), e(o, { key: "monomerName", prop: "monomerName", label: "单体", align: "center", "show-overflow-tooltip": true }, { default: l(({ row: a }) => [e(E, { show: a.boolAllPartSendDirectly, name: "檩条直发", color: "#f56c6c" }, null, 8, ["show"]), p("span", null, s(a.monomerName), 1)]), _: 1 }), e(o, { key: "areaName", prop: "areaName", label: "区域", align: "center", "show-overflow-tooltip": true }), e(o, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true }), e(o, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), e(o, { key: "material", prop: "material", label: "材质", align: "center", "show-overflow-tooltip": true }), e(o, { key: "netWeight", prop: "netWeight", label: "单净重（kg）", align: "center", "show-overflow-tooltip": true }, { default: l((a) => [p("span", null, s(t(c)(a.row.netWeight, t(u).COM_WT__KG)), 1)]), _: 1 }), e(o, { key: "grossWeight", prop: "grossWeight", label: "单毛重（kg）", align: "center", "show-overflow-tooltip": true }, { default: l((a) => [p("span", null, s(t(c)(a.row.grossWeight, t(u).COM_WT__KG)), 1)]), _: 1 }), e(o, { key: "totalNetWeight", prop: "totalNetWeight", label: "总净重（kg）", align: "center", "show-overflow-tooltip": true }, { default: l((a) => [p("span", null, s(t(c)(a.row.totalNetWeight, t(u).COM_WT__KG)), 1)]), _: 1 }), e(o, { key: "totalGrossWeight", prop: "totalGrossWeight", label: "总毛重（kg）", align: "center", "show-overflow-tooltip": true }, { default: l((a) => [p("span", null, s(t(c)(a.row.totalGrossWeight, t(u).COM_WT__KG)), 1)]), _: 1 }), e(o, { key: "quantity", prop: "quantity", label: "清单数", align: "center", "show-overflow-tooltip": true }), e(o, { key: "inboundQuantity", prop: "inboundQuantity", label: "入库数", align: "center", "show-overflow-tooltip": true }), e(o, { key: "cargoQuantity", prop: "cargoQuantity", label: "发运数", align: "center", "show-overflow-tooltip": true }), e(o, { key: "cargoNetWeight", prop: "cargoNetWeight", label: "发运量（kg）", align: "center", "show-overflow-tooltip": true }, { default: l((a) => [p("span", null, s(t(c)(a.row.cargoNetWeight, t(u).COM_WT__KG)), 1)]), _: 1 }), e(o, { key: "cargoDate", label: "发运时间", align: "center", "show-overflow-tooltip": true }, { default: l(({ row: a }) => [a.cargoDate ? (w(), x("span", le, s(`${t(te)(a.cargoDate, "{y}-{m}-{d}")}`), 1)) : (w(), x("span", re, "-"))]), _: 1 }), e(o, { key: "inventory", prop: "inventory", label: "库存数", align: "center", "show-overflow-tooltip": true }), e(o, { key: "inventoryNetWeight", prop: "inventoryNetWeight", label: "库存净重", align: "center", "show-overflow-tooltip": true }), e(o, { key: "inventoryGrossWeight", prop: "inventoryGrossWeight", label: "库存毛重", align: "center", "show-overflow-tooltip": true }), e(o, { key: "remark", prop: "remark", label: "备注", align: "center", "min-width": "120", "show-overflow-tooltip": true })]), _: 1 }, 8, ["data", "max-height"])), [[Q, h.value]]), e(M, { total: t(I), "current-page": t(b).pageNumber, "page-size": t(b).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(G), onCurrentChange: t(j) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  ce as default
};
