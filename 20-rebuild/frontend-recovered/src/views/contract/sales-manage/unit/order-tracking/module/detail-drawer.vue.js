import { ref as b } from "vue";
import { computed as h } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as a } from "vue";
import { createBlock as o } from "vue";
import { withCtx as s } from "vue";
import { createCommentVNode as l } from "vue";
import { unref as i } from "vue";
import { createTextVNode as H } from "vue";
import { createVNode as p } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as w } from "vue";
import { isRef as Q } from "vue";
import { ElMessageBox as Z } from "element-plus";
import { ElNotification as ee } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { a as ae } from "../../../../../../modules/manufactures-sales-return-578c5329.js";
import { _ as oe, o as le, u as re, kG as f, kH as ne, kI as ie, kJ as z, G as T, kK as A, z as se, kL as ue, bV as B, ba as pe } from "../../../../../../shared/runtime.js";
import { m as x } from "../../../../../../modules/ship-manage-3066b2ed.js";
import { j as ce } from "../../../../../../modules/list-valuation-9a754659.js";
const me = { __name: "detail-drawer", props: { visible: { type: Boolean, default: false }, rowData: { type: Object, default: () => {
} }, auditType: { type: String, default: "" } }, emits: ["update:visible", "success"], setup(c, { emit: j }) {
  const S = j, u = c, K = b(), D = b(), V = b(), E = b(false), { maxHeight: O } = le({ paginate: false, extraHeight: 140 }), { visible: R, handleClose: L } = re({ emit: S, props: u, field: "visible", showHook: Y, closeHook: $ });
  async function W() {
    try {
      const { content: e } = await ce({ linkId: u.rowData.cargoListProductLinkId });
      D.value = e;
    } catch (e) {
      console.log(e);
    }
  }
  const q = h(() => u.rowData.productType === f.STRUCTURE.V ? ne : u.rowData.productType === f.ENCLOSURE.V ? ie : {}), v = h(() => {
    var e;
    return ((e = u.rowData) == null ? void 0 : e.productType) === f.AUXILIARY_MATERIAL.V;
  }), y = h(() => {
    var e;
    return ((e = u.rowData) == null ? void 0 : e.productType) === f.ENCLOSURE.V;
  }), m = h(() => {
    var e;
    return ((e = u.rowData) == null ? void 0 : e.productType) === f.STRUCTURE.V;
  }), _ = h(() => {
    var e, r;
    return ((e = u.rowData) == null ? void 0 : e.productType) === f.AUXILIARY_MATERIAL.V && ((r = u.rowData) == null ? void 0 : r.relationType) === z.STRUCTURE.V;
  }), I = h(() => {
    var e, r;
    return ((e = u.rowData) == null ? void 0 : e.productType) === f.AUXILIARY_MATERIAL.V && ((r = u.rowData) == null ? void 0 : r.relationType) === z.ENCLOSURE.V;
  });
  function C(e) {
    const r = { auditRemark: V.value, id: u.rowData.id, auditStatus: e };
    Z.confirm(`是否确认${e === A.CHECKED.V ? "通过" : "驳回"}审核？`, { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      E.value = true, await ae(r), ee({ title: e === A.CHECKED.V ? "审核通过成功" : "审核驳回成功", type: "success", duration: 2500 }), L(), S("success");
    }).catch((g) => {
      console.log(g, "审核通过失败");
    }).finally(() => {
      E.value = false;
    });
  }
  function X(e) {
    return pe(e, { props: ["quantity", ["totalAmount", 3]], toThousandFields: ["totalAmount"] });
  }
  function Y() {
    W();
  }
  function $() {
    V.value = "";
  }
  return (e, r) => {
    const g = k("print-table"), N = k("common-button"), t = te, F = k("common-table"), G = k("common-drawer");
    return a(), o(G, { ref: "drawerRef", modelValue: i(R), "onUpdate:modelValue": r[2] || (r[2] = (n) => Q(R) ? R.value = n : null), "before-close": i(L), "append-to-body": "", direction: "rtl", size: "80%", title: "报废汇总清单" }, { titleAfter: s(() => r[3] || (r[3] = [])), titleRight: s(() => {
      var n, M, U, P;
      return [m.value ? (a(), o(g, { key: 0, params: { linkId: (n = c.rowData) == null ? void 0 : n.cargoListProductLinkId, isSales: true }, "api-key": "shipmentReturnListStructure", class: "print-table", size: "mini", type: "warning" }, null, 8, ["params"])) : l("", true), y.value && i(T)(i(x).detailPrint) ? (a(), o(g, { key: 1, params: { linkId: (M = c.rowData) == null ? void 0 : M.linkId }, "api-key": "shipmentReturnListEnclosure", class: "print-table", size: "mini", type: "warning" }, null, 8, ["params"])) : l("", true), _.value && i(T)(i(x).detailPrint) ? (a(), o(g, { key: 2, params: { linkId: (U = c.rowData) == null ? void 0 : U.linkId }, "api-key": "structureAuxiliarySalesReturnAuditReport", class: "print-table", size: "mini", type: "warning" }, null, 8, ["params"])) : l("", true), I.value && i(T)(i(x).detailPrint) ? (a(), o(g, { key: 3, params: { linkId: (P = c.rowData) == null ? void 0 : P.linkId }, "api-key": "enclosureAuxiliarySalesReturnAuditReport", class: "print-table", size: "mini", type: "warning" }, null, 8, ["params"])) : l("", true), c.auditType === "audit" ? (a(), o(N, { key: 4, size: "mini", type: "danger", onClick: r[0] || (r[0] = (J) => C(i(A).REJRCTED.V)) }, { default: s(() => r[4] || (r[4] = [H("驳回")])), _: 1, __: [4] })) : l("", true), c.auditType === "audit" ? (a(), o(N, { key: 5, loading: E.value, size: "mini", type: "success", onClick: r[1] || (r[1] = (J) => C(i(A).CHECKED.V)) }, { default: s(() => r[5] || (r[5] = [H("审核通过")])), _: 1, __: [5] }, 8, ["loading"])) : l("", true)];
    }), content: s(() => [p(F, { ref_key: "tableRef", ref: K, data: D.value, "max-height": i(O), "summary-method": X, "show-summary": "", style: { width: "100%" } }, { default: s(() => [p(t, { align: "center", label: "序号", type: "index", width: "60" }), p(t, { align: "center", label: "项目", "show-overflow-tooltip": "", width: "120" }, { default: s(({ row: n }) => [d("span", null, w(i(se)(n.project)), 1)]), _: 1 }), m.value || _.value ? (a(), o(t, { key: "monomerName", align: "center", label: "单体", prop: "monomerName", "show-overflow-tooltip": "" })) : l("", true), m.value || _.value ? (a(), o(t, { key: "areaName", align: "center", label: "区域", prop: "areaName", "show-overflow-tooltip": "" })) : l("", true), y.value || I.value ? (a(), o(t, { key: "planName", align: "center", label: "计划", prop: "planName", "show-overflow-tooltip": "" })) : l("", true), p(t, { key: "productName", align: "center", label: "名称", prop: "productName", "show-overflow-tooltip": "" }), v.value ? l("", true) : (a(), o(t, { key: "serialNumber", align: "center", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" })), p(t, { key: "specification", align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "", width: "120px" }), m.value ? (a(), o(t, { key: "length", align: "center", label: "长度（m）", prop: "length", "show-overflow-tooltip": "" })) : l("", true), y.value ? (a(), o(t, { key: "length", align: "center", label: "单长（m）", prop: "length", "show-overflow-tooltip": "" })) : l("", true), y.value ? (a(), o(t, { key: "totalLength", align: "center", label: "总长度（m）", prop: "totalLength", "show-overflow-tooltip": "", width: "100px" })) : l("", true), m.value ? (a(), o(t, { key: "netWeight", align: "center", label: "单重（t）", prop: "netWeight", "show-overflow-tooltip": "" })) : l("", true), m.value ? (a(), o(t, { key: "totalNetWeight", align: "center", label: "总重(t)", prop: "totalNetWeight", "show-overflow-tooltip": "" })) : l("", true), y.value ? (a(), o(t, { key: "surfaceArea", align: "center", label: "单面积（m²）", prop: "surfaceArea", "show-overflow-tooltip": "", width: "100px" }, { default: s((n) => [d("span", null, w(n.row.surfaceArea || "-"), 1)]), _: 1 })) : l("", true), y.value ? (a(), o(t, { key: "totalArea", align: "center", label: "总面积（㎡）", prop: "totalArea", "show-overflow-tooltip": "", width: "100px" }, { default: s((n) => [d("span", null, w(n.row.totalArea || "-"), 1)]), _: 1 })) : l("", true), m.value ? (a(), o(t, { key: "material", align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" })) : l("", true), v.value ? l("", true) : (a(), o(t, { key: "pricingManner", align: "center", label: "计价方式", prop: "pricingManner", "show-overflow-tooltip": "" }, { default: s((n) => [d("span", null, w(q.value.VL[n.row.pricingManner] || "-"), 1)]), _: 1 })), p(t, { key: "handleMethod", align: "center", label: "退货方式", prop: "handleMethod" }, { default: s(({ row: n }) => [d("span", null, w(i(ue).VL[n.handleMethod]), 1)]), _: 1 }), p(t, { key: "quantity", align: "center", label: "数量", prop: "quantity", "show-overflow-tooltip": "" }), v.value ? (a(), o(t, { key: "measureUnit", align: "center", label: "单位", prop: "measureUnit", "show-overflow-tooltip": "" })) : l("", true), v.value ? (a(), o(t, { key: "mete", align: "center", label: "核算量", prop: "mete", "show-overflow-tooltip": "" })) : l("", true), v.value ? (a(), o(t, { key: "accountingUnit", align: "center", label: "核算单位", prop: "accountingUnit", "show-overflow-tooltip": "" })) : l("", true), p(t, { key: "unitPrice", align: "center", label: "单价（元）", prop: "unitPrice", "show-overflow-tooltip": "", width: "100px" }, { default: s((n) => [d("span", null, w(i(B)(n.row.unitPrice, 3) || "-"), 1)]), _: 1 }), p(t, { key: "totalAmount", align: "center", label: "总价（元）", prop: "totalAmount", "show-overflow-tooltip": "", width: "100px" }, { default: s((n) => [d("span", null, w(i(B)(n.row.totalAmount, 3) || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, he = oe(me, [["__scopeId", "data-v-658b63c8"]]);
export {
  he as default
};
