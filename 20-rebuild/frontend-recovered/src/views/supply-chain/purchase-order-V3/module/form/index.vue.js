import { _ as ee, ll as te, lm as ae, v5 as ie, vy as se, jZ as re, jP as r, jJ as oe, am as F, bD as le, bR as ne, jU as ue, jV as ce, jT as pe, gD as C, fE as R, jY as de, ao as me, i as T, vh as Te, k3 as _, cP as n, bv as P, au as j, o as fe, b as he, a9 as ye, cO as Ee, jl as Ve, vz as Se, vg as Le, t0 as k } from "../../../../../shared/runtime.js";
import be from "./has-detail-form.vue.js";
import ge from "./raw-material.vue.js";
import { useStore as Ae } from "vuex";
import { provide as K } from "vue";
import { ref as O } from "vue";
import { computed as v } from "vue";
import { watch as Ie } from "vue";
import { nextTick as w } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as A } from "vue";
import { createBlock as x } from "vue";
import { withCtx as I } from "vue";
import { unref as c } from "vue";
import { createTextVNode as G } from "vue";
import { createCommentVNode as q } from "vue";
import { createElementVNode as U } from "vue";
import { resolveDynamicComponent as Me } from "vue";
import { createElementBlock as Ce } from "vue";
import { createVNode as Re } from "vue";
import "../components/detail-table/index.vue.js";
import "../components/detail-table/module/manufactured.vue.js";
import "../components/detail-table/module/raw-material.vue.js";
import "../components/requisition-list/index.vue.js";
import "../components/requisition-list/module/requisition-order.vue.js";
import "../components/requisition-list/module/steel/index.vue.js";
import "../components/requisition-list/module/steel/module/steel-plate-table.vue.js";
import "../components/requisition-list/module/steel/module/section-steel-table.vue.js";
import "../components/requisition-list/module/steel/module/steel-coil-table.vue.js";
import "../components/requisition-list/module/steel/module/other-steel-material-table.vue.js";
import "../components/requisition-list/module/auxiliary-material/index.vue.js";
import "../components/manuf-list.vue.js";
import "../components/submit-preview.vue.js";
import "../components/application/steel/index.vue.js";
import "../components/application/steel/module/steel-plate-table.vue.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
import "../components/application/steel/module/section-steel-table.vue.js";
import "../components/application/steel/module/steel-coil-table.vue.js";
import "../components/application/steel/module/other-steel-material-table.vue.js";
import "../components/application/other-table/index.vue.js";
import "../components/application/other-table/module/auxiliary-material.vue.js";
import "../components/application/other-table/module/gas.vue.js";
import "../components/application/other-table/module/other.vue.js";
const _e = { key: 0, class: "el-form-item el-form-item--small" }, Pe = { __name: "index", props: { requisitionList: { type: Array, default: () => [] }, isPassedEdit: { type: Boolean, default: false } }, setup(M) {
  const D = Ae();
  te(), ae();
  const { projectAllType: J } = ie(), { supplyUsedProject: Q } = se();
  K("supplyUsedProject", Q), K("projectAllType", J);
  const f = M, W = { boolDetail: false, useRequisitions: true, boolTemporaryStorage: false, serialNumber: void 0, boolAnnual: false, supplyType: re.SELF.V, materialType: r.STEEL.V, purchaseType: oe.RAW_MATERIAL.V, currentBasicClass: F.STEEL_PLATE.V, isAllMaterial: false, auxMaterialIds: void 0, isAllOtherMaterial: false, otherMaterialIds: void 0, projectIds: void 0, projectId: void 0, supplierId: void 0, branchCompanyId: void 0, mete: void 0, meteUnit: "kg", amount: void 0, invoiceType: le.SPECIAL.V, taxRate: void 0, weightMeasurementMode: ne.THEORY.V, logisticsTransportType: ue.FREIGHT.V, logisticsPayerType: ce.SUPPLIER.V, purchaseOrderPaymentMode: pe.ARRIVAL.V, projectAttribute: C.SELF_SUPPORT.V, remark: void 0, attachments: void 0, attachmentIds: void 0, list: [], sectionSteelList: [], steelPlateList: [], steelCoilList: [], otherSteelMaterialList: [], requisitions: [], requisitionsKV: {}, actualRequisitionIds: [], manufListObj: {}, manufMergeObj: {}, materialTypeTotal: [], level: R.FACTORY.V }, { purchaseCfg: B } = de(), p = O("620px"), z = O(), H = O(), { CRUD: b, crud: h, form: e } = me(W, z), V = v(() => h.status.cu > b.STATUS.NORMAL), S = v(() => h.status.edit > 0);
  Ie([() => V.value, () => f.requisitionList], () => {
    var E, o, y;
    if (V.value) if (p.value = "620px", T(f.requisitionList)) {
      const d = JSON.parse(JSON.stringify(f.requisitionList)), s = [], i = {};
      d == null || d.map((t) => {
        var a, m;
        t.isRequisition = true, t.projectId = t.projectId || ((a = t.project) == null ? void 0 : a.id), (m = t.detailList) == null || m.forEach((l) => {
          var g;
          l.isRequisition = true, l.uid = l.id, l.projectId = l.projectId || ((g = l.project) == null ? void 0 : g.id), (!l.projectAttribute || Number(l.projectAttribute) === C.SELF_SUPPORT.V) && s.push(l);
        }), i[t.id] = { id: t.id, serialNumber: t.serialNumber, purchaseCreationState: Te.DURING.V };
      });
      const u = [];
      for (let t = 0; t < s.length; t++) {
        u.includes(s[t].basicClass) || u.push(s[t].basicClass), s[t].basicClass === F.SECTION_STEEL.V && (s[t].standardId = s[t].standardId || ((o = (E = s[t].nationalStandardOptions) == null ? void 0 : E.find((g) => g.boolDefault === true)) == null ? void 0 : o.standardId));
        const a = s[t];
        a.isFirst = true, a.purchaseSN = (y = i[a.applyPurchaseId]) == null ? void 0 : y.serialNumber, a.productQuantity = a.productQuantity || 0, a.productMete = a.productMete || 0;
        const m = a.mete, l = a.quantity;
        a.originMete = m, a.originQuantity = l, a.canPurchaseQuantity = l - a.productQuantity > 0 ? l - a.productQuantity : 0, a.canPurchaseMete = m - a.productMete > 0 ? m - a.productMete : 0, a.quantity = a.canPurchaseQuantity, a.basicClass & _ ? (a.purchaseTotalWeight = a.mete, a.weighingTotalWeight = a.canPurchaseMete) : a.mete = a.canPurchaseMete;
      }
      let L;
      for (let t = 0; t < u.length; t++) u[t] & _ ? L = _ : L = L ? L | u[t] : u[t];
      w(() => {
        e.boolDetail = true, p.value = "100%", e.useRequisitions = true, e.actualRequisitionIds = d.map((t) => t.id), e.requisitionsKV = i, e.list = s, e.originList = JSON.parse(JSON.stringify(s)), e.isRequisition = true, e.materialType = L, e.projectAttribute = C.SELF_SUPPORT.V, e.branchCompanyId = f.requisitionList[0].branchCompanyId, e.branchCompany = f.requisitionList[0].branchCompany, e.level = f.requisitionList[0].level, e.steelPlateList = [], e.sectionSteelList = [], e.steelCoilList = [], e.otherSteelMaterialList = [], e.auxiliaryMaterialList = [], e.otherList = [], e.gasList = [], e.project = [], s.forEach((t) => {
          var a, m;
          switch (t.uid = t.id, t.weighingTotalWeight = t.mete, t.specificationMap = t.specKV, t.projectId = t.projectId || ((a = t.project) == null ? void 0 : a.id), t.warehouseId = t.warehouseId || ((m = t.warehouse) == null ? void 0 : m.id), e.level === R.CONSTRUCTION_SITE.V && e.project.find((l) => l.id === t.projectId) < 0 && e.project.push(t.project), t.basicClass) {
            case n.STEEL_PLATE.V:
              e.steelPlateList.push(t);
              break;
            case n.SECTION_STEEL.V:
              e.sectionSteelList.push(t);
              break;
            case n.STEEL_COIL.V:
              e.steelCoilList.push(t);
              break;
            case n.OTHER_STEEL_MATERIALS.V:
              e.otherSteelMaterialList.push(t);
              break;
            case n.MATERIAL.V:
              e.auxiliaryMaterialList.push(t);
              break;
            case n.GAS.V:
              e.gasList.push(t);
              break;
            case n.OTHER.V:
              e.otherList.push(t);
              break;
          }
        }), e.materialTypeTotal = P.getBits(r.ENUM, e.materialType, "V"), T(e.materialTypeTotal) && (e.materialTypeTotal.includes(r.STEEL.V) ? e.currentBasicClass = n.STEEL_PLATE.V : e.materialTypeTotal.includes(r.MATERIAL.V) ? (e.currentMaterial = r.MATERIAL.V, e.currentBasicClass = n.MATERIAL.V) : e.materialTypeTotal.includes(r.OTHER.V) ? (e.currentMaterial = r.OTHER.V, e.currentBasicClass = n.OTHER.V) : (e.currentMaterial = r.GAS.V, e.currentBasicClass = n.GAS.V)), e.isFirst = true, e.needFirstWatch = true;
      });
    } else e.id || (e.boolDetail = T(B.value.boolHaveDetail) ? B.value.boolHaveDetail : false, w(() => {
      e.boolDetail === j.TRUE.V ? p.value = "100%" : (p.value = "620px", e.materialType = void 0);
    }));
  }, { immediate: true, deep: true });
  function Y(E) {
    p.value = E ? "100%" : "620px";
  }
  const Z = v(() => {
    switch (e.boolDetail) {
      case j.TRUE.V:
        return be;
      default:
        return ge;
    }
  }), { maxHeight: $ } = fe({ mainBox: ".purchase-order-raw-mat-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true }, V);
  b.HOOK.afterToAdd = () => {
    setTimeout(() => {
    }, 300);
  }, b.HOOK.beforeEditDetailLoaded = async (E) => {
    var y, d, s;
    p.value = "620px", T(e.projects) && (e.projectIds = e.projects.map((i) => i.id), e.originEditProjectIds = JSON.parse(JSON.stringify(e.projectIds)), e.level === R.CONSTRUCTION_SITE.V && (e.projectId = e.projectIds[0], e.originEditId = e.projectId)), e.boolAnnual = !!e.boolAnnual, he(e.attachments) && (e.attachments = []);
    let o = {};
    if (T(e.applyPurchase)) {
      o = ye(e.applyPurchase), e.requisitionsKV = o;
      const i = e.applyPurchaseStatus ? JSON.parse(e.applyPurchaseStatus) : [];
      i == null || i.forEach((u) => {
        T(e.requisitionsKV) && e.requisitionsKV[u.id] && (e.requisitionsKV[u.id].purchaseCreationState = u.purchaseCreationState);
      });
    }
    e.requisitionsKV = T(e.requisitionsKV) ? e.requisitionsKV : {}, e.isAllMaterial = (y = e.auxMaterialIds) == null ? void 0 : y.includes(0), e.isAllOtherMaterial = (d = e.otherMaterialIds) == null ? void 0 : d.includes(0), e.isAllGAS = (s = e.gasMaterialIds) == null ? void 0 : s.includes(0), e.branchCompanyId = e.branchCompany ? e.branchCompany.id : void 0, e.supplierId = e.supplier ? e.supplier.id : void 0, e.clickTime = (/* @__PURE__ */ new Date()).getTime(), T(e.details) ? (await Ee(e.details), await Ve(e.details, { toNum: true }, { mete: ["mete", "applyPurchaseMete"] }), e.list = e.details.map((i) => {
      var u;
      return i.isFirst = true, i.uid = i.id, i.purchaseSN = (u = o[i.applyPurchaseId]) == null ? void 0 : u.serialNumber, i.purchaseTotalWeight = i.applyPurchaseMete, i;
    }), await Se(e), e.materialTypeTotal = P.getBits(r.ENUM, e.materialType, "V"), T(e.materialTypeTotal) && (e.materialTypeTotal.includes(r.STEEL.V) ? e.currentBasicClass = n.STEEL_PLATE.V : e.materialTypeTotal.includes(r.MATERIAL.V) ? (e.currentMaterial = r.MATERIAL.V, e.currentBasicClass = n.MATERIAL.V) : e.materialTypeTotal.includes(r.OTHER.V) ? (e.currentMaterial = r.OTHER.V, e.currentBasicClass = n.OTHER.V) : (e.currentMaterial = r.GAS.V, e.currentBasicClass = n.GAS.V)), e.isFirst = true) : e.boolDetail && (e.materialTypeTotal = P.getBits(r.ENUM, e.materialType, "V"), e.list = [], e.steelPlateList = [], e.sectionSteelList = [], e.steelCoilList = [], e.otherSteelMaterialList = [], e.auxiliaryMaterialList = [], e.otherList = [], e.gasList = []), e.boolDetail ? p.value = "100%" : p.value = "620px", e.boolTemporaryStorage = false;
  };
  async function X() {
    p.value = "620px", h.cancelCU(), h.refresh(), await D.dispatch("approval_list/fetchTSNum", k.PURCHASE_ORDER_V2.V), await D.dispatch("approval_list/fetchApprovalNum", k.PURCHASE_ORDER_V2.V);
  }
  return (E, o) => {
    const y = N("common-button"), d = N("common-radio"), s = N("common-drawer");
    return A(), x(s, { ref: "drawerRef", "before-close": c(h).cancelCU, "close-on-click-modal": false, contentLoading: c(h).editDetailLoading, "show-close": true, size: p.value, title: S.value ? "编辑采购订单（自营）" : "新增采购订单（自营）", visible: V.value, "custom-class": "purchase-order-raw-mat-form", "destroy-on-close": "" }, { titleRight: I(() => [!(M.isPassedEdit ? M.isPassedEdit && !S.value : S.value) && !c(e).boolDetail ? (A(), x(y, { key: 0, size: "default", type: "primary", onClick: o[0] || (o[0] = (i) => H.value.submit(c(Le).NO.V)) }, { default: I(() => o[2] || (o[2] = [G(" 提 交 ")])), _: 1, __: [2] })) : q("", true)]), content: I(() => [U("div", null, [c(h).status.cu > c(b).STATUS.NORMAL ? (A(), x(Me(Z.value), { key: 0, ref_key: "compRef", ref: H, detail: c(e), dialogVisible: V.value, edit: S.value, "is-passed-edit": f.isPassedEdit, maxHeight: c($) - 50, onSuccess: X }, { chose: I(() => [S.value ? q("", true) : (A(), Ce("div", _e, [o[3] || (o[3] = U("div", { class: "el-form-item__label", style: { "font-weight": "700", "font-size": "14px", width: "110px" } }, [U("span", { style: { color: "#f56c6c", "font-weight": "normal", "margin-right": "4px" } }, "*"), G("是否有明细 ")], -1)), Re(d, { modelValue: c(e).boolDetail, "onUpdate:modelValue": o[1] || (o[1] = (i) => c(e).boolDetail = i), options: c(j).ENUM, type: "enum", onChange: Y }, null, 8, ["modelValue", "options"])]))]), _: 1 }, 40, ["detail", "dialogVisible", "edit", "is-passed-edit", "maxHeight"])) : q("", true)])]), _: 1 }, 8, ["before-close", "contentLoading", "size", "title", "visible"]);
  };
} }, st = ee(Pe, [["__scopeId", "data-v-7217c8ac"]]);
export {
  st as default
};
