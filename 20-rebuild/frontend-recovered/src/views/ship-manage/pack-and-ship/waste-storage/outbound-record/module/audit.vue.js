import { ref as v } from "vue";
import { computed as g } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as o } from "vue";
import { createBlock as l } from "vue";
import { withCtx as n } from "vue";
import { createVNode as c } from "vue";
import { createTextVNode as m } from "vue";
import { toDisplayString as d } from "vue";
import { unref as s } from "vue";
import { createCommentVNode as r } from "vue";
import { createElementBlock as B } from "vue";
import { Fragment as ie } from "vue";
import { withDirectives as se } from "vue";
import { createElementVNode as f } from "vue";
import { isRef as ue } from "vue";
import { ElMessageBox as ce } from "element-plus";
import { ElNotification as de } from "element-plus";
import { ElTag as pe } from "element-plus";
import { ElDescriptionsItem as me } from "element-plus";
import { ElDescriptions as fe } from "element-plus";
import { ElTableColumn as we } from "element-plus";
import { ElInput as ye } from "element-plus";
import { vLoading as ge } from "element-plus";
import { l as L, _ as be, o as ve, u as ke, kG as w, kH as he, kI as Ee, kJ as W, G as T, kK as A, ur as O, bV as $, ba as De } from "../../../../../../shared/runtime.js";
import { v as _ } from "../../../../../../modules/ship-manage-3066b2ed.js";
function Te(t) {
  return L({ url: "/api/project/wasteProductMain/page", method: "get", params: t });
}
function Ae(t) {
  return L({ url: "/api/project/wasteProductChild/getWasteProductChild", method: "get", params: t });
}
function _e(t) {
  return L({ url: "/api/project/wasteProductMain/audit", method: "post", data: t });
}
const Ne = { get: Te };
const Re = { class: "remark-info" }, Se = { class: "remark-info-text" }, Ve = { key: 0, class: "remark-info" }, xe = { class: "remark-info-text" }, Ce = { __name: "audit", props: { visible: { type: Boolean, default: false }, rowData: { type: Object, default: () => {
} }, auditType: { type: String, default: "" } }, emits: ["update:visible", "success"], setup(t, { emit: q }) {
  const M = q, p = t, K = v(), P = v(), k = v(), R = v(false), S = v(false), { maxHeight: F } = ve({ paginate: false, extraHeight: 140 }), { visible: V, handleClose: U } = ke({ emit: M, props: p, field: "visible", showHook: Z, closeHook: ee });
  async function X() {
    try {
      S.value = true;
      const a = await Ae({ id: p.rowData.id });
      P.value = a;
    } catch (a) {
      console.log(a);
    } finally {
      S.value = false;
    }
  }
  const Y = g(() => p.rowData.productType === w.STRUCTURE.V ? he : p.rowData.productType === w.ENCLOSURE.V ? Ee : {}), b = g(() => {
    var a;
    return ((a = p.rowData) == null ? void 0 : a.productType) === w.AUXILIARY_MATERIAL.V;
  }), x = g(() => {
    var a;
    return ((a = p.rowData) == null ? void 0 : a.productType) === w.ENCLOSURE.V;
  }), h = g(() => {
    var a;
    return ((a = p.rowData) == null ? void 0 : a.productType) === w.STRUCTURE.V;
  }), G = g(() => {
    var a, e;
    return ((a = p.rowData) == null ? void 0 : a.productType) === w.AUXILIARY_MATERIAL.V && ((e = p.rowData) == null ? void 0 : e.relationType) === W.STRUCTURE.V;
  }), J = g(() => {
    var a, e;
    return ((a = p.rowData) == null ? void 0 : a.productType) === w.AUXILIARY_MATERIAL.V && ((e = p.rowData) == null ? void 0 : e.relationType) === W.ENCLOSURE.V;
  });
  function N(a) {
    const e = { auditRemark: k.value, id: p.rowData.id, auditStatus: a };
    ce.confirm(`是否确认${a === A.CHECKED.V ? "通过" : "驳回"}审核？`, { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      R.value = true, await _e(e), de({ title: a === A.CHECKED.V ? "审核通过成功" : "审核驳回成功", type: "success", duration: 2500 }), U(), M("success");
    }).catch((C) => {
      console.log(C, "审核失败");
    }).finally(() => {
      R.value = false;
    });
  }
  function Q(a) {
    return De(a, { props: ["quantity", ["totalAmount", 3]], toThousandFields: ["totalAmount"] });
  }
  function Z() {
    X();
  }
  function ee() {
    k.value = "";
  }
  return (a, e) => {
    const C = pe, E = D("print-table"), I = D("common-button"), y = me, te = fe, u = we, ae = D("common-table"), oe = ye, le = D("common-drawer"), re = ge;
    return o(), l(le, { "append-to-body": "", ref: "drawerRef", title: "废品清单", modelValue: s(V), "onUpdate:modelValue": e[3] || (e[3] = (i) => ue(V) ? V.value = i : null), direction: "rtl", "before-close": s(U), size: "70%" }, { titleAfter: n(() => [c(C, { effect: "plain", size: "large" }, { default: n(() => {
      var i;
      return [m(" 项目： " + d(((i = t.rowData) == null ? void 0 : i.projectName) || "-"), 1)];
    }), _: 1 })]), titleRight: n(() => {
      var i, H, j, z;
      return [h.value && s(T)(s(_).detailPrint) ? (o(), l(E, { key: 0, "api-key": "structureWasteStorageAuditReport", params: { id: (i = t.rowData) == null ? void 0 : i.id }, size: "default", type: "warning", class: "print-table" }, null, 8, ["params"])) : r("", true), x.value && s(T)(s(_).detailPrint) ? (o(), l(E, { key: 1, "api-key": "enclosureWasteStorageAuditReport", params: { id: (H = t.rowData) == null ? void 0 : H.id }, size: "default", type: "warning", class: "print-table" }, null, 8, ["params"])) : r("", true), G.value && s(T)(s(_).detailPrint) ? (o(), l(E, { key: 2, "api-key": "structureAuxiliaryWasteStorageAuditReport", params: { id: (j = t.rowData) == null ? void 0 : j.id }, size: "default", type: "warning", class: "print-table" }, null, 8, ["params"])) : r("", true), J.value && s(T)(s(_).detailPrint) ? (o(), l(E, { key: 3, "api-key": "enclosureAuxiliaryWasteStorageAuditReport", params: { id: (z = t.rowData) == null ? void 0 : z.id }, size: "default", type: "warning", class: "print-table" }, null, 8, ["params"])) : r("", true), t.auditType === "audit" ? (o(), l(I, { key: 4, type: "danger", size: "default", onClick: e[0] || (e[0] = (ne) => N(s(A).REJRCTED.V)) }, { default: n(() => e[4] || (e[4] = [m("驳回")])), _: 1, __: [4] })) : r("", true), t.auditType === "audit" ? (o(), l(I, { key: 5, loading: R.value, type: "success", size: "default", onClick: e[1] || (e[1] = (ne) => N(s(A).CHECKED.V)) }, { default: n(() => e[5] || (e[5] = [m("审核通过")])), _: 1, __: [5] }, 8, ["loading"])) : r("", true)];
    }), content: n(() => [c(te, { class: "descriptions", column: 2, border: "" }, { default: n(() => [c(y, { "label-class-name": "contractLabel", label: "二次利用项目" }, { default: n(() => [m(d(t.rowData.useProjectName || "-"), 1)]), _: 1 }), c(y, { "label-class-name": "contractLabel", label: "出库方式" }, { default: n(() => [m(d(s(O).VL[t.rowData.wasteHandleMethod] || "-"), 1)]), _: 1 }), t.rowData.wasteHandleMethod === s(O).SELL.V ? (o(), B(ie, { key: 0 }, [c(y, { "label-class-name": "contractLabel", label: "购买方" }, { default: n(() => [m(d(t.rowData.purchaser || "-"), 1)]), _: 1 }), c(y, { "label-class-name": "contractLabel", label: "出售方" }, { default: n(() => [m(d(t.rowData.branchCompanyName || "-"), 1)]), _: 1 })], 64)) : r("", true), c(y, { "label-class-name": "contractLabel", label: "出库单号" }, { default: n(() => [m(d(t.rowData.serialNumber || "-"), 1)]), _: 1 }), c(y, { "label-class-name": "contractLabel", label: "审核人" }, { default: n(() => [m(d(t.rowData.auditUserName || "-"), 1)]), _: 1 })]), _: 1 }), se((o(), l(ae, { ref_key: "tableRef", ref: K, data: P.value, "max-height": s(F), style: { width: "100%" }, "show-summary": "", "summary-method": Q }, { default: n(() => [c(u, { label: "序号", type: "index", align: "center", width: "60" }), c(u, { "show-overflow-tooltip": "", prop: "productName", key: "productName", label: "名称", align: "center" }), b.value ? r("", true) : (o(), l(u, { "show-overflow-tooltip": "", prop: "serialNumber", key: "serialNumber", label: "出库单号", align: "center" })), c(u, { "show-overflow-tooltip": "", prop: "specification", key: "specification", label: "规格", align: "center" }), h.value ? (o(), l(u, { "show-overflow-tooltip": "", prop: "length", key: "length", label: "长度（m）", align: "center" })) : r("", true), x.value ? (o(), l(u, { "show-overflow-tooltip": "", prop: "length", key: "length", label: "单长（m）", align: "center" })) : r("", true), h.value ? (o(), l(u, { "show-overflow-tooltip": "", prop: "netWeight", key: "netWeight", label: "单重（t）", align: "center" })) : r("", true), x.value ? (o(), l(u, { "show-overflow-tooltip": "", prop: "surfaceArea", key: "surfaceArea", label: "单面积（m²）", align: "center", width: "100px" }, { default: n((i) => [f("span", null, d(i.row.surfaceArea || "-"), 1)]), _: 1 })) : r("", true), h.value ? (o(), l(u, { "show-overflow-tooltip": "", prop: "material", key: "material", label: "材质", align: "center" })) : r("", true), b.value ? r("", true) : (o(), l(u, { "show-overflow-tooltip": "", prop: "pricingManner", key: "pricingManner", label: "计价方式", align: "center" }, { default: n((i) => [f("span", null, d(Y.value.VL[i.row.pricingManner] || "-"), 1)]), _: 1 })), c(u, { "show-overflow-tooltip": "", prop: "quantity", key: "quantity", label: "数量", align: "center" }), b.value ? (o(), l(u, { "show-overflow-tooltip": "", prop: "measureUnit", key: "measureUnit", label: "单位", align: "center" })) : r("", true), b.value ? (o(), l(u, { "show-overflow-tooltip": "", prop: "mete", key: "mete", label: "核算量", align: "center" })) : r("", true), b.value ? (o(), l(u, { "show-overflow-tooltip": "", prop: "accountingUnit", key: "accountingUnit", label: "核算单位", align: "center" })) : r("", true), c(u, { "show-overflow-tooltip": "", prop: "unitPrice", key: "unitPrice", label: "单价（元）", align: "center", width: "100px" }, { default: n((i) => [f("span", null, d(s($)(i.row.unitPrice, 3) || "-"), 1)]), _: 1 }), c(u, { "show-overflow-tooltip": "", prop: "totalAmount", key: "totalAmount", label: "总价（元）", align: "center", width: "100px" }, { default: n((i) => [f("span", null, d(s($)(i.row.totalAmount, 3) || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[re, S.value]]), f("div", Re, [e[6] || (e[6] = f("span", null, "创建人备注:", -1)), e[7] || (e[7] = m()), f("span", Se, d(t.rowData.remark || "-"), 1)]), t.auditType !== "audit" ? (o(), B("div", Ve, [e[8] || (e[8] = f("span", null, "审核人备注:", -1)), e[9] || (e[9] = m()), f("span", xe, d(t.rowData.auditRemark || "-"), 1)])) : r("", true), t.auditType === "audit" ? (o(), l(oe, { key: 1, class: "remark", type: "textarea", placeholder: "备注说明", maxlength: "200", "show-word-limit": "", modelValue: k.value, "onUpdate:modelValue": e[2] || (e[2] = (i) => k.value = i) }, null, 8, ["modelValue"])) : r("", true)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Le = be(Ce, [["__scopeId", "data-v-6613a3ae"]]), Ie = Object.freeze(Object.defineProperty({ __proto__: null, default: Le }, Symbol.toStringTag, { value: "Module" }));
export {
  Le as a,
  Ie as b,
  Ne as c
};
