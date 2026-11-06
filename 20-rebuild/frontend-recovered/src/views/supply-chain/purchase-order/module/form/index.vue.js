import { _ as B, jZ as k, j_ as y, jJ as D, am as f, bD as H, bR as F, jU as q, jV as W, jT as z, jY as K, ao as Q, i as d, au as g, o as Y, b as C, a9 as G, cO as J, jl as X, vO as Z, V as $, iX as ee } from "../../../../../shared/runtime.js";
import te from "./has-detail-form.vue.js";
import ae from "./raw-material.vue.js";
import { ref as b } from "vue";
import { computed as _ } from "vue";
import { watch as ie } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as T } from "vue";
import { createBlock as w } from "vue";
import { withCtx as E } from "vue";
import { createElementVNode as V } from "vue";
import { unref as n } from "vue";
import { resolveDynamicComponent as se } from "vue";
import { createElementBlock as re } from "vue";
import { createTextVNode as oe } from "vue";
import { createVNode as ne } from "vue";
import { createCommentVNode as I } from "vue";
import "../components/requisition-list/index.vue.js";
import "../components/requisition-list/module/requisition-order.vue.js";
import "../components/requisition-list/module/steel/index.vue.js";
import "../components/requisition-list/module/steel/module/steel-plate-table.vue.js";
import "../components/requisition-list/module/steel/module/section-steel-table.vue.js";
import "../components/requisition-list/module/steel/module/steel-coil-table.vue.js";
import "../components/requisition-list/module/auxiliary-material/index.vue.js";
import "../components/requisition-list/module/manufactured/index.vue.js";
import "../components/manuf-list.vue.js";
import "../components/application/steel/index.vue.js";
import "../components/application/steel/module/steel-plate-table.vue.js";
import "../components/application/steel/module/section-steel-table.vue.js";
import "../components/application/steel/module/steel-coil-table.vue.js";
import "../components/application/auxiliary-material/index.vue.js";
import "../components/application/other/index.vue.js";
import "../components/application/manufactured/index.vue.js";
const ue = { key: 0, class: "el-form-item el-form-item" }, le = { __name: "index", setup(ce) {
  const P = { useRequisitions: true, serialNumber: void 0, supplyType: k.SELF.V, materialType: y.STEEL.V, purchaseType: D.RAW_MATERIAL.V, currentBasicClass: f.STEEL_PLATE.V, isAllMaterial: false, auxMaterialIds: void 0, isAllOtherMaterial: false, otherMaterialIds: void 0, projectIds: void 0, projectId: void 0, supplierId: void 0, branchCompanyId: void 0, mete: void 0, meteUnit: "kg", amount: void 0, invoiceType: H.SPECIAL.V, taxRate: void 0, weightMeasurementMode: F.THEORY.V, logisticsTransportType: q.FREIGHT.V, logisticsPayerType: W.SUPPLIER.V, purchaseOrderPaymentMode: z.ARRIVAL.V, remark: void 0, attachments: void 0, attachmentIds: void 0, list: [], sectionSteelList: [], steelPlateList: [], steelCoilList: [], requisitions: [], requisitionsKV: {}, actualRequisitionIds: [], manufListObj: {}, manufMergeObj: {} }, { purchaseCfg: j } = K(), u = b("620px"), R = b(), c = b(), { CRUD: h, crud: r, form: e } = Q(P, R), m = _(() => r.status.cu > h.STATUS.NORMAL), M = _(() => r.status.edit > 0);
  ie(() => m.value, (o) => {
    o && (u.value = "620px", e.id || (c.value = d(j.value.boolHaveDetail) ? j.value.boolHaveDetail : true, c.value === g.TRUE.V && (u.value = "100%")));
  }, { immediate: true, deep: true });
  function O(o) {
    u.value = o ? "100%" : "620px";
  }
  const A = _(() => {
    switch (c.value) {
      case g.TRUE.V:
        return te;
      default:
        return ae;
    }
  }), { maxHeight: S } = Y({ mainBox: ".purchase-order-raw-mat-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true }, m);
  function U(o) {
    for (let a = 0; a < o.length; a++) {
      const t = $(o[a]), l = t.curPurchaseQuantity * t.netWeight || 0;
      C(e.manufListObj[t.id]) ? e.manufListObj[t.id] = { ...t, rowKey: t.id, curPurchaseWeight: l } : (e.manufListObj[t.id].curPurchaseQuantity += t.curPurchaseQuantity, e.manufListObj[t.id].curPurchaseWeight = ee(e.manufListObj[t.id].curPurchaseWeight + l, 2));
    }
  }
  h.HOOK.beforeEditDetailLoaded = async (o) => {
    var t, l, p, v, x;
    u.value = "620px", d(e.projects) && (e.projectIds = e.projects.map((i) => i.id)), C(e.attachments) && (e.attachments = []), e.useRequisitions = d(e.applyPurchase);
    let a = {};
    if (e.useRequisitions && (a = G(e.applyPurchase)), e.isAllMaterial = (t = e.auxMaterialIds) == null ? void 0 : t.includes(0), e.isAllOtherMaterial = (l = e.otherMaterialIds) == null ? void 0 : l.includes(0), e.branchCompanyId = e.branchCompany ? e.branchCompany.id : void 0, e.supplierId = e.supplier ? e.supplier.id : void 0, c.value = !!d(e.details), e.clickTime = (/* @__PURE__ */ new Date()).getTime(), d(e.details)) {
      if (u.value = "100%", e.materialType & y.MANUFACTURED.V) {
        e.projectId = (p = e.projects) != null && p.length ? (x = (v = e.projects) == null ? void 0 : v[0]) == null ? void 0 : x.id : void 0, e.manufListObj = {};
        const i = e.details.map((s) => (s.curPurchaseQuantity = s.quantity, s.detailId = s.id, s.id = s.artifactEnclosureId, s));
        U(i);
      } else await J(e.details), await X(e.details, { toNum: true }, { mete: ["mete", "applyPurchaseMete"] }), e.list = e.details.map((i) => {
        var s;
        return i.purchaseSN = (s = a[i.applyPurchaseId]) == null ? void 0 : s.serialNumber, i.purchaseTotalWeight = i.applyPurchaseMete, i;
      }), e.materialType & y.STEEL.V && await Z(e);
      Object.assign(e, { requisitionsKV: a });
      for (const i in f.ENUM) if (f[i].V & e.basicClass) {
        e.currentBasicClass = f[i].V;
        break;
      }
    }
  };
  function N() {
    u.value = "620px", r.cancelCU(), r.refresh();
  }
  return (o, a) => {
    const t = L("common-radio"), l = L("common-drawer");
    return T(), w(l, { ref: "drawerRef", "before-close": n(r).cancelCU, "close-on-click-modal": false, contentLoading: n(r).editDetailLoading, "show-close": true, size: u.value, title: n(r).status.title, visible: m.value, "custom-class": "purchase-order-raw-mat-form", "destroy-on-close": "" }, { titleAfter: E(() => a[1] || (a[1] = [])), content: E(() => [V("div", null, [n(r).status.cu > n(h).STATUS.NORMAL ? (T(), w(se(A.value), { key: 0, detail: n(e), dialogVisible: m.value, edit: M.value, maxHeight: n(S) - 50, onSuccess: N }, { chose: E(() => [M.value ? I("", true) : (T(), re("div", ue, [a[2] || (a[2] = V("div", { class: "el-form-item__label", style: { "font-weight": "700", "font-size": "14px", width: "110px" } }, [V("span", { style: { color: "#f56c6c", "font-weight": "normal", "margin-right": "4px" } }, "*"), oe(" 是否有明细 ")], -1)), ne(t, { modelValue: c.value, "onUpdate:modelValue": a[0] || (a[0] = (p) => c.value = p), options: n(g).ENUM, type: "enum", onChange: O }, null, 8, ["modelValue", "options"])]))]), _: 1 }, 40, ["detail", "dialogVisible", "edit", "maxHeight"])) : I("", true)])]), _: 1 }, 8, ["before-close", "contentLoading", "size", "title", "visible"]);
  };
} }, Pe = B(le, [["__scopeId", "data-v-f1efe9de"]]);
export {
  Pe as default
};
