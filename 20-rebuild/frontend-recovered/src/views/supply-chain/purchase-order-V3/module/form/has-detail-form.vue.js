import { useStore as st } from "vuex";
import { inject as ce } from "vue";
import { ref as V } from "vue";
import { watch as J } from "vue";
import { provide as me } from "vue";
import { computed as z } from "vue";
import { watchEffect as fe } from "vue";
import { nextTick as x } from "vue";
import { ElMessage as N } from "element-plus";
import { resolveComponent as F } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as S } from "vue";
import { createElementVNode as y } from "vue";
import { renderSlot as lt } from "vue";
import { createVNode as n } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as O } from "vue";
import { createBlock as E } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as g } from "vue";
import { normalizeStyle as be } from "vue";
import { toDisplayString as j } from "vue";
import { Fragment as ye } from "vue";
import { renderList as it } from "vue";
import { resolveDynamicComponent as rt } from "vue";
import { ElMessageBox as ot } from "element-plus";
import { ElFormItem as nt } from "element-plus";
import { ElInput as ut } from "element-plus";
import { ElCheckbox as dt } from "element-plus";
import { ElTag as pt } from "element-plus";
import { ElTooltip as ct } from "element-plus";
import { ElForm as mt } from "element-plus";
import { _ as ft, fE as M, tB as bt, vk as yt, vl as gt, jP as d, i as I, cP as u, jJ as ht, vm as Tt, vn as Vt, vo as Et, vp as It, vq as St, vr as vt, vs as Mt, o as ge, a$ as Ct, vh as ae, kf as Lt, uP as he, vt as Rt, vu as _t, t0 as Te, jl as At, vg as Ut, jS as xt, au as Ot, ap as se, lo as jt, fD as qt, fv as Pt, bG as kt, jT as Bt, bR as D, jU as Nt, jV as wt, R as Ht, S as Kt, nd as zt, vv as Ft, L as Dt, vw as $t, vx as Gt, cQ as Wt, bv as Qt, V as Jt, b as Xt, iX as Yt, ai as Zt, bD as ea } from "../../../../../shared/runtime.js";
import ta from "../components/detail-table/index.vue.js";
import aa from "../components/requisition-list/index.vue.js";
import sa from "../components/manuf-list.vue.js";
import la from "../components/submit-preview.vue.js";
import ia from "../components/application/steel/index.vue.js";
import ra from "../components/application/other-table/index.vue.js";
import "../components/detail-table/module/manufactured.vue.js";
import "../components/detail-table/module/raw-material.vue.js";
import "../components/requisition-list/module/requisition-order.vue.js";
import "../components/requisition-list/module/steel/index.vue.js";
import "../components/requisition-list/module/steel/module/steel-plate-table.vue.js";
import "../components/requisition-list/module/steel/module/section-steel-table.vue.js";
import "../components/requisition-list/module/steel/module/steel-coil-table.vue.js";
import "../components/requisition-list/module/steel/module/other-steel-material-table.vue.js";
import "../components/requisition-list/module/auxiliary-material/index.vue.js";
import "../components/application/steel/module/steel-plate-table.vue.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
import "../components/application/steel/module/section-steel-table.vue.js";
import "../components/application/steel/module/steel-coil-table.vue.js";
import "../components/application/steel/module/other-steel-material-table.vue.js";
import "../components/application/other-table/module/auxiliary-material.vue.js";
import "../components/application/other-table/module/gas.vue.js";
import "../components/application/other-table/module/other.vue.js";
const oa = { style: { display: "flex" } }, na = { style: { flex: "1", "text-align": "right" } }, ua = { class: "main-content" }, da = { class: "form-content" }, pa = { class: "order-details" }, ca = { class: "flex-rss child-mr-10" }, ma = { class: "flex-rss child-mr-10" }, fa = { class: "flex-rss child-mr-10" }, ba = { class: "form-right" }, ya = { key: 0 }, ga = { key: 0, class: "right-head flex-rbs" }, ha = { class: "right-head-content" }, Ta = { key: 0 }, Va = { key: 0, class: "opt-content" }, Ea = { class: "right-head flex-rbs" }, Ia = { class: "right-head-content" }, Sa = { key: 0, class: "label" }, va = { key: 0 }, Ma = { key: 0, class: "opt-content" }, Ca = { class: "table-remark" }, La = { class: "con" }, Ra = { class: "con" }, _a = { key: 1, style: { "font-size": "12px" } }, Aa = { __name: "has-detail-form", props: { edit: { type: Boolean, default: false }, dialogVisible: { type: Boolean, default: false }, detail: { type: Object }, maxHeight: { type: Number, default: 100 }, isPassedEdit: { type: Boolean, default: false } }, emits: "success", setup(U, { expose: Ve, emit: Ee }) {
  const $ = st(), Ie = Ee, Se = ce("supplyUsedProject"), ve = ce("projectAllType"), Me = { boolTemporaryStorage: false, boolDetail: true, attachmentIds: void 0, level: M.FACTORY.V, list: [], sectionSteelList: [], steelPlateList: [], steelCoilList: [], otherSteelMaterialList: [], auxiliaryMaterialList: [], otherList: [], gasList: [], requisitions: [], requisitionsKV: {}, actualRequisitionIds: [], manufListObj: {}, manufMergeObj: {}, materialTypeTotal: [] }, h = U, q = V(false), P = V(), X = V(false), Ce = V(), { cu: L, form: e, FORM: k } = bt({ title: "采购合同", formStore: !h.edit, formStoreKey: "SUPPLY_CHAIN_PURCHASE_ORDER", defaultForm: Me, useDraftCallback: Le, clearDraftCallback: Re, api: h.edit ? yt : gt }, P, h.detail);
  J(() => h.detail, (s = {}) => {
    e.useRequisitions = s.useRequisitions, e.materialType = h.detail.materialType, e.purchaseType = h.detail.purchaseType, e.currentBasicClass = h.detail.currentBasicClass, e.supplyType = h.detail.supplyType, e.boolUsed = h.detail.boolUsed, e.projectId = h.detail.projectId;
  }, { deep: true, immediate: true }), me("cu", L);
  function Le() {
  }
  function Re() {
  }
  const _e = (s, a, l) => {
    e.invoiceType || e.invoiceType === 0 ? e.invoiceType === ea.SPECIAL.V && !e.taxRate ? l(new Error("请选择税率")) : l() : l(new Error("请选择发票及税率"));
  }, le = { serialNumber: [{ max: 30, message: "订单编号长度不可超过30位", trigger: "blur" }], materialTypeTotal: [{ required: true, message: "请选择材料类型", trigger: "change" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], supplyType: [{ required: true, message: "请选择供货类型", trigger: "change" }], supplierId: [{ required: true, message: "请选择供应商", trigger: "change" }], level: [{ required: true, message: "请选择采购目的", trigger: "change" }], branchCompanyId: [{ required: true, message: "请选择签订主体", trigger: "change" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], projectAttribute: [{ required: true, message: "请选择项目属性", trigger: "change" }] }, Ae = { supplierId: [{ required: true, message: "请选择供应商", trigger: "change" }] }, Ue = { logisticsTransportType: [{ required: true, message: "请选择物流运输方式", trigger: "change" }], logisticsPayerType: [{ required: true, message: "请选择物流费用承担方", trigger: "change" }], purchaseOrderPaymentMode: [{ required: true, message: "请选择订单类型", trigger: "change" }], invoiceType: [{ required: true, validator: _e, trigger: "change" }], taxRate: [{ max: 2, message: "请输入税率", trigger: "blur" }], mete: [{ required: true, message: "请填写合同量", trigger: "blur" }], amount: [{ required: true, message: "请填写合同额", trigger: "blur" }] }, xe = { auxMaterialIds: [{ required: true, validator: (s, a, l) => {
    e.isAllMaterial || a ? l() : l(new Error("请选择辅材"));
  }, trigger: "change" }] }, Oe = { otherMaterialIds: [{ required: true, validator: (s, a, l) => {
    e.isAllOtherMaterial || a ? l() : l(new Error("请选择办公用品科目"));
  }, trigger: "change" }] }, je = z(() => {
    const s = {};
    return Object.assign(s, le), Object.assign(s, le), Object.assign(s, Ue), e.materialType & d.MATERIAL.V && !e.useRequisitions && Object.assign(s, xe), e.materialType & d.OTHER.V && !e.useRequisitions && Object.assign(s, Oe), e.boolTemporaryStorage ? Ae : s;
  });
  fe(() => {
    h.dialogVisible && x(() => {
      P.value && P.value.clearValidate();
    });
  });
  const w = z(() => false), H = V([]);
  J(() => e.materialTypeTotal, (s) => {
    if (e.materialType = e.materialType || void 0, e.currentBasicClass = e.currentBasicClass || void 0, e.currentMaterial = e.currentMaterial || void 0, H.value = [], I(e.materialTypeTotal)) if (e.materialTypeTotal.includes(d.STEEL.V)) H.value = [u.STEEL_PLATE, u.SECTION_STEEL, u.STEEL_COIL, u.OTHER_STEEL_MATERIALS], e.isFirst ? e.currentBasicClass = I(e.steelPlateList) ? u.STEEL_PLATE.V : I(e.sectionSteelList) ? u.SECTION_STEEL.V : u.STEEL_COIL.V : e.currentBasicClass = u.STEEL_PLATE.V, e.currentBasicClass = u.STEEL_PLATE.V, e.currentMaterial = d.STEEL.V, e.materialType = d.STEEL.V;
    else {
      for (let a = 0; a < e.materialTypeTotal.length; a++) e.materialType = a === 0 ? e.materialTypeTotal[0] : e.materialType | e.materialTypeTotal[a], H.value.push(u.V[e.materialTypeTotal[a]]);
      e.materialTypeTotal.includes(d.MATERIAL.V) ? (e.currentMaterial = d.MATERIAL.V, e.currentBasicClass = u.MATERIAL.V) : e.materialTypeTotal.includes(d.OTHER.V) ? (e.currentMaterial = d.OTHER.V, e.currentBasicClass = u.OTHER.V) : (e.currentMaterial = d.GAS.V, e.currentBasicClass = u.GAS.V);
    }
    e.basicClass = e.materialType, e.purchaseType = ht.RAW_MATERIAL.V, e.isFirst || G(), e.isFirst = false, C.value && C.value.clear();
  });
  const qe = z(() => {
    switch (e.materialType) {
      case d.STEEL.V:
        return ia;
      default:
        return ra;
    }
  }), Y = z(() => e.list.findIndex((s) => s.isRequisition) > -1), G = () => {
    e.list = [], e.sectionSteelList = [], e.steelPlateList = [], e.steelCoilList = [], e.auxiliaryMaterialList = [], e.otherSteelMaterialList = [], e.otherList = [], e.gasList = [], e.requisitionsKV = {}, e.actualRequisitionIds = [], e.manufListObj = {}, C.value && C.value.clear();
  }, R = { [u.STEEL_PLATE.V]: "steelPlateList", [u.SECTION_STEEL.V]: "sectionSteelList", [u.STEEL_COIL.V]: "steelCoilList", [u.OTHER_STEEL_MATERIALS.V]: "otherSteelMaterialList", [u.MATERIAL.V]: "auxiliaryMaterialList", [u.OTHER.V]: "otherList", [u.GAS.V]: "gasList" }, Pe = z(() => {
    switch (e.currentBasicClass) {
      case u.STEEL_PLATE.V:
        return Mt;
      case u.SECTION_STEEL.V:
        return vt;
      case u.STEEL_COIL.V:
        return St;
      case u.OTHER_STEEL_MATERIALS.V:
        return It;
      case u.MATERIAL.V:
        return Et;
      case u.GAS.V:
        return Vt;
      default:
        return Tt;
    }
  }), T = V(), ie = V(), re = V(), C = V(), W = V(false), K = V(false), Z = V([]), oe = V([]);
  me("matSpecRef", C);
  const { maxHeight: ke } = ge({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => {
    var s;
    return (s = ie.value) == null ? void 0 : s.loaded;
  }), { maxHeight: Be } = ge({ mainBox: ".manufactured-select-drawer", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, paginate: true, clientHRepMainH: true, extraHeight: 50, minHeight: 300 }, () => {
    var s;
    return (s = re.value) == null ? void 0 : s.loaded;
  });
  J(() => e.needFirstWatch, (s) => {
    s && x(() => {
      var a;
      (a = T.value) == null || a.setFormCallback(e);
    });
  }, { immediate: true });
  function Ne(s) {
    var l;
    const a = ["steelPlateList", "steelCoilList", "sectionSteelList"];
    for (let o = 0; o < a.length; o++) (l = e[a[o]]) == null || l.forEach((r) => {
      var p;
      const f = (p = e.list) == null ? void 0 : p.find((c) => c.uid === r.uid);
      I(f) && (f.weightMeasurementMode = s === D.MIXTURE.V ? void 0 : s), s === D.MIXTURE.V ? r.weightMeasurementMode = void 0 : r.weightMeasurementMode = s;
    });
  }
  function we(s) {
    e.branchCompany = s;
  }
  function He(s) {
    e.projectId = void 0, e.useRequisitions && I(e.actualRequisitionIds) && G(), e.requisitionsKV = {}, e.requisitions = [], e.actualRequisitionIds = [];
  }
  function Ke(s) {
    var a;
    if (s) {
      const l = [];
      (a = e.originList) == null || a.forEach((r) => {
        (r.projectId === s || !r.projectId) && l.push(r);
      });
      const o = ["steelPlateList", "steelCoilList", "sectionSteelList", "otherSteelMaterialList", "auxiliaryMaterialList", "otherList", "gasList"];
      for (let r = 0; r < o.length; r++) JSON.parse(JSON.stringify(e[o[r]])).forEach((p) => {
        (!p.projectId || p.projectId === s) && l.findIndex((c) => c.uid === p.uid) < 0 && l.push(p);
      });
      e.steelPlateList = [], e.sectionSteelList = [], e.steelCoilList = [], e.otherSteelMaterialList = [], e.auxiliaryMaterialList = [], e.otherList = [], e.gasList = [], e.list = l, l.forEach((r) => {
        switch (r.basicClass) {
          case u.STEEL_PLATE.V:
            e.steelPlateList.push(r);
            break;
          case u.SECTION_STEEL.V:
            e.sectionSteelList.push(r);
            break;
          case u.STEEL_COIL.V:
            e.steelCoilList.push(r);
            break;
          case u.OTHER_STEEL_MATERIALS.V:
            e.otherSteelMaterialList.push(r);
            break;
          case u.MATERIAL.V:
            e.auxiliaryMaterialList.push(r);
            break;
          case u.GAS.V:
            e.gasList.push(r);
            break;
          case u.OTHER.V:
            e.otherList.push(r);
            break;
        }
      }), x(() => {
        var r;
        (r = T.value) == null || r.setFormCallback(e);
      });
    }
  }
  function ze() {
    e.project = [], G();
  }
  function Fe() {
    e.boolSysgen && (Q.value.supplierId === e.supplierId ? e.serialNumber = Q.value.serialNumber : e.serialNumber = void 0);
  }
  function De(s) {
    let a = [];
    I(s == null ? void 0 : s.basicClass) && (a = Qt.getBits(u.ENUM, s.basicClass, "V"));
    const l = [];
    for (let f = 0; f < a.length; f++) l.push({ V: a[f] });
    const o = [], r = [];
    for (const f in d.ENUM) l.findIndex((p) => p.V & d.ENUM[f].V) < 0 ? o.findIndex((p) => p.V === d.ENUM[f].V) < 0 && (o.push(d.ENUM[f]), r.push(d.ENUM[f].V)) : oe.value.push(d.ENUM[f].V);
    Z.value = e.id ? r : [], e.annualContractId = s == null ? void 0 : s.annualContractId;
  }
  function $e(s) {
    return e.level === M.CONSTRUCTION_SITE.V && e.projectId && (s.projectId = e.projectId), T.value.rowInit(s);
  }
  function Ge() {
    var s, a;
    if (e.materialType & d.MATERIAL.V && !e.isAllMaterial && !((s = e.auxMaterialIds) != null && s.length) && !e.useRequisitions) {
      N.warning("请先选择辅材明细");
      return;
    }
    if (e.materialType & d.OTHER.V && !e.isAllOtherMaterial && !((a = e.otherMaterialIds) != null && a.length) && !e.useRequisitions) {
      N.warning("请先选择办公用品明细");
      return;
    }
    W.value = true;
  }
  function We(s) {
    for (let a = 0; a < s.length; a++) {
      const l = Jt(s[a]), o = l.curPurchaseQuantity * l.netWeight || 0;
      Xt(e.manufListObj[l.id]) ? e.manufListObj[l.id] = { ...l, rowKey: l.id, curPurchaseWeight: o } : (e.manufListObj[l.id].curPurchaseQuantity += l.curPurchaseQuantity, e.manufListObj[l.id].curPurchaseWeight = Yt(e.manufListObj[l.id].curPurchaseWeight + o, 2));
    }
    K.value = false;
  }
  function Qe(s) {
    var a, l;
    e.materialType & d.STEEL.V && s.forEach((o) => {
      e.level === M.CONSTRUCTION_SITE.V && e.projectId && (o.projectId = e.projectId), o.weightMeasurementMode = e.weightMeasurementMode;
    });
    try {
      const o = R[e.currentBasicClass], r = e[o].length;
      e[o].push.apply(e[o], s);
      const f = e[o].length;
      if ((a = T.value) != null && a.rowWatch) for (let c = r; c < f; c++) (l = T.value) == null || l.rowWatch(e[o][c]);
      const p = J(C, () => {
        C.value && (C.value.initSelected(s.map((c) => ({ sn: c.sn, classifyId: c.classifyId }))), x(() => {
          p();
        }));
      }, { immediate: true });
    } catch (o) {
      N.error({ message: o.message, duration: 5e3 });
    }
  }
  const ne = V(), ee = V(false), Q = V({});
  fe(() => {
    var r;
    e.requisitions = Ct(e.requisitionsKV);
    const s = ["steelPlateList", "steelCoilList", "sectionSteelList", "otherSteelMaterialList"], a = ["auxiliaryMaterialList", "otherList", "gasList"], l = e.materialType & d.STEEL.V ? s : a, o = [];
    if (I(l)) for (let f = 0; f < l.length; f++) {
      const p = [];
      (r = e[l[f]]) == null || r.forEach((c) => {
        c.applyPurchaseId ? e.requisitions.findIndex((v) => v.id === c.applyPurchaseId) > -1 && (o.push(c.applyPurchaseId), I(e.requisitionsKV) && I(e.requisitionsKV[c.applyPurchaseId]) && (e.requisitionsKV[c.applyPurchaseId].purchaseCreationState = e.requisitionsKV[c.applyPurchaseId].purchaseCreationState || ae.DURING.V), p.push(c)) : p.push(c);
      }), e[l[f]] = p;
    }
    e.actualRequisitionIds = Lt(o);
  });
  function Je() {
    if (e.level === M.CONSTRUCTION_SITE.V && !e.projectId && N.warning("请先选择项目"), !e.branchCompanyId) {
      N.warning("请先选择签订主体");
      return;
    }
    ee.value = true, x(() => {
      var s;
      return (s = ne.value) == null ? void 0 : s.openInit();
    });
  }
  function Xe(s) {
    var a;
    if (s.basicClass === u.SECTION_STEEL.V) {
      let l;
      const o = [];
      for (const r in s.specKV) r.indexOf("standard") > -1 ? l = s.specKV[r] : o.push(s.specKV[r]);
      s.sectionSteelSpec = l, s.doNotSectionSteelSpec = o.join(" * ");
    }
    s.basicClass & d.STEEL.V && (s.weightMeasurementMode = e.weightMeasurementMode && e.weightMeasurementMode !== D.MIXTURE.V ? e.weightMeasurementMode : D.THEORY.V, s.weighingTotalWeight = s.mete), e.requisitions.findIndex((l) => l.id === s.applyPurchaseId) > -1 && (e.actualRequisitionIds.includes(s.applyPurchaseId) || e.actualRequisitionIds.push(s.applyPurchaseId), I(e.requisitionsKV) && I(e.requisitionsKV[s.applyPurchaseId]) && (e.requisitionsKV[s.applyPurchaseId].purchaseCreationState = ae.DURING.V)), e[R[s.basicClass]].push(s), s.basicClass & e.currentBasicClass && ((a = T.value) == null || a.rowWatch(s));
  }
  function Ye() {
    x(() => {
      var s;
      (s = T.value) == null || s.setFormCallback(e);
    });
  }
  k.HOOK.beforeToEdit = async (s, a) => {
    x(() => {
      var l;
      (l = T.value) == null || l.setFormCallback(a);
    }), Q.value.serialNumber = a.serialNumber, Q.value.supplierId = a.supplierId;
  }, k.HOOK.beforeToCU = (s, a) => {
  }, k.HOOK.afterToCU = () => {
    e.clickTime = (/* @__PURE__ */ new Date()).getTime();
  }, k.HOOK.beforeValidateCU = () => {
    q.value = false;
  };
  async function ue() {
    var r, f;
    let s = true;
    const a = [], l = [], o = [];
    if (e.level === M.CONSTRUCTION_SITE.V && e.projectId && h.edit && e.projectId !== e.originEditProjectId && l.push(e.projectId), (r = e.list) == null || r.map((p) => {
      p.projectId && o.push(p.projectId);
    }), I(o) && (!h.edit || h.edit && !Zt(o, e.originEditProjectIds))) for (let p = 0; p < o.length; p++) {
      const c = o[p];
      (!h.edit || h.edit && !((f = e.originEditProjectIds) != null && f.includes(c))) && l.push(c);
    }
    for (let p = 0; p < l.length; p++) {
      const c = l[p];
      if (Se.value.includes(c) && a.findIndex((v) => v.id === c) < 0) {
        const v = ve.value.find((B) => B.id === c);
        a.push(v);
      }
    }
    if (I(a)) {
      const p = a.map((c) => c.name).join("、");
      await ot.confirm(`您已经为《${p}》创建过采购，是否继续创建，请确认?`, "提示", { distinguishCancelAndClose: true, confirmButtonText: "确认", cancelButtonText: "取消" }).then(() => {
        s = true;
      }).catch((c) => {
        s = false;
      });
    }
    return s;
  }
  k.HOOK.beforeSubmit = async () => {
    var l, o, r, f, p;
    if (h.isPassedEdit && h.edit && (e.dataStatus === he.PASSED.V && (L.api = Rt), e.dataStatus === he.UNDER_APPROVAL.V && (L.api = _t)), e.clickTime = $.state.config.getTreeClickTime, e.boolTemporaryStorage) return T.value && ((l = T.value) == null || l.TSValidateTable(), (o = T.value) == null || o.getData()), await ue();
    if (!((r = T.value) != null && r.validate()) && !e.boolUsed || !((f = P.value) != null && f.validate())) return false;
    const s = await ue(), a = (p = e.list) == null ? void 0 : p.find((c) => {
      var v, B;
      return (B = (v = L == null ? void 0 : L.submitResult) == null ? void 0 : v.data) == null ? void 0 : B.includes(c.classifyId);
    });
    return I(a) ? (N.error("请先删除标红数据并重新添加"), false) : s;
  }, k.HOOK.afterSubmit = async () => {
    Z.value = [], oe.value = [], await $.dispatch("approval_list/fetchTSNum", Te.PURCHASE_ORDER_V2.V), await $.dispatch("approval_list/fetchSubNum", Te.PURCHASE_ORDER_V2.V), await $.dispatch("config/fetchSupplyUsedProject"), Ie("success");
  }, L.submitFormFormat = async (s) => {
    if (s.projectIds = [], s.attachmentIds = s.attachments ? s.attachments.map((a) => a.id) : void 0, s.auxMaterialIds = s.isAllMaterial ? [0] : s.auxMaterialIds, s.otherMaterialIds = s.isAllOtherMaterial ? [0] : s.otherMaterialIds, s.gasMaterialIds = s.isAllGAS ? [0] : s.gasMaterialIds, s.useRequisitions) {
      s.applyPurchaseIds = s.actualRequisitionIds;
      const a = [];
      for (const l in s.requisitionsKV) s.requisitionsKV[l].purchaseCreationState && a.push({ id: s.requisitionsKV[l].id, purchaseCreationState: s.requisitionsKV[l].purchaseCreationState });
      s.applyPurchaseStatus = JSON.stringify(a);
    } else s.applyPurchaseIds = [], s.applyPurchaseStatus = "";
    return s.basicClass = s.currentBasicClass, s.projects = [], s.projectIds = [], s.projectId && s.projectIds.push(s.projectId), s.list.map((a) => {
      s.basicClass = s.basicClass | a.basicClass, s.level === M.CONSTRUCTION_SITE.V && (a.projectId = s.projectId), !s.projects.includes(a.projectId) && a.projectId && s.projects.push(a.projectId), a.projectId && !s.projectIds.includes(a.projectId) && s.projectIds.push(a.projectId);
    }), w.value ? (s.projectId && (s.projectIds = [s.projectId]), s.list = [], T != null && T.value && (T == null ? void 0 : T.value.fetchResList()).forEach((l) => {
      const { curPurchaseQuantity: o, basicClass: r } = s.manufListObj[l.rowKey];
      s.list.push({ artifactEnclosureId: l.id, quantity: o, basicClass: r, pricingMethod: l.pricingMethod, unitPrice: l.unitPrice, amount: l.amount, destination: l.destination });
    })) : s.list = await At(s.list, { toSmallest: true, toNum: true }), s;
  };
  async function Ze() {
    var a;
    if (!((a = T.value) != null && a.validate()) && !e.boolUsed || !await P.value.validate()) return false;
    X.value = true;
  }
  async function de(s) {
    try {
      e.boolTemporaryStorage = !!s, await L.submit();
    } catch (a) {
      console.log("采购合同提交", a);
    }
  }
  return Ve({ setFormCallback: Ye }), (s, a) => {
    const l = F("common-button"), o = F("common-radio"), r = nt, f = ut, p = F("common-select"), c = dt, v = F("common-radio-button"), B = pt, et = ct, tt = mt, te = F("common-drawer");
    return b(), S("div", null, [y("div", oa, [y("div", null, [lt(s.$slots, "chose", {}, void 0, true)]), y("div", na, [n(l, { size: "default", type: "primary", onClick: Ze }, { default: m(() => a[35] || (a[35] = [O(" 下一步 ")])), _: 1, __: [35] }), !U.isPassedEdit || U.isPassedEdit && !h.edit ? (b(), E(l, { key: 0, size: "default", type: "warning", onClick: a[0] || (a[0] = (i) => de(t(Ut).YES.V)) }, { default: m(() => a[36] || (a[36] = [O(" 暂 存 ")])), _: 1, __: [36] })) : g("", true)])]), y("div", ua, [n(tt, { ref_key: "detailFormRef", ref: P, model: t(e), rules: je.value, "label-position": "right", "label-width": "110px", size: "small" }, { default: m(() => [y("div", da, [y("div", { style: be(q.value ? "width:0px;padding:0;" : `height: ${U.maxHeight - 130}px`), class: "form-left" }, [y("div", pa, [n(r, { class: "el-form-item-18", label: "采购目的", prop: "level" }, { default: m(() => [n(o, { modelValue: t(e).level, "onUpdate:modelValue": a[1] || (a[1] = (i) => t(e).level = i), disabled: Y.value || !!t(e).boolUsed, options: t(M).ENUM, size: "small", type: "enumSL", onChange: ze }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), n(r, { label: "合同类型", prop: "boolAnnual", required: "" }, { default: m(() => [n(o, { modelValue: t(e).boolAnnual, "onUpdate:modelValue": a[2] || (a[2] = (i) => t(e).boolAnnual = i), disabled: t(e).id && !!t(e).boolUsed, options: t(xt).ENUM, type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), n(r, { label: "是否绑定申购", prop: "useRequisitions", required: "" }, { default: m(() => [n(o, { modelValue: t(e).useRequisitions, "onUpdate:modelValue": a[3] || (a[3] = (i) => t(e).useRequisitions = i), disabled: !!t(e).boolUsed, options: t(Ot).ENUM, type: "enum", onChange: G }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), n(r, { class: "el-form-item-1", label: "采购合同编号", prop: "serialNumber" }, { default: m(() => [n(f, { modelValue: t(e).serialNumber, "onUpdate:modelValue": a[4] || (a[4] = (i) => t(e).serialNumber = i), modelModifiers: { trim: true }, disabled: t(e).id && !!t(e).boolUsed, class: "input-underline", maxlength: "30", placeholder: "可输入采购合同编号（不填写则自动生成）", size: "small" }, null, 8, ["modelValue", "disabled"])]), _: 1 }), n(r, { class: "el-form-item-3", label: "材料类型", prop: "materialTypeTotal" }, { default: m(() => [n(p, { modelValue: t(e).materialTypeTotal, "onUpdate:modelValue": a[5] || (a[5] = (i) => t(e).materialTypeTotal = i), disabled: !!t(e).boolUsed, disabledVal: t(I)(t(e).materialTypeTotal) ? t(e).materialTypeTotal.includes(t(d).STEEL.V) ? [t(d).MATERIAL.V, t(d).OTHER.V, t(d).GAS.V] : [t(d).STEEL.V] : [], options: t(d).ENUM, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择材料类型", style: { width: "100%" }, type: "enum" }, null, 8, ["modelValue", "disabled", "disabledVal", "options"])]), _: 1 }), t(e).materialType & t(d).MATERIAL.V && !t(e).useRequisitions ? (b(), E(r, { key: 0, class: "el-form-item-5", label: "辅材明细", prop: "auxMaterialIds" }, { default: m(() => [y("div", ca, [n(c, { modelValue: t(e).isAllMaterial, "onUpdate:modelValue": a[6] || (a[6] = (i) => t(e).isAllMaterial = i), disabled: !!t(e).boolUsed, border: "", label: "所有辅材", size: "default", style: { "margin-top": "3px", "margin-right": "5px" }, onChange: a[7] || (a[7] = (i) => t(e).auxMaterialIds = []) }, null, 8, ["modelValue", "disabled"]), n(se, { modelValue: t(e).auxMaterialIds, "onUpdate:modelValue": a[8] || (a[8] = (i) => t(e).auxMaterialIds = i), "basic-class": t(u).MATERIAL.V, "collapse-tags": false, deep: 2, disabled: t(e).boolUsed ? !!t(e).boolUsed : t(e).isAllMaterial, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择辅材", separator: " > ", size: "small", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : g("", true), t(e).materialType & t(d).OTHER.V && !t(e).useRequisitions ? (b(), E(r, { key: 1, class: "el-form-item-5", label: "办公用品明细", prop: "otherMaterialIds" }, { default: m(() => [y("div", ma, [n(c, { modelValue: t(e).isAllOtherMaterial, "onUpdate:modelValue": a[9] || (a[9] = (i) => t(e).isAllOtherMaterial = i), disabled: t(e).boolUsed, border: "", label: "所有办公用品科目", size: "default", style: { "margin-top": "3px", "margin-right": "5px" }, onChange: a[10] || (a[10] = (i) => t(e).otherMaterialIds = []) }, null, 8, ["modelValue", "disabled"]), n(se, { modelValue: t(e).otherMaterialIds, "onUpdate:modelValue": a[11] || (a[11] = (i) => t(e).otherMaterialIds = i), "basic-class": t(u).OTHER.V, "collapse-tags": false, deep: 2, disabled: t(e).boolUsed ? !!t(e).boolUsed : t(e).isAllOtherMaterial, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择办公用品科目", separator: " > ", size: "small", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : g("", true), t(e).materialType & t(d).GAS.V && !t(e).useRequisitions ? (b(), E(r, { key: 2, class: "el-form-item-5", label: "气体明细", prop: "gasMaterialIds" }, { default: m(() => [y("div", fa, [n(c, { modelValue: t(e).isAllGAS, "onUpdate:modelValue": a[12] || (a[12] = (i) => t(e).isAllGAS = i), disabled: t(e).boolUsed, border: "", label: "所有气体科目", size: "default", style: { "margin-top": "3px", "margin-right": "5px" }, onChange: a[13] || (a[13] = (i) => t(e).gasMaterialIds = []) }, null, 8, ["modelValue", "disabled"]), n(se, { modelValue: t(e).gasMaterialIds, "onUpdate:modelValue": a[14] || (a[14] = (i) => t(e).gasMaterialIds = i), "basic-class": t(u).GAS.V, "collapse-tags": false, deep: 2, disabled: t(e).boolUsed ? !!t(e).boolUsed : t(e).isAllGAS, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择气体科目", separator: " > ", size: "small", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : g("", true), n(r, { class: "el-form-item-7", label: "供应商", prop: "supplierId" }, { default: m(() => [n(jt, { ref_key: "supplierRef", ref: Ce, modelValue: t(e).supplierId, "onUpdate:modelValue": a[15] || (a[15] = (i) => t(e).supplierId = i), "basic-class": t(e).materialType, disableOptions: Z.value, disabled: t(e).id && !!t(e).boolUsed, isAnnual: t(e).boolAnnual, type: t(e).purchaseType, class: "input-underline", clearable: "", filterable: "", mode: "cross", onChange: Fe, onInfoChange: De }, null, 8, ["modelValue", "basic-class", "disableOptions", "disabled", "isAnnual", "type"])]), _: 1 }), n(r, { class: "el-form-item-18", label: "签订主体", prop: "branchCompanyId" }, { default: m(() => [n(qt, { modelValue: t(e).branchCompanyId, "onUpdate:modelValue": a[16] || (a[16] = (i) => t(e).branchCompanyId = i), defaultLevel: t(e).level, disabled: !!t(e).boolUsed || !t(e).level || Y.value, class: "input-underline", placeholder: "合同签订主体", style: { width: "100%" }, onChange: He, onCurrentChange: we }, null, 8, ["modelValue", "defaultLevel", "disabled"])]), _: 1 }), t(e).level === t(M).CONSTRUCTION_SITE.V ? (b(), E(r, { key: 3, class: "el-form-item-4", label: "选择项目", prop: "projectId" }, { default: m(() => [n(t(Pt), { modelValue: t(e).projectId, "onUpdate:modelValue": a[17] || (a[17] = (i) => t(e).projectId = i), branchCompanyId: t(e).branchCompanyId, defaultOptions: Y.value ? t(e).project : [], disabled: !!t(e).boolUsed && !t(e).branchCompanyId, projectAttribute: t(e).projectAttribute, class: "input-underline", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: Ke }, null, 8, ["modelValue", "branchCompanyId", "defaultOptions", "disabled", "projectAttribute"])]), _: 1 })) : g("", true), n(r, { class: "el-form-item-10", label: "发票及税率", prop: "invoiceType" }, { default: m(() => [n(kt, { invoiceType: t(e).invoiceType, "onUpdate:invoiceType": a[18] || (a[18] = (i) => t(e).invoiceType = i), taxRate: t(e).taxRate, "onUpdate:taxRate": a[19] || (a[19] = (i) => t(e).taxRate = i), classification: t(e).materialType, disabled: !!t(e).boolUsed, class: "input-underline" }, null, 8, ["invoiceType", "taxRate", "classification", "disabled"])]), _: 1 }), t(e).materialType & t(d).STEEL.V ? (b(), E(r, { key: 4, class: "el-form-item-13", label: "订单类型", prop: "purchaseOrderPaymentMode" }, { default: m(() => [n(o, { modelValue: t(e).purchaseOrderPaymentMode, "onUpdate:modelValue": a[20] || (a[20] = (i) => t(e).purchaseOrderPaymentMode = i), disabled: !!t(e).boolUsed, options: t(Bt).ENUM, size: "small", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })) : g("", true), t(e).materialType & t(d).STEEL.V ? (b(), E(r, { key: 5, class: "el-form-item-11", label: "计量方式", prop: "weightMeasurementMode" }, { default: m(() => [n(o, { modelValue: t(e).weightMeasurementMode, "onUpdate:modelValue": a[21] || (a[21] = (i) => t(e).weightMeasurementMode = i), disabled: !!t(e).boolUsed, options: t(D).ENUM, props: { key: "K", label: "SL", value: "V" }, size: "small", type: "enum", onChange: Ne }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })) : g("", true), n(r, { class: "el-form-item-16", label: "物流运输方式", prop: "logisticsTransportType" }, { default: m(() => [n(o, { modelValue: t(e).logisticsTransportType, "onUpdate:modelValue": a[22] || (a[22] = (i) => t(e).logisticsTransportType = i), disabled: !!t(e).boolUsed, options: t(Nt).ENUM, size: "small", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), n(r, { class: "el-form-item-17", label: "物流费用承担", prop: "logisticsPayerType" }, { default: m(() => [n(o, { modelValue: t(e).logisticsPayerType, "onUpdate:modelValue": a[23] || (a[23] = (i) => t(e).logisticsPayerType = i), disabled: !!t(e).boolUsed, options: t(wt).ENUM, size: "small", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), n(r, { class: "el-form-item-14", "label-width": "0", prop: "remark" }, { default: m(() => [n(f, { modelValue: t(e).remark, "onUpdate:modelValue": a[24] || (a[24] = (i) => t(e).remark = i), disabled: !!t(e).boolUsed, rows: 3, maxlength: "1000", placeholder: "备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue", "disabled"])]), _: 1 }), n(Ht, { files: t(e).attachments, "onUpdate:files": a[25] || (a[25] = (i) => t(e).attachments = i), "file-classify": t(Kt).PURCHASE_ORDER_ATT.V, showView: true, class: "el-form-item-15", "empty-text": "暂未上传采购合同附件", "show-download": "" }, null, 8, ["files", "file-classify"])])], 4), y("div", { style: be(q.value ? "display:none;" : ""), class: "vertical-dashed-divider" }, null, 4), y("div", ba, [t(I)(t(e).materialTypeTotal) ? (b(), S("div", ya, [n(zt, { "is-active": q.value, class: "hamburger-container", onToggleClick: a[26] || (a[26] = (i) => q.value = !q.value) }, null, 8, ["is-active"]), t(e).useRequisitions ? (b(), S("div", ga, [y("span", ha, [a[37] || (a[37] = y("span", { class: "label" }, "关联申购单号", -1)), t(e).boolUsed ? g("", true) : (b(), E(v, { key: 0, modelValue: t(e).currentBasicClass, "onUpdate:modelValue": a[27] || (a[27] = (i) => t(e).currentBasicClass = i), "data-structure": { key: "V", label: "L", value: "V" }, options: H.value, clearable: "", style: { "vertical-align": "middle", "margin-right": "6px" }, type: "other" }, { suffix: m(({ item: i }) => {
      var _, A;
      return [(_ = t(e)[R[i.V]]) != null && _.length ? (b(), S("span", Ta, "(" + j((A = t(e)[R[i.V]]) == null ? void 0 : A.length) + ")", 1)) : g("", true)];
    }), _: 1 }, 8, ["modelValue", "options"])), (b(true), S(ye, null, it(t(e).actualRequisitionIds, (i) => (b(), S("span", { key: i }, [n(B, { class: "preparation-sn-tag", effect: "plain", size: "large" }, { default: m(() => {
      var _, A, pe;
      return [O(j((A = (_ = t(e).requisitionsKV) == null ? void 0 : _[i]) == null ? void 0 : A.serialNumber) + " ", 1), (pe = t(e).requisitionsKV) != null && pe[i] ? (b(), E(p, { key: 0, modelValue: t(e).requisitionsKV[i].purchaseCreationState, "onUpdate:modelValue": (at) => t(e).requisitionsKV[i].purchaseCreationState = at, disabled: !!t(e).boolUsed, options: t(ae).ENUM, class: "input-border-none", placeholder: "请选择采购状态", size: "default", style: { width: "130px" }, type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "options"])) : g("", true)];
    }), _: 2 }, 1024)]))), 128))]), t(e).boolUsed ? g("", true) : (b(), S("span", Va, [n(l, { size: "default", type: "success", onClick: Je }, { default: m(() => a[38] || (a[38] = [O(" 选择申购物料 ")])), _: 1, __: [38] })]))])) : g("", true), y("div", Ea, [y("span", Ia, [t(e).useRequisitions ? g("", true) : (b(), S("span", Sa, "采购清单")), !t(e).boolUsed && !t(e).useRequisitions ? (b(), E(v, { key: 1, modelValue: t(e).currentBasicClass, "onUpdate:modelValue": a[28] || (a[28] = (i) => t(e).currentBasicClass = i), "data-structure": { key: "V", label: "L", value: "V" }, options: H.value, clearable: "", style: { "vertical-align": "middle" }, type: "other" }, { suffix: m(({ item: i }) => {
      var _, A;
      return [(_ = t(e)[R[i.V]]) != null && _.length ? (b(), S("span", va, "(" + j((A = t(e)[R[i.V]]) == null ? void 0 : A.length) + ")", 1)) : g("", true)];
    }), _: 1 }, 8, ["modelValue", "options"])) : g("", true)]), t(e).boolUsed ? g("", true) : (b(), S("span", Ma, [!w.value && !t(e).boolUsed ? (b(), E(l, { key: 0, disabled: !t(e).projectAttribute || t(e).level === t(M).CONSTRUCTION_SITE.V && !t(e).projectId, class: "filter-item", size: "default", type: "success", onClick: Ge }, { default: m(() => a[39] || (a[39] = [O(" 添加物料 ")])), _: 1, __: [39] }, 8, ["disabled"])) : g("", true), w.value ? g("", true) : (b(), E(Ft, { key: 1, template: Pe.value, "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload2", "open-loading": "", style: { "margin-left": "10px" }, onSuccess: Qe }, null, 8, ["template"])), w.value ? g("", true) : (b(), E(Dt, { key: 2, fn: t($t), params: { basicClass: t(e).currentBasicClass, receiptType: t(Gt).PURCHASE.V }, class: "filter-item", style: { "margin-left": "10px" }, type: "info" }, { default: m(() => [O(j(t(u).VL[t(e).currentBasicClass]) + "清单模板下载 ", 1)]), _: 1 }, 8, ["fn", "params"])), n(et, { disabled: !!t(e).projectId, content: "请先选择项目", effect: "light", placement: "left-start" }, { default: m(() => [y("span", null, [w.value ? (b(), E(l, { key: 0, disabled: !t(e).projectId, class: "filter-item", icon: "el-icon-plus", size: "default", type: "success", onClick: a[29] || (a[29] = (i) => K.value = true) }, { default: m(() => a[40] || (a[40] = [O(" 添加制成品 ")])), _: 1, __: [40] }, 8, ["disabled"])) : g("", true)])]), _: 1 }, 8, ["disabled"])]))]), t(e).boolUsed ? (b(), E(ta, { key: 2, "bool-use-requisitions": t(e).useRequisitions, level: t(e).level, list: t(e).details, "material-type": t(e).materialType, "max-height": U.maxHeight - 150 }, null, 8, ["bool-use-requisitions", "level", "list", "material-type", "max-height"])) : (b(), E(rt(qe.value), { key: 1, ref_key: "compRef", ref: T, maxHeight: U.maxHeight - 260 }, null, 8, ["maxHeight"])), y("div", Ca, [t(e).materialType & (t(d).MATERIAL.V | t(d).OTHER.V | t(d).GAS.V) ? g("", true) : (b(), S(ye, { key: 0 }, [a[41] || (a[41] = y("span", { class: "title" }, "合同量", -1)), y("span", La, [y("span", null, j(t(e).mete), 1), y("span", null, j(t(e).meteUnit), 1)])], 64)), a[42] || (a[42] = y("span", { class: "title" }, "合同额", -1)), y("span", Ra, j(t(e).amount) + " 元", 1)])])) : (b(), S("div", _a, "*请先选择材料类型"))])])]), _: 1 }, 8, ["model", "rules"])]), n(te, { modelValue: ee.value, "onUpdate:modelValue": a[30] || (a[30] = (i) => ee.value = i), "custom-class": "material-requisition-select", direction: "btt", size: "70%", title: "申购选择" }, { titleRight: m(() => a[43] || (a[43] = [])), content: m(() => [n(aa, { ref_key: "requisitionListRef", ref: ne, projectId: t(e).level === t(M).CONSTRUCTION_SITE.V ? t(e).projectId : void 0, onAddPurchase: Xe }, null, 8, ["projectId"])]), _: 1 }, 8, ["modelValue"]), n(te, { ref_key: "materialSpecSelectDrawer", ref: ie, modelValue: W.value, "onUpdate:modelValue": a[32] || (a[32] = (i) => W.value = i), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: m(() => [n(Wt, { ref_key: "matSpecRef", ref: C, modelValue: t(e)[R[t(e).currentBasicClass]], "onUpdate:modelValue": a[31] || (a[31] = (i) => t(e)[R[t(e).currentBasicClass]] = i), "basic-class": t(e).currentBasicClass, "classify-ids": t(e).materialType & t(d).MATERIAL.V ? t(e).auxMaterialIds : t(e).materialType & t(d).OTHER.V ? t(e).otherMaterialIds : [], "max-height": t(ke), "row-init-fn": $e, "table-width": 350, visible: W.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "classify-ids", "max-height", "visible"])]), _: 1 }, 8, ["modelValue"]), n(te, { ref_key: "manufSelectDrawerRef", ref: re, modelValue: K.value, "onUpdate:modelValue": a[33] || (a[33] = (i) => K.value = i), "custom-class": "manufactured-select-drawer", "show-close": "", size: "80%", title: "制成品选择" }, { content: m(() => [n(sa, { maxHeight: t(Be), "project-id": t(e).projectId, visible: K.value, onAdd: We }, null, 8, ["maxHeight", "project-id", "visible"])]), _: 1 }, 8, ["modelValue"]), n(la, { modelValue: X.value, "onUpdate:modelValue": a[34] || (a[34] = (i) => X.value = i), edit: h.edit, "is-passed-edit": U.isPassedEdit, onSubmit: de }, null, 8, ["modelValue", "edit", "is-passed-edit"])]);
  };
} }, ls = ft(Aa, [["__scopeId", "data-v-2aa216eb"]]);
export {
  ls as default
};
