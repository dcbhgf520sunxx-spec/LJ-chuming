import { ref as A } from "vue";
import { computed as k } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as t } from "vue";
import { createBlock as o } from "vue";
import { withCtx as i } from "vue";
import { unref as u } from "vue";
import { createCommentVNode as a } from "vue";
import { createTextVNode as w } from "vue";
import { createVNode as c } from "vue";
import { toDisplayString as p } from "vue";
import { createElementBlock as T } from "vue";
import { Fragment as K } from "vue";
import { createElementVNode as m } from "vue";
import { renderList as re } from "vue";
import { isRef as ne } from "vue";
import { ElMessageBox as ie } from "element-plus";
import { ElNotification as se } from "element-plus";
import { ElDescriptionsItem as ue } from "element-plus";
import { ElDescriptions as ce } from "element-plus";
import { ElTableColumn as pe } from "element-plus";
import { ElImage as de } from "element-plus";
import { ElInput as me } from "element-plus";
import { g as we, a as fe } from "../../../../../modules/manufactures-sales-return-578c5329.js";
import { _ as ye, o as be, u as ge, kG as b, kH as ve, kI as he, kJ as O, G as V, kK as L, kL as W, bV as Y, ba as ke } from "../../../../../shared/runtime.js";
import { m as S } from "../../../../../modules/ship-manage-3066b2ed.js";
const Ee = { class: "remark-info" }, De = { class: "remark-info-text" }, Re = { key: 0, class: "remark-info" }, Ae = { class: "remark-info-text" }, xe = { key: 1, class: "remark-info" }, Te = { class: "imgs-box", style: { width: "100%" } }, Ve = { __name: "audit", props: { visible: { type: Boolean, default: false }, rowData: { type: Object, default: () => {
} }, auditType: { type: String, default: "" } }, emits: ["update:visible", "success"], setup(n, { emit: $ }) {
  const _ = $, d = n, j = A(), M = A(), D = A(), C = A(false), { maxHeight: q } = be({ paginate: false, extraHeight: 140 }), { visible: N, handleClose: I } = ge({ emit: _, props: d, field: "visible", showHook: J, closeHook: Q });
  async function F() {
    try {
      const l = await we({ id: d.rowData.id });
      M.value = l;
    } catch (l) {
      console.log(l);
    }
  }
  const X = k(() => d.rowData.productType === b.STRUCTURE.V ? ve : d.rowData.productType === b.ENCLOSURE.V ? he : {}), E = k(() => {
    var l;
    return ((l = d.rowData) == null ? void 0 : l.productType) === b.AUXILIARY_MATERIAL.V;
  }), g = k(() => {
    var l;
    return ((l = d.rowData) == null ? void 0 : l.productType) === b.ENCLOSURE.V;
  }), f = k(() => {
    var l;
    return ((l = d.rowData) == null ? void 0 : l.productType) === b.STRUCTURE.V;
  }), U = k(() => {
    var l, e;
    return ((l = d.rowData) == null ? void 0 : l.productType) === b.AUXILIARY_MATERIAL.V && ((e = d.rowData) == null ? void 0 : e.relationType) === O.STRUCTURE.V;
  }), P = k(() => {
    var l, e;
    return ((l = d.rowData) == null ? void 0 : l.productType) === b.AUXILIARY_MATERIAL.V && ((e = d.rowData) == null ? void 0 : e.relationType) === O.ENCLOSURE.V;
  });
  function H(l) {
    const e = { auditRemark: D.value, id: d.rowData.id, auditStatus: l };
    ie.confirm(`是否确认${l === L.CHECKED.V ? "通过" : "驳回"}审核？`, { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      C.value = true, await fe(e), se({ title: l === L.CHECKED.V ? "审核通过成功" : "审核驳回成功", type: "success", duration: 2500 }), I(), _("success");
    }).catch((v) => {
      console.log(v, "审核通过失败");
    }).finally(() => {
      C.value = false;
    });
  }
  function G(l) {
    return ke(l, { props: ["quantity", ["totalAmount", 3]], toThousandFields: ["totalAmount"] });
  }
  function J() {
    F();
  }
  function Q() {
    D.value = "";
  }
  return (l, e) => {
    const v = x("print-table"), z = x("common-button"), h = ue, Z = ce, r = pe, ee = x("common-table"), te = de, ae = me, le = x("common-drawer");
    return t(), o(le, { "append-to-body": "", ref: "drawerRef", title: "报废汇总清单", modelValue: u(N), "onUpdate:modelValue": e[3] || (e[3] = (y) => ne(N) ? N.value = y : null), direction: "rtl", "before-close": u(I), size: "70%" }, { titleAfter: i(() => e[4] || (e[4] = [])), titleRight: i(() => {
      var y, s, R, B;
      return [f.value && u(V)(u(S).detailPrint) ? (t(), o(v, { key: 0, "api-key": "structureSalesReturnAuditReport", params: { id: (y = n.rowData) == null ? void 0 : y.id }, size: "default", type: "warning", class: "print-table" }, null, 8, ["params"])) : a("", true), g.value && u(V)(u(S).detailPrint) ? (t(), o(v, { key: 1, "api-key": "enclosureSalesReturnAuditReport", params: { id: (s = n.rowData) == null ? void 0 : s.id }, size: "default", type: "warning", class: "print-table" }, null, 8, ["params"])) : a("", true), U.value && u(V)(u(S).detailPrint) ? (t(), o(v, { key: 2, "api-key": "structureAuxiliarySalesReturnAuditReport", params: { id: (R = n.rowData) == null ? void 0 : R.id }, size: "default", type: "warning", class: "print-table" }, null, 8, ["params"])) : a("", true), P.value && u(V)(u(S).detailPrint) ? (t(), o(v, { key: 3, "api-key": "enclosureAuxiliarySalesReturnAuditReport", params: { id: (B = n.rowData) == null ? void 0 : B.id }, size: "default", type: "warning", class: "print-table" }, null, 8, ["params"])) : a("", true), n.auditType === "audit" ? (t(), o(z, { key: 4, type: "danger", size: "default", onClick: e[0] || (e[0] = (oe) => H(u(L).REJRCTED.V)) }, { default: i(() => e[5] || (e[5] = [w("驳回")])), _: 1, __: [5] })) : a("", true), n.auditType === "audit" ? (t(), o(z, { key: 5, loading: C.value, type: "success", size: "default", onClick: e[1] || (e[1] = (oe) => H(u(L).CHECKED.V)) }, { default: i(() => e[6] || (e[6] = [w("审核通过")])), _: 1, __: [6] }, 8, ["loading"])) : a("", true)];
    }), content: i(() => {
      var y;
      return [c(Z, { class: "descriptions", column: 2, border: "" }, { default: i(() => [c(h, { "label-class-name": "contractLabel", label: "项目" }, { default: i(() => [w(p(n.rowData.projectName || "-"), 1)]), _: 1 }), c(h, { "label-class-name": "contractLabel", label: "处理方式" }, { default: i(() => [w(p(u(W).VL[n.rowData.handleMethod] || "-"), 1)]), _: 1 }), n.rowData.handleMethod === u(W).RECYCLE.V ? (t(), T(K, { key: 0 }, [c(h, { "label-class-name": "contractLabel", label: "购买方" }, { default: i(() => [w(p(n.rowData.branchCompanyName || "-"), 1)]), _: 1 }), c(h, { "label-class-name": "contractLabel", label: "出售方" }, { default: i(() => [w(p(n.rowData.customerUnit || "-"), 1)]), _: 1 })], 64)) : a("", true), c(h, { "label-class-name": "contractLabel", label: "编号" }, { default: i(() => [w(p(n.rowData.serialNumber || "-"), 1)]), _: 1 }), c(h, { "label-class-name": "contractLabel", label: "审核人" }, { default: i(() => [w(p(n.rowData.auditUserName || "-"), 1)]), _: 1 })]), _: 1 }), c(ee, { ref_key: "tableRef", ref: j, data: M.value, "max-height": u(q), style: { width: "100%" }, "show-summary": "", "summary-method": G }, { default: i(() => [c(r, { label: "序号", type: "index", align: "center", width: "60" }), f.value || U.value ? (t(), o(r, { "show-overflow-tooltip": "", prop: "monomerName", key: "monomerName", label: "单体", align: "center" })) : a("", true), f.value || U.value ? (t(), o(r, { "show-overflow-tooltip": "", prop: "areaName", key: "areaName", label: "区域", align: "center" })) : a("", true), g.value || P.value ? (t(), o(r, { "show-overflow-tooltip": "", prop: "planName", key: "planName", label: "计划", align: "center" })) : a("", true), c(r, { "show-overflow-tooltip": "", prop: "productName", key: "productName", label: "名称", align: "center" }), E.value ? a("", true) : (t(), o(r, { "show-overflow-tooltip": "", prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" })), c(r, { "show-overflow-tooltip": "", prop: "specification", key: "specification", label: "规格", align: "center", width: "120px" }), f.value ? (t(), o(r, { "show-overflow-tooltip": "", prop: "length", key: "length", label: "长度（m）", align: "center" })) : a("", true), g.value ? (t(), o(r, { "show-overflow-tooltip": "", prop: "length", key: "length", label: "单长（m）", align: "center" })) : a("", true), g.value ? (t(), o(r, { "show-overflow-tooltip": "", prop: "totalLength", key: "totalLength", label: "总长度（m）", align: "center", width: "100px" })) : a("", true), f.value ? (t(), o(r, { "show-overflow-tooltip": "", prop: "netWeight", key: "netWeight", label: "单重（t）", align: "center" })) : a("", true), f.value ? (t(), o(r, { "show-overflow-tooltip": "", prop: "totalNetWeight", key: "totalNetWeight", label: "总重(t)", align: "center" })) : a("", true), g.value ? (t(), o(r, { "show-overflow-tooltip": "", prop: "surfaceArea", key: "surfaceArea", label: "单面积（m²）", align: "center", width: "100px" }, { default: i((s) => [m("span", null, p(s.row.surfaceArea || "-"), 1)]), _: 1 })) : a("", true), g.value ? (t(), o(r, { "show-overflow-tooltip": "", prop: "totalArea", key: "totalArea", label: "总面积（㎡）", width: "100px", align: "center" }, { default: i((s) => [m("span", null, p(s.row.totalArea || "-"), 1)]), _: 1 })) : a("", true), f.value ? (t(), o(r, { "show-overflow-tooltip": "", prop: "material", key: "material", label: "材质", align: "center" })) : a("", true), E.value ? a("", true) : (t(), o(r, { "show-overflow-tooltip": "", prop: "pricingManner", key: "pricingManner", label: "计价方式", align: "center" }, { default: i((s) => [m("span", null, p(X.value.VL[s.row.pricingManner] || "-"), 1)]), _: 1 })), c(r, { "show-overflow-tooltip": "", prop: "quantity", key: "quantity", label: "数量", align: "center" }), E.value ? (t(), o(r, { "show-overflow-tooltip": "", prop: "measureUnit", key: "measureUnit", label: "单位", align: "center" })) : a("", true), E.value ? (t(), o(r, { "show-overflow-tooltip": "", prop: "mete", key: "mete", label: "核算量", align: "center" })) : a("", true), E.value ? (t(), o(r, { "show-overflow-tooltip": "", prop: "accountingUnit", key: "accountingUnit", label: "核算单位", align: "center" })) : a("", true), c(r, { "show-overflow-tooltip": "", prop: "unitPrice", key: "unitPrice", label: "单价（元）", align: "center", width: "100px" }, { default: i((s) => [m("span", null, p(u(Y)(s.row.unitPrice, 3) || "-"), 1)]), _: 1 }), c(r, { "show-overflow-tooltip": "", prop: "totalAmount", key: "totalAmount", label: "总价（元）", align: "center", width: "100px" }, { default: i((s) => [m("span", null, p(u(Y)(s.row.totalAmount, 3) || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), m("div", Ee, [e[7] || (e[7] = m("span", null, "创建人备注:", -1)), e[8] || (e[8] = w()), m("span", De, p(n.rowData.remark || "-"), 1)]), n.auditType === "view" ? (t(), T("div", Re, [e[9] || (e[9] = m("span", null, "审核人备注:", -1)), e[10] || (e[10] = w()), m("span", Ae, p(n.rowData.auditRemark || "-"), 1)])) : a("", true), (y = n.rowData.attachmentList) != null && y.length ? (t(), T("div", xe, [e[11] || (e[11] = m("span", null, "图片:", -1)), m("div", Te, [(t(true), T(K, null, re(n.rowData.attachmentList, (s) => (t(), o(te, { "preview-src-list": n.rowData.attachmentList.map((R) => R.imageUrl), "initial-index": 1, key: s.id, src: s.imageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"]))), 128))])])) : a("", true), n.auditType === "audit" ? (t(), o(ae, { key: 2, class: "remark", type: "textarea", placeholder: "备注说明", maxlength: "200", "show-word-limit": "", modelValue: D.value, "onUpdate:modelValue": e[2] || (e[2] = (s) => D.value = s) }, null, 8, ["modelValue"])) : a("", true)];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ue = ye(Ve, [["__scopeId", "data-v-347c7f70"]]);
export {
  Ue as default
};
